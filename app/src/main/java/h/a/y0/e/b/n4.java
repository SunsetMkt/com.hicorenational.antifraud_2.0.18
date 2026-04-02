package h.a.y0.e.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableWindowBoundarySelector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n4<T, B, V> extends h.a.y0.e.b.a<T, h.a.l<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<B> f10827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super B, ? extends j.d.b<V>> f10828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f10829e;

    /* JADX INFO: compiled from: FlowableWindowBoundarySelector.java */
    static final class a<T, V> extends h.a.g1.b<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T, ?, V> f10830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.d1.g<T> f10831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10832d;

        a(c<T, ?, V> cVar, h.a.d1.g<T> gVar) {
            this.f10830b = cVar;
            this.f10831c = gVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10832d) {
                return;
            }
            this.f10832d = true;
            this.f10830b.a((a) this);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10832d) {
                h.a.c1.a.b(th);
            } else {
                this.f10832d = true;
                this.f10830b.a(th);
            }
        }

        @Override // j.d.c
        public void onNext(V v) {
            if (this.f10832d) {
                return;
            }
            this.f10832d = true;
            a();
            this.f10830b.a((a) this);
        }
    }

    /* JADX INFO: compiled from: FlowableWindowBoundarySelector.java */
    static final class b<T, B> extends h.a.g1.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T, B, ?> f10833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10834c;

        b(c<T, B, ?> cVar) {
            this.f10833b = cVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10834c) {
                return;
            }
            this.f10834c = true;
            this.f10833b.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10834c) {
                h.a.c1.a.b(th);
            } else {
                this.f10834c = true;
                this.f10833b.a(th);
            }
        }

        @Override // j.d.c
        public void onNext(B b2) {
            if (this.f10834c) {
                return;
            }
            this.f10833b.a(b2);
        }
    }

    /* JADX INFO: compiled from: FlowableWindowBoundarySelector.java */
    static final class d<T, B> {
        final h.a.d1.g<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final B f10835b;

        d(h.a.d1.g<T> gVar, B b2) {
            this.a = gVar;
            this.f10835b = b2;
        }
    }

    public n4(h.a.l<T> lVar, j.d.b<B> bVar, h.a.x0.o<? super B, ? extends j.d.b<V>> oVar, int i2) {
        super(lVar);
        this.f10827c = bVar;
        this.f10828d = oVar;
        this.f10829e = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super h.a.l<T>> cVar) {
        this.f10561b.a((h.a.q) new c(new h.a.g1.e(cVar), this.f10827c, this.f10828d, this.f10829e));
    }

    /* JADX INFO: compiled from: FlowableWindowBoundarySelector.java */
    static final class c<T, B, V> extends h.a.y0.h.m<T, Object, h.a.l<T>> implements j.d.d {
        final j.d.b<B> m0;
        final h.a.x0.o<? super B, ? extends j.d.b<V>> n0;
        final int o0;
        final h.a.u0.b p0;
        j.d.d q0;
        final AtomicReference<h.a.u0.c> r0;
        final List<h.a.d1.g<T>> s0;
        final AtomicLong t0;

        c(j.d.c<? super h.a.l<T>> cVar, j.d.b<B> bVar, h.a.x0.o<? super B, ? extends j.d.b<V>> oVar, int i2) {
            super(cVar, new h.a.y0.f.a());
            this.r0 = new AtomicReference<>();
            this.t0 = new AtomicLong();
            this.m0 = bVar;
            this.n0 = oVar;
            this.o0 = i2;
            this.p0 = new h.a.u0.b();
            this.s0 = new ArrayList();
            this.t0.lazySet(1L);
        }

        void a(Throwable th) {
            this.q0.cancel();
            this.p0.dispose();
            h.a.y0.a.d.dispose(this.r0);
            this.h0.onError(th);
        }

        @Override // h.a.y0.h.m, h.a.y0.j.u
        public boolean a(j.d.c<? super h.a.l<T>> cVar, Object obj) {
            return false;
        }

        @Override // j.d.d
        public void cancel() {
            this.j0 = true;
        }

        void dispose() {
            this.p0.dispose();
            h.a.y0.a.d.dispose(this.r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f() {
            h.a.y0.c.o oVar = this.i0;
            j.d.c<? super V> cVar = this.h0;
            List<h.a.d1.g<T>> list = this.s0;
            int iA = 1;
            while (true) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    dispose();
                    Throwable th = this.l0;
                    if (th != null) {
                        Iterator<h.a.d1.g<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<h.a.d1.g<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar = (d) objPoll;
                    h.a.d1.g<T> gVar = dVar.a;
                    if (gVar != null) {
                        if (list.remove(gVar)) {
                            dVar.a.onComplete();
                            if (this.t0.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.j0) {
                        h.a.d1.g<T> gVarM = h.a.d1.g.m(this.o0);
                        long jRequested = requested();
                        if (jRequested != 0) {
                            list.add(gVarM);
                            cVar.onNext(gVarM);
                            if (jRequested != i.q2.t.m0.f12222b) {
                                a(1L);
                            }
                            try {
                                j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.n0.apply(dVar.f10835b), "The publisher supplied is null");
                                a aVar = new a(this, gVarM);
                                if (this.p0.b(aVar)) {
                                    this.t0.getAndIncrement();
                                    bVar.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                this.j0 = true;
                                cVar.onError(th2);
                            }
                        } else {
                            this.j0 = true;
                            cVar.onError(new h.a.v0.c("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<h.a.d1.g<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(h.a.y0.j.q.getValue(objPoll));
                    }
                }
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
            if (this.t0.decrementAndGet() == 0) {
                this.p0.dispose();
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
            if (this.t0.decrementAndGet() == 0) {
                this.p0.dispose();
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
                Iterator<h.a.d1.g<T>> it = this.s0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
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

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                this.h0.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                b bVar = new b(this);
                if (this.r0.compareAndSet(null, bVar)) {
                    this.t0.getAndIncrement();
                    dVar.request(i.q2.t.m0.f12222b);
                    this.m0.subscribe(bVar);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(B b2) {
            this.i0.offer((U) new d(null, b2));
            if (b()) {
                f();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(a<T, V> aVar) {
            this.p0.c(aVar);
            this.i0.offer((U) new d(aVar.f10831c, null));
            if (b()) {
                f();
            }
        }
    }
}
