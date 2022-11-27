package com.google.protobuf.nano;

public abstract class ExtendableMessageNano extends MessageNano {
    protected FieldArray unknownFieldData;

    public ExtendableMessageNano clone() {
        ExtendableMessageNano extendableMessageNano = (ExtendableMessageNano) super.clone();
        InternalNano.cloneUnknownFieldData(this, extendableMessageNano);
        return extendableMessageNano;
    }

    /* access modifiers changed from: protected */
    public int computeSerializedSize() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.unknownFieldData.size(); i2++) {
            i += this.unknownFieldData.dataAt(i2).computeSerializedSize();
        }
        return i;
    }

    public final Object getExtension(Extension extension) {
        FieldData fieldData;
        if (this.unknownFieldData == null || (fieldData = this.unknownFieldData.get(WireFormatNano.getTagFieldNumber(extension.tag))) == null) {
            return null;
        }
        return fieldData.getValue(extension);
    }

    public final FieldArray getUnknownFieldArray() {
        return this.unknownFieldData;
    }

    public final boolean hasExtension(Extension extension) {
        return (this.unknownFieldData == null || this.unknownFieldData.get(WireFormatNano.getTagFieldNumber(extension.tag)) == null) ? false : true;
    }

    public final ExtendableMessageNano setExtension(Extension extension, Object obj) {
        FieldData fieldData = null;
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(extension.tag);
        if (obj != null) {
            if (this.unknownFieldData == null) {
                this.unknownFieldData = new FieldArray();
            } else {
                fieldData = this.unknownFieldData.get(tagFieldNumber);
            }
            if (fieldData == null) {
                this.unknownFieldData.put(tagFieldNumber, new FieldData(extension, obj));
            } else {
                fieldData.setValue(extension, obj);
            }
        } else if (this.unknownFieldData != null) {
            this.unknownFieldData.remove(tagFieldNumber);
            if (this.unknownFieldData.isEmpty()) {
                this.unknownFieldData = null;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public final boolean storeUnknownField(CodedInputByteBufferNano codedInputByteBufferNano, int i) {
        int position = codedInputByteBufferNano.getPosition();
        if (!codedInputByteBufferNano.skipField(i)) {
            return false;
        }
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(i);
        UnknownFieldData unknownFieldData2 = new UnknownFieldData(i, codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position));
        FieldData fieldData = null;
        if (this.unknownFieldData == null) {
            this.unknownFieldData = new FieldArray();
        } else {
            fieldData = this.unknownFieldData.get(tagFieldNumber);
        }
        if (fieldData == null) {
            fieldData = new FieldData();
            this.unknownFieldData.put(tagFieldNumber, fieldData);
        }
        fieldData.addUnknownField(unknownFieldData2);
        return true;
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
        if (this.unknownFieldData != null) {
            for (int i = 0; i < this.unknownFieldData.size(); i++) {
                this.unknownFieldData.dataAt(i).writeTo(codedOutputByteBufferNano);
            }
        }
    }
}
