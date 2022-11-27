package com.google.gvr.permissionsupport;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.p000vr.ndk.base.DaydreamApi;

public class PermissionsFragment extends Fragment {
    public static final String FRAGMENT_TAG = "avr_PermissionsFragment";
    private static final String TAG = "PermissionsFragment";
    private static PermissionsCallback permissionsCallback = null;

    public interface PermissionsCallback {
        void onRequestPermissionResult(boolean z);
    }

    public static PermissionsFragment getInstance(Activity parentActivity) {
        PermissionsFragment fragment = (PermissionsFragment) parentActivity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            try {
                Log.i(TAG, "Creating PlayGamesFragment");
                PermissionsFragment fragment2 = new PermissionsFragment();
                try {
                    FragmentTransaction trans = parentActivity.getFragmentManager().beginTransaction();
                    trans.add(fragment2, FRAGMENT_TAG);
                    trans.commitAllowingStateLoss();
                    fragment = fragment2;
                } catch (Throwable th) {
                    th = th;
                    PermissionsFragment permissionsFragment = fragment2;
                    Log.e(TAG, "Cannot launch PermissionsFragment:" + th.getMessage(), th);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                Log.e(TAG, "Cannot launch PermissionsFragment:" + th.getMessage(), th);
                return null;
            }
        }
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public boolean hasPermission(String permission) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Log.d(TAG, "Checking permission " + permission);
        if (getActivity().checkSelfPermission(permission) == 0) {
            return true;
        }
        return false;
    }

    public boolean[] hasPermissions(String[] permissions) {
        if (permissions == null) {
            Log.w(TAG, "No permission asked, no permissions returned");
            return new boolean[0];
        }
        int length = permissions.length;
        boolean[] grantResults = new boolean[length];
        for (int i = 0; i < length; i++) {
            Log.d(TAG, "Checking permission for " + permissions[i]);
            grantResults[i] = hasPermission(permissions[i]);
        }
        return grantResults;
    }

    public boolean shouldShowRational(String permission) {
        return Build.VERSION.SDK_INT >= 23 && getActivity().shouldShowRequestPermissionRationale(permission);
    }

    public void requestPermission(final String[] permissionArray, PermissionsCallback callback) {
        permissionsCallback = callback;
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Intent intent = DaydreamApi.createVrIntent(new ComponentName(PermissionsFragment.this.getContext(), TransitionVRActivity.class));
                intent.putExtra(TransitionVRActivity.PERMISSION_EXTRA, permissionArray);
                DaydreamApi.create(PermissionsFragment.this.getContext()).launchInVr(intent);
            }
        });
    }

    public static void setPermissionResult(boolean allGranted) {
        if (permissionsCallback != null) {
            permissionsCallback.onRequestPermissionResult(allGranted);
        } else {
            Log.w(TAG, "Permission callback object is null!");
        }
    }
}
