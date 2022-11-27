package com.vuforia;

public class MultiTargetResult extends ObjectTargetResult {
    private long swigCPtr;

    protected MultiTargetResult(long j, boolean z) {
        super(VuforiaJNI.MultiTargetResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(MultiTargetResult multiTargetResult) {
        if (multiTargetResult == null) {
            return 0;
        }
        return multiTargetResult.swigCPtr;
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
                VuforiaJNI.delete_MultiTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MultiTargetResult) || ((MultiTargetResult) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTargetResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new MultiTarget(VuforiaJNI.MultiTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public TrackableResult getPartResult(String str) {
        long MultiTargetResult_getPartResult = VuforiaJNI.MultiTargetResult_getPartResult(this.swigCPtr, this, str);
        if (MultiTargetResult_getPartResult == 0) {
            return null;
        }
        TrackableResult trackableResult = new TrackableResult(MultiTargetResult_getPartResult, false);
        if (trackableResult.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(getClassType())) {
            return new MultiTargetResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(ModelTargetResult.getClassType())) {
            return new ModelTargetResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(AnchorResult.getClassType())) {
            return new AnchorResult(MultiTargetResult_getPartResult, false);
        }
        if (trackableResult.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(MultiTargetResult_getPartResult, false);
        }
        return null;
    }

    public TrackableResultList getPartResults() {
        return new TrackableResultList(VuforiaJNI.MultiTargetResult_getPartResults(this.swigCPtr, this), true);
    }
}
