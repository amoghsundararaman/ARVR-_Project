package com.google.p000vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;
import com.google.p000vr.vrcore.library.api.IObjectWrapper;

/* renamed from: com.google.vr.vrcore.library.api.IGvrUiLayout */
public interface IGvrUiLayout extends IInterface {

    /* renamed from: com.google.vr.vrcore.library.api.IGvrUiLayout$Stub */
    public static abstract class Stub extends C0086b implements IGvrUiLayout {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IGvrUiLayout";
        static final int TRANSACTION_getRootView = 2;
        static final int TRANSACTION_isEnabled = 4;
        static final int TRANSACTION_setCloseButtonListener = 5;
        static final int TRANSACTION_setEnabled = 3;
        static final int TRANSACTION_setSettingsButtonEnabled = 8;
        static final int TRANSACTION_setSettingsButtonListener = 9;
        static final int TRANSACTION_setTransitionViewEnabled = 6;
        static final int TRANSACTION_setTransitionViewListener = 7;
        static final int TRANSACTION_setViewerName = 10;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.library.api.IGvrUiLayout$Stub$Proxy */
        public static class Proxy extends C0085a implements IGvrUiLayout {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public IObjectWrapper getRootView() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public void setEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m7a(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            public boolean isEnabled() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public void setCloseButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
            }

            public void setTransitionViewEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m7a(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
            }

            public void setTransitionViewListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
            }

            public void setSettingsButtonEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m7a(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
            }

            public void setSettingsButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
            }

            public void setViewerName(String str) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
            }
        }

        public static IGvrUiLayout asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IGvrUiLayout) {
                return (IGvrUiLayout) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper rootView = getRootView();
                    parcel2.writeNoException();
                    C0087c.m5a(parcel2, (IInterface) rootView);
                    break;
                case 3:
                    setEnabled(C0087c.m8a(parcel));
                    parcel2.writeNoException();
                    break;
                case 4:
                    boolean isEnabled = isEnabled();
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, isEnabled);
                    break;
                case 5:
                    setCloseButtonListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 6:
                    setTransitionViewEnabled(C0087c.m8a(parcel));
                    parcel2.writeNoException();
                    break;
                case 7:
                    setTransitionViewListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 8:
                    setSettingsButtonEnabled(C0087c.m8a(parcel));
                    parcel2.writeNoException();
                    break;
                case 9:
                    setSettingsButtonListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 10:
                    setViewerName(parcel.readString());
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getRootView() throws RemoteException;

    boolean isEnabled() throws RemoteException;

    void setCloseButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setEnabled(boolean z) throws RemoteException;

    void setSettingsButtonEnabled(boolean z) throws RemoteException;

    void setSettingsButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setTransitionViewEnabled(boolean z) throws RemoteException;

    void setTransitionViewListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setViewerName(String str) throws RemoteException;
}
