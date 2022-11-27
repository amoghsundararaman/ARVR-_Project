package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.google.p000vr.ndk.base.Constants;
import com.unity3d.player.C0168l;
import com.unity3d.player.C0178q;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnityPlayer extends FrameLayout implements C0159f {
    public static Activity currentActivity = null;

    /* renamed from: t */
    private static boolean f70t;

    /* renamed from: a */
    C0141e f71a = new C0141e(this, (byte) 0);

    /* renamed from: b */
    C0164k f72b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f73c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f74d = false;

    /* renamed from: e */
    private boolean f75e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0172n f76f = new C0172n();

    /* renamed from: g */
    private final ConcurrentLinkedQueue f77g = new ConcurrentLinkedQueue();

    /* renamed from: h */
    private BroadcastReceiver f78h = null;

    /* renamed from: i */
    private boolean f79i = false;

    /* renamed from: j */
    private C0139c f80j = new C0139c(this, (byte) 0);

    /* renamed from: k */
    private TelephonyManager f81k;

    /* renamed from: l */
    private ClipboardManager f82l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C0168l f83m;

    /* renamed from: n */
    private GoogleARProxy f84n = null;

    /* renamed from: o */
    private GoogleARCoreApi f85o = null;

    /* renamed from: p */
    private C0137a f86p = new C0137a();

    /* renamed from: q */
    private Camera2Wrapper f87q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Context f88r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SurfaceView f89s;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f90u;

    /* renamed from: v */
    private boolean f91v;

    /* renamed from: w */
    private boolean f92w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C0178q f93x;

    /* renamed from: com.unity3d.player.UnityPlayer$3 */
    class C01303 extends BroadcastReceiver {

        /* renamed from: a */
        final /* synthetic */ UnityPlayer f120a;

        public void onReceive(Context context, Intent intent) {
            this.f120a.m66c();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$a */
    class C0137a implements SensorEventListener {
        C0137a() {
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$b */
    enum C0138b {
        ;

        static {
            f140a = 1;
            f141b = 2;
            f142c = 3;
            f143d = new int[]{f140a, f141b, f142c};
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$c */
    private class C0139c extends PhoneStateListener {
        private C0139c() {
        }

        /* synthetic */ C0139c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        public final void onCallStateChanged(int i, String str) {
            boolean z = true;
            UnityPlayer unityPlayer = UnityPlayer.this;
            if (i != 1) {
                z = false;
            }
            unityPlayer.nativeMuteMasterAudio(z);
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$d */
    enum C0140d {
        PAUSE,
        RESUME,
        QUIT,
        SURFACE_LOST,
        SURFACE_ACQUIRED,
        FOCUS_LOST,
        FOCUS_GAINED,
        NEXT_FRAME
    }

    /* renamed from: com.unity3d.player.UnityPlayer$e */
    private class C0141e extends Thread {

        /* renamed from: a */
        Handler f154a;

        /* renamed from: b */
        boolean f155b;

        /* renamed from: c */
        boolean f156c;

        /* renamed from: d */
        int f157d;

        /* renamed from: e */
        int f158e;

        private C0141e() {
            this.f155b = false;
            this.f156c = false;
            this.f157d = C0138b.f141b;
            this.f158e = 5;
        }

        /* synthetic */ C0141e(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        private void m99a(C0140d dVar) {
            Message.obtain(this.f154a, 2269, dVar).sendToTarget();
        }

        /* renamed from: a */
        public final void mo1594a() {
            m99a(C0140d.QUIT);
        }

        /* renamed from: a */
        public final void mo1595a(Runnable runnable) {
            m99a(C0140d.PAUSE);
            Message.obtain(this.f154a, runnable).sendToTarget();
        }

        /* renamed from: b */
        public final void mo1596b() {
            m99a(C0140d.RESUME);
        }

        /* renamed from: b */
        public final void mo1597b(Runnable runnable) {
            m99a(C0140d.SURFACE_LOST);
            Message.obtain(this.f154a, runnable).sendToTarget();
        }

        /* renamed from: c */
        public final void mo1598c() {
            m99a(C0140d.FOCUS_GAINED);
        }

        /* renamed from: c */
        public final void mo1599c(Runnable runnable) {
            Message.obtain(this.f154a, runnable).sendToTarget();
            m99a(C0140d.SURFACE_ACQUIRED);
        }

        /* renamed from: d */
        public final void mo1600d() {
            m99a(C0140d.FOCUS_LOST);
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f154a = new Handler(new Handler.Callback() {
                /* renamed from: a */
                private void m107a() {
                    if (C0141e.this.f157d == C0138b.f142c && C0141e.this.f156c) {
                        UnityPlayer.this.nativeFocusChanged(true);
                        C0141e.this.f157d = C0138b.f140a;
                    }
                }

                public final boolean handleMessage(Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    C0140d dVar = (C0140d) message.obj;
                    if (dVar == C0140d.NEXT_FRAME) {
                        return true;
                    }
                    if (dVar == C0140d.QUIT) {
                        Looper.myLooper().quit();
                    } else if (dVar == C0140d.RESUME) {
                        C0141e.this.f155b = true;
                    } else if (dVar == C0140d.PAUSE) {
                        C0141e.this.f155b = false;
                    } else if (dVar == C0140d.SURFACE_LOST) {
                        C0141e.this.f156c = false;
                    } else if (dVar == C0140d.SURFACE_ACQUIRED) {
                        C0141e.this.f156c = true;
                        m107a();
                    } else if (dVar == C0140d.FOCUS_LOST) {
                        if (C0141e.this.f157d == C0138b.f140a) {
                            UnityPlayer.this.nativeFocusChanged(false);
                        }
                        C0141e.this.f157d = C0138b.f141b;
                    } else if (dVar == C0140d.FOCUS_GAINED) {
                        C0141e.this.f157d = C0138b.f142c;
                        m107a();
                    }
                    return true;
                }
            });
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public final boolean queueIdle() {
                    UnityPlayer.this.executeGLThreadJobs();
                    if (C0141e.this.f155b && C0141e.this.f156c) {
                        if (C0141e.this.f158e >= 0) {
                            if (C0141e.this.f158e == 0 && UnityPlayer.this.m78i()) {
                                UnityPlayer.this.m50a();
                            }
                            C0141e eVar = C0141e.this;
                            eVar.f158e--;
                        }
                        if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.m66c();
                        }
                        Message.obtain(C0141e.this.f154a, 2269, C0140d.NEXT_FRAME).sendToTarget();
                    }
                    return true;
                }
            });
            Looper.loop();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$f */
    private abstract class C0144f implements Runnable {
        private C0144f() {
        }

        /* synthetic */ C0144f(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo1570a();

        public final void run() {
            if (!UnityPlayer.this.isFinishing()) {
                mo1570a();
            }
        }
    }

    static {
        new C0171m().mo1686a();
        f70t = false;
        f70t = loadLibraryStatic("main");
    }

    public UnityPlayer(Context context) {
        super(context);
        if (context instanceof Activity) {
            currentActivity = (Activity) context;
            this.f73c = currentActivity.getRequestedOrientation();
        }
        m52a(currentActivity);
        this.f88r = context;
        if (currentActivity != null && m78i()) {
            this.f83m = new C0168l(this.f88r, C0168l.C0170a.m154a()[getSplashMode()]);
            addView(this.f83m);
        }
        if (C0163j.f214c) {
            if (currentActivity != null) {
                C0163j.f215d.mo1669a(currentActivity, new Runnable() {
                    public final void run() {
                        UnityPlayer.this.mo1527a((Runnable) new Runnable() {
                            public final void run() {
                                UnityPlayer.this.f76f.mo1691d();
                                UnityPlayer.this.m72f();
                            }
                        });
                    }
                });
            } else {
                this.f76f.mo1691d();
            }
        }
        m53a(this.f88r.getApplicationInfo());
        if (!C0172n.m158c()) {
            AlertDialog create = new AlertDialog.Builder(this.f88r).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.m66c();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.f89s = m61b();
        addView(this.f89s);
        bringChildToFront(this.f83m);
        this.f90u = false;
        nativeInitWebRequest(UnityWebRequest.class);
        m82k();
        this.f81k = (TelephonyManager) this.f88r.getSystemService("phone");
        this.f82l = (ClipboardManager) this.f88r.getSystemService("clipboard");
        this.f87q = new Camera2Wrapper(this.f88r);
        this.f71a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!C0172n.m158c()) {
            C0160g.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
        } else {
            nativeUnitySendMessage(str, str2, str3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m50a() {
        mo1527a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer.this.removeView(UnityPlayer.this.f83m);
                C0168l unused = UnityPlayer.this.f83m = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m51a(int i, Surface surface) {
        if (!this.f74d) {
            m65b(0, surface);
        }
    }

    /* renamed from: a */
    private static void m52a(Activity activity) {
        View decorView;
        if (activity != null && activity.getIntent().getBooleanExtra(Constants.EXTRA_VR_LAUNCH, false) && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setSystemUiVisibility(7);
        }
    }

    /* renamed from: a */
    private static void m53a(ApplicationInfo applicationInfo) {
        if (f70t && NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C0172n.m156a();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m54a(android.view.View r5, android.view.View r6) {
        /*
            r4 = this;
            r3 = 0
            com.unity3d.player.n r0 = r4.f76f
            boolean r0 = r0.mo1692e()
            if (r0 != 0) goto L_0x0045
            r4.pause()
            r0 = 1
            r2 = r0
        L_0x000e:
            if (r5 == 0) goto L_0x002f
            android.view.ViewParent r1 = r5.getParent()
            boolean r0 = r1 instanceof com.unity3d.player.UnityPlayer
            if (r0 == 0) goto L_0x001d
            r0 = r1
            com.unity3d.player.UnityPlayer r0 = (com.unity3d.player.UnityPlayer) r0
            if (r0 == r4) goto L_0x002f
        L_0x001d:
            boolean r0 = r1 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0026
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r1.removeView(r5)
        L_0x0026:
            r4.addView(r5)
            r4.bringChildToFront(r5)
            r5.setVisibility(r3)
        L_0x002f:
            if (r6 == 0) goto L_0x003f
            android.view.ViewParent r0 = r6.getParent()
            if (r0 != r4) goto L_0x003f
            r0 = 8
            r6.setVisibility(r0)
            r4.removeView(r6)
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r4.resume()
        L_0x0044:
            return
        L_0x0045:
            r2 = r3
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.UnityPlayer.m54a(android.view.View, android.view.View):void");
    }

    /* renamed from: a */
    private void m55a(C0144f fVar) {
        if (!isFinishing()) {
            m64b((Runnable) fVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public SurfaceView m61b() {
        SurfaceView surfaceView = new SurfaceView(this.f88r);
        surfaceView.getHolder().setFormat(-3);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.m51a(0, surfaceHolder.getSurface());
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m51a(0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m51a(0, (Surface) null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* renamed from: b */
    private void m64b(Runnable runnable) {
        if (C0172n.m158c()) {
            if (Thread.currentThread() == this.f71a) {
                runnable.run();
            } else {
                this.f77g.add(runnable);
            }
        }
    }

    /* renamed from: b */
    private boolean m65b(final int i, final Surface surface) {
        if (!C0172n.m158c()) {
            return false;
        }
        final Semaphore semaphore = new Semaphore(0);
        C012518 r0 = new Runnable() {
            public final void run() {
                UnityPlayer.this.nativeRecreateGfxState(i, surface);
                semaphore.release();
            }
        };
        if (i != 0) {
            r0.run();
        } else if (surface == null) {
            this.f71a.mo1597b(r0);
        } else {
            this.f71a.mo1599c(r0);
        }
        if (surface == null && i == 0) {
            try {
                if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                    C0160g.Log(5, "Timeout while trying detaching primary window.");
                }
            } catch (InterruptedException e) {
                C0160g.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m66c() {
        if ((this.f88r instanceof Activity) && !((Activity) this.f88r).isFinishing()) {
            ((Activity) this.f88r).finish();
        }
    }

    /* renamed from: d */
    private void m68d() {
        reportSoftInputStr((String) null, 1, true);
        if (this.f76f.mo1694g()) {
            if (C0172n.m158c()) {
                final Semaphore semaphore = new Semaphore(0);
                this.f71a.mo1595a(isFinishing() ? new Runnable() {
                    public final void run() {
                        UnityPlayer.this.m71e();
                        semaphore.release();
                    }
                } : new Runnable() {
                    public final void run() {
                        if (UnityPlayer.this.nativePause()) {
                            boolean unused = UnityPlayer.this.f90u = true;
                            UnityPlayer.this.m71e();
                            semaphore.release(2);
                            return;
                        }
                        semaphore.release();
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        C0160g.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException e) {
                    C0160g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.f76f.mo1690c(false);
            this.f76f.mo1689b(true);
            if (this.f79i) {
                this.f81k.listen(this.f80j, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m71e() {
        this.f91v = nativeShouldQuit();
        this.f92w = true;
        nativeDone();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m72f() {
        if (this.f76f.mo1693f()) {
            this.f76f.mo1690c(true);
            m64b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f71a.mo1596b();
        }
    }

    /* renamed from: g */
    private static void m75g() {
        if (C0172n.m158c()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            C0172n.m157b();
        }
    }

    /* renamed from: h */
    private ApplicationInfo m76h() {
        return this.f88r.getPackageManager().getApplicationInfo(this.f88r.getPackageName(), 128);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m78i() {
        try {
            return m76h().metaData.getBoolean("unity.splash-enable");
        } catch (Exception e) {
            return false;
        }
    }

    private final native void initJni(Context context);

    /* renamed from: j */
    private boolean m81j() {
        try {
            return m76h().metaData.getBoolean("unity.tango-enable");
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: k */
    private void m82k() {
        if (this.f88r instanceof Activity) {
            ((Activity) this.f88r).getWindow().setFlags(1024, 1024);
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            C0160g.Log(6, "Unable to find " + str);
            return false;
        } catch (Exception e2) {
            C0160g.Log(6, "Unknown error " + e2);
            return false;
        }
    }

    private final native void nativeDone();

    /* access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWebRequest(Class cls);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* access modifiers changed from: private */
    public final native boolean nativePause();

    /* access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i, Surface surface);

    /* access modifiers changed from: private */
    public final native boolean nativeRender();

    private final native void nativeRestartActivityIndicator();

    /* access modifiers changed from: private */
    public final native void nativeResume();

    /* access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    private final native boolean nativeShouldQuit();

    /* access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, String str3);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1527a(Runnable runnable) {
        if (this.f88r instanceof Activity) {
            ((Activity) this.f88r).runOnUiThread(runnable);
        } else {
            C0160g.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    /* access modifiers changed from: protected */
    public void addPhoneCallListener() {
        this.f79i = true;
        this.f81k.listen(this.f80j, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        boolean z2 = true;
        m54a(view, (View) z ? this.f89s : null);
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.f89s.getParent() == null;
        boolean z5 = this.f89s.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                C0160g.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                C0160g.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        if (this.f89s instanceof SurfaceView) {
            this.f89s.getHolder().setSizeFromLayout();
        }
        if (this.f93x != null) {
            this.f93x.mo1728c();
        }
        GoogleVrProxy b = GoogleVrApi.m22b();
        if (b != null) {
            b.mo1503c();
        }
    }

    /* access modifiers changed from: protected */
    public void disableLogger() {
        C0160g.f210a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f74d = surface != null;
            mo1527a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.f74d) {
                        UnityPlayer.this.removeView(UnityPlayer.this.f89s);
                    } else {
                        UnityPlayer.this.addView(UnityPlayer.this.f89s);
                    }
                }
            });
        }
        return m65b(i, surface);
    }

    /* access modifiers changed from: protected */
    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f77g.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getClipboardText() {
        ClipData primaryClip = this.f82l.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.f88r).toString() : "";
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    /* access modifiers changed from: protected */
    public int getSplashMode() {
        try {
            return m76h().metaData.getInt("unity.splash-mode");
        } catch (Exception e) {
            return 0;
        }
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        final C01336 r0 = new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f72b != null) {
                    UnityPlayer.this.f72b.dismiss();
                    UnityPlayer.this.f72b = null;
                }
            }
        };
        if (C0163j.f213b) {
            m55a((C0144f) new C0144f() {
                /* renamed from: a */
                public final void mo1570a() {
                    UnityPlayer.this.mo1527a(r0);
                }
            });
        } else {
            mo1527a((Runnable) r0);
        }
    }

    public void init(int i, boolean z) {
    }

    /* access modifiers changed from: protected */
    public boolean initializeGoogleAr() {
        if (this.f84n == null && currentActivity != null && m81j()) {
            if (GoogleARProxy.m13a()) {
                this.f84n = new GoogleARProxy(this);
                this.f84n.mo1490a(currentActivity, this.f88r);
                this.f84n.mo1491b();
                if (!this.f76f.mo1692e()) {
                    this.f84n.mo1493d();
                }
                return this.f84n.mo1494e();
            }
            this.f85o = new GoogleARCoreApi();
            this.f85o.initializeARCore(currentActivity);
            if (!this.f76f.mo1692e()) {
                this.f85o.resumeARCore();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean initializeGoogleVr() {
        final GoogleVrProxy b = GoogleVrApi.m22b();
        if (b == null) {
            GoogleVrApi.m21a(this);
            b = GoogleVrApi.m22b();
            if (b == null) {
                C0160g.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final Semaphore semaphore = new Semaphore(0);
        final C011811 r3 = new Runnable() {
            public final void run() {
                UnityPlayer.this.injectEvent(new KeyEvent(0, 4));
                UnityPlayer.this.injectEvent(new KeyEvent(1, 4));
            }
        };
        mo1527a((Runnable) new Runnable() {
            public final void run() {
                if (!b.mo1501a(UnityPlayer.currentActivity, UnityPlayer.this.f88r, UnityPlayer.this.m61b(), r3)) {
                    C0160g.Log(6, "Unable to initialize Google VR subsystem.");
                }
                if (UnityPlayer.currentActivity != null) {
                    b.mo1499a(UnityPlayer.currentActivity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return b.mo1500a();
            }
            C0160g.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (InterruptedException e) {
            C0160g.Log(5, "UI thread was interrupted while initializing Google VR. " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        if (!C0172n.m158c()) {
            return false;
        }
        return nativeInjectEvent(inputEvent);
    }

    /* access modifiers changed from: protected */
    public boolean isFinishing() {
        if (!this.f90u) {
            boolean z = (this.f88r instanceof Activity) && ((Activity) this.f88r).isFinishing();
            this.f90u = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void kill() {
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: protected */
    public boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        if (C0172n.m158c()) {
            m64b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeLowMemory();
                }
            });
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        if (this.f84n != null) {
            this.f84n.mo1492c();
        } else if (this.f85o != null) {
            this.f85o.pauseARCore();
        }
        if (this.f93x != null) {
            this.f93x.mo1725a();
        }
        GoogleVrProxy b = GoogleVrApi.m22b();
        if (b != null) {
            b.pauseGvrLayout();
        }
        m68d();
    }

    public void quit() {
        if (GoogleVrApi.m22b() != null) {
            GoogleVrApi.m20a();
        }
        if (this.f87q != null) {
            this.f87q.mo1477a();
            this.f87q = null;
        }
        this.f90u = true;
        if (!this.f76f.mo1692e()) {
            pause();
        }
        this.f71a.mo1594a();
        try {
            this.f71a.join(4000);
        } catch (InterruptedException e) {
            this.f71a.interrupt();
        }
        if (this.f78h != null) {
            this.f88r.unregisterReceiver(this.f78h);
        }
        this.f78h = null;
        if (C0172n.m158c()) {
            removeAllViews();
        }
        if (this.f91v || !this.f92w) {
            kill();
        }
        m75g();
    }

    public void removeViewFromPlayer(View view) {
        boolean z = true;
        m54a((View) this.f89s, view);
        boolean z2 = view.getParent() == null;
        boolean z3 = this.f89s.getParent() == this;
        if (!z2 || !z3) {
            z = false;
        }
        if (!z) {
            if (!z2) {
                C0160g.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if (!z3) {
                C0160g.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    public void reportError(String str, String str2) {
        C0160g.Log(6, str + ": " + str2);
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m55a((C0144f) new C0144f() {
            /* renamed from: a */
            public final void mo1570a() {
                if (z) {
                    UnityPlayer.this.nativeSoftInputCanceled();
                } else if (str != null) {
                    UnityPlayer.this.nativeSetInputString(str);
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        if (this.f84n != null) {
            this.f84n.mo1493d();
        } else if (this.f85o != null) {
            this.f85o.resumeARCore();
        }
        this.f76f.mo1689b(false);
        if (this.f93x != null) {
            this.f93x.mo1727b();
        }
        m72f();
        nativeRestartActivityIndicator();
        GoogleVrProxy b = GoogleVrApi.m22b();
        if (b != null) {
            b.mo1502b();
        }
    }

    /* access modifiers changed from: protected */
    public void setCharacterLimit(final int i) {
        mo1527a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f72b != null) {
                    UnityPlayer.this.f72b.mo1672a(i);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setClipboardText(String str) {
        this.f82l.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    /* access modifiers changed from: protected */
    public void setSoftInputStr(final String str) {
        mo1527a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f72b != null && str != null) {
                    UnityPlayer.this.f72b.mo1673a(str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        final String str3 = str;
        final int i3 = i;
        final boolean z5 = z;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final boolean z8 = z4;
        final String str4 = str2;
        final int i4 = i2;
        mo1527a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer.this.f72b = new C0164k(UnityPlayer.this.f88r, this, str3, i3, z5, z6, z7, str4, i4);
                UnityPlayer.this.f72b.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.f93x == null) {
            this.f93x = new C0178q(this);
        }
        boolean a = this.f93x.mo1726a(this.f88r, str, i, i2, i3, z, (long) i4, (long) i5, new C0178q.C0185a() {
            /* renamed from: a */
            public final void mo1574a() {
                C0178q unused = UnityPlayer.this.f93x = null;
            }
        });
        if (a) {
            mo1527a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.nativeIsAutorotationOn() && (UnityPlayer.this.f88r instanceof Activity)) {
                        ((Activity) UnityPlayer.this.f88r).setRequestedOrientation(UnityPlayer.this.f73c);
                    }
                }
            });
        }
        return a;
    }

    public void start() {
    }

    public void stop() {
    }

    /* access modifiers changed from: protected */
    public void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.f88r.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.f86p, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.f86p);
        }
    }

    public void windowFocusChanged(boolean z) {
        this.f76f.mo1688a(z);
        if (z && this.f72b != null) {
            nativeSoftInputLostFocus();
            reportSoftInputStr((String) null, 1, false);
        }
        if (z) {
            this.f71a.mo1598c();
        } else {
            this.f71a.mo1600d();
        }
        m72f();
    }
}
