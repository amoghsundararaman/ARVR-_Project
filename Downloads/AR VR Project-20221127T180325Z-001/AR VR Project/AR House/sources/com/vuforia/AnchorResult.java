package com.vuforia;

public class AnchorResult extends TrackableResult {
    private long swigCPtr;

    protected AnchorResult(long j, boolean z) {
        super(VuforiaJNI.AnchorResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AnchorResult anchorResult) {
        if (anchorResult == null) {
            return 0;
        }
        return anchorResult.swigCPtr;
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
                VuforiaJNI.delete_AnchorResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnchorResult) || ((AnchorResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.AnchorResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new Anchor(VuforiaJNI.AnchorResult_getTrackable(this.swigCPtr, this), false);
    }
}
