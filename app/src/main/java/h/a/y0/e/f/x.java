package h.a.y0.e.f;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SingleFlatMapIterableFlowable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x<T, R> extends h.a.l<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.q0<T> f11899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f11900c;

    /* JADX INFO: compiled from: SingleFlatMapIterableFlowable.java */
    static final class a<T, R> extends h.a.y0.i.c<R> implements h.a.n0<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11901d;
        volatile Iterator<? extends R> it;
        final h.a.x0.o<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();

        a(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.actual = cVar;
            this.mapper = oVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.f11901d.dispose();
            this.f11901d = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.it = null;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super R> cVar = this.actual;
            Iterator<? extends R> it = this.it;
            if (this.outputFused && it != null) {
                cVar.onNext(null);
                cVar.onComplete();
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                if (it != null) {
                    long j2 = this.requested.get();
                    if (j2 == i.q2.t.m0.f12222b) {
                        slowPath(cVar, it);
                        return;
                    }
                    long j3 = 0;
                    while (j3 != j2) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            cVar.onNext((Object) h.a.y0.b.b.a(it.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j3++;
                            try {
                                if (!it.hasNext()) {
                                    cVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                cVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        h.a.y0.j.d.c(this.requested, j3);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (it == null) {
                    it = this.it;
                }
            }
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11901d = h.a.y0.a.d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11901d, cVar)) {
                this.f11901d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.actual.onComplete();
                } else {
                    this.it = it;
                    drain();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) h.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        void slowPath(j.d.c<? super R> cVar, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    cVar.onNext(it.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }
    }

    public x(h.a.q0<T> q0Var, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f11899b = q0Var;
        this.f11900c = oVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        this.f11899b.a(new a(cVar, this.f11900c));
    }
}
