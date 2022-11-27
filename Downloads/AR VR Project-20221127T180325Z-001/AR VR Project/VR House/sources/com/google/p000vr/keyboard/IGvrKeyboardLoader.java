package com.google.p000vr.keyboard;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.keyboard.deps.C0048a;
import com.google.p000vr.keyboard.deps.C0049b;

/* renamed from: com.google.vr.keyboard.IGvrKeyboardLoader */
public interface IGvrKeyboardLoader extends IInterface {

    /* renamed from: com.google.vr.keyboard.IGvrKeyboardLoader$Stub */
    public static abstract class Stub extends C0049b implements IGvrKeyboardLoader {
        private static final String DESCRIPTOR = "com.google.vr.keyboard.IGvrKeyboardLoader";
        static final int TRANSACTION_closeGvrKeyboard = 3;
        static final int TRANSACTION_loadGvrKeyboard = 2;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.keyboard.IGvrKeyboardLoader$Stub$Proxy */
        public static class Proxy extends C0048a implements IGvrKeyboardLoader {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public long loadGvrKeyboard(long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeLong(j);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            public void closeGvrKeyboard(long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeLong(j);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }
        }

        public static IGvrKeyboardLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IGvrKeyboardLoader) {
                return (IGvrKeyboardLoader) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            switch (i) {
                case 2:
                    long loadGvrKeyboard = loadGvrKeyboard(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(loadGvrKeyboard);
                    return true;
                case 3:
                    closeGvrKeyboard(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    void closeGvrKeyboard(long j) throws RemoteException;

    long loadGvrKeyboard(long j) throws RemoteException;
}
