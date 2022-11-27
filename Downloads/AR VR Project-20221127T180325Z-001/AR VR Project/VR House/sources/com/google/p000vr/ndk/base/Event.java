package com.google.p000vr.ndk.base;

import android.util.Log;

/* renamed from: com.google.vr.ndk.base.Event */
public final class Event implements AutoCloseable {
    private static final String TAG = "Event";
    long nativeEvent = GvrApi.nativeCreateEvent();

    /* renamed from: com.google.vr.ndk.base.Event$EventType */
    public static final class EventType {
        public static final int HEAD_TRACKING_PAUSED = 5;
        public static final int HEAD_TRACKING_RESUMED = 4;
        public static final int RECENTER = 1;
        public static final int SAFETY_REGION_ENTER = 3;
        public static final int SAFETY_REGION_EXIT = 2;

        private EventType() {
        }
    }

    /* renamed from: com.google.vr.ndk.base.Event$RecenterType */
    public static final class RecenterType {
        public static final int ALIGNED = 2;
        public static final int DON = 3;
        public static final int RESTART = 1;

        private RecenterType() {
        }
    }

    public final void close() {
        GvrApi.nativeDestroyEvent(this.nativeEvent);
        this.nativeEvent = 0;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        if (this.nativeEvent != 0) {
            Log.e(TAG, "Event.close() should be called when done with the event.");
            close();
        }
    }

    public final long getTimestamp() {
        return GvrApi.nativeGetEventTimestamp(this.nativeEvent);
    }

    public final int getType() {
        return GvrApi.nativeGetEventType(this.nativeEvent);
    }

    public final long getFlags() {
        return GvrApi.nativeGetEventFlags(this.nativeEvent);
    }

    public final int getRecenterEventType() {
        return GvrApi.nativeGetRecenterEventType(this.nativeEvent);
    }

    public final long getRecenterEventFlags() {
        return GvrApi.nativeGetRecenterEventFlags(this.nativeEvent);
    }

    public final void getRecenterEventStartSpaceFromTrackingSpaceTransform(float[] fArr) {
        GvrApi.nativeGetRecenterEventStartSpaceFromTrackingSpaceTransform(this.nativeEvent, fArr);
    }
}
