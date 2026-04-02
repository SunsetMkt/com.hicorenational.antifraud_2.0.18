package h.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableScalarXMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s2 {

    /* JADX INFO: compiled from: ObservableScalarXMap.java */
    public static final class a<T> extends AtomicInteger implements h.a.y0.c.j<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final h.a.i0<? super T> observer;
        final T value;

        public a(h.a.i0<? super T> i0Var, T t) {
            this.observer = i0Var;
            this.value = t;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            lazySet(3);
        }

        @Override // h.a.u0.c
        public void dispose() {
            set(3);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // h.a.y0.c.o
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // h.a.y0.c.o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    /* JADX INFO: compiled from: ObservableScalarXMap.java */
    static final class b<T, R> extends h.a.b0<R> {
        final T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> f11617b;

        b(T t, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar) {
            this.a = t;
            this.f11617b = oVar;
        }

        @Override // h.a.b0
        public void d(h.a.i0<? super R> i0Var) {
            try {
                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.f11617b.apply(this.a), "The mapper returned a null ObservableSource");
                if (!(g0Var instanceof Callable)) {
                    g0Var.subscribe(i0Var);
                    return;
                }
                try {
                    Object objCall = ((Callable) g0Var).call();
                    if (objCall == null) {
                        h.a.y0.a.e.complete(i0Var);
                        return;
                    }
                    a aVar = new a(i0Var, objCall);
                    i0Var.onSubscribe(aVar);
                    aVar.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.y0.a.e.error(th, i0Var);
                }
            } catch (Throwable th2) {
                h.a.y0.a.e.error(th2, i0Var);
            }
        }
    }

    private s2() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean a(h.a.g0<T> g0Var, h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar) {
        if (!(g0Var instanceof Callable)) {
            return false;
        }
        try {
            defpackage.a aVar = (Object) ((Callable) g0Var).call();
            if (aVar == null) {
                h.a.y0.a.e.complete(i0Var);
                return true;
            }
            try {
                h.a.g0 g0Var2 = (h.a.g0) h.a.y0.b.b.a(oVar.apply(aVar), "The mapper returned a null ObservableSource");
                if (g0Var2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) g0Var2).call();
                        if (objCall == null) {
                            h.a.y0.a.e.complete(i0Var);
                            return true;
                        }
                        a aVar2 = new a(i0Var, objCall);
                        i0Var.onSubscribe(aVar2);
                        aVar2.run();
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        h.a.y0.a.e.error(th, i0Var);
                        return true;
                    }
                } else {
                    g0Var2.subscribe(i0Var);
                }
                return true;
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                h.a.y0.a.e.error(th2, i0Var);
                return true;
            }
        } catch (Throwable th3) {
            h.a.v0.b.b(th3);
            h.a.y0.a.e.error(th3, i0Var);
            return true;
        }
    }

    public static <T, U> h.a.b0<U> a(T t, h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar) {
        return h.a.c1.a.a(new b(t, oVar));
    }
}
