package com.vuforia;

public class DataSet {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DataSet(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DataSet dataSet) {
        if (dataSet == null) {
            return 0;
        }
        return dataSet.swigCPtr;
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
                VuforiaJNI.delete_DataSet(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataSet) || ((DataSet) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static boolean exists(String str, int i) {
        return VuforiaJNI.DataSet_exists(str, i);
    }

    public boolean load(String str, int i) {
        return VuforiaJNI.DataSet_load(this.swigCPtr, this, str, i);
    }

    public TrackableList getTrackables() {
        return new TrackableList(VuforiaJNI.DataSet_getTrackables(this.swigCPtr, this), true);
    }

    public Trackable createTrackable(TrackableSource trackableSource) {
        long DataSet_createTrackable__SWIG_0 = VuforiaJNI.DataSet_createTrackable__SWIG_0(this.swigCPtr, this, TrackableSource.getCPtr(trackableSource), trackableSource);
        if (DataSet_createTrackable__SWIG_0 == 0) {
            return null;
        }
        Trackable trackable = new Trackable(DataSet_createTrackable__SWIG_0, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(DataSet_createTrackable__SWIG_0, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(DataSet_createTrackable__SWIG_0, false);
        }
        return null;
    }

    public Trackable createTrackable(RuntimeImageSource runtimeImageSource) {
        long DataSet_createTrackable__SWIG_1 = VuforiaJNI.DataSet_createTrackable__SWIG_1(this.swigCPtr, this, RuntimeImageSource.getCPtr(runtimeImageSource), runtimeImageSource);
        if (DataSet_createTrackable__SWIG_1 == 0) {
            return null;
        }
        Trackable trackable = new Trackable(DataSet_createTrackable__SWIG_1, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(DataSet_createTrackable__SWIG_1, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(DataSet_createTrackable__SWIG_1, false);
        }
        return null;
    }

    public MultiTarget createMultiTarget(String str) {
        long DataSet_createMultiTarget = VuforiaJNI.DataSet_createMultiTarget(this.swigCPtr, this, str);
        if (DataSet_createMultiTarget == 0) {
            return null;
        }
        return new MultiTarget(DataSet_createMultiTarget, false);
    }

    public boolean destroy(Trackable trackable) {
        return VuforiaJNI.DataSet_destroy(this.swigCPtr, this, Trackable.getCPtr(trackable), trackable);
    }

    public boolean hasReachedTrackableLimit() {
        return VuforiaJNI.DataSet_hasReachedTrackableLimit(this.swigCPtr, this);
    }

    public boolean isActive() {
        return VuforiaJNI.DataSet_isActive(this.swigCPtr, this);
    }
}
