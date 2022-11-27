package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;

/* renamed from: com.unity3d.player.p */
public final class C0072p extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f241a = false;

    /* renamed from: b */
    private final Context f242b;

    /* renamed from: c */
    private final SurfaceView f243c;

    /* renamed from: d */
    private final SurfaceHolder f244d;

    /* renamed from: e */
    private final String f245e;

    /* renamed from: f */
    private final int f246f;

    /* renamed from: g */
    private final int f247g;

    /* renamed from: h */
    private final boolean f248h;

    /* renamed from: i */
    private final long f249i;

    /* renamed from: j */
    private final long f250j;

    /* renamed from: k */
    private final FrameLayout f251k;

    /* renamed from: l */
    private final Display f252l;

    /* renamed from: m */
    private int f253m;

    /* renamed from: n */
    private int f254n;

    /* renamed from: o */
    private int f255o;

    /* renamed from: p */
    private int f256p;

    /* renamed from: q */
    private MediaPlayer f257q;

    /* renamed from: r */
    private MediaController f258r;

    /* renamed from: s */
    private boolean f259s = false;

    /* renamed from: t */
    private boolean f260t = false;

    /* renamed from: u */
    private int f261u = 0;

    /* renamed from: v */
    private boolean f262v = false;

    /* renamed from: w */
    private boolean f263w = false;

    /* renamed from: x */
    private C0073a f264x;

    /* renamed from: y */
    private C0074b f265y;

    /* renamed from: z */
    private volatile int f266z = 0;

    /* renamed from: com.unity3d.player.p$a */
    public interface C0073a {
        /* renamed from: a */
        void mo261a(int i);
    }

    /* renamed from: com.unity3d.player.p$b */
    public class C0074b implements Runnable {

        /* renamed from: b */
        private C0072p f268b;

        /* renamed from: c */
        private boolean f269c = false;

        public C0074b(C0072p pVar) {
            this.f268b = pVar;
        }

        /* renamed from: a */
        public final void mo262a() {
            this.f269c = true;
        }

        public final void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (!this.f269c) {
                if (C0072p.f241a) {
                    C0072p.m185b("Stopping the video player due to timeout.");
                }
                this.f268b.CancelOnPrepare();
            }
        }
    }

    protected C0072p(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0073a aVar) {
        super(context);
        this.f264x = aVar;
        this.f242b = context;
        this.f251k = this;
        this.f243c = new SurfaceView(context);
        this.f244d = this.f243c.getHolder();
        this.f244d.addCallback(this);
        this.f251k.setBackgroundColor(i);
        this.f251k.addView(this.f243c);
        this.f252l = ((WindowManager) this.f242b.getSystemService("window")).getDefaultDisplay();
        this.f245e = str;
        this.f246f = i2;
        this.f247g = i3;
        this.f248h = z;
        this.f249i = j;
        this.f250j = j2;
        if (f241a) {
            m185b("fileName: " + this.f245e);
        }
        if (f241a) {
            m185b("backgroundColor: " + i);
        }
        if (f241a) {
            m185b("controlMode: " + this.f246f);
        }
        if (f241a) {
            m185b("scalingMode: " + this.f247g);
        }
        if (f241a) {
            m185b("isURL: " + this.f248h);
        }
        if (f241a) {
            m185b("videoOffset: " + this.f249i);
        }
        if (f241a) {
            m185b("videoLength: " + this.f250j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    private void m183a(int i) {
        this.f266z = i;
        C0073a aVar = this.f264x;
        if (aVar != null) {
            aVar.mo261a(this.f266z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m185b(String str) {
        Log.i("Video", "VideoPlayer: " + str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007f */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m187c() {
        /*
            r8 = this;
            android.media.MediaPlayer r0 = r8.f257q
            if (r0 == 0) goto L_0x001c
            android.view.SurfaceHolder r1 = r8.f244d
            r0.setDisplay(r1)
            boolean r0 = r8.f262v
            if (r0 != 0) goto L_0x001b
            boolean r0 = f241a
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "Resuming playback"
            m185b(r0)
        L_0x0016:
            android.media.MediaPlayer r0 = r8.f257q
            r0.start()
        L_0x001b:
            return
        L_0x001c:
            r0 = 0
            r8.m183a((int) r0)
            r8.doCleanUp()
            android.media.MediaPlayer r0 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x00ce }
            r0.<init>()     // Catch:{ Exception -> 0x00ce }
            r8.f257q = r0     // Catch:{ Exception -> 0x00ce }
            boolean r0 = r8.f248h     // Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x003c
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            android.content.Context r1 = r8.f242b     // Catch:{ Exception -> 0x00ce }
            java.lang.String r2 = r8.f245e     // Catch:{ Exception -> 0x00ce }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00ce }
            r0.setDataSource(r1, r2)     // Catch:{ Exception -> 0x00ce }
            goto L_0x0090
        L_0x003c:
            long r0 = r8.f250j     // Catch:{ Exception -> 0x00ce }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x005c
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r8.f245e     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r2 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ Exception -> 0x00ce }
            long r4 = r8.f249i     // Catch:{ Exception -> 0x00ce }
            long r6 = r8.f250j     // Catch:{ Exception -> 0x00ce }
            r2.setDataSource(r3, r4, r6)     // Catch:{ Exception -> 0x00ce }
        L_0x0058:
            r0.close()     // Catch:{ Exception -> 0x00ce }
            goto L_0x0090
        L_0x005c:
            android.content.res.Resources r0 = r8.getResources()     // Catch:{ Exception -> 0x00ce }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r8.f245e     // Catch:{ IOException -> 0x007f }
            android.content.res.AssetFileDescriptor r0 = r0.openFd(r1)     // Catch:{ IOException -> 0x007f }
            android.media.MediaPlayer r1 = r8.f257q     // Catch:{ IOException -> 0x007f }
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch:{ IOException -> 0x007f }
            long r3 = r0.getStartOffset()     // Catch:{ IOException -> 0x007f }
            long r5 = r0.getLength()     // Catch:{ IOException -> 0x007f }
            r1.setDataSource(r2, r3, r5)     // Catch:{ IOException -> 0x007f }
            r0.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0090
        L_0x007f:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r8.f245e     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r1 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            java.io.FileDescriptor r2 = r0.getFD()     // Catch:{ Exception -> 0x00ce }
            r1.setDataSource(r2)     // Catch:{ Exception -> 0x00ce }
            goto L_0x0058
        L_0x0090:
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            android.view.SurfaceHolder r1 = r8.f244d     // Catch:{ Exception -> 0x00ce }
            r0.setDisplay(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r1 = 1
            r0.setScreenOnWhilePlaying(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r0.setOnBufferingUpdateListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r0.setOnCompletionListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r0.setOnPreparedListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r0.setOnVideoSizeChangedListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r1 = 3
            r0.setAudioStreamType(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f257q     // Catch:{ Exception -> 0x00ce }
            r0.prepareAsync()     // Catch:{ Exception -> 0x00ce }
            com.unity3d.player.p$b r0 = new com.unity3d.player.p$b     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r8)     // Catch:{ Exception -> 0x00ce }
            r8.f265y = r0     // Catch:{ Exception -> 0x00ce }
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Exception -> 0x00ce }
            com.unity3d.player.p$b r1 = r8.f265y     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ce }
            r0.start()     // Catch:{ Exception -> 0x00ce }
            return
        L_0x00ce:
            r0 = move-exception
            boolean r1 = f241a
            if (r1 == 0) goto L_0x00eb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            m185b(r0)
        L_0x00eb:
            r0 = 2
            r8.m183a((int) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C0072p.m187c():void");
    }

    /* renamed from: d */
    private void m188d() {
        if (!isPlaying()) {
            m183a(1);
            if (f241a) {
                m185b("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.f262v) {
                start();
            }
        }
    }

    public final void CancelOnPrepare() {
        m183a(2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo238a() {
        return this.f262v;
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void destroyPlayer() {
        if (f241a) {
            m185b("destroyPlayer");
        }
        if (!this.f262v) {
            pause();
        }
        doCleanUp();
    }

    /* access modifiers changed from: protected */
    public final void doCleanUp() {
        C0074b bVar = this.f265y;
        if (bVar != null) {
            bVar.mo262a();
            this.f265y = null;
        }
        MediaPlayer mediaPlayer = this.f257q;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f257q = null;
        }
        this.f255o = 0;
        this.f256p = 0;
        this.f260t = false;
        this.f259s = false;
    }

    public final int getBufferPercentage() {
        if (this.f248h) {
            return this.f261u;
        }
        return 100;
    }

    public final int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f257q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public final int getDuration() {
        MediaPlayer mediaPlayer = this.f257q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public final boolean isPlaying() {
        boolean z = this.f260t && this.f259s;
        MediaPlayer mediaPlayer = this.f257q;
        return mediaPlayer == null ? !z : mediaPlayer.isPlaying() || !z;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f241a) {
            m185b("onBufferingUpdate percent:" + i);
        }
        this.f261u = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f241a) {
            m185b("onCompletion called");
        }
        destroyPlayer();
        m183a(3);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || (this.f246f == 2 && i != 0 && !keyEvent.isSystem())) {
            destroyPlayer();
            m183a(3);
            return true;
        }
        MediaController mediaController = this.f258r;
        return mediaController != null ? mediaController.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f241a) {
            m185b("onPrepared called");
        }
        C0074b bVar = this.f265y;
        if (bVar != null) {
            bVar.mo262a();
            this.f265y = null;
        }
        int i = this.f246f;
        if (i == 0 || i == 1) {
            this.f258r = new MediaController(this.f242b);
            this.f258r.setMediaPlayer(this);
            this.f258r.setAnchorView(this);
            this.f258r.setEnabled(true);
            Context context = this.f242b;
            if (context instanceof Activity) {
                this.f258r.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.f258r.show();
        }
        this.f260t = true;
        if (this.f260t && this.f259s) {
            m188d();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f246f == 2 && action == 0) {
            destroyPlayer();
            m183a(3);
            return true;
        }
        MediaController mediaController = this.f258r;
        return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f241a) {
            m185b("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.f259s = true;
            this.f255o = i;
            this.f256p = i2;
            if (this.f260t && this.f259s) {
                m188d();
            }
        } else if (f241a) {
            m185b("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    public final void pause() {
        MediaPlayer mediaPlayer = this.f257q;
        if (mediaPlayer != null) {
            if (this.f263w) {
                mediaPlayer.pause();
            }
            this.f262v = true;
        }
    }

    public final void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f257q;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public final void start() {
        if (f241a) {
            m185b("Start");
        }
        MediaPlayer mediaPlayer = this.f257q;
        if (mediaPlayer != null) {
            if (this.f263w) {
                mediaPlayer.start();
            }
            this.f262v = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f241a) {
            m185b("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.f253m != i2 || this.f254n != i3) {
            this.f253m = i2;
            this.f254n = i3;
            if (this.f263w) {
                updateVideoLayout();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f241a) {
            m185b("surfaceCreated called");
        }
        this.f263w = true;
        m187c();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f241a) {
            m185b("surfaceDestroyed called");
        }
        this.f263w = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r5 <= r3) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r0 = (int) (((float) r1) * r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r5 >= r3) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateVideoLayout() {
        /*
            r8 = this;
            boolean r0 = f241a
            if (r0 == 0) goto L_0x0009
            java.lang.String r0 = "updateVideoLayout"
            m185b(r0)
        L_0x0009:
            android.media.MediaPlayer r0 = r8.f257q
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            int r0 = r8.f253m
            if (r0 == 0) goto L_0x0016
            int r0 = r8.f254n
            if (r0 != 0) goto L_0x0034
        L_0x0016:
            android.content.Context r0 = r8.f242b
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r1)
            int r0 = r1.widthPixels
            r8.f253m = r0
            int r0 = r1.heightPixels
            r8.f254n = r0
        L_0x0034:
            int r0 = r8.f253m
            int r1 = r8.f254n
            boolean r2 = r8.f259s
            if (r2 == 0) goto L_0x0064
            int r2 = r8.f255o
            float r3 = (float) r2
            int r4 = r8.f256p
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r5 = r5 / r6
            int r6 = r8.f247g
            r7 = 1
            if (r6 != r7) goto L_0x0057
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0053
        L_0x004f:
            float r1 = (float) r0
            float r1 = r1 / r3
            int r1 = (int) r1
            goto L_0x006d
        L_0x0053:
            float r0 = (float) r1
            float r0 = r0 * r3
            int r0 = (int) r0
            goto L_0x006d
        L_0x0057:
            r7 = 2
            if (r6 != r7) goto L_0x005f
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0053
            goto L_0x004f
        L_0x005f:
            if (r6 != 0) goto L_0x006d
            r0 = r2
            r1 = r4
            goto L_0x006d
        L_0x0064:
            boolean r2 = f241a
            if (r2 == 0) goto L_0x006d
            java.lang.String r2 = "updateVideoLayout: Video size is not known yet"
            m185b(r2)
        L_0x006d:
            int r2 = r8.f253m
            if (r2 != r0) goto L_0x0075
            int r2 = r8.f254n
            if (r2 == r1) goto L_0x00a0
        L_0x0075:
            boolean r2 = f241a
            if (r2 == 0) goto L_0x0092
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "frameWidth = "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r3 = "; frameHeight = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            m185b(r2)
        L_0x0092:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r0, r1, r3)
            android.widget.FrameLayout r0 = r8.f251k
            android.view.SurfaceView r1 = r8.f243c
            r0.updateViewLayout(r1, r2)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C0072p.updateVideoLayout():void");
    }
}
