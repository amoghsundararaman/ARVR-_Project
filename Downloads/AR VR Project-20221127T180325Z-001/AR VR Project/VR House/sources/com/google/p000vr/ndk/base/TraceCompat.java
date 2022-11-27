package com.google.p000vr.ndk.base;

import android.os.Build;
import android.os.Trace;

/* renamed from: com.google.vr.ndk.base.TraceCompat */
class TraceCompat {
    TraceCompat() {
    }

    static void beginSection(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
