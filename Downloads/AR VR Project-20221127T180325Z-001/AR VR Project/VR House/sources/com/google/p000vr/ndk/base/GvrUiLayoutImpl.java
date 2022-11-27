package com.google.p000vr.ndk.base;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.p000vr.cardboard.ContextUtils;
import com.google.p000vr.cardboard.UiLayer;
import com.google.p000vr.vrcore.common.api.SdkServiceConsts;
import com.google.p000vr.vrcore.library.api.IGvrUiLayout;
import com.google.p000vr.vrcore.library.api.IObjectWrapper;
import com.google.p000vr.vrcore.library.api.ObjectWrapper;

/* renamed from: com.google.vr.ndk.base.GvrUiLayoutImpl */
class GvrUiLayoutImpl extends IGvrUiLayout.Stub {
    private static final float DAYDREAM_ALIGNMENT_MARKER_SCALE = 0.35f;
    private static final boolean DEBUG = false;
    static final long FADE_TRANSITION_VIEW_DELAY_MILLIS = 100;
    static final float MIN_FADE_ALPHA = 0.2f;
    private static final String TAG = "GvrUiLayoutImpl";
    private final Runnable beginDimmingUiLayerRunnable;
    private final CloseButtonListenerWrapper closeButtonListener;
    private boolean daydreamModeEnabled;
    private final Runnable delayDimmingUiLayerAfterVisibleRunnable;
    private final UiLayer uiLayer;
    private ObjectAnimator uiLayerDimmingAnimation;

    GvrUiLayoutImpl(Context context, Runnable runnable) {
        this(context, runnable, new DaydreamUtilsWrapper());
    }

    GvrUiLayoutImpl(Context context, Runnable runnable, DaydreamUtilsWrapper daydreamUtilsWrapper) {
        this.delayDimmingUiLayerAfterVisibleRunnable = new GvrUiLayoutImpl$$Lambda$0(this);
        this.beginDimmingUiLayerRunnable = new GvrUiLayoutImpl$$Lambda$1(this);
        this.daydreamModeEnabled = false;
        this.closeButtonListener = new CloseButtonListenerWrapper(context, runnable, daydreamUtilsWrapper);
        this.uiLayer = new UiLayer(context);
        this.uiLayer.setBackButtonListener(this.closeButtonListener);
    }

    /* renamed from: com.google.vr.ndk.base.GvrUiLayoutImpl$CloseButtonListenerWrapper */
    private static class CloseButtonListenerWrapper implements Runnable {
        private Runnable activeCloseButtonListener;
        private final Context context;
        private final Runnable defaultCloseButtonListener;
        private boolean invokingCloseButton = false;
        private final Runnable passiveCloseButtonListener;

        CloseButtonListenerWrapper(Context context2, Runnable runnable, DaydreamUtilsWrapper daydreamUtilsWrapper) {
            this.context = context2;
            this.passiveCloseButtonListener = runnable;
            this.defaultCloseButtonListener = GvrUiLayoutImpl.createDefaultCloseButtonListener(context2, daydreamUtilsWrapper);
            this.activeCloseButtonListener = this.defaultCloseButtonListener;
        }

        public void run() {
            if (this.invokingCloseButton) {
                Log.w(GvrUiLayoutImpl.TAG, "GVR close behavior invoked recursively.");
                Activity activity = ContextUtils.getActivity(this.context);
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            Log.d(GvrUiLayoutImpl.TAG, "GVR close behavior invoked.");
            this.invokingCloseButton = true;
            try {
                if (this.passiveCloseButtonListener != null) {
                    this.passiveCloseButtonListener.run();
                }
                if (this.activeCloseButtonListener != null) {
                    this.activeCloseButtonListener.run();
                }
            } finally {
                this.invokingCloseButton = false;
            }
        }

        public void setClientCloseButtonListener(Runnable runnable) {
            if (runnable == null) {
                runnable = this.defaultCloseButtonListener;
            }
            this.activeCloseButtonListener = runnable;
        }
    }

    public void setEnabled(boolean z) {
        this.uiLayer.setEnabled(z);
    }

    public IObjectWrapper getRootView() {
        return ObjectWrapper.wrap(this.uiLayer.getView());
    }

    public boolean isEnabled() {
        return this.uiLayer.isEnabled();
    }

    public void setCloseButtonListener(IObjectWrapper iObjectWrapper) {
        this.closeButtonListener.setClientCloseButtonListener(iObjectWrapper != null ? (Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class) : null);
    }

