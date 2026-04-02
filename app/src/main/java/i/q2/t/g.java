package i.q2.t;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g<T> implements Iterator<T>, i.q2.t.q1.a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private final T[] f12206b;

    public g(@j.c.a.d T[] tArr) {
        i0.f(tArr, "array");
        this.f12206b = tArr;
    }

    @j.c.a.d
    public final T[] b() {
        return this.f12206b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12206b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f12206b;
            int i2 = this.a;
            this.a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
