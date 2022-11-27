package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TargetSearchResultList implements Cloneable, Iterable<TargetSearchResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TargetSearchResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetSearchResultList targetSearchResultList) {
        if (targetSearchResultList == null) {
            return 0;
        }
        return targetSearchResultList.swigCPtr;
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
                VuforiaJNI.delete_TargetSearchResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TargetSearchResultList clone() {
        return new TargetSearchResultList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TargetSearchResultList) || ((TargetSearchResultList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<TargetSearchResult> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<TargetSearchResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = TargetSearchResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public TargetSearchResult next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return TargetSearchResultList.this.mo680at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public TargetSearchResultList(TargetSearchResultList targetSearchResultList) {
        this(VuforiaJNI.new_TargetSearchResultList(getCPtr(targetSearchResultList), targetSearchResultList), true);
    }

    /* renamed from: at */
    public TargetSearchResult mo680at(int i) {
        long TargetSearchResultList_at = VuforiaJNI.TargetSearchResultList_at(this.swigCPtr, this, i);
        if (TargetSearchResultList_at != 0 && new TargetSearchResult(TargetSearchResultList_at, false).isOfType(CloudRecoSearchResult.getClassType())) {
            return new CloudRecoSearchResult(TargetSearchResultList_at, false);
        }
        return null;
    }

    public int size() {
        return VuforiaJNI.TargetSearchResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.TargetSearchResultList_empty(this.swigCPtr, this);
    }
}
