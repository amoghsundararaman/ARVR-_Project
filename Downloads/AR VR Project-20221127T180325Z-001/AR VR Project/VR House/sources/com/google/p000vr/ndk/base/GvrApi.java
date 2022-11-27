package com.google.p000vr.ndk.base;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.cardboard.DisplaySynchronizer;
import com.google.p000vr.cardboard.DisplayUtils;
import com.google.p000vr.cardboard.EglReadyListener;
import com.google.p000vr.cardboard.UsedByNative;
import com.google.p000vr.cardboard.VrParamsProvider;
import com.google.p000vr.cardboard.VrParamsProviderFactory;
import com.google.p000vr.cardboard.annotations.UsedByReflection;
import com.google.p000vr.ndk.base.GvrLayout;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.p000vr.sdk.proto.nano.Preferences;
import com.google.protobuf.nano.MessageNano;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@UsedByReflection("Unity")
/* renamed from: com.google.vr.ndk.base.GvrApi */
public class GvrApi {
    private static final boolean IS_ROBOLECTRIC_BUILD = "robolectric".equals(Build.FINGERPRINT);
    private static final String TAG = "GvrApi";
    private static PoseTracker sPoseTrackerForTesting;
    private final Context context;
    private final DisplaySynchronizer displaySynchronizer;
    private long nativeGvrContext;
    private final boolean ownsNativeGvrContext;
    private Properties properties;
    private ArrayList<WeakReference<SwapChain>> swapChainRefs;
    private UserPrefs userPrefs;
    private final VrParamsProvider vrParamsProvider;

    /* renamed from: com.google.vr.ndk.base.GvrApi$Error */
    public static abstract class Error {
        public static final int CONTROLLER_CREATE_FAILED = 2;
        public static final int NONE = 0;
        public static final int NO_FRAME_AVAILABLE = 3;
    }

    /* renamed from: com.google.vr.ndk.base.GvrApi$Feature */
    public static abstract class Feature {
        public static final int ASYNC_REPROJECTION = 0;
        public static final int EXTERNAL_SURFACE = 2;
        public static final int HARDWARE_BUFFERS = 4;
        public static final int HEAD_POSE_6DOF = 3;
        public static final int MULTIVIEW = 1;
    }

    @UsedByNative
    /* renamed from: com.google.vr.ndk.base.GvrApi$IdleListener */
    interface IdleListener {
        @UsedByNative
        void onIdleChanged(boolean z);
    }

    @UsedByNative
    /* renamed from: com.google.vr.ndk.base.GvrApi$PoseTracker */
    public interface PoseTracker {
        @UsedByNative
        void getHeadPoseInStartSpace(float[] fArr, long j);
    }

    /* renamed from: com.google.vr.ndk.base.GvrApi$ViewerType */
    public static abstract class ViewerType {
        public static final int CARDBOARD = 0;
        public static final int DAYDREAM = 1;
        static final int DEFAULT = 0;
    }

    static native byte[] nativeAnalyticsCreateSample(long j, byte[] bArr);

    static native long nativeBufferSpecCreate(long j);

    static native void nativeBufferSpecDestroy(long j);

    static native int nativeBufferSpecGetSamples(long j);

    static native void nativeBufferSpecGetSize(long j, Point point);

    static native void nativeBufferSpecSetColorFormat(long j, int i);

    static native void nativeBufferSpecSetDepthStencilFormat(long j, int i);

    static native void nativeBufferSpecSetMultiviewLayers(long j, int i);

    static native void nativeBufferSpecSetSamples(long j, int i);

    static native void nativeBufferSpecSetSize(long j, int i, int i2);

    static native long nativeBufferViewportCreate(long j);

    static native void nativeBufferViewportDestroy(long j);

    static native boolean nativeBufferViewportEqual(long j, long j2);

    static native int nativeBufferViewportGetExternalSurfaceId(long j);

    static native float nativeBufferViewportGetOpacity(long j);

    static native int nativeBufferViewportGetReprojection(long j);

    static native int nativeBufferViewportGetSourceBufferIndex(long j);

    static native void nativeBufferViewportGetSourceFov(long j, RectF rectF);

    static native void nativeBufferViewportGetSourceUv(long j, RectF rectF);

    static native int nativeBufferViewportGetTargetEye(long j);

