package com.google.p000vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;

/* renamed from: com.google.vr.vrcore.library.api.IObjectWrapper */
public interface IObjectWrapper extends IInterface {

    /* renamed from: com.google.vr.vrcore.library.api.IObjectWrapper$Stub */
    public static abstract class Stub extends C0086b implements IObjectWrapper {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IObjectWrapper";

        /* renamed from: com.google.vr.vrcore.library.api.IObjectWrapper$Stub$Proxy */
        public static class Proxy extends C0085a implements IObjectWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }
        }

        public Stub() {
            super(DESCRIPTOR);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IObjectWrapper) {
                return (IObjectWrapper) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }
    }
}
