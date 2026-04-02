package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableTimeoutTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f4<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f10659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final j.d.b<? extends T> f10660f;

    /* JADX INFO: compiled from: FlowableTimeoutTimed.java */
    static final class a<T> implements h.a.q<T> {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.y0.i.i f10661b;

        a(j.d.c<? super T> cVar, h.a.y0.i.i iVar) {
            this.a = cVar;
            this.f10661b = iVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            this.f10661b.setSubscription(dVar);
        }
    }

    /* JADX INFO: compiled from: FlowableTimeoutTimed.java */
    static final class b<T> extends h.a.y0.i.i implements h.a.q<T>, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final j.d.c<? super T> actual;
        long consumed;
        j.d.b<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;
        final h.a.y0.a.k task = new h.a.y0.a.k();
        final AtomicReference<j.d.d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        b(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2, j.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
            this.fallback = bVar;
        }

        @Override // h.a.y0.i.i, j.d.d
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.index.getAndSet(i.q2.t.m0.f12222b) != i.q2.t.m0.f12222b) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.index.getAndSet(i.q2.t.m0.f12222b) == i.q2.t.m0.f12222b) {
                h.a.c1.a.b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = this.index.get();
            if (j2 != i.q2.t.m0.f12222b) {
                long j3 = j2 + 1;
                if (this.index.compareAndSet(j2, j3)) {
                    this.task.get().dispose();
                    this.consumed++;
                    this.actual.onNext(t);
                    startTimeout(j3);
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this.upstream, dVar)) {
                setSubscription(dVar);
            }
        }

        @Override // h.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (this.index.compareAndSet(j2, i.q2.t.m0.f12222b)) {
                h.a.y0.i.j.cancel(this.upstream);
                long j3 = this.consumed;
                if (j3 != 0) {
                    produced(j3);
                }
                j.d.b<? extends T> bVar = this.fallback;
                this.fallback = null;
                bVar.subscribe(new a(this.actual, this));
                this.worker.dispose();
            }
        }

        void startTimeout(long j2) {
            this.task.replace(this.worker.a(new e(j2, this), this.timeout, this.unit));
        }
    }

    /* JADX INFO: compiled from: FlowableTimeoutTimed.java */
    static final class c<T> extends AtomicLong implements h.a.q<T>, j.d.d, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final j.d.c<? super T> actual;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;
        final h.a.y0.a.k task = new h.a.y0.a.k();
        final AtomicReference<j.d.d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        c(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            if (getAndSet(i.q2.t.m0.f12222b) != i.q2.t.m0.f12222b) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (getAndSet(i.q2.t.m0.f12222b) == i.q2.t.m0.f12222b) {
                h.a.c1.a.b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != i.q2.t.m0.f12222b) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    this.task.get().dispose();
                    this.actual.onNext(t);
                    startTimeout(j3);
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this.upstream, this.requested, dVar);
        }

        @Override // h.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (compareAndSet(j2, i.q2.t.m0.f12222b)) {
                h.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
                this.worker.dispose();
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.upstream, this.requested, j2);
        }

        void startTimeout(long j2) {
            this.task.replace(this.worker.a(new e(j2, this), this.timeout, this.unit));
        }
    }

    /* JADX INFO: compiled from: FlowableTimeoutTimed.java */
    interface d {
        void onTimeout(long j2);
    }

    /* JADX INFO: compiled from: FlowableTimeoutTimed.java */
    static final class e implements Runnable {
        final d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f10662b;

        e(long j2, d dVar) {
            this.f10662b = j2;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onTimeout(this.f10662b);
        }
    }

    public f4(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, j.d.b<? extends T> bVar) {
        super(lVar);
        this.f10657c = j2;
        this.f10658d = timeUnit;
        this.f10659e = j0Var;
        this.f10660f = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (this.f10660f == null) {
            c cVar2 = new c(cVar, this.f10657c, this.f10658d, this.f10659e.a());
            cVar.onSubscribe(cVar2);
            cVar2.startTimeout(0L);
            this.f10561b.a((h.a.q) cVar2);
            return;
        }
        b bVar = new b(cVar, this.f10657c, this.f10658d, this.f10659e.a(), this.f10660f);
        cVar.onSubscribe(bVar);
        bVar.startTimeout(0L);
        this.f10561b.a((h.a.q) bVar);
    }
}
