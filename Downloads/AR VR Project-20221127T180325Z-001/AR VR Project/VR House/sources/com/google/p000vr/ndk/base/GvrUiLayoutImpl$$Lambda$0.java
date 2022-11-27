package com.google.p000vr.ndk.base;

/* renamed from: com.google.vr.ndk.base.GvrUiLayoutImpl$$Lambda$0 */
final /* synthetic */ class GvrUiLayoutImpl$$Lambda$0 implements Runnable {
    private final GvrUiLayoutImpl arg$1;

    GvrUiLayoutImpl$$Lambda$0(GvrUiLayoutImpl gvrUiLayoutImpl) {
        this.arg$1 = gvrUiLayoutImpl;
    }

    public final void run() {
        this.arg$1.delayDimmingUiLayerAfterVisible();
    }
}
