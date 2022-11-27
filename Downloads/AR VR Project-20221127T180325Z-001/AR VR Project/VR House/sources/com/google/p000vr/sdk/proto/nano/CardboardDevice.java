package com.google.p000vr.sdk.proto.nano;

import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.DescriptorProtos;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.NanoEnumValue;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice */
public class CardboardDevice {
    private CardboardDevice() {
    }

    /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$CardboardInternalParams */
    public static final class CardboardInternalParams extends ExtendableMessageNano<CardboardInternalParams> implements Cloneable {
        private static volatile CardboardInternalParams[] _emptyArray;
        private String accelerometer_;
        private int bitField0_;
        @NanoEnumValue(legacy = false, value = OrientationType.class)
        public int[] eyeOrientations;
        private String gyroscope_;
        private float screenCenterToLensDistance_;
        private float xPpiOverride_;
        private float yPpiOverride_;

        /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$CardboardInternalParams$OrientationType */
        public interface OrientationType {
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_0_DEGREES = 0;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_0_DEGREES_MIRRORED = 4;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_180_DEGREES = 2;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_180_DEGREES_MIRRORED = 6;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_270_DEGREES = 3;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_270_DEGREES_MIRRORED = 7;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_90_DEGREES = 1;
            @NanoEnumValue(legacy = false, value = OrientationType.class)
            public static final int CCW_90_DEGREES_MIRRORED = 5;
        }

        @NanoEnumValue(legacy = false, value = OrientationType.class)
        public static int checkOrientationTypeOrThrow(int i) {
            if (i >= 0 && i <= 7) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(47).append(i).append(" is not a valid enum OrientationType").toString());
        }

