package com.vuforia;

public class VideoBackgroundTextureInfo {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VideoBackgroundTextureInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoBackgroundTextureInfo videoBackgroundTextureInfo) {
        if (videoBackgroundTextureInfo == null) {
            return 0;
        }
        return videoBackgroundTextureInfo.swigCPtr;
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
                VuforiaJNI.delete_VideoBackgroundTextureInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VideoBackgroundTextureInfo) || ((VideoBackgroundTextureInfo) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Vec2I getTextureSize() {
        long VideoBackgroundTextureInfo_TextureSize_get = VuforiaJNI.VideoBackgroundTextureInfo_TextureSize_get(this.swigCPtr, this);
        if (VideoBackgroundTextureInfo_TextureSize_get == 0) {
            return null;
        }
        return new Vec2I(VideoBackgroundTextureInfo_TextureSize_get, false);
    }

    public Vec2I getImageSize() {
        long VideoBackgroundTextureInfo_ImageSize_get = VuforiaJNI.VideoBackgroundTextureInfo_ImageSize_get(this.swigCPtr, this);
        if (VideoBackgroundTextureInfo_ImageSize_get == 0) {
            return null;
        }
        return new Vec2I(VideoBackgroundTextureInfo_ImageSize_get, false);
    }

    public int getPixelFormat() {
        return VuforiaJNI.VideoBackgroundTextureInfo_PixelFormat_get(this.swigCPtr, this);
    }

    public VideoBackgroundTextureInfo() {
        this(VuforiaJNI.new_VideoBackgroundTextureInfo(), true);
    }
}
