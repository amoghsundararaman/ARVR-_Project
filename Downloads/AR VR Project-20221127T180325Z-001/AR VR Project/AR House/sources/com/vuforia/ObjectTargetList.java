package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectTargetList implements Cloneable, Iterable<ObjectTarget> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ObjectTargetList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ObjectTargetList objectTargetList) {
        if (objectTargetList == null) {
            return 0;
        }
        return objectTargetList.swigCPtr;
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
                VuforiaJNI.delete_ObjectTargetList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ObjectTargetList clone() {
        return new ObjectTargetList(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectTargetList) || ((ObjectTargetList) obj).swigCPtr != this.swigCPtr) {
            return false;
        }
        return true;
    }

    public Iterator<ObjectTarget> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<ObjectTarget> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = ObjectTargetList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public ObjectTarget next() throws NoSuchElementException {
            int i = this.cur;
            if (i < this.end) {
                this.cur = i + 1;
                return ObjectTargetList.this.mo567at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    public ObjectTargetList(ObjectTargetList objectTargetList) {
        this(VuforiaJNI.new_ObjectTargetList(getCPtr(objectTargetList), objectTargetList), true);
    }

    /* renamed from: at */
    public ObjectTarget mo567at(int i) {
        long ObjectTargetList_at = VuforiaJNI.ObjectTargetList_at(this.swigCPtr, this, i);
        if (ObjectTargetList_at == 0) {
            return null;
        }
        ObjectTarget objectTarget = new ObjectTarget(ObjectTargetList_at, false);
        if (objectTarget.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(ObjectTargetList_at, false);
        }
        return null;
    }

    public int size() {
        return VuforiaJNI.ObjectTargetList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.ObjectTargetList_empty(this.swigCPtr, this);
    }
}
