package com.vuforia;

public class Type {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Type(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Type type) {
        if (type == null) {
            return 0;
        }
        return type.swigCPtr;
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
                VuforiaJNI.delete_Type(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Type) || ((Type) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Type() {
        this(VuforiaJNI.new_Type__SWIG_0(), true);
    }

    public Type(short s) {
        this(VuforiaJNI.new_Type__SWIG_1(s), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Type_isOfType(this.swigCPtr, this, getCPtr(type), type);
    }
}