    static native void nativeBufferViewportGetTransform(long j, float[] fArr);

    static native void nativeBufferViewportGetVignetteFraction(long j, PointF pointF);

    private native long nativeBufferViewportListCreate(long j);

    static native void nativeBufferViewportListDestroy(long j);

    static native void nativeBufferViewportListGetItem(long j, int i, long j2);

    static native int nativeBufferViewportListGetSize(long j);

    static native void nativeBufferViewportListSetItem(long j, int i, long j2);

    static native void nativeBufferViewportSetExternalSurface(long j, long j2);

    static native void nativeBufferViewportSetExternalSurfaceId(long j, int i);

    static native void nativeBufferViewportSetEyeFromWorldMatrix(long j, float[] fArr);

    static native void nativeBufferViewportSetOpacity(long j, float f);

    static native void nativeBufferViewportSetReprojection(long j, int i);

    static native void nativeBufferViewportSetSourceBufferIndex(long j, int i);

    static native void nativeBufferViewportSetSourceFov(long j, float f, float f2, float f3, float f4);

    static native void nativeBufferViewportSetSourceLayer(long j, int i);

    static native void nativeBufferViewportSetSourceUv(long j, float f, float f2, float f3, float f4);

    static native void nativeBufferViewportSetTargetEye(long j, int i);

    static native void nativeBufferViewportSetTransform(long j, float[] fArr);

    static native void nativeBufferViewportSetVignetteFraction(long j, float f, float f2);

    static native void nativeBufferViewportUnsetEyeFromWorldMatrix(long j);

    private native int nativeClearError(long j);

    private native float[] nativeComputeDistortedPoint(long j, int i, float[] fArr);

    private native long nativeCreate(ClassLoader classLoader, Context context2, long j, int i, int i2, float f, float f2, PoseTracker poseTracker);

    static native long nativeCreateEvent();

    static native long nativeCreateValue();

    static native void nativeDestroyEvent(long j);

    static native void nativeDestroyValue(long j);

    private native void nativeDistortToScreen(long j, int i, long j2, float[] fArr, long j3);

    private native void nativeDumpDebugData(long j);

    static native long nativeExternalSurfaceCreate(long j);

    static native long nativeExternalSurfaceCreateWithListeners(long j, Runnable runnable, Runnable runnable2, Handler handler);

    static native void nativeExternalSurfaceDestroy(long j);

    static native int nativeExternalSurfaceGetId(long j);

    static native Surface nativeExternalSurfaceGetSurface(long j);

    static native void nativeFrameBindBuffer(long j, int i);

    static native void nativeFrameGetBufferSize(long j, int i, Point point);

    static native int nativeFrameGetFramebufferObject(long j, int i);

    static native void nativeFrameSubmit(long j, long j2, float[] fArr);

    static native void nativeFrameUnbind(long j);

    private native boolean nativeGetAsyncReprojectionEnabled(long j);

    private native float nativeGetBorderSizeMeters(long j);

    private native long nativeGetCurrentProperties(long j);

    private native int nativeGetError(long j);

    private static native String nativeGetErrorString(int i);

    static native long nativeGetEventFlags(long j);

    static native long nativeGetEventTimestamp(long j);

    static native int nativeGetEventType(long j);

    private native void nativeGetEyeFromHeadMatrix(long j, int i, float[] fArr);

    private native void nativeGetHeadSpaceFromStartSpaceRotation(long j, float[] fArr, long j2);

    private native void nativeGetHeadSpaceFromStartSpaceTransform(long j, float[] fArr, long j2);

    private native void nativeGetMaximumEffectiveRenderTargetSize(long j, Point point);

    static native boolean nativeGetProperty(long j, int i, long j2);

    static native long nativeGetRecenterEventFlags(long j);

    static native void nativeGetRecenterEventStartSpaceFromTrackingSpaceTransform(long j, float[] fArr);

    static native int nativeGetRecenterEventType(long j);

    private native void nativeGetRecommendedBufferViewports(long j, long j2);

    private native void nativeGetScreenBufferViewports(long j, long j2);

    private native void nativeGetScreenTargetSize(long j, Point point);

    private native long nativeGetUserPrefs(long j);

    private native String nativeGetViewerModel(long j);

    private native int nativeGetViewerType(long j);

