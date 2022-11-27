package com.google.p000vr.vrcore.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.p000vr.sdk.proto.nano.Session;
import com.google.p000vr.vrcore.base.api.ParcelableProto;
import java.util.Arrays;

/* renamed from: com.google.vr.vrcore.common.api.HeadTrackingState */
public class HeadTrackingState extends ParcelableProto<Session.TrackerState> {
    public static final Parcelable.Creator<HeadTrackingState> CREATOR = new Parcelable.Creator<HeadTrackingState>() {
        public HeadTrackingState createFromParcel(Parcel parcel) {
            return new HeadTrackingState(parcel);
        }

        public HeadTrackingState[] newArray(int i) {
            return new HeadTrackingState[i];
        }
    };

    public HeadTrackingState() {
    }

    public HeadTrackingState(byte[] bArr) {
        super(bArr);
    }

    private HeadTrackingState(Parcel parcel) {
        super(parcel);
    }

    /* access modifiers changed from: protected */
    public final boolean shouldSerializeDataLength() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldSerializeEmptyInsteadOfNullBuffer() {
        return true;
    }

    public String toString() {
        return new StringBuilder(36).append("HeadTrackingState[").append(getSizeBytes()).append(" bytes]").toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeadTrackingState) {
            return Arrays.equals(((HeadTrackingState) obj).getData(), getData());
        }
        return false;
    }
}
