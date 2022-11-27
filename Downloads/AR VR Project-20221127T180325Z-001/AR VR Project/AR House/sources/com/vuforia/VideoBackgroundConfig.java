package com.vuforia;

public class VideoBackgroundConfig {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VideoBackgroundConfig(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoBackgroundConfig videoBackgroundConfig) {
        if (videoBackgroundConfig == null) {
            return 0;
        }
        return videoBackgroundConfig.swigCPtr;
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
                VuforiaJNI.delete_VideoBackgroundConfig(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VideoBackgroundConfig) || ((VideoBackgroundConfig) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public VideoBackgroundConfig() {
        this(VuforiaJNI.new_VideoBackgroundConfig(), true);
    }

    public void setPosition(Vec2I vec2I) {
        VuforiaJNI.VideoBackgroundConfig_Position_set(this.swigCPtr, this, Vec2I.getCPtr(vec2I), vec2I);
    }

    public Vec2I getPosition() {
        long VideoBackgroundConfig_Position_get = VuforiaJNI.VideoBackgroundConfig_Position_get(this.swigCPtr, this);
        if (VideoBackgroundConfig_Position_get == 0) {
            return null;
        }
        return new Vec2I(VideoBackgroundConfig_Position_get, false);
    }

    public void setSize(Vec2I vec2I) {
        VuforiaJNI.VideoBackgroundConfig_Size_set(this.swigCPtr, this, Vec2I.getCPtr(vec2I), vec2I);
    }

    public Vec2I getSize() {
        long VideoBackgroundConfig_Size_get = VuforiaJNI.VideoBackgroundConfig_Size_get(this.swigCPtr, this);
        if (VideoBackgroundConfig_Size_get == 0) {
            return null;
        }
        return new Vec2I(VideoBackgroundConfig_Size_get, false);
    }
}
