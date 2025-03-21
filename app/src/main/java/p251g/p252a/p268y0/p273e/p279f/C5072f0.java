package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p264u0.C4553d;

/* compiled from: SingleJust.java */
/* renamed from: g.a.y0.e.f.f0 */
/* loaded from: classes2.dex */
public final class C5072f0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final T f19707a;

    public C5072f0(T t) {
        this.f19707a = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        interfaceC4524n0.onSubscribe(C4553d.m18183a());
        interfaceC4524n0.onSuccess(this.f19707a);
    }
}
