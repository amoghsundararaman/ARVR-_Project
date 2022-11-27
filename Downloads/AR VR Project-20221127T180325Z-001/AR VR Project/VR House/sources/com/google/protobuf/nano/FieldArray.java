package com.google.protobuf.nano;

public final class FieldArray implements Cloneable {
    private static final FieldData DELETED = new FieldData();
    private FieldData[] mData;
    private int[] mFieldNumbers;
    private boolean mGarbage;
    private int mSize;

    FieldArray() {
        this(10);
    }

    FieldArray(int i) {
        this.mGarbage = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.mFieldNumbers = new int[idealIntArraySize];
        this.mData = new FieldData[idealIntArraySize];
        this.mSize = 0;
    }

    private final boolean arrayEquals(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private final boolean arrayEquals(FieldData[] fieldDataArr, FieldData[] fieldDataArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!fieldDataArr[i2].equals(fieldDataArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private final int binarySearch(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.mFieldNumbers[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    /* renamed from: gc */
    private final void m2gc() {
        int i = this.mSize;
        int[] iArr = this.mFieldNumbers;
        FieldData[] fieldDataArr = this.mData;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            FieldData fieldData = fieldDataArr[i3];
            if (fieldData != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    fieldDataArr[i2] = fieldData;
                    fieldDataArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    private final int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private final int idealIntArraySize(int i) {
        return idealByteArraySize(i << 2) / 4;
    }

    public final FieldArray clone() {
        int size = size();
        FieldArray fieldArray = new FieldArray(size);
        System.arraycopy(this.mFieldNumbers, 0, fieldArray.mFieldNumbers, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.mData[i] != null) {
                fieldArray.mData[i] = this.mData[i].clone();
            }
        }
        fieldArray.mSize = size;
        return fieldArray;
    }

    /* access modifiers changed from: package-private */
    public final FieldData dataAt(int i) {
        if (this.mGarbage) {
            m2gc();
        }
        return this.mData[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldArray)) {
            return false;
        }
        FieldArray fieldArray = (FieldArray) obj;
        if (size() != fieldArray.size()) {
            return false;
        }
        return arrayEquals(this.mFieldNumbers, fieldArray.mFieldNumbers, this.mSize) && arrayEquals(this.mData, fieldArray.mData, this.mSize);
    }

    /* access modifiers changed from: package-private */
    public final FieldData get(int i) {
        int binarySearch = binarySearch(i);
        if (binarySearch < 0 || this.mData[binarySearch] == DELETED) {
            return null;
        }
        return this.mData[binarySearch];
    }

    public final int getFieldNumberAt(int i) {
        return this.mFieldNumbers[i];
    }

    public final int getFieldNumbersSize() {
        return this.mFieldNumbers.length;
    }

    public final int hashCode() {
        if (this.mGarbage) {
            m2gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.mFieldNumbers[i2]) * 31) + this.mData[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public final void put(int i, FieldData fieldData) {
        int binarySearch = binarySearch(i);
        if (binarySearch >= 0) {
            this.mData[binarySearch] = fieldData;
            return;
        }
        int i2 = binarySearch ^ -1;
        if (i2 >= this.mSize || this.mData[i2] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mFieldNumbers.length) {
                m2gc();
                i2 = binarySearch(i) ^ -1;
            }
            if (this.mSize >= this.mFieldNumbers.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                FieldData[] fieldDataArr = new FieldData[idealIntArraySize];
                System.arraycopy(this.mFieldNumbers, 0, iArr, 0, this.mFieldNumbers.length);
                System.arraycopy(this.mData, 0, fieldDataArr, 0, this.mData.length);
                this.mFieldNumbers = iArr;
                this.mData = fieldDataArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.mFieldNumbers, i2, this.mFieldNumbers, i2 + 1, this.mSize - i2);
                System.arraycopy(this.mData, i2, this.mData, i2 + 1, this.mSize - i2);
            }
            this.mFieldNumbers[i2] = i;
            this.mData[i2] = fieldData;
            this.mSize++;
            return;
        }
        this.mFieldNumbers[i2] = i;
        this.mData[i2] = fieldData;
    }

    /* access modifiers changed from: package-private */
    public final void remove(int i) {
        int binarySearch = binarySearch(i);
        if (binarySearch >= 0 && this.mData[binarySearch] != DELETED) {
            this.mData[binarySearch] = DELETED;
            this.mGarbage = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        if (this.mGarbage) {
            m2gc();
        }
        return this.mSize;
    }
}
