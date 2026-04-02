package i.g2;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t0<T> implements Iterator<r0<? extends T>>, i.q2.t.q1.a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterator<T> f12100b;

    /* JADX WARN: Multi-variable type inference failed */
    public t0(@j.c.a.d Iterator<? extends T> it) {
        i.q2.t.i0.f(it, "iterator");
        this.f12100b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12100b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @j.c.a.d
    public final r0<T> next() {
        int i2 = this.a;
        this.a = i2 + 1;
        if (i2 < 0) {
            y.f();
        }
        return new r0<>(i2, this.f12100b.next());
    }
}
