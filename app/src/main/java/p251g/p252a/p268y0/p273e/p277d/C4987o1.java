package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p281g.C5129r;

/* compiled from: ObservableIntervalRange.java */
/* renamed from: g.a.y0.e.d.o1 */
/* loaded from: classes2.dex */
public final class C4987o1 extends AbstractC4469b0<Long> {

    /* renamed from: a */
    final AbstractC4516j0 f19242a;

    /* renamed from: b */
    final long f19243b;

    /* renamed from: c */
    final long f19244c;

    /* renamed from: d */
    final long f19245d;

    /* renamed from: e */
    final long f19246e;

    /* renamed from: f */
    final TimeUnit f19247f;

    /* compiled from: ObservableIntervalRange.java */
    /* renamed from: g.a.y0.e.d.o1$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        final InterfaceC4514i0<? super Long> actual;
        long count;
        final long end;

        a(InterfaceC4514i0<? super Long> interfaceC4514i0, long j2, long j3) {
            this.actual = interfaceC4514i0;
            this.count = j2;
            this.end = j3;
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
            if (isDisposed()) {
                return;
            }
            long j2 = this.count;
            this.actual.onNext(Long.valueOf(j2));
            if (j2 != this.end) {
                this.count = j2 + 1;
            } else {
                EnumC4592d.dispose(this);
                this.actual.onComplete();
            }
        }

        public void setResource(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    public C4987o1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f19245d = j4;
        this.f19246e = j5;
        this.f19247f = timeUnit;
        this.f19242a = abstractC4516j0;
        this.f19243b = j2;
        this.f19244c = j3;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super Long> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f19243b, this.f19244c);
        interfaceC4514i0.onSubscribe(aVar);
        AbstractC4516j0 abstractC4516j0 = this.f19242a;
        if (!(abstractC4516j0 instanceof C5129r)) {
            aVar.setResource(abstractC4516j0.mo17408a(aVar, this.f19245d, this.f19246e, this.f19247f));
            return;
        }
        AbstractC4516j0.c mo17277a = abstractC4516j0.mo17277a();
        aVar.setResource(mo17277a);
        mo17277a.mo17412a(aVar, this.f19245d, this.f19246e, this.f19247f);
    }
}
