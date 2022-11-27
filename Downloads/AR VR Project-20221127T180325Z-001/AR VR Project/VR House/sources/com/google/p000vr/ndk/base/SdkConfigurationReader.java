package com.google.p000vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.cardboard.VrParamsProvider;
import com.google.p000vr.cardboard.VrParamsProviderFactory;
import com.google.p000vr.sdk.proto.nano.SdkConfiguration;

/* renamed from: com.google.vr.ndk.base.SdkConfigurationReader */
public class SdkConfigurationReader {
    public static final C0003Vr.VREvent.SdkConfigurationParams DEFAULT_PARAMS;
    static final C0003Vr.VREvent.SdkConfigurationParams REQUESTED_PARAMS;
    private static final String TAG = "SdkConfigurationReader";
    static C0003Vr.VREvent.SdkConfigurationParams sParams;

    public static C0003Vr.VREvent.SdkConfigurationParams getParams(Context context) {
        synchronized (SdkConfigurationReader.class) {
            if (sParams != null) {
                C0003Vr.VREvent.SdkConfigurationParams sdkConfigurationParams = sParams;
                return sdkConfigurationParams;
            }
            VrParamsProvider create = VrParamsProviderFactory.create(context);
            C0003Vr.VREvent.SdkConfigurationParams readParamsFromProvider = readParamsFromProvider(create);
            synchronized (SdkConfigurationReader.class) {
                sParams = readParamsFromProvider;
            }
            create.close();
            return sParams;
        }
    }

    private static C0003Vr.VREvent.SdkConfigurationParams readParamsFromProvider(VrParamsProvider vrParamsProvider) {
        SdkConfiguration.SdkConfigurationRequest sdkConfigurationRequest = new SdkConfiguration.SdkConfigurationRequest();
        sdkConfigurationRequest.requestedParams = REQUESTED_PARAMS;
        sdkConfigurationRequest.sdkVersion = "1.150.0";
        C0003Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams = vrParamsProvider.readSdkConfigurationParams(sdkConfigurationRequest);
        if (readSdkConfigurationParams == null) {
            Log.w(TAG, "VrParamsProvider returned null params, using defaults.");
            return DEFAULT_PARAMS;
        }
        String valueOf = String.valueOf(readSdkConfigurationParams);
        Log.d(TAG, new StringBuilder(String.valueOf(valueOf).length() + 38).append("Fetched params from VrParamsProvider: ").append(valueOf).toString());
        return readSdkConfigurationParams;
    }

    static {
        C0003Vr.VREvent.SdkConfigurationParams sdkConfigurationParams = new C0003Vr.VREvent.SdkConfigurationParams();
        REQUESTED_PARAMS = sdkConfigurationParams;
        sdkConfigurationParams.useSystemClockForSensorTimestamps = true;
        REQUESTED_PARAMS.useMagnetometerInSensorFusion = true;
        REQUESTED_PARAMS.useStationaryBiasCorrection = true;
        REQUESTED_PARAMS.allowDynamicLibraryLoading = true;
        REQUESTED_PARAMS.cpuLateLatchingEnabled = true;
        REQUESTED_PARAMS.daydreamImageAlignment = 1;
        REQUESTED_PARAMS.asyncReprojectionConfig = new C0003Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig();
        REQUESTED_PARAMS.useOnlineMagnetometerCalibration = true;
        REQUESTED_PARAMS.useDeviceIdleDetection = true;
        REQUESTED_PARAMS.allowDynamicJavaLibraryLoading = true;
        REQUESTED_PARAMS.touchOverlayEnabled = true;
        REQUESTED_PARAMS.enableForcedTrackingCompat = true;
        REQUESTED_PARAMS.allowVrcoreHeadTracking = true;
        REQUESTED_PARAMS.allowVrcoreCompositing = true;
        REQUESTED_PARAMS.screenCaptureConfig = new C0003Vr.VREvent.SdkConfigurationParams.ScreenCaptureConfig();
        REQUESTED_PARAMS.dimUiLayer = true;
        REQUESTED_PARAMS.disallowMultiview = true;
        REQUESTED_PARAMS.useDirectModeSensors = true;
        C0003Vr.VREvent.SdkConfigurationParams sdkConfigurationParams2 = new C0003Vr.VREvent.SdkConfigurationParams();
        DEFAULT_PARAMS = sdkConfigurationParams2;
        sdkConfigurationParams2.useSystemClockForSensorTimestamps = false;
        DEFAULT_PARAMS.useMagnetometerInSensorFusion = false;
        DEFAULT_PARAMS.useStationaryBiasCorrection = false;
        DEFAULT_PARAMS.allowDynamicLibraryLoading = false;
        DEFAULT_PARAMS.cpuLateLatchingEnabled = false;
        DEFAULT_PARAMS.daydreamImageAlignment = 3;
        DEFAULT_PARAMS.asyncReprojectionConfig = null;
        DEFAULT_PARAMS.useOnlineMagnetometerCalibration = false;
        DEFAULT_PARAMS.useDeviceIdleDetection = false;
        DEFAULT_PARAMS.allowDynamicJavaLibraryLoading = false;
        DEFAULT_PARAMS.touchOverlayEnabled = false;
        DEFAULT_PARAMS.enableForcedTrackingCompat = false;
        DEFAULT_PARAMS.allowVrcoreHeadTracking = false;
        DEFAULT_PARAMS.allowVrcoreCompositing = false;
        DEFAULT_PARAMS.screenCaptureConfig = null;
        DEFAULT_PARAMS.dimUiLayer = false;
        DEFAULT_PARAMS.disallowMultiview = false;
        DEFAULT_PARAMS.useDirectModeSensors = false;
    }
}
