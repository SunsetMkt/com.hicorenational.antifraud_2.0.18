package h.g2;

import java.util.List;

/* compiled from: ReversedViews.kt */
/* loaded from: classes2.dex */
final class h1<T> extends g<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<T> f16139a;

    public h1(@i.c.a.d List<T> list) {
        h.q2.t.i0.f(list, "delegate");
        this.f16139a = list;
    }

    @Override // h.g2.g
    public int a() {
        return this.f16139a.size();
    }

    @Override // h.g2.g, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        int d2;
        List<T> list = this.f16139a;
        d2 = e0.d((List<?>) this, i2);
        list.add(d2, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f16139a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        int c2;
        List<T> list = this.f16139a;
        c2 = e0.c((List<?>) this, i2);
        return list.get(c2);
    }

    @Override // h.g2.g, java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        int c2;
        List<T> list = this.f16139a;
        c2 = e0.c((List<?>) this, i2);
        return list.set(c2, t);
    }

    @Override // h.g2.g
    public T a(int i2) {
        int c2;
        List<T> list = this.f16139a;
        c2 = e0.c((List<?>) this, i2);
        return list.remove(c2);
    }
}
