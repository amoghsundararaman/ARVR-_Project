package com.google.p000vr.vrcore.controller.api;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerServiceBridge$$Lambda$2 */
final /* synthetic */ class ControllerServiceBridge$$Lambda$2 implements Runnable {
    private final ControllerServiceBridge arg$1;
    private final int arg$2;
    private final ControllerRequest arg$3;

    ControllerServiceBridge$$Lambda$2(ControllerServiceBridge controllerServiceBridge, int i, ControllerRequest controllerRequest) {
        this.arg$1 = controllerServiceBridge;
        this.arg$2 = i;
        this.arg$3 = controllerRequest;
    }

    public final void run() {
        this.arg$1.lambda$vibrateController$0$ControllerServiceBridge(this.arg$2, this.arg$3);
    }
}
