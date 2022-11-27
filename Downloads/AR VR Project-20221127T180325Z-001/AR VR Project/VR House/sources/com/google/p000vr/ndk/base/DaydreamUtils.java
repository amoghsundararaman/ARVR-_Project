package com.google.p000vr.ndk.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.google.p000vr.cardboard.ConfigUtils;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import java.util.List;

/* renamed from: com.google.vr.ndk.base.DaydreamUtils */
public class DaydreamUtils {
    static final String INTENT_CATEGORY_CARDBOARD = "com.google.intent.category.CARDBOARD";
    static final String INTENT_CATEGORY_DAYDREAM = "com.google.intent.category.DAYDREAM";
    static final String INTENT_CATEGORY_DAYDREAM_CONTROLLER_OPTIONAL = "com.google.intent.category.DAYDREAM_CONTROLLER_OPTIONAL";
    private static final String TAG = "DaydreamUtils";
    private static boolean sDaydreamPhoneOverrideForTesting;

    public static boolean isDaydreamPhone(Context context) {
        if (sDaydreamPhoneOverrideForTesting) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
    }

    public static boolean isDaydreamViewer(CardboardDevice.DeviceParams deviceParams) {
        return (deviceParams == null || deviceParams.daydreamInternal == null) ? false : true;
    }

    public static DaydreamCompatibility getComponentDaydreamCompatibility(Context context, ComponentName componentName) {
        return getComponentDaydreamCompatibility(context.getPackageManager(), componentName);
    }

    public static void setIsDaydreamPhoneForTesting(boolean z) {
        sDaydreamPhoneOverrideForTesting = z;
    }

    public static String getDeviceParamsDisplayedName(CardboardDevice.DeviceParams deviceParams) {
        if (deviceParams != null) {
            return getDeviceParamsDisplayedName(deviceParams.getVendor(), deviceParams.getModel());
        }
        Log.e(TAG, "Null params in getDeviceParamsDisplayedName");
        return "";
    }

    public static String getDeviceParamsDisplayedName(String str, String str2) {
        if (str == null || str2 == null) {
            Log.e(TAG, "Null vendor/model in getDeviceParamsDisplayedName");
            if (str2 != null) {
                return str2;
            }
            return "";
        } else if (!str.equals("Google, Inc.") && !str.equals("Google")) {
            return str2;
        } else {
            char c = 65535;
            switch (str2.hashCode()) {
                case -2120800987:
                    if (str2.equals("Cardboard v1")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1761541558:
                    if (str2.equals(ConfigUtils.CARDBOARD_CONFIG_FOLDER)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "Google Cardboard (I/O 2015)";
                case 1:
                    return "Google Cardboard";
                default:
                    return str2;
            }
        }
    }

    static DaydreamCompatibility getComponentDaydreamCompatibility(PackageManager packageManager, ComponentName componentName) {
        int i = 0;
        if (checkHeadsetCompatibility(packageManager, componentName, "com.google.intent.category.DAYDREAM")) {
            i = 1;
        }
        if (checkHeadsetCompatibility(packageManager, componentName, "com.google.intent.category.CARDBOARD")) {
            i |= 2;
        }
        if (checkHeadsetCompatibility(packageManager, componentName, INTENT_CATEGORY_DAYDREAM_CONTROLLER_OPTIONAL)) {
            i |= 4;
        }
        return new DaydreamCompatibility(i);
    }

    private static boolean checkHeadsetCompatibility(PackageManager packageManager, ComponentName componentName, String str) {
        Intent intent = new Intent();
        intent.setPackage(componentName.getPackageName());
        intent.addCategory(str);
        return canResolveIntent(packageManager, componentName, intent);
    }

    private static boolean canResolveIntent(PackageManager packageManager, ComponentName componentName, Intent intent) {
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 128);
        if (queryIntentActivities != null) {
            for (ResolveInfo next : queryIntentActivities) {
                if (next != null && next.activityInfo != null && next.activityInfo.name != null && next.activityInfo.name.equals(componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected DaydreamUtils() {
    }
}
