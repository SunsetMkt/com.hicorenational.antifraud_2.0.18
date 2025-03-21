package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFromPublisher.java */
/* renamed from: g.a.y0.e.b.i1 */
/* loaded from: classes2.dex */
public final class C4736i1<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC5821b<? extends T> f17956b;

    public C4736i1(InterfaceC5821b<? extends T> interfaceC5821b) {
        this.f17956b = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17956b.subscribe(interfaceC5822c);
    }
}
