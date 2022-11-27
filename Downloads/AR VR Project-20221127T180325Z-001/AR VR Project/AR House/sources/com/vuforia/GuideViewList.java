package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GuideViewList implements Cloneable, Iterable<GuideView> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected GuideViewList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GuideViewList guideViewList) {
        if (guideViewList == null) {
            return 0;
        }
        return guideViewList.swigCPtr;
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
                VuforiaJNI.delete_GuideViewList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public GuideViewList clone() {
        return new GuideViewList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GuideViewList) || ((GuideViewList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<GuideView> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<GuideView> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = GuideViewList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public GuideView next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return GuideViewList.this.mo432at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public GuideViewList(GuideViewList guideViewList) {
        this(VuforiaJNI.new_GuideViewList(getCPtr(guideViewList), guideViewList), true);
    }

    /* renamed from: at */
    public GuideView mo432at(int i) {
        long GuideViewList_at = VuforiaJNI.GuideViewList_at(this.swigCPtr, this, i);
        if (GuideViewList_at == 0) {
            return null;
        }
        return new GuideView(GuideViewList_at, false);
    }

    public int size() {
        return VuforiaJNI.GuideViewList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.GuideViewList_empty(this.swigCPtr, this);
    }
}
