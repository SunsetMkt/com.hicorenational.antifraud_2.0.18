package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTimer.java */
/* renamed from: g.a.y0.e.b.g4 */
/* loaded from: classes2.dex */
public final class C4727g4 extends AbstractC4519l<Long> {

    /* renamed from: b */
    final AbstractC4516j0 f17922b;

    /* renamed from: c */
    final long f17923c;

    /* renamed from: d */
    final TimeUnit f17924d;

    /* compiled from: FlowableTimer.java */
    /* renamed from: g.a.y0.e.b.g4$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC5823d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final InterfaceC5822c<? super Long> actual;
        volatile boolean requested;

        a(InterfaceC5822c<? super Long> interfaceC5822c) {
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC4592d.dispose(this);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                this.requested = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != EnumC4592d.DISPOSED) {
                if (!this.requested) {
                    lazySet(EnumC4593e.INSTANCE);
                    this.actual.onError(new C4562c("Can't deliver value due to lack of requests"));
                } else {
                    this.actual.onNext(0L);
                    lazySet(EnumC4593e.INSTANCE);
                    this.actual.onComplete();
                }
            }
        }

        public void setResource(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.trySet(this, interfaceC4552c);
        }
    }

    public C4727g4(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f17923c = j2;
        this.f17924d = timeUnit;
        this.f17922b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super Long> interfaceC5822c) {
        a aVar = new a(interfaceC5822c);
        interfaceC5822c.onSubscribe(aVar);
        aVar.setResource(this.f17922b.mo17409a(aVar, this.f17923c, this.f17924d));
    }
}
