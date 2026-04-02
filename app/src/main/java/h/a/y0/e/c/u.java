package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeEqualSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u<T> extends h.a.k0<Boolean> {
    final h.a.y<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y<? extends T> f11191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.d<? super T, ? super T> f11192c;

    /* JADX INFO: compiled from: MaybeEqualSingle.java */
    static final class a<T> extends AtomicInteger implements h.a.u0.c {
        final h.a.n0<? super Boolean> actual;
        final h.a.x0.d<? super T, ? super T> isEqual;
        final b<T> observer1;
        final b<T> observer2;

        a(h.a.n0<? super Boolean> n0Var, h.a.x0.d<? super T, ? super T> dVar) {
            super(2);
            this.actual = n0Var;
            this.isEqual = dVar;
            this.observer1 = new b<>(this);
            this.observer2 = new b<>(this);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        void done() {
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj == null || obj2 == null) {
                    this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.actual.onSuccess(Boolean.valueOf(this.isEqual.a(obj, obj2)));
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        void error(b<T> bVar, Throwable th) {
            if (getAndSet(0) <= 0) {
                h.a.c1.a.b(th);
                return;
            }
            b<T> bVar2 = this.observer1;
            if (bVar == bVar2) {
                this.observer2.dispose();
            } else {
                bVar2.dispose();
            }
            this.actual.onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.observer1.get());
        }

        void subscribe(h.a.y<? extends T> yVar, h.a.y<? extends T> yVar2) {
            yVar.a(this.observer1);
            yVar2.a(this.observer2);
        }
    }

    /* JADX INFO: compiled from: MaybeEqualSingle.java */
    static final class b<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final a<T> parent;
        Object value;

        b(a<T> aVar) {
            this.parent = aVar;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.v
        public void onComplete() {
            this.parent.done();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.value = t;
            this.parent.done();
        }
    }

    public u(h.a.y<? extends T> yVar, h.a.y<? extends T> yVar2, h.a.x0.d<? super T, ? super T> dVar) {
        this.a = yVar;
        this.f11191b = yVar2;
        this.f11192c = dVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        a aVar = new a(n0Var, this.f11192c);
        n0Var.onSubscribe(aVar);
        aVar.subscribe(this.a, this.f11191b);
    }
}
