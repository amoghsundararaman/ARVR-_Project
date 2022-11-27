package com.google.p000vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;
import com.google.p000vr.vrcore.library.api.IGvrUiLayout;
import com.google.p000vr.vrcore.library.api.IObjectWrapper;

/* renamed from: com.google.vr.vrcore.library.api.IGvrLayout */
public interface IGvrLayout extends IInterface {

    /* renamed from: com.google.vr.vrcore.library.api.IGvrLayout$Stub */
    public static abstract class Stub extends C0086b implements IGvrLayout {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IGvrLayout";
        static final int TRANSACTION_enableAsyncReprojection = 9;
        static final int TRANSACTION_enableCardboardTriggerEmulation = 10;
        static final int TRANSACTION_getNativeGvrContext = 2;
        static final int TRANSACTION_getRootView = 3;
        static final int TRANSACTION_getUiLayout = 4;
        static final int TRANSACTION_onBackPressed = 12;
        static final int TRANSACTION_onPause = 5;
        static final int TRANSACTION_onResume = 6;
        static final int TRANSACTION_setOnDonNotNeededListener = 14;
        static final int TRANSACTION_setPresentationView = 8;
        static final int TRANSACTION_setReentryIntent = 13;
        static final int TRANSACTION_setStereoModeEnabled = 11;
        static final int TRANSACTION_shutdown = 7;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.library.api.IGvrLayout$Stub$Proxy */
        public static class Proxy extends C0085a implements IGvrLayout {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public long getNativeGvrContext() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            public IObjectWrapper getRootView() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IGvrUiLayout getUiLayout() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                IGvrUiLayout asInterface = IGvrUiLayout.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public void onPause() throws RemoteException {
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken());
            }

            public void onResume() throws RemoteException {
                transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken());
            }

            public void shutdown() throws RemoteException {
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken());
            }

            public void setPresentationView(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
            }

            public boolean enableAsyncReprojection(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean enableCardboardTriggerEmulation(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public void setStereoModeEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m7a(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
            }

            public void onBackPressed() throws RemoteException {
                transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken());
            }

            public void setReentryIntent(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
            }

            public boolean setOnDonNotNeededListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }
        }

        public static IGvrLayout asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IGvrLayout) {
                return (IGvrLayout) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    long nativeGvrContext = getNativeGvrContext();
                    parcel2.writeNoException();
                    parcel2.writeLong(nativeGvrContext);
                    break;
                case 3:
                    IObjectWrapper rootView = getRootView();
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) rootView);
                    break;
                case 4:
                    IGvrUiLayout uiLayout = getUiLayout();
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) uiLayout);
                    break;
                case 5:
                    onPause();
                    parcel2.writeNoException();
                    break;
                case 6:
                    onResume();
                    parcel2.writeNoException();
                    break;
                case 7:
                    shutdown();
                    parcel2.writeNoException();
                    break;
                case 8:
                    setPresentationView(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 9:
                    boolean enableAsyncReprojection = enableAsyncReprojection(parcel.readInt());
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, enableAsyncReprojection);
                    break;
                case 10:
                    boolean enableCardboardTriggerEmulation = enableCardboardTriggerEmulation(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, enableCardboardTriggerEmulation);
                    break;
                case 11:
                    setStereoModeEnabled(C0087c.m8a(parcel));
                    parcel2.writeNoException();
                    break;
                case 12:
                    onBackPressed();
                    parcel2.writeNoException();
                    break;
                case 13:
                    setReentryIntent(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 14:
                    boolean onDonNotNeededListener = setOnDonNotNeededListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, onDonNotNeededListener);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    boolean enableAsyncReprojection(int i) throws RemoteException;

    boolean enableCardboardTriggerEmulation(IObjectWrapper iObjectWrapper) throws RemoteException;

    long getNativeGvrContext() throws RemoteException;

    IObjectWrapper getRootView() throws RemoteException;

    IGvrUiLayout getUiLayout() throws RemoteException;

    void onBackPressed() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    boolean setOnDonNotNeededListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setPresentationView(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setReentryIntent(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setStereoModeEnabled(boolean z) throws RemoteException;

    void shutdown() throws RemoteException;
}
