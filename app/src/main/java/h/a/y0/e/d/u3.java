package h.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableToList.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u3<T, U extends Collection<? super T>> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f11657b;

    /* JADX INFO: compiled from: ObservableToList.java */
    static final class a<T, U extends Collection<? super T>> implements h.a.i0<T>, h.a.u0.c {
        U a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.i0<? super U> f11658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11659c;

        a(h.a.i0<? super U> i0Var, U u) {
            this.f11658b = i0Var;
            this.a = u;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11659c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11659c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            U u = this.a;
            this.a = null;
            this.f11658b.onNext(u);
            this.f11658b.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a = null;
            this.f11658b.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.a.add(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11659c, cVar)) {
                this.f11659c = cVar;
                this.f11658b.onSubscribe(this);
            }
        }
    }

    public u3(h.a.g0<T> g0Var, int i2) {
        super(g0Var);
        this.f11657b = h.a.y0.b.a.a(i2);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super U> i0Var) {
        try {
            this.a.subscribe(new a(i0Var, (Collection) h.a.y0.b.b.a(this.f11657b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }

    public u3(h.a.g0<T> g0Var, Callable<U> callable) {
        super(g0Var);
        this.f11657b = callable;
    }
}
