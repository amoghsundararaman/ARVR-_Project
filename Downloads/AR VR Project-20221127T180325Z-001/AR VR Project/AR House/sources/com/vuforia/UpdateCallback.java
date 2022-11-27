package com.vuforia;

class UpdateCallback {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected UpdateCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(UpdateCallback updateCallback) {
        if (updateCallback == null) {
            return 0;
        }
        return updateCallback.swigCPtr;
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
                VuforiaJNI.delete_UpdateCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        VuforiaJNI.UpdateCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        VuforiaJNI.UpdateCallback_change_ownership(this, this.swigCPtr, true);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UpdateCallback) || ((UpdateCallback) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public void Vuforia_onUpdate(State state) {
        VuforiaJNI.UpdateCallback_Vuforia_onUpdate(this.swigCPtr, this, State.getCPtr(state), state);
    }

    public UpdateCallback() {
        this(VuforiaJNI.new_UpdateCallback(), true);
        VuforiaJNI.UpdateCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
