package com.unity3d.player;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class UnityPlayerProxyActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.w("Unity", "UnityPlayerProxyActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
        super.onCreate(bundle);
    }
}
