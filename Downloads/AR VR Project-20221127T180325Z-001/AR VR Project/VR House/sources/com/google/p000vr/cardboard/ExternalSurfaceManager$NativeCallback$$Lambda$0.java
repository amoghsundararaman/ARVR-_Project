package com.google.p000vr.cardboard;

/* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$NativeCallback$$Lambda$0 */
final /* synthetic */ class ExternalSurfaceManager$NativeCallback$$Lambda$0 implements Runnable {
    private final long arg$1;

    ExternalSurfaceManager$NativeCallback$$Lambda$0(long j) {
        this.arg$1 = j;
    }

    public final void run() {
        ExternalSurfaceManager.nativeCallback(this.arg$1);
    }
}
