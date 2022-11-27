package com.vuforia;

public class Area {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Area(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Area area) {
        if (area == null) {
            return 0;
        }
        return area.swigCPtr;
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
                VuforiaJNI.delete_Area(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Area) || ((Area) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public int getType() {
        return VuforiaJNI.Area_getType(this.swigCPtr, this);
    }

    public static final class TYPE {
        public static final int INVALID = 2;
        public static final int RECTANGLE = 0;
        public static final int RECTANGLE_INT = 1;

        private TYPE() {
        }
    }
}
