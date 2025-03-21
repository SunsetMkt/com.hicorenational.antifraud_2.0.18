package p286h.p289g2;

import java.util.Collection;
import java.util.Iterator;
import p286h.p309q2.p311t.C5540h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Collections.kt */
/* renamed from: h.g2.k */
/* loaded from: classes2.dex */
final class C5273k<T> implements Collection<T>, InterfaceC5569a {

    /* renamed from: a */
    @InterfaceC5816d
    private final T[] f20136a;

    /* renamed from: b */
    private final boolean f20137b;

    public C5273k(@InterfaceC5816d T[] tArr, boolean z) {
        C5544i0.m22546f(tArr, "values");
        this.f20136a = tArr;
        this.f20137b = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public int m19977b() {
        return this.f20136a.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final T[] m19978c() {
        return this.f20136a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return C5294r.m20997b((Object[]) this.f20136a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection<? extends Object> collection) {
        C5544i0.m22546f(collection, "elements");
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

    /* renamed from: d */
    public final boolean m19979d() {
        return this.f20137b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f20136a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return C5540h.m22477a(this.f20136a);
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
        return m19977b();
    }

    @Override // java.util.Collection
    @InterfaceC5816d
    public final Object[] toArray() {
        return C5312x.m21754a(this.f20136a, this.f20137b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C5584u.m22688a(this, tArr);
    }
}
