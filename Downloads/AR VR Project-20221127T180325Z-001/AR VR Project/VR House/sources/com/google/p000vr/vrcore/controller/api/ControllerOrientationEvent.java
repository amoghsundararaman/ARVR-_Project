package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerOrientationEvent */
public final class ControllerOrientationEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerOrientationEvent> CREATOR = new Parcelable.Creator<ControllerOrientationEvent>() {
        public ControllerOrientationEvent createFromParcel(Parcel parcel) {
            return new ControllerOrientationEvent(parcel);
        }

        public ControllerOrientationEvent[] newArray(int i) {
            return new ControllerOrientationEvent[i];
        }
    };

    /* renamed from: qw */
    public float f18qw;

    /* renamed from: qx */
    public float f19qx;

    /* renamed from: qy */
    public float f20qy;

    /* renamed from: qz */
    public float f21qz;

    public ControllerOrientationEvent() {
    }

    public ControllerOrientationEvent(float f, float f2, float f3, float f4) {
        this.f19qx = f;
        this.f20qy = f2;
        this.f21qz = f3;
        this.f18qw = f4;
    }

    public ControllerOrientationEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final void set(ControllerOrientationEvent controllerOrientationEvent) {
        this.f19qx = controllerOrientationEvent.f19qx;
        this.f20qy = controllerOrientationEvent.f20qy;
        this.f21qz = controllerOrientationEvent.f21qz;
        this.f18qw = controllerOrientationEvent.f18qw;
    }

    public final void normalize() {
        float sqrt = (float) Math.sqrt((double) ((this.f19qx * this.f19qx) + (this.f20qy * this.f20qy) + (this.f21qz * this.f21qz) + (this.f18qw * this.f18qw)));
        this.f19qx /= sqrt;
        this.f20qy /= sqrt;
        this.f21qz /= sqrt;
        this.f18qw /= sqrt;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f19qx);
        parcel.writeFloat(this.f20qy);
        parcel.writeFloat(this.f21qz);
        parcel.writeFloat(this.f18qw);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f19qx = parcel.readFloat();
        this.f20qy = parcel.readFloat();
        this.f21qz = parcel.readFloat();
        this.f18qw = parcel.readFloat();
    }

    public final int getByteSize() {
        return super.getByteSize() + 16;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerOrientationEvent)) {
            throw new IllegalStateException("Cannot copy ControllerOrientationEvent from non-ControllerOrientationEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerOrientationEvent controllerOrientationEvent = (ControllerOrientationEvent) controllerEvent;
        this.f19qx = controllerOrientationEvent.f19qx;
        this.f20qy = controllerOrientationEvent.f20qy;
        this.f21qz = controllerOrientationEvent.f21qz;
        this.f18qw = controllerOrientationEvent.f18qw;
    }
}
