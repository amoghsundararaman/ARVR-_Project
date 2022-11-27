package com.vuforia;

public class Vec3I {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec3I(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Vec3I vec3I) {
        if (vec3I == null) {
            return 0;
        }
        return vec3I.swigCPtr;
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
                VuforiaJNI.delete_Vec3I(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Vec3I) || ((Vec3I) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Vec3I() {
        this(VuforiaJNI.new_Vec3I__SWIG_0(), true);
    }

    public Vec3I(int[] iArr) {
        this(VuforiaJNI.new_Vec3I__SWIG_1(iArr), true);
    }

    public void setData(int[] iArr) {
        VuforiaJNI.Vec3I_data_set(this.swigCPtr, this, iArr);
    }

    public int[] getData() {
        return VuforiaJNI.Vec3I_data_get(this.swigCPtr, this);
    }
}
