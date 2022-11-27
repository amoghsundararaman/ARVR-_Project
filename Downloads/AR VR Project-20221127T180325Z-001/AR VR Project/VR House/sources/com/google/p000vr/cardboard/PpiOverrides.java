package com.google.p000vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.view.Display;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.vr.cardboard.PpiOverrides */
public class PpiOverrides {
    private static final boolean DEBUG = false;
    private static final List<PpiOverride> PPI_OVERRIDES = Arrays.asList(new PpiOverride[]{new PpiOverride("Micromax", (String) null, "4560MMX", (String) null, 217.0f, 217.0f), new PpiOverride("HTC", "endeavoru", "HTC One X", (String) null, 312.0f, 312.0f), new PpiOverride("samsung", (String) null, "SM-G920P", (String) null, 575.0f, 575.0f), new PpiOverride("samsung", (String) null, "SM-G930", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G9300", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930A", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930F", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930P", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930R4", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930T", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930V", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-G930W8", (String) null, 581.0f, 580.0f), new PpiOverride("samsung", (String) null, "SM-N915FY", (String) null, 541.0f, 541.0f), new PpiOverride("samsung", (String) null, "SM-N915A", (String) null, 541.0f, 541.0f), new PpiOverride("samsung", (String) null, "SM-N915T", (String) null, 541.0f, 541.0f), new PpiOverride("samsung", (String) null, "SM-N915K", (String) null, 541.0f, 541.0f), new PpiOverride("samsung", (String) null, "SM-N915T", (String) null, 541.0f, 541.0f), new PpiOverride("samsung", (String) null, "SM-N915G", (String) null, 541.0f, 541.0f), new PpiOverride("samsung", (String) null, "SM-N915D", (String) null, 541.0f, 541.0f), new PpiOverride("BLU", "BLU", "Studio 5.0 HD LTE", "qcom", 294.0f, 294.0f), new PpiOverride("OnePlus", "A0001", "A0001", "bacon", 401.0f, 401.0f), new PpiOverride("THL", "THL", "thl 5000", "mt6592", 441.0f, 441.0f), new PpiOverride("Google", "sailfish", "Pixel", "sailfish", 441.74f, 441.74f), new PpiOverride("Google", "marlin", "Pixel XL", "marlin", 537.57f, 537.57f), new PpiOverride("Google", "walleye", (String) null, "walleye", 441.74f, 441.74f), new PpiOverride("Lenovo", "vega", (String) null, "vega", 537.388f, 537.882f)});
    private static final String TAG = PpiOverrides.class.getSimpleName();
    private static ArrayList<Size> supportedDisplaySizes = null;

    private PpiOverrides() {
    }

    static boolean getPpiOverride(List<PpiOverride> list, String str, String str2, String str3, String str4, Display.DisplayParams displayParams) {
        for (PpiOverride next : list) {
            if (next.isMatching(str, str2, str3, str4)) {
                Log.d(TAG, String.format("Found override: {MANUFACTURER=%s, DEVICE=%s, MODEL=%s, HARDWARE=%s} : x_ppi=%f, y_ppi=%f", new Object[]{next.manufacturer, next.device, next.model, next.hardware, Float.valueOf(next.xPpi), Float.valueOf(next.yPpi)}));
                displayParams.setXPpi(next.xPpi);
                displayParams.setYPpi(next.yPpi);
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.google.vr.cardboard.PpiOverrides$PpiOverride */
    static class PpiOverride {
        String device;
        String hardware;
        String manufacturer;
        String model;
        float xPpi;
        float yPpi;

        PpiOverride(String str, String str2, String str3, String str4, float f, float f2) {
            this.manufacturer = str;
            this.device = str2;
            this.model = str3;
            this.hardware = str4;
            this.xPpi = f;
            this.yPpi = f2;
        }

        /* access modifiers changed from: package-private */
        public boolean isMatching(String str, String str2, String str3, String str4) {
            return (this.manufacturer == null || this.manufacturer.equals(str)) && (this.device == null || this.device.equals(str2)) && ((this.model == null || this.model.equals(str3)) && (this.hardware == null || this.hardware.equals(str4)));
        }
    }

    public static Display.DisplayParams getPpiOverride(Context context) {
        Display.DisplayParams displayParams = new Display.DisplayParams();
        if (!getPpiOverride(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE, displayParams)) {
            return null;
        }
        if (!"samsung".equals(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
            return displayParams;
        }
        android.view.Display defaultDisplay = DisplayUtils.getDefaultDisplay(context);
        DisplayMetrics displayMetricsLandscape = DisplayUtils.getDisplayMetricsLandscape(defaultDisplay);
        int i = displayMetricsLandscape.widthPixels;
        ArrayList<Size> supportedDisplaySizes2 = getSupportedDisplaySizes(defaultDisplay);
        if (supportedDisplaySizes2 == null) {
            return displayParams;
        }
        ArrayList arrayList = supportedDisplaySizes2;
        int size = arrayList.size();
        int i2 = i;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Size size2 = (Size) obj;
            i2 = Math.max(i2, Math.max(size2.getWidth(), size2.getHeight()));
        }
        if (displayMetricsLandscape.widthPixels == i2) {
            return displayParams;
        }
        float f = ((float) displayMetricsLandscape.widthPixels) / ((float) i2);
        Log.i(TAG, new StringBuilder(61).append("Non-native screen resolution; scaling DPI by: ").append(f).toString());
        displayParams.setXPpi(displayParams.getXPpi() * f);
        displayParams.setYPpi(f * displayParams.getYPpi());
        return displayParams;
    }

    static void registerOverridesInternal(List<PpiOverride> list, String str, String str2, String str3, String str4) {
        Display.DisplayParams readDisplayParamsFromExternalStorage = ConfigUtils.readDisplayParamsFromExternalStorage();
        Display.DisplayParams displayParams = readDisplayParamsFromExternalStorage == null ? new Display.DisplayParams() : readDisplayParamsFromExternalStorage.clone();
        if (getPpiOverride(list, str, str2, str3, str4, displayParams) && !MessageNano.messageNanoEquals(readDisplayParamsFromExternalStorage, displayParams)) {
            Log.i(TAG, "Applying display param override.");
            ConfigUtils.writeDisplayParamsToExternalStorage(displayParams);
        }
    }

    public static void registerOverrides() {
        registerOverridesInternal(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE);
    }

    public static void setSupportedDisplaySizesForTesting(ArrayList<Size> arrayList) {
        supportedDisplaySizes = arrayList;
    }

    private static ArrayList<Size> getSupportedDisplaySizes(android.view.Display display) {
        if (display == null) {
            return null;
        }
        if (supportedDisplaySizes != null) {
            return supportedDisplaySizes;
        }
        supportedDisplaySizes = new ArrayList<>();
        Display.Mode[] supportedModes = display.getSupportedModes();
        if (supportedModes != null) {
            for (Display.Mode mode : supportedModes) {
                supportedDisplaySizes.add(new Size(mode.getPhysicalWidth(), mode.getPhysicalHeight()));
            }
        }
        return supportedDisplaySizes;
    }
}
