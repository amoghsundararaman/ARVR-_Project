package com.vuforia;

public class DeviceTracker extends Tracker {
    private long swigCPtr;

    protected DeviceTracker(long j, boolean z) {
        super(VuforiaJNI.DeviceTracker_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DeviceTracker deviceTracker) {
        if (deviceTracker == null) {
            return 0;
        }
        return deviceTracker.swigCPtr;
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
                VuforiaJNI.delete_DeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeviceTracker) || ((DeviceTracker) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTracker_getClassType(), true);
    }
}
