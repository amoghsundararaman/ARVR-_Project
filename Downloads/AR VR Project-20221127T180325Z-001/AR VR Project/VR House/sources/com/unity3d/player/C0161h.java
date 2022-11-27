package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.LinkedList;

/* renamed from: com.unity3d.player.h */
public final class C0161h implements C0158e {
    /* renamed from: a */
    private static boolean m143a(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public final void mo1669a(Activity activity, Runnable runnable) {
        if (activity != null) {
            PackageManager packageManager = activity.getPackageManager();
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 128);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 128);
                if (m143a(activityInfo) || m143a(applicationInfo)) {
                    runnable.run();
                    return;
                }
            } catch (Exception e) {
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 4096);
                if (packageInfo.requestedPermissions == null) {
                    packageInfo.requestedPermissions = new String[0];
                }
                LinkedList linkedList = new LinkedList();
                for (String str : packageInfo.requestedPermissions) {
                    try {
                        if (!((packageManager.getPermissionInfo(str, 128).protectionLevel & 1) == 0 || activity.checkCallingOrSelfPermission(str) == 0)) {
                            linkedList.add(str);
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        C0160g.Log(5, "Failed to get permission info for " + str + ", manifest likely missing custom permission declaration");
                        C0160g.Log(5, "Permission " + str + " ignored");
                    }
                }
                if (linkedList.isEmpty()) {
                    runnable.run();
                    return;
                }
                C0162i iVar = new C0162i(runnable);
                Bundle bundle = new Bundle();
                bundle.putStringArray("PermissionNames", (String[]) linkedList.toArray(new String[0]));
                iVar.setArguments(bundle);
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(0, iVar);
                beginTransaction.commit();
            } catch (Exception e3) {
                C0160g.Log(6, "Unable to query for permission: " + e3.getMessage());
            }
        }
    }
}
