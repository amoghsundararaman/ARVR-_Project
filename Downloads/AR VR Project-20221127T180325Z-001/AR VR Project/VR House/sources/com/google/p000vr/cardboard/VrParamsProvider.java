package com.google.p000vr.cardboard;

import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.p000vr.sdk.proto.nano.Preferences;
import com.google.p000vr.sdk.proto.nano.SdkConfiguration;

/* renamed from: com.google.vr.cardboard.VrParamsProvider */
public interface VrParamsProvider {
    void close();

    CardboardDevice.DeviceParams readDeviceParams();

    Display.DisplayParams readDisplayParams();

    CardboardDevice.DeviceParamsList readRecentHeadsets();

    C0003Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(SdkConfiguration.SdkConfigurationRequest sdkConfigurationRequest);

    Preferences.UserPrefs readUserPrefs();

    boolean updateUserPrefs(Preferences.UserPrefs userPrefs);

    boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams);
}
