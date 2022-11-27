package com.google.p000vr.ndk.base;

import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.google.p000vr.ndk.base.GvrLayout;

/* renamed from: com.google.vr.ndk.base.ExternalSurface */
public class ExternalSurface {
    /* access modifiers changed from: private */
    public static final String TAG = ExternalSurface.class.getSimpleName();
    private long nativeExternalSurface;

    ExternalSurface(long j) {
        this.nativeExternalSurface = j;
    }

    ExternalSurface(GvrApi gvrApi, final GvrLayout.ExternalSurfaceListener externalSurfaceListener, Handler handler) {
        if (externalSurfaceListener == null) {
            throw new IllegalArgumentException("ExternalSurface creation requires a valid listener.");
        } else if (handler == null) {
            throw new IllegalArgumentException("ExternalSurface creation requires a valid Handler.");
        } else {
            this.nativeExternalSurface = GvrApi.nativeExternalSurfaceCreateWithListeners(gvrApi.getNativeGvrContext(), new Runnable() {
                public void run() {
                    Surface surface = ExternalSurface.this.getSurface();
                    if (surface == null || !surface.isValid()) {
                        Log.w(ExternalSurface.TAG, "No valid Surface during onSurfaceAvailable callback. The native GvrContext might have been shut down already.");
                    } else {
                        externalSurfaceListener.onSurfaceAvailable(surface);
                    }
                }
            }, new Runnable(this) {
                public void run() {
                    externalSurfaceListener.onFrameAvailable();
                }
            }, handler);
            if (this.nativeExternalSurface == 0) {
                throw new IllegalStateException("ExternalSurface creation failed. Is reprojection enabled?");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nativeExternalSurface != 0) {
                Log.w(TAG, "ExternalSurface.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    public Surface getSurface() {
        return GvrApi.nativeExternalSurfaceGetSurface(this.nativeExternalSurface);
    }

    public int getId() {
        return GvrApi.nativeExternalSurfaceGetId(this.nativeExternalSurface);
    }

    public void shutdown() {
        if (this.nativeExternalSurface != 0) {
            GvrApi.nativeExternalSurfaceDestroy(this.nativeExternalSurface);
            this.nativeExternalSurface = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNativeExternalSurface() {
        return this.nativeExternalSurface;
    }
}
