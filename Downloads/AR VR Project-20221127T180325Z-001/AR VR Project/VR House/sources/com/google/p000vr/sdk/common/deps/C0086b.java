package com.google.p000vr.sdk.common.deps;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.vr.sdk.common.deps.b */
public class C0086b extends Binder implements IInterface {
    private static C0088d globalInterceptor = null;

    static synchronized void installTransactionInterceptorPackagePrivate(C0088d dVar) {
        synchronized (C0086b.class) {
            if (dVar == null) {
                throw new IllegalArgumentException("null interceptor");
            } else if (globalInterceptor != null) {
                throw new IllegalStateException("Duplicate TransactionInterceptor installation.");
            } else {
                globalInterceptor = dVar;
            }
        }
    }

    protected C0086b(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean routeToSuperOrEnforceInterface(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
            return true;
        }
        if (globalInterceptor == null) {
            return dispatchTransaction(i, parcel, parcel2, i2);
        }
        return globalInterceptor.mo935a();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }
}
