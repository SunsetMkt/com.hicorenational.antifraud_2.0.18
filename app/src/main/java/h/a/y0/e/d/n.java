package h.a.y0.e.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableBufferBoundary.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T, U extends Collection<? super T>, Open, Close> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f11503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.g0<? extends Open> f11504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super Open, ? extends h.a.g0<? extends Close>> f11505d;

    /* JADX INFO: compiled from: ObservableBufferBoundary.java */
    static final class a<T, U extends Collection<? super T>, Open, Close> extends h.a.y0.d.w<T, U, U> implements h.a.u0.c {
        final h.a.g0<? extends Open> K;
        final h.a.x0.o<? super Open, ? extends h.a.g0<? extends Close>> L;
        final Callable<U> M;
        final h.a.u0.b N;
        h.a.u0.c O;
        final List<U> b0;
        final AtomicInteger c0;

        a(h.a.i0<? super U> i0Var, h.a.g0<? extends Open> g0Var, h.a.x0.o<? super Open, ? extends h.a.g0<? extends Close>> oVar, Callable<U> callable) {
            super(i0Var, new h.a.y0.f.a());
            this.c0 = new AtomicInteger();
            this.K = g0Var;
            this.L = oVar;
            this.M = callable;
            this.b0 = new LinkedList();
            this.N = new h.a.u0.b();
        }

        @Override // h.a.y0.d.w, h.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(h.a.i0 i0Var, Object obj) {
            a((h.a.i0<? super Collection>) i0Var, (Collection) obj);
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.H) {
                return;
            }
            this.H = true;
            this.N.dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void f() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.b0);
                this.b0.clear();
            }
            h.a.y0.c.n<U> nVar = this.G;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                nVar.offer((U) ((Collection) it.next()));
            }
            this.I = true;
            if (b()) {
                h.a.y0.j.v.a((h.a.y0.c.n) nVar, (h.a.i0) this.F, false, (h.a.u0.c) this, (h.a.y0.j.r) this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.c0.decrementAndGet() == 0) {
                f();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            dispose();
            this.H = true;
            synchronized (this) {
                this.b0.clear();
            }
            this.F.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.b0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                c cVar2 = new c(this);
                this.N.b(cVar2);
                this.F.onSubscribe(this);
                this.c0.lazySet(1);
                this.K.subscribe(cVar2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(h.a.i0<? super U> i0Var, U u) {
            i0Var.onNext(u);
        }

        void a(Open open) {
            if (this.H) {
                return;
            }
            try {
                Collection collection = (Collection) h.a.y0.b.b.a(this.M.call(), "The buffer supplied is null");
                try {
                    h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.L.apply(open), "The buffer closing Observable is null");
                    if (this.H) {
                        return;
                    }
                    synchronized (this) {
                        if (this.H) {
                            return;
                        }
                        this.b0.add((U) collection);
                        b bVar = new b(collection, this);
                        this.N.b(bVar);
                        this.c0.getAndIncrement();
                        g0Var.subscribe(bVar);
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
            if (this.N.a(cVar) && this.c0.decrementAndGet() == 0) {
                f();
            }
        }

        void a(U u, h.a.u0.c cVar) {
            boolean zRemove;
            synchronized (this) {
                zRemove = this.b0.remove(u);
            }
            if (zRemove) {
                b(u, false, this);
            }
            if (this.N.a(cVar) && this.c0.decrementAndGet() == 0) {
                f();
            }
        }
    }

    /* JADX INFO: compiled from: ObservableBufferBoundary.java */
    static final class b<T, U extends Collection<? super T>, Open, Close> extends h.a.a1.e<Close> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f11506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f11507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11508d;

        b(U u, a<T, U, Open, Close> aVar) {
            this.f11506b = aVar;
            this.f11507c = u;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11508d) {
                return;
            }
            this.f11508d = true;
            this.f11506b.a(this.f11507c, this);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11508d) {
                h.a.c1.a.b(th);
            } else {
                this.f11506b.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* JADX INFO: compiled from: ObservableBufferBoundary.java */
    static final class c<T, U extends Collection<? super T>, Open, Close> extends h.a.a1.e<Open> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f11509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11510c;

        c(a<T, U, Open, Close> aVar) {
            this.f11509b = aVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11510c) {
                return;
            }
            this.f11510c = true;
            this.f11509b.a((h.a.u0.c) this);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11510c) {
                h.a.c1.a.b(th);
            } else {
                this.f11510c = true;
                this.f11509b.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(Open open) {
            if (this.f11510c) {
                return;
            }
            this.f11509b.a(open);
        }
    }

    public n(h.a.g0<T> g0Var, h.a.g0<? extends Open> g0Var2, h.a.x0.o<? super Open, ? extends h.a.g0<? extends Close>> oVar, Callable<U> callable) {
        super(g0Var);
        this.f11504c = g0Var2;
        this.f11505d = oVar;
        this.f11503b = callable;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super U> i0Var) {
        this.a.subscribe(new a(new h.a.a1.m(i0Var), this.f11504c, this.f11505d, this.f11503b));
    }
}
