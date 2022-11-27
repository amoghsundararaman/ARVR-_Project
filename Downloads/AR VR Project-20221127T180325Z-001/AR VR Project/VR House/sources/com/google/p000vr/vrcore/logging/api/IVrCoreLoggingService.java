package com.google.p000vr.vrcore.logging.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;

/* renamed from: com.google.vr.vrcore.logging.api.IVrCoreLoggingService */
public interface IVrCoreLoggingService extends IInterface {

    /* renamed from: com.google.vr.vrcore.logging.api.IVrCoreLoggingService$Stub */
    public static abstract class Stub extends C0086b implements IVrCoreLoggingService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
        static final int TRANSACTION_log = 2;
        static final int TRANSACTION_logBatched = 3;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.logging.api.IVrCoreLoggingService$Stub$Proxy */
        public static class Proxy extends C0085a implements IVrCoreLoggingService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public void log(VREventParcelable vREventParcelable) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) vREventParcelable);
                transactOneway(2, obtainAndWriteInterfaceToken);
            }

            public void logBatched(VREventParcelable[] vREventParcelableArr) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeTypedArray(vREventParcelableArr, 0);
                transactOneway(3, obtainAndWriteInterfaceToken);
            }
        }

        public static IVrCoreLoggingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrCoreLoggingService) {
                return (IVrCoreLoggingService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    log((VREventParcelable) C0087c.m4a(parcel, VREventParcelable.CREATOR));
                    break;
                case 3:
                    logBatched((VREventParcelable[]) parcel.createTypedArray(VREventParcelable.CREATOR));
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    void log(VREventParcelable vREventParcelable) throws RemoteException;

    void logBatched(VREventParcelable[] vREventParcelableArr) throws RemoteException;
}
