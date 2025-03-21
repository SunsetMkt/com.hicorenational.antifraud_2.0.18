package p286h.p309q2.p311t;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterator.kt */
/* renamed from: h.q2.t.g */
/* loaded from: classes2.dex */
final class C5537g<T> implements Iterator<T>, InterfaceC5569a {

    /* renamed from: a */
    private int f20370a;

    /* renamed from: b */
    @InterfaceC5816d
    private final T[] f20371b;

    public C5537g(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "array");
        this.f20371b = tArr;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final T[] m22476b() {
        return this.f20371b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20370a < this.f20371b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f20371b;
            int i2 = this.f20370a;
            this.f20370a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20370a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
