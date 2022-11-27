package com.google.p000vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.p000vr.sdk.proto.nano.Display;

/* renamed from: com.google.vr.cardboard.DisplayUtils */
public class DisplayUtils {
    private static final float DEFAULT_BORDER_SIZE_METERS = 0.003f;
    public static final String EXTERNAL_DISPLAY_RESOURCE_NAME = "display_manager_hdmi_display_name";
    private static final float METERS_PER_INCH = 0.0254f;

    public static Display getDefaultDisplay(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public static DisplayMetrics getDisplayMetricsLandscape(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealMetrics(displayMetrics);
        } else {
            display.getMetrics(displayMetrics);
        }
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            int i = displayMetrics.widthPixels;
            displayMetrics.widthPixels = displayMetrics.heightPixels;
            displayMetrics.heightPixels = i;
        }
        float f = displayMetrics.xdpi;
        displayMetrics.xdpi = displayMetrics.ydpi;
        displayMetrics.ydpi = f;
        return displayMetrics;
    }

    public static DisplayMetrics getDisplayMetricsLandscapeWithOverride(Display display, Display.DisplayParams displayParams) {
        DisplayMetrics displayMetricsLandscape = getDisplayMetricsLandscape(display);
        if (displayParams != null) {
            if (displayParams.hasXPpi()) {
                displayMetricsLandscape.xdpi = displayParams.getXPpi();
            }
            if (displayParams.hasYPpi()) {
                displayMetricsLandscape.ydpi = displayParams.getYPpi();
            }
        }
        return displayMetricsLandscape;
    }

    public static float getBorderSizeMeters(Display.DisplayParams displayParams) {
        if (displayParams == null || !displayParams.hasBottomBezelHeight()) {
            return DEFAULT_BORDER_SIZE_METERS;
        }
        return displayParams.getBottomBezelHeight();
    }

    public static float getMetersPerPixelFromDotsPerInch(float f) {
        return METERS_PER_INCH / f;
    }

    public static String getExternalDisplayName(Context context) {
        Resources resources = context.getResources();
        try {
            return resources.getString(resources.getIdentifier(EXTERNAL_DISPLAY_RESOURCE_NAME, "string", "android"));
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    public static boolean hasExternalDisplay(Context context) {
        if (Build.VERSION.SDK_INT <= 16) {
            return false;
        }
        String externalDisplayName = getExternalDisplayName(context);
        if (externalDisplayName == null) {
            return false;
        }
        for (android.view.Display name : ((DisplayManager) context.getSystemService("display")).getDisplays()) {
            if (name.getName().equals(externalDisplayName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameDisplay(android.view.Display display, android.view.Display display2) {
        if (display == display2) {
            return true;
        }
        if (display == null || display2 == null || display.getDisplayId() != display2.getDisplayId() || display.getFlags() != display2.getFlags() || display.isValid() != display2.isValid() || !display.getName().equals(display2.getName())) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        display2.getMetrics(displayMetrics2);
        return displayMetrics.equals(displayMetrics2);
    }
}
