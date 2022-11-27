package com.unity3d.player;

import android.os.Build;

/* renamed from: com.unity3d.player.j */
public final class C0060j {

    /* renamed from: a */
    static final boolean f207a = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: b */
    static final boolean f208b = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: c */
    static final boolean f209c;

    /* renamed from: d */
    static final C0055e f210d;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            z = false;
        }
        f209c = z;
        f210d = z ? new C0058h() : null;
    }
}
