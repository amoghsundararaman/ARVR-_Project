package com.vuforia;

public class CylinderTargetResult extends ObjectTargetResult {
    private long swigCPtr;

    protected CylinderTargetResult(long j, boolean z) {
        super(VuforiaJNI.CylinderTargetResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(CylinderTargetResult cylinderTargetResult) {
        if (cylinderTargetResult == null) {
            return 0;
        }
        return cylinderTargetResult.swigCPtr;
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
                VuforiaJNI.delete_CylinderTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CylinderTargetResult) || ((CylinderTargetResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTargetResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new CylinderTarget(VuforiaJNI.CylinderTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}
