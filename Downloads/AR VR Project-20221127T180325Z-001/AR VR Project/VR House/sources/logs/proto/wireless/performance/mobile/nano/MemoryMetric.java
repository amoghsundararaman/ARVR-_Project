package logs.proto.wireless.performance.mobile.nano;

import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

public class MemoryMetric {

    public static final class AndroidMemoryStats extends ExtendableMessageNano<AndroidMemoryStats> implements Cloneable {
        public Integer availableMemoryKb;
        public Integer dalvikPrivateDirtyKb;
        public Integer dalvikPssKb;
        public Integer nativePrivateDirtyKb;
        public Integer nativePssKb;
        public Integer otherGraphicsPssKb;
        public Integer otherPrivateDirtyKb;
        public Integer otherPssKb;
        public Integer summaryCodeKb;
        public Integer summaryGraphicsKb;
        public Integer summaryJavaHeapKb;
        public Integer summaryPrivateOtherKb;
        public Integer summaryStackKb;
        public Integer summarySystemKb;
        public Integer totalMemoryMb;
        public Integer totalPrivateCleanKb;
        public Integer totalPssByMemInfoKb;
        public Integer totalSharedDirtyKb;
        public Integer totalSwappablePssKb;

        public AndroidMemoryStats() {
            clear();
        }

