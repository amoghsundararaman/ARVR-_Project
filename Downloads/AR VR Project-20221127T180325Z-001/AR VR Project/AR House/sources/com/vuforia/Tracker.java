package com.vuforia;

public class Tracker {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Tracker(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Tracker tracker) {
        if (tracker == null) {
            return 0;
        }
        return tracker.swigCPtr;
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
                VuforiaJNI.delete_Tracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Tracker) || ((Tracker) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Tracker_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Tracker_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Tracker_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public boolean start() {
        return VuforiaJNI.Tracker_start(this.swigCPtr, this);
    }

    public void stop() {
        VuforiaJNI.Tracker_stop(this.swigCPtr, this);
    }
}
