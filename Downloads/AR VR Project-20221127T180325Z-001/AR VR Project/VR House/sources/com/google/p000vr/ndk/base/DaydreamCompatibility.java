package com.google.p000vr.ndk.base;

import android.util.Log;

/* renamed from: com.google.vr.ndk.base.DaydreamCompatibility */
public class DaydreamCompatibility {
    public static final int DAYDREAM_NOT_SUPPORTED = 1;
    public static final int DAYDREAM_OPTIONAL = 2;
    public static final int DAYDREAM_REQUIRED = 3;
    public static final int SUPPORTS_CARDBOARD = 2;
    public static final int SUPPORTS_CONTROLLERLESS_DAYDREAM = 4;
    public static final int SUPPORTS_DAYDREAM = 1;
    private static final String TAG = "DaydreamCompatibility";
    private final int supportedHeadsets;

    public DaydreamCompatibility(int i) {
        this.supportedHeadsets = i;
    }

    public DaydreamCompatibility() {
        this(0);
    }

    public int getSupportedHeadsets() {
        return this.supportedHeadsets;
    }

    public boolean supportsDaydream() {
        return (this.supportedHeadsets & 5) != 0;
    }

    public boolean supportsControllerlessDaydream() {
        return (this.supportedHeadsets & 4) != 0;
    }

    public boolean requiresDaydream() {
        return supportsDaydream() && !supportsCardboard();
    }

    public int toDeprecated() {
        if (requiresDaydream()) {
            return 3;
        }
        if (supportsDaydream()) {
            return 2;
        }
        return 1;
    }

    public static DaydreamCompatibility fromDeprecated(int i) {
        int i2 = 0;
        switch (i) {
            case 1:
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 1;
                break;
            default:
                Log.e(TAG, new StringBuilder(47).append("Invalid deprecated daydream compat: ").append(i).toString());
                break;
        }
        return new DaydreamCompatibility(i2);
    }

    private boolean supportsCardboard() {
        return (this.supportedHeadsets & 2) != 0;
    }
}
