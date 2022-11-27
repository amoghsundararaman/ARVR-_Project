package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TrackableList implements Cloneable, Iterable<Trackable> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TrackableList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrackableList trackableList) {
        if (trackableList == null) {
            return 0;
        }
        return trackableList.swigCPtr;
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
                VuforiaJNI.delete_TrackableList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TrackableList clone() {
        return new TrackableList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TrackableList) || ((TrackableList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<Trackable> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Trackable> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = TrackableList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public Trackable next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return TrackableList.this.mo702at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public TrackableList(TrackableList trackableList) {
        this(VuforiaJNI.new_TrackableList(getCPtr(trackableList), trackableList), true);
    }

    /* renamed from: at */
    public Trackable mo702at(int i) {
        long TrackableList_at = VuforiaJNI.TrackableList_at(this.swigCPtr, this, i);
        if (TrackableList_at == 0) {
            return null;
        }
        Trackable trackable = new Trackable(TrackableList_at, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(TrackableList_at, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(TrackableList_at, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(TrackableList_at, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(TrackableList_at, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(TrackableList_at, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(TrackableList_at, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(TrackableList_at, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(TrackableList_at, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(TrackableList_at, false);
        }
        return null;
    }

    public int size() {
        return VuforiaJNI.TrackableList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.TrackableList_empty(this.swigCPtr, this);
    }
}
