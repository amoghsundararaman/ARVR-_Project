package com.google.p000vr.vrcore.base.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.p000vr.cardboard.annotations.UsedByNative;
import java.util.List;

@UsedByNative
/* renamed from: com.google.vr.vrcore.base.api.VrCoreUtils */
public final class VrCoreUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "VrCoreUtils";

    /* renamed from: com.google.vr.vrcore.base.api.VrCoreUtils$ConnectionResult */
    public static class ConnectionResult {
        public static final int NOT_SUPPORTED = 7;
        public static final int NO_PERMISSION = 6;
        public static final int SERVICE_DISABLED = 2;
        public static final int SERVICE_INVALID = 9;
        public static final int SERVICE_MISSING = 1;
        public static final int SERVICE_NOT_CONNECTED = 5;
        public static final int SERVICE_OBSOLETE = 4;
        public static final int SERVICE_UPDATING = 3;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN = 8;
    }

    public static int checkVrCoreAvailability(Context context) {
        return checkVrCoreAvailabilityImpl(context);
    }

    public static boolean isVrCoreAvailable(Context context) {
        return checkVrCoreAvailability(context) == 0;
    }

    @UsedByNative
    public static int getVrCoreClientApiVersion(Context context) throws VrCoreNotAvailableException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128);
            if (!applicationInfo.enabled) {
                throw new VrCoreNotAvailableException(2);
            } else if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.getInt(VrCoreConstants.VR_CORE_CLIENT_API_VERSION_KEY, 0);
            } else {
                return 0;
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
    }

    public static int getVrCoreVersionCode(Context context) throws VrCoreNotAvailableException {
        try {
            return context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not find VrCore package", e);
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
    }

    public static String getVrCoreVersionName(Context context) throws VrCoreNotAvailableException {
        try {
            return context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not find VrCore package", e);
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
    }

    public static String getVrCoreSdkLibraryVersion(Context context) throws VrCoreNotAvailableException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128);
            if (applicationInfo == null) {
                throw new VrCoreNotAvailableException(8);
            } else if (!applicationInfo.enabled) {
                throw new VrCoreNotAvailableException(2);
            } else if (applicationInfo.metaData == null) {
                throw new VrCoreNotAvailableException(4);
            } else {
                String string = applicationInfo.metaData.getString(VrCoreConstants.VR_CORE_SDK_LIBRARY_VERSION_KEY, "");
                if (!string.isEmpty()) {
                    return string.substring(1);
                }
                throw new VrCoreNotAvailableException(4);
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
    }

    public static String getConnectionResultString(int i) {
        switch (i) {
            case 0:
                return "VR Service present";
            case 1:
                return "VR Service missing";
            case 2:
                return "VR Service disabled";
            case 3:
                return "VR Service updating";
            case 4:
                return "VR Service obsolete";
            case 5:
                return "VR Service not connected";
            case 6:
                return "No permission to do operation";
            case 7:
                return "This operation is not supported on this device";
            case 8:
                return "An unknown failure occurred";
            default:
                return new StringBuilder(38).append("Invalid connection result: ").append(i).toString();
        }
    }

    public static boolean isVrCorePackage(String str) {
        return "com.google.vr.vrcore".equalsIgnoreCase(str);
    }

    public static boolean isVrCoreComponent(ComponentName componentName) {
        return componentName != null && isVrCorePackage(componentName.getPackageName());
    }

    private static int checkVrCoreAvailabilityImpl(Context context) {
        List<PackageInstaller.SessionInfo> list;
        if ("com.google.vr.vrcore".equals(context.getPackageName())) {
            return 0;
        }
        try {
            if (!context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 0).enabled) {
                return 2;
            }
            if (!verifyRemotePackageSignature(context)) {
                return 9;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    list = context.getPackageManager().getPackageInstaller().getAllSessions();
                } catch (RuntimeException e2) {
                    String valueOf = String.valueOf(e2);
                    Log.w(TAG, new StringBuilder(String.valueOf(valueOf).length() + 45).append("Failure querying package installer sessions: ").append(valueOf).toString());
                    list = null;
                }
                if (list != null) {
                    for (PackageInstaller.SessionInfo appPackageName : list) {
                        if ("com.google.vr.vrcore".equals(appPackageName.getAppPackageName())) {
                            return 3;
                        }
                    }
                }
            }
            try {
                if (context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 8192).enabled) {
                    return 3;
                }
            } catch (PackageManager.NameNotFoundException e3) {
            }
            return 1;
        }
    }

    private static boolean verifyRemotePackageSignature(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 64);
        if (SignatureUtils.verifySignature(packageInfo, SignatureUtils.VRCORE_RELEASE_SIGNATURE)) {
            return true;
        }
        if (!BuildUtils.isDebugBuild(context)) {
            return false;
        }
        return SignatureUtils.verifySignature(packageInfo, SignatureUtils.VRCORE_DEBUG_SIGNATURE);
    }
}
