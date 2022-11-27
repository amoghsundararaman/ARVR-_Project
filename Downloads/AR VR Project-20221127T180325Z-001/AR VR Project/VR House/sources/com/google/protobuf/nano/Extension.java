package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Extension {
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
    protected final Class clazz;
    protected final boolean repeated;
    public final int tag;
    protected final int type;

    class PrimitiveExtension extends Extension {
        private final int nonPackedTag;
        private final int packedTag;

        public PrimitiveExtension(int i, Class cls, int i2, boolean z, int i3, int i4) {
            super(i, cls, i2, z);
            this.nonPackedTag = i3;
            this.packedTag = i4;
        }

        private int computePackedDataSize(Object obj) {
            int i = 0;
            int length = Array.getLength(obj);
            switch (this.type) {
                case 1:
                case 6:
                case 16:
                    return length << 3;
                case 2:
                case 7:
                case 15:
                    return length << 2;
                case 3:
                    int i2 = 0;
                    while (i2 < length) {
                        int computeInt64SizeNoTag = CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(obj, i2)) + i;
                        i2++;
                        i = computeInt64SizeNoTag;
                    }
                    return i;
                case 4:
                    int i3 = 0;
                    while (i3 < length) {
                        int computeUInt64SizeNoTag = CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(obj, i3)) + i;
                        i3++;
                        i = computeUInt64SizeNoTag;
                    }
                    return i;
                case 5:
                    int i4 = 0;
                    while (i4 < length) {
                        int computeInt32SizeNoTag = CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(obj, i4)) + i;
                        i4++;
                        i = computeInt32SizeNoTag;
                    }
                    return i;
                case 8:
                    return length;
                case 13:
                    int i5 = 0;
                    while (i5 < length) {
                        int computeUInt32SizeNoTag = CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(obj, i5)) + i;
                        i5++;
                        i = computeUInt32SizeNoTag;
                    }
                    return i;
                case 14:
                    int i6 = 0;
                    while (i6 < length) {
                        int computeEnumSizeNoTag = CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(obj, i6)) + i;
                        i6++;
                        i = computeEnumSizeNoTag;
                    }
                    return i;
                case 17:
                    int i7 = 0;
                    while (i7 < length) {
                        int computeSInt32SizeNoTag = CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(obj, i7)) + i;
                        i7++;
                        i = computeSInt32SizeNoTag;
                    }
                    return i;
                case 18:
                    int i8 = 0;
                    while (i8 < length) {
                        int computeSInt64SizeNoTag = CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(obj, i8)) + i;
                        i8++;
                        i = computeSInt64SizeNoTag;
                    }
                    return i;
                default:
                    throw new IllegalArgumentException(new StringBuilder(40).append("Unexpected non-packable type ").append(this.type).toString());
            }
        }

        /* access modifiers changed from: protected */
        public int computeRepeatedSerializedSize(Object obj) {
            if (this.tag == this.nonPackedTag) {
                return Extension.super.computeRepeatedSerializedSize(obj);
            }
            if (this.tag == this.packedTag) {
                int computePackedDataSize = computePackedDataSize(obj);
                return computePackedDataSize + CodedOutputByteBufferNano.computeRawVarint32Size(computePackedDataSize) + CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
            }
            int i = this.tag;
            int i2 = this.nonPackedTag;
            throw new IllegalArgumentException(new StringBuilder(124).append("Unexpected repeated extension tag ").append(i).append(", unequal to both non-packed variant ").append(i2).append(" and packed variant ").append(this.packedTag).toString());
        }

        /* access modifiers changed from: protected */
        public final int computeSingularSerializedSize(Object obj) {
            int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
            switch (this.type) {
                case 1:
                    return CodedOutputByteBufferNano.computeDoubleSize(tagFieldNumber, ((Double) obj).doubleValue());
                case 2:
                    return CodedOutputByteBufferNano.computeFloatSize(tagFieldNumber, ((Float) obj).floatValue());
                case 3:
                    return CodedOutputByteBufferNano.computeInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 4:
                    return CodedOutputByteBufferNano.computeUInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 5:
                    return CodedOutputByteBufferNano.computeInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 6:
                    return CodedOutputByteBufferNano.computeFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 7:
                    return CodedOutputByteBufferNano.computeFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 8:
                    return CodedOutputByteBufferNano.computeBoolSize(tagFieldNumber, ((Boolean) obj).booleanValue());
                case 9:
                    return CodedOutputByteBufferNano.computeStringSize(tagFieldNumber, (String) obj);
                case 12:
                    return CodedOutputByteBufferNano.computeBytesSize(tagFieldNumber, (byte[]) obj);
                case 13:
                    return CodedOutputByteBufferNano.computeUInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 14:
                    return CodedOutputByteBufferNano.computeEnumSize(tagFieldNumber, ((Integer) obj).intValue());
                case 15:
                    return CodedOutputByteBufferNano.computeSFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 16:
                    return CodedOutputByteBufferNano.computeSFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 17:
                    return CodedOutputByteBufferNano.computeSInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 18:
                    return CodedOutputByteBufferNano.computeSInt64Size(tagFieldNumber, ((Long) obj).longValue());
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        }

        /* access modifiers changed from: protected */
        public Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
            try {
                switch (this.type) {
                    case 1:
                        return Double.valueOf(codedInputByteBufferNano.readDouble());
                    case 2:
                        return Float.valueOf(codedInputByteBufferNano.readFloat());
                    case 3:
                        return Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 4:
                        return Long.valueOf(codedInputByteBufferNano.readUInt64());
                    case 5:
                        return Integer.valueOf(codedInputByteBufferNano.readInt32());
                    case 6:
                        return Long.valueOf(codedInputByteBufferNano.readFixed64());
                    case 7:
                        return Integer.valueOf(codedInputByteBufferNano.readFixed32());
                    case 8:
                        return Boolean.valueOf(codedInputByteBufferNano.readBool());
                    case 9:
                        return codedInputByteBufferNano.readString();
                    case 12:
                        return codedInputByteBufferNano.readBytes();
                    case 13:
                        return Integer.valueOf(codedInputByteBufferNano.readUInt32());
                    case 14:
                        return Integer.valueOf(codedInputByteBufferNano.readEnum());
                    case 15:
                        return Integer.valueOf(codedInputByteBufferNano.readSFixed32());
                    case 16:
                        return Long.valueOf(codedInputByteBufferNano.readSFixed64());
                    case 17:
                        return Integer.valueOf(codedInputByteBufferNano.readSInt32());
                    case 18:
                        return Long.valueOf(codedInputByteBufferNano.readSInt64());
                    default:
                        throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
            throw new IllegalArgumentException("Error reading extension field", e);
        }

        /* access modifiers changed from: protected */
        public void readDataInto(UnknownFieldData unknownFieldData, List list) {
            if (unknownFieldData.tag == this.nonPackedTag) {
                list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
                return;
            }
            CodedInputByteBufferNano newInstance = CodedInputByteBufferNano.newInstance(unknownFieldData.bytes);
            try {
                newInstance.pushLimit(newInstance.readRawVarint32());
                while (!newInstance.isAtEnd()) {
                    list.add(readData(newInstance));
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
            r8.writeFixed32NoTag(java.lang.reflect.Array.getInt(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
            r8.writeSFixed32NoTag(java.lang.reflect.Array.getInt(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
            r8.writeFloatNoTag(java.lang.reflect.Array.getFloat(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
            r8.writeFixed64NoTag(java.lang.reflect.Array.getLong(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
            r8.writeSFixed64NoTag(java.lang.reflect.Array.getLong(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
            r8.writeDoubleNoTag(java.lang.reflect.Array.getDouble(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a0, code lost:
            r8.writeInt32NoTag(java.lang.reflect.Array.getInt(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
            r8.writeSInt32NoTag(java.lang.reflect.Array.getInt(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b8, code lost:
            r8.writeUInt32NoTag(java.lang.reflect.Array.getInt(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
            r8.writeInt64NoTag(java.lang.reflect.Array.getLong(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ce, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d0, code lost:
            r8.writeSInt64NoTag(java.lang.reflect.Array.getLong(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00da, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dc, code lost:
            r8.writeUInt64NoTag(java.lang.reflect.Array.getLong(r7, r0));
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e6, code lost:
            if (r0 >= r1) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e8, code lost:
            r8.writeEnumNoTag(java.lang.reflect.Array.getInt(r7, r0));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ef, code lost:
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeRepeatedData(java.lang.Object r7, com.google.protobuf.nano.CodedOutputByteBufferNano r8) {
            /*
                r6 = this;
                r0 = 0
                int r1 = r6.tag
                int r2 = r6.nonPackedTag
                if (r1 != r2) goto L_0x000b
                com.google.protobuf.nano.Extension.super.writeRepeatedData(r7, r8)
            L_0x000a:
                return
            L_0x000b:
                int r1 = r6.tag
                int r2 = r6.packedTag
                if (r1 != r2) goto L_0x00f2
                int r1 = java.lang.reflect.Array.getLength(r7)
                int r2 = r6.computePackedDataSize(r7)
                int r3 = r6.tag     // Catch:{ IOException -> 0x0043 }
                r8.writeRawVarint32(r3)     // Catch:{ IOException -> 0x0043 }
                r8.writeRawVarint32(r2)     // Catch:{ IOException -> 0x0043 }
                int r2 = r6.type     // Catch:{ IOException -> 0x0043 }
                switch(r2) {
                    case 1: goto L_0x0092;
                    case 2: goto L_0x006e;
                    case 3: goto L_0x00c2;
                    case 4: goto L_0x00da;
                    case 5: goto L_0x009e;
                    case 6: goto L_0x007a;
                    case 7: goto L_0x0056;
                    case 8: goto L_0x004a;
                    case 9: goto L_0x0026;
                    case 10: goto L_0x0026;
                    case 11: goto L_0x0026;
                    case 12: goto L_0x0026;
                    case 13: goto L_0x00b6;
                    case 14: goto L_0x00e6;
                    case 15: goto L_0x0062;
                    case 16: goto L_0x0086;
                    case 17: goto L_0x00aa;
                    case 18: goto L_0x00ce;
                    default: goto L_0x0026;
                }     // Catch:{ IOException -> 0x0043 }
            L_0x0026:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x0043 }
                int r1 = r6.type     // Catch:{ IOException -> 0x0043 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0043 }
                r3 = 27
                r2.<init>(r3)     // Catch:{ IOException -> 0x0043 }
                java.lang.String r3 = "Unpackable type "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0043 }
                java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ IOException -> 0x0043 }
                java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0043 }
                r0.<init>(r1)     // Catch:{ IOException -> 0x0043 }
                throw r0     // Catch:{ IOException -> 0x0043 }
            L_0x0043:
                r0 = move-exception
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                r1.<init>(r0)
                throw r1
            L_0x004a:
                if (r0 >= r1) goto L_0x000a
                boolean r2 = java.lang.reflect.Array.getBoolean(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeBoolNoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x004a
            L_0x0056:
                if (r0 >= r1) goto L_0x000a
                int r2 = java.lang.reflect.Array.getInt(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeFixed32NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x0056
            L_0x0062:
                if (r0 >= r1) goto L_0x000a
                int r2 = java.lang.reflect.Array.getInt(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeSFixed32NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x0062
            L_0x006e:
                if (r0 >= r1) goto L_0x000a
                float r2 = java.lang.reflect.Array.getFloat(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeFloatNoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x006e
            L_0x007a:
                if (r0 >= r1) goto L_0x000a
                long r2 = java.lang.reflect.Array.getLong(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeFixed64NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x007a
            L_0x0086:
                if (r0 >= r1) goto L_0x000a
                long r2 = java.lang.reflect.Array.getLong(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeSFixed64NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x0086
            L_0x0092:
                if (r0 >= r1) goto L_0x000a
                double r2 = java.lang.reflect.Array.getDouble(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeDoubleNoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x0092
            L_0x009e:
                if (r0 >= r1) goto L_0x000a
                int r2 = java.lang.reflect.Array.getInt(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeInt32NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x009e
            L_0x00aa:
                if (r0 >= r1) goto L_0x000a
                int r2 = java.lang.reflect.Array.getInt(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeSInt32NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x00aa
            L_0x00b6:
                if (r0 >= r1) goto L_0x000a
                int r2 = java.lang.reflect.Array.getInt(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeUInt32NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x00b6
            L_0x00c2:
                if (r0 >= r1) goto L_0x000a
                long r2 = java.lang.reflect.Array.getLong(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeInt64NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x00c2
            L_0x00ce:
                if (r0 >= r1) goto L_0x000a
                long r2 = java.lang.reflect.Array.getLong(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeSInt64NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x00ce
            L_0x00da:
                if (r0 >= r1) goto L_0x000a
                long r2 = java.lang.reflect.Array.getLong(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeUInt64NoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x00da
            L_0x00e6:
                if (r0 >= r1) goto L_0x000a
                int r2 = java.lang.reflect.Array.getInt(r7, r0)     // Catch:{ IOException -> 0x0043 }
                r8.writeEnumNoTag(r2)     // Catch:{ IOException -> 0x0043 }
                int r0 = r0 + 1
                goto L_0x00e6
            L_0x00f2:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                int r1 = r6.tag
                int r2 = r6.nonPackedTag
                int r3 = r6.packedTag
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r5 = 124(0x7c, float:1.74E-43)
                r4.<init>(r5)
                java.lang.String r5 = "Unexpected repeated extension tag "
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.StringBuilder r1 = r4.append(r1)
                java.lang.String r4 = ", unequal to both non-packed variant "
                java.lang.StringBuilder r1 = r1.append(r4)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = " and packed variant "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.nano.Extension.PrimitiveExtension.writeRepeatedData(java.lang.Object, com.google.protobuf.nano.CodedOutputByteBufferNano):void");
        }

        /* access modifiers changed from: protected */
        public final void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                switch (this.type) {
                    case 1:
                        codedOutputByteBufferNano.writeDoubleNoTag(((Double) obj).doubleValue());
                        return;
                    case 2:
                        codedOutputByteBufferNano.writeFloatNoTag(((Float) obj).floatValue());
                        return;
                    case 3:
                        codedOutputByteBufferNano.writeInt64NoTag(((Long) obj).longValue());
                        return;
                    case 4:
                        codedOutputByteBufferNano.writeUInt64NoTag(((Long) obj).longValue());
                        return;
                    case 5:
                        codedOutputByteBufferNano.writeInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 6:
                        codedOutputByteBufferNano.writeFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 7:
                        codedOutputByteBufferNano.writeFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 8:
                        codedOutputByteBufferNano.writeBoolNoTag(((Boolean) obj).booleanValue());
                        return;
                    case 9:
                        codedOutputByteBufferNano.writeStringNoTag((String) obj);
                        return;
                    case 12:
                        codedOutputByteBufferNano.writeBytesNoTag((byte[]) obj);
                        return;
                    case 13:
                        codedOutputByteBufferNano.writeUInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 14:
                        codedOutputByteBufferNano.writeEnumNoTag(((Integer) obj).intValue());
                        return;
                    case 15:
                        codedOutputByteBufferNano.writeSFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 16:
                        codedOutputByteBufferNano.writeSFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 17:
                        codedOutputByteBufferNano.writeSInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 18:
                        codedOutputByteBufferNano.writeSInt64NoTag(((Long) obj).longValue());
                        return;
                    default:
                        throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
            throw new IllegalStateException(e);
        }
    }

    private Extension(int i, Class cls, int i2, boolean z) {
        this.type = i;
        this.clazz = cls;
        this.tag = i2;
        this.repeated = z;
    }

    @Deprecated
    public static Extension createMessageTyped(int i, Class cls, int i2) {
        return new Extension(i, cls, i2, false);
    }

    public static Extension createMessageTyped(int i, Class cls, long j) {
        return new Extension(i, cls, (int) j, false);
    }

    public static Extension createPrimitiveTyped(int i, Class cls, long j) {
        return new PrimitiveExtension(i, cls, (int) j, false, 0, 0);
    }

    public static Extension createRepeatedMessageTyped(int i, Class cls, long j) {
        return new Extension(i, cls, (int) j, true);
    }

    public static Extension createRepeatedPrimitiveTyped(int i, Class cls, long j, long j2, long j3) {
        return new PrimitiveExtension(i, cls, (int) j, true, (int) j2, (int) j3);
    }

    private Object getRepeatedValueFrom(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            UnknownFieldData unknownFieldData = (UnknownFieldData) list.get(i);
            if (unknownFieldData.bytes.length != 0) {
                readDataInto(unknownFieldData, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Object cast = this.clazz.cast(Array.newInstance(this.clazz.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private Object getSingularValueFrom(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(((UnknownFieldData) list.get(list.size() - 1)).bytes)));
    }

    /* access modifiers changed from: protected */
    public int computeRepeatedSerializedSize(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += computeSingularSerializedSize(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public int computeSerializedSize(Object obj) {
        return this.repeated ? computeRepeatedSerializedSize(obj) : computeSingularSerializedSize(obj);
    }

    /* access modifiers changed from: protected */
    public int computeSingularSerializedSize(Object obj) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
        switch (this.type) {
            case 10:
                return CodedOutputByteBufferNano.computeGroupSize(tagFieldNumber, (MessageNano) obj);
            case 11:
                return CodedOutputByteBufferNano.computeMessageSize(tagFieldNumber, (MessageNano) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        return this.type == extension.type && this.clazz == extension.clazz && this.tag == extension.tag && this.repeated == extension.repeated;
    }

    /* access modifiers changed from: package-private */
    public final Object getValueFrom(List list) {
        if (list == null) {
            return null;
        }
        return this.repeated ? getRepeatedValueFrom(list) : getSingularValueFrom(list);
    }

    public int hashCode() {
        return (this.repeated ? 1 : 0) + ((((((this.type + 1147) * 31) + this.clazz.hashCode()) * 31) + this.tag) * 31);
    }

    /* access modifiers changed from: protected */
    public Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
        Class<?> componentType = this.repeated ? this.clazz.getComponentType() : this.clazz;
        try {
            switch (this.type) {
                case 10:
                    MessageNano messageNano = (MessageNano) componentType.newInstance();
                    codedInputByteBufferNano.readGroup(messageNano, WireFormatNano.getTagFieldNumber(this.tag));
                    return messageNano;
                case 11:
                    MessageNano messageNano2 = (MessageNano) componentType.newInstance();
                    codedInputByteBufferNano.readMessage(messageNano2);
                    return messageNano2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: protected */
    public void readDataInto(UnknownFieldData unknownFieldData, List list) {
        list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
    }

    /* access modifiers changed from: protected */
    public void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                writeSingularData(obj2, codedOutputByteBufferNano);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        try {
            codedOutputByteBufferNano.writeRawVarint32(this.tag);
            switch (this.type) {
                case 10:
                    int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
                    codedOutputByteBufferNano.writeGroupNoTag((MessageNano) obj);
                    codedOutputByteBufferNano.writeTag(tagFieldNumber, 4);
                    return;
                case 11:
                    codedOutputByteBufferNano.writeMessageNoTag((MessageNano) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: package-private */
    public void writeTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        if (this.repeated) {
            writeRepeatedData(obj, codedOutputByteBufferNano);
        } else {
            writeSingularData(obj, codedOutputByteBufferNano);
        }
    }
}
