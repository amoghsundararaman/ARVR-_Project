package com.google.p000vr.cardboard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* renamed from: com.google.vr.cardboard.PackageUtils */
public class PackageUtils {
    private static final String GOOGLE_PACKAGE_PREFIX = "com.google.";

    public static boolean isGooglePackage(String str) {
        return str != null && str.startsWith(GOOGLE_PACKAGE_PREFIX);
    }

    public static boolean isSystemPackage(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            int i = applicationInfo != null ? applicationInfo.flags : 0;
            if ((i & 1) == 0 && (i & 128) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
