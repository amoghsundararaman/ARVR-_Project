package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerPositionEvent */
public final class ControllerPositionEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerPositionEvent> CREATOR = new Parcelable.Creator<ControllerPositionEvent>() {
        public ControllerPositionEvent createFromParcel(Parcel parcel) {
            return new ControllerPositionEvent(parcel);
        }

        public ControllerPositionEvent[] newArray(int i) {
            return new ControllerPositionEvent[i];
        }
    };

    /* renamed from: x */
    public float f22x;

    /* renamed from: y */
    public float f23y;

    /* renamed from: z */
    public float f24z;

    public ControllerPositionEvent() {
    }

    public ControllerPositionEvent(float f, float f2, float f3) {
        this.f22x = f;
        this.f23y = f2;
        this.f24z = f3;
    }

    public ControllerPositionEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f22x);
        parcel.writeFloat(this.f23y);
        parcel.writeFloat(this.f24z);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f22x = parcel.readFloat();
        this.f23y = parcel.readFloat();
        this.f24z = parcel.readFloat();
    }

    public final int getByteSize() {
        return super.getByteSize() + 12;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerPositionEvent)) {
            throw new IllegalStateException("Cannot copy ControllerPositionEvent from non-ControllerPositionEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerPositionEvent controllerPositionEvent = (ControllerPositionEvent) controllerEvent;
        this.f22x = controllerPositionEvent.f22x;
        this.f23y = controllerPositionEvent.f23y;
        this.f24z = controllerPositionEvent.f24z;
    }
}
