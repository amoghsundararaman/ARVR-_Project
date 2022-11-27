package com.vuforia;

public class SmartTerrain extends Tracker {
    private long swigCPtr;

    public static final class HITTEST_HINT {
        public static final int HITTEST_HINT_HORIZONTAL_PLANE = 1;
        public static final int HITTEST_HINT_NONE = 0;
        public static final int HITTEST_HINT_VERTICAL_PLANE = 2;
    }

    protected SmartTerrain(long j, boolean z) {
        super(VuforiaJNI.SmartTerrain_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(SmartTerrain smartTerrain) {
        if (smartTerrain == null) {
            return 0;
        }
        return smartTerrain.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    /* access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_SmartTerrain(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SmartTerrain) || ((SmartTerrain) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrain_getClassType(), true);
    }

    public HitTestResultList hitTest(Vec2F vec2F, int i, State state, float f) {
        return new HitTestResultList(VuforiaJNI.SmartTerrain_hitTest(this.swigCPtr, this, Vec2F.getCPtr(vec2F), vec2F, i, State.getCPtr(state), state, f), true);
    }
}
