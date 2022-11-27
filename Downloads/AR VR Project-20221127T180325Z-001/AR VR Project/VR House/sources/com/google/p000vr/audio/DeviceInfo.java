package com.google.p000vr.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
import com.google.p000vr.cardboard.annotations.UsedByNative;

@UsedByNative
/* renamed from: com.google.vr.audio.DeviceInfo */
public class DeviceInfo {
    private static final int DEFAULT_BUFFER_SIZE = 256;
    private static final int DEFAULT_SAMPLE_RATE = 48000;
    private static final String TAG = "DeviceInfo";
    private final Context context;
    private final BroadcastReceiver headphoneStateReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                switch (intent.getIntExtra("state", -1)) {
                    case 0:
                        DeviceInfo.this.nativeUpdateHeadphoneStateChange(DeviceInfo.this.nativeObject, 2);
                        return;
                    case 1:
                        DeviceInfo.this.nativeUpdateHeadphoneStateChange(DeviceInfo.this.nativeObject, 1);
                        return;
                    default:
                        DeviceInfo.this.nativeUpdateHeadphoneStateChange(DeviceInfo.this.nativeObject, 0);
                        return;
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public final long nativeObject;

    /* renamed from: com.google.vr.audio.DeviceInfo$HeadphoneState */
    private static abstract class HeadphoneState {
        public static final int PLUGGEDIN = 1;
        public static final int UNKNOWN = 0;
        public static final int UNPLUGGED = 2;

        private HeadphoneState() {
        }
    }

    private DeviceInfo(long j, Context context2) {
        this.nativeObject = j;
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public native void nativeUpdateHeadphoneStateChange(long j, int i);

    @UsedByNative
    private static DeviceInfo createDeviceInfo(long j, Context context2) {
        return new DeviceInfo(j, context2);
    }

    @UsedByNative
    private void registerHandlers() {
        this.context.registerReceiver(this.headphoneStateReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    @UsedByNative
    private void unregisterHandlers() {
        this.context.unregisterReceiver(this.headphoneStateReceiver);
    }

    @UsedByNative
    private boolean isHeadphonePluggedIn() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) this.context.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 22) {
                return true;
            }
        }
        return false;
    }

    @UsedByNative
    private int getSystemSampleRate() {
        String property = ((AudioManager) this.context.getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property != null) {
            return Integer.parseInt(property);
        }
        Log.w(TAG, "Could not obtain system sample rate, defaulting to 48000");
        return DEFAULT_SAMPLE_RATE;
    }

    @UsedByNative
    private int getSystemBufferSize() {
        String property = ((AudioManager) this.context.getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        if (property != null) {
            return Integer.parseInt(property);
        }
        Log.w(TAG, "Could not obtain system buffer size, defaulting to 256");
        return DEFAULT_BUFFER_SIZE;
    }

    @UsedByNative
    private boolean isBluetoothAudioDevicePluggedIn() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        for (AudioDeviceInfo type : ((AudioManager) this.context.getSystemService("audio")).getDevices(2)) {
            if (type.getType() == 8) {
                return true;
            }
        }
        return false;
    }
}
