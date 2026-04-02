package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDoOnSuccess.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super T> f11882b;

    /* JADX INFO: compiled from: SingleDoOnSuccess.java */
    final class a implements h.a.n0<T> {
        private final h.a.n0<? super T> a;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                s.this.f11882b.accept(t);
                this.a.onSuccess(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public s(h.a.q0<T> q0Var, h.a.x0.g<? super T> gVar) {
        this.a = q0Var;
        this.f11882b = gVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
