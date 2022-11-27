package com.vuforia;

import android.app.Activity;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Vuforia {
    public static final int GL_20 = 1;
    public static final int GL_30 = 8;
    public static final int INIT_DEVICE_NOT_SUPPORTED = -2;
    public static final int INIT_ERROR = -1;
    public static final int INIT_EXTERNAL_DEVICE_NOT_DETECTED = -10;
    public static final int INIT_LICENSE_ERROR_CANCELED_KEY = -8;
    public static final int INIT_LICENSE_ERROR_INVALID_KEY = -5;
    public static final int INIT_LICENSE_ERROR_MISSING_KEY = -4;
    public static final int INIT_LICENSE_ERROR_NO_NETWORK_PERMANENT = -6;
    public static final int INIT_LICENSE_ERROR_NO_NETWORK_TRANSIENT = -7;
    public static final int INIT_LICENSE_ERROR_PRODUCT_TYPE_MISMATCH = -9;
    public static final int INIT_NO_CAMERA_ACCESS = -3;
    private static boolean initializedJava = false;
    private static UpdateCallback sUpdateCallback = null;
    /* access modifiers changed from: private */
    public static UpdateCallbackInterface sUpdateCallbackInterface = null;
    protected static Map<Integer, Object> sUserDataMap = new ConcurrentHashMap(16, 0.75f, 4);

    public interface UpdateCallbackInterface {
        void Vuforia_onUpdate(State state);
    }

    private static native void privateSetInitParameters(Activity activity, int i, String str);

    protected static short[] convertStringToShortArray(String str) {
        if (str == null) {
            return null;
        }
        short[] sArr = new short[(str.codePointCount(0, str.length()) + 1)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt > 65535) {
                sArr[i2] = (short) (codePointAt >> 16);
                i2++;
            }
            sArr[i2] = (short) codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        sArr[sArr.length - 1] = 0;
        return sArr;
    }

    protected static boolean wasInitializedJava() {
        return initializedJava;
    }

    protected static void setHint() {
        setHint(-858996736, 2796202);
    }

    public static void setInitParameters(Activity activity, int i, String str) {
        if (!initializedJava) {
            setHint();
            initializedJava = true;
        }
        privateSetInitParameters(activity, i, str);
    }

    private static boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            PrintStream printStream = System.out;
            printStream.println("Native library lib" + str + ".so loaded");
            return true;
        } catch (UnsatisfiedLinkError unused) {
            PrintStream printStream2 = System.err;
            printStream2.println("The library lib" + str + ".so could not be loaded");
            return false;
        } catch (SecurityException unused2) {
            PrintStream printStream3 = System.err;
            printStream3.println("The library lib" + str + ".so was not allowed to be loaded");
            return false;
        }
    }

    static {
        if (!loadLibrary("Vuforia")) {
            System.exit(1);
        }
    }

    protected static UpdateCallback registerLocalReference(UpdateCallbackInterface updateCallbackInterface) {
        if (updateCallbackInterface == null) {
            sUpdateCallback = null;
            sUpdateCallbackInterface = null;
            return null;
        }
        sUpdateCallbackInterface = updateCallbackInterface;
        sUpdateCallback = new UpdateCallback() {
            public void Vuforia_onUpdate(State state) {
                Vuforia.sUpdateCallbackInterface.Vuforia_onUpdate(state);
                state.delete();
            }
        };
        return sUpdateCallback;
    }

    protected static boolean updateUserDataMap(Integer num, Object obj) {
        if (num == null) {
            return false;
        }
        if (obj == null) {
            sUserDataMap.remove(num);
            return true;
        }
        sUserDataMap.put(num, obj);
        return true;
    }

    protected static Object retrieveFromUserDataMap(Integer num) {
        if (!sUserDataMap.containsKey(num)) {
            return null;
        }
        return sUserDataMap.get(num);
    }

    public static boolean setDriverLibrary(String str) {
        return VuforiaJNI.setDriverLibrary(str);
    }

    public static int init() {
        return VuforiaJNI.init();
    }

    public static boolean isInitialized() {
        return VuforiaJNI.isInitialized();
    }

    public static void deinit() {
        VuforiaJNI.deinit();
    }

    public static int setAllowedFusionProviders(int i) {
        return VuforiaJNI.setAllowedFusionProviders(i);
    }

    public static int getActiveFusionProvider() {
        return VuforiaJNI.getActiveFusionProvider();
    }

    public static boolean setHint(long j, int i) {
        return VuforiaJNI.setHint(j, i);
    }

    public static void registerCallback(UpdateCallbackInterface updateCallbackInterface) {
        VuforiaJNI.registerCallback(UpdateCallback.getCPtr(registerLocalReference(updateCallbackInterface)), sUpdateCallback);
    }

    public static boolean setFrameFormat(int i, boolean z) {
        return VuforiaJNI.setFrameFormat(i, z);
    }

    public static int getBitsPerPixel(int i) {
        return VuforiaJNI.getBitsPerPixel(i);
    }

    public static boolean requiresAlpha() {
        return VuforiaJNI.requiresAlpha();
    }

    public static int getBufferSize(int i, int i2, int i3) {
        return VuforiaJNI.getBufferSize(i, i2, i3);
    }

    public static void onResume() {
        VuforiaJNI.onResume();
    }

    public static void onPause() {
        VuforiaJNI.onPause();
    }

    public static void onSurfaceCreated() {
        VuforiaJNI.onSurfaceCreated();
    }

    public static void onSurfaceChanged(int i, int i2) {
        VuforiaJNI.onSurfaceChanged(i, i2);
    }

    public static String getLibraryVersion() {
        return VuforiaJNI.getLibraryVersion();
    }

    public static String getBuildVersion() {
        return VuforiaJNI.getBuildVersion();
    }
}