    private native String nativeGetViewerVendor(long j);

    private native int[] nativeGetWindowBounds(long j);

    private native void nativeInitializeGl(long j);

    private native boolean nativeIsFeatureSupported(long j, int i);

    private native void nativeOnPauseReprojectionThread(long j);

    private native void nativeOnSurfaceChangedReprojectionThread(long j);

    private native void nativeOnSurfaceCreatedReprojectionThread(long j);

    private native void nativePause(long j);

    private native void nativePauseTracking(long j);

    private native byte[] nativePauseTrackingGetState(long j);

    private native boolean nativePollEvent(long j, long j2);

    private native void nativeRecenterTracking(long j);

    private native void nativeReconnectSensors(long j);

    private native void nativeReleaseGvrContext(long j);

    private native Point nativeRenderReprojectionThread(long j);

    private native void nativeRequestContextSharing(long j, EglReadyListener eglReadyListener);

    private native void nativeResetTracking(long j);

    private native void nativeResume(long j);

    private native void nativeResumeTracking(long j);

    private native void nativeResumeTrackingSetState(long j, byte[] bArr);

    private static native void nativeSetApplicationState(ClassLoader classLoader, Context context2);

    private native boolean nativeSetAsyncReprojectionEnabled(long j, boolean z);

    private native void nativeSetDefaultFramebufferActive(long j);

    private native boolean nativeSetDefaultViewerProfile(long j, String str);

    private native void nativeSetDisplayMetrics(long j, int i, int i2, float f, float f2);

    private static native void nativeSetDynamicLibraryLoadingEnabled(boolean z);

    private native void nativeSetIdleListener(long j, IdleListener idleListener);

    private native void nativeSetIgnoreManualPauseResumeTracker(long j, boolean z);

    private native void nativeSetLensOffset(long j, float f, float f2, float f3);

    private native void nativeSetSurfaceSize(long j, int i, int i2);

    private native boolean nativeSetViewerParams(long j, byte[] bArr);

    static native long nativeSwapChainAcquireFrame(long j);

    static native long nativeSwapChainCreate(long j, long[] jArr);

    static native void nativeSwapChainDestroy(long j);

    static native int nativeSwapChainGetBufferCount(long j);

    static native void nativeSwapChainGetBufferSize(long j, int i, Point point);

    static native void nativeSwapChainResizeBuffer(long j, int i, int i2, int i3);

    static native int nativeUserPrefsGetControllerHandedness(long j);

    static native boolean nativeUserPrefsGetPerformanceHudEnabled(long j);

    static native boolean nativeUserPrefsGetPerformanceMonitoringEnabled(long j);

    private static native boolean nativeUsingDynamicLibrary();

    private static native boolean nativeUsingShimLibrary();

    private native boolean nativeUsingVrDisplayService(long j);

    static native long nativeValueAsFlags(long j);

    static native float nativeValueAsFloat(long j);

    static native int nativeValueAsInt(long j);

    static native void nativeValueAsMat4f(long j, float[] fArr);

    static native long nativeValueGetFlags(long j);

    public static void setPoseTrackerForTesting(PoseTracker poseTracker) {
        sPoseTrackerForTesting = poseTracker;
    }

    public static void setDynamicLibraryLoadingEnabled(boolean z) {
        nativeSetDynamicLibraryLoadingEnabled(z);
    }

    public static boolean usingDynamicLibrary(Context context2) {
        setApplicationState(context2);
        return nativeUsingDynamicLibrary();
    }

    public static boolean usingShimLibrary() {
        return nativeUsingShimLibrary();
    }

