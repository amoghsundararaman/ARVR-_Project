package com.google.p000vr.sdk.proto.nano;

import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.NanoEnumValue;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* renamed from: com.google.vr.sdk.proto.nano.Session */
public class Session {
    private Session() {
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Session$RecenteredState */
    public static final class RecenteredState extends ExtendableMessageNano<RecenteredState> implements Cloneable {
        private static volatile RecenteredState[] _emptyArray;
        private boolean applyDisplayFromSensorRotation_;
        private int bitField0_;
        public Pose headRecenterPoseInTrackingSpace;
        private long timestampNs_;
        private int type_;

        /* renamed from: com.google.vr.sdk.proto.nano.Session$RecenteredState$Type */
        public interface Type {
            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_ALIGNED = 2;
            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_CONTROLLER_CONNECTED = 4;
            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_DON = 3;
            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_INVALID = 0;
            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_OOBE_TO_WELCOME_TRANSITION = 5;
            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_RESTART = 1;
        }

        @NanoEnumValue(legacy = false, value = Type.class)
        public static int checkTypeOrThrow(int i) {
            if (i >= 0 && i <= 5) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Type").toString());
        }

        @NanoEnumValue(legacy = false, value = Type.class)
        public static int[] checkTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkTypeOrThrow : iArr2) {
                checkTypeOrThrow(checkTypeOrThrow);
            }
            return iArr2;
        }

        public static RecenteredState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecenteredState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final long getTimestampNs() {
            return this.timestampNs_;
        }

        public final boolean hasTimestampNs() {
            return (this.bitField0_ & 1) != 0;
        }

        public final RecenteredState clearTimestampNs() {
            this.timestampNs_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final RecenteredState setTimestampNs(long j) {
            this.bitField0_ |= 1;
            this.timestampNs_ = j;
            return this;
        }

        @NanoEnumValue(legacy = false, value = Type.class)
        public final int getType() {
            return this.type_;
        }

        public final RecenteredState setType(@NanoEnumValue(legacy = false, value = Type.class) int i) {
            this.type_ = i;
            this.bitField0_ |= 2;
            return this;
        }

        public final boolean hasType() {
            return (this.bitField0_ & 2) != 0;
        }

        public final RecenteredState clearType() {
            this.bitField0_ &= -3;
            this.type_ = 0;
            return this;
        }

        public final boolean getApplyDisplayFromSensorRotation() {
            return this.applyDisplayFromSensorRotation_;
        }

        public final boolean hasApplyDisplayFromSensorRotation() {
            return (this.bitField0_ & 4) != 0;
        }

        public final RecenteredState clearApplyDisplayFromSensorRotation() {
            this.applyDisplayFromSensorRotation_ = true;
            this.bitField0_ &= -5;
            return this;
        }

        public final RecenteredState setApplyDisplayFromSensorRotation(boolean z) {
            this.bitField0_ |= 4;
            this.applyDisplayFromSensorRotation_ = z;
            return this;
        }

        public RecenteredState() {
            clear();
        }

        public final RecenteredState clear() {
            this.bitField0_ = 0;
            this.timestampNs_ = 0;
            this.type_ = 0;
            this.headRecenterPoseInTrackingSpace = null;
            this.applyDisplayFromSensorRotation_ = true;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final RecenteredState clone() {
            try {
                RecenteredState recenteredState = (RecenteredState) super.clone();
                if (this.headRecenterPoseInTrackingSpace != null) {
                    recenteredState.headRecenterPoseInTrackingSpace = this.headRecenterPoseInTrackingSpace.clone();
                }
                return recenteredState;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.timestampNs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeInt32(2, this.type_);
            }
            if (this.headRecenterPoseInTrackingSpace != null) {
                codedOutputByteBufferNano.writeMessage(3, this.headRecenterPoseInTrackingSpace);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(4, this.applyDisplayFromSensorRotation_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.type_);
            }
            if (this.headRecenterPoseInTrackingSpace != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.headRecenterPoseInTrackingSpace);
            }
            if ((this.bitField0_ & 4) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, this.applyDisplayFromSensorRotation_);
            }
            return computeSerializedSize;
        }

