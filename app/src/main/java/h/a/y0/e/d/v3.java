package h.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableToListSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v3<T, U extends Collection<? super T>> extends h.a.k0<U> implements h.a.y0.c.d<U> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f11681b;

    /* JADX INFO: compiled from: ObservableToListSingle.java */
    static final class a<T, U extends Collection<? super T>> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super U> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        U f11682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11683c;

        a(h.a.n0<? super U> n0Var, U u) {
            this.a = n0Var;
            this.f11682b = u;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11683c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11683c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            U u = this.f11682b;
            this.f11682b = null;
            this.a.onSuccess(u);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11682b = null;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11682b.add(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11683c, cVar)) {
                this.f11683c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public v3(h.a.g0<T> g0Var, int i2) {
        this.a = g0Var;
        this.f11681b = h.a.y0.b.a.a(i2);
    }

    @Override // h.a.y0.c.d
    public h.a.b0<U> a() {
        return h.a.c1.a.a(new u3(this.a, this.f11681b));
    }

    @Override // h.a.k0
    public void b(h.a.n0<? super U> n0Var) {
        try {
            this.a.subscribe(new a(n0Var, (Collection) h.a.y0.b.b.a(this.f11681b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }

    public v3(h.a.g0<T> g0Var, Callable<U> callable) {
        this.a = g0Var;
        this.f11681b = callable;
    }
}
