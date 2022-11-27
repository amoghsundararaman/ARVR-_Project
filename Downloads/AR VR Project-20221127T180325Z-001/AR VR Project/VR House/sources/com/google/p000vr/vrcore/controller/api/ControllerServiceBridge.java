package com.google.p000vr.vrcore.controller.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.p000vr.cardboard.annotations.UsedByNative;
import com.google.p000vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.p000vr.vrcore.base.api.VrCoreUtils;
import com.google.p000vr.vrcore.controller.api.IControllerListener;
import com.google.p000vr.vrcore.controller.api.IControllerService;
import com.google.p000vr.vrcore.controller.api.IControllerServiceListener;
import com.google.p000vr.vrcore.controller.api.nano.Proto;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

@UsedByNative
/* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge */
public class ControllerServiceBridge implements ServiceConnection {
    private static final boolean DEBUG = false;
    public static final int FLAG_SUPPORTS_RECENTER = 1;
    static final int MIN_API_VERSION_FOR_SERVICE_CALLBACKS = 21;
    static final String TAG = "VrCtl.ServiceBridge";
    public static final int TARGET_SERVICE_API_VERSION = 23;
    private static final AtomicInteger UNIQUE_INT = new AtomicInteger(-1);
    private final Context context;
    private final SparseArray<LocalControllerListener> controllerListenerMap;
    private LocalControllerListener defaultListener;
    private final ControllerServiceListener defaultServiceListener;
    private boolean isBound;
    final String listenerKey;
    private final Handler mainThreadHandler;
    private IControllerService service;
    private final int vrcoreApiVersion;

    @UsedByNative
    /* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge$Callbacks */
    public interface Callbacks {
        void onControllerEventPacket(ControllerEventPacket controllerEventPacket);

        void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2);

