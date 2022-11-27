package com.google.protobuf.nano;

import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.p000vr.vrcore.common.api.SdkServiceConsts;

public interface DescriptorProtos {

    public final class DescriptorProto extends ExtendableMessageNano {
        private static volatile DescriptorProto[] _emptyArray;
        public EnumDescriptorProto[] enumType = EnumDescriptorProto.emptyArray();
        public FieldDescriptorProto[] extension = FieldDescriptorProto.emptyArray();
        public ExtensionRange[] extensionRange = ExtensionRange.emptyArray();
        public FieldDescriptorProto[] field = FieldDescriptorProto.emptyArray();
        public String name = null;
        public DescriptorProto[] nestedType = emptyArray();
        public OneofDescriptorProto[] oneofDecl = OneofDescriptorProto.emptyArray();
        public MessageOptions options;
        public String[] reservedName = WireFormatNano.EMPTY_STRING_ARRAY;
        public ReservedRange[] reservedRange = ReservedRange.emptyArray();

        public final class ExtensionRange extends ExtendableMessageNano {
            private static volatile ExtensionRange[] _emptyArray;
            public Integer end = null;
            public Integer start = null;

            public ExtensionRange() {
                this.cachedSize = -1;
            }

            public static ExtensionRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ExtensionRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static ExtensionRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new ExtensionRange().mergeFrom(codedInputByteBufferNano);
            }

