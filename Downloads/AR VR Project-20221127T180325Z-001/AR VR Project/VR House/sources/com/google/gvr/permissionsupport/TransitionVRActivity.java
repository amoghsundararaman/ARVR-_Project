package com.google.gvr.permissionsupport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.p000vr.ndk.base.DaydreamApi;

public class TransitionVRActivity extends Activity {
    public static final String PERMISSION_EXTRA = "permissions.PermissionArray";
    private static final int RC_ASK_PERMISSION = 778;
    private static final int RC_EXIT_VR = 777;
    private static final String TAG = "TransitionVRActivity";
    private String[] permissionArray;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setImmersiveSticky();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & 4) == 0) {
                    TransitionVRActivity.this.setImmersiveSticky();
                }
            }
        });
        Intent myIntent = getIntent();
        this.permissionArray = null;
        if (myIntent.hasExtra(PERMISSION_EXTRA)) {
            this.permissionArray = myIntent.getStringArrayExtra(PERMISSION_EXTRA);
        }
        if (this.permissionArray == null || this.permissionArray.length == 0) {
            Log.w(TAG, "No permissions requested!");
            PermissionsFragment.setPermissionResult(true);
            finish();
            return;
        }
        DaydreamApi daydreamApi = DaydreamApi.create(this);
        daydreamApi.exitFromVr(this, RC_EXIT_VR, (Intent) null);
        daydreamApi.close();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != RC_EXIT_VR) {
            super.onActivityResult(requestCode, resultCode, data);
        } else if (resultCode == -1) {
            requestPermissions(this.permissionArray, RC_ASK_PERMISSION);
        } else {
            Log.w(TAG, "exitFromVR returned " + resultCode + ", finishing");
            PermissionsFragment.setPermissionResult(false);
            finish();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == RC_ASK_PERMISSION) {
            boolean allPermissionsGranted = true;
            int length = grantResults.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (grantResults[i] != 0) {
                    allPermissionsGranted = false;
                    break;
                } else {
                    i++;
                }
            }
            PermissionsFragment.setPermissionResult(allPermissionsGranted);
            finish();
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* access modifiers changed from: private */
    public void setImmersiveSticky() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
