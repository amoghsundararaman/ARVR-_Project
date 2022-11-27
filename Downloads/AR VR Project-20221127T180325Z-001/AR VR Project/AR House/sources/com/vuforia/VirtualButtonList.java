package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VirtualButtonList implements Cloneable, Iterable<VirtualButton> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VirtualButtonList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButtonList virtualButtonList) {
        if (virtualButtonList == null) {
            return 0;
        }
        return virtualButtonList.swigCPtr;
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
                VuforiaJNI.delete_VirtualButtonList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public VirtualButtonList clone() {
        return new VirtualButtonList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VirtualButtonList) || ((VirtualButtonList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<VirtualButton> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<VirtualButton> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = VirtualButtonList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public VirtualButton next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return VirtualButtonList.this.mo821at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public VirtualButtonList(VirtualButtonList virtualButtonList) {
        this(VuforiaJNI.new_VirtualButtonList(getCPtr(virtualButtonList), virtualButtonList), true);
    }

    /* renamed from: at */
    public VirtualButton mo821at(int i) {
        long VirtualButtonList_at = VuforiaJNI.VirtualButtonList_at(this.swigCPtr, this, i);
        if (VirtualButtonList_at == 0) {
            return null;
        }
        return new VirtualButton(VirtualButtonList_at, false);
    }

    public int size() {
        return VuforiaJNI.VirtualButtonList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.VirtualButtonList_empty(this.swigCPtr, this);
    }
}
