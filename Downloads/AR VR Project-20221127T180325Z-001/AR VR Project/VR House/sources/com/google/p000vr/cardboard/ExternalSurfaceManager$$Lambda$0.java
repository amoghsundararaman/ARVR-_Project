package com.google.p000vr.cardboard;

import com.google.p000vr.cardboard.ExternalSurfaceManager;

/* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$$Lambda$0 */
final /* synthetic */ class ExternalSurfaceManager$$Lambda$0 implements ExternalSurfaceManager.ExternalSurfaceConsumer {
    private final ExternalSurfaceManager arg$1;

    ExternalSurfaceManager$$Lambda$0(ExternalSurfaceManager externalSurfaceManager) {
        this.arg$1 = externalSurfaceManager;
    }

    public final void accept(ExternalSurfaceManager.ExternalSurface externalSurface) {
        this.arg$1.lambda$consumerUpdateManagedSurfaces$0$ExternalSurfaceManager(externalSurface);
    }
}
