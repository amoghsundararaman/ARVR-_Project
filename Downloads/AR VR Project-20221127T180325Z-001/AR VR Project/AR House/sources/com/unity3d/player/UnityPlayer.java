package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
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
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.unity3d.player.C0065l;
import com.unity3d.player.C0075q;
import com.vuforia.PIXEL_FORMAT;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnityPlayer extends FrameLayout implements C0056f {
    public static Activity currentActivity;

    /* renamed from: a */
    C0036e f43a = new C0036e(this, (byte) 0);

    /* renamed from: b */
    C0061k f44b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f45c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f46d = false;

    /* renamed from: e */
    private boolean f47e = true;

    /* renamed from: f */
    private C0069n f48f = new C0069n();

    /* renamed from: g */
    private final ConcurrentLinkedQueue f49g = new ConcurrentLinkedQueue();

    /* renamed from: h */
    private BroadcastReceiver f50h = null;

    /* renamed from: i */
    private boolean f51i = false;

    /* renamed from: j */
    private C0034c f52j = new C0034c(this, (byte) 0);

    /* renamed from: k */
    private TelephonyManager f53k;

    /* renamed from: l */
    private ClipboardManager f54l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C0065l f55m;

    /* renamed from: n */
    private GoogleARCoreApi f56n = null;

    /* renamed from: o */
    private C0032a f57o = new C0032a();

    /* renamed from: p */
    private Camera2Wrapper f58p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Context f59q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public SurfaceView f60r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f61s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C0075q f62t;

    /* renamed from: com.unity3d.player.UnityPlayer$a */
    class C0032a implements SensorEventListener {
        C0032a() {
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$b */
    enum C0033b {
        ;

        static {
            f119d = new int[]{f116a, f117b, f118c};
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$c */
    private class C0034c extends PhoneStateListener {
        private C0034c() {
        }

        /* synthetic */ C0034c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        public final void onCallStateChanged(int i, String str) {
            UnityPlayer unityPlayer = UnityPlayer.this;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            unityPlayer.nativeMuteMasterAudio(z);
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$d */
    enum C0035d {
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
    private class C0036e extends Thread {

        /* renamed from: a */
        Handler f130a;

        /* renamed from: b */
        boolean f131b;

        /* renamed from: c */
        boolean f132c;

        /* renamed from: d */
        int f133d;

        /* renamed from: e */
        int f134e;

        private C0036e() {
            this.f131b = false;
            this.f132c = false;
            this.f133d = C0033b.f117b;
            this.f134e = 5;
        }

        /* synthetic */ C0036e(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        private void m91a(C0035d dVar) {
            Handler handler = this.f130a;
            if (handler != null) {
                Message.obtain(handler, 2269, dVar).sendToTarget();
            }
        }

        /* renamed from: a */
        public final void mo124a() {
            m91a(C0035d.QUIT);
        }

        /* renamed from: a */
        public final void mo125a(Runnable runnable) {
            if (this.f130a != null) {
                m91a(C0035d.PAUSE);
                Message.obtain(this.f130a, runnable).sendToTarget();
            }
        }

        /* renamed from: b */
        public final void mo126b() {
            m91a(C0035d.RESUME);
        }

        /* renamed from: b */
        public final void mo127b(Runnable runnable) {
            if (this.f130a != null) {
                m91a(C0035d.SURFACE_LOST);
                Message.obtain(this.f130a, runnable).sendToTarget();
            }
        }

        /* renamed from: c */
        public final void mo128c() {
            m91a(C0035d.FOCUS_GAINED);
        }

        /* renamed from: c */
        public final void mo129c(Runnable runnable) {
            Handler handler = this.f130a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
                m91a(C0035d.SURFACE_ACQUIRED);
            }
        }

        /* renamed from: d */
        public final void mo130d() {
            m91a(C0035d.FOCUS_LOST);
        }

        /* renamed from: d */
        public final void mo131d(Runnable runnable) {
            Handler handler = this.f130a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
            }
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f130a = new Handler(new Handler.Callback() {
                /* renamed from: a */
                private void m100a() {
                    if (C0036e.this.f133d == C0033b.f118c && C0036e.this.f132c) {
                        UnityPlayer.this.nativeFocusChanged(true);
                        C0036e.this.f133d = C0033b.f116a;
                    }
                }

                public final boolean handleMessage(Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    C0035d dVar = (C0035d) message.obj;
                    if (dVar == C0035d.NEXT_FRAME) {
                        return true;
                    }
                    if (dVar == C0035d.QUIT) {
                        Looper.myLooper().quit();
                    } else if (dVar == C0035d.RESUME) {
                        C0036e.this.f131b = true;
                    } else if (dVar == C0035d.PAUSE) {
                        C0036e.this.f131b = false;
                    } else if (dVar == C0035d.SURFACE_LOST) {
                        C0036e.this.f132c = false;
                    } else {
                        if (dVar == C0035d.SURFACE_ACQUIRED) {
                            C0036e.this.f132c = true;
                        } else if (dVar == C0035d.FOCUS_LOST) {
                            if (C0036e.this.f133d == C0033b.f116a) {
                                UnityPlayer.this.nativeFocusChanged(false);
                            }
                            C0036e.this.f133d = C0033b.f117b;
                        } else if (dVar == C0035d.FOCUS_GAINED) {
                            C0036e.this.f133d = C0033b.f118c;
                        }
                        m100a();
                    }
                    return true;
                }
            });
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public final boolean queueIdle() {
                    UnityPlayer.this.executeGLThreadJobs();
                    if (!C0036e.this.f131b || !C0036e.this.f132c) {
                        return true;
                    }
                    if (C0036e.this.f134e >= 0) {
                        if (C0036e.this.f134e == 0 && UnityPlayer.this.m72k()) {
                            UnityPlayer.this.m38a();
                        }
                        C0036e.this.f134e--;
                    }
                    if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                        UnityPlayer.this.m60e();
                    }
                    Message.obtain(C0036e.this.f130a, 2269, C0035d.NEXT_FRAME).sendToTarget();
                    return true;
                }
            });
            Looper.loop();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$f */
    private abstract class C0039f implements Runnable {
        private C0039f() {
        }

        /* synthetic */ C0039f(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo100a();

        public final void run() {
            if (!UnityPlayer.this.isFinishing()) {
                mo100a();
            }
        }
    }

    static {
        new C0068m().mo224a();
        try {
            System.loadLibrary("main");
        } catch (UnsatisfiedLinkError e) {
            C0057g.Log(6, "Failed to load 'libmain.so', the application will terminate.");
            throw e;
        }
    }

    public UnityPlayer(Context context) {
        super(context);
        if (context instanceof Activity) {
            currentActivity = (Activity) context;
            this.f45c = currentActivity.getRequestedOrientation();
        }
        m40a(currentActivity);
        this.f59q = context;
        if (currentActivity != null && m72k()) {
            this.f55m = new C0065l(this.f59q, C0065l.C0067a.m167a()[getSplashMode()]);
            addView(this.f55m);
        }
        m41a(this.f59q.getApplicationInfo());
        if (!C0069n.m171c()) {
            AlertDialog create = new AlertDialog.Builder(this.f59q).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.m60e();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.f48f.mo228c(true);
        this.f60r = m55c();
        this.f60r.setContentDescription(m37a(context));
        addView(this.f60r);
        bringChildToFront(this.f55m);
        this.f61s = false;
        nativeInitWebRequest(UnityWebRequest.class);
        m75m();
        this.f53k = (TelephonyManager) this.f59q.getSystemService("phone");
        this.f54l = (ClipboardManager) this.f59q.getSystemService("clipboard");
        this.f58p = new Camera2Wrapper(this.f59q);
        this.f43a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!C0069n.m171c()) {
            C0057g.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
            return;
        }
        try {
            nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* renamed from: a */
    private static String m37a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38a() {
        mo51a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                unityPlayer.removeView(unityPlayer.f55m);
                C0065l unused = UnityPlayer.this.f55m = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39a(int i, Surface surface) {
        if (!this.f46d) {
            m54b(0, surface);
        }
    }

    /* renamed from: a */
    private static void m40a(Activity activity) {
        View decorView;
        if (activity != null && activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setSystemUiVisibility(7);
        }
    }

    /* renamed from: a */
    private static void m41a(ApplicationInfo applicationInfo) {
        if (NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C0069n.m169a();
        } else {
            C0057g.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m42a(android.view.View r5, android.view.View r6) {
        /*
            r4 = this;
            com.unity3d.player.n r0 = r4.f48f
            boolean r0 = r0.mo230d()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            r4.pause()
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r5 == 0) goto L_0x0030
            android.view.ViewParent r2 = r5.getParent()
            boolean r3 = r2 instanceof com.unity3d.player.UnityPlayer
            if (r3 == 0) goto L_0x001e
            r3 = r2
            com.unity3d.player.UnityPlayer r3 = (com.unity3d.player.UnityPlayer) r3
            if (r3 == r4) goto L_0x0030
        L_0x001e:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0027
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r2.removeView(r5)
        L_0x0027:
            r4.addView(r5)
            r4.bringChildToFront(r5)
            r5.setVisibility(r1)
        L_0x0030:
            if (r6 == 0) goto L_0x0040
            android.view.ViewParent r5 = r6.getParent()
            if (r5 != r4) goto L_0x0040
            r5 = 8
            r6.setVisibility(r5)
            r4.removeView(r6)
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            r4.resume()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.UnityPlayer.m42a(android.view.View, android.view.View):void");
    }

    /* renamed from: a */
    private void m43a(C0039f fVar) {
        if (!isFinishing()) {
            m52b((Runnable) fVar);
        }
    }

    /* renamed from: b */
    private void m52b(Runnable runnable) {
        if (C0069n.m171c()) {
            if (Thread.currentThread() == this.f43a) {
                runnable.run();
            } else {
                this.f49g.add(runnable);
            }
        }
    }

    /* renamed from: b */
    private static boolean m53b() {
        if (currentActivity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        return currentActivity.getTheme().resolveAttribute(16842840, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    /* renamed from: b */
    private boolean m54b(final int i, final Surface surface) {
        if (!C0069n.m171c() || !this.f48f.mo231e()) {
            return false;
        }
        final Semaphore semaphore = new Semaphore(0);
        C002120 r1 = new Runnable() {
            public final void run() {
                UnityPlayer.this.nativeRecreateGfxState(i, surface);
                semaphore.release();
            }
        };
        if (i != 0) {
            r1.run();
        } else if (surface == null) {
            this.f43a.mo127b(r1);
        } else {
            this.f43a.mo129c(r1);
        }
        if (surface != null || i != 0) {
            return true;
        }
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return true;
            }
            C0057g.Log(5, "Timeout while trying detaching primary window.");
            return true;
        } catch (InterruptedException unused) {
            C0057g.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public SurfaceView m55c() {
        SurfaceView surfaceView = new SurfaceView(this.f59q);
        if (m53b()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.m39a(0, surfaceHolder.getSurface());
                UnityPlayer.this.m57d();
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m39a(0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m39a(0, (Surface) null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m57d() {
        if (C0069n.m171c() && this.f48f.mo231e()) {
            this.f43a.mo131d(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeSendSurfaceChangedEvent();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m60e() {
        Context context = this.f59q;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            ((Activity) this.f59q).finish();
        }
    }

    /* renamed from: f */
    private void m62f() {
        reportSoftInputStr((String) null, 1, true);
        if (this.f48f.mo233g()) {
            if (C0069n.m171c()) {
                final Semaphore semaphore = new Semaphore(0);
                this.f43a.mo125a(isFinishing() ? new Runnable() {
                    public final void run() {
                        UnityPlayer.this.m63g();
                        semaphore.release();
                    }
                } : new Runnable() {
                    public final void run() {
                        if (UnityPlayer.this.nativePause()) {
                            boolean unused = UnityPlayer.this.f61s = true;
                            UnityPlayer.this.m63g();
                            semaphore.release(2);
                            return;
                        }
                        semaphore.release();
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        C0057g.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException unused) {
                    C0057g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    destroy();
                }
            }
            this.f48f.mo229d(false);
            this.f48f.mo227b(true);
            if (this.f51i) {
                this.f53k.listen(this.f52j, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m63g() {
        nativeDone();
        this.f48f.mo228c(false);
    }

    /* renamed from: h */
    private void m65h() {
        if (this.f48f.mo232f()) {
            this.f48f.mo229d(true);
            m52b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f43a.mo126b();
        }
    }

    /* renamed from: i */
    private static void m67i() {
        if (C0069n.m171c()) {
            if (NativeLoader.unload()) {
                C0069n.m170b();
                return;
            }
            throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
        }
    }

    private final native void initJni(Context context);

    /* renamed from: j */
    private ApplicationInfo m69j() {
        return this.f59q.getPackageManager().getApplicationInfo(this.f59q.getPackageName(), PIXEL_FORMAT.YV12);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m72k() {
        try {
            return m69j().metaData.getBoolean("unity.splash-enable");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: l */
    private boolean m73l() {
        try {
            return m69j().metaData.getBoolean("unity.tango-enable");
        } catch (Exception unused) {
            return false;
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        StringBuilder sb;
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            sb = new StringBuilder("Unable to find ");
            sb.append(str);
            C0057g.Log(6, sb.toString());
            return false;
        } catch (Exception e) {
            sb = new StringBuilder("Unknown error ");
            sb.append(e);
            C0057g.Log(6, sb.toString());
            return false;
        }
    }

    /* renamed from: m */
    private void m75m() {
        Context context = this.f59q;
        if (context instanceof Activity) {
            ((Activity) context).getWindow().setFlags(1024, 1024);
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
    public final native void nativeSendSurfaceChangedEvent();

    /* access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i, int i2);

    /* access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo51a(Runnable runnable) {
        Context context = this.f59q;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            C0057g.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    /* access modifiers changed from: protected */
    public void addPhoneCallListener() {
        this.f51i = true;
        this.f53k.listen(this.f52j, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        m42a(view, (View) z ? this.f60r : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.f60r.getParent() == null;
        boolean z5 = this.f60r.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                C0057g.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                C0057g.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        SurfaceView surfaceView = this.f60r;
        if (surfaceView instanceof SurfaceView) {
            surfaceView.getHolder().setSizeFromLayout();
        }
        C0075q qVar = this.f62t;
        if (qVar != null) {
            qVar.mo267c();
        }
        GoogleVrProxy b = GoogleVrApi.m8b();
        if (b != null) {
            b.mo27c();
        }
    }

    public void destroy() {
        if (GoogleVrApi.m8b() != null) {
            GoogleVrApi.m6a();
        }
        Camera2Wrapper camera2Wrapper = this.f58p;
        if (camera2Wrapper != null) {
            camera2Wrapper.mo4a();
            this.f58p = null;
        }
        this.f61s = true;
        if (!this.f48f.mo230d()) {
            pause();
        }
        this.f43a.mo124a();
        try {
            this.f43a.join(4000);
        } catch (InterruptedException unused) {
            this.f43a.interrupt();
        }
        BroadcastReceiver broadcastReceiver = this.f50h;
        if (broadcastReceiver != null) {
            this.f59q.unregisterReceiver(broadcastReceiver);
        }
        this.f50h = null;
        if (C0069n.m171c()) {
            removeAllViews();
        }
        kill();
        m67i();
    }

    /* access modifiers changed from: protected */
    public void disableLogger() {
        C0057g.f206a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f46d = surface != null;
            mo51a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.f46d) {
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.f60r);
                        return;
                    }
                    UnityPlayer unityPlayer2 = UnityPlayer.this;
                    unityPlayer2.addView(unityPlayer2.f60r);
                }
            });
        }
        return m54b(i, surface);
    }

    /* access modifiers changed from: protected */
    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f49g.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getClipboardText() {
        ClipData primaryClip = this.f54l.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.f59q).toString() : "";
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    /* access modifiers changed from: protected */
    public int getSplashMode() {
        try {
            return m69j().metaData.getInt("unity.splash-mode");
        } catch (Exception unused) {
            return 0;
        }
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        final C00275 r0 = new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f44b != null) {
                    UnityPlayer.this.f44b.dismiss();
                    UnityPlayer.this.f44b = null;
                }
            }
        };
        if (C0060j.f208b) {
            m43a((C0039f) new C0039f() {
                /* renamed from: a */
                public final void mo100a() {
                    UnityPlayer.this.mo51a(r0);
                }
            });
        } else {
            mo51a((Runnable) r0);
        }
    }

    public void init(int i, boolean z) {
    }

    /* access modifiers changed from: protected */
    public boolean initializeGoogleAr() {
        if (this.f56n != null || currentActivity == null || !m73l()) {
            return false;
        }
        this.f56n = new GoogleARCoreApi();
        this.f56n.initializeARCore(currentActivity);
        if (this.f48f.mo230d()) {
            return false;
        }
        this.f56n.resumeARCore();
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean initializeGoogleVr() {
        final GoogleVrProxy b = GoogleVrApi.m8b();
        if (b == null) {
            GoogleVrApi.m7a(this);
            b = GoogleVrApi.m8b();
            if (b == null) {
                C0057g.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final Semaphore semaphore = new Semaphore(0);
        final C001313 r3 = new Runnable() {
            public final void run() {
                UnityPlayer.this.injectEvent(new KeyEvent(0, 4));
                UnityPlayer.this.injectEvent(new KeyEvent(1, 4));
            }
        };
        mo51a((Runnable) new Runnable() {
            public final void run() {
                if (!b.mo25a(UnityPlayer.currentActivity, UnityPlayer.this.f59q, UnityPlayer.this.m55c(), r3)) {
                    C0057g.Log(6, "Unable to initialize Google VR subsystem.");
                }
                if (UnityPlayer.currentActivity != null) {
                    b.mo23a(UnityPlayer.currentActivity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return b.mo24a();
            }
            C0057g.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (InterruptedException e) {
            C0057g.Log(5, "UI thread was interrupted while initializing Google VR. " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        if (!C0069n.m171c()) {
            return false;
        }
        return nativeInjectEvent(inputEvent);
    }

    /* access modifiers changed from: protected */
    public boolean isFinishing() {
        if (!this.f61s) {
            Context context = this.f59q;
            boolean z = (context instanceof Activity) && ((Activity) context).isFinishing();
            this.f61s = z;
            return z;
        }
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
        if (C0069n.m171c()) {
            m52b((Runnable) new Runnable() {
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
        GoogleARCoreApi googleARCoreApi = this.f56n;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        C0075q qVar = this.f62t;
        if (qVar != null) {
            qVar.mo264a();
        }
        GoogleVrProxy b = GoogleVrApi.m8b();
        if (b != null) {
            b.pauseGvrLayout();
        }
        m62f();
    }

    public void quit() {
        destroy();
    }

    public void removeViewFromPlayer(View view) {
        m42a((View) this.f60r, view);
        boolean z = true;
        boolean z2 = view.getParent() == null;
        boolean z3 = this.f60r.getParent() == this;
        if (!z2 || !z3) {
            z = false;
        }
        if (!z) {
            if (!z2) {
                C0057g.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if (!z3) {
                C0057g.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    public void reportError(String str, String str2) {
        C0057g.Log(6, str + ": " + str2);
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputSelection(final int i, final int i2) {
        m43a((C0039f) new C0039f() {
            /* renamed from: a */
            public final void mo100a() {
                UnityPlayer.this.nativeSetInputSelection(i, i2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m43a((C0039f) new C0039f() {
            /* renamed from: a */
            public final void mo100a() {
                if (z) {
                    UnityPlayer.this.nativeSoftInputCanceled();
                } else {
                    String str = str;
                    if (str != null) {
                        UnityPlayer.this.nativeSetInputString(str);
                    }
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void requestUserAuthorization(String str) {
        if (C0060j.f209c && str != null && !str.isEmpty() && currentActivity != null) {
            C0060j.f210d.mo203a(currentActivity, str);
        }
    }

    public void resume() {
        GoogleARCoreApi googleARCoreApi = this.f56n;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.f48f.mo227b(false);
        C0075q qVar = this.f62t;
        if (qVar != null) {
            qVar.mo266b();
        }
        m65h();
        nativeRestartActivityIndicator();
        GoogleVrProxy b = GoogleVrApi.m8b();
        if (b != null) {
            b.mo26b();
        }
    }

    /* access modifiers changed from: protected */
    public void setCharacterLimit(final int i) {
        mo51a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f44b != null) {
                    UnityPlayer.this.f44b.mo207a(i);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setClipboardText(String str) {
        this.f54l.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    /* access modifiers changed from: protected */
    public void setHideInputField(final boolean z) {
        mo51a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f44b != null) {
                    UnityPlayer.this.f44b.mo210a(z);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setSelection(final int i, final int i2) {
        mo51a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f44b != null) {
                    UnityPlayer.this.f44b.mo208a(i, i2);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setSoftInputStr(final String str) {
        mo51a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f44b != null && str != null) {
                    UnityPlayer.this.f44b.mo209a(str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5) {
        final String str3 = str;
        final int i3 = i;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final String str4 = str2;
        final int i4 = i2;
        final boolean z10 = z5;
        mo51a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                unityPlayer.f44b = new C0061k(unityPlayer.f59q, this, str3, i3, z6, z7, z8, str4, i4, z10);
                UnityPlayer.this.f44b.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.f62t == null) {
            this.f62t = new C0075q(this);
        }
        boolean a = this.f62t.mo265a(this.f59q, str, i, i2, i3, z, (long) i4, (long) i5, new C0075q.C0082a() {
            /* renamed from: a */
            public final void mo103a() {
                C0075q unused = UnityPlayer.this.f62t = null;
            }
        });
        if (a) {
            mo51a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.nativeIsAutorotationOn() && (UnityPlayer.this.f59q instanceof Activity)) {
                        ((Activity) UnityPlayer.this.f59q).setRequestedOrientation(UnityPlayer.this.f45c);
                    }
                }
            });
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public boolean skipPermissionsDialog() {
        if (!C0060j.f209c || currentActivity == null) {
            return false;
        }
        return C0060j.f210d.mo204a(currentActivity);
    }

    public void start() {
    }

    public void stop() {
    }

    /* access modifiers changed from: protected */
    public void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.f59q.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.f57o, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.f57o);
        }
    }

    public void windowFocusChanged(boolean z) {
        this.f48f.mo226a(z);
        if (this.f48f.mo231e()) {
            if (z && this.f44b != null) {
                nativeSoftInputLostFocus();
                reportSoftInputStr((String) null, 1, false);
            }
            if (z) {
                this.f43a.mo128c();
            } else {
                this.f43a.mo130d();
            }
            m65h();
        }
    }
}
