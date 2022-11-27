package com.google.p000vr.ndk.base;

import android.app.Activity;
import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.p000vr.cardboard.annotations.UsedByReflection;

@UsedByReflection("Unity")
/* renamed from: com.google.vr.ndk.base.AndroidCompat */
public final class AndroidCompat {
    @UsedByReflection("Unity")
    public static boolean setVrModeEnabled(Activity activity, boolean z) {
        return AndroidNCompat.setVrModeEnabled(activity, z);
    }

    @UsedByReflection("Unity")
    public static void setSustainedPerformanceMode(Activity activity, boolean z) {
        AndroidNCompat.setSustainedPerformanceMode(activity, z);
    }

    private AndroidCompat() {
    }
}
