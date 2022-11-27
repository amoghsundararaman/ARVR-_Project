package com.google.p000vr.vrcore.base.api;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: com.google.vr.vrcore.base.api.BuildUtils */
public class BuildUtils {
    private static volatile Boolean isDebug;

    public static boolean isDebugBuild(Context context) {
        return isDebug != null ? isDebug.booleanValue() : computeIsDebugBuild(context);
    }

    public static synchronized void setIsDebugBuild(boolean z) {
        synchronized (BuildUtils.class) {
            isDebug = Boolean.valueOf(z);
        }
    }

    private static synchronized boolean computeIsDebugBuild(Context context) {
        boolean booleanValue;
        synchronized (BuildUtils.class) {
            if (isDebug == null) {
                try {
                    isDebug = Boolean.valueOf(SignatureUtils.verifySignature(context.getPackageManager().getPackageInfo(context.getPackageName(), 64), SignatureUtils.BLAZE_DEBUG_SIGNATURE, SignatureUtils.ANDROID_DEBUG_SIGNATURE, SignatureUtils.VRCORE_DEBUG_SIGNATURE));
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalStateException("Unable to find self package info", e);
                }
            }
            booleanValue = isDebug.booleanValue();
        }
        return booleanValue;
    }
}
