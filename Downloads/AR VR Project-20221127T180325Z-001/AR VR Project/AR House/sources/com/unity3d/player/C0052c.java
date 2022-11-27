package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.c */
class C0052c {

    /* renamed from: a */
    protected C0070o f198a = null;

    /* renamed from: b */
    protected C0056f f199b = null;

    /* renamed from: c */
    protected Context f200c = null;

    /* renamed from: d */
    protected String f201d = null;

    /* renamed from: e */
    protected String f202e = "";

    C0052c(String str, C0056f fVar) {
        this.f202e = str;
        this.f199b = fVar;
    }

    /* access modifiers changed from: protected */
    public void reportError(String str) {
        C0056f fVar = this.f199b;
        if (fVar != null) {
            fVar.reportError(this.f202e + " Error [" + this.f201d + "]", str);
            return;
        }
        C0057g.Log(6, this.f202e + " Error [" + this.f201d + "]: " + str);
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        Context context = this.f200c;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
            return;
        }
        C0057g.Log(5, "Not running " + this.f202e + " from an Activity; Ignoring execution request...");
    }

    /* access modifiers changed from: protected */
    public boolean runOnUiThreadWithSync(final Runnable runnable) {
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
                    C0052c cVar = C0052c.this;
                    cVar.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                } catch (Throwable th) {
                    semaphore.release();
                    throw th;
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return true;
            }
            reportError("Timeout waiting for vr state change!");
            return false;
        } catch (InterruptedException e) {
            reportError("Interrupted while trying to acquire sync lock. " + e.getLocalizedMessage());
            return false;
        }
    }
}
