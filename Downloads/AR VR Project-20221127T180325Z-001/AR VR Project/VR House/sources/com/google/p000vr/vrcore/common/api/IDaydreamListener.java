package com.google.p000vr.vrcore.common.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;

/* renamed from: com.google.vr.vrcore.common.api.IDaydreamListener */
public interface IDaydreamListener extends IInterface {

    /* renamed from: com.google.vr.vrcore.common.api.IDaydreamListener$Stub */
    public static abstract class Stub extends C0086b implements IDaydreamListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamListener";
        static final int TRANSACTION_applyColorfulFade = 10;
        static final int TRANSACTION_applyFade = 3;
        static final int TRANSACTION_deprecated_setLensOffsets = 8;
        static final int TRANSACTION_dumpDebugData = 5;
        static final int TRANSACTION_getTargetApiVersion = 1;
        static final int TRANSACTION_invokeCloseAction = 7;
        static final int TRANSACTION_recenterHeadTracking = 4;
        static final int TRANSACTION_requestStopTracking = 2;
        static final int TRANSACTION_resumeHeadTracking = 6;
        static final int TRANSACTION_setLensOffset = 9;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.common.api.IDaydreamListener$Stub$Proxy */
        public static class Proxy extends C0085a implements IDaydreamListener {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public int getTargetApiVersion() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public HeadTrackingState requestStopTracking() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                HeadTrackingState headTrackingState = (HeadTrackingState) C0087c.m4a(transactAndReadException, HeadTrackingState.CREATOR);
                transactAndReadException.recycle();
                return headTrackingState;
            }

            public void applyFade(int i, long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeLong(j);
                transactOneway(3, obtainAndWriteInterfaceToken);
            }

            public void recenterHeadTracking() throws RemoteException {
                transactOneway(4, obtainAndWriteInterfaceToken());
            }

            public void dumpDebugData() throws RemoteException {
                transactOneway(5, obtainAndWriteInterfaceToken());
            }

            public void resumeHeadTracking(HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) headTrackingState);
                transactOneway(6, obtainAndWriteInterfaceToken);
            }

            public void invokeCloseAction() throws RemoteException {
                transactOneway(7, obtainAndWriteInterfaceToken());
            }

            public void deprecated_setLensOffsets(float f, float f2, float f3, float f4) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeFloat(f2);
                obtainAndWriteInterfaceToken.writeFloat(f3);
                obtainAndWriteInterfaceToken.writeFloat(f4);
                transactOneway(8, obtainAndWriteInterfaceToken);
            }

            public void setLensOffset(float f, float f2, float f3) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeFloat(f2);
                obtainAndWriteInterfaceToken.writeFloat(f3);
                transactOneway(9, obtainAndWriteInterfaceToken);
            }

            public void applyColorfulFade(int i, long j, int i2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeLong(j);
                obtainAndWriteInterfaceToken.writeInt(i2);
                transactOneway(10, obtainAndWriteInterfaceToken);
            }
        }

        public static IDaydreamListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IDaydreamListener) {
                return (IDaydreamListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    int targetApiVersion = getTargetApiVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(targetApiVersion);
                    break;
                case 2:
                    HeadTrackingState requestStopTracking = requestStopTracking();
                    parcel2.writeNoException();
                    C0087c.m9b(parcel2, requestStopTracking);
                    break;
                case 3:
                    applyFade(parcel.readInt(), parcel.readLong());
                    break;
                case 4:
                    recenterHeadTracking();
                    break;
                case 5:
                    dumpDebugData();
                    break;
                case 6:
                    resumeHeadTracking((HeadTrackingState) C0087c.m4a(parcel, HeadTrackingState.CREATOR));
                    break;
                case 7:
                    invokeCloseAction();
                    break;
                case 8:
                    deprecated_setLensOffsets(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                    break;
                case 9:
                    setLensOffset(parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                    break;
                case 10:
                    applyColorfulFade(parcel.readInt(), parcel.readLong(), parcel.readInt());
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    void applyColorfulFade(int i, long j, int i2) throws RemoteException;

    void applyFade(int i, long j) throws RemoteException;

    void deprecated_setLensOffsets(float f, float f2, float f3, float f4) throws RemoteException;

    void dumpDebugData() throws RemoteException;

    int getTargetApiVersion() throws RemoteException;

    void invokeCloseAction() throws RemoteException;

    void recenterHeadTracking() throws RemoteException;

    HeadTrackingState requestStopTracking() throws RemoteException;

    void resumeHeadTracking(HeadTrackingState headTrackingState) throws RemoteException;

    void setLensOffset(float f, float f2, float f3) throws RemoteException;
}
