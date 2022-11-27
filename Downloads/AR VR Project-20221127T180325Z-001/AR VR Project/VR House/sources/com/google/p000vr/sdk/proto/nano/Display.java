package com.google.p000vr.sdk.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* renamed from: com.google.vr.sdk.proto.nano.Display */
public class Display {
    private Display() {
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Display$DisplayParams */
    public static final class DisplayParams extends ExtendableMessageNano<DisplayParams> implements Cloneable {
        private static volatile DisplayParams[] _emptyArray;
        private int bitField0_;
        private float bottomBezelHeight_;
        public float[] dEPRECATEDGyroBias;
        private float xPpi_;
        private float yPpi_;

        public static DisplayParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DisplayParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final float getXPpi() {
            return this.xPpi_;
        }

        public final boolean hasXPpi() {
            return (this.bitField0_ & 1) != 0;
        }

        public final DisplayParams clearXPpi() {
            this.xPpi_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final DisplayParams setXPpi(float f) {
            this.bitField0_ |= 1;
            this.xPpi_ = f;
            return this;
        }

        public final float getYPpi() {
            return this.yPpi_;
        }

        public final boolean hasYPpi() {
            return (this.bitField0_ & 2) != 0;
        }

        public final DisplayParams clearYPpi() {
            this.yPpi_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final DisplayParams setYPpi(float f) {
            this.bitField0_ |= 2;
            this.yPpi_ = f;
            return this;
        }

        public final float getBottomBezelHeight() {
            return this.bottomBezelHeight_;
        }

        public final boolean hasBottomBezelHeight() {
            return (this.bitField0_ & 4) != 0;
        }

        public final DisplayParams clearBottomBezelHeight() {
            this.bottomBezelHeight_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final DisplayParams setBottomBezelHeight(float f) {
            this.bitField0_ |= 4;
            this.bottomBezelHeight_ = f;
            return this;
        }

        public DisplayParams() {
            clear();
        }

        public final DisplayParams clear() {
            this.bitField0_ = 0;
            this.xPpi_ = 0.0f;
            this.yPpi_ = 0.0f;
            this.bottomBezelHeight_ = 0.0f;
            this.dEPRECATEDGyroBias = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DisplayParams clone() {
            try {
                DisplayParams displayParams = (DisplayParams) super.clone();
                if (this.dEPRECATEDGyroBias != null && this.dEPRECATEDGyroBias.length > 0) {
                    displayParams.dEPRECATEDGyroBias = (float[]) this.dEPRECATEDGyroBias.clone();
                }
                return displayParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.xPpi_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.yPpi_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.bottomBezelHeight_);
            }
            if (this.dEPRECATEDGyroBias != null && this.dEPRECATEDGyroBias.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(34);
                codedOutputByteBufferNano.writeRawVarint32(this.dEPRECATEDGyroBias.length * 4);
                for (float writeFloatNoTag : this.dEPRECATEDGyroBias) {
                    codedOutputByteBufferNano.writeFloatNoTag(writeFloatNoTag);
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.xPpi_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.yPpi_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.bottomBezelHeight_);
            }
            if (this.dEPRECATEDGyroBias == null || this.dEPRECATEDGyroBias.length <= 0) {
                return computeSerializedSize;
            }
            int length = this.dEPRECATEDGyroBias.length * 4;
            return computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
        }

        public final DisplayParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 13:
                        this.xPpi_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 1;
                        continue;
                    case 21:
                        this.yPpi_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 2;
                        continue;
                    case 29:
                        this.bottomBezelHeight_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 4;
                        continue;
                    case 34:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i = readRawVarint32 / 4;
                        int length = this.dEPRECATEDGyroBias == null ? 0 : this.dEPRECATEDGyroBias.length;
                        float[] fArr = new float[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.dEPRECATEDGyroBias, 0, fArr, 0, length);
                        }
                        while (length < fArr.length) {
                            fArr[length] = codedInputByteBufferNano.readFloat();
                            length++;
                        }
                        this.dEPRECATEDGyroBias = fArr;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 37:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                        int length2 = this.dEPRECATEDGyroBias == null ? 0 : this.dEPRECATEDGyroBias.length;
                        float[] fArr2 = new float[(repeatedFieldArrayLength + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.dEPRECATEDGyroBias, 0, fArr2, 0, length2);
                        }
                        while (length2 < fArr2.length - 1) {
                            fArr2[length2] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        fArr2[length2] = codedInputByteBufferNano.readFloat();
                        this.dEPRECATEDGyroBias = fArr2;
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

        public static DisplayParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (DisplayParams) MessageNano.mergeFrom(new DisplayParams(), bArr);
        }

        public static DisplayParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DisplayParams().mergeFrom(codedInputByteBufferNano);
        }
    }
}
