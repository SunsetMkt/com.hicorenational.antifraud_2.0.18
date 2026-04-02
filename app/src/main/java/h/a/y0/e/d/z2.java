package h.a.y0.e.d;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableSingleSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z2<T> extends h.a.k0<T> {
    final h.a.g0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f11735b;

    /* JADX INFO: compiled from: ObservableSingleSingle.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f11736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f11738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11739e;

        a(h.a.n0<? super T> n0Var, T t) {
            this.a = n0Var;
            this.f11736b = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11737c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11737c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11739e) {
                return;
            }
            this.f11739e = true;
            T t = this.f11738d;
            this.f11738d = null;
            if (t == null) {
                t = this.f11736b;
            }
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11739e) {
                h.a.c1.a.b(th);
            } else {
                this.f11739e = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11739e) {
                return;
            }
            if (this.f11738d == null) {
                this.f11738d = t;
                return;
            }
            this.f11739e = true;
            this.f11737c.dispose();
            this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11737c, cVar)) {
                this.f11737c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public z2(h.a.g0<? extends T> g0Var, T t) {
        this.a = g0Var;
        this.f11735b = t;
    }

    @Override // h.a.k0
    public void b(h.a.n0<? super T> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11735b));
    }
}
