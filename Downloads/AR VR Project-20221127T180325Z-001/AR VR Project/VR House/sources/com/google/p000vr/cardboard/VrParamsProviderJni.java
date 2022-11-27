package com.google.p000vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import com.google.p000vr.ndk.base.SdkConfigurationReader;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.p000vr.sdk.proto.nano.Preferences;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;

@UsedByNative
/* renamed from: com.google.vr.cardboard.VrParamsProviderJni */
public class VrParamsProviderJni {
    private static final String TAG = "VrParamsProviderJni";
    private static volatile DisplayMetrics displayMetricsOverride = null;

    private static native void nativeUpdateNativeDisplayParamsPointer(long j, int i, int i2, float f, float f2, float f3);

    public static void setDisplayOverride(Display display) {
        displayMetricsOverride = display != null ? DisplayUtils.getDisplayMetricsLandscape(display) : null;
    }

    @UsedByNative
    private static byte[] readDeviceParams(Context context) {
        VrParamsProvider create = VrParamsProviderFactory.create(context);
        CardboardDevice.DeviceParams readDeviceParams = create.readDeviceParams();
        create.close();
        if (readDeviceParams == null) {
            return null;
        }
        return MessageNano.toByteArray(readDeviceParams);
    }

    @UsedByNative
    private static byte[] readSdkConfigurationParams(Context context) {
        return MessageNano.toByteArray(SdkConfigurationReader.getParams(context));
    }

    @UsedByNative
    private static boolean writeDeviceParams(Context context, byte[] bArr) {
        CardboardDevice.DeviceParams deviceParams;
        VrParamsProvider create = VrParamsProviderFactory.create(context);
        if (bArr != null) {
            try {
                deviceParams = (CardboardDevice.DeviceParams) MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), bArr);
            } catch (InvalidProtocolBufferNanoException e) {
                String valueOf = String.valueOf(e);
                Log.w(TAG, new StringBuilder(String.valueOf(valueOf).length() + 31).append("Error parsing protocol buffer: ").append(valueOf).toString());
                create.close();
                return false;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        } else {
            deviceParams = null;
        }
        boolean writeDeviceParams = create.writeDeviceParams(deviceParams);
        create.close();
        return writeDeviceParams;
    }

    @UsedByNative
    private static void readDisplayParams(Context context, long j) {
        if (context == null) {
            Log.w(TAG, "Missing context for phone params lookup. Results may be invalid.");
            updateNativeDisplayParamsPointer(j, Resources.getSystem().getDisplayMetrics(), DisplayUtils.getBorderSizeMeters((Display.DisplayParams) null));
            return;
        }
        VrParamsProvider create = VrParamsProviderFactory.create(context);
        Display.DisplayParams readDisplayParams = create.readDisplayParams();
        DisplayMetrics displayMetrics = getDisplayMetrics(context, readDisplayParams);
        create.close();
        updateNativeDisplayParamsPointer(j, displayMetrics, DisplayUtils.getBorderSizeMeters(readDisplayParams));
    }

    @UsedByNative
    private static byte[] readUserPrefs(Context context) {
        VrParamsProvider create = VrParamsProviderFactory.create(context);
        Preferences.UserPrefs readUserPrefs = create.readUserPrefs();
        create.close();
        if (readUserPrefs == null) {
            return null;
        }
        return MessageNano.toByteArray(readUserPrefs);
    }

    private static DisplayMetrics getDisplayMetrics(Context context, Display.DisplayParams displayParams) {
        DisplayMetrics displayMetrics = displayMetricsOverride;
        return displayMetrics != null ? displayMetrics : DisplayUtils.getDisplayMetricsLandscapeWithOverride(DisplayUtils.getDefaultDisplay(context), displayParams);
    }

    private static void updateNativeDisplayParamsPointer(long j, DisplayMetrics displayMetrics, float f) {
        nativeUpdateNativeDisplayParamsPointer(j, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.xdpi, displayMetrics.ydpi, f);
    }
}
