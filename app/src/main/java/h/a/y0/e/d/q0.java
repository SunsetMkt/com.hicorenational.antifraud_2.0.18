package h.a.y0.e.d;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableElementAtSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0<T> extends h.a.k0<T> implements h.a.y0.c.d<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f11572c;

    /* JADX INFO: compiled from: ObservableElementAtSingle.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final T f11574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f11576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11577f;

        a(h.a.n0<? super T> n0Var, long j2, T t) {
            this.a = n0Var;
            this.f11573b = j2;
            this.f11574c = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11575d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11575d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11577f) {
                return;
            }
            this.f11577f = true;
            T t = this.f11574c;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11577f) {
                h.a.c1.a.b(th);
            } else {
                this.f11577f = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11577f) {
                return;
            }
            long j2 = this.f11576e;
            if (j2 != this.f11573b) {
                this.f11576e = j2 + 1;
                return;
            }
            this.f11577f = true;
            this.f11575d.dispose();
            this.a.onSuccess(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11575d, cVar)) {
                this.f11575d = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public q0(h.a.g0<T> g0Var, long j2, T t) {
        this.a = g0Var;
        this.f11571b = j2;
        this.f11572c = t;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<T> a() {
        return h.a.c1.a.a(new o0(this.a, this.f11571b, this.f11572c, true));
    }

    @Override // h.a.k0
    public void b(h.a.n0<? super T> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11571b, this.f11572c));
    }
}