    public void setTransitionViewEnabled(boolean z) {
        this.uiLayer.setTransitionViewEnabled(z && !this.daydreamModeEnabled);
    }

    public void setTransitionViewListener(IObjectWrapper iObjectWrapper) {
        this.uiLayer.setTransitionViewListener(iObjectWrapper != null ? (Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class) : null);
    }

    public void setSettingsButtonEnabled(boolean z) {
        this.uiLayer.setSettingsButtonEnabled(z);
    }

    public void setSettingsButtonListener(IObjectWrapper iObjectWrapper) {
        this.uiLayer.setSettingsButtonListener(iObjectWrapper != null ? (Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class) : null);
    }

    public void setViewerName(String str) {
        this.uiLayer.setViewerName(str);
    }

    /* access modifiers changed from: package-private */
    public UiLayer getUiLayer() {
        return this.uiLayer;
    }

    /* access modifiers changed from: package-private */
    public ViewGroup getRoot() {
        return this.uiLayer.getView();
    }

    /* access modifiers changed from: package-private */
    public void invokeCloseButtonListener() {
        this.closeButtonListener.run();
    }

    /* access modifiers changed from: package-private */
    public void setDaydreamModeEnabled(boolean z) {
        if (this.daydreamModeEnabled != z) {
            this.daydreamModeEnabled = z;
            if (z) {
                this.uiLayer.setAlignmentMarkerScale(DAYDREAM_ALIGNMENT_MARKER_SCALE);
                this.uiLayer.setTransitionViewEnabled(false);
                return;
            }
            this.uiLayer.setAlignmentMarkerScale(1.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isDaydreamModeEnabled() {
        return this.daydreamModeEnabled;
    }

    private void delayDimmingUiLayer(long j) {
        cancelDimmingUiLayer();
        getRoot().postDelayed(this.beginDimmingUiLayerRunnable, j);
    }

    /* access modifiers changed from: package-private */
    public void delayDimmingUiLayerAfterVisible() {
        delayDimmingUiLayer(SdkServiceConsts.DIM_UI_FADE_AFTER_VISIBLE_DELAY_MILLIS);
    }

    /* access modifiers changed from: private */
    /* renamed from: beginDimmingUiLayer */
    public void bridge$lambda$0$GvrUiLayoutImpl() {
        cancelDimmingUiLayer();
        if (this.uiLayer.isTransitionViewVisible()) {
            getRoot().postDelayed(this.delayDimmingUiLayerAfterVisibleRunnable, FADE_TRANSITION_VIEW_DELAY_MILLIS);
            return;
        }
        this.uiLayerDimmingAnimation = ObjectAnimator.ofFloat(this.uiLayer.getView(), View.ALPHA, new float[]{1.0f, MIN_FADE_ALPHA});
        this.uiLayerDimmingAnimation.setDuration(500);
        this.uiLayerDimmingAnimation.start();
        setDimmedUiTouchOverride();
    }

    private void setDimmedUiTouchOverride() {
        this.uiLayer.setButtonClickCallbackOverride(new GvrUiLayoutImpl$$Lambda$2(this));
    }

    /* access modifiers changed from: package-private */
    public void cancelDimmingUiLayer() {
        getRoot().removeCallbacks(this.beginDimmingUiLayerRunnable);
        if (this.uiLayerDimmingAnimation != null) {
            this.uiLayerDimmingAnimation.cancel();
            this.uiLayerDimmingAnimation = null;
        }
        this.uiLayer.getView().setAlpha(1.0f);
        this.uiLayer.setButtonClickCallbackOverride((Runnable) null);
    }

    /* access modifiers changed from: private */
    public static Runnable createDefaultCloseButtonListener(final Context context, DaydreamUtilsWrapper daydreamUtilsWrapper) {
        final Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        final Activity activity = ContextUtils.getActivity(context);
        if (activity == null) {
            return new Runnable() {
                public void run() {
                    context.startActivity(intent);
                }
            };
        }
        if (daydreamUtilsWrapper.isDaydreamActivity(activity)) {
            return new Runnable() {
                public void run() {
                    activity.startActivity(intent);
                    activity.finish();
                }
            };
        }
        return new Runnable() {
            public void run() {
                activity.onBackPressed();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$setDimmedUiTouchOverride$0$GvrUiLayoutImpl() {
        delayDimmingUiLayer(SdkServiceConsts.DIM_UI_FADE_AFTER_TOUCH_DELAY_MILLIS);
    }
}
