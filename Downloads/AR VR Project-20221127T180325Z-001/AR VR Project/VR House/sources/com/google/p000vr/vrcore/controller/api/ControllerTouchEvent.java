package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerTouchEvent */
public final class ControllerTouchEvent extends ControllerEvent {
    public static final int ACTION_CANCEL = 4;
    public static final int ACTION_DOWN = 1;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_UP = 3;
    public static final Parcelable.Creator<ControllerTouchEvent> CREATOR = new Parcelable.Creator<ControllerTouchEvent>() {
        public ControllerTouchEvent createFromParcel(Parcel parcel) {
            return new ControllerTouchEvent(parcel);
        }

        public ControllerTouchEvent[] newArray(int i) {
            return new ControllerTouchEvent[i];
        }
    };
    public int action;
    public int fingerId;

    /* renamed from: x */
    public float f25x;

    /* renamed from: y */
    public float f26y;

    public ControllerTouchEvent() {
    }

    public ControllerTouchEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fingerId);
        parcel.writeInt(this.action);
        parcel.writeFloat(this.f25x);
        parcel.writeFloat(this.f26y);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.fingerId = parcel.readInt();
        this.action = parcel.readInt();
        this.f25x = parcel.readFloat();
        this.f26y = parcel.readFloat();
    }

    public final int getByteSize() {
        return super.getByteSize() + 8 + 8;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerTouchEvent)) {
            throw new IllegalStateException("Cannot copy ControllerTouchEvent from non-ControllerTouchEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerTouchEvent controllerTouchEvent = (ControllerTouchEvent) controllerEvent;
        this.fingerId = controllerTouchEvent.fingerId;
        this.action = controllerTouchEvent.action;
        this.f25x = controllerTouchEvent.f25x;
        this.f26y = controllerTouchEvent.f26y;
    }
}
