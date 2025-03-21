package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p281g.C5129r;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableInterval.java */
/* renamed from: g.a.y0.e.b.q1 */
/* loaded from: classes2.dex */
public final class C4784q1 extends AbstractC4519l<Long> {

    /* renamed from: b */
    final AbstractC4516j0 f18313b;

    /* renamed from: c */
    final long f18314c;

    /* renamed from: d */
    final long f18315d;

    /* renamed from: e */
    final TimeUnit f18316e;

    /* compiled from: FlowableInterval.java */
    /* renamed from: g.a.y0.e.b.q1$a */
    static final class a extends AtomicLong implements InterfaceC5823d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final InterfaceC5822c<? super Long> actual;
        long count;
        final AtomicReference<InterfaceC4552c> resource = new AtomicReference<>();

        a(InterfaceC5822c<? super Long> interfaceC5822c) {
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC4592d.dispose(this.resource);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.resource.get() != EnumC4592d.DISPOSED) {
                if (get() != 0) {
                    InterfaceC5822c<? super Long> interfaceC5822c = this.actual;
                    long j2 = this.count;
                    this.count = j2 + 1;
                    interfaceC5822c.onNext(Long.valueOf(j2));
                    C5164d.m18610c(this, 1L);
                    return;
                }
                this.actual.onError(new C4562c("Can't deliver value " + this.count + " due to lack of requests"));
                EnumC4592d.dispose(this.resource);
            }
        }

        public void setResource(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.resource, interfaceC4552c);
        }
    }

    public C4784q1(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f18314c = j2;
        this.f18315d = j3;
        this.f18316e = timeUnit;
        this.f18313b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super Long> interfaceC5822c) {
        a aVar = new a(interfaceC5822c);
        interfaceC5822c.onSubscribe(aVar);
        AbstractC4516j0 abstractC4516j0 = this.f18313b;
        if (!(abstractC4516j0 instanceof C5129r)) {
            aVar.setResource(abstractC4516j0.mo17408a(aVar, this.f18314c, this.f18315d, this.f18316e));
            return;
        }
        AbstractC4516j0.c mo17277a = abstractC4516j0.mo17277a();
        aVar.setResource(mo17277a);
        mo17277a.mo17412a(aVar, this.f18314c, this.f18315d, this.f18316e);
    }
}
