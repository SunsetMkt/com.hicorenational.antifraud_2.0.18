package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSampleTimed.java */
/* renamed from: g.a.y0.e.b.c3 */
/* loaded from: classes2.dex */
public final class C4702c3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f17805c;

    /* renamed from: d */
    final TimeUnit f17806d;

    /* renamed from: e */
    final AbstractC4516j0 f17807e;

    /* renamed from: f */
    final boolean f17808f;

    /* compiled from: FlowableSampleTimed.java */
    /* renamed from: g.a.y0.e.b.c3$a */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            super(interfaceC5822c, j2, timeUnit, abstractC4516j0);
            this.wip = new AtomicInteger(1);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4702c3.c
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }

    /* compiled from: FlowableSampleTimed.java */
    /* renamed from: g.a.y0.e.b.c3$b */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            super(interfaceC5822c, j2, timeUnit, abstractC4516j0);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4702c3.c
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* compiled from: FlowableSampleTimed.java */
    /* renamed from: g.a.y0.e.b.c3$c */
    static abstract class c<T> extends AtomicReference<T> implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final InterfaceC5822c<? super T> actual;
        final long period;

        /* renamed from: s */
        InterfaceC5823d f17809s;
        final AbstractC4516j0 scheduler;
        final TimeUnit unit;
        final AtomicLong requested = new AtomicLong();
        final C4599k timer = new C4599k();

        c(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC5822c;
            this.period = j2;
            this.unit = timeUnit;
            this.scheduler = abstractC4516j0;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            cancelTimer();
            this.f17809s.cancel();
        }

        void cancelTimer() {
            EnumC4592d.dispose(this.timer);
        }

        abstract void complete();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    C5164d.m18610c(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new C4562c("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17809s, interfaceC5823d)) {
                this.f17809s = interfaceC5823d;
                this.actual.onSubscribe(this);
                C4599k c4599k = this.timer;
                AbstractC4516j0 abstractC4516j0 = this.scheduler;
                long j2 = this.period;
                c4599k.replace(abstractC4516j0.mo17408a(this, j2, j2, this.unit));
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
            }
        }
    }

    public C4702c3(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        super(abstractC4519l);
        this.f17805c = j2;
        this.f17806d = timeUnit;
        this.f17807e = abstractC4516j0;
        this.f17808f = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C4509e c4509e = new C4509e(interfaceC5822c);
        if (this.f17808f) {
            this.f17759b.m17799a((InterfaceC4529q) new a(c4509e, this.f17805c, this.f17806d, this.f17807e));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(c4509e, this.f17805c, this.f17806d, this.f17807e));
        }
    }
}
