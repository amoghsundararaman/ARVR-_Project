package com.google.p000vr.ndk.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.p000vr.vrcore.performance.api.IPerformanceService;
import com.google.p000vr.vrcore.performance.api.IThrottlingTriggerCallback;
import com.google.p000vr.vrcore.performance.api.PerformanceServiceConsts;
import java.util.ArrayList;

/* renamed from: com.google.vr.ndk.base.ThrottlingMonitor */
public class ThrottlingMonitor implements AutoCloseable {
    public static final int ERROR_NOT_ACCURATE = -4;
    public static final int ERROR_NOT_CONNECTED = -3;
    public static final int ERROR_NOT_SUPPORTED = -1;
    public static final int ERROR_NO_PERMISSION = -2;
    public static final int ERROR_UNKNOWN = -5;
    public static final int SUCCESS = 0;
    private static final String TAG = "ThrottlingMonitor";
    private final ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ArrayList arrayList = new ArrayList();
            synchronized (ThrottlingMonitor.this.lock) {
                IPerformanceService unused = ThrottlingMonitor.this.perfService = IPerformanceService.Stub.asInterface(iBinder);
                arrayList.addAll(ThrottlingMonitor.this.setupCallbacks);
                ThrottlingMonitor.this.setupCallbacks.clear();
                ThrottlingMonitor.this.lock.notifyAll();
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((SetupCallback) obj).onInitialized();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (ThrottlingMonitor.this.lock) {
                IPerformanceService unused = ThrottlingMonitor.this.perfService = null;
                ThrottlingMonitor.this.lock.notifyAll();
            }
        }
    };
    private final Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Handler mainHandler;
    /* access modifiers changed from: private */
    public IPerformanceService perfService;
    /* access modifiers changed from: private */
    public final ArrayList<SetupCallback> setupCallbacks = new ArrayList<>();

    /* renamed from: com.google.vr.ndk.base.ThrottlingMonitor$SetupCallback */
    public interface SetupCallback {
        void onInitialized();
    }

    /* renamed from: com.google.vr.ndk.base.ThrottlingMonitor$TemperatureTrigger */
    public interface TemperatureTrigger {
        void onTemperatureEvent(float f, long j);
    }

    private ThrottlingMonitor(Context context2) {
        this.context = context2;
        this.mainHandler = new Handler(context2.getMainLooper());
    }

    /* renamed from: com.google.vr.ndk.base.ThrottlingMonitor$ThrottlingTriggerCallback */
    private static class ThrottlingTriggerCallback extends IThrottlingTriggerCallback.Stub {
        private final Handler handler;
        /* access modifiers changed from: private */
        public final TemperatureTrigger trigger;

        public ThrottlingTriggerCallback(TemperatureTrigger temperatureTrigger, Handler handler2) {
            this.trigger = temperatureTrigger;
            this.handler = handler2;
        }

        public void onTriggerActivated(final float f, final long j) {
            if (this.handler == null) {
                this.trigger.onTemperatureEvent(f, j);
            } else {
                this.handler.post(new Runnable() {
                    public void run() {
                        ThrottlingTriggerCallback.this.trigger.onTemperatureEvent(f, j);
                    }
                });
            }
        }
    }

    public static ThrottlingMonitor create(Context context2) {
        Intent intent = new Intent(PerformanceServiceConsts.BIND_INTENT_ACTION);
        intent.setPackage("com.google.vr.vrcore");
        ThrottlingMonitor throttlingMonitor = new ThrottlingMonitor(context2);
        if (!context2.bindService(intent, throttlingMonitor.connection, 1)) {
            return null;
        }
        return throttlingMonitor;
    }

    public void registerSetupCallback(final SetupCallback setupCallback) {
        synchronized (this.lock) {
            if (this.perfService != null) {
                this.mainHandler.post(new Runnable(this) {
                    public void run() {
                        setupCallback.onInitialized();
                    }
                });
            } else {
                this.setupCallbacks.add(setupCallback);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int queryRelativeTemperature(com.google.p000vr.vrcore.performance.api.TimestampedTemperature r5) {
        /*
            r4 = this;
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
            com.google.vr.vrcore.performance.api.IPerformanceService r0 = r4.perfService     // Catch:{ all -> 0x000a }
            monitor-exit(r1)     // Catch:{ all -> 0x000a }
            if (r0 != 0) goto L_0x000d
            r0 = -3
        L_0x0009:
            return r0
        L_0x000a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000a }
            throw r0
        L_0x000d:
            r0.getCurrentThrottlingRelativeTemperature(r5)     // Catch:{ RemoteException -> 0x0019, SecurityException -> 0x0042, UnsupportedOperationException -> 0x0045 }
            float r0 = r5.temperature
            r1 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x004f
            r0 = -4
            goto L_0x0009
        L_0x0019:
            r0 = move-exception
            java.lang.String r1 = "ThrottlingMonitor"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 29
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Service failed unexpectedly: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            r0 = -5
            goto L_0x0009
        L_0x0042:
            r0 = move-exception
            r0 = -2
            goto L_0x0009
        L_0x0045:
            r0 = move-exception
            java.lang.String r0 = "ThrottlingMonitor"
            java.lang.String r1 = "Throttling monitoring not supported on this device."
            android.util.Log.w(r0, r1)
            r0 = -1
            goto L_0x0009
        L_0x004f:
            r0 = 0
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.ThrottlingMonitor.queryRelativeTemperature(com.google.vr.vrcore.performance.api.TimestampedTemperature):int");
    }

    public int addTrigger(ComponentName componentName, float f, TemperatureTrigger temperatureTrigger, long j, Handler handler) {
        return addTriggerInternal(componentName, 3, f, temperatureTrigger, j, handler);
    }

    public int addTrigger(ComponentName componentName, TemperatureTrigger temperatureTrigger, long j, Handler handler) {
        return addTriggerInternal(componentName, 1, 0.0f, temperatureTrigger, j, handler);
    }

    public int addTrigger(ComponentName componentName, float f, TemperatureTrigger temperatureTrigger, Handler handler) {
        return addTriggerInternal(componentName, 2, f, temperatureTrigger, 0, handler);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int removeAllTriggers(android.content.ComponentName r5) {
        /*
            r4 = this;
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
            com.google.vr.vrcore.performance.api.IPerformanceService r0 = r4.perfService     // Catch:{ all -> 0x000a }
            monitor-exit(r1)     // Catch:{ all -> 0x000a }
            if (r0 != 0) goto L_0x000d
            r0 = -3
        L_0x0009:
            return r0
        L_0x000a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000a }
            throw r0
        L_0x000d:
            r0.removeAllTriggers(r5)     // Catch:{ RemoteException -> 0x0012, SecurityException -> 0x003b, UnsupportedOperationException -> 0x003e }
            r0 = 0
            goto L_0x0009
        L_0x0012:
            r0 = move-exception
            java.lang.String r1 = "ThrottlingMonitor"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 29
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Service failed unexpectedly: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            r0 = -5
            goto L_0x0009
        L_0x003b:
            r0 = move-exception
            r0 = -2
            goto L_0x0009
        L_0x003e:
            r0 = move-exception
            java.lang.String r0 = "ThrottlingMonitor"
            java.lang.String r1 = "Throttling monitoring not supported on this device."
            android.util.Log.w(r0, r1)
            r0 = -1
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.ThrottlingMonitor.removeAllTriggers(android.content.ComponentName):int");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getEstimatedThrottlingTimeNanos() {
        /*
            r4 = this;
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
            com.google.vr.vrcore.performance.api.IPerformanceService r0 = r4.perfService     // Catch:{ all -> 0x000b }
            monitor-exit(r1)     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x000e
            r0 = -3
        L_0x000a:
            return r0
        L_0x000b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000b }
            throw r0
        L_0x000e:
            long r0 = r0.getCurrentEstimatedThrottleWarningTime()     // Catch:{ RemoteException -> 0x001b, SecurityException -> 0x0045, UnsupportedOperationException -> 0x0049 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x000a
            r0 = -4
            goto L_0x000a
        L_0x001b:
            r0 = move-exception
            java.lang.String r1 = "ThrottlingMonitor"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 29
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Service failed unexpectedly: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            r0 = -5
            goto L_0x000a
        L_0x0045:
            r0 = move-exception
            r0 = -2
            goto L_0x000a
        L_0x0049:
            r0 = move-exception
            java.lang.String r0 = "ThrottlingMonitor"
            java.lang.String r1 = "Throttling monitoring not supported on this device."
            android.util.Log.w(r0, r1)
            r0 = -1
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.ThrottlingMonitor.getEstimatedThrottlingTimeNanos():long");
    }

    public void close() {
        this.context.unbindService(this.connection);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int addTriggerInternal(android.content.ComponentName r12, int r13, float r14, com.google.p000vr.ndk.base.ThrottlingMonitor.TemperatureTrigger r15, long r16, android.os.Handler r18) {
        /*
            r11 = this;
            if (r15 != 0) goto L_0x000a
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Argument 'trigger' cannot be null."
            r2.<init>(r3)
            throw r2
        L_0x000a:
            java.lang.Object r4 = r11.lock
            monitor-enter(r4)
            com.google.vr.vrcore.performance.api.IPerformanceService r3 = r11.perfService     // Catch:{ all -> 0x0014 }
            monitor-exit(r4)     // Catch:{ all -> 0x0014 }
            if (r3 != 0) goto L_0x0017
            r2 = -3
        L_0x0013:
            return r2
        L_0x0014:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0014 }
            throw r2
        L_0x0017:
            com.google.vr.ndk.base.ThrottlingMonitor$ThrottlingTriggerCallback r5 = new com.google.vr.ndk.base.ThrottlingMonitor$ThrottlingTriggerCallback
            r0 = r18
            r5.<init>(r15, r0)
            r4 = r12
            r6 = r16
            r8 = r14
            r9 = r13
            r3.addTrigger(r4, r5, r6, r8, r9)     // Catch:{ RemoteException -> 0x0028, SecurityException -> 0x0051, UnsupportedOperationException -> 0x0054 }
            r2 = 0
            goto L_0x0013
        L_0x0028:
            r2 = move-exception
            java.lang.String r3 = "ThrottlingMonitor"
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r4 = r4 + 29
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Service failed unexpectedly: "
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r3, r2)
            r2 = -5
            goto L_0x0013
        L_0x0051:
            r2 = move-exception
            r2 = -2
            goto L_0x0013
        L_0x0054:
            r2 = move-exception
            java.lang.String r2 = "ThrottlingMonitor"
            java.lang.String r3 = "Throttling monitoring not supported on this device."
            android.util.Log.w(r2, r3)
            r2 = -1
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.ThrottlingMonitor.addTriggerInternal(android.content.ComponentName, int, float, com.google.vr.ndk.base.ThrottlingMonitor$TemperatureTrigger, long, android.os.Handler):int");
    }
}
