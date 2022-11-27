package com.unity3d.player;

import android.os.Build;

/* renamed from: com.unity3d.player.j */
public final class C0163j {

    /* renamed from: a */
    static final boolean f212a = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: b */
    static final boolean f213b = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: c */
    static final boolean f214c;

    /* renamed from: d */
    static final C0158e f215d;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            z = false;
        }
        f214c = z;
        f215d = z ? new C0161h() : null;
    }
}
