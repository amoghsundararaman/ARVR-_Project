package com.google.p000vr.ndk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;

/* renamed from: com.google.vr.ndk.base.FadeOverlayView */
class FadeOverlayView extends View {
    static final long AUTO_FADE_DURATION_MILLIS = 350;
    static final int AUTO_FADE_QUICK_START_DELAY_MILLIS = 200;
    static final long AUTO_FADE_START_DELAY_MILLIS = 1000;
    private static final boolean DEBUG = false;
    static final int DEFAULT_BACKGROUND_COLOR = -16777216;
    private static final int MSG_AUTO_FADE = 77337733;
    private static final String TAG = "FadeOverlayView";
    private final boolean autoFadeEnabled;
    private final Handler autoFadeHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == FadeOverlayView.MSG_AUTO_FADE) {
                FadeOverlayView.this.startFade(1, 350, -16777216);
            } else {
                super.handleMessage(message);
            }
        }
    };
    private long fadeDurationMillis;
    private float fadeStartOpacity;
    private long fadeStartTimeMillis;
    private int fadeType = 0;
    private final Runnable fadeUpdateRunnable = new Runnable() {
        public void run() {
            FadeOverlayView.this.updateFade();
        }
    };
    private boolean flushAutoFadeOnVisible;
    private boolean visible;

    public FadeOverlayView(Context context, boolean z) {
        super(context);
        setBackgroundColor(-16777216);
        this.autoFadeEnabled = z;
    }

    public void startFade(int i, long j, int i2) {
        if (!isEnabled()) {
            Log.w(TAG, "Ignoring fade request while disabled.");
        } else if (!this.visible) {
            Log.w(TAG, "Ignoring fade request while invisible.");
        } else {
            setBackgroundColor(i2);
            removeFadeCallbacks();
            this.fadeType = i;
            this.fadeDurationMillis = j;
            this.fadeStartTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.fadeStartOpacity = getAlpha();
            updateFade();
        }
    }

    public void onInvisible() {
        if (this.visible) {
            this.visible = false;
            if (isEnabled() && this.autoFadeEnabled) {
                removeFadeCallbacks();
                this.fadeType = 2;
                endFade();
            }
        }
    }

    public void onVisible() {
        long j;
        if (!this.visible || getAlpha() != 0.0f) {
            this.visible = true;
            if (!isEnabled() || !this.autoFadeEnabled) {
                this.fadeType = 1;
                endFade();
                return;
            }
            removeFadeCallbacks();
            Handler handler = this.autoFadeHandler;
            if (this.flushAutoFadeOnVisible) {
                j = 200;
            } else {
                j = 1000;
            }
            handler.sendEmptyMessageDelayed(MSG_AUTO_FADE, j);
        }
    }

    public void flushAutoFade() {
        if (this.autoFadeEnabled) {
            if (this.autoFadeHandler.hasMessages(MSG_AUTO_FADE)) {
                this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
                this.autoFadeHandler.sendEmptyMessageDelayed(MSG_AUTO_FADE, 200);
            } else if (!this.visible) {
                this.flushAutoFadeOnVisible = true;
            }
        }
    }

    public void setEnabled(boolean z) {
        if (isEnabled() != z) {
            super.setEnabled(z);
            if (!z) {
                removeFadeCallbacks();
                this.fadeType = 1;
                endFade();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getFadeType() {
        return this.fadeType;
    }

    /* access modifiers changed from: package-private */
    public boolean isVisible() {
        return this.visible;
    }

    private void removeFadeCallbacks() {
        this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
        removeCallbacks(this.fadeUpdateRunnable);
    }

    private void endFade() {
        if (this.fadeType != 0) {
            setVisibility(this.fadeType == 2 ? 0 : 8);
            setAlpha(this.fadeType == 2 ? 1.0f : 0.0f);
            removeCallbacks(this.fadeUpdateRunnable);
            this.fadeType = 0;
            this.flushAutoFadeOnVisible = false;
        }
    }

    /* access modifiers changed from: private */
    public void updateFade() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.fadeStartTimeMillis;
        float f = ((float) currentAnimationTimeMillis) / ((float) this.fadeDurationMillis);
        if (this.fadeType == 1) {
            f = -f;
        }
        float min = Math.min(Math.max(f + this.fadeStartOpacity, 0.0f), 1.0f);
        setAlpha(min);
        if (currentAnimationTimeMillis < this.fadeDurationMillis && getVisibility() != 0) {
            setVisibility(0);
        }
        if (currentAnimationTimeMillis >= this.fadeDurationMillis || ((this.fadeType == 1 && min <= 0.0f) || (this.fadeType == 2 && min >= 1.0f))) {
            endFade();
        } else {
            postOnAnimation(this.fadeUpdateRunnable);
        }
    }
}
