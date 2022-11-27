package com.google.p000vr.ndk.base;

/* renamed from: com.google.vr.ndk.base.Properties */
public final class Properties {
    private final long nativeProperties;

    /* renamed from: com.google.vr.ndk.base.Properties$PropertyType */
    public static final class PropertyType {
        public static final int RECENTER_TRANSFORM = 2;
        public static final int SAFETY_CYLINDER_ENTER_RADIUS = 4;
        public static final int SAFETY_CYLINDER_EXIT_RADIUS = 5;
        public static final int SAFETY_REGION = 3;
        public static final int TRACKING_FLOOR_HEIGHT = 1;
        public static final int TRACKING_STATUS = 6;

        private PropertyType() {
        }
    }

    /* renamed from: com.google.vr.ndk.base.Properties$SafetyRegionType */
    public static final class SafetyRegionType {
        public static final int CYLINDER = 1;
        public static final int NONE = 0;

        private SafetyRegionType() {
        }
    }

    /* renamed from: com.google.vr.ndk.base.Properties$TrackingStatusFlag */
    public static final class TrackingStatusFlag {
        public static final long HAS_6DOF = 4;
        public static final long INITIALIZING = 2;
        public static final long INVALID = 1;

        private TrackingStatusFlag() {
        }
    }

    Properties(long j) {
        this.nativeProperties = j;
    }

    public final boolean get(int i, Value value) {
        return GvrApi.nativeGetProperty(this.nativeProperties, i, value.nativeValue);
    }
}
