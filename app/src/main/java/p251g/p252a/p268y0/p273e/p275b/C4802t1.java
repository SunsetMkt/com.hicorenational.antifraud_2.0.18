package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p268y0.p271c.InterfaceCallableC4614m;
import p251g.p252a.p268y0.p283i.C5158h;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableJust.java */
/* renamed from: g.a.y0.e.b.t1 */
/* loaded from: classes2.dex */
public final class C4802t1<T> extends AbstractC4519l<T> implements InterfaceCallableC4614m<T> {

    /* renamed from: b */
    private final T f18413b;

    public C4802t1(T t) {
        this.f18413b = t;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceCallableC4614m, java.util.concurrent.Callable
    public T call() {
        return this.f18413b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        interfaceC5822c.onSubscribe(new C5158h(interfaceC5822c, this.f18413b));
    }
}
