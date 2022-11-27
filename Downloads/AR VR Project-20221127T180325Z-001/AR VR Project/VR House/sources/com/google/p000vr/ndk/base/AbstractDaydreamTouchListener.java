package com.google.p000vr.ndk.base;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.cardboard.DisplayUtils;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;

/* renamed from: com.google.vr.ndk.base.AbstractDaydreamTouchListener */
public abstract class AbstractDaydreamTouchListener {
    static final int ANGLE_SAMPLE_TO_LOG = 200;
    static final double MAX_TOUCH_DISTANCE_METERS = 0.015d;
    private int angleSamplesReceived = 0;
    private float borderSizeMeters;
    private double[] currentMarkerBestDists;
    private DisplayMetrics displayMetrics;
    private boolean enabled = true;
    private boolean lastMotionEventInHeadset;
    private float[] lastTranslation = new float[2];
    private final String logTag = getClass().getSimpleName();
    private int[] markerBestTouch;
    private float[][] markersInPixels;
    private int mostTouchesSeen;
    private float[] pixelTranslation = new float[2];
    private float rotation;
    private int[] touchBestMarker;
    private float[] translation = new float[2];
    private boolean useRotationalAlignmentCorrection;
    private float xMetersPerPixel;
    private float yMetersPerPixel;

    /* access modifiers changed from: protected */
    public abstract boolean isDaydreamImageAlignmentEnabled();

    /* access modifiers changed from: protected */
    public abstract void logEvent(int i, C0003Vr.VREvent vREvent);

    /* access modifiers changed from: protected */
    public abstract void setLensOffset(float f, float f2, float f3);

    public void setEnabled(boolean z) {
        this.enabled = z;
        if (!z) {
            resetTrackingState();
        }
    }

    public void getTranslationInScreenSpace(float[] fArr) {
        if (fArr.length < 2) {
            throw new IllegalArgumentException("Translation array too small");
        } else if (this.displayMetrics == null) {
            Log.e(this.logTag, "displayMetrics must be set before calling getTranslationInScreenSpace.");
        } else {
            fArr[0] = this.pixelTranslation[0] / ((float) this.displayMetrics.widthPixels);
            fArr[1] = this.pixelTranslation[1] / ((float) this.displayMetrics.heightPixels);
            fArr[0] = fArr[0] * 2.0f;
            fArr[1] = fArr[1] * -2.0f;
        }
    }

    public Rect getBoundingRect(DisplayMetrics displayMetrics2) {
        if (this.markersInPixels == null || this.markersInPixels.length == 0) {
            Log.e(this.logTag, "No touch markers, so there's no bounding rect.");
            return null;
        }
        double d = MAX_TOUCH_DISTANCE_METERS / ((double) this.xMetersPerPixel);
        double d2 = MAX_TOUCH_DISTANCE_METERS / ((double) this.yMetersPerPixel);
        int i = displayMetrics2.widthPixels;
        int i2 = 0;
        int i3 = displayMetrics2.heightPixels;
        int i4 = 0;
        for (float[] fArr : this.markersInPixels) {
            i = (int) Math.min((double) i, ((double) fArr[0]) - d);
            i2 = (int) Math.max((double) i2, ((double) fArr[0]) + d + 1.0d);
            i3 = (int) Math.min((double) i3, ((double) fArr[1]) - d2);
            i4 = (int) Math.max((double) i4, ((double) fArr[1]) + d2 + 1.0d);
        }
        return new Rect(Math.max(i, 0), Math.max(i3, 0), Math.min(i2, displayMetrics2.widthPixels), Math.min(i4, displayMetrics2.heightPixels));
    }

