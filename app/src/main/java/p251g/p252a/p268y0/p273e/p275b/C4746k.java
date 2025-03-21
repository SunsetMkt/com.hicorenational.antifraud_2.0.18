package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p266w0.AbstractC4567a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableAutoConnect.java */
/* renamed from: g.a.y0.e.b.k */
/* loaded from: classes2.dex */
public final class C4746k<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final AbstractC4567a<? extends T> f17987b;

    /* renamed from: c */
    final int f17988c;

    /* renamed from: d */
    final InterfaceC4576g<? super InterfaceC4552c> f17989d;

    /* renamed from: e */
    final AtomicInteger f17990e = new AtomicInteger();

    public C4746k(AbstractC4567a<? extends T> abstractC4567a, int i2, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        this.f17987b = abstractC4567a;
        this.f17988c = i2;
        this.f17989d = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17987b.subscribe(interfaceC5822c);
        if (this.f17990e.incrementAndGet() == this.f17988c) {
            this.f17987b.mo18205l(this.f17989d);
        }
    }
}
