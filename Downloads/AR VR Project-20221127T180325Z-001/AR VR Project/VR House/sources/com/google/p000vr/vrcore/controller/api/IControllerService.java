package com.google.p000vr.vrcore.controller.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;
import com.google.p000vr.vrcore.controller.api.IControllerListener;
import com.google.p000vr.vrcore.controller.api.IControllerServiceListener;

/* renamed from: com.google.vr.vrcore.controller.api.IControllerService */
public interface IControllerService extends IInterface {

    /* renamed from: com.google.vr.vrcore.controller.api.IControllerService$Stub */
    public static abstract class Stub extends C0086b implements IControllerService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerService";
        static final int TRANSACTION_deprecatedOnHeadTrackingRecentered = 7;
        static final int TRANSACTION_getNumberOfControllers = 10;
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_registerListener = 5;
        static final int TRANSACTION_registerServiceListener = 8;
        static final int TRANSACTION_request = 11;
        static final int TRANSACTION_unregisterListener = 6;
        static final int TRANSACTION_unregisterServiceListener = 9;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.controller.api.IControllerService$Stub$Proxy */
        public static class Proxy extends C0085a implements IControllerService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public int initialize(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public boolean registerListener(int i, String str, IControllerListener iControllerListener) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeString(str);
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iControllerListener);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean unregisterListener(String str) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public void deprecatedOnHeadTrackingRecentered() throws RemoteException {
                transactOneway(7, obtainAndWriteInterfaceToken());
            }

            public boolean registerServiceListener(IControllerServiceListener iControllerServiceListener) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iControllerServiceListener);
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean unregisterServiceListener(IControllerServiceListener iControllerServiceListener) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iControllerServiceListener);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public int getNumberOfControllers() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public void request(int i, ControllerRequest controllerRequest) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) controllerRequest);
                transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
            }
        }

        public static IControllerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IControllerService) {
                return (IControllerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    int initialize = initialize(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(initialize);
                    break;
                case 5:
                    boolean registerListener = registerListener(parcel.readInt(), parcel.readString(), IControllerListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, registerListener);
                    break;
                case 6:
                    boolean unregisterListener = unregisterListener(parcel.readString());
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, unregisterListener);
                    break;
                case 7:
                    deprecatedOnHeadTrackingRecentered();
                    break;
                case 8:
                    boolean registerServiceListener = registerServiceListener(IControllerServiceListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, registerServiceListener);
                    break;
                case 9:
                    boolean unregisterServiceListener = unregisterServiceListener(IControllerServiceListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, unregisterServiceListener);
                    break;
                case 10:
                    int numberOfControllers = getNumberOfControllers();
                    parcel2.writeNoException();
                    parcel2.writeInt(numberOfControllers);
                    break;
                case 11:
                    request(parcel.readInt(), (ControllerRequest) C0087c.m4a(parcel, ControllerRequest.CREATOR));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    void deprecatedOnHeadTrackingRecentered() throws RemoteException;

    int getNumberOfControllers() throws RemoteException;

    int initialize(int i) throws RemoteException;

    boolean registerListener(int i, String str, IControllerListener iControllerListener) throws RemoteException;

    boolean registerServiceListener(IControllerServiceListener iControllerServiceListener) throws RemoteException;

    void request(int i, ControllerRequest controllerRequest) throws RemoteException;

    boolean unregisterListener(String str) throws RemoteException;

    boolean unregisterServiceListener(IControllerServiceListener iControllerServiceListener) throws RemoteException;
}
