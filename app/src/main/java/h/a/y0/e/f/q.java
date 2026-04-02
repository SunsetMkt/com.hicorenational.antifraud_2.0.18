package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDoOnEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.b<? super T, ? super Throwable> f11874b;

    /* JADX INFO: compiled from: SingleDoOnEvent.java */
    final class a implements h.a.n0<T> {
        private final h.a.n0<? super T> a;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            try {
                q.this.f11874b.a(null, th);
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
            try {
                q.this.f11874b.a(t, null);
                this.a.onSuccess(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public q(h.a.q0<T> q0Var, h.a.x0.b<? super T, ? super Throwable> bVar) {
        this.a = q0Var;
        this.f11874b = bVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
