package com.google.p000vr.cardboard;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;

/* renamed from: com.google.vr.cardboard.ContextUtils */
public class ContextUtils {
    public static Activity getActivity(Context context) {
        Context baseContext;
        Context context2 = context;
        while (context2 != null) {
            if (context2 instanceof Activity) {
                return (Activity) context2;
            }
            if (!(context2 instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context2).getBaseContext()) == context2) {
                return null;
            }
            context2 = baseContext;
        }
        return null;
    }

    public static boolean canGetActivity(Context context) {
        return getActivity(context) != null;
    }

    public static ComponentName getComponentName(Context context) {
        if (context instanceof VrContextWrapper) {
            return ((VrContextWrapper) context).getVrComponent();
        }
        Activity activity = getActivity(context);
        if (activity != null) {
            return activity.getComponentName();
        }
        return null;
    }
}
