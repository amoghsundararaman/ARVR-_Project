package com.google.common.logging.nano;

import com.google.common.logging.nano.VrBaseOuterClass;
import com.google.p000vr.cardboard.AndroidNCompat;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.DescriptorProtos;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.NanoEnumValue;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import logs.proto.wireless.performance.mobile.nano.MemoryMetric;

/* renamed from: com.google.common.logging.nano.Vr */
public class C0003Vr {

    /* renamed from: com.google.common.logging.nano.Vr$VREvent */
    public static final class VREvent extends ExtendableMessageNano<VREvent> implements Cloneable {
        public Application application;
        public AudioStats audioStats;
        public String cohort;
        public Cyclops cyclops;
        public Long durationMs;
        public EarthVr earthVr;
        public EmbedVrWidget embedVrWidget;
        public Eva eva;
        @NanoEnumValue(legacy = false, value = EventSource.class)
        public Integer eventSource;
        public Expeditions expeditions;
        public GConfigUpdate gConfigUpdate;
        public VrBaseOuterClass.VrBase.HeadMount headMount;
        public HeadTracking headTracking;
        public Application[] installedVrApplications;
        public JumpInspector jumpInspector;
        public Keyboard keyboard;
        public Launcher launcher;
        @NanoEnumValue(legacy = false, value = Bucket.class)
        public Integer lifetimeCountBucket;
        public LoggingOptInState loggingOptInState;
        public Lullaby lullaby;
        public PerformanceStats performanceStats;
        public PhoneAlignment phoneAlignment;
        public Photos photos;
        public QrCodeScan qrCodeScan;
        public Renderer renderer;
        public SdkConfigurationParams sdkConfiguration;
        public SensorStats sensorStats;
        public StandaloneHeadset standaloneHeadset;
        public StreetView streetView;
        public VrCore vrCore;
        public VrHome vrHome;
        public VrStreaming vrStreaming;

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Bucket */
        public interface Bucket {
        }

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr */
        public static final class EarthVr extends ExtendableMessageNano<EarthVr> implements Cloneable {
            public ActionOrb actionOrb;
            public Actor[] actors;
            public AppState appState;
            public ControllerState[] controllerStates;
            public Environment environment;
            public VrSdkError[] errors;
            public Menu menu;
            public Preferences preferences;
            public Preferences preferencesDelta;
            public Search search;
            public SplashScreen splashScreen;
            public Transform startFromHeadTransform;
            public DoublePrecisionTransform startFromKeyholeTransform;
            public StreetView streetView;
            public Tour tour;
            public Tutorial tutorial;
            public View view;

            public EarthVr() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Actor */
            public static final class Actor extends ExtendableMessageNano<Actor> implements Cloneable {
                private static volatile Actor[] _emptyArray;
                public ControllerState[] controllerStates;
                public Transform startFromHeadTransform;
                @NanoEnumValue(legacy = false, value = VrSdk.class)
                public Integer vrSdk;
                @NanoEnumValue(legacy = false, value = VrSystemType.class)
                public Integer vrSystemType;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Actor$VrSdk */
                public interface VrSdk {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Actor$VrSystemType */
                public interface VrSystemType {
                }

                @NanoEnumValue(legacy = false, value = VrSdk.class)
                public static int checkVrSdkOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(37).append(i).append(" is not a valid enum VrSdk").toString());
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Actor$ControllerState */
                public static final class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
                    private static volatile ControllerState[] _emptyArray;
                    @NanoEnumValue(legacy = false, value = Role.class)
                    public Integer role;
                    public Transform startFromControllerTransform;
                    @NanoEnumValue(legacy = false, value = Type.class)
                    public Integer type;

                    /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Actor$ControllerState$Role */
                    public interface Role {
                    }

                    /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Actor$ControllerState$Type */
                    public interface Type {
                    }

                    @NanoEnumValue(legacy = false, value = Role.class)
                    public static int checkRoleOrThrow(int i) {
                        if (i >= 0 && i <= 2) {
                            return i;
                        }
                        throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Role").toString());
                    }

                    @NanoEnumValue(legacy = false, value = Type.class)
                    public static int checkTypeOrThrow(int i) {
                        if (i >= 0 && i <= 4) {
                            return i;
                        }
                        throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Type").toString());
                    }

                    public static ControllerState[] emptyArray() {
                        if (_emptyArray == null) {
                            synchronized (InternalNano.LAZY_INIT_LOCK) {
                                if (_emptyArray == null) {
                                    _emptyArray = new ControllerState[0];
                                }
                            }
                        }
                        return _emptyArray;
                    }

                    public ControllerState() {
                        clear();
                    }

                    public final ControllerState clear() {
                        this.role = null;
                        this.startFromControllerTransform = null;
                        this.type = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final ControllerState clone() {
                        try {
                            ControllerState controllerState = (ControllerState) super.clone();
                            if (this.startFromControllerTransform != null) {
                                controllerState.startFromControllerTransform = this.startFromControllerTransform.clone();
                            }
                            return controllerState;
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.role != null) {
                            codedOutputByteBufferNano.writeInt32(1, this.role.intValue());
                        }
                        if (this.startFromControllerTransform != null) {
                            codedOutputByteBufferNano.writeMessage(2, this.startFromControllerTransform);
                        }
                        if (this.type != null) {
                            codedOutputByteBufferNano.writeInt32(3, this.type.intValue());
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.role != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.role.intValue());
                        }
                        if (this.startFromControllerTransform != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromControllerTransform);
                        }
                        if (this.type != null) {
                            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.type.intValue());
                        }
                        return computeSerializedSize;
                    }

                    public final ControllerState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    int position = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.role = Integer.valueOf(checkRoleOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
                                case 18:
                                    if (this.startFromControllerTransform == null) {
                                        this.startFromControllerTransform = new Transform();
                                    }
                                    codedInputByteBufferNano.readMessage(this.startFromControllerTransform);
                                    continue;
                                case AndroidNCompat.N_SDK_LEVEL:
                                    int position2 = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.type = Integer.valueOf(checkTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e2) {
                                        codedInputByteBufferNano.rewindToPosition(position2);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
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

                @NanoEnumValue(legacy = false, value = VrSystemType.class)
                public static int checkVrSystemTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(44).append(i).append(" is not a valid enum VrSystemType").toString());
                }

