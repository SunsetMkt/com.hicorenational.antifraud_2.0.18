package p286h.p289g2;

import java.util.Iterator;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Iterators.kt */
/* renamed from: h.g2.t0 */
/* loaded from: classes2.dex */
public final class C5301t0<T> implements Iterator<C5295r0<? extends T>>, InterfaceC5569a {

    /* renamed from: a */
    private int f20182a;

    /* renamed from: b */
    private final Iterator<T> f20183b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5301t0(@InterfaceC5816d Iterator<? extends T> it) {
        C5544i0.m22546f(it, "iterator");
        this.f20183b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f20183b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @InterfaceC5816d
    public final C5295r0<T> next() {
        int i2 = this.f20182a;
        this.f20182a = i2 + 1;
        if (i2 < 0) {
            C5315y.m21790f();
        }
        return new C5295r0<>(i2, this.f20183b.next());
    }
}
