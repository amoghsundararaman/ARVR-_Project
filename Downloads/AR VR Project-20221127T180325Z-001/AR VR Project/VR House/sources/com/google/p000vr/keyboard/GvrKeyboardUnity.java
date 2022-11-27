package com.google.p000vr.keyboard;

import android.content.Context;

/* renamed from: com.google.vr.keyboard.GvrKeyboardUnity */
public class GvrKeyboardUnity {
    private native void nativeInitializeKeyboard(ClassLoader classLoader, Context context);

    public void initializeKeyboard(Context context) {
        nativeInitializeKeyboard(getClass().getClassLoader(), context);
    }

    static {
        System.loadLibrary("gvr_keyboard_shim_unity");
    }
}
