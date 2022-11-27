package com.vuforia;

public class NonCopyable {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected NonCopyable(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NonCopyable nonCopyable) {
        if (nonCopyable == null) {
            return 0;
        }
        return nonCopyable.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NonCopyable) || ((NonCopyable) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }
}
