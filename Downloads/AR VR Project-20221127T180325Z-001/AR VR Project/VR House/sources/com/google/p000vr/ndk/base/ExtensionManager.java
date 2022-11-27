package com.google.p000vr.ndk.base;

import android.view.ViewGroup;
import com.google.p000vr.vrcore.logging.api.IVrCoreLoggingService;

/* renamed from: com.google.vr.ndk.base.ExtensionManager */
public interface ExtensionManager {
    boolean bootsToVr();

    void initialize(ViewGroup viewGroup, GvrApi gvrApi);

    void onPause();

    void onResume();

    void reportTelemetry(IVrCoreLoggingService iVrCoreLoggingService);

    void setEnabled(boolean z);

    void shutdown();
}
