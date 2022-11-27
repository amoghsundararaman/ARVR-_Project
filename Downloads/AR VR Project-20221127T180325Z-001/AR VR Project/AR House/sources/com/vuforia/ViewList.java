package com.vuforia;

public class ViewList {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ViewList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ViewList viewList) {
        if (viewList == null) {
            return 0;
        }
        return viewList.swigCPtr;
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
                VuforiaJNI.delete_ViewList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ViewList) || ((ViewList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public long getNumViews() {
        return VuforiaJNI.ViewList_getNumViews(this.swigCPtr, this);
    }

    public int getView(int i) {
        return VuforiaJNI.ViewList_getView(this.swigCPtr, this, i);
    }

    public boolean contains(int i) {
        return VuforiaJNI.ViewList_contains(this.swigCPtr, this, i);
    }
}
