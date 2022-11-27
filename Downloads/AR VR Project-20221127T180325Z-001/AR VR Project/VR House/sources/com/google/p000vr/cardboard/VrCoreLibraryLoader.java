package com.google.p000vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.google.p000vr.ndk.base.Version;
import com.google.p000vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.p000vr.vrcore.base.api.VrCoreUtils;
import com.google.p000vr.vrcore.library.api.IVrNativeLibraryLoader;
import com.google.p000vr.vrcore.library.api.ObjectWrapper;
import com.google.p000vr.vrcore.library.api.VrCoreLoader;

@UsedByNative
/* renamed from: com.google.vr.cardboard.VrCoreLibraryLoader */
public class VrCoreLibraryLoader {
    private static final int MAX_ANDROID_SDK_VERSION_FOR_DLSYM = 23;
    private static final int MIN_TARGET_API_VERSION_FOR_DLSYM = 14;
    private static final int MIN_TARGET_API_VERSION_FOR_MIN_SDK_VERSION = 19;
    private static final String TAG = "VrCoreLibraryLoader";

    public static void checkVrCoreGvrLibraryAvailable(Context context) throws VrCoreNotAvailableException {
        checkVrCoreGvrLibraryAvailable(context, Version.MIN);
    }

    @UsedByNative
    public static long loadNativeGvrLibrary(Context context) {
        return loadNativeGvrLibrary(context, Version.MIN, Version.CURRENT);
    }

    @UsedByNative
    public static long loadNativeGvrLibrary(Context context, Version version, Version version2) {
        try {
            checkVrCoreGvrLibraryAvailable(context, version);
            Context remoteContext = VrCoreLoader.getRemoteContext(context);
            int remoteContextClientApiVersion = VrCoreLoader.getRemoteContextClientApiVersion(context);
            IVrNativeLibraryLoader newNativeLibraryLoader = VrCoreLoader.getRemoteCreator(context).newNativeLibraryLoader(ObjectWrapper.wrap(remoteContext), ObjectWrapper.wrap(context));
            if (newNativeLibraryLoader == null) {
                Log.e(TAG, "Failed to load native GVR library from VrCore: no library loader available.");
                return 0;
            } else if (remoteContextClientApiVersion < MIN_TARGET_API_VERSION_FOR_MIN_SDK_VERSION) {
                return newNativeLibraryLoader.loadNativeGvrLibrary(version2.majorVersion, version2.minorVersion, version2.patchVersion);
            } else {
                return newNativeLibraryLoader.loadNativeGvrLibraryWithMinVersion(version.toString(), version2.toString());
            }
        } catch (RemoteException | VrCoreNotAvailableException | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e) {
            String valueOf = String.valueOf(e);
            Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 49).append("Failed to load native GVR library from VrCore:\n  ").append(valueOf).toString());
            return 0;
        }
    }

    @UsedByNative
    public static long loadNativeDlsymMethod(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            return 0;
        }
        try {
            if (VrCoreUtils.getVrCoreClientApiVersion(context) < 14) {
                return 0;
            }
            IVrNativeLibraryLoader newNativeLibraryLoader = VrCoreLoader.getRemoteCreator(context).newNativeLibraryLoader(ObjectWrapper.wrap(VrCoreLoader.getRemoteContext(context)), ObjectWrapper.wrap(context));
            if (newNativeLibraryLoader != null) {
                return newNativeLibraryLoader.loadNativeDlsymMethod();
            }
            Log.e(TAG, "Failed to load native dlsym handle from VrCore: no library loader available.");
            return 0;
        } catch (RemoteException | VrCoreNotAvailableException | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e) {
            String valueOf = String.valueOf(e);
            Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 50).append("Failed to load native dlsym handle from VrCore:\n  ").append(valueOf).toString());
            return 0;
        }
    }

    private static void checkVrCoreGvrLibraryAvailable(Context context, Version version) throws VrCoreNotAvailableException {
        String vrCoreSdkLibraryVersion = VrCoreUtils.getVrCoreSdkLibraryVersion(context);
        Version parse = Version.parse(vrCoreSdkLibraryVersion);
        if (parse == null) {
            Log.i(TAG, "VrCore version does not support library loading.");
            throw new VrCoreNotAvailableException(4);
        } else if (!parse.isAtLeast(version)) {
            Log.w(TAG, String.format("VrCore GVR library version obsolete; VrCore supports %s but client min is %s", new Object[]{vrCoreSdkLibraryVersion, version.toString()}));
            throw new VrCoreNotAvailableException(4);
        }
    }
}
