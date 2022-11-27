package com.google.p000vr.ndk.base;

import android.app.PendingIntent;
import android.view.View;
import com.google.p000vr.vrcore.library.api.IGvrLayout;
import com.google.p000vr.vrcore.library.api.IGvrUiLayout;
import com.google.p000vr.vrcore.library.api.IObjectWrapper;
import com.google.p000vr.vrcore.library.api.ObjectWrapper;

/* renamed from: com.google.vr.ndk.base.GvrLayoutImplWrapper */
class GvrLayoutImplWrapper extends IGvrLayout.Stub {
    private final GvrLayoutImpl impl;

    public GvrLayoutImplWrapper(GvrLayoutImpl gvrLayoutImpl) {
        this.impl = gvrLayoutImpl;
    }

    public long getNativeGvrContext() {
        return this.impl.getGvrApi().getNativeGvrContext();
    }

    public IObjectWrapper getRootView() {
        return ObjectWrapper.wrap(this.impl);
    }

    public IGvrUiLayout getUiLayout() {
        return this.impl.getUiLayoutImpl();
    }

    public void onPause() {
        this.impl.onPause();
    }

    public void onResume() {
        this.impl.onResume();
    }

    public void onBackPressed() {
        this.impl.onBackPressed();
    }

    public void shutdown() {
        this.impl.shutdown();
    }

    public void setPresentationView(IObjectWrapper iObjectWrapper) {
        this.impl.setPresentationView((View) ObjectWrapper.unwrap(iObjectWrapper, View.class));
    }

    public boolean enableAsyncReprojection(int i) {
        return this.impl.enableAsyncReprojection(i);
    }

    public boolean enableCardboardTriggerEmulation(IObjectWrapper iObjectWrapper) {
        return this.impl.enableCardboardTriggerEmulation((Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class));
    }

    public void setStereoModeEnabled(boolean z) {
        this.impl.setStereoModeEnabled(z);
    }

    public void setReentryIntent(IObjectWrapper iObjectWrapper) {
        this.impl.setReentryIntent((PendingIntent) ObjectWrapper.unwrap(iObjectWrapper, PendingIntent.class));
    }

    public boolean setOnDonNotNeededListener(IObjectWrapper iObjectWrapper) {
        return this.impl.setOnDonNotNeededListener((Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class));
    }
}
