package com.vuforia;

public class TargetSearchResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TargetSearchResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetSearchResult targetSearchResult) {
        if (targetSearchResult == null) {
            return 0;
        }
        return targetSearchResult.swigCPtr;
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
                VuforiaJNI.delete_TargetSearchResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TargetSearchResult) || ((TargetSearchResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.TargetSearchResult_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.TargetSearchResult_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.TargetSearchResult_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public String getTargetName() {
        return VuforiaJNI.TargetSearchResult_getTargetName(this.swigCPtr, this);
    }

    public String getUniqueTargetId() {
        return VuforiaJNI.TargetSearchResult_getUniqueTargetId(this.swigCPtr, this);
    }
}
