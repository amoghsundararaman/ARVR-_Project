package com.vuforia.p000ar.p001pl;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import java.io.File;

/* renamed from: com.vuforia.ar.pl.FileTools */
public class FileTools {
    private static final int FILE_PATHTYPEINDEX_ABSOLUTE = -1;
    private static final int FILE_PATHTYPEINDEX_ANDROID_ASSETS = 0;
    private static final int FILE_PATHTYPEINDEX_ANDROID_DATALOCAL = 4;
    private static final int FILE_PATHTYPEINDEX_ANDROID_MEDIASTORAGE = 3;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPCACHE = 2;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPSTORAGE = 1;
    private static final String MODULENAME = "FileTools";

    public static String getAbsolutePath(int i, String str) {
        String str2;
        if (i == 1) {
            Activity activityFromNative = SystemTools.getActivityFromNative();
            if (activityFromNative == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            File filesDir = activityFromNative.getFilesDir();
            if (filesDir == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            str2 = filesDir.getAbsolutePath();
        } else if (i == 2) {
            Activity activityFromNative2 = SystemTools.getActivityFromNative();
            if (activityFromNative2 == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            File cacheDir = activityFromNative2.getCacheDir();
            if (cacheDir == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            str2 = cacheDir.getAbsolutePath();
        } else if (i != 3) {
            SystemTools.setSystemErrorCode(6);
            return null;
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            str2 = externalStorageDirectory.getAbsolutePath();
        }
        if (str2 == null || str == null) {
            return str2;
        }
        if (str2.length() > 0 && str2.charAt(str2.length() - 1) != '/') {
            str2 = str2 + "/";
        }
        return str2 + str;
    }

    public static boolean mediastorage_isAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static AssetManager get_assetmanager() {
        Activity activityFromNative = SystemTools.getActivityFromNative();
        if (activityFromNative != null) {
            return activityFromNative.getAssets();
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }
}
