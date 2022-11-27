package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.google.p000vr.ndk.base.BufferSpec;
import com.google.p000vr.vrcore.common.api.SdkServiceConsts;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.unity3d.player.p */
public final class C0175p extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f246a = false;

    /* renamed from: b */
    private final Context f247b;

    /* renamed from: c */
    private final SurfaceView f248c;

    /* renamed from: d */
    private final SurfaceHolder f249d;

    /* renamed from: e */
    private final String f250e;

    /* renamed from: f */
    private final int f251f;

    /* renamed from: g */
    private final int f252g;

    /* renamed from: h */
    private final boolean f253h;

    /* renamed from: i */
    private final long f254i;

    /* renamed from: j */
    private final long f255j;

    /* renamed from: k */
    private final FrameLayout f256k;

    /* renamed from: l */
    private final Display f257l;

    /* renamed from: m */
    private int f258m;

    /* renamed from: n */
    private int f259n;

    /* renamed from: o */
    private int f260o;

    /* renamed from: p */
    private int f261p;

    /* renamed from: q */
    private MediaPlayer f262q;

    /* renamed from: r */
    private MediaController f263r;

    /* renamed from: s */
    private boolean f264s = false;

    /* renamed from: t */
    private boolean f265t = false;

    /* renamed from: u */
    private int f266u = 0;

    /* renamed from: v */
    private boolean f267v = false;

    /* renamed from: w */
    private boolean f268w = false;

    /* renamed from: x */
    private C0176a f269x;

    /* renamed from: y */
    private C0177b f270y;

    /* renamed from: z */
    private volatile int f271z = 0;

    /* renamed from: com.unity3d.player.p$a */
    public interface C0176a {
        /* renamed from: a */
        void mo1722a(int i);
    }

    /* renamed from: com.unity3d.player.p$b */
    public class C0177b implements Runnable {

        /* renamed from: b */
        private C0175p f273b;

        /* renamed from: c */
        private boolean f274c = false;

        public C0177b(C0175p pVar) {
            this.f273b = pVar;
        }

        /* renamed from: a */
        public final void mo1723a() {
            this.f274c = true;
        }

        public final void run() {
            try {
                Thread.sleep(SdkServiceConsts.DIM_UI_FADE_AFTER_TOUCH_DELAY_MILLIS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!this.f274c) {
                if (C0175p.f246a) {
                    C0175p.m171b("Stopping the video player due to timeout.");
                }
                this.f273b.CancelOnPrepare();
            }
        }
    }

    protected C0175p(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0176a aVar) {
        super(context);
        this.f269x = aVar;
        this.f247b = context;
        this.f256k = this;
        this.f248c = new SurfaceView(context);
        this.f249d = this.f248c.getHolder();
        this.f249d.addCallback(this);
        this.f256k.setBackgroundColor(i);
        this.f256k.addView(this.f248c);
        this.f257l = ((WindowManager) this.f247b.getSystemService("window")).getDefaultDisplay();
        this.f250e = str;
        this.f251f = i2;
        this.f252g = i3;
        this.f253h = z;
        this.f254i = j;
        this.f255j = j2;
        if (f246a) {
            m171b("fileName: " + this.f250e);
        }
        if (f246a) {
            m171b("backgroundColor: " + i);
        }
        if (f246a) {
            m171b("controlMode: " + this.f251f);
        }
        if (f246a) {
            m171b("scalingMode: " + this.f252g);
        }
        if (f246a) {
            m171b("isURL: " + this.f253h);
        }
        if (f246a) {
            m171b("videoOffset: " + this.f254i);
        }
        if (f246a) {
            m171b("videoLength: " + this.f255j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    private void m169a(int i) {
        this.f271z = i;
        if (this.f269x != null) {
            this.f269x.mo1722a(this.f271z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m171b(String str) {
        Log.i("Video", "VideoPlayer: " + str);
    }

    /* renamed from: c */
    private void m173c() {
        if (this.f262q != null) {
            this.f262q.setDisplay(this.f249d);
            if (!this.f267v) {
                if (f246a) {
                    m171b("Resuming playback");
                }
                this.f262q.start();
                return;
            }
            return;
        }
        m169a(0);
        doCleanUp();
        try {
            this.f262q = new MediaPlayer();
            if (this.f253h) {
                this.f262q.setDataSource(this.f247b, Uri.parse(this.f250e));
            } else if (this.f255j != 0) {
                FileInputStream fileInputStream = new FileInputStream(this.f250e);
                this.f262q.setDataSource(fileInputStream.getFD(), this.f254i, this.f255j);
                fileInputStream.close();
            } else {
                try {
                    AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f250e);
                    this.f262q.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                } catch (IOException e) {
                    FileInputStream fileInputStream2 = new FileInputStream(this.f250e);
                    this.f262q.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                }
            }
            this.f262q.setDisplay(this.f249d);
            this.f262q.setScreenOnWhilePlaying(true);
            this.f262q.setOnBufferingUpdateListener(this);
            this.f262q.setOnCompletionListener(this);
            this.f262q.setOnPreparedListener(this);
            this.f262q.setOnVideoSizeChangedListener(this);
            this.f262q.setAudioStreamType(3);
            this.f262q.prepareAsync();
            this.f270y = new C0177b(this);
            new Thread(this.f270y).start();
        } catch (Exception e2) {
            if (f246a) {
                m171b("error: " + e2.getMessage() + e2);
            }
            m169a(2);
        }
    }

    /* renamed from: d */
    private void m174d() {
        if (!isPlaying()) {
            m169a(1);
            if (f246a) {
                m171b("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.f267v) {
                start();
            }
        }
    }

    public final void CancelOnPrepare() {
        m169a(2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo1699a() {
        return this.f267v;
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
        if (f246a) {
            m171b("destroyPlayer");
        }
        if (!this.f267v) {
            pause();
        }
        doCleanUp();
    }

    /* access modifiers changed from: protected */
    public final void doCleanUp() {
        if (this.f270y != null) {
            this.f270y.mo1723a();
            this.f270y = null;
        }
        if (this.f262q != null) {
            this.f262q.release();
            this.f262q = null;
        }
        this.f260o = 0;
        this.f261p = 0;
        this.f265t = false;
        this.f264s = false;
    }

    public final int getBufferPercentage() {
        if (this.f253h) {
            return this.f266u;
        }
        return 100;
    }

    public final int getCurrentPosition() {
        if (this.f262q == null) {
            return 0;
        }
        return this.f262q.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.f262q == null) {
            return 0;
        }
        return this.f262q.getDuration();
    }

    public final boolean isPlaying() {
        boolean z = this.f265t && this.f264s;
        return this.f262q == null ? !z : this.f262q.isPlaying() || !z;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f246a) {
            m171b("onBufferingUpdate percent:" + i);
        }
        this.f266u = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f246a) {
            m171b("onCompletion called");
        }
        destroyPlayer();
        m169a(3);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f251f != 2 || i == 0 || keyEvent.isSystem())) {
            return this.f263r != null ? this.f263r.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
        destroyPlayer();
        m169a(3);
        return true;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f246a) {
            m171b("onPrepared called");
        }
        if (this.f270y != null) {
            this.f270y.mo1723a();
            this.f270y = null;
        }
        if (this.f251f == 0 || this.f251f == 1) {
            this.f263r = new MediaController(this.f247b);
            this.f263r.setMediaPlayer(this);
            this.f263r.setAnchorView(this);
            this.f263r.setEnabled(true);
            this.f263r.show();
        }
        this.f265t = true;
        if (this.f265t && this.f264s) {
            m174d();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & BufferSpec.DepthStencilFormat.NONE;
        if (this.f251f != 2 || action != 0) {
            return this.f263r != null ? this.f263r.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        m169a(3);
        return true;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f246a) {
            m171b("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.f264s = true;
            this.f260o = i;
            this.f261p = i2;
            if (this.f265t && this.f264s) {
                m174d();
            }
        } else if (f246a) {
            m171b("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    public final void pause() {
        if (this.f262q != null) {
            if (this.f268w) {
                this.f262q.pause();
            }
            this.f267v = true;
        }
    }

    public final void seekTo(int i) {
        if (this.f262q != null) {
            this.f262q.seekTo(i);
        }
    }

    public final void start() {
        if (f246a) {
            m171b("Start");
        }
        if (this.f262q != null) {
            if (this.f268w) {
                this.f262q.start();
            }
            this.f267v = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f246a) {
            m171b("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.f258m != i2 || this.f259n != i3) {
            this.f258m = i2;
            this.f259n = i3;
            if (this.f268w) {
                updateVideoLayout();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f246a) {
            m171b("surfaceCreated called");
        }
        this.f268w = true;
        m173c();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f246a) {
            m171b("surfaceDestroyed called");
        }
        this.f268w = false;
    }

    /* access modifiers changed from: protected */
    public final void updateVideoLayout() {
        if (f246a) {
            m171b("updateVideoLayout");
        }
        if (this.f262q != null) {
            if (this.f258m == 0 || this.f259n == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.f247b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                this.f258m = displayMetrics.widthPixels;
                this.f259n = displayMetrics.heightPixels;
            }
            int i = this.f258m;
            int i2 = this.f259n;
            if (this.f264s) {
                float f = ((float) this.f260o) / ((float) this.f261p);
                float f2 = ((float) this.f258m) / ((float) this.f259n);
                if (this.f252g == 1) {
                    if (f2 <= f) {
                        i2 = (int) (((float) this.f258m) / f);
                    } else {
                        i = (int) (((float) this.f259n) * f);
                    }
                } else if (this.f252g == 2) {
                    if (f2 >= f) {
                        i2 = (int) (((float) this.f258m) / f);
                    } else {
                        i = (int) (((float) this.f259n) * f);
                    }
                } else if (this.f252g == 0) {
                    i = this.f260o;
                    i2 = this.f261p;
                }
            } else if (f246a) {
                m171b("updateVideoLayout: Video size is not known yet");
            }
            if (this.f258m != i || this.f259n != i2) {
                if (f246a) {
                    m171b("frameWidth = " + i + "; frameHeight = " + i2);
                }
                this.f256k.updateViewLayout(this.f248c, new FrameLayout.LayoutParams(i, i2, 17));
            }
        }
    }
}
