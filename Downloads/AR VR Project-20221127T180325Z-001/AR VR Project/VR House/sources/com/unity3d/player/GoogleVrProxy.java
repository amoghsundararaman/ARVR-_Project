package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import com.google.p000vr.cardboard.ConfigUtils;
import com.google.p000vr.ndk.base.Constants;
import com.unity3d.player.GoogleVrVideo;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

class GoogleVrProxy extends C0155c implements GoogleVrVideo {

    /* renamed from: f */
    private boolean f36f = false;

    /* renamed from: g */
    private boolean f37g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Runnable f38h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Vector f39i = new Vector();

    /* renamed from: j */
    private SurfaceView f40j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C0112a f41k = new C0112a();

    /* renamed from: l */
    private Thread f42l = null;

    /* renamed from: m */
    private Handler f43m = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 135711:
                    switch (message.arg1) {
                        case 2147483645:
                            Iterator it = GoogleVrProxy.this.f39i.iterator();
                            while (it.hasNext()) {
                                ((GoogleVrVideo.GoogleVrVideoCallbacks) it.next()).onFrameAvailable();
                            }
                            return;
                        case 2147483646:
                            Surface surface = (Surface) message.obj;
                            Iterator it2 = GoogleVrProxy.this.f39i.iterator();
                            while (it2.hasNext()) {
                                ((GoogleVrVideo.GoogleVrVideoCallbacks) it2.next()).onSurfaceAvailable(surface);
                            }
                            return;
                        default:
                            super.handleMessage(message);
                            return;
                    }
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* renamed from: com.unity3d.player.GoogleVrProxy$a */
    class C0112a {

        /* renamed from: a */
        public boolean f55a = false;

        /* renamed from: b */
        public boolean f56b = false;

        /* renamed from: c */
        public boolean f57c = false;

        /* renamed from: d */
        public boolean f58d = false;

        /* renamed from: e */
        public boolean f59e = true;

        /* renamed from: f */
        public boolean f60f = false;

        C0112a() {
        }

        /* renamed from: a */
        public final boolean mo1518a() {
            return this.f55a && this.f56b;
        }

        /* renamed from: b */
        public final void mo1519b() {
            this.f55a = false;
            this.f56b = false;
            this.f58d = false;
            this.f59e = true;
            this.f60f = false;
        }
    }

