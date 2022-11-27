package com.google.p000vr.sdk.proto.nano;

import com.google.common.logging.nano.C0003Vr;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* renamed from: com.google.vr.sdk.proto.nano.SdkConfiguration */
public class SdkConfiguration {
    private SdkConfiguration() {
    }

    /* renamed from: com.google.vr.sdk.proto.nano.SdkConfiguration$SdkConfigurationRequest */
    public static final class SdkConfigurationRequest extends ExtendableMessageNano<SdkConfigurationRequest> implements Cloneable {
        private static volatile SdkConfigurationRequest[] _emptyArray;
        public C0003Vr.VREvent.SdkConfigurationParams requestedParams;
        public String sdkVersion;

        public static SdkConfigurationRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SdkConfigurationRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SdkConfigurationRequest() {
            clear();
        }

        public final SdkConfigurationRequest clear() {
            this.sdkVersion = null;
            this.requestedParams = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final SdkConfigurationRequest clone() {
            try {
                SdkConfigurationRequest sdkConfigurationRequest = (SdkConfigurationRequest) super.clone();
                if (this.requestedParams != null) {
                    sdkConfigurationRequest.requestedParams = this.requestedParams.clone();
                }
                return sdkConfigurationRequest;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.sdkVersion != null) {
                codedOutputByteBufferNano.writeString(1, this.sdkVersion);
            }
            if (this.requestedParams != null) {
                codedOutputByteBufferNano.writeMessage(2, this.requestedParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.sdkVersion != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.sdkVersion);
            }
            if (this.requestedParams != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, this.requestedParams);
            }
            return computeSerializedSize;
        }

        public final SdkConfigurationRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        this.sdkVersion = codedInputByteBufferNano.readString();
                        continue;
                    case 18:
                        if (this.requestedParams == null) {
                            this.requestedParams = new C0003Vr.VREvent.SdkConfigurationParams();
                        }
                        codedInputByteBufferNano.readMessage(this.requestedParams);
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

        public static SdkConfigurationRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (SdkConfigurationRequest) MessageNano.mergeFrom(new SdkConfigurationRequest(), bArr);
        }

        public static SdkConfigurationRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new SdkConfigurationRequest().mergeFrom(codedInputByteBufferNano);
        }
    }
}
