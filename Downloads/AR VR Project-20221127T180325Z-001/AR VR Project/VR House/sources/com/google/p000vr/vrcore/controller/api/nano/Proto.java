package com.google.p000vr.vrcore.controller.api.nano;

import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* renamed from: com.google.vr.vrcore.controller.api.nano.Proto */
public class Proto {
    private Proto() {
    }

    /* renamed from: com.google.vr.vrcore.controller.api.nano.Proto$Request */
    public static final class Request extends ExtendableMessageNano<Request> implements Cloneable {
        private static volatile Request[] _emptyArray;
        public Vibration vibration;

        public static Request[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Request[0];
                    }
                }
            }
            return _emptyArray;
        }

        /* renamed from: com.google.vr.vrcore.controller.api.nano.Proto$Request$Vibration */
        public static final class Vibration extends ExtendableMessageNano<Vibration> implements Cloneable {
            private static volatile Vibration[] _emptyArray;
            private int bitField0_;
            private int durationMs_;
            private int frequencyHz_;
            private int volumePercentage_;

            public static Vibration[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Vibration[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public final int getFrequencyHz() {
                return this.frequencyHz_;
            }

            public final boolean hasFrequencyHz() {
                return (this.bitField0_ & 1) != 0;
            }

            public final Vibration clearFrequencyHz() {
                this.frequencyHz_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final Vibration setFrequencyHz(int i) {
                this.bitField0_ |= 1;
                this.frequencyHz_ = i;
                return this;
            }

            public final int getVolumePercentage() {
                return this.volumePercentage_;
            }

            public final boolean hasVolumePercentage() {
                return (this.bitField0_ & 2) != 0;
            }

            public final Vibration clearVolumePercentage() {
                this.volumePercentage_ = 0;
                this.bitField0_ &= -3;
                return this;
            }

            public final Vibration setVolumePercentage(int i) {
                this.bitField0_ |= 2;
                this.volumePercentage_ = i;
                return this;
            }

            public final int getDurationMs() {
                return this.durationMs_;
            }

            public final boolean hasDurationMs() {
                return (this.bitField0_ & 4) != 0;
            }

            public final Vibration clearDurationMs() {
                this.durationMs_ = 0;
                this.bitField0_ &= -5;
                return this;
            }

            public final Vibration setDurationMs(int i) {
                this.bitField0_ |= 4;
                this.durationMs_ = i;
                return this;
            }

            public Vibration() {
                clear();
            }

            public final Vibration clear() {
                this.bitField0_ = 0;
                this.frequencyHz_ = 0;
                this.volumePercentage_ = 0;
                this.durationMs_ = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vibration clone() {
                try {
                    return (Vibration) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputByteBufferNano.writeInt32(1, this.frequencyHz_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputByteBufferNano.writeInt32(2, this.volumePercentage_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    codedOutputByteBufferNano.writeInt32(3, this.durationMs_);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if ((this.bitField0_ & 1) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.frequencyHz_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.volumePercentage_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.durationMs_);
                }
                return computeSerializedSize;
            }

            public final Vibration mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.frequencyHz_ = codedInputByteBufferNano.readInt32();
                            this.bitField0_ |= 1;
                            continue;
                        case 16:
                            this.volumePercentage_ = codedInputByteBufferNano.readInt32();
                            this.bitField0_ |= 2;
                            continue;
                        case AndroidNCompat.N_SDK_LEVEL:
                            this.durationMs_ = codedInputByteBufferNano.readInt32();
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

            public static Vibration parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (Vibration) MessageNano.mergeFrom(new Vibration(), bArr);
            }

            public static Vibration parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new Vibration().mergeFrom(codedInputByteBufferNano);
            }
        }

        public Request() {
            clear();
        }

        public final Request clear() {
            this.vibration = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final Request clone() {
            try {
                Request request = (Request) super.clone();
                if (this.vibration != null) {
                    request.vibration = this.vibration.clone();
                }
                return request;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.vibration != null) {
                codedOutputByteBufferNano.writeMessage(1, this.vibration);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.vibration != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, this.vibration);
            }
            return computeSerializedSize;
        }

        public final Request mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        if (this.vibration == null) {
                            this.vibration = new Vibration();
                        }
                        codedInputByteBufferNano.readMessage(this.vibration);
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

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (Request) MessageNano.mergeFrom(new Request(), bArr);
        }

        public static Request parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Request().mergeFrom(codedInputByteBufferNano);
        }
    }
}
