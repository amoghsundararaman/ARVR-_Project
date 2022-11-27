package com.google.p000vr.sdk.proto.nano;

import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.NanoEnumValue;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* renamed from: com.google.vr.sdk.proto.nano.Preferences */
public class Preferences {
    private Preferences() {
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Preferences$DeveloperPrefs */
    public static final class DeveloperPrefs extends ExtendableMessageNano<DeveloperPrefs> implements Cloneable {
        private static volatile DeveloperPrefs[] _emptyArray;
        private int bitField0_;
        private boolean captureEnabled_;
        private boolean dEPRECATEDGvrPlatformLibraryEnabled_;
        private boolean dEPRECATEDHeadTrackingServiceEnabled_;
        private boolean dEPRECATEDMotophoPatchEnabled_;
        private boolean developerLoggingEnabled_;
        private boolean forceUndistortedRendering_;
        private boolean frameTrackerEnabled_;
        private int motophoPatchMode_;
        private boolean openglKhrDebugEnabled_;
        private boolean performanceHudEnabled_;
        private boolean performanceLoggingActivated_;
        private boolean performanceMonitoringEnabled_;
        public SafetyCylinderParams safetyCylinderParams;
        private boolean sensorLoggingEnabled_;

        /* renamed from: com.google.vr.sdk.proto.nano.Preferences$DeveloperPrefs$MotophoPatchMode */
        public interface MotophoPatchMode {
            @NanoEnumValue(legacy = false, value = MotophoPatchMode.class)
            public static final int IMPULSE = 2;
            @NanoEnumValue(legacy = false, value = MotophoPatchMode.class)
            public static final int NONE = 0;
            @NanoEnumValue(legacy = false, value = MotophoPatchMode.class)
            public static final int VELOCITY = 1;
        }

        @NanoEnumValue(legacy = false, value = MotophoPatchMode.class)
        public static int checkMotophoPatchModeOrThrow(int i) {
            if (i >= 0 && i <= 2) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(48).append(i).append(" is not a valid enum MotophoPatchMode").toString());
        }

        @NanoEnumValue(legacy = false, value = MotophoPatchMode.class)
        public static int[] checkMotophoPatchModeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkMotophoPatchModeOrThrow : iArr2) {
                checkMotophoPatchModeOrThrow(checkMotophoPatchModeOrThrow);
            }
            return iArr2;
        }

        public static DeveloperPrefs[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeveloperPrefs[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean getPerformanceMonitoringEnabled() {
            return this.performanceMonitoringEnabled_;
        }

        public final boolean hasPerformanceMonitoringEnabled() {
            return (this.bitField0_ & 1) != 0;
        }

        public final DeveloperPrefs clearPerformanceMonitoringEnabled() {
            this.performanceMonitoringEnabled_ = false;
            this.bitField0_ &= -2;
            return this;
        }

        public final DeveloperPrefs setPerformanceMonitoringEnabled(boolean z) {
            this.bitField0_ |= 1;
            this.performanceMonitoringEnabled_ = z;
            return this;
        }

        public final boolean getSensorLoggingEnabled() {
            return this.sensorLoggingEnabled_;
        }

        public final boolean hasSensorLoggingEnabled() {
            return (this.bitField0_ & 2) != 0;
        }

        public final DeveloperPrefs clearSensorLoggingEnabled() {
            this.sensorLoggingEnabled_ = false;
            this.bitField0_ &= -3;
            return this;
        }

        public final DeveloperPrefs setSensorLoggingEnabled(boolean z) {
            this.bitField0_ |= 2;
            this.sensorLoggingEnabled_ = z;
            return this;
        }

        public final boolean getDEPRECATEDMotophoPatchEnabled() {
            return this.dEPRECATEDMotophoPatchEnabled_;
        }

        public final boolean hasDEPRECATEDMotophoPatchEnabled() {
            return (this.bitField0_ & 4) != 0;
        }

        public final DeveloperPrefs clearDEPRECATEDMotophoPatchEnabled() {
            this.dEPRECATEDMotophoPatchEnabled_ = false;
            this.bitField0_ &= -5;
            return this;
        }

        public final DeveloperPrefs setDEPRECATEDMotophoPatchEnabled(boolean z) {
            this.bitField0_ |= 4;
            this.dEPRECATEDMotophoPatchEnabled_ = z;
            return this;
        }

        public final boolean getDeveloperLoggingEnabled() {
            return this.developerLoggingEnabled_;
        }

        public final boolean hasDeveloperLoggingEnabled() {
            return (this.bitField0_ & 8) != 0;
        }

        public final DeveloperPrefs clearDeveloperLoggingEnabled() {
            this.developerLoggingEnabled_ = false;
            this.bitField0_ &= -9;
            return this;
        }

        public final DeveloperPrefs setDeveloperLoggingEnabled(boolean z) {
            this.bitField0_ |= 8;
            this.developerLoggingEnabled_ = z;
            return this;
        }

        public final boolean getForceUndistortedRendering() {
            return this.forceUndistortedRendering_;
        }

        public final boolean hasForceUndistortedRendering() {
            return (this.bitField0_ & 16) != 0;
        }

        public final DeveloperPrefs clearForceUndistortedRendering() {
            this.forceUndistortedRendering_ = false;
            this.bitField0_ &= -17;
            return this;
        }

        public final DeveloperPrefs setForceUndistortedRendering(boolean z) {
            this.bitField0_ |= 16;
            this.forceUndistortedRendering_ = z;
            return this;
        }

        public final boolean getPerformanceHudEnabled() {
            return this.performanceHudEnabled_;
        }

        public final boolean hasPerformanceHudEnabled() {
            return (this.bitField0_ & 32) != 0;
        }

        public final DeveloperPrefs clearPerformanceHudEnabled() {
            this.performanceHudEnabled_ = false;
            this.bitField0_ &= -33;
            return this;
        }

        public final DeveloperPrefs setPerformanceHudEnabled(boolean z) {
            this.bitField0_ |= 32;
            this.performanceHudEnabled_ = z;
            return this;
        }

        public final boolean getDEPRECATEDGvrPlatformLibraryEnabled() {
            return this.dEPRECATEDGvrPlatformLibraryEnabled_;
        }

        public final boolean hasDEPRECATEDGvrPlatformLibraryEnabled() {
            return (this.bitField0_ & 64) != 0;
        }

        public final DeveloperPrefs clearDEPRECATEDGvrPlatformLibraryEnabled() {
            this.dEPRECATEDGvrPlatformLibraryEnabled_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public final DeveloperPrefs setDEPRECATEDGvrPlatformLibraryEnabled(boolean z) {
            this.bitField0_ |= 64;
            this.dEPRECATEDGvrPlatformLibraryEnabled_ = z;
            return this;
        }

        public final boolean getDEPRECATEDHeadTrackingServiceEnabled() {
            return this.dEPRECATEDHeadTrackingServiceEnabled_;
        }

        public final boolean hasDEPRECATEDHeadTrackingServiceEnabled() {
            return (this.bitField0_ & 128) != 0;
        }

        public final DeveloperPrefs clearDEPRECATEDHeadTrackingServiceEnabled() {
            this.dEPRECATEDHeadTrackingServiceEnabled_ = false;
            this.bitField0_ &= -129;
            return this;
        }

        public final DeveloperPrefs setDEPRECATEDHeadTrackingServiceEnabled(boolean z) {
            this.bitField0_ |= 128;
            this.dEPRECATEDHeadTrackingServiceEnabled_ = z;
            return this;
        }

        public final boolean getCaptureEnabled() {
            return this.captureEnabled_;
        }

        public final boolean hasCaptureEnabled() {
            return (this.bitField0_ & 256) != 0;
        }

        public final DeveloperPrefs clearCaptureEnabled() {
            this.captureEnabled_ = false;
            this.bitField0_ &= -257;
            return this;
        }

        public final DeveloperPrefs setCaptureEnabled(boolean z) {
            this.bitField0_ |= 256;
            this.captureEnabled_ = z;
            return this;
        }

        public final boolean getFrameTrackerEnabled() {
            return this.frameTrackerEnabled_;
        }

        public final boolean hasFrameTrackerEnabled() {
            return (this.bitField0_ & 512) != 0;
        }

        public final DeveloperPrefs clearFrameTrackerEnabled() {
            this.frameTrackerEnabled_ = false;
            this.bitField0_ &= -513;
            return this;
        }

        public final DeveloperPrefs setFrameTrackerEnabled(boolean z) {
            this.bitField0_ |= 512;
            this.frameTrackerEnabled_ = z;
            return this;
        }

        @NanoEnumValue(legacy = false, value = MotophoPatchMode.class)
        public final int getMotophoPatchMode() {
            return this.motophoPatchMode_;
        }

        public final DeveloperPrefs setMotophoPatchMode(@NanoEnumValue(legacy = false, value = MotophoPatchMode.class) int i) {
            this.motophoPatchMode_ = i;
            this.bitField0_ |= 1024;
            return this;
        }

        public final boolean hasMotophoPatchMode() {
            return (this.bitField0_ & 1024) != 0;
        }

        public final DeveloperPrefs clearMotophoPatchMode() {
            this.bitField0_ &= -1025;
            this.motophoPatchMode_ = 0;
            return this;
        }

        public final boolean getPerformanceLoggingActivated() {
            return this.performanceLoggingActivated_;
        }

        public final boolean hasPerformanceLoggingActivated() {
            return (this.bitField0_ & 2048) != 0;
        }

        public final DeveloperPrefs clearPerformanceLoggingActivated() {
            this.performanceLoggingActivated_ = false;
            this.bitField0_ &= -2049;
            return this;
        }

        public final DeveloperPrefs setPerformanceLoggingActivated(boolean z) {
            this.bitField0_ |= 2048;
            this.performanceLoggingActivated_ = z;
            return this;
        }

        public final boolean getOpenglKhrDebugEnabled() {
            return this.openglKhrDebugEnabled_;
        }

        public final boolean hasOpenglKhrDebugEnabled() {
            return (this.bitField0_ & 4096) != 0;
        }

        public final DeveloperPrefs clearOpenglKhrDebugEnabled() {
            this.openglKhrDebugEnabled_ = false;
            this.bitField0_ &= -4097;
            return this;
        }

        public final DeveloperPrefs setOpenglKhrDebugEnabled(boolean z) {
            this.bitField0_ |= 4096;
            this.openglKhrDebugEnabled_ = z;
            return this;
        }

        public DeveloperPrefs() {
            clear();
        }

        public final DeveloperPrefs clear() {
            this.bitField0_ = 0;
            this.performanceMonitoringEnabled_ = false;
            this.sensorLoggingEnabled_ = false;
            this.dEPRECATEDMotophoPatchEnabled_ = false;
            this.developerLoggingEnabled_ = false;
            this.forceUndistortedRendering_ = false;
            this.performanceHudEnabled_ = false;
            this.dEPRECATEDGvrPlatformLibraryEnabled_ = false;
            this.dEPRECATEDHeadTrackingServiceEnabled_ = false;
            this.captureEnabled_ = false;
            this.safetyCylinderParams = null;
            this.frameTrackerEnabled_ = false;
            this.motophoPatchMode_ = 0;
            this.performanceLoggingActivated_ = false;
            this.openglKhrDebugEnabled_ = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DeveloperPrefs clone() {
            try {
                DeveloperPrefs developerPrefs = (DeveloperPrefs) super.clone();
                if (this.safetyCylinderParams != null) {
                    developerPrefs.safetyCylinderParams = this.safetyCylinderParams.clone();
                }
                return developerPrefs;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeBool(1, this.performanceMonitoringEnabled_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeBool(2, this.sensorLoggingEnabled_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(3, this.dEPRECATEDMotophoPatchEnabled_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeBool(4, this.developerLoggingEnabled_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeBool(5, this.forceUndistortedRendering_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeBool(6, this.performanceHudEnabled_);
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputByteBufferNano.writeBool(7, this.dEPRECATEDGvrPlatformLibraryEnabled_);
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputByteBufferNano.writeBool(8, this.dEPRECATEDHeadTrackingServiceEnabled_);
            }
            if ((this.bitField0_ & 256) != 0) {
                codedOutputByteBufferNano.writeBool(9, this.captureEnabled_);
            }
            if (this.safetyCylinderParams != null) {
                codedOutputByteBufferNano.writeMessage(10, this.safetyCylinderParams);
            }
            if ((this.bitField0_ & 512) != 0) {
                codedOutputByteBufferNano.writeBool(11, this.frameTrackerEnabled_);
            }
            if ((this.bitField0_ & 1024) != 0) {
                codedOutputByteBufferNano.writeInt32(12, this.motophoPatchMode_);
            }
            if ((this.bitField0_ & 2048) != 0) {
                codedOutputByteBufferNano.writeBool(13, this.performanceLoggingActivated_);
            }
            if ((this.bitField0_ & 4096) != 0) {
                codedOutputByteBufferNano.writeBool(14, this.openglKhrDebugEnabled_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.performanceMonitoringEnabled_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.sensorLoggingEnabled_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.dEPRECATEDMotophoPatchEnabled_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, this.developerLoggingEnabled_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, this.forceUndistortedRendering_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, this.performanceHudEnabled_);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.dEPRECATEDGvrPlatformLibraryEnabled_);
            }
            if ((this.bitField0_ & 128) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, this.dEPRECATEDHeadTrackingServiceEnabled_);
            }
            if ((this.bitField0_ & 256) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, this.captureEnabled_);
            }
            if (this.safetyCylinderParams != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, this.safetyCylinderParams);
            }
            if ((this.bitField0_ & 512) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, this.frameTrackerEnabled_);
            }
            if ((this.bitField0_ & 1024) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, this.motophoPatchMode_);
            }
            if ((this.bitField0_ & 2048) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, this.performanceLoggingActivated_);
            }
            if ((this.bitField0_ & 4096) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(14, this.openglKhrDebugEnabled_);
            }
            return computeSerializedSize;
        }

        public final DeveloperPrefs mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.performanceMonitoringEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 1;
                        continue;
                    case 16:
                        this.sensorLoggingEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 2;
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.dEPRECATEDMotophoPatchEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 4;
                        continue;
                    case 32:
                        this.developerLoggingEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 8;
                        continue;
                    case 40:
                        this.forceUndistortedRendering_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 16;
                        continue;
                    case 48:
                        this.performanceHudEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 32;
                        continue;
                    case 56:
                        this.dEPRECATEDGvrPlatformLibraryEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 64;
                        continue;
                    case 64:
                        this.dEPRECATEDHeadTrackingServiceEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 128;
                        continue;
                    case 72:
                        this.captureEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 256;
                        continue;
                    case 82:
                        if (this.safetyCylinderParams == null) {
                            this.safetyCylinderParams = new SafetyCylinderParams();
                        }
                        codedInputByteBufferNano.readMessage(this.safetyCylinderParams);
                        continue;
                    case 88:
                        this.frameTrackerEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 512;
                        continue;
                    case 96:
                        this.bitField0_ |= 1024;
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.motophoPatchMode_ = checkMotophoPatchModeOrThrow(codedInputByteBufferNano.readInt32());
                            this.bitField0_ |= 1024;
                            continue;
                        } catch (IllegalArgumentException e) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 104:
                        this.performanceLoggingActivated_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 2048;
                        continue;
                    case 112:
                        this.openglKhrDebugEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 4096;
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

        public static DeveloperPrefs parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (DeveloperPrefs) MessageNano.mergeFrom(new DeveloperPrefs(), bArr);
        }

        public static DeveloperPrefs parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DeveloperPrefs().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Preferences$UserPrefs */
    public static final class UserPrefs extends ExtendableMessageNano<UserPrefs> implements Cloneable {
        private static volatile UserPrefs[] _emptyArray;
        private int bitField0_;
        private int controllerHandedness_;
        public DeveloperPrefs developerPrefs;

        /* renamed from: com.google.vr.sdk.proto.nano.Preferences$UserPrefs$Handedness */
        public interface Handedness {
            @NanoEnumValue(legacy = false, value = Handedness.class)
            public static final int LEFT_HANDED = 1;
            @NanoEnumValue(legacy = false, value = Handedness.class)
            public static final int RIGHT_HANDED = 0;
        }

        @NanoEnumValue(legacy = false, value = Handedness.class)
        public static int checkHandednessOrThrow(int i) {
            if (i >= 0 && i <= 1) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum Handedness").toString());
        }

        @NanoEnumValue(legacy = false, value = Handedness.class)
        public static int[] checkHandednessOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int checkHandednessOrThrow : iArr2) {
                checkHandednessOrThrow(checkHandednessOrThrow);
            }
            return iArr2;
        }

        public static UserPrefs[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserPrefs[0];
                    }
                }
            }
            return _emptyArray;
        }

        @NanoEnumValue(legacy = false, value = Handedness.class)
        public final int getControllerHandedness() {
            return this.controllerHandedness_;
        }

        public final UserPrefs setControllerHandedness(@NanoEnumValue(legacy = false, value = Handedness.class) int i) {
            this.controllerHandedness_ = i;
            this.bitField0_ |= 1;
            return this;
        }

        public final boolean hasControllerHandedness() {
            return (this.bitField0_ & 1) != 0;
        }

        public final UserPrefs clearControllerHandedness() {
            this.bitField0_ &= -2;
            this.controllerHandedness_ = 0;
            return this;
        }

        public UserPrefs() {
            clear();
        }

        public final UserPrefs clear() {
            this.bitField0_ = 0;
            this.controllerHandedness_ = 0;
            this.developerPrefs = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final UserPrefs clone() {
            try {
                UserPrefs userPrefs = (UserPrefs) super.clone();
                if (this.developerPrefs != null) {
                    userPrefs.developerPrefs = this.developerPrefs.clone();
                }
                return userPrefs;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(1, this.controllerHandedness_);
            }
            if (this.developerPrefs != null) {
                codedOutputByteBufferNano.writeMessage(2, this.developerPrefs);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.controllerHandedness_);
            }
            if (this.developerPrefs != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, this.developerPrefs);
            }
            return computeSerializedSize;
        }

        public final UserPrefs mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.bitField0_ |= 1;
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.controllerHandedness_ = checkHandednessOrThrow(codedInputByteBufferNano.readInt32());
                            this.bitField0_ |= 1;
                            continue;
                        } catch (IllegalArgumentException e) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 18:
                        if (this.developerPrefs == null) {
                            this.developerPrefs = new DeveloperPrefs();
                        }
                        codedInputByteBufferNano.readMessage(this.developerPrefs);
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

        public static UserPrefs parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (UserPrefs) MessageNano.mergeFrom(new UserPrefs(), bArr);
        }

        public static UserPrefs parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new UserPrefs().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Preferences$FrameReuseMonitoringParams */
    public static final class FrameReuseMonitoringParams extends ExtendableMessageNano<FrameReuseMonitoringParams> implements Cloneable {
        private static volatile FrameReuseMonitoringParams[] _emptyArray;
        private int bitField0_;
        private long fadeInDurationMs_;
        private long fadeOutDurationMs_;
        private float failureProportion_;
        private long frameWindowMs_;
        private long promptUserToKillDelayMs_;
        private float recoveryProportion_;

        public static FrameReuseMonitoringParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FrameReuseMonitoringParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final long getFrameWindowMs() {
            return this.frameWindowMs_;
        }

        public final boolean hasFrameWindowMs() {
            return (this.bitField0_ & 1) != 0;
        }

        public final FrameReuseMonitoringParams clearFrameWindowMs() {
            this.frameWindowMs_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public final FrameReuseMonitoringParams setFrameWindowMs(long j) {
            this.bitField0_ |= 1;
            this.frameWindowMs_ = j;
            return this;
        }

        public final float getFailureProportion() {
            return this.failureProportion_;
        }

        public final boolean hasFailureProportion() {
            return (this.bitField0_ & 2) != 0;
        }

        public final FrameReuseMonitoringParams clearFailureProportion() {
            this.failureProportion_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final FrameReuseMonitoringParams setFailureProportion(float f) {
            this.bitField0_ |= 2;
            this.failureProportion_ = f;
            return this;
        }

        public final float getRecoveryProportion() {
            return this.recoveryProportion_;
        }

        public final boolean hasRecoveryProportion() {
            return (this.bitField0_ & 4) != 0;
        }

        public final FrameReuseMonitoringParams clearRecoveryProportion() {
            this.recoveryProportion_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final FrameReuseMonitoringParams setRecoveryProportion(float f) {
            this.bitField0_ |= 4;
            this.recoveryProportion_ = f;
            return this;
        }

        public final long getFadeInDurationMs() {
            return this.fadeInDurationMs_;
        }

        public final boolean hasFadeInDurationMs() {
            return (this.bitField0_ & 8) != 0;
        }

        public final FrameReuseMonitoringParams clearFadeInDurationMs() {
            this.fadeInDurationMs_ = 0;
            this.bitField0_ &= -9;
            return this;
        }

        public final FrameReuseMonitoringParams setFadeInDurationMs(long j) {
            this.bitField0_ |= 8;
            this.fadeInDurationMs_ = j;
            return this;
        }

        public final long getFadeOutDurationMs() {
            return this.fadeOutDurationMs_;
        }

        public final boolean hasFadeOutDurationMs() {
            return (this.bitField0_ & 16) != 0;
        }

        public final FrameReuseMonitoringParams clearFadeOutDurationMs() {
            this.fadeOutDurationMs_ = 0;
            this.bitField0_ &= -17;
            return this;
        }

        public final FrameReuseMonitoringParams setFadeOutDurationMs(long j) {
            this.bitField0_ |= 16;
            this.fadeOutDurationMs_ = j;
            return this;
        }

        public final long getPromptUserToKillDelayMs() {
            return this.promptUserToKillDelayMs_;
        }

        public final boolean hasPromptUserToKillDelayMs() {
            return (this.bitField0_ & 32) != 0;
        }

        public final FrameReuseMonitoringParams clearPromptUserToKillDelayMs() {
            this.promptUserToKillDelayMs_ = 0;
            this.bitField0_ &= -33;
            return this;
        }

        public final FrameReuseMonitoringParams setPromptUserToKillDelayMs(long j) {
            this.bitField0_ |= 32;
            this.promptUserToKillDelayMs_ = j;
            return this;
        }

        public FrameReuseMonitoringParams() {
            clear();
        }

        public final FrameReuseMonitoringParams clear() {
            this.bitField0_ = 0;
            this.frameWindowMs_ = 0;
            this.failureProportion_ = 0.0f;
            this.recoveryProportion_ = 0.0f;
            this.fadeInDurationMs_ = 0;
            this.fadeOutDurationMs_ = 0;
            this.promptUserToKillDelayMs_ = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final FrameReuseMonitoringParams clone() {
            try {
                return (FrameReuseMonitoringParams) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.frameWindowMs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.failureProportion_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.recoveryProportion_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeInt64(4, this.fadeInDurationMs_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeInt64(5, this.fadeOutDurationMs_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeInt64(6, this.promptUserToKillDelayMs_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.frameWindowMs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.failureProportion_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.recoveryProportion_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.fadeInDurationMs_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, this.fadeOutDurationMs_);
            }
            if ((this.bitField0_ & 32) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(6, this.promptUserToKillDelayMs_);
            }
            return computeSerializedSize;
        }

        public final FrameReuseMonitoringParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        this.frameWindowMs_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                        continue;
                    case 21:
                        this.failureProportion_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 2;
                        continue;
                    case 29:
                        this.recoveryProportion_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 4;
                        continue;
                    case 32:
                        this.fadeInDurationMs_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 8;
                        continue;
                    case 40:
                        this.fadeOutDurationMs_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 16;
                        continue;
                    case 48:
                        this.promptUserToKillDelayMs_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 32;
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

        public static FrameReuseMonitoringParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (FrameReuseMonitoringParams) MessageNano.mergeFrom(new FrameReuseMonitoringParams(), bArr);
        }

        public static FrameReuseMonitoringParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FrameReuseMonitoringParams().mergeFrom(codedInputByteBufferNano);
        }
    }

    /* renamed from: com.google.vr.sdk.proto.nano.Preferences$SafetyCylinderParams */
    public static final class SafetyCylinderParams extends ExtendableMessageNano<SafetyCylinderParams> implements Cloneable {
        private static volatile SafetyCylinderParams[] _emptyArray;
        private float anchorWarningDistance_;
        private int bitField0_;
        private float collisionSphereRadius_;
        private float enterEventRadius_;
        private float exitEventRadius_;
        private boolean graphicsEnabled_;
        public float[] innerFogColor;
        private float innerRadius_;
        public float[] outerFogColor;
        private float outerRadius_;

        public static SafetyCylinderParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SafetyCylinderParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final float getCollisionSphereRadius() {
            return this.collisionSphereRadius_;
        }

        public final boolean hasCollisionSphereRadius() {
            return (this.bitField0_ & 1) != 0;
        }

        public final SafetyCylinderParams clearCollisionSphereRadius() {
            this.collisionSphereRadius_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final SafetyCylinderParams setCollisionSphereRadius(float f) {
            this.bitField0_ |= 1;
            this.collisionSphereRadius_ = f;
            return this;
        }

        public final float getInnerRadius() {
            return this.innerRadius_;
        }

        public final boolean hasInnerRadius() {
            return (this.bitField0_ & 2) != 0;
        }

        public final SafetyCylinderParams clearInnerRadius() {
            this.innerRadius_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final SafetyCylinderParams setInnerRadius(float f) {
            this.bitField0_ |= 2;
            this.innerRadius_ = f;
            return this;
        }

        public final float getOuterRadius() {
            return this.outerRadius_;
        }

        public final boolean hasOuterRadius() {
            return (this.bitField0_ & 4) != 0;
        }

        public final SafetyCylinderParams clearOuterRadius() {
            this.outerRadius_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final SafetyCylinderParams setOuterRadius(float f) {
            this.bitField0_ |= 4;
            this.outerRadius_ = f;
            return this;
        }

        public final float getEnterEventRadius() {
            return this.enterEventRadius_;
        }

        public final boolean hasEnterEventRadius() {
            return (this.bitField0_ & 8) != 0;
        }

        public final SafetyCylinderParams clearEnterEventRadius() {
            this.enterEventRadius_ = 0.0f;
            this.bitField0_ &= -9;
            return this;
        }

        public final SafetyCylinderParams setEnterEventRadius(float f) {
            this.bitField0_ |= 8;
            this.enterEventRadius_ = f;
            return this;
        }

        public final float getExitEventRadius() {
            return this.exitEventRadius_;
        }

        public final boolean hasExitEventRadius() {
            return (this.bitField0_ & 16) != 0;
        }

        public final SafetyCylinderParams clearExitEventRadius() {
            this.exitEventRadius_ = 0.0f;
            this.bitField0_ &= -17;
            return this;
        }

        public final SafetyCylinderParams setExitEventRadius(float f) {
            this.bitField0_ |= 16;
            this.exitEventRadius_ = f;
            return this;
        }

        public final float getAnchorWarningDistance() {
            return this.anchorWarningDistance_;
        }

        public final boolean hasAnchorWarningDistance() {
            return (this.bitField0_ & 32) != 0;
        }

        public final SafetyCylinderParams clearAnchorWarningDistance() {
            this.anchorWarningDistance_ = 0.0f;
            this.bitField0_ &= -33;
            return this;
        }

        public final SafetyCylinderParams setAnchorWarningDistance(float f) {
            this.bitField0_ |= 32;
            this.anchorWarningDistance_ = f;
            return this;
        }

        public final boolean getGraphicsEnabled() {
            return this.graphicsEnabled_;
        }

        public final boolean hasGraphicsEnabled() {
            return (this.bitField0_ & 64) != 0;
        }

        public final SafetyCylinderParams clearGraphicsEnabled() {
            this.graphicsEnabled_ = true;
            this.bitField0_ &= -65;
            return this;
        }

        public final SafetyCylinderParams setGraphicsEnabled(boolean z) {
            this.bitField0_ |= 64;
            this.graphicsEnabled_ = z;
            return this;
        }

        public SafetyCylinderParams() {
            clear();
        }

        public final SafetyCylinderParams clear() {
            this.bitField0_ = 0;
            this.collisionSphereRadius_ = 0.0f;
            this.innerRadius_ = 0.0f;
            this.outerRadius_ = 0.0f;
            this.innerFogColor = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.outerFogColor = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.enterEventRadius_ = 0.0f;
            this.exitEventRadius_ = 0.0f;
            this.anchorWarningDistance_ = 0.0f;
            this.graphicsEnabled_ = true;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final SafetyCylinderParams clone() {
            try {
                SafetyCylinderParams safetyCylinderParams = (SafetyCylinderParams) super.clone();
                if (this.innerFogColor != null && this.innerFogColor.length > 0) {
                    safetyCylinderParams.innerFogColor = (float[]) this.innerFogColor.clone();
                }
                if (this.outerFogColor != null && this.outerFogColor.length > 0) {
                    safetyCylinderParams.outerFogColor = (float[]) this.outerFogColor.clone();
                }
                return safetyCylinderParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.collisionSphereRadius_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.innerRadius_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.outerRadius_);
            }
            if (this.innerFogColor != null && this.innerFogColor.length > 0) {
                for (float writeFloat : this.innerFogColor) {
                    codedOutputByteBufferNano.writeFloat(4, writeFloat);
                }
            }
            if (this.outerFogColor != null && this.outerFogColor.length > 0) {
                for (float writeFloat2 : this.outerFogColor) {
                    codedOutputByteBufferNano.writeFloat(5, writeFloat2);
                }
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeFloat(6, this.enterEventRadius_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeFloat(7, this.exitEventRadius_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeFloat(8, this.anchorWarningDistance_);
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputByteBufferNano.writeBool(9, this.graphicsEnabled_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.collisionSphereRadius_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.innerRadius_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.outerRadius_);
            }
            if (this.innerFogColor != null && this.innerFogColor.length > 0) {
                computeSerializedSize = computeSerializedSize + (this.innerFogColor.length * 4) + (this.innerFogColor.length * 1);
            }
            if (this.outerFogColor != null && this.outerFogColor.length > 0) {
                computeSerializedSize = computeSerializedSize + (this.outerFogColor.length * 4) + (this.outerFogColor.length * 1);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.enterEventRadius_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(7, this.exitEventRadius_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(8, this.anchorWarningDistance_);
            }
            if ((this.bitField0_ & 64) != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(9, this.graphicsEnabled_);
            }
            return computeSerializedSize;
        }

        public final SafetyCylinderParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 13:
                        this.collisionSphereRadius_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 1;
                        continue;
                    case 21:
                        this.innerRadius_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 2;
                        continue;
                    case 29:
                        this.outerRadius_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 4;
                        continue;
                    case 34:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i = readRawVarint32 / 4;
                        int length = this.innerFogColor == null ? 0 : this.innerFogColor.length;
                        float[] fArr = new float[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.innerFogColor, 0, fArr, 0, length);
                        }
                        while (length < fArr.length) {
                            fArr[length] = codedInputByteBufferNano.readFloat();
                            length++;
                        }
                        this.innerFogColor = fArr;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        continue;
                    case 37:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                        int length2 = this.innerFogColor == null ? 0 : this.innerFogColor.length;
                        float[] fArr2 = new float[(repeatedFieldArrayLength + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.innerFogColor, 0, fArr2, 0, length2);
                        }
                        while (length2 < fArr2.length - 1) {
                            fArr2[length2] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        fArr2[length2] = codedInputByteBufferNano.readFloat();
                        this.innerFogColor = fArr2;
                        continue;
                    case 42:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i2 = readRawVarint322 / 4;
                        int length3 = this.outerFogColor == null ? 0 : this.outerFogColor.length;
                        float[] fArr3 = new float[(i2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.outerFogColor, 0, fArr3, 0, length3);
                        }
                        while (length3 < fArr3.length) {
                            fArr3[length3] = codedInputByteBufferNano.readFloat();
                            length3++;
                        }
                        this.outerFogColor = fArr3;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        continue;
                    case 45:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 45);
                        int length4 = this.outerFogColor == null ? 0 : this.outerFogColor.length;
                        float[] fArr4 = new float[(repeatedFieldArrayLength2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.outerFogColor, 0, fArr4, 0, length4);
                        }
                        while (length4 < fArr4.length - 1) {
                            fArr4[length4] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        fArr4[length4] = codedInputByteBufferNano.readFloat();
                        this.outerFogColor = fArr4;
                        continue;
                    case 53:
                        this.enterEventRadius_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 8;
                        continue;
                    case 61:
                        this.exitEventRadius_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 16;
                        continue;
                    case 69:
                        this.anchorWarningDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 32;
                        continue;
                    case 72:
                        this.graphicsEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 64;
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

        public static SafetyCylinderParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (SafetyCylinderParams) MessageNano.mergeFrom(new SafetyCylinderParams(), bArr);
        }

        public static SafetyCylinderParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new SafetyCylinderParams().mergeFrom(codedInputByteBufferNano);
        }
    }
}
