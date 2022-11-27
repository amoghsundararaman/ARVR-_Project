package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* renamed from: org.fmod.a */
final class C0093a implements Runnable {

    /* renamed from: a */
    private final FMODAudioDevice f304a;

    /* renamed from: b */
    private final ByteBuffer f305b;

    /* renamed from: c */
    private final int f306c;

    /* renamed from: d */
    private final int f307d;

    /* renamed from: e */
    private final int f308e = 2;

    /* renamed from: f */
    private volatile Thread f309f;

    /* renamed from: g */
    private volatile boolean f310g;

    /* renamed from: h */
    private AudioRecord f311h;

    /* renamed from: i */
    private boolean f312i;

    C0093a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f304a = fMODAudioDevice;
        this.f306c = i;
        this.f307d = i2;
        this.f305b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* renamed from: d */
    private void m220d() {
        AudioRecord audioRecord = this.f311h;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.f311h.stop();
            }
            this.f311h.release();
            this.f311h = null;
        }
        this.f305b.position(0);
        this.f312i = false;
    }

    /* renamed from: a */
    public final int mo947a() {
        return this.f305b.capacity();
    }

    /* renamed from: b */
    public final void mo948b() {
        if (this.f309f != null) {
            mo949c();
        }
        this.f310g = true;
        this.f309f = new Thread(this);
        this.f309f.start();
    }

    /* renamed from: c */
    public final void mo949c() {
        while (this.f309f != null) {
            this.f310g = false;
            try {
                this.f309f.join();
                this.f309f = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void run() {
        int i = 3;
        while (this.f310g) {
            if (!this.f312i && i > 0) {
                m220d();
                this.f311h = new AudioRecord(1, this.f306c, this.f307d, this.f308e, this.f305b.capacity());
                boolean z = true;
                if (this.f311h.getState() != 1) {
                    z = false;
                }
                this.f312i = z;
                if (this.f312i) {
                    this.f305b.position(0);
                    this.f311h.startRecording();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f311h.getState() + ")");
                    i += -1;
                    m220d();
                }
            }
            if (this.f312i && this.f311h.getRecordingState() == 3) {
                AudioRecord audioRecord = this.f311h;
                ByteBuffer byteBuffer = this.f305b;
                this.f304a.fmodProcessMicData(this.f305b, audioRecord.read(byteBuffer, byteBuffer.capacity()));
                this.f305b.position(0);
            }
        }
        m220d();
    }
}
