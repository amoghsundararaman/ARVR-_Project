package com.google.protobuf.nano.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.protobuf.nano.ExtendableMessageNano;

public abstract class ParcelableExtendableMessageNano extends ExtendableMessageNano implements Parcelable {
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelableMessageNanoCreator.writeToParcel(getClass(), this, parcel);
    }
}
