package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p267x0.InterfaceC4584o;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFlatMapPublisher.java */
/* renamed from: g.a.y0.e.b.a1 */
/* loaded from: classes2.dex */
public final class C4688a1<T, U> extends AbstractC4519l<U> {

    /* renamed from: b */
    final InterfaceC5821b<T> f17761b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> f17762c;

    /* renamed from: d */
    final boolean f17763d;

    /* renamed from: e */
    final int f17764e;

    /* renamed from: f */
    final int f17765f;

    public C4688a1(InterfaceC5821b<T> interfaceC5821b, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o, boolean z, int i2, int i3) {
        this.f17761b = interfaceC5821b;
        this.f17762c = interfaceC4584o;
        this.f17763d = z;
        this.f17764e = i2;
        this.f17765f = i3;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        if (C4708d3.m18317a(this.f17761b, interfaceC5822c, this.f17762c)) {
            return;
        }
        this.f17761b.subscribe(C4817w0.m18398a(interfaceC5822c, this.f17762c, this.f17763d, this.f17764e, this.f17765f));
    }
}
