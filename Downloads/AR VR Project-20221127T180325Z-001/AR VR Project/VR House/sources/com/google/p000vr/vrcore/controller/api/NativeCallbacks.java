package com.google.p000vr.vrcore.controller.api;

import com.google.p000vr.cardboard.annotations.UsedByNative;
import com.google.p000vr.vrcore.controller.api.ControllerServiceBridge;

@UsedByNative
/* renamed from: com.google.vr.vrcore.controller.api.NativeCallbacks */
public final class NativeCallbacks implements ControllerServiceBridge.Callbacks {
    private boolean closed;
    private final long userData;

    @UsedByNative
    public NativeCallbacks(long j) {
        this.userData = j;
    }

    private final native void handleAccelEvent(long j, int i, long j2, float f, float f2, float f3);

    private final native void handleBatteryEvent(long j, int i, long j2, boolean z, int i2);

    private final native void handleButtonEvent(long j, int i, long j2, int i2, boolean z);

    private final native void handleControllerRecentered(long j, int i, long j2, float f, float f2, float f3, float f4);

    private final native void handleGyroEvent(long j, int i, long j2, float f, float f2, float f3);

    private final native void handleOrientationEvent(long j, int i, long j2, float f, float f2, float f3, float f4);

    private final native void handlePositionEvent(long j, int i, long j2, float f, float f2, float f3);

    private final native void handleServiceConnected(long j, int i);

    private final native void handleServiceDisconnected(long j);

    private final native void handleServiceFailed(long j);

    private final native void handleServiceInitFailed(long j, int i);

    private final native void handleServiceUnavailable(long j);

    private final native void handleStateChanged(long j, int i, int i2);

    private final native void handleTouchEvent(long j, int i, long j2, int i2, float f, float f2);

    @UsedByNative
    public final synchronized void close() {
        this.closed = true;
    }

    public final synchronized void onControllerStateChanged(int i, int i2) {
        if (!this.closed) {
            handleStateChanged(this.userData, i, i2);
        }
    }

    public final synchronized void onControllerEventPacket(ControllerEventPacket controllerEventPacket) {
        if (!this.closed) {
            handleEventsCompatibilityLocked(controllerEventPacket);
        }
    }

    public final synchronized void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) {
        if (!this.closed) {
            handleEventsCompatibilityLocked(controllerEventPacket2);
            int i = 0;
            while (!this.closed && i < controllerEventPacket2.getPositionEventCount()) {
                ControllerPositionEvent positionEvent = controllerEventPacket2.getPositionEvent(i);
                handlePositionEvent(this.userData, positionEvent.controllerId, positionEvent.timestampNanos, positionEvent.f22x, positionEvent.f23y, positionEvent.f24z);
                i++;
            }
            if (!this.closed && controllerEventPacket2.hasBatteryEvent()) {
                ControllerBatteryEvent batteryEvent = controllerEventPacket2.getBatteryEvent();
                handleBatteryEvent(this.userData, batteryEvent.controllerId, batteryEvent.timestampNanos, batteryEvent.charging, batteryEvent.batteryLevelBucket);
            }
        }
    }

    private final void handleEventsCompatibilityLocked(ControllerEventPacket controllerEventPacket) {
        int i = 0;
        int i2 = 0;
        while (!this.closed && i2 < controllerEventPacket.getAccelEventCount()) {
            ControllerAccelEvent accelEvent = controllerEventPacket.getAccelEvent(i2);
            handleAccelEvent(this.userData, accelEvent.controllerId, accelEvent.timestampNanos, accelEvent.f12x, accelEvent.f13y, accelEvent.f14z);
            i2++;
        }
        int i3 = 0;
        while (!this.closed && i3 < controllerEventPacket.getButtonEventCount()) {
            ControllerButtonEvent buttonEvent = controllerEventPacket.getButtonEvent(i3);
            handleButtonEvent(this.userData, buttonEvent.controllerId, buttonEvent.timestampNanos, buttonEvent.button, buttonEvent.down);
            i3++;
        }
        int i4 = 0;
        while (!this.closed && i4 < controllerEventPacket.getGyroEventCount()) {
            ControllerGyroEvent gyroEvent = controllerEventPacket.getGyroEvent(i4);
            handleGyroEvent(this.userData, gyroEvent.controllerId, gyroEvent.timestampNanos, gyroEvent.f15x, gyroEvent.f16y, gyroEvent.f17z);
            i4++;
        }
        int i5 = 0;
        while (!this.closed && i5 < controllerEventPacket.getOrientationEventCount()) {
            ControllerOrientationEvent orientationEvent = controllerEventPacket.getOrientationEvent(i5);
            handleOrientationEvent(this.userData, orientationEvent.controllerId, orientationEvent.timestampNanos, orientationEvent.f19qx, orientationEvent.f20qy, orientationEvent.f21qz, orientationEvent.f18qw);
            i5++;
        }
        while (!this.closed && i < controllerEventPacket.getTouchEventCount()) {
            ControllerTouchEvent touchEvent = controllerEventPacket.getTouchEvent(i);
            handleTouchEvent(this.userData, touchEvent.controllerId, touchEvent.timestampNanos, touchEvent.action, touchEvent.f25x, touchEvent.f26y);
            i++;
        }
    }

    public final synchronized void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) {
        if (!this.closed) {
            handleControllerRecentered(this.userData, controllerOrientationEvent.controllerId, controllerOrientationEvent.timestampNanos, controllerOrientationEvent.f19qx, controllerOrientationEvent.f20qy, controllerOrientationEvent.f21qz, controllerOrientationEvent.f18qw);
        }
    }

    public final synchronized void onServiceConnected(int i) {
        if (!this.closed) {
            handleServiceConnected(this.userData, i);
        }
    }

    public final synchronized void onServiceDisconnected() {
        if (!this.closed) {
            handleServiceDisconnected(this.userData);
        }
    }

    public final synchronized void onServiceFailed() {
        if (!this.closed) {
            handleServiceFailed(this.userData);
        }
    }

    public final synchronized void onServiceUnavailable() {
        if (!this.closed) {
            handleServiceUnavailable(this.userData);
        }
    }

    public final synchronized void onServiceInitFailed(int i) {
        if (!this.closed) {
            handleServiceInitFailed(this.userData, i);
        }
    }
}
