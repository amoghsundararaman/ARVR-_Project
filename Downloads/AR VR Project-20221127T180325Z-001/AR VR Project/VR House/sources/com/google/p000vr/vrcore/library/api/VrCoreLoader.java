package com.google.p000vr.vrcore.library.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.google.p000vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.p000vr.vrcore.base.api.VrCoreUtils;
import com.google.p000vr.vrcore.library.api.IVrCreator;

/* renamed from: com.google.vr.vrcore.library.api.VrCoreLoader */
public class VrCoreLoader {
    private static final String CREATOR_NAME = "com.google.vr.vrcore.library.VrCreator";
    private static final boolean DEBUG = false;
    private static final String LIBRARY_APK_PACKAGE = "com.google.vr.vrcore";
    static final int MIN_TARGET_API_VERSION = 9;
    private static final String TAG = "VrCoreLoader";
    private static IVrCreator sCreator;
    private static Context sRemoteContext;
    private static int sRemoteContextApiVersion;

    public static IVrCreator getRemoteCreator(Context context) throws VrCoreNotAvailableException {
        if (sCreator == null) {
            sCreator = IVrCreator.Stub.asInterface(newBinderInstance(getRemoteContext(context).getClassLoader(), CREATOR_NAME));
        }
        return sCreator;
    }

    public static Context getRemoteContext(Context context) throws VrCoreNotAvailableException {
        if (sRemoteContext == null) {
            int vrCoreClientApiVersion = VrCoreUtils.getVrCoreClientApiVersion(context);
            if (vrCoreClientApiVersion < 9) {
                throw new VrCoreNotAvailableException(4);
            }
            try {
                sRemoteContext = context.createPackageContext("com.google.vr.vrcore", 3);
                sRemoteContextApiVersion = vrCoreClientApiVersion;
            } catch (PackageManager.NameNotFoundException e) {
                throw new VrCoreNotAvailableException(1);
            }
        }
        return sRemoteContext;
    }

    public static int getRemoteContextClientApiVersion(Context context) throws VrCoreNotAvailableException {
        getRemoteContext(context);
        return sRemoteContextApiVersion;
    }

    static void resetForTesting() {
        sRemoteContext = null;
        sRemoteContextApiVersion = 0;
        sCreator = null;
    }

    private static IBinder newBinderInstance(ClassLoader classLoader, String str) {
        try {
            return (IBinder) classLoader.loadClass(str).newInstance();
        } catch (ClassNotFoundException e) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        } catch (InstantiationException e2) {
            String valueOf2 = String.valueOf(str);
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to instantiate the remote class ".concat(valueOf2) : new String("Unable to instantiate the remote class "));
        } catch (IllegalAccessException e3) {
            String valueOf3 = String.valueOf(str);
            throw new IllegalStateException(valueOf3.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf3) : new String("Unable to call the default constructor of "));
        }
    }
}
