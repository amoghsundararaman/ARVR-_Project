package com.google.p000vr.ndk.base;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;

/* renamed from: com.google.vr.ndk.base.BufferViewport */
public class BufferViewport {
    public static final int BUFFER_INDEX_EXTERNAL_SURFACE = -1;
    public static final int EXTERNAL_SURFACE_ID_NONE = -1;
    private static final String TAG = BufferViewport.class.getSimpleName();
    long nativeBufferViewport;

    /* renamed from: com.google.vr.ndk.base.BufferViewport$EyeType */
    public static abstract class EyeType {
        public static final int LEFT = 0;
        public static final int RIGHT = 1;
    }

    /* renamed from: com.google.vr.ndk.base.BufferViewport$Reprojection */
    public static abstract class Reprojection {
        public static final int FULL = 1;
        public static final int NONE = 0;
    }

    BufferViewport(long j) {
        this.nativeBufferViewport = j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BufferViewport)) {
            return false;
        }
        return GvrApi.nativeBufferViewportEqual(this.nativeBufferViewport, ((BufferViewport) obj).nativeBufferViewport);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nativeBufferViewport != 0) {
                Log.w(TAG, "BufferViewport.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    public void shutdown() {
        if (this.nativeBufferViewport != 0) {
            GvrApi.nativeBufferViewportDestroy(this.nativeBufferViewport);
            this.nativeBufferViewport = 0;
        }
    }

    public void getSourceUv(RectF rectF) {
        GvrApi.nativeBufferViewportGetSourceUv(this.nativeBufferViewport, rectF);
    }

    public void setSourceUv(RectF rectF) {
        GvrApi.nativeBufferViewportSetSourceUv(this.nativeBufferViewport, rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void getSourceFov(RectF rectF) {
        GvrApi.nativeBufferViewportGetSourceFov(this.nativeBufferViewport, rectF);
    }

    public void setSourceFov(RectF rectF) {
        GvrApi.nativeBufferViewportSetSourceFov(this.nativeBufferViewport, rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void getTransform(float[] fArr) {
        GvrApi.nativeBufferViewportGetTransform(this.nativeBufferViewport, fArr);
    }

    public void setTransform(float[] fArr) {
        GvrApi.nativeBufferViewportSetTransform(this.nativeBufferViewport, fArr);
    }

    public int getTargetEye() {
        return GvrApi.nativeBufferViewportGetTargetEye(this.nativeBufferViewport);
    }

    public void setTargetEye(int i) {
        GvrApi.nativeBufferViewportSetTargetEye(this.nativeBufferViewport, i);
    }

    public int getSourceBufferIndex() {
        return GvrApi.nativeBufferViewportGetSourceBufferIndex(this.nativeBufferViewport);
    }

    public void setSourceBufferIndex(int i) {
        GvrApi.nativeBufferViewportSetSourceBufferIndex(this.nativeBufferViewport, i);
    }

    public int getExternalSurfaceId() {
        return GvrApi.nativeBufferViewportGetExternalSurfaceId(this.nativeBufferViewport);
    }

    public void setExternalSurfaceId(int i) {
        GvrApi.nativeBufferViewportSetExternalSurfaceId(this.nativeBufferViewport, i);
    }

    public void setExternalSurface(ExternalSurface externalSurface) {
        GvrApi.nativeBufferViewportSetExternalSurface(this.nativeBufferViewport, externalSurface != null ? externalSurface.getNativeExternalSurface() : 0);
    }

    public int getReprojection() {
        return GvrApi.nativeBufferViewportGetReprojection(this.nativeBufferViewport);
    }

    public void setReprojection(int i) {
        GvrApi.nativeBufferViewportSetReprojection(this.nativeBufferViewport, i);
    }

    public void setSourceLayer(int i) {
        GvrApi.nativeBufferViewportSetSourceLayer(this.nativeBufferViewport, i);
    }

    public float getOpacity() {
        return GvrApi.nativeBufferViewportGetOpacity(this.nativeBufferViewport);
    }

    public void setOpacity(float f) {
        GvrApi.nativeBufferViewportSetOpacity(this.nativeBufferViewport, f);
    }

    public void getVignetteFraction(PointF pointF) {
        pointF.set(0.04f, 0.04f);
        Log.e(TAG, "getVignetteFraction requires experimental GVR SDK");
    }

    public void setVignetteFraction(PointF pointF) {
        Log.e(TAG, "setVignetteFraction requires experimental GVR SDK");
    }

    public void setEyeFromWorldMatrix(float[] fArr) {
    }

    public void unsetEyeFromWorldMatrix() {
    }
}
