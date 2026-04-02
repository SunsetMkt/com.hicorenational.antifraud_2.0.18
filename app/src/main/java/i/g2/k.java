package i.g2;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k<T> implements Collection<T>, i.q2.t.q1.a {

    @j.c.a.d
    private final T[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12089b;

    public k(@j.c.a.d T[] tArr, boolean z) {
        i.q2.t.i0.f(tArr, "values");
        this.a = tArr;
        this.f12089b = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b() {
        return this.a.length;
    }

    @j.c.a.d
    public final T[] c() {
        return this.a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return r.b((Object[]) this.a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@j.c.a.d Collection<? extends Object> collection) {
        i.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        return this.f12089b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @j.c.a.d
    public Iterator<T> iterator() {
        return i.q2.t.h.a(this.a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection
    @j.c.a.d
    public final Object[] toArray() {
        return x.a(this.a, this.f12089b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) i.q2.t.u.a(this, tArr);
    }
}
