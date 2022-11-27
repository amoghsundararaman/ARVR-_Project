package com.unity3d.player;

/* renamed from: com.unity3d.player.n */
final class C0172n {

    /* renamed from: a */
    private static boolean f235a = false;

    /* renamed from: b */
    private boolean f236b;

    /* renamed from: c */
    private boolean f237c;

    /* renamed from: d */
    private boolean f238d;

    /* renamed from: e */
    private boolean f239e;

    C0172n() {
        this.f236b = !C0163j.f214c;
        this.f237c = false;
        this.f238d = false;
        this.f239e = true;
    }

    /* renamed from: a */
    static void m156a() {
        f235a = true;
    }

    /* renamed from: b */
    static void m157b() {
        f235a = false;
    }

    /* renamed from: c */
    static boolean m158c() {
        return f235a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1688a(boolean z) {
        this.f237c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo1689b(boolean z) {
        this.f239e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo1690c(boolean z) {
        this.f238d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo1691d() {
        this.f236b = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo1692e() {
        return this.f239e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo1693f() {
        return f235a && this.f237c && this.f236b && !this.f239e && !this.f238d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo1694g() {
        return this.f238d;
    }

    public final String toString() {
        return super.toString();
    }
}
