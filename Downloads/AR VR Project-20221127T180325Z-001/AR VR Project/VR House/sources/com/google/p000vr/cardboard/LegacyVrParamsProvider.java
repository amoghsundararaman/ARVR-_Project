package com.google.p000vr.cardboard;

import android.content.Context;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.p000vr.sdk.proto.nano.Preferences;
import com.google.p000vr.sdk.proto.nano.SdkConfiguration;

/* renamed from: com.google.vr.cardboard.LegacyVrParamsProvider */
public final class LegacyVrParamsProvider implements VrParamsProvider {
    private static final String TAG = LegacyVrParamsProvider.class.getSimpleName();
    private final Context context;

    public LegacyVrParamsProvider(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public final CardboardDevice.DeviceParams readDeviceParams() {
        return ConfigUtils.readDeviceParamsFromExternalStorage();
    }

    public final boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        if (deviceParams == null) {
            return ConfigUtils.removeDeviceParamsFromExternalStorage();
        }
        return ConfigUtils.writeDeviceParamsToExternalStorage(deviceParams);
    }

    public final Display.DisplayParams readDisplayParams() {
        Display.DisplayParams readDisplayParamsFromExternalStorage = ConfigUtils.readDisplayParamsFromExternalStorage();
        if (readDisplayParamsFromExternalStorage == null) {
            return PpiOverrides.getPpiOverride(this.context);
        }
        return readDisplayParamsFromExternalStorage;
    }

    public final Preferences.UserPrefs readUserPrefs() {
        return null;
    }

    public final boolean updateUserPrefs(Preferences.UserPrefs userPrefs) {
        return false;
    }

    public final C0003Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(SdkConfiguration.SdkConfigurationRequest sdkConfigurationRequest) {
        return null;
    }

    public final void close() {
    }

    public final CardboardDevice.DeviceParamsList readRecentHeadsets() {
        CardboardDevice.DeviceParamsList deviceParamsList = new CardboardDevice.DeviceParamsList();
        deviceParamsList.params = new CardboardDevice.DeviceParams[0];
        return deviceParamsList;
    }
}
