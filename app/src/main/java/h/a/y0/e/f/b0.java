package h.a.y0.e.f;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SingleFromPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0<T> extends h.a.k0<T> {
    final j.d.b<? extends T> a;

    /* JADX INFO: compiled from: SingleFromPublisher.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f11825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f11826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f11828e;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11828e = true;
            this.f11825b.cancel();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11828e;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11827d) {
                return;
            }
            this.f11827d = true;
            T t = this.f11826c;
            this.f11826c = null;
            if (t == null) {
                this.a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11827d) {
                h.a.c1.a.b(th);
                return;
            }
            this.f11827d = true;
            this.f11826c = null;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f11827d) {
                return;
            }
            if (this.f11826c == null) {
                this.f11826c = t;
                return;
            }
            this.f11825b.cancel();
            this.f11827d = true;
            this.f11826c = null;
            this.a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11825b, dVar)) {
                this.f11825b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public b0(j.d.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.subscribe(new a(n0Var));
    }
}
