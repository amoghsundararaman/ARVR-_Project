package com.google.p000vr.vrcore.performance.api;

import android.content.ComponentName;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p000vr.sdk.common.deps.C0085a;
import com.google.p000vr.sdk.common.deps.C0086b;
import com.google.p000vr.sdk.common.deps.C0087c;
import com.google.p000vr.vrcore.performance.api.IThrottlingTriggerCallback;

/* renamed from: com.google.vr.vrcore.performance.api.IPerformanceService */
public interface IPerformanceService extends IInterface {

    /* renamed from: com.google.vr.vrcore.performance.api.IPerformanceService$Stub */
    public static abstract class Stub extends C0086b implements IPerformanceService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IPerformanceService";
        static final int TRANSACTION_addTrigger = 3;
        static final int TRANSACTION_getCurrentEstimatedThrottleWarningTime = 2;
        static final int TRANSACTION_getCurrentThrottlingRelativeTemperature = 1;
        static final int TRANSACTION_removeAllTriggers = 4;

        public Stub() {
            super(DESCRIPTOR);
        }

        /* renamed from: com.google.vr.vrcore.performance.api.IPerformanceService$Stub$Proxy */
        public static class Proxy extends C0085a implements IPerformanceService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public void getCurrentThrottlingRelativeTemperature(TimestampedTemperature timestampedTemperature) throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                if (transactAndReadException.readInt() != 0) {
                    timestampedTemperature.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
            }

            public long getCurrentEstimatedThrottleWarningTime() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            public void addTrigger(ComponentName componentName, IThrottlingTriggerCallback iThrottlingTriggerCallback, long j, float f, int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                C0087c.m5a(obtainAndWriteInterfaceToken, (IInterface) iThrottlingTriggerCallback);
                obtainAndWriteInterfaceToken.writeLong(j);
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            public void removeAllTriggers(ComponentName componentName) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                C0087c.m6a(obtainAndWriteInterfaceToken, (Parcelable) componentName);
                transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
            }
        }

        public static IPerformanceService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IPerformanceService) {
                return (IPerformanceService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    TimestampedTemperature timestampedTemperature = new TimestampedTemperature();
                    getCurrentThrottlingRelativeTemperature(timestampedTemperature);
                    parcel2.writeNoException();
                    C0087c.m9b(parcel2, timestampedTemperature);
                    break;
                case 2:
                    long currentEstimatedThrottleWarningTime = getCurrentEstimatedThrottleWarningTime();
                    parcel2.writeNoException();
                    parcel2.writeLong(currentEstimatedThrottleWarningTime);
                    break;
                case 3:
                    addTrigger((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR), IThrottlingTriggerCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong(), parcel.readFloat(), parcel.readInt());
                    parcel2.writeNoException();
                    break;
                case 4:
                    removeAllTriggers((ComponentName) C0087c.m4a(parcel, ComponentName.CREATOR));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    void addTrigger(ComponentName componentName, IThrottlingTriggerCallback iThrottlingTriggerCallback, long j, float f, int i) throws RemoteException;

    long getCurrentEstimatedThrottleWarningTime() throws RemoteException;

    void getCurrentThrottlingRelativeTemperature(TimestampedTemperature timestampedTemperature) throws RemoteException;

    void removeAllTriggers(ComponentName componentName) throws RemoteException;
}
