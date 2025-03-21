package p286h.p289g2;

import java.util.List;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ReversedViews.kt */
/* renamed from: h.g2.h1 */
/* loaded from: classes2.dex */
final class C5266h1<T> extends AbstractC5261g<T> {

    /* renamed from: a */
    private final List<T> f20125a;

    public C5266h1(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "delegate");
        this.f20125a = list;
    }

    @Override // p286h.p289g2.AbstractC5261g
    /* renamed from: a */
    public int mo19740a() {
        return this.f20125a.size();
    }

    @Override // p286h.p289g2.AbstractC5261g, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        int m19729d;
        List<T> list = this.f20125a;
        m19729d = C5256e0.m19729d((List<?>) this, i2);
        list.add(m19729d, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f20125a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        int m19728c;
        List<T> list = this.f20125a;
        m19728c = C5256e0.m19728c((List<?>) this, i2);
        return list.get(m19728c);
    }

    @Override // p286h.p289g2.AbstractC5261g, java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        int m19728c;
        List<T> list = this.f20125a;
        m19728c = C5256e0.m19728c((List<?>) this, i2);
        return list.set(m19728c, t);
    }

    @Override // p286h.p289g2.AbstractC5261g
    /* renamed from: a */
    public T mo19741a(int i2) {
        int m19728c;
        List<T> list = this.f20125a;
        m19728c = C5256e0.m19728c((List<?>) this, i2);
        return list.remove(m19728c);
    }
}
