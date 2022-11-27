package com.vuforia;

import java.nio.ByteBuffer;

public class Image {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Image(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Image image) {
        if (image == null) {
            return 0;
        }
        return image.swigCPtr;
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
        if (!(obj instanceof Image) || ((Image) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public int getWidth() {
        return VuforiaJNI.Image_getWidth(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.Image_getHeight(this.swigCPtr, this);
    }

    public int getStride() {
        return VuforiaJNI.Image_getStride(this.swigCPtr, this);
    }

    public int getBufferWidth() {
        return VuforiaJNI.Image_getBufferWidth(this.swigCPtr, this);
    }

    public int getBufferHeight() {
        return VuforiaJNI.Image_getBufferHeight(this.swigCPtr, this);
    }

    public int getFormat() {
        return VuforiaJNI.Image_getFormat(this.swigCPtr, this);
    }

    public ByteBuffer getPixels() {
        return VuforiaJNI.Image_getPixels(this.swigCPtr, this);
    }
}
