package com.vuforia;

public class ModelTargetResult extends ObjectTargetResult {
    private long swigCPtr;

    protected ModelTargetResult(long j, boolean z) {
        super(VuforiaJNI.ModelTargetResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ModelTargetResult modelTargetResult) {
        if (modelTargetResult == null) {
            return 0;
        }
        return modelTargetResult.swigCPtr;
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
                VuforiaJNI.delete_ModelTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ModelTargetResult) || ((ModelTargetResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ModelTargetResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new ModelTarget(VuforiaJNI.ModelTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}
