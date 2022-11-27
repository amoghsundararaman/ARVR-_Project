package com.vuforia;

public class CloudRecoSearchResult extends TargetSearchResult {
    private long swigCPtr;

    protected CloudRecoSearchResult(long j, boolean z) {
        super(VuforiaJNI.CloudRecoSearchResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(CloudRecoSearchResult cloudRecoSearchResult) {
        if (cloudRecoSearchResult == null) {
            return 0;
        }
        return cloudRecoSearchResult.swigCPtr;
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
                VuforiaJNI.delete_CloudRecoSearchResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CloudRecoSearchResult) || ((CloudRecoSearchResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CloudRecoSearchResult_getClassType(), true);
    }

    public float getTargetSize() {
        return VuforiaJNI.CloudRecoSearchResult_getTargetSize(this.swigCPtr, this);
    }

    public String getMetaData() {
        return VuforiaJNI.CloudRecoSearchResult_getMetaData(this.swigCPtr, this);
    }

    public short getTrackingRating() {
        return VuforiaJNI.CloudRecoSearchResult_getTrackingRating(this.swigCPtr, this);
    }
}