    public GoogleVrProxy(C0159f fVar) {
        super("Google VR", fVar);
        initVrJni();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25a(boolean z) {
        this.f41k.f58d = z;
    }

    /* renamed from: a */
    private static boolean m26a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private boolean m27a(ClassLoader classLoader) {
        try {
            Class<?> loadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            C0173o oVar = new C0173o(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            oVar.mo1697a("initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, Boolean.TYPE, Handler.class});
            oVar.mo1697a("deinitialize", new Class[0]);
            oVar.mo1697a("load", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Runnable.class});
            oVar.mo1697a("enable", new Class[]{Boolean.TYPE});
            oVar.mo1697a("unload", new Class[0]);
            oVar.mo1697a("pause", new Class[0]);
            oVar.mo1697a("resume", new Class[0]);
            oVar.mo1697a("getGvrLayout", new Class[0]);
            oVar.mo1697a("getVideoSurfaceId", new Class[0]);
            oVar.mo1697a("getVideoSurface", new Class[0]);
            this.f202a = oVar;
            return true;
        } catch (Exception e) {
            reportError("Exception initializing GoogleVR from Unity library. " + e.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m30d() {
        return this.f41k.f58d;
    }

    /* renamed from: e */
    private void m32e() {
        Activity activity = (Activity) this.f204c;
        if (this.f37g && !this.f41k.f60f && activity != null) {
            this.f41k.f60f = true;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            activity.startActivity(intent);
        }
    }

    private final native void initVrJni();

    private final native boolean isQuiting();

    private final native void setVrVideoTransform(float[][] fArr);

    /* renamed from: a */
    public final void mo1499a(Intent intent) {
        if (intent != null && intent.getBooleanExtra(Constants.EXTRA_VR_LAUNCH, false)) {
            this.f37g = true;
        }
    }

    /* renamed from: a */
    public final boolean mo1500a() {
        return this.f41k.f55a;
    }

    /* renamed from: a */
    public final boolean mo1501a(Activity activity, Context context, SurfaceView surfaceView, Runnable runnable) {
        boolean z;
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            reportError("Invalid parameters passed to Google VR initiialization.");
            return false;
        }
        this.f41k.mo1519b();
        this.f204c = context;
        this.f38h = runnable;
        if (!m26a(19)) {
            reportError("Google VR requires a device that supports an api version of 19 (KitKat) or better.");
            return false;
        } else if (this.f37g && !m26a(24)) {
            reportError("Daydream requires a device that supports an api version of 24 (Nougat) or better.");
            return false;
        } else if (!m27a(UnityPlayer.class.getClassLoader())) {
            return false;
        } else {
            try {
                z = ((Boolean) this.f202a.mo1696a("initialize", activity, context, surfaceView, Boolean.valueOf(this.f37g), this.f43m)).booleanValue();
            } catch (Exception e) {
                reportError("Exception while trying to intialize Unity Google VR Library. " + e.getLocalizedMessage());
                z = false;
            }
            if (!z) {
                reportError("Unable to initialize GoogleVR library.");
                return false;
            }
            this.f40j = surfaceView;
            this.f41k.f55a = true;
            this.f205d = "";
            return true;
        }
    }

    /* renamed from: b */
    public final void mo1502b() {
        resumeGvrLayout();
    }

    /* renamed from: c */
    public final void mo1503c() {
        if (this.f40j != null) {
            this.f40j.getHolder().setSizeFromLayout();
        }
    }

    public void deregisterGoogleVrVideoListener(GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.f39i.contains(googleVrVideoCallbacks)) {
            googleVrVideoCallbacks.onSurfaceUnavailable();
            this.f39i.remove(googleVrVideoCallbacks);
        }
    }

    /* access modifiers changed from: protected */
    public Object getVideoSurface() {
        if (!m30d() || this.f41k.f59e) {
            return null;
        }
        try {
            return this.f202a.mo1696a("getVideoSurface", new Object[0]);
        } catch (Exception e) {
            reportError("Exception caught while Getting GoogleVR Video Surface. " + e.getLocalizedMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public int getVideoSurfaceId() {
        if (!m30d() || this.f41k.f59e) {
            return -1;
        }
        try {
            return ((Integer) this.f202a.mo1696a("getVideoSurfaceId", new Object[0])).intValue();
        } catch (Exception e) {
            reportError("Exception caught while getting Video Surface ID from GoogleVR. " + e.getLocalizedMessage());
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public long loadGoogleVr(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!this.f41k.f55a) {
            return 0;
        }
        final AtomicLong atomicLong = new AtomicLong(0);
        this.f205d = (z || z2) ? "Daydream" : ConfigUtils.CARDBOARD_CONFIG_FOLDER;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final boolean z10 = z5;
        if (!runOnUiThreadWithSync(new Runnable() {
            public final void run() {
                try {
                    atomicLong.set(((Long) GoogleVrProxy.this.f202a.mo1696a("load", Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), GoogleVrProxy.this.f38h)).longValue());
                    GoogleVrProxy.this.f41k.f56b = true;
                } catch (Exception e) {
                    GoogleVrProxy.this.reportError("Exception caught while loading GoogleVR. " + e.getLocalizedMessage());
                    atomicLong.set(0);
                }
            }
        }) || atomicLong.longValue() == 0) {
            reportError("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    /* access modifiers changed from: protected */
    public void pauseGvrLayout() {
        if (this.f41k.mo1518a() && !this.f41k.f59e) {
            if (m30d()) {
                Iterator it = this.f39i.iterator();
                while (it.hasNext()) {
                    ((GoogleVrVideo.GoogleVrVideoCallbacks) it.next()).onSurfaceUnavailable();
                }
            }
            if (this.f202a != null) {
                this.f202a.mo1696a("pause", new Object[0]);
            }
            this.f41k.f59e = true;
        }
    }

    public void registerGoogleVrVideoListener(GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (!this.f39i.contains(googleVrVideoCallbacks)) {
            this.f39i.add(googleVrVideoCallbacks);
            Surface surface = (Surface) getVideoSurface();
            if (surface != null) {
                googleVrVideoCallbacks.onSurfaceAvailable(surface);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resumeGvrLayout() {
        if (this.f41k.mo1518a() && this.f41k.f59e) {
            if (this.f202a != null) {
                this.f202a.mo1696a("resume", new Object[0]);
            }
            this.f41k.f59e = false;
        }
    }

    /* access modifiers changed from: protected */
    public void setGoogleVrModeEnabled(final boolean z) {
        if (this.f41k.mo1518a() && this.f203b != null && this.f204c != null) {
            if (!z && isQuiting()) {
                m32e();
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (z != GoogleVrProxy.this.m30d()) {
                        try {
                            if (!z || GoogleVrProxy.this.m30d()) {
                                if (!z && GoogleVrProxy.this.m30d()) {
                                    GoogleVrProxy.this.m25a(false);
                                    if (GoogleVrProxy.this.f202a != null) {
                                        GoogleVrProxy.this.f202a.mo1696a("enable", false);
                                    }
                                    if (GoogleVrProxy.this.f202a != null && GoogleVrProxy.this.f203b != null) {
                                        GoogleVrProxy.this.f203b.removeViewFromPlayer((View) GoogleVrProxy.this.f202a.mo1696a("getGvrLayout", new Object[0]));
                                    }
                                }
                            } else if (GoogleVrProxy.this.f202a == null || GoogleVrProxy.this.f203b == null || GoogleVrProxy.this.f203b.addViewToPlayer((View) GoogleVrProxy.this.f202a.mo1696a("getGvrLayout", new Object[0]), true)) {
                                if (GoogleVrProxy.this.f202a != null) {
                                    GoogleVrProxy.this.f202a.mo1696a("enable", true);
                                }
                                GoogleVrProxy.this.m25a(true);
                            } else {
                                GoogleVrProxy.this.reportError("Unable to add Google VR to view hierarchy.");
                            }
                        } catch (Exception e) {
                            GoogleVrProxy.this.reportError("Exception enabling Google VR on UI Thread. " + e.getLocalizedMessage());
                        }
                    }
                }
            });
        }
    }

    public void setVideoLocationTransform(float[] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{4, 4});
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                fArr2[i][i2] = fArr[(i * 4) + i2];
            }
        }
        setVrVideoTransform(fArr2);
    }

    /* access modifiers changed from: protected */
    public void unloadGoogleVr() {
        if (this.f41k.f58d) {
            setGoogleVrModeEnabled(false);
        }
        if (this.f41k.f57c) {
            this.f41k.f57c = false;
        }
        this.f40j = null;
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    if (GoogleVrProxy.this.f202a != null) {
                        GoogleVrProxy.this.f202a.mo1696a("unload", new Object[0]);
                        GoogleVrProxy.this.f202a.mo1696a("deinitialize", new Object[0]);
                        GoogleVrProxy.this.f202a = null;
                    }
                    GoogleVrProxy.this.f41k.f56b = false;
                } catch (Exception e) {
                    GoogleVrProxy.this.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }
}
