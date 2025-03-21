package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    /* renamed from: gc */
    private void m383gc() {
        int i2 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != DELETED) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.mGarbage = false;
        this.mSize = i3;
    }

    public void append(long j2, E e2) {
        int i2 = this.mSize;
        if (i2 != 0 && j2 <= this.mKeys[i2 - 1]) {
            put(j2, e2);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m383gc();
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i3] = j2;
        this.mValues[i3] = e2;
        this.mSize = i3 + 1;
    }

    public void clear() {
        int i2 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(long j2) {
        return indexOfKey(j2) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(long j2) {
        remove(j2);
    }

    @Nullable
    public E get(long j2) {
        return get(j2, null);
    }

    public int indexOfKey(long j2) {
        if (this.mGarbage) {
            m383gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
    }

    public int indexOfValue(E e2) {
        if (this.mGarbage) {
            m383gc();
        }
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (this.mValues[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i2) {
        if (this.mGarbage) {
            m383gc();
        }
        return this.mKeys[i2];
    }

    public void put(long j2, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e2;
            return;
        }
        int i2 = ~binarySearch;
        if (i2 < this.mSize) {
            Object[] objArr = this.mValues;
            if (objArr[i2] == DELETED) {
                this.mKeys[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m383gc();
            i2 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.mKeys;
            int i5 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i2, objArr4, i5, this.mSize - i2);
        }
        this.mKeys[i2] = j2;
        this.mValues[i2] = e2;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
        }
    }

    @Nullable
    public E putIfAbsent(long j2, E e2) {
        E e3 = get(j2);
        if (e3 == null) {
            put(j2, e2);
        }
        return e3;
    }

    public void remove(long j2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void removeAt(int i2) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i2];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j2, E e2) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.mValues;
        E e3 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e2;
        return e3;
    }

    public void setValueAt(int i2, E e2) {
        if (this.mGarbage) {
            m383gc();
        }
        this.mValues[i2] = e2;
    }

    public int size() {
        if (this.mGarbage) {
            m383gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i2) {
        if (this.mGarbage) {
            m383gc();
        }
        return (E) this.mValues[i2];
    }

    public LongSparseArray(int i2) {
        this.mGarbage = false;
        if (i2 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2);
            this.mKeys = new long[idealLongArraySize];
            this.mValues = new Object[idealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m26842clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(long j2, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[binarySearch] != DELETED) {
                return (E) objArr[binarySearch];
            }
        }
        return e2;
    }

    public boolean replace(long j2, E e2, E e3) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey < 0) {
            return false;
        }
        Object obj = this.mValues[indexOfKey];
        if (obj != e2 && (e2 == null || !e2.equals(obj))) {
            return false;
        }
        this.mValues[indexOfKey] = e3;
        return true;
    }

    public boolean remove(long j2, Object obj) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey < 0) {
            return false;
        }
        E valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
