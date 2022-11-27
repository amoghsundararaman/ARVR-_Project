package com.google.p000vr.cardboard;

import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;

/* renamed from: com.google.vr.cardboard.FullscreenMode */
public class FullscreenMode {
    private static final int NAVIGATION_BAR_TIMEOUT_MS = 2000;
    private final Window window;

    public FullscreenMode(Window window2) {
        this.window = window2;
    }

    public void goFullscreen() {
        setFullscreenModeFlags();
        setImmersiveStickyModeCompat();
    }

    private void setImmersiveStickyModeCompat() {
        if (Build.VERSION.SDK_INT < 19) {
            final Handler handler = new Handler();
            this.window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                public void onSystemUiVisibilityChange(int i) {
                    if ((i & 2) == 0) {
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                FullscreenMode.this.setFullscreenModeFlags();
                            }
                        }, 2000);
                    }
                }
            });
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            setFullscreenModeFlags();
        }
    }

    /* access modifiers changed from: private */
    public void setFullscreenModeFlags() {
        this.window.getDecorView().setSystemUiVisibility(5894);
    }
}
