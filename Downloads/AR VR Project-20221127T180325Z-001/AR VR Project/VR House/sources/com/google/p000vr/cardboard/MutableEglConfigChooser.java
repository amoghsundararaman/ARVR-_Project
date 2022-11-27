package com.google.p000vr.cardboard;

import android.opengl.GLSurfaceView;
import android.os.Build;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.google.vr.cardboard.MutableEglConfigChooser */
public class MutableEglConfigChooser implements GLSurfaceView.EGLConfigChooser {
    private static final int EGL_MUTABLE_RENDER_BUFFER_BIT = 4096;
    private static final int EGL_OPENGL_ES3_BIT_KHR = 64;
    private static final boolean IS_EMULATOR = Build.FINGERPRINT.contains("generic_x86");
    private boolean forceMutableBuffer = true;

    public MutableEglConfigChooser() {
    }

    public MutableEglConfigChooser(boolean z) {
        this.forceMutableBuffer = z;
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12352, EGL_OPENGL_ES3_BIT_KHR, 12339, 4100, 12344};
        int[] iArr2 = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, iArr, (EGLConfig[]) null, 0, iArr2) || !this.forceMutableBuffer || IS_EMULATOR) {
            iArr[15] = 4;
            if (!egl10.eglChooseConfig(eGLDisplay, iArr, (EGLConfig[]) null, 0, iArr2)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr2[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr, this.forceMutableBuffer);
            if (chooseConfig != null) {
                return chooseConfig;
            }
            throw new IllegalArgumentException("No config chosen");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }

    private static EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, boolean z) {
        if (IS_EMULATOR) {
            return eGLConfigArr[0];
        }
        int length = eGLConfigArr.length;
        for (int i = 0; i < length; i++) {
            EGLConfig eGLConfig = eGLConfigArr[i];
            int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
            int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
            int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
            int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
            int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12339, 0);
            if (findConfigAttrib3 == 8 && findConfigAttrib4 == 8 && findConfigAttrib5 == 8 && findConfigAttrib == 0 && findConfigAttrib2 == 0 && (!z || (findConfigAttrib6 & EGL_MUTABLE_RENDER_BUFFER_BIT) != 0)) {
                return eGLConfig;
            }
        }
        return null;
    }

    private static int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        int[] iArr = new int[1];
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr)) {
            return iArr[0];
        }
        return i2;
    }
}
