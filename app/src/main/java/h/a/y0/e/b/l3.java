package h.a.y0.e.b;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: FlowableSingleSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l3<T> extends h.a.k0<T> implements h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f10768b;

    /* JADX INFO: compiled from: FlowableSingleSingle.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f10769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        T f10772e;

        a(h.a.n0<? super T> n0Var, T t) {
            this.a = n0Var;
            this.f10769b = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10770c.cancel();
            this.f10770c = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10770c == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10771d) {
                return;
            }
            this.f10771d = true;
            this.f10770c = h.a.y0.i.j.CANCELLED;
            T t = this.f10772e;
            this.f10772e = null;
            if (t == null) {
                t = this.f10769b;
            }
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10771d) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10771d = true;
            this.f10770c = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10771d) {
                return;
            }
            if (this.f10772e == null) {
                this.f10772e = t;
                return;
            }
            this.f10771d = true;
            this.f10770c.cancel();
            this.f10770c = h.a.y0.i.j.CANCELLED;
            this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10770c, dVar)) {
                this.f10770c = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public l3(h.a.l<T> lVar, T t) {
        this.a = lVar;
        this.f10768b = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a((h.a.q) new a(n0Var, this.f10768b));
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new j3(this.a, this.f10768b));
    }
}
