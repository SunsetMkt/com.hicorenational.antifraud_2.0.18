package h.a.y0.e.d;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableTimeout.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r3<T, U, V> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<U> f11601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<V>> f11602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.g0<? extends T> f11603d;

    /* JADX INFO: compiled from: ObservableTimeout.java */
    interface a {
        void innerError(Throwable th);

        void timeout(long j2);
    }

    /* JADX INFO: compiled from: ObservableTimeout.java */
    static final class b<T, U, V> extends h.a.a1.e<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a f11604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f11605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11606d;

        b(a aVar, long j2) {
            this.f11604b = aVar;
            this.f11605c = j2;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11606d) {
                return;
            }
            this.f11606d = true;
            this.f11604b.timeout(this.f11605c);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11606d) {
                h.a.c1.a.b(th);
            } else {
                this.f11606d = true;
                this.f11604b.innerError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            if (this.f11606d) {
                return;
            }
            this.f11606d = true;
            dispose();
            this.f11604b.timeout(this.f11605c);
        }
    }

    /* JADX INFO: compiled from: ObservableTimeout.java */
    static final class c<T, U, V> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c, a {
        private static final long serialVersionUID = 2672739326310051084L;
        final h.a.i0<? super T> actual;
        final h.a.g0<U> firstTimeoutIndicator;
        volatile long index;
        final h.a.x0.o<? super T, ? extends h.a.g0<V>> itemTimeoutIndicator;
        h.a.u0.c s;

        c(h.a.i0<? super T> i0Var, h.a.g0<U> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<V>> oVar) {
            this.actual = i0Var;
            this.firstTimeoutIndicator = g0Var;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (h.a.y0.a.d.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // h.a.y0.e.d.r3.a
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.y0.a.d.dispose(this);
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this);
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            long j2 = this.index + 1;
            this.index = j2;
            this.actual.onNext(t);
            h.a.u0.c cVar = (h.a.u0.c) get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                b bVar = new b(this, j2);
                if (compareAndSet(cVar, bVar)) {
                    g0Var.subscribe(bVar);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                h.a.i0<? super T> i0Var = this.actual;
                h.a.g0<U> g0Var = this.firstTimeoutIndicator;
                if (g0Var == null) {
                    i0Var.onSubscribe(this);
                    return;
                }
                b bVar = new b(this, 0L);
                if (compareAndSet(null, bVar)) {
                    i0Var.onSubscribe(this);
                    g0Var.subscribe(bVar);
                }
            }
        }

        @Override // h.a.y0.e.d.r3.a
        public void timeout(long j2) {
            if (j2 == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }
    }

    /* JADX INFO: compiled from: ObservableTimeout.java */
    static final class d<T, U, V> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c, a {
        private static final long serialVersionUID = -1957813281749686898L;
        final h.a.i0<? super T> actual;
        final h.a.y0.a.j<T> arbiter;
        boolean done;
        final h.a.g0<U> firstTimeoutIndicator;
        volatile long index;
        final h.a.x0.o<? super T, ? extends h.a.g0<V>> itemTimeoutIndicator;
        final h.a.g0<? extends T> other;
        h.a.u0.c s;

        d(h.a.i0<? super T> i0Var, h.a.g0<U> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<V>> oVar, h.a.g0<? extends T> g0Var2) {
            this.actual = i0Var;
            this.firstTimeoutIndicator = g0Var;
            this.itemTimeoutIndicator = oVar;
            this.other = g0Var2;
            this.arbiter = new h.a.y0.a.j<>(i0Var, this, 8);
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (h.a.y0.a.d.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // h.a.y0.e.d.r3.a
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.a(this.s);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.a(th, this.s);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            if (this.arbiter.a(t, this.s)) {
                h.a.u0.c cVar = (h.a.u0.c) get();
                if (cVar != null) {
                    cVar.dispose();
                }
                try {
                    h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                    b bVar = new b(this, j2);
                    if (compareAndSet(cVar, bVar)) {
                        g0Var.subscribe(bVar);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.arbiter.b(cVar);
                h.a.i0<? super T> i0Var = this.actual;
                h.a.g0<U> g0Var = this.firstTimeoutIndicator;
                if (g0Var == null) {
                    i0Var.onSubscribe(this.arbiter);
                    return;
                }
                b bVar = new b(this, 0L);
                if (compareAndSet(null, bVar)) {
                    i0Var.onSubscribe(this.arbiter);
                    g0Var.subscribe(bVar);
                }
            }
        }

        @Override // h.a.y0.e.d.r3.a
        public void timeout(long j2) {
            if (j2 == this.index) {
                dispose();
                this.other.subscribe(new h.a.y0.d.q(this.arbiter));
            }
        }
    }

    public r3(h.a.g0<T> g0Var, h.a.g0<U> g0Var2, h.a.x0.o<? super T, ? extends h.a.g0<V>> oVar, h.a.g0<? extends T> g0Var3) {
        super(g0Var);
        this.f11601b = g0Var2;
        this.f11602c = oVar;
        this.f11603d = g0Var3;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.g0<? extends T> g0Var = this.f11603d;
        if (g0Var == null) {
            this.a.subscribe(new c(new h.a.a1.m(i0Var), this.f11601b, this.f11602c));
        } else {
            this.a.subscribe(new d(i0Var, this.f11601b, this.f11602c, g0Var));
        }
    }
}
