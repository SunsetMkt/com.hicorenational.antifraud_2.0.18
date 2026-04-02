package h.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableBufferBoundarySupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T, U extends Collection<? super T>, B> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<? extends j.d.b<B>> f10836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<U> f10837d;

    /* JADX INFO: compiled from: FlowableBufferBoundarySupplier.java */
    static final class a<T, U extends Collection<? super T>, B> extends h.a.g1.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, U, B> f10838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10839c;

        a(b<T, U, B> bVar) {
            this.f10838b = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10839c) {
                return;
            }
            this.f10839c = true;
            this.f10838b.g();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10839c) {
                h.a.c1.a.b(th);
            } else {
                this.f10839c = true;
                this.f10838b.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(B b2) {
            if (this.f10839c) {
                return;
            }
            this.f10839c = true;
            a();
            this.f10838b.g();
        }
    }

    /* JADX INFO: compiled from: FlowableBufferBoundarySupplier.java */
    static final class b<T, U extends Collection<? super T>, B> extends h.a.y0.h.m<T, U, U> implements h.a.q<T>, j.d.d, h.a.u0.c {
        final Callable<U> m0;
        final Callable<? extends j.d.b<B>> n0;
        j.d.d o0;
        final AtomicReference<h.a.u0.c> p0;
        U q0;

        b(j.d.c<? super U> cVar, Callable<U> callable, Callable<? extends j.d.b<B>> callable2) {
            super(cVar, new h.a.y0.f.a());
            this.p0 = new AtomicReference<>();
            this.m0 = callable;
            this.n0 = callable2;
        }

        @Override // h.a.y0.h.m, h.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(j.d.c cVar, Object obj) {
            return a((j.d.c<? super Collection>) cVar, (Collection) obj);
        }

        @Override // j.d.d
        public void cancel() {
            if (this.j0) {
                return;
            }
            this.j0 = true;
            this.o0.cancel();
            f();
            if (b()) {
                this.i0.clear();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.o0.cancel();
            f();
        }

        void f() {
            h.a.y0.a.d.dispose(this.p0);
        }

        void g() {
            try {
                U u = (U) h.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                try {
                    j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.n0.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    if (this.p0.compareAndSet(this.p0.get(), aVar)) {
                        synchronized (this) {
                            U u2 = this.q0;
                            if (u2 == null) {
                                return;
                            }
                            this.q0 = u;
                            bVar.subscribe(aVar);
                            a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.j0 = true;
                    this.o0.cancel();
                    this.h0.onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                cancel();
                this.h0.onError(th2);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.p0.get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // j.d.c
        public void onComplete() {
            synchronized (this) {
                U u = this.q0;
                if (u == null) {
                    return;
                }
                this.q0 = null;
                this.i0.offer(u);
                this.k0 = true;
                if (b()) {
                    h.a.y0.j.v.a((h.a.y0.c.n) this.i0, (j.d.c) this.h0, false, (h.a.u0.c) this, (h.a.y0.j.u) this);
                }
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            cancel();
            this.h0.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.q0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.o0, dVar)) {
                this.o0 = dVar;
                j.d.c<? super V> cVar = this.h0;
                try {
                    this.q0 = (U) h.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                    try {
                        j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.n0.call(), "The boundary publisher supplied is null");
                        a aVar = new a(this);
                        this.p0.set(aVar);
                        cVar.onSubscribe(this);
                        if (this.j0) {
                            return;
                        }
                        dVar.request(i.q2.t.m0.f12222b);
                        bVar.subscribe(aVar);
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.j0 = true;
                        dVar.cancel();
                        h.a.y0.i.g.error(th, cVar);
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    this.j0 = true;
                    dVar.cancel();
                    h.a.y0.i.g.error(th2, cVar);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public boolean a(j.d.c<? super U> cVar, U u) {
            this.h0.onNext((Object) u);
            return true;
        }
    }

    public o(h.a.l<T> lVar, Callable<? extends j.d.b<B>> callable, Callable<U> callable2) {
        super(lVar);
        this.f10836c = callable;
        this.f10837d = callable2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        this.f10561b.a((h.a.q) new b(new h.a.g1.e(cVar), this.f10837d, this.f10836c));
    }
}
