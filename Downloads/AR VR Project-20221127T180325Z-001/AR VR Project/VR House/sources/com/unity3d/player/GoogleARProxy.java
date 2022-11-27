package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;

class GoogleARProxy extends C0155c {

    /* renamed from: f */
    private boolean f29f = false;

    GoogleARProxy(C0159f fVar) {
        super("Google AR", fVar);
    }

    /* renamed from: a */
    public static boolean m13a() {
        try {
            Class<?> loadClass = UnityPlayer.class.getClassLoader().loadClass("com.unity3d.unitygar.GoogleAR");
            C0173o oVar = new C0173o(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            oVar.mo1697a("getClassVersion", new Class[0]);
            if (((Number) oVar.mo1696a("getClassVersion", new Object[0])).intValue() > 0) {
                Log.d("Unity", "Loading ARCore V1+ path.");
                return false;
            }
            Log.d("Unity", "Loading ARCore Preview path (Version <= 1).");
            return true;
        } catch (Exception e) {
            Log.d("Unity", "Loading ARCore Preview path.");
            return true;
        }
    }

    /* renamed from: a */
    private boolean m14a(ClassLoader classLoader) {
        if (this.f29f) {
            return true;
        }
        try {
            Class<?> loadClass = classLoader.loadClass("com.unity3d.unitygar.GoogleAR");
            C0173o oVar = new C0173o(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            oVar.mo1697a("initialize", new Class[]{Activity.class});
            oVar.mo1697a("create", new Class[0]);
            oVar.mo1697a("pause", new Class[0]);
            oVar.mo1697a("resume", new Class[0]);
            this.f202a = oVar;
            this.f29f = true;
            return true;
        } catch (Exception e) {
            this.f203b.reportError("Google AR Error", e.toString() + e.getLocalizedMessage());
            return false;
        }
    }

    private final native void tangoOnCreate(Activity activity);

    private final native void tangoOnServiceConnected(IBinder iBinder);

    private final native void tangoOnStop();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1490a(final Activity activity, Context context) {
        if (m14a(UnityPlayer.class.getClassLoader())) {
            this.f204c = context;
            runOnUiThread(new Runnable() {
                public final void run() {
                    try {
                        if (GoogleARProxy.this.f202a != null) {
                            GoogleARProxy.this.f202a.mo1696a("initialize", activity);
                        }
                    } catch (Exception e) {
                        GoogleARProxy.this.reportError("Exception creating " + GoogleARProxy.this.f206e + " VR on UI Thread. " + e.getLocalizedMessage());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo1491b() {
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    if (GoogleARProxy.this.f202a != null) {
                        GoogleARProxy.this.f202a.mo1696a("create", new Object[0]);
                    }
                } catch (Exception e) {
                    GoogleARProxy.this.reportError("Exception creating " + GoogleARProxy.this.f206e + " VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo1492c() {
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    if (GoogleARProxy.this.f202a != null) {
                        GoogleARProxy.this.f202a.mo1696a("pause", new Object[0]);
                    }
                } catch (Exception e) {
                    GoogleARProxy.this.reportError("Exception pausing " + GoogleARProxy.this.f206e + " VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo1493d() {
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    if (GoogleARProxy.this.f202a != null) {
                        GoogleARProxy.this.f202a.mo1696a("resume", new Object[0]);
                    }
                } catch (Exception e) {
                    GoogleARProxy.this.reportError("Exception resuming " + GoogleARProxy.this.f206e + " VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }

    /* renamed from: e */
    public final boolean mo1494e() {
        return this.f29f;
    }
}