        public final AndroidMemoryStats clear() {
            this.dalvikPssKb = null;
            this.nativePssKb = null;
            this.otherPssKb = null;
            this.dalvikPrivateDirtyKb = null;
            this.nativePrivateDirtyKb = null;
            this.otherPrivateDirtyKb = null;
            this.totalPssByMemInfoKb = null;
            this.totalPrivateCleanKb = null;
            this.totalSharedDirtyKb = null;
            this.totalSwappablePssKb = null;
            this.otherGraphicsPssKb = null;
            this.summaryJavaHeapKb = null;
            this.summaryCodeKb = null;
            this.summaryStackKb = null;
            this.summaryGraphicsKb = null;
            this.summaryPrivateOtherKb = null;
            this.summarySystemKb = null;
            this.availableMemoryKb = null;
            this.totalMemoryMb = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AndroidMemoryStats clone() {
            try {
                return (AndroidMemoryStats) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.dalvikPssKb != null) {
                codedOutputByteBufferNano.writeInt32(1, this.dalvikPssKb.intValue());
            }
            if (this.nativePssKb != null) {
                codedOutputByteBufferNano.writeInt32(2, this.nativePssKb.intValue());
            }
            if (this.otherPssKb != null) {
                codedOutputByteBufferNano.writeInt32(3, this.otherPssKb.intValue());
            }
            if (this.dalvikPrivateDirtyKb != null) {
                codedOutputByteBufferNano.writeInt32(4, this.dalvikPrivateDirtyKb.intValue());
            }
            if (this.nativePrivateDirtyKb != null) {
                codedOutputByteBufferNano.writeInt32(5, this.nativePrivateDirtyKb.intValue());
            }
            if (this.otherPrivateDirtyKb != null) {
                codedOutputByteBufferNano.writeInt32(6, this.otherPrivateDirtyKb.intValue());
            }
            if (this.totalPrivateCleanKb != null) {
                codedOutputByteBufferNano.writeInt32(7, this.totalPrivateCleanKb.intValue());
            }
            if (this.totalSharedDirtyKb != null) {
                codedOutputByteBufferNano.writeInt32(8, this.totalSharedDirtyKb.intValue());
            }
            if (this.totalSwappablePssKb != null) {
                codedOutputByteBufferNano.writeInt32(9, this.totalSwappablePssKb.intValue());
            }
            if (this.otherGraphicsPssKb != null) {
                codedOutputByteBufferNano.writeInt32(10, this.otherGraphicsPssKb.intValue());
            }
            if (this.summaryJavaHeapKb != null) {
                codedOutputByteBufferNano.writeInt32(11, this.summaryJavaHeapKb.intValue());
            }
            if (this.summaryCodeKb != null) {
                codedOutputByteBufferNano.writeInt32(12, this.summaryCodeKb.intValue());
            }
            if (this.summaryStackKb != null) {
                codedOutputByteBufferNano.writeInt32(13, this.summaryStackKb.intValue());
            }
            if (this.summaryGraphicsKb != null) {
                codedOutputByteBufferNano.writeInt32(14, this.summaryGraphicsKb.intValue());
            }
            if (this.summaryPrivateOtherKb != null) {
                codedOutputByteBufferNano.writeInt32(15, this.summaryPrivateOtherKb.intValue());
            }
            if (this.summarySystemKb != null) {
                codedOutputByteBufferNano.writeInt32(16, this.summarySystemKb.intValue());
            }
            if (this.availableMemoryKb != null) {
                codedOutputByteBufferNano.writeInt32(17, this.availableMemoryKb.intValue());
            }
            if (this.totalMemoryMb != null) {
                codedOutputByteBufferNano.writeInt32(18, this.totalMemoryMb.intValue());
            }
            if (this.totalPssByMemInfoKb != null) {
                codedOutputByteBufferNano.writeInt32(19, this.totalPssByMemInfoKb.intValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.dalvikPssKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.dalvikPssKb.intValue());
            }
            if (this.nativePssKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.nativePssKb.intValue());
            }
            if (this.otherPssKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.otherPssKb.intValue());
            }
            if (this.dalvikPrivateDirtyKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.dalvikPrivateDirtyKb.intValue());
            }
            if (this.nativePrivateDirtyKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.nativePrivateDirtyKb.intValue());
            }
            if (this.otherPrivateDirtyKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.otherPrivateDirtyKb.intValue());
            }
            if (this.totalPrivateCleanKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.totalPrivateCleanKb.intValue());
            }
            if (this.totalSharedDirtyKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, this.totalSharedDirtyKb.intValue());
            }
            if (this.totalSwappablePssKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, this.totalSwappablePssKb.intValue());
            }
            if (this.otherGraphicsPssKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, this.otherGraphicsPssKb.intValue());
            }
            if (this.summaryJavaHeapKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, this.summaryJavaHeapKb.intValue());
            }
            if (this.summaryCodeKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, this.summaryCodeKb.intValue());
            }
            if (this.summaryStackKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, this.summaryStackKb.intValue());
            }
            if (this.summaryGraphicsKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, this.summaryGraphicsKb.intValue());
            }
            if (this.summaryPrivateOtherKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, this.summaryPrivateOtherKb.intValue());
            }
            if (this.summarySystemKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, this.summarySystemKb.intValue());
            }
            if (this.availableMemoryKb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, this.availableMemoryKb.intValue());
            }
            if (this.totalMemoryMb != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(18, this.totalMemoryMb.intValue());
            }
            if (this.totalPssByMemInfoKb != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(19, this.totalPssByMemInfoKb.intValue());
            }
            return computeSerializedSize;
        }

        public final AndroidMemoryStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.dalvikPssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 16:
                        this.nativePssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.otherPssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 32:
                        this.dalvikPrivateDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 40:
                        this.nativePrivateDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 48:
                        this.otherPrivateDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 56:
                        this.totalPrivateCleanKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 64:
                        this.totalSharedDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 72:
                        this.totalSwappablePssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 80:
                        this.otherGraphicsPssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 88:
                        this.summaryJavaHeapKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 96:
                        this.summaryCodeKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 104:
                        this.summaryStackKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 112:
                        this.summaryGraphicsKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 120:
                        this.summaryPrivateOtherKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 128:
                        this.summarySystemKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 136:
                        this.availableMemoryKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 144:
                        this.totalMemoryMb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        continue;
                    case 152:
                        this.totalPssByMemInfoKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
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
}
