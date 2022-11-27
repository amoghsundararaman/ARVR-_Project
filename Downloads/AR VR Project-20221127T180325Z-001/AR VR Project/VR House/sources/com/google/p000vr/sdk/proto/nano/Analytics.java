package com.google.p000vr.sdk.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* renamed from: com.google.vr.sdk.proto.nano.Analytics */
public class Analytics {
    private Analytics() {
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AsyncReprojectionAnalytics */
    public static final class AsyncReprojectionAnalytics extends ExtendableMessageNano<AsyncReprojectionAnalytics> implements Cloneable {
        private static volatile AsyncReprojectionAnalytics[] _emptyArray;
        private int bitField0_;
        private float fps_;
        private int totalMissedVsyncs_;
        public VsyncStatus[] vsyncStatus;

        public static AsyncReprojectionAnalytics[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AsyncReprojectionAnalytics[0];
                    }
                }
            }
            return _emptyArray;
        }

        /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AsyncReprojectionAnalytics$VsyncStatus */
        public static final class VsyncStatus extends ExtendableMessageNano<VsyncStatus> implements Cloneable {
            private static volatile VsyncStatus[] _emptyArray;
            private int bitField0_;
            private MissedVsync missedVsync;
            private NewAppFrame newAppFrame;
            private int oneof_Status_ = -1;
            private ReusedAppFrame reusedAppFrame;
            private long timestampNanoseconds_;

            public static VsyncStatus[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new VsyncStatus[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AsyncReprojectionAnalytics$VsyncStatus$MissedVsync */
            public static final class MissedVsync extends ExtendableMessageNano<MissedVsync> implements Cloneable {
                private static volatile MissedVsync[] _emptyArray;

                public static MissedVsync[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new MissedVsync[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public MissedVsync() {
                    clear();
                }

                public final MissedVsync clear() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final MissedVsync clone() {
                    try {
                        return (MissedVsync) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final MissedVsync mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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

                public static MissedVsync parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                    return (MissedVsync) MessageNano.mergeFrom(new MissedVsync(), bArr);
                }

                public static MissedVsync parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    return new MissedVsync().mergeFrom(codedInputByteBufferNano);
                }
            }

            /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AsyncReprojectionAnalytics$VsyncStatus$NewAppFrame */
            public static final class NewAppFrame extends ExtendableMessageNano<NewAppFrame> implements Cloneable {
                private static volatile NewAppFrame[] _emptyArray;
                private int bitField0_;
                private int numSkippedAppFrames_;
                private long sinceSubmitNanoseconds_;

                public static NewAppFrame[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new NewAppFrame[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public final long getSinceSubmitNanoseconds() {
                    return this.sinceSubmitNanoseconds_;
                }

                public final boolean hasSinceSubmitNanoseconds() {
                    return (this.bitField0_ & 1) != 0;
                }

                public final NewAppFrame clearSinceSubmitNanoseconds() {
                    this.sinceSubmitNanoseconds_ = 0;
                    this.bitField0_ &= -2;
                    return this;
                }

                public final NewAppFrame setSinceSubmitNanoseconds(long j) {
                    this.bitField0_ |= 1;
                    this.sinceSubmitNanoseconds_ = j;
                    return this;
                }

                public final int getNumSkippedAppFrames() {
                    return this.numSkippedAppFrames_;
                }

                public final boolean hasNumSkippedAppFrames() {
                    return (this.bitField0_ & 2) != 0;
                }

                public final NewAppFrame clearNumSkippedAppFrames() {
                    this.numSkippedAppFrames_ = 0;
                    this.bitField0_ &= -3;
                    return this;
                }

                public final NewAppFrame setNumSkippedAppFrames(int i) {
                    this.bitField0_ |= 2;
                    this.numSkippedAppFrames_ = i;
                    return this;
                }

                public NewAppFrame() {
                    clear();
                }

                public final NewAppFrame clear() {
                    this.bitField0_ = 0;
                    this.sinceSubmitNanoseconds_ = 0;
                    this.numSkippedAppFrames_ = 0;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final NewAppFrame clone() {
                    try {
                        return (NewAppFrame) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if ((this.bitField0_ & 1) != 0) {
                        codedOutputByteBufferNano.writeInt64(1, this.sinceSubmitNanoseconds_);
                    }
                    if ((this.bitField0_ & 2) != 0) {
                        codedOutputByteBufferNano.writeInt32(2, this.numSkippedAppFrames_);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if ((this.bitField0_ & 1) != 0) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.sinceSubmitNanoseconds_);
                    }
                    if ((this.bitField0_ & 2) != 0) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.numSkippedAppFrames_);
                    }
                    return computeSerializedSize;
                }

                public final NewAppFrame mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.sinceSubmitNanoseconds_ = codedInputByteBufferNano.readInt64();
                                this.bitField0_ |= 1;
                                continue;
                            case 16:
                                this.numSkippedAppFrames_ = codedInputByteBufferNano.readInt32();
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

                public static NewAppFrame parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                    return (NewAppFrame) MessageNano.mergeFrom(new NewAppFrame(), bArr);
                }

                public static NewAppFrame parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    return new NewAppFrame().mergeFrom(codedInputByteBufferNano);
                }
            }

            /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AsyncReprojectionAnalytics$VsyncStatus$ReusedAppFrame */
            public static final class ReusedAppFrame extends ExtendableMessageNano<ReusedAppFrame> implements Cloneable {
                private static volatile ReusedAppFrame[] _emptyArray;
                private int bitField0_;
                private long sinceSubmitNanoseconds_;

                public static ReusedAppFrame[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new ReusedAppFrame[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public final long getSinceSubmitNanoseconds() {
                    return this.sinceSubmitNanoseconds_;
                }

                public final boolean hasSinceSubmitNanoseconds() {
                    return (this.bitField0_ & 1) != 0;
                }

                public final ReusedAppFrame clearSinceSubmitNanoseconds() {
                    this.sinceSubmitNanoseconds_ = 0;
                    this.bitField0_ &= -2;
                    return this;
                }

                public final ReusedAppFrame setSinceSubmitNanoseconds(long j) {
                    this.bitField0_ |= 1;
                    this.sinceSubmitNanoseconds_ = j;
                    return this;
                }

                public ReusedAppFrame() {
                    clear();
                }

                public final ReusedAppFrame clear() {
                    this.bitField0_ = 0;
                    this.sinceSubmitNanoseconds_ = 0;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ReusedAppFrame clone() {
                    try {
                        return (ReusedAppFrame) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if ((this.bitField0_ & 1) != 0) {
                        codedOutputByteBufferNano.writeInt64(1, this.sinceSubmitNanoseconds_);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if ((this.bitField0_ & 1) != 0) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, this.sinceSubmitNanoseconds_);
                    }
                    return computeSerializedSize;
                }

                public final ReusedAppFrame mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.sinceSubmitNanoseconds_ = codedInputByteBufferNano.readInt64();
                                this.bitField0_ |= 1;
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

                public static ReusedAppFrame parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                    return (ReusedAppFrame) MessageNano.mergeFrom(new ReusedAppFrame(), bArr);
                }

                public static ReusedAppFrame parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    return new ReusedAppFrame().mergeFrom(codedInputByteBufferNano);
                }
            }

            public final long getTimestampNanoseconds() {
                return this.timestampNanoseconds_;
            }

            public final boolean hasTimestampNanoseconds() {
                return (this.bitField0_ & 1) != 0;
            }

            public final VsyncStatus clearTimestampNanoseconds() {
                this.timestampNanoseconds_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final VsyncStatus setTimestampNanoseconds(long j) {
                this.bitField0_ |= 1;
                this.timestampNanoseconds_ = j;
                return this;
            }

            public final NewAppFrame getNewAppFrame() {
                if (this.oneof_Status_ == 0) {
                    return this.newAppFrame;
                }
                return null;
            }

            public final boolean hasNewAppFrame() {
                return this.oneof_Status_ == 0;
            }

            public final VsyncStatus setNewAppFrame(NewAppFrame newAppFrame2) {
                if (newAppFrame2 == null) {
                    if (this.oneof_Status_ == 0) {
                        this.oneof_Status_ = -1;
                    }
                    this.newAppFrame = null;
                } else {
                    this.oneof_Status_ = -1;
                    this.oneof_Status_ = 0;
                    this.newAppFrame = newAppFrame2;
                }
                return this;
            }

            public final ReusedAppFrame getReusedAppFrame() {
                if (this.oneof_Status_ == 1) {
                    return this.reusedAppFrame;
                }
                return null;
            }

            public final boolean hasReusedAppFrame() {
                return this.oneof_Status_ == 1;
            }

            public final VsyncStatus setReusedAppFrame(ReusedAppFrame reusedAppFrame2) {
                if (reusedAppFrame2 == null) {
                    if (this.oneof_Status_ == 1) {
                        this.oneof_Status_ = -1;
                    }
                    this.reusedAppFrame = null;
                } else {
                    this.oneof_Status_ = -1;
                    this.oneof_Status_ = 1;
                    this.reusedAppFrame = reusedAppFrame2;
                }
                return this;
            }

            public final MissedVsync getMissedVsync() {
                if (this.oneof_Status_ == 2) {
                    return this.missedVsync;
                }
                return null;
            }

            public final boolean hasMissedVsync() {
                return this.oneof_Status_ == 2;
            }

            public final VsyncStatus setMissedVsync(MissedVsync missedVsync2) {
                if (missedVsync2 == null) {
                    if (this.oneof_Status_ == 2) {
                        this.oneof_Status_ = -1;
                    }
                    this.missedVsync = null;
                } else {
                    this.oneof_Status_ = -1;
                    this.oneof_Status_ = 2;
                    this.missedVsync = missedVsync2;
                }
                return this;
            }

            public VsyncStatus() {
                clear();
            }

            public final VsyncStatus clear() {
                this.bitField0_ = 0;
                this.timestampNanoseconds_ = 0;
                this.oneof_Status_ = -1;
                this.newAppFrame = null;
                this.oneof_Status_ = -1;
                this.reusedAppFrame = null;
                this.oneof_Status_ = -1;
                this.missedVsync = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final VsyncStatus clone() {
                try {
                    VsyncStatus vsyncStatus = (VsyncStatus) super.clone();
                    if (this.newAppFrame != null) {
                        vsyncStatus.newAppFrame = this.newAppFrame.clone();
                    }
                    if (this.reusedAppFrame != null) {
                        vsyncStatus.reusedAppFrame = this.reusedAppFrame.clone();
                    }
                    if (this.missedVsync != null) {
                        vsyncStatus.missedVsync = this.missedVsync.clone();
                    }
                    return vsyncStatus;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputByteBufferNano.writeInt64(1, this.timestampNanoseconds_);
                }
                if (this.oneof_Status_ == 0) {
                    codedOutputByteBufferNano.writeMessage(2, this.newAppFrame);
                }
                if (this.oneof_Status_ == 1) {
                    codedOutputByteBufferNano.writeMessage(3, this.reusedAppFrame);
                }
                if (this.oneof_Status_ == 2) {
                    codedOutputByteBufferNano.writeMessage(4, this.missedVsync);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if ((this.bitField0_ & 1) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNanoseconds_);
                }
                if (this.oneof_Status_ == 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.newAppFrame);
                }
                if (this.oneof_Status_ == 1) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.reusedAppFrame);
                }
                if (this.oneof_Status_ == 2) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.missedVsync);
                }
                return computeSerializedSize;
            }

            public final VsyncStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.timestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                            this.bitField0_ |= 1;
                            continue;
                        case 18:
                            if (this.newAppFrame == null) {
                                this.newAppFrame = new NewAppFrame();
                            }
                            codedInputByteBufferNano.readMessage(this.newAppFrame);
                            this.oneof_Status_ = 0;
                            continue;
                        case 26:
                            if (this.reusedAppFrame == null) {
                                this.reusedAppFrame = new ReusedAppFrame();
                            }
                            codedInputByteBufferNano.readMessage(this.reusedAppFrame);
                            this.oneof_Status_ = 1;
                            continue;
                        case 34:
                            if (this.missedVsync == null) {
                                this.missedVsync = new MissedVsync();
                            }
                            codedInputByteBufferNano.readMessage(this.missedVsync);
                            this.oneof_Status_ = 2;
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

            public static VsyncStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (VsyncStatus) MessageNano.mergeFrom(new VsyncStatus(), bArr);
            }

            public static VsyncStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new VsyncStatus().mergeFrom(codedInputByteBufferNano);
            }
        }

        public final int getTotalMissedVsyncs() {
            return this.totalMissedVsyncs_;
        }

        public final boolean hasTotalMissedVsyncs() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AsyncReprojectionAnalytics clearTotalMissedVsyncs() {
            this.totalMissedVsyncs_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final AsyncReprojectionAnalytics setTotalMissedVsyncs(int i) {
            this.bitField0_ |= 1;
            this.totalMissedVsyncs_ = i;
            return this;
        }

        public final float getFps() {
            return this.fps_;
        }

        public final boolean hasFps() {
            return (this.bitField0_ & 2) != 0;
        }

        public final AsyncReprojectionAnalytics clearFps() {
            this.fps_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final AsyncReprojectionAnalytics setFps(float f) {
            this.bitField0_ |= 2;
            this.fps_ = f;
            return this;
        }

        public AsyncReprojectionAnalytics() {
            clear();
        }

        public final AsyncReprojectionAnalytics clear() {
            this.bitField0_ = 0;
            this.totalMissedVsyncs_ = 0;
            this.fps_ = 0.0f;
            this.vsyncStatus = VsyncStatus.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AsyncReprojectionAnalytics clone() {
            try {
                AsyncReprojectionAnalytics asyncReprojectionAnalytics = (AsyncReprojectionAnalytics) super.clone();
                if (this.vsyncStatus != null && this.vsyncStatus.length > 0) {
                    asyncReprojectionAnalytics.vsyncStatus = new VsyncStatus[this.vsyncStatus.length];
                    for (int i = 0; i < this.vsyncStatus.length; i++) {
                        if (this.vsyncStatus[i] != null) {
                            asyncReprojectionAnalytics.vsyncStatus[i] = this.vsyncStatus[i].clone();
                        }
                    }
                }
                return asyncReprojectionAnalytics;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(1, this.totalMissedVsyncs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.fps_);
            }
            if (this.vsyncStatus != null && this.vsyncStatus.length > 0) {
                for (VsyncStatus vsyncStatus2 : this.vsyncStatus) {
                    if (vsyncStatus2 != null) {
                        codedOutputByteBufferNano.writeMessage(3, vsyncStatus2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.totalMissedVsyncs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.fps_);
            }
            if (this.vsyncStatus == null || this.vsyncStatus.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (VsyncStatus vsyncStatus2 : this.vsyncStatus) {
                if (vsyncStatus2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(3, vsyncStatus2);
                }
            }
            return i;
        }

        public final AsyncReprojectionAnalytics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.totalMissedVsyncs_ = codedInputByteBufferNano.readInt32();
                        this.bitField0_ |= 1;
                        continue;
                    case 21:
                        this.fps_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 2;
                        continue;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        int length = this.vsyncStatus == null ? 0 : this.vsyncStatus.length;
                        VsyncStatus[] vsyncStatusArr = new VsyncStatus[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.vsyncStatus, 0, vsyncStatusArr, 0, length);
                        }
                        while (length < vsyncStatusArr.length - 1) {
                            vsyncStatusArr[length] = new VsyncStatus();
                            codedInputByteBufferNano.readMessage(vsyncStatusArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        vsyncStatusArr[length] = new VsyncStatus();
                        codedInputByteBufferNano.readMessage(vsyncStatusArr[length]);
                        this.vsyncStatus = vsyncStatusArr;
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

        public static AsyncReprojectionAnalytics parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (AsyncReprojectionAnalytics) MessageNano.mergeFrom(new AsyncReprojectionAnalytics(), bArr);
        }

        public static AsyncReprojectionAnalytics parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AsyncReprojectionAnalytics().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AppAnalytics */
    public static final class AppAnalytics extends ExtendableMessageNano<AppAnalytics> implements Cloneable {
        private static volatile AppAnalytics[] _emptyArray;
        private int bitField0_;
        private float fps_;
        public SubmitStatus[] submitStatus;

        public static AppAnalytics[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppAnalytics[0];
                    }
                }
            }
            return _emptyArray;
        }

        /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AppAnalytics$SubmitStatus */
        public static final class SubmitStatus extends ExtendableMessageNano<SubmitStatus> implements Cloneable {
            private static volatile SubmitStatus[] _emptyArray;
            private int bitField0_;
            private long timestampNanoseconds_;
            private boolean wasBlockedOnGpu_;

            public static SubmitStatus[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new SubmitStatus[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public final long getTimestampNanoseconds() {
                return this.timestampNanoseconds_;
            }

            public final boolean hasTimestampNanoseconds() {
                return (this.bitField0_ & 1) != 0;
            }

            public final SubmitStatus clearTimestampNanoseconds() {
                this.timestampNanoseconds_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final SubmitStatus setTimestampNanoseconds(long j) {
                this.bitField0_ |= 1;
                this.timestampNanoseconds_ = j;
                return this;
            }

            public final boolean getWasBlockedOnGpu() {
                return this.wasBlockedOnGpu_;
            }

            public final boolean hasWasBlockedOnGpu() {
                return (this.bitField0_ & 2) != 0;
            }

            public final SubmitStatus clearWasBlockedOnGpu() {
                this.wasBlockedOnGpu_ = false;
                this.bitField0_ &= -3;
                return this;
            }

            public final SubmitStatus setWasBlockedOnGpu(boolean z) {
                this.bitField0_ |= 2;
                this.wasBlockedOnGpu_ = z;
                return this;
            }

            public SubmitStatus() {
                clear();
            }

            public final SubmitStatus clear() {
                this.bitField0_ = 0;
                this.timestampNanoseconds_ = 0;
                this.wasBlockedOnGpu_ = false;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final SubmitStatus clone() {
                try {
                    return (SubmitStatus) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputByteBufferNano.writeInt64(1, this.timestampNanoseconds_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputByteBufferNano.writeBool(2, this.wasBlockedOnGpu_);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if ((this.bitField0_ & 1) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNanoseconds_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.wasBlockedOnGpu_);
                }
                return computeSerializedSize;
            }

            public final SubmitStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.timestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                            this.bitField0_ |= 1;
                            continue;
                        case 16:
                            this.wasBlockedOnGpu_ = codedInputByteBufferNano.readBool();
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

            public static SubmitStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (SubmitStatus) MessageNano.mergeFrom(new SubmitStatus(), bArr);
            }

            public static SubmitStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new SubmitStatus().mergeFrom(codedInputByteBufferNano);
            }
        }

        public final float getFps() {
            return this.fps_;
        }

        public final boolean hasFps() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AppAnalytics clearFps() {
            this.fps_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final AppAnalytics setFps(float f) {
            this.bitField0_ |= 1;
            this.fps_ = f;
            return this;
        }

        public AppAnalytics() {
            clear();
        }

        public final AppAnalytics clear() {
            this.bitField0_ = 0;
            this.fps_ = 0.0f;
            this.submitStatus = SubmitStatus.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AppAnalytics clone() {
            try {
                AppAnalytics appAnalytics = (AppAnalytics) super.clone();
                if (this.submitStatus != null && this.submitStatus.length > 0) {
                    appAnalytics.submitStatus = new SubmitStatus[this.submitStatus.length];
                    for (int i = 0; i < this.submitStatus.length; i++) {
                        if (this.submitStatus[i] != null) {
                            appAnalytics.submitStatus[i] = this.submitStatus[i].clone();
                        }
                    }
                }
                return appAnalytics;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.fps_);
            }
            if (this.submitStatus != null && this.submitStatus.length > 0) {
                for (SubmitStatus submitStatus2 : this.submitStatus) {
                    if (submitStatus2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, submitStatus2);
                    }
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.fps_);
            }
            if (this.submitStatus == null || this.submitStatus.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (SubmitStatus submitStatus2 : this.submitStatus) {
                if (submitStatus2 != null) {
                    i += CodedOutputByteBufferNano.computeMessageSize(2, submitStatus2);
                }
            }
            return i;
        }

        public final AppAnalytics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 13:
                        this.fps_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        int length = this.submitStatus == null ? 0 : this.submitStatus.length;
                        SubmitStatus[] submitStatusArr = new SubmitStatus[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.submitStatus, 0, submitStatusArr, 0, length);
                        }
                        while (length < submitStatusArr.length - 1) {
                            submitStatusArr[length] = new SubmitStatus();
                            codedInputByteBufferNano.readMessage(submitStatusArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        submitStatusArr[length] = new SubmitStatus();
                        codedInputByteBufferNano.readMessage(submitStatusArr[length]);
                        this.submitStatus = submitStatusArr;
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

        public static AppAnalytics parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (AppAnalytics) MessageNano.mergeFrom(new AppAnalytics(), bArr);
        }

        public static AppAnalytics parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AppAnalytics().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AnalyticsRequest */
    public static final class AnalyticsRequest extends ExtendableMessageNano<AnalyticsRequest> implements Cloneable {
        private static volatile AnalyticsRequest[] _emptyArray;
        private int bitField0_;
        private long prevSampleTimestampNanoseconds_;

        public static AnalyticsRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AnalyticsRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final long getPrevSampleTimestampNanoseconds() {
            return this.prevSampleTimestampNanoseconds_;
        }

        public final boolean hasPrevSampleTimestampNanoseconds() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AnalyticsRequest clearPrevSampleTimestampNanoseconds() {
            this.prevSampleTimestampNanoseconds_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final AnalyticsRequest setPrevSampleTimestampNanoseconds(long j) {
            this.bitField0_ |= 1;
            this.prevSampleTimestampNanoseconds_ = j;
            return this;
        }

        public AnalyticsRequest() {
            clear();
        }

        public final AnalyticsRequest clear() {
            this.bitField0_ = 0;
            this.prevSampleTimestampNanoseconds_ = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AnalyticsRequest clone() {
            try {
                return (AnalyticsRequest) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.prevSampleTimestampNanoseconds_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, this.prevSampleTimestampNanoseconds_);
            }
            return computeSerializedSize;
        }

        public final AnalyticsRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.prevSampleTimestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
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

        public static AnalyticsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (AnalyticsRequest) MessageNano.mergeFrom(new AnalyticsRequest(), bArr);
        }

        public static AnalyticsRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AnalyticsRequest().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Analytics$AnalyticsSample */
    public static final class AnalyticsSample extends ExtendableMessageNano<AnalyticsSample> implements Cloneable {
        private static volatile AnalyticsSample[] _emptyArray;
        public AppAnalytics appAnalytics;
        public AsyncReprojectionAnalytics asyncReprojectionAnalytics;
        private int bitField0_;
        private long timestampNanoseconds_;

        public static AnalyticsSample[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AnalyticsSample[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final long getTimestampNanoseconds() {
            return this.timestampNanoseconds_;
        }

        public final boolean hasTimestampNanoseconds() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AnalyticsSample clearTimestampNanoseconds() {
            this.timestampNanoseconds_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final AnalyticsSample setTimestampNanoseconds(long j) {
            this.bitField0_ |= 1;
            this.timestampNanoseconds_ = j;
            return this;
        }

        public AnalyticsSample() {
            clear();
        }

        public final AnalyticsSample clear() {
            this.bitField0_ = 0;
            this.timestampNanoseconds_ = 0;
            this.asyncReprojectionAnalytics = null;
            this.appAnalytics = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AnalyticsSample clone() {
            try {
                AnalyticsSample analyticsSample = (AnalyticsSample) super.clone();
                if (this.asyncReprojectionAnalytics != null) {
                    analyticsSample.asyncReprojectionAnalytics = this.asyncReprojectionAnalytics.clone();
                }
                if (this.appAnalytics != null) {
                    analyticsSample.appAnalytics = this.appAnalytics.clone();
                }
                return analyticsSample;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.timestampNanoseconds_);
            }
            if (this.asyncReprojectionAnalytics != null) {
                codedOutputByteBufferNano.writeMessage(2, this.asyncReprojectionAnalytics);
            }
            if (this.appAnalytics != null) {
                codedOutputByteBufferNano.writeMessage(3, this.appAnalytics);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNanoseconds_);
            }
            if (this.asyncReprojectionAnalytics != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.asyncReprojectionAnalytics);
            }
            if (this.appAnalytics != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, this.appAnalytics);
            }
            return computeSerializedSize;
        }

        public final AnalyticsSample mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.timestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        if (this.asyncReprojectionAnalytics == null) {
                            this.asyncReprojectionAnalytics = new AsyncReprojectionAnalytics();
                        }
                        codedInputByteBufferNano.readMessage(this.asyncReprojectionAnalytics);
                        continue;
                    case 26:
                        if (this.appAnalytics == null) {
                            this.appAnalytics = new AppAnalytics();
                        }
                        codedInputByteBufferNano.readMessage(this.appAnalytics);
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

        public static AnalyticsSample parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (AnalyticsSample) MessageNano.mergeFrom(new AnalyticsSample(), bArr);
        }

        public static AnalyticsSample parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AnalyticsSample().mergeFrom(codedInputByteBufferNano);
        }
    }
}
