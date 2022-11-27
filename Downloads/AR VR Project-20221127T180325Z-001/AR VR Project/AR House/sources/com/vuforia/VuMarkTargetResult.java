package com.vuforia;

public class VuMarkTargetResult extends ObjectTargetResult {
    private long swigCPtr;

    protected VuMarkTargetResult(long j, boolean z) {
        super(VuforiaJNI.VuMarkTargetResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(VuMarkTargetResult vuMarkTargetResult) {
        if (vuMarkTargetResult == null) {
            return 0;
        }
        return vuMarkTargetResult.swigCPtr;
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
                VuforiaJNI.delete_VuMarkTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VuMarkTargetResult) || ((VuMarkTargetResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTargetResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new VuMarkTarget(VuforiaJNI.VuMarkTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getId() {
        return VuforiaJNI.VuMarkTargetResult_getId(this.swigCPtr, this);
    }
}
