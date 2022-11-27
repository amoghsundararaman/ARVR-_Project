package com.google.p000vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.vr.vrcore.controller.api.ControllerEventPacket2 */
public final class ControllerEventPacket2 extends ControllerEventPacket {
    public static final Parcelable.Creator<ControllerEventPacket2> CREATOR = new Parcelable.Creator<ControllerEventPacket2>() {
        public ControllerEventPacket2 createFromParcel(Parcel parcel) {
            ControllerEventPacket2 obtain = ControllerEventPacket2.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        public ControllerEventPacket2[] newArray(int i) {
            return new ControllerEventPacket2[i];
        }
    };
    private static ArrayDeque<ControllerEventPacket2> pool = new ArrayDeque<>();
    private static Object poolLock = new Object();
    private ControllerBatteryEvent batteryEvent = new ControllerBatteryEvent();
    private boolean hasBatteryEvent;
    private int positionEventCount;
    private ControllerPositionEvent[] positionEvents = new ControllerPositionEvent[16];
    private long timestampMillis;

    public ControllerEventPacket2() {
        for (int i = 0; i < 16; i++) {
            this.positionEvents[i] = new ControllerPositionEvent();
        }
        clear();
    }

    public final void copyFrom(ControllerEventPacket controllerEventPacket) {
        if (!(controllerEventPacket instanceof ControllerEventPacket2)) {
            throw new IllegalStateException("Cannot copy ControllerEventPacket2 from non-ControllerEventPacket2 instance.");
        }
        super.copyFrom(controllerEventPacket);
        ControllerEventPacket2 controllerEventPacket2 = (ControllerEventPacket2) controllerEventPacket;
        this.positionEventCount = controllerEventPacket2.positionEventCount;
        this.hasBatteryEvent = controllerEventPacket2.hasBatteryEvent;
        this.timestampMillis = controllerEventPacket2.timestampMillis;
        this.batteryEvent.copyFrom(controllerEventPacket2.batteryEvent);
        for (int i = 0; i < 16; i++) {
            this.positionEvents[i].copyFrom(controllerEventPacket2.positionEvents[i]);
        }
    }

    public final void clear() {
        super.clear();
        this.positionEventCount = 0;
        this.hasBatteryEvent = false;
        this.timestampMillis = 0;
    }

    public final void setEventsControllerIndex(int i) {
        super.setEventsControllerIndex(i);
        setControllerIndex(i, this.positionEventCount, this.positionEvents);
        this.batteryEvent.controllerId = i;
    }

    public final void refreshTimestampMillis() {
        this.timestampMillis = getSystemTimeMillis();
    }

    public final void setTimestampMillis(long j) {
        this.timestampMillis = j;
    }

    public final long getTimestampMillis() {
        return this.timestampMillis;
    }

    public final int getPositionEventCount() {
        return this.positionEventCount;
    }

    public final boolean hasBatteryEvent() {
        return this.hasBatteryEvent;
    }

    public final ControllerPositionEvent getPositionEvent(int i) {
        if (i >= 0 && i < this.positionEventCount) {
            return this.positionEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public final ControllerPositionEvent addPositionEvent() {
        if (this.positionEventCount >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        }
        ControllerPositionEvent[] controllerPositionEventArr = this.positionEvents;
        int i = this.positionEventCount;
        this.positionEventCount = i + 1;
        return controllerPositionEventArr[i];
    }

    public final ControllerBatteryEvent getBatteryEvent() {
        if (this.hasBatteryEvent) {
            return this.batteryEvent;
        }
        throw new IllegalStateException("ControllerEventPacket doesn't have a battery event.");
    }

    public final ControllerBatteryEvent addBatteryEvent() {
        if (this.hasBatteryEvent) {
            throw new IllegalStateException("ControllerEventPacket already has battery event.");
        }
        this.hasBatteryEvent = true;
        return this.batteryEvent;
    }

    public static ControllerEventPacket2 obtain() {
        ControllerEventPacket2 controllerEventPacket2;
        synchronized (poolLock) {
            controllerEventPacket2 = pool.isEmpty() ? new ControllerEventPacket2() : pool.remove();
        }
        return controllerEventPacket2;
    }

    public final void recycle() {
        clear();
        synchronized (poolLock) {
            if (!pool.contains(this)) {
                pool.add(this);
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final int calculateParcelByteLength() {
        int calculateParcelByteLength = super.calculateParcelByteLength() + 4 + 4;
        for (int i = 0; i < this.positionEventCount; i++) {
            calculateParcelByteLength += this.positionEvents[i].getByteSize();
        }
        int i2 = calculateParcelByteLength + 4;
        if (this.hasBatteryEvent) {
            i2 += this.batteryEvent.getByteSize();
        }
        return i2 + 8;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        int dataPosition = parcel.dataPosition();
        int calculateParcelByteLength = calculateParcelByteLength();
        parcel.writeInt(calculateParcelByteLength);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.positionEventCount);
        for (int i3 = 0; i3 < this.positionEventCount; i3++) {
            this.positionEvents[i3].writeToParcel(parcel, i);
        }
        if (this.hasBatteryEvent) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.hasBatteryEvent) {
            this.batteryEvent.writeToParcel(parcel, i);
        }
        parcel.writeLong(this.timestampMillis);
        if (parcel.dataPosition() - dataPosition != calculateParcelByteLength) {
            throw new IllegalStateException("Parcelable implemented incorrectly, getByteSize() must return the correct size for each ControllerEvent subclass.");
        }
    }

    public final void readFromParcel(Parcel parcel) {
        boolean z = false;
        int readInt = parcel.readInt() + parcel.dataPosition();
        super.readFromParcel(parcel);
        if (parcel.dataPosition() < readInt) {
            this.positionEventCount = parcel.readInt();
            checkIsValidEventCount(this.positionEventCount);
            for (int i = 0; i < this.positionEventCount; i++) {
                this.positionEvents[i].readFromParcel(parcel);
            }
        }
        if (parcel.dataPosition() < readInt) {
            if (parcel.readInt() != 0) {
                z = true;
            }
            this.hasBatteryEvent = z;
            if (this.hasBatteryEvent) {
                this.batteryEvent.readFromParcel(parcel);
            }
        }
        if (parcel.dataPosition() < readInt) {
            this.timestampMillis = parcel.readLong();
        }
        parcel.setDataPosition(readInt);
    }

    public static long getSystemTimeMillis() {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}
