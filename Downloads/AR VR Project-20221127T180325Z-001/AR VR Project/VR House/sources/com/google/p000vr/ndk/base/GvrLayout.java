package com.google.p000vr.ndk.base;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.google.p000vr.cardboard.ContextUtils;
import com.google.p000vr.cardboard.VrContextWrapper;
import com.google.p000vr.cardboard.annotations.UsedByReflection;
import com.google.p000vr.vrcore.library.api.IGvrLayout;
import com.google.p000vr.vrcore.library.api.ObjectWrapper;

@UsedByReflection("Unity")
/* renamed from: com.google.vr.ndk.base.GvrLayout */
public class GvrLayout extends FrameLayout {
    private static final String TAG = "GvrLayout";
    private GvrApi gvrApi;
    private IGvrLayout impl;
    private GvrUiLayout uiLayout;
    private ExternalSurface videoSurface;

    /* renamed from: com.google.vr.ndk.base.GvrLayout$ExternalSurfaceListener */
    public interface ExternalSurfaceListener {
        void onFrameAvailable();

        void onSurfaceAvailable(Surface surface);
    }

    /* renamed from: com.google.vr.ndk.base.GvrLayout$SetOnDonNotNeededListenerResult */
    public static final class SetOnDonNotNeededListenerResult {
        public static final int API_NOT_SUPPORTED = 1;
        public static final int DON_NOT_SUPPORTED = 2;
        public static final int SUCCESS = 3;

        private SetOnDonNotNeededListenerResult() {
        }
    }

    public GvrLayout(Context context) {
        super(context);
        if (ContextUtils.getActivity(context) == null) {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        }
        init();
    }

    public GvrLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (ContextUtils.getActivity(context) == null) {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        }
        init();
    }

    public GvrLayout(VrContextWrapper vrContextWrapper) {
        super(vrContextWrapper);
        init();
    }

    GvrLayout(Context context, GvrLayoutImpl gvrLayoutImpl, GvrApi gvrApi2) {
        super(context);
        this.impl = new GvrLayoutImplWrapper(gvrLayoutImpl);
        this.gvrApi = gvrApi2;
        init();
    }

    private void init() {
        TraceCompat.beginSection("GvrLayout.init");
        try {
            if (this.impl == null) {
                this.impl = GvrLayoutFactory.create(getContext());
            }
            this.uiLayout = new GvrUiLayout(this.impl.getUiLayout());
            if (this.gvrApi == null) {
                this.gvrApi = new GvrApi(getContext(), this.impl.getNativeGvrContext());
            }
            addView((View) ObjectWrapper.unwrap(this.impl.getRootView(), View.class));
            TraceCompat.endSection();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    @UsedByReflection("Unity")
    public GvrUiLayout getUiLayout() {
        return this.uiLayout;
    }

    @UsedByReflection("Unity")
    public void onPause() {
        TraceCompat.beginSection("GvrLayout.onPause");
        try {
            this.impl.onPause();
            TraceCompat.endSection();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    @UsedByReflection("Unity")
    public void onResume() {
        TraceCompat.beginSection("GvrLayout.onResume");
        try {
            this.impl.onResume();
            TraceCompat.endSection();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    public void onBackPressed() {
        try {
            this.impl.onBackPressed();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public void shutdown() {
        TraceCompat.beginSection("GvrLayout.shutdown");
        try {
            if (this.videoSurface != null) {
                this.videoSurface.shutdown();
                this.videoSurface = null;
            }
            this.impl.shutdown();
            this.gvrApi.shutdown();
            TraceCompat.endSection();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    @UsedByReflection("Unity")
    public void setPresentationView(View view) {
        try {
            this.impl.setPresentationView(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFixedPresentationSurfaceSize(int i, int i2) {
        getGvrApi().setSurfaceSize(i, i2);
    }

    public boolean enableAsyncReprojectionVideoSurface(ExternalSurfaceListener externalSurfaceListener, Handler handler, boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        try {
            if (!this.impl.enableAsyncReprojection(i)) {
                return false;
            }
            if (!this.gvrApi.isFeatureSupported(2)) {
                Log.e(TAG, "External Surfaces are unsupported. Cannot enable video Surface.");
                return false;
            }
            this.videoSurface = this.gvrApi.createExternalSurface(externalSurfaceListener, handler);
            return true;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public boolean setAsyncReprojectionEnabled(boolean z) {
        if (z) {
            try {
                return this.impl.enableAsyncReprojection(0);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } else if (!this.gvrApi.getAsyncReprojectionEnabled()) {
            return true;
        } else {
            throw new UnsupportedOperationException("Async reprojection cannot be disabled once enabled.");
        }
    }

    @UsedByReflection("Unity")
    public boolean enableAsyncReprojectionProtected() {
        try {
            return this.impl.enableAsyncReprojection(1);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean enableCardboardTriggerEmulation(Runnable runnable) {
        try {
            return this.impl.enableCardboardTriggerEmulation(ObjectWrapper.wrap(runnable));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAsyncReprojectionVideoSurfaceId() {
        if (this.videoSurface != null) {
            return this.videoSurface.getId();
        }
        Log.w(TAG, "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
        return -1;
    }

    public Surface getAsyncReprojectionVideoSurface() {
        if (this.videoSurface != null) {
            return this.videoSurface.getSurface();
        }
        Log.w(TAG, "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
        return null;
    }

    @UsedByReflection("Unity")
    public GvrApi getGvrApi() {
        return this.gvrApi;
    }

    public void setStereoModeEnabled(boolean z) {
        try {
            this.impl.setStereoModeEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        try {
            this.impl.setReentryIntent(ObjectWrapper.wrap(pendingIntent));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public int setOnDonNotNeededListener(Runnable runnable) {
        try {
            if (this.impl.setOnDonNotNeededListener(ObjectWrapper.wrap(runnable))) {
                return 3;
            }
            return 2;
        } catch (Exception e) {
            Log.w(TAG, "Unable to call setOnDonNotNeededListener(); probably an old VrCore build.");
            return 1;
        }
    }
}
