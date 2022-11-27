package com.vuforia;

public class TextureData {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TextureData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TextureData textureData) {
        if (textureData == null) {
            return 0;
        }
        return textureData.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TextureData) || ((TextureData) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public int type() {
        return VuforiaJNI.TextureData_type(this.swigCPtr, this);
    }
}
