package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p268y0.p271c.InterfaceCallableC4614m;
import p251g.p252a.p268y0.p273e.p277d.C5008s2;

/* compiled from: ObservableJust.java */
/* renamed from: g.a.y0.e.d.q1 */
/* loaded from: classes2.dex */
public final class C4997q1<T> extends AbstractC4469b0<T> implements InterfaceCallableC4614m<T> {

    /* renamed from: a */
    private final T f19326a;

    public C4997q1(T t) {
        this.f19326a = t;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceCallableC4614m, java.util.concurrent.Callable
    public T call() {
        return this.f19326a;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C5008s2.a aVar = new C5008s2.a(interfaceC4514i0, this.f19326a);
        interfaceC4514i0.onSubscribe(aVar);
        aVar.run();
    }
}
