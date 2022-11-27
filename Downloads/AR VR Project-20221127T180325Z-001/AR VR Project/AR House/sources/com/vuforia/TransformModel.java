package com.vuforia;

public class TransformModel {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class TYPE {
        public static final int TRANSFORM_MODEL_HANDHELD = 1;
        public static final int TRANSFORM_MODEL_HEAD = 0;
    }

    protected TransformModel(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TransformModel transformModel) {
        if (transformModel == null) {
            return 0;
        }
        return transformModel.swigCPtr;
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
                VuforiaJNI.delete_TransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransformModel) || ((TransformModel) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public int getType() {
        return VuforiaJNI.TransformModel_getType(this.swigCPtr, this);
    }
}
