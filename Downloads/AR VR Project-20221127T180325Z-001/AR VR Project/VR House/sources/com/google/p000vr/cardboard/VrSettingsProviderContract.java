package com.google.p000vr.cardboard;

import android.net.Uri;

/* renamed from: com.google.vr.cardboard.VrSettingsProviderContract */
public class VrSettingsProviderContract {
    public static final String BOOTS_TO_VR = "boots_to_vr";
    public static final String DASHBOARD_ENABLED = "dashboard_enabled";
    public static final String DAYDREAM_SETUP_COMPLETED = "daydream_setup";
    public static final String DEVICE_PARAMS_SETTING = "device_params";
    public static final String DISPLAY_PARAMS_SETTING = "phone_params";
    public static final String IS_IN_VR_SESSION = "is_in_vr_session";
    public static final String PROVIDER_INTENT_ACTION = "android.content.action.VR_SETTINGS_PROVIDER";
    public static final String QUERY_PARAMETER_KEY = "key";
    public static final String RECENT_HEADSETS_SETTING = "recent_headsets";
    public static final String SDK_CONFIGURATION_PARAMS_SETTING = "sdk_configuration_params";
    public static final String SETTING_VALUE_KEY = "value";
    public static final String USER_PREFS_SETTING = "user_prefs";
    public static final String VRCORE_AUTHORITY = "com.google.vr.vrcore.settings";

    public static Uri createUri(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).path(str2).build();
    }

    public static Uri createUri(String str, String str2, String str3) {
        return new Uri.Builder().scheme("content").authority(str).path(str2).appendQueryParameter(QUERY_PARAMETER_KEY, str3).build();
    }
}
