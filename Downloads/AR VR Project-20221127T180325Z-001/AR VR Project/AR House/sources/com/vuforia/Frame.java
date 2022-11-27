package com.vuforia;

public class Frame implements Cloneable {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Frame(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Frame frame) {
        if (frame == null) {
            return 0;
        }
        return frame.swigCPtr;
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
                VuforiaJNI.delete_Frame(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public Frame clone() {
        return new Frame(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Frame) || ((Frame) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Frame() {
        this(VuforiaJNI.new_Frame__SWIG_0(), true);
    }

    public Frame(Frame frame) {
        this(VuforiaJNI.new_Frame__SWIG_1(getCPtr(frame), frame), true);
    }

    public double getTimeStamp() {
        return VuforiaJNI.Frame_getTimeStamp(this.swigCPtr, this);
    }

    public int getIndex() {
        return VuforiaJNI.Frame_getIndex(this.swigCPtr, this);
    }

    public ImageList getImages() {
        return new ImageList(VuforiaJNI.Frame_getImages(this.swigCPtr, this), true);
    }
}
