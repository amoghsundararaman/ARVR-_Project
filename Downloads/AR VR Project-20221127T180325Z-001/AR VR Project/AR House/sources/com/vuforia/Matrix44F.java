package com.vuforia;

public class Matrix44F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Matrix44F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Matrix44F matrix44F) {
        if (matrix44F == null) {
            return 0;
        }
        return matrix44F.swigCPtr;
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
                VuforiaJNI.delete_Matrix44F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix44F) || ((Matrix44F) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public void setData(float[] fArr) {
        VuforiaJNI.Matrix44F_data_set(this.swigCPtr, this, fArr);
    }

    public float[] getData() {
        return VuforiaJNI.Matrix44F_data_get(this.swigCPtr, this);
    }

    public Matrix44F() {
        this(VuforiaJNI.new_Matrix44F__SWIG_0(), true);
    }

    public Matrix44F(Matrix44F matrix44F) {
        this(VuforiaJNI.new_Matrix44F__SWIG_1(getCPtr(matrix44F), matrix44F), true);
    }
}
