package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableCount.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y<T> extends h.a.y0.e.d.a<T, Long> {

    /* JADX INFO: compiled from: ObservableCount.java */
    static final class a implements h.a.i0<Object>, h.a.u0.c {
        final h.a.i0<? super Long> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f11710c;

        a(h.a.i0<? super Long> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11709b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11709b.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onNext(Long.valueOf(this.f11710c));
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            this.f11710c++;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11709b, cVar)) {
                this.f11709b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public y(h.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super Long> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
