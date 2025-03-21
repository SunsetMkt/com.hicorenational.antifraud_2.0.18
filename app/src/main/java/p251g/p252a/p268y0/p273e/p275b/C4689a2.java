package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p273e.p275b.C4828y1;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableMapPublisher.java */
/* renamed from: g.a.y0.e.b.a2 */
/* loaded from: classes2.dex */
public final class C4689a2<T, U> extends AbstractC4519l<U> {

    /* renamed from: b */
    final InterfaceC5821b<T> f17766b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends U> f17767c;

    public C4689a2(InterfaceC5821b<T> interfaceC5821b, InterfaceC4584o<? super T, ? extends U> interfaceC4584o) {
        this.f17766b = interfaceC5821b;
        this.f17767c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        this.f17766b.subscribe(new C4828y1.b(interfaceC5822c, this.f17767c));
    }
}
