package com.vuforia;

public class HitTestResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected HitTestResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(HitTestResult hitTestResult) {
        if (hitTestResult == null) {
            return 0;
        }
        return hitTestResult.swigCPtr;
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
                VuforiaJNI.delete_HitTestResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HitTestResult) || ((HitTestResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Matrix34F getPose() {
        return new Matrix34F(VuforiaJNI.HitTestResult_getPose(this.swigCPtr, this), true);
    }
}
