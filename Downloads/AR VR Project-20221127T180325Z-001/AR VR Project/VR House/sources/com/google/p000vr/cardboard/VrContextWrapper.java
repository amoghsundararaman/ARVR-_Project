package com.google.p000vr.cardboard;

import android.content.ComponentName;
import android.content.Context;
import android.content.MutableContextWrapper;

/* renamed from: com.google.vr.cardboard.VrContextWrapper */
public abstract class VrContextWrapper extends MutableContextWrapper {
    public VrContextWrapper(Context context) {
        super(context);
    }

    public abstract ComponentName getVrComponent();

    public boolean autoFadeEnabled() {
        return true;
    }
}
