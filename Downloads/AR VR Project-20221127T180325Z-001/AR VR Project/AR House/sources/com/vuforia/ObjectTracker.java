package com.vuforia;

public class ObjectTracker extends Tracker {
    private long swigCPtr;

    public static final class TargetFinderType {
        public static final int CLOUD_RECO = 0;
    }

    protected ObjectTracker(long j, boolean z) {
        super(VuforiaJNI.ObjectTracker_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ObjectTracker objectTracker) {
        if (objectTracker == null) {
            return 0;
        }
        return objectTracker.swigCPtr;
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
                VuforiaJNI.delete_ObjectTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectTracker) || ((ObjectTracker) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTracker_getClassType(), true);
    }

    public DataSet createDataSet() {
        long ObjectTracker_createDataSet = VuforiaJNI.ObjectTracker_createDataSet(this.swigCPtr, this);
        if (ObjectTracker_createDataSet == 0) {
            return null;
        }
        return new DataSet(ObjectTracker_createDataSet, false);
    }

    public boolean destroyDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_destroyDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public boolean activateDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_activateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public boolean deactivateDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_deactivateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public DataSetList getActiveDataSets() {
        return new DataSetList(VuforiaJNI.ObjectTracker_getActiveDataSets(this.swigCPtr, this), true);
    }

    public ImageTargetBuilder getImageTargetBuilder() {
        long ObjectTracker_getImageTargetBuilder = VuforiaJNI.ObjectTracker_getImageTargetBuilder(this.swigCPtr, this);
        if (ObjectTracker_getImageTargetBuilder == 0) {
            return null;
        }
        return new ImageTargetBuilder(ObjectTracker_getImageTargetBuilder, false);
    }

    public RuntimeImageSource getRuntimeImageSource() {
        long ObjectTracker_getRuntimeImageSource = VuforiaJNI.ObjectTracker_getRuntimeImageSource(this.swigCPtr, this);
        if (ObjectTracker_getRuntimeImageSource == 0) {
            return null;
        }
        return new RuntimeImageSource(ObjectTracker_getRuntimeImageSource, false);
    }

    public TargetFinder getTargetFinder(int i) {
        long ObjectTracker_getTargetFinder__SWIG_0 = VuforiaJNI.ObjectTracker_getTargetFinder__SWIG_0(this.swigCPtr, this, i);
        if (ObjectTracker_getTargetFinder__SWIG_0 == 0) {
            return null;
        }
        return new TargetFinder(ObjectTracker_getTargetFinder__SWIG_0, false);
    }

    public TargetFinder getTargetFinder() {
        long ObjectTracker_getTargetFinder__SWIG_1 = VuforiaJNI.ObjectTracker_getTargetFinder__SWIG_1(this.swigCPtr, this);
        if (ObjectTracker_getTargetFinder__SWIG_1 == 0) {
            return null;
        }
        return new TargetFinder(ObjectTracker_getTargetFinder__SWIG_1, false);
    }
}
