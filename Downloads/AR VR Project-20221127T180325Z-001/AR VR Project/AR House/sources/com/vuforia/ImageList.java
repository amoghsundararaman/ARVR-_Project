package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImageList implements Cloneable, Iterable<Image> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ImageList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageList imageList) {
        if (imageList == null) {
            return 0;
        }
        return imageList.swigCPtr;
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
                VuforiaJNI.delete_ImageList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ImageList clone() {
        return new ImageList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageList) || ((ImageList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<Image> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Image> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = ImageList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public Image next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return ImageList.this.mo482at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public ImageList(ImageList imageList) {
        this(VuforiaJNI.new_ImageList(getCPtr(imageList), imageList), true);
    }

    /* renamed from: at */
    public Image mo482at(int i) {
        long ImageList_at = VuforiaJNI.ImageList_at(this.swigCPtr, this, i);
        if (ImageList_at == 0) {
            return null;
        }
        return new Image(ImageList_at, false);
    }

    public int size() {
        return VuforiaJNI.ImageList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.ImageList_empty(this.swigCPtr, this);
    }
}
