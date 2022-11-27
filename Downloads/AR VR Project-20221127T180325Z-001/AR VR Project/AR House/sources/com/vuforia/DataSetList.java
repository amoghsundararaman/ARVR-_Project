package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataSetList implements Cloneable, Iterable<DataSet> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DataSetList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DataSetList dataSetList) {
        if (dataSetList == null) {
            return 0;
        }
        return dataSetList.swigCPtr;
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
                VuforiaJNI.delete_DataSetList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DataSetList clone() {
        return new DataSetList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataSetList) || ((DataSetList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<DataSet> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<DataSet> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = DataSetList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public DataSet next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return DataSetList.this.mo362at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public DataSetList(DataSetList dataSetList) {
        this(VuforiaJNI.new_DataSetList(getCPtr(dataSetList), dataSetList), true);
    }

    /* renamed from: at */
    public DataSet mo362at(int i) {
        long DataSetList_at = VuforiaJNI.DataSetList_at(this.swigCPtr, this, i);
        if (DataSetList_at == 0) {
            return null;
        }
        return new DataSet(DataSetList_at, false);
    }

    public int size() {
        return VuforiaJNI.DataSetList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.DataSetList_empty(this.swigCPtr, this);
    }
}
