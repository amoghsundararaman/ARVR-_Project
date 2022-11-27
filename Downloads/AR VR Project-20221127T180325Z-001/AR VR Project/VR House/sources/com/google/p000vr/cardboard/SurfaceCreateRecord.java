package com.google.p000vr.cardboard;

import android.os.Handler;

@UsedByNative
/* renamed from: com.google.vr.cardboard.SurfaceCreateRecord */
public final class SurfaceCreateRecord {
    @UsedByNative
    public final Runnable frameListener;
    @UsedByNative
    public final Handler handler;
    @UsedByNative
    public final int height;
    @UsedByNative
    public final Runnable surfaceListener;
    @UsedByNative
    public final int width;

    public SurfaceCreateRecord(Runnable runnable, Runnable runnable2, Handler handler2) {
        this.surfaceListener = runnable;
        this.frameListener = runnable2;
        this.handler = handler2;
        this.width = -1;
        this.height = -1;
    }

    public SurfaceCreateRecord(Runnable runnable, Runnable runnable2, Handler handler2, int i, int i2) {
        this.surfaceListener = runnable;
        this.frameListener = runnable2;
        this.handler = handler2;
        this.width = i;
        this.height = i2;
    }
}
