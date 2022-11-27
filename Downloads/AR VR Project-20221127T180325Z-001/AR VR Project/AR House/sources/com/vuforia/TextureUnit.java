package com.vuforia;

public class TextureUnit {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TextureUnit(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TextureUnit textureUnit) {
        if (textureUnit == null) {
            return 0;
        }
        return textureUnit.swigCPtr;
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
        if (!(obj instanceof TextureUnit) || ((TextureUnit) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public int type() {
        return VuforiaJNI.TextureUnit_type(this.swigCPtr, this);
    }
}
