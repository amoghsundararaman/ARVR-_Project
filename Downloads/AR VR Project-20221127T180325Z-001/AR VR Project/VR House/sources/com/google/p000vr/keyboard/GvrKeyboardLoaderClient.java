package com.google.p000vr.keyboard;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.p000vr.keyboard.IGvrKeyboardLoader;

/* renamed from: com.google.vr.keyboard.GvrKeyboardLoaderClient */
public class GvrKeyboardLoaderClient {
    private static final String KEYBOARD_PACKAGE = "com.google.android.vr.inputmethod";
    private static final String LOADER_NAME = "com.google.vr.keyboard.GvrKeyboardLoader";
    private static final String TAG = "GvrKeyboard";
    private static KeyboardContextWrapper staticContextWrapper = null;
    private static IGvrKeyboardLoader staticLoader = null;
    private static ClassLoader staticRemoteClassLoader = null;
    private static Context staticRemoteContext = null;

    public static long loadKeyboardSDK(Context context) {
        IGvrKeyboardLoader loader = getLoader(context);
        if (loader == null) {
            Log.e(TAG, "Couldn't find GVR keyboard SDK.");
            return 0;
        }
        try {
            return loader.loadGvrKeyboard(2);
        } catch (RemoteException e) {
            Log.e(TAG, "Couldn't load GVR keyboard SDK.", e);
            return 0;
        }
    }

    /* renamed from: com.google.vr.keyboard.GvrKeyboardLoaderClient$KeyboardContextWrapper */
    private static class KeyboardContextWrapper extends ContextWrapper {
        private final AssetManager assetManager;
        private final Context keyboardContext;

        private KeyboardContextWrapper(Context context, Context context2) {
            super(context2);
            this.keyboardContext = context;
            this.assetManager = context.getAssets();
        }

        public Object getSystemService(String str) {
            if ("layout_inflater".equals(str)) {
                return this.keyboardContext.getSystemService(str);
            }
            return super.getSystemService(str);
        }

        public Resources getResources() {
            return this.keyboardContext.getResources();
        }

        public AssetManager getAssets() {
            return this.assetManager;
        }

        public Context getApplicationContext() {
            return this;
        }

        public ClassLoader getClassLoader() {
            return this.keyboardContext.getClassLoader();
        }
    }

    public static void closeKeyboardSDK(Context context, long j) {
        IGvrKeyboardLoader loader = getLoader(context);
        if (loader != null) {
            try {
                loader.closeGvrKeyboard(j);
            } catch (RemoteException e) {
                Log.e(TAG, "Couldn't close GVR keyboard library", e);
            }
        }
    }

    private static IGvrKeyboardLoader getLoader(Context context) {
        ClassLoader remoteClassLoader;
        if (staticLoader == null && (remoteClassLoader = getRemoteClassLoader(context)) != null) {
            staticLoader = IGvrKeyboardLoader.Stub.asInterface(newBinder(remoteClassLoader, LOADER_NAME));
        }
        return staticLoader;
    }

    public static Context getRemoteContext(Context context) {
        if (staticRemoteContext == null) {
            try {
                staticRemoteContext = context.createPackageContext(KEYBOARD_PACKAGE, 3);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Couldn't find remote context", e);
            }
        }
        return staticRemoteContext;
    }

    public static Context getContextWrapper(Context context) {
        if (staticContextWrapper == null) {
            staticContextWrapper = new KeyboardContextWrapper(getRemoteContext(context), context);
        }
        return staticContextWrapper;
    }

    public static ClassLoader getRemoteClassLoader(Context context) {
        Context remoteContext;
        if (staticRemoteClassLoader == null && (remoteContext = getRemoteContext(context)) != null) {
            staticRemoteClassLoader = remoteContext.getClassLoader();
        }
        return staticRemoteClassLoader;
    }

    private static IBinder newBinder(ClassLoader classLoader, String str) {
        try {
            return (IBinder) classLoader.loadClass(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        } catch (InstantiationException e2) {
            String valueOf2 = String.valueOf(str);
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to instantiate the remote class ".concat(valueOf2) : new String("Unable to instantiate the remote class "));
        } catch (IllegalAccessException e3) {
            String valueOf3 = String.valueOf(str);
            throw new IllegalStateException(valueOf3.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf3) : new String("Unable to call the default constructor of "));
        } catch (ReflectiveOperationException e4) {
            String valueOf4 = String.valueOf(str);
            throw new IllegalStateException(valueOf4.length() != 0 ? "Reflection error in ".concat(valueOf4) : new String("Reflection error in "));
        }
    }
}
