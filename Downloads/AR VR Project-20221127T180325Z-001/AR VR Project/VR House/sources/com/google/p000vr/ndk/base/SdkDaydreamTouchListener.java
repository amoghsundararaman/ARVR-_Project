package com.google.p000vr.ndk.base;

import android.content.Context;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.logging.nano.C0003Vr;
import com.google.p000vr.cardboard.DisplayUtils;
import com.google.p000vr.cardboard.VrParamsProvider;
import com.google.p000vr.cardboard.VrParamsProviderFactory;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Display;
import com.google.p000vr.vrcore.logging.api.VREventParcelable;

/* renamed from: com.google.vr.ndk.base.SdkDaydreamTouchListener */
class SdkDaydreamTouchListener extends AbstractDaydreamTouchListener implements View.OnTouchListener {
    static final String TAG = "SdkDaydreamTouchListener";
    private final GvrApi gvrApi;
    private final GvrLayoutImpl gvrLayout;
    private final boolean isDaydreamImageAlignmentEnabled;
    /* access modifiers changed from: private */
    public final VrParamsProvider vrParamsProvider;

    /* renamed from: com.google.vr.ndk.base.SdkDaydreamTouchListener$FinishInitilizationTask */
    private class FinishInitilizationTask extends AsyncTask<Void, Void, Display.DisplayParams> {
        public android.view.Display display;

        private FinishInitilizationTask() {
        }

        /* access modifiers changed from: protected */
        public Display.DisplayParams doInBackground(Void... voidArr) {
            return SdkDaydreamTouchListener.this.vrParamsProvider.readDisplayParams();
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Void... voidArr) {
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Display.DisplayParams displayParams) {
            SdkDaydreamTouchListener.this.init(DisplayUtils.getDisplayMetricsLandscapeWithOverride(this.display, displayParams), displayParams);
        }
    }

    /* renamed from: com.google.vr.ndk.base.SdkDaydreamTouchListener$RefreshViewerProfileTask */
    private class RefreshViewerProfileTask extends AsyncTask<Void, Void, CardboardDevice.DeviceParams> {
        private RefreshViewerProfileTask() {
        }

        /* access modifiers changed from: protected */
        public CardboardDevice.DeviceParams doInBackground(Void... voidArr) {
            return SdkDaydreamTouchListener.this.vrParamsProvider.readDeviceParams();
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Void... voidArr) {
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(CardboardDevice.DeviceParams deviceParams) {
            SdkDaydreamTouchListener.this.setDeviceParams(deviceParams);
        }
    }

    public SdkDaydreamTouchListener(GvrLayoutImpl gvrLayoutImpl) {
        boolean z = true;
        this.gvrLayout = gvrLayoutImpl;
        this.gvrApi = gvrLayoutImpl.getGvrApi();
        this.isDaydreamImageAlignmentEnabled = (this.gvrApi.getSdkConfigurationParams().daydreamImageAlignment.intValue() == 1 || this.gvrApi.getSdkConfigurationParams().touchOverlayEnabled.booleanValue()) ? false : z;
        Context context = gvrLayoutImpl.getContext();
        this.vrParamsProvider = VrParamsProviderFactory.create(context);
        FinishInitilizationTask finishInitilizationTask = new FinishInitilizationTask();
        finishInitilizationTask.display = DisplayUtils.getDefaultDisplay(context);
        finishInitilizationTask.execute(new Void[0]);
    }

    SdkDaydreamTouchListener(VrParamsProvider vrParamsProvider2, DisplayMetrics displayMetrics, Display.DisplayParams displayParams, GvrApi gvrApi2, GvrLayoutImpl gvrLayoutImpl, boolean z) {
        this.isDaydreamImageAlignmentEnabled = z;
        this.vrParamsProvider = vrParamsProvider2;
        this.gvrApi = gvrApi2;
        this.gvrLayout = gvrLayoutImpl;
        init(displayMetrics, displayParams);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return handleTouch(motionEvent, 0.0f, 0.0f);
    }

    public void refreshViewerProfile() {
        new RefreshViewerProfileTask().execute(new Void[0]);
    }

    public void shutdown() {
        this.vrParamsProvider.close();
    }

    /* access modifiers changed from: private */
    public void init(DisplayMetrics displayMetrics, Display.DisplayParams displayParams) {
        initWithDisplayParams(displayMetrics, displayParams);
        refreshViewerProfile();
    }

    /* access modifiers changed from: protected */
    public boolean isDaydreamImageAlignmentEnabled() {
        return this.isDaydreamImageAlignmentEnabled;
    }

    /* access modifiers changed from: protected */
    public void setLensOffset(float f, float f2, float f3) {
        this.gvrApi.setLensOffset(f, f2, 0.0f);
    }

    /* access modifiers changed from: protected */
    public void logEvent(int i, C0003Vr.VREvent vREvent) {
        if (this.gvrLayout.getVrCoreSdkClient() == null || this.gvrLayout.getVrCoreSdkClient().getLoggingService() == null) {
            Log.w(TAG, "Unable to log alignment event; logging service not available.");
            return;
        }
        try {
            this.gvrLayout.getVrCoreSdkClient().getLoggingService().log(new VREventParcelable(2012, vREvent));
        } catch (RemoteException e) {
            Log.w(TAG, "Unable to log alignment event");
        }
    }
}