        public final RecenteredState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.timestampNs_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                        continue;
                    case 16:
                        this.bitField0_ |= 2;
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.type_ = checkTypeOrThrow(codedInputByteBufferNano.readInt32());
                            this.bitField0_ |= 2;
                            continue;
                        } catch (IllegalArgumentException e) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 26:
                        if (this.headRecenterPoseInTrackingSpace == null) {
                            this.headRecenterPoseInTrackingSpace = new Pose();
                        }
                        codedInputByteBufferNano.readMessage(this.headRecenterPoseInTrackingSpace);
                        continue;
                    case 32:
                        this.applyDisplayFromSensorRotation_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 4;
                        continue;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public static RecenteredState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (RecenteredState) MessageNano.mergeFrom(new RecenteredState(), bArr);
        }

        public static RecenteredState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new RecenteredState().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Session$HeadTrackingServiceState */
    public static final class HeadTrackingServiceState extends ExtendableMessageNano<HeadTrackingServiceState> implements Cloneable {
        private static volatile HeadTrackingServiceState[] _emptyArray;
        private boolean applyDisplayFromSensorRotation_;
        private int bitField0_;
        private float defaultFloorHeight_;
        public RecenteredState recenteredState;
        public SafeRegionState safeRegionState;

        public static HeadTrackingServiceState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new HeadTrackingServiceState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean getApplyDisplayFromSensorRotation() {
            return this.applyDisplayFromSensorRotation_;
        }

        public final boolean hasApplyDisplayFromSensorRotation() {
            return (this.bitField0_ & 1) != 0;
        }

        public final HeadTrackingServiceState clearApplyDisplayFromSensorRotation() {
            this.applyDisplayFromSensorRotation_ = true;
            this.bitField0_ &= -2;
            return this;
        }

        public final HeadTrackingServiceState setApplyDisplayFromSensorRotation(boolean z) {
            this.bitField0_ |= 1;
            this.applyDisplayFromSensorRotation_ = z;
            return this;
        }

        public final float getDefaultFloorHeight() {
            return this.defaultFloorHeight_;
        }

        public final boolean hasDefaultFloorHeight() {
            return (this.bitField0_ & 2) != 0;
        }

        public final HeadTrackingServiceState clearDefaultFloorHeight() {
            this.defaultFloorHeight_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final HeadTrackingServiceState setDefaultFloorHeight(float f) {
            this.bitField0_ |= 2;
            this.defaultFloorHeight_ = f;
            return this;
        }

        public HeadTrackingServiceState() {
            clear();
        }

        public final HeadTrackingServiceState clear() {
            this.bitField0_ = 0;
            this.applyDisplayFromSensorRotation_ = true;
            this.recenteredState = null;
            this.safeRegionState = null;
            this.defaultFloorHeight_ = 0.0f;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final HeadTrackingServiceState clone() {
            try {
                HeadTrackingServiceState headTrackingServiceState = (HeadTrackingServiceState) super.clone();
                if (this.recenteredState != null) {
                    headTrackingServiceState.recenteredState = this.recenteredState.clone();
                }
                if (this.safeRegionState != null) {
                    headTrackingServiceState.safeRegionState = this.safeRegionState.clone();
                }
                return headTrackingServiceState;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeBool(1, this.applyDisplayFromSensorRotation_);
            }
            if (this.recenteredState != null) {
                codedOutputByteBufferNano.writeMessage(2, this.recenteredState);
            }
            if (this.safeRegionState != null) {
                codedOutputByteBufferNano.writeMessage(3, this.safeRegionState);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.defaultFloorHeight_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.applyDisplayFromSensorRotation_);
            }
            if (this.recenteredState != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.recenteredState);
            }
            if (this.safeRegionState != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.safeRegionState);
            }
            if ((this.bitField0_ & 2) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.defaultFloorHeight_);
            }
            return computeSerializedSize;
        }

        public final HeadTrackingServiceState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.applyDisplayFromSensorRotation_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        if (this.recenteredState == null) {
                            this.recenteredState = new RecenteredState();
                        }
                        codedInputByteBufferNano.readMessage(this.recenteredState);
                        continue;
                    case 26:
                        if (this.safeRegionState == null) {
                            this.safeRegionState = new SafeRegionState();
                        }
                        codedInputByteBufferNano.readMessage(this.safeRegionState);
                        continue;
                    case 37:
                        this.defaultFloorHeight_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 2;
                        continue;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public static HeadTrackingServiceState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (HeadTrackingServiceState) MessageNano.mergeFrom(new HeadTrackingServiceState(), bArr);
        }

        public static HeadTrackingServiceState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new HeadTrackingServiceState().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Session$Pose */
    public static final class Pose extends ExtendableMessageNano<Pose> implements Cloneable {
        private static volatile Pose[] _emptyArray;

        /* renamed from: p */
        public float[] f9p;

        /* renamed from: q */
        public float[] f10q;

        public static Pose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Pose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Pose() {
            clear();
        }

        public final Pose clear() {
            this.f10q = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.f9p = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final Pose clone() {
            try {
                Pose pose = (Pose) super.clone();
                if (this.f10q != null && this.f10q.length > 0) {
                    pose.f10q = (float[]) this.f10q.clone();
                }
                if (this.f9p != null && this.f9p.length > 0) {
                    pose.f9p = (float[]) this.f9p.clone();
                }
                return pose;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.f10q != null && this.f10q.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(this.f10q.length * 4);
                for (float writeFloatNoTag : this.f10q) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag);
                }
            }
            if (this.f9p != null && this.f9p.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(18);
                codedOutputByteBufferNano.writeRawVarint32(this.f9p.length * 4);
                for (float writeFloatNoTag2 : this.f9p) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag2);
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.f10q != null && this.f10q.length > 0) {
                int length = this.f10q.length * 4;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            if (this.f9p == null || this.f9p.length <= 0) {
                return computeSerializedSize;
            }
            int length2 = this.f9p.length * 4;
            return computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
        }

        public final Pose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i = readRawVarint32 / 4;
                        int length = this.f10q == null ? 0 : this.f10q.length;
                        float[] fArr = new float[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.f10q, 0, fArr, 0, length);
                        }
                        while (length < fArr.length) {
                            fArr[length] = codedInputByteBufferNano.readFloat();
                            length++;
                        }
                        this.f10q = fArr;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 13:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 13);
                        int length2 = this.f10q == null ? 0 : this.f10q.length;
                        float[] fArr2 = new float[(repeatedFieldArrayLength + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f10q, 0, fArr2, 0, length2);
                        }
                        while (length2 < fArr2.length - 1) {
                            fArr2[length2] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        fArr2[length2] = codedInputByteBufferNano.readFloat();
                        this.f10q = fArr2;
                        continue;
                    case 18:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i2 = readRawVarint322 / 4;
                        int length3 = this.f9p == null ? 0 : this.f9p.length;
                        float[] fArr3 = new float[(i2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f9p, 0, fArr3, 0, length3);
                        }
                        while (length3 < fArr3.length) {
                            fArr3[length3] = codedInputByteBufferNano.readFloat();
                            length3++;
                        }
                        this.f9p = fArr3;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        continue;
                    case 21:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 21);
                        int length4 = this.f9p == null ? 0 : this.f9p.length;
                        float[] fArr4 = new float[(repeatedFieldArrayLength2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f9p, 0, fArr4, 0, length4);
                        }
                        while (length4 < fArr4.length - 1) {
                            fArr4[length4] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        fArr4[length4] = codedInputByteBufferNano.readFloat();
                        this.f9p = fArr4;
                        continue;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public static Pose parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (Pose) MessageNano.mergeFrom(new Pose(), bArr);
        }

        public static Pose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Pose().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Session$SafeRegionState */
    public static final class SafeRegionState extends ExtendableMessageNano<SafeRegionState> implements Cloneable {
        private static volatile SafeRegionState[] _emptyArray;
        private int bitField0_;
        private long counter_;
        private boolean inside_;

        public static SafeRegionState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SafeRegionState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final long getCounter() {
            return this.counter_;
        }

        public final boolean hasCounter() {
            return (this.bitField0_ & 1) != 0;
        }

        public final SafeRegionState clearCounter() {
            this.counter_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final SafeRegionState setCounter(long j) {
            this.bitField0_ |= 1;
            this.counter_ = j;
            return this;
        }

        public final boolean getInside() {
            return this.inside_;
        }

        public final boolean hasInside() {
            return (this.bitField0_ & 2) != 0;
        }

        public final SafeRegionState clearInside() {
            this.inside_ = true;
            this.bitField0_ &= -3;
            return this;
        }

        public final SafeRegionState setInside(boolean z) {
            this.bitField0_ |= 2;
            this.inside_ = z;
            return this;
        }

        public SafeRegionState() {
            clear();
        }

        public final SafeRegionState clear() {
            this.bitField0_ = 0;
            this.counter_ = 0;
            this.inside_ = true;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final SafeRegionState clone() {
            try {
                return (SafeRegionState) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.counter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeBool(2, this.inside_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.counter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.inside_);
            }
            return computeSerializedSize;
        }

        public final SafeRegionState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.counter_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                        continue;
                    case 16:
                        this.inside_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 2;
                        continue;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public static SafeRegionState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (SafeRegionState) MessageNano.mergeFrom(new SafeRegionState(), bArr);
        }

        public static SafeRegionState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new SafeRegionState().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Session$TrackerState */
    public static final class TrackerState extends ExtendableMessageNano<TrackerState> implements Cloneable {
        private static volatile TrackerState[] _emptyArray;
        private int bitField0_;
        public double[] gyroscopeBias;
        public double[] lastGyroscopeSample;
        private double lastGyroscopeTimestamp_;
        public float[] lensOffset;
        private long magCalibrationTimeSinceEpochSeconds_;
        private double magneticFieldStrength_;
        public double[] magnetometerBias;

        /* renamed from: q */
        public double[] f11q;
        public float[] rightLensOffset;
        private long timeSinceEpochSeconds_;
        private boolean trackingInVrcore_;

        public static TrackerState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TrackerState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final long getTimeSinceEpochSeconds() {
            return this.timeSinceEpochSeconds_;
        }

        public final boolean hasTimeSinceEpochSeconds() {
            return (this.bitField0_ & 1) != 0;
        }

        public final TrackerState clearTimeSinceEpochSeconds() {
            this.timeSinceEpochSeconds_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final TrackerState setTimeSinceEpochSeconds(long j) {
            this.bitField0_ |= 1;
            this.timeSinceEpochSeconds_ = j;
            return this;
        }

        public final double getLastGyroscopeTimestamp() {
            return this.lastGyroscopeTimestamp_;
        }

        public final boolean hasLastGyroscopeTimestamp() {
            return (this.bitField0_ & 2) != 0;
        }

        public final TrackerState clearLastGyroscopeTimestamp() {
            this.lastGyroscopeTimestamp_ = 0.0d;
            this.bitField0_ &= -3;
            return this;
        }

        public final TrackerState setLastGyroscopeTimestamp(double d) {
            this.bitField0_ |= 2;
            this.lastGyroscopeTimestamp_ = d;
            return this;
        }

        public final boolean getTrackingInVrcore() {
            return this.trackingInVrcore_;
        }

        public final boolean hasTrackingInVrcore() {
            return (this.bitField0_ & 4) != 0;
        }

        public final TrackerState clearTrackingInVrcore() {
            this.trackingInVrcore_ = false;
            this.bitField0_ &= -5;
            return this;
        }

        public final TrackerState setTrackingInVrcore(boolean z) {
            this.bitField0_ |= 4;
            this.trackingInVrcore_ = z;
            return this;
        }

        public final double getMagneticFieldStrength() {
            return this.magneticFieldStrength_;
        }

        public final boolean hasMagneticFieldStrength() {
            return (this.bitField0_ & 8) != 0;
        }

        public final TrackerState clearMagneticFieldStrength() {
            this.magneticFieldStrength_ = 0.0d;
            this.bitField0_ &= -9;
            return this;
        }

        public final TrackerState setMagneticFieldStrength(double d) {
            this.bitField0_ |= 8;
            this.magneticFieldStrength_ = d;
            return this;
        }

        public final long getMagCalibrationTimeSinceEpochSeconds() {
            return this.magCalibrationTimeSinceEpochSeconds_;
        }

        public final boolean hasMagCalibrationTimeSinceEpochSeconds() {
            return (this.bitField0_ & 16) != 0;
        }

        public final TrackerState clearMagCalibrationTimeSinceEpochSeconds() {
            this.magCalibrationTimeSinceEpochSeconds_ = 0;
            this.bitField0_ &= -17;
            return this;
        }

        public final TrackerState setMagCalibrationTimeSinceEpochSeconds(long j) {
            this.bitField0_ |= 16;
            this.magCalibrationTimeSinceEpochSeconds_ = j;
            return this;
        }

        public TrackerState() {
            clear();
        }

        public final TrackerState clear() {
            this.bitField0_ = 0;
            this.f11q = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.timeSinceEpochSeconds_ = 0;
            this.gyroscopeBias = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.lensOffset = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.lastGyroscopeSample = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.lastGyroscopeTimestamp_ = 0.0d;
            this.trackingInVrcore_ = false;
            this.magnetometerBias = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.magneticFieldStrength_ = 0.0d;
            this.magCalibrationTimeSinceEpochSeconds_ = 0;
            this.rightLensOffset = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final TrackerState clone() {
            try {
                TrackerState trackerState = (TrackerState) super.clone();
                if (this.f11q != null && this.f11q.length > 0) {
                    trackerState.f11q = (double[]) this.f11q.clone();
                }
                if (this.gyroscopeBias != null && this.gyroscopeBias.length > 0) {
                    trackerState.gyroscopeBias = (double[]) this.gyroscopeBias.clone();
                }
                if (this.lensOffset != null && this.lensOffset.length > 0) {
                    trackerState.lensOffset = (float[]) this.lensOffset.clone();
                }
                if (this.lastGyroscopeSample != null && this.lastGyroscopeSample.length > 0) {
                    trackerState.lastGyroscopeSample = (double[]) this.lastGyroscopeSample.clone();
                }
                if (this.magnetometerBias != null && this.magnetometerBias.length > 0) {
                    trackerState.magnetometerBias = (double[]) this.magnetometerBias.clone();
                }
                if (this.rightLensOffset != null && this.rightLensOffset.length > 0) {
                    trackerState.rightLensOffset = (float[]) this.rightLensOffset.clone();
                }
                return trackerState;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.f11q != null && this.f11q.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(this.f11q.length * 8);
                for (double writeDoubleNoTag : this.f11q) {
                    codedOutputByteBufferNano.writeDoubleNoTag(writeDoubleNoTag);
                }
            }
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(2, this.timeSinceEpochSeconds_);
            }
            if (this.gyroscopeBias != null && this.gyroscopeBias.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(26);
                codedOutputByteBufferNano.writeRawVarint32(this.gyroscopeBias.length * 8);
                for (double writeDoubleNoTag2 : this.gyroscopeBias) {
                    codedOutputByteBufferNano.writeDoubleNoTag(writeDoubleNoTag2);
                }
            }
            if (this.lensOffset != null && this.lensOffset.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(34);
                codedOutputByteBufferNano.writeRawVarint32(this.lensOffset.length * 4);
                for (float writeFloatNoTag : this.lensOffset) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag);
                }
            }
            if (this.lastGyroscopeSample != null && this.lastGyroscopeSample.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(42);
                codedOutputByteBufferNano.writeRawVarint32(this.lastGyroscopeSample.length * 8);
                for (double writeDoubleNoTag3 : this.lastGyroscopeSample) {
                    codedOutputByteBufferNano.writeDoubleNoTag(writeDoubleNoTag3);
                }
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeDouble(6, this.lastGyroscopeTimestamp_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(7, this.trackingInVrcore_);
            }
            if (this.magnetometerBias != null && this.magnetometerBias.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(66);
                codedOutputByteBufferNano.writeRawVarint32(this.magnetometerBias.length * 8);
                for (double writeDoubleNoTag4 : this.magnetometerBias) {
                    codedOutputByteBufferNano.writeDoubleNoTag(writeDoubleNoTag4);
                }
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeDouble(9, this.magneticFieldStrength_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeInt64(10, this.magCalibrationTimeSinceEpochSeconds_);
            }
            if (this.rightLensOffset != null && this.rightLensOffset.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(90);
                codedOutputByteBufferNano.writeRawVarint32(this.rightLensOffset.length * 4);
                for (float writeFloatNoTag2 : this.rightLensOffset) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag2);
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.f11q != null && this.f11q.length > 0) {
                int length = this.f11q.length * 8;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.timeSinceEpochSeconds_);
            }
            if (this.gyroscopeBias != null && this.gyroscopeBias.length > 0) {
                int length2 = this.gyroscopeBias.length * 8;
                computeSerializedSize = computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
            }
            if (this.lensOffset != null && this.lensOffset.length > 0) {
                int length3 = this.lensOffset.length * 4;
                computeSerializedSize = computeSerializedSize + length3 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length3);
            }
            if (this.lastGyroscopeSample != null && this.lastGyroscopeSample.length > 0) {
                int length4 = this.lastGyroscopeSample.length * 8;
                computeSerializedSize = computeSerializedSize + length4 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length4);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, this.lastGyroscopeTimestamp_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.trackingInVrcore_);
            }
            if (this.magnetometerBias != null && this.magnetometerBias.length > 0) {
                int length5 = this.magnetometerBias.length * 8;
                computeSerializedSize = computeSerializedSize + length5 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length5);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(9, this.magneticFieldStrength_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(10, this.magCalibrationTimeSinceEpochSeconds_);
            }
            if (this.rightLensOffset == null || this.rightLensOffset.length <= 0) {
                return computeSerializedSize;
            }
            int length6 = this.rightLensOffset.length * 4;
            return computeSerializedSize + length6 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length6);
        }

        public final TrackerState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 9:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 9);
                        int length = this.f11q == null ? 0 : this.f11q.length;
                        double[] dArr = new double[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.f11q, 0, dArr, 0, length);
                        }
                        while (length < dArr.length - 1) {
                            dArr[length] = codedInputByteBufferNano.readDouble();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        dArr[length] = codedInputByteBufferNano.readDouble();
                        this.f11q = dArr;
                        continue;
                    case 10:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i = readRawVarint32 / 8;
                        int length2 = this.f11q == null ? 0 : this.f11q.length;
                        double[] dArr2 = new double[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f11q, 0, dArr2, 0, length2);
                        }
                        while (length2 < dArr2.length) {
                            dArr2[length2] = codedInputByteBufferNano.readDouble();
                            length2++;
                        }
                        this.f11q = dArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 16:
                        this.timeSinceEpochSeconds_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                        continue;
                    case AndroidNCompat.NMR1_SDK_LEVEL:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 25);
                        int length3 = this.gyroscopeBias == null ? 0 : this.gyroscopeBias.length;
                        double[] dArr3 = new double[(repeatedFieldArrayLength2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.gyroscopeBias, 0, dArr3, 0, length3);
                        }
                        while (length3 < dArr3.length - 1) {
                            dArr3[length3] = codedInputByteBufferNano.readDouble();
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        dArr3[length3] = codedInputByteBufferNano.readDouble();
                        this.gyroscopeBias = dArr3;
                        continue;
                    case 26:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i2 = readRawVarint322 / 8;
                        int length4 = this.gyroscopeBias == null ? 0 : this.gyroscopeBias.length;
                        double[] dArr4 = new double[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.gyroscopeBias, 0, dArr4, 0, length4);
                        }
                        while (length4 < dArr4.length) {
                            dArr4[length4] = codedInputByteBufferNano.readDouble();
                            length4++;
                        }
                        this.gyroscopeBias = dArr4;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        continue;
                    case 34:
                        int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                        int i3 = readRawVarint323 / 4;
                        int length5 = this.lensOffset == null ? 0 : this.lensOffset.length;
                        float[] fArr = new float[(i3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.lensOffset, 0, fArr, 0, length5);
                        }
                        while (length5 < fArr.length) {
                            fArr[length5] = codedInputByteBufferNano.readFloat();
                            length5++;
                        }
                        this.lensOffset = fArr;
                        codedInputByteBufferNano.popLimit(pushLimit3);
                        continue;
                    case 37:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                        int length6 = this.lensOffset == null ? 0 : this.lensOffset.length;
                        float[] fArr2 = new float[(repeatedFieldArrayLength3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.lensOffset, 0, fArr2, 0, length6);
                        }
                        while (length6 < fArr2.length - 1) {
                            fArr2[length6] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        fArr2[length6] = codedInputByteBufferNano.readFloat();
                        this.lensOffset = fArr2;
                        continue;
                    case 41:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 41);
                        int length7 = this.lastGyroscopeSample == null ? 0 : this.lastGyroscopeSample.length;
                        double[] dArr5 = new double[(repeatedFieldArrayLength4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.lastGyroscopeSample, 0, dArr5, 0, length7);
                        }
                        while (length7 < dArr5.length - 1) {
                            dArr5[length7] = codedInputByteBufferNano.readDouble();
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        dArr5[length7] = codedInputByteBufferNano.readDouble();
                        this.lastGyroscopeSample = dArr5;
                        continue;
                    case 42:
                        int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                        int i4 = readRawVarint324 / 8;
                        int length8 = this.lastGyroscopeSample == null ? 0 : this.lastGyroscopeSample.length;
                        double[] dArr6 = new double[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.lastGyroscopeSample, 0, dArr6, 0, length8);
                        }
                        while (length8 < dArr6.length) {
                            dArr6[length8] = codedInputByteBufferNano.readDouble();
                            length8++;
                        }
                        this.lastGyroscopeSample = dArr6;
                        codedInputByteBufferNano.popLimit(pushLimit4);
                        continue;
                    case 49:
                        this.lastGyroscopeTimestamp_ = codedInputByteBufferNano.readDouble();
                        this.bitField0_ |= 2;
                        continue;
                    case 56:
                        this.trackingInVrcore_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 4;
                        continue;
                    case 65:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 65);
                        int length9 = this.magnetometerBias == null ? 0 : this.magnetometerBias.length;
                        double[] dArr7 = new double[(repeatedFieldArrayLength5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.magnetometerBias, 0, dArr7, 0, length9);
                        }
                        while (length9 < dArr7.length - 1) {
                            dArr7[length9] = codedInputByteBufferNano.readDouble();
                            codedInputByteBufferNano.readTag();
                            length9++;
                        }
                        dArr7[length9] = codedInputByteBufferNano.readDouble();
                        this.magnetometerBias = dArr7;
                        continue;
                    case 66:
                        int readRawVarint325 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit5 = codedInputByteBufferNano.pushLimit(readRawVarint325);
                        int i5 = readRawVarint325 / 8;
                        int length10 = this.magnetometerBias == null ? 0 : this.magnetometerBias.length;
                        double[] dArr8 = new double[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.magnetometerBias, 0, dArr8, 0, length10);
                        }
                        while (length10 < dArr8.length) {
                            dArr8[length10] = codedInputByteBufferNano.readDouble();
                            length10++;
                        }
                        this.magnetometerBias = dArr8;
                        codedInputByteBufferNano.popLimit(pushLimit5);
                        continue;
                    case 73:
                        this.magneticFieldStrength_ = codedInputByteBufferNano.readDouble();
                        this.bitField0_ |= 8;
                        continue;
                    case 80:
                        this.magCalibrationTimeSinceEpochSeconds_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 16;
                        continue;
                    case 90:
                        int readRawVarint326 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit6 = codedInputByteBufferNano.pushLimit(readRawVarint326);
                        int i6 = readRawVarint326 / 4;
                        int length11 = this.rightLensOffset == null ? 0 : this.rightLensOffset.length;
                        float[] fArr3 = new float[(i6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.rightLensOffset, 0, fArr3, 0, length11);
                        }
                        while (length11 < fArr3.length) {
                            fArr3[length11] = codedInputByteBufferNano.readFloat();
                            length11++;
                        }
                        this.rightLensOffset = fArr3;
                        codedInputByteBufferNano.popLimit(pushLimit6);
                        continue;
                    case 93:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 93);
                        int length12 = this.rightLensOffset == null ? 0 : this.rightLensOffset.length;
                        float[] fArr4 = new float[(repeatedFieldArrayLength6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.rightLensOffset, 0, fArr4, 0, length12);
                        }
                        while (length12 < fArr4.length - 1) {
                            fArr4[length12] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length12++;
                        }
                        fArr4[length12] = codedInputByteBufferNano.readFloat();
                        this.rightLensOffset = fArr4;
                        continue;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public static TrackerState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (TrackerState) MessageNano.mergeFrom(new TrackerState(), bArr);
        }

        public static TrackerState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new TrackerState().mergeFrom(codedInputByteBufferNano);
        }
    }
}
