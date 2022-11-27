package com.google.gvr.keyboardsupport;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.p000vr.ndk.base.DaydreamApi;

public class TransitionVRActivity extends Activity {
    private static final String DD_KEYBOARD_BUNDLE_ID = "com.google.android.vr.inputmethod";
    private static final int RC_EXIT_VR = 777;
    private static final String TAG = "TransitionVRActivity";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaydreamApi daydreamApi = DaydreamApi.create(this);
        daydreamApi.exitFromVr(this, RC_EXIT_VR, (Intent) null);
        daydreamApi.close();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != RC_EXIT_VR) {
            super.onActivityResult(requestCode, resultCode, data);
        } else if (resultCode == -1) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.vr.inputmethod")));
        } else {
            Log.w(TAG, "exitFromVR returned " + resultCode + ", finishing");
            finish();
        }
        KeyboardFragment.callBackCall();
    }

    private void setImmersiveSticky() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
