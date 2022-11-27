package com.google.p000vr.cardboard;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Choreographer;

/* renamed from: com.google.vr.cardboard.FrameMonitor */
public class FrameMonitor implements Handler.Callback, Choreographer.FrameCallback {
    private static final int CREATE_CHOREOGRAPHER = 0;
    private static final int MSG_POST_FRAME_CALLBACK = 1;
    private static final int MSG_REMOVE_FRAME_CALLBACK = 2;
    private static final String TAG = FrameMonitor.class.getSimpleName();
    private final Choreographer.FrameCallback callback;
    private Choreographer choreographer;
    private final HandlerThread choreographerOwnerThread;
    private Handler handler;
    private boolean isResumed;

    public FrameMonitor(Choreographer.FrameCallback frameCallback) {
        this((Choreographer) null, frameCallback);
    }

    public FrameMonitor(Choreographer choreographer2, Choreographer.FrameCallback frameCallback) {
        this.callback = frameCallback;
        this.choreographer = choreographer2;
        this.choreographerOwnerThread = new HandlerThread("FrameMonitor");
    }

    public void init() {
        this.choreographerOwnerThread.start();
        this.handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public Looper getLooper() {
        return this.handler.getLooper();
    }

    public void onPause() {
        if (this.isResumed) {
            this.isResumed = false;
            this.handler.sendEmptyMessage(2);
        }
    }

    public void onResume() {
        if (!this.isResumed) {
            this.isResumed = true;
            this.handler.sendEmptyMessage(1);
        }
    }

    public void shutdown() {
        onPause();
        this.choreographerOwnerThread.quitSafely();
        try {
            this.choreographerOwnerThread.join();
        } catch (InterruptedException e) {
            String str = TAG;
            String valueOf = String.valueOf(e);
            Log.e(str, new StringBuilder(String.valueOf(valueOf).length() + 45).append("Interrupted when shutting down FrameMonitor: ").append(valueOf).toString());
        }
    }

    public void doFrame(long j) {
        this.callback.doFrame(j);
        this.choreographer.postFrameCallback(this);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (this.choreographer != null) {
                    return true;
                }
                this.choreographer = Choreographer.getInstance();
                return true;
            case 1:
                this.choreographer.postFrameCallback(this);
                return true;
            case 2:
                this.choreographer.removeFrameCallback(this);
                return true;
            default:
                return false;
        }
    }
}
