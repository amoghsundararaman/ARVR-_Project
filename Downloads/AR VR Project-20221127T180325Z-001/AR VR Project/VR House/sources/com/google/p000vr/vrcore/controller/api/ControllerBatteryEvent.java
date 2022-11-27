package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerBatteryEvent */
public final class ControllerBatteryEvent extends ControllerEvent {
    public static final int BATTERY_LEVEL_ALMOST_FULL = 4;
    public static final int BATTERY_LEVEL_COUNT = 6;
    public static final int BATTERY_LEVEL_CRITICAL_LOW = 1;
    public static final int BATTERY_LEVEL_FULL = 5;
    public static final int BATTERY_LEVEL_LOW = 2;
    public static final int BATTERY_LEVEL_MEDIUM = 3;
    public static final int BATTERY_LEVEL_UNKNOWN = 0;
    public static final Parcelable.Creator<ControllerBatteryEvent> CREATOR = new Parcelable.Creator<ControllerBatteryEvent>() {
        public ControllerBatteryEvent createFromParcel(Parcel parcel) {
            return new ControllerBatteryEvent(parcel);
        }

        public ControllerBatteryEvent[] newArray(int i) {
            return new ControllerBatteryEvent[i];
        }
    };
    public int batteryLevelBucket;
    public boolean charging;

    public ControllerBatteryEvent() {
    }

    public ControllerBatteryEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.batteryLevelBucket);
        parcel.writeInt(this.charging ? 1 : 0);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.batteryLevelBucket = parcel.readInt();
        this.charging = parcel.readInt() != 0;
    }

    public static String toString(int i) {
        switch (i) {
            case 0:
                return "BATTERY_LEVEL_UNKNOWN";
            case 1:
                return "BATTERY_LEVEL_CRITICAL_LOW";
            case 2:
                return "BATTERY_LEVEL_LOW";
            case 3:
                return "BATTERY_LEVEL_MEDIUM";
            case 4:
                return "BATTERY_LEVEL_ALMOST_FULL";
            case 5:
                return "BATTERY_LEVEL_FULL";
            default:
                return new StringBuilder(28).append("[Unknown level: ").append(i).append("]").toString();
        }
    }

    public static int getBatteryLevelBucket(int i) {
        if (i < 20) {
            return 1;
        }
        if (i < 40) {
            return 2;
        }
        if (i < 60) {
            return 3;
        }
        if (i < 80) {
            return 4;
        }
        return 5;
    }

    public final int getByteSize() {
        return super.getByteSize() + 8;
    }

    public final void copyFrom(ControllerEvent controllerEvent) {
        if (!(controllerEvent instanceof ControllerBatteryEvent)) {
            throw new IllegalStateException("Cannot copy ControllerBatteryEvent from non-ControllerBatteryEvent instance.");
        }
        super.copyFrom(controllerEvent);
        ControllerBatteryEvent controllerBatteryEvent = (ControllerBatteryEvent) controllerEvent;
        this.batteryLevelBucket = controllerBatteryEvent.batteryLevelBucket;
        this.charging = controllerBatteryEvent.charging;
    }
}
