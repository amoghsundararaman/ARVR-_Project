package com.google.p000vr.ndk.base;

/* renamed from: com.google.vr.ndk.base.DefaultNativeLibraryLoader */
public class DefaultNativeLibraryLoader {
    private static volatile boolean shouldIgnoreDefaultLibrary = false;

    public static void maybeLoadDefaultLibrary() {
        if (!shouldIgnoreDefaultLibrary) {
            try {
                System.loadLibrary("gvr");
            } catch (UnsatisfiedLinkError e) {
            }
        }
    }

    public static void ignoreDefaultLibrary() {
        shouldIgnoreDefaultLibrary = true;
    }
}
