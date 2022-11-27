package com.google.p000vr.cardboard;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.ndk.base.SdkConfigurationReader;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.p000vr.sdk.proto.nano.Preferences;
import com.google.p000vr.sdk.proto.nano.SdkConfiguration;
import com.google.protobuf.nano.MessageNano;

/* renamed from: com.google.vr.cardboard.ContentProviderVrParamsProvider */
public class ContentProviderVrParamsProvider implements VrParamsProvider {
    private static final String TAG = ContentProviderVrParamsProvider.class.getSimpleName();
    private final ContentProviderClient client;
    private final Uri deviceParamsSettingUri;
    private final Uri displayParamsSettingUri;
    private final Uri recentHeadsetsSettingUri;
    private final Uri sdkConfigurationParamsSettingUri;
    private final Uri userPrefsUri;

    public ContentProviderVrParamsProvider(ContentProviderClient contentProviderClient, String str) {
        if (contentProviderClient == null) {
            throw new IllegalArgumentException("ContentProviderClient must not be null");
        } else if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Authority key must be non-null and non-empty");
        } else {
            this.client = contentProviderClient;
            this.deviceParamsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.DEVICE_PARAMS_SETTING);
            this.userPrefsUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.USER_PREFS_SETTING);
            this.displayParamsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.DISPLAY_PARAMS_SETTING);
            this.sdkConfigurationParamsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.SDK_CONFIGURATION_PARAMS_SETTING);
            this.recentHeadsetsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.RECENT_HEADSETS_SETTING);
        }
    }

    public CardboardDevice.DeviceParams readDeviceParams() {
        return (CardboardDevice.DeviceParams) readParams(new CardboardDevice.DeviceParams(), this.deviceParamsSettingUri, (String) null);
    }

    public boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        return writeParams(deviceParams, this.deviceParamsSettingUri);
    }

    public CardboardDevice.DeviceParamsList readRecentHeadsets() {
        return (CardboardDevice.DeviceParamsList) readParams(new CardboardDevice.DeviceParamsList(), this.recentHeadsetsSettingUri, (String) null);
    }

    public Display.DisplayParams readDisplayParams() {
        return (Display.DisplayParams) readParams(new Display.DisplayParams(), this.displayParamsSettingUri, (String) null);
    }

    public C0003Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(SdkConfiguration.SdkConfigurationRequest sdkConfigurationRequest) {
        return (C0003Vr.VREvent.SdkConfigurationParams) readParams(SdkConfigurationReader.DEFAULT_PARAMS, this.sdkConfigurationParamsSettingUri, Base64.encodeToString(MessageNano.toByteArray(sdkConfigurationRequest), 0));
    }

    public Preferences.UserPrefs readUserPrefs() {
        return (Preferences.UserPrefs) readParams(new Preferences.UserPrefs(), this.userPrefsUri, (String) null);
    }

    public boolean updateUserPrefs(Preferences.UserPrefs userPrefs) {
        return writeParams(userPrefs, this.userPrefsUri);
    }

    public void close() {
        this.client.release();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T extends com.google.protobuf.nano.MessageNano> T readParams(T r8, android.net.Uri r9, java.lang.String r10) {
        /*
            r7 = this;
            r6 = 0
            android.content.ContentProviderClient r0 = r7.client     // Catch:{ InvalidProtocolBufferNanoException -> 0x007f, CursorIndexOutOfBoundsException -> 0x0075, IllegalArgumentException -> 0x007a, RemoteException -> 0x0059, all -> 0x0069 }
            r2 = 0
            r4 = 0
            r5 = 0
            r1 = r9
            r3 = r10
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ InvalidProtocolBufferNanoException -> 0x007f, CursorIndexOutOfBoundsException -> 0x0075, IllegalArgumentException -> 0x007a, RemoteException -> 0x0059, all -> 0x0069 }
            if (r1 == 0) goto L_0x002c
            boolean r0 = r1.moveToFirst()     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            if (r0 == 0) goto L_0x002c
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            if (r0 != 0) goto L_0x0022
            if (r1 == 0) goto L_0x0020
            r1.close()
        L_0x0020:
            r0 = r6
        L_0x0021:
            return r0
        L_0x0022:
            com.google.protobuf.nano.MessageNano r0 = com.google.protobuf.nano.MessageNano.mergeFrom(r8, r0)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            if (r1 == 0) goto L_0x0021
            r1.close()
            goto L_0x0021
        L_0x002c:
            java.lang.String r0 = TAG     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            int r3 = r3.length()     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            int r3 = r3 + 50
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            r4.<init>(r3)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            java.lang.String r3 = "Invalid params result from ContentProvider query: "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            java.lang.String r2 = r2.toString()     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            android.util.Log.e(r0, r2)     // Catch:{ InvalidProtocolBufferNanoException -> 0x0082, CursorIndexOutOfBoundsException -> 0x0078, IllegalArgumentException -> 0x007d, RemoteException -> 0x0073 }
            if (r1 == 0) goto L_0x0057
            r1.close()
        L_0x0057:
            r0 = r6
            goto L_0x0021
        L_0x0059:
            r0 = move-exception
            r1 = r6
        L_0x005b:
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = "Error reading params from ContentProvider"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x0067
            r1.close()
        L_0x0067:
            r0 = r6
            goto L_0x0021
        L_0x0069:
            r0 = move-exception
            r1 = r6
        L_0x006b:
            if (r1 == 0) goto L_0x0070
            r1.close()
        L_0x0070:
            throw r0
        L_0x0071:
            r0 = move-exception
            goto L_0x006b
        L_0x0073:
            r0 = move-exception
            goto L_0x005b
        L_0x0075:
            r0 = move-exception
            r1 = r6
            goto L_0x005b
        L_0x0078:
            r0 = move-exception
            goto L_0x005b
        L_0x007a:
            r0 = move-exception
            r1 = r6
            goto L_0x005b
        L_0x007d:
            r0 = move-exception
            goto L_0x005b
        L_0x007f:
            r0 = move-exception
            r1 = r6
            goto L_0x005b
        L_0x0082:
            r0 = move-exception
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.cardboard.ContentProviderVrParamsProvider.readParams(com.google.protobuf.nano.MessageNano, android.net.Uri, java.lang.String):com.google.protobuf.nano.MessageNano");
    }

    private boolean writeParams(MessageNano messageNano, Uri uri) {
        int update;
        if (messageNano == null) {
            try {
                update = this.client.delete(uri, (String) null, (String[]) null);
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to write params to ContentProvider", e);
                return false;
            } catch (SecurityException e2) {
                Log.e(TAG, "Insufficient permissions to write params to ContentProvider", e2);
                return false;
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(VrSettingsProviderContract.SETTING_VALUE_KEY, MessageNano.toByteArray(messageNano));
            update = this.client.update(uri, contentValues, (String) null, (String[]) null);
        }
        if (update > 0) {
            return true;
        }
        return false;
    }
}
