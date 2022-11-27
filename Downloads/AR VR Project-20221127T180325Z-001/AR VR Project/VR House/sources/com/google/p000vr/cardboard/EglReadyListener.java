package com.google.p000vr.cardboard;

import android.opengl.GLES20;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

@UsedByNative
/* renamed from: com.google.vr.cardboard.EglReadyListener */
public class EglReadyListener {
    private static final int DEFAULT_GL_MAJOR_VERSION = 2;
    private static final int GL_CONTEXT_FLAGS = 33310;
    private static final String TAG = "EglReadyListener";
    private final Object contextInfoLock = new Object();
    private volatile EGLContext eglContext;
    private volatile int eglContextFlags;
    private volatile int glVersion = 2;
    private volatile EventListener listener;
    private final Object listenerLock = new Object();

    /* renamed from: com.google.vr.cardboard.EglReadyListener$EventListener */
    public interface EventListener {
        void onEglReady();
    }

    public void setEventListener(EventListener eventListener) {
        synchronized (this.listenerLock) {
            this.listener = eventListener;
        }
    }

    public void releaseEventListener() {
        synchronized (this.listenerLock) {
            this.listener = null;
        }
    }

    @UsedByNative
    public void onEglReady() {
        synchronized (this.contextInfoLock) {
            this.eglContext = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
            if (this.eglContext == null || this.eglContext == EGL10.EGL_NO_CONTEXT) {
                Log.e(TAG, "Unable to obtain the application's OpenGL context.");
            }
            this.glVersion = parseVersionString(GLES20.glGetString(7938));
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(GL_CONTEXT_FLAGS, iArr, 0);
            GLES20.glGetError();
            this.eglContextFlags = iArr[0];
        }
        synchronized (this.listenerLock) {
            if (this.listener != null) {
                this.listener.onEglReady();
            }
        }
    }

    public void clearContext() {
        synchronized (this.contextInfoLock) {
            this.eglContext = null;
            this.glVersion = 2;
            this.eglContextFlags = 0;
        }
    }

    public EGLContext getEGLContext() {
        return this.eglContext;
    }

    public int getEGLContextFlags() {
        return this.eglContextFlags;
    }

    public int getGLVersion() {
        return this.glVersion;
    }

    public static int parseVersionString(String str) {
        if (str == null) {
            Log.e(TAG, "Unable to determine the OpenGL major version.");
            return 2;
        }
        int indexOf = str.indexOf(46);
        if (indexOf <= 0) {
            Log.e(TAG, "Unable to determine the OpenGL major version.");
            return 2;
        }
        int numericValue = Character.getNumericValue(str.charAt(indexOf - 1));
        if (numericValue >= 0) {
            return numericValue;
        }
        Log.e(TAG, "Unable to determine the OpenGL major version.");
        return 2;
    }
}
