package com.google.p000vr.cardboard;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@UsedByNative
/* renamed from: com.google.vr.cardboard.ExternalSurfaceManager */
public class ExternalSurfaceManager {
    private static final String TAG = ExternalSurfaceManager.class.getSimpleName();
    public static final int UNSPECIFIED_BUFFER_SIZE = -1;
    private boolean isAttachedToGlContext;
    private int nextID;
    private volatile ExternalSurfaceData surfaceData;
    private final Object surfaceDataUpdateLock;
    private final UpdateSurfaceCallback updateSurfaceCallback;

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$ExternalSurfaceCallback */
    private interface ExternalSurfaceCallback {
        void cancelPosts();

        void onFrameAvailable();

        void onSurfaceAvailable();
    }

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$ExternalSurfaceConsumer */
    private interface ExternalSurfaceConsumer {
        void accept(ExternalSurface externalSurface);
    }

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$UpdateSurfaceCallback */
    public interface UpdateSurfaceCallback {
        void updateSurface(int i, int i2, long j, float[] fArr);
    }

    @UsedByNative
    public ExternalSurfaceManager(final long j) {
        this((UpdateSurfaceCallback) new UpdateSurfaceCallback() {
            public void updateSurface(int i, int i2, long j, float[] fArr) {
                ExternalSurfaceManager.nativeUpdateSurface(j, i, i2, j, fArr);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void nativeCallback(long j);

    /* access modifiers changed from: private */
    public static native void nativeUpdateSurface(long j, int i, int i2, long j2, float[] fArr);

    public ExternalSurfaceManager(UpdateSurfaceCallback updateSurfaceCallback2) {
        this.surfaceDataUpdateLock = new Object();
        this.surfaceData = new ExternalSurfaceData();
        this.nextID = 1;
        this.updateSurfaceCallback = updateSurfaceCallback2;
    }

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$ExternalSurfaceData */
    private static class ExternalSurfaceData {
        final HashMap<Integer, ExternalSurface> surfaces;
        final HashMap<Integer, ExternalSurface> surfacesToRelease;

        ExternalSurfaceData() {
            this.surfaces = new HashMap<>();
            this.surfacesToRelease = new HashMap<>();
        }

        ExternalSurfaceData(ExternalSurfaceData externalSurfaceData) {
            this.surfaces = new HashMap<>(externalSurfaceData.surfaces);
            this.surfacesToRelease = new HashMap<>(externalSurfaceData.surfacesToRelease);
            Iterator<Map.Entry<Integer, ExternalSurface>> it = this.surfacesToRelease.entrySet().iterator();
            while (it.hasNext()) {
                if (((ExternalSurface) it.next().getValue()).released.get()) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$AndroidHandlerCallback */
    private static class AndroidHandlerCallback implements ExternalSurfaceCallback {
        private final Runnable frameListener;
        private final Handler handler;
        private final Runnable surfaceListener;

        public AndroidHandlerCallback(Runnable runnable, Runnable runnable2, Handler handler2) {
            this.surfaceListener = runnable;
            this.frameListener = runnable2;
            this.handler = handler2;
        }

        public void onSurfaceAvailable() {
            if (this.surfaceListener != null) {
                this.handler.post(this.surfaceListener);
            }
        }

        public void onFrameAvailable() {
            if (this.frameListener != null) {
                this.handler.post(this.frameListener);
            }
        }

        public void cancelPosts() {
            if (this.surfaceListener != null) {
                this.handler.removeCallbacks(this.surfaceListener);
            }
            if (this.frameListener != null) {
                this.handler.removeCallbacks(this.frameListener);
            }
        }
    }

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$NativeCallback */
    private static class NativeCallback implements ExternalSurfaceCallback {
        private final long nativeFrameCallbackPtr;
        private final Runnable surfaceListener;
        private final Handler surfaceMainHandler = new Handler(Looper.getMainLooper());

        public NativeCallback(long j, long j2) {
            this.surfaceListener = new ExternalSurfaceManager$NativeCallback$$Lambda$0(j);
            this.nativeFrameCallbackPtr = j2;
        }

        public void onSurfaceAvailable() {
            this.surfaceMainHandler.post(this.surfaceListener);
        }

        public void onFrameAvailable() {
            ExternalSurfaceManager.nativeCallback(this.nativeFrameCallbackPtr);
        }

        public void cancelPosts() {
            this.surfaceMainHandler.removeCallbacks(this.surfaceListener);
        }
    }

    @UsedByNative
    public void shutdown() {
        synchronized (this.surfaceDataUpdateLock) {
            ExternalSurfaceData externalSurfaceData = this.surfaceData;
            this.surfaceData = new ExternalSurfaceData();
            if (!externalSurfaceData.surfaces.isEmpty()) {
                for (Map.Entry<Integer, ExternalSurface> value : externalSurfaceData.surfaces.entrySet()) {
                    ((ExternalSurface) value.getValue()).shutdown(this.updateSurfaceCallback);
                }
            }
            if (!externalSurfaceData.surfacesToRelease.isEmpty()) {
                for (Map.Entry<Integer, ExternalSurface> value2 : externalSurfaceData.surfacesToRelease.entrySet()) {
                    ((ExternalSurface) value2.getValue()).shutdown(this.updateSurfaceCallback);
                }
            }
        }
    }

    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$ExternalSurface */
    private static class ExternalSurface {
        /* access modifiers changed from: private */
        public final ExternalSurfaceCallback callback;
        /* access modifiers changed from: private */
        public final AtomicInteger frameAvailableCallbackCount = new AtomicInteger(0);
        private final int[] glTextureId = new int[1];

        /* renamed from: id */
        private final int f8id;
        private volatile boolean isAttached = false;
        /* access modifiers changed from: private */
        public volatile boolean isShutdown = false;
        /* access modifiers changed from: private */
        public final Object onFrameAvailableShutdownLock = new Object();
        /* access modifiers changed from: private */
        public final AtomicBoolean released = new AtomicBoolean(false);
        private volatile Surface surface;
        private volatile SurfaceTexture surfaceTexture;
        private final int surfaceTextureHeight;
        private final int surfaceTextureWidth;
        private final float[] transformMatrix = new float[16];

        ExternalSurface(int i, int i2, int i3, ExternalSurfaceCallback externalSurfaceCallback) {
            this.f8id = i;
            this.surfaceTextureWidth = i2;
            this.surfaceTextureHeight = i3;
            this.callback = externalSurfaceCallback;
            Matrix.setIdentityM(this.transformMatrix, 0);
        }

        /* access modifiers changed from: package-private */
        public void maybeAttachToCurrentGLContext() {
            if (!this.isAttached) {
                GLES20.glGenTextures(1, this.glTextureId, 0);
                maybeAttachToCurrentGLContext(this.glTextureId[0]);
            }
        }

        /* access modifiers changed from: package-private */
        public void maybeAttachToCurrentGLContext(int i) {
            if (!this.isAttached) {
                this.glTextureId[0] = i;
                if (this.surfaceTexture == null) {
                    this.surfaceTexture = new SurfaceTexture(this.glTextureId[0]);
                    if (this.surfaceTextureWidth > 0 && this.surfaceTextureHeight > 0) {
                        this.surfaceTexture.setDefaultBufferSize(this.surfaceTextureWidth, this.surfaceTextureHeight);
                    }
                    this.surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                            ExternalSurface.this.frameAvailableCallbackCount.getAndIncrement();
                            synchronized (ExternalSurface.this.onFrameAvailableShutdownLock) {
                                if (!ExternalSurface.this.isShutdown && ExternalSurface.this.callback != null) {
                                    ExternalSurface.this.callback.onFrameAvailable();
                                }
                            }
                        }
                    });
                    this.surface = new Surface(this.surfaceTexture);
                } else {
                    this.surfaceTexture.attachToGLContext(this.glTextureId[0]);
                }
                this.isAttached = true;
                if (this.callback != null) {
                    this.callback.onSurfaceAvailable();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void maybeDetachFromCurrentGLContext() {
            if (this.isAttached) {
                if (this.callback != null) {
                    this.callback.cancelPosts();
                }
                this.surfaceTexture.detachFromGLContext();
                this.isAttached = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void updateSurfaceTexture(UpdateSurfaceCallback updateSurfaceCallback) {
            if (this.isAttached) {
                if (this.frameAvailableCallbackCount.getAndSet(0) > 0) {
                    this.surfaceTexture.updateTexImage();
                    this.surfaceTexture.getTransformMatrix(this.transformMatrix);
                    updateSurfaceCallback.updateSurface(this.f8id, this.glTextureId[0], this.surfaceTexture.getTimestamp(), this.transformMatrix);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void updateSurfaceTextureToLatestImage(UpdateSurfaceCallback updateSurfaceCallback) {
            if (this.isAttached) {
                int andSet = this.frameAvailableCallbackCount.getAndSet(0);
                for (int i = 0; i < andSet; i++) {
                    this.surfaceTexture.updateTexImage();
                }
                if (andSet > 0) {
                    this.surfaceTexture.getTransformMatrix(this.transformMatrix);
                    updateSurfaceCallback.updateSurface(this.f8id, this.glTextureId[0], this.surfaceTexture.getTimestamp(), this.transformMatrix);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Surface getSurface() {
            if (!this.isAttached) {
                return null;
            }
            return this.surface;
        }

        /* access modifiers changed from: package-private */
        public void shutdown(UpdateSurfaceCallback updateSurfaceCallback) {
            synchronized (this.onFrameAvailableShutdownLock) {
                this.isShutdown = true;
            }
            if (!this.released.getAndSet(true)) {
                if (this.callback != null) {
                    this.callback.cancelPosts();
                }
                if (this.surfaceTexture != null) {
                    this.surfaceTexture.release();
                    this.surfaceTexture = null;
                    if (this.surface != null) {
                        this.surface.release();
                    }
                    this.surface = null;
                }
                updateSurfaceCallback.updateSurface(this.f8id, 0, 0, this.transformMatrix);
            }
        }
    }

    @UsedByNative
    public int createExternalSurface() {
        return createExternalSurfaceImpl(-1, -1, (ExternalSurfaceCallback) null);
    }

    @UsedByNative
    public int createExternalSurface(int i, int i2, Runnable runnable, Runnable runnable2, Handler handler) {
        if (runnable != null && handler != null) {
            return createExternalSurfaceImpl(i, i2, new AndroidHandlerCallback(runnable, runnable2, handler));
        }
        throw new IllegalArgumentException("Surface listener and handler must both be non-null for external Surface creation for Java callbacks.");
    }

    @UsedByNative
    public int createExternalSurfaceWithNativeCallback(int i, int i2, long j, long j2) {
        return createExternalSurfaceImpl(i, i2, new NativeCallback(j, j2));
    }

    private int createExternalSurfaceImpl(int i, int i2, ExternalSurfaceCallback externalSurfaceCallback) {
        int i3;
        synchronized (this.surfaceDataUpdateLock) {
            ExternalSurfaceData externalSurfaceData = new ExternalSurfaceData(this.surfaceData);
            i3 = this.nextID;
            this.nextID = i3 + 1;
            externalSurfaceData.surfaces.put(Integer.valueOf(i3), new ExternalSurface(i3, i, i2, externalSurfaceCallback));
            this.surfaceData = externalSurfaceData;
        }
        return i3;
    }

    @UsedByNative
    public void releaseExternalSurface(int i) {
        synchronized (this.surfaceDataUpdateLock) {
            ExternalSurfaceData externalSurfaceData = new ExternalSurfaceData(this.surfaceData);
            ExternalSurface remove = externalSurfaceData.surfaces.remove(Integer.valueOf(i));
            if (remove != null) {
                externalSurfaceData.surfacesToRelease.put(Integer.valueOf(i), remove);
                this.surfaceData = externalSurfaceData;
            } else {
                Log.e(TAG, new StringBuilder(48).append("Not releasing nonexistent surface ID ").append(i).toString());
            }
        }
    }

    public int getSurfaceCount() {
        return this.surfaceData.surfaces.size();
    }

    @UsedByNative
    public Surface getSurface(int i) {
        ExternalSurfaceData externalSurfaceData = this.surfaceData;
        if (externalSurfaceData.surfaces.containsKey(Integer.valueOf(i))) {
            return externalSurfaceData.surfaces.get(Integer.valueOf(i)).getSurface();
        }
        Log.e(TAG, new StringBuilder(58).append("Surface with ID ").append(i).append(" does not exist, returning null").toString());
        return null;
    }

    @UsedByNative
    public void consumerAttachToCurrentGLContext() {
        this.isAttachedToGlContext = true;
        ExternalSurfaceData externalSurfaceData = this.surfaceData;
        if (!externalSurfaceData.surfaces.isEmpty()) {
            for (ExternalSurface maybeAttachToCurrentGLContext : externalSurfaceData.surfaces.values()) {
                maybeAttachToCurrentGLContext.maybeAttachToCurrentGLContext();
            }
        }
    }

    @UsedByNative
    public void consumerAttachToCurrentGLContext(Map<Integer, Integer> map) {
        this.isAttachedToGlContext = true;
        ExternalSurfaceData externalSurfaceData = this.surfaceData;
        if (!this.surfaceData.surfaces.isEmpty()) {
            for (Integer next : this.surfaceData.surfaces.keySet()) {
                if (!map.containsKey(next)) {
                    Log.e(TAG, String.format("Surface %d's texture ID is not provided, abandoning attaching to current GL context.", new Object[]{next}));
                    return;
                }
            }
        }
        if (!map.isEmpty()) {
            for (Map.Entry next2 : map.entrySet()) {
                if (externalSurfaceData.surfaces.containsKey(next2.getKey())) {
                    externalSurfaceData.surfaces.get(next2.getKey()).maybeAttachToCurrentGLContext(((Integer) next2.getValue()).intValue());
                } else {
                    Log.e(TAG, String.format("Surface %d doesn't exist, skip attaching to current GL context.", new Object[]{next2.getKey()}));
                }
            }
        }
    }

    @UsedByNative
    public void consumerDetachFromCurrentGLContext() {
        this.isAttachedToGlContext = false;
        ExternalSurfaceData externalSurfaceData = this.surfaceData;
        if (!externalSurfaceData.surfaces.isEmpty()) {
            for (ExternalSurface maybeDetachFromCurrentGLContext : externalSurfaceData.surfaces.values()) {
                maybeDetachFromCurrentGLContext.maybeDetachFromCurrentGLContext();
            }
        }
    }

    @UsedByNative
    public void consumerUpdateManagedSurfaces() {
        consumerUpdateManagedSurfaceHelper(new ExternalSurfaceManager$$Lambda$0(this));
    }

    @UsedByNative
    public void consumerUpdateManagedSurfacesToLatestImage() {
        consumerUpdateManagedSurfaceHelper(new ExternalSurfaceManager$$Lambda$1(this));
    }

    private void consumerUpdateManagedSurfaceHelper(ExternalSurfaceConsumer externalSurfaceConsumer) {
        ExternalSurfaceData externalSurfaceData = this.surfaceData;
        if (this.isAttachedToGlContext && !externalSurfaceData.surfaces.isEmpty()) {
            for (ExternalSurface next : externalSurfaceData.surfaces.values()) {
                next.maybeAttachToCurrentGLContext();
                externalSurfaceConsumer.accept(next);
            }
        }
        if (!externalSurfaceData.surfacesToRelease.isEmpty()) {
            for (ExternalSurface shutdown : externalSurfaceData.surfacesToRelease.values()) {
                shutdown.shutdown(this.updateSurfaceCallback);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$consumerUpdateManagedSurfacesToLatestImage$1$ExternalSurfaceManager */
    public final /* synthetic */ void mo343xf6534792(ExternalSurface externalSurface) {
        externalSurface.updateSurfaceTextureToLatestImage(this.updateSurfaceCallback);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$consumerUpdateManagedSurfaces$0$ExternalSurfaceManager(ExternalSurface externalSurface) {
        externalSurface.updateSurfaceTexture(this.updateSurfaceCallback);
    }
}
