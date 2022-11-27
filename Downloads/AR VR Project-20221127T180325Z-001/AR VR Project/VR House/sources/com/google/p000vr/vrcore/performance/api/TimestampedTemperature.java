package com.google.p000vr.vrcore.performance.api;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.vr.vrcore.performance.api.TimestampedTemperature */
public class TimestampedTemperature implements Parcelable {
    public static final Parcelable.Creator<TimestampedTemperature> CREATOR = new Parcelable.Creator<TimestampedTemperature>() {
        public TimestampedTemperature createFromParcel(Parcel parcel) {
            return new TimestampedTemperature(parcel);
        }

        public TimestampedTemperature[] newArray(int i) {
            return new TimestampedTemperature[i];
        }
    };
    private static final int PARCEL_SIZE = 16;
    public float temperature;
    public long timestamp;

    public TimestampedTemperature() {
    }

    public TimestampedTemperature(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void set(long j, float f) {
        this.timestamp = j;
        this.temperature = f;
    }

    public void set(TimestampedTemperature timestampedTemperature) {
        set(timestampedTemperature.timestamp, timestampedTemperature.temperature);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(16);
        parcel.writeLong(this.timestamp);
        parcel.writeFloat(this.temperature);
        if (parcel.dataPosition() - dataPosition != 16) {
            throw new IllegalStateException("Parcelable implemented incorrectly, PARCEL_SIZE must include the size of each parcelled field.");
        }
    }

    public void readFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        this.timestamp = parcel.readLong();
        this.temperature = parcel.readFloat();
        parcel.setDataPosition(dataPosition + readInt);
    }
}
