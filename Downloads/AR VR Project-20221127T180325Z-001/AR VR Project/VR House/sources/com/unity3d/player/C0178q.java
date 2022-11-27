package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.unity3d.player.C0175p;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.q */
final class C0178q {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public UnityPlayer f275a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f276b = null;

    /* renamed from: c */
    private C0185a f277c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Semaphore f278d = new Semaphore(0);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Lock f279e = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0175p f280f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f281g = 2;

    /* renamed from: h */
    private boolean f282h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f283i = false;

    /* renamed from: com.unity3d.player.q$a */
    public interface C0185a {
        /* renamed from: a */
        void mo1574a();
    }

    C0178q(UnityPlayer unityPlayer) {
        this.f275a = unityPlayer;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m184d() {
        if (this.f280f != null) {
            this.f275a.removeViewFromPlayer(this.f280f);
            this.f283i = false;
            this.f280f.destroyPlayer();
            this.f280f = null;
            if (this.f277c != null) {
                this.f277c.mo1574a();
            }
        }
    }

    /* renamed from: a */
    public final void mo1725a() {
        this.f279e.lock();
        if (this.f280f != null) {
            if (this.f281g == 0) {
                this.f280f.CancelOnPrepare();
            } else if (this.f283i) {
                this.f282h = this.f280f.mo1699a();
                if (!this.f282h) {
                    this.f280f.pause();
                }
            }
        }
        this.f279e.unlock();
    }

    /* renamed from: a */
    public final boolean mo1726a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0185a aVar) {
        this.f279e.lock();
        this.f277c = aVar;
        this.f276b = context;
        this.f278d.drainPermits();
        this.f281g = 2;
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        final long j3 = j;
        final long j4 = j2;
        runOnUiThread(new Runnable() {
            public final void run() {
                if (C0178q.this.f280f != null) {
                    C0160g.Log(5, "Video already playing");
                    int unused = C0178q.this.f281g = 2;
                    C0178q.this.f278d.release();
                    return;
                }
                C0175p unused2 = C0178q.this.f280f = new C0175p(C0178q.this.f276b, str2, i4, i5, i6, z2, j3, j4, new C0175p.C0176a() {
                    /* renamed from: a */
                    public final void mo1722a(int i) {
                        C0178q.this.f279e.lock();
                        int unused = C0178q.this.f281g = i;
                        if (i == 3 && C0178q.this.f283i) {
                            C0178q.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    C0178q.this.m184d();
                                    C0178q.this.f275a.resume();
                                }
                            });
                        }
                        if (i != 0) {
                            C0178q.this.f278d.release();
                        }
                        C0178q.this.f279e.unlock();
                    }
                });
                if (C0178q.this.f280f != null) {
                    C0178q.this.f275a.addView(C0178q.this.f280f);
                }
            }
        });
        boolean z3 = false;
        try {
            this.f279e.unlock();
            this.f278d.acquire();
            this.f279e.lock();
            z3 = this.f281g != 2;
        } catch (InterruptedException e) {
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                C0178q.this.f275a.pause();
            }
        });
        if (!z3 || this.f281g == 3) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    C0178q.this.m184d();
                    C0178q.this.f275a.resume();
                }
            });
        } else {
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (C0178q.this.f280f != null) {
                        C0178q.this.f275a.addViewToPlayer(C0178q.this.f280f, true);
                        boolean unused = C0178q.this.f283i = true;
                        C0178q.this.f280f.requestFocus();
                    }
                }
            });
        }
        this.f279e.unlock();
        return z3;
    }

    /* renamed from: b */
    public final void mo1727b() {
        this.f279e.lock();
        if (this.f280f != null && this.f283i && !this.f282h) {
            this.f280f.start();
        }
        this.f279e.unlock();
    }

    /* renamed from: c */
    public final void mo1728c() {
        this.f279e.lock();
        if (this.f280f != null) {
            this.f280f.updateVideoLayout();
        }
        this.f279e.unlock();
    }

    /* access modifiers changed from: protected */
    public final void runOnUiThread(Runnable runnable) {
        if (this.f276b instanceof Activity) {
            ((Activity) this.f276b).runOnUiThread(runnable);
        } else {
            C0160g.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
