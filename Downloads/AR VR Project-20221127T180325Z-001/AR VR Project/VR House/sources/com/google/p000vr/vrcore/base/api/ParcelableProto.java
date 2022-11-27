package com.google.p000vr.vrcore.base.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* renamed from: com.google.vr.vrcore.base.api.ParcelableProto */
public class ParcelableProto<T extends MessageNano> implements Parcelable {
    private static final String TAG = "ParcelableProto";
    private byte[] data = null;

    public ParcelableProto() {
    }

    public ParcelableProto(byte[] bArr) {
        setData(bArr);
    }

    public ParcelableProto(T t) {
        setFromProto(t);
    }

    protected ParcelableProto(Parcel parcel) {
        readFromParcel(parcel);
    }

    public byte[] getData() {
        return this.data;
    }

    public T parseToProto(Class<T> cls) {
        try {
            T t = (MessageNano) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (isEmpty()) {
                return t;
            }
            try {
                return MessageNano.mergeFrom(t, this.data);
            } catch (InvalidProtocolBufferNanoException e) {
                String valueOf = String.valueOf(e);
                Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 29).append("Failed to parse data buffer: ").append(valueOf).toString());
                return null;
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            String valueOf2 = String.valueOf(e2);
            Log.e(TAG, new StringBuilder(String.valueOf(valueOf2).length() + 38).append("Failed to invoke nullary constructor: ").append(valueOf2).toString());
            return null;
        }
    }

    public int getSizeBytes() {
        if (this.data == null) {
            return 0;
        }
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.data == null || this.data.length == 0;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setFromProto(T t) {
        int i;
        if (t != null) {
            i = t.getSerializedSize();
        } else {
            i = 0;
        }
        if (i == 0) {
            clear();
        } else if (this.data == null || i != this.data.length) {
            this.data = MessageNano.toByteArray(t);
        } else {
            MessageNano.toByteArray(t, this.data, 0, this.data.length);
        }
    }

    public void clear() {
        this.data = null;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean shouldSerializeDataLength() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldSerializeEmptyInsteadOfNullBuffer() {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (shouldSerializeDataLength()) {
            parcel.writeInt(this.data == null ? 0 : this.data.length);
        }
        if (this.data != null || !shouldSerializeEmptyInsteadOfNullBuffer()) {
            parcel.writeByteArray(this.data);
        } else {
            parcel.writeByteArray(new byte[0]);
        }
    }

    public void readFromParcel(Parcel parcel) {
        if (shouldSerializeDataLength()) {
            parcel.readInt();
        }
        this.data = parcel.createByteArray();
    }

    public String toString() {
        return new StringBuilder(34).append("ParcelableProto[").append(getSizeBytes()).append(" bytes]").toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ParcelableProto) {
            return Arrays.equals(((ParcelableProto) obj).data, this.data);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public void copyFrom(ParcelableProto<T> parcelableProto) {
        if (parcelableProto.data == null) {
            this.data = null;
        } else {
            this.data = Arrays.copyOf(parcelableProto.data, parcelableProto.data.length);
        }
    }
}
