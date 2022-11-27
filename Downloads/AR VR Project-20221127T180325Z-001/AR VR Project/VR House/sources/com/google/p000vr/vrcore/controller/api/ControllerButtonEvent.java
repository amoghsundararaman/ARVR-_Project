package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerButtonEvent */
public final class ControllerButtonEvent extends ControllerEvent {
    public static final int[] ALL_BUTTONS = {0, 1, 2, 3, 5, 6};
    public static final int BUTTON_APP = 3;
    public static final int BUTTON_CLICK = 1;
    public static final int BUTTON_COUNT = 8;
    public static final int BUTTON_HOME = 2;
    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_TRIGGER = 7;
    public static final int BUTTON_VOLUME_DOWN = 6;
    public static final int BUTTON_VOLUME_UP = 5;
    public static final Parcelable.Creator<ControllerButtonEvent> CREATOR = new Parcelable.Creator<ControllerButtonEvent>() {
        public ControllerButtonEvent createFromParcel(Parcel parcel) {
            return new ControllerButtonEvent(parcel);
        }

        public ControllerButtonEvent[] newArray(int i) {
            return new ControllerButtonEvent[i];
        }
    };
    public int button;
    public boolean down;

    public ControllerButtonEvent() {
    }

    public ControllerButtonEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.button);
        parcel.writeInt(this.down ? 1 : 0);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.button = parcel.readInt();
        this.down = parcel.readInt() != 0;
    }

    public static String buttonToString(int i) {
        switch (i) {
            case 0:
                return "BUTTON_NONE";
            case 1:
                return "BUTTON_CLICK";
            case 2:
                return "BUTTON_HOME";
            case 3:
                return "BUTTON_APP";
            case 5:
                return "BUTTON_VOLUME_UP";
            case 6:
                return "BUTTON_VOLUME_DOWN";
            case 7:
                return "BUTTON_TRIGGER";
            default:
                return new StringBuilder(29).append("[Unknown button: ").append(i).append("]").toString();
        }
    }

    public final int getByteSize() {
        return super.getByteSize() + 8;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerButtonEvent)) {
            throw new IllegalStateException("Cannot copy ControllerButtonEvent from non-ControllerButtonEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerButtonEvent controllerButtonEvent = (ControllerButtonEvent) controllerEvent;
        this.button = controllerButtonEvent.button;
        this.down = controllerButtonEvent.down;
    }
}
