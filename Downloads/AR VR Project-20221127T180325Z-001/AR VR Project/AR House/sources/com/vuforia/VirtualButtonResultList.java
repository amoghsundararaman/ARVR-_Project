package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VirtualButtonResultList implements Cloneable, Iterable<VirtualButtonResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VirtualButtonResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButtonResultList virtualButtonResultList) {
        if (virtualButtonResultList == null) {
            return 0;
        }
        return virtualButtonResultList.swigCPtr;
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
                VuforiaJNI.delete_VirtualButtonResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public VirtualButtonResultList clone() {
        return new VirtualButtonResultList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VirtualButtonResultList) || ((VirtualButtonResultList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<VirtualButtonResult> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<VirtualButtonResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = VirtualButtonResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public VirtualButtonResult next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return VirtualButtonResultList.this.mo836at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public VirtualButtonResultList(VirtualButtonResultList virtualButtonResultList) {
        this(VuforiaJNI.new_VirtualButtonResultList(getCPtr(virtualButtonResultList), virtualButtonResultList), true);
    }

    /* renamed from: at */
    public VirtualButtonResult mo836at(int i) {
        long VirtualButtonResultList_at = VuforiaJNI.VirtualButtonResultList_at(this.swigCPtr, this, i);
        if (VirtualButtonResultList_at == 0) {
            return null;
        }
        return new VirtualButtonResult(VirtualButtonResultList_at, false);
    }

    public int size() {
        return VuforiaJNI.VirtualButtonResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.VirtualButtonResultList_empty(this.swigCPtr, this);
    }
}
