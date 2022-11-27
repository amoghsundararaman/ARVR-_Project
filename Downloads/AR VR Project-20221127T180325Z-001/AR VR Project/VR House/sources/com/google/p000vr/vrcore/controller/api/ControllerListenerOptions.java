package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerListenerOptions */
public class ControllerListenerOptions implements Parcelable {
    public static final Parcelable.Creator<ControllerListenerOptions> CREATOR = new Parcelable.Creator<ControllerListenerOptions>() {
        public ControllerListenerOptions createFromParcel(Parcel parcel) {
            return new ControllerListenerOptions(parcel);
        }

        public ControllerListenerOptions[] newArray(int i) {
            return new ControllerListenerOptions[i];
        }
    };
    public static final int GVR_CONTROLLER_ENABLE_ACCEL = 8;
    public static final int GVR_CONTROLLER_ENABLE_GESTURES = 16;
    public static final int GVR_CONTROLLER_ENABLE_GYRO = 4;
    public static final int GVR_CONTROLLER_ENABLE_ORIENTATION = 1;
    public static final int GVR_CONTROLLER_ENABLE_TOUCH = 2;
    public boolean enableAccel;
    public boolean enableGestures;
    public boolean enableGyro;
    public boolean enableOrientation;
    public boolean enableTouch;

    public ControllerListenerOptions() {
        this.enableOrientation = true;
        this.enableTouch = true;
    }

    public ControllerListenerOptions(int i) {
        if ((i & 1) != 0) {
            this.enableOrientation = true;
        }
        if ((i & 2) != 0) {
            this.enableTouch = true;
        }
        if ((i & 4) != 0) {
            this.enableGyro = true;
        }
        if ((i & 8) != 0) {
            this.enableAccel = true;
        }
        if ((i & 16) != 0) {
            this.enableGestures = true;
        }
    }

    protected ControllerListenerOptions(Parcel parcel) {
        readFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        parcel.writeInt(this.enableOrientation ? 1 : 0);
        if (this.enableGyro) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.enableAccel) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (this.enableTouch) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeInt(i4);
        if (!this.enableGestures) {
            i5 = 0;
        }
        parcel.writeInt(i5);
    }

    public void readFromParcel(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.enableOrientation = parcel.readInt() != 0;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.enableGyro = z;
        if (parcel.readInt() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.enableAccel = z2;
        if (parcel.readInt() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.enableTouch = z3;
        if (parcel.readInt() == 0) {
            z4 = false;
        }
        this.enableGestures = z4;
    }

    public String toString() {
        return String.format(Locale.US, "ori=%b, gyro=%b, accel=%b, touch=%b, gestures=%b", new Object[]{Boolean.valueOf(this.enableOrientation), Boolean.valueOf(this.enableGyro), Boolean.valueOf(this.enableAccel), Boolean.valueOf(this.enableTouch), Boolean.valueOf(this.enableGestures)});
    }
}
