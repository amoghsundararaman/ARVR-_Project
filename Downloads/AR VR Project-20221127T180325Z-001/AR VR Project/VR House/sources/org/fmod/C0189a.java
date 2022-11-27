package org.fmod;

import android.media.AudioRecord;
import java.nio.ByteBuffer;

/* renamed from: org.fmod.a */
final class C0189a implements Runnable {

    /* renamed from: a */
    private final FMODAudioDevice f308a;

    /* renamed from: b */
    private final ByteBuffer f309b;

    /* renamed from: c */
    private final int f310c;

    /* renamed from: d */
    private final int f311d;

    /* renamed from: e */
    private final int f312e = 2;

    /* renamed from: f */
    private volatile Thread f313f;

    /* renamed from: g */
    private volatile boolean f314g;

    /* renamed from: h */
    private AudioRecord f315h;

    /* renamed from: i */
    private boolean f316i;

    C0189a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f308a = fMODAudioDevice;
        this.f310c = i;
        this.f311d = i2;
        this.f309b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* renamed from: d */
    private void m195d() {
        if (this.f315h != null) {
            if (this.f315h.getState() == 1) {
                this.f315h.stop();
            }
            this.f315h.release();
            this.f315h = null;
        }
        this.f309b.position(0);
        this.f316i = false;
    }

    /* renamed from: a */
    public final int mo1754a() {
        return this.f309b.capacity();
    }

    /* renamed from: b */
    public final void mo1755b() {
        if (this.f313f != null) {
            mo1756c();
        }
        this.f314g = true;
        this.f313f = new Thread(this);
        this.f313f.start();
    }

    /* renamed from: c */
    public final void mo1756c() {
        while (this.f313f != null) {
            this.f314g = false;
            try {
                this.f313f.join();
                this.f313f = null;
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            r7 = 3
            r1 = 1
            r8 = 0
            r6 = r7
        L_0x0004:
            boolean r0 = r9.f314g
            if (r0 == 0) goto L_0x008f
            boolean r0 = r9.f316i
            if (r0 != 0) goto L_0x008d
            if (r6 <= 0) goto L_0x008d
            r9.m195d()
            android.media.AudioRecord r0 = new android.media.AudioRecord
            int r2 = r9.f310c
            int r3 = r9.f311d
            int r4 = r9.f312e
            java.nio.ByteBuffer r5 = r9.f309b
            int r5 = r5.capacity()
            r0.<init>(r1, r2, r3, r4, r5)
            r9.f315h = r0
            android.media.AudioRecord r0 = r9.f315h
            int r0 = r0.getState()
            if (r0 != r1) goto L_0x0066
            r0 = r1
        L_0x002d:
            r9.f316i = r0
            boolean r0 = r9.f316i
            if (r0 == 0) goto L_0x0068
            java.nio.ByteBuffer r0 = r9.f309b
            r0.position(r8)
            android.media.AudioRecord r0 = r9.f315h
            r0.startRecording()
            r0 = r7
        L_0x003e:
            boolean r2 = r9.f316i
            if (r2 == 0) goto L_0x0093
            android.media.AudioRecord r2 = r9.f315h
            int r2 = r2.getRecordingState()
            if (r2 != r7) goto L_0x0093
            android.media.AudioRecord r2 = r9.f315h
            java.nio.ByteBuffer r3 = r9.f309b
            java.nio.ByteBuffer r4 = r9.f309b
            int r4 = r4.capacity()
            int r2 = r2.read(r3, r4)
            org.fmod.FMODAudioDevice r3 = r9.f308a
            java.nio.ByteBuffer r4 = r9.f309b
            r3.fmodProcessMicData(r4, r2)
            java.nio.ByteBuffer r2 = r9.f309b
            r2.position(r8)
            r6 = r0
            goto L_0x0004
        L_0x0066:
            r0 = r8
            goto L_0x002d
        L_0x0068:
            java.lang.String r0 = "FMOD"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "AudioRecord failed to initialize (status "
            r2.<init>(r3)
            android.media.AudioRecord r3 = r9.f315h
            int r3 = r3.getState()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r0, r2)
            int r6 = r6 + -1
            r9.m195d()
        L_0x008d:
            r0 = r6
            goto L_0x003e
        L_0x008f:
            r9.m195d()
            return
        L_0x0093:
            r6 = r0
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fmod.C0189a.run():void");
    }
}
