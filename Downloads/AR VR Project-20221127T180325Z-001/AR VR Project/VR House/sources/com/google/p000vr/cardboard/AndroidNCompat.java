package com.google.p000vr.cardboard;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* renamed from: com.google.vr.cardboard.AndroidNCompat */
public class AndroidNCompat {
    private static final String ACTION_VR_LISTENER_SETTINGS = "android.settings.VR_LISTENER_SETTINGS";
    private static final boolean DEBUG = false;
    private static final String DEFAULT_VR_MODE_CLASS = "com.google.vr.vrcore.common.VrCoreListenerService";
    private static final String DEFAULT_VR_MODE_PACKAGE = "com.google.vr.vrcore";
    private static final String ENABLED_VR_LISTENERS = "enabled_vr_listeners";
    public static final int FLAG_VR_MODE_ENABLE_FALLBACK = 1;
    public static final int NMR1_SDK_LEVEL = 25;
    public static final int N_SDK_LEVEL = 24;
    private static final int PACKAGE_NOT_ENABLED = -2;
    private static final int PACKAGE_NOT_PRESENT = -1;
    private static final int SUCCESS = 0;
    /* access modifiers changed from: private */
    public static final String TAG = AndroidNCompat.class.getSimpleName();
    private static int sSdkLevelOverride = 0;

    public static boolean setVrModeEnabled(Activity activity, boolean z) {
        return setVrModeEnabled(activity, z, 1);
    }

    public static boolean setVrModeEnabled(Activity activity, boolean z, int i) {
        if (isVrModeSupported(activity)) {
            try {
                activity.setVrModeEnabled(z, new ComponentName("com.google.vr.vrcore", DEFAULT_VR_MODE_CLASS));
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                String str = TAG;
                String valueOf = String.valueOf(e);
                Log.w(str, new StringBuilder(String.valueOf(valueOf).length() + 25).append("No VR service component: ").append(valueOf).toString());
                if ((i & 1) == 0 || !isVrModeHighPerformanceSupported(activity) || !handleVrCoreAbsence(activity, checkForVrCorePresence(activity))) {
                    return false;
                }
                Log.w(TAG, "Failed to handle missing VrCore package.");
                return false;
            } catch (UnsupportedOperationException e2) {
                String str2 = TAG;
                String valueOf2 = String.valueOf(e2);
                Log.w(str2, new StringBuilder(String.valueOf(valueOf2).length() + 23).append("Failed to set VR mode: ").append(valueOf2).toString());
                return false;
            }
        } else if (!isAtLeastN()) {
            return false;
        } else {
            Log.d(TAG, "VR mode is not supported on this N device.");
            return false;
        }
    }

    public static boolean isVrModeSupported(Context context) {
        return isAtLeastN() && context.getPackageManager().hasSystemFeature("android.software.vr.mode");
    }

    public static boolean setSustainedPerformanceMode(Activity activity, boolean z) {
        if (!isAtLeastN()) {
            return false;
        }
        if (!((PowerManager) activity.getSystemService("power")).isSustainedPerformanceModeSupported()) {
            Log.d(TAG, "Sustained performance mode is not supported on this device.");
            return false;
        }
        Window window = activity.getWindow();
        if (window == null) {
            Log.e(TAG, "Activity does not have a window");
            return false;
        }
        window.setSustainedPerformanceMode(z);
        return true;
    }

    public static void setVrThread(int i) {
        if (isAtLeastN()) {
            Class<ActivityManager> cls = ActivityManager.class;
            try {
                Method method = cls.getMethod("setVrThread", new Class[]{Integer.TYPE});
                try {
                    method.invoke((Object) null, new Object[]{Integer.valueOf(i)});
                } catch (IllegalAccessException | RuntimeException | InvocationTargetException e) {
                    String str = TAG;
                    String valueOf = String.valueOf(e);
                    Log.e(str, new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke setVrThread: ").append(valueOf).toString());
                }
            } catch (NoSuchMethodException | RuntimeException e2) {
                if (isAtLeastNMR1()) {
                    String str2 = TAG;
                    String valueOf2 = String.valueOf(e2);
                    Log.e(str2, new StringBuilder(String.valueOf(valueOf2).length() + 38).append("Failed to acquire setVrThread method: ").append(valueOf2).toString());
                    return;
                }
                String str3 = TAG;
                String valueOf3 = String.valueOf(e2);
                Log.w(str3, new StringBuilder(String.valueOf(valueOf3).length() + 38).append("Failed to acquire setVrThread method: ").append(valueOf3).toString());
            }
        }
    }

    public static void setSdkLevelForTesting(int i) {
        sSdkLevelOverride = i;
    }

    private static boolean isAtLeastN() {
        return sSdkLevelOverride >= 24 || Build.VERSION.SDK_INT >= 24;
    }

    private static boolean isVrModeHighPerformanceSupported(Context context) {
        return isAtLeastN() && context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
    }

    private static boolean isAtLeastNMR1() {
        return sSdkLevelOverride >= 25 || "NMR1".equals(Build.VERSION.CODENAME) || Build.VERSION.SDK_INT >= 25;
    }

    private static int checkForVrCorePresence(Context context) {
        boolean z;
        Iterator<ApplicationInfo> it = context.getPackageManager().getInstalledApplications(0).iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().packageName.equals("com.google.vr.vrcore")) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return -1;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), ENABLED_VR_LISTENERS);
        return (string == null || !string.contains(new ComponentName("com.google.vr.vrcore", DEFAULT_VR_MODE_CLASS).flattenToString())) ? -2 : 0;
    }

    private static boolean handleVrCoreAbsence(final Context context, int i) {
        if (IsEmulator.isEmulator()) {
            return true;
        }
        if (i == -1) {
            showWarningDialog(context, C0021R.string.dialog_vr_core_not_installed, C0021R.string.go_to_playstore_button, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("market://details?id=com.google.vr.vrcore"));
                    intent.setPackage("com.android.vending");
                    try {
                        context.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e(AndroidNCompat.TAG, "Google Play Services is not installed, unable to download VrCore.");
                    }
                }
            });
            return false;
        } else if (i != -2) {
            return true;
        } else {
            showWarningDialog(context, C0021R.string.dialog_vr_core_not_enabled, C0021R.string.go_to_vr_listeners_settings_button, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    context.startActivity(new Intent(AndroidNCompat.ACTION_VR_LISTENER_SETTINGS));
                }
            });
            return false;
        }
    }

    private static void showWarningDialog(Context context, int i, int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, C0021R.style.GvrDialogTheme);
        builder.setMessage(i).setTitle(C0021R.string.dialog_title_warning).setPositiveButton(i2, onClickListener).setNegativeButton(C0021R.string.cancel_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    private AndroidNCompat() {
    }
}
