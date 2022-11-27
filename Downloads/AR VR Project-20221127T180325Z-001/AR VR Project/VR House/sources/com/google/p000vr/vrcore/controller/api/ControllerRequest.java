package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.p000vr.vrcore.base.api.ParcelableProto;
import com.google.p000vr.vrcore.controller.api.nano.Proto;
import java.util.Arrays;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerRequest */
public class ControllerRequest extends ParcelableProto<Proto.Request> {
    public static final Parcelable.Creator<ControllerRequest> CREATOR = new Parcelable.Creator<ControllerRequest>() {
        public ControllerRequest createFromParcel(Parcel parcel) {
            return new ControllerRequest(parcel);
        }

        public ControllerRequest[] newArray(int i) {
            return new ControllerRequest[i];
        }
    };
    private static final int MAX_VIBRATION_DURATION_MS = 10000;

    public ControllerRequest() {
    }

    public ControllerRequest(byte[] bArr) {
        super(bArr);
    }

    public ControllerRequest(Parcel parcel) {
        super(parcel);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ControllerRequest) {
            return Arrays.equals(((ControllerRequest) obj).getData(), getData());
        }
        return false;
    }

    public Proto.Request getValidatedRequest() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        Proto.Request request = (Proto.Request) parseToProto(Proto.Request.class);
        checkArgument(request != null, "Failed to parse request proto data.", new Object[0]);
        if (request.vibration != null) {
            Proto.Request.Vibration vibration = request.vibration;
            if (vibration.getDurationMs() >= 0) {
                z = true;
            } else {
                z = false;
            }
            checkArgument(z, "Vibration duration should be non-negative", new Object[0]);
            if (vibration.getDurationMs() <= MAX_VIBRATION_DURATION_MS) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkArgument(z2, "Vibration duration can be at most %d", Integer.valueOf(MAX_VIBRATION_DURATION_MS));
            if (vibration.getVolumePercentage() >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            checkArgument(z3, "Volume should be positive", new Object[0]);
            if (vibration.getVolumePercentage() <= 100) {
                z4 = true;
            } else {
                z4 = false;
            }
            checkArgument(z4, "Volume should be at most 100.", new Object[0]);
            if (vibration.getFrequencyHz() <= 0) {
                z5 = false;
            }
            checkArgument(z5, "Vibration frequency be positive", new Object[0]);
        }
        return request;
    }

    private static void checkArgument(boolean z, String str, Object... objArr) {
        if (z) {
            return;
        }
        if (objArr.length == 0) {
            throw new IllegalArgumentException(str);
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }
}
