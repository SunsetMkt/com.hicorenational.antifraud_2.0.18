package h.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableBufferExactBoundary.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p<T, U extends Collection<? super T>, B> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<B> f10864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<U> f10865d;

    /* JADX INFO: compiled from: FlowableBufferExactBoundary.java */
    static final class a<T, U extends Collection<? super T>, B> extends h.a.g1.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, U, B> f10866b;

        a(b<T, U, B> bVar) {
            this.f10866b = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10866b.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10866b.onError(th);
        }

        @Override // j.d.c
        public void onNext(B b2) {
            this.f10866b.f();
        }
    }

    /* JADX INFO: compiled from: FlowableBufferExactBoundary.java */
    static final class b<T, U extends Collection<? super T>, B> extends h.a.y0.h.m<T, U, U> implements h.a.q<T>, j.d.d, h.a.u0.c {
        final Callable<U> m0;
        final j.d.b<B> n0;
        j.d.d o0;
        h.a.u0.c p0;
        U q0;

        b(j.d.c<? super U> cVar, Callable<U> callable, j.d.b<B> bVar) {
            super(cVar, new h.a.y0.f.a());
            this.m0 = callable;
            this.n0 = bVar;
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
            this.p0.dispose();
            this.o0.cancel();
            if (b()) {
                this.i0.clear();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            cancel();
        }

        void f() {
            try {
                U u = (U) h.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.q0;
                    if (u2 == null) {
                        return;
                    }
                    this.q0 = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.j0;
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
                try {
                    this.q0 = (U) h.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.p0 = aVar;
                    this.h0.onSubscribe(this);
                    if (this.j0) {
                        return;
                    }
                    dVar.request(i.q2.t.m0.f12222b);
                    this.n0.subscribe(aVar);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.j0 = true;
                    dVar.cancel();
                    h.a.y0.i.g.error(th, this.h0);
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

    public p(h.a.l<T> lVar, j.d.b<B> bVar, Callable<U> callable) {
        super(lVar);
        this.f10864c = bVar;
        this.f10865d = callable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        this.f10561b.a((h.a.q) new b(new h.a.g1.e(cVar), this.f10865d, this.f10864c));
    }
}
