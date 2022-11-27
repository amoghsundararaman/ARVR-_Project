package com.google.p000vr.ndk.base;

/* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$$Lambda$0 */
final /* synthetic */ class GvrLayoutImpl$$Lambda$0 implements Runnable {
    private final GvrLayoutImpl arg$1;
    private final boolean arg$2;

    GvrLayoutImpl$$Lambda$0(GvrLayoutImpl gvrLayoutImpl, boolean z) {
        this.arg$1 = gvrLayoutImpl;
        this.arg$2 = z;
    }

    public final void run() {
        this.arg$1.lambda$setStereoModeEnabled$0$GvrLayoutImpl(this.arg$2);
    }
}
