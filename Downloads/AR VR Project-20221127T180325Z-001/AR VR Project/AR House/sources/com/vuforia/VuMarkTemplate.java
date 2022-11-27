package com.vuforia;

public class VuMarkTemplate extends ObjectTarget {
    private long swigCPtr;

    protected VuMarkTemplate(long j, boolean z) {
        super(VuforiaJNI.VuMarkTemplate_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(VuMarkTemplate vuMarkTemplate) {
        if (vuMarkTemplate == null) {
            return 0;
        }
        return vuMarkTemplate.swigCPtr;
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
                VuforiaJNI.delete_VuMarkTemplate(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VuMarkTemplate) || ((VuMarkTemplate) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTemplate_getClassType(), true);
    }

    public String getVuMarkUserData() {
        return VuforiaJNI.VuMarkTemplate_getVuMarkUserData(this.swigCPtr, this);
    }

    public void setTrackingFromRuntimeAppearance(boolean z) {
        VuforiaJNI.VuMarkTemplate_setTrackingFromRuntimeAppearance(this.swigCPtr, this, z);
    }

    public boolean isTrackingFromRuntimeAppearanceEnabled() {
        return VuforiaJNI.VuMarkTemplate_isTrackingFromRuntimeAppearanceEnabled(this.swigCPtr, this);
    }

    public Vec2F getOrigin() {
        return new Vec2F(VuforiaJNI.VuMarkTemplate_getOrigin(this.swigCPtr, this), true);
    }
}
