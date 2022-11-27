package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {

    /* renamed from: h */
    private static int f293h = 0;

    /* renamed from: i */
    private static int f294i = 1;

    /* renamed from: j */
    private static int f295j = 2;

    /* renamed from: k */
    private static int f296k = 3;

    /* renamed from: a */
    private volatile Thread f297a = null;

    /* renamed from: b */
    private volatile boolean f298b = false;

    /* renamed from: c */
    private AudioTrack f299c = null;

    /* renamed from: d */
    private boolean f300d = false;

    /* renamed from: e */
    private ByteBuffer f301e = null;

    /* renamed from: f */
    private byte[] f302f = null;

    /* renamed from: g */
    private volatile C0093a f303g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f299c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f299c.stop();
            }
            this.f299c.release();
            this.f299c = null;
        }
        this.f301e = null;
        this.f302f = null;
        this.f300d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f297a != null && this.f297a.isAlive();
    }

    public void run() {
        int i = 3;
        while (this.f298b) {
            if (!this.f300d && i > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f293h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(f294i);
                int fmodGetInfo3 = fmodGetInfo(f295j) * fmodGetInfo2 * 4;
                this.f299c = new AudioTrack(3, fmodGetInfo, 3, 2, fmodGetInfo3 > round ? fmodGetInfo3 : round, 1);
                this.f300d = this.f299c.getState() == 1;
                if (this.f300d) {
                    this.f301e = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f302f = new byte[this.f301e.capacity()];
                    this.f299c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f299c.getState() + ")");
                    releaseAudioTrack();
                    i += -1;
                }
            }
            if (this.f300d) {
                if (fmodGetInfo(f296k) == 1) {
                    fmodProcess(this.f301e);
                    ByteBuffer byteBuffer = this.f301e;
                    byteBuffer.get(this.f302f, 0, byteBuffer.capacity());
                    this.f299c.write(this.f302f, 0, this.f301e.capacity());
                    this.f301e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f297a != null) {
            stop();
        }
        this.f297a = new Thread(this, "FMODAudioDevice");
        this.f297a.setPriority(10);
        this.f298b = true;
        this.f297a.start();
        if (this.f303g != null) {
            this.f303g.mo948b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f303g == null) {
            this.f303g = new C0093a(this, i, i2);
            this.f303g.mo948b();
        }
        return this.f303g.mo947a();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:16:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop() {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            java.lang.Thread r0 = r1.f297a     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0011
            r0 = 0
            r1.f298b = r0     // Catch:{ all -> 0x001c }
            java.lang.Thread r0 = r1.f297a     // Catch:{ InterruptedException -> 0x0001 }
            r0.join()     // Catch:{ InterruptedException -> 0x0001 }
            r0 = 0
            r1.f297a = r0     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x0011:
            org.fmod.a r0 = r1.f303g     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            org.fmod.a r0 = r1.f303g     // Catch:{ all -> 0x001c }
            r0.mo949c()     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fmod.FMODAudioDevice.stop():void");
    }

    public synchronized void stopAudioRecord() {
        if (this.f303g != null) {
            this.f303g.mo949c();
            this.f303g = null;
        }
    }
}