        void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent);

        void onControllerStateChanged(int i, int i2);

        void onServiceConnected(int i);

        void onServiceDisconnected();

        void onServiceFailed();

        void onServiceInitFailed(int i);

        void onServiceUnavailable();
    }

    /* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge$LocalControllerListener */
    private static class LocalControllerListener {
        public final Callbacks callbacks;
        public final int controllerIndex;
        public final ControllerListenerOptions options;

        public LocalControllerListener(Callbacks callbacks2, ControllerListenerOptions controllerListenerOptions, int i) {
            this.callbacks = callbacks2;
            this.options = controllerListenerOptions;
            this.controllerIndex = i;
        }
    }

    @UsedByNative
    public ControllerServiceBridge(Context context2, Callbacks callbacks, int i) {
        this(context2, callbacks, new ControllerListenerOptions(i));
    }

    /* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge$ControllerListener */
    private static class ControllerListener extends IControllerListener.Stub {
        private final WeakReference<LocalControllerListener> listener;

        public ControllerListener(LocalControllerListener localControllerListener) {
            this.listener = new WeakReference<>(localControllerListener);
        }

        public int getApiVersion() throws RemoteException {
            return 23;
        }

        public ControllerListenerOptions getOptions() throws RemoteException {
            LocalControllerListener localControllerListener = (LocalControllerListener) this.listener.get();
            if (localControllerListener == null) {
                return null;
            }
            return localControllerListener.options;
        }

        public void onControllerStateChanged(int i, int i2) throws RemoteException {
            LocalControllerListener localControllerListener = (LocalControllerListener) this.listener.get();
            if (localControllerListener != null) {
                localControllerListener.callbacks.onControllerStateChanged(i, i2);
            }
        }

        public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) throws RemoteException {
            LocalControllerListener localControllerListener = (LocalControllerListener) this.listener.get();
            if (localControllerListener != null) {
                controllerEventPacket.setEventsControllerIndex(localControllerListener.controllerIndex);
                localControllerListener.callbacks.onControllerEventPacket(controllerEventPacket);
                controllerEventPacket.recycle();
            }
        }

        public void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) throws RemoteException {
            LocalControllerListener localControllerListener = (LocalControllerListener) this.listener.get();
            if (localControllerListener != null) {
                ControllerServiceBridge.logIfControllerPacketLags(controllerEventPacket2);
                controllerEventPacket2.setEventsControllerIndex(localControllerListener.controllerIndex);
                localControllerListener.callbacks.onControllerEventPacket2(controllerEventPacket2);
                controllerEventPacket2.recycle();
            }
        }

        public void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) {
            LocalControllerListener localControllerListener = (LocalControllerListener) this.listener.get();
            if (localControllerListener != null) {
                controllerOrientationEvent.controllerId = localControllerListener.controllerIndex;
                localControllerListener.callbacks.onControllerRecentered(controllerOrientationEvent);
            }
        }
    }

    /* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge$ControllerServiceListener */
    private static class ControllerServiceListener extends IControllerServiceListener.Stub {
        private final WeakReference<ControllerServiceBridge> serviceBridge;

        public ControllerServiceListener(ControllerServiceBridge controllerServiceBridge) {
            this.serviceBridge = new WeakReference<>(controllerServiceBridge);
        }

        public int getApiVersion() throws RemoteException {
            return 23;
        }

        public void onControllerServiceEvent(int i) throws RemoteException {
            ControllerServiceBridge controllerServiceBridge = (ControllerServiceBridge) this.serviceBridge.get();
            if (controllerServiceBridge != null) {
                controllerServiceBridge.handleServiceEvent(i);
            }
        }
    }

    public ControllerServiceBridge(Context context2, Callbacks callbacks) {
        this(context2, callbacks, (ControllerListenerOptions) null);
    }

    private ControllerServiceBridge(Context context2, Callbacks callbacks, ControllerListenerOptions controllerListenerOptions) {
        this.controllerListenerMap = new SparseArray<>();
        this.context = context2.getApplicationContext();
        initializeDefaultListener(callbacks, controllerListenerOptions);
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.defaultServiceListener = new ControllerServiceListener(this);
        this.vrcoreApiVersion = getVrCoreApiVersion(context2);
        this.listenerKey = createListenerKey();
    }

    @UsedByNative
    public void requestBind() {
        this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$0(this));
    }

    @UsedByNative
    public void requestUnbind() {
        this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$1(this));
    }

    public void doBind() {
        ensureOnMainThread();
        if (this.isBound) {
            Log.w(TAG, "Service is already bound.");
            return;
        }
        Intent intent = new Intent(ControllerServiceConsts.BIND_INTENT_ACTION);
        intent.setPackage("com.google.vr.vrcore");
        if (!this.context.bindService(intent, this, 1)) {
            Log.w(TAG, "Bind failed. Service is not available.");
            this.defaultListener.callbacks.onServiceUnavailable();
        }
        this.isBound = true;
    }

    public void doUnbind() {
        ensureOnMainThread();
        if (!this.isBound) {
            Log.w(TAG, "Service is already unbound.");
            return;
        }
        unregisterListeners();
        if (this.vrcoreApiVersion >= MIN_API_VERSION_FOR_SERVICE_CALLBACKS) {
            try {
                if (this.service != null && !this.service.unregisterServiceListener(this.defaultServiceListener)) {
                    Log.w(TAG, "Failed to unregister remote service listener.");
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w(TAG, new StringBuilder(String.valueOf(valueOf).length() + 55).append("Exception while unregistering remote service listener: ").append(valueOf).toString());
            }
        }
        this.context.unbindService(this);
        this.service = null;
        this.isBound = false;
    }

    public Callbacks getControllerCallbacks(int i) {
        ensureOnMainThread();
        LocalControllerListener localControllerListener = this.controllerListenerMap.get(i);
        if (localControllerListener == null) {
            return null;
        }
        return localControllerListener.callbacks;
    }

    public void clearControllers() {
        ensureOnMainThread();
        this.controllerListenerMap.clear();
    }

    @UsedByNative
    public boolean createAndConnectController(int i, Callbacks callbacks, int i2) throws RemoteException {
        return createAndConnectControllerInternal(i, callbacks, new ControllerListenerOptions(i2));
    }

    public boolean createAndConnectController(int i, Callbacks callbacks) throws RemoteException {
        return createAndConnectControllerInternal(i, callbacks, new ControllerListenerOptions());
    }

    public void unregisterListeners() {
        ensureOnMainThread();
        if (this.service != null) {
            try {
                this.service.unregisterListener(this.listenerKey);
            } catch (RemoteException e) {
                Log.w(TAG, "RemoteException while unregistering listeners.", e);
            }
        }
    }

    @UsedByNative
    public void vibrateController(int i, int i2, int i3, int i4) {
        Proto.Request request = new Proto.Request();
        request.vibration = new Proto.Request.Vibration().setFrequencyHz(i2).setVolumePercentage(i3).setDurationMs(i4);
        ControllerRequest controllerRequest = new ControllerRequest();
        controllerRequest.setFromProto(request);
        this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$2(this, i, controllerRequest));
    }

    /* access modifiers changed from: private */
    /* renamed from: vibrateControllerInternal */
    public void lambda$vibrateController$0$ControllerServiceBridge(int i, ControllerRequest controllerRequest) {
        ensureOnMainThread();
        if (this.service == null) {
            Log.w(TAG, "Vibration cancelled: service not connected");
            return;
        }
        try {
            this.service.request(i, controllerRequest);
        } catch (RemoteException e) {
            Log.w(TAG, "RemoteException while vibrating the controller.", e);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ensureOnMainThread();
        if (!this.isBound) {
            Log.d(TAG, "Ignoring service connection after unbind.");
            return;
        }
        this.service = IControllerService.Stub.asInterface(iBinder);
        try {
            int initialize = this.service.initialize(23);
            if (initialize != 0) {
                String valueOf = String.valueOf(ControllerInitResults.toString(initialize));
                Log.e(TAG, valueOf.length() != 0 ? "initialize() returned error: ".concat(valueOf) : new String("initialize() returned error: "));
                this.defaultListener.callbacks.onServiceInitFailed(initialize);
                doUnbind();
                return;
            }
            if (this.vrcoreApiVersion >= MIN_API_VERSION_FOR_SERVICE_CALLBACKS) {
                try {
                    if (!this.service.registerServiceListener(this.defaultServiceListener)) {
                        Log.e(TAG, "Failed to register remote service listener.");
                        this.defaultListener.callbacks.onServiceInitFailed(initialize);
                        doUnbind();
                        return;
                    }
                } catch (RemoteException e) {
                    String valueOf2 = String.valueOf(e);
                    Log.w(TAG, new StringBuilder(String.valueOf(valueOf2).length() + 53).append("Exception while registering remote service listener: ").append(valueOf2).toString());
                }
            }
            setupAndBindDefaultControllerListener();
        } catch (RemoteException e2) {
            Log.e(TAG, "Failed to call initialize() on controller service (RemoteException).", e2);
            this.defaultListener.callbacks.onServiceFailed();
            doUnbind();
        }
    }

    private void setupAndBindDefaultControllerListener() {
        this.defaultListener.callbacks.onServiceConnected(1);
        if (!registerListener(this.defaultListener.controllerIndex, this.defaultListener)) {
            Log.w(TAG, "Failed to register service listener.");
            this.defaultListener.callbacks.onServiceFailed();
            doUnbind();
            return;
        }
        this.controllerListenerMap.put(this.defaultListener.controllerIndex, this.defaultListener);
        Log.i(TAG, "Successfully registered service listener.");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ensureOnMainThread();
        this.service = null;
        this.defaultListener.callbacks.onServiceDisconnected();
    }

    private void ensureOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("This should be running on the main thread.");
        }
    }

    /* access modifiers changed from: private */
    public void handleServiceEvent(int i) {
        if (i == 1) {
            this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleAvailableControllersChanged */
    public void bridge$lambda$0$ControllerServiceBridge() {
        ensureOnMainThread();
        if (getNumOfControllers() <= 0) {
            int size = this.controllerListenerMap.size();
            for (int i = 0; i < size; i++) {
                LocalControllerListener valueAt = this.controllerListenerMap.valueAt(i);
                if (valueAt != null) {
                    valueAt.callbacks.onControllerStateChanged(i, 0);
                }
            }
            clearControllers();
            this.defaultListener.callbacks.onServiceDisconnected();
        } else if (this.isBound) {
            setupAndBindDefaultControllerListener();
        }
    }

    public int getNumOfControllers() {
        if (this.service == null) {
            return 0;
        }
        try {
            return this.service.getNumberOfControllers();
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            Log.w(TAG, new StringBuilder(String.valueOf(valueOf).length() + 54).append("Remote exception while getting number of controllers: ").append(valueOf).toString());
            return 0;
        }
    }

    private static int getVrCoreApiVersion(Context context2) {
        try {
            return VrCoreUtils.getVrCoreClientApiVersion(context2);
        } catch (VrCoreNotAvailableException e) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static void logIfControllerPacketLags(ControllerEventPacket2 controllerEventPacket2) {
        if (controllerEventPacket2.getTimestampMillis() != 0) {
            long systemTimeMillis = ControllerEventPacket2.getSystemTimeMillis() - controllerEventPacket2.getTimestampMillis();
            if (systemTimeMillis > 300) {
                Log.w(TAG, new StringBuilder(122).append("Experiencing large controller packet delivery time between service and  client: timestamp diff in ms: ").append(systemTimeMillis).toString());
            }
        }
    }

    private void initializeDefaultListener(Callbacks callbacks, ControllerListenerOptions controllerListenerOptions) {
        this.defaultListener = new LocalControllerListener(callbacks, controllerListenerOptions, 0);
        this.controllerListenerMap.put(this.defaultListener.controllerIndex, this.defaultListener);
    }

    private boolean createAndConnectControllerInternal(int i, Callbacks callbacks, ControllerListenerOptions controllerListenerOptions) throws RemoteException {
        ensureOnMainThread();
        if (this.service == null) {
            return false;
        }
        LocalControllerListener localControllerListener = new LocalControllerListener(callbacks, controllerListenerOptions, i);
        if (registerListener(localControllerListener.controllerIndex, localControllerListener)) {
            if (localControllerListener.controllerIndex == 0) {
                this.defaultListener = localControllerListener;
            }
            this.controllerListenerMap.put(i, localControllerListener);
            return true;
        }
        if (i == 0) {
            Log.e(TAG, new StringBuilder(41).append("Failed to connect controller ").append(i).append(".").toString());
        }
        this.controllerListenerMap.remove(i);
        return false;
    }

    private boolean registerListener(int i, LocalControllerListener localControllerListener) {
        try {
            if (this.service.registerListener(i, this.listenerKey, new ControllerListener(localControllerListener))) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.w(TAG, "RemoteException while registering listener.", e);
        }
    }

    private static String createListenerKey() {
        return new StringBuilder(30).append(TAG).append(UNIQUE_INT.incrementAndGet()).toString();
    }
}
