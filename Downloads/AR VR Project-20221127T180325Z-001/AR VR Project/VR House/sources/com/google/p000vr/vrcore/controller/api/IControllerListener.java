package com.google.p000vr.vrcore.controller.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;

/* renamed from: com.google.vr.vrcore.controller.api.IControllerListener */
public interface IControllerListener extends IInterface {

    /* renamed from: com.google.vr.vrcore.controller.api.IControllerListener$Stub */
    public static abstract class Stub extends C0086b implements IControllerListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerListener";
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_getOptions = 9;
        static final int TRANSACTION_onControllerEventPacket = 10;
        static final int TRANSACTION_onControllerEventPacket2 = 12;
        static final int TRANSACTION_onControllerRecentered = 11;
        static final int TRANSACTION_onControllerStateChanged = 2;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.controller.api.IControllerListener$Stub$Proxy */
        public static class Proxy extends C0085a implements IControllerListener {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public int getApiVersion() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public void onControllerStateChanged(int i, int i2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeInt(i2);
                transactOneway(2, obtainAndWriteInterfaceToken);
            }

            public ControllerListenerOptions getOptions() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
                ControllerListenerOptions controllerListenerOptions = (ControllerListenerOptions) C0087c.m4a(transactAndReadException, ControllerListenerOptions.CREATOR);
                transactAndReadException.recycle();
                return controllerListenerOptions;
            }

            public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) controllerEventPacket);
                transactOneway(10, obtainAndWriteInterfaceToken);
            }

            public void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) controllerOrientationEvent);
                transactOneway(11, obtainAndWriteInterfaceToken);
            }

            public void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) controllerEventPacket2);
                transactOneway(12, obtainAndWriteInterfaceToken);
            }
        }

        public static IControllerListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IControllerListener) {
                return (IControllerListener) queryLocalInterface;
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
                    onControllerStateChanged(parcel.readInt(), parcel.readInt());
                    break;
                case 9:
                    ControllerListenerOptions options = getOptions();
                    parcel2.writeNoException();
                    C0087c.m9b(parcel2, options);
                    break;
                case 10:
                    onControllerEventPacket((ControllerEventPacket) C0087c.m4a(parcel, ControllerEventPacket.CREATOR));
                    break;
                case 11:
                    onControllerRecentered((ControllerOrientationEvent) C0087c.m4a(parcel, ControllerOrientationEvent.CREATOR));
                    break;
                case 12:
                    onControllerEventPacket2((ControllerEventPacket2) C0087c.m4a(parcel, ControllerEventPacket2.CREATOR));
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    int getApiVersion() throws RemoteException;

    ControllerListenerOptions getOptions() throws RemoteException;

    void onControllerEventPacket(ControllerEventPacket controllerEventPacket) throws RemoteException;

    void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) throws RemoteException;

    void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) throws RemoteException;

    void onControllerStateChanged(int i, int i2) throws RemoteException;
}
