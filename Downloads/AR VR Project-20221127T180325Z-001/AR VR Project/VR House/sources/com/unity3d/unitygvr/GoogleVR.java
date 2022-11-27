package com.unity3d.unitygvr;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import com.google.p000vr.ndk.base.AndroidCompat;
import com.google.p000vr.ndk.base.GvrApi;
import com.google.p000vr.ndk.base.GvrLayout;
import com.google.p000vr.ndk.base.GvrUiLayout;

public class GoogleVR {
    private static final int FRAME_AVAILABLE = 2147483645;
    private static final int GOOGLE_VR_MESSAGE = 135711;
    private static final int SURFACE_AVAILABLE = 2147483646;
    private static final String TAG = "Unity";
    private Activity mActivity = null;
    private Context mContext = null;
    private Handler mDispatchHandler = null;
    private GvrApi mGvrApi = null;
    private SurfaceView mGvrGlView = null;
    private GvrLayout mGvrLayout = null;
    private boolean mGvrLoaded = false;
    private GvrUiLayout mGvrUiLayout = null;
    /* access modifiers changed from: private */
    public Surface mGvrVideoSurface = null;
    private boolean mIsDaydream = false;

    public GvrLayout getGvrLayout() {
        return this.mGvrLayout;
    }

    public boolean initialize(Activity activity, Context context, SurfaceView glView, boolean isDaydream, Handler dispatchHandler) {
        if (this.mGvrLoaded) {
            return true;
        }
        if (activity == null || context == null || glView == null) {
            Log.e(TAG, "One or more parameters were invalid when trying to initialize GoogleVR.");
            return false;
        }
        this.mActivity = activity;
        this.mContext = context;
        this.mGvrGlView = glView;
        this.mIsDaydream = isDaydream;
        this.mDispatchHandler = dispatchHandler;
        return loadGvrLibrary();
    }

    public void deinitialize() {
        this.mGvrApi = null;
        this.mGvrLayout = null;
        this.mGvrUiLayout = null;
        this.mGvrGlView = null;
        this.mActivity = null;
        this.mContext = null;
        this.mGvrLoaded = false;
        this.mIsDaydream = false;
        this.mGvrVideoSurface = null;
    }

    public long load(boolean enableAsynchronousProjection, boolean enableSustainedPerformanceMode, boolean enableTransitionView, boolean enableVideoLayer, boolean useProtectedMemory, Runnable closeButtonHandler) {
        if (this.mActivity == null || this.mContext == null) {
            Log.e(TAG, "Google VR is in an invalid state. Failing load");
            return 0;
        } else if (this.mGvrLayout != null) {
            return 0;
        } else {
            this.mGvrLayout = new GvrLayout(this.mContext);
            this.mGvrLayout.setPresentationView(this.mGvrGlView);
            if (enableAsynchronousProjection) {
                if (enableVideoLayer) {
                    this.mGvrLayout.enableAsyncReprojectionVideoSurface(new GvrLayout.ExternalSurfaceListener() {
                        public void onSurfaceAvailable(Surface surface) {
                            Surface unused = GoogleVR.this.mGvrVideoSurface = surface;
                            GoogleVR.this.notifySurfaceAvaialble(surface);
                        }

                        public void onFrameAvailable() {
                            GoogleVR.this.notifyFrameAvaialable();
                        }
                    }, new Handler(Looper.getMainLooper()), useProtectedMemory);
                }
                if (!this.mGvrLayout.setAsyncReprojectionEnabled(true)) {
                    Log.e(TAG, "Error Enabling Async Projection. Aborting load operation.");
                    return 0;
                } else if (enableSustainedPerformanceMode) {
                    AndroidCompat.setSustainedPerformanceMode(this.mActivity, true);
                }
            }
            this.mGvrUiLayout = this.mGvrLayout.getUiLayout();
            if (closeButtonHandler != null) {
                this.mGvrUiLayout.setCloseButtonListener(closeButtonHandler);
            }
            this.mGvrUiLayout.setTransitionViewEnabled(enableTransitionView);
            this.mGvrApi = this.mGvrLayout.getGvrApi();
            return this.mGvrApi.getNativeGvrContext();
        }
    }

    public void pause() {
        this.mGvrLayout.onPause();
        this.mGvrVideoSurface = null;
    }

    public void resume() {
        this.mGvrLayout.onResume();
    }

    public boolean enable(boolean enabled) {
        if (this.mContext == null) {
            Log.e(TAG, "Google VR is in an invalid state. Failing enable.");
            return false;
        }
        AndroidCompat.setVrModeEnabled(this.mActivity, enabled);
        return true;
    }

    public boolean unload() {
        this.mGvrLayout.shutdown();
        return true;
    }

    public int getVideoSurfaceId() {
        if (this.mGvrLayout == null || this.mGvrVideoSurface == null) {
            return -1;
        }
        return this.mGvrLayout.getAsyncReprojectionVideoSurfaceId();
    }

    public Surface getVideoSurface() {
        return this.mGvrVideoSurface;
    }

    private static boolean loadLibraryStatic(String libName) {
        try {
            System.loadLibrary(libName);
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Unable to find " + libName);
            return false;
        } catch (Exception ex) {
            Log.e(TAG, "Unknown error " + ex);
            return false;
        }
    }

    private boolean loadLibrary(String libName) {
        return loadLibraryStatic(libName);
    }

    private boolean loadGvrLibrary() {
        if (!this.mGvrLoaded) {
            this.mGvrLoaded = loadLibrary("gvr");
            if (!this.mGvrLoaded) {
                Log.e(TAG, "Unable to load Google GVR Library.");
            }
        }
        return this.mGvrLoaded;
    }

    /* access modifiers changed from: private */
    public void notifySurfaceAvaialble(Surface surface) {
        if (this.mDispatchHandler != null) {
            this.mDispatchHandler.sendMessage(this.mDispatchHandler.obtainMessage(GOOGLE_VR_MESSAGE, SURFACE_AVAILABLE, 0, surface));
        }
    }

    /* access modifiers changed from: private */
    public void notifyFrameAvaialable() {
        if (this.mDispatchHandler != null) {
            this.mDispatchHandler.sendMessage(this.mDispatchHandler.obtainMessage(GOOGLE_VR_MESSAGE, FRAME_AVAILABLE, 0));
        }
    }
}
