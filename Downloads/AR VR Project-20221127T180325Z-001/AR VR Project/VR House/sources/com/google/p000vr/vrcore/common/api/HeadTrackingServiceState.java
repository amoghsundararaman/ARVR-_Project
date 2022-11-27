package com.google.p000vr.vrcore.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.p000vr.sdk.proto.nano.Session;
import com.google.p000vr.vrcore.base.api.ParcelableProto;
import java.util.Arrays;

/* renamed from: com.google.vr.vrcore.common.api.HeadTrackingServiceState */
public class HeadTrackingServiceState extends ParcelableProto<Session.HeadTrackingServiceState> {
    public static final Parcelable.Creator<HeadTrackingServiceState> CREATOR = new Parcelable.Creator<HeadTrackingServiceState>() {
        public HeadTrackingServiceState createFromParcel(Parcel parcel) {
            return new HeadTrackingServiceState(parcel);
        }

        public HeadTrackingServiceState[] newArray(int i) {
            return new HeadTrackingServiceState[i];
        }
    };

    public HeadTrackingServiceState() {
    }

    public HeadTrackingServiceState(byte[] bArr) {
        super(bArr);
    }

    public HeadTrackingServiceState(Session.HeadTrackingServiceState headTrackingServiceState) {
        super(headTrackingServiceState);
    }

    private HeadTrackingServiceState(Parcel parcel) {
        super(parcel);
    }

    public String toString() {
        return new StringBuilder(43).append("HeadTrackingServiceState[").append(getSizeBytes()).append(" bytes]").toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeadTrackingServiceState) {
            return Arrays.equals(((HeadTrackingServiceState) obj).getData(), getData());
        }
        return false;
    }
}
