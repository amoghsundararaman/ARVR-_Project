package com.vuforia;

public class VirtualButton {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VirtualButton(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButton virtualButton) {
        if (virtualButton == null) {
            return 0;
        }
        return virtualButton.swigCPtr;
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
        if (!(obj instanceof VirtualButton) || ((VirtualButton) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public boolean setArea(Area area) {
        return VuforiaJNI.VirtualButton_setArea(this.swigCPtr, this, Area.getCPtr(area), area);
    }

    public Area getArea() {
        long VirtualButton_getArea = VuforiaJNI.VirtualButton_getArea(this.swigCPtr, this);
        if (VirtualButton_getArea == 0) {
            return null;
        }
        int type = new Area(VirtualButton_getArea, false).getType();
        if (type == 0) {
            return new Rectangle(VirtualButton_getArea, false);
        }
        if (type != 1) {
            return null;
        }
        return new RectangleInt(VirtualButton_getArea, false);
    }

    public boolean setSensitivity(int i) {
        return VuforiaJNI.VirtualButton_setSensitivity(this.swigCPtr, this, i);
    }

    public boolean setEnabled(boolean z) {
        return VuforiaJNI.VirtualButton_setEnabled(this.swigCPtr, this, z);
    }

    public boolean isEnabled() {
        return VuforiaJNI.VirtualButton_isEnabled(this.swigCPtr, this);
    }

    public String getName() {
        return VuforiaJNI.VirtualButton_getName(this.swigCPtr, this);
    }

    public int getID() {
        return VuforiaJNI.VirtualButton_getID(this.swigCPtr, this);
    }

    public static final class SENSITIVITY {
        public static final int HIGH = 0;
        public static final int LOW = 2;
        public static final int MEDIUM = 1;

        private SENSITIVITY() {
        }
    }
}
