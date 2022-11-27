package com.google.p000vr.cardboard;

import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Process;
import com.google.p000vr.ndk.base.GvrApi;
import com.google.p000vr.ndk.base.GvrSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.google.vr.cardboard.ScanlineRacingRenderer */
public class ScanlineRacingRenderer implements GLSurfaceView.Renderer {
    private static final String TAG = "ScanlineRacingRenderer";
    private final GvrApi gvrApi;
    /* access modifiers changed from: private */
    public GvrSurfaceView gvrSurfaceView;

    public ScanlineRacingRenderer(GvrApi gvrApi2) {
        if (gvrApi2 == null) {
            throw new IllegalArgumentException("GvrApi must be supplied for proper scanline rendering");
        }
        this.gvrApi = gvrApi2;
    }

    public void setSurfaceView(GvrSurfaceView gvrSurfaceView2) {
        if (gvrSurfaceView2 == null) {
            throw new IllegalArgumentException("GvrSurfaceView must be supplied for proper scanline rendering");
        }
        this.gvrSurfaceView = gvrSurfaceView2;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Thread.currentThread().setPriority(10);
        AndroidNCompat.setVrThread(Process.myTid());
        this.gvrApi.onSurfaceCreatedReprojectionThread();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.gvrApi.onSurfaceChangedReprojectionThread();
    }

    public void onDrawFrame(GL10 gl10) {
        Point renderReprojectionThread = this.gvrApi.renderReprojectionThread();
        if (renderReprojectionThread != null) {
            setSurfaceSize(renderReprojectionThread.x, renderReprojectionThread.y);
        }
    }

    public void onSurfaceDestroyed() {
        onPause();
    }

    public void setSurfaceSize(final int i, final int i2) {
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (i <= 0 || i2 <= 0) {
                    ScanlineRacingRenderer.this.gvrSurfaceView.getHolder().setSizeFromLayout();
                } else {
                    ScanlineRacingRenderer.this.gvrSurfaceView.getHolder().setFixedSize(i, i2);
                }
            }
        });
    }

    public void onPause() {
        this.gvrApi.onPauseReprojectionThread();
    }
}
