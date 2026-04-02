package h.a.y0.e.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableBufferBoundary.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T, U extends Collection<? super T>, Open, Close> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<U> f10814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final j.d.b<? extends Open> f10815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.o<? super Open, ? extends j.d.b<? extends Close>> f10816e;

    /* JADX INFO: compiled from: FlowableBufferBoundary.java */
    static final class a<T, U extends Collection<? super T>, Open, Close> extends h.a.y0.h.m<T, U, U> implements j.d.d, h.a.u0.c {
        final j.d.b<? extends Open> m0;
        final h.a.x0.o<? super Open, ? extends j.d.b<? extends Close>> n0;
        final Callable<U> o0;
        final h.a.u0.b p0;
        j.d.d q0;
        final List<U> r0;
        final AtomicInteger s0;

        a(j.d.c<? super U> cVar, j.d.b<? extends Open> bVar, h.a.x0.o<? super Open, ? extends j.d.b<? extends Close>> oVar, Callable<U> callable) {
            super(cVar, new h.a.y0.f.a());
            this.s0 = new AtomicInteger();
            this.m0 = bVar;
            this.n0 = oVar;
            this.o0 = callable;
            this.r0 = new LinkedList();
            this.p0 = new h.a.u0.b();
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
            dispose();
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.p0.dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void f() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.r0);
                this.r0.clear();
            }
            h.a.y0.c.n<U> nVar = this.i0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                nVar.offer((U) ((Collection) it.next()));
            }
            this.k0 = true;
            if (b()) {
                h.a.y0.j.v.a((h.a.y0.c.n) nVar, (j.d.c) this.h0, false, (h.a.u0.c) this, (h.a.y0.j.u) this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.p0.isDisposed();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.s0.decrementAndGet() == 0) {
                f();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            cancel();
            this.j0 = true;
            synchronized (this) {
                this.r0.clear();
            }
            this.h0.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.r0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                c cVar = new c(this);
                this.p0.b(cVar);
                this.h0.onSubscribe(this);
                this.s0.lazySet(1);
                this.m0.subscribe(cVar);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(j.d.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }

        void a(Open open) {
            if (this.j0) {
                return;
            }
            try {
                Collection collection = (Collection) h.a.y0.b.b.a(this.o0.call(), "The buffer supplied is null");
                try {
                    j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.n0.apply(open), "The buffer closing publisher is null");
                    if (this.j0) {
                        return;
                    }
                    synchronized (this) {
                        if (this.j0) {
                            return;
                        }
                        this.r0.add((U) collection);
                        b bVar2 = new b(collection, this);
                        this.p0.b(bVar2);
                        this.s0.getAndIncrement();
                        bVar.subscribe(bVar2);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                onError(th2);
            }
        }

        void a(h.a.u0.c cVar) {
            if (this.p0.a(cVar) && this.s0.decrementAndGet() == 0) {
                f();
            }
        }

        void a(U u, h.a.u0.c cVar) {
            boolean zRemove;
            synchronized (this) {
                zRemove = this.r0.remove(u);
            }
            if (zRemove) {
                b(u, false, this);
            }
            if (this.p0.a(cVar) && this.s0.decrementAndGet() == 0) {
                f();
            }
        }
    }

    /* JADX INFO: compiled from: FlowableBufferBoundary.java */
    static final class b<T, U extends Collection<? super T>, Open, Close> extends h.a.g1.b<Close> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f10817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f10818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10819d;

        b(U u, a<T, U, Open, Close> aVar) {
            this.f10817b = aVar;
            this.f10818c = u;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10819d) {
                return;
            }
            this.f10819d = true;
            this.f10817b.a(this.f10818c, this);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10819d) {
                h.a.c1.a.b(th);
            } else {
                this.f10817b.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* JADX INFO: compiled from: FlowableBufferBoundary.java */
    static final class c<T, U extends Collection<? super T>, Open, Close> extends h.a.g1.b<Open> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f10820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10821c;

        c(a<T, U, Open, Close> aVar) {
            this.f10820b = aVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10821c) {
                return;
            }
            this.f10821c = true;
            this.f10820b.a((h.a.u0.c) this);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10821c) {
                h.a.c1.a.b(th);
            } else {
                this.f10821c = true;
                this.f10820b.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(Open open) {
            if (this.f10821c) {
                return;
            }
            this.f10820b.a(open);
        }
    }

    public n(h.a.l<T> lVar, j.d.b<? extends Open> bVar, h.a.x0.o<? super Open, ? extends j.d.b<? extends Close>> oVar, Callable<U> callable) {
        super(lVar);
        this.f10815d = bVar;
        this.f10816e = oVar;
        this.f10814c = callable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        this.f10561b.a((h.a.q) new a(new h.a.g1.e(cVar), this.f10815d, this.f10816e, this.f10814c));
    }
}
