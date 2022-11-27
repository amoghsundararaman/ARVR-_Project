package com.google.p000vr.vrcore.performance.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;

/* renamed from: com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback */
public interface IThrottlingTriggerCallback extends IInterface {

    /* renamed from: com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback$Stub */
    public static abstract class Stub extends C0086b implements IThrottlingTriggerCallback {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback";
        static final int TRANSACTION_onTriggerActivated = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback$Stub$Proxy */
        public static class Proxy extends C0085a implements IThrottlingTriggerCallback {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public void onTriggerActivated(float f, long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeLong(j);
                transactOneway(1, obtainAndWriteInterfaceToken);
            }
        }

        public static IThrottlingTriggerCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IThrottlingTriggerCallback) {
                return (IThrottlingTriggerCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            onTriggerActivated(parcel.readFloat(), parcel.readLong());
            return true;
        }
    }

    void onTriggerActivated(float f, long j) throws RemoteException;
}
