package h.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableSampleTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f10597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f10598f;

    /* JADX INFO: compiled from: FlowableSampleTimed.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        a(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            super(cVar, j2, timeUnit, j0Var);
            this.wip = new AtomicInteger(1);
        }

        @Override // h.a.y0.e.b.c3.c
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

    /* JADX INFO: compiled from: FlowableSampleTimed.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            super(cVar, j2, timeUnit, j0Var);
        }

        @Override // h.a.y0.e.b.c3.c
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* JADX INFO: compiled from: FlowableSampleTimed.java */
    static abstract class c<T> extends AtomicReference<T> implements h.a.q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final j.d.c<? super T> actual;
        final long period;
        j.d.d s;
        final h.a.j0 scheduler;
        final TimeUnit unit;
        final AtomicLong requested = new AtomicLong();
        final h.a.y0.a.k timer = new h.a.y0.a.k();

        c(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.actual = cVar;
            this.period = j2;
            this.unit = timeUnit;
            this.scheduler = j0Var;
        }

        @Override // j.d.d
        public void cancel() {
            cancelTimer();
            this.s.cancel();
        }

        void cancelTimer() {
            h.a.y0.a.d.dispose(this.timer);
        }

        abstract void complete();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    h.a.y0.j.d.c(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new h.a.v0.c("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // j.d.c
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                h.a.y0.a.k kVar = this.timer;
                h.a.j0 j0Var = this.scheduler;
                long j2 = this.period;
                kVar.replace(j0Var.a(this, j2, j2, this.unit));
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
            }
        }
    }

    public c3(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, boolean z) {
        super(lVar);
        this.f10595c = j2;
        this.f10596d = timeUnit;
        this.f10597e = j0Var;
        this.f10598f = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        h.a.g1.e eVar = new h.a.g1.e(cVar);
        if (this.f10598f) {
            this.f10561b.a((h.a.q) new a(eVar, this.f10595c, this.f10596d, this.f10597e));
        } else {
            this.f10561b.a((h.a.q) new b(eVar, this.f10595c, this.f10596d, this.f10597e));
        }
    }
}
