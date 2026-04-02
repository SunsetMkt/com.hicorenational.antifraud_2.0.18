package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleContains.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends h.a.k0<Boolean> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f11829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.d<Object, Object> f11830c;

    /* JADX INFO: compiled from: SingleContains.java */
    final class a implements h.a.n0<T> {
        private final h.a.n0<? super Boolean> a;

        a(h.a.n0<? super Boolean> n0Var) {
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
                this.a.onSuccess(Boolean.valueOf(c.this.f11830c.a(t, c.this.f11829b)));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public c(h.a.q0<T> q0Var, Object obj, h.a.x0.d<Object, Object> dVar) {
        this.a = q0Var;
        this.f11829b = obj;
        this.f11830c = dVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        this.a.a(new a(n0Var));
    }
}
