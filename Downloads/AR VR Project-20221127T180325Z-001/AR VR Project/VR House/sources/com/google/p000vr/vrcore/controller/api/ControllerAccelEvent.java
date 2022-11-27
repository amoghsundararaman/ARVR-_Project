package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerAccelEvent */
public final class ControllerAccelEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerAccelEvent> CREATOR = new Parcelable.Creator<ControllerAccelEvent>() {
        public ControllerAccelEvent createFromParcel(Parcel parcel) {
            return new ControllerAccelEvent(parcel);
        }

        public ControllerAccelEvent[] newArray(int i) {
            return new ControllerAccelEvent[i];
        }
    };

    /* renamed from: x */
    public float f12x;

    /* renamed from: y */
    public float f13y;

    /* renamed from: z */
    public float f14z;

    public ControllerAccelEvent() {
    }

    public ControllerAccelEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f12x);
        parcel.writeFloat(this.f13y);
        parcel.writeFloat(this.f14z);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f12x = parcel.readFloat();
        this.f13y = parcel.readFloat();
        this.f14z = parcel.readFloat();
    }

    public final int getByteSize() {
        return super.getByteSize() + 12;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerAccelEvent)) {
            throw new IllegalStateException("Cannot copy ControllerAccelEvent from non-ControllerAccelEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerAccelEvent controllerAccelEvent = (ControllerAccelEvent) controllerEvent;
        this.f12x = controllerAccelEvent.f12x;
        this.f13y = controllerAccelEvent.f13y;
        this.f14z = controllerAccelEvent.f14z;
    }
}
