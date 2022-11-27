package com.google.p000vr.vrcore.base.api;

/* renamed from: com.google.vr.vrcore.base.api.VrCoreNotAvailableException */
public final class VrCoreNotAvailableException extends Exception {
    public final int errorCode;

    public VrCoreNotAvailableException(int i) {
        super(VrCoreUtils.getConnectionResultString(i));
        this.errorCode = i;
    }
}
