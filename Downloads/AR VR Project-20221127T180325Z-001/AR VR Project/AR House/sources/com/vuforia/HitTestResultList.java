package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HitTestResultList implements Cloneable, Iterable<HitTestResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected HitTestResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(HitTestResultList hitTestResultList) {
        if (hitTestResultList == null) {
            return 0;
        }
        return hitTestResultList.swigCPtr;
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
                VuforiaJNI.delete_HitTestResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public HitTestResultList clone() {
        return new HitTestResultList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HitTestResultList) || ((HitTestResultList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<HitTestResult> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<HitTestResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = HitTestResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public HitTestResult next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return HitTestResultList.this.mo455at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public HitTestResultList(HitTestResultList hitTestResultList) {
        this(VuforiaJNI.new_HitTestResultList(getCPtr(hitTestResultList), hitTestResultList), true);
    }

    /* renamed from: at */
    public HitTestResult mo455at(int i) {
        long HitTestResultList_at = VuforiaJNI.HitTestResultList_at(this.swigCPtr, this, i);
        if (HitTestResultList_at == 0) {
            return null;
        }
        return new HitTestResult(HitTestResultList_at, false);
    }

    public int size() {
        return VuforiaJNI.HitTestResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.HitTestResultList_empty(this.swigCPtr, this);
    }
}