        @NanoEnumValue(legacy = false, value = OrientationType.class)
        public static int[] checkOrientationTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkOrientationTypeOrThrow : iArr2) {
                checkOrientationTypeOrThrow(checkOrientationTypeOrThrow);
            }
            return iArr2;
        }

        public static CardboardInternalParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CardboardInternalParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final float getScreenCenterToLensDistance() {
            return this.screenCenterToLensDistance_;
        }

        public final boolean hasScreenCenterToLensDistance() {
            return (this.bitField0_ & 1) != 0;
        }

        public final CardboardInternalParams clearScreenCenterToLensDistance() {
            this.screenCenterToLensDistance_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final CardboardInternalParams setScreenCenterToLensDistance(float f) {
            this.bitField0_ |= 1;
            this.screenCenterToLensDistance_ = f;
            return this;
        }

        public final float getXPpiOverride() {
            return this.xPpiOverride_;
        }

        public final boolean hasXPpiOverride() {
            return (this.bitField0_ & 2) != 0;
        }

        public final CardboardInternalParams clearXPpiOverride() {
            this.xPpiOverride_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final CardboardInternalParams setXPpiOverride(float f) {
            this.bitField0_ |= 2;
            this.xPpiOverride_ = f;
            return this;
        }

        public final float getYPpiOverride() {
            return this.yPpiOverride_;
        }

        public final boolean hasYPpiOverride() {
            return (this.bitField0_ & 4) != 0;
        }

        public final CardboardInternalParams clearYPpiOverride() {
            this.yPpiOverride_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final CardboardInternalParams setYPpiOverride(float f) {
            this.bitField0_ |= 4;
            this.yPpiOverride_ = f;
            return this;
        }

        public final String getAccelerometer() {
            return this.accelerometer_;
        }

        public final boolean hasAccelerometer() {
            return (this.bitField0_ & 8) != 0;
        }

        public final CardboardInternalParams clearAccelerometer() {
            this.accelerometer_ = "";
            this.bitField0_ &= -9;
            return this;
        }

        public final CardboardInternalParams setAccelerometer(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.accelerometer_ = str;
            return this;
        }

        public final String getGyroscope() {
            return this.gyroscope_;
        }

        public final boolean hasGyroscope() {
            return (this.bitField0_ & 16) != 0;
        }

        public final CardboardInternalParams clearGyroscope() {
            this.gyroscope_ = "";
            this.bitField0_ &= -17;
            return this;
        }

        public final CardboardInternalParams setGyroscope(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.gyroscope_ = str;
            return this;
        }

        public CardboardInternalParams() {
            clear();
        }

        public final CardboardInternalParams clear() {
            this.bitField0_ = 0;
            this.eyeOrientations = WireFormatNano.EMPTY_INT_ARRAY;
            this.screenCenterToLensDistance_ = 0.0f;
            this.xPpiOverride_ = 0.0f;
            this.yPpiOverride_ = 0.0f;
            this.accelerometer_ = "";
            this.gyroscope_ = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final CardboardInternalParams clone() {
            try {
                CardboardInternalParams cardboardInternalParams = (CardboardInternalParams) super.clone();
                if (this.eyeOrientations != null && this.eyeOrientations.length > 0) {
                    cardboardInternalParams.eyeOrientations = (int[]) this.eyeOrientations.clone();
                }
                return cardboardInternalParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.eyeOrientations != null && this.eyeOrientations.length > 0) {
                int i = 0;
                for (int computeInt32SizeNoTag : this.eyeOrientations) {
                    i += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                }
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(i);
                for (int writeRawVarint32 : this.eyeOrientations) {
                    codedOutputByteBufferNano.writeRawVarint32(writeRawVarint32);
                }
            }
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.screenCenterToLensDistance_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.xPpiOverride_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.yPpiOverride_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeString(5, this.accelerometer_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeString(6, this.gyroscope_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int i;
            int computeSerializedSize = super.computeSerializedSize();
            if (this.eyeOrientations == null || this.eyeOrientations.length <= 0) {
                i = computeSerializedSize;
            } else {
                int i2 = 0;
                for (int computeInt32SizeNoTag : this.eyeOrientations) {
                    i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                }
                i = computeSerializedSize + i2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i2);
            }
            if ((this.bitField0_ & 1) != 0) {
                i += CodedOutputByteBufferNano.computeFloatSize(2, this.screenCenterToLensDistance_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i += CodedOutputByteBufferNano.computeFloatSize(3, this.xPpiOverride_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i += CodedOutputByteBufferNano.computeFloatSize(4, this.yPpiOverride_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i += CodedOutputByteBufferNano.computeStringSize(5, this.accelerometer_);
            }
            if ((this.bitField0_ & 16) != 0) {
                return i + CodedOutputByteBufferNano.computeStringSize(6, this.gyroscope_);
            }
            return i;
        }

        public final CardboardInternalParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr = new int[repeatedFieldArrayLength];
                        int i = 0;
                        for (int i2 = 0; i2 < repeatedFieldArrayLength; i2++) {
                            if (i2 != 0) {
                                codedInputByteBufferNano.readTag();
                            }
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                iArr[i] = checkOrientationTypeOrThrow(codedInputByteBufferNano.readInt32());
                                i++;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            }
                        }
                        if (i != 0) {
                            int length = this.eyeOrientations == null ? 0 : this.eyeOrientations.length;
                            if (length != 0 || i != repeatedFieldArrayLength) {
                                int[] iArr2 = new int[(length + i)];
                                if (length != 0) {
                                    System.arraycopy(this.eyeOrientations, 0, iArr2, 0, length);
                                }
                                System.arraycopy(iArr, 0, iArr2, length, i);
                                this.eyeOrientations = iArr2;
                                break;
                            } else {
                                this.eyeOrientations = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 10:
                        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position2 = codedInputByteBufferNano.getPosition();
                        int i3 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            try {
                                checkOrientationTypeOrThrow(codedInputByteBufferNano.readInt32());
                                i3++;
                            } catch (IllegalArgumentException e2) {
                            }
                        }
                        if (i3 != 0) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            int length2 = this.eyeOrientations == null ? 0 : this.eyeOrientations.length;
                            int[] iArr3 = new int[(i3 + length2)];
                            if (length2 != 0) {
                                System.arraycopy(this.eyeOrientations, 0, iArr3, 0, length2);
                            }
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    iArr3[length2] = checkOrientationTypeOrThrow(codedInputByteBufferNano.readInt32());
                                    length2++;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, 8);
                                }
                            }
                            this.eyeOrientations = iArr3;
                        }
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 21:
                        this.screenCenterToLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 1;
                        continue;
                    case 29:
                        this.xPpiOverride_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 2;
                        continue;
                    case 37:
                        this.yPpiOverride_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 4;
                        continue;
                    case 42:
                        this.accelerometer_ = codedInputByteBufferNano.readString();
                        this.bitField0_ |= 8;
                        continue;
                    case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                        this.gyroscope_ = codedInputByteBufferNano.readString();
                        this.bitField0_ |= 16;
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

        public static CardboardInternalParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (CardboardInternalParams) MessageNano.mergeFrom(new CardboardInternalParams(), bArr);
        }

        public static CardboardInternalParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new CardboardInternalParams().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$DeviceParams */
    public static final class DeviceParams extends ExtendableMessageNano<DeviceParams> implements Cloneable {
        private static volatile DeviceParams[] _emptyArray;
        private int bitField0_;
        public float[] blueDistortionCoefficients;
        public DaydreamInternalParams daydreamInternal;
        public float[] distortionCoefficients;
        public float[] greenDistortionCoefficients;
        private boolean hasMagnet_;
        private float interLensDistance_;
        public CardboardInternalParams internal;
        public float[] leftEyeFieldOfViewAngles;
        private String model_;
        private int primaryButton_;
        private float screenToLensDistance_;
        private float trayToLensDistance_;
        private String vendor_;
        private int verticalAlignment_;

        /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$DeviceParams$ButtonType */
        public interface ButtonType {
            @NanoEnumValue(legacy = false, value = ButtonType.class)
            public static final int INDIRECT_TOUCH = 3;
            @NanoEnumValue(legacy = false, value = ButtonType.class)
            public static final int MAGNET = 1;
            @NanoEnumValue(legacy = false, value = ButtonType.class)
            public static final int NONE = 0;
            @NanoEnumValue(legacy = false, value = ButtonType.class)
            public static final int TOUCH = 2;
        }

        /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$DeviceParams$VerticalAlignmentType */
        public interface VerticalAlignmentType {
            @NanoEnumValue(legacy = false, value = VerticalAlignmentType.class)
            public static final int BOTTOM = 0;
            @NanoEnumValue(legacy = false, value = VerticalAlignmentType.class)
            public static final int CENTER = 1;
            @NanoEnumValue(legacy = false, value = VerticalAlignmentType.class)
            public static final int TOP = 2;
        }

        @NanoEnumValue(legacy = false, value = VerticalAlignmentType.class)
        public static int checkVerticalAlignmentTypeOrThrow(int i) {
            if (i >= 0 && i <= 2) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(53).append(i).append(" is not a valid enum VerticalAlignmentType").toString());
        }

        @NanoEnumValue(legacy = false, value = VerticalAlignmentType.class)
        public static int[] checkVerticalAlignmentTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkVerticalAlignmentTypeOrThrow : iArr2) {
                checkVerticalAlignmentTypeOrThrow(checkVerticalAlignmentTypeOrThrow);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = ButtonType.class)
        public static int checkButtonTypeOrThrow(int i) {
            if (i >= 0 && i <= 3) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum ButtonType").toString());
        }

        @NanoEnumValue(legacy = false, value = ButtonType.class)
        public static int[] checkButtonTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkButtonTypeOrThrow : iArr2) {
                checkButtonTypeOrThrow(checkButtonTypeOrThrow);
            }
            return iArr2;
        }

        public static DeviceParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final String getVendor() {
            return this.vendor_;
        }

        public final boolean hasVendor() {
            return (this.bitField0_ & 1) != 0;
        }

        public final DeviceParams clearVendor() {
            this.vendor_ = "";
            this.bitField0_ &= -2;
            return this;
        }

        public final DeviceParams setVendor(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.vendor_ = str;
            return this;
        }

        public final String getModel() {
            return this.model_;
        }

        public final boolean hasModel() {
            return (this.bitField0_ & 2) != 0;
        }

        public final DeviceParams clearModel() {
            this.model_ = "";
            this.bitField0_ &= -3;
            return this;
        }

        public final DeviceParams setModel(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.model_ = str;
            return this;
        }

        public final float getScreenToLensDistance() {
            return this.screenToLensDistance_;
        }

        public final boolean hasScreenToLensDistance() {
            return (this.bitField0_ & 4) != 0;
        }

        public final DeviceParams clearScreenToLensDistance() {
            this.screenToLensDistance_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final DeviceParams setScreenToLensDistance(float f) {
            this.bitField0_ |= 4;
            this.screenToLensDistance_ = f;
            return this;
        }

        public final float getInterLensDistance() {
            return this.interLensDistance_;
        }

        public final boolean hasInterLensDistance() {
            return (this.bitField0_ & 8) != 0;
        }

        public final DeviceParams clearInterLensDistance() {
            this.interLensDistance_ = 0.0f;
            this.bitField0_ &= -9;
            return this;
        }

        public final DeviceParams setInterLensDistance(float f) {
            this.bitField0_ |= 8;
            this.interLensDistance_ = f;
            return this;
        }

        @NanoEnumValue(legacy = false, value = VerticalAlignmentType.class)
        public final int getVerticalAlignment() {
            return this.verticalAlignment_;
        }

        public final DeviceParams setVerticalAlignment(@NanoEnumValue(legacy = false, value = VerticalAlignmentType.class) int i) {
            this.verticalAlignment_ = i;
            this.bitField0_ |= 16;
            return this;
        }

        public final boolean hasVerticalAlignment() {
            return (this.bitField0_ & 16) != 0;
        }

        public final DeviceParams clearVerticalAlignment() {
            this.bitField0_ &= -17;
            this.verticalAlignment_ = 0;
            return this;
        }

        public final float getTrayToLensDistance() {
            return this.trayToLensDistance_;
        }

        public final boolean hasTrayToLensDistance() {
            return (this.bitField0_ & 32) != 0;
        }

        public final DeviceParams clearTrayToLensDistance() {
            this.trayToLensDistance_ = 0.0f;
            this.bitField0_ &= -33;
            return this;
        }

        public final DeviceParams setTrayToLensDistance(float f) {
            this.bitField0_ |= 32;
            this.trayToLensDistance_ = f;
            return this;
        }

        public final boolean getHasMagnet() {
            return this.hasMagnet_;
        }

        public final boolean hasHasMagnet() {
            return (this.bitField0_ & 64) != 0;
        }

        public final DeviceParams clearHasMagnet() {
            this.hasMagnet_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public final DeviceParams setHasMagnet(boolean z) {
            this.bitField0_ |= 64;
            this.hasMagnet_ = z;
            return this;
        }

        @NanoEnumValue(legacy = false, value = ButtonType.class)
        public final int getPrimaryButton() {
            return this.primaryButton_;
        }

        public final DeviceParams setPrimaryButton(@NanoEnumValue(legacy = false, value = ButtonType.class) int i) {
            this.primaryButton_ = i;
            this.bitField0_ |= 128;
            return this;
        }

        public final boolean hasPrimaryButton() {
            return (this.bitField0_ & 128) != 0;
        }

        public final DeviceParams clearPrimaryButton() {
            this.bitField0_ &= -129;
            this.primaryButton_ = 1;
            return this;
        }

        public DeviceParams() {
            clear();
        }

        public final DeviceParams clear() {
            this.bitField0_ = 0;
            this.vendor_ = "";
            this.model_ = "";
            this.screenToLensDistance_ = 0.0f;
            this.interLensDistance_ = 0.0f;
            this.leftEyeFieldOfViewAngles = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.verticalAlignment_ = 0;
            this.trayToLensDistance_ = 0.0f;
            this.distortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.greenDistortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.blueDistortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.hasMagnet_ = false;
            this.primaryButton_ = 1;
            this.internal = null;
            this.daydreamInternal = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DeviceParams clone() {
            try {
                DeviceParams deviceParams = (DeviceParams) super.clone();
                if (this.leftEyeFieldOfViewAngles != null && this.leftEyeFieldOfViewAngles.length > 0) {
                    deviceParams.leftEyeFieldOfViewAngles = (float[]) this.leftEyeFieldOfViewAngles.clone();
                }
                if (this.distortionCoefficients != null && this.distortionCoefficients.length > 0) {
                    deviceParams.distortionCoefficients = (float[]) this.distortionCoefficients.clone();
                }
                if (this.greenDistortionCoefficients != null && this.greenDistortionCoefficients.length > 0) {
                    deviceParams.greenDistortionCoefficients = (float[]) this.greenDistortionCoefficients.clone();
                }
                if (this.blueDistortionCoefficients != null && this.blueDistortionCoefficients.length > 0) {
                    deviceParams.blueDistortionCoefficients = (float[]) this.blueDistortionCoefficients.clone();
                }
                if (this.internal != null) {
                    deviceParams.internal = this.internal.clone();
                }
                if (this.daydreamInternal != null) {
                    deviceParams.daydreamInternal = this.daydreamInternal.clone();
                }
                return deviceParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeString(1, this.vendor_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeString(2, this.model_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.screenToLensDistance_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.interLensDistance_);
            }
            if (this.leftEyeFieldOfViewAngles != null && this.leftEyeFieldOfViewAngles.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(42);
                codedOutputByteBufferNano.writeRawVarint32(this.leftEyeFieldOfViewAngles.length * 4);
                for (float writeFloatNoTag : this.leftEyeFieldOfViewAngles) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag);
                }
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeFloat(6, this.trayToLensDistance_);
            }
            if (this.distortionCoefficients != null && this.distortionCoefficients.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(58);
                codedOutputByteBufferNano.writeRawVarint32(this.distortionCoefficients.length * 4);
                for (float writeFloatNoTag2 : this.distortionCoefficients) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag2);
                }
            }
            if (this.greenDistortionCoefficients != null && this.greenDistortionCoefficients.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(66);
                codedOutputByteBufferNano.writeRawVarint32(this.greenDistortionCoefficients.length * 4);
                for (float writeFloatNoTag3 : this.greenDistortionCoefficients) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag3);
                }
            }
            if (this.blueDistortionCoefficients != null && this.blueDistortionCoefficients.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(74);
                codedOutputByteBufferNano.writeRawVarint32(this.blueDistortionCoefficients.length * 4);
                for (float writeFloatNoTag4 : this.blueDistortionCoefficients) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag4);
                }
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputByteBufferNano.writeBool(10, this.hasMagnet_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeInt32(11, this.verticalAlignment_);
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputByteBufferNano.writeInt32(12, this.primaryButton_);
            }
            if (this.internal != null) {
                codedOutputByteBufferNano.writeMessage(1729, this.internal);
            }
            if (this.daydreamInternal != null) {
                codedOutputByteBufferNano.writeMessage(196883, this.daydreamInternal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.vendor_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.model_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.screenToLensDistance_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.interLensDistance_);
            }
            if (this.leftEyeFieldOfViewAngles != null && this.leftEyeFieldOfViewAngles.length > 0) {
                int length = this.leftEyeFieldOfViewAngles.length * 4;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.trayToLensDistance_);
            }
            if (this.distortionCoefficients != null && this.distortionCoefficients.length > 0) {
                int length2 = this.distortionCoefficients.length * 4;
                computeSerializedSize = computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
            }
            if (this.greenDistortionCoefficients != null && this.greenDistortionCoefficients.length > 0) {
                int length3 = this.greenDistortionCoefficients.length * 4;
                computeSerializedSize = computeSerializedSize + length3 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length3);
            }
            if (this.blueDistortionCoefficients != null && this.blueDistortionCoefficients.length > 0) {
                int length4 = this.blueDistortionCoefficients.length * 4;
                computeSerializedSize = computeSerializedSize + length4 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length4);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.hasMagnet_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, this.verticalAlignment_);
            }
            if ((this.bitField0_ & 128) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, this.primaryButton_);
            }
            if (this.internal != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1729, this.internal);
            }
            if (this.daydreamInternal != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(196883, this.daydreamInternal);
            }
            return computeSerializedSize;
        }

        public final DeviceParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.vendor_ = codedInputByteBufferNano.readString();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        this.model_ = codedInputByteBufferNano.readString();
                        this.bitField0_ |= 2;
                        continue;
                    case 29:
                        this.screenToLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 4;
                        continue;
                    case 37:
                        this.interLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 8;
                        continue;
                    case 42:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i = readRawVarint32 / 4;
                        int length = this.leftEyeFieldOfViewAngles == null ? 0 : this.leftEyeFieldOfViewAngles.length;
                        float[] fArr = new float[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.leftEyeFieldOfViewAngles, 0, fArr, 0, length);
                        }
                        while (length < fArr.length) {
                            fArr[length] = codedInputByteBufferNano.readFloat();
                            length++;
                        }
                        this.leftEyeFieldOfViewAngles = fArr;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 45:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 45);
                        int length2 = this.leftEyeFieldOfViewAngles == null ? 0 : this.leftEyeFieldOfViewAngles.length;
                        float[] fArr2 = new float[(repeatedFieldArrayLength + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.leftEyeFieldOfViewAngles, 0, fArr2, 0, length2);
                        }
                        while (length2 < fArr2.length - 1) {
                            fArr2[length2] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        fArr2[length2] = codedInputByteBufferNano.readFloat();
                        this.leftEyeFieldOfViewAngles = fArr2;
                        continue;
                    case 53:
                        this.trayToLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 32;
                        continue;
                    case 58:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i2 = readRawVarint322 / 4;
                        int length3 = this.distortionCoefficients == null ? 0 : this.distortionCoefficients.length;
                        float[] fArr3 = new float[(i2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.distortionCoefficients, 0, fArr3, 0, length3);
                        }
                        while (length3 < fArr3.length) {
                            fArr3[length3] = codedInputByteBufferNano.readFloat();
                            length3++;
                        }
                        this.distortionCoefficients = fArr3;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        continue;
                    case 61:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 61);
                        int length4 = this.distortionCoefficients == null ? 0 : this.distortionCoefficients.length;
                        float[] fArr4 = new float[(repeatedFieldArrayLength2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.distortionCoefficients, 0, fArr4, 0, length4);
                        }
                        while (length4 < fArr4.length - 1) {
                            fArr4[length4] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        fArr4[length4] = codedInputByteBufferNano.readFloat();
                        this.distortionCoefficients = fArr4;
                        continue;
                    case 66:
                        int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                        int i3 = readRawVarint323 / 4;
                        int length5 = this.greenDistortionCoefficients == null ? 0 : this.greenDistortionCoefficients.length;
                        float[] fArr5 = new float[(i3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.greenDistortionCoefficients, 0, fArr5, 0, length5);
                        }
                        while (length5 < fArr5.length) {
                            fArr5[length5] = codedInputByteBufferNano.readFloat();
                            length5++;
                        }
                        this.greenDistortionCoefficients = fArr5;
                        codedInputByteBufferNano.popLimit(pushLimit3);
                        continue;
                    case 69:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 69);
                        int length6 = this.greenDistortionCoefficients == null ? 0 : this.greenDistortionCoefficients.length;
                        float[] fArr6 = new float[(repeatedFieldArrayLength3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.greenDistortionCoefficients, 0, fArr6, 0, length6);
                        }
                        while (length6 < fArr6.length - 1) {
                            fArr6[length6] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        fArr6[length6] = codedInputByteBufferNano.readFloat();
                        this.greenDistortionCoefficients = fArr6;
                        continue;
                    case 74:
                        int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                        int i4 = readRawVarint324 / 4;
                        int length7 = this.blueDistortionCoefficients == null ? 0 : this.blueDistortionCoefficients.length;
                        float[] fArr7 = new float[(i4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.blueDistortionCoefficients, 0, fArr7, 0, length7);
                        }
                        while (length7 < fArr7.length) {
                            fArr7[length7] = codedInputByteBufferNano.readFloat();
                            length7++;
                        }
                        this.blueDistortionCoefficients = fArr7;
                        codedInputByteBufferNano.popLimit(pushLimit4);
                        continue;
                    case 77:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 77);
                        int length8 = this.blueDistortionCoefficients == null ? 0 : this.blueDistortionCoefficients.length;
                        float[] fArr8 = new float[(repeatedFieldArrayLength4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.blueDistortionCoefficients, 0, fArr8, 0, length8);
                        }
                        while (length8 < fArr8.length - 1) {
                            fArr8[length8] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        fArr8[length8] = codedInputByteBufferNano.readFloat();
                        this.blueDistortionCoefficients = fArr8;
                        continue;
                    case 80:
                        this.hasMagnet_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 64;
                        continue;
                    case 88:
                        this.bitField0_ |= 16;
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.verticalAlignment_ = checkVerticalAlignmentTypeOrThrow(codedInputByteBufferNano.readInt32());
                            this.bitField0_ |= 16;
                            continue;
                        } catch (IllegalArgumentException e) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 96:
                        this.bitField0_ |= 128;
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.primaryButton_ = checkButtonTypeOrThrow(codedInputByteBufferNano.readInt32());
                            this.bitField0_ |= 128;
                            continue;
                        } catch (IllegalArgumentException e2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 13834:
                        if (this.internal == null) {
                            this.internal = new CardboardInternalParams();
                        }
                        codedInputByteBufferNano.readMessage(this.internal);
                        continue;
                    case 1575066:
                        if (this.daydreamInternal == null) {
                            this.daydreamInternal = new DaydreamInternalParams();
                        }
                        codedInputByteBufferNano.readMessage(this.daydreamInternal);
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

        public static DeviceParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (DeviceParams) MessageNano.mergeFrom(new DeviceParams(), bArr);
        }

        public static DeviceParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DeviceParams().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$VignetteParams */
    public static final class VignetteParams extends ExtendableMessageNano<VignetteParams> implements Cloneable {
        private static volatile VignetteParams[] _emptyArray;
        private int bitField0_;
        private int condition_;
        private float value_;

        /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$VignetteParams$VignetteParamsCondition */
        public interface VignetteParamsCondition {
            @NanoEnumValue(legacy = false, value = VignetteParamsCondition.class)
            public static final int HORIZ_DIMEN_LESS_THAN_METER = 1;
            @NanoEnumValue(legacy = false, value = VignetteParamsCondition.class)
            public static final int NO_VIGNETTE_CONDITION = 0;
        }

        @NanoEnumValue(legacy = false, value = VignetteParamsCondition.class)
        public static int checkVignetteParamsConditionOrThrow(int i) {
            if (i >= 0 && i <= 1) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(55).append(i).append(" is not a valid enum VignetteParamsCondition").toString());
        }

        @NanoEnumValue(legacy = false, value = VignetteParamsCondition.class)
        public static int[] checkVignetteParamsConditionOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkVignetteParamsConditionOrThrow : iArr2) {
                checkVignetteParamsConditionOrThrow(checkVignetteParamsConditionOrThrow);
            }
            return iArr2;
        }

        public static VignetteParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new VignetteParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        @NanoEnumValue(legacy = false, value = VignetteParamsCondition.class)
        public final int getCondition() {
            return this.condition_;
        }

        public final VignetteParams setCondition(@NanoEnumValue(legacy = false, value = VignetteParamsCondition.class) int i) {
            this.condition_ = i;
            this.bitField0_ |= 1;
            return this;
        }

        public final boolean hasCondition() {
            return (this.bitField0_ & 1) != 0;
        }

        public final VignetteParams clearCondition() {
            this.bitField0_ &= -2;
            this.condition_ = 0;
            return this;
        }

        public final float getValue() {
            return this.value_;
        }

        public final boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        public final VignetteParams clearValue() {
            this.value_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final VignetteParams setValue(float f) {
            this.bitField0_ |= 2;
            this.value_ = f;
            return this;
        }

        public VignetteParams() {
            clear();
        }

        public final VignetteParams clear() {
            this.bitField0_ = 0;
            this.condition_ = 0;
            this.value_ = 0.0f;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final VignetteParams clone() {
            try {
                return (VignetteParams) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(2, this.condition_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.value_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.condition_);
            }
            if ((this.bitField0_ & 2) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, this.value_);
            }
            return computeSerializedSize;
        }

        public final VignetteParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 16:
                        this.bitField0_ |= 1;
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.condition_ = checkVignetteParamsConditionOrThrow(codedInputByteBufferNano.readInt32());
                            this.bitField0_ |= 1;
                            continue;
                        } catch (IllegalArgumentException e) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 29:
                        this.value_ = codedInputByteBufferNano.readFloat();
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

        public static VignetteParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (VignetteParams) MessageNano.mergeFrom(new VignetteParams(), bArr);
        }

        public static VignetteParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new VignetteParams().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$DaydreamInternalParams */
    public static final class DaydreamInternalParams extends ExtendableMessageNano<DaydreamInternalParams> implements Cloneable {
        private static volatile DaydreamInternalParams[] _emptyArray;
        public ScreenAlignmentMarker[] alignmentMarkers;
        private int bitField0_;
        private boolean clampDistortionToMaximumFieldOfView_;
        private boolean clipFieldOfViewToDisplay_;
        private int distortionMeshResolution_;
        private boolean sensorOrientationIndependentOfDisplay_;
        private boolean useRotationalAlignmentCorrection_;
        private int version_;
        public VignetteParams vignetteParams;

        public static DaydreamInternalParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DaydreamInternalParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final int getVersion() {
            return this.version_;
        }

        public final boolean hasVersion() {
            return (this.bitField0_ & 1) != 0;
        }

        public final DaydreamInternalParams clearVersion() {
            this.version_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final DaydreamInternalParams setVersion(int i) {
            this.bitField0_ |= 1;
            this.version_ = i;
            return this;
        }

        public final boolean getUseRotationalAlignmentCorrection() {
            return this.useRotationalAlignmentCorrection_;
        }

        public final boolean hasUseRotationalAlignmentCorrection() {
            return (this.bitField0_ & 2) != 0;
        }

        public final DaydreamInternalParams clearUseRotationalAlignmentCorrection() {
            this.useRotationalAlignmentCorrection_ = false;
            this.bitField0_ &= -3;
            return this;
        }

        public final DaydreamInternalParams setUseRotationalAlignmentCorrection(boolean z) {
            this.bitField0_ |= 2;
            this.useRotationalAlignmentCorrection_ = z;
            return this;
        }

        public final boolean getSensorOrientationIndependentOfDisplay() {
            return this.sensorOrientationIndependentOfDisplay_;
        }

        public final boolean hasSensorOrientationIndependentOfDisplay() {
            return (this.bitField0_ & 4) != 0;
        }

        public final DaydreamInternalParams clearSensorOrientationIndependentOfDisplay() {
            this.sensorOrientationIndependentOfDisplay_ = false;
            this.bitField0_ &= -5;
            return this;
        }

        public final DaydreamInternalParams setSensorOrientationIndependentOfDisplay(boolean z) {
            this.bitField0_ |= 4;
            this.sensorOrientationIndependentOfDisplay_ = z;
            return this;
        }

        public final int getDistortionMeshResolution() {
            return this.distortionMeshResolution_;
        }

        public final boolean hasDistortionMeshResolution() {
            return (this.bitField0_ & 8) != 0;
        }

        public final DaydreamInternalParams clearDistortionMeshResolution() {
            this.distortionMeshResolution_ = 40;
            this.bitField0_ &= -9;
            return this;
        }

        public final DaydreamInternalParams setDistortionMeshResolution(int i) {
            this.bitField0_ |= 8;
            this.distortionMeshResolution_ = i;
            return this;
        }

        public final boolean getClipFieldOfViewToDisplay() {
            return this.clipFieldOfViewToDisplay_;
        }

        public final boolean hasClipFieldOfViewToDisplay() {
            return (this.bitField0_ & 16) != 0;
        }

        public final DaydreamInternalParams clearClipFieldOfViewToDisplay() {
            this.clipFieldOfViewToDisplay_ = true;
            this.bitField0_ &= -17;
            return this;
        }

        public final DaydreamInternalParams setClipFieldOfViewToDisplay(boolean z) {
            this.bitField0_ |= 16;
            this.clipFieldOfViewToDisplay_ = z;
            return this;
        }

        public final boolean getClampDistortionToMaximumFieldOfView() {
            return this.clampDistortionToMaximumFieldOfView_;
        }

        public final boolean hasClampDistortionToMaximumFieldOfView() {
            return (this.bitField0_ & 32) != 0;
        }

        public final DaydreamInternalParams clearClampDistortionToMaximumFieldOfView() {
            this.clampDistortionToMaximumFieldOfView_ = false;
            this.bitField0_ &= -33;
            return this;
        }

        public final DaydreamInternalParams setClampDistortionToMaximumFieldOfView(boolean z) {
            this.bitField0_ |= 32;
            this.clampDistortionToMaximumFieldOfView_ = z;
            return this;
        }

        public DaydreamInternalParams() {
            clear();
        }

        public final DaydreamInternalParams clear() {
            this.bitField0_ = 0;
            this.version_ = 0;
            this.alignmentMarkers = ScreenAlignmentMarker.emptyArray();
            this.useRotationalAlignmentCorrection_ = false;
            this.sensorOrientationIndependentOfDisplay_ = false;
            this.vignetteParams = null;
            this.distortionMeshResolution_ = 40;
            this.clipFieldOfViewToDisplay_ = true;
            this.clampDistortionToMaximumFieldOfView_ = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DaydreamInternalParams clone() {
            try {
                DaydreamInternalParams daydreamInternalParams = (DaydreamInternalParams) super.clone();
                if (this.alignmentMarkers != null && this.alignmentMarkers.length > 0) {
                    daydreamInternalParams.alignmentMarkers = new ScreenAlignmentMarker[this.alignmentMarkers.length];
                    for (int i = 0; i < this.alignmentMarkers.length; i++) {
                        if (this.alignmentMarkers[i] != null) {
                            daydreamInternalParams.alignmentMarkers[i] = this.alignmentMarkers[i].clone();
                        }
                    }
                }
                if (this.vignetteParams != null) {
                    daydreamInternalParams.vignetteParams = this.vignetteParams.clone();
                }
                return daydreamInternalParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(1, this.version_);
            }
            if (this.alignmentMarkers != null && this.alignmentMarkers.length > 0) {
                for (ScreenAlignmentMarker screenAlignmentMarker : this.alignmentMarkers) {
                    if (screenAlignmentMarker != null) {
                        codedOutputByteBufferNano.writeMessage(2, screenAlignmentMarker);
                    }
                }
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeBool(3, this.useRotationalAlignmentCorrection_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(4, this.sensorOrientationIndependentOfDisplay_);
            }
            if (this.vignetteParams != null) {
                codedOutputByteBufferNano.writeMessage(5, this.vignetteParams);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeInt32(6, this.distortionMeshResolution_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeBool(7, this.clipFieldOfViewToDisplay_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeBool(8, this.clampDistortionToMaximumFieldOfView_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.version_);
            }
            if (this.alignmentMarkers != null && this.alignmentMarkers.length > 0) {
                int i = computeSerializedSize;
                for (ScreenAlignmentMarker screenAlignmentMarker : this.alignmentMarkers) {
                    if (screenAlignmentMarker != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(2, screenAlignmentMarker);
                    }
                }
                computeSerializedSize = i;
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.useRotationalAlignmentCorrection_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, this.sensorOrientationIndependentOfDisplay_);
            }
            if (this.vignetteParams != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.vignetteParams);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.distortionMeshResolution_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.clipFieldOfViewToDisplay_);
            }
            if ((this.bitField0_ & 32) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(8, this.clampDistortionToMaximumFieldOfView_);
            }
            return computeSerializedSize;
        }

        public final DaydreamInternalParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.version_ = codedInputByteBufferNano.readInt32();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        int length = this.alignmentMarkers == null ? 0 : this.alignmentMarkers.length;
                        ScreenAlignmentMarker[] screenAlignmentMarkerArr = new ScreenAlignmentMarker[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.alignmentMarkers, 0, screenAlignmentMarkerArr, 0, length);
                        }
                        while (length < screenAlignmentMarkerArr.length - 1) {
                            screenAlignmentMarkerArr[length] = new ScreenAlignmentMarker();
                            codedInputByteBufferNano.readMessage(screenAlignmentMarkerArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        screenAlignmentMarkerArr[length] = new ScreenAlignmentMarker();
                        codedInputByteBufferNano.readMessage(screenAlignmentMarkerArr[length]);
                        this.alignmentMarkers = screenAlignmentMarkerArr;
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.useRotationalAlignmentCorrection_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 2;
                        continue;
                    case 32:
                        this.sensorOrientationIndependentOfDisplay_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 4;
                        continue;
                    case 42:
                        if (this.vignetteParams == null) {
                            this.vignetteParams = new VignetteParams();
                        }
                        codedInputByteBufferNano.readMessage(this.vignetteParams);
                        continue;
                    case 48:
                        this.distortionMeshResolution_ = codedInputByteBufferNano.readInt32();
                        this.bitField0_ |= 8;
                        continue;
                    case 56:
                        this.clipFieldOfViewToDisplay_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 16;
                        continue;
                    case 64:
                        this.clampDistortionToMaximumFieldOfView_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 32;
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

        public static DaydreamInternalParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (DaydreamInternalParams) MessageNano.mergeFrom(new DaydreamInternalParams(), bArr);
        }

        public static DaydreamInternalParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DaydreamInternalParams().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$DeviceParamsList */
    public static final class DeviceParamsList extends ExtendableMessageNano<DeviceParamsList> implements Cloneable {
        private static volatile DeviceParamsList[] _emptyArray;
        public DeviceParams[] params;

        public static DeviceParamsList[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceParamsList[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DeviceParamsList() {
            clear();
        }

        public final DeviceParamsList clear() {
            this.params = DeviceParams.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DeviceParamsList clone() {
            try {
                DeviceParamsList deviceParamsList = (DeviceParamsList) super.clone();
                if (this.params != null && this.params.length > 0) {
                    deviceParamsList.params = new DeviceParams[this.params.length];
                    for (int i = 0; i < this.params.length; i++) {
                        if (this.params[i] != null) {
                            deviceParamsList.params[i] = this.params[i].clone();
                        }
                    }
                }
                return deviceParamsList;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.params != null && this.params.length > 0) {
                for (DeviceParams deviceParams : this.params) {
                    if (deviceParams != null) {
                        codedOutputByteBufferNano.writeMessage(1, deviceParams);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.params != null && this.params.length > 0) {
                for (DeviceParams deviceParams : this.params) {
                    if (deviceParams != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, deviceParams);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final DeviceParamsList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        int length = this.params == null ? 0 : this.params.length;
                        DeviceParams[] deviceParamsArr = new DeviceParams[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.params, 0, deviceParamsArr, 0, length);
                        }
                        while (length < deviceParamsArr.length - 1) {
                            deviceParamsArr[length] = new DeviceParams();
                            codedInputByteBufferNano.readMessage(deviceParamsArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        deviceParamsArr[length] = new DeviceParams();
                        codedInputByteBufferNano.readMessage(deviceParamsArr[length]);
                        this.params = deviceParamsArr;
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

        public static DeviceParamsList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (DeviceParamsList) MessageNano.mergeFrom(new DeviceParamsList(), bArr);
        }

        public static DeviceParamsList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DeviceParamsList().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.CardboardDevice$ScreenAlignmentMarker */
    public static final class ScreenAlignmentMarker extends ExtendableMessageNano<ScreenAlignmentMarker> implements Cloneable {
        private static volatile ScreenAlignmentMarker[] _emptyArray;
        private int bitField0_;
        private float horizontal_;
        private float vertical_;

        public static ScreenAlignmentMarker[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScreenAlignmentMarker[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final float getHorizontal() {
            return this.horizontal_;
        }

        public final boolean hasHorizontal() {
            return (this.bitField0_ & 1) != 0;
        }

        public final ScreenAlignmentMarker clearHorizontal() {
            this.horizontal_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final ScreenAlignmentMarker setHorizontal(float f) {
            this.bitField0_ |= 1;
            this.horizontal_ = f;
            return this;
        }

        public final float getVertical() {
            return this.vertical_;
        }

        public final boolean hasVertical() {
            return (this.bitField0_ & 2) != 0;
        }

        public final ScreenAlignmentMarker clearVertical() {
            this.vertical_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final ScreenAlignmentMarker setVertical(float f) {
            this.bitField0_ |= 2;
            this.vertical_ = f;
            return this;
        }

        public ScreenAlignmentMarker() {
            clear();
        }

        public final ScreenAlignmentMarker clear() {
            this.bitField0_ = 0;
            this.horizontal_ = 0.0f;
            this.vertical_ = 0.0f;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final ScreenAlignmentMarker clone() {
            try {
                return (ScreenAlignmentMarker) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.horizontal_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.vertical_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.horizontal_);
            }
            if ((this.bitField0_ & 2) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, this.vertical_);
            }
            return computeSerializedSize;
        }

        public final ScreenAlignmentMarker mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 13:
                        this.horizontal_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 1;
                        continue;
                    case 21:
                        this.vertical_ = codedInputByteBufferNano.readFloat();
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

        public static ScreenAlignmentMarker parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (ScreenAlignmentMarker) MessageNano.mergeFrom(new ScreenAlignmentMarker(), bArr);
        }

        public static ScreenAlignmentMarker parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ScreenAlignmentMarker().mergeFrom(codedInputByteBufferNano);
        }
    }
}
