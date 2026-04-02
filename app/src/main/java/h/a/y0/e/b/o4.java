package h.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableWindowBoundarySupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o4<T, B> extends h.a.y0.e.b.a<T, h.a.l<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<? extends j.d.b<B>> f10860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10861d;

    /* JADX INFO: compiled from: FlowableWindowBoundarySupplier.java */
    static final class a<T, B> extends h.a.g1.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, B> f10862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10863c;

        a(b<T, B> bVar) {
            this.f10862b = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10863c) {
                return;
            }
            this.f10863c = true;
            this.f10862b.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10863c) {
                h.a.c1.a.b(th);
            } else {
                this.f10863c = true;
                this.f10862b.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(B b2) {
            if (this.f10863c) {
                return;
            }
            this.f10863c = true;
            a();
            this.f10862b.g();
        }
    }

    /* JADX INFO: compiled from: FlowableWindowBoundarySupplier.java */
    static final class b<T, B> extends h.a.y0.h.m<T, Object, h.a.l<T>> implements j.d.d {
        static final Object s0 = new Object();
        final Callable<? extends j.d.b<B>> m0;
        final int n0;
        j.d.d o0;
        final AtomicReference<h.a.u0.c> p0;
        h.a.d1.g<T> q0;
        final AtomicLong r0;

        b(j.d.c<? super h.a.l<T>> cVar, Callable<? extends j.d.b<B>> callable, int i2) {
            super(cVar, new h.a.y0.f.a());
            this.p0 = new AtomicReference<>();
            this.r0 = new AtomicLong();
            this.m0 = callable;
            this.n0 = i2;
            this.r0.lazySet(1L);
        }

        @Override // j.d.d
        public void cancel() {
            this.j0 = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void f() {
            h.a.y0.c.o oVar = this.i0;
            j.d.c<? super V> cVar = this.h0;
            h.a.d1.g<T> gVar = this.q0;
            int iA = 1;
            while (true) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    h.a.y0.a.d.dispose(this.p0);
                    Throwable th = this.l0;
                    if (th != null) {
                        gVar.onError(th);
                        return;
                    } else {
                        gVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == s0) {
                    gVar.onComplete();
                    if (this.r0.decrementAndGet() == 0) {
                        h.a.y0.a.d.dispose(this.p0);
                        return;
                    }
                    if (this.j0) {
                        continue;
                    } else {
                        try {
                            j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.m0.call(), "The publisher supplied is null");
                            h.a.d1.g<T> gVarM = h.a.d1.g.m(this.n0);
                            long jRequested = requested();
                            if (jRequested != 0) {
                                this.r0.getAndIncrement();
                                cVar.onNext(gVarM);
                                if (jRequested != i.q2.t.m0.f12222b) {
                                    a(1L);
                                }
                                this.q0 = gVarM;
                                a aVar = new a(this);
                                AtomicReference<h.a.u0.c> atomicReference = this.p0;
                                if (atomicReference.compareAndSet(atomicReference.get(), aVar)) {
                                    bVar.subscribe(aVar);
                                }
                            } else {
                                this.j0 = true;
                                cVar.onError(new h.a.v0.c("Could not deliver new window due to lack of requests"));
                            }
                            gVar = gVarM;
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            h.a.y0.a.d.dispose(this.p0);
                            cVar.onError(th2);
                            return;
                        }
                    }
                } else {
                    gVar.onNext(h.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void g() {
            this.i0.offer((U) s0);
            if (b()) {
                f();
            }
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.k0) {
                return;
            }
            this.k0 = true;
            if (b()) {
                f();
            }
            if (this.r0.decrementAndGet() == 0) {
                h.a.y0.a.d.dispose(this.p0);
            }
            this.h0.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.k0) {
                h.a.c1.a.b(th);
                return;
            }
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            if (this.r0.decrementAndGet() == 0) {
                h.a.y0.a.d.dispose(this.p0);
            }
            this.h0.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.k0) {
                return;
            }
            if (e()) {
                this.q0.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer((U) h.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.o0, dVar)) {
                this.o0 = dVar;
                j.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                try {
                    j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.m0.call(), "The first window publisher supplied is null");
                    h.a.d1.g<T> gVarM = h.a.d1.g.m(this.n0);
                    long jRequested = requested();
                    if (jRequested == 0) {
                        dVar.cancel();
                        cVar.onError(new h.a.v0.c("Could not deliver first window due to lack of requests"));
                        return;
                    }
                    cVar.onNext(gVarM);
                    if (jRequested != i.q2.t.m0.f12222b) {
                        a(1L);
                    }
                    this.q0 = gVarM;
                    a aVar = new a(this);
                    if (this.p0.compareAndSet(null, aVar)) {
                        this.r0.getAndIncrement();
                        dVar.request(i.q2.t.m0.f12222b);
                        bVar.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    dVar.cancel();
                    cVar.onError(th);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }
    }

    public o4(h.a.l<T> lVar, Callable<? extends j.d.b<B>> callable, int i2) {
        super(lVar);
        this.f10860c = callable;
        this.f10861d = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super h.a.l<T>> cVar) {
        this.f10561b.a((h.a.q) new b(new h.a.g1.e(cVar), this.f10860c, this.f10861d));
    }
}
