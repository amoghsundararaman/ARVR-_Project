package com.google.p000vr.vrcore.common.api;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;
import com.google.p000vr.vrcore.common.api.IDaydreamManager;
import com.google.p000vr.vrcore.logging.api.IVrCoreLoggingService;

/* renamed from: com.google.vr.vrcore.common.api.IVrCoreSdkService */
public interface IVrCoreSdkService extends IInterface {

    /* renamed from: com.google.vr.vrcore.common.api.IVrCoreSdkService$Stub */
    public static abstract class Stub extends C0086b implements IVrCoreSdkService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IVrCoreSdkService";
        static final int TRANSACTION_getDaydreamManager = 2;
        static final int TRANSACTION_getLoggingService = 4;
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_setClientOptions = 3;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.common.api.IVrCoreSdkService$Stub$Proxy */
        public static class Proxy extends C0085a implements IVrCoreSdkService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public boolean initialize(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public IDaydreamManager getDaydreamManager() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IDaydreamManager asInterface = IDaydreamManager.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public boolean setClientOptions(ComponentName componentName, Bundle bundle) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) bundle);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public IVrCoreLoggingService getLoggingService() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                IVrCoreLoggingService asInterface = IVrCoreLoggingService.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }
        }

        public static IVrCoreSdkService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrCoreSdkService) {
                return (IVrCoreSdkService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    boolean initialize = initialize(parcel.readInt());
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, initialize);
                    break;
                case 2:
                    IDaydreamManager daydreamManager = getDaydreamManager();
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) daydreamManager);
                    break;
                case 3:
                    boolean clientOptions = setClientOptions((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR), (Bundle) C0087c.m4a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, clientOptions);
                    break;
                case 4:
                    IVrCoreLoggingService loggingService = getLoggingService();
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) loggingService);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IDaydreamManager getDaydreamManager() throws RemoteException;

    IVrCoreLoggingService getLoggingService() throws RemoteException;

    boolean initialize(int i) throws RemoteException;

    boolean setClientOptions(ComponentName componentName, Bundle bundle) throws RemoteException;
}
