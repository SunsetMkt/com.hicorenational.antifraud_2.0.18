package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDoOnError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super Throwable> f11870b;

    /* JADX INFO: compiled from: SingleDoOnError.java */
    final class a implements h.a.n0<T> {
        private final h.a.n0<? super T> a;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            try {
                p.this.f11870b.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public p(h.a.q0<T> q0Var, h.a.x0.g<? super Throwable> gVar) {
        this.a = q0Var;
        this.f11870b = gVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
