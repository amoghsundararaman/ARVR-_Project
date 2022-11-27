package com.vuforia;

public class Device {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Device(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Device device) {
        if (device == null) {
            return 0;
        }
        return device.swigCPtr;
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
                VuforiaJNI.delete_Device(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Device) || ((Device) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Device getInstance() {
        if (Vuforia.wasInitializedJava()) {
            long Device_getInstance = VuforiaJNI.Device_getInstance();
            if (VuforiaJNI.Device_isOfType(Device_getInstance, (Device) null, Type.getCPtr(EyewearDevice.getClassType()), EyewearDevice.getClassType())) {
                return new EyewearDevice(Device_getInstance, false);
            }
            return new Device(Device_getInstance, false);
        }
        throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Device_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Device_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Device_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public void setConfigurationChanged() {
        VuforiaJNI.Device_setConfigurationChanged(this.swigCPtr, this);
    }

    public RenderingPrimitives getRenderingPrimitives() {
        return new RenderingPrimitives(VuforiaJNI.Device_getRenderingPrimitives(this.swigCPtr, this), true);
    }
}
