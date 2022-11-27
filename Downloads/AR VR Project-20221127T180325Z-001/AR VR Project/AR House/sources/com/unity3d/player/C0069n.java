package com.unity3d.player;

/* renamed from: com.unity3d.player.n */
final class C0069n {

    /* renamed from: a */
    private static boolean f230a = false;

    /* renamed from: b */
    private boolean f231b = false;

    /* renamed from: c */
    private boolean f232c = false;

    /* renamed from: d */
    private boolean f233d = true;

    /* renamed from: e */
    private boolean f234e = false;

    C0069n() {
    }

    /* renamed from: a */
    static void m169a() {
        f230a = true;
    }

    /* renamed from: b */
    static void m170b() {
        f230a = false;
    }

    /* renamed from: c */
    static boolean m171c() {
        return f230a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo226a(boolean z) {
        this.f231b = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo227b(boolean z) {
        this.f233d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo228c(boolean z) {
        this.f234e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo229d(boolean z) {
        this.f232c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo230d() {
        return this.f233d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo231e() {
        return this.f234e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo232f() {
        return f230a && this.f231b && !this.f233d && !this.f232c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo233g() {
        return this.f232c;
    }

    public final String toString() {
        return super.toString();
    }
}
