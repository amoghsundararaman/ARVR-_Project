package com.vuforia;

public class Illumination {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Illumination(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Illumination illumination) {
        if (illumination == null) {
            return 0;
        }
        return illumination.swigCPtr;
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
                VuforiaJNI.delete_Illumination(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Illumination) || ((Illumination) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static float getAMBIENT_INTENSITY_UNAVAILABLE() {
        return VuforiaJNI.Illumination_AMBIENT_INTENSITY_UNAVAILABLE_get();
    }

    public static float getAMBIENT_COLOR_TEMPERATURE_UNAVAILABLE() {
        return VuforiaJNI.Illumination_AMBIENT_COLOR_TEMPERATURE_UNAVAILABLE_get();
    }

    public float getAmbientIntensity() {
        return VuforiaJNI.Illumination_getAmbientIntensity(this.swigCPtr, this);
    }

    public float getAmbientColorTemperature() {
        return VuforiaJNI.Illumination_getAmbientColorTemperature(this.swigCPtr, this);
    }

    public float getIntensityCorrection() {
        return VuforiaJNI.Illumination_getIntensityCorrection(this.swigCPtr, this);
    }

    public Vec4F getColorCorrection() {
        return new Vec4F(VuforiaJNI.Illumination_getColorCorrection(this.swigCPtr, this), true);
    }
}
