package com.google.p000vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;

/* renamed from: com.google.vr.vrcore.library.api.IVrNativeLibraryLoader */
public interface IVrNativeLibraryLoader extends IInterface {

    /* renamed from: com.google.vr.vrcore.library.api.IVrNativeLibraryLoader$Stub */
    public static abstract class Stub extends C0086b implements IVrNativeLibraryLoader {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader";
        static final int TRANSACTION_closeNativeGvrLibrary = 3;
        static final int TRANSACTION_loadNativeDlsymMethod = 4;
        static final int TRANSACTION_loadNativeGvrLibrary = 2;
        static final int TRANSACTION_loadNativeGvrLibraryWithMinVersion = 5;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.library.api.IVrNativeLibraryLoader$Stub$Proxy */
        public static class Proxy extends C0085a implements IVrNativeLibraryLoader {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public long loadNativeGvrLibrary(int i, int i2, int i3) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeInt(i2);
                obtainAndWriteInterfaceToken.writeInt(i3);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            public void closeNativeGvrLibrary(long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeLong(j);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            public long loadNativeDlsymMethod() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            public long loadNativeGvrLibraryWithMinVersion(String str, String str2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeString(str2);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }
        }

        public static IVrNativeLibraryLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrNativeLibraryLoader) {
                return (IVrNativeLibraryLoader) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    long loadNativeGvrLibrary = loadNativeGvrLibrary(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(loadNativeGvrLibrary);
                    break;
                case 3:
                    closeNativeGvrLibrary(parcel.readLong());
                    parcel2.writeNoException();
                    break;
                case 4:
                    long loadNativeDlsymMethod = loadNativeDlsymMethod();
                    parcel2.writeNoException();
                    parcel2.writeLong(loadNativeDlsymMethod);
                    break;
                case 5:
                    long loadNativeGvrLibraryWithMinVersion = loadNativeGvrLibraryWithMinVersion(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(loadNativeGvrLibraryWithMinVersion);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    void closeNativeGvrLibrary(long j) throws RemoteException;

    long loadNativeDlsymMethod() throws RemoteException;

    long loadNativeGvrLibrary(int i, int i2, int i3) throws RemoteException;

    long loadNativeGvrLibraryWithMinVersion(String str, String str2) throws RemoteException;
}
