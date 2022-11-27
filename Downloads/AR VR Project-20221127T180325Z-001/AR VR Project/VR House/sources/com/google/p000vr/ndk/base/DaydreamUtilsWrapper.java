package com.google.p000vr.ndk.base;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import com.google.p000vr.cardboard.ContextUtils;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;

/* renamed from: com.google.vr.ndk.base.DaydreamUtilsWrapper */
public class DaydreamUtilsWrapper {
    public boolean isDaydreamActivity(Activity activity) {
        return isDaydreamComponent(activity);
    }

    public boolean isDaydreamComponent(Context context) {
        return getComponentDaydreamCompatibility(context).supportsDaydream();
    }

    public boolean isDaydreamRequiredActivity(Activity activity) {
        return isDaydreamRequiredComponent(activity);
    }

    public boolean isDaydreamRequiredComponent(Context context) {
        return getComponentDaydreamCompatibility(context).requiresDaydream();
    }

    public DaydreamCompatibility getActivityDaydreamCompatibility(Activity activity) {
        return DaydreamUtils.getComponentDaydreamCompatibility((Context) activity, activity.getComponentName());
    }

    public DaydreamCompatibility getComponentDaydreamCompatibility(Context context) {
        ComponentName componentName = ContextUtils.getComponentName(context);
        if (componentName != null) {
            return DaydreamUtils.getComponentDaydreamCompatibility(context, componentName);
        }
        return new DaydreamCompatibility();
    }

    public boolean isDaydreamPhone(Context context) {
        return DaydreamUtils.isDaydreamPhone(context);
    }

    public boolean isDaydreamViewer(CardboardDevice.DeviceParams deviceParams) {
        return DaydreamUtils.isDaydreamViewer(deviceParams);
    }
}
