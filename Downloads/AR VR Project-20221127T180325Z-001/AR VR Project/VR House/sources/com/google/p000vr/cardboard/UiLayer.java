package com.google.p000vr.cardboard;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/* renamed from: com.google.vr.cardboard.UiLayer */
public class UiLayer {
    private static final String TAG = "UiLayer";
    /* access modifiers changed from: private */
    public RelativeLayout alignmentMarker;
    private volatile float alignmentMarkerScale = 1.0f;
    /* access modifiers changed from: private */
    public ImageButton backButton;
    /* access modifiers changed from: private */
    public View backButtonHolder;
    /* access modifiers changed from: private */
    public volatile Runnable backButtonListener = null;
    /* access modifiers changed from: private */
    public volatile Runnable buttonClickCallbackOverride = null;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public int currentLayoutId;
    private volatile boolean isAlignmentMarkerEnabled = true;
    private volatile boolean isEnabled = true;
    private volatile boolean isSettingsButtonEnabled = true;
    private RelativeLayout rootInnerLayout;
    /* access modifiers changed from: private */
    public final FrameLayout rootOuterLayout;
    /* access modifiers changed from: private */
    public ImageButton settingsButton;
    /* access modifiers changed from: private */
    public View settingsButtonHolder;
    /* access modifiers changed from: private */
    public volatile Runnable settingsButtonListener;
    private volatile Runnable transitionListener = null;
    /* access modifiers changed from: private */
    public TransitionView transitionView;
    private volatile boolean transitionViewEnabled = false;
    private volatile String viewerName;

    public UiLayer(Context context2) {
        this.context = context2;
        this.rootOuterLayout = new RootOuterLayout(context2);
        inflateViewsWithLayoutId(C0021R.layout.ui_layer);
    }

    /* renamed from: com.google.vr.cardboard.UiLayer$RootOuterLayout */
    private class RootOuterLayout extends FrameLayout {
        private Configuration currentConfig;