    /* access modifiers changed from: protected */
    public final boolean handleTouch(MotionEvent motionEvent, float f, float f2) {
        if (!processMotionEvent(motionEvent, f, f2)) {
            return false;
        }
        getTranslationInScreenSpace(this.translation);
        if (!(this.translation[0] == this.lastTranslation[0] && this.translation[1] == this.lastTranslation[1])) {
            this.lastTranslation[0] = this.translation[0];
            this.lastTranslation[1] = this.translation[1];
            setLensOffset(this.translation[0], this.translation[1], this.rotation);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void initWithDisplayParams(DisplayMetrics displayMetrics2, Display.DisplayParams displayParams) {
        this.displayMetrics = displayMetrics2;
        this.borderSizeMeters = DisplayUtils.getBorderSizeMeters(displayParams);
        this.xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(this.displayMetrics.xdpi);
        this.yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(this.displayMetrics.ydpi);
        resetTrackingState();
    }

    /* access modifiers changed from: protected */
    public final void setDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        if (deviceParams == null || deviceParams.daydreamInternal == null || deviceParams.daydreamInternal.alignmentMarkers == null) {
            Log.e(this.logTag, "Null deviceParams or no alignment markers found.");
            this.markersInPixels = null;
        } else if (this.displayMetrics == null) {
            Log.e(this.logTag, "displayMetrics must be set before calling setDeviceParams.");
        } else {
            CardboardDevice.ScreenAlignmentMarker[] screenAlignmentMarkerArr = deviceParams.daydreamInternal.alignmentMarkers;
            this.markersInPixels = new float[screenAlignmentMarkerArr.length][];
            this.currentMarkerBestDists = new double[screenAlignmentMarkerArr.length];
            this.markerBestTouch = new int[screenAlignmentMarkerArr.length];
            for (int i = 0; i < screenAlignmentMarkerArr.length; i++) {
                CardboardDevice.ScreenAlignmentMarker screenAlignmentMarker = screenAlignmentMarkerArr[i];
                this.markersInPixels[i] = new float[2];
                this.markersInPixels[i][0] = ((float) (this.displayMetrics.widthPixels / 2)) + (screenAlignmentMarker.getHorizontal() / this.xMetersPerPixel);
                this.markersInPixels[i][1] = ((float) this.displayMetrics.heightPixels) - (((screenAlignmentMarker.getVertical() + deviceParams.getTrayToLensDistance()) - this.borderSizeMeters) / this.yMetersPerPixel);
            }
            this.useRotationalAlignmentCorrection = deviceParams.daydreamInternal.getUseRotationalAlignmentCorrection();
        }
    }

    /* access modifiers changed from: package-private */
    public void getTranslationInPixels(float[] fArr) {
        if (fArr.length < 2) {
            throw new IllegalArgumentException("Translation array too small");
        }
        fArr[0] = this.pixelTranslation[0];
        fArr[1] = this.pixelTranslation[1];
    }

    /* access modifiers changed from: package-private */
    public boolean viewerNeedsTouchProcessing() {
        return this.enabled && this.markersInPixels != null && this.markersInPixels.length > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean wasLastMotionEventInViewer() {
        return this.lastMotionEventInHeadset;
    }

    /* access modifiers changed from: package-private */
    public boolean processMotionEvent(MotionEvent motionEvent, float f, float f2) {
        if (!viewerNeedsTouchProcessing()) {
            this.lastMotionEventInHeadset = false;
            return false;
        } else if (!isDaydreamImageAlignmentEnabled()) {
            return true;
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount > this.mostTouchesSeen) {
                this.touchBestMarker = new int[pointerCount];
                this.mostTouchesSeen = pointerCount;
            }
            for (int i = 0; i < this.markersInPixels.length; i++) {
                this.markerBestTouch[i] = -1;
                this.currentMarkerBestDists[i] = 2.25E-4d;
            }
            for (int i2 = 0; i2 < pointerCount; i2++) {
                double d = 2.25E-4d;
                this.touchBestMarker[i2] = -1;
                for (int i3 = 0; i3 < this.markersInPixels.length; i3++) {
                    float x = (this.markersInPixels[i3][0] - (motionEvent.getX(i2) + f)) * this.xMetersPerPixel;
                    float y = (this.markersInPixels[i3][1] - (motionEvent.getY(i2) + f2)) * this.yMetersPerPixel;
                    double d2 = (double) ((x * x) + (y * y));
                    if (d2 < d) {
                        this.touchBestMarker[i2] = i3;
                        d = d2;
                    }
                    if (d2 < this.currentMarkerBestDists[i3]) {
                        this.currentMarkerBestDists[i3] = d2;
                        this.markerBestTouch[i3] = i2;
                    }
                }
            }
            float f3 = 0.0f;
            float f4 = 0.0f;
            int i4 = 0;
            for (int i5 = 0; i5 < this.markerBestTouch.length; i5++) {
                if (this.markerBestTouch[i5] != -1) {
                    if (this.touchBestMarker[this.markerBestTouch[i5]] != i5) {
                        this.markerBestTouch[i5] = -1;
                    } else {
                        i4++;
                        f3 += (motionEvent.getX(this.markerBestTouch[i5]) + f) - this.markersInPixels[i5][0];
                        f4 += (motionEvent.getY(this.markerBestTouch[i5]) + f2) - this.markersInPixels[i5][1];
                    }
                }
            }
            if (i4 > 0) {
                this.lastMotionEventInHeadset = true;
                this.pixelTranslation[0] = f3 / ((float) i4);
                this.pixelTranslation[1] = f4 / ((float) i4);
            } else {
                this.lastMotionEventInHeadset = false;
                this.pixelTranslation[0] = 0.0f;
                this.pixelTranslation[1] = 0.0f;
            }
            if (i4 != 2 || !this.useRotationalAlignmentCorrection) {
                this.rotation = 0.0f;
            } else {
                this.rotation = getRotationRadians(motionEvent);
            }
            if (pointerCount > 0) {
                this.angleSamplesReceived++;
                if (this.angleSamplesReceived == 200) {
                    logPhoneAlignment(motionEvent, f, f2);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public float getRotationRadians(MotionEvent motionEvent) {
        if (this.markersInPixels == null || this.markersInPixels.length != 2) {
            Log.e(this.logTag, "No touch markers or the wrong number of touch markers.");
            return 0.0f;
        }
        float atan2 = (float) (Math.atan2((double) (motionEvent.getY(0) - motionEvent.getY(1)), (double) (motionEvent.getX(0) - motionEvent.getX(1))) - Math.atan2((double) (this.markersInPixels[0][1] - this.markersInPixels[1][1]), (double) (this.markersInPixels[0][0] - this.markersInPixels[1][0])));
        if (((double) atan2) > 1.5707963267948966d) {
            atan2 -= 3.1415927f;
        }
        if (((double) atan2) < -1.5707963267948966d) {
            return atan2 + 3.1415927f;
        }
        return atan2;
    }

    private void resetTrackingState() {
        this.lastMotionEventInHeadset = false;
        this.pixelTranslation[0] = 0.0f;
        this.pixelTranslation[1] = 0.0f;
        this.rotation = 0.0f;
        this.mostTouchesSeen = 0;
    }

    private void logPhoneAlignment(MotionEvent motionEvent, float f, float f2) {
        int pointerCount = motionEvent.getPointerCount();
        C0003Vr.VREvent vREvent = new C0003Vr.VREvent();
        vREvent.phoneAlignment = new C0003Vr.VREvent.PhoneAlignment();
        vREvent.phoneAlignment.touchLocations = new C0003Vr.VREvent.Vector2[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            vREvent.phoneAlignment.touchLocations[i] = new C0003Vr.VREvent.Vector2();
            vREvent.phoneAlignment.touchLocations[i].f6x = Float.valueOf(motionEvent.getX(i) + f);
            vREvent.phoneAlignment.touchLocations[i].f7y = Float.valueOf(motionEvent.getY(i) + f2);
        }
        vREvent.phoneAlignment.lensOffset = new C0003Vr.VREvent.Vector2();
        vREvent.phoneAlignment.lensOffset.f6x = Float.valueOf(this.pixelTranslation[0]);
        vREvent.phoneAlignment.lensOffset.f7y = Float.valueOf(this.pixelTranslation[1]);
        if (pointerCount == 2 && this.markersInPixels.length == 2) {
            double degrees = Math.toDegrees((double) getRotationRadians(motionEvent));
            vREvent.phoneAlignment.angleDegrees = Float.valueOf((float) degrees);
            Log.i(this.logTag, new StringBuilder(58).append("Phone angle in headset (degrees): ").append(degrees).toString());
            Log.i(this.logTag, new StringBuilder(49).append("  Touch point 1: ").append(motionEvent.getX(0) + f).append(", ").append(motionEvent.getY(0) + f2).toString());
            Log.i(this.logTag, new StringBuilder(49).append("  Touch point 2: ").append(motionEvent.getX(1) + f).append(", ").append(motionEvent.getY(1) + f2).toString());
        }
        logEvent(2012, vREvent);
    }
}
