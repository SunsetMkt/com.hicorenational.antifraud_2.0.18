package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p268y0.p273e.p275b.C4810u3;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableTakePublisher.java */
/* renamed from: g.a.y0.e.b.y3 */
/* loaded from: classes2.dex */
public final class C4830y3<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC5821b<T> f18530b;

    /* renamed from: c */
    final long f18531c;

    public C4830y3(InterfaceC5821b<T> interfaceC5821b, long j2) {
        this.f18530b = interfaceC5821b;
        this.f18531c = j2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f18530b.subscribe(new C4810u3.a(interfaceC5822c, this.f18531c));
    }
}
