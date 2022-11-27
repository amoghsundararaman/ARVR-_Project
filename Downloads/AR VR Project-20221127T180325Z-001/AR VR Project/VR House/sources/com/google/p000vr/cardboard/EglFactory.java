package com.google.p000vr.cardboard;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.google.vr.cardboard.EglFactory */
public class EglFactory implements GLSurfaceView.EGLContextFactory, GLSurfaceView.EGLWindowSurfaceFactory {
    public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_CONTEXT_FLAGS_KHR = 12540;
    private static final int EGL_CONTEXT_OPENGL_DEBUG_BIT_KHR = 1;
    private static final int EGL_CONTEXT_OPENGL_NO_ERROR_KHR = 12723;
    private static final int EGL_CONTEXT_PRIORITY_HIGH = 12545;
    private static final int EGL_CONTEXT_PRIORITY_LEVEL = 12544;
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final int MIN_REQUIRED_CONTEXT_CLIENT_VERSION = 2;
    private static final String TAG = "GvrEglFactory";
    private int eglContextClientVersion = 2;
    private boolean errorReportingEnabled = true;
    private EGLContext sharedContext = EGL10.EGL_NO_CONTEXT;
    private boolean useDebug = false;
    private boolean usePriority = false;
    private boolean useProtected = false;

    public void setUsePriorityContext(boolean z) {
        this.usePriority = z;
    }

    public void setUseProtectedBuffers(boolean z) {
        if (!z || Build.VERSION.SDK_INT >= 17) {
            this.useProtected = z;
            return;
        }
        throw new RuntimeException("Protected buffer support requires EGL 1.4, available only on Jelly Bean MR1 and later.");
    }

    public void setUseDebug(boolean z) {
        this.useDebug = z;
    }

    public void setSharedContext(EGLContext eGLContext) {
        this.sharedContext = eGLContext;
    }

    public void setErrorReportingEnabled(boolean z) {
        this.errorReportingEnabled = z;
    }

    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        IntBuffer allocate = IntBuffer.allocate(10);
        allocate.put(EGL_CONTEXT_CLIENT_VERSION);
        allocate.put(this.eglContextClientVersion);
        if (this.useDebug) {
            allocate.put(EGL_CONTEXT_FLAGS_KHR);
            allocate.put(1);
        }
        if (this.usePriority) {
            if (Build.FINGERPRINT.contains("generic_x86")) {
                Log.w(TAG, "EGL_CONTEXT_PRIORITY_LEVEL not supported on emulators.");
            } else {
                allocate.put(EGL_CONTEXT_PRIORITY_LEVEL);
                allocate.put(EGL_CONTEXT_PRIORITY_HIGH);
            }
        }
        if (this.useProtected && supportsProtectedContent(egl10, eGLDisplay)) {
            allocate.put(EGL_PROTECTED_CONTENT_EXT);
            allocate.put(1);
        }
        if (!this.errorReportingEnabled && egl10.eglQueryString(eGLDisplay, 12373).contains("EGL_KHR_create_context_no_error")) {
            allocate.put(EGL_CONTEXT_OPENGL_NO_ERROR_KHR);
            allocate.put(1);
        }
        while (allocate.hasRemaining()) {
            allocate.put(12344);
        }
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, this.sharedContext, allocate.array());
        if ((eglCreateContext != null && eglCreateContext != EGL10.EGL_NO_CONTEXT) || this.eglContextClientVersion <= 2) {
            return eglCreateContext;
        }
        Log.w(TAG, new StringBuilder(65).append("Failed to create EGL context with version ").append(this.eglContextClientVersion).append(", will try 2").toString());
        allocate.array()[1] = 2;
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, this.sharedContext, allocate.array());
    }

    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }

    public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        int[] iArr;
        if (!this.useProtected || !supportsProtectedContent(egl10, eGLDisplay)) {
            iArr = null;
        } else {
            iArr = new int[]{EGL_PROTECTED_CONTENT_EXT, 1, 12344};
        }
        try {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "eglCreateWindowSurface", e);
            return null;
        }
    }

    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }

    public void setEGLContextClientVersion(int i) {
        this.eglContextClientVersion = i;
    }

    private boolean supportsProtectedContent(EGL10 egl10, EGLDisplay eGLDisplay) {
        return egl10.eglQueryString(eGLDisplay, 12373).contains("EGL_EXT_protected_content");
    }
}
