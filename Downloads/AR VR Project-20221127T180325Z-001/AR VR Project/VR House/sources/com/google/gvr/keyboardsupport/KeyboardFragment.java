package com.google.gvr.keyboardsupport;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import com.google.p000vr.ndk.base.DaydreamApi;

public class KeyboardFragment extends Fragment {
    public static final String FRAGMENT_TAG = "avr_KeyboardFragment";
    private static final String TAG = "KeyboardFragment";
    private static KeyboardCallback keyboardCallback = null;

    public interface KeyboardCallback {
        void onPlayStoreResult();
    }

    public static KeyboardFragment getInstance(Activity parentActivity) {
        KeyboardFragment fragment = (KeyboardFragment) parentActivity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            try {
                Log.i(TAG, "Creating PlayGamesFragment");
                KeyboardFragment fragment2 = new KeyboardFragment();
                try {
                    FragmentTransaction trans = parentActivity.getFragmentManager().beginTransaction();
                    trans.add(fragment2, FRAGMENT_TAG);
                    trans.commitAllowingStateLoss();
                    fragment = fragment2;
                } catch (Throwable th) {
                    th = th;
                    KeyboardFragment keyboardFragment = fragment2;
                    Log.e(TAG, "Cannot launch KeyboardFragment:" + th.getMessage(), th);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                Log.e(TAG, "Cannot launch KeyboardFragment:" + th.getMessage(), th);
                return null;
            }
        }
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void launchPlayStore(KeyboardCallback callback) {
        keyboardCallback = callback;
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                DaydreamApi.create(KeyboardFragment.this.getContext()).launchInVr(DaydreamApi.createVrIntent(new ComponentName(KeyboardFragment.this.getContext(), TransitionVRActivity.class)));
            }
        });
    }

    public static void callBackCall() {
        if (keyboardCallback != null) {
            keyboardCallback.onPlayStoreResult();
        } else {
            Log.w(TAG, "Keyboard callback object is null!");
        }
    }
}
