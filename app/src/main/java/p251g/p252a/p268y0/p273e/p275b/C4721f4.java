package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p283i.C5159i;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTimeoutTimed.java */
/* renamed from: g.a.y0.e.b.f4 */
/* loaded from: classes2.dex */
public final class C4721f4<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f17883c;

    /* renamed from: d */
    final TimeUnit f17884d;

    /* renamed from: e */
    final AbstractC4516j0 f17885e;

    /* renamed from: f */
    final InterfaceC5821b<? extends T> f17886f;

    /* compiled from: FlowableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.b.f4$a */
    static final class a<T> implements InterfaceC4529q<T> {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17887a;

        /* renamed from: b */
        final C5159i f17888b;

        a(InterfaceC5822c<? super T> interfaceC5822c, C5159i c5159i) {
            this.f17887a = interfaceC5822c;
            this.f17888b = c5159i;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17887a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17887a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f17887a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f17888b.setSubscription(interfaceC5823d);
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.b.f4$b */
    static final class b<T> extends C5159i implements InterfaceC4529q<T>, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final InterfaceC5822c<? super T> actual;
        long consumed;
        InterfaceC5821b<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final AbstractC4516j0.c worker;
        final C4599k task = new C4599k();
        final AtomicReference<InterfaceC5823d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        b(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = interfaceC5821b;
        }

        @Override // p251g.p252a.p268y0.p283i.C5159i, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.index.getAndSet(C5556m0.f20396b) != C5556m0.f20396b) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.index.getAndSet(C5556m0.f20396b) == C5556m0.f20396b) {
                C4476a.m17152b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = this.index.get();
            if (j2 != C5556m0.f20396b) {
                long j3 = j2 + 1;
                if (this.index.compareAndSet(j2, j3)) {
                    this.task.get().dispose();
                    this.consumed++;
                    this.actual.onNext(t);
                    startTimeout(j3);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this.upstream, interfaceC5823d)) {
                setSubscription(interfaceC5823d);
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4721f4.d
        public void onTimeout(long j2) {
            if (this.index.compareAndSet(j2, C5556m0.f20396b)) {
                EnumC5160j.cancel(this.upstream);
                long j3 = this.consumed;
                if (j3 != 0) {
                    produced(j3);
                }
                InterfaceC5821b<? extends T> interfaceC5821b = this.fallback;
                this.fallback = null;
                interfaceC5821b.subscribe(new a(this.actual, this));
                this.worker.dispose();
            }
        }

        void startTimeout(long j2) {
            this.task.replace(this.worker.mo17283a(new e(j2, this), this.timeout, this.unit));
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.b.f4$c */
    static final class c<T> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final InterfaceC5822c<? super T> actual;
        final long timeout;
        final TimeUnit unit;
        final AbstractC4516j0.c worker;
        final C4599k task = new C4599k();
        final AtomicReference<InterfaceC5823d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        c(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            this.actual = interfaceC5822c;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (getAndSet(C5556m0.f20396b) != C5556m0.f20396b) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (getAndSet(C5556m0.f20396b) == C5556m0.f20396b) {
                C4476a.m17152b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != C5556m0.f20396b) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    this.task.get().dispose();
                    this.actual.onNext(t);
                    startTimeout(j3);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this.upstream, this.requested, interfaceC5823d);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4721f4.d
        public void onTimeout(long j2) {
            if (compareAndSet(j2, C5556m0.f20396b)) {
                EnumC5160j.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
                this.worker.dispose();
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this.upstream, this.requested, j2);
        }

        void startTimeout(long j2) {
            this.task.replace(this.worker.mo17283a(new e(j2, this), this.timeout, this.unit));
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.b.f4$d */
    interface d {
        void onTimeout(long j2);
    }

    /* compiled from: FlowableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.b.f4$e */
    static final class e implements Runnable {

        /* renamed from: a */
        final d f17889a;

        /* renamed from: b */
        final long f17890b;

        e(long j2, d dVar) {
            this.f17890b = j2;
            this.f17889a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17889a.onTimeout(this.f17890b);
        }
    }

    public C4721f4(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC5821b<? extends T> interfaceC5821b) {
        super(abstractC4519l);
        this.f17883c = j2;
        this.f17884d = timeUnit;
        this.f17885e = abstractC4516j0;
        this.f17886f = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (this.f17886f == null) {
            c cVar = new c(interfaceC5822c, this.f17883c, this.f17884d, this.f17885e.mo17277a());
            interfaceC5822c.onSubscribe(cVar);
            cVar.startTimeout(0L);
            this.f17759b.m17799a((InterfaceC4529q) cVar);
            return;
        }
        b bVar = new b(interfaceC5822c, this.f17883c, this.f17884d, this.f17885e.mo17277a(), this.f17886f);
        interfaceC5822c.onSubscribe(bVar);
        bVar.startTimeout(0L);
        this.f17759b.m17799a((InterfaceC4529q) bVar);
    }
}
