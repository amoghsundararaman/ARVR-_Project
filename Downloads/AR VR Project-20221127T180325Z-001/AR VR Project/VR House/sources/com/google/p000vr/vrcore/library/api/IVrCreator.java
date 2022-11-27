package com.google.p000vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;
import com.google.p000vr.vrcore.library.api.IGvrLayout;
import com.google.p000vr.vrcore.library.api.IObjectWrapper;
import com.google.p000vr.vrcore.library.api.IVrNativeLibraryLoader;

/* renamed from: com.google.vr.vrcore.library.api.IVrCreator */
public interface IVrCreator extends IInterface {

    /* renamed from: com.google.vr.vrcore.library.api.IVrCreator$Stub */
    public static abstract class Stub extends C0086b implements IVrCreator {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrCreator";
        static final int TRANSACTION_DEPRECATED_newNativeLibraryLoader = 3;
        static final int TRANSACTION_newGvrLayout = 5;
        static final int TRANSACTION_newNativeLibraryLoader = 4;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.library.api.IVrCreator$Stub$Proxy */
        public static class Proxy extends C0085a implements IVrCreator {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                IVrNativeLibraryLoader asInterface = IVrNativeLibraryLoader.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
                IVrNativeLibraryLoader asInterface = IVrNativeLibraryLoader.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IGvrLayout newGvrLayout(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                IGvrLayout asInterface = IGvrLayout.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }
        }

        public static IVrCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrCreator) {
                return (IVrCreator) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 3:
                    IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader = DEPRECATED_newNativeLibraryLoader(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) DEPRECATED_newNativeLibraryLoader);
                    break;
                case 4:
                    IVrNativeLibraryLoader newNativeLibraryLoader = newNativeLibraryLoader(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) newNativeLibraryLoader);
                    break;
                case 5:
                    IGvrLayout newGvrLayout = newGvrLayout(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) newGvrLayout);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper iObjectWrapper) throws RemoteException;

    IGvrLayout newGvrLayout(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
