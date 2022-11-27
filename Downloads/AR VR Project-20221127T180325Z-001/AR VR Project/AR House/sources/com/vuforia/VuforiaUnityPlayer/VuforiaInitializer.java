package com.vuforia.VuforiaUnityPlayer;

import android.app.Activity;
import com.vuforia.Vuforia;

public class VuforiaInitializer {
    private static final String NATIVE_LIB_UNITYPLAYER = "VuforiaUnityPlayer";
    private static final String NATIVE_LIB_VUFORIA = "Vuforia";
    private static final String NATIVE_LIB_VUFORIAWRAPPER = "VuforiaWrapper";

    private static native void initPlatformNative();

    public static void loadNativeLibraries() {
        loadLibrary(NATIVE_LIB_VUFORIA);
        loadLibrary(NATIVE_LIB_VUFORIAWRAPPER);
        loadLibrary(NATIVE_LIB_UNITYPLAYER);
    }

    public static void initPlatform() {
        initPlatformNative();
    }

    public static void setInitParameters(Activity activity, int i, String str) {
        Vuforia.setInitParameters(activity, i, str);
        Vuforia.setHint(-858996736, 1747626);
    }

    public static int init() {
        int init = Vuforia.init();
        if (init < 0) {
            DebugLog.LOGE("Vuforia initialization failed");
        }
        return init;
    }

    private static boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            DebugLog.LOGE("The library lib" + str + ".so could not be loaded: " + e.toString());
            return false;
        } catch (SecurityException unused) {
            DebugLog.LOGE("The library lib" + str + ".so was not allowed to be loaded");
            return false;
        }
    }
}
