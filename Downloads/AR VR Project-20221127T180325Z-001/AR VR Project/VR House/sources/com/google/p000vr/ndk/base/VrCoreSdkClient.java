package com.google.p000vr.ndk.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.p000vr.cardboard.C0021R;
import com.google.p000vr.cardboard.ContextUtils;
import com.google.p000vr.cardboard.ThreadUtils;
import com.google.p000vr.cardboard.UiUtils;
import com.google.p000vr.cardboard.VrContextWrapper;
import com.google.p000vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.p000vr.vrcore.base.api.VrCoreUtils;
import com.google.p000vr.vrcore.common.api.HeadTrackingState;
import com.google.p000vr.vrcore.common.api.IDaydreamListener;
import com.google.p000vr.vrcore.common.api.IDaydreamManager;
import com.google.p000vr.vrcore.common.api.IVrCoreSdkService;
import com.google.p000vr.vrcore.common.api.SdkServiceConsts;
import com.google.p000vr.vrcore.logging.api.IVrCoreLoggingService;
import java.lang.ref.WeakReference;

/* renamed from: com.google.vr.ndk.base.VrCoreSdkClient */
class VrCoreSdkClient {
    private static final boolean DEBUG = false;
    static final int MIN_ON_EXITING_FROM_VR_API_VERSION = 16;
    static final int MIN_PREPARE_VR_2_API_VERSION = 13;
    static final int MIN_PREPARE_VR_3_API_VERSION = 22;
    static final int MIN_VRCORE_API_VERSION = 5;
    private static final String TAG = "VrCoreSdkClient";
    static final int TARGET_VR_CORE_API_VERSION = 23;
    private final Runnable closeVrRunnable;
    /* access modifiers changed from: private */
    public final ComponentName componentName;
    private final Context context;
    /* access modifiers changed from: private */
    public final DaydreamListenerImpl daydreamListener;
    /* access modifiers changed from: private */
    public IDaydreamManager daydreamManager;
    private final DaydreamUtilsWrapper daydreamUtils;
    private final FadeOverlayView fadeOverlayView;
    private final GvrApi gvrApi;
    private AlertDialog helpCenterDialog;
    private boolean isBound;
    private boolean isEnabled = true;
    /* access modifiers changed from: private */
    public boolean isResumed;
    /* access modifiers changed from: private */
    public IVrCoreLoggingService loggingService;
    /* access modifiers changed from: private */
    public Runnable onDonNotNeededListener;
    private PendingIntent optionalReentryIntent;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IVrCoreSdkService asInterface = IVrCoreSdkService.Stub.asInterface(iBinder);
            try {
                if (!asInterface.initialize(23)) {
                    Log.e(VrCoreSdkClient.TAG, "Failed to initialize VrCore SDK Service.");
                    VrCoreSdkClient.this.handleBindFailed();
                    return;
                }
                IVrCoreSdkService unused = VrCoreSdkClient.this.vrCoreSdkService = asInterface;
                try {
                    IDaydreamManager unused2 = VrCoreSdkClient.this.daydreamManager = VrCoreSdkClient.this.vrCoreSdkService.getDaydreamManager();
                    if (VrCoreSdkClient.this.daydreamManager == null) {
                        Log.w(VrCoreSdkClient.TAG, "Failed to obtain DaydreamManager from VrCore SDK Service.");
                        VrCoreSdkClient.this.handleNoDaydreamManager();
                        return;
                    }
                    VrCoreSdkClient.this.daydreamManager.registerListener(VrCoreSdkClient.this.componentName, VrCoreSdkClient.this.daydreamListener);
                    try {
                        HeadTrackingState headTrackingState = VrCoreSdkClient.this.getHeadTrackingState();
                        int access$600 = VrCoreSdkClient.this.prepareVr(headTrackingState);
                        if (access$600 == 0 && VrCoreSdkClient.this.onDonNotNeededListener != null) {
                            VrCoreSdkClient.this.onDonNotNeededListener.run();
                        }
                        if (access$600 == 2) {
                            Log.e(VrCoreSdkClient.TAG, "Daydream VR preparation failed, closing VR session.");
                            VrCoreSdkClient.this.handlePrepareVrFailed();
                            if (VrCoreSdkClient.this.isResumed) {
                                VrCoreSdkClient.this.resumeTracking((HeadTrackingState) null);
                                return;
                            }
                            return;
                        }
                        if (access$600 != 0) {
                            headTrackingState = null;
                        }
                        if (VrCoreSdkClient.this.isResumed) {
                            VrCoreSdkClient.this.resumeTracking(headTrackingState);
                        }
                        try {
                            IVrCoreLoggingService unused3 = VrCoreSdkClient.this.loggingService = VrCoreSdkClient.this.vrCoreSdkService.getLoggingService();
                        } catch (RemoteException e) {
                            String valueOf = String.valueOf(e);
                            Log.w(VrCoreSdkClient.TAG, new StringBuilder(String.valueOf(valueOf).length() + 42).append("Error getting logging service from VrCore:").append(valueOf).toString());
                        }
                    } catch (RemoteException e2) {
                        String valueOf2 = String.valueOf(e2);
                        Log.w(VrCoreSdkClient.TAG, new StringBuilder(String.valueOf(valueOf2).length() + 61).append("Error while registering listener with the VrCore SDK Service:").append(valueOf2).toString());
                        if (VrCoreSdkClient.this.isResumed) {
                            VrCoreSdkClient.this.resumeTracking((HeadTrackingState) null);
                        }
                    } catch (Throwable th) {
                        if (VrCoreSdkClient.this.isResumed) {
                            VrCoreSdkClient.this.resumeTracking((HeadTrackingState) null);
                        }
                        throw th;
                    }
                } catch (RemoteException e3) {
                    String valueOf3 = String.valueOf(e3);
                    Log.w(VrCoreSdkClient.TAG, new StringBuilder(String.valueOf(valueOf3).length() + 57).append("Failed to obtain DaydreamManager from VrCore SDK Service:").append(valueOf3).toString());
                    VrCoreSdkClient.this.handleNoDaydreamManager();
                }
            } catch (RemoteException e4) {
                String valueOf4 = String.valueOf(e4);
                Log.w(VrCoreSdkClient.TAG, new StringBuilder(String.valueOf(valueOf4).length() + 41).append("Failed to initialize VrCore SDK Service: ").append(valueOf4).toString());
                VrCoreSdkClient.this.handleBindFailed();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            IVrCoreSdkService unused = VrCoreSdkClient.this.vrCoreSdkService = null;
            IDaydreamManager unused2 = VrCoreSdkClient.this.daydreamManager = null;
            IVrCoreLoggingService unused3 = VrCoreSdkClient.this.loggingService = null;
        }
    };
    private final boolean shouldBind;
    private int vrCoreClientApiVersion;
    /* access modifiers changed from: private */
    public IVrCoreSdkService vrCoreSdkService;

    public VrCoreSdkClient(Context context2, GvrApi gvrApi2, ComponentName componentName2, DaydreamUtilsWrapper daydreamUtilsWrapper, Runnable runnable, FadeOverlayView fadeOverlayView2) {
        this.context = context2;
        this.gvrApi = gvrApi2;
        this.componentName = componentName2;
        this.daydreamUtils = daydreamUtilsWrapper;
        this.closeVrRunnable = runnable;
        this.fadeOverlayView = fadeOverlayView2;
        this.daydreamListener = new DaydreamListenerImpl(gvrApi2, fadeOverlayView2, runnable);
        this.shouldBind = hasCompatibleSdkService(context2);
        gvrApi2.setIgnoreManualTrackerPauseResume(true);
    }

    /* renamed from: com.google.vr.ndk.base.VrCoreSdkClient$DaydreamListenerImpl */
    private static final class DaydreamListenerImpl extends IDaydreamListener.Stub {
        private static final long FADE_SAFEGUARD_DELAY_MILLIS = 5500;
        private static final int MSG_FADE_IN_SAFEGUARD = 2;
        private static final int MSG_TRACKING_RESUME_SAFEGUARD = 1;
        private static final long TRACKING_SAFEGUARD_DELAY_MILLIS = 5000;
        private final WeakReference<Runnable> closeVrRunnableWeak;
        private final WeakReference<FadeOverlayView> fadeOverlayViewWeak;
        private final WeakReference<GvrApi> gvrApiWeak;
        private final Handler safeguardHandler = new Handler() {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        Log.w(VrCoreSdkClient.TAG, "Forcing tracking resume: VrCore unresponsive");
                        DaydreamListenerImpl.this.resumeHeadTrackingImpl((HeadTrackingState) null);
                        return;
                    case 2:
                        Log.w(VrCoreSdkClient.TAG, "Forcing fade in: VrCore unresponsive");
                        DaydreamListenerImpl.this.applyColorfulFadeImpl(1, 350, SdkServiceConsts.TRANSITION_FADE_OVERLAY_COLOR);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };

        DaydreamListenerImpl(GvrApi gvrApi, FadeOverlayView fadeOverlayView, Runnable runnable) {
            this.gvrApiWeak = new WeakReference<>(gvrApi);
            this.fadeOverlayViewWeak = new WeakReference<>(fadeOverlayView);
            this.closeVrRunnableWeak = new WeakReference<>(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void resetSafeguards() {
            this.safeguardHandler.removeCallbacksAndMessages((Object) null);
        }

        public final int getTargetApiVersion() throws RemoteException {
            return 23;
        }

        public final HeadTrackingState requestStopTracking() throws RemoteException {
            GvrApi gvrApi = (GvrApi) this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid requestStopTracking() call: GvrApi no longer valid");
                return null;
            }
            byte[] pauseTrackingGetState = gvrApi.pauseTrackingGetState();
            rescheduleSafeguard(1, 5000);
            if (pauseTrackingGetState != null) {
                return new HeadTrackingState(pauseTrackingGetState);
            }
            return null;
        }

        public final void applyFade(int i, long j) {
            applyColorfulFadeImpl(i, j, SdkServiceConsts.TRANSITION_FADE_OVERLAY_COLOR);
        }

        public final void applyColorfulFade(int i, long j, int i2) {
            applyColorfulFadeImpl(i, j, i2);
        }

        public final void recenterHeadTracking() throws RemoteException {
            GvrApi gvrApi = (GvrApi) this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid recenterHeadTracking() call: GvrApi no longer valid");
            } else {
                gvrApi.recenterTracking();
            }
        }

        public final void dumpDebugData() throws RemoteException {
            GvrApi gvrApi = (GvrApi) this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid dumpDebugData() call: GvrApi no longer valid");
            } else {
                gvrApi.dumpDebugData();
            }
        }

        public final void resumeHeadTracking(HeadTrackingState headTrackingState) {
            resumeHeadTrackingImpl(headTrackingState);
        }

        public final void invokeCloseAction() {
            Runnable runnable = (Runnable) this.closeVrRunnableWeak.get();
            if (runnable == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid invokeCloseAction() call: Runnable no longer valid");
            } else {
                ThreadUtils.runOnUiThread(runnable);
            }
        }

        public final void deprecated_setLensOffsets(float f, float f2, float f3, float f4) {
            GvrApi gvrApi = (GvrApi) this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid setLensOffsets() call: GvrApi no longer valid");
            } else {
                gvrApi.setLensOffset(f, f2, 0.0f);
            }
        }

        public final void setLensOffset(float f, float f2, float f3) {
            GvrApi gvrApi = (GvrApi) this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid setLensOffset() call: GvrApi no longer valid");
            } else {
                gvrApi.setLensOffset(f, f2, f3);
            }
        }

        /* access modifiers changed from: private */
        public final void resumeHeadTrackingImpl(HeadTrackingState headTrackingState) {
            GvrApi gvrApi = (GvrApi) this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w(VrCoreSdkClient.TAG, "Invalid resumeHeadTracking() call: GvrApi no longer valid");
                return;
            }
            cancelSafeguard(1);
            VrCoreSdkClient.resumeTracking(gvrApi, headTrackingState);
        }

        /* access modifiers changed from: private */
        public final void applyColorfulFadeImpl(int i, long j, int i2) {
            final FadeOverlayView fadeOverlayView = (FadeOverlayView) this.fadeOverlayViewWeak.get();
            if (fadeOverlayView != null) {
                cancelSafeguard(2);
                final int i3 = i;
                final long j2 = j;
                final int i4 = i2;
                fadeOverlayView.post(new Runnable(this) {
                    public void run() {
                        fadeOverlayView.startFade(i3, j2, i4);
                    }
                });
                if (i == 2) {
                    rescheduleSafeguard(2, FADE_SAFEGUARD_DELAY_MILLIS + j);
                }
            }
        }

        private final void cancelSafeguard(int i) {
            this.safeguardHandler.removeMessages(i);
        }

        private final void rescheduleSafeguard(int i, long j) {
            cancelSafeguard(i);
            this.safeguardHandler.sendEmptyMessageDelayed(i, j);
        }
    }

    /* access modifiers changed from: package-private */
    public IDaydreamManager getDaydreamManager() {
        return this.daydreamManager;
    }

    /* access modifiers changed from: package-private */
    public IVrCoreLoggingService getLoggingService() {
        return this.loggingService;
    }

    /* access modifiers changed from: package-private */
    public HeadTrackingState getHeadTrackingState() {
        return new HeadTrackingState();
    }

    public boolean onResume() {
        this.isResumed = true;
        if (!this.isEnabled) {
            return false;
        }
        return doBind();
    }

    public void onPause() {
        this.isResumed = false;
        this.daydreamListener.resetSafeguards();
        if (this.isEnabled) {
            doUnbind();
        }
    }

    public void setEnabled(boolean z) {
        if (this.isEnabled != z) {
            this.isEnabled = z;
            this.gvrApi.setIgnoreManualTrackerPauseResume(z);
            if (!this.isResumed) {
                return;
            }
            if (this.isEnabled) {
                doBind();
            } else {
                doUnbind();
            }
        }
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        this.optionalReentryIntent = pendingIntent;
    }

    public void setOnDonNotNeededListener(Runnable runnable) {
        this.onDonNotNeededListener = runnable;
    }

    public void onExitingFromVr() {
        if (this.daydreamManager != null && this.vrCoreClientApiVersion >= 16) {
            try {
                this.daydreamManager.onExitingFromVr();
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to signal exit from VR to VrCore: ").append(valueOf).toString());
            }
        }
    }

    private boolean doBind() {
        if (this.isBound) {
            return true;
        }
        if (this.shouldBind) {
            Intent intent = new Intent(SdkServiceConsts.BIND_INTENT_ACTION);
            intent.setPackage("com.google.vr.vrcore");
            this.isBound = this.context.bindService(intent, this.serviceConnection, 1);
        }
        if (!this.isBound) {
            handleBindFailed();
        }
        return this.isBound;
    }

    private void doUnbind() {
        if (this.isResumed) {
            resumeTracking((HeadTrackingState) null);
        } else {
            this.gvrApi.pauseTrackingGetState();
        }
        if (this.isBound) {
            if (this.daydreamManager != null) {
                try {
                    this.daydreamManager.unregisterListener(this.componentName);
                } catch (RemoteException e) {
                    String valueOf = String.valueOf(e);
                    Log.w(TAG, new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to unregister Daydream listener: ").append(valueOf).toString());
                }
                this.daydreamManager = null;
            }
            this.vrCoreSdkService = null;
            this.loggingService = null;
            this.context.unbindService(this.serviceConnection);
            this.isBound = false;
        }
    }

    /* access modifiers changed from: private */
    public void handleBindFailed() {
        doUnbind();
        warnIfIncompatibleClient();
    }

    /* access modifiers changed from: private */
    public void handleNoDaydreamManager() {
        doUnbind();
        warnIfIncompatibleClient();
    }

    /* access modifiers changed from: private */
    public void handlePrepareVrFailed() {
        doUnbind();
        this.closeVrRunnable.run();
    }

    private void warnIfIncompatibleClient() {
        if (!this.daydreamUtils.isDaydreamPhone(this.context) && this.daydreamUtils.isDaydreamRequiredComponent(this.context) && !ActivityManager.isRunningInTestHarness()) {
            if (this.helpCenterDialog != null) {
                this.helpCenterDialog.show();
            } else {
                this.helpCenterDialog = UiUtils.showDaydreamHelpCenterDialog(this.context, C0021R.string.dialog_title_incompatible_phone, C0021R.string.dialog_message_incompatible_phone, this.closeVrRunnable);
            }
        }
    }

    /* access modifiers changed from: private */
    public void resumeTracking(HeadTrackingState headTrackingState) {
        resumeTracking(this.gvrApi, headTrackingState);
        if (this.fadeOverlayView != null) {
            this.fadeOverlayView.flushAutoFade();
        }
    }

    /* access modifiers changed from: private */
    public static void resumeTracking(GvrApi gvrApi2, HeadTrackingState headTrackingState) {
        gvrApi2.resumeTrackingSetState((headTrackingState == null || headTrackingState.isEmpty()) ? null : headTrackingState.getData());
    }

    private boolean hasCompatibleSdkService(Context context2) {
        try {
            this.vrCoreClientApiVersion = VrCoreUtils.getVrCoreClientApiVersion(context2);
            if (this.vrCoreClientApiVersion >= 5) {
                return true;
            }
            Log.w(TAG, String.format("VrCore service obsolete, GVR SDK requires API %d but found API %d.", new Object[]{5, Integer.valueOf(this.vrCoreClientApiVersion)}));
            return false;
        } catch (VrCoreNotAvailableException e) {
        }
    }

    /* access modifiers changed from: private */
    public int prepareVr(HeadTrackingState headTrackingState) throws RemoteException {
        Activity activity;
        if (this.vrCoreClientApiVersion < 13) {
            if (this.optionalReentryIntent != null) {
                Log.i(TAG, "Ignoring client re-entry intent; unsupported by current VrCore.");
            }
            return this.daydreamManager.prepareVr(this.componentName, headTrackingState);
        }
        DaydreamCompatibility componentDaydreamCompatibility = DaydreamUtils.getComponentDaydreamCompatibility(this.context, this.componentName);
        PendingIntent pendingIntent = this.optionalReentryIntent;
        if (pendingIntent == null) {
            Intent createVrIntent = DaydreamApi.createVrIntent(this.componentName);
            createVrIntent.addFlags(536870912);
            if (!((this.context instanceof VrContextWrapper) || (activity = ContextUtils.getActivity(this.context)) == null || activity.getIntent() == null)) {
                createVrIntent.putExtras(activity.getIntent());
                createVrIntent.fillIn(activity.getIntent(), 2);
            }
            pendingIntent = PendingIntent.getActivity(this.context, 0, createVrIntent, 1073741824);
        }
        if (this.vrCoreClientApiVersion < MIN_PREPARE_VR_3_API_VERSION) {
            return this.daydreamManager.prepareVr2(this.componentName, componentDaydreamCompatibility.toDeprecated(), pendingIntent, headTrackingState);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(SdkServiceConsts.CONFIGURATION_KEY_COMPONENT_NAME, this.componentName);
        bundle.putInt(SdkServiceConsts.CONFIGURATION_KEY_DAYDREAM_COMPATIBILITY_DEPRECATED, componentDaydreamCompatibility.toDeprecated());
        bundle.putInt(SdkServiceConsts.CONFIGURATION_KEY_DAYDREAM_COMPATIBILITY_BITMASK, componentDaydreamCompatibility.getSupportedHeadsets());
        bundle.putParcelable(SdkServiceConsts.CONFIGURATION_KEY_OPTIONAL_REENTRY_INTENT, pendingIntent);
        bundle.putBoolean(SdkServiceConsts.CONFIGURATION_KEY_IS_USING_VR_DISPLAY_SERVICE, this.gvrApi.usingVrDisplayService());
        return this.daydreamManager.prepareVr3(bundle, headTrackingState);
    }
}
