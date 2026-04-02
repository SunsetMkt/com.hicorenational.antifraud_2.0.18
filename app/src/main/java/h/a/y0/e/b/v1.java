package h.a.y0.e.b;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: FlowableLastSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v1<T> extends h.a.k0<T> {
    final j.d.b<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f11018b;

    /* JADX INFO: compiled from: FlowableLastSingle.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f11019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f11020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f11021d;

        a(h.a.n0<? super T> n0Var, T t) {
            this.a = n0Var;
            this.f11019b = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11020c.cancel();
            this.f11020c = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11020c == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f11020c = h.a.y0.i.j.CANCELLED;
            T t = this.f11021d;
            if (t != null) {
                this.f11021d = null;
                this.a.onSuccess(t);
                return;
            }
            T t2 = this.f11019b;
            if (t2 != null) {
                this.a.onSuccess(t2);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f11020c = h.a.y0.i.j.CANCELLED;
            this.f11021d = null;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.f11021d = t;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11020c, dVar)) {
                this.f11020c = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public v1(j.d.b<T> bVar, T t) {
        this.a = bVar;
        this.f11018b = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11018b));
    }
}
