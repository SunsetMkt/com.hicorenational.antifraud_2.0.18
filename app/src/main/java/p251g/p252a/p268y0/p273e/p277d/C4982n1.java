package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p281g.C5129r;

/* compiled from: ObservableInterval.java */
/* renamed from: g.a.y0.e.d.n1 */
/* loaded from: classes2.dex */
public final class C4982n1 extends AbstractC4469b0<Long> {

    /* renamed from: a */
    final AbstractC4516j0 f19212a;

    /* renamed from: b */
    final long f19213b;

    /* renamed from: c */
    final long f19214c;

    /* renamed from: d */
    final TimeUnit f19215d;

    /* compiled from: ObservableInterval.java */
    /* renamed from: g.a.y0.e.d.n1$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        final InterfaceC4514i0<? super Long> actual;
        long count;

        a(InterfaceC4514i0<? super Long> interfaceC4514i0) {
            this.actual = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == EnumC4592d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != EnumC4592d.DISPOSED) {
                InterfaceC4514i0<? super Long> interfaceC4514i0 = this.actual;
                long j2 = this.count;
                this.count = 1 + j2;
                interfaceC4514i0.onNext(Long.valueOf(j2));
            }
        }

        public void setResource(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    public C4982n1(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f19213b = j2;
        this.f19214c = j3;
        this.f19215d = timeUnit;
        this.f19212a = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super Long> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0);
        interfaceC4514i0.onSubscribe(aVar);
        AbstractC4516j0 abstractC4516j0 = this.f19212a;
        if (!(abstractC4516j0 instanceof C5129r)) {
            aVar.setResource(abstractC4516j0.mo17408a(aVar, this.f19213b, this.f19214c, this.f19215d));
            return;
        }
        AbstractC4516j0.c mo17277a = abstractC4516j0.mo17277a();
        aVar.setResource(mo17277a);
        mo17277a.mo17412a(aVar, this.f19213b, this.f19214c, this.f19215d);
    }
}
