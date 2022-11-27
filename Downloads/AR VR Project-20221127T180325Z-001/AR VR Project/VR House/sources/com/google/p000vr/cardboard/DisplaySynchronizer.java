package com.google.p000vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.vr.cardboard.DisplaySynchronizer */
public class DisplaySynchronizer implements Choreographer.FrameCallback {
    private static final boolean DEBUG = false;
    public static final long DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS = TimeUnit.SECONDS.toNanos(1);
    private static final int INVALID_DISPLAY_ROTATION = -1;
    private static final float MIN_VALID_DISPLAY_REFRESH_RATE = 30.0f;
    private static final String TAG = "DisplaySynchronizer";
    private volatile Display display;
    private DisplayMetrics displayMetrics;
    private volatile int displayRotationDegrees = -1;
    private FrameMonitor frameMonitor;
    private long lastDisplayRotationUpdateTimeNanos = 0;
    private volatile long nativeDisplaySynchronizer;

    public DisplaySynchronizer(Context context, Display display2) {
        this.nativeDisplaySynchronizer = nativeCreate(getClass().getClassLoader(), context.getApplicationContext());
        if (this.nativeDisplaySynchronizer == 0) {
            throw new IllegalStateException("Native DisplaySynchronizer creation failed, implementation unavailable.");
        }
        setDisplay(display2);
        this.frameMonitor = new FrameMonitor(this);
        this.frameMonitor.init();
    }

    /* access modifiers changed from: protected */
    public native long nativeCreate(ClassLoader classLoader, Context context);

    /* access modifiers changed from: protected */
    public native void nativeDestroy(long j);

    /* access modifiers changed from: protected */
    public native void nativeOnMetricsChanged(long j);

    /* access modifiers changed from: protected */
    public native void nativeReset(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeUpdate(long j, long j2, int i);

    public void disableFrameMonitor() {
        if (this.frameMonitor != null) {
            this.frameMonitor.shutdown();
            this.frameMonitor = null;
        }
    }

    public void setDisplay(Display display2) {
        long j;
        long j2;
        checkNativeDisplaySynchronizer();
        this.display = display2;
        invalidateDisplayProperties();
        float refreshRate = display2.getRefreshRate();
        if (refreshRate >= MIN_VALID_DISPLAY_REFRESH_RATE) {
            j = (long) (((float) TimeUnit.SECONDS.toNanos(1)) / refreshRate);
        } else {
            j = 0;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            j2 = display2.getAppVsyncOffsetNanos();
        } else {
            j2 = 0;
        }
        nativeReset(this.nativeDisplaySynchronizer, j, j2);
    }

    public Display getDisplay() {
        return this.display;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nativeDisplaySynchronizer != 0) {
                Log.w(TAG, "DisplaySynchronizer.shutdown() should be called to ensure resource cleanup");
                nativeDestroy(this.nativeDisplaySynchronizer);
            }
        } finally {
            super.finalize();
        }
    }

    public void onPause() {
        if (this.frameMonitor != null) {
            this.frameMonitor.onPause();
        }
    }

    public void onResume() {
        invalidateDisplayProperties();
        if (this.frameMonitor != null) {
            this.frameMonitor.onResume();
        }
    }

    public void onConfigurationChanged() {
        invalidateDisplayProperties();
    }

    public void shutdown() {
        if (this.nativeDisplaySynchronizer != 0) {
            onPause();
            if (this.frameMonitor != null) {
                this.frameMonitor.shutdown();
            }
            nativeDestroy(this.nativeDisplaySynchronizer);
            this.nativeDisplaySynchronizer = 0;
        }
    }

    public long getNativeDisplaySynchronizer() {
        checkNativeDisplaySynchronizer();
        return this.nativeDisplaySynchronizer;
    }

    public void doFrame(long j) {
        checkNativeDisplaySynchronizer();
        if (this.displayRotationDegrees == -1 || j - this.lastDisplayRotationUpdateTimeNanos > DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS) {
            switch (this.display.getRotation()) {
                case 0:
                    this.displayRotationDegrees = 0;
                    break;
                case 1:
                    this.displayRotationDegrees = 90;
                    break;
                case 2:
                    this.displayRotationDegrees = 180;
                    break;
                case 3:
                    this.displayRotationDegrees = 270;
                    break;
                default:
                    Log.e(TAG, "Unknown display rotation, defaulting to 0");
                    this.displayRotationDegrees = 0;
                    break;
            }
            this.lastDisplayRotationUpdateTimeNanos = j;
        }
        nativeUpdate(this.nativeDisplaySynchronizer, j, this.displayRotationDegrees);
    }

    private void checkNativeDisplaySynchronizer() {
        if (this.nativeDisplaySynchronizer == 0) {
            throw new IllegalStateException("DisplaySynchronizer has already been shut down.");
        }
    }

    private void invalidateDisplayProperties() {
        this.displayRotationDegrees = -1;
        DisplayMetrics displayMetricsLandscape = DisplayUtils.getDisplayMetricsLandscape(this.display);
        if (!displayMetricsLandscape.equals(this.displayMetrics)) {
            if (this.displayMetrics != null) {
                nativeOnMetricsChanged(this.nativeDisplaySynchronizer);
            }
            this.displayMetrics = displayMetricsLandscape;
        }
    }
}