        RootOuterLayout(Context context) {
            super(context);
            this.currentConfig = new Configuration(context.getResources().getConfiguration());
        }

        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            handlePotentialConfigurationChange(UiLayer.this.context.getResources().getConfiguration());
        }

        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            handlePotentialConfigurationChange(configuration);
        }

        private void handlePotentialConfigurationChange(Configuration configuration) {
            int diff = configuration.diff(this.currentConfig);
            if ((diff & 4096) != 0 || (diff & 128) != 0) {
                Log.d(UiLayer.TAG, "Re-inflating UiLayer due to configuration change.");
                this.currentConfig = new Configuration(configuration);
                UiLayer.this.inflateViewsWithLayoutId(UiLayer.this.currentLayoutId);
            }
        }
    }

    public void setPortraitSupportEnabled(boolean z) {
        inflateViewsWithLayoutId(z ? C0021R.layout.ui_layer_with_portrait_support : C0021R.layout.ui_layer);
    }

    /* access modifiers changed from: private */
    public void inflateViewsWithLayoutId(int i) {
        this.currentLayoutId = i;
        boolean z = (this.transitionView == null || this.transitionView.getParent() == null) ? false : true;
        this.transitionView = null;
        if (this.rootInnerLayout != null) {
            this.rootOuterLayout.removeView(this.rootInnerLayout);
        }
        this.rootInnerLayout = (RelativeLayout) LayoutInflater.from(this.context).inflate(i, (ViewGroup) null, false);
        this.rootOuterLayout.addView(this.rootInnerLayout);
        if (z) {
            setTransitionViewEnabled(this.transitionViewEnabled);
        }
        this.settingsButtonListener = new Runnable() {
            public void run() {
                UiUtils.launchOrInstallCardboard(UiLayer.this.context);
            }
        };
        this.settingsButtonHolder = this.rootInnerLayout.findViewById(C0021R.C0022id.ui_settings_button_holder);
        if (this.settingsButtonHolder != null) {
            this.settingsButtonHolder.setVisibility(computeVisibility(this.isSettingsButtonEnabled));
            this.settingsButtonHolder.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Runnable access$100 = UiLayer.this.buttonClickCallbackOverride;
                    if (access$100 != null) {
                        access$100.run();
                    }
                }
            });
        }
        this.settingsButton = (ImageButton) this.rootInnerLayout.findViewById(C0021R.C0022id.ui_settings_button);
        this.settingsButton.setVisibility(computeVisibility(this.isSettingsButtonEnabled));
        this.settingsButton.setContentDescription("Settings");
        this.settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Runnable access$200 = UiLayer.this.settingsButtonListener;
                Runnable access$100 = UiLayer.this.buttonClickCallbackOverride;
                if (access$100 != null) {
                    access$100.run();
                } else if (access$200 != null) {
                    access$200.run();
                }
            }
        });
        this.backButtonHolder = this.rootInnerLayout.findViewById(C0021R.C0022id.ui_back_button_holder);
        if (this.backButtonHolder != null) {
            this.backButtonHolder.setVisibility(computeVisibility(getBackButtonEnabled()));
            this.backButtonHolder.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Runnable access$100 = UiLayer.this.buttonClickCallbackOverride;
                    if (access$100 != null) {
                        access$100.run();
                    }
                }
            });
        }
        this.backButton = (ImageButton) this.rootInnerLayout.findViewById(C0021R.C0022id.ui_back_button);
        this.backButton.setVisibility(computeVisibility(getBackButtonEnabled()));
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Runnable access$300 = UiLayer.this.backButtonListener;
                Runnable access$100 = UiLayer.this.buttonClickCallbackOverride;
                if (access$100 != null) {
                    access$100.run();
                } else if (access$300 != null) {
                    access$300.run();
                }
            }
        });
        if (ActivityManager.isRunningInTestHarness()) {
            if (this.settingsButtonHolder != null) {
                ViewGroup.LayoutParams layoutParams = this.settingsButtonHolder.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.settingsButtonHolder.setLayoutParams(layoutParams);
            }
            if (this.backButtonHolder != null) {
                ViewGroup.LayoutParams layoutParams2 = this.backButtonHolder.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.backButtonHolder.setLayoutParams(layoutParams2);
            }
        }
        this.alignmentMarker = (RelativeLayout) this.rootInnerLayout.findViewById(C0021R.C0022id.ui_alignment_marker);
        this.alignmentMarker.setVisibility(computeVisibility(getAlignmentMarkerEnabled()));
        setAlignmentMarkerScale(this.alignmentMarkerScale);
    }

    /* access modifiers changed from: private */
    public TransitionView getTransitionView() {
        if (this.transitionView == null) {
            this.transitionView = new TransitionView(this.context);
            this.transitionView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.transitionView.setVisibility(computeVisibility(this.transitionViewEnabled));
            if (this.viewerName != null) {
                this.transitionView.setViewerName(this.viewerName);
            }
            if (this.transitionListener != null) {
                this.transitionView.setTransitionListener(this.transitionListener);
            }
            this.transitionView.setBackButtonListener(this.backButtonListener);
            this.rootInnerLayout.addView(this.transitionView);
        }
        return this.transitionView;
    }

    /* access modifiers changed from: private */
    public static int computeVisibility(boolean z) {
        return z ? 0 : 8;
    }

    public ViewGroup getView() {
        return this.rootOuterLayout;
    }

    public void setEnabled(final boolean z) {
        this.isEnabled = z;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.rootOuterLayout.setVisibility(UiLayer.computeVisibility(z));
            }
        });
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setSettingsButtonEnabled(final boolean z) {
        this.isSettingsButtonEnabled = z;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.settingsButton.setVisibility(UiLayer.computeVisibility(z));
                if (UiLayer.this.settingsButtonHolder != null) {
                    UiLayer.this.settingsButtonHolder.setVisibility(UiLayer.computeVisibility(z));
                }
            }
        });
    }

    public void setButtonClickCallbackOverride(Runnable runnable) {
        this.buttonClickCallbackOverride = runnable;
    }

    public void setSettingsButtonListener(Runnable runnable) {
        this.settingsButtonListener = runnable;
    }

    public void setBackButtonListener(final Runnable runnable) {
        this.backButtonListener = runnable;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                boolean z = runnable != null;
                UiLayer.this.backButton.setVisibility(UiLayer.computeVisibility(z));
                if (UiLayer.this.backButtonHolder != null) {
                    UiLayer.this.backButtonHolder.setVisibility(UiLayer.computeVisibility(z));
                }
                if (UiLayer.this.transitionView != null) {
                    UiLayer.this.transitionView.setBackButtonListener(runnable);
                }
            }
        });
    }

    public void setAlignmentMarkerEnabled(final boolean z) {
        this.isAlignmentMarkerEnabled = z;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.alignmentMarker.setVisibility(UiLayer.computeVisibility(z));
            }
        });
    }

    @TargetApi(23)
    public static void scaleAlignmentMarkerLayoutParams(Context context2, float f, RelativeLayout.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 23) {
            int dimension = (int) (((float) ((int) context2.getResources().getDimension(C0021R.dimen.alignment_marker_height))) * f);
            if (layoutParams.getRule(15) == -1) {
                layoutParams.width = dimension;
            } else {
                layoutParams.height = dimension;
            }
        }
    }

    @TargetApi(23)
    public void setAlignmentMarkerScale(final float f) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.alignmentMarkerScale != f || f != 1.0f) {
                this.alignmentMarkerScale = f;
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) UiLayer.this.alignmentMarker.getLayoutParams();
                        UiLayer.scaleAlignmentMarkerLayoutParams(UiLayer.this.context, f, layoutParams);
                        UiLayer.this.alignmentMarker.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    public void setTransitionViewEnabled(final boolean z) {
        this.transitionViewEnabled = z;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (z || UiLayer.this.transitionView != null) {
                    UiLayer.this.getTransitionView().setVisibility(UiLayer.computeVisibility(z));
                }
            }
        });
    }

    public boolean getTransitionViewEnabled() {
        return this.transitionViewEnabled;
    }

    public boolean isTransitionViewVisible() {
        return this.transitionView != null && this.transitionView.getVisibility() == 0;
    }

    public void setTransitionViewListener(final Runnable runnable) {
        this.transitionListener = runnable;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (runnable != null || UiLayer.this.transitionView != null) {
                    UiLayer.this.getTransitionView().setTransitionListener(runnable);
                }
            }
        });
    }

    public void setViewerName(final String str) {
        this.viewerName = str;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (UiLayer.this.transitionView != null) {
                    UiLayer.this.transitionView.setViewerName(str);
                }
            }
        });
    }

    public String getViewerName() {
        return this.viewerName;
    }

    public boolean getSettingsButtonEnabled() {
        return this.isSettingsButtonEnabled;
    }

    public boolean getBackButtonEnabled() {
        return this.backButtonListener != null;
    }

    public Runnable getBackButtonListener() {
        return this.backButtonListener;
    }

    public boolean getAlignmentMarkerEnabled() {
        return this.isAlignmentMarkerEnabled;
    }
}
