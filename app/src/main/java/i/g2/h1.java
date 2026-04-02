package i.g2;

import java.util.List;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes2.dex */
final class h1<T> extends g<T> {
    private final List<T> a;

    public h1(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "delegate");
        this.a = list;
    }

    @Override // i.g2.g
    public int a() {
        return this.a.size();
    }

    @Override // i.g2.g, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        this.a.add(e0.d((List<?>) this, i2), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.a.get(e0.c((List<?>) this, i2));
    }

    @Override // i.g2.g, java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        return this.a.set(e0.c((List<?>) this, i2), t);
    }

    @Override // i.g2.g
    public T a(int i2) {
        return this.a.remove(e0.c((List<?>) this, i2));
    }
}
