package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p285z0.AbstractC5187a;

/* compiled from: ObservableAutoConnect.java */
/* renamed from: g.a.y0.e.d.k */
/* loaded from: classes2.dex */
public final class C4965k<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final AbstractC5187a<? extends T> f19093a;

    /* renamed from: b */
    final int f19094b;

    /* renamed from: c */
    final InterfaceC4576g<? super InterfaceC4552c> f19095c;

    /* renamed from: d */
    final AtomicInteger f19096d = new AtomicInteger();

    public C4965k(AbstractC5187a<? extends T> abstractC5187a, int i2, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        this.f19093a = abstractC5187a;
        this.f19094b = i2;
        this.f19095c = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f19093a.subscribe(interfaceC4514i0);
        if (this.f19096d.incrementAndGet() == this.f19094b) {
            this.f19093a.mo18422k(this.f19095c);
        }
    }
}
