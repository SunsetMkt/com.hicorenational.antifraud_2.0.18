package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeFilterSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y<T> extends h.a.s<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11201b;

    /* JADX INFO: compiled from: MaybeFilterSingle.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11203c;

        a(h.a.v<? super T> vVar, h.a.x0.r<? super T> rVar) {
            this.a = vVar;
            this.f11202b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.u0.c cVar = this.f11203c;
            this.f11203c = h.a.y0.a.d.DISPOSED;
            cVar.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11203c.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11203c, cVar)) {
                this.f11203c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                if (this.f11202b.test(t)) {
                    this.a.onSuccess(t);
                } else {
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public y(h.a.q0<T> q0Var, h.a.x0.r<? super T> rVar) {
        this.a = q0Var;
        this.f11201b = rVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11201b));
    }
}
