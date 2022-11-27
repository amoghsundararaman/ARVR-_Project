package com.google.p000vr.ndk.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.p000vr.cardboard.EglFactory;
import com.google.p000vr.cardboard.EglReadyListener;
import com.google.p000vr.cardboard.IsEmulator;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* renamed from: com.google.vr.ndk.base.GvrSurfaceView */
public class GvrSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final int GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR = 8;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final int SWAPMODE_MANUAL = 2;
    public static final int SWAPMODE_QUEUED = 0;
    public static final int SWAPMODE_SINGLE = 1;
    private static final String TAG = "GvrSurfaceView";
    /* access modifiers changed from: private */
    public EglReadyListener mAppContextListener;
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public GLSurfaceView.EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public GLSurfaceView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    private boolean mPreserveGlThreadOnDetachedFromWindow;
    /* access modifiers changed from: private */
    public GLSurfaceView.Renderer mRenderer;
    private final WeakReference<GvrSurfaceView> mThisWeakRef = new WeakReference<>(this);

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$DefaultContextFactory */
    private class DefaultContextFactory implements GLSurfaceView.EGLContextFactory {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private DefaultContextFactory() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, GvrSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GvrSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                String valueOf = String.valueOf(eGLDisplay);
                String valueOf2 = String.valueOf(eGLContext);
                Log.e("DefaultContextFactory", new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("display:").append(valueOf).append(" context: ").append(valueOf2).toString());
                EglHelper.throwEglException("eglDestroyContext", egl10.eglGetError());
            }
        }
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$DefaultWindowSurfaceFactory */
    private static class DefaultWindowSurfaceFactory implements GLSurfaceView.EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                Log.e(GvrSurfaceView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$GLWrapper */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$SimpleEGLConfigChooser */
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SimpleEGLConfigChooser(com.google.p000vr.ndk.base.GvrSurfaceView r9, boolean r10) {
            /*
                r8 = this;
                r2 = 8
                r5 = 0
                if (r10 == 0) goto L_0x0010
                r6 = 16
            L_0x0007:
                r0 = r8
                r1 = r9
                r3 = r2
                r4 = r2
                r7 = r5
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return
            L_0x0010:
                r6 = r5
                goto L_0x0007
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.GvrSurfaceView.SimpleEGLConfigChooser.<init>(com.google.vr.ndk.base.GvrSurfaceView, boolean):void");
        }
    }

    public GvrSurfaceView(Context context) {
        super(context);
        init();
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$LogWriter */
    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GvrSurfaceView.TAG, this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
            }
        }
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$BaseConfigChooser */
    private abstract class BaseConfigChooser implements GLSurfaceView.EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, (EGLConfig[]) null, 0, iArr)) {
                for (int i = 1; i < this.mConfigSpec.length; i++) {
                    if (this.mConfigSpec[i - 1] == 12352 && this.mConfigSpec[i] == 64) {
                        Log.w(GvrSurfaceView.TAG, "Failed to choose GLES 3 config, will try 2.");
                        this.mConfigSpec[i] = 4;
                        return chooseConfig(egl10, eGLDisplay);
                    }
                }
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i2 = iArr[0];
            if (i2 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i2];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i2, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig != null) {
                return chooseConfig;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GvrSurfaceView.this.mEGLContextClientVersion != 2 && GvrSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            System.arraycopy(iArr, 0, iArr2, 0, length - 1);
            iArr2[length - 1] = 12352;
            if (GvrSurfaceView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$EglHelper */
    private static class EglHelper {
        public static final int EGL_FRONT_BUFFER_AUTO_REFRESH = 12620;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        EGLContext mPendingEglContext;
        EGLDisplay mPendingEglDisplay;

        public EglHelper(WeakReference<GvrSurfaceView> weakReference) {
            this.mGvrSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            if (this.mEgl == null) {
                initialize();
            }
            if (this.mEglContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.mPendingEglContext == null) {
                createPendingEglContext();
            }
            this.mEglContext = this.mPendingEglContext;
            this.mEglDisplay = this.mPendingEglDisplay;
            this.mPendingEglContext = null;
            this.mPendingEglDisplay = null;
        }

        public void renewPendingEglContext() {
            if (this.mEgl == null) {
                initialize();
            }
            if (this.mPendingEglContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, this.mPendingEglContext);
            }
            createPendingEglContext();
        }

        private void initialize() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            this.mEglSurface = null;
        }

        private void createPendingEglContext() {
            EGLContext createContext;
            EGLContext eGLContext;
            this.mPendingEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mPendingEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.mEgl.eglInitialize(this.mPendingEglDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
            if (gvrSurfaceView == null) {
                this.mEglConfig = null;
                createContext = null;
            } else {
                if (gvrSurfaceView.mAppContextListener != null) {
                    EGLContext eGLContext2 = gvrSurfaceView.mAppContextListener.getEGLContext();
                    if (eGLContext2 == null || eGLContext2 == EGL10.EGL_NO_CONTEXT) {
                        throwEglException("Unable to obtain application's OpenGL context.");
                    } else {
                        EglFactory eglFactory = (EglFactory) gvrSurfaceView.mEGLContextFactory;
                        int eGLContextFlags = gvrSurfaceView.mAppContextListener.getEGLContextFlags();
                        eglFactory.setSharedContext(eGLContext2);
                        eglFactory.setErrorReportingEnabled((eGLContextFlags & 8) == 0);
                        eglFactory.setEGLContextClientVersion(gvrSurfaceView.mAppContextListener.getGLVersion());
                    }
                }
                this.mEglConfig = gvrSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mPendingEglDisplay);
                createContext = gvrSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mPendingEglDisplay, this.mEglConfig);
            }
            if (createContext == null || createContext == EGL10.EGL_NO_CONTEXT) {
                int eglGetError = this.mEgl.eglGetError();
                if (eglGetError == 12294) {
                    Log.e("EglHelper", "Stashed EGL context has become invalid and can no longer be used for sharing.");
                    this.mPendingEglContext = null;
                    this.mPendingEglDisplay = null;
                    this.mEglConfig = null;
                    if (gvrSurfaceView.mAppContextListener != null) {
                        gvrSurfaceView.mAppContextListener.clearContext();
                        return;
                    }
                    return;
                }
                throwEglException("createPendingEglContext", eglGetError);
                eGLContext = null;
            } else {
                eGLContext = createContext;
            }
            this.mPendingEglContext = eGLContext;
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                destroySurfaceImp();
                GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    this.mEglSurface = gvrSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gvrSurfaceView.getHolder());
                } else {
                    this.mEglSurface = null;
                }
                if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                    return true;
                } else {
                    logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                    return false;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            LogWriter logWriter;
            GL gl = this.mEglContext.getGL();
            GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
            if (gvrSurfaceView == null) {
                return gl;
            }
            if (gvrSurfaceView.mGLWrapper != null) {
                gl = gvrSurfaceView.mGLWrapper.wrap(gl);
            }
            if ((gvrSurfaceView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            if ((gvrSurfaceView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((gvrSurfaceView.mDebugFlags & 2) != 0) {
                logWriter = new LogWriter();
            } else {
                logWriter = null;
            }
            return GLDebugHelper.wrap(gl, i, logWriter);
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return 12288;
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void setEglSurfaceAttrib(int i, int i2) {
            if (Build.VERSION.SDK_INT < 17) {
                Log.e("EglHelper", "Cannot call eglSurfaceAttrib. API version is too low.");
            } else if (!EGL14.eglSurfaceAttrib(EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377), i, i2)) {
                Log.e("EglHelper", new StringBuilder(66).append("eglSurfaceAttrib() failed. attribute=").append(i).append(" value=").append(i2).toString());
            }
        }

        private void destroySurfaceImp() {
            if (this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    gvrSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    gvrSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        public static String formatEglError(String str, int i) {
            String errorString = getErrorString(i);
            return new StringBuilder(String.valueOf(str).length() + 9 + String.valueOf(errorString).length()).append(str).append(" failed: ").append(errorString).toString();
        }

        private static String getHex(int i) {
            String valueOf = String.valueOf(Integer.toHexString(i));
            return valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        }

        private static String getErrorString(int i) {
            switch (i) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return getHex(i);
            }
        }
    }

    public GvrSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$ComponentSizeChooser */
    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(GvrSurfaceView gvrSurfaceView, int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                return this.mValue[0];
            }
            return i2;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$GLThread */
    static class GLThread extends Thread implements EglReadyListener.EventListener {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private final GLThreadManager mGLThreadManager = new GLThreadManager();
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private int mRequestedSwapMode = 0;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;

        /* renamed from: com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager */
        private static class GLThreadManager {
            private static final String TAG = "GLThreadManager";

            private GLThreadManager() {
            }

            public synchronized void threadExiting(GLThread gLThread) {
                boolean unused = gLThread.mExited = true;
                notifyAll();
            }

            public void releaseEglContextLocked(GLThread gLThread) {
                notifyAll();
            }
        }

        GLThread(WeakReference<GvrSurfaceView> weakReference) {
            this.mGvrSurfaceViewWeakRef = weakReference;
            GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) weakReference.get();
            if (gvrSurfaceView != null && gvrSurfaceView.mAppContextListener != null) {
                gvrSurfaceView.mAppContextListener.setEventListener(this);
            }
        }

        public void onEglReady() {
            synchronized (this.mGLThreadManager) {
                this.mEglHelper.renewPendingEglContext();
                this.mGLThreadManager.notifyAll();
            }
        }

        public void run() {
            setName(new StringBuilder(29).append("GLThread ").append(getId()).toString());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } finally {
                this.mGLThreadManager.threadExiting(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                this.mGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:116:0x020d, code lost:
            if (r3 == false) goto L_0x0363;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0217, code lost:
            if (r21.mEglHelper.createSurface() == false) goto L_0x0312;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0219, code lost:
            r3 = r21.mGLThreadManager;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x021d, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            r21.mFinishedCreatingEglSurface = true;
            r21.mGLThreadManager.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x022a, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x022b, code lost:
            r4 = false;
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x022f, code lost:
            if (r14 == false) goto L_0x023e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
            r14 = false;
            r16 = (javax.microedition.khronos.opengles.GL10) r21.mEglHelper.createGL();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x023e, code lost:
            if (r15 == false) goto L_0x0264;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0240, code lost:
            r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r21.mGvrSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x024a, code lost:
            if (r2 == null) goto L_0x0263;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
            com.google.p000vr.ndk.base.TraceCompat.beginSection("onSurfaceCreated");
            com.google.p000vr.ndk.base.GvrSurfaceView.access$1000(r2).onSurfaceCreated(r16, r21.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
            com.google.p000vr.ndk.base.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0263, code lost:
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0264, code lost:
            if (r12 == false) goto L_0x0284;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0266, code lost:
            r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r21.mGvrSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0270, code lost:
            if (r2 == null) goto L_0x0283;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
            com.google.p000vr.ndk.base.TraceCompat.beginSection("onSurfaceChanged");
            com.google.p000vr.ndk.base.GvrSurfaceView.access$1000(r2).onSurfaceChanged(r16, r7, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
            com.google.p000vr.ndk.base.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0283, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0284, code lost:
            if (r8 == false) goto L_0x02ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x0286, code lost:
            r17 = r21.mEglHelper;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x028f, code lost:
            if (r3 != 1) goto L_0x034f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0291, code lost:
            r2 = 12421;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0293, code lost:
            r17.setEglSurfaceAttrib(12422, r2);
            r17 = r21.mEglHelper;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x02a3, code lost:
            if (r3 != 1) goto L_0x0353;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a5, code lost:
            r2 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x02a6, code lost:
            r17.setEglSurfaceAttrib(com.google.p000vr.ndk.base.GvrSurfaceView.EglHelper.EGL_FRONT_BUFFER_AUTO_REFRESH, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x02ad, code lost:
            r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r21.mGvrSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b7, code lost:
            if (r2 == null) goto L_0x02ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
            com.google.p000vr.ndk.base.TraceCompat.beginSection("onDrawFrame");
            com.google.p000vr.ndk.base.GvrSurfaceView.access$1000(r2).onDrawFrame(r16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
            com.google.p000vr.ndk.base.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x02ca, code lost:
            if (r8 != false) goto L_0x02ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x02cc, code lost:
            if (r3 != 0) goto L_0x02fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x02ce, code lost:
            r2 = r21.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d6, code lost:
            switch(r2) {
                case 12288: goto L_0x02fa;
                case 12302: goto L_0x035b;
                default: goto L_0x02d9;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x02d9, code lost:
            com.google.p000vr.ndk.base.GvrSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x02e4, code lost:
            if (r3 != 0) goto L_0x02fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x02e6, code lost:
            r17 = r21.mGLThreadManager;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x02ec, code lost:
            monitor-enter(r17);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
            r21.mSurfaceIsBad = true;
            r21.mGLThreadManager.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x02f9, code lost:
            monitor-exit(r17);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x02fa, code lost:
            if (r11 == false) goto L_0x036e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x02fc, code lost:
            r20 = r5;
            r5 = r7;
            r7 = r8;
            r8 = r9;
            r9 = true;
            r10 = false;
            r11 = r12;
            r12 = r13;
            r13 = r14;
            r14 = r4;
            r4 = r6;
            r6 = r3;
            r3 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0312, code lost:
            r4 = r21.mGLThreadManager;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0316, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
            r21.mFinishedCreatingEglSurface = true;
            r21.mSurfaceIsBad = true;
            r21.mGLThreadManager.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0330, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0331, code lost:
            r4 = r6;
            r6 = r2;
            r20 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r12;
            r12 = r13;
            r13 = r14;
            r14 = r3;
            r3 = r5;
            r5 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x034f, code lost:
            r2 = 12420;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0353, code lost:
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x035b, code lost:
            r13 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x0363, code lost:
            r4 = r3;
            r3 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x036e, code lost:
            r20 = r5;
            r5 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r12;
            r12 = r13;
            r13 = r14;
            r14 = r4;
            r4 = r6;
            r6 = r3;
            r3 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
            if (r5 == null) goto L_0x020d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r5.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0080, code lost:
            r4 = r6;
            r6 = r2;
            r20 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r12;
            r12 = r13;
            r13 = r14;
            r14 = r3;
            r3 = null;
            r5 = r20;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r21 = this;
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r2 = new com.google.vr.ndk.base.GvrSurfaceView$EglHelper
                r0 = r21
                java.lang.ref.WeakReference<com.google.vr.ndk.base.GvrSurfaceView> r3 = r0.mGvrSurfaceViewWeakRef
                r2.<init>(r3)
                r0 = r21
                r0.mEglHelper = r2
                r2 = 0
                r0 = r21
                r0.mHaveEglContext = r2
                r2 = 0
                r0 = r21
                r0.mHaveEglSurface = r2
                r2 = 0
                r0 = r21
                r0.mWantRenderNotification = r2
                r4 = 0
                r15 = 0
                r3 = 0
                r14 = 0
                r13 = 0
                r12 = 0
                r11 = 0
                r10 = 0
                r9 = 0
                r8 = 0
                r2 = 0
                r7 = 0
                r6 = 0
                r5 = 0
                r16 = r4
                r4 = r6
                r6 = r2
                r20 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r13
                r13 = r14
                r14 = r3
                r3 = r5
                r5 = r20
            L_0x003b:
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r0.mGLThreadManager     // Catch:{ all -> 0x01e9 }
                r17 = r0
                monitor-enter(r17)     // Catch:{ all -> 0x01e9 }
            L_0x0042:
                r0 = r21
                boolean r2 = r0.mShouldExit     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0059
                monitor-exit(r17)     // Catch:{ all -> 0x01e6 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r3 = r0.mGLThreadManager
                monitor-enter(r3)
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x0056 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x0056 }
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                return
            L_0x0056:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                throw r2
            L_0x0059:
                r0 = r21
                java.util.ArrayList<java.lang.Runnable> r2 = r0.mEventQueue     // Catch:{ all -> 0x01e6 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x01e6 }
                if (r2 != 0) goto L_0x0091
                r0 = r21
                java.util.ArrayList<java.lang.Runnable> r2 = r0.mEventQueue     // Catch:{ all -> 0x01e6 }
                r3 = 0
                java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x01e6 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x01e6 }
                r3 = r14
                r14 = r13
                r13 = r12
                r12 = r11
                r11 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                r7 = r5
                r5 = r2
                r2 = r6
                r6 = r4
            L_0x007a:
                monitor-exit(r17)     // Catch:{ all -> 0x01e6 }
                if (r5 == 0) goto L_0x020d
                r5.run()     // Catch:{ all -> 0x01e9 }
                r5 = 0
                r4 = r6
                r6 = r2
                r20 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r13
                r13 = r14
                r14 = r3
                r3 = r5
                r5 = r20
                goto L_0x003b
            L_0x0091:
                r2 = 0
                r0 = r21
                boolean r0 = r0.mPaused     // Catch:{ all -> 0x01e6 }
                r18 = r0
                r0 = r21
                boolean r0 = r0.mRequestPaused     // Catch:{ all -> 0x01e6 }
                r19 = r0
                r0 = r18
                r1 = r19
                if (r0 == r1) goto L_0x00bd
                r0 = r21
                boolean r2 = r0.mRequestPaused     // Catch:{ all -> 0x01e6 }
                r0 = r21
                boolean r0 = r0.mRequestPaused     // Catch:{ all -> 0x01e6 }
                r18 = r0
                r0 = r18
                r1 = r21
                r1.mPaused = r0     // Catch:{ all -> 0x01e6 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r18 = r0
                r18.notifyAll()     // Catch:{ all -> 0x01e6 }
            L_0x00bd:
                r0 = r21
                boolean r0 = r0.mShouldReleaseEglContext     // Catch:{ all -> 0x01e6 }
                r18 = r0
                if (r18 == 0) goto L_0x00d1
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x01e6 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x01e6 }
                r8 = 0
                r0 = r21
                r0.mShouldReleaseEglContext = r8     // Catch:{ all -> 0x01e6 }
                r8 = 1
            L_0x00d1:
                if (r12 == 0) goto L_0x00da
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x01e6 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x01e6 }
                r12 = 0
            L_0x00da:
                if (r2 == 0) goto L_0x00e7
                r0 = r21
                boolean r0 = r0.mHaveEglSurface     // Catch:{ all -> 0x01e6 }
                r18 = r0
                if (r18 == 0) goto L_0x00e7
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x01e6 }
            L_0x00e7:
                if (r2 == 0) goto L_0x0101
                r0 = r21
                boolean r2 = r0.mHaveEglContext     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0101
                r0 = r21
                java.lang.ref.WeakReference<com.google.vr.ndk.base.GvrSurfaceView> r2 = r0.mGvrSurfaceViewWeakRef     // Catch:{ all -> 0x01e6 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01e6 }
                com.google.vr.ndk.base.GvrSurfaceView r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r2     // Catch:{ all -> 0x01e6 }
                if (r2 != 0) goto L_0x01c2
                r2 = 0
            L_0x00fc:
                if (r2 != 0) goto L_0x0101
                r21.stopEglContextLocked()     // Catch:{ all -> 0x01e6 }
            L_0x0101:
                r0 = r21
                boolean r2 = r0.mHasSurface     // Catch:{ all -> 0x01e6 }
                if (r2 != 0) goto L_0x0127
                r0 = r21
                boolean r2 = r0.mWaitingForSurface     // Catch:{ all -> 0x01e6 }
                if (r2 != 0) goto L_0x0127
                r0 = r21
                boolean r2 = r0.mHaveEglSurface     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0116
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x01e6 }
            L_0x0116:
                r2 = 1
                r0 = r21
                r0.mWaitingForSurface = r2     // Catch:{ all -> 0x01e6 }
                r2 = 0
                r0 = r21
                r0.mSurfaceIsBad = r2     // Catch:{ all -> 0x01e6 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r2.notifyAll()     // Catch:{ all -> 0x01e6 }
            L_0x0127:
                r0 = r21
                boolean r2 = r0.mHasSurface     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x013f
                r0 = r21
                boolean r2 = r0.mWaitingForSurface     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x013f
                r2 = 0
                r0 = r21
                r0.mWaitingForSurface = r2     // Catch:{ all -> 0x01e6 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r2.notifyAll()     // Catch:{ all -> 0x01e6 }
            L_0x013f:
                if (r9 == 0) goto L_0x0153
                r2 = 0
                r0 = r21
                r0.mWantRenderNotification = r2     // Catch:{ all -> 0x01e6 }
                r9 = 0
                r2 = 1
                r0 = r21
                r0.mRenderComplete = r2     // Catch:{ all -> 0x01e6 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r2.notifyAll()     // Catch:{ all -> 0x01e6 }
            L_0x0153:
                boolean r2 = r21.readyToDraw()     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0204
                r0 = r21
                boolean r2 = r0.mHaveEglContext     // Catch:{ all -> 0x01e6 }
                if (r2 != 0) goto L_0x0162
                if (r8 == 0) goto L_0x01c8
                r8 = 0
            L_0x0162:
                r0 = r21
                boolean r2 = r0.mHaveEglContext     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0176
                r0 = r21
                boolean r2 = r0.mHaveEglSurface     // Catch:{ all -> 0x01e6 }
                if (r2 != 0) goto L_0x0176
                r2 = 1
                r0 = r21
                r0.mHaveEglSurface = r2     // Catch:{ all -> 0x01e6 }
                r14 = 1
                r13 = 1
                r11 = 1
            L_0x0176:
                r0 = r21
                boolean r2 = r0.mHaveEglSurface     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0204
                r0 = r21
                boolean r2 = r0.mSizeChanged     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x036a
                r11 = 1
                r0 = r21
                int r4 = r0.mWidth     // Catch:{ all -> 0x01e6 }
                r0 = r21
                int r2 = r0.mHeight     // Catch:{ all -> 0x01e6 }
                r5 = 1
                r0 = r21
                r0.mWantRenderNotification = r5     // Catch:{ all -> 0x01e6 }
                r14 = 1
                r5 = 0
                r0 = r21
                r0.mSizeChanged = r5     // Catch:{ all -> 0x01e6 }
            L_0x0196:
                r5 = 0
                r0 = r21
                r0.mRequestRender = r5     // Catch:{ all -> 0x01e6 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r5 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r5.notifyAll()     // Catch:{ all -> 0x01e6 }
                r0 = r21
                boolean r5 = r0.mWantRenderNotification     // Catch:{ all -> 0x01e6 }
                if (r5 == 0) goto L_0x0367
                r7 = 1
            L_0x01a9:
                r0 = r21
                int r5 = r0.mRequestedSwapMode     // Catch:{ all -> 0x01e6 }
                if (r5 == r6) goto L_0x0202
                r6 = 1
            L_0x01b0:
                r0 = r21
                int r5 = r0.mRequestedSwapMode     // Catch:{ all -> 0x01e6 }
                r10 = r9
                r9 = r8
                r8 = r6
                r6 = r2
                r2 = r5
                r5 = r3
                r3 = r14
                r14 = r13
                r13 = r12
                r12 = r11
                r11 = r7
                r7 = r4
                goto L_0x007a
            L_0x01c2:
                boolean r2 = r2.mPreserveEGLContextOnPause     // Catch:{ all -> 0x01e6 }
                goto L_0x00fc
            L_0x01c8:
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r2 = r0.mEglHelper     // Catch:{ RuntimeException -> 0x01f7 }
                r2.start()     // Catch:{ RuntimeException -> 0x01f7 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r2 = r0.mEglHelper     // Catch:{ all -> 0x01e6 }
                javax.microedition.khronos.egl.EGLContext r2 = r2.mEglContext     // Catch:{ all -> 0x01e6 }
                if (r2 == 0) goto L_0x0162
                r2 = 1
                r0 = r21
                r0.mHaveEglContext = r2     // Catch:{ all -> 0x01e6 }
                r15 = 1
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r2.notifyAll()     // Catch:{ all -> 0x01e6 }
                goto L_0x0162
            L_0x01e6:
                r2 = move-exception
                monitor-exit(r17)     // Catch:{ all -> 0x01e6 }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x01e9:
                r2 = move-exception
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r3 = r0.mGLThreadManager
                monitor-enter(r3)
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x0360 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x0360 }
                monitor-exit(r3)     // Catch:{ all -> 0x0360 }
                throw r2
            L_0x01f7:
                r2 = move-exception
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r3 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r0 = r21
                r3.releaseEglContextLocked(r0)     // Catch:{ all -> 0x01e6 }
                throw r2     // Catch:{ all -> 0x01e6 }
            L_0x0202:
                r6 = 0
                goto L_0x01b0
            L_0x0204:
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x01e6 }
                r2.wait()     // Catch:{ all -> 0x01e6 }
                goto L_0x0042
            L_0x020d:
                if (r3 == 0) goto L_0x0363
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r4 = r0.mEglHelper     // Catch:{ all -> 0x01e9 }
                boolean r4 = r4.createSurface()     // Catch:{ all -> 0x01e9 }
                if (r4 == 0) goto L_0x0312
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r3 = r0.mGLThreadManager     // Catch:{ all -> 0x01e9 }
                monitor-enter(r3)     // Catch:{ all -> 0x01e9 }
                r2 = 1
                r0 = r21
                r0.mFinishedCreatingEglSurface = r2     // Catch:{ all -> 0x030f }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x030f }
                r2.notifyAll()     // Catch:{ all -> 0x030f }
                monitor-exit(r3)     // Catch:{ all -> 0x030f }
                r3 = 0
                r2 = 0
                r4 = r3
                r3 = r2
            L_0x022f:
                if (r14 == 0) goto L_0x023e
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r2 = r0.mEglHelper     // Catch:{ all -> 0x01e9 }
                javax.microedition.khronos.opengles.GL r2 = r2.createGL()     // Catch:{ all -> 0x01e9 }
                javax.microedition.khronos.opengles.GL10 r2 = (javax.microedition.khronos.opengles.GL10) r2     // Catch:{ all -> 0x01e9 }
                r14 = 0
                r16 = r2
            L_0x023e:
                if (r15 == 0) goto L_0x0264
                r0 = r21
                java.lang.ref.WeakReference<com.google.vr.ndk.base.GvrSurfaceView> r2 = r0.mGvrSurfaceViewWeakRef     // Catch:{ all -> 0x01e9 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01e9 }
                com.google.vr.ndk.base.GvrSurfaceView r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r2     // Catch:{ all -> 0x01e9 }
                if (r2 == 0) goto L_0x0263
                java.lang.String r15 = "onSurfaceCreated"
                com.google.p000vr.ndk.base.TraceCompat.beginSection(r15)     // Catch:{ all -> 0x0345 }
                android.opengl.GLSurfaceView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0345 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r15 = r0.mEglHelper     // Catch:{ all -> 0x0345 }
                javax.microedition.khronos.egl.EGLConfig r15 = r15.mEglConfig     // Catch:{ all -> 0x0345 }
                r0 = r16
                r2.onSurfaceCreated(r0, r15)     // Catch:{ all -> 0x0345 }
                com.google.p000vr.ndk.base.TraceCompat.endSection()     // Catch:{ all -> 0x01e9 }
            L_0x0263:
                r15 = 0
            L_0x0264:
                if (r12 == 0) goto L_0x0284
                r0 = r21
                java.lang.ref.WeakReference<com.google.vr.ndk.base.GvrSurfaceView> r2 = r0.mGvrSurfaceViewWeakRef     // Catch:{ all -> 0x01e9 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01e9 }
                com.google.vr.ndk.base.GvrSurfaceView r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r2     // Catch:{ all -> 0x01e9 }
                if (r2 == 0) goto L_0x0283
                java.lang.String r12 = "onSurfaceChanged"
                com.google.p000vr.ndk.base.TraceCompat.beginSection(r12)     // Catch:{ all -> 0x034a }
                android.opengl.GLSurfaceView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x034a }
                r0 = r16
                r2.onSurfaceChanged(r0, r7, r6)     // Catch:{ all -> 0x034a }
                com.google.p000vr.ndk.base.TraceCompat.endSection()     // Catch:{ all -> 0x01e9 }
            L_0x0283:
                r12 = 0
            L_0x0284:
                if (r8 == 0) goto L_0x02ad
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r0 = r0.mEglHelper     // Catch:{ all -> 0x01e9 }
                r17 = r0
                r18 = 12422(0x3086, float:1.7407E-41)
                r2 = 1
                if (r3 != r2) goto L_0x034f
                r2 = 12421(0x3085, float:1.7406E-41)
            L_0x0293:
                r0 = r17
                r1 = r18
                r0.setEglSurfaceAttrib(r1, r2)     // Catch:{ all -> 0x01e9 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r0 = r0.mEglHelper     // Catch:{ all -> 0x01e9 }
                r17 = r0
                r18 = 12620(0x314c, float:1.7684E-41)
                r2 = 1
                if (r3 != r2) goto L_0x0353
                r2 = 1
            L_0x02a6:
                r0 = r17
                r1 = r18
                r0.setEglSurfaceAttrib(r1, r2)     // Catch:{ all -> 0x01e9 }
            L_0x02ad:
                r0 = r21
                java.lang.ref.WeakReference<com.google.vr.ndk.base.GvrSurfaceView> r2 = r0.mGvrSurfaceViewWeakRef     // Catch:{ all -> 0x01e9 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01e9 }
                com.google.vr.ndk.base.GvrSurfaceView r2 = (com.google.p000vr.ndk.base.GvrSurfaceView) r2     // Catch:{ all -> 0x01e9 }
                if (r2 == 0) goto L_0x02ca
                java.lang.String r17 = "onDrawFrame"
                com.google.p000vr.ndk.base.TraceCompat.beginSection(r17)     // Catch:{ all -> 0x0356 }
                android.opengl.GLSurfaceView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0356 }
                r0 = r16
                r2.onDrawFrame(r0)     // Catch:{ all -> 0x0356 }
                com.google.p000vr.ndk.base.TraceCompat.endSection()     // Catch:{ all -> 0x01e9 }
            L_0x02ca:
                if (r8 != 0) goto L_0x02ce
                if (r3 != 0) goto L_0x02fa
            L_0x02ce:
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$EglHelper r2 = r0.mEglHelper     // Catch:{ all -> 0x01e9 }
                int r2 = r2.swap()     // Catch:{ all -> 0x01e9 }
                switch(r2) {
                    case 12288: goto L_0x02fa;
                    case 12302: goto L_0x035b;
                    default: goto L_0x02d9;
                }     // Catch:{ all -> 0x01e9 }
            L_0x02d9:
                java.lang.String r17 = "GLThread"
                java.lang.String r18 = "eglSwapBuffers"
                r0 = r17
                r1 = r18
                com.google.p000vr.ndk.base.GvrSurfaceView.EglHelper.logEglErrorAsWarning(r0, r1, r2)     // Catch:{ all -> 0x01e9 }
                if (r3 != 0) goto L_0x02fa
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r0.mGLThreadManager     // Catch:{ all -> 0x01e9 }
                r17 = r0
                monitor-enter(r17)     // Catch:{ all -> 0x01e9 }
                r2 = 1
                r0 = r21
                r0.mSurfaceIsBad = r2     // Catch:{ all -> 0x035d }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r2 = r0.mGLThreadManager     // Catch:{ all -> 0x035d }
                r2.notifyAll()     // Catch:{ all -> 0x035d }
                monitor-exit(r17)     // Catch:{ all -> 0x035d }
            L_0x02fa:
                if (r11 == 0) goto L_0x036e
                r10 = 1
                r11 = 0
                r20 = r5
                r5 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r13
                r13 = r14
                r14 = r4
                r4 = r6
                r6 = r3
                r3 = r20
                goto L_0x003b
            L_0x030f:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x030f }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x0312:
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r4 = r0.mGLThreadManager     // Catch:{ all -> 0x01e9 }
                monitor-enter(r4)     // Catch:{ all -> 0x01e9 }
                r17 = 1
                r0 = r17
                r1 = r21
                r1.mFinishedCreatingEglSurface = r0     // Catch:{ all -> 0x0342 }
                r17 = 1
                r0 = r17
                r1 = r21
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0342 }
                r0 = r21
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r0.mGLThreadManager     // Catch:{ all -> 0x0342 }
                r17 = r0
                r17.notifyAll()     // Catch:{ all -> 0x0342 }
                monitor-exit(r4)     // Catch:{ all -> 0x0342 }
                r4 = r6
                r6 = r2
                r20 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r13
                r13 = r14
                r14 = r3
                r3 = r5
                r5 = r20
                goto L_0x003b
            L_0x0342:
                r2 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0342 }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x0345:
                r2 = move-exception
                com.google.p000vr.ndk.base.TraceCompat.endSection()     // Catch:{ all -> 0x01e9 }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x034a:
                r2 = move-exception
                com.google.p000vr.ndk.base.TraceCompat.endSection()     // Catch:{ all -> 0x01e9 }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x034f:
                r2 = 12420(0x3084, float:1.7404E-41)
                goto L_0x0293
            L_0x0353:
                r2 = 0
                goto L_0x02a6
            L_0x0356:
                r2 = move-exception
                com.google.p000vr.ndk.base.TraceCompat.endSection()     // Catch:{ all -> 0x01e9 }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x035b:
                r13 = 1
                goto L_0x02fa
            L_0x035d:
                r2 = move-exception
                monitor-exit(r17)     // Catch:{ all -> 0x035d }
                throw r2     // Catch:{ all -> 0x01e9 }
            L_0x0360:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0360 }
                throw r2
            L_0x0363:
                r4 = r3
                r3 = r2
                goto L_0x022f
            L_0x0367:
                r7 = r10
                goto L_0x01a9
            L_0x036a:
                r2 = r4
                r4 = r5
                goto L_0x0196
            L_0x036e:
                r20 = r5
                r5 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r13
                r13 = r14
                r14 = r4
                r4 = r6
                r6 = r3
                r3 = r20
                goto L_0x003b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.GvrSurfaceView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            boolean z;
            GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
            EglReadyListener access$300 = gvrSurfaceView == null ? null : gvrSurfaceView.mAppContextListener;
            if (access$300 == null || access$300.getEGLContext() != null) {
                z = true;
            } else {
                z = false;
            }
            if (this.mPaused || !z || !this.mHasSurface || this.mSurfaceIsBad || this.mWidth <= 0 || this.mHeight <= 0 || (!this.mRequestRender && this.mRenderMode != 1)) {
                return false;
            }
            return true;
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.mGLThreadManager) {
                this.mRenderMode = i;
                this.mGLThreadManager.notifyAll();
            }
        }

        public void setSwapMode(int i) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("swapMode");
            }
            synchronized (this.mGLThreadManager) {
                this.mRequestedSwapMode = i;
                this.mGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.mGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public int getSwapMode() {
            int i;
            synchronized (this.mGLThreadManager) {
                i = this.mRequestedSwapMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.mGLThreadManager) {
                this.mRequestRender = true;
                this.mGLThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRenderAndWait() {
            /*
                r2 = this;
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r1 = r2.mGLThreadManager
                monitor-enter(r1)
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003a }
                if (r0 != r2) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x003a }
            L_0x000a:
                return
            L_0x000b:
                r0 = 1
                r2.mWantRenderNotification = r0     // Catch:{ all -> 0x003a }
                r0 = 1
                r2.mRequestRender = r0     // Catch:{ all -> 0x003a }
                r0 = 0
                r2.mRenderComplete = r0     // Catch:{ all -> 0x003a }
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r2.mGLThreadManager     // Catch:{ all -> 0x003a }
                r0.notifyAll()     // Catch:{ all -> 0x003a }
            L_0x0019:
                boolean r0 = r2.mExited     // Catch:{ all -> 0x003a }
                if (r0 != 0) goto L_0x003d
                boolean r0 = r2.mPaused     // Catch:{ all -> 0x003a }
                if (r0 != 0) goto L_0x003d
                boolean r0 = r2.mRenderComplete     // Catch:{ all -> 0x003a }
                if (r0 != 0) goto L_0x003d
                boolean r0 = r2.ableToDraw()     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x003d
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r2.mGLThreadManager     // Catch:{ InterruptedException -> 0x0031 }
                r0.wait()     // Catch:{ InterruptedException -> 0x0031 }
                goto L_0x0019
            L_0x0031:
                r0 = move-exception
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003a }
                r0.interrupt()     // Catch:{ all -> 0x003a }
                goto L_0x0019
            L_0x003a:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x003a }
                throw r0
            L_0x003d:
                monitor-exit(r1)     // Catch:{ all -> 0x003a }
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.GvrSurfaceView.GLThread.requestRenderAndWait():void");
        }

        public void surfaceCreated() {
            synchronized (this.mGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                this.mGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed(Runnable runnable) {
            synchronized (this.mGLThreadManager) {
                this.mHasSurface = false;
                if (runnable != null) {
                    this.mEventQueue.add(runnable);
                }
                this.mGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause(Runnable runnable) {
            synchronized (this.mGLThreadManager) {
                this.mRequestPaused = true;
                if (runnable != null) {
                    this.mEventQueue.add(runnable);
                }
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.mGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r3, int r4) {
            /*
                r2 = this;
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r1 = r2.mGLThreadManager
                monitor-enter(r1)
                r2.mWidth = r3     // Catch:{ all -> 0x003e }
                r2.mHeight = r4     // Catch:{ all -> 0x003e }
                r0 = 1
                r2.mSizeChanged = r0     // Catch:{ all -> 0x003e }
                r0 = 1
                r2.mRequestRender = r0     // Catch:{ all -> 0x003e }
                r0 = 0
                r2.mRenderComplete = r0     // Catch:{ all -> 0x003e }
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003e }
                if (r0 != r2) goto L_0x0018
                monitor-exit(r1)     // Catch:{ all -> 0x003e }
            L_0x0017:
                return
            L_0x0018:
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r2.mGLThreadManager     // Catch:{ all -> 0x003e }
                r0.notifyAll()     // Catch:{ all -> 0x003e }
            L_0x001d:
                boolean r0 = r2.mExited     // Catch:{ all -> 0x003e }
                if (r0 != 0) goto L_0x0041
                boolean r0 = r2.mPaused     // Catch:{ all -> 0x003e }
                if (r0 != 0) goto L_0x0041
                boolean r0 = r2.mRenderComplete     // Catch:{ all -> 0x003e }
                if (r0 != 0) goto L_0x0041
                boolean r0 = r2.ableToDraw()     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0041
                com.google.vr.ndk.base.GvrSurfaceView$GLThread$GLThreadManager r0 = r2.mGLThreadManager     // Catch:{ InterruptedException -> 0x0035 }
                r0.wait()     // Catch:{ InterruptedException -> 0x0035 }
                goto L_0x001d
            L_0x0035:
                r0 = move-exception
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003e }
                r0.interrupt()     // Catch:{ all -> 0x003e }
                goto L_0x001d
            L_0x003e:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x003e }
                throw r0
            L_0x0041:
                monitor-exit(r1)     // Catch:{ all -> 0x003e }
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.GvrSurfaceView.GLThread.onWindowResize(int, int):void");
        }

        public void requestExitAndWait() {
            synchronized (this.mGLThreadManager) {
                this.mShouldExit = true;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                GvrSurfaceView gvrSurfaceView = (GvrSurfaceView) this.mGvrSurfaceViewWeakRef.get();
                if (!(gvrSurfaceView == null || gvrSurfaceView.mAppContextListener == null)) {
                    gvrSurfaceView.mAppContextListener.releaseEventListener();
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            this.mGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (this.mGLThreadManager) {
                this.mEventQueue.add(runnable);
                this.mGLThreadManager.notifyAll();
            }
        }
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(this, true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    public void setEglReadyListener(EglReadyListener eglReadyListener) {
        this.mAppContextListener = eglReadyListener;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) new SimpleEGLConfigChooser(this, z));
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) new ComponentSizeChooser(this, i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setSwapMode(int i) {
        if (i != 1 || (Build.VERSION.SDK_INT >= 17 && !IsEmulator.isEmulator())) {
            this.mGLThread.setSwapMode(i);
        } else {
            Log.e(TAG, "setSwapMode(SWAPMODE_SINGLE) requires Jellybean MR1 (EGL14 dependency) and is not supported on emulators.");
        }
    }

    public void setPreserveGlThreadOnDetachedFromWindow(boolean z) {
        checkRenderThreadState();
        this.mPreserveGlThreadOnDetachedFromWindow = z;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        onSurfaceDestroyed((Runnable) null);
    }

    public void onSurfaceDestroyed(Runnable runnable) {
        this.mGLThread.surfaceDestroyed(runnable);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        this.mGLThread.requestRenderAndWait();
    }

    public void onPause() {
        this.mGLThread.onPause((Runnable) null);
    }

    public void onPause(Runnable runnable) {
        this.mGLThread.onPause(runnable);
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestExitAndWait() {
        this.mGLThread.requestExitAndWait();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i;
        int i2;
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            if (this.mGLThread != null) {
                i2 = this.mGLThread.getRenderMode();
                i = this.mGLThread.getSwapMode();
            } else {
                i = 0;
                i2 = 1;
            }
            this.mGLThread = new GLThread(this.mThisWeakRef);
            if (i2 != 1) {
                this.mGLThread.setRenderMode(i2);
            }
            if (i != 0) {
                this.mGLThread.setSwapMode(i);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.mGLThread != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public boolean isDetachedFromWindow() {
        return this.mDetached;
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
