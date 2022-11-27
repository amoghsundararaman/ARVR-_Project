package com.google.p000vr.ndk.base;

import android.graphics.Point;
import android.util.Log;

/* renamed from: com.google.vr.ndk.base.Frame */
public class Frame {
    private static final String TAG = Frame.class.getSimpleName();
    private long nativeFrame = 0;

    Frame() {
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nativeFrame != 0) {
                Log.w(TAG, "Frame finalized before it was submitted");
            }
        } finally {
            super.finalize();
        }
    }

    public void bindBuffer(int i) {
        checkAccess();
        GvrApi.nativeFrameBindBuffer(this.nativeFrame, i);
    }

    public void unbind() {
        checkAccess();
        GvrApi.nativeFrameUnbind(this.nativeFrame);
    }

    public int getFramebufferObject(int i) {
        checkAccess();
        return GvrApi.nativeFrameGetFramebufferObject(this.nativeFrame, i);
    }

    public void getBufferSize(int i, Point point) {
        checkAccess();
        GvrApi.nativeFrameGetBufferSize(this.nativeFrame, i, point);
    }

    public void submit(BufferViewportList bufferViewportList, float[] fArr) {
        checkAccess();
        GvrApi.nativeFrameSubmit(this.nativeFrame, bufferViewportList.nativeBufferViewportList, fArr);
        this.nativeFrame = 0;
    }

    /* access modifiers changed from: package-private */
    public void setNativeFrame(long j) {
        this.nativeFrame = j;
    }

    /* access modifiers changed from: package-private */
    public long getNativeFrame() {
        return this.nativeFrame;
    }

    private void checkAccess() {
        if (this.nativeFrame == 0) {
            throw new RuntimeException("Frame was reused after submission");
        }
    }
}
