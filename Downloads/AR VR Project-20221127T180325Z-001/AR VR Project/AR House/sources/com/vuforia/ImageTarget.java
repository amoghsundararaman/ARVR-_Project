package com.vuforia;

public class ImageTarget extends ObjectTarget {
    private long swigCPtr;

    protected ImageTarget(long j, boolean z) {
        super(VuforiaJNI.ImageTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageTarget imageTarget) {
        if (imageTarget == null) {
            return 0;
        }
        return imageTarget.swigCPtr;
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
                VuforiaJNI.delete_ImageTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageTarget) || ((ImageTarget) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTarget_getClassType(), true);
    }

    public VirtualButtonList getVirtualButtons() {
        return new VirtualButtonList(VuforiaJNI.ImageTarget_getVirtualButtons(this.swigCPtr, this), true);
    }

    public VirtualButton getVirtualButton(String str) {
        long ImageTarget_getVirtualButton = VuforiaJNI.ImageTarget_getVirtualButton(this.swigCPtr, this, str);
        if (ImageTarget_getVirtualButton == 0) {
            return null;
        }
        return new VirtualButton(ImageTarget_getVirtualButton, false);
    }

    public VirtualButton createVirtualButton(String str, Area area) {
        long ImageTarget_createVirtualButton = VuforiaJNI.ImageTarget_createVirtualButton(this.swigCPtr, this, str, Area.getCPtr(area), area);
        if (ImageTarget_createVirtualButton == 0) {
            return null;
        }
        return new VirtualButton(ImageTarget_createVirtualButton, false);
    }

    public boolean destroyVirtualButton(VirtualButton virtualButton) {
        return VuforiaJNI.ImageTarget_destroyVirtualButton(this.swigCPtr, this, VirtualButton.getCPtr(virtualButton), virtualButton);
    }

    public String getMetaData() {
        return VuforiaJNI.ImageTarget_getMetaData(this.swigCPtr, this);
    }
}
