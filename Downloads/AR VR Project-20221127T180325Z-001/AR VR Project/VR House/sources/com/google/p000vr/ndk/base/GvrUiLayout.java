package com.google.p000vr.ndk.base;

import android.app.Activity;
import android.os.RemoteException;
import android.view.View;
import com.google.p000vr.cardboard.UiUtils;
import com.google.p000vr.cardboard.annotations.UsedByReflection;
import com.google.p000vr.vrcore.library.api.IGvrUiLayout;
import com.google.p000vr.vrcore.library.api.ObjectWrapper;

@UsedByReflection("Unity")
/* renamed from: com.google.vr.ndk.base.GvrUiLayout */
public class GvrUiLayout {
    private final IGvrUiLayout impl;

    GvrUiLayout(IGvrUiLayout iGvrUiLayout) {
        this.impl = iGvrUiLayout;
    }

    public static void launchOrInstallGvrApp(Activity activity) {
        UiUtils.launchOrInstallCardboard(activity);
    }

    public void setEnabled(boolean z) {
        try {
            this.impl.setEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEnabled() {
        try {
            return this.impl.isEnabled();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public void setCloseButtonListener(Runnable runnable) {
        try {
            this.impl.setCloseButtonListener(ObjectWrapper.wrap(runnable));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public void setTransitionViewEnabled(boolean z) {
        try {
            this.impl.setTransitionViewEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTransitionViewListener(Runnable runnable) {
        try {
            this.impl.setTransitionViewListener(ObjectWrapper.wrap(runnable));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSettingsButtonEnabled(boolean z) {
        try {
            this.impl.setSettingsButtonEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSettingsButtonListener(Runnable runnable) {
        try {
            this.impl.setSettingsButtonListener(ObjectWrapper.wrap(runnable));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setViewerName(String str) {
        try {
            this.impl.setViewerName(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        try {
            ((View) ObjectWrapper.unwrap(this.impl.getRootView(), View.class)).setOnTouchListener(onTouchListener);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
