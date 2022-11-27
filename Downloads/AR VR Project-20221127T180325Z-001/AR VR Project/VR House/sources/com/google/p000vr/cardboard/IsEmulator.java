package com.google.p000vr.cardboard;

import android.os.Build;

/* renamed from: com.google.vr.cardboard.IsEmulator */
public class IsEmulator {
    private static final String EMULATOR_HARDWARE_GOLDFISH = "goldfish";
    private static final String EMULATOR_HARDWARE_RANCHU = "ranchu";

    public static boolean isEmulator() {
        return EMULATOR_HARDWARE_GOLDFISH.equals(Build.HARDWARE) || EMULATOR_HARDWARE_RANCHU.equals(Build.HARDWARE);
    }
}
