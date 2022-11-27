package com.unity3d.player;

import android.os.Build;
import java.lang.Thread;

/* renamed from: com.unity3d.player.m */
final class C0171m implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private volatile Thread.UncaughtExceptionHandler f234a;

    C0171m() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized boolean mo1686a() {
        boolean z;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f234a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", new Object[]{thread.getName()}) + String.format("Unity version     : %s\n", new Object[]{"2018.2.3f1"}) + String.format("Device model      : %s %s\n", new Object[]{Build.MANUFACTURER, Build.MODEL}) + String.format("Device fingerprint: %s\n", new Object[]{Build.FINGERPRINT}));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f234a.uncaughtException(thread, error);
        } catch (Throwable th2) {
            this.f234a.uncaughtException(thread, th);
        }
        return;
    }
}
