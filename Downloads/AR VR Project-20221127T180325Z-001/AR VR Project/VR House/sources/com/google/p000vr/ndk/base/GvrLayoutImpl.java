package com.google.p000vr.ndk.base;

import android.app.PendingIntent;
import android.app.Presentation;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.cardboard.ContextUtils;
import com.google.p000vr.cardboard.DisplaySynchronizer;
import com.google.p000vr.cardboard.DisplayUtils;
import com.google.p000vr.cardboard.EglFactory;
import com.google.p000vr.cardboard.EglReadyListener;
import com.google.p000vr.cardboard.MutableEglConfigChooser;
import com.google.p000vr.cardboard.ScanlineRacingRenderer;
import com.google.p000vr.cardboard.ThreadUtils;
import com.google.p000vr.cardboard.VrContextWrapper;
import com.google.p000vr.ndk.base.GvrApi;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.vr.ndk.base.GvrLayoutImpl */
class GvrLayoutImpl extends FrameLayout {
    private static final int ASYNC_REPROJECTION_FLAGS_UNKNOWN = -1;
    private static final boolean DEBUG = false;
    private static final int EXTERNAL_PRESENTATION_MIN_API = 16;
    private static final int SHOW_RENDERING_VIEWS_DELAY_FOR_FADE = 50;
    private static final String TAG = "GvrLayoutImpl";
    /* access modifiers changed from: private */
    public static PresentationFactory sOptionalPresentationFactory = null;
    private int asyncReprojectionFlags;
    private boolean attachedToWindow;
    private boolean autoFadeEnabled;
    private CardboardEmulator cardboardEmulator;
    private SdkDaydreamTouchListener daydreamTouchListener;
    private DaydreamUtilsWrapper daydreamUtils;
    private DisplaySynchronizer displaySynchronizer;
    private EglFactory eglFactory;
    private EglReadyListener eglReadyListener;
    private ExtensionManager extensionManager;
    private FadeOverlayView fadeOverlayView;
    private FrameFlushWorkaround frameFlushWorkaround;
    private GvrApi gvrApi;
    private boolean isResumed;
    private PresentationHelper presentationHelper;
    private FrameLayout presentationLayout;
    private View presentationView;
    /* access modifiers changed from: private */
    public ScanlineRacingRenderer scanlineRacingRenderer;
    private AsyncReprojectionSurfaceView scanlineRacingView;
    private ScreenOnManager screenOnManager;
    private final Runnable showRenderingViewsRunnable;
    private boolean stereoModeEnabled;
    /* access modifiers changed from: private */
    public GvrUiLayoutImpl uiLayout;
    private ExternalSurface videoSurface;
    /* access modifiers changed from: private */
    public VrCoreSdkClient vrCoreSdkClient;

    /* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$PresentationFactory */
    interface PresentationFactory {
        Presentation create(Context context, Display display);
    }

    /* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener */
    interface PresentationListener {
        void onPresentationStarted(Display display);

        void onPresentationStopped();
    }

    public GvrLayoutImpl(Context context) {
        this(context, (ExtensionManager) null);
    }

    /* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$AsyncReprojectionSurfaceView */
    private static class AsyncReprojectionSurfaceView extends GvrSurfaceView {
        /* access modifiers changed from: private */
        public ScanlineRacingRenderer scanlineRacingRenderer;

        AsyncReprojectionSurfaceView(Context context) {
            super(context);
        }

        public void setRenderer(ScanlineRacingRenderer scanlineRacingRenderer2) {
            this.scanlineRacingRenderer = scanlineRacingRenderer2;
            super.setRenderer(scanlineRacingRenderer2);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (isDetachedFromWindow() || this.scanlineRacingRenderer == null) {
                onSurfaceDestroyed((Runnable) null);
            } else {
                onSurfaceDestroyed(new Runnable() {
                    public void run() {
                        AsyncReprojectionSurfaceView.this.scanlineRacingRenderer.onSurfaceDestroyed();
                    }
                });
            }
        }
    }

    /* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$FrameFlushWorkaround */
    private static class FrameFlushWorkaround implements Choreographer.FrameCallback {
        private static final int DEFAULT_FRAME_FLUSH_COUNT = 5;
        private final Choreographer choreographer = Choreographer.getInstance();
        private int framesRemaining;

