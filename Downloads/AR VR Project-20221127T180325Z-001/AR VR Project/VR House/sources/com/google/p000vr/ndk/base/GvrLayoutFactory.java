package com.google.p000vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.cardboard.VrContextWrapper;
import com.google.p000vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.p000vr.vrcore.base.api.VrCoreUtils;
import com.google.p000vr.vrcore.library.api.IGvrLayout;
import com.google.p000vr.vrcore.library.api.ObjectWrapper;
import com.google.p000vr.vrcore.library.api.VrCoreLoader;

/* renamed from: com.google.vr.ndk.base.GvrLayoutFactory */
public class GvrLayoutFactory {
    static final int MIN_VRCORE_API_VERSION = 17;
    private static final String TAG = "GvrLayoutFactory";

    public static IGvrLayout create(Context context) {
        IGvrLayout tryCreateFromVrCorePackage = tryCreateFromVrCorePackage(context);
        if (tryCreateFromVrCorePackage != null) {
            return tryCreateFromVrCorePackage;
        }
        if (GvrApi.usingShimLibrary()) {
            throw new IllegalStateException("Client shim failed to load GvrLayout from VrCore.");
        }
        IGvrLayout createFromCurrentPackage = createFromCurrentPackage(context);
        Log.d(TAG, "Loaded GvrLayout from SDK.");
        return createFromCurrentPackage;
    }

    public static IGvrLayout createFromCurrentPackageWithExtensions(Context context, ExtensionManager extensionManager) {
        return new GvrLayoutImplWrapper(new GvrLayoutImpl(context, extensionManager));
    }

    private static IGvrLayout createFromCurrentPackage(Context context) {
        return new GvrLayoutImplWrapper(new GvrLayoutImpl(context));
    }

    private static IGvrLayout tryCreateFromVrCorePackage(Context context) {
        if (VrCoreUtils.isVrCorePackage(context.getPackageName())) {
            return createFromCurrentPackage(context);
        }
        if (context instanceof VrContextWrapper) {
            throw new IllegalArgumentException("VrContextWrapper only supported within VrCore.");
        } else if (!GvrApi.usingDynamicLibrary(context)) {
            Log.v(TAG, "Dynamic library loading disabled, using built-in GvrLayout implementation.");
            return null;
        } else {
            C0003Vr.VREvent.SdkConfigurationParams params = SdkConfigurationReader.getParams(context);
            if ((params.allowDynamicJavaLibraryLoading == null || !params.allowDynamicJavaLibraryLoading.booleanValue()) && !GvrApi.usingShimLibrary()) {
                Log.v(TAG, "Dynamic Java library loading disabled, using built-in GvrLayout implementation.");
                return null;
            }
            try {
                if (VrCoreUtils.getVrCoreClientApiVersion(context) < 17) {
                    Log.d(TAG, "VrCore outdated, using built-in GvrLayout implementation.");
                    return null;
                }
                try {
                    IGvrLayout newGvrLayout = VrCoreLoader.getRemoteCreator(context).newGvrLayout(ObjectWrapper.wrap(VrCoreLoader.getRemoteContext(context)), ObjectWrapper.wrap(context));
                    if (newGvrLayout != null) {
                        Log.i(TAG, "Successfully loaded GvrLayout from VrCore.");
                    } else {
                        Log.w(TAG, "GvrLayout creation from VrCore failed.");
                    }
                    return newGvrLayout;
                } catch (Exception e) {
                    String valueOf = String.valueOf(e);
                    Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to load GvrLayout from VrCore:\n  ").append(valueOf).toString());
                    return null;
                }
            } catch (VrCoreNotAvailableException e2) {
                Log.d(TAG, "VrCore unavailable, using built-in GvrLayout implementation.");
                return null;
            }
        }
    }
}
