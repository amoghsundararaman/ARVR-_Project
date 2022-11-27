package com.vuforia;

public class TargetFinderQueryResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TargetFinderQueryResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetFinderQueryResult targetFinderQueryResult) {
        if (targetFinderQueryResult == null) {
            return 0;
        }
        return targetFinderQueryResult.swigCPtr;
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
                VuforiaJNI.delete_TargetFinderQueryResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TargetFinderQueryResult) || ((TargetFinderQueryResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public void setStatus(int i) {
        VuforiaJNI.TargetFinderQueryResult_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return VuforiaJNI.TargetFinderQueryResult_status_get(this.swigCPtr, this);
    }

    public void setResults(TargetSearchResultList targetSearchResultList) {
        VuforiaJNI.TargetFinderQueryResult_results_set(this.swigCPtr, this, TargetSearchResultList.getCPtr(targetSearchResultList), targetSearchResultList);
    }

    public TargetSearchResultList getResults() {
        long TargetFinderQueryResult_results_get = VuforiaJNI.TargetFinderQueryResult_results_get(this.swigCPtr, this);
        if (TargetFinderQueryResult_results_get == 0) {
            return null;
        }
        return new TargetSearchResultList(TargetFinderQueryResult_results_get, false);
    }
}