            public static ExtensionRange parseFrom(byte[] bArr) {
                return (ExtensionRange) MessageNano.mergeFrom(new ExtensionRange(), bArr);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.start != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.start.intValue());
                }
                return this.end != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.end.intValue()) : computeSerializedSize;
            }

            public final ExtensionRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.start = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 16:
                            this.end = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                if (this.start != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.start.intValue());
                }
                if (this.end != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.end.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public final class ReservedRange extends ExtendableMessageNano {
            private static volatile ReservedRange[] _emptyArray;
            public Integer end = null;
            public Integer start = null;

            public ReservedRange() {
                this.cachedSize = -1;
            }

            public static ReservedRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ReservedRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static ReservedRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new ReservedRange().mergeFrom(codedInputByteBufferNano);
            }

            public static ReservedRange parseFrom(byte[] bArr) {
                return (ReservedRange) MessageNano.mergeFrom(new ReservedRange(), bArr);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.start != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.start.intValue());
                }
                return this.end != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.end.intValue()) : computeSerializedSize;
            }

            public final ReservedRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.start = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 16:
                            this.end = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                if (this.start != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.start.intValue());
                }
                if (this.end != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.end.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public DescriptorProto() {
            this.cachedSize = -1;
        }

        public static DescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static DescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static DescriptorProto parseFrom(byte[] bArr) {
            return (DescriptorProto) MessageNano.mergeFrom(new DescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.field != null && this.field.length > 0) {
                int i = computeSerializedSize;
                for (FieldDescriptorProto fieldDescriptorProto : this.field) {
                    if (fieldDescriptorProto != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(2, fieldDescriptorProto);
                    }
                }
                computeSerializedSize = i;
            }
            if (this.nestedType != null && this.nestedType.length > 0) {
                int i2 = computeSerializedSize;
                for (DescriptorProto descriptorProto : this.nestedType) {
                    if (descriptorProto != null) {
                        i2 += CodedOutputByteBufferNano.computeMessageSize(3, descriptorProto);
                    }
                }
                computeSerializedSize = i2;
            }
            if (this.enumType != null && this.enumType.length > 0) {
                int i3 = computeSerializedSize;
                for (EnumDescriptorProto enumDescriptorProto : this.enumType) {
                    if (enumDescriptorProto != null) {
                        i3 += CodedOutputByteBufferNano.computeMessageSize(4, enumDescriptorProto);
                    }
                }
                computeSerializedSize = i3;
            }
            if (this.extensionRange != null && this.extensionRange.length > 0) {
                int i4 = computeSerializedSize;
                for (ExtensionRange extensionRange2 : this.extensionRange) {
                    if (extensionRange2 != null) {
                        i4 += CodedOutputByteBufferNano.computeMessageSize(5, extensionRange2);
                    }
                }
                computeSerializedSize = i4;
            }
            if (this.extension != null && this.extension.length > 0) {
                int i5 = computeSerializedSize;
                for (FieldDescriptorProto fieldDescriptorProto2 : this.extension) {
                    if (fieldDescriptorProto2 != null) {
                        i5 += CodedOutputByteBufferNano.computeMessageSize(6, fieldDescriptorProto2);
                    }
                }
                computeSerializedSize = i5;
            }
            if (this.options != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, this.options);
            }
            if (this.oneofDecl != null && this.oneofDecl.length > 0) {
                int i6 = computeSerializedSize;
                for (OneofDescriptorProto oneofDescriptorProto : this.oneofDecl) {
                    if (oneofDescriptorProto != null) {
                        i6 += CodedOutputByteBufferNano.computeMessageSize(8, oneofDescriptorProto);
                    }
                }
                computeSerializedSize = i6;
            }
            if (this.reservedRange != null && this.reservedRange.length > 0) {
                int i7 = computeSerializedSize;
                for (ReservedRange reservedRange2 : this.reservedRange) {
                    if (reservedRange2 != null) {
                        i7 += CodedOutputByteBufferNano.computeMessageSize(9, reservedRange2);
                    }
                }
                computeSerializedSize = i7;
            }
            if (this.reservedName == null || this.reservedName.length <= 0) {
                return computeSerializedSize;
            }
            int i8 = 0;
            int i9 = 0;
            for (String str : this.reservedName) {
                if (str != null) {
                    i9++;
                    i8 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
            }
            return computeSerializedSize + i8 + (i9 * 1);
        }

        public final DescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        int length = this.field == null ? 0 : this.field.length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr = new FieldDescriptorProto[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.field, 0, fieldDescriptorProtoArr, 0, length);
                        }
                        while (length < fieldDescriptorProtoArr.length - 1) {
                            fieldDescriptorProtoArr[length] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        fieldDescriptorProtoArr[length] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr[length]);
                        this.field = fieldDescriptorProtoArr;
                        continue;
                    case 26:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        int length2 = this.nestedType == null ? 0 : this.nestedType.length;
                        DescriptorProto[] descriptorProtoArr = new DescriptorProto[(repeatedFieldArrayLength2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.nestedType, 0, descriptorProtoArr, 0, length2);
                        }
                        while (length2 < descriptorProtoArr.length - 1) {
                            descriptorProtoArr[length2] = new DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr[length2] = new DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr[length2]);
                        this.nestedType = descriptorProtoArr;
                        continue;
                    case 34:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        int length3 = this.enumType == null ? 0 : this.enumType.length;
                        EnumDescriptorProto[] enumDescriptorProtoArr = new EnumDescriptorProto[(repeatedFieldArrayLength3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.enumType, 0, enumDescriptorProtoArr, 0, length3);
                        }
                        while (length3 < enumDescriptorProtoArr.length - 1) {
                            enumDescriptorProtoArr[length3] = new EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr[length3] = new EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr[length3]);
                        this.enumType = enumDescriptorProtoArr;
                        continue;
                    case 42:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        int length4 = this.extensionRange == null ? 0 : this.extensionRange.length;
                        ExtensionRange[] extensionRangeArr = new ExtensionRange[(repeatedFieldArrayLength4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.extensionRange, 0, extensionRangeArr, 0, length4);
                        }
                        while (length4 < extensionRangeArr.length - 1) {
                            extensionRangeArr[length4] = new ExtensionRange();
                            codedInputByteBufferNano.readMessage(extensionRangeArr[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        extensionRangeArr[length4] = new ExtensionRange();
                        codedInputByteBufferNano.readMessage(extensionRangeArr[length4]);
                        this.extensionRange = extensionRangeArr;
                        continue;
                    case FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE /*50*/:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        int length5 = this.extension == null ? 0 : this.extension.length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr2 = new FieldDescriptorProto[(repeatedFieldArrayLength5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.extension, 0, fieldDescriptorProtoArr2, 0, length5);
                        }
                        while (length5 < fieldDescriptorProtoArr2.length - 1) {
                            fieldDescriptorProtoArr2[length5] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr2[length5] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                        this.extension = fieldDescriptorProtoArr2;
                        continue;
                    case 58:
                        if (this.options == null) {
                            this.options = new MessageOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        continue;
                    case 66:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        int length6 = this.oneofDecl == null ? 0 : this.oneofDecl.length;
                        OneofDescriptorProto[] oneofDescriptorProtoArr = new OneofDescriptorProto[(repeatedFieldArrayLength6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.oneofDecl, 0, oneofDescriptorProtoArr, 0, length6);
                        }
                        while (length6 < oneofDescriptorProtoArr.length - 1) {
                            oneofDescriptorProtoArr[length6] = new OneofDescriptorProto();
                            codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        oneofDescriptorProtoArr[length6] = new OneofDescriptorProto();
                        codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr[length6]);
                        this.oneofDecl = oneofDescriptorProtoArr;
                        continue;
                    case 74:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        int length7 = this.reservedRange == null ? 0 : this.reservedRange.length;
                        ReservedRange[] reservedRangeArr = new ReservedRange[(repeatedFieldArrayLength7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.reservedRange, 0, reservedRangeArr, 0, length7);
                        }
                        while (length7 < reservedRangeArr.length - 1) {
                            reservedRangeArr[length7] = new ReservedRange();
                            codedInputByteBufferNano.readMessage(reservedRangeArr[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        reservedRangeArr[length7] = new ReservedRange();
                        codedInputByteBufferNano.readMessage(reservedRangeArr[length7]);
                        this.reservedRange = reservedRangeArr;
                        continue;
                    case 82:
                        int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        int length8 = this.reservedName == null ? 0 : this.reservedName.length;
                        String[] strArr = new String[(repeatedFieldArrayLength8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.reservedName, 0, strArr, 0, length8);
                        }
                        while (length8 < strArr.length - 1) {
                            strArr[length8] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        strArr[length8] = codedInputByteBufferNano.readString();
                        this.reservedName = strArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.field != null && this.field.length > 0) {
                for (FieldDescriptorProto fieldDescriptorProto : this.field) {
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, fieldDescriptorProto);
                    }
                }
            }
            if (this.nestedType != null && this.nestedType.length > 0) {
                for (DescriptorProto descriptorProto : this.nestedType) {
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(3, descriptorProto);
                    }
                }
            }
            if (this.enumType != null && this.enumType.length > 0) {
                for (EnumDescriptorProto enumDescriptorProto : this.enumType) {
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, enumDescriptorProto);
                    }
                }
            }
            if (this.extensionRange != null && this.extensionRange.length > 0) {
                for (ExtensionRange extensionRange2 : this.extensionRange) {
                    if (extensionRange2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, extensionRange2);
                    }
                }
            }
            if (this.extension != null && this.extension.length > 0) {
                for (FieldDescriptorProto fieldDescriptorProto2 : this.extension) {
                    if (fieldDescriptorProto2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, fieldDescriptorProto2);
                    }
                }
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(7, this.options);
            }
            if (this.oneofDecl != null && this.oneofDecl.length > 0) {
                for (OneofDescriptorProto oneofDescriptorProto : this.oneofDecl) {
                    if (oneofDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(8, oneofDescriptorProto);
                    }
                }
            }
            if (this.reservedRange != null && this.reservedRange.length > 0) {
                for (ReservedRange reservedRange2 : this.reservedRange) {
                    if (reservedRange2 != null) {
                        codedOutputByteBufferNano.writeMessage(9, reservedRange2);
                    }
                }
            }
            if (this.reservedName != null && this.reservedName.length > 0) {
                for (String str : this.reservedName) {
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(10, str);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class EnumDescriptorProto extends ExtendableMessageNano {
        private static volatile EnumDescriptorProto[] _emptyArray;
        public String name = null;
        public EnumOptions options;
        public EnumValueDescriptorProto[] value = EnumValueDescriptorProto.emptyArray();

        public EnumDescriptorProto() {
            this.cachedSize = -1;
        }

        public static EnumDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) {
            return (EnumDescriptorProto) MessageNano.mergeFrom(new EnumDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.value != null && this.value.length > 0) {
                int i = computeSerializedSize;
                for (EnumValueDescriptorProto enumValueDescriptorProto : this.value) {
                    if (enumValueDescriptorProto != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(2, enumValueDescriptorProto);
                    }
                }
                computeSerializedSize = i;
            }
            return this.options != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, this.options) : computeSerializedSize;
        }

        public final EnumDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        int length = this.value == null ? 0 : this.value.length;
                        EnumValueDescriptorProto[] enumValueDescriptorProtoArr = new EnumValueDescriptorProto[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.value, 0, enumValueDescriptorProtoArr, 0, length);
                        }
                        while (length < enumValueDescriptorProtoArr.length - 1) {
                            enumValueDescriptorProtoArr[length] = new EnumValueDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        enumValueDescriptorProtoArr[length] = new EnumValueDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr[length]);
                        this.value = enumValueDescriptorProtoArr;
                        continue;
                    case 26:
                        if (this.options == null) {
                            this.options = new EnumOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.value != null && this.value.length > 0) {
                for (EnumValueDescriptorProto enumValueDescriptorProto : this.value) {
                    if (enumValueDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, enumValueDescriptorProto);
                    }
                }
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(3, this.options);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class EnumOptions extends ExtendableMessageNano {
        private static volatile EnumOptions[] _emptyArray;
        public Boolean allowAlias = null;
        public Boolean ccAllowUnsafeEnumToString = null;
        public Boolean deprecated = null;
        public String proto1Name = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public EnumOptions() {
            this.cachedSize = -1;
        }

        public static EnumOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumOptions parseFrom(byte[] bArr) {
            return (EnumOptions) MessageNano.mergeFrom(new EnumOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.proto1Name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.proto1Name);
            }
            if (this.allowAlias != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.allowAlias.booleanValue());
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.deprecated.booleanValue());
            }
            if (this.ccAllowUnsafeEnumToString != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, this.ccAllowUnsafeEnumToString.booleanValue());
            }
            if (this.uninterpretedOption == null || this.uninterpretedOption.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                if (uninterpretedOption2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                }
            }
            return i;
        }

        public final EnumOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.proto1Name = codedInputByteBufferNano.readString();
                        continue;
                    case 16:
                        this.allowAlias = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 32:
                        this.ccAllowUnsafeEnumToString = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.proto1Name != null) {
                codedOutputByteBufferNano.writeString(1, this.proto1Name);
            }
            if (this.allowAlias != null) {
                codedOutputByteBufferNano.writeBool(2, this.allowAlias.booleanValue());
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(3, this.deprecated.booleanValue());
            }
            if (this.ccAllowUnsafeEnumToString != null) {
                codedOutputByteBufferNano.writeBool(4, this.ccAllowUnsafeEnumToString.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class EnumValueDescriptorProto extends ExtendableMessageNano {
        private static volatile EnumValueDescriptorProto[] _emptyArray;
        public String name = null;
        public Integer number = null;
        public EnumValueOptions options;

        public EnumValueDescriptorProto() {
            this.cachedSize = -1;
        }

        public static EnumValueDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumValueDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumValueDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) {
            return (EnumValueDescriptorProto) MessageNano.mergeFrom(new EnumValueDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.number != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.number.intValue());
            }
            return this.options != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, this.options) : computeSerializedSize;
        }

        public final EnumValueDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 16:
                        this.number = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 26:
                        if (this.options == null) {
                            this.options = new EnumValueOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.number != null) {
                codedOutputByteBufferNano.writeInt32(2, this.number.intValue());
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(3, this.options);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class EnumValueOptions extends ExtendableMessageNano {
        private static volatile EnumValueOptions[] _emptyArray;
        public Boolean deprecated = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public EnumValueOptions() {
            this.cachedSize = -1;
        }

        public static EnumValueOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumValueOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumValueOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumValueOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumValueOptions parseFrom(byte[] bArr) {
            return (EnumValueOptions) MessageNano.mergeFrom(new EnumValueOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption == null || this.uninterpretedOption.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                if (uninterpretedOption2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                }
            }
            return i;
        }

        public final EnumValueOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(1, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class FieldDescriptorProto extends ExtendableMessageNano {
        private static volatile FieldDescriptorProto[] _emptyArray;
        public String defaultValue = null;
        public String extendee = null;
        public String jsonName = null;
        public int label = MessageNano.UNSET_ENUM_VALUE;
        public String name = null;
        public Integer number = null;
        public Integer oneofIndex = null;
        public FieldOptions options;
        public int type = MessageNano.UNSET_ENUM_VALUE;
        public String typeName = null;

        public interface Label {
            public static final int LABEL_OPTIONAL = 1;
            public static final int LABEL_REPEATED = 3;
            public static final int LABEL_REQUIRED = 2;
        }

        public interface Type {
            public static final int TYPE_BOOL = 8;
            public static final int TYPE_BYTES = 12;
            public static final int TYPE_DOUBLE = 1;
            public static final int TYPE_ENUM = 14;
            public static final int TYPE_FIXED32 = 7;
            public static final int TYPE_FIXED64 = 6;
            public static final int TYPE_FLOAT = 2;
            public static final int TYPE_GROUP = 10;
            public static final int TYPE_INT32 = 5;
            public static final int TYPE_INT64 = 3;
            public static final int TYPE_MESSAGE = 11;
            public static final int TYPE_SFIXED32 = 15;
            public static final int TYPE_SFIXED64 = 16;
            public static final int TYPE_SINT32 = 17;
            public static final int TYPE_SINT64 = 18;
            public static final int TYPE_STRING = 9;
            public static final int TYPE_UINT32 = 13;
            public static final int TYPE_UINT64 = 4;
        }

        public FieldDescriptorProto() {
            this.cachedSize = -1;
        }

        public static FieldDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FieldDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FieldDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FieldDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) {
            return (FieldDescriptorProto) MessageNano.mergeFrom(new FieldDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.extendee != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.extendee);
            }
            if (this.number != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.number.intValue());
            }
            if (this.label != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.label);
            }
            if (this.type != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.type);
            }
            if (this.typeName != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.typeName);
            }
            if (this.defaultValue != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.defaultValue);
            }
            if (this.options != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, this.options);
            }
            if (this.oneofIndex != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, this.oneofIndex.intValue());
            }
            return this.jsonName != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.jsonName) : computeSerializedSize;
        }

        public final FieldDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        this.extendee = codedInputByteBufferNano.readString();
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.number = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 32:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 1:
                            case 2:
                            case 3:
                                this.label = readInt32;
                                break;
                            default:
                                continue;
                        }
                    case 40:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        switch (readInt322) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                                this.type = readInt322;
                                break;
                            default:
                                continue;
                        }
                    case FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE /*50*/:
                        this.typeName = codedInputByteBufferNano.readString();
                        continue;
                    case 58:
                        this.defaultValue = codedInputByteBufferNano.readString();
                        continue;
                    case 66:
                        if (this.options == null) {
                            this.options = new FieldOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        continue;
                    case 72:
                        this.oneofIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 82:
                        this.jsonName = codedInputByteBufferNano.readString();
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.extendee != null) {
                codedOutputByteBufferNano.writeString(2, this.extendee);
            }
            if (this.number != null) {
                codedOutputByteBufferNano.writeInt32(3, this.number.intValue());
            }
            if (this.label != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(4, this.label);
            }
            if (this.type != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(5, this.type);
            }
            if (this.typeName != null) {
                codedOutputByteBufferNano.writeString(6, this.typeName);
            }
            if (this.defaultValue != null) {
                codedOutputByteBufferNano.writeString(7, this.defaultValue);
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(8, this.options);
            }
            if (this.oneofIndex != null) {
                codedOutputByteBufferNano.writeInt32(9, this.oneofIndex.intValue());
            }
            if (this.jsonName != null) {
                codedOutputByteBufferNano.writeString(10, this.jsonName);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class FieldOptions extends ExtendableMessageNano {
        private static volatile FieldOptions[] _emptyArray;
        public int ctype = MessageNano.UNSET_ENUM_VALUE;
        public Boolean deprecated = null;
        public Boolean deprecatedRawMessage = null;
        public Boolean enforceUtf8 = null;
        public int jstype = MessageNano.UNSET_ENUM_VALUE;
        public int jtype = MessageNano.UNSET_ENUM_VALUE;
        public Boolean lazy = null;
        public Boolean packed = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();
        public UpgradedOption[] upgradedOption = UpgradedOption.emptyArray();
        public Boolean weak = null;

        public interface CType {
            public static final int CORD = 1;
            public static final int STRING = 0;
            public static final int STRING_PIECE = 2;
        }

        public interface JSType {
            public static final int JS_NORMAL = 0;
            public static final int JS_NUMBER = 2;
            public static final int JS_STRING = 1;
        }

        public interface JType {
            public static final int BYTES = 1;
            public static final int EXPERIMENTAL_BYTE_BUFFER = 2;
            public static final int NORMAL = 0;
        }

        public final class UpgradedOption extends ExtendableMessageNano {
            private static volatile UpgradedOption[] _emptyArray;
            public String name = null;
            public String value = null;

            public UpgradedOption() {
                this.cachedSize = -1;
            }

            public static UpgradedOption[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new UpgradedOption[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static UpgradedOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new UpgradedOption().mergeFrom(codedInputByteBufferNano);
            }

            public static UpgradedOption parseFrom(byte[] bArr) {
                return (UpgradedOption) MessageNano.mergeFrom(new UpgradedOption(), bArr);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.name != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
                }
                return this.value != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.value) : computeSerializedSize;
            }

            public final UpgradedOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.name = codedInputByteBufferNano.readString();
                            continue;
                        case 18:
                            this.value = codedInputByteBufferNano.readString();
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

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                if (this.name != null) {
                    codedOutputByteBufferNano.writeString(1, this.name);
                }
                if (this.value != null) {
                    codedOutputByteBufferNano.writeString(2, this.value);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public FieldOptions() {
            this.cachedSize = -1;
        }

        public static FieldOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FieldOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FieldOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FieldOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static FieldOptions parseFrom(byte[] bArr) {
            return (FieldOptions) MessageNano.mergeFrom(new FieldOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.ctype != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.ctype);
            }
            if (this.packed != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.packed.booleanValue());
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.deprecated.booleanValue());
            }
            if (this.jtype != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.jtype);
            }
            if (this.lazy != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, this.lazy.booleanValue());
            }
            if (this.jstype != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.jstype);
            }
            if (this.weak != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.weak.booleanValue());
            }
            if (this.upgradedOption != null && this.upgradedOption.length > 0) {
                int i = computeSerializedSize;
                for (UpgradedOption upgradedOption2 : this.upgradedOption) {
                    if (upgradedOption2 != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(11, upgradedOption2);
                    }
                }
                computeSerializedSize = i;
            }
            if (this.deprecatedRawMessage != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, this.deprecatedRawMessage.booleanValue());
            }
            if (this.enforceUtf8 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, this.enforceUtf8.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final FieldOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                                this.ctype = readInt32;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.packed = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 32:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        switch (readInt322) {
                            case 0:
                            case 1:
                            case 2:
                                this.jtype = readInt322;
                                break;
                            default:
                                continue;
                        }
                    case 40:
                        this.lazy = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 48:
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        switch (readInt323) {
                            case 0:
                            case 1:
                            case 2:
                                this.jstype = readInt323;
                                break;
                            default:
                                continue;
                        }
                    case 80:
                        this.weak = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 90:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        int length = this.upgradedOption == null ? 0 : this.upgradedOption.length;
                        UpgradedOption[] upgradedOptionArr = new UpgradedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.upgradedOption, 0, upgradedOptionArr, 0, length);
                        }
                        while (length < upgradedOptionArr.length - 1) {
                            upgradedOptionArr[length] = new UpgradedOption();
                            codedInputByteBufferNano.readMessage(upgradedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        upgradedOptionArr[length] = new UpgradedOption();
                        codedInputByteBufferNano.readMessage(upgradedOptionArr[length]);
                        this.upgradedOption = upgradedOptionArr;
                        continue;
                    case 96:
                        this.deprecatedRawMessage = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 104:
                        this.enforceUtf8 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length2 = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length2);
                        }
                        while (length2 < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length2] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        uninterpretedOptionArr[length2] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length2]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.ctype != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(1, this.ctype);
            }
            if (this.packed != null) {
                codedOutputByteBufferNano.writeBool(2, this.packed.booleanValue());
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(3, this.deprecated.booleanValue());
            }
            if (this.jtype != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(4, this.jtype);
            }
            if (this.lazy != null) {
                codedOutputByteBufferNano.writeBool(5, this.lazy.booleanValue());
            }
            if (this.jstype != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(6, this.jstype);
            }
            if (this.weak != null) {
                codedOutputByteBufferNano.writeBool(10, this.weak.booleanValue());
            }
            if (this.upgradedOption != null && this.upgradedOption.length > 0) {
                for (UpgradedOption upgradedOption2 : this.upgradedOption) {
                    if (upgradedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(11, upgradedOption2);
                    }
                }
            }
            if (this.deprecatedRawMessage != null) {
                codedOutputByteBufferNano.writeBool(12, this.deprecatedRawMessage.booleanValue());
            }
            if (this.enforceUtf8 != null) {
                codedOutputByteBufferNano.writeBool(13, this.enforceUtf8.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class FileDescriptorProto extends ExtendableMessageNano {
        private static volatile FileDescriptorProto[] _emptyArray;
        public String[] dependency = WireFormatNano.EMPTY_STRING_ARRAY;
        public EnumDescriptorProto[] enumType = EnumDescriptorProto.emptyArray();
        public FieldDescriptorProto[] extension = FieldDescriptorProto.emptyArray();
        public DescriptorProto[] messageType = DescriptorProto.emptyArray();
        public String name = null;
        public FileOptions options;
        public String package_ = null;
        public int[] publicDependency = WireFormatNano.EMPTY_INT_ARRAY;
        public ServiceDescriptorProto[] service = ServiceDescriptorProto.emptyArray();
        public SourceCodeInfo sourceCodeInfo;
        public String syntax = null;
        public int[] weakDependency = WireFormatNano.EMPTY_INT_ARRAY;

        public FileDescriptorProto() {
            this.cachedSize = -1;
        }

        public static FileDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FileDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FileDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) {
            return (FileDescriptorProto) MessageNano.mergeFrom(new FileDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.package_ != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.package_);
            }
            if (this.dependency != null && this.dependency.length > 0) {
                int i = 0;
                int i2 = 0;
                for (String str : this.dependency) {
                    if (str != null) {
                        i2++;
                        i += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                }
                computeSerializedSize = computeSerializedSize + i + (i2 * 1);
            }
            if (this.messageType != null && this.messageType.length > 0) {
                int i3 = computeSerializedSize;
                for (DescriptorProto descriptorProto : this.messageType) {
                    if (descriptorProto != null) {
                        i3 += CodedOutputByteBufferNano.computeMessageSize(4, descriptorProto);
                    }
                }
                computeSerializedSize = i3;
            }
            if (this.enumType != null && this.enumType.length > 0) {
                int i4 = computeSerializedSize;
                for (EnumDescriptorProto enumDescriptorProto : this.enumType) {
                    if (enumDescriptorProto != null) {
                        i4 += CodedOutputByteBufferNano.computeMessageSize(5, enumDescriptorProto);
                    }
                }
                computeSerializedSize = i4;
            }
            if (this.service != null && this.service.length > 0) {
                int i5 = computeSerializedSize;
                for (ServiceDescriptorProto serviceDescriptorProto : this.service) {
                    if (serviceDescriptorProto != null) {
                        i5 += CodedOutputByteBufferNano.computeMessageSize(6, serviceDescriptorProto);
                    }
                }
                computeSerializedSize = i5;
            }
            if (this.extension != null && this.extension.length > 0) {
                int i6 = computeSerializedSize;
                for (FieldDescriptorProto fieldDescriptorProto : this.extension) {
                    if (fieldDescriptorProto != null) {
                        i6 += CodedOutputByteBufferNano.computeMessageSize(7, fieldDescriptorProto);
                    }
                }
                computeSerializedSize = i6;
            }
            if (this.options != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, this.options);
            }
            if (this.sourceCodeInfo != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, this.sourceCodeInfo);
            }
            if (this.publicDependency != null && this.publicDependency.length > 0) {
                int i7 = 0;
                for (int computeInt32SizeNoTag : this.publicDependency) {
                    i7 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                }
                computeSerializedSize = computeSerializedSize + i7 + (this.publicDependency.length * 1);
            }
            if (this.weakDependency != null && this.weakDependency.length > 0) {
                int i8 = 0;
                for (int computeInt32SizeNoTag2 : this.weakDependency) {
                    i8 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag2);
                }
                computeSerializedSize = computeSerializedSize + i8 + (this.weakDependency.length * 1);
            }
            return this.syntax != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.syntax) : computeSerializedSize;
        }

        public final FileDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        this.package_ = codedInputByteBufferNano.readString();
                        continue;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        int length = this.dependency == null ? 0 : this.dependency.length;
                        String[] strArr = new String[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.dependency, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr[length] = codedInputByteBufferNano.readString();
                        this.dependency = strArr;
                        continue;
                    case 34:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        int length2 = this.messageType == null ? 0 : this.messageType.length;
                        DescriptorProto[] descriptorProtoArr = new DescriptorProto[(repeatedFieldArrayLength2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.messageType, 0, descriptorProtoArr, 0, length2);
                        }
                        while (length2 < descriptorProtoArr.length - 1) {
                            descriptorProtoArr[length2] = new DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr[length2] = new DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr[length2]);
                        this.messageType = descriptorProtoArr;
                        continue;
                    case 42:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        int length3 = this.enumType == null ? 0 : this.enumType.length;
                        EnumDescriptorProto[] enumDescriptorProtoArr = new EnumDescriptorProto[(repeatedFieldArrayLength3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.enumType, 0, enumDescriptorProtoArr, 0, length3);
                        }
                        while (length3 < enumDescriptorProtoArr.length - 1) {
                            enumDescriptorProtoArr[length3] = new EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr[length3] = new EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr[length3]);
                        this.enumType = enumDescriptorProtoArr;
                        continue;
                    case FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE /*50*/:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        int length4 = this.service == null ? 0 : this.service.length;
                        ServiceDescriptorProto[] serviceDescriptorProtoArr = new ServiceDescriptorProto[(repeatedFieldArrayLength4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.service, 0, serviceDescriptorProtoArr, 0, length4);
                        }
                        while (length4 < serviceDescriptorProtoArr.length - 1) {
                            serviceDescriptorProtoArr[length4] = new ServiceDescriptorProto();
                            codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        serviceDescriptorProtoArr[length4] = new ServiceDescriptorProto();
                        codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr[length4]);
                        this.service = serviceDescriptorProtoArr;
                        continue;
                    case 58:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        int length5 = this.extension == null ? 0 : this.extension.length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr = new FieldDescriptorProto[(repeatedFieldArrayLength5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.extension, 0, fieldDescriptorProtoArr, 0, length5);
                        }
                        while (length5 < fieldDescriptorProtoArr.length - 1) {
                            fieldDescriptorProtoArr[length5] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr[length5] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr[length5]);
                        this.extension = fieldDescriptorProtoArr;
                        continue;
                    case 66:
                        if (this.options == null) {
                            this.options = new FileOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        continue;
                    case 74:
                        if (this.sourceCodeInfo == null) {
                            this.sourceCodeInfo = new SourceCodeInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.sourceCodeInfo);
                        continue;
                    case 80:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                        int length6 = this.publicDependency == null ? 0 : this.publicDependency.length;
                        int[] iArr = new int[(repeatedFieldArrayLength6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.publicDependency, 0, iArr, 0, length6);
                        }
                        while (length6 < iArr.length - 1) {
                            iArr[length6] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        iArr[length6] = codedInputByteBufferNano.readInt32();
                        this.publicDependency = iArr;
                        continue;
                    case 82:
                        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int length7 = this.publicDependency == null ? 0 : this.publicDependency.length;
                        int[] iArr2 = new int[(i + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.publicDependency, 0, iArr2, 0, length7);
                        }
                        while (length7 < iArr2.length) {
                            iArr2[length7] = codedInputByteBufferNano.readInt32();
                            length7++;
                        }
                        this.publicDependency = iArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 88:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 88);
                        int length8 = this.weakDependency == null ? 0 : this.weakDependency.length;
                        int[] iArr3 = new int[(repeatedFieldArrayLength7 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.weakDependency, 0, iArr3, 0, length8);
                        }
                        while (length8 < iArr3.length - 1) {
                            iArr3[length8] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        iArr3[length8] = codedInputByteBufferNano.readInt32();
                        this.weakDependency = iArr3;
                        continue;
                    case 90:
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position2 = codedInputByteBufferNano.getPosition();
                        int i2 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i2++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position2);
                        int length9 = this.weakDependency == null ? 0 : this.weakDependency.length;
                        int[] iArr4 = new int[(i2 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.weakDependency, 0, iArr4, 0, length9);
                        }
                        while (length9 < iArr4.length) {
                            iArr4[length9] = codedInputByteBufferNano.readInt32();
                            length9++;
                        }
                        this.weakDependency = iArr4;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        continue;
                    case 98:
                        this.syntax = codedInputByteBufferNano.readString();
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.package_ != null) {
                codedOutputByteBufferNano.writeString(2, this.package_);
            }
            if (this.dependency != null && this.dependency.length > 0) {
                for (String str : this.dependency) {
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(3, str);
                    }
                }
            }
            if (this.messageType != null && this.messageType.length > 0) {
                for (DescriptorProto descriptorProto : this.messageType) {
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, descriptorProto);
                    }
                }
            }
            if (this.enumType != null && this.enumType.length > 0) {
                for (EnumDescriptorProto enumDescriptorProto : this.enumType) {
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(5, enumDescriptorProto);
                    }
                }
            }
            if (this.service != null && this.service.length > 0) {
                for (ServiceDescriptorProto serviceDescriptorProto : this.service) {
                    if (serviceDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(6, serviceDescriptorProto);
                    }
                }
            }
            if (this.extension != null && this.extension.length > 0) {
                for (FieldDescriptorProto fieldDescriptorProto : this.extension) {
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(7, fieldDescriptorProto);
                    }
                }
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(8, this.options);
            }
            if (this.sourceCodeInfo != null) {
                codedOutputByteBufferNano.writeMessage(9, this.sourceCodeInfo);
            }
            if (this.publicDependency != null && this.publicDependency.length > 0) {
                for (int writeInt32 : this.publicDependency) {
                    codedOutputByteBufferNano.writeInt32(10, writeInt32);
                }
            }
            if (this.weakDependency != null && this.weakDependency.length > 0) {
                for (int writeInt322 : this.weakDependency) {
                    codedOutputByteBufferNano.writeInt32(11, writeInt322);
                }
            }
            if (this.syntax != null) {
                codedOutputByteBufferNano.writeString(12, this.syntax);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class FileDescriptorSet extends ExtendableMessageNano {
        private static volatile FileDescriptorSet[] _emptyArray;
        public FileDescriptorProto[] file = FileDescriptorProto.emptyArray();

        public FileDescriptorSet() {
            this.cachedSize = -1;
        }

        public static FileDescriptorSet[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileDescriptorSet[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FileDescriptorSet parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FileDescriptorSet().mergeFrom(codedInputByteBufferNano);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) {
            return (FileDescriptorSet) MessageNano.mergeFrom(new FileDescriptorSet(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.file != null && this.file.length > 0) {
                for (FileDescriptorProto fileDescriptorProto : this.file) {
                    if (fileDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fileDescriptorProto);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final FileDescriptorSet mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        int length = this.file == null ? 0 : this.file.length;
                        FileDescriptorProto[] fileDescriptorProtoArr = new FileDescriptorProto[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.file, 0, fileDescriptorProtoArr, 0, length);
                        }
                        while (length < fileDescriptorProtoArr.length - 1) {
                            fileDescriptorProtoArr[length] = new FileDescriptorProto();
                            codedInputByteBufferNano.readMessage(fileDescriptorProtoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        fileDescriptorProtoArr[length] = new FileDescriptorProto();
                        codedInputByteBufferNano.readMessage(fileDescriptorProtoArr[length]);
                        this.file = fileDescriptorProtoArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.file != null && this.file.length > 0) {
                for (FileDescriptorProto fileDescriptorProto : this.file) {
                    if (fileDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(1, fileDescriptorProto);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class FileOptions extends ExtendableMessageNano {
        private static volatile FileOptions[] _emptyArray;
        public int ccApiCompatibility = MessageNano.UNSET_ENUM_VALUE;
        public Integer ccApiVersion = null;
        public Boolean ccDeprecatedMapsImplementation = null;
        public Boolean ccEnableArenas = null;
        public Boolean ccGenericServices = null;
        public Boolean ccProto1TextFormat = null;
        public Boolean ccProtoArrayCompatible = null;
        public Boolean ccUtf8Verification = null;
        public String csharpNamespace = null;
        public Boolean deprecated = null;
        public String goPackage = null;
        public String javaAltApiPackage = null;
        public Integer javaApiVersion = null;
        public Boolean javaEnableDualGenerateMutableApi = null;
        public Boolean javaEnableMapsForProto2 = null;
        public Boolean javaGenerateEqualsAndHash = null;
        public Boolean javaGenerateRpcBaseimpl = null;
        public Boolean javaGenericServices = null;
        public Boolean javaJava5Enums = null;
        public Boolean javaMultipleFiles = null;
        public String javaMultipleFilesMutablePackage = null;
        public Boolean javaMutableApi = null;
        public String javaOuterClassname = null;
        public String javaPackage = null;
        public Boolean javaStringCheckUtf8 = null;
        public Boolean javaUseJavaproto2 = null;
        public Boolean javaUseJavastrings = null;
        public String javascriptPackage = null;
        public String objcClassPrefix = null;
        public int optimizeFor = MessageNano.UNSET_ENUM_VALUE;
        public Integer pyApiVersion = null;
        public Boolean pyGenericServices = null;
        public Integer szlApiVersion = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public interface CompatibilityLevel {
            public static final int DEPRECATED_PROTO1_COMPATIBLE = 50;
            public static final int NO_COMPATIBILITY = 0;
            public static final int PROTO1_COMPATIBLE = 100;
        }

        public interface OptimizeMode {
            public static final int CODE_SIZE = 2;
            public static final int LITE_RUNTIME = 3;
            public static final int SPEED = 1;
        }

        public FileOptions() {
            this.cachedSize = -1;
        }

        public static FileOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FileOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FileOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static FileOptions parseFrom(byte[] bArr) {
            return (FileOptions) MessageNano.mergeFrom(new FileOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.javaPackage != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.javaPackage);
            }
            if (this.ccApiVersion != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.ccApiVersion.intValue());
            }
            if (this.pyApiVersion != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.pyApiVersion.intValue());
            }
            if (this.javaApiVersion != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.javaApiVersion.intValue());
            }
            if (this.javaUseJavaproto2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, this.javaUseJavaproto2.booleanValue());
            }
            if (this.javaJava5Enums != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.javaJava5Enums.booleanValue());
            }
            if (this.javaOuterClassname != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.javaOuterClassname);
            }
            if (this.optimizeFor != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, this.optimizeFor);
            }
            if (this.javaMultipleFiles != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.javaMultipleFiles.booleanValue());
            }
            if (this.goPackage != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.goPackage);
            }
            if (this.javascriptPackage != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.javascriptPackage);
            }
            if (this.javaGenerateRpcBaseimpl != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, this.javaGenerateRpcBaseimpl.booleanValue());
            }
            if (this.szlApiVersion != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, this.szlApiVersion.intValue());
            }
            if (this.ccApiCompatibility != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, this.ccApiCompatibility);
            }
            if (this.ccGenericServices != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, this.ccGenericServices.booleanValue());
            }
            if (this.javaGenericServices != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, this.javaGenericServices.booleanValue());
            }
            if (this.pyGenericServices != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, this.pyGenericServices.booleanValue());
            }
            if (this.javaAltApiPackage != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.javaAltApiPackage);
            }
            if (this.javaGenerateEqualsAndHash != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, this.javaGenerateEqualsAndHash.booleanValue());
            }
            if (this.javaUseJavastrings != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, this.javaUseJavastrings.booleanValue());
            }
            if (this.ccProtoArrayCompatible != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, this.ccProtoArrayCompatible.booleanValue());
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, this.deprecated.booleanValue());
            }
            if (this.ccUtf8Verification != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(24, this.ccUtf8Verification.booleanValue());
            }
            if (this.ccProto1TextFormat != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, this.ccProto1TextFormat.booleanValue());
            }
            if (this.javaEnableDualGenerateMutableApi != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, this.javaEnableDualGenerateMutableApi.booleanValue());
            }
            if (this.javaStringCheckUtf8 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(27, this.javaStringCheckUtf8.booleanValue());
            }
            if (this.javaMutableApi != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(28, this.javaMutableApi.booleanValue());
            }
            if (this.javaMultipleFilesMutablePackage != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.javaMultipleFilesMutablePackage);
            }
            if (this.ccEnableArenas != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(31, this.ccEnableArenas.booleanValue());
            }
            if (this.javaEnableMapsForProto2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(34, this.javaEnableMapsForProto2.booleanValue());
            }
            if (this.ccDeprecatedMapsImplementation != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(35, this.ccDeprecatedMapsImplementation.booleanValue());
            }
            if (this.objcClassPrefix != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(36, this.objcClassPrefix);
            }
            if (this.csharpNamespace != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(37, this.csharpNamespace);
            }
            if (this.uninterpretedOption == null || this.uninterpretedOption.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                if (uninterpretedOption2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                }
            }
            return i;
        }

        public final FileOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.javaPackage = codedInputByteBufferNano.readString();
                        continue;
                    case 16:
                        this.ccApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 32:
                        this.pyApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 40:
                        this.javaApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 48:
                        this.javaUseJavaproto2 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 56:
                        this.javaJava5Enums = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 66:
                        this.javaOuterClassname = codedInputByteBufferNano.readString();
                        continue;
                    case 72:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 1:
                            case 2:
                            case 3:
                                this.optimizeFor = readInt32;
                                break;
                            default:
                                continue;
                        }
                    case 80:
                        this.javaMultipleFiles = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 90:
                        this.goPackage = codedInputByteBufferNano.readString();
                        continue;
                    case 98:
                        this.javascriptPackage = codedInputByteBufferNano.readString();
                        continue;
                    case 104:
                        this.javaGenerateRpcBaseimpl = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 112:
                        this.szlApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 120:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        switch (readInt322) {
                            case 0:
                            case CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE /*50*/:
                            case CompatibilityLevel.PROTO1_COMPATIBLE /*100*/:
                                this.ccApiCompatibility = readInt322;
                                break;
                            default:
                                continue;
                        }
                    case 128:
                        this.ccGenericServices = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 136:
                        this.javaGenericServices = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 144:
                        this.pyGenericServices = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 154:
                        this.javaAltApiPackage = codedInputByteBufferNano.readString();
                        continue;
                    case 160:
                        this.javaGenerateEqualsAndHash = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 168:
                        this.javaUseJavastrings = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 176:
                        this.ccProtoArrayCompatible = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 184:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 192:
                        this.ccUtf8Verification = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case SdkServiceConsts.AUTO_FADE_QUICK_START_DELAY_MILLIS /*200*/:
                        this.ccProto1TextFormat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 208:
                        this.javaEnableDualGenerateMutableApi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 216:
                        this.javaStringCheckUtf8 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 224:
                        this.javaMutableApi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 234:
                        this.javaMultipleFilesMutablePackage = codedInputByteBufferNano.readString();
                        continue;
                    case 248:
                        this.ccEnableArenas = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 272:
                        this.javaEnableMapsForProto2 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 280:
                        this.ccDeprecatedMapsImplementation = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 290:
                        this.objcClassPrefix = codedInputByteBufferNano.readString();
                        continue;
                    case 298:
                        this.csharpNamespace = codedInputByteBufferNano.readString();
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.javaPackage != null) {
                codedOutputByteBufferNano.writeString(1, this.javaPackage);
            }
            if (this.ccApiVersion != null) {
                codedOutputByteBufferNano.writeInt32(2, this.ccApiVersion.intValue());
            }
            if (this.pyApiVersion != null) {
                codedOutputByteBufferNano.writeInt32(4, this.pyApiVersion.intValue());
            }
            if (this.javaApiVersion != null) {
                codedOutputByteBufferNano.writeInt32(5, this.javaApiVersion.intValue());
            }
            if (this.javaUseJavaproto2 != null) {
                codedOutputByteBufferNano.writeBool(6, this.javaUseJavaproto2.booleanValue());
            }
            if (this.javaJava5Enums != null) {
                codedOutputByteBufferNano.writeBool(7, this.javaJava5Enums.booleanValue());
            }
            if (this.javaOuterClassname != null) {
                codedOutputByteBufferNano.writeString(8, this.javaOuterClassname);
            }
            if (this.optimizeFor != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(9, this.optimizeFor);
            }
            if (this.javaMultipleFiles != null) {
                codedOutputByteBufferNano.writeBool(10, this.javaMultipleFiles.booleanValue());
            }
            if (this.goPackage != null) {
                codedOutputByteBufferNano.writeString(11, this.goPackage);
            }
            if (this.javascriptPackage != null) {
                codedOutputByteBufferNano.writeString(12, this.javascriptPackage);
            }
            if (this.javaGenerateRpcBaseimpl != null) {
                codedOutputByteBufferNano.writeBool(13, this.javaGenerateRpcBaseimpl.booleanValue());
            }
            if (this.szlApiVersion != null) {
                codedOutputByteBufferNano.writeInt32(14, this.szlApiVersion.intValue());
            }
            if (this.ccApiCompatibility != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(15, this.ccApiCompatibility);
            }
            if (this.ccGenericServices != null) {
                codedOutputByteBufferNano.writeBool(16, this.ccGenericServices.booleanValue());
            }
            if (this.javaGenericServices != null) {
                codedOutputByteBufferNano.writeBool(17, this.javaGenericServices.booleanValue());
            }
            if (this.pyGenericServices != null) {
                codedOutputByteBufferNano.writeBool(18, this.pyGenericServices.booleanValue());
            }
            if (this.javaAltApiPackage != null) {
                codedOutputByteBufferNano.writeString(19, this.javaAltApiPackage);
            }
            if (this.javaGenerateEqualsAndHash != null) {
                codedOutputByteBufferNano.writeBool(20, this.javaGenerateEqualsAndHash.booleanValue());
            }
            if (this.javaUseJavastrings != null) {
                codedOutputByteBufferNano.writeBool(21, this.javaUseJavastrings.booleanValue());
            }
            if (this.ccProtoArrayCompatible != null) {
                codedOutputByteBufferNano.writeBool(22, this.ccProtoArrayCompatible.booleanValue());
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(23, this.deprecated.booleanValue());
            }
            if (this.ccUtf8Verification != null) {
                codedOutputByteBufferNano.writeBool(24, this.ccUtf8Verification.booleanValue());
            }
            if (this.ccProto1TextFormat != null) {
                codedOutputByteBufferNano.writeBool(25, this.ccProto1TextFormat.booleanValue());
            }
            if (this.javaEnableDualGenerateMutableApi != null) {
                codedOutputByteBufferNano.writeBool(26, this.javaEnableDualGenerateMutableApi.booleanValue());
            }
            if (this.javaStringCheckUtf8 != null) {
                codedOutputByteBufferNano.writeBool(27, this.javaStringCheckUtf8.booleanValue());
            }
            if (this.javaMutableApi != null) {
                codedOutputByteBufferNano.writeBool(28, this.javaMutableApi.booleanValue());
            }
            if (this.javaMultipleFilesMutablePackage != null) {
                codedOutputByteBufferNano.writeString(29, this.javaMultipleFilesMutablePackage);
            }
            if (this.ccEnableArenas != null) {
                codedOutputByteBufferNano.writeBool(31, this.ccEnableArenas.booleanValue());
            }
            if (this.javaEnableMapsForProto2 != null) {
                codedOutputByteBufferNano.writeBool(34, this.javaEnableMapsForProto2.booleanValue());
            }
            if (this.ccDeprecatedMapsImplementation != null) {
                codedOutputByteBufferNano.writeBool(35, this.ccDeprecatedMapsImplementation.booleanValue());
            }
            if (this.objcClassPrefix != null) {
                codedOutputByteBufferNano.writeString(36, this.objcClassPrefix);
            }
            if (this.csharpNamespace != null) {
                codedOutputByteBufferNano.writeString(37, this.csharpNamespace);
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class GeneratedCodeInfo extends ExtendableMessageNano {
        private static volatile GeneratedCodeInfo[] _emptyArray;
        public Annotation[] annotation = Annotation.emptyArray();

        public final class Annotation extends ExtendableMessageNano {
            private static volatile Annotation[] _emptyArray;
            public Integer begin = null;
            public Integer end = null;
            public int[] path = WireFormatNano.EMPTY_INT_ARRAY;
            public String sourceFile = null;

            public Annotation() {
                this.cachedSize = -1;
            }

            public static Annotation[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Annotation[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static Annotation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Annotation().mergeFrom(codedInputByteBufferNano);
            }

            public static Annotation parseFrom(byte[] bArr) {
                return (Annotation) MessageNano.mergeFrom(new Annotation(), bArr);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int i;
                int computeSerializedSize = super.computeSerializedSize();
                if (this.path == null || this.path.length <= 0) {
                    i = computeSerializedSize;
                } else {
                    int i2 = 0;
                    for (int computeInt32SizeNoTag : this.path) {
                        i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                    }
                    i = computeSerializedSize + i2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i2);
                }
                if (this.sourceFile != null) {
                    i += CodedOutputByteBufferNano.computeStringSize(2, this.sourceFile);
                }
                if (this.begin != null) {
                    i += CodedOutputByteBufferNano.computeInt32Size(3, this.begin.intValue());
                }
                return this.end != null ? i + CodedOutputByteBufferNano.computeInt32Size(4, this.end.intValue()) : i;
            }

            public final Annotation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                            int length = this.path == null ? 0 : this.path.length;
                            int[] iArr = new int[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.path, 0, iArr, 0, length);
                            }
                            while (length < iArr.length - 1) {
                                iArr[length] = codedInputByteBufferNano.readInt32();
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            iArr[length] = codedInputByteBufferNano.readInt32();
                            this.path = iArr;
                            continue;
                        case 10:
                            int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position = codedInputByteBufferNano.getPosition();
                            int i = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                codedInputByteBufferNano.readInt32();
                                i++;
                            }
                            codedInputByteBufferNano.rewindToPosition(position);
                            int length2 = this.path == null ? 0 : this.path.length;
                            int[] iArr2 = new int[(i + length2)];
                            if (length2 != 0) {
                                System.arraycopy(this.path, 0, iArr2, 0, length2);
                            }
                            while (length2 < iArr2.length) {
                                iArr2[length2] = codedInputByteBufferNano.readInt32();
                                length2++;
                            }
                            this.path = iArr2;
                            codedInputByteBufferNano.popLimit(pushLimit);
                            continue;
                        case 18:
                            this.sourceFile = codedInputByteBufferNano.readString();
                            continue;
                        case AndroidNCompat.N_SDK_LEVEL:
                            this.begin = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 32:
                            this.end = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                if (this.path != null && this.path.length > 0) {
                    int i = 0;
                    for (int computeInt32SizeNoTag : this.path) {
                        i += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(i);
                    for (int writeInt32NoTag : this.path) {
                        codedOutputByteBufferNano.writeInt32NoTag(writeInt32NoTag);
                    }
                }
                if (this.sourceFile != null) {
                    codedOutputByteBufferNano.writeString(2, this.sourceFile);
                }
                if (this.begin != null) {
                    codedOutputByteBufferNano.writeInt32(3, this.begin.intValue());
                }
                if (this.end != null) {
                    codedOutputByteBufferNano.writeInt32(4, this.end.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public GeneratedCodeInfo() {
            this.cachedSize = -1;
        }

        public static GeneratedCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GeneratedCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static GeneratedCodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GeneratedCodeInfo().mergeFrom(codedInputByteBufferNano);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) {
            return (GeneratedCodeInfo) MessageNano.mergeFrom(new GeneratedCodeInfo(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.annotation != null && this.annotation.length > 0) {
                for (Annotation annotation2 : this.annotation) {
                    if (annotation2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, annotation2);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final GeneratedCodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        int length = this.annotation == null ? 0 : this.annotation.length;
                        Annotation[] annotationArr = new Annotation[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.annotation, 0, annotationArr, 0, length);
                        }
                        while (length < annotationArr.length - 1) {
                            annotationArr[length] = new Annotation();
                            codedInputByteBufferNano.readMessage(annotationArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        annotationArr[length] = new Annotation();
                        codedInputByteBufferNano.readMessage(annotationArr[length]);
                        this.annotation = annotationArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.annotation != null && this.annotation.length > 0) {
                for (Annotation annotation2 : this.annotation) {
                    if (annotation2 != null) {
                        codedOutputByteBufferNano.writeMessage(1, annotation2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class MessageOptions extends ExtendableMessageNano {
        private static volatile MessageOptions[] _emptyArray;
        public Boolean deprecated = null;
        public String[] experimentalJavaBuilderInterface = WireFormatNano.EMPTY_STRING_ARRAY;
        public String[] experimentalJavaInterfaceExtends = WireFormatNano.EMPTY_STRING_ARRAY;
        public String[] experimentalJavaMessageInterface = WireFormatNano.EMPTY_STRING_ARRAY;
        public Boolean javaliteSerializable = null;
        public Boolean mapEntry = null;
        public Boolean messageSetWireFormat = null;
        public Boolean noStandardDescriptorAccessor = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public MessageOptions() {
            this.cachedSize = -1;
        }

        public static MessageOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MessageOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MessageOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MessageOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static MessageOptions parseFrom(byte[] bArr) {
            return (MessageOptions) MessageNano.mergeFrom(new MessageOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.messageSetWireFormat != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.messageSetWireFormat.booleanValue());
            }
            if (this.noStandardDescriptorAccessor != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.noStandardDescriptorAccessor.booleanValue());
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.deprecated.booleanValue());
            }
            if (this.experimentalJavaMessageInterface != null && this.experimentalJavaMessageInterface.length > 0) {
                int i = 0;
                int i2 = 0;
                for (String str : this.experimentalJavaMessageInterface) {
                    if (str != null) {
                        i2++;
                        i += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                }
                computeSerializedSize = computeSerializedSize + i + (i2 * 1);
            }
            if (this.experimentalJavaBuilderInterface != null && this.experimentalJavaBuilderInterface.length > 0) {
                int i3 = 0;
                int i4 = 0;
                for (String str2 : this.experimentalJavaBuilderInterface) {
                    if (str2 != null) {
                        i4++;
                        i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                }
                computeSerializedSize = computeSerializedSize + i3 + (i4 * 1);
            }
            if (this.experimentalJavaInterfaceExtends != null && this.experimentalJavaInterfaceExtends.length > 0) {
                int i5 = 0;
                int i6 = 0;
                for (String str3 : this.experimentalJavaInterfaceExtends) {
                    if (str3 != null) {
                        i6++;
                        i5 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                }
                computeSerializedSize = computeSerializedSize + i5 + (i6 * 1);
            }
            if (this.mapEntry != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.mapEntry.booleanValue());
            }
            if (this.javaliteSerializable != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, this.javaliteSerializable.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final MessageOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.messageSetWireFormat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 16:
                        this.noStandardDescriptorAccessor = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 34:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        int length = this.experimentalJavaMessageInterface == null ? 0 : this.experimentalJavaMessageInterface.length;
                        String[] strArr = new String[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.experimentalJavaMessageInterface, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr[length] = codedInputByteBufferNano.readString();
                        this.experimentalJavaMessageInterface = strArr;
                        continue;
                    case 42:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        int length2 = this.experimentalJavaBuilderInterface == null ? 0 : this.experimentalJavaBuilderInterface.length;
                        String[] strArr2 = new String[(repeatedFieldArrayLength2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.experimentalJavaBuilderInterface, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        this.experimentalJavaBuilderInterface = strArr2;
                        continue;
                    case FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE /*50*/:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        int length3 = this.experimentalJavaInterfaceExtends == null ? 0 : this.experimentalJavaInterfaceExtends.length;
                        String[] strArr3 = new String[(repeatedFieldArrayLength3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.experimentalJavaInterfaceExtends, 0, strArr3, 0, length3);
                        }
                        while (length3 < strArr3.length - 1) {
                            strArr3[length3] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        strArr3[length3] = codedInputByteBufferNano.readString();
                        this.experimentalJavaInterfaceExtends = strArr3;
                        continue;
                    case 56:
                        this.mapEntry = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 64:
                        this.javaliteSerializable = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length4 = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length4);
                        }
                        while (length4 < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length4] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        uninterpretedOptionArr[length4] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length4]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.messageSetWireFormat != null) {
                codedOutputByteBufferNano.writeBool(1, this.messageSetWireFormat.booleanValue());
            }
            if (this.noStandardDescriptorAccessor != null) {
                codedOutputByteBufferNano.writeBool(2, this.noStandardDescriptorAccessor.booleanValue());
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(3, this.deprecated.booleanValue());
            }
            if (this.experimentalJavaMessageInterface != null && this.experimentalJavaMessageInterface.length > 0) {
                for (String str : this.experimentalJavaMessageInterface) {
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(4, str);
                    }
                }
            }
            if (this.experimentalJavaBuilderInterface != null && this.experimentalJavaBuilderInterface.length > 0) {
                for (String str2 : this.experimentalJavaBuilderInterface) {
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(5, str2);
                    }
                }
            }
            if (this.experimentalJavaInterfaceExtends != null && this.experimentalJavaInterfaceExtends.length > 0) {
                for (String str3 : this.experimentalJavaInterfaceExtends) {
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(6, str3);
                    }
                }
            }
            if (this.mapEntry != null) {
                codedOutputByteBufferNano.writeBool(7, this.mapEntry.booleanValue());
            }
            if (this.javaliteSerializable != null) {
                codedOutputByteBufferNano.writeBool(8, this.javaliteSerializable.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class MethodDescriptorProto extends ExtendableMessageNano {
        private static volatile MethodDescriptorProto[] _emptyArray;
        public Boolean clientStreaming = null;
        public String inputType = null;
        public String name = null;
        public MethodOptions options;
        public String outputType = null;
        public Boolean serverStreaming = null;

        public MethodDescriptorProto() {
            this.cachedSize = -1;
        }

        public static MethodDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MethodDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MethodDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MethodDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) {
            return (MethodDescriptorProto) MessageNano.mergeFrom(new MethodDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.inputType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.inputType);
            }
            if (this.outputType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.outputType);
            }
            if (this.options != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.options);
            }
            if (this.clientStreaming != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, this.clientStreaming.booleanValue());
            }
            return this.serverStreaming != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, this.serverStreaming.booleanValue()) : computeSerializedSize;
        }

        public final MethodDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        this.inputType = codedInputByteBufferNano.readString();
                        continue;
                    case 26:
                        this.outputType = codedInputByteBufferNano.readString();
                        continue;
                    case 34:
                        if (this.options == null) {
                            this.options = new MethodOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        continue;
                    case 40:
                        this.clientStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 48:
                        this.serverStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.inputType != null) {
                codedOutputByteBufferNano.writeString(2, this.inputType);
            }
            if (this.outputType != null) {
                codedOutputByteBufferNano.writeString(3, this.outputType);
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(4, this.options);
            }
            if (this.clientStreaming != null) {
                codedOutputByteBufferNano.writeBool(5, this.clientStreaming.booleanValue());
            }
            if (this.serverStreaming != null) {
                codedOutputByteBufferNano.writeBool(6, this.serverStreaming.booleanValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class MethodOptions extends ExtendableMessageNano {
        private static volatile MethodOptions[] _emptyArray;
        public Integer clientLogging = null;
        public Boolean clientStreaming = null;
        public Double deadline = null;
        public Boolean deprecated = null;
        public Boolean duplicateSuppression = null;
        public Boolean endUserCredsRequested = null;
        public Boolean failFast = null;
        public Boolean goLegacyChannelApi = null;
        public Long legacyClientInitialTokens = null;
        public String legacyResultType = null;
        public Long legacyServerInitialTokens = null;
        public String legacyStreamType = null;
        public int legacyTokenUnit = MessageNano.UNSET_ENUM_VALUE;
        public int logLevel = MessageNano.UNSET_ENUM_VALUE;
        public int protocol = MessageNano.UNSET_ENUM_VALUE;
        public int requestFormat = MessageNano.UNSET_ENUM_VALUE;
        public int responseFormat = MessageNano.UNSET_ENUM_VALUE;
        public String securityLabel = null;
        public int securityLevel = MessageNano.UNSET_ENUM_VALUE;
        public Integer serverLogging = null;
        public Boolean serverStreaming = null;
        public String streamType = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public interface Format {
            public static final int UNCOMPRESSED = 0;
            public static final int ZIPPY_COMPRESSED = 1;
        }

        public interface LogLevel {
            public static final int LOG_HEADER_AND_FILTERED_PAYLOAD = 3;
            public static final int LOG_HEADER_AND_NON_PRIVATE_PAYLOAD_INTERNAL = 2;
            public static final int LOG_HEADER_AND_PAYLOAD = 4;
            public static final int LOG_HEADER_ONLY = 1;
            public static final int LOG_NONE = 0;
        }

        public interface Protocol {
            public static final int TCP = 0;
            public static final int UDP = 1;
        }

        public interface SecurityLevel {
            public static final int INTEGRITY = 1;
            public static final int NONE = 0;
            public static final int PRIVACY_AND_INTEGRITY = 2;
            public static final int STRONG_PRIVACY_AND_INTEGRITY = 3;
        }

        public interface TokenUnit {
            public static final int BYTE = 1;
            public static final int MESSAGE = 0;
        }

        public MethodOptions() {
            this.cachedSize = -1;
        }

        public static MethodOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MethodOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MethodOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MethodOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static MethodOptions parseFrom(byte[] bArr) {
            return (MethodOptions) MessageNano.mergeFrom(new MethodOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.protocol != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.protocol);
            }
            if (this.deadline != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, this.deadline.doubleValue());
            }
            if (this.duplicateSuppression != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, this.duplicateSuppression.booleanValue());
            }
            if (this.failFast != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.failFast.booleanValue());
            }
            if (this.clientLogging != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(11, this.clientLogging.intValue());
            }
            if (this.serverLogging != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(12, this.serverLogging.intValue());
            }
            if (this.securityLevel != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, this.securityLevel);
            }
            if (this.responseFormat != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, this.responseFormat);
            }
            if (this.requestFormat != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, this.requestFormat);
            }
            if (this.streamType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.streamType);
            }
            if (this.securityLabel != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.securityLabel);
            }
            if (this.clientStreaming != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, this.clientStreaming.booleanValue());
            }
            if (this.serverStreaming != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, this.serverStreaming.booleanValue());
            }
            if (this.legacyStreamType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.legacyStreamType);
            }
            if (this.legacyResultType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.legacyResultType);
            }
            if (this.legacyClientInitialTokens != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(24, this.legacyClientInitialTokens.longValue());
            }
            if (this.legacyServerInitialTokens != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(25, this.legacyServerInitialTokens.longValue());
            }
            if (this.endUserCredsRequested != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, this.endUserCredsRequested.booleanValue());
            }
            if (this.logLevel != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(27, this.logLevel);
            }
            if (this.legacyTokenUnit != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(28, this.legacyTokenUnit);
            }
            if (this.goLegacyChannelApi != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(29, this.goLegacyChannelApi.booleanValue());
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption == null || this.uninterpretedOption.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                if (uninterpretedOption2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                }
            }
            return i;
        }

        public final MethodOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 56:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                                this.protocol = readInt32;
                                break;
                            default:
                                continue;
                        }
                    case 65:
                        this.deadline = Double.valueOf(codedInputByteBufferNano.readDouble());
                        continue;
                    case 72:
                        this.duplicateSuppression = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 80:
                        this.failFast = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 88:
                        this.clientLogging = Integer.valueOf(codedInputByteBufferNano.readSInt32());
                        continue;
                    case 96:
                        this.serverLogging = Integer.valueOf(codedInputByteBufferNano.readSInt32());
                        continue;
                    case 104:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        switch (readInt322) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                this.securityLevel = readInt322;
                                break;
                            default:
                                continue;
                        }
                    case 120:
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        switch (readInt323) {
                            case 0:
                            case 1:
                                this.responseFormat = readInt323;
                                break;
                            default:
                                continue;
                        }
                    case 136:
                        int readInt324 = codedInputByteBufferNano.readInt32();
                        switch (readInt324) {
                            case 0:
                            case 1:
                                this.requestFormat = readInt324;
                                break;
                            default:
                                continue;
                        }
                    case 146:
                        this.streamType = codedInputByteBufferNano.readString();
                        continue;
                    case 154:
                        this.securityLabel = codedInputByteBufferNano.readString();
                        continue;
                    case 160:
                        this.clientStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 168:
                        this.serverStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 178:
                        this.legacyStreamType = codedInputByteBufferNano.readString();
                        continue;
                    case 186:
                        this.legacyResultType = codedInputByteBufferNano.readString();
                        continue;
                    case 192:
                        this.legacyClientInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        continue;
                    case SdkServiceConsts.AUTO_FADE_QUICK_START_DELAY_MILLIS /*200*/:
                        this.legacyServerInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        continue;
                    case 208:
                        this.endUserCredsRequested = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 216:
                        int readInt325 = codedInputByteBufferNano.readInt32();
                        switch (readInt325) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.logLevel = readInt325;
                                break;
                            default:
                                continue;
                        }
                    case 224:
                        int readInt326 = codedInputByteBufferNano.readInt32();
                        switch (readInt326) {
                            case 0:
                            case 1:
                                this.legacyTokenUnit = readInt326;
                                break;
                            default:
                                continue;
                        }
                    case 232:
                        this.goLegacyChannelApi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 264:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.protocol != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(7, this.protocol);
            }
            if (this.deadline != null) {
                codedOutputByteBufferNano.writeDouble(8, this.deadline.doubleValue());
            }
            if (this.duplicateSuppression != null) {
                codedOutputByteBufferNano.writeBool(9, this.duplicateSuppression.booleanValue());
            }
            if (this.failFast != null) {
                codedOutputByteBufferNano.writeBool(10, this.failFast.booleanValue());
            }
            if (this.clientLogging != null) {
                codedOutputByteBufferNano.writeSInt32(11, this.clientLogging.intValue());
            }
            if (this.serverLogging != null) {
                codedOutputByteBufferNano.writeSInt32(12, this.serverLogging.intValue());
            }
            if (this.securityLevel != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(13, this.securityLevel);
            }
            if (this.responseFormat != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(15, this.responseFormat);
            }
            if (this.requestFormat != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(17, this.requestFormat);
            }
            if (this.streamType != null) {
                codedOutputByteBufferNano.writeString(18, this.streamType);
            }
            if (this.securityLabel != null) {
                codedOutputByteBufferNano.writeString(19, this.securityLabel);
            }
            if (this.clientStreaming != null) {
                codedOutputByteBufferNano.writeBool(20, this.clientStreaming.booleanValue());
            }
            if (this.serverStreaming != null) {
                codedOutputByteBufferNano.writeBool(21, this.serverStreaming.booleanValue());
            }
            if (this.legacyStreamType != null) {
                codedOutputByteBufferNano.writeString(22, this.legacyStreamType);
            }
            if (this.legacyResultType != null) {
                codedOutputByteBufferNano.writeString(23, this.legacyResultType);
            }
            if (this.legacyClientInitialTokens != null) {
                codedOutputByteBufferNano.writeInt64(24, this.legacyClientInitialTokens.longValue());
            }
            if (this.legacyServerInitialTokens != null) {
                codedOutputByteBufferNano.writeInt64(25, this.legacyServerInitialTokens.longValue());
            }
            if (this.endUserCredsRequested != null) {
                codedOutputByteBufferNano.writeBool(26, this.endUserCredsRequested.booleanValue());
            }
            if (this.logLevel != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(27, this.logLevel);
            }
            if (this.legacyTokenUnit != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(28, this.legacyTokenUnit);
            }
            if (this.goLegacyChannelApi != null) {
                codedOutputByteBufferNano.writeBool(29, this.goLegacyChannelApi.booleanValue());
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(33, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class OneofDescriptorProto extends ExtendableMessageNano {
        private static volatile OneofDescriptorProto[] _emptyArray;
        public String name = null;
        public OneofOptions options;

        public OneofDescriptorProto() {
            this.cachedSize = -1;
        }

        public static OneofDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OneofDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static OneofDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new OneofDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) {
            return (OneofDescriptorProto) MessageNano.mergeFrom(new OneofDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            return this.options != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, this.options) : computeSerializedSize;
        }

        public final OneofDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        if (this.options == null) {
                            this.options = new OneofOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(2, this.options);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class OneofOptions extends ExtendableMessageNano {
        private static volatile OneofOptions[] _emptyArray;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public OneofOptions() {
            this.cachedSize = -1;
        }

        public static OneofOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OneofOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static OneofOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new OneofOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static OneofOptions parseFrom(byte[] bArr) {
            return (OneofOptions) MessageNano.mergeFrom(new OneofOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final OneofOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class ServiceDescriptorProto extends ExtendableMessageNano {
        private static volatile ServiceDescriptorProto[] _emptyArray;
        public MethodDescriptorProto[] method = MethodDescriptorProto.emptyArray();
        public String name = null;
        public ServiceOptions options;
        public StreamDescriptorProto[] stream = StreamDescriptorProto.emptyArray();

        public ServiceDescriptorProto() {
            this.cachedSize = -1;
        }

        public static ServiceDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ServiceDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static ServiceDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ServiceDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) {
            return (ServiceDescriptorProto) MessageNano.mergeFrom(new ServiceDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.method != null && this.method.length > 0) {
                int i = computeSerializedSize;
                for (MethodDescriptorProto methodDescriptorProto : this.method) {
                    if (methodDescriptorProto != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(2, methodDescriptorProto);
                    }
                }
                computeSerializedSize = i;
            }
            if (this.options != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.options);
            }
            if (this.stream != null && this.stream.length > 0) {
                for (StreamDescriptorProto streamDescriptorProto : this.stream) {
                    if (streamDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, streamDescriptorProto);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final ServiceDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        int length = this.method == null ? 0 : this.method.length;
                        MethodDescriptorProto[] methodDescriptorProtoArr = new MethodDescriptorProto[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.method, 0, methodDescriptorProtoArr, 0, length);
                        }
                        while (length < methodDescriptorProtoArr.length - 1) {
                            methodDescriptorProtoArr[length] = new MethodDescriptorProto();
                            codedInputByteBufferNano.readMessage(methodDescriptorProtoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        methodDescriptorProtoArr[length] = new MethodDescriptorProto();
                        codedInputByteBufferNano.readMessage(methodDescriptorProtoArr[length]);
                        this.method = methodDescriptorProtoArr;
                        continue;
                    case 26:
                        if (this.options == null) {
                            this.options = new ServiceOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        continue;
                    case 34:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        int length2 = this.stream == null ? 0 : this.stream.length;
                        StreamDescriptorProto[] streamDescriptorProtoArr = new StreamDescriptorProto[(repeatedFieldArrayLength2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.stream, 0, streamDescriptorProtoArr, 0, length2);
                        }
                        while (length2 < streamDescriptorProtoArr.length - 1) {
                            streamDescriptorProtoArr[length2] = new StreamDescriptorProto();
                            codedInputByteBufferNano.readMessage(streamDescriptorProtoArr[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        streamDescriptorProtoArr[length2] = new StreamDescriptorProto();
                        codedInputByteBufferNano.readMessage(streamDescriptorProtoArr[length2]);
                        this.stream = streamDescriptorProtoArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.method != null && this.method.length > 0) {
                for (MethodDescriptorProto methodDescriptorProto : this.method) {
                    if (methodDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, methodDescriptorProto);
                    }
                }
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(3, this.options);
            }
            if (this.stream != null && this.stream.length > 0) {
                for (StreamDescriptorProto streamDescriptorProto : this.stream) {
                    if (streamDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, streamDescriptorProto);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class ServiceOptions extends ExtendableMessageNano {
        private static volatile ServiceOptions[] _emptyArray;
        public Boolean deprecated = null;
        public Double failureDetectionDelay = null;
        public Boolean multicastStub = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public ServiceOptions() {
            this.cachedSize = -1;
        }

        public static ServiceOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ServiceOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static ServiceOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ServiceOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static ServiceOptions parseFrom(byte[] bArr) {
            return (ServiceOptions) MessageNano.mergeFrom(new ServiceOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.failureDetectionDelay != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(16, this.failureDetectionDelay.doubleValue());
            }
            if (this.multicastStub != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, this.multicastStub.booleanValue());
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption == null || this.uninterpretedOption.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                if (uninterpretedOption2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                }
            }
            return i;
        }

        public final ServiceOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 129:
                        this.failureDetectionDelay = Double.valueOf(codedInputByteBufferNano.readDouble());
                        continue;
                    case 160:
                        this.multicastStub = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 264:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.failureDetectionDelay != null) {
                codedOutputByteBufferNano.writeDouble(16, this.failureDetectionDelay.doubleValue());
            }
            if (this.multicastStub != null) {
                codedOutputByteBufferNano.writeBool(20, this.multicastStub.booleanValue());
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(33, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class SourceCodeInfo extends ExtendableMessageNano {
        private static volatile SourceCodeInfo[] _emptyArray;
        public Location[] location = Location.emptyArray();

        public final class Location extends ExtendableMessageNano {
            private static volatile Location[] _emptyArray;
            public String leadingComments = null;
            public String[] leadingDetachedComments = WireFormatNano.EMPTY_STRING_ARRAY;
            public int[] path = WireFormatNano.EMPTY_INT_ARRAY;
            public int[] span = WireFormatNano.EMPTY_INT_ARRAY;
            public String trailingComments = null;

            public Location() {
                this.cachedSize = -1;
            }

            public static Location[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Location[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static Location parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Location().mergeFrom(codedInputByteBufferNano);
            }

            public static Location parseFrom(byte[] bArr) {
                return (Location) MessageNano.mergeFrom(new Location(), bArr);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int i;
                int computeSerializedSize = super.computeSerializedSize();
                if (this.path == null || this.path.length <= 0) {
                    i = computeSerializedSize;
                } else {
                    int i2 = 0;
                    for (int computeInt32SizeNoTag : this.path) {
                        i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                    }
                    i = computeSerializedSize + i2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i2);
                }
                if (this.span != null && this.span.length > 0) {
                    int i3 = 0;
                    for (int computeInt32SizeNoTag2 : this.span) {
                        i3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag2);
                    }
                    i = i + i3 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i3);
                }
                if (this.leadingComments != null) {
                    i += CodedOutputByteBufferNano.computeStringSize(3, this.leadingComments);
                }
                if (this.trailingComments != null) {
                    i += CodedOutputByteBufferNano.computeStringSize(4, this.trailingComments);
                }
                if (this.leadingDetachedComments == null || this.leadingDetachedComments.length <= 0) {
                    return i;
                }
                int i4 = 0;
                int i5 = 0;
                for (String str : this.leadingDetachedComments) {
                    if (str != null) {
                        i5++;
                        i4 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                }
                return i + i4 + (i5 * 1);
            }

            public final Location mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                            int length = this.path == null ? 0 : this.path.length;
                            int[] iArr = new int[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.path, 0, iArr, 0, length);
                            }
                            while (length < iArr.length - 1) {
                                iArr[length] = codedInputByteBufferNano.readInt32();
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            iArr[length] = codedInputByteBufferNano.readInt32();
                            this.path = iArr;
                            continue;
                        case 10:
                            int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position = codedInputByteBufferNano.getPosition();
                            int i = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                codedInputByteBufferNano.readInt32();
                                i++;
                            }
                            codedInputByteBufferNano.rewindToPosition(position);
                            int length2 = this.path == null ? 0 : this.path.length;
                            int[] iArr2 = new int[(i + length2)];
                            if (length2 != 0) {
                                System.arraycopy(this.path, 0, iArr2, 0, length2);
                            }
                            while (length2 < iArr2.length) {
                                iArr2[length2] = codedInputByteBufferNano.readInt32();
                                length2++;
                            }
                            this.path = iArr2;
                            codedInputByteBufferNano.popLimit(pushLimit);
                            continue;
                        case 16:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                            int length3 = this.span == null ? 0 : this.span.length;
                            int[] iArr3 = new int[(repeatedFieldArrayLength2 + length3)];
                            if (length3 != 0) {
                                System.arraycopy(this.span, 0, iArr3, 0, length3);
                            }
                            while (length3 < iArr3.length - 1) {
                                iArr3[length3] = codedInputByteBufferNano.readInt32();
                                codedInputByteBufferNano.readTag();
                                length3++;
                            }
                            iArr3[length3] = codedInputByteBufferNano.readInt32();
                            this.span = iArr3;
                            continue;
                        case 18:
                            int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position2 = codedInputByteBufferNano.getPosition();
                            int i2 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                codedInputByteBufferNano.readInt32();
                                i2++;
                            }
                            codedInputByteBufferNano.rewindToPosition(position2);
                            int length4 = this.span == null ? 0 : this.span.length;
                            int[] iArr4 = new int[(i2 + length4)];
                            if (length4 != 0) {
                                System.arraycopy(this.span, 0, iArr4, 0, length4);
                            }
                            while (length4 < iArr4.length) {
                                iArr4[length4] = codedInputByteBufferNano.readInt32();
                                length4++;
                            }
                            this.span = iArr4;
                            codedInputByteBufferNano.popLimit(pushLimit2);
                            continue;
                        case 26:
                            this.leadingComments = codedInputByteBufferNano.readString();
                            continue;
                        case 34:
                            this.trailingComments = codedInputByteBufferNano.readString();
                            continue;
                        case FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE /*50*/:
                            int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                            int length5 = this.leadingDetachedComments == null ? 0 : this.leadingDetachedComments.length;
                            String[] strArr = new String[(repeatedFieldArrayLength3 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.leadingDetachedComments, 0, strArr, 0, length5);
                            }
                            while (length5 < strArr.length - 1) {
                                strArr[length5] = codedInputByteBufferNano.readString();
                                codedInputByteBufferNano.readTag();
                                length5++;
                            }
                            strArr[length5] = codedInputByteBufferNano.readString();
                            this.leadingDetachedComments = strArr;
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

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                if (this.path != null && this.path.length > 0) {
                    int i = 0;
                    for (int computeInt32SizeNoTag : this.path) {
                        i += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(i);
                    for (int writeInt32NoTag : this.path) {
                        codedOutputByteBufferNano.writeInt32NoTag(writeInt32NoTag);
                    }
                }
                if (this.span != null && this.span.length > 0) {
                    int i2 = 0;
                    for (int computeInt32SizeNoTag2 : this.span) {
                        i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag2);
                    }
                    codedOutputByteBufferNano.writeRawVarint32(18);
                    codedOutputByteBufferNano.writeRawVarint32(i2);
                    for (int writeInt32NoTag2 : this.span) {
                        codedOutputByteBufferNano.writeInt32NoTag(writeInt32NoTag2);
                    }
                }
                if (this.leadingComments != null) {
                    codedOutputByteBufferNano.writeString(3, this.leadingComments);
                }
                if (this.trailingComments != null) {
                    codedOutputByteBufferNano.writeString(4, this.trailingComments);
                }
                if (this.leadingDetachedComments != null && this.leadingDetachedComments.length > 0) {
                    for (String str : this.leadingDetachedComments) {
                        if (str != null) {
                            codedOutputByteBufferNano.writeString(6, str);
                        }
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public SourceCodeInfo() {
            this.cachedSize = -1;
        }

        public static SourceCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SourceCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static SourceCodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SourceCodeInfo().mergeFrom(codedInputByteBufferNano);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) {
            return (SourceCodeInfo) MessageNano.mergeFrom(new SourceCodeInfo(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.location != null && this.location.length > 0) {
                for (Location location2 : this.location) {
                    if (location2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, location2);
                    }
                }
            }
            return computeSerializedSize;
        }

        public final SourceCodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        int length = this.location == null ? 0 : this.location.length;
                        Location[] locationArr = new Location[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.location, 0, locationArr, 0, length);
                        }
                        while (length < locationArr.length - 1) {
                            locationArr[length] = new Location();
                            codedInputByteBufferNano.readMessage(locationArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        locationArr[length] = new Location();
                        codedInputByteBufferNano.readMessage(locationArr[length]);
                        this.location = locationArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.location != null && this.location.length > 0) {
                for (Location location2 : this.location) {
                    if (location2 != null) {
                        codedOutputByteBufferNano.writeMessage(1, location2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class StreamDescriptorProto extends ExtendableMessageNano {
        private static volatile StreamDescriptorProto[] _emptyArray;
        public String clientMessageType = null;
        public String name = null;
        public StreamOptions options;
        public String serverMessageType = null;

        public StreamDescriptorProto() {
            this.cachedSize = -1;
        }

        public static StreamDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static StreamDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new StreamDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static StreamDescriptorProto parseFrom(byte[] bArr) {
            return (StreamDescriptorProto) MessageNano.mergeFrom(new StreamDescriptorProto(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.clientMessageType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.clientMessageType);
            }
            if (this.serverMessageType != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.serverMessageType);
            }
            return this.options != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.options) : computeSerializedSize;
        }

        public final StreamDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        this.clientMessageType = codedInputByteBufferNano.readString();
                        continue;
                    case 26:
                        this.serverMessageType = codedInputByteBufferNano.readString();
                        continue;
                    case 34:
                        if (this.options == null) {
                            this.options = new StreamOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.clientMessageType != null) {
                codedOutputByteBufferNano.writeString(2, this.clientMessageType);
            }
            if (this.serverMessageType != null) {
                codedOutputByteBufferNano.writeString(3, this.serverMessageType);
            }
            if (this.options != null) {
                codedOutputByteBufferNano.writeMessage(4, this.options);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class StreamOptions extends ExtendableMessageNano {
        private static volatile StreamOptions[] _emptyArray;
        public Long clientInitialTokens = null;
        public Integer clientLogging = null;
        public Double deadline = null;
        public Boolean deprecated = null;
        public Boolean endUserCredsRequested = null;
        public Boolean failFast = null;
        public int logLevel = MessageNano.UNSET_ENUM_VALUE;
        public String securityLabel = null;
        public int securityLevel = MessageNano.UNSET_ENUM_VALUE;
        public Long serverInitialTokens = null;
        public Integer serverLogging = null;
        public int tokenUnit = MessageNano.UNSET_ENUM_VALUE;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public interface TokenUnit {
            public static final int BYTE = 1;
            public static final int MESSAGE = 0;
        }

        public StreamOptions() {
            this.cachedSize = -1;
        }

        public static StreamOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static StreamOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new StreamOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static StreamOptions parseFrom(byte[] bArr) {
            return (StreamOptions) MessageNano.mergeFrom(new StreamOptions(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.clientInitialTokens != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.clientInitialTokens.longValue());
            }
            if (this.serverInitialTokens != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.serverInitialTokens.longValue());
            }
            if (this.tokenUnit != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.tokenUnit);
            }
            if (this.securityLevel != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.securityLevel);
            }
            if (this.securityLabel != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.securityLabel);
            }
            if (this.clientLogging != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.clientLogging.intValue());
            }
            if (this.serverLogging != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.serverLogging.intValue());
            }
            if (this.deadline != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, this.deadline.doubleValue());
            }
            if (this.failFast != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, this.failFast.booleanValue());
            }
            if (this.endUserCredsRequested != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.endUserCredsRequested.booleanValue());
            }
            if (this.logLevel != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, this.logLevel);
            }
            if (this.deprecated != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption == null || this.uninterpretedOption.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                if (uninterpretedOption2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption2);
                }
            }
            return i;
        }

        public final StreamOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.clientInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        continue;
                    case 16:
                        this.serverInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                                this.tokenUnit = readInt32;
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        switch (readInt322) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                this.securityLevel = readInt322;
                                break;
                            default:
                                continue;
                        }
                    case 42:
                        this.securityLabel = codedInputByteBufferNano.readString();
                        continue;
                    case 48:
                        this.clientLogging = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 56:
                        this.serverLogging = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 65:
                        this.deadline = Double.valueOf(codedInputByteBufferNano.readDouble());
                        continue;
                    case 72:
                        this.failFast = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 80:
                        this.endUserCredsRequested = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 88:
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        switch (readInt323) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.logLevel = readInt323;
                                break;
                            default:
                                continue;
                        }
                    case 264:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        continue;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        int length = this.uninterpretedOption == null ? 0 : this.uninterpretedOption.length;
                        UninterpretedOption[] uninterpretedOptionArr = new UninterpretedOption[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr, 0, length);
                        }
                        while (length < uninterpretedOptionArr.length - 1) {
                            uninterpretedOptionArr[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr[length]);
                        this.uninterpretedOption = uninterpretedOptionArr;
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.clientInitialTokens != null) {
                codedOutputByteBufferNano.writeInt64(1, this.clientInitialTokens.longValue());
            }
            if (this.serverInitialTokens != null) {
                codedOutputByteBufferNano.writeInt64(2, this.serverInitialTokens.longValue());
            }
            if (this.tokenUnit != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(3, this.tokenUnit);
            }
            if (this.securityLevel != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(4, this.securityLevel);
            }
            if (this.securityLabel != null) {
                codedOutputByteBufferNano.writeString(5, this.securityLabel);
            }
            if (this.clientLogging != null) {
                codedOutputByteBufferNano.writeInt32(6, this.clientLogging.intValue());
            }
            if (this.serverLogging != null) {
                codedOutputByteBufferNano.writeInt32(7, this.serverLogging.intValue());
            }
            if (this.deadline != null) {
                codedOutputByteBufferNano.writeDouble(8, this.deadline.doubleValue());
            }
            if (this.failFast != null) {
                codedOutputByteBufferNano.writeBool(9, this.failFast.booleanValue());
            }
            if (this.endUserCredsRequested != null) {
                codedOutputByteBufferNano.writeBool(10, this.endUserCredsRequested.booleanValue());
            }
            if (this.logLevel != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(11, this.logLevel);
            }
            if (this.deprecated != null) {
                codedOutputByteBufferNano.writeBool(33, this.deprecated.booleanValue());
            }
            if (this.uninterpretedOption != null && this.uninterpretedOption.length > 0) {
                for (UninterpretedOption uninterpretedOption2 : this.uninterpretedOption) {
                    if (uninterpretedOption2 != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public final class UninterpretedOption extends ExtendableMessageNano {
        private static volatile UninterpretedOption[] _emptyArray;
        public String aggregateValue = null;
        public Double doubleValue = null;
        public String identifierValue = null;
        public NamePart[] name = NamePart.emptyArray();
        public Long negativeIntValue = null;
        public Long positiveIntValue = null;
        public byte[] stringValue = null;

        public final class NamePart extends ExtendableMessageNano {
            private static volatile NamePart[] _emptyArray;
            public Boolean isExtension = null;
            public String namePart = null;

            public NamePart() {
                this.cachedSize = -1;
            }

            public static NamePart[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new NamePart[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static NamePart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new NamePart().mergeFrom(codedInputByteBufferNano);
            }

            public static NamePart parseFrom(byte[] bArr) {
                return (NamePart) MessageNano.mergeFrom(new NamePart(), bArr);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.namePart) + CodedOutputByteBufferNano.computeBoolSize(2, this.isExtension.booleanValue());
            }

            public final NamePart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.namePart = codedInputByteBufferNano.readString();
                            continue;
                        case 16:
                            this.isExtension = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                codedOutputByteBufferNano.writeString(1, this.namePart);
                codedOutputByteBufferNano.writeBool(2, this.isExtension.booleanValue());
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public UninterpretedOption() {
            this.cachedSize = -1;
        }

        public static UninterpretedOption[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UninterpretedOption[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static UninterpretedOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UninterpretedOption().mergeFrom(codedInputByteBufferNano);
        }

        public static UninterpretedOption parseFrom(byte[] bArr) {
            return (UninterpretedOption) MessageNano.mergeFrom(new UninterpretedOption(), bArr);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.name != null && this.name.length > 0) {
                for (NamePart namePart : this.name) {
                    if (namePart != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, namePart);
                    }
                }
            }
            if (this.identifierValue != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.identifierValue);
            }
            if (this.positiveIntValue != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, this.positiveIntValue.longValue());
            }
            if (this.negativeIntValue != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, this.negativeIntValue.longValue());
            }
            if (this.doubleValue != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, this.doubleValue.doubleValue());
            }
            if (this.stringValue != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.stringValue);
            }
            return this.aggregateValue != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.aggregateValue) : computeSerializedSize;
        }

        public final UninterpretedOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        int length = this.name == null ? 0 : this.name.length;
                        NamePart[] namePartArr = new NamePart[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.name, 0, namePartArr, 0, length);
                        }
                        while (length < namePartArr.length - 1) {
                            namePartArr[length] = new NamePart();
                            codedInputByteBufferNano.readMessage(namePartArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        namePartArr[length] = new NamePart();
                        codedInputByteBufferNano.readMessage(namePartArr[length]);
                        this.name = namePartArr;
                        continue;
                    case 26:
                        this.identifierValue = codedInputByteBufferNano.readString();
                        continue;
                    case 32:
                        this.positiveIntValue = Long.valueOf(codedInputByteBufferNano.readUInt64());
                        continue;
                    case 40:
                        this.negativeIntValue = Long.valueOf(codedInputByteBufferNano.readInt64());
                        continue;
                    case 49:
                        this.doubleValue = Double.valueOf(codedInputByteBufferNano.readDouble());
                        continue;
                    case 58:
                        this.stringValue = codedInputByteBufferNano.readBytes();
                        continue;
                    case 66:
                        this.aggregateValue = codedInputByteBufferNano.readString();
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

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if (this.name != null && this.name.length > 0) {
                for (NamePart namePart : this.name) {
                    if (namePart != null) {
                        codedOutputByteBufferNano.writeMessage(2, namePart);
                    }
                }
            }
            if (this.identifierValue != null) {
                codedOutputByteBufferNano.writeString(3, this.identifierValue);
            }
            if (this.positiveIntValue != null) {
                codedOutputByteBufferNano.writeUInt64(4, this.positiveIntValue.longValue());
            }
            if (this.negativeIntValue != null) {
                codedOutputByteBufferNano.writeInt64(5, this.negativeIntValue.longValue());
            }
            if (this.doubleValue != null) {
                codedOutputByteBufferNano.writeDouble(6, this.doubleValue.doubleValue());
            }
            if (this.stringValue != null) {
                codedOutputByteBufferNano.writeBytes(7, this.stringValue);
            }
            if (this.aggregateValue != null) {
                codedOutputByteBufferNano.writeString(8, this.aggregateValue);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
