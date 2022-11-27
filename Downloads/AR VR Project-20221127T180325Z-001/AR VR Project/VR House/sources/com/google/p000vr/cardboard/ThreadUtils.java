package com.google.p000vr.cardboard;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.google.vr.cardboard.ThreadUtils */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Handler uiHandler = new Handler(Looper.getMainLooper());

    public static void runOnUiThread(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
        } else {
            uiHandler.post(runnable);
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        uiHandler.post(runnable);
    }

    public static boolean runningOnUiThread() {
        return uiHandler.getLooper() == Looper.myLooper();
    }

    public static void assertOnUiThread() {
    }

    public static void throwIfNotOnUiThread() {
        if (!runningOnUiThread()) {
            throw new IllegalStateException("Call was not made on the UI thread.");
        }
    }

    public static Handler getUiThreadHandler() {
        return uiHandler;
    }
}