        public void onResume() {
            if (this.framesRemaining > 0) {
                this.choreographer.removeFrameCallback(this);
            }
            this.framesRemaining = 5;
            this.choreographer.postFrameCallback(this);
        }

        public void doFrame(long j) {
            int i = this.framesRemaining - 1;
            this.framesRemaining = i;
            if (i > 0) {
                this.choreographer.postFrameCallback(this);
            }
        }
    }

    public GvrLayoutImpl(Context context, ExtensionManager extensionManager2) {
        super(context);
        this.asyncReprojectionFlags = -1;
        this.autoFadeEnabled = true;
        this.isResumed = false;
        this.stereoModeEnabled = true;
        this.showRenderingViewsRunnable = new Runnable() {
            public void run() {
                GvrLayoutImpl.this.updateRenderingViewsVisibility(0);
            }
        };
        if ((context instanceof VrContextWrapper) || ContextUtils.getActivity(context) != null) {
            init(extensionManager2);
            return;
        }
        throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
    }

    /* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$ScreenOnManager */
    static class ScreenOnManager implements GvrApi.IdleListener {
        /* access modifiers changed from: private */
        public static final long QUIET_PERIOD_AFTER_RESUME_MILLIS = TimeUnit.SECONDS.toMillis(5);
        /* access modifiers changed from: private */
        public boolean isEnabled = true;
        /* access modifiers changed from: private */
        public boolean isIdle;
        private boolean isResumed;
        /* access modifiers changed from: private */
        public long lastResumeTimeMillis;
        private final View parentView;

        public ScreenOnManager(View view) {
            this.parentView = view;
        }

        public void onResume() {
            this.isResumed = true;
            this.isIdle = false;
            this.lastResumeTimeMillis = SystemClock.elapsedRealtime();
            updateSetScreenOn();
        }

        public void onPause() {
            this.isResumed = false;
            updateSetScreenOn();
        }

