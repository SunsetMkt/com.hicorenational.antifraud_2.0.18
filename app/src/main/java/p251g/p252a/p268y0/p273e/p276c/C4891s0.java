package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p268y0.p271c.InterfaceCallableC4614m;

/* compiled from: MaybeJust.java */
/* renamed from: g.a.y0.e.c.s0 */
/* loaded from: classes2.dex */
public final class C4891s0<T> extends AbstractC4533s<T> implements InterfaceCallableC4614m<T> {

    /* renamed from: a */
    final T f18703a;

    public C4891s0(T t) {
        this.f18703a = t;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        interfaceC4559v.onSubscribe(C4553d.m18183a());
        interfaceC4559v.onSuccess(this.f18703a);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceCallableC4614m, java.util.concurrent.Callable
    public T call() {
        return this.f18703a;
    }
}
