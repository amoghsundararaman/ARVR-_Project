package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AnchorList implements Cloneable, Iterable<Anchor> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected AnchorList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AnchorList anchorList) {
        if (anchorList == null) {
            return 0;
        }
        return anchorList.swigCPtr;
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
                VuforiaJNI.delete_AnchorList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public AnchorList clone() {
        return new AnchorList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnchorList) || ((AnchorList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<Anchor> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Anchor> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = AnchorList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public Anchor next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return AnchorList.this.mo277at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public AnchorList(AnchorList anchorList) {
        this(VuforiaJNI.new_AnchorList(getCPtr(anchorList), anchorList), true);
    }

    /* renamed from: at */
    public Anchor mo277at(int i) {
        long AnchorList_at = VuforiaJNI.AnchorList_at(this.swigCPtr, this, i);
        if (AnchorList_at == 0) {
            return null;
        }
        return new Anchor(AnchorList_at, false);
    }

    public int size() {
        return VuforiaJNI.AnchorList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.AnchorList_empty(this.swigCPtr, this);
    }
}
