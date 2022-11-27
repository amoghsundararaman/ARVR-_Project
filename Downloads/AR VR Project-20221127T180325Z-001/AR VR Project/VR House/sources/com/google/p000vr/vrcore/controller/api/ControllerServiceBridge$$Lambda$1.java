package com.google.p000vr.vrcore.controller.api;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge$$Lambda$1 */
final /* synthetic */ class ControllerServiceBridge$$Lambda$1 implements Runnable {
    private final ControllerServiceBridge arg$1;

    ControllerServiceBridge$$Lambda$1(ControllerServiceBridge controllerServiceBridge) {
        this.arg$1 = controllerServiceBridge;
    }

    public final void run() {
        this.arg$1.doUnbind();
    }
}
