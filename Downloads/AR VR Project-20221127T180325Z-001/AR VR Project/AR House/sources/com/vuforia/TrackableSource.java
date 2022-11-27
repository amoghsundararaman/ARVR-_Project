package com.vuforia;

public class TrackableSource {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TrackableSource(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrackableSource trackableSource) {
        if (trackableSource == null) {
            return 0;
        }
        return trackableSource.swigCPtr;
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
                VuforiaJNI.delete_TrackableSource(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TrackableSource) || ((TrackableSource) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public TrackableSource() {
        this(VuforiaJNI.new_TrackableSource(), true);
    }
}
