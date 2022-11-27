package com.google.common.logging.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

public class VrBaseOuterClass {

    public static final class VrBase extends ExtendableMessageNano<VrBase> implements Cloneable {
        public VrBase() {
            clear();
        }

        public static final class HeadMount extends ExtendableMessageNano<HeadMount> implements Cloneable {
            public String model;
            public String vendor;

            public HeadMount() {
                clear();
            }

            public final HeadMount clear() {
                this.vendor = null;
                this.model = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final HeadMount clone() {
                try {
                    return (HeadMount) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.vendor != null) {
                    codedOutputByteBufferNano.writeString(1, this.vendor);
                }
                if (this.model != null) {
                    codedOutputByteBufferNano.writeString(2, this.model);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.vendor != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.vendor);
                }
                if (this.model != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.model);
                }
                return computeSerializedSize;
            }

            public final HeadMount mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.vendor = codedInputByteBufferNano.readString();
                            continue;
                        case 18:
                            this.model = codedInputByteBufferNano.readString();
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
        }

        public final VrBase clear() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final VrBase clone() {
            try {
                return (VrBase) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final VrBase mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int readTag;
            do {
                readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                }
                return this;
            } while (super.storeUnknownField(codedInputByteBufferNano, readTag));
            return this;
        }
    }
}
