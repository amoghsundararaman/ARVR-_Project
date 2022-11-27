package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;

public class Camera2Wrapper implements C0157d {

    /* renamed from: a */
    private Context f27a;

    /* renamed from: b */
    private C0147a f28b = null;

    public Camera2Wrapper(Context context) {
        this.f27a = context;
        initCamera2Jni();
    }

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    /* renamed from: a */
    public final void mo1477a() {
        closeCamera2();
    }

    /* renamed from: a */
    public final void mo1478a(Object obj, Object obj2, Object obj3, int i, int i2, int i3) {
        nativeFrameReady(obj, obj2, obj3, i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void closeCamera2() {
        if (this.f28b != null) {
            this.f28b.mo1640b();
        }
        this.f28b = null;
    }

    /* access modifiers changed from: protected */
    public int getCamera2Count() {
        if (C0163j.f213b) {
            return C0147a.m109a(this.f27a);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getCamera2SensorOrientation(int i) {
        if (C0163j.f213b) {
            return C0147a.m110a(this.f27a, i);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public Rect getFrameSizeCamera2() {
        return this.f28b != null ? this.f28b.mo1638a() : new Rect();
    }

    /* access modifiers changed from: protected */
    public boolean initializeCamera2(int i, int i2, int i3, int i4) {
        if (!C0163j.f213b || this.f28b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        this.f28b = new C0147a(this);
        return this.f28b.mo1639a(this.f27a, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public boolean isCamera2FrontFacing(int i) {
        if (C0163j.f213b) {
            return C0147a.m119b(this.f27a, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void startCamera2() {
        if (this.f28b != null) {
            this.f28b.mo1641c();
        }
    }

    /* access modifiers changed from: protected */
    public void stopCamera2() {
        if (this.f28b != null) {
            this.f28b.mo1642d();
        }
    }
}
