package com.vuforia;

public class GLTextureUnit extends TextureUnit {
    private long swigCPtr;

    protected GLTextureUnit(long j, boolean z) {
        super(VuforiaJNI.GLTextureUnit_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(GLTextureUnit gLTextureUnit) {
        if (gLTextureUnit == null) {
            return 0;
        }
        return gLTextureUnit.swigCPtr;
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
                VuforiaJNI.delete_GLTextureUnit(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GLTextureUnit) || ((GLTextureUnit) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public GLTextureUnit(int i) {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_0(i), true);
    }

    public GLTextureUnit() {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_1(), true);
    }

    public void setTextureUnit(int i) {
        VuforiaJNI.GLTextureUnit_TextureUnit_set(this.swigCPtr, this, i);
    }

    public int getTextureUnit() {
        return VuforiaJNI.GLTextureUnit_TextureUnit_get(this.swigCPtr, this);
    }
}
