package com.vuforia;

public class ModelTarget extends ObjectTarget {
    private long swigCPtr;

    protected ModelTarget(long j, boolean z) {
        super(VuforiaJNI.ModelTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ModelTarget modelTarget) {
        if (modelTarget == null) {
            return 0;
        }
        return modelTarget.swigCPtr;
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
                VuforiaJNI.delete_ModelTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ModelTarget) || ((ModelTarget) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ModelTarget_getClassType(), true);
    }

    public Obb3D getBoundingBox() {
        return new Obb3D(VuforiaJNI.ModelTarget_getBoundingBox(this.swigCPtr, this), false);
    }

    public GuideViewList getGuideViews() {
        return new GuideViewList(VuforiaJNI.ModelTarget_getGuideViews(this.swigCPtr, this), true);
    }

    public boolean setActiveGuideViewIndex(int i) {
        return VuforiaJNI.ModelTarget_setActiveGuideViewIndex(this.swigCPtr, this, i);
    }

    public int getActiveGuideViewIndex() {
        return VuforiaJNI.ModelTarget_getActiveGuideViewIndex(this.swigCPtr, this);
    }
}
