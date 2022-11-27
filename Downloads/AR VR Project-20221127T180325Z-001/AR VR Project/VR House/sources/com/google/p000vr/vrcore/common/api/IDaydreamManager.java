package com.google.p000vr.vrcore.common.api;

import android.app.PendingIntent;
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
import com.google.p000vr.vrcore.common.api.IDaydreamListener;
import com.google.p000vr.vrcore.common.api.ITransitionCallbacks;

/* renamed from: com.google.vr.vrcore.common.api.IDaydreamManager */
public interface IDaydreamManager extends IInterface {

    /* renamed from: com.google.vr.vrcore.common.api.IDaydreamManager$Stub */
    public static abstract class Stub extends C0086b implements IDaydreamManager {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamManager";
        static final int TRANSACTION_deprecatedExitFromVr = 10;
        static final int TRANSACTION_deprecatedLaunchInVr = 4;
        static final int TRANSACTION_exitFromVr2 = 17;
        static final int TRANSACTION_handleInsertionIntoHeadset = 11;
        static final int TRANSACTION_handleRemovalFromHeadset = 12;
        static final int TRANSACTION_launchInVr = 7;
        static final int TRANSACTION_launchVrHome = 8;
        static final int TRANSACTION_launchVrTransition = 9;
        static final int TRANSACTION_launchVrTransition2 = 15;
        static final int TRANSACTION_onExitingFromVr = 14;
        static final int TRANSACTION_prepareVr = 3;
        static final int TRANSACTION_prepareVr2 = 13;
        static final int TRANSACTION_prepareVr3 = 16;
        static final int TRANSACTION_registerDaydreamIntent = 5;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_unregisterDaydreamIntent = 6;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.common.api.IDaydreamManager$Stub$Proxy */
        public static class Proxy extends C0085a implements IDaydreamManager {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public boolean registerListener(ComponentName componentName, IDaydreamListener iDaydreamListener) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iDaydreamListener);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean unregisterListener(ComponentName componentName) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public int prepareVr(ComponentName componentName, HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                if (transactAndReadException.readInt() != 0) {
                    headTrackingState.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
                return readInt;
            }

            public boolean deprecatedLaunchInVr(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) pendingIntent);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public void registerDaydreamIntent(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) pendingIntent);
                transactOneway(5, obtainAndWriteInterfaceToken);
            }

            public void unregisterDaydreamIntent() throws RemoteException {
                transactOneway(6, obtainAndWriteInterfaceToken());
            }

            public boolean launchInVr(PendingIntent pendingIntent, ComponentName componentName) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) pendingIntent);
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean launchVrHome() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean launchVrTransition(ITransitionCallbacks iTransitionCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iTransitionCallbacks);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public boolean deprecatedExitFromVr(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) pendingIntent);
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }

            public void handleInsertionIntoHeadset(byte[] bArr) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                transactOneway(11, obtainAndWriteInterfaceToken);
            }

            public void handleRemovalFromHeadset() throws RemoteException {
                transactOneway(12, obtainAndWriteInterfaceToken());
            }

            public int prepareVr2(ComponentName componentName, int i, PendingIntent pendingIntent, HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                obtainAndWriteInterfaceToken.writeInt(i);
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) pendingIntent);
                Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                if (transactAndReadException.readInt() != 0) {
                    headTrackingState.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
                return readInt;
            }

            public void onExitingFromVr() throws RemoteException {
                transactOneway(14, obtainAndWriteInterfaceToken());
            }

            public void launchVrTransition2(Bundle bundle) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) bundle);
                transactOneway(15, obtainAndWriteInterfaceToken);
            }

            public int prepareVr3(Bundle bundle, HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) bundle);
                Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                if (transactAndReadException.readInt() != 0) {
                    headTrackingState.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
                return readInt;
            }

            public boolean exitFromVr2(Bundle bundle) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) bundle);
                Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
                boolean a = C0087c.m8a(transactAndReadException);
                transactAndReadException.recycle();
                return a;
            }
        }

        public static IDaydreamManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IDaydreamManager) {
                return (IDaydreamManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    boolean registerListener = registerListener((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR), IDaydreamListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, registerListener);
                    break;
                case 2:
                    boolean unregisterListener = unregisterListener((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, unregisterListener);
                    break;
                case 3:
                    HeadTrackingState headTrackingState = new HeadTrackingState();
                    int prepareVr = prepareVr((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR), headTrackingState);
                    parcel2.writeNoException();
                    parcel2.writeInt(prepareVr);
                    C0087c.m9b(parcel2, headTrackingState);
                    break;
                case 4:
                    boolean deprecatedLaunchInVr = deprecatedLaunchInVr((PendingIntent) C0087c.m4a(parcel, PendingIntent.CREATOR));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, deprecatedLaunchInVr);
                    break;
                case 5:
                    registerDaydreamIntent((PendingIntent) C0087c.m4a(parcel, PendingIntent.CREATOR));
                    break;
                case 6:
                    unregisterDaydreamIntent();
                    break;
                case 7:
                    boolean launchInVr = launchInVr((PendingIntent) C0087c.m4a(parcel, PendingIntent.CREATOR), (ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, launchInVr);
                    break;
                case 8:
                    boolean launchVrHome = launchVrHome();
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, launchVrHome);
                    break;
                case 9:
                    boolean launchVrTransition = launchVrTransition(ITransitionCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, launchVrTransition);
                    break;
                case 10:
                    boolean deprecatedExitFromVr = deprecatedExitFromVr((PendingIntent) C0087c.m4a(parcel, PendingIntent.CREATOR));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, deprecatedExitFromVr);
                    break;
                case 11:
                    handleInsertionIntoHeadset(parcel.createByteArray());
                    break;
                case 12:
                    handleRemovalFromHeadset();
                    break;
                case 13:
                    HeadTrackingState headTrackingState2 = new HeadTrackingState();
                    int prepareVr2 = prepareVr2((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR), parcel.readInt(), (PendingIntent) C0087c.m4a(parcel, PendingIntent.CREATOR), headTrackingState2);
                    parcel2.writeNoException();
                    parcel2.writeInt(prepareVr2);
                    C0087c.m9b(parcel2, headTrackingState2);
                    break;
                case 14:
                    onExitingFromVr();
                    break;
                case 15:
                    launchVrTransition2((Bundle) C0087c.m4a(parcel, Bundle.CREATOR));
                    break;
                case 16:
                    HeadTrackingState headTrackingState3 = new HeadTrackingState();
                    int prepareVr3 = prepareVr3((Bundle) C0087c.m4a(parcel, Bundle.CREATOR), headTrackingState3);
                    parcel2.writeNoException();
                    parcel2.writeInt(prepareVr3);
                    C0087c.m9b(parcel2, headTrackingState3);
                    break;
                case 17:
                    boolean exitFromVr2 = exitFromVr2((Bundle) C0087c.m4a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0087c.m7a(parcel2, exitFromVr2);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    boolean deprecatedExitFromVr(PendingIntent pendingIntent) throws RemoteException;

    boolean deprecatedLaunchInVr(PendingIntent pendingIntent) throws RemoteException;

    boolean exitFromVr2(Bundle bundle) throws RemoteException;

    void handleInsertionIntoHeadset(byte[] bArr) throws RemoteException;

    void handleRemovalFromHeadset() throws RemoteException;

    boolean launchInVr(PendingIntent pendingIntent, ComponentName componentName) throws RemoteException;

    boolean launchVrHome() throws RemoteException;

    boolean launchVrTransition(ITransitionCallbacks iTransitionCallbacks) throws RemoteException;

    void launchVrTransition2(Bundle bundle) throws RemoteException;

    void onExitingFromVr() throws RemoteException;

    int prepareVr(ComponentName componentName, HeadTrackingState headTrackingState) throws RemoteException;

    int prepareVr2(ComponentName componentName, int i, PendingIntent pendingIntent, HeadTrackingState headTrackingState) throws RemoteException;

    int prepareVr3(Bundle bundle, HeadTrackingState headTrackingState) throws RemoteException;

    void registerDaydreamIntent(PendingIntent pendingIntent) throws RemoteException;

    boolean registerListener(ComponentName componentName, IDaydreamListener iDaydreamListener) throws RemoteException;

    void unregisterDaydreamIntent() throws RemoteException;

    boolean unregisterListener(ComponentName componentName) throws RemoteException;
}
