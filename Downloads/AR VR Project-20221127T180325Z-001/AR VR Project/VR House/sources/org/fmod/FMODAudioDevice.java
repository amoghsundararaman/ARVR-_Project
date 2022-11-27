package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {

    /* renamed from: h */
    private static int f297h = 0;

    /* renamed from: i */
    private static int f298i = 1;

    /* renamed from: j */
    private static int f299j = 2;

    /* renamed from: k */
    private static int f300k = 3;

    /* renamed from: a */
    private volatile Thread f301a = null;

    /* renamed from: b */
    private volatile boolean f302b = false;

    /* renamed from: c */
    private AudioTrack f303c = null;

    /* renamed from: d */
    private boolean f304d = false;

    /* renamed from: e */
    private ByteBuffer f305e = null;

    /* renamed from: f */
    private byte[] f306f = null;

    /* renamed from: g */
    private volatile C0189a f307g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        if (this.f303c != null) {
            if (this.f303c.getState() == 1) {
                this.f303c.stop();
            }
            this.f303c.release();
            this.f303c = null;
        }
        this.f305e = null;
        this.f306f = null;
        this.f304d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f301a != null && this.f301a.isAlive();
    }

    public void run() {
        int i;
        int i2 = 3;
        while (this.f302b) {
            if (this.f304d || i2 <= 0) {
                i = i2;
            } else {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f297h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(f298i);
                int fmodGetInfo3 = fmodGetInfo(f299j);
                if (fmodGetInfo2 * fmodGetInfo3 * 4 > round) {
                    round = fmodGetInfo3 * fmodGetInfo2 * 4;
                }
                this.f303c = new AudioTrack(3, fmodGetInfo, 3, 2, round, 1);
                this.f304d = this.f303c.getState() == 1;
                if (this.f304d) {
                    this.f305e = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f306f = new byte[this.f305e.capacity()];
                    this.f303c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f303c.getState() + ")");
                    releaseAudioTrack();
                    i = i2 - 1;
                }
            }
            if (!this.f304d) {
                i2 = i;
            } else if (fmodGetInfo(f300k) == 1) {
                fmodProcess(this.f305e);
                this.f305e.get(this.f306f, 0, this.f305e.capacity());
                this.f303c.write(this.f306f, 0, this.f305e.capacity());
                this.f305e.position(0);
                i2 = i;
            } else {
                releaseAudioTrack();
                i2 = i;
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f301a != null) {
            stop();
        }
        this.f301a = new Thread(this, "FMODAudioDevice");
        this.f301a.setPriority(10);
        this.f302b = true;
        this.f301a.start();
        if (this.f307g != null) {
            this.f307g.mo1755b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f307g == null) {
            this.f307g = new C0189a(this, i, i2);
            this.f307g.mo1755b();
        }
        return this.f307g.mo1754a();
    }

    public synchronized void stop() {
        while (this.f301a != null) {
            this.f302b = false;
            try {
                this.f301a.join();
                this.f301a = null;
            } catch (InterruptedException e) {
            }
        }
        if (this.f307g != null) {
            this.f307g.mo1756c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f307g != null) {
            this.f307g.mo1756c();
            this.f307g = null;
        }
    }
}
