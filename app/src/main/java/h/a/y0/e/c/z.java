package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeFlatMapBiSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z<T, U, R> extends h.a.y0.e.c.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.y<? extends U>> f11207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<? super T, ? super U, ? extends R> f11208c;

    /* JADX INFO: compiled from: MaybeFlatMapBiSelector.java */
    static final class a<T, U, R> implements h.a.v<T>, h.a.u0.c {
        final h.a.x0.o<? super T, ? extends h.a.y<? extends U>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C0207a<T, U, R> f11209b;

        /* JADX INFO: renamed from: h.a.y0.e.c.z$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeFlatMapBiSelector.java */
        static final class C0207a<T, U, R> extends AtomicReference<h.a.u0.c> implements h.a.v<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final h.a.v<? super R> actual;
            final h.a.x0.c<? super T, ? super U, ? extends R> resultSelector;
            T value;

            C0207a(h.a.v<? super R> vVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
                this.actual = vVar;
                this.resultSelector = cVar;
            }

            @Override // h.a.v
            public void onComplete() {
                this.actual.onComplete();
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                this.actual.onError(th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    this.actual.onSuccess(h.a.y0.b.b.a(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        a(h.a.v<? super R> vVar, h.a.x0.o<? super T, ? extends h.a.y<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
            this.f11209b = new C0207a<>(vVar, cVar);
            this.a = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.f11209b);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.f11209b.get());
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11209b.actual.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11209b.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this.f11209b, cVar)) {
                this.f11209b.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                h.a.y yVar = (h.a.y) h.a.y0.b.b.a(this.a.apply(t), "The mapper returned a null MaybeSource");
                if (h.a.y0.a.d.replace(this.f11209b, null)) {
                    C0207a<T, U, R> c0207a = this.f11209b;
                    c0207a.value = t;
                    yVar.a(c0207a);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11209b.actual.onError(th);
            }
        }
    }

    public z(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends h.a.y<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        super(yVar);
        this.f11207b = oVar;
        this.f11208c = cVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        this.a.a(new a(vVar, this.f11207b, this.f11208c));
    }
}
