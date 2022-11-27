package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.unity3d.player.C0072p;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.q */
final class C0075q {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public UnityPlayer f270a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f271b = null;

    /* renamed from: c */
    private C0082a f272c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Semaphore f273d = new Semaphore(0);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Lock f274e = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0072p f275f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f276g = 2;

    /* renamed from: h */
    private boolean f277h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f278i = false;

    /* renamed from: com.unity3d.player.q$a */
    public interface C0082a {
        /* renamed from: a */
        void mo103a();
    }

    C0075q(UnityPlayer unityPlayer) {
        this.f270a = unityPlayer;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m198d() {
        C0072p pVar = this.f275f;
        if (pVar != null) {
            this.f270a.removeViewFromPlayer(pVar);
            this.f278i = false;
            this.f275f.destroyPlayer();
            this.f275f = null;
            C0082a aVar = this.f272c;
            if (aVar != null) {
                aVar.mo103a();
            }
        }
    }

    /* renamed from: a */
    public final void mo264a() {
        this.f274e.lock();
        C0072p pVar = this.f275f;
        if (pVar != null) {
            if (this.f276g == 0) {
                pVar.CancelOnPrepare();
            } else if (this.f278i) {
                this.f277h = pVar.mo238a();
                if (!this.f277h) {
                    this.f275f.pause();
                }
            }
        }
        this.f274e.unlock();
    }

    /* renamed from: a */
    public final boolean mo265a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0082a aVar) {
        this.f274e.lock();
        this.f272c = aVar;
        this.f271b = context;
        this.f273d.drainPermits();
        this.f276g = 2;
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        final long j3 = j;
        final long j4 = j2;
        runOnUiThread(new Runnable() {
            public final void run() {
                if (C0075q.this.f275f != null) {
                    C0057g.Log(5, "Video already playing");
                    int unused = C0075q.this.f276g = 2;
                    C0075q.this.f273d.release();
                    return;
                }
                C0075q qVar = C0075q.this;
                C0072p unused2 = qVar.f275f = new C0072p(qVar.f271b, str2, i4, i5, i6, z2, j3, j4, new C0072p.C0073a() {
                    /* renamed from: a */
                    public final void mo261a(int i) {
                        C0075q.this.f274e.lock();
                        int unused = C0075q.this.f276g = i;
                        if (i == 3 && C0075q.this.f278i) {
                            C0075q.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    C0075q.this.m198d();
                                    C0075q.this.f270a.resume();
                                }
                            });
                        }
                        if (i != 0) {
                            C0075q.this.f273d.release();
                        }
                        C0075q.this.f274e.unlock();
                    }
                });
                if (C0075q.this.f275f != null) {
                    C0075q.this.f270a.addView(C0075q.this.f275f);
                }
            }
        });
        boolean z3 = false;
        try {
            this.f274e.unlock();
            this.f273d.acquire();
            this.f274e.lock();
            if (this.f276g != 2) {
                z3 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                C0075q.this.f270a.pause();
            }
        });
        runOnUiThread((!z3 || this.f276g == 3) ? new Runnable() {
            public final void run() {
                C0075q.this.m198d();
                C0075q.this.f270a.resume();
            }
        } : new Runnable() {
            public final void run() {
                if (C0075q.this.f275f != null) {
                    C0075q.this.f270a.addViewToPlayer(C0075q.this.f275f, true);
                    boolean unused = C0075q.this.f278i = true;
                    C0075q.this.f275f.requestFocus();
                }
            }
        });
        this.f274e.unlock();
        return z3;
    }

    /* renamed from: b */
    public final void mo266b() {
        this.f274e.lock();
        C0072p pVar = this.f275f;
        if (pVar != null && this.f278i && !this.f277h) {
            pVar.start();
        }
        this.f274e.unlock();
    }

    /* renamed from: c */
    public final void mo267c() {
        this.f274e.lock();
        C0072p pVar = this.f275f;
        if (pVar != null) {
            pVar.updateVideoLayout();
        }
        this.f274e.unlock();
    }

    /* access modifiers changed from: protected */
    public final void runOnUiThread(Runnable runnable) {
        Context context = this.f271b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            C0057g.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