    /* JADX INFO: finally extract failed */
    public GvrApi(Context context2, DisplaySynchronizer displaySynchronizer2) {
        this.context = context2;
        this.displaySynchronizer = displaySynchronizer2;
        long nativeDisplaySynchronizer = displaySynchronizer2 == null ? 0 : displaySynchronizer2.getNativeDisplaySynchronizer();
        this.vrParamsProvider = VrParamsProviderFactory.create(context2);
        Display.DisplayParams readDisplayParams = this.vrParamsProvider.readDisplayParams();
        this.swapChainRefs = new ArrayList<>();
        DisplayMetrics computeCurrentDisplayMetrics = computeCurrentDisplayMetrics(readDisplayParams);
        this.ownsNativeGvrContext = true;
        if (!IS_ROBOLECTRIC_BUILD) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                this.nativeGvrContext = nativeCreate(getClass().getClassLoader(), context2.getApplicationContext(), nativeDisplaySynchronizer, computeCurrentDisplayMetrics.widthPixels, computeCurrentDisplayMetrics.heightPixels, computeCurrentDisplayMetrics.xdpi, computeCurrentDisplayMetrics.ydpi, sPoseTrackerForTesting);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                if (this.nativeGvrContext == 0) {
                    throw new IllegalStateException("Native GVR context creation failed, implementation unavailable.");
                }
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th;
            }
        }
    }

    GvrApi(Context context2, long j) {
        if (j == 0) {
            throw new IllegalArgumentException("Invalid wrapped native GVR context.");
        }
        this.context = context2;
        this.ownsNativeGvrContext = false;
        this.nativeGvrContext = j;
        this.vrParamsProvider = VrParamsProviderFactory.create(context2);
        this.displaySynchronizer = null;
        this.swapChainRefs = new ArrayList<>();
        setApplicationState(context2);
    }

    /* access modifiers changed from: package-private */
    public void requestContextSharing(EglReadyListener eglReadyListener) {
        nativeRequestContextSharing(this.nativeGvrContext, eglReadyListener);
    }

    static DisplaySynchronizer createDefaultDisplaySynchronizer(Context context2) {
        return new DisplaySynchronizer(context2, DisplayUtils.getDefaultDisplay(context2));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nativeGvrContext != 0) {
                Log.w(TAG, "GvrApi.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public C0003Vr.VREvent.SdkConfigurationParams getSdkConfigurationParams() {
        return SdkConfigurationReader.getParams(this.context);
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        nativePause(this.nativeGvrContext);
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        nativeResume(this.nativeGvrContext);
    }

    public void shutdown() {
        ArrayList arrayList = this.swapChainRefs;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SwapChain swapChain = (SwapChain) ((WeakReference) obj).get();
            if (swapChain != null) {
                swapChain.shutdown();
            }
        }
        if (this.nativeGvrContext != 0) {
            this.vrParamsProvider.close();
            if (this.ownsNativeGvrContext) {
                nativeReleaseGvrContext(this.nativeGvrContext);
            }
            this.nativeGvrContext = 0;
        }
    }

    @UsedByReflection("Unity")
    public long getNativeGvrContext() {
        return this.nativeGvrContext;
    }

    public int getError() {
        return nativeGetError(this.nativeGvrContext);
    }

    public int clearError() {
        return nativeClearError(this.nativeGvrContext);
    }

    public static String getErrorString(int i) {
        return nativeGetErrorString(i);
    }

    public UserPrefs getUserPrefs() {
        if (this.userPrefs == null) {
            this.userPrefs = new UserPrefs(nativeGetUserPrefs(this.nativeGvrContext));
        }
        return this.userPrefs;
    }

    /* access modifiers changed from: package-private */
    public boolean isOpenGLKHRDebugEnabled() {
        Preferences.DeveloperPrefs developerPrefs;
        Preferences.UserPrefs readUserPrefs = this.vrParamsProvider.readUserPrefs();
        if (readUserPrefs == null || (developerPrefs = readUserPrefs.developerPrefs) == null || !developerPrefs.getOpenglKhrDebugEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void dumpDebugData() {
        nativeDumpDebugData(this.nativeGvrContext);
    }

    public void initializeGl() {
        nativeInitializeGl(this.nativeGvrContext);
    }

    public void onSurfaceCreatedReprojectionThread() {
        nativeOnSurfaceCreatedReprojectionThread(this.nativeGvrContext);
    }

    public void onSurfaceChangedReprojectionThread() {
        nativeOnSurfaceChangedReprojectionThread(this.nativeGvrContext);
    }

    public BufferSpec createBufferSpec() {
        return new BufferSpec(nativeBufferSpecCreate(this.nativeGvrContext));
    }

    public ExternalSurface createExternalSurface(GvrLayout.ExternalSurfaceListener externalSurfaceListener, Handler handler) {
        return new ExternalSurface(this, externalSurfaceListener, handler);
    }

    public SwapChain createSwapChain(BufferSpec[] bufferSpecArr) {
        long[] jArr = new long[bufferSpecArr.length];
        for (int i = 0; i < bufferSpecArr.length; i++) {
            jArr[i] = bufferSpecArr[i].nativeBufferSpec;
        }
        SwapChain swapChain = new SwapChain(nativeSwapChainCreate(this.nativeGvrContext, jArr));
        this.swapChainRefs.add(new WeakReference(swapChain));
        return swapChain;
    }

    public BufferViewportList createBufferViewportList() {
        return new BufferViewportList(nativeBufferViewportListCreate(this.nativeGvrContext));
    }

    public BufferViewport createBufferViewport() {
        return new BufferViewport(nativeBufferViewportCreate(this.nativeGvrContext));
    }

    public void getRecommendedBufferViewports(BufferViewportList bufferViewportList) {
        nativeGetRecommendedBufferViewports(this.nativeGvrContext, bufferViewportList.nativeBufferViewportList);
    }

    public void getScreenBufferViewports(BufferViewportList bufferViewportList) {
        nativeGetScreenBufferViewports(this.nativeGvrContext, bufferViewportList.nativeBufferViewportList);
    }

    public void getMaximumEffectiveRenderTargetSize(Point point) {
        nativeGetMaximumEffectiveRenderTargetSize(this.nativeGvrContext, point);
    }

    public void getScreenTargetSize(Point point) {
        nativeGetScreenTargetSize(this.nativeGvrContext, point);
    }

    @Deprecated
    public void distortToScreen(int i, BufferViewportList bufferViewportList, float[] fArr, long j) {
        if (fArr == null) {
            throw new IllegalArgumentException("Head transform must not be null.");
        }
        nativeDistortToScreen(this.nativeGvrContext, i, bufferViewportList.nativeBufferViewportList, fArr, j);
    }

    public Point renderReprojectionThread() {
        return nativeRenderReprojectionThread(this.nativeGvrContext);
    }

    public void onPauseReprojectionThread() {
        nativeOnPauseReprojectionThread(this.nativeGvrContext);
    }

    public void setDefaultFramebufferActive() {
        nativeSetDefaultFramebufferActive(this.nativeGvrContext);
    }

    @Deprecated
    public void getHeadSpaceFromStartSpaceRotation(float[] fArr, long j) {
        if (fArr == null || fArr.length != 16) {
            throw new IllegalArgumentException("Invalid head rotation argument, must be a float[16].");
        }
        nativeGetHeadSpaceFromStartSpaceRotation(this.nativeGvrContext, fArr, j);
    }

    public void getHeadSpaceFromStartSpaceTransform(float[] fArr, long j) {
        if (fArr == null || fArr.length != 16) {
            throw new IllegalArgumentException("Invalid head transform argument, must be a float[16].");
        }
        nativeGetHeadSpaceFromStartSpaceTransform(this.nativeGvrContext, fArr, j);
    }

    /* access modifiers changed from: package-private */
    public void setIgnoreManualTrackerPauseResume(boolean z) {
        nativeSetIgnoreManualPauseResumeTracker(this.nativeGvrContext, z);
    }

    public void pauseTracking() {
        nativePauseTracking(this.nativeGvrContext);
    }

    public void resumeTracking() {
        nativeResumeTracking(this.nativeGvrContext);
    }

    public byte[] pauseTrackingGetState() {
        return nativePauseTrackingGetState(this.nativeGvrContext);
    }

    public void resumeTrackingSetState(byte[] bArr) {
        nativeResumeTrackingSetState(this.nativeGvrContext, bArr);
    }

    public void resetTracking() {
        nativeResetTracking(this.nativeGvrContext);
    }

    public void recenterTracking() {
        nativeRecenterTracking(this.nativeGvrContext);
    }

    public void reconnectSensors() {
        nativeReconnectSensors(this.nativeGvrContext);
    }

    /* access modifiers changed from: package-private */
    public void setIdleListener(IdleListener idleListener) {
        nativeSetIdleListener(this.nativeGvrContext, idleListener);
    }

    public void refreshDisplayMetrics() {
        setDisplayMetrics(computeCurrentDisplayMetrics(this.vrParamsProvider.readDisplayParams()));
    }

    public boolean setDefaultViewerProfile(String str) {
        return nativeSetDefaultViewerProfile(this.nativeGvrContext, str);
    }

    public void refreshViewerProfile() {
        CardboardDevice.DeviceParams readDeviceParams = this.vrParamsProvider.readDeviceParams();
        if (readDeviceParams != null) {
            setViewerParams(MessageNano.toByteArray(readDeviceParams));
        }
    }

    public String getViewerVendor() {
        return nativeGetViewerVendor(this.nativeGvrContext);
    }

    public String getViewerModel() {
        return nativeGetViewerModel(this.nativeGvrContext);
    }

    public int getViewerType() {
        return nativeGetViewerType(this.nativeGvrContext);
    }

    @Deprecated
    public float[] getEyeFromHeadMatrix(int i) {
        float[] fArr = new float[16];
        getEyeFromHeadMatrix(i, fArr);
        return fArr;
    }

    public void getEyeFromHeadMatrix(int i, float[] fArr) {
        nativeGetEyeFromHeadMatrix(this.nativeGvrContext, i, fArr);
    }

    public int[] getWindowBounds() {
        int[] nativeGetWindowBounds = nativeGetWindowBounds(this.nativeGvrContext);
        if (nativeGetWindowBounds.length == 4) {
            return nativeGetWindowBounds;
        }
        throw new AssertionError("Implementation error: invalid window bounds.");
    }

    public float[] computeDistortedPoint(int i, float[] fArr) {
        float[] nativeComputeDistortedPoint = nativeComputeDistortedPoint(this.nativeGvrContext, i, fArr);
        if (nativeComputeDistortedPoint.length == 6) {
            return nativeComputeDistortedPoint;
        }
        throw new AssertionError("Implementation error: invalid UV coordinates output.");
    }

    /* access modifiers changed from: package-private */
    public boolean setAsyncReprojectionEnabled(boolean z) {
        return nativeSetAsyncReprojectionEnabled(this.nativeGvrContext, z);
    }

    public boolean getAsyncReprojectionEnabled() {
        return nativeGetAsyncReprojectionEnabled(this.nativeGvrContext);
    }

    public void setSurfaceSize(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (i2 != 0) {
            z2 = false;
        }
        if (z != z2) {
            throw new IllegalArgumentException("Custom surface dimensions should both either be zero or non-zero");
        }
        nativeSetSurfaceSize(this.nativeGvrContext, i, i2);
    }

    public boolean isFeatureSupported(int i) {
        return nativeIsFeatureSupported(this.nativeGvrContext, i);
    }

    public void setLensOffset(float f, float f2, float f3) {
        nativeSetLensOffset(this.nativeGvrContext, f, f2, f3);
    }

    public boolean pollEvent(Event event) {
        return nativePollEvent(this.nativeGvrContext, event.nativeEvent);
    }

    public Properties getCurrentProperties() {
        if (this.properties == null) {
            this.properties = new Properties(nativeGetCurrentProperties(this.nativeGvrContext));
        }
        return this.properties;
    }

    /* access modifiers changed from: package-private */
    public DisplayMetrics computeCurrentDisplayMetrics(Display.DisplayParams displayParams) {
        android.view.Display display;
        if (this.displaySynchronizer == null) {
            display = DisplayUtils.getDefaultDisplay(this.context);
        } else {
            display = this.displaySynchronizer.getDisplay();
        }
        return DisplayUtils.getDisplayMetricsLandscapeWithOverride(display, displayParams);
    }

    /* access modifiers changed from: package-private */
    public void setDisplayMetrics(DisplayMetrics displayMetrics) {
        nativeSetDisplayMetrics(this.nativeGvrContext, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.xdpi, displayMetrics.ydpi);
    }

    public float getBorderSizeMeters() {
        return nativeGetBorderSizeMeters(this.nativeGvrContext);
    }

    private boolean setViewerParams(byte[] bArr) {
        return nativeSetViewerParams(this.nativeGvrContext, bArr);
    }

    public boolean usingVrDisplayService() {
        return nativeUsingVrDisplayService(this.nativeGvrContext);
    }

    private static void setApplicationState(Context context2) {
        if (!IS_ROBOLECTRIC_BUILD) {
            nativeSetApplicationState(GvrApi.class.getClassLoader(), context2.getApplicationContext());
        }
    }

    static {
        DefaultNativeLibraryLoader.maybeLoadDefaultLibrary();
    }
}
