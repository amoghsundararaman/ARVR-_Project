package com.google.p000vr.cardboard;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.p000vr.ndk.base.GvrSurfaceView;
import java.util.ArrayList;

/* renamed from: com.google.vr.cardboard.CardboardGLSurfaceView */
public class CardboardGLSurfaceView extends GvrSurfaceView {
    private static final String TAG = CardboardGLSurfaceView.class.getSimpleName();
    private final EglFactory eglFactory = new EglFactory();
    private ArrayList<Runnable> eventQueueWhileDetached;
    private boolean isDetached;
    private boolean isRendererSet;
    private final DetachListener listener;

    /* renamed from: com.google.vr.cardboard.CardboardGLSurfaceView$DetachListener */
    public interface DetachListener {
        void onSurfaceViewDetachedFromWindow();
    }

    public CardboardGLSurfaceView(Context context, DetachListener detachListener) {
        super(context);
        this.listener = detachListener;
        setEGLContextFactory(this.eglFactory);
        setEGLWindowSurfaceFactory(this.eglFactory);
    }

    public CardboardGLSurfaceView(Context context, AttributeSet attributeSet, DetachListener detachListener) {
        super(context, attributeSet);
        this.listener = detachListener;
        setEGLContextFactory(this.eglFactory);
        setEGLWindowSurfaceFactory(this.eglFactory);
    }

    public void onPause() {
        if (this.isRendererSet) {
            super.onPause();
        }
    }

    public void onResume() {
        if (this.isRendererSet) {
            super.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isDetached = false;
        if (this.eventQueueWhileDetached != null) {
            ArrayList arrayList = this.eventQueueWhileDetached;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.queueEvent((Runnable) obj);
            }
            this.eventQueueWhileDetached.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.isRendererSet && this.listener != null) {
            this.listener.onSurfaceViewDetachedFromWindow();
        }
        super.onDetachedFromWindow();
        this.isDetached = true;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        super.setRenderer(renderer);
        this.isRendererSet = true;
    }

    public void setEGLContextClientVersion(int i) {
        super.setEGLContextClientVersion(i);
        this.eglFactory.setEGLContextClientVersion(i);
    }

    public void queueEvent(Runnable runnable) {
        if (!this.isRendererSet) {
            runnable.run();
        } else if (this.isDetached) {
            if (this.eventQueueWhileDetached == null) {
                this.eventQueueWhileDetached = new ArrayList<>();
            }
            this.eventQueueWhileDetached.add(runnable);
        } else {
            super.queueEvent(runnable);
        }
    }

    public boolean isDetached() {
        return this.isDetached;
    }
}
