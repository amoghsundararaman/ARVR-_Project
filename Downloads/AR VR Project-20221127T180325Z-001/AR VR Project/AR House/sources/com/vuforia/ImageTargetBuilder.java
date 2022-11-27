package com.vuforia;

public class ImageTargetBuilder {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ImageTargetBuilder(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageTargetBuilder imageTargetBuilder) {
        if (imageTargetBuilder == null) {
            return 0;
        }
        return imageTargetBuilder.swigCPtr;
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
        if (!(obj instanceof ImageTargetBuilder) || ((ImageTargetBuilder) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public boolean build(String str, float f) {
        return VuforiaJNI.ImageTargetBuilder_build(this.swigCPtr, this, str, f);
    }

    public void startScan() {
        VuforiaJNI.ImageTargetBuilder_startScan(this.swigCPtr, this);
    }

    public void stopScan() {
        VuforiaJNI.ImageTargetBuilder_stopScan(this.swigCPtr, this);
    }

    public int getFrameQuality() {
        return VuforiaJNI.ImageTargetBuilder_getFrameQuality(this.swigCPtr, this);
    }

    public TrackableSource getTrackableSource() {
        long ImageTargetBuilder_getTrackableSource = VuforiaJNI.ImageTargetBuilder_getTrackableSource(this.swigCPtr, this);
        if (ImageTargetBuilder_getTrackableSource == 0) {
            return null;
        }
        return new TrackableSource(ImageTargetBuilder_getTrackableSource, false);
    }

    public static final class FRAME_QUALITY {
        public static final int FRAME_QUALITY_HIGH = 2;
        public static final int FRAME_QUALITY_LOW = 0;
        public static final int FRAME_QUALITY_MEDIUM = 1;
        public static final int FRAME_QUALITY_NONE = -1;

        private FRAME_QUALITY() {
        }
    }
}