        public void setEnabled(final boolean z) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (ScreenOnManager.this.isEnabled != z) {
                        boolean unused = ScreenOnManager.this.isEnabled = z;
                        ScreenOnManager.this.updateSetScreenOn();
                    }
                }
            });
        }

        public void onIdleChanged(final boolean z) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    TraceCompat.beginSection("GvrLayoutImpl.onIdleChanged");
                    try {
                        if (SystemClock.elapsedRealtime() - ScreenOnManager.this.lastResumeTimeMillis < ScreenOnManager.QUIET_PERIOD_AFTER_RESUME_MILLIS) {
                            Log.d(GvrLayoutImpl.TAG, new StringBuilder(80).append("Quiet period after onResume() -- ignoring idle status change with isIdle = ").append(z).toString());
                            return;
                        }
                        if (ScreenOnManager.this.isIdle != z) {
                            Log.d(GvrLayoutImpl.TAG, new StringBuilder(36).append("Idle status change to isIdle = ").append(z).toString());
                        }
                        boolean unused = ScreenOnManager.this.isIdle = z;
                        ScreenOnManager.this.updateSetScreenOn();
                        TraceCompat.endSection();
                    } finally {
                        TraceCompat.endSection();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void updateSetScreenOn() {
            this.parentView.setKeepScreenOn(this.isEnabled && this.isResumed && !this.isIdle);
        }
    }

    /* renamed from: com.google.vr.ndk.base.GvrLayoutImpl$PresentationHelper */
    private static class PresentationHelper implements DisplayManager.DisplayListener {
        private final Context context;
        private final DisplayManager displayManager;
        private final DisplaySynchronizer displaySynchronizer;
        private String externalDisplayName;
        private final RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(-1, -1);
        private final List<PresentationListener> listeners;
        private final FrameLayout originalParent;
        private Presentation presentation;
        private final View view;

        PresentationHelper(Context context2, FrameLayout frameLayout, View view2, DisplaySynchronizer displaySynchronizer2, String str) {
            this.context = context2;
            this.originalParent = frameLayout;
            this.view = view2;
            this.displaySynchronizer = displaySynchronizer2;
            this.externalDisplayName = str;
            this.displayManager = (DisplayManager) context2.getSystemService("display");
            this.listeners = new ArrayList();
        }

        public boolean isPresenting() {
            return this.presentation != null && this.presentation.isShowing();
        }

        public void onPause() {
            this.displayManager.unregisterDisplayListener(this);
        }

        public void onResume() {
            Display display;
            this.externalDisplayName = DisplayUtils.getExternalDisplayName(this.context);
            if (this.externalDisplayName == null) {
                setDisplay((Display) null);
                return;
            }
            this.displayManager.registerDisplayListener(this, (Handler) null);
            Display[] displays = this.displayManager.getDisplays();
            int length = displays.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    display = null;
                    break;
                }
                display = displays[i];
                if (isValidExternalDisplay(display)) {
                    break;
                }
                i++;
            }
            setDisplay(display);
        }

        public void shutdown() {
            this.displayManager.unregisterDisplayListener(this);
            if (this.presentation != null) {
                this.presentation.cancel();
                this.presentation = null;
                for (PresentationListener onPresentationStopped : this.listeners) {
                    onPresentationStopped.onPresentationStopped();
                }
            }
        }

        public void onDetachedFromWindow() {
            this.displayManager.unregisterDisplayListener(this);
            setDisplay((Display) null);
        }

        public void addListener(PresentationListener presentationListener) {
            if (!this.listeners.contains(presentationListener)) {
                this.listeners.add(presentationListener);
                if (this.presentation != null) {
                    presentationListener.onPresentationStarted(this.presentation.getDisplay());
                }
            }
        }

        public void onDisplayAdded(int i) {
            Display display = this.displayManager.getDisplay(i);
            if (isValidExternalDisplay(display)) {
                setDisplay(display);
            }
        }

        public void onDisplayRemoved(int i) {
            if (this.presentation != null && this.presentation.getDisplay().getDisplayId() == i) {
                setDisplay((Display) null);
            }
        }

        public void onDisplayChanged(int i) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void setDisplay(android.view.Display r7) {
            /*
                r6 = this;
                r1 = 0
                android.app.Presentation r0 = r6.presentation
                if (r0 == 0) goto L_0x0018
                android.app.Presentation r0 = r6.presentation
                android.view.Display r0 = r0.getDisplay()
            L_0x000b:
                boolean r2 = r6.hasCurrentPresentationExpired()
                if (r2 != 0) goto L_0x001a
                boolean r0 = com.google.p000vr.cardboard.DisplayUtils.isSameDisplay(r7, r0)
                if (r0 == 0) goto L_0x001a
            L_0x0017:
                return
            L_0x0018:
                r0 = r1
                goto L_0x000b
            L_0x001a:
                android.app.Presentation r2 = r6.presentation
                android.app.Presentation r0 = r6.presentation
                if (r0 == 0) goto L_0x0027
                android.app.Presentation r0 = r6.presentation
                r0.dismiss()
                r6.presentation = r1
            L_0x0027:
                android.view.View r0 = r6.view
                detachViewFromParent(r0)
                if (r7 == 0) goto L_0x00b0
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationFactory r0 = com.google.p000vr.ndk.base.GvrLayoutImpl.sOptionalPresentationFactory
                if (r0 == 0) goto L_0x0075
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationFactory r0 = com.google.p000vr.ndk.base.GvrLayoutImpl.sOptionalPresentationFactory
                android.content.Context r3 = r6.context
                android.app.Presentation r0 = r0.create(r3, r7)
            L_0x003e:
                r6.presentation = r0
                android.app.Presentation r0 = r6.presentation
                android.view.View r3 = r6.view
                android.widget.RelativeLayout$LayoutParams r4 = r6.layout
                r0.addContentView(r3, r4)
                android.app.Presentation r0 = r6.presentation     // Catch:{ InvalidDisplayException -> 0x007d }
                r0.show()     // Catch:{ InvalidDisplayException -> 0x007d }
            L_0x004e:
                com.google.vr.cardboard.DisplaySynchronizer r1 = r6.displaySynchronizer
                android.app.Presentation r0 = r6.presentation
                if (r0 == 0) goto L_0x00b9
                android.app.Presentation r0 = r6.presentation
                android.view.Display r0 = r0.getDisplay()
            L_0x005a:
                r1.setDisplay(r0)
                if (r2 == 0) goto L_0x00c0
                java.util.List<com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener> r0 = r6.listeners
                java.util.Iterator r1 = r0.iterator()
            L_0x0065:
                boolean r0 = r1.hasNext()
                if (r0 == 0) goto L_0x00c0
                java.lang.Object r0 = r1.next()
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener r0 = (com.google.p000vr.ndk.base.GvrLayoutImpl.PresentationListener) r0
                r0.onPresentationStopped()
                goto L_0x0065
            L_0x0075:
                android.app.Presentation r0 = new android.app.Presentation
                android.content.Context r3 = r6.context
                r0.<init>(r3, r7)
                goto L_0x003e
            L_0x007d:
                r0 = move-exception
                java.lang.String r3 = "GvrLayoutImpl"
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r4 = java.lang.String.valueOf(r0)
                int r4 = r4.length()
                int r4 = r4 + 57
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>(r4)
                java.lang.String r4 = "Attaching Cardboard View to the external display failed: "
                java.lang.StringBuilder r4 = r5.append(r4)
                java.lang.StringBuilder r0 = r4.append(r0)
                java.lang.String r0 = r0.toString()
                android.util.Log.e(r3, r0)
                android.app.Presentation r0 = r6.presentation
                r0.cancel()
                r6.presentation = r1
                android.view.View r0 = r6.view
                detachViewFromParent(r0)
            L_0x00b0:
                android.widget.FrameLayout r0 = r6.originalParent
                android.view.View r1 = r6.view
                r3 = 0
                r0.addView(r1, r3)
                goto L_0x004e
            L_0x00b9:
                android.content.Context r0 = r6.context
                android.view.Display r0 = com.google.p000vr.cardboard.DisplayUtils.getDefaultDisplay(r0)
                goto L_0x005a
            L_0x00c0:
                android.app.Presentation r0 = r6.presentation
                if (r0 == 0) goto L_0x0017
                java.util.List<com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener> r0 = r6.listeners
                java.util.Iterator r1 = r0.iterator()
            L_0x00ca:
                boolean r0 = r1.hasNext()
                if (r0 == 0) goto L_0x0017
                java.lang.Object r0 = r1.next()
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener r0 = (com.google.p000vr.ndk.base.GvrLayoutImpl.PresentationListener) r0
                android.app.Presentation r2 = r6.presentation
                android.view.Display r2 = r2.getDisplay()
                r0.onPresentationStarted(r2)
                goto L_0x00ca
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.GvrLayoutImpl.PresentationHelper.setDisplay(android.view.Display):void");
        }

        private static void detachViewFromParent(View view2) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
        }

        private boolean isValidExternalDisplay(Display display) {
            return display != null && display.isValid() && display.getName().equals(this.externalDisplayName);
        }

        private boolean hasCurrentPresentationExpired() {
            if (this.presentation == null) {
                return false;
            }
            if (!this.presentation.isShowing() || !this.presentation.getDisplay().isValid()) {
                return true;
            }
            return false;
        }
    }

    GvrLayoutImpl(Context context, GvrApi gvrApi2, DisplaySynchronizer displaySynchronizer2, EglReadyListener eglReadyListener2, FadeOverlayView fadeOverlayView2, DaydreamUtilsWrapper daydreamUtilsWrapper, ExtensionManager extensionManager2, GvrUiLayoutImpl gvrUiLayoutImpl) {
        super(context);
        this.asyncReprojectionFlags = -1;
        this.autoFadeEnabled = true;
        this.isResumed = false;
        this.stereoModeEnabled = true;
        this.showRenderingViewsRunnable = new Runnable() {
            public void run() {
                GvrLayoutImpl.this.updateRenderingViewsVisibility(0);
            }
        };
        initWithInjectedObjects(gvrApi2, displaySynchronizer2, eglReadyListener2, fadeOverlayView2, daydreamUtilsWrapper, extensionManager2, gvrUiLayoutImpl);
    }

    private void init(ExtensionManager extensionManager2) {
        DisplaySynchronizer createDefaultDisplaySynchronizer = GvrApi.createDefaultDisplaySynchronizer(getContext());
        C00682 r0 = new Runnable() {
            public void run() {
                if (GvrLayoutImpl.this.vrCoreSdkClient != null) {
                    GvrLayoutImpl.this.vrCoreSdkClient.onExitingFromVr();
                }
            }
        };
        initWithInjectedObjects(new GvrApi(getContext(), createDefaultDisplaySynchronizer), createDefaultDisplaySynchronizer, new EglReadyListener(), (FadeOverlayView) null, new DaydreamUtilsWrapper(), extensionManager2, new GvrUiLayoutImpl(getContext(), r0));
    }

    private void initWithInjectedObjects(GvrApi gvrApi2, DisplaySynchronizer displaySynchronizer2, EglReadyListener eglReadyListener2, FadeOverlayView fadeOverlayView2, DaydreamUtilsWrapper daydreamUtilsWrapper, ExtensionManager extensionManager2, GvrUiLayoutImpl gvrUiLayoutImpl) {
        boolean z = false;
        this.gvrApi = gvrApi2;
        if (isContextSharingEnabled()) {
            gvrApi2.requestContextSharing(eglReadyListener2);
        }
        this.daydreamUtils = daydreamUtilsWrapper;
        this.presentationLayout = new FrameLayout(getContext());
        this.uiLayout = gvrUiLayoutImpl;
        this.displaySynchronizer = displaySynchronizer2;
        this.eglReadyListener = eglReadyListener2;
        this.presentationHelper = tryCreatePresentationHelper();
        this.frameFlushWorkaround = new FrameFlushWorkaround();
        addView(this.presentationLayout, 0);
        addView(gvrUiLayoutImpl.getRoot(), 1);
        updateUiLayout();
        boolean isDaydreamPhone = daydreamUtilsWrapper.isDaydreamPhone(getContext());
        if (isDaydreamPhone) {
            this.daydreamTouchListener = createDaydreamTouchListener();
            gvrUiLayoutImpl.getRoot().setOnTouchListener(this.daydreamTouchListener);
        }
        DaydreamCompatibility componentDaydreamCompatibility = daydreamUtilsWrapper.getComponentDaydreamCompatibility(getContext());
        boolean supportsDaydream = componentDaydreamCompatibility.supportsDaydream();
        boolean requiresDaydream = componentDaydreamCompatibility.requiresDaydream();
        if (isDaydreamPhone || requiresDaydream) {
            z = true;
        }
        if (z) {
            if (supportsDaydream) {
                if (getContext() instanceof VrContextWrapper) {
                    this.autoFadeEnabled = ((VrContextWrapper) getContext()).autoFadeEnabled();
                }
                if (fadeOverlayView2 == null) {
                    fadeOverlayView2 = new FadeOverlayView(getContext(), this.autoFadeEnabled);
                }
                this.fadeOverlayView = fadeOverlayView2;
                addView(this.fadeOverlayView, 2);
            }
            this.vrCoreSdkClient = createVrCoreSdkClient(getContext(), gvrApi2, daydreamUtilsWrapper, this.fadeOverlayView);
        }
        this.screenOnManager = new ScreenOnManager(this);
        if (isDeviceDetectionEnabled()) {
            gvrApi2.setIdleListener(this.screenOnManager);
        }
        if (extensionManager2 != null) {
            extensionManager2.initialize(this, gvrApi2);
            if (gvrApi2.usingVrDisplayService()) {
                gvrUiLayoutImpl.getRoot().setVisibility(8);
            }
        }
        this.extensionManager = extensionManager2;
    }

    public GvrUiLayoutImpl getUiLayoutImpl() {
        return this.uiLayout;
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        updateFadeVisibility();
        if (!isDimUiEnabled()) {
            return;
        }
        if (i == 0) {
            this.uiLayout.delayDimmingUiLayerAfterVisible();
        } else {
            this.uiLayout.cancelDimmingUiLayer();
        }
    }

    public void onPause() {
        if (!(this.extensionManager == null || this.vrCoreSdkClient == null || this.vrCoreSdkClient.getLoggingService() == null)) {
            this.extensionManager.reportTelemetry(this.vrCoreSdkClient.getLoggingService());
        }
        this.gvrApi.pause();
        if (this.scanlineRacingView != null) {
            this.scanlineRacingView.onPause(new Runnable() {
                public void run() {
                    GvrLayoutImpl.this.scanlineRacingRenderer.onPause();
                }
            });
        }
        if (this.presentationHelper != null) {
            this.presentationHelper.onPause();
        }
        this.displaySynchronizer.onPause();
        if (this.vrCoreSdkClient != null) {
            this.vrCoreSdkClient.onPause();
        }
        if (this.cardboardEmulator != null) {
            this.cardboardEmulator.onPause();
        }
        if (this.extensionManager != null) {
            this.extensionManager.onPause();
        }
        this.screenOnManager.onPause();
        this.isResumed = false;
        updateFadeVisibility();
    }

    public void onResume() {
        this.gvrApi.resume();
        if (this.daydreamTouchListener != null) {
            this.daydreamTouchListener.refreshViewerProfile();
        }
        this.displaySynchronizer.onResume();
        if (this.presentationHelper != null) {
            this.presentationHelper.onResume();
        }
        if (this.scanlineRacingView != null) {
            this.scanlineRacingView.onResume();
        }
        if (this.vrCoreSdkClient != null) {
            this.vrCoreSdkClient.onResume();
        }
        if (this.cardboardEmulator != null && this.gvrApi.getViewerType() == 1) {
            this.cardboardEmulator.onResume();
        }
        if (this.extensionManager != null) {
            this.extensionManager.onResume();
        }
        this.screenOnManager.onResume();
        this.frameFlushWorkaround.onResume();
        this.isResumed = true;
        updateFadeVisibility();
        updateUiLayout();
    }

    public void onBackPressed() {
        this.uiLayout.invokeCloseButtonListener();
    }

    public void shutdown() {
        this.displaySynchronizer.shutdown();
        if (this.daydreamTouchListener != null) {
            this.daydreamTouchListener.shutdown();
        }
        removeView(this.presentationLayout);
        removeView(this.uiLayout.getRoot());
        this.scanlineRacingRenderer = null;
        if (this.videoSurface != null) {
            this.videoSurface.shutdown();
            this.videoSurface = null;
        }
        this.scanlineRacingView = null;
        this.presentationView = null;
        if (this.presentationHelper != null) {
            this.presentationHelper.shutdown();
            this.presentationHelper = null;
        }
        if (this.vrCoreSdkClient != null) {
            this.vrCoreSdkClient.onPause();
            this.vrCoreSdkClient = null;
        }
        if (this.cardboardEmulator != null) {
            this.cardboardEmulator.onPause();
            this.cardboardEmulator = null;
        }
        if (this.extensionManager != null) {
            this.extensionManager.shutdown();
            this.extensionManager = null;
        }
        if (this.gvrApi != null) {
            this.gvrApi.shutdown();
            this.gvrApi = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        updateFadeVisibility();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.attachedToWindow = false;
        updateFadeVisibility();
        super.onDetachedFromWindow();
        if (this.presentationHelper != null) {
            this.presentationHelper.onDetachedFromWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.displaySynchronizer.onConfigurationChanged();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.presentationView == null || !isPresenting() || !this.presentationView.dispatchTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setPresentationView(View view) {
        if (this.presentationView != null) {
            this.presentationLayout.removeView(this.presentationView);
        }
        this.presentationLayout.addView(view, 0);
        this.presentationView = view;
    }

    public boolean enableAsyncReprojection(int i) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Async reprojection may only be enabled from the UI thread");
        } else if (this.asyncReprojectionFlags != -1) {
            if ((this.asyncReprojectionFlags & i) != i) {
                throw new UnsupportedOperationException("Async reprojection flags cannot be added once initialized.");
            }
            Log.d(TAG, new StringBuilder(58).append("Async reprojection already enabled with flags: ").append(this.asyncReprojectionFlags).toString());
            return true;
        } else if (this.scanlineRacingView != null) {
            return true;
        } else {
            if (!this.daydreamUtils.isDaydreamPhone(getContext())) {
                return false;
            }
            if (!this.gvrApi.setAsyncReprojectionEnabled(true)) {
                Log.e(TAG, "Failed to initialize async reprojection, unsupported device.");
                return false;
            }
            this.asyncReprojectionFlags = i;
            if (this.gvrApi.usingVrDisplayService()) {
                this.displaySynchronizer.disableFrameMonitor();
                return true;
            }
            addScanlineRacingView();
            return true;
        }
    }

    public boolean enableCardboardTriggerEmulation(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("The Cardboard trigger listener must not be null.");
        } else if (this.cardboardEmulator != null) {
            return true;
        } else {
            if (!this.daydreamUtils.isDaydreamPhone(getContext())) {
                return false;
            }
            this.cardboardEmulator = new CardboardEmulator(getContext(), runnable);
            return true;
        }
    }

    public GvrApi getGvrApi() {
        return this.gvrApi;
    }

    /* access modifiers changed from: protected */
    public VrCoreSdkClient createVrCoreSdkClient(Context context, GvrApi gvrApi2, DaydreamUtilsWrapper daydreamUtilsWrapper, FadeOverlayView fadeOverlayView2) {
        return new VrCoreSdkClient(context, gvrApi2, ContextUtils.getComponentName(context), daydreamUtilsWrapper, new Runnable() {
            public void run() {
                GvrLayoutImpl.this.uiLayout.invokeCloseButtonListener();
            }
        }, fadeOverlayView2);
    }

    public void setStereoModeEnabled(boolean z) {
        ThreadUtils.runOnUiThread(new GvrLayoutImpl$$Lambda$0(this, z));
    }

    /* access modifiers changed from: private */
    /* renamed from: setStereoModeEnabledImpl */
    public void lambda$setStereoModeEnabled$0$GvrLayoutImpl(boolean z) {
        if (this.stereoModeEnabled != z) {
            this.stereoModeEnabled = z;
            this.uiLayout.setEnabled(z);
            if (this.vrCoreSdkClient != null) {
                this.vrCoreSdkClient.setEnabled(z);
            }
            if (this.fadeOverlayView != null) {
                this.fadeOverlayView.setEnabled(z);
            }
            if (this.daydreamTouchListener != null) {
                this.daydreamTouchListener.setEnabled(z);
            }
            if (this.extensionManager != null) {
                this.extensionManager.setEnabled(z);
            }
            this.screenOnManager.setEnabled(z);
            updateRenderingViewsVisibility(0);
        }
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        if (this.vrCoreSdkClient != null) {
            this.vrCoreSdkClient.setReentryIntent(pendingIntent);
        }
    }

    public boolean setOnDonNotNeededListener(Runnable runnable) {
        if (this.vrCoreSdkClient == null) {
            return false;
        }
        this.vrCoreSdkClient.setOnDonNotNeededListener(runnable);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isPresenting() {
        return (this.presentationView == null || this.presentationHelper == null || !this.presentationHelper.isPresenting()) ? false : true;
    }

    static void setPresentationFactory(PresentationFactory presentationFactory) {
        sOptionalPresentationFactory = presentationFactory;
    }

    /* access modifiers changed from: package-private */
    public VrCoreSdkClient getVrCoreSdkClient() {
        return this.vrCoreSdkClient;
    }

    /* access modifiers changed from: package-private */
    public FadeOverlayView getFadeOverlayView() {
        return this.fadeOverlayView;
    }

    /* access modifiers changed from: package-private */
    public void addPresentationListener(PresentationListener presentationListener) {
        if (this.presentationHelper != null) {
            this.presentationHelper.addListener(presentationListener);
        }
    }

    /* access modifiers changed from: package-private */
    public SdkDaydreamTouchListener createDaydreamTouchListener() {
        return new SdkDaydreamTouchListener(this);
    }

    private boolean isDeviceDetectionEnabled() {
        if (this.gvrApi.getSdkConfigurationParams().useDeviceIdleDetection == null) {
            return false;
        }
        return this.gvrApi.getSdkConfigurationParams().useDeviceIdleDetection.booleanValue();
    }

    private boolean isContextSharingEnabled() {
        if (this.gvrApi == null) {
            throw new IllegalStateException("GvrApi must be ready before isContextSharingEnabled is called");
        }
        C0003Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig asyncReprojectionConfig = this.gvrApi.getSdkConfigurationParams().asyncReprojectionConfig;
        if (asyncReprojectionConfig == null || asyncReprojectionConfig.flags == null || (asyncReprojectionConfig.flags.longValue() & 16) == 0) {
            return false;
        }
        return true;
    }

    private boolean isDimUiEnabled() {
        Boolean bool;
        if (this.gvrApi == null || (bool = this.gvrApi.getSdkConfigurationParams().dimUiLayer) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private void addScanlineRacingView() {
        if (this.scanlineRacingView == null) {
            this.eglFactory = new EglFactory();
            this.eglFactory.setUseDebug(this.gvrApi.isOpenGLKHRDebugEnabled());
            this.eglFactory.setUsePriorityContext(true);
            this.eglFactory.setUseProtectedBuffers((this.asyncReprojectionFlags & 1) != 0);
            this.eglFactory.setEGLContextClientVersion(3);
            this.scanlineRacingView = new AsyncReprojectionSurfaceView(getContext());
            this.scanlineRacingView.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) new MutableEglConfigChooser());
            this.scanlineRacingView.setZOrderMediaOverlay(true);
            this.scanlineRacingView.setEGLContextFactory(this.eglFactory);
            this.scanlineRacingView.setEGLWindowSurfaceFactory(this.eglFactory);
            if (isContextSharingEnabled()) {
                this.scanlineRacingView.setEglReadyListener(this.eglReadyListener);
            }
            if (!this.stereoModeEnabled) {
                Log.w(TAG, "Disabling stereo mode with async reprojection enabled may not work properly.");
                this.scanlineRacingView.setVisibility(8);
            }
            if (this.scanlineRacingRenderer == null) {
                this.scanlineRacingRenderer = new ScanlineRacingRenderer(this.gvrApi);
            }
            this.scanlineRacingRenderer.setSurfaceView(this.scanlineRacingView);
            this.scanlineRacingView.setRenderer(this.scanlineRacingRenderer);
            this.scanlineRacingView.setSwapMode(1);
            if (!this.isResumed) {
                this.scanlineRacingView.onPause();
            }
            this.presentationLayout.addView(this.scanlineRacingView, 0);
        }
    }

    private PresentationHelper tryCreatePresentationHelper() {
        if (Build.VERSION.SDK_INT <= 16) {
            return null;
        }
        String externalDisplayName = DisplayUtils.getExternalDisplayName(getContext());
        if (externalDisplayName == null) {
            Log.e(TAG, "HDMI display name could not be found, disabling external presentation support");
            return null;
        }
        return new PresentationHelper(getContext(), this, this.presentationLayout, this.displaySynchronizer, externalDisplayName);
    }

    /* access modifiers changed from: private */
    public void updateRenderingViewsVisibility(int i) {
        if (this.presentationView != null) {
            this.presentationView.setVisibility(this.stereoModeEnabled ? i : 0);
        }
        if (this.scanlineRacingView != null) {
            AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
            if (!this.stereoModeEnabled) {
                i = 8;
            }
            asyncReprojectionSurfaceView.setVisibility(i);
        }
    }

    private void updateFadeVisibility() {
        if (this.fadeOverlayView != null) {
            if (this.autoFadeEnabled) {
                boolean z = this.attachedToWindow && getWindowVisibility() == 0;
                if (z && this.isResumed) {
                    this.fadeOverlayView.onVisible();
                    removeCallbacks(this.showRenderingViewsRunnable);
                    postDelayed(this.showRenderingViewsRunnable, 50);
                } else if (!z && !this.isResumed) {
                    this.fadeOverlayView.onInvisible();
                    updateRenderingViewsVisibility(4);
                    removeCallbacks(this.showRenderingViewsRunnable);
                }
            } else if (this.isResumed) {
                this.fadeOverlayView.onVisible();
            } else {
                this.fadeOverlayView.onInvisible();
            }
        }
    }

    private void updateUiLayout() {
        boolean z = true;
        if (this.gvrApi.getViewerType() != 1) {
            z = false;
        }
        this.uiLayout.setDaydreamModeEnabled(z);
    }
}
