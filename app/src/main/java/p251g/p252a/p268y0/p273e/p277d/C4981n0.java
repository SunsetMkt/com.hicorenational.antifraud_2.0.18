package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p272d.C4632n;

/* compiled from: ObservableDoOnLifecycle.java */
/* renamed from: g.a.y0.e.d.n0 */
/* loaded from: classes2.dex */
public final class C4981n0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    private final InterfaceC4576g<? super InterfaceC4552c> f19210b;

    /* renamed from: c */
    private final InterfaceC4570a f19211c;

    public C4981n0(AbstractC4469b0<T> abstractC4469b0, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        super(abstractC4469b0);
        this.f19210b = interfaceC4576g;
        this.f19211c = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new C4632n(interfaceC4514i0, this.f19210b, this.f19211c));
    }
}
