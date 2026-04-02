package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleOnErrorReturn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0<T> extends h.a.k0<T> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends T> f11850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f11851c;

    /* JADX INFO: compiled from: SingleOnErrorReturn.java */
    final class a implements h.a.n0<T> {
        private final h.a.n0<? super T> a;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            T tApply;
            k0 k0Var = k0.this;
            h.a.x0.o<? super Throwable, ? extends T> oVar = k0Var.f11850b;
            if (oVar != null) {
                try {
                    tApply = oVar.apply(th);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    this.a.onError(new h.a.v0.a(th, th2));
                    return;
                }
            } else {
                tApply = k0Var.f11851c;
            }
            if (tApply != null) {
                this.a.onSuccess(tApply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.a.onError(nullPointerException);
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

    public k0(h.a.q0<? extends T> q0Var, h.a.x0.o<? super Throwable, ? extends T> oVar, T t) {
        this.a = q0Var;
        this.f11850b = oVar;
        this.f11851c = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
