package com.google.p000vr.ndk.base;

import android.content.Context;
import com.google.p000vr.cardboard.ThreadUtils;
import com.google.p000vr.vrcore.controller.api.ControllerButtonEvent;
import com.google.p000vr.vrcore.controller.api.ControllerEventPacket;
import com.google.p000vr.vrcore.controller.api.ControllerEventPacket2;
import com.google.p000vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.p000vr.vrcore.controller.api.ControllerServiceBridge;

/* renamed from: com.google.vr.ndk.base.CardboardEmulator */
class CardboardEmulator {
    private static final boolean DEBUG = false;
    private static final String TAG = CardboardEmulator.class.getSimpleName();
    private final ControllerServiceBridge controllerServiceBridge;
    private boolean resumed;

    public CardboardEmulator(Context context, Runnable runnable) {
        this.controllerServiceBridge = createServiceBridge(context, new ControllerCallbacks(runnable));
    }

    /* renamed from: com.google.vr.ndk.base.CardboardEmulator$ControllerCallbacks */
    private static class ControllerCallbacks implements ControllerServiceBridge.Callbacks {
        private final Runnable cardboardTriggerCallback;

        ControllerCallbacks(Runnable runnable) {
            this.cardboardTriggerCallback = runnable;
        }

        public void onServiceConnected(int i) {
        }

        public void onServiceDisconnected() {
        }

        public void onServiceUnavailable() {
        }

        public void onServiceFailed() {
        }

        public void onServiceInitFailed(int i) {
        }

        public void onControllerStateChanged(int i, int i2) {
        }

        public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) {
            for (int i = 0; i < controllerEventPacket.getButtonEventCount(); i++) {
                ControllerButtonEvent buttonEvent = controllerEventPacket.getButtonEvent(i);
                if (buttonEvent.down) {
                    switch (buttonEvent.button) {
                        case 1:
                        case 3:
                            ThreadUtils.runOnUiThread(this.cardboardTriggerCallback);
                            break;
                    }
                }
            }
        }

        public void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) {
        }

        public void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) {
            onControllerEventPacket(controllerEventPacket2);
        }
    }

    public void onResume() {
        if (!this.resumed) {
            this.resumed = true;
            this.controllerServiceBridge.requestBind();
        }
    }

    public void onPause() {
        if (this.resumed) {
            this.resumed = false;
            this.controllerServiceBridge.requestUnbind();
        }
    }

    /* access modifiers changed from: protected */
    public ControllerServiceBridge createServiceBridge(Context context, ControllerServiceBridge.Callbacks callbacks) {
        return new ControllerServiceBridge(context, callbacks, 0);
    }
}
