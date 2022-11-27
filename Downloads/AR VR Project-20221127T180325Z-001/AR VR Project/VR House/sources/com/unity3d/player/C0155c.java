package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.c */
class C0155c {

    /* renamed from: a */
    protected C0173o f202a = null;

    /* renamed from: b */
    protected C0159f f203b = null;

    /* renamed from: c */
    protected Context f204c = null;

    /* renamed from: d */
    protected String f205d = null;

    /* renamed from: e */
    protected String f206e = "";

    C0155c(String str, C0159f fVar) {
        this.f206e = str;
        this.f203b = fVar;
    }

    /* access modifiers changed from: protected */
    public void reportError(String str) {
        if (this.f203b != null) {
            this.f203b.reportError(this.f206e + " Error [" + this.f205d + "]", str);
        } else {
            C0160g.Log(6, this.f206e + " Error [" + this.f205d + "]: " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        if (this.f204c instanceof Activity) {
            ((Activity) this.f204c).runOnUiThread(runnable);
        } else {
            C0160g.Log(5, "Not running " + this.f206e + " from an Activity; Ignoring execution request...");
        }
    }

    /* access modifiers changed from: protected */
    public boolean runOnUiThreadWithSync(final Runnable runnable) {
        boolean z = false;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return true;
        }
        final Semaphore semaphore = new Semaphore(0);
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    C0155c.this.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                } finally {
                    semaphore.release();
                }
            }
        });
        try {
            if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                reportError("Timeout waiting for vr state change!");
            } else {
                z = true;
            }
        } catch (InterruptedException e) {
            reportError("Interrupted while trying to acquire sync lock. " + e.getLocalizedMessage());
        }
        return z;
    }
}
