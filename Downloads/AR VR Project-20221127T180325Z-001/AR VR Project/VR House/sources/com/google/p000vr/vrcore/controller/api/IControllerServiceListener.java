package com.google.p000vr.vrcore.controller.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;

/* renamed from: com.google.vr.vrcore.controller.api.IControllerServiceListener */
public interface IControllerServiceListener extends IInterface {
    public static final int EVENT_AVAILABLE_CONTROLLERS_CHANGED = 1;

    /* renamed from: com.google.vr.vrcore.controller.api.IControllerServiceListener$Stub */
    public static abstract class Stub extends C0086b implements IControllerServiceListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerServiceListener";
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_onControllerServiceEvent = 2;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.controller.api.IControllerServiceListener$Stub$Proxy */
        public static class Proxy extends C0085a implements IControllerServiceListener {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public int getApiVersion() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public void onControllerServiceEvent(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                transactOneway(2, obtainAndWriteInterfaceToken);
            }
        }

        public static IControllerServiceListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IControllerServiceListener) {
                return (IControllerServiceListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    int apiVersion = getApiVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(apiVersion);
                    break;
                case 2:
                    onControllerServiceEvent(parcel.readInt());
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    int getApiVersion() throws RemoteException;

    void onControllerServiceEvent(int i) throws RemoteException;
}
