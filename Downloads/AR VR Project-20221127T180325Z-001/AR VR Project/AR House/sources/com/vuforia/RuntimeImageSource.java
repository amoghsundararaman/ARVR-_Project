package com.vuforia;

import java.nio.ByteBuffer;

public class RuntimeImageSource {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected RuntimeImageSource(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RuntimeImageSource runtimeImageSource) {
        if (runtimeImageSource == null) {
            return 0;
        }
        return runtimeImageSource.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    /* access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RuntimeImageSource(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RuntimeImageSource) || ((RuntimeImageSource) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public boolean setImage(ByteBuffer byteBuffer, int i, Vec2I vec2I, float f, String str) {
        return VuforiaJNI.RuntimeImageSource_setImage(this.swigCPtr, this, byteBuffer, i, Vec2I.getCPtr(vec2I), vec2I, f, str);
    }

    public boolean setFile(String str, int i, float f, String str2) {
        return VuforiaJNI.RuntimeImageSource_setFile(this.swigCPtr, this, str, i, f, str2);
    }
}
