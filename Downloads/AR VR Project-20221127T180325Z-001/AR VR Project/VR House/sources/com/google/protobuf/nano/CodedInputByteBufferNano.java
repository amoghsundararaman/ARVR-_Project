package com.google.protobuf.nano;

public final class CodedInputByteBufferNano {
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int bufferStart;
    private int currentLimit = Integer.MAX_VALUE;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit = DEFAULT_RECURSION_LIMIT;
    private int sizeLimit = DEFAULT_SIZE_LIMIT;

    private CodedInputByteBufferNano(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bufferStart = i;
        this.bufferSize = i + i2;
        this.bufferPos = i;
    }

    public static int decodeZigZag32(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr, int i, int i2) {
        return new CodedInputByteBufferNano(bArr, i, i2);
    }

    private final void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        int i = this.bufferSize;
        if (i > this.currentLimit) {
            this.bufferSizeAfterLimit = i - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public final void checkLastTagWas(int i) {
        if (this.lastTag != i) {
            throw InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public final int getBytesUntilLimit() {
        if (this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        }
        return this.currentLimit - this.bufferPos;
    }

    public final byte[] getData(int i, int i2) {
        if (i2 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.bufferStart + i, bArr, 0, i2);
        return bArr;
    }

    public final int getPosition() {
        return this.bufferPos - this.bufferStart;
    }

    public final boolean isAtEnd() {
        return this.bufferPos == this.bufferSize;
    }

    public final void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public final int pushLimit(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos + i;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    public final boolean readBool() {
        return readRawVarint32() != 0;
    }

    public final byte[] readBytes() {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if (readRawVarint32 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        } else {
            if (readRawVarint32 > this.bufferSize - this.bufferPos) {
                throw InvalidProtocolBufferNanoException.truncatedMessage();
            }
            byte[] bArr = new byte[readRawVarint32];
            System.arraycopy(this.buffer, this.bufferPos, bArr, 0, readRawVarint32);
            this.bufferPos = readRawVarint32 + this.bufferPos;
            return bArr;
        }
    }

    public final double readDouble() {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public final int readEnum() {
        return readRawVarint32();
    }

    public final int readFixed32() {
        return readRawLittleEndian32();
    }

    public final long readFixed64() {
        return readRawLittleEndian64();
    }

    public final float readFloat() {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public final void readGroup(MessageNano messageNano, int i) {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        this.recursionDepth++;
        messageNano.mergeFrom(this);
        checkLastTagWas(WireFormatNano.makeTag(i, 4));
        this.recursionDepth--;
    }

    public final int readInt32() {
        return readRawVarint32();
    }

    public final long readInt64() {
        return readRawVarint64();
    }

    public final void readMessage(MessageNano messageNano) {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        messageNano.mergeFrom(this);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
    }

    public final byte readRawByte() {
        if (this.bufferPos == this.bufferSize) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public final byte[] readRawBytes(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if (this.bufferPos + i > this.currentLimit) {
            skipRawBytes(this.currentLimit - this.bufferPos);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else if (i > this.bufferSize - this.bufferPos) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.bufferPos, bArr, 0, i);
            this.bufferPos += i;
            return bArr;
        }
    }

    public final int readRawLittleEndian32() {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public final long readRawLittleEndian64() {
        byte readRawByte = readRawByte();
        byte readRawByte2 = readRawByte();
        return ((((long) readRawByte2) & 255) << 8) | (((long) readRawByte) & 255) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48) | ((((long) readRawByte()) & 255) << 56);
    }

    public final int readRawVarint32() {
        byte readRawByte = readRawByte();
        if (readRawByte >= 0) {
            return readRawByte;
        }
        byte b = readRawByte & Byte.MAX_VALUE;
        byte readRawByte2 = readRawByte();
        if (readRawByte2 >= 0) {
            return b | (readRawByte2 << 7);
        }
        byte b2 = b | ((readRawByte2 & Byte.MAX_VALUE) << 7);
        byte readRawByte3 = readRawByte();
        if (readRawByte3 >= 0) {
            return b2 | (readRawByte3 << 14);
        }
        byte b3 = b2 | ((readRawByte3 & Byte.MAX_VALUE) << 14);
        byte readRawByte4 = readRawByte();
        if (readRawByte4 >= 0) {
            return b3 | (readRawByte4 << 21);
        }
        byte b4 = b3 | ((readRawByte4 & Byte.MAX_VALUE) << 21);
        byte readRawByte5 = readRawByte();
        byte b5 = b4 | (readRawByte5 << 28);
        if (readRawByte5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (readRawByte() >= 0) {
                return b5;
            }
        }
        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public final long readRawVarint64() {
        long j = 0;
        for (int i = 0; i < DEFAULT_RECURSION_LIMIT; i += 7) {
            byte readRawByte = readRawByte();
            j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
            if ((readRawByte & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public final int readSFixed32() {
        return readRawLittleEndian32();
    }

    public final long readSFixed64() {
        return readRawLittleEndian64();
    }

    public final int readSInt32() {
        return decodeZigZag32(readRawVarint32());
    }

    public final long readSInt64() {
        return decodeZigZag64(readRawVarint64());
    }

    public final String readString() {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if (readRawVarint32 > this.bufferSize - this.bufferPos) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else {
            String str = new String(this.buffer, this.bufferPos, readRawVarint32, InternalNano.UTF_8);
            this.bufferPos = readRawVarint32 + this.bufferPos;
            return str;
        }
    }

    public final int readTag() {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readRawVarint32();
        if (this.lastTag != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferNanoException.invalidTag();
    }

    public final int readUInt32() {
        return readRawVarint32();
    }

    public final long readUInt64() {
        return readRawVarint64();
    }

    public final void resetSizeCounter() {
    }

    public final void rewindToPosition(int i) {
        if (i > this.bufferPos - this.bufferStart) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.bufferPos - this.bufferStart).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        } else {
            this.bufferPos = this.bufferStart + i;
        }
    }

    public final int setRecursionLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i;
        return i2;
    }

    public final int setSizeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(42).append("Size limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i;
        return i2;
    }

    public final boolean skipField(int i) {
        switch (WireFormatNano.getTagWireType(i)) {
            case 0:
                readInt32();
                return true;
            case 1:
                readRawLittleEndian64();
                return true;
            case 2:
                skipRawBytes(readRawVarint32());
                return true;
            case 3:
                skipMessage();
                checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                readRawLittleEndian32();
                return true;
            default:
                throw InvalidProtocolBufferNanoException.invalidWireType();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void skipMessage() {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.skipField(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.nano.CodedInputByteBufferNano.skipMessage():void");
    }

    public final void skipRawBytes(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if (this.bufferPos + i > this.currentLimit) {
            skipRawBytes(this.currentLimit - this.bufferPos);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else if (i <= this.bufferSize - this.bufferPos) {
            this.bufferPos += i;
        } else {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
    }
}
