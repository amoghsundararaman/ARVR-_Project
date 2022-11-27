package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

public abstract class MessageNano {
    public static final int UNSET_ENUM_VALUE = Integer.MIN_VALUE;
    protected volatile int cachedSize = -1;

    public static final MessageNano mergeFrom(MessageNano messageNano, byte[] bArr) {
        return mergeFrom(messageNano, bArr, 0, bArr.length);
    }

    public static final MessageNano mergeFrom(MessageNano messageNano, byte[] bArr, int i, int i2) {
        try {
            CodedInputByteBufferNano newInstance = CodedInputByteBufferNano.newInstance(bArr, i, i2);
            messageNano.mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return messageNano;
        } catch (InvalidProtocolBufferNanoException e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(MessageNano messageNano, MessageNano messageNano2) {
        int serializedSize;
        if (messageNano == messageNano2) {
            return true;
        }
        if (messageNano == null || messageNano2 == null || messageNano.getClass() != messageNano2.getClass() || messageNano2.getSerializedSize() != (serializedSize = messageNano.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(messageNano, bArr, 0, serializedSize);
        toByteArray(messageNano2, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final void toByteArray(MessageNano messageNano, byte[] bArr, int i, int i2) {
        try {
            CodedOutputByteBufferNano newInstance = CodedOutputByteBufferNano.newInstance(bArr, i, i2);
            messageNano.writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] toByteArray(MessageNano messageNano) {
        byte[] bArr = new byte[messageNano.getSerializedSize()];
        toByteArray(messageNano, bArr, 0, bArr.length);
        return bArr;
    }

    public MessageNano clone() {
        return (MessageNano) super.clone();
    }

    /* access modifiers changed from: protected */
    public int computeSerializedSize() {
        return 0;
    }

    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getSerializedSize() {
        int computeSerializedSize = computeSerializedSize();
        this.cachedSize = computeSerializedSize;
        return computeSerializedSize;
    }

    public abstract MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano);

    public String toString() {
        return MessageNanoPrinter.print(this);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
    }
}
