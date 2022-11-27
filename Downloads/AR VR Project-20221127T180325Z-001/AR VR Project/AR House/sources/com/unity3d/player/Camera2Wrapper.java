package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;

public class Camera2Wrapper implements C0054d {

    /* renamed from: a */
    private Context f3a;

    /* renamed from: b */
    private C0042a f4b = null;

    /* renamed from: c */
    private final int f5c = 100;

    public Camera2Wrapper(Context context) {
        this.f3a = context;
        initCamera2Jni();
    }

    /* renamed from: a */
    private static int m2a(float f) {
        return (int) Math.min(Math.max((f * 2000.0f) - 0.0040893555f, -900.0f), 900.0f);
    }

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    /* renamed from: a */
    public final void mo4a() {
        closeCamera2();
    }

    /* renamed from: a */
    public final void mo5a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    /* renamed from: a */
    public final void mo6a(Object obj, Object obj2, Object obj3, int i, int i2, int i3) {
        nativeFrameReady(obj, obj2, obj3, i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void closeCamera2() {
        C0042a aVar = this.f4b;
        if (aVar != null) {
            aVar.mo172b();
        }
        this.f4b = null;
    }

    /* access modifiers changed from: protected */
    public int getCamera2Count() {
        if (C0060j.f208b) {
            return C0042a.m102a(this.f3a);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int[] getCamera2Resolutions(int i) {
        if (C0060j.f208b) {
            return C0042a.m124d(this.f3a, i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getCamera2SensorOrientation(int i) {
        if (C0060j.f208b) {
            return C0042a.m103a(this.f3a, i);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public Object getCameraFocusArea(float f, float f2) {
        int a = m2a(f);
        int a2 = m2a(1.0f - f2);
        return new Camera.Area(new Rect(a - 100, a2 - 100, a + 100, a2 + 100), 1000);
    }

    /* access modifiers changed from: protected */
    public Rect getFrameSizeCamera2() {
        C0042a aVar = this.f4b;
        return aVar != null ? aVar.mo169a() : new Rect();
    }

    /* access modifiers changed from: protected */
    public boolean initializeCamera2(int i, int i2, int i3, int i4, int i5) {
        if (!C0060j.f208b || this.f4b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        this.f4b = new C0042a(this);
        return this.f4b.mo171a(this.f3a, i, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public boolean isCamera2AutoFocusPointSupported(int i) {
        if (C0060j.f208b) {
            return C0042a.m121c(this.f3a, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isCamera2FrontFacing(int i) {
        if (C0060j.f208b) {
            return C0042a.m119b(this.f3a, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void pauseCamera2() {
        C0042a aVar = this.f4b;
        if (aVar != null) {
            aVar.mo174d();
        }
    }

    /* access modifiers changed from: protected */
    public boolean setAutoFocusPoint(float f, float f2) {
        C0042a aVar;
        if (!C0060j.f208b || (aVar = this.f4b) == null) {
            return false;
        }
        return aVar.mo170a(f, f2);
    }

    /* access modifiers changed from: protected */
    public void startCamera2() {
        C0042a aVar = this.f4b;
        if (aVar != null) {
            aVar.mo173c();
        }
    }

    /* access modifiers changed from: protected */
    public void stopCamera2() {
        C0042a aVar = this.f4b;
        if (aVar != null) {
            aVar.mo175e();
        }
    }
}
