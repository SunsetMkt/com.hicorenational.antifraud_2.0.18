package p286h.p289g2;

import java.util.List;
import java.util.RandomAccess;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SlidingWindow.kt */
/* renamed from: h.g2.e1 */
/* loaded from: classes2.dex */
public final class C5257e1<E> extends AbstractC5252d<E> implements RandomAccess {

    /* renamed from: a */
    private int f20117a;

    /* renamed from: b */
    private int f20118b;

    /* renamed from: c */
    private final List<E> f20119c;

    /* JADX WARN: Multi-variable type inference failed */
    public C5257e1(@InterfaceC5816d List<? extends E> list) {
        C5544i0.m22546f(list, "list");
        this.f20119c = list;
    }

    /* renamed from: a */
    public final void m19732a(int i2, int i3) {
        AbstractC5252d.Companion.m19655b(i2, i3, this.f20119c.size());
        this.f20117a = i2;
        this.f20118b = i3 - i2;
    }

    @Override // p286h.p289g2.AbstractC5252d, java.util.List
    public E get(int i2) {
        AbstractC5252d.Companion.m19651a(i2, this.f20118b);
        return this.f20119c.get(this.f20117a + i2);
    }

    @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
    public int getSize() {
        return this.f20118b;
    }
}
