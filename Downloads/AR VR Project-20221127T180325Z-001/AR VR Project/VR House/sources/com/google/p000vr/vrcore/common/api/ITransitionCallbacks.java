package com.google.p000vr.vrcore.common.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;

/* renamed from: com.google.vr.vrcore.common.api.ITransitionCallbacks */
public interface ITransitionCallbacks extends IInterface {

    /* renamed from: com.google.vr.vrcore.common.api.ITransitionCallbacks$Stub */
    public static abstract class Stub extends C0086b implements ITransitionCallbacks {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.ITransitionCallbacks";
        static final int TRANSACTION_onTransitionComplete = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.common.api.ITransitionCallbacks$Stub$Proxy */
        public static class Proxy extends C0085a implements ITransitionCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public void onTransitionComplete() throws RemoteException {
                transactOneway(1, obtainAndWriteInterfaceToken());
            }
        }

        public static ITransitionCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof ITransitionCallbacks) {
                return (ITransitionCallbacks) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            onTransitionComplete();
            return true;
        }
    }

    void onTransitionComplete() throws RemoteException;
}
