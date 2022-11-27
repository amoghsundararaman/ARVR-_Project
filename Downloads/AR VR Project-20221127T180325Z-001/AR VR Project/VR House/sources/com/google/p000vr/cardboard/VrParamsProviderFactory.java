package com.google.p000vr.cardboard;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.vr.cardboard.VrParamsProviderFactory */
public final class VrParamsProviderFactory {
    private static final boolean DEBUG = false;
    private static final String TAG = "VrParamsProviderFactory";
    private static VrParamsProvider providerForTesting;

    /* renamed from: com.google.vr.cardboard.VrParamsProviderFactory$ContentProviderClientHandle */
    public static class ContentProviderClientHandle {
        public final String authority;
        public final ContentProviderClient client;

        ContentProviderClientHandle(ContentProviderClient contentProviderClient, String str) {
            this.client = contentProviderClient;
            this.authority = str;
        }
    }

    public static VrParamsProvider create(Context context) {
        if (providerForTesting != null) {
            return providerForTesting;
        }
        ContentProviderClientHandle tryToGetContentProviderClientHandle = tryToGetContentProviderClientHandle(context);
        if (tryToGetContentProviderClientHandle != null) {
            return new ContentProviderVrParamsProvider(tryToGetContentProviderClientHandle.client, tryToGetContentProviderClientHandle.authority);
        }
        return new LegacyVrParamsProvider(context);
    }

    public static ContentProviderClientHandle tryToGetContentProviderClientHandle(Context context) {
        List<String> validContentProviderAuthorities = getValidContentProviderAuthorities(context);
        if (validContentProviderAuthorities != null) {
            for (String next : validContentProviderAuthorities) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(next);
                if (acquireContentProviderClient != null) {
                    return new ContentProviderClientHandle(acquireContentProviderClient, next);
                }
            }
        }
        return null;
    }

    public static boolean isContentProviderAvailable(Context context) {
        if (providerForTesting != null && (providerForTesting instanceof ContentProviderVrParamsProvider)) {
            return true;
        }
        List<String> validContentProviderAuthorities = getValidContentProviderAuthorities(context);
        if (validContentProviderAuthorities == null || validContentProviderAuthorities.isEmpty()) {
            return false;
        }
        return true;
    }

    private static List<String> getValidContentProviderAuthorities(Context context) {
        List<ResolveInfo> queryIntentContentProviders;
        if ("com.google.vr.vrcore".equals(context.getPackageName())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(VrSettingsProviderContract.VRCORE_AUTHORITY);
            return arrayList;
        } else if (Build.VERSION.SDK_INT < 19 || (queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent(VrSettingsProviderContract.PROVIDER_INTENT_ACTION), 0)) == null || queryIntentContentProviders.isEmpty()) {
            return null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentContentProviders) {
                ProviderInfo providerInfo = resolveInfo.providerInfo;
                if (PackageUtils.isGooglePackage(providerInfo.packageName)) {
                    arrayList2.add(providerInfo.authority);
                }
            }
            return arrayList2;
        }
    }

    public static void setProviderForTesting(VrParamsProvider vrParamsProvider) {
        providerForTesting = vrParamsProvider;
    }
}
