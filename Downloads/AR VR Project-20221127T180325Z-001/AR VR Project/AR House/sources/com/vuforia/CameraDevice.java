package com.vuforia;

public class CameraDevice {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected CameraDevice(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CameraDevice cameraDevice) {
        if (cameraDevice == null) {
            return 0;
        }
        return cameraDevice.swigCPtr;
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
                VuforiaJNI.delete_CameraDevice(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CameraDevice) || ((CameraDevice) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static CameraDevice getInstance() {
        if (Vuforia.wasInitializedJava()) {
            return new CameraDevice(VuforiaJNI.CameraDevice_getInstance(), false);
        }
        throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
    }

    public boolean init() {
        return VuforiaJNI.CameraDevice_init(this.swigCPtr, this);
    }

    public boolean deinit() {
        return VuforiaJNI.CameraDevice_deinit(this.swigCPtr, this);
    }

    public boolean start() {
        return VuforiaJNI.CameraDevice_start(this.swigCPtr, this);
    }

    public boolean stop() {
        return VuforiaJNI.CameraDevice_stop(this.swigCPtr, this);
    }

    public int getNumVideoModes() {
        return VuforiaJNI.CameraDevice_getNumVideoModes(this.swigCPtr, this);
    }

    public VideoMode getVideoMode(int i) {
        return new VideoMode(VuforiaJNI.CameraDevice_getVideoMode(this.swigCPtr, this, i), true);
    }

    public VideoMode getCurrentVideoMode() {
        return new VideoMode(VuforiaJNI.CameraDevice_getCurrentVideoMode(this.swigCPtr, this), true);
    }

    public boolean selectVideoMode(int i) {
        return VuforiaJNI.CameraDevice_selectVideoMode(this.swigCPtr, this, i);
    }

    public boolean setFlashTorchMode(boolean z) {
        return VuforiaJNI.CameraDevice_setFlashTorchMode(this.swigCPtr, this, z);
    }

    public boolean setFocusMode(int i) {
        return VuforiaJNI.CameraDevice_setFocusMode(this.swigCPtr, this, i);
    }

    public int getNumFields() {
        return VuforiaJNI.CameraDevice_getNumFields(this.swigCPtr, this);
    }

    public boolean getCameraField(int i, CameraField cameraField) {
        return VuforiaJNI.CameraDevice_getCameraField(this.swigCPtr, this, i, CameraField.getCPtr(cameraField), cameraField);
    }

    public boolean getFieldInt64(String str, long[] jArr) {
        return VuforiaJNI.CameraDevice_getFieldInt64(this.swigCPtr, this, str, jArr);
    }

    public boolean getFieldFloat(String str, float[] fArr) {
        return VuforiaJNI.CameraDevice_getFieldFloat(this.swigCPtr, this, str, fArr);
    }

    public boolean getFieldBool(String str, boolean[] zArr) {
        return VuforiaJNI.CameraDevice_getFieldBool(this.swigCPtr, this, str, zArr);
    }

    public boolean getFieldInt64Range(String str, long[] jArr) {
        return VuforiaJNI.CameraDevice_getFieldInt64Range(this.swigCPtr, this, str, jArr);
    }

    public boolean setField(String str, String str2) {
        return VuforiaJNI.CameraDevice_setField__SWIG_0(this.swigCPtr, this, str, str2);
    }

    public boolean setField(String str, long j) {
        return VuforiaJNI.CameraDevice_setField__SWIG_1(this.swigCPtr, this, str, j);
    }

    public boolean setField(String str, float f) {
        return VuforiaJNI.CameraDevice_setField__SWIG_2(this.swigCPtr, this, str, f);
    }

    public boolean setField(String str, boolean z) {
        return VuforiaJNI.CameraDevice_setField__SWIG_3(this.swigCPtr, this, str, z);
    }

    public String getFieldString(String str) {
        return VuforiaJNI.CameraDevice_getFieldString(this.swigCPtr, this, str);
    }

    public boolean setField(String str, long j, long j2) {
        return VuforiaJNI.CameraDevice_setField__SWIG_4(this.swigCPtr, this, str, j, j2);
    }

    public static final class MODE {
        public static final int MODE_DEFAULT = -1;
        public static final int MODE_OPTIMIZE_QUALITY = -3;
        public static final int MODE_OPTIMIZE_SPEED = -2;

        private MODE() {
        }
    }

    public static final class FOCUS_MODE {
        public static final int FOCUS_MODE_CONTINUOUSAUTO = 2;
        public static final int FOCUS_MODE_INFINITY = 3;
        public static final int FOCUS_MODE_MACRO = 4;
        public static final int FOCUS_MODE_NORMAL = 0;
        public static final int FOCUS_MODE_TRIGGERAUTO = 1;

        private FOCUS_MODE() {
        }
    }
}
