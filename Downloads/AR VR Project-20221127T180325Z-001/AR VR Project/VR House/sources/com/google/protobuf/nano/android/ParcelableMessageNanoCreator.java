package com.google.protobuf.nano.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.lang.reflect.Array;

public final class ParcelableMessageNanoCreator implements Parcelable.Creator {
    private static final String TAG = "PMNCreator";
    private final Class mClazz;

    public ParcelableMessageNanoCreator(Class cls) {
        this.mClazz = cls;
    }

    static void writeToParcel(Class cls, MessageNano messageNano, Parcel parcel) {
        parcel.writeString(cls.getName());
        parcel.writeByteArray(MessageNano.toByteArray(messageNano));
    }

    public final MessageNano createFromParcel(Parcel parcel) {
        InvalidProtocolBufferNanoException e;
        MessageNano messageNano;
        InstantiationException e2;
        IllegalAccessException e3;
        ClassNotFoundException e4;
        String readString = parcel.readString();
        byte[] createByteArray = parcel.createByteArray();
        try {
            messageNano = (MessageNano) Class.forName(readString).newInstance();
            try {
                MessageNano.mergeFrom(messageNano, createByteArray);
            } catch (ClassNotFoundException e5) {
                e4 = e5;
                Log.e(TAG, "Exception trying to create proto from parcel", e4);
                return messageNano;
            } catch (IllegalAccessException e6) {
                e3 = e6;
                Log.e(TAG, "Exception trying to create proto from parcel", e3);
                return messageNano;
            } catch (InstantiationException e7) {
                e2 = e7;
                Log.e(TAG, "Exception trying to create proto from parcel", e2);
                return messageNano;
            } catch (InvalidProtocolBufferNanoException e8) {
                e = e8;
                Log.e(TAG, "Exception trying to create proto from parcel", e);
                return messageNano;
            }
        } catch (ClassNotFoundException e9) {
            ClassNotFoundException classNotFoundException = e9;
            messageNano = null;
            e4 = classNotFoundException;
            Log.e(TAG, "Exception trying to create proto from parcel", e4);
            return messageNano;
        } catch (IllegalAccessException e10) {
            IllegalAccessException illegalAccessException = e10;
            messageNano = null;
            e3 = illegalAccessException;
            Log.e(TAG, "Exception trying to create proto from parcel", e3);
            return messageNano;
        } catch (InstantiationException e11) {
            InstantiationException instantiationException = e11;
            messageNano = null;
            e2 = instantiationException;
            Log.e(TAG, "Exception trying to create proto from parcel", e2);
            return messageNano;
        } catch (InvalidProtocolBufferNanoException e12) {
            InvalidProtocolBufferNanoException invalidProtocolBufferNanoException = e12;
            messageNano = null;
            e = invalidProtocolBufferNanoException;
            Log.e(TAG, "Exception trying to create proto from parcel", e);
            return messageNano;
        }
        return messageNano;
    }

    public final MessageNano[] newArray(int i) {
        return (MessageNano[]) Array.newInstance(this.mClazz, i);
    }
}
