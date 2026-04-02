package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDoOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super h.a.u0.c> f11878b;

    /* JADX INFO: compiled from: SingleDoOnSubscribe.java */
    static final class a<T> implements h.a.n0<T> {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.g<? super h.a.u0.c> f11879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11880c;

        a(h.a.n0<? super T> n0Var, h.a.x0.g<? super h.a.u0.c> gVar) {
            this.a = n0Var;
            this.f11879b = gVar;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            if (this.f11880c) {
                h.a.c1.a.b(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            try {
                this.f11879b.accept(cVar);
                this.a.onSubscribe(cVar);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11880c = true;
                cVar.dispose();
                h.a.y0.a.e.error(th, this.a);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            if (this.f11880c) {
                return;
            }
            this.a.onSuccess(t);
        }
    }

    public r(h.a.q0<T> q0Var, h.a.x0.g<? super h.a.u0.c> gVar) {
        this.a = q0Var;
        this.f11878b = gVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11878b));
    }
}
