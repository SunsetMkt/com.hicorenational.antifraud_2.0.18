package p286h.p289g2;

import java.util.Iterator;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Iterables.kt */
/* renamed from: h.g2.s0 */
/* loaded from: classes2.dex */
public final class C5298s0<T> implements Iterable<C5295r0<? extends T>>, InterfaceC5569a {

    /* renamed from: a */
    private final InterfaceC5495a<Iterator<T>> f20181a;

    /* JADX WARN: Multi-variable type inference failed */
    public C5298s0(@InterfaceC5816d InterfaceC5495a<? extends Iterator<? extends T>> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "iteratorFactory");
        this.f20181a = interfaceC5495a;
    }

    @Override // java.lang.Iterable
    @InterfaceC5816d
    public Iterator<C5295r0<T>> iterator() {
        return new C5301t0(this.f20181a.invoke());
    }
}
