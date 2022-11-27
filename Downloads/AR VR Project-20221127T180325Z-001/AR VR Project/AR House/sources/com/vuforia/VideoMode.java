package com.vuforia;

public class VideoMode {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VideoMode(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoMode videoMode) {
        if (videoMode == null) {
            return 0;
        }
        return videoMode.swigCPtr;
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
                VuforiaJNI.delete_VideoMode(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VideoMode) || ((VideoMode) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public VideoMode() {
        this(VuforiaJNI.new_VideoMode__SWIG_0(), true);
    }

    public int getWidth() {
        return VuforiaJNI.VideoMode_Width_get(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.VideoMode_Height_get(this.swigCPtr, this);
    }

    public float getFramerate() {
        return VuforiaJNI.VideoMode_Framerate_get(this.swigCPtr, this);
    }

    public void setFormat(int i) {
        VuforiaJNI.VideoMode_Format_set(this.swigCPtr, this, i);
    }

    public int getFormat() {
        return VuforiaJNI.VideoMode_Format_get(this.swigCPtr, this);
    }

    public VideoMode(VideoMode videoMode) {
        this(VuforiaJNI.new_VideoMode__SWIG_1(getCPtr(videoMode), videoMode), true);
    }
}