                public static Actor[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Actor[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public Actor() {
                    clear();
                }

                public final Actor clear() {
                    this.startFromHeadTransform = null;
                    this.controllerStates = ControllerState.emptyArray();
                    this.vrSdk = null;
                    this.vrSystemType = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Actor clone() {
                    try {
                        Actor actor = (Actor) super.clone();
                        if (this.startFromHeadTransform != null) {
                            actor.startFromHeadTransform = this.startFromHeadTransform.clone();
                        }
                        if (this.controllerStates != null && this.controllerStates.length > 0) {
                            actor.controllerStates = new ControllerState[this.controllerStates.length];
                            for (int i = 0; i < this.controllerStates.length; i++) {
                                if (this.controllerStates[i] != null) {
                                    actor.controllerStates[i] = this.controllerStates[i].clone();
                                }
                            }
                        }
                        return actor;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.startFromHeadTransform != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.startFromHeadTransform);
                    }
                    if (this.controllerStates != null && this.controllerStates.length > 0) {
                        for (ControllerState controllerState : this.controllerStates) {
                            if (controllerState != null) {
                                codedOutputByteBufferNano.writeMessage(3, controllerState);
                            }
                        }
                    }
                    if (this.vrSdk != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.vrSdk.intValue());
                    }
                    if (this.vrSystemType != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.vrSystemType.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.startFromHeadTransform != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromHeadTransform);
                    }
                    if (this.controllerStates != null && this.controllerStates.length > 0) {
                        int i = computeSerializedSize;
                        for (ControllerState controllerState : this.controllerStates) {
                            if (controllerState != null) {
                                i += CodedOutputByteBufferNano.computeMessageSize(3, controllerState);
                            }
                        }
                        computeSerializedSize = i;
                    }
                    if (this.vrSdk != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.vrSdk.intValue());
                    }
                    if (this.vrSystemType != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, this.vrSystemType.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Actor mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 18:
                                if (this.startFromHeadTransform == null) {
                                    this.startFromHeadTransform = new Transform();
                                }
                                codedInputByteBufferNano.readMessage(this.startFromHeadTransform);
                                continue;
                            case 26:
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                                int length = this.controllerStates == null ? 0 : this.controllerStates.length;
                                ControllerState[] controllerStateArr = new ControllerState[(repeatedFieldArrayLength + length)];
                                if (length != 0) {
                                    System.arraycopy(this.controllerStates, 0, controllerStateArr, 0, length);
                                }
                                while (length < controllerStateArr.length - 1) {
                                    controllerStateArr[length] = new ControllerState();
                                    codedInputByteBufferNano.readMessage(controllerStateArr[length]);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                controllerStateArr[length] = new ControllerState();
                                codedInputByteBufferNano.readMessage(controllerStateArr[length]);
                                this.controllerStates = controllerStateArr;
                                continue;
                            case 32:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.vrSdk = Integer.valueOf(checkVrSdkOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 40:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.vrSystemType = Integer.valueOf(checkVrSystemTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$ActionOrb */
            public static final class ActionOrb extends ExtendableMessageNano<ActionOrb> implements Cloneable {
                @NanoEnumValue(legacy = false, value = DisplayMode.class)
                public Integer displayMode;
                @NanoEnumValue(legacy = false, value = ExpansionState.class)
                public Integer expansionState;
                @NanoEnumValue(legacy = false, value = DisplayMode.class)
                public Integer previousDisplayMode;
                @NanoEnumValue(legacy = false, value = ExpansionState.class)
                public Integer previousExpansionState;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$ActionOrb$DisplayMode */
                public interface DisplayMode {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$ActionOrb$ExpansionState */
                public interface ExpansionState {
                }

                @NanoEnumValue(legacy = false, value = ExpansionState.class)
                public static int checkExpansionStateOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum ExpansionState").toString());
                }

                @NanoEnumValue(legacy = false, value = DisplayMode.class)
                public static int checkDisplayModeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum DisplayMode").toString());
                }

                public ActionOrb() {
                    clear();
                }

                public final ActionOrb clear() {
                    this.expansionState = null;
                    this.displayMode = null;
                    this.previousExpansionState = null;
                    this.previousDisplayMode = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ActionOrb clone() {
                    try {
                        return (ActionOrb) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.expansionState != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.expansionState.intValue());
                    }
                    if (this.displayMode != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.displayMode.intValue());
                    }
                    if (this.previousExpansionState != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.previousExpansionState.intValue());
                    }
                    if (this.previousDisplayMode != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.previousDisplayMode.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.expansionState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.expansionState.intValue());
                    }
                    if (this.displayMode != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.displayMode.intValue());
                    }
                    if (this.previousExpansionState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.previousExpansionState.intValue());
                    }
                    if (this.previousDisplayMode != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, this.previousDisplayMode.intValue());
                    }
                    return computeSerializedSize;
                }

                public final ActionOrb mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.expansionState = Integer.valueOf(checkExpansionStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.displayMode = Integer.valueOf(checkDisplayModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.previousExpansionState = Integer.valueOf(checkExpansionStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 32:
                                int position4 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.previousDisplayMode = Integer.valueOf(checkDisplayModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e4) {
                                    codedInputByteBufferNano.rewindToPosition(position4);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$AppState */
            public static final class AppState extends ExtendableMessageNano<AppState> implements Cloneable {
                public Long appModeId;

                public AppState() {
                    clear();
                }

                public final AppState clear() {
                    this.appModeId = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final AppState clone() {
                    try {
                        return (AppState) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.appModeId != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.appModeId.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.appModeId != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, this.appModeId.longValue());
                    }
                    return computeSerializedSize;
                }

                public final AppState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.appModeId = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$ControllerState */
            public static final class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
                private static volatile ControllerState[] _emptyArray;
                @NanoEnumValue(legacy = false, value = Role.class)
                public Integer role;
                public Transform startFromControllerTransform;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$ControllerState$Role */
                public interface Role {
                }

                @NanoEnumValue(legacy = false, value = Role.class)
                public static int checkRoleOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Role").toString());
                }

                public static ControllerState[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new ControllerState[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public ControllerState() {
                    clear();
                }

                public final ControllerState clear() {
                    this.role = null;
                    this.startFromControllerTransform = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ControllerState clone() {
                    try {
                        ControllerState controllerState = (ControllerState) super.clone();
                        if (this.startFromControllerTransform != null) {
                            controllerState.startFromControllerTransform = this.startFromControllerTransform.clone();
                        }
                        return controllerState;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.role != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.role.intValue());
                    }
                    if (this.startFromControllerTransform != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.startFromControllerTransform);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.role != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.role.intValue());
                    }
                    if (this.startFromControllerTransform != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, this.startFromControllerTransform);
                    }
                    return computeSerializedSize;
                }

                public final ControllerState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.role = Integer.valueOf(checkRoleOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 18:
                                if (this.startFromControllerTransform == null) {
                                    this.startFromControllerTransform = new Transform();
                                }
                                codedInputByteBufferNano.readMessage(this.startFromControllerTransform);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Environment */
            public static final class Environment extends ExtendableMessageNano<Environment> implements Cloneable {
                public Transform startFromEnvironmentTransform;

                public Environment() {
                    clear();
                }

                public final Environment clear() {
                    this.startFromEnvironmentTransform = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Environment clone() {
                    try {
                        Environment environment = (Environment) super.clone();
                        if (this.startFromEnvironmentTransform != null) {
                            environment.startFromEnvironmentTransform = this.startFromEnvironmentTransform.clone();
                        }
                        return environment;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.startFromEnvironmentTransform != null) {
                        codedOutputByteBufferNano.writeMessage(1, this.startFromEnvironmentTransform);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.startFromEnvironmentTransform != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, this.startFromEnvironmentTransform);
                    }
                    return computeSerializedSize;
                }

                public final Environment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                if (this.startFromEnvironmentTransform == null) {
                                    this.startFromEnvironmentTransform = new Transform();
                                }
                                codedInputByteBufferNano.readMessage(this.startFromEnvironmentTransform);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$GeoLocation */
            public static final class GeoLocation extends ExtendableMessageNano<GeoLocation> implements Cloneable {
                public Double altitudeMeters;
                public Double latitudeDegrees;
                public Double longitudeDegrees;

                public GeoLocation() {
                    clear();
                }

                public final GeoLocation clear() {
                    this.latitudeDegrees = null;
                    this.longitudeDegrees = null;
                    this.altitudeMeters = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final GeoLocation clone() {
                    try {
                        return (GeoLocation) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.latitudeDegrees != null) {
                        codedOutputByteBufferNano.writeDouble(1, this.latitudeDegrees.doubleValue());
                    }
                    if (this.longitudeDegrees != null) {
                        codedOutputByteBufferNano.writeDouble(2, this.longitudeDegrees.doubleValue());
                    }
                    if (this.altitudeMeters != null) {
                        codedOutputByteBufferNano.writeDouble(3, this.altitudeMeters.doubleValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.latitudeDegrees != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.latitudeDegrees.doubleValue());
                    }
                    if (this.longitudeDegrees != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.longitudeDegrees.doubleValue());
                    }
                    if (this.altitudeMeters != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(3, this.altitudeMeters.doubleValue());
                    }
                    return computeSerializedSize;
                }

                public final GeoLocation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 9:
                                this.latitudeDegrees = Double.valueOf(codedInputByteBufferNano.readDouble());
                                continue;
                            case 17:
                                this.longitudeDegrees = Double.valueOf(codedInputByteBufferNano.readDouble());
                                continue;
                            case AndroidNCompat.NMR1_SDK_LEVEL:
                                this.altitudeMeters = Double.valueOf(codedInputByteBufferNano.readDouble());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Menu */
            public static final class Menu extends ExtendableMessageNano<Menu> implements Cloneable {
                public String categoryName;
                public String contentKey;
                public String contentName;
                public Integer pageIndex;

                public Menu() {
                    clear();
                }

                public final Menu clear() {
                    this.categoryName = null;
                    this.pageIndex = null;
                    this.contentKey = null;
                    this.contentName = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Menu clone() {
                    try {
                        return (Menu) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.categoryName != null) {
                        codedOutputByteBufferNano.writeString(1, this.categoryName);
                    }
                    if (this.pageIndex != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.pageIndex.intValue());
                    }
                    if (this.contentKey != null) {
                        codedOutputByteBufferNano.writeString(3, this.contentKey);
                    }
                    if (this.contentName != null) {
                        codedOutputByteBufferNano.writeString(4, this.contentName);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.categoryName != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.categoryName);
                    }
                    if (this.pageIndex != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.pageIndex.intValue());
                    }
                    if (this.contentKey != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.contentKey);
                    }
                    if (this.contentName != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.contentName);
                    }
                    return computeSerializedSize;
                }

                public final Menu mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.categoryName = codedInputByteBufferNano.readString();
                                continue;
                            case 16:
                                this.pageIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 26:
                                this.contentKey = codedInputByteBufferNano.readString();
                                continue;
                            case 34:
                                this.contentName = codedInputByteBufferNano.readString();
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Preferences */
            public static final class Preferences extends ExtendableMessageNano<Preferences> implements Cloneable {
                @NanoEnumValue(legacy = false, value = ComfortModeState.class)
                public Integer comfortModeState;
                @NanoEnumValue(legacy = false, value = GuestMode.class)
                public Integer guestMode;
                @NanoEnumValue(legacy = false, value = HumanScaleMode.class)
                public Integer humanScaleMode;
                @NanoEnumValue(legacy = false, value = LabelsState.class)
                public Integer labelsState;
                @NanoEnumValue(legacy = false, value = StartConfiguration.class)
                public Integer startConfiguration;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Preferences$ComfortModeState */
                public interface ComfortModeState {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Preferences$GuestMode */
                public interface GuestMode {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Preferences$HumanScaleMode */
                public interface HumanScaleMode {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Preferences$LabelsState */
                public interface LabelsState {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Preferences$StartConfiguration */
                public interface StartConfiguration {
                }

                @NanoEnumValue(legacy = false, value = LabelsState.class)
                public static int checkLabelsStateOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum LabelsState").toString());
                }

                @NanoEnumValue(legacy = false, value = ComfortModeState.class)
                public static int checkComfortModeStateOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(48).append(i).append(" is not a valid enum ComfortModeState").toString());
                }

                @NanoEnumValue(legacy = false, value = StartConfiguration.class)
                public static int checkStartConfigurationOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(50).append(i).append(" is not a valid enum StartConfiguration").toString());
                }

                @NanoEnumValue(legacy = false, value = GuestMode.class)
                public static int checkGuestModeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum GuestMode").toString());
                }

                @NanoEnumValue(legacy = false, value = HumanScaleMode.class)
                public static int checkHumanScaleModeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum HumanScaleMode").toString());
                }

                public Preferences() {
                    clear();
                }

                public final Preferences clear() {
                    this.labelsState = null;
                    this.comfortModeState = null;
                    this.startConfiguration = null;
                    this.guestMode = null;
                    this.humanScaleMode = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Preferences clone() {
                    try {
                        return (Preferences) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.labelsState != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.labelsState.intValue());
                    }
                    if (this.comfortModeState != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.comfortModeState.intValue());
                    }
                    if (this.startConfiguration != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.startConfiguration.intValue());
                    }
                    if (this.guestMode != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.guestMode.intValue());
                    }
                    if (this.humanScaleMode != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.humanScaleMode.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.labelsState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.labelsState.intValue());
                    }
                    if (this.comfortModeState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.comfortModeState.intValue());
                    }
                    if (this.startConfiguration != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.startConfiguration.intValue());
                    }
                    if (this.guestMode != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.guestMode.intValue());
                    }
                    if (this.humanScaleMode != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, this.humanScaleMode.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Preferences mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.labelsState = Integer.valueOf(checkLabelsStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.comfortModeState = Integer.valueOf(checkComfortModeStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.startConfiguration = Integer.valueOf(checkStartConfigurationOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 32:
                                int position4 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.guestMode = Integer.valueOf(checkGuestModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e4) {
                                    codedInputByteBufferNano.rewindToPosition(position4);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 40:
                                int position5 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.humanScaleMode = Integer.valueOf(checkHumanScaleModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e5) {
                                    codedInputByteBufferNano.rewindToPosition(position5);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Search */
            public static final class Search extends ExtendableMessageNano<Search> implements Cloneable {
                public String searchQuery;
                public Integer selectedEntityIndex;
                public View selectedEntityView;
                public String typedQuery;

                public Search() {
                    clear();
                }

                public final Search clear() {
                    this.typedQuery = null;
                    this.searchQuery = null;
                    this.selectedEntityIndex = null;
                    this.selectedEntityView = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Search clone() {
                    try {
                        Search search = (Search) super.clone();
                        if (this.selectedEntityView != null) {
                            search.selectedEntityView = this.selectedEntityView.clone();
                        }
                        return search;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.typedQuery != null) {
                        codedOutputByteBufferNano.writeString(1, this.typedQuery);
                    }
                    if (this.searchQuery != null) {
                        codedOutputByteBufferNano.writeString(2, this.searchQuery);
                    }
                    if (this.selectedEntityIndex != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.selectedEntityIndex.intValue());
                    }
                    if (this.selectedEntityView != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.selectedEntityView);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.typedQuery != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.typedQuery);
                    }
                    if (this.searchQuery != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.searchQuery);
                    }
                    if (this.selectedEntityIndex != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.selectedEntityIndex.intValue());
                    }
                    if (this.selectedEntityView != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.selectedEntityView);
                    }
                    return computeSerializedSize;
                }

                public final Search mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.typedQuery = codedInputByteBufferNano.readString();
                                continue;
                            case 18:
                                this.searchQuery = codedInputByteBufferNano.readString();
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.selectedEntityIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 34:
                                if (this.selectedEntityView == null) {
                                    this.selectedEntityView = new View();
                                }
                                codedInputByteBufferNano.readMessage(this.selectedEntityView);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$SplashScreen */
            public static final class SplashScreen extends ExtendableMessageNano<SplashScreen> implements Cloneable {
                @NanoEnumValue(legacy = false, value = ExitType.class)
                public Integer exitType;
                public Long numberOfViewPreloadsAttempted;
                public Long numberOfViewPreloadsSucceeded;
                public Long viewPreloadDurationMs;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$SplashScreen$ExitType */
                public interface ExitType {
                }

                @NanoEnumValue(legacy = false, value = ExitType.class)
                public static int checkExitTypeOrThrow(int i) {
                    if (i >= 0 && i <= 1) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum ExitType").toString());
                }

                public SplashScreen() {
                    clear();
                }

                public final SplashScreen clear() {
                    this.exitType = null;
                    this.numberOfViewPreloadsAttempted = null;
                    this.numberOfViewPreloadsSucceeded = null;
                    this.viewPreloadDurationMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final SplashScreen clone() {
                    try {
                        return (SplashScreen) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.exitType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.exitType.intValue());
                    }
                    if (this.numberOfViewPreloadsAttempted != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.numberOfViewPreloadsAttempted.longValue());
                    }
                    if (this.numberOfViewPreloadsSucceeded != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.numberOfViewPreloadsSucceeded.longValue());
                    }
                    if (this.viewPreloadDurationMs != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.viewPreloadDurationMs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.exitType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.exitType.intValue());
                    }
                    if (this.numberOfViewPreloadsAttempted != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.numberOfViewPreloadsAttempted.longValue());
                    }
                    if (this.numberOfViewPreloadsSucceeded != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.numberOfViewPreloadsSucceeded.longValue());
                    }
                    if (this.viewPreloadDurationMs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, this.viewPreloadDurationMs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final SplashScreen mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.exitType = Integer.valueOf(checkExitTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.numberOfViewPreloadsAttempted = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.numberOfViewPreloadsSucceeded = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.viewPreloadDurationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$StreetView */
            public static final class StreetView extends ExtendableMessageNano<StreetView> implements Cloneable {
                public Boolean hasUserDiscoveredNeighbor;
                @NanoEnumValue(legacy = false, value = PanoFrontend.class)
                public Integer panoFrontend;
                public String panoId;
                public GeoLocation panoLocation;
                public Integer panoNeighborCount;
                @NanoEnumValue(legacy = false, value = PanoType.class)
                public Integer panoType;
                @NanoEnumValue(legacy = false, value = State.class)
                public Integer previousState;
                @NanoEnumValue(legacy = false, value = State.class)
                public Integer state;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$StreetView$PanoFrontend */
                public interface PanoFrontend {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$StreetView$PanoType */
                public interface PanoType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$StreetView$State */
                public interface State {
                }

                @NanoEnumValue(legacy = false, value = State.class)
                public static int checkStateOrThrow(int i) {
                    if (i >= 0 && i <= 12) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(37).append(i).append(" is not a valid enum State").toString());
                }

                @NanoEnumValue(legacy = false, value = PanoType.class)
                public static int checkPanoTypeOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum PanoType").toString());
                }

                @NanoEnumValue(legacy = false, value = PanoFrontend.class)
                public static int checkPanoFrontendOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(44).append(i).append(" is not a valid enum PanoFrontend").toString());
                }

                public StreetView() {
                    clear();
                }

                public final StreetView clear() {
                    this.state = null;
                    this.previousState = null;
                    this.panoId = null;
                    this.panoLocation = null;
                    this.panoType = null;
                    this.panoFrontend = null;
                    this.panoNeighborCount = null;
                    this.hasUserDiscoveredNeighbor = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final StreetView clone() {
                    try {
                        StreetView streetView = (StreetView) super.clone();
                        if (this.panoLocation != null) {
                            streetView.panoLocation = this.panoLocation.clone();
                        }
                        return streetView;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.state != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.state.intValue());
                    }
                    if (this.previousState != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.previousState.intValue());
                    }
                    if (this.panoId != null) {
                        codedOutputByteBufferNano.writeString(3, this.panoId);
                    }
                    if (this.panoLocation != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.panoLocation);
                    }
                    if (this.panoType != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.panoType.intValue());
                    }
                    if (this.panoFrontend != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.panoFrontend.intValue());
                    }
                    if (this.panoNeighborCount != null) {
                        codedOutputByteBufferNano.writeInt32(7, this.panoNeighborCount.intValue());
                    }
                    if (this.hasUserDiscoveredNeighbor != null) {
                        codedOutputByteBufferNano.writeBool(8, this.hasUserDiscoveredNeighbor.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.state != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.state.intValue());
                    }
                    if (this.previousState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.previousState.intValue());
                    }
                    if (this.panoId != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.panoId);
                    }
                    if (this.panoLocation != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.panoLocation);
                    }
                    if (this.panoType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.panoType.intValue());
                    }
                    if (this.panoFrontend != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.panoFrontend.intValue());
                    }
                    if (this.panoNeighborCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.panoNeighborCount.intValue());
                    }
                    if (this.hasUserDiscoveredNeighbor != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(8, this.hasUserDiscoveredNeighbor.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final StreetView mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.state = Integer.valueOf(checkStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.previousState = Integer.valueOf(checkStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 26:
                                this.panoId = codedInputByteBufferNano.readString();
                                continue;
                            case 34:
                                if (this.panoLocation == null) {
                                    this.panoLocation = new GeoLocation();
                                }
                                codedInputByteBufferNano.readMessage(this.panoLocation);
                                continue;
                            case 40:
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.panoType = Integer.valueOf(checkPanoTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 48:
                                int position4 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.panoFrontend = Integer.valueOf(checkPanoFrontendOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e4) {
                                    codedInputByteBufferNano.rewindToPosition(position4);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 56:
                                this.panoNeighborCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 64:
                                this.hasUserDiscoveredNeighbor = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Tour */
            public static final class Tour extends ExtendableMessageNano<Tour> implements Cloneable {
                public String name;
                public Long playbackMs;

                public Tour() {
                    clear();
                }

                public final Tour clear() {
                    this.name = null;
                    this.playbackMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Tour clone() {
                    try {
                        return (Tour) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.name != null) {
                        codedOutputByteBufferNano.writeString(1, this.name);
                    }
                    if (this.playbackMs != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.playbackMs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.name != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
                    }
                    if (this.playbackMs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, this.playbackMs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final Tour mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.name = codedInputByteBufferNano.readString();
                                continue;
                            case 16:
                                this.playbackMs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$Tutorial */
            public static final class Tutorial extends ExtendableMessageNano<Tutorial> implements Cloneable {
                public Integer stage;
                public String stageName;

                public Tutorial() {
                    clear();
                }

                public final Tutorial clear() {
                    this.stage = null;
                    this.stageName = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Tutorial clone() {
                    try {
                        return (Tutorial) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.stage != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.stage.intValue());
                    }
                    if (this.stageName != null) {
                        codedOutputByteBufferNano.writeString(2, this.stageName);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.stage != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.stage.intValue());
                    }
                    if (this.stageName != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.stageName);
                    }
                    return computeSerializedSize;
                }

                public final Tutorial mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.stage = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 18:
                                this.stageName = codedInputByteBufferNano.readString();
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$View */
            public static final class View extends ExtendableMessageNano<View> implements Cloneable {
                @NanoEnumValue(legacy = false, value = ForceHumanScale.class)
                public Integer forceHumanScale;
                public Double logicalViewerScale;
                @NanoEnumValue(legacy = false, value = Mode.class)
                public Integer mode;
                public Long simulationSecondsSinceEpoch;
                public DoublePrecisionTransform startFromKeyholeTransform;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$View$ForceHumanScale */
                public interface ForceHumanScale {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$View$Mode */
                public interface Mode {
                }

                @NanoEnumValue(legacy = false, value = Mode.class)
                public static int checkModeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Mode").toString());
                }

                @NanoEnumValue(legacy = false, value = ForceHumanScale.class)
                public static int checkForceHumanScaleOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(47).append(i).append(" is not a valid enum ForceHumanScale").toString());
                }

                public View() {
                    clear();
                }

                public final View clear() {
                    this.mode = null;
                    this.startFromKeyholeTransform = null;
                    this.simulationSecondsSinceEpoch = null;
                    this.forceHumanScale = null;
                    this.logicalViewerScale = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final View clone() {
                    try {
                        View view = (View) super.clone();
                        if (this.startFromKeyholeTransform != null) {
                            view.startFromKeyholeTransform = this.startFromKeyholeTransform.clone();
                        }
                        return view;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.mode != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.mode.intValue());
                    }
                    if (this.startFromKeyholeTransform != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.startFromKeyholeTransform);
                    }
                    if (this.simulationSecondsSinceEpoch != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.simulationSecondsSinceEpoch.longValue());
                    }
                    if (this.forceHumanScale != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.forceHumanScale.intValue());
                    }
                    if (this.logicalViewerScale != null) {
                        codedOutputByteBufferNano.writeDouble(5, this.logicalViewerScale.doubleValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.mode != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.mode.intValue());
                    }
                    if (this.startFromKeyholeTransform != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromKeyholeTransform);
                    }
                    if (this.simulationSecondsSinceEpoch != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.simulationSecondsSinceEpoch.longValue());
                    }
                    if (this.forceHumanScale != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.forceHumanScale.intValue());
                    }
                    if (this.logicalViewerScale != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(5, this.logicalViewerScale.doubleValue());
                    }
                    return computeSerializedSize;
                }

                public final View mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.mode = Integer.valueOf(checkModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 18:
                                if (this.startFromKeyholeTransform == null) {
                                    this.startFromKeyholeTransform = new DoublePrecisionTransform();
                                }
                                codedInputByteBufferNano.readMessage(this.startFromKeyholeTransform);
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.simulationSecondsSinceEpoch = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.forceHumanScale = Integer.valueOf(checkForceHumanScaleOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 41:
                                this.logicalViewerScale = Double.valueOf(codedInputByteBufferNano.readDouble());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$VrSdkError */
            public static final class VrSdkError extends ExtendableMessageNano<VrSdkError> implements Cloneable {
                private static volatile VrSdkError[] _emptyArray;
                public Integer sdkErrorCode;
                public String sdkFunction;
                @NanoEnumValue(legacy = false, value = ShutdownReason.class)
                public Integer shutdownReason;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$EarthVr$VrSdkError$ShutdownReason */
                public interface ShutdownReason {
                }

                @NanoEnumValue(legacy = false, value = ShutdownReason.class)
                public static int checkShutdownReasonOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum ShutdownReason").toString());
                }

                public static VrSdkError[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new VrSdkError[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public VrSdkError() {
                    clear();
                }

                public final VrSdkError clear() {
                    this.shutdownReason = null;
                    this.sdkErrorCode = null;
                    this.sdkFunction = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final VrSdkError clone() {
                    try {
                        return (VrSdkError) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.shutdownReason != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.shutdownReason.intValue());
                    }
                    if (this.sdkErrorCode != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.sdkErrorCode.intValue());
                    }
                    if (this.sdkFunction != null) {
                        codedOutputByteBufferNano.writeString(3, this.sdkFunction);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.shutdownReason != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.shutdownReason.intValue());
                    }
                    if (this.sdkErrorCode != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.sdkErrorCode.intValue());
                    }
                    if (this.sdkFunction != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.sdkFunction);
                    }
                    return computeSerializedSize;
                }

                public final VrSdkError mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.shutdownReason = Integer.valueOf(checkShutdownReasonOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.sdkErrorCode = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 26:
                                this.sdkFunction = codedInputByteBufferNano.readString();
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

            public final EarthVr clear() {
                this.startFromKeyholeTransform = null;
                this.startFromHeadTransform = null;
                this.controllerStates = ControllerState.emptyArray();
                this.appState = null;
                this.view = null;
                this.menu = null;
                this.preferences = null;
                this.preferencesDelta = null;
                this.tour = null;
                this.tutorial = null;
                this.actors = Actor.emptyArray();
                this.environment = null;
                this.splashScreen = null;
                this.streetView = null;
                this.actionOrb = null;
                this.search = null;
                this.errors = VrSdkError.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final EarthVr clone() {
                try {
                    EarthVr earthVr = (EarthVr) super.clone();
                    if (this.startFromKeyholeTransform != null) {
                        earthVr.startFromKeyholeTransform = this.startFromKeyholeTransform.clone();
                    }
                    if (this.startFromHeadTransform != null) {
                        earthVr.startFromHeadTransform = this.startFromHeadTransform.clone();
                    }
                    if (this.controllerStates != null && this.controllerStates.length > 0) {
                        earthVr.controllerStates = new ControllerState[this.controllerStates.length];
                        for (int i = 0; i < this.controllerStates.length; i++) {
                            if (this.controllerStates[i] != null) {
                                earthVr.controllerStates[i] = this.controllerStates[i].clone();
                            }
                        }
                    }
                    if (this.appState != null) {
                        earthVr.appState = this.appState.clone();
                    }
                    if (this.view != null) {
                        earthVr.view = this.view.clone();
                    }
                    if (this.menu != null) {
                        earthVr.menu = this.menu.clone();
                    }
                    if (this.preferences != null) {
                        earthVr.preferences = this.preferences.clone();
                    }
                    if (this.preferencesDelta != null) {
                        earthVr.preferencesDelta = this.preferencesDelta.clone();
                    }
                    if (this.tour != null) {
                        earthVr.tour = this.tour.clone();
                    }
                    if (this.tutorial != null) {
                        earthVr.tutorial = this.tutorial.clone();
                    }
                    if (this.actors != null && this.actors.length > 0) {
                        earthVr.actors = new Actor[this.actors.length];
                        for (int i2 = 0; i2 < this.actors.length; i2++) {
                            if (this.actors[i2] != null) {
                                earthVr.actors[i2] = this.actors[i2].clone();
                            }
                        }
                    }
                    if (this.environment != null) {
                        earthVr.environment = this.environment.clone();
                    }
                    if (this.splashScreen != null) {
                        earthVr.splashScreen = this.splashScreen.clone();
                    }
                    if (this.streetView != null) {
                        earthVr.streetView = this.streetView.clone();
                    }
                    if (this.actionOrb != null) {
                        earthVr.actionOrb = this.actionOrb.clone();
                    }
                    if (this.search != null) {
                        earthVr.search = this.search.clone();
                    }
                    if (this.errors != null && this.errors.length > 0) {
                        earthVr.errors = new VrSdkError[this.errors.length];
                        for (int i3 = 0; i3 < this.errors.length; i3++) {
                            if (this.errors[i3] != null) {
                                earthVr.errors[i3] = this.errors[i3].clone();
                            }
                        }
                    }
                    return earthVr;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.startFromKeyholeTransform != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.startFromKeyholeTransform);
                }
                if (this.startFromHeadTransform != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.startFromHeadTransform);
                }
                if (this.controllerStates != null && this.controllerStates.length > 0) {
                    for (ControllerState controllerState : this.controllerStates) {
                        if (controllerState != null) {
                            codedOutputByteBufferNano.writeMessage(3, controllerState);
                        }
                    }
                }
                if (this.appState != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.appState);
                }
                if (this.view != null) {
                    codedOutputByteBufferNano.writeMessage(5, this.view);
                }
                if (this.menu != null) {
                    codedOutputByteBufferNano.writeMessage(6, this.menu);
                }
                if (this.preferences != null) {
                    codedOutputByteBufferNano.writeMessage(7, this.preferences);
                }
                if (this.tour != null) {
                    codedOutputByteBufferNano.writeMessage(8, this.tour);
                }
                if (this.tutorial != null) {
                    codedOutputByteBufferNano.writeMessage(9, this.tutorial);
                }
                if (this.actors != null && this.actors.length > 0) {
                    for (Actor actor : this.actors) {
                        if (actor != null) {
                            codedOutputByteBufferNano.writeMessage(10, actor);
                        }
                    }
                }
                if (this.environment != null) {
                    codedOutputByteBufferNano.writeMessage(11, this.environment);
                }
                if (this.splashScreen != null) {
                    codedOutputByteBufferNano.writeMessage(12, this.splashScreen);
                }
                if (this.search != null) {
                    codedOutputByteBufferNano.writeMessage(13, this.search);
                }
                if (this.preferencesDelta != null) {
                    codedOutputByteBufferNano.writeMessage(14, this.preferencesDelta);
                }
                if (this.errors != null && this.errors.length > 0) {
                    for (VrSdkError vrSdkError : this.errors) {
                        if (vrSdkError != null) {
                            codedOutputByteBufferNano.writeMessage(15, vrSdkError);
                        }
                    }
                }
                if (this.streetView != null) {
                    codedOutputByteBufferNano.writeMessage(16, this.streetView);
                }
                if (this.actionOrb != null) {
                    codedOutputByteBufferNano.writeMessage(17, this.actionOrb);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.startFromKeyholeTransform != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.startFromKeyholeTransform);
                }
                if (this.startFromHeadTransform != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromHeadTransform);
                }
                if (this.controllerStates != null && this.controllerStates.length > 0) {
                    int i = computeSerializedSize;
                    for (ControllerState controllerState : this.controllerStates) {
                        if (controllerState != null) {
                            i += CodedOutputByteBufferNano.computeMessageSize(3, controllerState);
                        }
                    }
                    computeSerializedSize = i;
                }
                if (this.appState != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.appState);
                }
                if (this.view != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.view);
                }
                if (this.menu != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, this.menu);
                }
                if (this.preferences != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, this.preferences);
                }
                if (this.tour != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, this.tour);
                }
                if (this.tutorial != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, this.tutorial);
                }
                if (this.actors != null && this.actors.length > 0) {
                    int i2 = computeSerializedSize;
                    for (Actor actor : this.actors) {
                        if (actor != null) {
                            i2 += CodedOutputByteBufferNano.computeMessageSize(10, actor);
                        }
                    }
                    computeSerializedSize = i2;
                }
                if (this.environment != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, this.environment);
                }
                if (this.splashScreen != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, this.splashScreen);
                }
                if (this.search != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, this.search);
                }
                if (this.preferencesDelta != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, this.preferencesDelta);
                }
                if (this.errors != null && this.errors.length > 0) {
                    for (VrSdkError vrSdkError : this.errors) {
                        if (vrSdkError != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, vrSdkError);
                        }
                    }
                }
                if (this.streetView != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, this.streetView);
                }
                if (this.actionOrb != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(17, this.actionOrb);
                }
                return computeSerializedSize;
            }

            public final EarthVr mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.startFromKeyholeTransform == null) {
                                this.startFromKeyholeTransform = new DoublePrecisionTransform();
                            }
                            codedInputByteBufferNano.readMessage(this.startFromKeyholeTransform);
                            continue;
                        case 18:
                            if (this.startFromHeadTransform == null) {
                                this.startFromHeadTransform = new Transform();
                            }
                            codedInputByteBufferNano.readMessage(this.startFromHeadTransform);
                            continue;
                        case 26:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            int length = this.controllerStates == null ? 0 : this.controllerStates.length;
                            ControllerState[] controllerStateArr = new ControllerState[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.controllerStates, 0, controllerStateArr, 0, length);
                            }
                            while (length < controllerStateArr.length - 1) {
                                controllerStateArr[length] = new ControllerState();
                                codedInputByteBufferNano.readMessage(controllerStateArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            controllerStateArr[length] = new ControllerState();
                            codedInputByteBufferNano.readMessage(controllerStateArr[length]);
                            this.controllerStates = controllerStateArr;
                            continue;
                        case 34:
                            if (this.appState == null) {
                                this.appState = new AppState();
                            }
                            codedInputByteBufferNano.readMessage(this.appState);
                            continue;
                        case 42:
                            if (this.view == null) {
                                this.view = new View();
                            }
                            codedInputByteBufferNano.readMessage(this.view);
                            continue;
                        case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                            if (this.menu == null) {
                                this.menu = new Menu();
                            }
                            codedInputByteBufferNano.readMessage(this.menu);
                            continue;
                        case 58:
                            if (this.preferences == null) {
                                this.preferences = new Preferences();
                            }
                            codedInputByteBufferNano.readMessage(this.preferences);
                            continue;
                        case 66:
                            if (this.tour == null) {
                                this.tour = new Tour();
                            }
                            codedInputByteBufferNano.readMessage(this.tour);
                            continue;
                        case 74:
                            if (this.tutorial == null) {
                                this.tutorial = new Tutorial();
                            }
                            codedInputByteBufferNano.readMessage(this.tutorial);
                            continue;
                        case 82:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                            int length2 = this.actors == null ? 0 : this.actors.length;
                            Actor[] actorArr = new Actor[(repeatedFieldArrayLength2 + length2)];
                            if (length2 != 0) {
                                System.arraycopy(this.actors, 0, actorArr, 0, length2);
                            }
                            while (length2 < actorArr.length - 1) {
                                actorArr[length2] = new Actor();
                                codedInputByteBufferNano.readMessage(actorArr[length2]);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            actorArr[length2] = new Actor();
                            codedInputByteBufferNano.readMessage(actorArr[length2]);
                            this.actors = actorArr;
                            continue;
                        case 90:
                            if (this.environment == null) {
                                this.environment = new Environment();
                            }
                            codedInputByteBufferNano.readMessage(this.environment);
                            continue;
                        case 98:
                            if (this.splashScreen == null) {
                                this.splashScreen = new SplashScreen();
                            }
                            codedInputByteBufferNano.readMessage(this.splashScreen);
                            continue;
                        case 106:
                            if (this.search == null) {
                                this.search = new Search();
                            }
                            codedInputByteBufferNano.readMessage(this.search);
                            continue;
                        case 114:
                            if (this.preferencesDelta == null) {
                                this.preferencesDelta = new Preferences();
                            }
                            codedInputByteBufferNano.readMessage(this.preferencesDelta);
                            continue;
                        case 122:
                            int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                            int length3 = this.errors == null ? 0 : this.errors.length;
                            VrSdkError[] vrSdkErrorArr = new VrSdkError[(repeatedFieldArrayLength3 + length3)];
                            if (length3 != 0) {
                                System.arraycopy(this.errors, 0, vrSdkErrorArr, 0, length3);
                            }
                            while (length3 < vrSdkErrorArr.length - 1) {
                                vrSdkErrorArr[length3] = new VrSdkError();
                                codedInputByteBufferNano.readMessage(vrSdkErrorArr[length3]);
                                codedInputByteBufferNano.readTag();
                                length3++;
                            }
                            vrSdkErrorArr[length3] = new VrSdkError();
                            codedInputByteBufferNano.readMessage(vrSdkErrorArr[length3]);
                            this.errors = vrSdkErrorArr;
                            continue;
                        case 130:
                            if (this.streetView == null) {
                                this.streetView = new StreetView();
                            }
                            codedInputByteBufferNano.readMessage(this.streetView);
                            continue;
                        case 138:
                            if (this.actionOrb == null) {
                                this.actionOrb = new ActionOrb();
                            }
                            codedInputByteBufferNano.readMessage(this.actionOrb);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva */
        public static final class Eva extends ExtendableMessageNano<Eva> implements Cloneable {
            public BluetoothSession bluetoothSession;
            public CameraStatus cameraStatus;
            public CameraInfo cameraType;
            public Capture capture;
            public Delete delete;
            public FileTransfer fileTransfer;
            public LocalGalleryStats localGalleryStats;
            public Pairing pairing;
            public Share share;
            public View view;
            public WifiSetupSession wifiSetupSession;

            public Eva() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Capture */
            public static final class Capture extends ExtendableMessageNano<Capture> implements Cloneable {
                @NanoEnumValue(legacy = false, value = CaptureType.class)
                public Integer captureType;
                public LiveStreamStats liveStreamStats;
                public Resolution resolution;
                public VideoInfo videoInfo;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Capture$CaptureType */
                public interface CaptureType {
                }

                @NanoEnumValue(legacy = false, value = CaptureType.class)
                public static int checkCaptureTypeOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum CaptureType").toString());
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Capture$LiveStreamStats */
                public static final class LiveStreamStats extends ExtendableMessageNano<LiveStreamStats> implements Cloneable {
                    public Long averageSourceBitrate;
                    public Long averageTargetBitrate;
                    public Long averageUploadBitrate;
                    @NanoEnumValue(legacy = false, value = LiveStreamError.class)
                    public Integer errorState;

                    /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Capture$LiveStreamStats$LiveStreamError */
                    public interface LiveStreamError {
                    }

                    @NanoEnumValue(legacy = false, value = LiveStreamError.class)
                    public static int checkLiveStreamErrorOrThrow(int i) {
                        if (i >= 0 && i <= 6) {
                            return i;
                        }
                        throw new IllegalArgumentException(new StringBuilder(47).append(i).append(" is not a valid enum LiveStreamError").toString());
                    }

                    public LiveStreamStats() {
                        clear();
                    }

                    public final LiveStreamStats clear() {
                        this.errorState = null;
                        this.averageUploadBitrate = null;
                        this.averageSourceBitrate = null;
                        this.averageTargetBitrate = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final LiveStreamStats clone() {
                        try {
                            return (LiveStreamStats) super.clone();
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.errorState != null) {
                            codedOutputByteBufferNano.writeInt32(1, this.errorState.intValue());
                        }
                        if (this.averageUploadBitrate != null) {
                            codedOutputByteBufferNano.writeInt64(2, this.averageUploadBitrate.longValue());
                        }
                        if (this.averageSourceBitrate != null) {
                            codedOutputByteBufferNano.writeInt64(3, this.averageSourceBitrate.longValue());
                        }
                        if (this.averageTargetBitrate != null) {
                            codedOutputByteBufferNano.writeInt64(4, this.averageTargetBitrate.longValue());
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.errorState != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.errorState.intValue());
                        }
                        if (this.averageUploadBitrate != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.averageUploadBitrate.longValue());
                        }
                        if (this.averageSourceBitrate != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.averageSourceBitrate.longValue());
                        }
                        if (this.averageTargetBitrate != null) {
                            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, this.averageTargetBitrate.longValue());
                        }
                        return computeSerializedSize;
                    }

                    public final LiveStreamStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    int position = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.errorState = Integer.valueOf(checkLiveStreamErrorOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
                                case 16:
                                    this.averageUploadBitrate = Long.valueOf(codedInputByteBufferNano.readInt64());
                                    continue;
                                case AndroidNCompat.N_SDK_LEVEL:
                                    this.averageSourceBitrate = Long.valueOf(codedInputByteBufferNano.readInt64());
                                    continue;
                                case 32:
                                    this.averageTargetBitrate = Long.valueOf(codedInputByteBufferNano.readInt64());
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

                public Capture() {
                    clear();
                }

                public final Capture clear() {
                    this.captureType = null;
                    this.resolution = null;
                    this.videoInfo = null;
                    this.liveStreamStats = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Capture clone() {
                    try {
                        Capture capture = (Capture) super.clone();
                        if (this.resolution != null) {
                            capture.resolution = this.resolution.clone();
                        }
                        if (this.videoInfo != null) {
                            capture.videoInfo = this.videoInfo.clone();
                        }
                        if (this.liveStreamStats != null) {
                            capture.liveStreamStats = this.liveStreamStats.clone();
                        }
                        return capture;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.captureType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.captureType.intValue());
                    }
                    if (this.resolution != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.resolution);
                    }
                    if (this.videoInfo != null) {
                        codedOutputByteBufferNano.writeMessage(3, this.videoInfo);
                    }
                    if (this.liveStreamStats != null) {
                        codedOutputByteBufferNano.writeMessage(10, this.liveStreamStats);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.captureType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.captureType.intValue());
                    }
                    if (this.resolution != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.resolution);
                    }
                    if (this.videoInfo != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.videoInfo);
                    }
                    if (this.liveStreamStats != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, this.liveStreamStats);
                    }
                    return computeSerializedSize;
                }

                public final Capture mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.captureType = Integer.valueOf(checkCaptureTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 18:
                                if (this.resolution == null) {
                                    this.resolution = new Resolution();
                                }
                                codedInputByteBufferNano.readMessage(this.resolution);
                                continue;
                            case 26:
                                if (this.videoInfo == null) {
                                    this.videoInfo = new VideoInfo();
                                }
                                codedInputByteBufferNano.readMessage(this.videoInfo);
                                continue;
                            case 82:
                                if (this.liveStreamStats == null) {
                                    this.liveStreamStats = new LiveStreamStats();
                                }
                                codedInputByteBufferNano.readMessage(this.liveStreamStats);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$BluetoothSession */
            public static final class BluetoothSession extends ExtendableMessageNano<BluetoothSession> implements Cloneable {
                public Integer failedRequestCount;
                public Long receivedBytes;
                public Integer requestCount;
                public Long sentBytes;
                public Integer statusUpdateNotificationCount;
                public Long totalLatencyMs;

                public BluetoothSession() {
                    clear();
                }

                public final BluetoothSession clear() {
                    this.requestCount = null;
                    this.failedRequestCount = null;
                    this.totalLatencyMs = null;
                    this.sentBytes = null;
                    this.receivedBytes = null;
                    this.statusUpdateNotificationCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final BluetoothSession clone() {
                    try {
                        return (BluetoothSession) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.requestCount != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.requestCount.intValue());
                    }
                    if (this.failedRequestCount != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.failedRequestCount.intValue());
                    }
                    if (this.totalLatencyMs != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.totalLatencyMs.longValue());
                    }
                    if (this.sentBytes != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.sentBytes.longValue());
                    }
                    if (this.receivedBytes != null) {
                        codedOutputByteBufferNano.writeInt64(5, this.receivedBytes.longValue());
                    }
                    if (this.statusUpdateNotificationCount != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.statusUpdateNotificationCount.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.requestCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.requestCount.intValue());
                    }
                    if (this.failedRequestCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.failedRequestCount.intValue());
                    }
                    if (this.totalLatencyMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.totalLatencyMs.longValue());
                    }
                    if (this.sentBytes != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.sentBytes.longValue());
                    }
                    if (this.receivedBytes != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, this.receivedBytes.longValue());
                    }
                    if (this.statusUpdateNotificationCount != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, this.statusUpdateNotificationCount.intValue());
                    }
                    return computeSerializedSize;
                }

                public final BluetoothSession mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.requestCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.failedRequestCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.totalLatencyMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.sentBytes = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 40:
                                this.receivedBytes = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 48:
                                this.statusUpdateNotificationCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$CameraInfo */
            public static final class CameraInfo extends ExtendableMessageNano<CameraInfo> implements Cloneable {
                @NanoEnumValue(legacy = false, value = CameraType.class)
                public Integer cameraType;
                public String firmwareVersion;
                public String manufacturerName;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$CameraInfo$CameraType */
                public interface CameraType {
                }

                @NanoEnumValue(legacy = false, value = CameraType.class)
                public static int checkCameraTypeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum CameraType").toString());
                }

                public CameraInfo() {
                    clear();
                }

                public final CameraInfo clear() {
                    this.cameraType = null;
                    this.firmwareVersion = null;
                    this.manufacturerName = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final CameraInfo clone() {
                    try {
                        return (CameraInfo) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.cameraType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.cameraType.intValue());
                    }
                    if (this.firmwareVersion != null) {
                        codedOutputByteBufferNano.writeString(2, this.firmwareVersion);
                    }
                    if (this.manufacturerName != null) {
                        codedOutputByteBufferNano.writeString(3, this.manufacturerName);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.cameraType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.cameraType.intValue());
                    }
                    if (this.firmwareVersion != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.firmwareVersion);
                    }
                    if (this.manufacturerName != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.manufacturerName);
                    }
                    return computeSerializedSize;
                }

                public final CameraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.cameraType = Integer.valueOf(checkCameraTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 18:
                                this.firmwareVersion = codedInputByteBufferNano.readString();
                                continue;
                            case 26:
                                this.manufacturerName = codedInputByteBufferNano.readString();
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$CameraStatus */
            public static final class CameraStatus extends ExtendableMessageNano<CameraStatus> implements Cloneable {
                public Boolean batteryCharging;
                public Integer batteryPercentage;
                public Boolean connectedToWifi;
                public Integer deviceTemperature;
                public Long freeStorage;
                public Integer mediaCount;
                public Boolean phoneToCameraWifi;
                public Boolean recording;
                @NanoEnumValue(legacy = false, value = TemperatureState.class)
                public Integer temperatureState;
                public Long totalStorage;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$CameraStatus$TemperatureState */
                public interface TemperatureState {
                }

                @NanoEnumValue(legacy = false, value = TemperatureState.class)
                public static int checkTemperatureStateOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(48).append(i).append(" is not a valid enum TemperatureState").toString());
                }

                public CameraStatus() {
                    clear();
                }

                public final CameraStatus clear() {
                    this.recording = null;
                    this.batteryPercentage = null;
                    this.batteryCharging = null;
                    this.deviceTemperature = null;
                    this.totalStorage = null;
                    this.freeStorage = null;
                    this.connectedToWifi = null;
                    this.phoneToCameraWifi = null;
                    this.temperatureState = null;
                    this.mediaCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final CameraStatus clone() {
                    try {
                        return (CameraStatus) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.recording != null) {
                        codedOutputByteBufferNano.writeBool(1, this.recording.booleanValue());
                    }
                    if (this.batteryPercentage != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.batteryPercentage.intValue());
                    }
                    if (this.batteryCharging != null) {
                        codedOutputByteBufferNano.writeBool(3, this.batteryCharging.booleanValue());
                    }
                    if (this.deviceTemperature != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.deviceTemperature.intValue());
                    }
                    if (this.totalStorage != null) {
                        codedOutputByteBufferNano.writeInt64(5, this.totalStorage.longValue());
                    }
                    if (this.freeStorage != null) {
                        codedOutputByteBufferNano.writeInt64(6, this.freeStorage.longValue());
                    }
                    if (this.connectedToWifi != null) {
                        codedOutputByteBufferNano.writeBool(7, this.connectedToWifi.booleanValue());
                    }
                    if (this.phoneToCameraWifi != null) {
                        codedOutputByteBufferNano.writeBool(8, this.phoneToCameraWifi.booleanValue());
                    }
                    if (this.temperatureState != null) {
                        codedOutputByteBufferNano.writeInt32(9, this.temperatureState.intValue());
                    }
                    if (this.mediaCount != null) {
                        codedOutputByteBufferNano.writeInt32(10, this.mediaCount.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.recording != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.recording.booleanValue());
                    }
                    if (this.batteryPercentage != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.batteryPercentage.intValue());
                    }
                    if (this.batteryCharging != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.batteryCharging.booleanValue());
                    }
                    if (this.deviceTemperature != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.deviceTemperature.intValue());
                    }
                    if (this.totalStorage != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, this.totalStorage.longValue());
                    }
                    if (this.freeStorage != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, this.freeStorage.longValue());
                    }
                    if (this.connectedToWifi != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.connectedToWifi.booleanValue());
                    }
                    if (this.phoneToCameraWifi != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, this.phoneToCameraWifi.booleanValue());
                    }
                    if (this.temperatureState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, this.temperatureState.intValue());
                    }
                    if (this.mediaCount != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, this.mediaCount.intValue());
                    }
                    return computeSerializedSize;
                }

                public final CameraStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.recording = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 16:
                                this.batteryPercentage = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.batteryCharging = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 32:
                                this.deviceTemperature = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 40:
                                this.totalStorage = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 48:
                                this.freeStorage = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 56:
                                this.connectedToWifi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 64:
                                this.phoneToCameraWifi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 72:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.temperatureState = Integer.valueOf(checkTemperatureStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 80:
                                this.mediaCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Delete */
            public static final class Delete extends ExtendableMessageNano<Delete> implements Cloneable {
                @NanoEnumValue(legacy = false, value = View.MediaType.class)
                public Integer mediaType;
                public Long sizeBytes;
                @NanoEnumValue(legacy = false, value = View.ViewSource.class)
                public Integer source;

                public Delete() {
                    clear();
                }

                public final Delete clear() {
                    this.mediaType = null;
                    this.source = null;
                    this.sizeBytes = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Delete clone() {
                    try {
                        return (Delete) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.mediaType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.mediaType.intValue());
                    }
                    if (this.source != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.source.intValue());
                    }
                    if (this.sizeBytes != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.sizeBytes.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.mediaType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.mediaType.intValue());
                    }
                    if (this.source != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.source.intValue());
                    }
                    if (this.sizeBytes != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, this.sizeBytes.longValue());
                    }
                    return computeSerializedSize;
                }

                public final Delete mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.mediaType = Integer.valueOf(View.checkMediaTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.source = Integer.valueOf(View.checkViewSourceOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.sizeBytes = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$FileTransfer */
            public static final class FileTransfer extends ExtendableMessageNano<FileTransfer> implements Cloneable {
                public Long fileSize;
                @NanoEnumValue(legacy = false, value = FileType.class)
                public Integer fileType;
                @NanoEnumValue(legacy = false, value = Outcome.class)
                public Integer outcome;
                public Resolution resolution;
                @NanoEnumValue(legacy = false, value = TransferInterface.class)
                public Integer transferInterface;
                public Long transferTimeMs;
                public VideoInfo videoInfo;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$FileTransfer$FileType */
                public interface FileType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$FileTransfer$Outcome */
                public interface Outcome {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$FileTransfer$TransferInterface */
                public interface TransferInterface {
                }

                @NanoEnumValue(legacy = false, value = Outcome.class)
                public static int checkOutcomeOrThrow(int i) {
                    if (i >= 0 && i <= 5) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append(i).append(" is not a valid enum Outcome").toString());
                }

                @NanoEnumValue(legacy = false, value = TransferInterface.class)
                public static int checkTransferInterfaceOrThrow(int i) {
                    if (i >= 0 && i <= 5) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(49).append(i).append(" is not a valid enum TransferInterface").toString());
                }

                @NanoEnumValue(legacy = false, value = FileType.class)
                public static int checkFileTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum FileType").toString());
                }

                public FileTransfer() {
                    clear();
                }

                public final FileTransfer clear() {
                    this.outcome = null;
                    this.transferInterface = null;
                    this.fileSize = null;
                    this.transferTimeMs = null;
                    this.fileType = null;
                    this.resolution = null;
                    this.videoInfo = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final FileTransfer clone() {
                    try {
                        FileTransfer fileTransfer = (FileTransfer) super.clone();
                        if (this.resolution != null) {
                            fileTransfer.resolution = this.resolution.clone();
                        }
                        if (this.videoInfo != null) {
                            fileTransfer.videoInfo = this.videoInfo.clone();
                        }
                        return fileTransfer;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.outcome != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.outcome.intValue());
                    }
                    if (this.transferInterface != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.transferInterface.intValue());
                    }
                    if (this.fileSize != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.fileSize.longValue());
                    }
                    if (this.transferTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.transferTimeMs.longValue());
                    }
                    if (this.fileType != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.fileType.intValue());
                    }
                    if (this.resolution != null) {
                        codedOutputByteBufferNano.writeMessage(6, this.resolution);
                    }
                    if (this.videoInfo != null) {
                        codedOutputByteBufferNano.writeMessage(7, this.videoInfo);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.outcome != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.outcome.intValue());
                    }
                    if (this.transferInterface != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.transferInterface.intValue());
                    }
                    if (this.fileSize != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.fileSize.longValue());
                    }
                    if (this.transferTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.transferTimeMs.longValue());
                    }
                    if (this.fileType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.fileType.intValue());
                    }
                    if (this.resolution != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, this.resolution);
                    }
                    if (this.videoInfo != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, this.videoInfo);
                    }
                    return computeSerializedSize;
                }

                public final FileTransfer mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.outcome = Integer.valueOf(checkOutcomeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.transferInterface = Integer.valueOf(checkTransferInterfaceOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.fileSize = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.transferTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 40:
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.fileType = Integer.valueOf(checkFileTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                                if (this.resolution == null) {
                                    this.resolution = new Resolution();
                                }
                                codedInputByteBufferNano.readMessage(this.resolution);
                                continue;
                            case 58:
                                if (this.videoInfo == null) {
                                    this.videoInfo = new VideoInfo();
                                }
                                codedInputByteBufferNano.readMessage(this.videoInfo);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$LocalGalleryStats */
            public static final class LocalGalleryStats extends ExtendableMessageNano<LocalGalleryStats> implements Cloneable {
                public Long availableBytes;
                public Long mediaBytes;
                public Integer mediaCount;

                public LocalGalleryStats() {
                    clear();
                }

                public final LocalGalleryStats clear() {
                    this.mediaCount = null;
                    this.availableBytes = null;
                    this.mediaBytes = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final LocalGalleryStats clone() {
                    try {
                        return (LocalGalleryStats) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.mediaCount != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.mediaCount.intValue());
                    }
                    if (this.availableBytes != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.availableBytes.longValue());
                    }
                    if (this.mediaBytes != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.mediaBytes.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.mediaCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.mediaCount.intValue());
                    }
                    if (this.availableBytes != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.availableBytes.longValue());
                    }
                    if (this.mediaBytes != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, this.mediaBytes.longValue());
                    }
                    return computeSerializedSize;
                }

                public final LocalGalleryStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.mediaCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.availableBytes = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.mediaBytes = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Pairing */
            public static final class Pairing extends ExtendableMessageNano<Pairing> implements Cloneable {
                public Long bluetoothPairingTimeMs;
                @NanoEnumValue(legacy = false, value = Outcome.class)
                public Integer outcome;
                public Long pairingFlowTimeMs;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Pairing$Outcome */
                public interface Outcome {
                }

                @NanoEnumValue(legacy = false, value = Outcome.class)
                public static int checkOutcomeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append(i).append(" is not a valid enum Outcome").toString());
                }

                public Pairing() {
                    clear();
                }

                public final Pairing clear() {
                    this.outcome = null;
                    this.pairingFlowTimeMs = null;
                    this.bluetoothPairingTimeMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Pairing clone() {
                    try {
                        return (Pairing) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.outcome != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.outcome.intValue());
                    }
                    if (this.pairingFlowTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.pairingFlowTimeMs.longValue());
                    }
                    if (this.bluetoothPairingTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.bluetoothPairingTimeMs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.outcome != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.outcome.intValue());
                    }
                    if (this.pairingFlowTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.pairingFlowTimeMs.longValue());
                    }
                    if (this.bluetoothPairingTimeMs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, this.bluetoothPairingTimeMs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final Pairing mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.outcome = Integer.valueOf(checkOutcomeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.pairingFlowTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.bluetoothPairingTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Resolution */
            public static final class Resolution extends ExtendableMessageNano<Resolution> implements Cloneable {
                public Integer height;
                public Integer width;

                public Resolution() {
                    clear();
                }

                public final Resolution clear() {
                    this.width = null;
                    this.height = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Resolution clone() {
                    try {
                        return (Resolution) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.width != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.width.intValue());
                    }
                    if (this.height != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.height.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.width != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.width.intValue());
                    }
                    if (this.height != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.height.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Resolution mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.width = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.height = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Share */
            public static final class Share extends ExtendableMessageNano<Share> implements Cloneable {
                public Resolution resolution;
                @NanoEnumValue(legacy = false, value = ShareApp.class)
                public Integer shareApp;
                @NanoEnumValue(legacy = false, value = ShareType.class)
                public Integer shareType;
                public VideoInfo videoInfo;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Share$ShareApp */
                public interface ShareApp {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$Share$ShareType */
                public interface ShareType {
                }

                @NanoEnumValue(legacy = false, value = ShareType.class)
                public static int checkShareTypeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum ShareType").toString());
                }

                @NanoEnumValue(legacy = false, value = ShareApp.class)
                public static int checkShareAppOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum ShareApp").toString());
                }

                public Share() {
                    clear();
                }

                public final Share clear() {
                    this.shareType = null;
                    this.shareApp = null;
                    this.resolution = null;
                    this.videoInfo = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Share clone() {
                    try {
                        Share share = (Share) super.clone();
                        if (this.resolution != null) {
                            share.resolution = this.resolution.clone();
                        }
                        if (this.videoInfo != null) {
                            share.videoInfo = this.videoInfo.clone();
                        }
                        return share;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.shareType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.shareType.intValue());
                    }
                    if (this.shareApp != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.shareApp.intValue());
                    }
                    if (this.resolution != null) {
                        codedOutputByteBufferNano.writeMessage(3, this.resolution);
                    }
                    if (this.videoInfo != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.videoInfo);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.shareType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.shareType.intValue());
                    }
                    if (this.shareApp != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.shareApp.intValue());
                    }
                    if (this.resolution != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.resolution);
                    }
                    if (this.videoInfo != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.videoInfo);
                    }
                    return computeSerializedSize;
                }

                public final Share mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.shareType = Integer.valueOf(checkShareTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.shareApp = Integer.valueOf(checkShareAppOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 26:
                                if (this.resolution == null) {
                                    this.resolution = new Resolution();
                                }
                                codedInputByteBufferNano.readMessage(this.resolution);
                                continue;
                            case 34:
                                if (this.videoInfo == null) {
                                    this.videoInfo = new VideoInfo();
                                }
                                codedInputByteBufferNano.readMessage(this.videoInfo);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$VideoInfo */
            public static final class VideoInfo extends ExtendableMessageNano<VideoInfo> implements Cloneable {
                @NanoEnumValue(legacy = false, value = Codec.class)
                public Integer codec;
                public Long durationMs;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$VideoInfo$Codec */
                public interface Codec {
                }

                @NanoEnumValue(legacy = false, value = Codec.class)
                public static int checkCodecOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(37).append(i).append(" is not a valid enum Codec").toString());
                }

                public VideoInfo() {
                    clear();
                }

                public final VideoInfo clear() {
                    this.durationMs = null;
                    this.codec = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final VideoInfo clone() {
                    try {
                        return (VideoInfo) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.durationMs != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.durationMs.longValue());
                    }
                    if (this.codec != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.codec.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.durationMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.durationMs.longValue());
                    }
                    if (this.codec != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.codec.intValue());
                    }
                    return computeSerializedSize;
                }

                public final VideoInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.durationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 16:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.codec = Integer.valueOf(checkCodecOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$View */
            public static final class View extends ExtendableMessageNano<View> implements Cloneable {
                public Long loadingTimeMs;
                public Integer mediaHeadingRotation;
                @NanoEnumValue(legacy = false, value = MediaType.class)
                public Integer mediaType;
                @NanoEnumValue(legacy = false, value = ViewSource.class)
                public Integer viewSource;
                @NanoEnumValue(legacy = false, value = ViewType.class)
                public Integer viewType;
                public Integer viewerHeadingRotation;
                public Long viewingDurationMs;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$View$MediaType */
                public interface MediaType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$View$ViewSource */
                public interface ViewSource {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$View$ViewType */
                public interface ViewType {
                }

                @NanoEnumValue(legacy = false, value = MediaType.class)
                public static int checkMediaTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum MediaType").toString());
                }

                @NanoEnumValue(legacy = false, value = ViewType.class)
                public static int checkViewTypeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum ViewType").toString());
                }

                @NanoEnumValue(legacy = false, value = ViewSource.class)
                public static int checkViewSourceOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum ViewSource").toString());
                }

                public View() {
                    clear();
                }

                public final View clear() {
                    this.mediaType = null;
                    this.viewType = null;
                    this.viewingDurationMs = null;
                    this.loadingTimeMs = null;
                    this.viewSource = null;
                    this.viewerHeadingRotation = null;
                    this.mediaHeadingRotation = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final View clone() {
                    try {
                        return (View) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.mediaType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.mediaType.intValue());
                    }
                    if (this.viewType != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.viewType.intValue());
                    }
                    if (this.viewingDurationMs != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.viewingDurationMs.longValue());
                    }
                    if (this.loadingTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.loadingTimeMs.longValue());
                    }
                    if (this.viewSource != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.viewSource.intValue());
                    }
                    if (this.viewerHeadingRotation != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.viewerHeadingRotation.intValue());
                    }
                    if (this.mediaHeadingRotation != null) {
                        codedOutputByteBufferNano.writeInt32(7, this.mediaHeadingRotation.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.mediaType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.mediaType.intValue());
                    }
                    if (this.viewType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.viewType.intValue());
                    }
                    if (this.viewingDurationMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.viewingDurationMs.longValue());
                    }
                    if (this.loadingTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.loadingTimeMs.longValue());
                    }
                    if (this.viewSource != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.viewSource.intValue());
                    }
                    if (this.viewerHeadingRotation != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.viewerHeadingRotation.intValue());
                    }
                    if (this.mediaHeadingRotation != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, this.mediaHeadingRotation.intValue());
                    }
                    return computeSerializedSize;
                }

                public final View mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.mediaType = Integer.valueOf(checkMediaTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.viewType = Integer.valueOf(checkViewTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.viewingDurationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.loadingTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 40:
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.viewSource = Integer.valueOf(checkViewSourceOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 48:
                                this.viewerHeadingRotation = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 56:
                                this.mediaHeadingRotation = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$WifiSetupSession */
            public static final class WifiSetupSession extends ExtendableMessageNano<WifiSetupSession> implements Cloneable {
                @NanoEnumValue(legacy = false, value = WifiConnectionAttemptType.class)
                public Integer connectionAttemptType;
                @NanoEnumValue(legacy = false, value = WifiConnectionType.class)
                public Integer connectionType;
                public Integer connectivityCheckFailCount;
                public Long hotspotStartTimeMs;
                public Long joinTimeMs;
                public Integer managedConnectionApiErrorCount;
                public Integer managedConnectionFailCount;
                public Long setupTimeMs;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$WifiSetupSession$WifiConnectionAttemptType */
                public interface WifiConnectionAttemptType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Eva$WifiSetupSession$WifiConnectionType */
                public interface WifiConnectionType {
                }

                @NanoEnumValue(legacy = false, value = WifiConnectionType.class)
                public static int checkWifiConnectionTypeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(50).append(i).append(" is not a valid enum WifiConnectionType").toString());
                }

                @NanoEnumValue(legacy = false, value = WifiConnectionAttemptType.class)
                public static int checkWifiConnectionAttemptTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(57).append(i).append(" is not a valid enum WifiConnectionAttemptType").toString());
                }

                public WifiSetupSession() {
                    clear();
                }

                public final WifiSetupSession clear() {
                    this.connectionType = null;
                    this.setupTimeMs = null;
                    this.hotspotStartTimeMs = null;
                    this.joinTimeMs = null;
                    this.connectivityCheckFailCount = null;
                    this.connectionAttemptType = null;
                    this.managedConnectionFailCount = null;
                    this.managedConnectionApiErrorCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final WifiSetupSession clone() {
                    try {
                        return (WifiSetupSession) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.connectionType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.connectionType.intValue());
                    }
                    if (this.setupTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.setupTimeMs.longValue());
                    }
                    if (this.hotspotStartTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.hotspotStartTimeMs.longValue());
                    }
                    if (this.joinTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.joinTimeMs.longValue());
                    }
                    if (this.connectivityCheckFailCount != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.connectivityCheckFailCount.intValue());
                    }
                    if (this.connectionAttemptType != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.connectionAttemptType.intValue());
                    }
                    if (this.managedConnectionFailCount != null) {
                        codedOutputByteBufferNano.writeInt32(7, this.managedConnectionFailCount.intValue());
                    }
                    if (this.managedConnectionApiErrorCount != null) {
                        codedOutputByteBufferNano.writeInt32(8, this.managedConnectionApiErrorCount.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.connectionType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.connectionType.intValue());
                    }
                    if (this.setupTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.setupTimeMs.longValue());
                    }
                    if (this.hotspotStartTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.hotspotStartTimeMs.longValue());
                    }
                    if (this.joinTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.joinTimeMs.longValue());
                    }
                    if (this.connectivityCheckFailCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.connectivityCheckFailCount.intValue());
                    }
                    if (this.connectionAttemptType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.connectionAttemptType.intValue());
                    }
                    if (this.managedConnectionFailCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.managedConnectionFailCount.intValue());
                    }
                    if (this.managedConnectionApiErrorCount != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, this.managedConnectionApiErrorCount.intValue());
                    }
                    return computeSerializedSize;
                }

                public final WifiSetupSession mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.connectionType = Integer.valueOf(checkWifiConnectionTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.setupTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.hotspotStartTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.joinTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 40:
                                this.connectivityCheckFailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 48:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.connectionAttemptType = Integer.valueOf(checkWifiConnectionAttemptTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 56:
                                this.managedConnectionFailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 64:
                                this.managedConnectionApiErrorCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            public final Eva clear() {
                this.cameraType = null;
                this.capture = null;
                this.pairing = null;
                this.fileTransfer = null;
                this.view = null;
                this.cameraStatus = null;
                this.bluetoothSession = null;
                this.wifiSetupSession = null;
                this.share = null;
                this.delete = null;
                this.localGalleryStats = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Eva clone() {
                try {
                    Eva eva = (Eva) super.clone();
                    if (this.cameraType != null) {
                        eva.cameraType = this.cameraType.clone();
                    }
                    if (this.capture != null) {
                        eva.capture = this.capture.clone();
                    }
                    if (this.pairing != null) {
                        eva.pairing = this.pairing.clone();
                    }
                    if (this.fileTransfer != null) {
                        eva.fileTransfer = this.fileTransfer.clone();
                    }
                    if (this.view != null) {
                        eva.view = this.view.clone();
                    }
                    if (this.cameraStatus != null) {
                        eva.cameraStatus = this.cameraStatus.clone();
                    }
                    if (this.bluetoothSession != null) {
                        eva.bluetoothSession = this.bluetoothSession.clone();
                    }
                    if (this.wifiSetupSession != null) {
                        eva.wifiSetupSession = this.wifiSetupSession.clone();
                    }
                    if (this.share != null) {
                        eva.share = this.share.clone();
                    }
                    if (this.delete != null) {
                        eva.delete = this.delete.clone();
                    }
                    if (this.localGalleryStats != null) {
                        eva.localGalleryStats = this.localGalleryStats.clone();
                    }
                    return eva;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.cameraType != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.cameraType);
                }
                if (this.capture != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.capture);
                }
                if (this.pairing != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.pairing);
                }
                if (this.fileTransfer != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.fileTransfer);
                }
                if (this.view != null) {
                    codedOutputByteBufferNano.writeMessage(5, this.view);
                }
                if (this.cameraStatus != null) {
                    codedOutputByteBufferNano.writeMessage(6, this.cameraStatus);
                }
                if (this.bluetoothSession != null) {
                    codedOutputByteBufferNano.writeMessage(7, this.bluetoothSession);
                }
                if (this.wifiSetupSession != null) {
                    codedOutputByteBufferNano.writeMessage(8, this.wifiSetupSession);
                }
                if (this.share != null) {
                    codedOutputByteBufferNano.writeMessage(9, this.share);
                }
                if (this.delete != null) {
                    codedOutputByteBufferNano.writeMessage(10, this.delete);
                }
                if (this.localGalleryStats != null) {
                    codedOutputByteBufferNano.writeMessage(11, this.localGalleryStats);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.cameraType != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.cameraType);
                }
                if (this.capture != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.capture);
                }
                if (this.pairing != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.pairing);
                }
                if (this.fileTransfer != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.fileTransfer);
                }
                if (this.view != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.view);
                }
                if (this.cameraStatus != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, this.cameraStatus);
                }
                if (this.bluetoothSession != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, this.bluetoothSession);
                }
                if (this.wifiSetupSession != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, this.wifiSetupSession);
                }
                if (this.share != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, this.share);
                }
                if (this.delete != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, this.delete);
                }
                if (this.localGalleryStats != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, this.localGalleryStats);
                }
                return computeSerializedSize;
            }

            public final Eva mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.cameraType == null) {
                                this.cameraType = new CameraInfo();
                            }
                            codedInputByteBufferNano.readMessage(this.cameraType);
                            continue;
                        case 18:
                            if (this.capture == null) {
                                this.capture = new Capture();
                            }
                            codedInputByteBufferNano.readMessage(this.capture);
                            continue;
                        case 26:
                            if (this.pairing == null) {
                                this.pairing = new Pairing();
                            }
                            codedInputByteBufferNano.readMessage(this.pairing);
                            continue;
                        case 34:
                            if (this.fileTransfer == null) {
                                this.fileTransfer = new FileTransfer();
                            }
                            codedInputByteBufferNano.readMessage(this.fileTransfer);
                            continue;
                        case 42:
                            if (this.view == null) {
                                this.view = new View();
                            }
                            codedInputByteBufferNano.readMessage(this.view);
                            continue;
                        case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                            if (this.cameraStatus == null) {
                                this.cameraStatus = new CameraStatus();
                            }
                            codedInputByteBufferNano.readMessage(this.cameraStatus);
                            continue;
                        case 58:
                            if (this.bluetoothSession == null) {
                                this.bluetoothSession = new BluetoothSession();
                            }
                            codedInputByteBufferNano.readMessage(this.bluetoothSession);
                            continue;
                        case 66:
                            if (this.wifiSetupSession == null) {
                                this.wifiSetupSession = new WifiSetupSession();
                            }
                            codedInputByteBufferNano.readMessage(this.wifiSetupSession);
                            continue;
                        case 74:
                            if (this.share == null) {
                                this.share = new Share();
                            }
                            codedInputByteBufferNano.readMessage(this.share);
                            continue;
                        case 82:
                            if (this.delete == null) {
                                this.delete = new Delete();
                            }
                            codedInputByteBufferNano.readMessage(this.delete);
                            continue;
                        case 90:
                            if (this.localGalleryStats == null) {
                                this.localGalleryStats = new LocalGalleryStats();
                            }
                            codedInputByteBufferNano.readMessage(this.localGalleryStats);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$EventSource */
        public interface EventSource {
        }

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore */
        public static final class VrCore extends ExtendableMessageNano<VrCore> implements Cloneable {
            public CaptureEvent captureEvent;
            public Integer clientApiVersion;
            @NanoEnumValue(legacy = false, value = CompositionType.class)
            public Integer compositionType;
            public Controller controller;
            public Integer controllerHandedness;
            public DashboardEvent dashboardEvent;
            @NanoEnumValue(legacy = false, value = ErrorCode.class)
            public Integer errorCode;
            public Application foregroundApplication;
            public Boolean isInDemoMode;
            public LockScreenEvent lockScreenEvent;
            @NanoEnumValue(legacy = false, value = Permission.class)
            public Integer permission;
            public Application previousForegroundApplication;
            public Long vrSessionId;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$CompositionType */
            public interface CompositionType {
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$ErrorCode */
            public interface ErrorCode {
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$Permission */
            public interface Permission {
            }

            @NanoEnumValue(legacy = false, value = ErrorCode.class)
            public static int checkErrorCodeOrThrow(int i) {
                if ((i >= 0 && i <= 8) || ((i >= 101 && i <= 129) || ((i >= 151 && i <= 153) || ((i >= 176 && i <= 192) || ((i >= 201 && i <= 203) || ((i >= 301 && i <= 301) || ((i >= 401 && i <= 402) || ((i >= 501 && i <= 503) || ((i >= 510 && i <= 515) || (i >= 520 && i <= 525)))))))))) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum ErrorCode").toString());
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$DashboardEvent */
            public static final class DashboardEvent extends ExtendableMessageNano<DashboardEvent> implements Cloneable {
                public Long clientTimestamp;
                public DashboardDismissDetails dismissDetails;
                @NanoEnumValue(legacy = false, value = DashboardEventType.class)
                public Integer eventType;
                public String sessionId;
                public Application worldApp;
                public MemoryMetric.AndroidMemoryStats worldAppMemoryStats;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$DashboardEvent$DashboardEventType */
                public interface DashboardEventType {
                }

                @NanoEnumValue(legacy = false, value = DashboardEventType.class)
                public static int checkDashboardEventTypeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(50).append(i).append(" is not a valid enum DashboardEventType").toString());
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$DashboardEvent$DashboardDismissDetails */
                public static final class DashboardDismissDetails extends ExtendableMessageNano<DashboardDismissDetails> implements Cloneable {
                    @NanoEnumValue(legacy = false, value = DashboardDismissReason.class)
                    public Integer dismissReason;
                    public Boolean worldAppDied;

                    /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$DashboardEvent$DashboardDismissDetails$DashboardDismissReason */
                    public interface DashboardDismissReason {
                    }

                    @NanoEnumValue(legacy = false, value = DashboardDismissReason.class)
                    public static int checkDashboardDismissReasonOrThrow(int i) {
                        if (i >= 0 && i <= 7) {
                            return i;
                        }
                        throw new IllegalArgumentException(new StringBuilder(54).append(i).append(" is not a valid enum DashboardDismissReason").toString());
                    }

                    public DashboardDismissDetails() {
                        clear();
                    }

                    public final DashboardDismissDetails clear() {
                        this.dismissReason = null;
                        this.worldAppDied = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final DashboardDismissDetails clone() {
                        try {
                            return (DashboardDismissDetails) super.clone();
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.dismissReason != null) {
                            codedOutputByteBufferNano.writeInt32(1, this.dismissReason.intValue());
                        }
                        if (this.worldAppDied != null) {
                            codedOutputByteBufferNano.writeBool(2, this.worldAppDied.booleanValue());
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.dismissReason != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.dismissReason.intValue());
                        }
                        if (this.worldAppDied != null) {
                            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.worldAppDied.booleanValue());
                        }
                        return computeSerializedSize;
                    }

                    public final DashboardDismissDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    int position = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.dismissReason = Integer.valueOf(checkDashboardDismissReasonOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
                                case 16:
                                    this.worldAppDied = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

                public DashboardEvent() {
                    clear();
                }

                public final DashboardEvent clear() {
                    this.eventType = null;
                    this.clientTimestamp = null;
                    this.sessionId = null;
                    this.worldApp = null;
                    this.worldAppMemoryStats = null;
                    this.dismissDetails = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final DashboardEvent clone() {
                    try {
                        DashboardEvent dashboardEvent = (DashboardEvent) super.clone();
                        if (this.worldApp != null) {
                            dashboardEvent.worldApp = this.worldApp.clone();
                        }
                        if (this.worldAppMemoryStats != null) {
                            dashboardEvent.worldAppMemoryStats = this.worldAppMemoryStats.clone();
                        }
                        if (this.dismissDetails != null) {
                            dashboardEvent.dismissDetails = this.dismissDetails.clone();
                        }
                        return dashboardEvent;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.eventType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.eventType.intValue());
                    }
                    if (this.clientTimestamp != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.clientTimestamp.longValue());
                    }
                    if (this.sessionId != null) {
                        codedOutputByteBufferNano.writeString(3, this.sessionId);
                    }
                    if (this.worldApp != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.worldApp);
                    }
                    if (this.worldAppMemoryStats != null) {
                        codedOutputByteBufferNano.writeMessage(5, this.worldAppMemoryStats);
                    }
                    if (this.dismissDetails != null) {
                        codedOutputByteBufferNano.writeMessage(6, this.dismissDetails);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.eventType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.eventType.intValue());
                    }
                    if (this.clientTimestamp != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.clientTimestamp.longValue());
                    }
                    if (this.sessionId != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.sessionId);
                    }
                    if (this.worldApp != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.worldApp);
                    }
                    if (this.worldAppMemoryStats != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.worldAppMemoryStats);
                    }
                    if (this.dismissDetails != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, this.dismissDetails);
                    }
                    return computeSerializedSize;
                }

                public final DashboardEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.eventType = Integer.valueOf(checkDashboardEventTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.clientTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 26:
                                this.sessionId = codedInputByteBufferNano.readString();
                                continue;
                            case 34:
                                if (this.worldApp == null) {
                                    this.worldApp = new Application();
                                }
                                codedInputByteBufferNano.readMessage(this.worldApp);
                                continue;
                            case 42:
                                if (this.worldAppMemoryStats == null) {
                                    this.worldAppMemoryStats = new MemoryMetric.AndroidMemoryStats();
                                }
                                codedInputByteBufferNano.readMessage(this.worldAppMemoryStats);
                                continue;
                            case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                                if (this.dismissDetails == null) {
                                    this.dismissDetails = new DashboardDismissDetails();
                                }
                                codedInputByteBufferNano.readMessage(this.dismissDetails);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$CaptureEvent */
            public static final class CaptureEvent extends ExtendableMessageNano<CaptureEvent> implements Cloneable {
                public Boolean initiatedByController;

                public CaptureEvent() {
                    clear();
                }

                public final CaptureEvent clear() {
                    this.initiatedByController = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final CaptureEvent clone() {
                    try {
                        return (CaptureEvent) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.initiatedByController != null) {
                        codedOutputByteBufferNano.writeBool(1, this.initiatedByController.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.initiatedByController != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, this.initiatedByController.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final CaptureEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.initiatedByController = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$Controller */
            public static final class Controller extends ExtendableMessageNano<Controller> implements Cloneable {
                public String availableFirmware;
                @NanoEnumValue(legacy = false, value = ControllerAxis.class)
                public Integer axis;
                public Integer batteryLevel;
                public String firmware;
                public String hardwareRevision;
                public Boolean isConnected;
                public String manufacturer;
                public String model;
                public Integer otaRetries;
                public Integer sampleCount;
                @NanoEnumValue(legacy = false, value = SensorType.class)
                public Integer sensorType;
                public String softwareRevision;
                public Integer status;
                public Integer totalControllerLagCount;
                public Integer xRailCount;
                public Integer yRailCount;
                public Integer zRailCount;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$Controller$ControllerAxis */
                public interface ControllerAxis {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$Controller$SensorType */
                public interface SensorType {
                }

                @NanoEnumValue(legacy = false, value = SensorType.class)
                public static int checkSensorTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum SensorType").toString());
                }

                @NanoEnumValue(legacy = false, value = ControllerAxis.class)
                public static int checkControllerAxisOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum ControllerAxis").toString());
                }

                public Controller() {
                    clear();
                }

                public final Controller clear() {
                    this.manufacturer = null;
                    this.model = null;
                    this.firmware = null;
                    this.availableFirmware = null;
                    this.softwareRevision = null;
                    this.isConnected = null;
                    this.batteryLevel = null;
                    this.hardwareRevision = null;
                    this.xRailCount = null;
                    this.yRailCount = null;
                    this.zRailCount = null;
                    this.sampleCount = null;
                    this.sensorType = null;
                    this.axis = null;
                    this.otaRetries = null;
                    this.totalControllerLagCount = null;
                    this.status = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Controller clone() {
                    try {
                        return (Controller) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.manufacturer != null) {
                        codedOutputByteBufferNano.writeString(1, this.manufacturer);
                    }
                    if (this.model != null) {
                        codedOutputByteBufferNano.writeString(2, this.model);
                    }
                    if (this.firmware != null) {
                        codedOutputByteBufferNano.writeString(3, this.firmware);
                    }
                    if (this.availableFirmware != null) {
                        codedOutputByteBufferNano.writeString(4, this.availableFirmware);
                    }
                    if (this.softwareRevision != null) {
                        codedOutputByteBufferNano.writeString(5, this.softwareRevision);
                    }
                    if (this.batteryLevel != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.batteryLevel.intValue());
                    }
                    if (this.hardwareRevision != null) {
                        codedOutputByteBufferNano.writeString(7, this.hardwareRevision);
                    }
                    if (this.xRailCount != null) {
                        codedOutputByteBufferNano.writeInt32(8, this.xRailCount.intValue());
                    }
                    if (this.yRailCount != null) {
                        codedOutputByteBufferNano.writeInt32(9, this.yRailCount.intValue());
                    }
                    if (this.zRailCount != null) {
                        codedOutputByteBufferNano.writeInt32(10, this.zRailCount.intValue());
                    }
                    if (this.sampleCount != null) {
                        codedOutputByteBufferNano.writeInt32(11, this.sampleCount.intValue());
                    }
                    if (this.sensorType != null) {
                        codedOutputByteBufferNano.writeInt32(12, this.sensorType.intValue());
                    }
                    if (this.axis != null) {
                        codedOutputByteBufferNano.writeInt32(13, this.axis.intValue());
                    }
                    if (this.otaRetries != null) {
                        codedOutputByteBufferNano.writeInt32(14, this.otaRetries.intValue());
                    }
                    if (this.totalControllerLagCount != null) {
                        codedOutputByteBufferNano.writeInt32(15, this.totalControllerLagCount.intValue());
                    }
                    if (this.isConnected != null) {
                        codedOutputByteBufferNano.writeBool(16, this.isConnected.booleanValue());
                    }
                    if (this.status != null) {
                        codedOutputByteBufferNano.writeInt32(17, this.status.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.manufacturer != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.manufacturer);
                    }
                    if (this.model != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.model);
                    }
                    if (this.firmware != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.firmware);
                    }
                    if (this.availableFirmware != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.availableFirmware);
                    }
                    if (this.softwareRevision != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.softwareRevision);
                    }
                    if (this.batteryLevel != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.batteryLevel.intValue());
                    }
                    if (this.hardwareRevision != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.hardwareRevision);
                    }
                    if (this.xRailCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, this.xRailCount.intValue());
                    }
                    if (this.yRailCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, this.yRailCount.intValue());
                    }
                    if (this.zRailCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, this.zRailCount.intValue());
                    }
                    if (this.sampleCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, this.sampleCount.intValue());
                    }
                    if (this.sensorType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, this.sensorType.intValue());
                    }
                    if (this.axis != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, this.axis.intValue());
                    }
                    if (this.otaRetries != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, this.otaRetries.intValue());
                    }
                    if (this.totalControllerLagCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, this.totalControllerLagCount.intValue());
                    }
                    if (this.isConnected != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, this.isConnected.booleanValue());
                    }
                    if (this.status != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(17, this.status.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Controller mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.manufacturer = codedInputByteBufferNano.readString();
                                continue;
                            case 18:
                                this.model = codedInputByteBufferNano.readString();
                                continue;
                            case 26:
                                this.firmware = codedInputByteBufferNano.readString();
                                continue;
                            case 34:
                                this.availableFirmware = codedInputByteBufferNano.readString();
                                continue;
                            case 42:
                                this.softwareRevision = codedInputByteBufferNano.readString();
                                continue;
                            case 48:
                                this.batteryLevel = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 58:
                                this.hardwareRevision = codedInputByteBufferNano.readString();
                                continue;
                            case 64:
                                this.xRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 72:
                                this.yRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 80:
                                this.zRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 88:
                                this.sampleCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 96:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.sensorType = Integer.valueOf(checkSensorTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 104:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.axis = Integer.valueOf(checkControllerAxisOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 112:
                                this.otaRetries = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 120:
                                this.totalControllerLagCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 128:
                                this.isConnected = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 136:
                                this.status = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$LockScreenEvent */
            public static final class LockScreenEvent extends ExtendableMessageNano<LockScreenEvent> implements Cloneable {
                @NanoEnumValue(legacy = false, value = LockScreenEventType.class)
                public Integer eventType;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrCore$LockScreenEvent$LockScreenEventType */
                public interface LockScreenEventType {
                }

                @NanoEnumValue(legacy = false, value = LockScreenEventType.class)
                public static int checkLockScreenEventTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(51).append(i).append(" is not a valid enum LockScreenEventType").toString());
                }

                public LockScreenEvent() {
                    clear();
                }

                public final LockScreenEvent clear() {
                    this.eventType = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final LockScreenEvent clone() {
                    try {
                        return (LockScreenEvent) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.eventType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.eventType.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.eventType != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, this.eventType.intValue());
                    }
                    return computeSerializedSize;
                }

                public final LockScreenEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.eventType = Integer.valueOf(checkLockScreenEventTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            @NanoEnumValue(legacy = false, value = Permission.class)
            public static int checkPermissionOrThrow(int i) {
                if (i >= 0 && i <= 8) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum Permission").toString());
            }

            @NanoEnumValue(legacy = false, value = CompositionType.class)
            public static int checkCompositionTypeOrThrow(int i) {
                if (i >= 0 && i <= 3) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(47).append(i).append(" is not a valid enum CompositionType").toString());
            }

            public VrCore() {
                clear();
            }

            public final VrCore clear() {
                this.vrSessionId = null;
                this.errorCode = null;
                this.permission = null;
                this.foregroundApplication = null;
                this.clientApiVersion = null;
                this.previousForegroundApplication = null;
                this.controller = null;
                this.dashboardEvent = null;
                this.isInDemoMode = null;
                this.captureEvent = null;
                this.controllerHandedness = null;
                this.lockScreenEvent = null;
                this.compositionType = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final VrCore clone() {
                try {
                    VrCore vrCore = (VrCore) super.clone();
                    if (this.foregroundApplication != null) {
                        vrCore.foregroundApplication = this.foregroundApplication.clone();
                    }
                    if (this.previousForegroundApplication != null) {
                        vrCore.previousForegroundApplication = this.previousForegroundApplication.clone();
                    }
                    if (this.controller != null) {
                        vrCore.controller = this.controller.clone();
                    }
                    if (this.dashboardEvent != null) {
                        vrCore.dashboardEvent = this.dashboardEvent.clone();
                    }
                    if (this.captureEvent != null) {
                        vrCore.captureEvent = this.captureEvent.clone();
                    }
                    if (this.lockScreenEvent != null) {
                        vrCore.lockScreenEvent = this.lockScreenEvent.clone();
                    }
                    return vrCore;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.errorCode != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.errorCode.intValue());
                }
                if (this.permission != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.permission.intValue());
                }
                if (this.foregroundApplication != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.foregroundApplication);
                }
                if (this.clientApiVersion != null) {
                    codedOutputByteBufferNano.writeInt32(4, this.clientApiVersion.intValue());
                }
                if (this.previousForegroundApplication != null) {
                    codedOutputByteBufferNano.writeMessage(5, this.previousForegroundApplication);
                }
                if (this.controller != null) {
                    codedOutputByteBufferNano.writeMessage(6, this.controller);
                }
                if (this.dashboardEvent != null) {
                    codedOutputByteBufferNano.writeMessage(7, this.dashboardEvent);
                }
                if (this.isInDemoMode != null) {
                    codedOutputByteBufferNano.writeBool(8, this.isInDemoMode.booleanValue());
                }
                if (this.captureEvent != null) {
                    codedOutputByteBufferNano.writeMessage(9, this.captureEvent);
                }
                if (this.controllerHandedness != null) {
                    codedOutputByteBufferNano.writeInt32(10, this.controllerHandedness.intValue());
                }
                if (this.vrSessionId != null) {
                    codedOutputByteBufferNano.writeInt64(11, this.vrSessionId.longValue());
                }
                if (this.lockScreenEvent != null) {
                    codedOutputByteBufferNano.writeMessage(12, this.lockScreenEvent);
                }
                if (this.compositionType != null) {
                    codedOutputByteBufferNano.writeInt32(13, this.compositionType.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.errorCode != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.errorCode.intValue());
                }
                if (this.permission != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.permission.intValue());
                }
                if (this.foregroundApplication != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.foregroundApplication);
                }
                if (this.clientApiVersion != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.clientApiVersion.intValue());
                }
                if (this.previousForegroundApplication != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.previousForegroundApplication);
                }
                if (this.controller != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, this.controller);
                }
                if (this.dashboardEvent != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, this.dashboardEvent);
                }
                if (this.isInDemoMode != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, this.isInDemoMode.booleanValue());
                }
                if (this.captureEvent != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, this.captureEvent);
                }
                if (this.controllerHandedness != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, this.controllerHandedness.intValue());
                }
                if (this.vrSessionId != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(11, this.vrSessionId.longValue());
                }
                if (this.lockScreenEvent != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, this.lockScreenEvent);
                }
                if (this.compositionType != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(13, this.compositionType.intValue());
                }
                return computeSerializedSize;
            }

            public final VrCore mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.errorCode = Integer.valueOf(checkErrorCodeOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 16:
                            int position2 = codedInputByteBufferNano.getPosition();
                            try {
                                this.permission = Integer.valueOf(checkPermissionOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e2) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 26:
                            if (this.foregroundApplication == null) {
                                this.foregroundApplication = new Application();
                            }
                            codedInputByteBufferNano.readMessage(this.foregroundApplication);
                            continue;
                        case 32:
                            this.clientApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 42:
                            if (this.previousForegroundApplication == null) {
                                this.previousForegroundApplication = new Application();
                            }
                            codedInputByteBufferNano.readMessage(this.previousForegroundApplication);
                            continue;
                        case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                            if (this.controller == null) {
                                this.controller = new Controller();
                            }
                            codedInputByteBufferNano.readMessage(this.controller);
                            continue;
                        case 58:
                            if (this.dashboardEvent == null) {
                                this.dashboardEvent = new DashboardEvent();
                            }
                            codedInputByteBufferNano.readMessage(this.dashboardEvent);
                            continue;
                        case 64:
                            this.isInDemoMode = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 74:
                            if (this.captureEvent == null) {
                                this.captureEvent = new CaptureEvent();
                            }
                            codedInputByteBufferNano.readMessage(this.captureEvent);
                            continue;
                        case 80:
                            this.controllerHandedness = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 88:
                            this.vrSessionId = Long.valueOf(codedInputByteBufferNano.readInt64());
                            continue;
                        case 98:
                            if (this.lockScreenEvent == null) {
                                this.lockScreenEvent = new LockScreenEvent();
                            }
                            codedInputByteBufferNano.readMessage(this.lockScreenEvent);
                            continue;
                        case 104:
                            int position3 = codedInputByteBufferNano.getPosition();
                            try {
                                this.compositionType = Integer.valueOf(checkCompositionTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e3) {
                                codedInputByteBufferNano.rewindToPosition(position3);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome */
        public static final class VrHome extends ExtendableMessageNano<VrHome> implements Cloneable {
            public DialogAction dialogAction;
            public GConfigUpdate gConfigUpdate;
            public GetViewerClick getViewerClick;
            public Setup setup;

            public VrHome() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$Setup */
            public static final class Setup extends ExtendableMessageNano<Setup> implements Cloneable {
                public StepStateChange stepStateChange;
                public View view;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$Setup$Step */
                public interface Step {
                }

                @NanoEnumValue(legacy = false, value = Step.class)
                public static int checkStepOrThrow(int i) {
                    if (i >= 0 && i <= 9) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Step").toString());
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$Setup$StepStateChange */
                public static final class StepStateChange extends ExtendableMessageNano<StepStateChange> implements Cloneable {
                    @NanoEnumValue(legacy = false, value = StepState.class)
                    public Integer newStepState;
                    @NanoEnumValue(legacy = false, value = StepState.class)
                    public Integer previousStepState;
                    @NanoEnumValue(legacy = false, value = Step.class)
                    public Integer step;

                    /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$Setup$StepStateChange$StepState */
                    public interface StepState {
                    }

                    @NanoEnumValue(legacy = false, value = StepState.class)
                    public static int checkStepStateOrThrow(int i) {
                        if (i >= 0 && i <= 4) {
                            return i;
                        }
                        throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum StepState").toString());
                    }

                    public StepStateChange() {
                        clear();
                    }

                    public final StepStateChange clear() {
                        this.step = null;
                        this.previousStepState = null;
                        this.newStepState = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final StepStateChange clone() {
                        try {
                            return (StepStateChange) super.clone();
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.step != null) {
                            codedOutputByteBufferNano.writeInt32(1, this.step.intValue());
                        }
                        if (this.previousStepState != null) {
                            codedOutputByteBufferNano.writeInt32(2, this.previousStepState.intValue());
                        }
                        if (this.newStepState != null) {
                            codedOutputByteBufferNano.writeInt32(3, this.newStepState.intValue());
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.step != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.step.intValue());
                        }
                        if (this.previousStepState != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.previousStepState.intValue());
                        }
                        if (this.newStepState != null) {
                            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.newStepState.intValue());
                        }
                        return computeSerializedSize;
                    }

                    public final StepStateChange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    int position = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.step = Integer.valueOf(Setup.checkStepOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
                                case 16:
                                    int position2 = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.previousStepState = Integer.valueOf(checkStepStateOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e2) {
                                        codedInputByteBufferNano.rewindToPosition(position2);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
                                case AndroidNCompat.N_SDK_LEVEL:
                                    int position3 = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.newStepState = Integer.valueOf(checkStepStateOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e3) {
                                        codedInputByteBufferNano.rewindToPosition(position3);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
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

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$Setup$View */
                public static final class View extends ExtendableMessageNano<View> implements Cloneable {
                    public Integer page;
                    @NanoEnumValue(legacy = false, value = Step.class)
                    public Integer step;

                    public View() {
                        clear();
                    }

                    public final View clear() {
                        this.step = null;
                        this.page = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final View clone() {
                        try {
                            return (View) super.clone();
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.step != null) {
                            codedOutputByteBufferNano.writeInt32(1, this.step.intValue());
                        }
                        if (this.page != null) {
                            codedOutputByteBufferNano.writeInt32(2, this.page.intValue());
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.step != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.step.intValue());
                        }
                        if (this.page != null) {
                            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.page.intValue());
                        }
                        return computeSerializedSize;
                    }

                    public final View mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    int position = codedInputByteBufferNano.getPosition();
                                    try {
                                        this.step = Integer.valueOf(Setup.checkStepOrThrow(codedInputByteBufferNano.readInt32()));
                                        continue;
                                    } catch (IllegalArgumentException e) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                        break;
                                    }
                                case 16:
                                    this.page = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

                public Setup() {
                    clear();
                }

                public final Setup clear() {
                    this.view = null;
                    this.stepStateChange = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Setup clone() {
                    try {
                        Setup setup = (Setup) super.clone();
                        if (this.view != null) {
                            setup.view = this.view.clone();
                        }
                        if (this.stepStateChange != null) {
                            setup.stepStateChange = this.stepStateChange.clone();
                        }
                        return setup;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.view != null) {
                        codedOutputByteBufferNano.writeMessage(1, this.view);
                    }
                    if (this.stepStateChange != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.stepStateChange);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.view != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.view);
                    }
                    if (this.stepStateChange != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, this.stepStateChange);
                    }
                    return computeSerializedSize;
                }

                public final Setup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                if (this.view == null) {
                                    this.view = new View();
                                }
                                codedInputByteBufferNano.readMessage(this.view);
                                continue;
                            case 18:
                                if (this.stepStateChange == null) {
                                    this.stepStateChange = new StepStateChange();
                                }
                                codedInputByteBufferNano.readMessage(this.stepStateChange);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$DialogAction */
            public static final class DialogAction extends ExtendableMessageNano<DialogAction> implements Cloneable {
                @NanoEnumValue(legacy = false, value = DialogActionType.class)
                public Integer actionType;
                @NanoEnumValue(legacy = false, value = DialogType.class)
                public Integer type;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$DialogAction$DialogActionType */
                public interface DialogActionType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$DialogAction$DialogType */
                public interface DialogType {
                }

                @NanoEnumValue(legacy = false, value = DialogType.class)
                public static int checkDialogTypeOrThrow(int i) {
                    if (i >= 0 && i <= 1) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum DialogType").toString());
                }

                @NanoEnumValue(legacy = false, value = DialogActionType.class)
                public static int checkDialogActionTypeOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(48).append(i).append(" is not a valid enum DialogActionType").toString());
                }

                public DialogAction() {
                    clear();
                }

                public final DialogAction clear() {
                    this.type = null;
                    this.actionType = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final DialogAction clone() {
                    try {
                        return (DialogAction) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.type != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.type.intValue());
                    }
                    if (this.actionType != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.actionType.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.type != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }
                    if (this.actionType != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.actionType.intValue());
                    }
                    return computeSerializedSize;
                }

                public final DialogAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.type = Integer.valueOf(checkDialogTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.actionType = Integer.valueOf(checkDialogActionTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrHome$GetViewerClick */
            public static final class GetViewerClick extends ExtendableMessageNano<GetViewerClick> implements Cloneable {
                public String url;

                public GetViewerClick() {
                    clear();
                }

                public final GetViewerClick clear() {
                    this.url = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final GetViewerClick clone() {
                    try {
                        return (GetViewerClick) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.url != null) {
                        codedOutputByteBufferNano.writeString(1, this.url);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.url != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.url);
                    }
                    return computeSerializedSize;
                }

                public final GetViewerClick mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.url = codedInputByteBufferNano.readString();
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

            public final VrHome clear() {
                this.setup = null;
                this.gConfigUpdate = null;
                this.getViewerClick = null;
                this.dialogAction = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final VrHome clone() {
                try {
                    VrHome vrHome = (VrHome) super.clone();
                    if (this.setup != null) {
                        vrHome.setup = this.setup.clone();
                    }
                    if (this.gConfigUpdate != null) {
                        vrHome.gConfigUpdate = this.gConfigUpdate.clone();
                    }
                    if (this.getViewerClick != null) {
                        vrHome.getViewerClick = this.getViewerClick.clone();
                    }
                    if (this.dialogAction != null) {
                        vrHome.dialogAction = this.dialogAction.clone();
                    }
                    return vrHome;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.setup != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.setup);
                }
                if (this.gConfigUpdate != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.gConfigUpdate);
                }
                if (this.getViewerClick != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.getViewerClick);
                }
                if (this.dialogAction != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.dialogAction);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.setup != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.setup);
                }
                if (this.gConfigUpdate != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.gConfigUpdate);
                }
                if (this.getViewerClick != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.getViewerClick);
                }
                if (this.dialogAction != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.dialogAction);
                }
                return computeSerializedSize;
            }

            public final VrHome mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.setup == null) {
                                this.setup = new Setup();
                            }
                            codedInputByteBufferNano.readMessage(this.setup);
                            continue;
                        case 18:
                            if (this.gConfigUpdate == null) {
                                this.gConfigUpdate = new GConfigUpdate();
                            }
                            codedInputByteBufferNano.readMessage(this.gConfigUpdate);
                            continue;
                        case 26:
                            if (this.getViewerClick == null) {
                                this.getViewerClick = new GetViewerClick();
                            }
                            codedInputByteBufferNano.readMessage(this.getViewerClick);
                            continue;
                        case 34:
                            if (this.dialogAction == null) {
                                this.dialogAction = new DialogAction();
                            }
                            codedInputByteBufferNano.readMessage(this.dialogAction);
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

        @NanoEnumValue(legacy = false, value = EventSource.class)
        public static int checkEventSourceOrThrow(int i) {
            if (i >= 0 && i <= 4) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum EventSource").toString());
        }

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops */
        public static final class Cyclops extends ExtendableMessageNano<Cyclops> implements Cloneable {
            public Capture capture;
            public Share share;
            public ShareStart shareStart;
            public View view;

            public Cyclops() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$Capture */
            public static final class Capture extends ExtendableMessageNano<Capture> implements Cloneable {
                public Float angleDegrees;
                public Long captureTimeMs;
                public Boolean captureWarnings;
                public Long compositionTimeMs;
                @NanoEnumValue(legacy = false, value = Outcome.class)
                public Integer outcome;
                public Long processingTimeMs;
                public Boolean withSound;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$Capture$Outcome */
                public interface Outcome {
                }

                @NanoEnumValue(legacy = false, value = Outcome.class)
                public static int checkOutcomeOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append(i).append(" is not a valid enum Outcome").toString());
                }

                public Capture() {
                    clear();
                }

                public final Capture clear() {
                    this.outcome = null;
                    this.angleDegrees = null;
                    this.withSound = null;
                    this.captureWarnings = null;
                    this.compositionTimeMs = null;
                    this.captureTimeMs = null;
                    this.processingTimeMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Capture clone() {
                    try {
                        return (Capture) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.outcome != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.outcome.intValue());
                    }
                    if (this.angleDegrees != null) {
                        codedOutputByteBufferNano.writeFloat(2, this.angleDegrees.floatValue());
                    }
                    if (this.withSound != null) {
                        codedOutputByteBufferNano.writeBool(3, this.withSound.booleanValue());
                    }
                    if (this.captureWarnings != null) {
                        codedOutputByteBufferNano.writeBool(4, this.captureWarnings.booleanValue());
                    }
                    if (this.compositionTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(5, this.compositionTimeMs.longValue());
                    }
                    if (this.captureTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(6, this.captureTimeMs.longValue());
                    }
                    if (this.processingTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(7, this.processingTimeMs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.outcome != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.outcome.intValue());
                    }
                    if (this.angleDegrees != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.angleDegrees.floatValue());
                    }
                    if (this.withSound != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.withSound.booleanValue());
                    }
                    if (this.captureWarnings != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, this.captureWarnings.booleanValue());
                    }
                    if (this.compositionTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, this.compositionTimeMs.longValue());
                    }
                    if (this.captureTimeMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, this.captureTimeMs.longValue());
                    }
                    if (this.processingTimeMs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, this.processingTimeMs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final Capture mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.outcome = Integer.valueOf(checkOutcomeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 21:
                                this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 32:
                                this.captureWarnings = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 40:
                                this.compositionTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 48:
                                this.captureTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 56:
                                this.processingTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$Share */
            public static final class Share extends ExtendableMessageNano<Share> implements Cloneable {
                public Integer numPhotos;
                @NanoEnumValue(legacy = false, value = Type.class)
                public Integer type;
                public Boolean withSound;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$Share$Type */
                public interface Type {
                }

                @NanoEnumValue(legacy = false, value = Type.class)
                public static int checkTypeOrThrow(int i) {
                    if (i >= 0 && i <= 7) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(36).append(i).append(" is not a valid enum Type").toString());
                }

                public Share() {
                    clear();
                }

                public final Share clear() {
                    this.type = null;
                    this.withSound = null;
                    this.numPhotos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Share clone() {
                    try {
                        return (Share) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.type != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.type.intValue());
                    }
                    if (this.withSound != null) {
                        codedOutputByteBufferNano.writeBool(2, this.withSound.booleanValue());
                    }
                    if (this.numPhotos != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.numPhotos.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.type != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }
                    if (this.withSound != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.withSound.booleanValue());
                    }
                    if (this.numPhotos != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.numPhotos.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Share mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.type = Integer.valueOf(checkTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$ShareStart */
            public static final class ShareStart extends ExtendableMessageNano<ShareStart> implements Cloneable {
                public Integer numPhotos;
                @NanoEnumValue(legacy = false, value = OriginScreen.class)
                public Integer originScreen;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$ShareStart$OriginScreen */
                public interface OriginScreen {
                }

                @NanoEnumValue(legacy = false, value = OriginScreen.class)
                public static int checkOriginScreenOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(44).append(i).append(" is not a valid enum OriginScreen").toString());
                }

                public ShareStart() {
                    clear();
                }

                public final ShareStart clear() {
                    this.originScreen = null;
                    this.numPhotos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ShareStart clone() {
                    try {
                        return (ShareStart) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.originScreen != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.originScreen.intValue());
                    }
                    if (this.numPhotos != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.numPhotos.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.originScreen != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.originScreen.intValue());
                    }
                    if (this.numPhotos != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.numPhotos.intValue());
                    }
                    return computeSerializedSize;
                }

                public final ShareStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.originScreen = Integer.valueOf(checkOriginScreenOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$View */
            public static final class View extends ExtendableMessageNano<View> implements Cloneable {
                public Boolean interaction;
                public Integer numPanos;
                @NanoEnumValue(legacy = false, value = Orientation.class)
                public Integer orientation;
                public Boolean withSound;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Cyclops$View$Orientation */
                public interface Orientation {
                }

                @NanoEnumValue(legacy = false, value = Orientation.class)
                public static int checkOrientationOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum Orientation").toString());
                }

                public View() {
                    clear();
                }

                public final View clear() {
                    this.orientation = null;
                    this.interaction = null;
                    this.withSound = null;
                    this.numPanos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final View clone() {
                    try {
                        return (View) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.orientation != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.orientation.intValue());
                    }
                    if (this.interaction != null) {
                        codedOutputByteBufferNano.writeBool(2, this.interaction.booleanValue());
                    }
                    if (this.withSound != null) {
                        codedOutputByteBufferNano.writeBool(3, this.withSound.booleanValue());
                    }
                    if (this.numPanos != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.numPanos.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.orientation != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.orientation.intValue());
                    }
                    if (this.interaction != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.interaction.booleanValue());
                    }
                    if (this.withSound != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.withSound.booleanValue());
                    }
                    if (this.numPanos != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, this.numPanos.intValue());
                    }
                    return computeSerializedSize;
                }

                public final View mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.orientation = Integer.valueOf(checkOrientationOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.interaction = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 32:
                                this.numPanos = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            public final Cyclops clear() {
                this.capture = null;
                this.view = null;
                this.share = null;
                this.shareStart = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Cyclops clone() {
                try {
                    Cyclops cyclops = (Cyclops) super.clone();
                    if (this.capture != null) {
                        cyclops.capture = this.capture.clone();
                    }
                    if (this.view != null) {
                        cyclops.view = this.view.clone();
                    }
                    if (this.share != null) {
                        cyclops.share = this.share.clone();
                    }
                    if (this.shareStart != null) {
                        cyclops.shareStart = this.shareStart.clone();
                    }
                    return cyclops;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.capture != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.capture);
                }
                if (this.view != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.view);
                }
                if (this.share != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.share);
                }
                if (this.shareStart != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.shareStart);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.capture != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.capture);
                }
                if (this.view != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.view);
                }
                if (this.share != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.share);
                }
                if (this.shareStart != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.shareStart);
                }
                return computeSerializedSize;
            }

            public final Cyclops mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.capture == null) {
                                this.capture = new Capture();
                            }
                            codedInputByteBufferNano.readMessage(this.capture);
                            continue;
                        case 18:
                            if (this.view == null) {
                                this.view = new View();
                            }
                            codedInputByteBufferNano.readMessage(this.view);
                            continue;
                        case 26:
                            if (this.share == null) {
                                this.share = new Share();
                            }
                            codedInputByteBufferNano.readMessage(this.share);
                            continue;
                        case 34:
                            if (this.shareStart == null) {
                                this.shareStart = new ShareStart();
                            }
                            codedInputByteBufferNano.readMessage(this.shareStart);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$EmbedVrWidget */
        public static final class EmbedVrWidget extends ExtendableMessageNano<EmbedVrWidget> implements Cloneable {
            public String errorMsg;
            public Pano pano;
            public Video video;
            @NanoEnumValue(legacy = false, value = ViewMode.class)
            public Integer viewMode;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EmbedVrWidget$StereoFormat */
            public interface StereoFormat {
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EmbedVrWidget$ViewMode */
            public interface ViewMode {
            }

            @NanoEnumValue(legacy = false, value = StereoFormat.class)
            public static int checkStereoFormatOrThrow(int i) {
                if (i >= 0 && i <= 2) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(44).append(i).append(" is not a valid enum StereoFormat").toString());
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EmbedVrWidget$Pano */
            public static final class Pano extends ExtendableMessageNano<Pano> implements Cloneable {
                public Integer heightPixels;
                @NanoEnumValue(legacy = false, value = StereoFormat.class)
                public Integer stereoFormat;
                public Integer widthPixels;

                public Pano() {
                    clear();
                }

                public final Pano clear() {
                    this.widthPixels = null;
                    this.heightPixels = null;
                    this.stereoFormat = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Pano clone() {
                    try {
                        return (Pano) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.widthPixels != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.widthPixels.intValue());
                    }
                    if (this.heightPixels != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.heightPixels.intValue());
                    }
                    if (this.stereoFormat != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.stereoFormat.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.widthPixels != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.widthPixels.intValue());
                    }
                    if (this.heightPixels != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.heightPixels.intValue());
                    }
                    if (this.stereoFormat != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.stereoFormat.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Pano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.stereoFormat = Integer.valueOf(EmbedVrWidget.checkStereoFormatOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$EmbedVrWidget$Video */
            public static final class Video extends ExtendableMessageNano<Video> implements Cloneable {
                public Integer heightPixels;
                @NanoEnumValue(legacy = false, value = StereoFormat.class)
                public Integer stereoFormat;
                public Integer videoDurationMs;
                public Integer widthPixels;

                public Video() {
                    clear();
                }

                public final Video clear() {
                    this.widthPixels = null;
                    this.heightPixels = null;
                    this.stereoFormat = null;
                    this.videoDurationMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Video clone() {
                    try {
                        return (Video) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.widthPixels != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.widthPixels.intValue());
                    }
                    if (this.heightPixels != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.heightPixels.intValue());
                    }
                    if (this.stereoFormat != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.stereoFormat.intValue());
                    }
                    if (this.videoDurationMs != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.videoDurationMs.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.widthPixels != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.widthPixels.intValue());
                    }
                    if (this.heightPixels != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.heightPixels.intValue());
                    }
                    if (this.stereoFormat != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.stereoFormat.intValue());
                    }
                    if (this.videoDurationMs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, this.videoDurationMs.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Video mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.stereoFormat = Integer.valueOf(EmbedVrWidget.checkStereoFormatOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 32:
                                this.videoDurationMs = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            @NanoEnumValue(legacy = false, value = ViewMode.class)
            public static int checkViewModeOrThrow(int i) {
                if (i >= 0 && i <= 3) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum ViewMode").toString());
            }

            public EmbedVrWidget() {
                clear();
            }

            public final EmbedVrWidget clear() {
                this.viewMode = null;
                this.pano = null;
                this.video = null;
                this.errorMsg = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final EmbedVrWidget clone() {
                try {
                    EmbedVrWidget embedVrWidget = (EmbedVrWidget) super.clone();
                    if (this.pano != null) {
                        embedVrWidget.pano = this.pano.clone();
                    }
                    if (this.video != null) {
                        embedVrWidget.video = this.video.clone();
                    }
                    return embedVrWidget;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.viewMode != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.viewMode.intValue());
                }
                if (this.pano != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.pano);
                }
                if (this.video != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.video);
                }
                if (this.errorMsg != null) {
                    codedOutputByteBufferNano.writeString(4, this.errorMsg);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.viewMode != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.viewMode.intValue());
                }
                if (this.pano != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.pano);
                }
                if (this.video != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.video);
                }
                if (this.errorMsg != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.errorMsg);
                }
                return computeSerializedSize;
            }

            public final EmbedVrWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.viewMode = Integer.valueOf(checkViewModeOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 18:
                            if (this.pano == null) {
                                this.pano = new Pano();
                            }
                            codedInputByteBufferNano.readMessage(this.pano);
                            continue;
                        case 26:
                            if (this.video == null) {
                                this.video = new Video();
                            }
                            codedInputByteBufferNano.readMessage(this.video);
                            continue;
                        case 34:
                            this.errorMsg = codedInputByteBufferNano.readString();
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$HeadTracking */
        public static final class HeadTracking extends ExtendableMessageNano<HeadTracking> implements Cloneable {
            public Float floorHeight;
            public Long headTrackingTimestamp;
            private int oneof_safety_config_ = -1;
            public PeriodicReport periodicReport;
            private SafetyCylinderConfig safetyCylinderConfig;
            @NanoEnumValue(legacy = false, value = FallBackReason.class)
            public Integer sixDofFallbackReason;
            public Long sixDofFallbackTimestamp;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$HeadTracking$FallBackReason */
            public interface FallBackReason {
            }

            @NanoEnumValue(legacy = false, value = FallBackReason.class)
            public static int checkFallBackReasonOrThrow(int i) {
                if (i >= 0 && i <= 7) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum FallBackReason").toString());
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$HeadTracking$PeriodicReport */
            public static final class PeriodicReport extends ExtendableMessageNano<PeriodicReport> implements Cloneable {
                public Long endTimestampMs;
                public RecenterEvent[] recenterEvent;
                public SafeRegionEvent[] safeRegionEvent;
                public Long startTimestampMs;

                public PeriodicReport() {
                    clear();
                }

                public final PeriodicReport clear() {
                    this.startTimestampMs = null;
                    this.endTimestampMs = null;
                    this.recenterEvent = RecenterEvent.emptyArray();
                    this.safeRegionEvent = SafeRegionEvent.emptyArray();
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$HeadTracking$PeriodicReport$RecenterEvent */
                public static final class RecenterEvent extends ExtendableMessageNano<RecenterEvent> implements Cloneable {
                    private static volatile RecenterEvent[] _emptyArray;
                    public Long timestampMs;
                    public Integer type;

                    public static RecenterEvent[] emptyArray() {
                        if (_emptyArray == null) {
                            synchronized (InternalNano.LAZY_INIT_LOCK) {
                                if (_emptyArray == null) {
                                    _emptyArray = new RecenterEvent[0];
                                }
                            }
                        }
                        return _emptyArray;
                    }

                    public RecenterEvent() {
                        clear();
                    }

                    public final RecenterEvent clear() {
                        this.timestampMs = null;
                        this.type = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final RecenterEvent clone() {
                        try {
                            return (RecenterEvent) super.clone();
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.timestampMs != null) {
                            codedOutputByteBufferNano.writeInt64(1, this.timestampMs.longValue());
                        }
                        if (this.type != null) {
                            codedOutputByteBufferNano.writeInt32(2, this.type.intValue());
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.timestampMs != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampMs.longValue());
                        }
                        if (this.type != null) {
                            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.type.intValue());
                        }
                        return computeSerializedSize;
                    }

                    public final RecenterEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.timestampMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                    continue;
                                case 16:
                                    this.type = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$HeadTracking$PeriodicReport$SafeRegionEvent */
                public static final class SafeRegionEvent extends ExtendableMessageNano<SafeRegionEvent> implements Cloneable {
                    private static volatile SafeRegionEvent[] _emptyArray;
                    public Boolean entered;
                    public float[] hrsPosition;
                    public float[] hrsQuat;
                    public Long timestampMs;

                    public static SafeRegionEvent[] emptyArray() {
                        if (_emptyArray == null) {
                            synchronized (InternalNano.LAZY_INIT_LOCK) {
                                if (_emptyArray == null) {
                                    _emptyArray = new SafeRegionEvent[0];
                                }
                            }
                        }
                        return _emptyArray;
                    }

                    public SafeRegionEvent() {
                        clear();
                    }

                    public final SafeRegionEvent clear() {
                        this.timestampMs = null;
                        this.entered = null;
                        this.hrsPosition = WireFormatNano.EMPTY_FLOAT_ARRAY;
                        this.hrsQuat = WireFormatNano.EMPTY_FLOAT_ARRAY;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final SafeRegionEvent clone() {
                        try {
                            SafeRegionEvent safeRegionEvent = (SafeRegionEvent) super.clone();
                            if (this.hrsPosition != null && this.hrsPosition.length > 0) {
                                safeRegionEvent.hrsPosition = (float[]) this.hrsPosition.clone();
                            }
                            if (this.hrsQuat != null && this.hrsQuat.length > 0) {
                                safeRegionEvent.hrsQuat = (float[]) this.hrsQuat.clone();
                            }
                            return safeRegionEvent;
                        } catch (CloneNotSupportedException e) {
                            throw new AssertionError(e);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        if (this.timestampMs != null) {
                            codedOutputByteBufferNano.writeInt64(1, this.timestampMs.longValue());
                        }
                        if (this.entered != null) {
                            codedOutputByteBufferNano.writeBool(2, this.entered.booleanValue());
                        }
                        if (this.hrsPosition != null && this.hrsPosition.length > 0) {
                            for (float writeFloat : this.hrsPosition) {
                                codedOutputByteBufferNano.writeFloat(3, writeFloat);
                            }
                        }
                        if (this.hrsQuat != null && this.hrsQuat.length > 0) {
                            for (float writeFloat2 : this.hrsQuat) {
                                codedOutputByteBufferNano.writeFloat(4, writeFloat2);
                            }
                        }
                        super.writeTo(codedOutputByteBufferNano);
                    }

                    /* access modifiers changed from: protected */
                    public final int computeSerializedSize() {
                        int computeSerializedSize = super.computeSerializedSize();
                        if (this.timestampMs != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampMs.longValue());
                        }
                        if (this.entered != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.entered.booleanValue());
                        }
                        if (this.hrsPosition != null && this.hrsPosition.length > 0) {
                            computeSerializedSize = computeSerializedSize + (this.hrsPosition.length * 4) + (this.hrsPosition.length * 1);
                        }
                        if (this.hrsQuat == null || this.hrsQuat.length <= 0) {
                            return computeSerializedSize;
                        }
                        return computeSerializedSize + (this.hrsQuat.length * 4) + (this.hrsQuat.length * 1);
                    }

                    public final SafeRegionEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                        while (true) {
                            int readTag = codedInputByteBufferNano.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.timestampMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                    continue;
                                case 16:
                                    this.entered = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                    continue;
                                case 26:
                                    int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                                    int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                                    int i = readRawVarint32 / 4;
                                    int length = this.hrsPosition == null ? 0 : this.hrsPosition.length;
                                    float[] fArr = new float[(i + length)];
                                    if (length != 0) {
                                        System.arraycopy(this.hrsPosition, 0, fArr, 0, length);
                                    }
                                    while (length < fArr.length) {
                                        fArr[length] = codedInputByteBufferNano.readFloat();
                                        length++;
                                    }
                                    this.hrsPosition = fArr;
                                    codedInputByteBufferNano.popLimit(pushLimit);
                                    continue;
                                case 29:
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 29);
                                    int length2 = this.hrsPosition == null ? 0 : this.hrsPosition.length;
                                    float[] fArr2 = new float[(repeatedFieldArrayLength + length2)];
                                    if (length2 != 0) {
                                        System.arraycopy(this.hrsPosition, 0, fArr2, 0, length2);
                                    }
                                    while (length2 < fArr2.length - 1) {
                                        fArr2[length2] = codedInputByteBufferNano.readFloat();
                                        codedInputByteBufferNano.readTag();
                                        length2++;
                                    }
                                    fArr2[length2] = codedInputByteBufferNano.readFloat();
                                    this.hrsPosition = fArr2;
                                    continue;
                                case 34:
                                    int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                                    int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                                    int i2 = readRawVarint322 / 4;
                                    int length3 = this.hrsQuat == null ? 0 : this.hrsQuat.length;
                                    float[] fArr3 = new float[(i2 + length3)];
                                    if (length3 != 0) {
                                        System.arraycopy(this.hrsQuat, 0, fArr3, 0, length3);
                                    }
                                    while (length3 < fArr3.length) {
                                        fArr3[length3] = codedInputByteBufferNano.readFloat();
                                        length3++;
                                    }
                                    this.hrsQuat = fArr3;
                                    codedInputByteBufferNano.popLimit(pushLimit2);
                                    continue;
                                case 37:
                                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                                    int length4 = this.hrsQuat == null ? 0 : this.hrsQuat.length;
                                    float[] fArr4 = new float[(repeatedFieldArrayLength2 + length4)];
                                    if (length4 != 0) {
                                        System.arraycopy(this.hrsQuat, 0, fArr4, 0, length4);
                                    }
                                    while (length4 < fArr4.length - 1) {
                                        fArr4[length4] = codedInputByteBufferNano.readFloat();
                                        codedInputByteBufferNano.readTag();
                                        length4++;
                                    }
                                    fArr4[length4] = codedInputByteBufferNano.readFloat();
                                    this.hrsQuat = fArr4;
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

                public final PeriodicReport clone() {
                    try {
                        PeriodicReport periodicReport = (PeriodicReport) super.clone();
                        if (this.recenterEvent != null && this.recenterEvent.length > 0) {
                            periodicReport.recenterEvent = new RecenterEvent[this.recenterEvent.length];
                            for (int i = 0; i < this.recenterEvent.length; i++) {
                                if (this.recenterEvent[i] != null) {
                                    periodicReport.recenterEvent[i] = this.recenterEvent[i].clone();
                                }
                            }
                        }
                        if (this.safeRegionEvent != null && this.safeRegionEvent.length > 0) {
                            periodicReport.safeRegionEvent = new SafeRegionEvent[this.safeRegionEvent.length];
                            for (int i2 = 0; i2 < this.safeRegionEvent.length; i2++) {
                                if (this.safeRegionEvent[i2] != null) {
                                    periodicReport.safeRegionEvent[i2] = this.safeRegionEvent[i2].clone();
                                }
                            }
                        }
                        return periodicReport;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.startTimestampMs != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.startTimestampMs.longValue());
                    }
                    if (this.endTimestampMs != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.endTimestampMs.longValue());
                    }
                    if (this.recenterEvent != null && this.recenterEvent.length > 0) {
                        for (RecenterEvent recenterEvent2 : this.recenterEvent) {
                            if (recenterEvent2 != null) {
                                codedOutputByteBufferNano.writeMessage(3, recenterEvent2);
                            }
                        }
                    }
                    if (this.safeRegionEvent != null && this.safeRegionEvent.length > 0) {
                        for (SafeRegionEvent safeRegionEvent2 : this.safeRegionEvent) {
                            if (safeRegionEvent2 != null) {
                                codedOutputByteBufferNano.writeMessage(4, safeRegionEvent2);
                            }
                        }
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.startTimestampMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.startTimestampMs.longValue());
                    }
                    if (this.endTimestampMs != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.endTimestampMs.longValue());
                    }
                    if (this.recenterEvent != null && this.recenterEvent.length > 0) {
                        int i = computeSerializedSize;
                        for (RecenterEvent recenterEvent2 : this.recenterEvent) {
                            if (recenterEvent2 != null) {
                                i += CodedOutputByteBufferNano.computeMessageSize(3, recenterEvent2);
                            }
                        }
                        computeSerializedSize = i;
                    }
                    if (this.safeRegionEvent != null && this.safeRegionEvent.length > 0) {
                        for (SafeRegionEvent safeRegionEvent2 : this.safeRegionEvent) {
                            if (safeRegionEvent2 != null) {
                                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, safeRegionEvent2);
                            }
                        }
                    }
                    return computeSerializedSize;
                }

                public final PeriodicReport mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.startTimestampMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 16:
                                this.endTimestampMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 26:
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                                int length = this.recenterEvent == null ? 0 : this.recenterEvent.length;
                                RecenterEvent[] recenterEventArr = new RecenterEvent[(repeatedFieldArrayLength + length)];
                                if (length != 0) {
                                    System.arraycopy(this.recenterEvent, 0, recenterEventArr, 0, length);
                                }
                                while (length < recenterEventArr.length - 1) {
                                    recenterEventArr[length] = new RecenterEvent();
                                    codedInputByteBufferNano.readMessage(recenterEventArr[length]);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                recenterEventArr[length] = new RecenterEvent();
                                codedInputByteBufferNano.readMessage(recenterEventArr[length]);
                                this.recenterEvent = recenterEventArr;
                                continue;
                            case 34:
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                int length2 = this.safeRegionEvent == null ? 0 : this.safeRegionEvent.length;
                                SafeRegionEvent[] safeRegionEventArr = new SafeRegionEvent[(repeatedFieldArrayLength2 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.safeRegionEvent, 0, safeRegionEventArr, 0, length2);
                                }
                                while (length2 < safeRegionEventArr.length - 1) {
                                    safeRegionEventArr[length2] = new SafeRegionEvent();
                                    codedInputByteBufferNano.readMessage(safeRegionEventArr[length2]);
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                safeRegionEventArr[length2] = new SafeRegionEvent();
                                codedInputByteBufferNano.readMessage(safeRegionEventArr[length2]);
                                this.safeRegionEvent = safeRegionEventArr;
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$HeadTracking$SafetyCylinderConfig */
            public static final class SafetyCylinderConfig extends ExtendableMessageNano<SafetyCylinderConfig> implements Cloneable {
                public Float anchorWarningDistance;
                public Float collisionSphereRadius;
                public Float enterEventRadius;
                public Float exitEventRadius;
                public float[] innerFogColor;
                public Float innerRadius;
                public float[] outerFogColor;
                public Float outerRadius;

                public SafetyCylinderConfig() {
                    clear();
                }

                public final SafetyCylinderConfig clear() {
                    this.innerRadius = null;
                    this.outerRadius = null;
                    this.collisionSphereRadius = null;
                    this.innerFogColor = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.outerFogColor = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.enterEventRadius = null;
                    this.exitEventRadius = null;
                    this.anchorWarningDistance = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final SafetyCylinderConfig clone() {
                    try {
                        SafetyCylinderConfig safetyCylinderConfig = (SafetyCylinderConfig) super.clone();
                        if (this.innerFogColor != null && this.innerFogColor.length > 0) {
                            safetyCylinderConfig.innerFogColor = (float[]) this.innerFogColor.clone();
                        }
                        if (this.outerFogColor != null && this.outerFogColor.length > 0) {
                            safetyCylinderConfig.outerFogColor = (float[]) this.outerFogColor.clone();
                        }
                        return safetyCylinderConfig;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.innerRadius != null) {
                        codedOutputByteBufferNano.writeFloat(1, this.innerRadius.floatValue());
                    }
                    if (this.outerRadius != null) {
                        codedOutputByteBufferNano.writeFloat(2, this.outerRadius.floatValue());
                    }
                    if (this.collisionSphereRadius != null) {
                        codedOutputByteBufferNano.writeFloat(3, this.collisionSphereRadius.floatValue());
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
                    if (this.enterEventRadius != null) {
                        codedOutputByteBufferNano.writeFloat(6, this.enterEventRadius.floatValue());
                    }
                    if (this.exitEventRadius != null) {
                        codedOutputByteBufferNano.writeFloat(7, this.exitEventRadius.floatValue());
                    }
                    if (this.anchorWarningDistance != null) {
                        codedOutputByteBufferNano.writeFloat(8, this.anchorWarningDistance.floatValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.innerRadius != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.innerRadius.floatValue());
                    }
                    if (this.outerRadius != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.outerRadius.floatValue());
                    }
                    if (this.collisionSphereRadius != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.collisionSphereRadius.floatValue());
                    }
                    if (this.innerFogColor != null && this.innerFogColor.length > 0) {
                        computeSerializedSize = computeSerializedSize + (this.innerFogColor.length * 4) + (this.innerFogColor.length * 1);
                    }
                    if (this.outerFogColor != null && this.outerFogColor.length > 0) {
                        computeSerializedSize = computeSerializedSize + (this.outerFogColor.length * 4) + (this.outerFogColor.length * 1);
                    }
                    if (this.enterEventRadius != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.enterEventRadius.floatValue());
                    }
                    if (this.exitEventRadius != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(7, this.exitEventRadius.floatValue());
                    }
                    if (this.anchorWarningDistance != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(8, this.anchorWarningDistance.floatValue());
                    }
                    return computeSerializedSize;
                }

                public final SafetyCylinderConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 13:
                                this.innerRadius = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case 21:
                                this.outerRadius = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case 29:
                                this.collisionSphereRadius = Float.valueOf(codedInputByteBufferNano.readFloat());
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
                                this.enterEventRadius = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case 61:
                                this.exitEventRadius = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case 69:
                                this.anchorWarningDistance = Float.valueOf(codedInputByteBufferNano.readFloat());
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

            public HeadTracking() {
                clear();
            }

            public final HeadTracking clear() {
                this.sixDofFallbackReason = null;
                this.sixDofFallbackTimestamp = null;
                this.floorHeight = null;
                this.headTrackingTimestamp = null;
                this.periodicReport = null;
                this.oneof_safety_config_ = -1;
                this.safetyCylinderConfig = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final HeadTracking clone() {
                try {
                    HeadTracking headTracking = (HeadTracking) super.clone();
                    if (this.periodicReport != null) {
                        headTracking.periodicReport = this.periodicReport.clone();
                    }
                    if (this.safetyCylinderConfig != null) {
                        headTracking.safetyCylinderConfig = this.safetyCylinderConfig.clone();
                    }
                    return headTracking;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.sixDofFallbackReason != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.sixDofFallbackReason.intValue());
                }
                if (this.sixDofFallbackTimestamp != null) {
                    codedOutputByteBufferNano.writeInt64(2, this.sixDofFallbackTimestamp.longValue());
                }
                if (this.floorHeight != null) {
                    codedOutputByteBufferNano.writeFloat(3, this.floorHeight.floatValue());
                }
                if (this.headTrackingTimestamp != null) {
                    codedOutputByteBufferNano.writeInt64(4, this.headTrackingTimestamp.longValue());
                }
                if (this.periodicReport != null) {
                    codedOutputByteBufferNano.writeMessage(5, this.periodicReport);
                }
                if (this.oneof_safety_config_ == 0) {
                    codedOutputByteBufferNano.writeMessage(6, this.safetyCylinderConfig);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.sixDofFallbackReason != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.sixDofFallbackReason.intValue());
                }
                if (this.sixDofFallbackTimestamp != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.sixDofFallbackTimestamp.longValue());
                }
                if (this.floorHeight != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.floorHeight.floatValue());
                }
                if (this.headTrackingTimestamp != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.headTrackingTimestamp.longValue());
                }
                if (this.periodicReport != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.periodicReport);
                }
                if (this.oneof_safety_config_ == 0) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, this.safetyCylinderConfig);
                }
                return computeSerializedSize;
            }

            public final HeadTracking mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.sixDofFallbackReason = Integer.valueOf(checkFallBackReasonOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 16:
                            this.sixDofFallbackTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                            continue;
                        case 29:
                            this.floorHeight = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 32:
                            this.headTrackingTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                            continue;
                        case 42:
                            if (this.periodicReport == null) {
                                this.periodicReport = new PeriodicReport();
                            }
                            codedInputByteBufferNano.readMessage(this.periodicReport);
                            continue;
                        case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                            if (this.safetyCylinderConfig == null) {
                                this.safetyCylinderConfig = new SafetyCylinderConfig();
                            }
                            codedInputByteBufferNano.readMessage(this.safetyCylinderConfig);
                            this.oneof_safety_config_ = 0;
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector */
        public static final class JumpInspector extends ExtendableMessageNano<JumpInspector> implements Cloneable {
            public MediaDetails mediaDetails;
            public PickerDetails pickerEvent;
            public PlaybackDetails playbackDetails;

            public JumpInspector() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$AudioDetails */
            public static final class AudioDetails extends ExtendableMessageNano<AudioDetails> implements Cloneable {
                public Integer audioBitRate;
                public Integer audioChannelCount;
                @NanoEnumValue(legacy = false, value = MediaDetails.AudioCodec.class)
                public Integer audioCodec;
                public Long mediaLengthSeconds;
                public Integer sampleRate;

                public AudioDetails() {
                    clear();
                }

                public final AudioDetails clear() {
                    this.mediaLengthSeconds = null;
                    this.sampleRate = null;
                    this.audioBitRate = null;
                    this.audioCodec = null;
                    this.audioChannelCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final AudioDetails clone() {
                    try {
                        return (AudioDetails) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.mediaLengthSeconds != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.mediaLengthSeconds.longValue());
                    }
                    if (this.sampleRate != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.sampleRate.intValue());
                    }
                    if (this.audioBitRate != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.audioBitRate.intValue());
                    }
                    if (this.audioCodec != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.audioCodec.intValue());
                    }
                    if (this.audioChannelCount != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.audioChannelCount.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.mediaLengthSeconds != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.mediaLengthSeconds.longValue());
                    }
                    if (this.sampleRate != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.sampleRate.intValue());
                    }
                    if (this.audioBitRate != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.audioBitRate.intValue());
                    }
                    if (this.audioCodec != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.audioCodec.intValue());
                    }
                    if (this.audioChannelCount != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, this.audioChannelCount.intValue());
                    }
                    return computeSerializedSize;
                }

                public final AudioDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.mediaLengthSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 16:
                                this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.audioBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 32:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.audioCodec = Integer.valueOf(MediaDetails.checkAudioCodecOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 40:
                                this.audioChannelCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$ImageDetails */
            public static final class ImageDetails extends ExtendableMessageNano<ImageDetails> implements Cloneable {
                public Resolution resolution;
                public Boolean usedMonoFilename;

                public ImageDetails() {
                    clear();
                }

                public final ImageDetails clear() {
                    this.resolution = null;
                    this.usedMonoFilename = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ImageDetails clone() {
                    try {
                        ImageDetails imageDetails = (ImageDetails) super.clone();
                        if (this.resolution != null) {
                            imageDetails.resolution = this.resolution.clone();
                        }
                        return imageDetails;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.resolution != null) {
                        codedOutputByteBufferNano.writeMessage(1, this.resolution);
                    }
                    if (this.usedMonoFilename != null) {
                        codedOutputByteBufferNano.writeBool(2, this.usedMonoFilename.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.resolution != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.resolution);
                    }
                    if (this.usedMonoFilename != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.usedMonoFilename.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final ImageDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                if (this.resolution == null) {
                                    this.resolution = new Resolution();
                                }
                                codedInputByteBufferNano.readMessage(this.resolution);
                                continue;
                            case 16:
                                this.usedMonoFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$ImagePlaybackDetails */
            public static final class ImagePlaybackDetails extends ExtendableMessageNano<ImagePlaybackDetails> implements Cloneable {
                @NanoEnumValue(legacy = false, value = PlaybackDetails.PlaybackMode.class)
                public Integer playbackMode;

                public ImagePlaybackDetails() {
                    clear();
                }

                public final ImagePlaybackDetails clear() {
                    this.playbackMode = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ImagePlaybackDetails clone() {
                    try {
                        return (ImagePlaybackDetails) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.playbackMode != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.playbackMode.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.playbackMode != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, this.playbackMode.intValue());
                    }
                    return computeSerializedSize;
                }

                public final ImagePlaybackDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.playbackMode = Integer.valueOf(PlaybackDetails.checkPlaybackModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$MediaDetails */
            public static final class MediaDetails extends ExtendableMessageNano<MediaDetails> implements Cloneable {
                public AudioDetails audioDetails;
                public String fileExtension;
                public ImageDetails imageDetails;
                public VideoDetails videoDetails;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$MediaDetails$AudioCodec */
                public interface AudioCodec {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$MediaDetails$VideoCodec */
                public interface VideoCodec {
                }

                @NanoEnumValue(legacy = false, value = AudioCodec.class)
                public static int checkAudioCodecOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum AudioCodec").toString());
                }

                @NanoEnumValue(legacy = false, value = VideoCodec.class)
                public static int checkVideoCodecOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum VideoCodec").toString());
                }

                public MediaDetails() {
                    clear();
                }

                public final MediaDetails clear() {
                    this.fileExtension = null;
                    this.videoDetails = null;
                    this.imageDetails = null;
                    this.audioDetails = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final MediaDetails clone() {
                    try {
                        MediaDetails mediaDetails = (MediaDetails) super.clone();
                        if (this.videoDetails != null) {
                            mediaDetails.videoDetails = this.videoDetails.clone();
                        }
                        if (this.imageDetails != null) {
                            mediaDetails.imageDetails = this.imageDetails.clone();
                        }
                        if (this.audioDetails != null) {
                            mediaDetails.audioDetails = this.audioDetails.clone();
                        }
                        return mediaDetails;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.fileExtension != null) {
                        codedOutputByteBufferNano.writeString(1, this.fileExtension);
                    }
                    if (this.videoDetails != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.videoDetails);
                    }
                    if (this.imageDetails != null) {
                        codedOutputByteBufferNano.writeMessage(3, this.imageDetails);
                    }
                    if (this.audioDetails != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.audioDetails);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.fileExtension != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.fileExtension);
                    }
                    if (this.videoDetails != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.videoDetails);
                    }
                    if (this.imageDetails != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.imageDetails);
                    }
                    if (this.audioDetails != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.audioDetails);
                    }
                    return computeSerializedSize;
                }

                public final MediaDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.fileExtension = codedInputByteBufferNano.readString();
                                continue;
                            case 18:
                                if (this.videoDetails == null) {
                                    this.videoDetails = new VideoDetails();
                                }
                                codedInputByteBufferNano.readMessage(this.videoDetails);
                                continue;
                            case 26:
                                if (this.imageDetails == null) {
                                    this.imageDetails = new ImageDetails();
                                }
                                codedInputByteBufferNano.readMessage(this.imageDetails);
                                continue;
                            case 34:
                                if (this.audioDetails == null) {
                                    this.audioDetails = new AudioDetails();
                                }
                                codedInputByteBufferNano.readMessage(this.audioDetails);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$PickerDetails */
            public static final class PickerDetails extends ExtendableMessageNano<PickerDetails> implements Cloneable {
                public Integer numberOfFiles;
                public Integer numberOfFolders;

                public PickerDetails() {
                    clear();
                }

                public final PickerDetails clear() {
                    this.numberOfFiles = null;
                    this.numberOfFolders = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final PickerDetails clone() {
                    try {
                        return (PickerDetails) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.numberOfFiles != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.numberOfFiles.intValue());
                    }
                    if (this.numberOfFolders != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.numberOfFolders.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.numberOfFiles != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.numberOfFiles.intValue());
                    }
                    if (this.numberOfFolders != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.numberOfFolders.intValue());
                    }
                    return computeSerializedSize;
                }

                public final PickerDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.numberOfFiles = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.numberOfFolders = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$PlaybackDetails */
            public static final class PlaybackDetails extends ExtendableMessageNano<PlaybackDetails> implements Cloneable {
                public ImagePlaybackDetails imagePlayback;
                public Long playbackDurationSeconds;
                @NanoEnumValue(legacy = false, value = PlaybackEngine.class)
                public Integer playbackEngine;
                @NanoEnumValue(legacy = false, value = PlaybackState.class)
                public Integer playbackState;
                public VideoPlaybackDetails videoPlayback;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$PlaybackDetails$PlaybackEngine */
                public interface PlaybackEngine {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$PlaybackDetails$PlaybackMode */
                public interface PlaybackMode {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$PlaybackDetails$PlaybackState */
                public interface PlaybackState {
                }

                @NanoEnumValue(legacy = false, value = PlaybackState.class)
                public static int checkPlaybackStateOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(45).append(i).append(" is not a valid enum PlaybackState").toString());
                }

                @NanoEnumValue(legacy = false, value = PlaybackEngine.class)
                public static int checkPlaybackEngineOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum PlaybackEngine").toString());
                }

                @NanoEnumValue(legacy = false, value = PlaybackMode.class)
                public static int checkPlaybackModeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(44).append(i).append(" is not a valid enum PlaybackMode").toString());
                }

                public PlaybackDetails() {
                    clear();
                }

                public final PlaybackDetails clear() {
                    this.playbackState = null;
                    this.playbackDurationSeconds = null;
                    this.playbackEngine = null;
                    this.videoPlayback = null;
                    this.imagePlayback = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final PlaybackDetails clone() {
                    try {
                        PlaybackDetails playbackDetails = (PlaybackDetails) super.clone();
                        if (this.videoPlayback != null) {
                            playbackDetails.videoPlayback = this.videoPlayback.clone();
                        }
                        if (this.imagePlayback != null) {
                            playbackDetails.imagePlayback = this.imagePlayback.clone();
                        }
                        return playbackDetails;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.playbackState != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.playbackState.intValue());
                    }
                    if (this.playbackDurationSeconds != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.playbackDurationSeconds.longValue());
                    }
                    if (this.playbackEngine != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.playbackEngine.intValue());
                    }
                    if (this.videoPlayback != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.videoPlayback);
                    }
                    if (this.imagePlayback != null) {
                        codedOutputByteBufferNano.writeMessage(5, this.imagePlayback);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.playbackState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.playbackState.intValue());
                    }
                    if (this.playbackDurationSeconds != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.playbackDurationSeconds.longValue());
                    }
                    if (this.playbackEngine != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.playbackEngine.intValue());
                    }
                    if (this.videoPlayback != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.videoPlayback);
                    }
                    if (this.imagePlayback != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, this.imagePlayback);
                    }
                    return computeSerializedSize;
                }

                public final PlaybackDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.playbackState = Integer.valueOf(checkPlaybackStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.playbackDurationSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.playbackEngine = Integer.valueOf(checkPlaybackEngineOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 34:
                                if (this.videoPlayback == null) {
                                    this.videoPlayback = new VideoPlaybackDetails();
                                }
                                codedInputByteBufferNano.readMessage(this.videoPlayback);
                                continue;
                            case 42:
                                if (this.imagePlayback == null) {
                                    this.imagePlayback = new ImagePlaybackDetails();
                                }
                                codedInputByteBufferNano.readMessage(this.imagePlayback);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$Resolution */
            public static final class Resolution extends ExtendableMessageNano<Resolution> implements Cloneable {
                public Integer height;
                public Integer width;

                public Resolution() {
                    clear();
                }

                public final Resolution clear() {
                    this.width = null;
                    this.height = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Resolution clone() {
                    try {
                        return (Resolution) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.width != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.width.intValue());
                    }
                    if (this.height != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.height.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.width != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.width.intValue());
                    }
                    if (this.height != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.height.intValue());
                    }
                    return computeSerializedSize;
                }

                public final Resolution mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.width = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.height = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$SphericalMetadata */
            public static final class SphericalMetadata extends ExtendableMessageNano<SphericalMetadata> implements Cloneable {
                public Integer meshCrc;
                public Integer metadataVersion;
                @NanoEnumValue(legacy = false, value = ProjectionType.class)
                public Integer projectionType;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$SphericalMetadata$ProjectionType */
                public interface ProjectionType {
                }

                @NanoEnumValue(legacy = false, value = ProjectionType.class)
                public static int checkProjectionTypeOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(46).append(i).append(" is not a valid enum ProjectionType").toString());
                }

                public SphericalMetadata() {
                    clear();
                }

                public final SphericalMetadata clear() {
                    this.metadataVersion = null;
                    this.projectionType = null;
                    this.meshCrc = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final SphericalMetadata clone() {
                    try {
                        return (SphericalMetadata) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.metadataVersion != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.metadataVersion.intValue());
                    }
                    if (this.projectionType != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.projectionType.intValue());
                    }
                    if (this.meshCrc != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.meshCrc.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.metadataVersion != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.metadataVersion.intValue());
                    }
                    if (this.projectionType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.projectionType.intValue());
                    }
                    if (this.meshCrc != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.meshCrc.intValue());
                    }
                    return computeSerializedSize;
                }

                public final SphericalMetadata mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.metadataVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.projectionType = Integer.valueOf(checkProjectionTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.meshCrc = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$VideoDetails */
            public static final class VideoDetails extends ExtendableMessageNano<VideoDetails> implements Cloneable {
                public Integer audioBitRate;
                public Integer audioChannelCount;
                @NanoEnumValue(legacy = false, value = MediaDetails.AudioCodec.class)
                public Integer audioCodec;
                public Double framesPerSecond;
                public Long mediaLengthSeconds;
                public Resolution resolution;
                public Integer sampleRate;
                public SphericalMetadata sphericalMetadata;
                public Boolean usedMonoFilename;
                public Boolean usedWalleFilename;
                public Boolean usedWallyFilename;
                public Integer videoBitRate;
                @NanoEnumValue(legacy = false, value = MediaDetails.VideoCodec.class)
                public Integer videoCodec;

                public VideoDetails() {
                    clear();
                }

                public final VideoDetails clear() {
                    this.mediaLengthSeconds = null;
                    this.resolution = null;
                    this.framesPerSecond = null;
                    this.sampleRate = null;
                    this.videoBitRate = null;
                    this.audioBitRate = null;
                    this.videoCodec = null;
                    this.audioCodec = null;
                    this.sphericalMetadata = null;
                    this.audioChannelCount = null;
                    this.usedMonoFilename = null;
                    this.usedWalleFilename = null;
                    this.usedWallyFilename = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final VideoDetails clone() {
                    try {
                        VideoDetails videoDetails = (VideoDetails) super.clone();
                        if (this.resolution != null) {
                            videoDetails.resolution = this.resolution.clone();
                        }
                        if (this.sphericalMetadata != null) {
                            videoDetails.sphericalMetadata = this.sphericalMetadata.clone();
                        }
                        return videoDetails;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.mediaLengthSeconds != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.mediaLengthSeconds.longValue());
                    }
                    if (this.resolution != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.resolution);
                    }
                    if (this.framesPerSecond != null) {
                        codedOutputByteBufferNano.writeDouble(3, this.framesPerSecond.doubleValue());
                    }
                    if (this.sampleRate != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.sampleRate.intValue());
                    }
                    if (this.videoBitRate != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.videoBitRate.intValue());
                    }
                    if (this.audioBitRate != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.audioBitRate.intValue());
                    }
                    if (this.videoCodec != null) {
                        codedOutputByteBufferNano.writeInt32(7, this.videoCodec.intValue());
                    }
                    if (this.audioCodec != null) {
                        codedOutputByteBufferNano.writeInt32(8, this.audioCodec.intValue());
                    }
                    if (this.sphericalMetadata != null) {
                        codedOutputByteBufferNano.writeMessage(9, this.sphericalMetadata);
                    }
                    if (this.audioChannelCount != null) {
                        codedOutputByteBufferNano.writeInt32(10, this.audioChannelCount.intValue());
                    }
                    if (this.usedMonoFilename != null) {
                        codedOutputByteBufferNano.writeBool(11, this.usedMonoFilename.booleanValue());
                    }
                    if (this.usedWalleFilename != null) {
                        codedOutputByteBufferNano.writeBool(12, this.usedWalleFilename.booleanValue());
                    }
                    if (this.usedWallyFilename != null) {
                        codedOutputByteBufferNano.writeBool(13, this.usedWallyFilename.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.mediaLengthSeconds != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.mediaLengthSeconds.longValue());
                    }
                    if (this.resolution != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.resolution);
                    }
                    if (this.framesPerSecond != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.framesPerSecond.doubleValue());
                    }
                    if (this.sampleRate != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.sampleRate.intValue());
                    }
                    if (this.videoBitRate != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.videoBitRate.intValue());
                    }
                    if (this.audioBitRate != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.audioBitRate.intValue());
                    }
                    if (this.videoCodec != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.videoCodec.intValue());
                    }
                    if (this.audioCodec != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, this.audioCodec.intValue());
                    }
                    if (this.sphericalMetadata != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, this.sphericalMetadata);
                    }
                    if (this.audioChannelCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, this.audioChannelCount.intValue());
                    }
                    if (this.usedMonoFilename != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, this.usedMonoFilename.booleanValue());
                    }
                    if (this.usedWalleFilename != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, this.usedWalleFilename.booleanValue());
                    }
                    if (this.usedWallyFilename != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, this.usedWallyFilename.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final VideoDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.mediaLengthSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 18:
                                if (this.resolution == null) {
                                    this.resolution = new Resolution();
                                }
                                codedInputByteBufferNano.readMessage(this.resolution);
                                continue;
                            case AndroidNCompat.NMR1_SDK_LEVEL:
                                this.framesPerSecond = Double.valueOf(codedInputByteBufferNano.readDouble());
                                continue;
                            case 32:
                                this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 40:
                                this.videoBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 48:
                                this.audioBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 56:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.videoCodec = Integer.valueOf(MediaDetails.checkVideoCodecOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 64:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.audioCodec = Integer.valueOf(MediaDetails.checkAudioCodecOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 74:
                                if (this.sphericalMetadata == null) {
                                    this.sphericalMetadata = new SphericalMetadata();
                                }
                                codedInputByteBufferNano.readMessage(this.sphericalMetadata);
                                continue;
                            case 80:
                                this.audioChannelCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 88:
                                this.usedMonoFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 96:
                                this.usedWalleFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 104:
                                this.usedWallyFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$JumpInspector$VideoPlaybackDetails */
            public static final class VideoPlaybackDetails extends ExtendableMessageNano<VideoPlaybackDetails> implements Cloneable {
                public Integer droppedFramesCount;
                @NanoEnumValue(legacy = false, value = PlaybackDetails.PlaybackMode.class)
                public Integer playbackMode;
                public Boolean usedExternalSync;

                public VideoPlaybackDetails() {
                    clear();
                }

                public final VideoPlaybackDetails clear() {
                    this.playbackMode = null;
                    this.usedExternalSync = null;
                    this.droppedFramesCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final VideoPlaybackDetails clone() {
                    try {
                        return (VideoPlaybackDetails) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.playbackMode != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.playbackMode.intValue());
                    }
                    if (this.usedExternalSync != null) {
                        codedOutputByteBufferNano.writeBool(2, this.usedExternalSync.booleanValue());
                    }
                    if (this.droppedFramesCount != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.droppedFramesCount.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.playbackMode != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.playbackMode.intValue());
                    }
                    if (this.usedExternalSync != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.usedExternalSync.booleanValue());
                    }
                    if (this.droppedFramesCount != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.droppedFramesCount.intValue());
                    }
                    return computeSerializedSize;
                }

                public final VideoPlaybackDetails mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.playbackMode = Integer.valueOf(PlaybackDetails.checkPlaybackModeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.usedExternalSync = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.droppedFramesCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            public final JumpInspector clear() {
                this.mediaDetails = null;
                this.playbackDetails = null;
                this.pickerEvent = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final JumpInspector clone() {
                try {
                    JumpInspector jumpInspector = (JumpInspector) super.clone();
                    if (this.mediaDetails != null) {
                        jumpInspector.mediaDetails = this.mediaDetails.clone();
                    }
                    if (this.playbackDetails != null) {
                        jumpInspector.playbackDetails = this.playbackDetails.clone();
                    }
                    if (this.pickerEvent != null) {
                        jumpInspector.pickerEvent = this.pickerEvent.clone();
                    }
                    return jumpInspector;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.mediaDetails != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.mediaDetails);
                }
                if (this.playbackDetails != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.playbackDetails);
                }
                if (this.pickerEvent != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.pickerEvent);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.mediaDetails != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.mediaDetails);
                }
                if (this.playbackDetails != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.playbackDetails);
                }
                if (this.pickerEvent != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, this.pickerEvent);
                }
                return computeSerializedSize;
            }

            public final JumpInspector mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.mediaDetails == null) {
                                this.mediaDetails = new MediaDetails();
                            }
                            codedInputByteBufferNano.readMessage(this.mediaDetails);
                            continue;
                        case 18:
                            if (this.playbackDetails == null) {
                                this.playbackDetails = new PlaybackDetails();
                            }
                            codedInputByteBufferNano.readMessage(this.playbackDetails);
                            continue;
                        case 26:
                            if (this.pickerEvent == null) {
                                this.pickerEvent = new PickerDetails();
                            }
                            codedInputByteBufferNano.readMessage(this.pickerEvent);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Keyboard */
        public static final class Keyboard extends ExtendableMessageNano<Keyboard> implements Cloneable {
            public KeyboardEvent[] keyboardEvents;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Keyboard$KeyboardEventType */
            public interface KeyboardEventType {
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Keyboard$KeyboardInputType */
            public interface KeyboardInputType {
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Keyboard$KeyboardTextType */
            public interface KeyboardTextType {
            }

            @NanoEnumValue(legacy = false, value = KeyboardEventType.class)
            public static int checkKeyboardEventTypeOrThrow(int i) {
                if ((i >= 0 && i <= 10) || ((i >= 1000 && i <= 1001) || ((i >= 2000 && i <= 2001) || (i >= 3000 && i <= 3002)))) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(49).append(i).append(" is not a valid enum KeyboardEventType").toString());
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Keyboard$KeyboardTextEntry */
            public static final class KeyboardTextEntry extends ExtendableMessageNano<KeyboardTextEntry> implements Cloneable {
                public String language;
                public String layout;
                public Integer length;
                @NanoEnumValue(legacy = false, value = KeyboardTextType.class)
                public Integer type;

                public KeyboardTextEntry() {
                    clear();
                }

                public final KeyboardTextEntry clear() {
                    this.type = null;
                    this.length = null;
                    this.layout = null;
                    this.language = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final KeyboardTextEntry clone() {
                    try {
                        return (KeyboardTextEntry) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.type != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.type.intValue());
                    }
                    if (this.length != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.length.intValue());
                    }
                    if (this.layout != null) {
                        codedOutputByteBufferNano.writeString(3, this.layout);
                    }
                    if (this.language != null) {
                        codedOutputByteBufferNano.writeString(4, this.language);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.type != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }
                    if (this.length != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.length.intValue());
                    }
                    if (this.layout != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.layout);
                    }
                    if (this.language != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.language);
                    }
                    return computeSerializedSize;
                }

                public final KeyboardTextEntry mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.type = Integer.valueOf(Keyboard.checkKeyboardTextTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.length = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 26:
                                this.layout = codedInputByteBufferNano.readString();
                                continue;
                            case 34:
                                this.language = codedInputByteBufferNano.readString();
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Keyboard$KeyboardEvent */
            public static final class KeyboardEvent extends ExtendableMessageNano<KeyboardEvent> implements Cloneable {
                private static volatile KeyboardEvent[] _emptyArray;
                public Long clientTimestamp;
                public String[] enabledLanguages;
                @NanoEnumValue(legacy = false, value = KeyboardEventType.class)
                public Integer eventType;
                @NanoEnumValue(legacy = false, value = KeyboardInputType.class)
                public Integer inputType;
                public Application keyboardService;
                public String language;
                public String layout;
                public Integer suggestionCount;
                public String[] systemLanguages;
                public KeyboardTextEntry textEntry;
                public String[] voiceInputLanguages;

                public static KeyboardEvent[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new KeyboardEvent[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public KeyboardEvent() {
                    clear();
                }

                public final KeyboardEvent clear() {
                    this.clientTimestamp = null;
                    this.eventType = null;
                    this.textEntry = null;
                    this.keyboardService = null;
                    this.systemLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.enabledLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.language = null;
                    this.inputType = null;
                    this.layout = null;
                    this.suggestionCount = null;
                    this.voiceInputLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final KeyboardEvent clone() {
                    try {
                        KeyboardEvent keyboardEvent = (KeyboardEvent) super.clone();
                        if (this.textEntry != null) {
                            keyboardEvent.textEntry = this.textEntry.clone();
                        }
                        if (this.keyboardService != null) {
                            keyboardEvent.keyboardService = this.keyboardService.clone();
                        }
                        if (this.systemLanguages != null && this.systemLanguages.length > 0) {
                            keyboardEvent.systemLanguages = (String[]) this.systemLanguages.clone();
                        }
                        if (this.enabledLanguages != null && this.enabledLanguages.length > 0) {
                            keyboardEvent.enabledLanguages = (String[]) this.enabledLanguages.clone();
                        }
                        if (this.voiceInputLanguages != null && this.voiceInputLanguages.length > 0) {
                            keyboardEvent.voiceInputLanguages = (String[]) this.voiceInputLanguages.clone();
                        }
                        return keyboardEvent;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.clientTimestamp != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.clientTimestamp.longValue());
                    }
                    if (this.eventType != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.eventType.intValue());
                    }
                    if (this.textEntry != null) {
                        codedOutputByteBufferNano.writeMessage(3, this.textEntry);
                    }
                    if (this.keyboardService != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.keyboardService);
                    }
                    if (this.systemLanguages != null && this.systemLanguages.length > 0) {
                        for (String str : this.systemLanguages) {
                            if (str != null) {
                                codedOutputByteBufferNano.writeString(5, str);
                            }
                        }
                    }
                    if (this.enabledLanguages != null && this.enabledLanguages.length > 0) {
                        for (String str2 : this.enabledLanguages) {
                            if (str2 != null) {
                                codedOutputByteBufferNano.writeString(6, str2);
                            }
                        }
                    }
                    if (this.language != null) {
                        codedOutputByteBufferNano.writeString(7, this.language);
                    }
                    if (this.inputType != null) {
                        codedOutputByteBufferNano.writeInt32(8, this.inputType.intValue());
                    }
                    if (this.layout != null) {
                        codedOutputByteBufferNano.writeString(9, this.layout);
                    }
                    if (this.suggestionCount != null) {
                        codedOutputByteBufferNano.writeInt32(10, this.suggestionCount.intValue());
                    }
                    if (this.voiceInputLanguages != null && this.voiceInputLanguages.length > 0) {
                        for (String str3 : this.voiceInputLanguages) {
                            if (str3 != null) {
                                codedOutputByteBufferNano.writeString(11, str3);
                            }
                        }
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.clientTimestamp != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.clientTimestamp.longValue());
                    }
                    if (this.eventType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.eventType.intValue());
                    }
                    if (this.textEntry != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.textEntry);
                    }
                    if (this.keyboardService != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, this.keyboardService);
                    }
                    if (this.systemLanguages != null && this.systemLanguages.length > 0) {
                        int i = 0;
                        int i2 = 0;
                        for (String str : this.systemLanguages) {
                            if (str != null) {
                                i2++;
                                i += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                            }
                        }
                        computeSerializedSize = computeSerializedSize + i + (i2 * 1);
                    }
                    if (this.enabledLanguages != null && this.enabledLanguages.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str2 : this.enabledLanguages) {
                            if (str2 != null) {
                                i4++;
                                i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                            }
                        }
                        computeSerializedSize = computeSerializedSize + i3 + (i4 * 1);
                    }
                    if (this.language != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.language);
                    }
                    if (this.inputType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, this.inputType.intValue());
                    }
                    if (this.layout != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.layout);
                    }
                    if (this.suggestionCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, this.suggestionCount.intValue());
                    }
                    if (this.voiceInputLanguages == null || this.voiceInputLanguages.length <= 0) {
                        return computeSerializedSize;
                    }
                    int i5 = 0;
                    int i6 = 0;
                    for (String str3 : this.voiceInputLanguages) {
                        if (str3 != null) {
                            i6++;
                            i5 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                        }
                    }
                    return computeSerializedSize + i5 + (i6 * 1);
                }

                public final KeyboardEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.clientTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 16:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.eventType = Integer.valueOf(Keyboard.checkKeyboardEventTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 26:
                                if (this.textEntry == null) {
                                    this.textEntry = new KeyboardTextEntry();
                                }
                                codedInputByteBufferNano.readMessage(this.textEntry);
                                continue;
                            case 34:
                                if (this.keyboardService == null) {
                                    this.keyboardService = new Application();
                                }
                                codedInputByteBufferNano.readMessage(this.keyboardService);
                                continue;
                            case 42:
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                int length = this.systemLanguages == null ? 0 : this.systemLanguages.length;
                                String[] strArr = new String[(repeatedFieldArrayLength + length)];
                                if (length != 0) {
                                    System.arraycopy(this.systemLanguages, 0, strArr, 0, length);
                                }
                                while (length < strArr.length - 1) {
                                    strArr[length] = codedInputByteBufferNano.readString();
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                strArr[length] = codedInputByteBufferNano.readString();
                                this.systemLanguages = strArr;
                                continue;
                            case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                                int length2 = this.enabledLanguages == null ? 0 : this.enabledLanguages.length;
                                String[] strArr2 = new String[(repeatedFieldArrayLength2 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.enabledLanguages, 0, strArr2, 0, length2);
                                }
                                while (length2 < strArr2.length - 1) {
                                    strArr2[length2] = codedInputByteBufferNano.readString();
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                strArr2[length2] = codedInputByteBufferNano.readString();
                                this.enabledLanguages = strArr2;
                                continue;
                            case 58:
                                this.language = codedInputByteBufferNano.readString();
                                continue;
                            case 64:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.inputType = Integer.valueOf(Keyboard.checkKeyboardInputTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 74:
                                this.layout = codedInputByteBufferNano.readString();
                                continue;
                            case 80:
                                this.suggestionCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 90:
                                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                                int length3 = this.voiceInputLanguages == null ? 0 : this.voiceInputLanguages.length;
                                String[] strArr3 = new String[(repeatedFieldArrayLength3 + length3)];
                                if (length3 != 0) {
                                    System.arraycopy(this.voiceInputLanguages, 0, strArr3, 0, length3);
                                }
                                while (length3 < strArr3.length - 1) {
                                    strArr3[length3] = codedInputByteBufferNano.readString();
                                    codedInputByteBufferNano.readTag();
                                    length3++;
                                }
                                strArr3[length3] = codedInputByteBufferNano.readString();
                                this.voiceInputLanguages = strArr3;
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

            @NanoEnumValue(legacy = false, value = KeyboardInputType.class)
            public static int checkKeyboardInputTypeOrThrow(int i) {
                if (i >= 0 && i <= 1) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(49).append(i).append(" is not a valid enum KeyboardInputType").toString());
            }

            @NanoEnumValue(legacy = false, value = KeyboardTextType.class)
            public static int checkKeyboardTextTypeOrThrow(int i) {
                if ((i >= 0 && i <= 0) || (i >= 4 && i <= 6)) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(48).append(i).append(" is not a valid enum KeyboardTextType").toString());
            }

            public Keyboard() {
                clear();
            }

            public final Keyboard clear() {
                this.keyboardEvents = KeyboardEvent.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Keyboard clone() {
                try {
                    Keyboard keyboard = (Keyboard) super.clone();
                    if (this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                        keyboard.keyboardEvents = new KeyboardEvent[this.keyboardEvents.length];
                        for (int i = 0; i < this.keyboardEvents.length; i++) {
                            if (this.keyboardEvents[i] != null) {
                                keyboard.keyboardEvents[i] = this.keyboardEvents[i].clone();
                            }
                        }
                    }
                    return keyboard;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    for (KeyboardEvent keyboardEvent : this.keyboardEvents) {
                        if (keyboardEvent != null) {
                            codedOutputByteBufferNano.writeMessage(2, keyboardEvent);
                        }
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    for (KeyboardEvent keyboardEvent : this.keyboardEvents) {
                        if (keyboardEvent != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, keyboardEvent);
                        }
                    }
                }
                return computeSerializedSize;
            }

            public final Keyboard mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 18:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                            int length = this.keyboardEvents == null ? 0 : this.keyboardEvents.length;
                            KeyboardEvent[] keyboardEventArr = new KeyboardEvent[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.keyboardEvents, 0, keyboardEventArr, 0, length);
                            }
                            while (length < keyboardEventArr.length - 1) {
                                keyboardEventArr[length] = new KeyboardEvent();
                                codedInputByteBufferNano.readMessage(keyboardEventArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            keyboardEventArr[length] = new KeyboardEvent();
                            codedInputByteBufferNano.readMessage(keyboardEventArr[length]);
                            this.keyboardEvents = keyboardEventArr;
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Lullaby */
        public static final class Lullaby extends ExtendableMessageNano<Lullaby> implements Cloneable {
            public String contentId;
            public Integer index;
            public LoadTime loadTime;
            @NanoEnumValue(legacy = false, value = UiElement.class)
            public Integer uiElement;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Lullaby$UiElement */
            public interface UiElement {
            }

            @NanoEnumValue(legacy = false, value = UiElement.class)
            public static int checkUiElementOrThrow(int i) {
                if ((i >= 0 && i <= 1) || ((i >= 1000 && i <= 1008) || ((i >= 2000 && i <= 2021) || (i >= 3000 && i <= 3014)))) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum UiElement").toString());
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Lullaby$LoadTime */
            public static final class LoadTime extends ExtendableMessageNano<LoadTime> implements Cloneable {
                @NanoEnumValue(legacy = false, value = AssetType.class)
                public Integer assetType;
                public Long loadTimeMs;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Lullaby$LoadTime$AssetType */
                public interface AssetType {
                }

                @NanoEnumValue(legacy = false, value = AssetType.class)
                public static int checkAssetTypeOrThrow(int i) {
                    if (i >= 0 && i <= 10) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum AssetType").toString());
                }

                public LoadTime() {
                    clear();
                }

                public final LoadTime clear() {
                    this.assetType = null;
                    this.loadTimeMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final LoadTime clone() {
                    try {
                        return (LoadTime) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.assetType != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.assetType.intValue());
                    }
                    if (this.loadTimeMs != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.loadTimeMs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.assetType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.assetType.intValue());
                    }
                    if (this.loadTimeMs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, this.loadTimeMs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final LoadTime mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.assetType = Integer.valueOf(checkAssetTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.loadTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            public Lullaby() {
                clear();
            }

            public final Lullaby clear() {
                this.uiElement = null;
                this.index = null;
                this.contentId = null;
                this.loadTime = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Lullaby clone() {
                try {
                    Lullaby lullaby = (Lullaby) super.clone();
                    if (this.loadTime != null) {
                        lullaby.loadTime = this.loadTime.clone();
                    }
                    return lullaby;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.uiElement != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.uiElement.intValue());
                }
                if (this.index != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.index.intValue());
                }
                if (this.contentId != null) {
                    codedOutputByteBufferNano.writeString(3, this.contentId);
                }
                if (this.loadTime != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.loadTime);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.uiElement != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.uiElement.intValue());
                }
                if (this.index != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.index.intValue());
                }
                if (this.contentId != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.contentId);
                }
                if (this.loadTime != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.loadTime);
                }
                return computeSerializedSize;
            }

            public final Lullaby mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.uiElement = Integer.valueOf(checkUiElementOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 16:
                            this.index = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 26:
                            this.contentId = codedInputByteBufferNano.readString();
                            continue;
                        case 34:
                            if (this.loadTime == null) {
                                this.loadTime = new LoadTime();
                            }
                            codedInputByteBufferNano.readMessage(this.loadTime);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos */
        public static final class Photos extends ExtendableMessageNano<Photos> implements Cloneable {
            public MediaStats mediaStats;
            public Integer numPhotos;
            public OpenMedia openMedia;
            public WarmWelcome warmWelcome;

            public Photos() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$MediaStats */
            public static final class MediaStats extends ExtendableMessageNano<MediaStats> implements Cloneable {
                public Integer numAllMedia;
                public Integer numVrMedia;

                public MediaStats() {
                    clear();
                }

                public final MediaStats clear() {
                    this.numVrMedia = null;
                    this.numAllMedia = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final MediaStats clone() {
                    try {
                        return (MediaStats) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.numVrMedia != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.numVrMedia.intValue());
                    }
                    if (this.numAllMedia != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.numAllMedia.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.numVrMedia != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.numVrMedia.intValue());
                    }
                    if (this.numAllMedia != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.numAllMedia.intValue());
                    }
                    return computeSerializedSize;
                }

                public final MediaStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.numVrMedia = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.numAllMedia = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$OpenMedia */
            public static final class OpenMedia extends ExtendableMessageNano<OpenMedia> implements Cloneable {
                @NanoEnumValue(legacy = false, value = ImmersiveType.class)
                public Integer immersiveType;
                public Boolean isSample;
                @NanoEnumValue(legacy = false, value = MediaSource.class)
                public Integer source;
                @NanoEnumValue(legacy = false, value = StereoType.class)
                public Integer stereoType;
                @NanoEnumValue(legacy = false, value = MediaType.class)
                public Integer type;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$OpenMedia$ImmersiveType */
                public interface ImmersiveType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$OpenMedia$MediaSource */
                public interface MediaSource {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$OpenMedia$MediaType */
                public interface MediaType {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$OpenMedia$StereoType */
                public interface StereoType {
                }

                @NanoEnumValue(legacy = false, value = MediaType.class)
                public static int checkMediaTypeOrThrow(int i) {
                    if (i >= 0 && i <= 5) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(41).append(i).append(" is not a valid enum MediaType").toString());
                }

                @NanoEnumValue(legacy = false, value = ImmersiveType.class)
                public static int checkImmersiveTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(45).append(i).append(" is not a valid enum ImmersiveType").toString());
                }

                @NanoEnumValue(legacy = false, value = StereoType.class)
                public static int checkStereoTypeOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum StereoType").toString());
                }

                @NanoEnumValue(legacy = false, value = MediaSource.class)
                public static int checkMediaSourceOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum MediaSource").toString());
                }

                public OpenMedia() {
                    clear();
                }

                public final OpenMedia clear() {
                    this.type = null;
                    this.source = null;
                    this.isSample = null;
                    this.immersiveType = null;
                    this.stereoType = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final OpenMedia clone() {
                    try {
                        return (OpenMedia) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.type != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.type.intValue());
                    }
                    if (this.source != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.source.intValue());
                    }
                    if (this.isSample != null) {
                        codedOutputByteBufferNano.writeBool(3, this.isSample.booleanValue());
                    }
                    if (this.immersiveType != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.immersiveType.intValue());
                    }
                    if (this.stereoType != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.stereoType.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.type != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }
                    if (this.source != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.source.intValue());
                    }
                    if (this.isSample != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.isSample.booleanValue());
                    }
                    if (this.immersiveType != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.immersiveType.intValue());
                    }
                    if (this.stereoType != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, this.stereoType.intValue());
                    }
                    return computeSerializedSize;
                }

                public final OpenMedia mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.type = Integer.valueOf(checkMediaTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int position2 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.source = Integer.valueOf(checkMediaSourceOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e2) {
                                    codedInputByteBufferNano.rewindToPosition(position2);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.isSample = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 32:
                                int position3 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.immersiveType = Integer.valueOf(checkImmersiveTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e3) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 40:
                                int position4 = codedInputByteBufferNano.getPosition();
                                try {
                                    this.stereoType = Integer.valueOf(checkStereoTypeOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e4) {
                                    codedInputByteBufferNano.rewindToPosition(position4);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Photos$WarmWelcome */
            public static final class WarmWelcome extends ExtendableMessageNano<WarmWelcome> implements Cloneable {
                public Float exitProgress;

                public WarmWelcome() {
                    clear();
                }

                public final WarmWelcome clear() {
                    this.exitProgress = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final WarmWelcome clone() {
                    try {
                        return (WarmWelcome) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.exitProgress != null) {
                        codedOutputByteBufferNano.writeFloat(1, this.exitProgress.floatValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.exitProgress != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(1, this.exitProgress.floatValue());
                    }
                    return computeSerializedSize;
                }

                public final WarmWelcome mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 13:
                                this.exitProgress = Float.valueOf(codedInputByteBufferNano.readFloat());
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

            public final Photos clear() {
                this.numPhotos = null;
                this.openMedia = null;
                this.warmWelcome = null;
                this.mediaStats = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Photos clone() {
                try {
                    Photos photos = (Photos) super.clone();
                    if (this.openMedia != null) {
                        photos.openMedia = this.openMedia.clone();
                    }
                    if (this.warmWelcome != null) {
                        photos.warmWelcome = this.warmWelcome.clone();
                    }
                    if (this.mediaStats != null) {
                        photos.mediaStats = this.mediaStats.clone();
                    }
                    return photos;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.numPhotos != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.numPhotos.intValue());
                }
                if (this.openMedia != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.openMedia);
                }
                if (this.warmWelcome != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.warmWelcome);
                }
                if (this.mediaStats != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.mediaStats);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.numPhotos != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.numPhotos.intValue());
                }
                if (this.openMedia != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.openMedia);
                }
                if (this.warmWelcome != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.warmWelcome);
                }
                if (this.mediaStats != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.mediaStats);
                }
                return computeSerializedSize;
            }

            public final Photos mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 18:
                            if (this.openMedia == null) {
                                this.openMedia = new OpenMedia();
                            }
                            codedInputByteBufferNano.readMessage(this.openMedia);
                            continue;
                        case 26:
                            if (this.warmWelcome == null) {
                                this.warmWelcome = new WarmWelcome();
                            }
                            codedInputByteBufferNano.readMessage(this.warmWelcome);
                            continue;
                        case 34:
                            if (this.mediaStats == null) {
                                this.mediaStats = new MediaStats();
                            }
                            codedInputByteBufferNano.readMessage(this.mediaStats);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$SdkConfigurationParams */
        public static final class SdkConfigurationParams extends ExtendableMessageNano<SdkConfigurationParams> implements Cloneable {
            public Boolean allowDynamicJavaLibraryLoading;
            public Boolean allowDynamicLibraryLoading;
            public Boolean allowVrcoreCompositing;
            public Boolean allowVrcoreHeadTracking;
            public AsyncReprojectionConfig asyncReprojectionConfig;
            public Boolean cpuLateLatchingEnabled;
            @NanoEnumValue(legacy = false, value = DaydreamImageAlignment.class)
            public Integer daydreamImageAlignment;
            public Boolean daydreamImageAlignmentEnabled;
            public Boolean dimUiLayer;
            public Boolean disallowMultiview;
            public Boolean enableForcedTrackingCompat;
            public PerformanceOverlayInfo performanceOverlayInfo;
            public ScreenCaptureConfig screenCaptureConfig;
            public Boolean touchOverlayEnabled;
            public Boolean useDeviceIdleDetection;
            public Boolean useDirectModeSensors;
            public Boolean useMagnetometerInSensorFusion;
            public Boolean useOnlineMagnetometerCalibration;
            public Boolean useStationaryBiasCorrection;
            public Boolean useSystemClockForSensorTimestamps;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$SdkConfigurationParams$DaydreamImageAlignment */
            public interface DaydreamImageAlignment {
            }

            @NanoEnumValue(legacy = false, value = DaydreamImageAlignment.class)
            public static int checkDaydreamImageAlignmentOrThrow(int i) {
                if (i >= 0 && i <= 3) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(54).append(i).append(" is not a valid enum DaydreamImageAlignment").toString());
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$SdkConfigurationParams$AsyncReprojectionConfig */
            public static final class AsyncReprojectionConfig extends ExtendableMessageNano<AsyncReprojectionConfig> implements Cloneable {
                public Long additionalAhardwarebufferUsage;
                public Boolean backRgb16WithBgr16;
                public Long blackBoost;
                public Long displayLatencyMicros;
                public Long flags;
                public Long stripsPerFrame;
                public Long vsyncGracePeriodMicros;

                public AsyncReprojectionConfig() {
                    clear();
                }

                public final AsyncReprojectionConfig clear() {
                    this.flags = null;
                    this.displayLatencyMicros = null;
                    this.blackBoost = null;
                    this.vsyncGracePeriodMicros = null;
                    this.stripsPerFrame = null;
                    this.additionalAhardwarebufferUsage = null;
                    this.backRgb16WithBgr16 = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final AsyncReprojectionConfig clone() {
                    try {
                        return (AsyncReprojectionConfig) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.flags != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.flags.longValue());
                    }
                    if (this.displayLatencyMicros != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.displayLatencyMicros.longValue());
                    }
                    if (this.blackBoost != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.blackBoost.longValue());
                    }
                    if (this.vsyncGracePeriodMicros != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.vsyncGracePeriodMicros.longValue());
                    }
                    if (this.stripsPerFrame != null) {
                        codedOutputByteBufferNano.writeInt64(5, this.stripsPerFrame.longValue());
                    }
                    if (this.additionalAhardwarebufferUsage != null) {
                        codedOutputByteBufferNano.writeInt64(6, this.additionalAhardwarebufferUsage.longValue());
                    }
                    if (this.backRgb16WithBgr16 != null) {
                        codedOutputByteBufferNano.writeBool(7, this.backRgb16WithBgr16.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.flags != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.flags.longValue());
                    }
                    if (this.displayLatencyMicros != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.displayLatencyMicros.longValue());
                    }
                    if (this.blackBoost != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.blackBoost.longValue());
                    }
                    if (this.vsyncGracePeriodMicros != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, this.vsyncGracePeriodMicros.longValue());
                    }
                    if (this.stripsPerFrame != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, this.stripsPerFrame.longValue());
                    }
                    if (this.additionalAhardwarebufferUsage != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, this.additionalAhardwarebufferUsage.longValue());
                    }
                    if (this.backRgb16WithBgr16 != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, this.backRgb16WithBgr16.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final AsyncReprojectionConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.flags = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 16:
                                this.displayLatencyMicros = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.blackBoost = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.vsyncGracePeriodMicros = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 40:
                                this.stripsPerFrame = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 48:
                                this.additionalAhardwarebufferUsage = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 56:
                                this.backRgb16WithBgr16 = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$SdkConfigurationParams$PerformanceOverlayInfo */
            public static final class PerformanceOverlayInfo extends ExtendableMessageNano<PerformanceOverlayInfo> implements Cloneable {
                public String version;

                public PerformanceOverlayInfo() {
                    clear();
                }

                public final PerformanceOverlayInfo clear() {
                    this.version = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final PerformanceOverlayInfo clone() {
                    try {
                        return (PerformanceOverlayInfo) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.version != null) {
                        codedOutputByteBufferNano.writeString(1, this.version);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.version != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.version);
                    }
                    return computeSerializedSize;
                }

                public final PerformanceOverlayInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.version = codedInputByteBufferNano.readString();
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$SdkConfigurationParams$ScreenCaptureConfig */
            public static final class ScreenCaptureConfig extends ExtendableMessageNano<ScreenCaptureConfig> implements Cloneable {
                public Boolean allowCasting;
                public Boolean allowScreenRecord;
                public Boolean allowScreenshot;

                public ScreenCaptureConfig() {
                    clear();
                }

                public final ScreenCaptureConfig clear() {
                    this.allowCasting = null;
                    this.allowScreenRecord = null;
                    this.allowScreenshot = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ScreenCaptureConfig clone() {
                    try {
                        return (ScreenCaptureConfig) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.allowCasting != null) {
                        codedOutputByteBufferNano.writeBool(1, this.allowCasting.booleanValue());
                    }
                    if (this.allowScreenRecord != null) {
                        codedOutputByteBufferNano.writeBool(2, this.allowScreenRecord.booleanValue());
                    }
                    if (this.allowScreenshot != null) {
                        codedOutputByteBufferNano.writeBool(3, this.allowScreenshot.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.allowCasting != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.allowCasting.booleanValue());
                    }
                    if (this.allowScreenRecord != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.allowScreenRecord.booleanValue());
                    }
                    if (this.allowScreenshot != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, this.allowScreenshot.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final ScreenCaptureConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.allowCasting = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case 16:
                                this.allowScreenRecord = Boolean.valueOf(codedInputByteBufferNano.readBool());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.allowScreenshot = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            public SdkConfigurationParams() {
                clear();
            }

            public final SdkConfigurationParams clear() {
                this.daydreamImageAlignmentEnabled = null;
                this.useSystemClockForSensorTimestamps = null;
                this.useMagnetometerInSensorFusion = null;
                this.allowDynamicLibraryLoading = null;
                this.cpuLateLatchingEnabled = null;
                this.daydreamImageAlignment = null;
                this.asyncReprojectionConfig = null;
                this.useOnlineMagnetometerCalibration = null;
                this.useDeviceIdleDetection = null;
                this.useStationaryBiasCorrection = null;
                this.allowDynamicJavaLibraryLoading = null;
                this.touchOverlayEnabled = null;
                this.allowVrcoreHeadTracking = null;
                this.allowVrcoreCompositing = null;
                this.performanceOverlayInfo = null;
                this.enableForcedTrackingCompat = null;
                this.screenCaptureConfig = null;
                this.disallowMultiview = null;
                this.dimUiLayer = null;
                this.useDirectModeSensors = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final SdkConfigurationParams clone() {
                try {
                    SdkConfigurationParams sdkConfigurationParams = (SdkConfigurationParams) super.clone();
                    if (this.asyncReprojectionConfig != null) {
                        sdkConfigurationParams.asyncReprojectionConfig = this.asyncReprojectionConfig.clone();
                    }
                    if (this.performanceOverlayInfo != null) {
                        sdkConfigurationParams.performanceOverlayInfo = this.performanceOverlayInfo.clone();
                    }
                    if (this.screenCaptureConfig != null) {
                        sdkConfigurationParams.screenCaptureConfig = this.screenCaptureConfig.clone();
                    }
                    return sdkConfigurationParams;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.daydreamImageAlignmentEnabled != null) {
                    codedOutputByteBufferNano.writeBool(1, this.daydreamImageAlignmentEnabled.booleanValue());
                }
                if (this.useSystemClockForSensorTimestamps != null) {
                    codedOutputByteBufferNano.writeBool(2, this.useSystemClockForSensorTimestamps.booleanValue());
                }
                if (this.useMagnetometerInSensorFusion != null) {
                    codedOutputByteBufferNano.writeBool(3, this.useMagnetometerInSensorFusion.booleanValue());
                }
                if (this.allowDynamicLibraryLoading != null) {
                    codedOutputByteBufferNano.writeBool(4, this.allowDynamicLibraryLoading.booleanValue());
                }
                if (this.cpuLateLatchingEnabled != null) {
                    codedOutputByteBufferNano.writeBool(5, this.cpuLateLatchingEnabled.booleanValue());
                }
                if (this.daydreamImageAlignment != null) {
                    codedOutputByteBufferNano.writeInt32(6, this.daydreamImageAlignment.intValue());
                }
                if (this.asyncReprojectionConfig != null) {
                    codedOutputByteBufferNano.writeMessage(7, this.asyncReprojectionConfig);
                }
                if (this.useOnlineMagnetometerCalibration != null) {
                    codedOutputByteBufferNano.writeBool(8, this.useOnlineMagnetometerCalibration.booleanValue());
                }
                if (this.useDeviceIdleDetection != null) {
                    codedOutputByteBufferNano.writeBool(9, this.useDeviceIdleDetection.booleanValue());
                }
                if (this.useStationaryBiasCorrection != null) {
                    codedOutputByteBufferNano.writeBool(10, this.useStationaryBiasCorrection.booleanValue());
                }
                if (this.allowDynamicJavaLibraryLoading != null) {
                    codedOutputByteBufferNano.writeBool(11, this.allowDynamicJavaLibraryLoading.booleanValue());
                }
                if (this.touchOverlayEnabled != null) {
                    codedOutputByteBufferNano.writeBool(12, this.touchOverlayEnabled.booleanValue());
                }
                if (this.allowVrcoreHeadTracking != null) {
                    codedOutputByteBufferNano.writeBool(13, this.allowVrcoreHeadTracking.booleanValue());
                }
                if (this.allowVrcoreCompositing != null) {
                    codedOutputByteBufferNano.writeBool(14, this.allowVrcoreCompositing.booleanValue());
                }
                if (this.performanceOverlayInfo != null) {
                    codedOutputByteBufferNano.writeMessage(15, this.performanceOverlayInfo);
                }
                if (this.enableForcedTrackingCompat != null) {
                    codedOutputByteBufferNano.writeBool(16, this.enableForcedTrackingCompat.booleanValue());
                }
                if (this.screenCaptureConfig != null) {
                    codedOutputByteBufferNano.writeMessage(17, this.screenCaptureConfig);
                }
                if (this.disallowMultiview != null) {
                    codedOutputByteBufferNano.writeBool(18, this.disallowMultiview.booleanValue());
                }
                if (this.dimUiLayer != null) {
                    codedOutputByteBufferNano.writeBool(19, this.dimUiLayer.booleanValue());
                }
                if (this.useDirectModeSensors != null) {
                    codedOutputByteBufferNano.writeBool(20, this.useDirectModeSensors.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.daydreamImageAlignmentEnabled != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.daydreamImageAlignmentEnabled.booleanValue());
                }
                if (this.useSystemClockForSensorTimestamps != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.useSystemClockForSensorTimestamps.booleanValue());
                }
                if (this.useMagnetometerInSensorFusion != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.useMagnetometerInSensorFusion.booleanValue());
                }
                if (this.allowDynamicLibraryLoading != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, this.allowDynamicLibraryLoading.booleanValue());
                }
                if (this.cpuLateLatchingEnabled != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, this.cpuLateLatchingEnabled.booleanValue());
                }
                if (this.daydreamImageAlignment != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.daydreamImageAlignment.intValue());
                }
                if (this.asyncReprojectionConfig != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, this.asyncReprojectionConfig);
                }
                if (this.useOnlineMagnetometerCalibration != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, this.useOnlineMagnetometerCalibration.booleanValue());
                }
                if (this.useDeviceIdleDetection != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, this.useDeviceIdleDetection.booleanValue());
                }
                if (this.useStationaryBiasCorrection != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.useStationaryBiasCorrection.booleanValue());
                }
                if (this.allowDynamicJavaLibraryLoading != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, this.allowDynamicJavaLibraryLoading.booleanValue());
                }
                if (this.touchOverlayEnabled != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, this.touchOverlayEnabled.booleanValue());
                }
                if (this.allowVrcoreHeadTracking != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, this.allowVrcoreHeadTracking.booleanValue());
                }
                if (this.allowVrcoreCompositing != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, this.allowVrcoreCompositing.booleanValue());
                }
                if (this.performanceOverlayInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, this.performanceOverlayInfo);
                }
                if (this.enableForcedTrackingCompat != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, this.enableForcedTrackingCompat.booleanValue());
                }
                if (this.screenCaptureConfig != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, this.screenCaptureConfig);
                }
                if (this.disallowMultiview != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, this.disallowMultiview.booleanValue());
                }
                if (this.dimUiLayer != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(19, this.dimUiLayer.booleanValue());
                }
                if (this.useDirectModeSensors != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(20, this.useDirectModeSensors.booleanValue());
                }
                return computeSerializedSize;
            }

            public final SdkConfigurationParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.daydreamImageAlignmentEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 16:
                            this.useSystemClockForSensorTimestamps = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case AndroidNCompat.N_SDK_LEVEL:
                            this.useMagnetometerInSensorFusion = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 32:
                            this.allowDynamicLibraryLoading = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 40:
                            this.cpuLateLatchingEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 48:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.daydreamImageAlignment = Integer.valueOf(checkDaydreamImageAlignmentOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 58:
                            if (this.asyncReprojectionConfig == null) {
                                this.asyncReprojectionConfig = new AsyncReprojectionConfig();
                            }
                            codedInputByteBufferNano.readMessage(this.asyncReprojectionConfig);
                            continue;
                        case 64:
                            this.useOnlineMagnetometerCalibration = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 72:
                            this.useDeviceIdleDetection = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 80:
                            this.useStationaryBiasCorrection = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 88:
                            this.allowDynamicJavaLibraryLoading = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 96:
                            this.touchOverlayEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 104:
                            this.allowVrcoreHeadTracking = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 112:
                            this.allowVrcoreCompositing = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 122:
                            if (this.performanceOverlayInfo == null) {
                                this.performanceOverlayInfo = new PerformanceOverlayInfo();
                            }
                            codedInputByteBufferNano.readMessage(this.performanceOverlayInfo);
                            continue;
                        case 128:
                            this.enableForcedTrackingCompat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 138:
                            if (this.screenCaptureConfig == null) {
                                this.screenCaptureConfig = new ScreenCaptureConfig();
                            }
                            codedInputByteBufferNano.readMessage(this.screenCaptureConfig);
                            continue;
                        case 144:
                            this.disallowMultiview = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 152:
                            this.dimUiLayer = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            continue;
                        case 160:
                            this.useDirectModeSensors = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$SensorStats */
        public static final class SensorStats extends ExtendableMessageNano<SensorStats> implements Cloneable {
            public GyroscopeStats gyroscopeStats;

            public SensorStats() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$SensorStats$GyroscopeStats */
            public static final class GyroscopeStats extends ExtendableMessageNano<GyroscopeStats> implements Cloneable {
                public Vector3 bias;
                public Vector3 lowerBound;
                public Vector3 standardDeviation;
                public Vector3 upperBound;

                public GyroscopeStats() {
                    clear();
                }

                public final GyroscopeStats clear() {
                    this.bias = null;
                    this.lowerBound = null;
                    this.upperBound = null;
                    this.standardDeviation = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final GyroscopeStats clone() {
                    try {
                        GyroscopeStats gyroscopeStats = (GyroscopeStats) super.clone();
                        if (this.bias != null) {
                            gyroscopeStats.bias = this.bias.clone();
                        }
                        if (this.lowerBound != null) {
                            gyroscopeStats.lowerBound = this.lowerBound.clone();
                        }
                        if (this.upperBound != null) {
                            gyroscopeStats.upperBound = this.upperBound.clone();
                        }
                        if (this.standardDeviation != null) {
                            gyroscopeStats.standardDeviation = this.standardDeviation.clone();
                        }
                        return gyroscopeStats;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.bias != null) {
                        codedOutputByteBufferNano.writeMessage(1, this.bias);
                    }
                    if (this.lowerBound != null) {
                        codedOutputByteBufferNano.writeMessage(2, this.lowerBound);
                    }
                    if (this.upperBound != null) {
                        codedOutputByteBufferNano.writeMessage(3, this.upperBound);
                    }
                    if (this.standardDeviation != null) {
                        codedOutputByteBufferNano.writeMessage(4, this.standardDeviation);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.bias != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.bias);
                    }
                    if (this.lowerBound != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.lowerBound);
                    }
                    if (this.upperBound != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.upperBound);
                    }
                    if (this.standardDeviation != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.standardDeviation);
                    }
                    return computeSerializedSize;
                }

                public final GyroscopeStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                if (this.bias == null) {
                                    this.bias = new Vector3();
                                }
                                codedInputByteBufferNano.readMessage(this.bias);
                                continue;
                            case 18:
                                if (this.lowerBound == null) {
                                    this.lowerBound = new Vector3();
                                }
                                codedInputByteBufferNano.readMessage(this.lowerBound);
                                continue;
                            case 26:
                                if (this.upperBound == null) {
                                    this.upperBound = new Vector3();
                                }
                                codedInputByteBufferNano.readMessage(this.upperBound);
                                continue;
                            case 34:
                                if (this.standardDeviation == null) {
                                    this.standardDeviation = new Vector3();
                                }
                                codedInputByteBufferNano.readMessage(this.standardDeviation);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$SensorStats$Vector3 */
            public static final class Vector3 extends ExtendableMessageNano<Vector3> implements Cloneable {

                /* renamed from: x */
                public Float f3x;

                /* renamed from: y */
                public Float f4y;

                /* renamed from: z */
                public Float f5z;

                public Vector3() {
                    clear();
                }

                public final Vector3 clear() {
                    this.f3x = null;
                    this.f4y = null;
                    this.f5z = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vector3 clone() {
                    try {
                        return (Vector3) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.f3x != null) {
                        codedOutputByteBufferNano.writeFloat(1, this.f3x.floatValue());
                    }
                    if (this.f4y != null) {
                        codedOutputByteBufferNano.writeFloat(2, this.f4y.floatValue());
                    }
                    if (this.f5z != null) {
                        codedOutputByteBufferNano.writeFloat(3, this.f5z.floatValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.f3x != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.f3x.floatValue());
                    }
                    if (this.f4y != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.f4y.floatValue());
                    }
                    if (this.f5z != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, this.f5z.floatValue());
                    }
                    return computeSerializedSize;
                }

                public final Vector3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 13:
                                this.f3x = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case 21:
                                this.f4y = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case 29:
                                this.f5z = Float.valueOf(codedInputByteBufferNano.readFloat());
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

            public final SensorStats clear() {
                this.gyroscopeStats = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final SensorStats clone() {
                try {
                    SensorStats sensorStats = (SensorStats) super.clone();
                    if (this.gyroscopeStats != null) {
                        sensorStats.gyroscopeStats = this.gyroscopeStats.clone();
                    }
                    return sensorStats;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.gyroscopeStats != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.gyroscopeStats);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.gyroscopeStats != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, this.gyroscopeStats);
                }
                return computeSerializedSize;
            }

            public final SensorStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.gyroscopeStats == null) {
                                this.gyroscopeStats = new GyroscopeStats();
                            }
                            codedInputByteBufferNano.readMessage(this.gyroscopeStats);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset */
        public static final class StandaloneHeadset extends ExtendableMessageNano<StandaloneHeadset> implements Cloneable {
            public IdleMetrics idleMetrics;
            public MemoryStats memoryStats;
            public HeadSetOnOffStats onOffStats;
            public PowerState powerState;

            public StandaloneHeadset() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$HeadSetOnOffStats */
            public static final class HeadSetOnOffStats extends ExtendableMessageNano<HeadSetOnOffStats> implements Cloneable {
                public Long onOffCount;

                public HeadSetOnOffStats() {
                    clear();
                }

                public final HeadSetOnOffStats clear() {
                    this.onOffCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final HeadSetOnOffStats clone() {
                    try {
                        return (HeadSetOnOffStats) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.onOffCount != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.onOffCount.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.onOffCount != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, this.onOffCount.longValue());
                    }
                    return computeSerializedSize;
                }

                public final HeadSetOnOffStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.onOffCount = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$IdleMetrics */
            public static final class IdleMetrics extends ExtendableMessageNano<IdleMetrics> implements Cloneable {
                @NanoEnumValue(legacy = false, value = IdleReason.class)
                public int[] idleReason;
                @NanoEnumValue(legacy = false, value = ScreenState.class)
                public Integer screenState;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$IdleMetrics$IdleReason */
                public interface IdleReason {
                }

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$IdleMetrics$ScreenState */
                public interface ScreenState {
                }

                @NanoEnumValue(legacy = false, value = ScreenState.class)
                public static int checkScreenStateOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum ScreenState").toString());
                }

                @NanoEnumValue(legacy = false, value = IdleReason.class)
                public static int checkIdleReasonOrThrow(int i) {
                    if (i >= 0 && i <= 3) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(42).append(i).append(" is not a valid enum IdleReason").toString());
                }

                public IdleMetrics() {
                    clear();
                }

                public final IdleMetrics clear() {
                    this.screenState = null;
                    this.idleReason = WireFormatNano.EMPTY_INT_ARRAY;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final IdleMetrics clone() {
                    try {
                        IdleMetrics idleMetrics = (IdleMetrics) super.clone();
                        if (this.idleReason != null && this.idleReason.length > 0) {
                            idleMetrics.idleReason = (int[]) this.idleReason.clone();
                        }
                        return idleMetrics;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.screenState != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.screenState.intValue());
                    }
                    if (this.idleReason != null && this.idleReason.length > 0) {
                        for (int writeInt32 : this.idleReason) {
                            codedOutputByteBufferNano.writeInt32(2, writeInt32);
                        }
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.screenState != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.screenState.intValue());
                    }
                    if (this.idleReason == null || this.idleReason.length <= 0) {
                        return computeSerializedSize;
                    }
                    int i = 0;
                    for (int computeInt32SizeNoTag : this.idleReason) {
                        i += CodedOutputByteBufferNano.computeInt32SizeNoTag(computeInt32SizeNoTag);
                    }
                    return computeSerializedSize + i + (this.idleReason.length * 1);
                }

                public final IdleMetrics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.screenState = Integer.valueOf(checkScreenStateOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                                int[] iArr = new int[repeatedFieldArrayLength];
                                int i = 0;
                                for (int i2 = 0; i2 < repeatedFieldArrayLength; i2++) {
                                    if (i2 != 0) {
                                        codedInputByteBufferNano.readTag();
                                    }
                                    int position2 = codedInputByteBufferNano.getPosition();
                                    try {
                                        iArr[i] = checkIdleReasonOrThrow(codedInputByteBufferNano.readInt32());
                                        i++;
                                    } catch (IllegalArgumentException e2) {
                                        codedInputByteBufferNano.rewindToPosition(position2);
                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                    }
                                }
                                if (i != 0) {
                                    int length = this.idleReason == null ? 0 : this.idleReason.length;
                                    if (length != 0 || i != repeatedFieldArrayLength) {
                                        int[] iArr2 = new int[(length + i)];
                                        if (length != 0) {
                                            System.arraycopy(this.idleReason, 0, iArr2, 0, length);
                                        }
                                        System.arraycopy(iArr, 0, iArr2, length, i);
                                        this.idleReason = iArr2;
                                        break;
                                    } else {
                                        this.idleReason = iArr;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            case 18:
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position3 = codedInputByteBufferNano.getPosition();
                                int i3 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    try {
                                        checkIdleReasonOrThrow(codedInputByteBufferNano.readInt32());
                                        i3++;
                                    } catch (IllegalArgumentException e3) {
                                    }
                                }
                                if (i3 != 0) {
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    int length2 = this.idleReason == null ? 0 : this.idleReason.length;
                                    int[] iArr3 = new int[(i3 + length2)];
                                    if (length2 != 0) {
                                        System.arraycopy(this.idleReason, 0, iArr3, 0, length2);
                                    }
                                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                        int position4 = codedInputByteBufferNano.getPosition();
                                        try {
                                            iArr3[length2] = checkIdleReasonOrThrow(codedInputByteBufferNano.readInt32());
                                            length2++;
                                        } catch (IllegalArgumentException e4) {
                                            codedInputByteBufferNano.rewindToPosition(position4);
                                            storeUnknownField(codedInputByteBufferNano, 16);
                                        }
                                    }
                                    this.idleReason = iArr3;
                                }
                                codedInputByteBufferNano.popLimit(pushLimit);
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$MemoryStats */
            public static final class MemoryStats extends ExtendableMessageNano<MemoryStats> implements Cloneable {
                public Long availableMemoryKb;
                public Long freeMemoryKb;
                public Long timeSinceBootNs;
                public Long totalMemoryKb;

                public MemoryStats() {
                    clear();
                }

                public final MemoryStats clear() {
                    this.totalMemoryKb = null;
                    this.freeMemoryKb = null;
                    this.availableMemoryKb = null;
                    this.timeSinceBootNs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final MemoryStats clone() {
                    try {
                        return (MemoryStats) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.totalMemoryKb != null) {
                        codedOutputByteBufferNano.writeInt64(1, this.totalMemoryKb.longValue());
                    }
                    if (this.freeMemoryKb != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.freeMemoryKb.longValue());
                    }
                    if (this.availableMemoryKb != null) {
                        codedOutputByteBufferNano.writeInt64(3, this.availableMemoryKb.longValue());
                    }
                    if (this.timeSinceBootNs != null) {
                        codedOutputByteBufferNano.writeInt64(4, this.timeSinceBootNs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.totalMemoryKb != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.totalMemoryKb.longValue());
                    }
                    if (this.freeMemoryKb != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.freeMemoryKb.longValue());
                    }
                    if (this.availableMemoryKb != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.availableMemoryKb.longValue());
                    }
                    if (this.timeSinceBootNs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, this.timeSinceBootNs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final MemoryStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.totalMemoryKb = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 16:
                                this.freeMemoryKb = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.availableMemoryKb = Long.valueOf(codedInputByteBufferNano.readInt64());
                                continue;
                            case 32:
                                this.timeSinceBootNs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$PowerState */
            public static final class PowerState extends ExtendableMessageNano<PowerState> implements Cloneable {
                public Long powerStateDurationNs;
                @NanoEnumValue(legacy = false, value = PowerStates.class)
                public Integer powerStates;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$StandaloneHeadset$PowerState$PowerStates */
                public interface PowerStates {
                }

                @NanoEnumValue(legacy = false, value = PowerStates.class)
                public static int checkPowerStatesOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum PowerStates").toString());
                }

                public PowerState() {
                    clear();
                }

                public final PowerState clear() {
                    this.powerStates = null;
                    this.powerStateDurationNs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final PowerState clone() {
                    try {
                        return (PowerState) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.powerStates != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.powerStates.intValue());
                    }
                    if (this.powerStateDurationNs != null) {
                        codedOutputByteBufferNano.writeInt64(2, this.powerStateDurationNs.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.powerStates != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.powerStates.intValue());
                    }
                    if (this.powerStateDurationNs != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, this.powerStateDurationNs.longValue());
                    }
                    return computeSerializedSize;
                }

                public final PowerState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.powerStates = Integer.valueOf(checkPowerStatesOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.powerStateDurationNs = Long.valueOf(codedInputByteBufferNano.readInt64());
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

            public final StandaloneHeadset clear() {
                this.powerState = null;
                this.memoryStats = null;
                this.onOffStats = null;
                this.idleMetrics = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final StandaloneHeadset clone() {
                try {
                    StandaloneHeadset standaloneHeadset = (StandaloneHeadset) super.clone();
                    if (this.powerState != null) {
                        standaloneHeadset.powerState = this.powerState.clone();
                    }
                    if (this.memoryStats != null) {
                        standaloneHeadset.memoryStats = this.memoryStats.clone();
                    }
                    if (this.onOffStats != null) {
                        standaloneHeadset.onOffStats = this.onOffStats.clone();
                    }
                    if (this.idleMetrics != null) {
                        standaloneHeadset.idleMetrics = this.idleMetrics.clone();
                    }
                    return standaloneHeadset;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.powerState != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.powerState);
                }
                if (this.memoryStats != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.memoryStats);
                }
                if (this.onOffStats != null) {
                    codedOutputByteBufferNano.writeMessage(3, this.onOffStats);
                }
                if (this.idleMetrics != null) {
                    codedOutputByteBufferNano.writeMessage(4, this.idleMetrics);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.powerState != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.powerState);
                }
                if (this.memoryStats != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.memoryStats);
                }
                if (this.onOffStats != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.onOffStats);
                }
                if (this.idleMetrics != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.idleMetrics);
                }
                return computeSerializedSize;
            }

            public final StandaloneHeadset mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.powerState == null) {
                                this.powerState = new PowerState();
                            }
                            codedInputByteBufferNano.readMessage(this.powerState);
                            continue;
                        case 18:
                            if (this.memoryStats == null) {
                                this.memoryStats = new MemoryStats();
                            }
                            codedInputByteBufferNano.readMessage(this.memoryStats);
                            continue;
                        case 26:
                            if (this.onOffStats == null) {
                                this.onOffStats = new HeadSetOnOffStats();
                            }
                            codedInputByteBufferNano.readMessage(this.onOffStats);
                            continue;
                        case 34:
                            if (this.idleMetrics == null) {
                                this.idleMetrics = new IdleMetrics();
                            }
                            codedInputByteBufferNano.readMessage(this.idleMetrics);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$StreetView */
        public static final class StreetView extends ExtendableMessageNano<StreetView> implements Cloneable {
            public PanoSession panoSession;
            public TutorialSession tutorialSession;

            public StreetView() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$StreetView$PanoSession */
            public static final class PanoSession extends ExtendableMessageNano<PanoSession> implements Cloneable {
                public Integer infoClicks;
                public Integer nextClicks;
                public Integer nodesNavigated;
                public Integer panosAvailable;
                public Integer panosViewed;
                public Integer playPauseClicks;
                public Integer prevClicks;
                @NanoEnumValue(legacy = false, value = Source.class)
                public Integer source;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$StreetView$PanoSession$Source */
                public interface Source {
                }

                @NanoEnumValue(legacy = false, value = Source.class)
                public static int checkSourceOrThrow(int i) {
                    if (i >= 0 && i <= 4) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(38).append(i).append(" is not a valid enum Source").toString());
                }

                public PanoSession() {
                    clear();
                }

                public final PanoSession clear() {
                    this.source = null;
                    this.panosAvailable = null;
                    this.panosViewed = null;
                    this.nodesNavigated = null;
                    this.nextClicks = null;
                    this.prevClicks = null;
                    this.playPauseClicks = null;
                    this.infoClicks = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final PanoSession clone() {
                    try {
                        return (PanoSession) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.source != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.source.intValue());
                    }
                    if (this.panosAvailable != null) {
                        codedOutputByteBufferNano.writeInt32(2, this.panosAvailable.intValue());
                    }
                    if (this.panosViewed != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.panosViewed.intValue());
                    }
                    if (this.nodesNavigated != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.nodesNavigated.intValue());
                    }
                    if (this.nextClicks != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.nextClicks.intValue());
                    }
                    if (this.prevClicks != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.prevClicks.intValue());
                    }
                    if (this.playPauseClicks != null) {
                        codedOutputByteBufferNano.writeInt32(7, this.playPauseClicks.intValue());
                    }
                    if (this.infoClicks != null) {
                        codedOutputByteBufferNano.writeInt32(8, this.infoClicks.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.source != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.source.intValue());
                    }
                    if (this.panosAvailable != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.panosAvailable.intValue());
                    }
                    if (this.panosViewed != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.panosViewed.intValue());
                    }
                    if (this.nodesNavigated != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.nodesNavigated.intValue());
                    }
                    if (this.nextClicks != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.nextClicks.intValue());
                    }
                    if (this.prevClicks != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.prevClicks.intValue());
                    }
                    if (this.playPauseClicks != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, this.playPauseClicks.intValue());
                    }
                    if (this.infoClicks != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, this.infoClicks.intValue());
                    }
                    return computeSerializedSize;
                }

                public final PanoSession mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.source = Integer.valueOf(checkSourceOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.panosAvailable = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.panosViewed = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 32:
                                this.nodesNavigated = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 40:
                                this.nextClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 48:
                                this.prevClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 56:
                                this.playPauseClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 64:
                                this.infoClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$StreetView$TutorialSession */
            public static final class TutorialSession extends ExtendableMessageNano<TutorialSession> implements Cloneable {
                public Boolean completed;
                @NanoEnumValue(legacy = false, value = Tutorial.class)
                public Integer tutorial;

                /* renamed from: com.google.common.logging.nano.Vr$VREvent$StreetView$TutorialSession$Tutorial */
                public interface Tutorial {
                }

                @NanoEnumValue(legacy = false, value = Tutorial.class)
                public static int checkTutorialOrThrow(int i) {
                    if (i >= 0 && i <= 2) {
                        return i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(40).append(i).append(" is not a valid enum Tutorial").toString());
                }

                public TutorialSession() {
                    clear();
                }

                public final TutorialSession clear() {
                    this.tutorial = null;
                    this.completed = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final TutorialSession clone() {
                    try {
                        return (TutorialSession) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.tutorial != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.tutorial.intValue());
                    }
                    if (this.completed != null) {
                        codedOutputByteBufferNano.writeBool(2, this.completed.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.tutorial != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.tutorial.intValue());
                    }
                    if (this.completed != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.completed.booleanValue());
                    }
                    return computeSerializedSize;
                }

                public final TutorialSession mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                int position = codedInputByteBufferNano.getPosition();
                                try {
                                    this.tutorial = Integer.valueOf(checkTutorialOrThrow(codedInputByteBufferNano.readInt32()));
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    break;
                                }
                            case 16:
                                this.completed = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

            public final StreetView clear() {
                this.panoSession = null;
                this.tutorialSession = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final StreetView clone() {
                try {
                    StreetView streetView = (StreetView) super.clone();
                    if (this.panoSession != null) {
                        streetView.panoSession = this.panoSession.clone();
                    }
                    if (this.tutorialSession != null) {
                        streetView.tutorialSession = this.tutorialSession.clone();
                    }
                    return streetView;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.panoSession != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.panoSession);
                }
                if (this.tutorialSession != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.tutorialSession);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.panoSession != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.panoSession);
                }
                if (this.tutorialSession != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, this.tutorialSession);
                }
                return computeSerializedSize;
            }

            public final StreetView mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.panoSession == null) {
                                this.panoSession = new PanoSession();
                            }
                            codedInputByteBufferNano.readMessage(this.panoSession);
                            continue;
                        case 18:
                            if (this.tutorialSession == null) {
                                this.tutorialSession = new TutorialSession();
                            }
                            codedInputByteBufferNano.readMessage(this.tutorialSession);
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrStreaming */
        public static final class VrStreaming extends ExtendableMessageNano<VrStreaming> implements Cloneable {
            public Frame[] frame;
            public SessionInfo sessionInfo;

            public VrStreaming() {
                clear();
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrStreaming$SessionInfo */
            public static final class SessionInfo extends ExtendableMessageNano<SessionInfo> implements Cloneable {
                public String sessionId;

                public SessionInfo() {
                    clear();
                }

                public final SessionInfo clear() {
                    this.sessionId = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final SessionInfo clone() {
                    try {
                        return (SessionInfo) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.sessionId != null) {
                        codedOutputByteBufferNano.writeString(1, this.sessionId);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.sessionId != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.sessionId);
                    }
                    return computeSerializedSize;
                }

                public final SessionInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.sessionId = codedInputByteBufferNano.readString();
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

            public final VrStreaming clear() {
                this.sessionInfo = null;
                this.frame = Frame.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$VrStreaming$Frame */
            public static final class Frame extends ExtendableMessageNano<Frame> implements Cloneable {
                private static volatile Frame[] _emptyArray;
                public Long decodeEndTimeUsec;
                public Long decodeStartTimeUsec;
                public Long framePresentTimeUsec;
                public Integer poseId;
                public Long poseSendTimeUsec;

                public static Frame[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Frame[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public Frame() {
                    clear();
                }

                public final Frame clear() {
                    this.poseId = null;
                    this.poseSendTimeUsec = null;
                    this.framePresentTimeUsec = null;
                    this.decodeStartTimeUsec = null;
                    this.decodeEndTimeUsec = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Frame clone() {
                    try {
                        return (Frame) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.poseId != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.poseId.intValue());
                    }
                    if (this.poseSendTimeUsec != null) {
                        codedOutputByteBufferNano.writeUInt64(2, this.poseSendTimeUsec.longValue());
                    }
                    if (this.framePresentTimeUsec != null) {
                        codedOutputByteBufferNano.writeUInt64(3, this.framePresentTimeUsec.longValue());
                    }
                    if (this.decodeStartTimeUsec != null) {
                        codedOutputByteBufferNano.writeUInt64(4, this.decodeStartTimeUsec.longValue());
                    }
                    if (this.decodeEndTimeUsec != null) {
                        codedOutputByteBufferNano.writeUInt64(5, this.decodeEndTimeUsec.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.poseId != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.poseId.intValue());
                    }
                    if (this.poseSendTimeUsec != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, this.poseSendTimeUsec.longValue());
                    }
                    if (this.framePresentTimeUsec != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, this.framePresentTimeUsec.longValue());
                    }
                    if (this.decodeStartTimeUsec != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, this.decodeStartTimeUsec.longValue());
                    }
                    if (this.decodeEndTimeUsec != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, this.decodeEndTimeUsec.longValue());
                    }
                    return computeSerializedSize;
                }

                public final Frame mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.poseId = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 16:
                                this.poseSendTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.framePresentTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                                continue;
                            case 32:
                                this.decodeStartTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                                continue;
                            case 40:
                                this.decodeEndTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
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

            public final VrStreaming clone() {
                try {
                    VrStreaming vrStreaming = (VrStreaming) super.clone();
                    if (this.sessionInfo != null) {
                        vrStreaming.sessionInfo = this.sessionInfo.clone();
                    }
                    if (this.frame != null && this.frame.length > 0) {
                        vrStreaming.frame = new Frame[this.frame.length];
                        for (int i = 0; i < this.frame.length; i++) {
                            if (this.frame[i] != null) {
                                vrStreaming.frame[i] = this.frame[i].clone();
                            }
                        }
                    }
                    return vrStreaming;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.sessionInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, this.sessionInfo);
                }
                if (this.frame != null && this.frame.length > 0) {
                    for (Frame frame2 : this.frame) {
                        if (frame2 != null) {
                            codedOutputByteBufferNano.writeMessage(2, frame2);
                        }
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.sessionInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.sessionInfo);
                }
                if (this.frame == null || this.frame.length <= 0) {
                    return computeSerializedSize;
                }
                int i = computeSerializedSize;
                for (Frame frame2 : this.frame) {
                    if (frame2 != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(2, frame2);
                    }
                }
                return i;
            }

            public final VrStreaming mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            if (this.sessionInfo == null) {
                                this.sessionInfo = new SessionInfo();
                            }
                            codedInputByteBufferNano.readMessage(this.sessionInfo);
                            continue;
                        case 18:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                            int length = this.frame == null ? 0 : this.frame.length;
                            Frame[] frameArr = new Frame[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.frame, 0, frameArr, 0, length);
                            }
                            while (length < frameArr.length - 1) {
                                frameArr[length] = new Frame();
                                codedInputByteBufferNano.readMessage(frameArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            frameArr[length] = new Frame();
                            codedInputByteBufferNano.readMessage(frameArr[length]);
                            this.frame = frameArr;
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$AudioStats */
        public static final class AudioStats extends ExtendableMessageNano<AudioStats> implements Cloneable {
            public HistogramBucket[] cpuMeasurementsPercent;
            public Integer framesPerBuffer;
            public HistogramBucket[] numberOfSimultaneousSoundFields;
            public HistogramBucket[] numberOfSimultaneousSoundObjects;
            @NanoEnumValue(legacy = false, value = RenderingMode.class)
            public Integer renderingMode;
            public HistogramBucket[] renderingTimePerBufferMilliseconds;
            public Integer sampleRate;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$AudioStats$RenderingMode */
            public interface RenderingMode {
            }

            @NanoEnumValue(legacy = false, value = RenderingMode.class)
            public static int checkRenderingModeOrThrow(int i) {
                if (i >= 0 && i <= 3) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(45).append(i).append(" is not a valid enum RenderingMode").toString());
            }

            public AudioStats() {
                clear();
            }

            public final AudioStats clear() {
                this.renderingMode = null;
                this.sampleRate = null;
                this.framesPerBuffer = null;
                this.renderingTimePerBufferMilliseconds = HistogramBucket.emptyArray();
                this.numberOfSimultaneousSoundObjects = HistogramBucket.emptyArray();
                this.numberOfSimultaneousSoundFields = HistogramBucket.emptyArray();
                this.cpuMeasurementsPercent = HistogramBucket.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final AudioStats clone() {
                try {
                    AudioStats audioStats = (AudioStats) super.clone();
                    if (this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                        audioStats.renderingTimePerBufferMilliseconds = new HistogramBucket[this.renderingTimePerBufferMilliseconds.length];
                        for (int i = 0; i < this.renderingTimePerBufferMilliseconds.length; i++) {
                            if (this.renderingTimePerBufferMilliseconds[i] != null) {
                                audioStats.renderingTimePerBufferMilliseconds[i] = this.renderingTimePerBufferMilliseconds[i].clone();
                            }
                        }
                    }
                    if (this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                        audioStats.numberOfSimultaneousSoundObjects = new HistogramBucket[this.numberOfSimultaneousSoundObjects.length];
                        for (int i2 = 0; i2 < this.numberOfSimultaneousSoundObjects.length; i2++) {
                            if (this.numberOfSimultaneousSoundObjects[i2] != null) {
                                audioStats.numberOfSimultaneousSoundObjects[i2] = this.numberOfSimultaneousSoundObjects[i2].clone();
                            }
                        }
                    }
                    if (this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                        audioStats.numberOfSimultaneousSoundFields = new HistogramBucket[this.numberOfSimultaneousSoundFields.length];
                        for (int i3 = 0; i3 < this.numberOfSimultaneousSoundFields.length; i3++) {
                            if (this.numberOfSimultaneousSoundFields[i3] != null) {
                                audioStats.numberOfSimultaneousSoundFields[i3] = this.numberOfSimultaneousSoundFields[i3].clone();
                            }
                        }
                    }
                    if (this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                        audioStats.cpuMeasurementsPercent = new HistogramBucket[this.cpuMeasurementsPercent.length];
                        for (int i4 = 0; i4 < this.cpuMeasurementsPercent.length; i4++) {
                            if (this.cpuMeasurementsPercent[i4] != null) {
                                audioStats.cpuMeasurementsPercent[i4] = this.cpuMeasurementsPercent[i4].clone();
                            }
                        }
                    }
                    return audioStats;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.renderingMode != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.renderingMode.intValue());
                }
                if (this.sampleRate != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.sampleRate.intValue());
                }
                if (this.framesPerBuffer != null) {
                    codedOutputByteBufferNano.writeInt32(3, this.framesPerBuffer.intValue());
                }
                if (this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                    for (HistogramBucket histogramBucket : this.renderingTimePerBufferMilliseconds) {
                        if (histogramBucket != null) {
                            codedOutputByteBufferNano.writeMessage(4, histogramBucket);
                        }
                    }
                }
                if (this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                    for (HistogramBucket histogramBucket2 : this.numberOfSimultaneousSoundObjects) {
                        if (histogramBucket2 != null) {
                            codedOutputByteBufferNano.writeMessage(5, histogramBucket2);
                        }
                    }
                }
                if (this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                    for (HistogramBucket histogramBucket3 : this.numberOfSimultaneousSoundFields) {
                        if (histogramBucket3 != null) {
                            codedOutputByteBufferNano.writeMessage(6, histogramBucket3);
                        }
                    }
                }
                if (this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                    for (HistogramBucket histogramBucket4 : this.cpuMeasurementsPercent) {
                        if (histogramBucket4 != null) {
                            codedOutputByteBufferNano.writeMessage(7, histogramBucket4);
                        }
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.renderingMode != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.renderingMode.intValue());
                }
                if (this.sampleRate != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.sampleRate.intValue());
                }
                if (this.framesPerBuffer != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.framesPerBuffer.intValue());
                }
                if (this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                    int i = computeSerializedSize;
                    for (HistogramBucket histogramBucket : this.renderingTimePerBufferMilliseconds) {
                        if (histogramBucket != null) {
                            i += CodedOutputByteBufferNano.computeMessageSize(4, histogramBucket);
                        }
                    }
                    computeSerializedSize = i;
                }
                if (this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                    int i2 = computeSerializedSize;
                    for (HistogramBucket histogramBucket2 : this.numberOfSimultaneousSoundObjects) {
                        if (histogramBucket2 != null) {
                            i2 += CodedOutputByteBufferNano.computeMessageSize(5, histogramBucket2);
                        }
                    }
                    computeSerializedSize = i2;
                }
                if (this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                    int i3 = computeSerializedSize;
                    for (HistogramBucket histogramBucket3 : this.numberOfSimultaneousSoundFields) {
                        if (histogramBucket3 != null) {
                            i3 += CodedOutputByteBufferNano.computeMessageSize(6, histogramBucket3);
                        }
                    }
                    computeSerializedSize = i3;
                }
                if (this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                    for (HistogramBucket histogramBucket4 : this.cpuMeasurementsPercent) {
                        if (histogramBucket4 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, histogramBucket4);
                        }
                    }
                }
                return computeSerializedSize;
            }

            public final AudioStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.renderingMode = Integer.valueOf(checkRenderingModeOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 16:
                            this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case AndroidNCompat.N_SDK_LEVEL:
                            this.framesPerBuffer = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 34:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                            int length = this.renderingTimePerBufferMilliseconds == null ? 0 : this.renderingTimePerBufferMilliseconds.length;
                            HistogramBucket[] histogramBucketArr = new HistogramBucket[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.renderingTimePerBufferMilliseconds, 0, histogramBucketArr, 0, length);
                            }
                            while (length < histogramBucketArr.length - 1) {
                                histogramBucketArr[length] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            histogramBucketArr[length] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr[length]);
                            this.renderingTimePerBufferMilliseconds = histogramBucketArr;
                            continue;
                        case 42:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                            int length2 = this.numberOfSimultaneousSoundObjects == null ? 0 : this.numberOfSimultaneousSoundObjects.length;
                            HistogramBucket[] histogramBucketArr2 = new HistogramBucket[(repeatedFieldArrayLength2 + length2)];
                            if (length2 != 0) {
                                System.arraycopy(this.numberOfSimultaneousSoundObjects, 0, histogramBucketArr2, 0, length2);
                            }
                            while (length2 < histogramBucketArr2.length - 1) {
                                histogramBucketArr2[length2] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr2[length2]);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            histogramBucketArr2[length2] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr2[length2]);
                            this.numberOfSimultaneousSoundObjects = histogramBucketArr2;
                            continue;
                        case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                            int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                            int length3 = this.numberOfSimultaneousSoundFields == null ? 0 : this.numberOfSimultaneousSoundFields.length;
                            HistogramBucket[] histogramBucketArr3 = new HistogramBucket[(repeatedFieldArrayLength3 + length3)];
                            if (length3 != 0) {
                                System.arraycopy(this.numberOfSimultaneousSoundFields, 0, histogramBucketArr3, 0, length3);
                            }
                            while (length3 < histogramBucketArr3.length - 1) {
                                histogramBucketArr3[length3] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr3[length3]);
                                codedInputByteBufferNano.readTag();
                                length3++;
                            }
                            histogramBucketArr3[length3] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr3[length3]);
                            this.numberOfSimultaneousSoundFields = histogramBucketArr3;
                            continue;
                        case 58:
                            int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                            int length4 = this.cpuMeasurementsPercent == null ? 0 : this.cpuMeasurementsPercent.length;
                            HistogramBucket[] histogramBucketArr4 = new HistogramBucket[(repeatedFieldArrayLength4 + length4)];
                            if (length4 != 0) {
                                System.arraycopy(this.cpuMeasurementsPercent, 0, histogramBucketArr4, 0, length4);
                            }
                            while (length4 < histogramBucketArr4.length - 1) {
                                histogramBucketArr4[length4] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr4[length4]);
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            histogramBucketArr4[length4] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr4[length4]);
                            this.cpuMeasurementsPercent = histogramBucketArr4;
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$DoublePrecisionTransform */
        public static final class DoublePrecisionTransform extends ExtendableMessageNano<DoublePrecisionTransform> implements Cloneable {
            public Double rotationQx;
            public Double rotationQy;
            public Double rotationQz;
            public Double scale;
            public Double translationX;
            public Double translationY;
            public Double translationZ;

            public DoublePrecisionTransform() {
                clear();
            }

            public final DoublePrecisionTransform clear() {
                this.translationX = null;
                this.translationY = null;
                this.translationZ = null;
                this.rotationQx = null;
                this.rotationQy = null;
                this.rotationQz = null;
                this.scale = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final DoublePrecisionTransform clone() {
                try {
                    return (DoublePrecisionTransform) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.translationX != null) {
                    codedOutputByteBufferNano.writeDouble(1, this.translationX.doubleValue());
                }
                if (this.translationY != null) {
                    codedOutputByteBufferNano.writeDouble(2, this.translationY.doubleValue());
                }
                if (this.translationZ != null) {
                    codedOutputByteBufferNano.writeDouble(3, this.translationZ.doubleValue());
                }
                if (this.rotationQx != null) {
                    codedOutputByteBufferNano.writeDouble(4, this.rotationQx.doubleValue());
                }
                if (this.rotationQy != null) {
                    codedOutputByteBufferNano.writeDouble(5, this.rotationQy.doubleValue());
                }
                if (this.rotationQz != null) {
                    codedOutputByteBufferNano.writeDouble(6, this.rotationQz.doubleValue());
                }
                if (this.scale != null) {
                    codedOutputByteBufferNano.writeDouble(7, this.scale.doubleValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.translationX != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.translationX.doubleValue());
                }
                if (this.translationY != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.translationY.doubleValue());
                }
                if (this.translationZ != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.translationZ.doubleValue());
                }
                if (this.rotationQx != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(4, this.rotationQx.doubleValue());
                }
                if (this.rotationQy != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(5, this.rotationQy.doubleValue());
                }
                if (this.rotationQz != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, this.rotationQz.doubleValue());
                }
                if (this.scale != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(7, this.scale.doubleValue());
                }
                return computeSerializedSize;
            }

            public final DoublePrecisionTransform mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 9:
                            this.translationX = Double.valueOf(codedInputByteBufferNano.readDouble());
                            continue;
                        case 17:
                            this.translationY = Double.valueOf(codedInputByteBufferNano.readDouble());
                            continue;
                        case AndroidNCompat.NMR1_SDK_LEVEL:
                            this.translationZ = Double.valueOf(codedInputByteBufferNano.readDouble());
                            continue;
                        case 33:
                            this.rotationQx = Double.valueOf(codedInputByteBufferNano.readDouble());
                            continue;
                        case 41:
                            this.rotationQy = Double.valueOf(codedInputByteBufferNano.readDouble());
                            continue;
                        case 49:
                            this.rotationQz = Double.valueOf(codedInputByteBufferNano.readDouble());
                            continue;
                        case 57:
                            this.scale = Double.valueOf(codedInputByteBufferNano.readDouble());
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Expeditions */
        public static final class Expeditions extends ExtendableMessageNano<Expeditions> implements Cloneable {
            public String contentId;

            public Expeditions() {
                clear();
            }

            public final Expeditions clear() {
                this.contentId = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Expeditions clone() {
                try {
                    return (Expeditions) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.contentId != null) {
                    codedOutputByteBufferNano.writeString(1, this.contentId);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.contentId != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.contentId);
                }
                return computeSerializedSize;
            }

            public final Expeditions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.contentId = codedInputByteBufferNano.readString();
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$GConfigUpdate */
        public static final class GConfigUpdate extends ExtendableMessageNano<GConfigUpdate> implements Cloneable {
            public GConfigValue[] gConfigValue;

            public GConfigUpdate() {
                clear();
            }

            public final GConfigUpdate clear() {
                this.gConfigValue = GConfigValue.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$GConfigUpdate$GConfigValue */
            public static final class GConfigValue extends ExtendableMessageNano<GConfigValue> implements Cloneable {
                private static volatile GConfigValue[] _emptyArray;
                public String gConfigKey;
                public String stringValue;

                public static GConfigValue[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new GConfigValue[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public GConfigValue() {
                    clear();
                }

                public final GConfigValue clear() {
                    this.gConfigKey = null;
                    this.stringValue = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final GConfigValue clone() {
                    try {
                        return (GConfigValue) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.gConfigKey != null) {
                        codedOutputByteBufferNano.writeString(1, this.gConfigKey);
                    }
                    if (this.stringValue != null) {
                        codedOutputByteBufferNano.writeString(2, this.stringValue);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.gConfigKey != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.gConfigKey);
                    }
                    if (this.stringValue != null) {
                        return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.stringValue);
                    }
                    return computeSerializedSize;
                }

                public final GConfigValue mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.gConfigKey = codedInputByteBufferNano.readString();
                                continue;
                            case 18:
                                this.stringValue = codedInputByteBufferNano.readString();
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

            public final GConfigUpdate clone() {
                try {
                    GConfigUpdate gConfigUpdate = (GConfigUpdate) super.clone();
                    if (this.gConfigValue != null && this.gConfigValue.length > 0) {
                        gConfigUpdate.gConfigValue = new GConfigValue[this.gConfigValue.length];
                        for (int i = 0; i < this.gConfigValue.length; i++) {
                            if (this.gConfigValue[i] != null) {
                                gConfigUpdate.gConfigValue[i] = this.gConfigValue[i].clone();
                            }
                        }
                    }
                    return gConfigUpdate;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.gConfigValue != null && this.gConfigValue.length > 0) {
                    for (GConfigValue gConfigValue2 : this.gConfigValue) {
                        if (gConfigValue2 != null) {
                            codedOutputByteBufferNano.writeMessage(1, gConfigValue2);
                        }
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.gConfigValue != null && this.gConfigValue.length > 0) {
                    for (GConfigValue gConfigValue2 : this.gConfigValue) {
                        if (gConfigValue2 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gConfigValue2);
                        }
                    }
                }
                return computeSerializedSize;
            }

            public final GConfigUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                            int length = this.gConfigValue == null ? 0 : this.gConfigValue.length;
                            GConfigValue[] gConfigValueArr = new GConfigValue[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.gConfigValue, 0, gConfigValueArr, 0, length);
                            }
                            while (length < gConfigValueArr.length - 1) {
                                gConfigValueArr[length] = new GConfigValue();
                                codedInputByteBufferNano.readMessage(gConfigValueArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            gConfigValueArr[length] = new GConfigValue();
                            codedInputByteBufferNano.readMessage(gConfigValueArr[length]);
                            this.gConfigValue = gConfigValueArr;
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$LoggingOptInState */
        public static final class LoggingOptInState extends ExtendableMessageNano<LoggingOptInState> implements Cloneable {
            public Integer accountIndex;
            public Integer numOptInAccounts;
            public Boolean wasOptedIntoSwaa;

            public LoggingOptInState() {
                clear();
            }

            public final LoggingOptInState clear() {
                this.numOptInAccounts = null;
                this.accountIndex = null;
                this.wasOptedIntoSwaa = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final LoggingOptInState clone() {
                try {
                    return (LoggingOptInState) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.numOptInAccounts != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.numOptInAccounts.intValue());
                }
                if (this.accountIndex != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.accountIndex.intValue());
                }
                if (this.wasOptedIntoSwaa != null) {
                    codedOutputByteBufferNano.writeBool(3, this.wasOptedIntoSwaa.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.numOptInAccounts != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.numOptInAccounts.intValue());
                }
                if (this.accountIndex != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.accountIndex.intValue());
                }
                if (this.wasOptedIntoSwaa != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, this.wasOptedIntoSwaa.booleanValue());
                }
                return computeSerializedSize;
            }

            public final LoggingOptInState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.numOptInAccounts = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 16:
                            this.accountIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case AndroidNCompat.N_SDK_LEVEL:
                            this.wasOptedIntoSwaa = Boolean.valueOf(codedInputByteBufferNano.readBool());
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$PerformanceStats */
        public static final class PerformanceStats extends ExtendableMessageNano<PerformanceStats> implements Cloneable {
            public HistogramBucket[] appRenderTime;
            public Float averageAppFps;
            public Integer averageFps;
            public float[] batteryShutdownTemperature;
            public float[] batteryThrottlingTemperature;
            public HistogramBucket[] consecutiveDroppedFrames;
            public float[] cpuShutdownTemperature;
            public float[] cpuThrottlingTemperature;
            public Float edsFps;
            public HistogramBucket[] frameTime;
            public float[] gpuShutdownTemperature;
            public float[] gpuThrottlingTemperature;
            public Integer memoryConsumptionKilobytes;
            public HistogramBucket[] postFrameTime;
            public HistogramBucket[] presentTime;
            public HistogramBucket[] scanlineRacingVsyncOvershootUs;
            public Float shutdownSkinTemperatureCelsius;
            public Integer thermalEventFlags;
            public Float throttleSkinTemperatureCelsius;
            public TimeSeriesData timeSeriesData;
            public HistogramBucket[] totalRenderTime;
            public Float vrMaxSkinTemperatureCelsius;

            public PerformanceStats() {
                clear();
            }

            public final PerformanceStats clear() {
                this.averageFps = null;
                this.frameTime = HistogramBucket.emptyArray();
                this.memoryConsumptionKilobytes = null;
                this.throttleSkinTemperatureCelsius = null;
                this.vrMaxSkinTemperatureCelsius = null;
                this.shutdownSkinTemperatureCelsius = null;
                this.timeSeriesData = null;
                this.appRenderTime = HistogramBucket.emptyArray();
                this.presentTime = HistogramBucket.emptyArray();
                this.totalRenderTime = HistogramBucket.emptyArray();
                this.postFrameTime = HistogramBucket.emptyArray();
                this.consecutiveDroppedFrames = HistogramBucket.emptyArray();
                this.scanlineRacingVsyncOvershootUs = HistogramBucket.emptyArray();
                this.thermalEventFlags = null;
                this.cpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.gpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.batteryThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.cpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.gpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.batteryShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.averageAppFps = null;
                this.edsFps = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final PerformanceStats clone() {
                try {
                    PerformanceStats performanceStats = (PerformanceStats) super.clone();
                    if (this.frameTime != null && this.frameTime.length > 0) {
                        performanceStats.frameTime = new HistogramBucket[this.frameTime.length];
                        for (int i = 0; i < this.frameTime.length; i++) {
                            if (this.frameTime[i] != null) {
                                performanceStats.frameTime[i] = this.frameTime[i].clone();
                            }
                        }
                    }
                    if (this.timeSeriesData != null) {
                        performanceStats.timeSeriesData = this.timeSeriesData.clone();
                    }
                    if (this.appRenderTime != null && this.appRenderTime.length > 0) {
                        performanceStats.appRenderTime = new HistogramBucket[this.appRenderTime.length];
                        for (int i2 = 0; i2 < this.appRenderTime.length; i2++) {
                            if (this.appRenderTime[i2] != null) {
                                performanceStats.appRenderTime[i2] = this.appRenderTime[i2].clone();
                            }
                        }
                    }
                    if (this.presentTime != null && this.presentTime.length > 0) {
                        performanceStats.presentTime = new HistogramBucket[this.presentTime.length];
                        for (int i3 = 0; i3 < this.presentTime.length; i3++) {
                            if (this.presentTime[i3] != null) {
                                performanceStats.presentTime[i3] = this.presentTime[i3].clone();
                            }
                        }
                    }
                    if (this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                        performanceStats.totalRenderTime = new HistogramBucket[this.totalRenderTime.length];
                        for (int i4 = 0; i4 < this.totalRenderTime.length; i4++) {
                            if (this.totalRenderTime[i4] != null) {
                                performanceStats.totalRenderTime[i4] = this.totalRenderTime[i4].clone();
                            }
                        }
                    }
                    if (this.postFrameTime != null && this.postFrameTime.length > 0) {
                        performanceStats.postFrameTime = new HistogramBucket[this.postFrameTime.length];
                        for (int i5 = 0; i5 < this.postFrameTime.length; i5++) {
                            if (this.postFrameTime[i5] != null) {
                                performanceStats.postFrameTime[i5] = this.postFrameTime[i5].clone();
                            }
                        }
                    }
                    if (this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                        performanceStats.consecutiveDroppedFrames = new HistogramBucket[this.consecutiveDroppedFrames.length];
                        for (int i6 = 0; i6 < this.consecutiveDroppedFrames.length; i6++) {
                            if (this.consecutiveDroppedFrames[i6] != null) {
                                performanceStats.consecutiveDroppedFrames[i6] = this.consecutiveDroppedFrames[i6].clone();
                            }
                        }
                    }
                    if (this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                        performanceStats.scanlineRacingVsyncOvershootUs = new HistogramBucket[this.scanlineRacingVsyncOvershootUs.length];
                        for (int i7 = 0; i7 < this.scanlineRacingVsyncOvershootUs.length; i7++) {
                            if (this.scanlineRacingVsyncOvershootUs[i7] != null) {
                                performanceStats.scanlineRacingVsyncOvershootUs[i7] = this.scanlineRacingVsyncOvershootUs[i7].clone();
                            }
                        }
                    }
                    if (this.cpuThrottlingTemperature != null && this.cpuThrottlingTemperature.length > 0) {
                        performanceStats.cpuThrottlingTemperature = (float[]) this.cpuThrottlingTemperature.clone();
                    }
                    if (this.gpuThrottlingTemperature != null && this.gpuThrottlingTemperature.length > 0) {
                        performanceStats.gpuThrottlingTemperature = (float[]) this.gpuThrottlingTemperature.clone();
                    }
                    if (this.batteryThrottlingTemperature != null && this.batteryThrottlingTemperature.length > 0) {
                        performanceStats.batteryThrottlingTemperature = (float[]) this.batteryThrottlingTemperature.clone();
                    }
                    if (this.cpuShutdownTemperature != null && this.cpuShutdownTemperature.length > 0) {
                        performanceStats.cpuShutdownTemperature = (float[]) this.cpuShutdownTemperature.clone();
                    }
                    if (this.gpuShutdownTemperature != null && this.gpuShutdownTemperature.length > 0) {
                        performanceStats.gpuShutdownTemperature = (float[]) this.gpuShutdownTemperature.clone();
                    }
                    if (this.batteryShutdownTemperature != null && this.batteryShutdownTemperature.length > 0) {
                        performanceStats.batteryShutdownTemperature = (float[]) this.batteryShutdownTemperature.clone();
                    }
                    return performanceStats;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.averageFps != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.averageFps.intValue());
                }
                if (this.frameTime != null && this.frameTime.length > 0) {
                    for (HistogramBucket histogramBucket : this.frameTime) {
                        if (histogramBucket != null) {
                            codedOutputByteBufferNano.writeMessage(2, histogramBucket);
                        }
                    }
                }
                if (this.memoryConsumptionKilobytes != null) {
                    codedOutputByteBufferNano.writeInt32(3, this.memoryConsumptionKilobytes.intValue());
                }
                if (this.throttleSkinTemperatureCelsius != null) {
                    codedOutputByteBufferNano.writeFloat(4, this.throttleSkinTemperatureCelsius.floatValue());
                }
                if (this.vrMaxSkinTemperatureCelsius != null) {
                    codedOutputByteBufferNano.writeFloat(5, this.vrMaxSkinTemperatureCelsius.floatValue());
                }
                if (this.shutdownSkinTemperatureCelsius != null) {
                    codedOutputByteBufferNano.writeFloat(6, this.shutdownSkinTemperatureCelsius.floatValue());
                }
                if (this.timeSeriesData != null) {
                    codedOutputByteBufferNano.writeMessage(7, this.timeSeriesData);
                }
                if (this.appRenderTime != null && this.appRenderTime.length > 0) {
                    for (HistogramBucket histogramBucket2 : this.appRenderTime) {
                        if (histogramBucket2 != null) {
                            codedOutputByteBufferNano.writeMessage(8, histogramBucket2);
                        }
                    }
                }
                if (this.presentTime != null && this.presentTime.length > 0) {
                    for (HistogramBucket histogramBucket3 : this.presentTime) {
                        if (histogramBucket3 != null) {
                            codedOutputByteBufferNano.writeMessage(9, histogramBucket3);
                        }
                    }
                }
                if (this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                    for (HistogramBucket histogramBucket4 : this.totalRenderTime) {
                        if (histogramBucket4 != null) {
                            codedOutputByteBufferNano.writeMessage(10, histogramBucket4);
                        }
                    }
                }
                if (this.postFrameTime != null && this.postFrameTime.length > 0) {
                    for (HistogramBucket histogramBucket5 : this.postFrameTime) {
                        if (histogramBucket5 != null) {
                            codedOutputByteBufferNano.writeMessage(11, histogramBucket5);
                        }
                    }
                }
                if (this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                    for (HistogramBucket histogramBucket6 : this.consecutiveDroppedFrames) {
                        if (histogramBucket6 != null) {
                            codedOutputByteBufferNano.writeMessage(12, histogramBucket6);
                        }
                    }
                }
                if (this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                    for (HistogramBucket histogramBucket7 : this.scanlineRacingVsyncOvershootUs) {
                        if (histogramBucket7 != null) {
                            codedOutputByteBufferNano.writeMessage(13, histogramBucket7);
                        }
                    }
                }
                if (this.thermalEventFlags != null) {
                    codedOutputByteBufferNano.writeInt32(14, this.thermalEventFlags.intValue());
                }
                if (this.cpuThrottlingTemperature != null && this.cpuThrottlingTemperature.length > 0) {
                    for (float writeFloat : this.cpuThrottlingTemperature) {
                        codedOutputByteBufferNano.writeFloat(15, writeFloat);
                    }
                }
                if (this.gpuThrottlingTemperature != null && this.gpuThrottlingTemperature.length > 0) {
                    for (float writeFloat2 : this.gpuThrottlingTemperature) {
                        codedOutputByteBufferNano.writeFloat(16, writeFloat2);
                    }
                }
                if (this.batteryThrottlingTemperature != null && this.batteryThrottlingTemperature.length > 0) {
                    for (float writeFloat3 : this.batteryThrottlingTemperature) {
                        codedOutputByteBufferNano.writeFloat(17, writeFloat3);
                    }
                }
                if (this.cpuShutdownTemperature != null && this.cpuShutdownTemperature.length > 0) {
                    for (float writeFloat4 : this.cpuShutdownTemperature) {
                        codedOutputByteBufferNano.writeFloat(18, writeFloat4);
                    }
                }
                if (this.gpuShutdownTemperature != null && this.gpuShutdownTemperature.length > 0) {
                    for (float writeFloat5 : this.gpuShutdownTemperature) {
                        codedOutputByteBufferNano.writeFloat(19, writeFloat5);
                    }
                }
                if (this.batteryShutdownTemperature != null && this.batteryShutdownTemperature.length > 0) {
                    for (float writeFloat6 : this.batteryShutdownTemperature) {
                        codedOutputByteBufferNano.writeFloat(20, writeFloat6);
                    }
                }
                if (this.averageAppFps != null) {
                    codedOutputByteBufferNano.writeFloat(21, this.averageAppFps.floatValue());
                }
                if (this.edsFps != null) {
                    codedOutputByteBufferNano.writeFloat(22, this.edsFps.floatValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.averageFps != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.averageFps.intValue());
                }
                if (this.frameTime != null && this.frameTime.length > 0) {
                    int i = computeSerializedSize;
                    for (HistogramBucket histogramBucket : this.frameTime) {
                        if (histogramBucket != null) {
                            i += CodedOutputByteBufferNano.computeMessageSize(2, histogramBucket);
                        }
                    }
                    computeSerializedSize = i;
                }
                if (this.memoryConsumptionKilobytes != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.memoryConsumptionKilobytes.intValue());
                }
                if (this.throttleSkinTemperatureCelsius != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.throttleSkinTemperatureCelsius.floatValue());
                }
                if (this.vrMaxSkinTemperatureCelsius != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.vrMaxSkinTemperatureCelsius.floatValue());
                }
                if (this.shutdownSkinTemperatureCelsius != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.shutdownSkinTemperatureCelsius.floatValue());
                }
                if (this.timeSeriesData != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, this.timeSeriesData);
                }
                if (this.appRenderTime != null && this.appRenderTime.length > 0) {
                    int i2 = computeSerializedSize;
                    for (HistogramBucket histogramBucket2 : this.appRenderTime) {
                        if (histogramBucket2 != null) {
                            i2 += CodedOutputByteBufferNano.computeMessageSize(8, histogramBucket2);
                        }
                    }
                    computeSerializedSize = i2;
                }
                if (this.presentTime != null && this.presentTime.length > 0) {
                    int i3 = computeSerializedSize;
                    for (HistogramBucket histogramBucket3 : this.presentTime) {
                        if (histogramBucket3 != null) {
                            i3 += CodedOutputByteBufferNano.computeMessageSize(9, histogramBucket3);
                        }
                    }
                    computeSerializedSize = i3;
                }
                if (this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                    int i4 = computeSerializedSize;
                    for (HistogramBucket histogramBucket4 : this.totalRenderTime) {
                        if (histogramBucket4 != null) {
                            i4 += CodedOutputByteBufferNano.computeMessageSize(10, histogramBucket4);
                        }
                    }
                    computeSerializedSize = i4;
                }
                if (this.postFrameTime != null && this.postFrameTime.length > 0) {
                    int i5 = computeSerializedSize;
                    for (HistogramBucket histogramBucket5 : this.postFrameTime) {
                        if (histogramBucket5 != null) {
                            i5 += CodedOutputByteBufferNano.computeMessageSize(11, histogramBucket5);
                        }
                    }
                    computeSerializedSize = i5;
                }
                if (this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                    int i6 = computeSerializedSize;
                    for (HistogramBucket histogramBucket6 : this.consecutiveDroppedFrames) {
                        if (histogramBucket6 != null) {
                            i6 += CodedOutputByteBufferNano.computeMessageSize(12, histogramBucket6);
                        }
                    }
                    computeSerializedSize = i6;
                }
                if (this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                    for (HistogramBucket histogramBucket7 : this.scanlineRacingVsyncOvershootUs) {
                        if (histogramBucket7 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, histogramBucket7);
                        }
                    }
                }
                if (this.thermalEventFlags != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, this.thermalEventFlags.intValue());
                }
                if (this.cpuThrottlingTemperature != null && this.cpuThrottlingTemperature.length > 0) {
                    computeSerializedSize = computeSerializedSize + (this.cpuThrottlingTemperature.length * 4) + (this.cpuThrottlingTemperature.length * 1);
                }
                if (this.gpuThrottlingTemperature != null && this.gpuThrottlingTemperature.length > 0) {
                    computeSerializedSize = computeSerializedSize + (this.gpuThrottlingTemperature.length * 4) + (this.gpuThrottlingTemperature.length * 2);
                }
                if (this.batteryThrottlingTemperature != null && this.batteryThrottlingTemperature.length > 0) {
                    computeSerializedSize = computeSerializedSize + (this.batteryThrottlingTemperature.length * 4) + (this.batteryThrottlingTemperature.length * 2);
                }
                if (this.cpuShutdownTemperature != null && this.cpuShutdownTemperature.length > 0) {
                    computeSerializedSize = computeSerializedSize + (this.cpuShutdownTemperature.length * 4) + (this.cpuShutdownTemperature.length * 2);
                }
                if (this.gpuShutdownTemperature != null && this.gpuShutdownTemperature.length > 0) {
                    computeSerializedSize = computeSerializedSize + (this.gpuShutdownTemperature.length * 4) + (this.gpuShutdownTemperature.length * 2);
                }
                if (this.batteryShutdownTemperature != null && this.batteryShutdownTemperature.length > 0) {
                    computeSerializedSize = computeSerializedSize + (this.batteryShutdownTemperature.length * 4) + (this.batteryShutdownTemperature.length * 2);
                }
                if (this.averageAppFps != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(21, this.averageAppFps.floatValue());
                }
                if (this.edsFps != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(22, this.edsFps.floatValue());
                }
                return computeSerializedSize;
            }

            public final PerformanceStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.averageFps = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 18:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                            int length = this.frameTime == null ? 0 : this.frameTime.length;
                            HistogramBucket[] histogramBucketArr = new HistogramBucket[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.frameTime, 0, histogramBucketArr, 0, length);
                            }
                            while (length < histogramBucketArr.length - 1) {
                                histogramBucketArr[length] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            histogramBucketArr[length] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr[length]);
                            this.frameTime = histogramBucketArr;
                            continue;
                        case AndroidNCompat.N_SDK_LEVEL:
                            this.memoryConsumptionKilobytes = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 37:
                            this.throttleSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 45:
                            this.vrMaxSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 53:
                            this.shutdownSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 58:
                            if (this.timeSeriesData == null) {
                                this.timeSeriesData = new TimeSeriesData();
                            }
                            codedInputByteBufferNano.readMessage(this.timeSeriesData);
                            continue;
                        case 66:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                            int length2 = this.appRenderTime == null ? 0 : this.appRenderTime.length;
                            HistogramBucket[] histogramBucketArr2 = new HistogramBucket[(repeatedFieldArrayLength2 + length2)];
                            if (length2 != 0) {
                                System.arraycopy(this.appRenderTime, 0, histogramBucketArr2, 0, length2);
                            }
                            while (length2 < histogramBucketArr2.length - 1) {
                                histogramBucketArr2[length2] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr2[length2]);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            histogramBucketArr2[length2] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr2[length2]);
                            this.appRenderTime = histogramBucketArr2;
                            continue;
                        case 74:
                            int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                            int length3 = this.presentTime == null ? 0 : this.presentTime.length;
                            HistogramBucket[] histogramBucketArr3 = new HistogramBucket[(repeatedFieldArrayLength3 + length3)];
                            if (length3 != 0) {
                                System.arraycopy(this.presentTime, 0, histogramBucketArr3, 0, length3);
                            }
                            while (length3 < histogramBucketArr3.length - 1) {
                                histogramBucketArr3[length3] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr3[length3]);
                                codedInputByteBufferNano.readTag();
                                length3++;
                            }
                            histogramBucketArr3[length3] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr3[length3]);
                            this.presentTime = histogramBucketArr3;
                            continue;
                        case 82:
                            int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                            int length4 = this.totalRenderTime == null ? 0 : this.totalRenderTime.length;
                            HistogramBucket[] histogramBucketArr4 = new HistogramBucket[(repeatedFieldArrayLength4 + length4)];
                            if (length4 != 0) {
                                System.arraycopy(this.totalRenderTime, 0, histogramBucketArr4, 0, length4);
                            }
                            while (length4 < histogramBucketArr4.length - 1) {
                                histogramBucketArr4[length4] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr4[length4]);
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            histogramBucketArr4[length4] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr4[length4]);
                            this.totalRenderTime = histogramBucketArr4;
                            continue;
                        case 90:
                            int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                            int length5 = this.postFrameTime == null ? 0 : this.postFrameTime.length;
                            HistogramBucket[] histogramBucketArr5 = new HistogramBucket[(repeatedFieldArrayLength5 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.postFrameTime, 0, histogramBucketArr5, 0, length5);
                            }
                            while (length5 < histogramBucketArr5.length - 1) {
                                histogramBucketArr5[length5] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr5[length5]);
                                codedInputByteBufferNano.readTag();
                                length5++;
                            }
                            histogramBucketArr5[length5] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr5[length5]);
                            this.postFrameTime = histogramBucketArr5;
                            continue;
                        case 98:
                            int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                            int length6 = this.consecutiveDroppedFrames == null ? 0 : this.consecutiveDroppedFrames.length;
                            HistogramBucket[] histogramBucketArr6 = new HistogramBucket[(repeatedFieldArrayLength6 + length6)];
                            if (length6 != 0) {
                                System.arraycopy(this.consecutiveDroppedFrames, 0, histogramBucketArr6, 0, length6);
                            }
                            while (length6 < histogramBucketArr6.length - 1) {
                                histogramBucketArr6[length6] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr6[length6]);
                                codedInputByteBufferNano.readTag();
                                length6++;
                            }
                            histogramBucketArr6[length6] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr6[length6]);
                            this.consecutiveDroppedFrames = histogramBucketArr6;
                            continue;
                        case 106:
                            int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                            int length7 = this.scanlineRacingVsyncOvershootUs == null ? 0 : this.scanlineRacingVsyncOvershootUs.length;
                            HistogramBucket[] histogramBucketArr7 = new HistogramBucket[(repeatedFieldArrayLength7 + length7)];
                            if (length7 != 0) {
                                System.arraycopy(this.scanlineRacingVsyncOvershootUs, 0, histogramBucketArr7, 0, length7);
                            }
                            while (length7 < histogramBucketArr7.length - 1) {
                                histogramBucketArr7[length7] = new HistogramBucket();
                                codedInputByteBufferNano.readMessage(histogramBucketArr7[length7]);
                                codedInputByteBufferNano.readTag();
                                length7++;
                            }
                            histogramBucketArr7[length7] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr7[length7]);
                            this.scanlineRacingVsyncOvershootUs = histogramBucketArr7;
                            continue;
                        case 112:
                            this.thermalEventFlags = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 122:
                            int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                            int i = readRawVarint32 / 4;
                            int length8 = this.cpuThrottlingTemperature == null ? 0 : this.cpuThrottlingTemperature.length;
                            float[] fArr = new float[(i + length8)];
                            if (length8 != 0) {
                                System.arraycopy(this.cpuThrottlingTemperature, 0, fArr, 0, length8);
                            }
                            while (length8 < fArr.length) {
                                fArr[length8] = codedInputByteBufferNano.readFloat();
                                length8++;
                            }
                            this.cpuThrottlingTemperature = fArr;
                            codedInputByteBufferNano.popLimit(pushLimit);
                            continue;
                        case 125:
                            int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 125);
                            int length9 = this.cpuThrottlingTemperature == null ? 0 : this.cpuThrottlingTemperature.length;
                            float[] fArr2 = new float[(repeatedFieldArrayLength8 + length9)];
                            if (length9 != 0) {
                                System.arraycopy(this.cpuThrottlingTemperature, 0, fArr2, 0, length9);
                            }
                            while (length9 < fArr2.length - 1) {
                                fArr2[length9] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length9++;
                            }
                            fArr2[length9] = codedInputByteBufferNano.readFloat();
                            this.cpuThrottlingTemperature = fArr2;
                            continue;
                        case 130:
                            int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                            int i2 = readRawVarint322 / 4;
                            int length10 = this.gpuThrottlingTemperature == null ? 0 : this.gpuThrottlingTemperature.length;
                            float[] fArr3 = new float[(i2 + length10)];
                            if (length10 != 0) {
                                System.arraycopy(this.gpuThrottlingTemperature, 0, fArr3, 0, length10);
                            }
                            while (length10 < fArr3.length) {
                                fArr3[length10] = codedInputByteBufferNano.readFloat();
                                length10++;
                            }
                            this.gpuThrottlingTemperature = fArr3;
                            codedInputByteBufferNano.popLimit(pushLimit2);
                            continue;
                        case 133:
                            int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 133);
                            int length11 = this.gpuThrottlingTemperature == null ? 0 : this.gpuThrottlingTemperature.length;
                            float[] fArr4 = new float[(repeatedFieldArrayLength9 + length11)];
                            if (length11 != 0) {
                                System.arraycopy(this.gpuThrottlingTemperature, 0, fArr4, 0, length11);
                            }
                            while (length11 < fArr4.length - 1) {
                                fArr4[length11] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length11++;
                            }
                            fArr4[length11] = codedInputByteBufferNano.readFloat();
                            this.gpuThrottlingTemperature = fArr4;
                            continue;
                        case 138:
                            int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                            int i3 = readRawVarint323 / 4;
                            int length12 = this.batteryThrottlingTemperature == null ? 0 : this.batteryThrottlingTemperature.length;
                            float[] fArr5 = new float[(i3 + length12)];
                            if (length12 != 0) {
                                System.arraycopy(this.batteryThrottlingTemperature, 0, fArr5, 0, length12);
                            }
                            while (length12 < fArr5.length) {
                                fArr5[length12] = codedInputByteBufferNano.readFloat();
                                length12++;
                            }
                            this.batteryThrottlingTemperature = fArr5;
                            codedInputByteBufferNano.popLimit(pushLimit3);
                            continue;
                        case 141:
                            int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 141);
                            int length13 = this.batteryThrottlingTemperature == null ? 0 : this.batteryThrottlingTemperature.length;
                            float[] fArr6 = new float[(repeatedFieldArrayLength10 + length13)];
                            if (length13 != 0) {
                                System.arraycopy(this.batteryThrottlingTemperature, 0, fArr6, 0, length13);
                            }
                            while (length13 < fArr6.length - 1) {
                                fArr6[length13] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length13++;
                            }
                            fArr6[length13] = codedInputByteBufferNano.readFloat();
                            this.batteryThrottlingTemperature = fArr6;
                            continue;
                        case 146:
                            int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                            int i4 = readRawVarint324 / 4;
                            int length14 = this.cpuShutdownTemperature == null ? 0 : this.cpuShutdownTemperature.length;
                            float[] fArr7 = new float[(i4 + length14)];
                            if (length14 != 0) {
                                System.arraycopy(this.cpuShutdownTemperature, 0, fArr7, 0, length14);
                            }
                            while (length14 < fArr7.length) {
                                fArr7[length14] = codedInputByteBufferNano.readFloat();
                                length14++;
                            }
                            this.cpuShutdownTemperature = fArr7;
                            codedInputByteBufferNano.popLimit(pushLimit4);
                            continue;
                        case 149:
                            int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 149);
                            int length15 = this.cpuShutdownTemperature == null ? 0 : this.cpuShutdownTemperature.length;
                            float[] fArr8 = new float[(repeatedFieldArrayLength11 + length15)];
                            if (length15 != 0) {
                                System.arraycopy(this.cpuShutdownTemperature, 0, fArr8, 0, length15);
                            }
                            while (length15 < fArr8.length - 1) {
                                fArr8[length15] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length15++;
                            }
                            fArr8[length15] = codedInputByteBufferNano.readFloat();
                            this.cpuShutdownTemperature = fArr8;
                            continue;
                        case 154:
                            int readRawVarint325 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit5 = codedInputByteBufferNano.pushLimit(readRawVarint325);
                            int i5 = readRawVarint325 / 4;
                            int length16 = this.gpuShutdownTemperature == null ? 0 : this.gpuShutdownTemperature.length;
                            float[] fArr9 = new float[(i5 + length16)];
                            if (length16 != 0) {
                                System.arraycopy(this.gpuShutdownTemperature, 0, fArr9, 0, length16);
                            }
                            while (length16 < fArr9.length) {
                                fArr9[length16] = codedInputByteBufferNano.readFloat();
                                length16++;
                            }
                            this.gpuShutdownTemperature = fArr9;
                            codedInputByteBufferNano.popLimit(pushLimit5);
                            continue;
                        case 157:
                            int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 157);
                            int length17 = this.gpuShutdownTemperature == null ? 0 : this.gpuShutdownTemperature.length;
                            float[] fArr10 = new float[(repeatedFieldArrayLength12 + length17)];
                            if (length17 != 0) {
                                System.arraycopy(this.gpuShutdownTemperature, 0, fArr10, 0, length17);
                            }
                            while (length17 < fArr10.length - 1) {
                                fArr10[length17] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length17++;
                            }
                            fArr10[length17] = codedInputByteBufferNano.readFloat();
                            this.gpuShutdownTemperature = fArr10;
                            continue;
                        case 162:
                            int readRawVarint326 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit6 = codedInputByteBufferNano.pushLimit(readRawVarint326);
                            int i6 = readRawVarint326 / 4;
                            int length18 = this.batteryShutdownTemperature == null ? 0 : this.batteryShutdownTemperature.length;
                            float[] fArr11 = new float[(i6 + length18)];
                            if (length18 != 0) {
                                System.arraycopy(this.batteryShutdownTemperature, 0, fArr11, 0, length18);
                            }
                            while (length18 < fArr11.length) {
                                fArr11[length18] = codedInputByteBufferNano.readFloat();
                                length18++;
                            }
                            this.batteryShutdownTemperature = fArr11;
                            codedInputByteBufferNano.popLimit(pushLimit6);
                            continue;
                        case 165:
                            int repeatedFieldArrayLength13 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 165);
                            int length19 = this.batteryShutdownTemperature == null ? 0 : this.batteryShutdownTemperature.length;
                            float[] fArr12 = new float[(repeatedFieldArrayLength13 + length19)];
                            if (length19 != 0) {
                                System.arraycopy(this.batteryShutdownTemperature, 0, fArr12, 0, length19);
                            }
                            while (length19 < fArr12.length - 1) {
                                fArr12[length19] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length19++;
                            }
                            fArr12[length19] = codedInputByteBufferNano.readFloat();
                            this.batteryShutdownTemperature = fArr12;
                            continue;
                        case 173:
                            this.averageAppFps = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 181:
                            this.edsFps = Float.valueOf(codedInputByteBufferNano.readFloat());
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$PhoneAlignment */
        public static final class PhoneAlignment extends ExtendableMessageNano<PhoneAlignment> implements Cloneable {
            public Float angleDegrees;
            public Vector2 lensOffset;
            public Vector2[] touchLocations;

            public PhoneAlignment() {
                clear();
            }

            public final PhoneAlignment clear() {
                this.touchLocations = Vector2.emptyArray();
                this.lensOffset = null;
                this.angleDegrees = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final PhoneAlignment clone() {
                try {
                    PhoneAlignment phoneAlignment = (PhoneAlignment) super.clone();
                    if (this.touchLocations != null && this.touchLocations.length > 0) {
                        phoneAlignment.touchLocations = new Vector2[this.touchLocations.length];
                        for (int i = 0; i < this.touchLocations.length; i++) {
                            if (this.touchLocations[i] != null) {
                                phoneAlignment.touchLocations[i] = this.touchLocations[i].clone();
                            }
                        }
                    }
                    if (this.lensOffset != null) {
                        phoneAlignment.lensOffset = this.lensOffset.clone();
                    }
                    return phoneAlignment;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.touchLocations != null && this.touchLocations.length > 0) {
                    for (Vector2 vector2 : this.touchLocations) {
                        if (vector2 != null) {
                            codedOutputByteBufferNano.writeMessage(1, vector2);
                        }
                    }
                }
                if (this.lensOffset != null) {
                    codedOutputByteBufferNano.writeMessage(2, this.lensOffset);
                }
                if (this.angleDegrees != null) {
                    codedOutputByteBufferNano.writeFloat(3, this.angleDegrees.floatValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.touchLocations != null && this.touchLocations.length > 0) {
                    for (Vector2 vector2 : this.touchLocations) {
                        if (vector2 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vector2);
                        }
                    }
                }
                if (this.lensOffset != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.lensOffset);
                }
                if (this.angleDegrees != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, this.angleDegrees.floatValue());
                }
                return computeSerializedSize;
            }

            public final PhoneAlignment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                            int length = this.touchLocations == null ? 0 : this.touchLocations.length;
                            Vector2[] vector2Arr = new Vector2[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.touchLocations, 0, vector2Arr, 0, length);
                            }
                            while (length < vector2Arr.length - 1) {
                                vector2Arr[length] = new Vector2();
                                codedInputByteBufferNano.readMessage(vector2Arr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            vector2Arr[length] = new Vector2();
                            codedInputByteBufferNano.readMessage(vector2Arr[length]);
                            this.touchLocations = vector2Arr;
                            continue;
                        case 18:
                            if (this.lensOffset == null) {
                                this.lensOffset = new Vector2();
                            }
                            codedInputByteBufferNano.readMessage(this.lensOffset);
                            continue;
                        case 29:
                            this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$QrCodeScan */
        public static final class QrCodeScan extends ExtendableMessageNano<QrCodeScan> implements Cloneable {
            public String headMountConfigUrl;
            @NanoEnumValue(legacy = false, value = Status.class)
            public Integer status;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$QrCodeScan$Status */
            public interface Status {
            }

            @NanoEnumValue(legacy = false, value = Status.class)
            public static int checkStatusOrThrow(int i) {
                if (i >= 0 && i <= 3) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(38).append(i).append(" is not a valid enum Status").toString());
            }

            public QrCodeScan() {
                clear();
            }

            public final QrCodeScan clear() {
                this.status = null;
                this.headMountConfigUrl = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final QrCodeScan clone() {
                try {
                    return (QrCodeScan) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.status != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.status.intValue());
                }
                if (this.headMountConfigUrl != null) {
                    codedOutputByteBufferNano.writeString(2, this.headMountConfigUrl);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.status != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.status.intValue());
                }
                if (this.headMountConfigUrl != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.headMountConfigUrl);
                }
                return computeSerializedSize;
            }

            public final QrCodeScan mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.status = Integer.valueOf(checkStatusOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
                        case 18:
                            this.headMountConfigUrl = codedInputByteBufferNano.readString();
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Renderer */
        public static final class Renderer extends ExtendableMessageNano<Renderer> implements Cloneable {
            public String glRenderer;
            public String glVendor;
            public String glVersion;

            public Renderer() {
                clear();
            }

            public final Renderer clear() {
                this.glVendor = null;
                this.glRenderer = null;
                this.glVersion = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Renderer clone() {
                try {
                    return (Renderer) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.glVendor != null) {
                    codedOutputByteBufferNano.writeString(1, this.glVendor);
                }
                if (this.glRenderer != null) {
                    codedOutputByteBufferNano.writeString(2, this.glRenderer);
                }
                if (this.glVersion != null) {
                    codedOutputByteBufferNano.writeString(3, this.glVersion);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.glVendor != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.glVendor);
                }
                if (this.glRenderer != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.glRenderer);
                }
                if (this.glVersion != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.glVersion);
                }
                return computeSerializedSize;
            }

            public final Renderer mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.glVendor = codedInputByteBufferNano.readString();
                            continue;
                        case 18:
                            this.glRenderer = codedInputByteBufferNano.readString();
                            continue;
                        case 26:
                            this.glVersion = codedInputByteBufferNano.readString();
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$TimeSeriesData */
        public static final class TimeSeriesData extends ExtendableMessageNano<TimeSeriesData> implements Cloneable {
            public TimeIntervalData[] timeIntervalData;
            public Integer timeIntervalSeconds;

            public TimeSeriesData() {
                clear();
            }

            public final TimeSeriesData clear() {
                this.timeIntervalSeconds = null;
                this.timeIntervalData = TimeIntervalData.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$TimeSeriesData$TimeIntervalData */
            public static final class TimeIntervalData extends ExtendableMessageNano<TimeIntervalData> implements Cloneable {
                private static volatile TimeIntervalData[] _emptyArray;
                public Integer batteryLevel;
                public Integer batteryLevelDelta;
                public float[] batteryTemperature;
                public float[] cpuTemperature;
                public Integer edsThreadFrameDropCount;
                public float[] gpuTemperature;
                public Integer intervalStartTimeSeconds;
                public Float skinTemperature;
                public Integer thermalWarningsShown;

                public static TimeIntervalData[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new TimeIntervalData[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public TimeIntervalData() {
                    clear();
                }

                public final TimeIntervalData clear() {
                    this.intervalStartTimeSeconds = null;
                    this.skinTemperature = null;
                    this.edsThreadFrameDropCount = null;
                    this.batteryLevel = null;
                    this.batteryLevelDelta = null;
                    this.thermalWarningsShown = null;
                    this.cpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.gpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.batteryTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final TimeIntervalData clone() {
                    try {
                        TimeIntervalData timeIntervalData = (TimeIntervalData) super.clone();
                        if (this.cpuTemperature != null && this.cpuTemperature.length > 0) {
                            timeIntervalData.cpuTemperature = (float[]) this.cpuTemperature.clone();
                        }
                        if (this.gpuTemperature != null && this.gpuTemperature.length > 0) {
                            timeIntervalData.gpuTemperature = (float[]) this.gpuTemperature.clone();
                        }
                        if (this.batteryTemperature != null && this.batteryTemperature.length > 0) {
                            timeIntervalData.batteryTemperature = (float[]) this.batteryTemperature.clone();
                        }
                        return timeIntervalData;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if (this.intervalStartTimeSeconds != null) {
                        codedOutputByteBufferNano.writeInt32(1, this.intervalStartTimeSeconds.intValue());
                    }
                    if (this.skinTemperature != null) {
                        codedOutputByteBufferNano.writeFloat(2, this.skinTemperature.floatValue());
                    }
                    if (this.edsThreadFrameDropCount != null) {
                        codedOutputByteBufferNano.writeInt32(3, this.edsThreadFrameDropCount.intValue());
                    }
                    if (this.batteryLevel != null) {
                        codedOutputByteBufferNano.writeInt32(4, this.batteryLevel.intValue());
                    }
                    if (this.batteryLevelDelta != null) {
                        codedOutputByteBufferNano.writeInt32(5, this.batteryLevelDelta.intValue());
                    }
                    if (this.thermalWarningsShown != null) {
                        codedOutputByteBufferNano.writeInt32(6, this.thermalWarningsShown.intValue());
                    }
                    if (this.cpuTemperature != null && this.cpuTemperature.length > 0) {
                        for (float writeFloat : this.cpuTemperature) {
                            codedOutputByteBufferNano.writeFloat(7, writeFloat);
                        }
                    }
                    if (this.gpuTemperature != null && this.gpuTemperature.length > 0) {
                        for (float writeFloat2 : this.gpuTemperature) {
                            codedOutputByteBufferNano.writeFloat(8, writeFloat2);
                        }
                    }
                    if (this.batteryTemperature != null && this.batteryTemperature.length > 0) {
                        for (float writeFloat3 : this.batteryTemperature) {
                            codedOutputByteBufferNano.writeFloat(9, writeFloat3);
                        }
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    if (this.intervalStartTimeSeconds != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.intervalStartTimeSeconds.intValue());
                    }
                    if (this.skinTemperature != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.skinTemperature.floatValue());
                    }
                    if (this.edsThreadFrameDropCount != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, this.edsThreadFrameDropCount.intValue());
                    }
                    if (this.batteryLevel != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, this.batteryLevel.intValue());
                    }
                    if (this.batteryLevelDelta != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, this.batteryLevelDelta.intValue());
                    }
                    if (this.thermalWarningsShown != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, this.thermalWarningsShown.intValue());
                    }
                    if (this.cpuTemperature != null && this.cpuTemperature.length > 0) {
                        computeSerializedSize = computeSerializedSize + (this.cpuTemperature.length * 4) + (this.cpuTemperature.length * 1);
                    }
                    if (this.gpuTemperature != null && this.gpuTemperature.length > 0) {
                        computeSerializedSize = computeSerializedSize + (this.gpuTemperature.length * 4) + (this.gpuTemperature.length * 1);
                    }
                    if (this.batteryTemperature == null || this.batteryTemperature.length <= 0) {
                        return computeSerializedSize;
                    }
                    return computeSerializedSize + (this.batteryTemperature.length * 4) + (this.batteryTemperature.length * 1);
                }

                public final TimeIntervalData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.intervalStartTimeSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 21:
                                this.skinTemperature = Float.valueOf(codedInputByteBufferNano.readFloat());
                                continue;
                            case AndroidNCompat.N_SDK_LEVEL:
                                this.edsThreadFrameDropCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 32:
                                this.batteryLevel = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 40:
                                this.batteryLevelDelta = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 48:
                                this.thermalWarningsShown = Integer.valueOf(codedInputByteBufferNano.readInt32());
                                continue;
                            case 58:
                                int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                                int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                                int i = readRawVarint32 / 4;
                                int length = this.cpuTemperature == null ? 0 : this.cpuTemperature.length;
                                float[] fArr = new float[(i + length)];
                                if (length != 0) {
                                    System.arraycopy(this.cpuTemperature, 0, fArr, 0, length);
                                }
                                while (length < fArr.length) {
                                    fArr[length] = codedInputByteBufferNano.readFloat();
                                    length++;
                                }
                                this.cpuTemperature = fArr;
                                codedInputByteBufferNano.popLimit(pushLimit);
                                continue;
                            case 61:
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 61);
                                int length2 = this.cpuTemperature == null ? 0 : this.cpuTemperature.length;
                                float[] fArr2 = new float[(repeatedFieldArrayLength + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.cpuTemperature, 0, fArr2, 0, length2);
                                }
                                while (length2 < fArr2.length - 1) {
                                    fArr2[length2] = codedInputByteBufferNano.readFloat();
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                fArr2[length2] = codedInputByteBufferNano.readFloat();
                                this.cpuTemperature = fArr2;
                                continue;
                            case 66:
                                int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                                int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                                int i2 = readRawVarint322 / 4;
                                int length3 = this.gpuTemperature == null ? 0 : this.gpuTemperature.length;
                                float[] fArr3 = new float[(i2 + length3)];
                                if (length3 != 0) {
                                    System.arraycopy(this.gpuTemperature, 0, fArr3, 0, length3);
                                }
                                while (length3 < fArr3.length) {
                                    fArr3[length3] = codedInputByteBufferNano.readFloat();
                                    length3++;
                                }
                                this.gpuTemperature = fArr3;
                                codedInputByteBufferNano.popLimit(pushLimit2);
                                continue;
                            case 69:
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 69);
                                int length4 = this.gpuTemperature == null ? 0 : this.gpuTemperature.length;
                                float[] fArr4 = new float[(repeatedFieldArrayLength2 + length4)];
                                if (length4 != 0) {
                                    System.arraycopy(this.gpuTemperature, 0, fArr4, 0, length4);
                                }
                                while (length4 < fArr4.length - 1) {
                                    fArr4[length4] = codedInputByteBufferNano.readFloat();
                                    codedInputByteBufferNano.readTag();
                                    length4++;
                                }
                                fArr4[length4] = codedInputByteBufferNano.readFloat();
                                this.gpuTemperature = fArr4;
                                continue;
                            case 74:
                                int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                                int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                                int i3 = readRawVarint323 / 4;
                                int length5 = this.batteryTemperature == null ? 0 : this.batteryTemperature.length;
                                float[] fArr5 = new float[(i3 + length5)];
                                if (length5 != 0) {
                                    System.arraycopy(this.batteryTemperature, 0, fArr5, 0, length5);
                                }
                                while (length5 < fArr5.length) {
                                    fArr5[length5] = codedInputByteBufferNano.readFloat();
                                    length5++;
                                }
                                this.batteryTemperature = fArr5;
                                codedInputByteBufferNano.popLimit(pushLimit3);
                                continue;
                            case 77:
                                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 77);
                                int length6 = this.batteryTemperature == null ? 0 : this.batteryTemperature.length;
                                float[] fArr6 = new float[(repeatedFieldArrayLength3 + length6)];
                                if (length6 != 0) {
                                    System.arraycopy(this.batteryTemperature, 0, fArr6, 0, length6);
                                }
                                while (length6 < fArr6.length - 1) {
                                    fArr6[length6] = codedInputByteBufferNano.readFloat();
                                    codedInputByteBufferNano.readTag();
                                    length6++;
                                }
                                fArr6[length6] = codedInputByteBufferNano.readFloat();
                                this.batteryTemperature = fArr6;
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

            public final TimeSeriesData clone() {
                try {
                    TimeSeriesData timeSeriesData = (TimeSeriesData) super.clone();
                    if (this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                        timeSeriesData.timeIntervalData = new TimeIntervalData[this.timeIntervalData.length];
                        for (int i = 0; i < this.timeIntervalData.length; i++) {
                            if (this.timeIntervalData[i] != null) {
                                timeSeriesData.timeIntervalData[i] = this.timeIntervalData[i].clone();
                            }
                        }
                    }
                    return timeSeriesData;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.timeIntervalSeconds != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.timeIntervalSeconds.intValue());
                }
                if (this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                    for (TimeIntervalData timeIntervalData2 : this.timeIntervalData) {
                        if (timeIntervalData2 != null) {
                            codedOutputByteBufferNano.writeMessage(2, timeIntervalData2);
                        }
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.timeIntervalSeconds != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.timeIntervalSeconds.intValue());
                }
                if (this.timeIntervalData == null || this.timeIntervalData.length <= 0) {
                    return computeSerializedSize;
                }
                int i = computeSerializedSize;
                for (TimeIntervalData timeIntervalData2 : this.timeIntervalData) {
                    if (timeIntervalData2 != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(2, timeIntervalData2);
                    }
                }
                return i;
            }

            public final TimeSeriesData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.timeIntervalSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 18:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                            int length = this.timeIntervalData == null ? 0 : this.timeIntervalData.length;
                            TimeIntervalData[] timeIntervalDataArr = new TimeIntervalData[(repeatedFieldArrayLength + length)];
                            if (length != 0) {
                                System.arraycopy(this.timeIntervalData, 0, timeIntervalDataArr, 0, length);
                            }
                            while (length < timeIntervalDataArr.length - 1) {
                                timeIntervalDataArr[length] = new TimeIntervalData();
                                codedInputByteBufferNano.readMessage(timeIntervalDataArr[length]);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            timeIntervalDataArr[length] = new TimeIntervalData();
                            codedInputByteBufferNano.readMessage(timeIntervalDataArr[length]);
                            this.timeIntervalData = timeIntervalDataArr;
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Transform */
        public static final class Transform extends ExtendableMessageNano<Transform> implements Cloneable {
            public Float rotationQx;
            public Float rotationQy;
            public Float rotationQz;
            public Float scale;
            public Float translationX;
            public Float translationY;
            public Float translationZ;

            public Transform() {
                clear();
            }

            public final Transform clear() {
                this.translationX = null;
                this.translationY = null;
                this.translationZ = null;
                this.rotationQx = null;
                this.rotationQy = null;
                this.rotationQz = null;
                this.scale = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Transform clone() {
                try {
                    return (Transform) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.translationX != null) {
                    codedOutputByteBufferNano.writeFloat(1, this.translationX.floatValue());
                }
                if (this.translationY != null) {
                    codedOutputByteBufferNano.writeFloat(2, this.translationY.floatValue());
                }
                if (this.translationZ != null) {
                    codedOutputByteBufferNano.writeFloat(3, this.translationZ.floatValue());
                }
                if (this.rotationQx != null) {
                    codedOutputByteBufferNano.writeFloat(4, this.rotationQx.floatValue());
                }
                if (this.rotationQy != null) {
                    codedOutputByteBufferNano.writeFloat(5, this.rotationQy.floatValue());
                }
                if (this.rotationQz != null) {
                    codedOutputByteBufferNano.writeFloat(6, this.rotationQz.floatValue());
                }
                if (this.scale != null) {
                    codedOutputByteBufferNano.writeFloat(7, this.scale.floatValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.translationX != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.translationX.floatValue());
                }
                if (this.translationY != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.translationY.floatValue());
                }
                if (this.translationZ != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.translationZ.floatValue());
                }
                if (this.rotationQx != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.rotationQx.floatValue());
                }
                if (this.rotationQy != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.rotationQy.floatValue());
                }
                if (this.rotationQz != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.rotationQz.floatValue());
                }
                if (this.scale != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(7, this.scale.floatValue());
                }
                return computeSerializedSize;
            }

            public final Transform mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 13:
                            this.translationX = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 21:
                            this.translationY = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 29:
                            this.translationZ = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 37:
                            this.rotationQx = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 45:
                            this.rotationQy = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 53:
                            this.rotationQz = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 61:
                            this.scale = Float.valueOf(codedInputByteBufferNano.readFloat());
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

        @NanoEnumValue(legacy = false, value = Bucket.class)
        public static int checkBucketOrThrow(int i) {
            if ((i >= 0 && i <= 6) || ((i >= 11 && i <= 11) || (i >= 21 && i <= 21))) {
                return i;
            }
            throw new IllegalArgumentException(new StringBuilder(38).append(i).append(" is not a valid enum Bucket").toString());
        }

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Launcher */
        public static final class Launcher extends ExtendableMessageNano<Launcher> implements Cloneable {
            @NanoEnumValue(legacy = false, value = NavItem.class)
            public Integer navItem;

            /* renamed from: com.google.common.logging.nano.Vr$VREvent$Launcher$NavItem */
            public interface NavItem {
            }

            @NanoEnumValue(legacy = false, value = NavItem.class)
            public static int checkNavItemOrThrow(int i) {
                if ((i >= 0 && i <= 3) || (i >= 6 && i <= 8)) {
                    return i;
                }
                throw new IllegalArgumentException(new StringBuilder(39).append(i).append(" is not a valid enum NavItem").toString());
            }

            public Launcher() {
                clear();
            }

            public final Launcher clear() {
                this.navItem = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Launcher clone() {
                try {
                    return (Launcher) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.navItem != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.navItem.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.navItem != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, this.navItem.intValue());
                }
                return computeSerializedSize;
            }

            public final Launcher mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            int position = codedInputByteBufferNano.getPosition();
                            try {
                                this.navItem = Integer.valueOf(checkNavItemOrThrow(codedInputByteBufferNano.readInt32()));
                                continue;
                            } catch (IllegalArgumentException e) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            }
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Application */
        public static final class Application extends ExtendableMessageNano<Application> implements Cloneable {
            private static volatile Application[] _emptyArray;
            public String name;
            public String packageName;
            public String version;

            public static Application[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Application[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Application() {
                clear();
            }

            public final Application clear() {
                this.packageName = null;
                this.name = null;
                this.version = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Application clone() {
                try {
                    return (Application) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.packageName != null) {
                    codedOutputByteBufferNano.writeString(1, this.packageName);
                }
                if (this.name != null) {
                    codedOutputByteBufferNano.writeString(2, this.name);
                }
                if (this.version != null) {
                    codedOutputByteBufferNano.writeString(3, this.version);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.packageName != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.packageName);
                }
                if (this.name != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
                }
                if (this.version != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.version);
                }
                return computeSerializedSize;
            }

            public final Application mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.packageName = codedInputByteBufferNano.readString();
                            continue;
                        case 18:
                            this.name = codedInputByteBufferNano.readString();
                            continue;
                        case 26:
                            this.version = codedInputByteBufferNano.readString();
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$HistogramBucket */
        public static final class HistogramBucket extends ExtendableMessageNano<HistogramBucket> implements Cloneable {
            private static volatile HistogramBucket[] _emptyArray;
            public Integer count;
            public Integer minimumValue;

            public static HistogramBucket[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new HistogramBucket[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public HistogramBucket() {
                clear();
            }

            public final HistogramBucket clear() {
                this.minimumValue = null;
                this.count = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final HistogramBucket clone() {
                try {
                    return (HistogramBucket) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.minimumValue != null) {
                    codedOutputByteBufferNano.writeInt32(1, this.minimumValue.intValue());
                }
                if (this.count != null) {
                    codedOutputByteBufferNano.writeInt32(2, this.count.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.minimumValue != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.minimumValue.intValue());
                }
                if (this.count != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.count.intValue());
                }
                return computeSerializedSize;
            }

            public final HistogramBucket mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.minimumValue = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            continue;
                        case 16:
                            this.count = Integer.valueOf(codedInputByteBufferNano.readInt32());
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

        /* renamed from: com.google.common.logging.nano.Vr$VREvent$Vector2 */
        public static final class Vector2 extends ExtendableMessageNano<Vector2> implements Cloneable {
            private static volatile Vector2[] _emptyArray;

            /* renamed from: x */
            public Float f6x;

            /* renamed from: y */
            public Float f7y;

            public static Vector2[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Vector2[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Vector2() {
                clear();
            }

            public final Vector2 clear() {
                this.f6x = null;
                this.f7y = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vector2 clone() {
                try {
                    return (Vector2) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (this.f6x != null) {
                    codedOutputByteBufferNano.writeFloat(1, this.f6x.floatValue());
                }
                if (this.f7y != null) {
                    codedOutputByteBufferNano.writeFloat(2, this.f7y.floatValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if (this.f6x != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.f6x.floatValue());
                }
                if (this.f7y != null) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, this.f7y.floatValue());
                }
                return computeSerializedSize;
            }

            public final Vector2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 13:
                            this.f6x = Float.valueOf(codedInputByteBufferNano.readFloat());
                            continue;
                        case 21:
                            this.f7y = Float.valueOf(codedInputByteBufferNano.readFloat());
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

        public VREvent() {
            clear();
        }

        public final VREvent clear() {
            this.eventSource = null;
            this.loggingOptInState = null;
            this.headMount = null;
            this.application = null;
            this.durationMs = null;
            this.installedVrApplications = Application.emptyArray();
            this.cyclops = null;
            this.qrCodeScan = null;
            this.cohort = null;
            this.lifetimeCountBucket = null;
            this.performanceStats = null;
            this.sensorStats = null;
            this.audioStats = null;
            this.embedVrWidget = null;
            this.vrCore = null;
            this.earthVr = null;
            this.launcher = null;
            this.keyboard = null;
            this.renderer = null;
            this.lullaby = null;
            this.streetView = null;
            this.photos = null;
            this.vrHome = null;
            this.sdkConfiguration = null;
            this.gConfigUpdate = null;
            this.jumpInspector = null;
            this.phoneAlignment = null;
            this.vrStreaming = null;
            this.expeditions = null;
            this.headTracking = null;
            this.standaloneHeadset = null;
            this.eva = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final VREvent clone() {
            try {
                VREvent vREvent = (VREvent) super.clone();
                if (this.loggingOptInState != null) {
                    vREvent.loggingOptInState = this.loggingOptInState.clone();
                }
                if (this.headMount != null) {
                    vREvent.headMount = this.headMount.clone();
                }
                if (this.application != null) {
                    vREvent.application = this.application.clone();
                }
                if (this.installedVrApplications != null && this.installedVrApplications.length > 0) {
                    vREvent.installedVrApplications = new Application[this.installedVrApplications.length];
                    for (int i = 0; i < this.installedVrApplications.length; i++) {
                        if (this.installedVrApplications[i] != null) {
                            vREvent.installedVrApplications[i] = this.installedVrApplications[i].clone();
                        }
                    }
                }
                if (this.cyclops != null) {
                    vREvent.cyclops = this.cyclops.clone();
                }
                if (this.qrCodeScan != null) {
                    vREvent.qrCodeScan = this.qrCodeScan.clone();
                }
                if (this.performanceStats != null) {
                    vREvent.performanceStats = this.performanceStats.clone();
                }
                if (this.sensorStats != null) {
                    vREvent.sensorStats = this.sensorStats.clone();
                }
                if (this.audioStats != null) {
                    vREvent.audioStats = this.audioStats.clone();
                }
                if (this.embedVrWidget != null) {
                    vREvent.embedVrWidget = this.embedVrWidget.clone();
                }
                if (this.vrCore != null) {
                    vREvent.vrCore = this.vrCore.clone();
                }
                if (this.earthVr != null) {
                    vREvent.earthVr = this.earthVr.clone();
                }
                if (this.launcher != null) {
                    vREvent.launcher = this.launcher.clone();
                }
                if (this.keyboard != null) {
                    vREvent.keyboard = this.keyboard.clone();
                }
                if (this.renderer != null) {
                    vREvent.renderer = this.renderer.clone();
                }
                if (this.lullaby != null) {
                    vREvent.lullaby = this.lullaby.clone();
                }
                if (this.streetView != null) {
                    vREvent.streetView = this.streetView.clone();
                }
                if (this.photos != null) {
                    vREvent.photos = this.photos.clone();
                }
                if (this.vrHome != null) {
                    vREvent.vrHome = this.vrHome.clone();
                }
                if (this.sdkConfiguration != null) {
                    vREvent.sdkConfiguration = this.sdkConfiguration.clone();
                }
                if (this.gConfigUpdate != null) {
                    vREvent.gConfigUpdate = this.gConfigUpdate.clone();
                }
                if (this.jumpInspector != null) {
                    vREvent.jumpInspector = this.jumpInspector.clone();
                }
                if (this.phoneAlignment != null) {
                    vREvent.phoneAlignment = this.phoneAlignment.clone();
                }
                if (this.vrStreaming != null) {
                    vREvent.vrStreaming = this.vrStreaming.clone();
                }
                if (this.expeditions != null) {
                    vREvent.expeditions = this.expeditions.clone();
                }
                if (this.headTracking != null) {
                    vREvent.headTracking = this.headTracking.clone();
                }
                if (this.standaloneHeadset != null) {
                    vREvent.standaloneHeadset = this.standaloneHeadset.clone();
                }
                if (this.eva != null) {
                    vREvent.eva = this.eva.clone();
                }
                return vREvent;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.headMount != null) {
                codedOutputByteBufferNano.writeMessage(1, this.headMount);
            }
            if (this.application != null) {
                codedOutputByteBufferNano.writeMessage(2, this.application);
            }
            if (this.durationMs != null) {
                codedOutputByteBufferNano.writeInt64(3, this.durationMs.longValue());
            }
            if (this.installedVrApplications != null && this.installedVrApplications.length > 0) {
                for (Application application2 : this.installedVrApplications) {
                    if (application2 != null) {
                        codedOutputByteBufferNano.writeMessage(4, application2);
                    }
                }
            }
            if (this.cyclops != null) {
                codedOutputByteBufferNano.writeMessage(5, this.cyclops);
            }
            if (this.qrCodeScan != null) {
                codedOutputByteBufferNano.writeMessage(6, this.qrCodeScan);
            }
            if (this.cohort != null) {
                codedOutputByteBufferNano.writeString(7, this.cohort);
            }
            if (this.lifetimeCountBucket != null) {
                codedOutputByteBufferNano.writeInt32(8, this.lifetimeCountBucket.intValue());
            }
            if (this.performanceStats != null) {
                codedOutputByteBufferNano.writeMessage(9, this.performanceStats);
            }
            if (this.sensorStats != null) {
                codedOutputByteBufferNano.writeMessage(10, this.sensorStats);
            }
            if (this.audioStats != null) {
                codedOutputByteBufferNano.writeMessage(11, this.audioStats);
            }
            if (this.embedVrWidget != null) {
                codedOutputByteBufferNano.writeMessage(12, this.embedVrWidget);
            }
            if (this.vrCore != null) {
                codedOutputByteBufferNano.writeMessage(13, this.vrCore);
            }
            if (this.earthVr != null) {
                codedOutputByteBufferNano.writeMessage(14, this.earthVr);
            }
            if (this.launcher != null) {
                codedOutputByteBufferNano.writeMessage(15, this.launcher);
            }
            if (this.keyboard != null) {
                codedOutputByteBufferNano.writeMessage(16, this.keyboard);
            }
            if (this.renderer != null) {
                codedOutputByteBufferNano.writeMessage(17, this.renderer);
            }
            if (this.lullaby != null) {
                codedOutputByteBufferNano.writeMessage(18, this.lullaby);
            }
            if (this.streetView != null) {
                codedOutputByteBufferNano.writeMessage(19, this.streetView);
            }
            if (this.photos != null) {
                codedOutputByteBufferNano.writeMessage(20, this.photos);
            }
            if (this.vrHome != null) {
                codedOutputByteBufferNano.writeMessage(21, this.vrHome);
            }
            if (this.sdkConfiguration != null) {
                codedOutputByteBufferNano.writeMessage(22, this.sdkConfiguration);
            }
            if (this.gConfigUpdate != null) {
                codedOutputByteBufferNano.writeMessage(23, this.gConfigUpdate);
            }
            if (this.jumpInspector != null) {
                codedOutputByteBufferNano.writeMessage(24, this.jumpInspector);
            }
            if (this.phoneAlignment != null) {
                codedOutputByteBufferNano.writeMessage(25, this.phoneAlignment);
            }
            if (this.vrStreaming != null) {
                codedOutputByteBufferNano.writeMessage(26, this.vrStreaming);
            }
            if (this.expeditions != null) {
                codedOutputByteBufferNano.writeMessage(27, this.expeditions);
            }
            if (this.headTracking != null) {
                codedOutputByteBufferNano.writeMessage(28, this.headTracking);
            }
            if (this.standaloneHeadset != null) {
                codedOutputByteBufferNano.writeMessage(29, this.standaloneHeadset);
            }
            if (this.eventSource != null) {
                codedOutputByteBufferNano.writeInt32(30, this.eventSource.intValue());
            }
            if (this.eva != null) {
                codedOutputByteBufferNano.writeMessage(31, this.eva);
            }
            if (this.loggingOptInState != null) {
                codedOutputByteBufferNano.writeMessage(32, this.loggingOptInState);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.headMount != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, this.headMount);
            }
            if (this.application != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.application);
            }
            if (this.durationMs != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, this.durationMs.longValue());
            }
            if (this.installedVrApplications != null && this.installedVrApplications.length > 0) {
                int i = computeSerializedSize;
                for (Application application2 : this.installedVrApplications) {
                    if (application2 != null) {
                        i += CodedOutputByteBufferNano.computeMessageSize(4, application2);
                    }
                }
                computeSerializedSize = i;
            }
            if (this.cyclops != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, this.cyclops);
            }
            if (this.qrCodeScan != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, this.qrCodeScan);
            }
            if (this.cohort != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.cohort);
            }
            if (this.lifetimeCountBucket != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, this.lifetimeCountBucket.intValue());
            }
            if (this.performanceStats != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, this.performanceStats);
            }
            if (this.sensorStats != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, this.sensorStats);
            }
            if (this.audioStats != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, this.audioStats);
            }
            if (this.embedVrWidget != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, this.embedVrWidget);
            }
            if (this.vrCore != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, this.vrCore);
            }
            if (this.earthVr != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, this.earthVr);
            }
            if (this.launcher != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, this.launcher);
            }
            if (this.keyboard != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, this.keyboard);
            }
            if (this.renderer != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, this.renderer);
            }
            if (this.lullaby != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, this.lullaby);
            }
            if (this.streetView != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, this.streetView);
            }
            if (this.photos != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, this.photos);
            }
            if (this.vrHome != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, this.vrHome);
            }
            if (this.sdkConfiguration != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, this.sdkConfiguration);
            }
            if (this.gConfigUpdate != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, this.gConfigUpdate);
            }
            if (this.jumpInspector != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, this.jumpInspector);
            }
            if (this.phoneAlignment != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, this.phoneAlignment);
            }
            if (this.vrStreaming != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, this.vrStreaming);
            }
            if (this.expeditions != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, this.expeditions);
            }
            if (this.headTracking != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(28, this.headTracking);
            }
            if (this.standaloneHeadset != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(29, this.standaloneHeadset);
            }
            if (this.eventSource != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(30, this.eventSource.intValue());
            }
            if (this.eva != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(31, this.eva);
            }
            if (this.loggingOptInState != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(32, this.loggingOptInState);
            }
            return computeSerializedSize;
        }

        public final VREvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        if (this.headMount == null) {
                            this.headMount = new VrBaseOuterClass.VrBase.HeadMount();
                        }
                        codedInputByteBufferNano.readMessage(this.headMount);
                        continue;
                    case 18:
                        if (this.application == null) {
                            this.application = new Application();
                        }
                        codedInputByteBufferNano.readMessage(this.application);
                        continue;
                    case AndroidNCompat.N_SDK_LEVEL:
                        this.durationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                        continue;
                    case 34:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        int length = this.installedVrApplications == null ? 0 : this.installedVrApplications.length;
                        Application[] applicationArr = new Application[(repeatedFieldArrayLength + length)];
                        if (length != 0) {
                            System.arraycopy(this.installedVrApplications, 0, applicationArr, 0, length);
                        }
                        while (length < applicationArr.length - 1) {
                            applicationArr[length] = new Application();
                            codedInputByteBufferNano.readMessage(applicationArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        applicationArr[length] = new Application();
                        codedInputByteBufferNano.readMessage(applicationArr[length]);
                        this.installedVrApplications = applicationArr;
                        continue;
                    case 42:
                        if (this.cyclops == null) {
                            this.cyclops = new Cyclops();
                        }
                        codedInputByteBufferNano.readMessage(this.cyclops);
                        continue;
                    case DescriptorProtos.FileOptions.CompatibilityLevel.DEPRECATED_PROTO1_COMPATIBLE:
                        if (this.qrCodeScan == null) {
                            this.qrCodeScan = new QrCodeScan();
                        }
                        codedInputByteBufferNano.readMessage(this.qrCodeScan);
                        continue;
                    case 58:
                        this.cohort = codedInputByteBufferNano.readString();
                        continue;
                    case 64:
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.lifetimeCountBucket = Integer.valueOf(checkBucketOrThrow(codedInputByteBufferNano.readInt32()));
                            continue;
                        } catch (IllegalArgumentException e) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 74:
                        if (this.performanceStats == null) {
                            this.performanceStats = new PerformanceStats();
                        }
                        codedInputByteBufferNano.readMessage(this.performanceStats);
                        continue;
                    case 82:
                        if (this.sensorStats == null) {
                            this.sensorStats = new SensorStats();
                        }
                        codedInputByteBufferNano.readMessage(this.sensorStats);
                        continue;
                    case 90:
                        if (this.audioStats == null) {
                            this.audioStats = new AudioStats();
                        }
                        codedInputByteBufferNano.readMessage(this.audioStats);
                        continue;
                    case 98:
                        if (this.embedVrWidget == null) {
                            this.embedVrWidget = new EmbedVrWidget();
                        }
                        codedInputByteBufferNano.readMessage(this.embedVrWidget);
                        continue;
                    case 106:
                        if (this.vrCore == null) {
                            this.vrCore = new VrCore();
                        }
                        codedInputByteBufferNano.readMessage(this.vrCore);
                        continue;
                    case 114:
                        if (this.earthVr == null) {
                            this.earthVr = new EarthVr();
                        }
                        codedInputByteBufferNano.readMessage(this.earthVr);
                        continue;
                    case 122:
                        if (this.launcher == null) {
                            this.launcher = new Launcher();
                        }
                        codedInputByteBufferNano.readMessage(this.launcher);
                        continue;
                    case 130:
                        if (this.keyboard == null) {
                            this.keyboard = new Keyboard();
                        }
                        codedInputByteBufferNano.readMessage(this.keyboard);
                        continue;
                    case 138:
                        if (this.renderer == null) {
                            this.renderer = new Renderer();
                        }
                        codedInputByteBufferNano.readMessage(this.renderer);
                        continue;
                    case 146:
                        if (this.lullaby == null) {
                            this.lullaby = new Lullaby();
                        }
                        codedInputByteBufferNano.readMessage(this.lullaby);
                        continue;
                    case 154:
                        if (this.streetView == null) {
                            this.streetView = new StreetView();
                        }
                        codedInputByteBufferNano.readMessage(this.streetView);
                        continue;
                    case 162:
                        if (this.photos == null) {
                            this.photos = new Photos();
                        }
                        codedInputByteBufferNano.readMessage(this.photos);
                        continue;
                    case 170:
                        if (this.vrHome == null) {
                            this.vrHome = new VrHome();
                        }
                        codedInputByteBufferNano.readMessage(this.vrHome);
                        continue;
                    case 178:
                        if (this.sdkConfiguration == null) {
                            this.sdkConfiguration = new SdkConfigurationParams();
                        }
                        codedInputByteBufferNano.readMessage(this.sdkConfiguration);
                        continue;
                    case 186:
                        if (this.gConfigUpdate == null) {
                            this.gConfigUpdate = new GConfigUpdate();
                        }
                        codedInputByteBufferNano.readMessage(this.gConfigUpdate);
                        continue;
                    case 194:
                        if (this.jumpInspector == null) {
                            this.jumpInspector = new JumpInspector();
                        }
                        codedInputByteBufferNano.readMessage(this.jumpInspector);
                        continue;
                    case 202:
                        if (this.phoneAlignment == null) {
                            this.phoneAlignment = new PhoneAlignment();
                        }
                        codedInputByteBufferNano.readMessage(this.phoneAlignment);
                        continue;
                    case 210:
                        if (this.vrStreaming == null) {
                            this.vrStreaming = new VrStreaming();
                        }
                        codedInputByteBufferNano.readMessage(this.vrStreaming);
                        continue;
                    case 218:
                        if (this.expeditions == null) {
                            this.expeditions = new Expeditions();
                        }
                        codedInputByteBufferNano.readMessage(this.expeditions);
                        continue;
                    case 226:
                        if (this.headTracking == null) {
                            this.headTracking = new HeadTracking();
                        }
                        codedInputByteBufferNano.readMessage(this.headTracking);
                        continue;
                    case 234:
                        if (this.standaloneHeadset == null) {
                            this.standaloneHeadset = new StandaloneHeadset();
                        }
                        codedInputByteBufferNano.readMessage(this.standaloneHeadset);
                        continue;
                    case 240:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.eventSource = Integer.valueOf(checkEventSourceOrThrow(codedInputByteBufferNano.readInt32()));
                            continue;
                        } catch (IllegalArgumentException e2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        }
                    case 250:
                        if (this.eva == null) {
                            this.eva = new Eva();
                        }
                        codedInputByteBufferNano.readMessage(this.eva);
                        continue;
                    case 258:
                        if (this.loggingOptInState == null) {
                            this.loggingOptInState = new LoggingOptInState();
                        }
                        codedInputByteBufferNano.readMessage(this.loggingOptInState);
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

        public static VREvent parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (VREvent) MessageNano.mergeFrom(new VREvent(), bArr);
        }
    }
}
