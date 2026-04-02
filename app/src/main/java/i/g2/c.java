package i.g2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements Iterator<T>, i.q2.t.q1.a {
    private q1 a = q1.NotReady;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f12071b;

    private final boolean d() {
        this.a = q1.Failed;
        b();
        return this.a == q1.Ready;
    }

    protected abstract void b();

    protected final void b(T t) {
        this.f12071b = t;
        this.a = q1.Ready;
    }

    protected final void c() {
        this.a = q1.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!(this.a != q1.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = b.a[this.a.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = q1.NotReady;
        return this.f12071b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
