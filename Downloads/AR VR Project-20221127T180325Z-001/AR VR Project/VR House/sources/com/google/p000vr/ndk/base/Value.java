package com.google.p000vr.ndk.base;

import android.util.Log;

/* renamed from: com.google.vr.ndk.base.Value */
public final class Value implements AutoCloseable {
    private static final String TAG = "Value";
    long nativeValue = GvrApi.nativeCreateValue();

    public final void close() {
        GvrApi.nativeDestroyValue(this.nativeValue);
        this.nativeValue = 0;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        if (this.nativeValue != 0) {
            Log.e(TAG, "Value.close() should be called when done with the event.");
            close();
        }
    }

    public final long getFlags() {
        return GvrApi.nativeValueGetFlags(this.nativeValue);
    }

    public final float asFloat() {
        return GvrApi.nativeValueAsFloat(this.nativeValue);
    }

    public final int asInt() {
        return GvrApi.nativeValueAsInt(this.nativeValue);
    }

    public final long asFlags() {
        return GvrApi.nativeValueAsFlags(this.nativeValue);
    }

    public final void asMat4f(float[] fArr) {
        GvrApi.nativeValueAsMat4f(this.nativeValue, fArr);
    }
}
