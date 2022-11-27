package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerGyroEvent */
public final class ControllerGyroEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerGyroEvent> CREATOR = new Parcelable.Creator<ControllerGyroEvent>() {
        public ControllerGyroEvent createFromParcel(Parcel parcel) {
            return new ControllerGyroEvent(parcel);
        }

        public ControllerGyroEvent[] newArray(int i) {
            return new ControllerGyroEvent[i];
        }
    };

    /* renamed from: x */
    public float f15x;

    /* renamed from: y */
    public float f16y;

    /* renamed from: z */
    public float f17z;

    public ControllerGyroEvent() {
    }

    public ControllerGyroEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f15x);
        parcel.writeFloat(this.f16y);
        parcel.writeFloat(this.f17z);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f15x = parcel.readFloat();
        this.f16y = parcel.readFloat();
        this.f17z = parcel.readFloat();
    }

    public final int getByteSize() {
        return super.getByteSize() + 12;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerGyroEvent)) {
            throw new IllegalStateException("Cannot copy ControllerGyroEvent from non-ControllerGyroEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerGyroEvent controllerGyroEvent = (ControllerGyroEvent) controllerEvent;
        this.f15x = controllerGyroEvent.f15x;
        this.f16y = controllerGyroEvent.f16y;
        this.f17z = controllerGyroEvent.f17z;
    }
}
