package com.google.p000vr.cardboard;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.google.vr.cardboard.TransitionView */
public class TransitionView extends FrameLayout implements View.OnTouchListener {
    public static final int ALREADY_LANDSCAPE_LEFT_TRANSITION_DELAY_MS = 2000;
    private static final int LANDSCAPE_TOLERANCE_DEGREES = 5;
    private static final int PORTRAIT_TOLERANCE_DEGREES = 45;
    public static final int TRANSITION_ANIMATION_DURATION_MS = 500;
    public static final int TRANSITION_BACKGROUND_COLOR = -12232092;
    private static final int VIEW_CORRECTION_ROTATION_DEGREES = 90;
    private ImageButton backButton;
    /* access modifiers changed from: private */
    public Runnable backButtonListener;
    /* access modifiers changed from: private */
    public int orientation = -1;
    private OrientationEventListener orientationEventListener;
    /* access modifiers changed from: private */
    public boolean rotationChecked;
    /* access modifiers changed from: private */
    public Runnable transitionListener;

    public TransitionView(Context context) {
        super(context);
        setOnTouchListener(this);
        setBackground(new ColorDrawable(TRANSITION_BACKGROUND_COLOR));
        inflateContentView(C0021R.layout.transition_view);
        super.setVisibility(8);
    }

    private void inflateContentView(int i) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(i, this, true);
        findViewById(C0021R.C0022id.transition_switch_action).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UiUtils.launchOrInstallCardboard(TransitionView.this.getContext());
            }
        });
        ((ImageView) findViewById(C0021R.C0022id.transition_icon)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TransitionView.this.fadeOutAndRemove(false);
            }
        });
        updateBackButtonVisibility();
        if (getResources().getConfiguration().orientation == 2) {
            findViewById(C0021R.C0022id.transition_bottom_frame).setVisibility(8);
        }
    }

    public void setViewerName(String str) {
        TextView textView = (TextView) findViewById(C0021R.C0022id.transition_text);
        if (str != null) {
            textView.setText(getContext().getString(C0021R.string.place_your_viewer_into_viewer_format, new Object[]{str}));
            return;
        }
        textView.setText(getContext().getString(C0021R.string.place_your_phone_into_cardboard));
    }

    public void setBackButtonListener(Runnable runnable) {
        this.backButtonListener = runnable;
        updateBackButtonVisibility();
    }

    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (visibility == i) {
            return;
        }
        if (i == 0) {
            startOrientationMonitor();
        } else {
            stopOrientationMonitor();
        }
    }

    public void setTransitionListener(Runnable runnable) {
        this.transitionListener = runnable;
    }

    private void startOrientationMonitor() {
        if (this.orientationEventListener == null) {
            this.orientationEventListener = new OrientationEventListener(getContext()) {
                public void onOrientationChanged(int i) {
                    int unused = TransitionView.this.orientation = i;
                    if (!TransitionView.this.rotationChecked) {
                        TransitionView.this.rotateViewIfNeeded();
                    } else if (TransitionView.isLandscapeLeft(i)) {
                        TransitionView.this.fadeOutAndRemove(false);
                    } else {
                        boolean unused2 = TransitionView.isLandscapeRight(i);
                    }
                }
            };
            this.orientationEventListener.enable();
        }
    }

    private void stopOrientationMonitor() {
        if (this.orientationEventListener != null) {
            this.orientation = -1;
            this.orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.orientationEventListener != null) {
            this.orientationEventListener.enable();
        }
        rotateViewIfNeeded();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.orientationEventListener != null) {
            this.orientation = -1;
            this.orientationEventListener.disable();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void rotateViewIfNeeded() {
        if (getWidth() > 0 && getHeight() > 0 && this.orientation != -1 && this.orientationEventListener != null && !this.rotationChecked) {
            boolean z = getWidth() < getHeight();
            boolean isPortrait = isPortrait(this.orientation);
            if (z != isPortrait) {
                View findViewById = findViewById(C0021R.C0022id.transition_frame);
                int width = findViewById.getWidth();
                int height = findViewById.getHeight();
                if (Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1) {
                    findViewById.setPivotX(((float) height) - findViewById.getPivotX());
                    findViewById.setPivotY(((float) width) - findViewById.getPivotY());
                }
                if (z) {
                    findViewById.setRotation(90.0f);
                } else {
                    findViewById.setRotation(-90.0f);
                }
                findViewById.setTranslationX((float) ((width - height) / 2));
                findViewById.setTranslationY((float) ((height - width) / 2));
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = width;
                layoutParams.width = height;
                findViewById.requestLayout();
            }
            if (!isPortrait) {
                findViewById(C0021R.C0022id.transition_bottom_frame).setVisibility(8);
            } else {
                findViewById(C0021R.C0022id.transition_bottom_frame).setVisibility(0);
            }
            this.rotationChecked = true;
            if (isLandscapeLeft(this.orientation)) {
                fadeOutAndRemove(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void fadeOutAndRemove(boolean z) {
        stopOrientationMonitor();
        Animation animation = getAnimation();
        if (animation != null) {
            if (!z && animation.getStartOffset() != 0) {
                animation.setAnimationListener((Animation.AnimationListener) null);
                clearAnimation();
            } else {
                return;
            }
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setDuration(500);
        if (z) {
            alphaAnimation.setStartOffset(2000);
        }
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                TransitionView.this.setVisibility(8);
                ((ViewGroup) TransitionView.this.getParent()).removeView(TransitionView.this);
                if (TransitionView.this.transitionListener != null) {
                    TransitionView.this.transitionListener.run();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    private void updateBackButtonVisibility() {
        this.backButton = (ImageButton) ((ViewGroup) findViewById(C0021R.C0022id.transition_frame)).findViewById(C0021R.C0022id.back_button);
        if (this.backButtonListener == null) {
            this.backButton.setVisibility(8);
            this.backButton.setTag((Object) null);
            this.backButton.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.backButton.setTag(this.backButtonListener);
        this.backButton.setVisibility(0);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TransitionView.this.backButtonListener.run();
            }
        });
    }

    private static boolean isPortrait(int i) {
        return Math.abs(i + -180) > 135;
    }

    /* access modifiers changed from: private */
    public static boolean isLandscapeLeft(int i) {
        return Math.abs(i + -270) < 5;
    }

    /* access modifiers changed from: private */
    public static boolean isLandscapeRight(int i) {
        return Math.abs(i + -90) < 5;
    }
}
