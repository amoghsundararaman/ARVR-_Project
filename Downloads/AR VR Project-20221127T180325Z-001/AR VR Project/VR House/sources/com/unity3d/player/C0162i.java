package com.unity3d.player;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

/* renamed from: com.unity3d.player.i */
public final class C0162i extends Fragment {

    /* renamed from: a */
    private final Runnable f211a;

    public C0162i() {
        this.f211a = null;
    }

    public C0162i(Runnable runnable) {
        this.f211a = runnable;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f211a == null) {
            getFragmentManager().beginTransaction().remove(this).commit();
        } else {
            requestPermissions(getArguments().getStringArray("PermissionNames"), 15881);
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 15881) {
            if (strArr.length == 0) {
                requestPermissions(getArguments().getStringArray("PermissionNames"), 15881);
                return;
            }
            int i2 = 0;
            while (i2 < strArr.length && i2 < iArr.length) {
                C0160g.Log(4, strArr[i2] + (iArr[i2] == 0 ? " granted" : " denied"));
                i2++;
            }
            FragmentTransaction beginTransaction = getActivity().getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commit();
            this.f211a.run();
        }
    }
}
