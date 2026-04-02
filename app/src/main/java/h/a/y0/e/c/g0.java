package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeFlatten.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0<T, R> extends h.a.y0.e.c.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> f11135b;

    /* JADX INFO: compiled from: MaybeFlatten.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 4375739915521278546L;
        final h.a.v<? super R> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11136d;
        final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> mapper;

        /* JADX INFO: renamed from: h.a.y0.e.c.g0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeFlatten.java */
        final class C0205a implements h.a.v<R> {
            C0205a() {
            }

            @Override // h.a.v
            public void onComplete() {
                a.this.actual.onComplete();
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(a.this, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(R r) {
                a.this.actual.onSuccess(r);
            }
        }

        a(h.a.v<? super R> vVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar) {
            this.actual = vVar;
            this.mapper = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            this.f11136d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
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
            if (h.a.y0.a.d.validate(this.f11136d, cVar)) {
                this.f11136d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                h.a.y yVar = (h.a.y) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                yVar.a(new C0205a());
            } catch (Exception e2) {
                h.a.v0.b.b(e2);
                this.actual.onError(e2);
            }
        }
    }

    public g0(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar) {
        super(yVar);
        this.f11135b = oVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        this.a.a(new a(vVar, this.f11135b));
    }
}
