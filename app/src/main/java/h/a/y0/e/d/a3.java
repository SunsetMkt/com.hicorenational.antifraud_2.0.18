package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableSkip.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11220b;

    /* JADX INFO: compiled from: ObservableSkip.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f11221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11222c;

        a(h.a.i0<? super T> i0Var, long j2) {
            this.a = i0Var;
            this.f11221b = j2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11222c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11222c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            long j2 = this.f11221b;
            if (j2 != 0) {
                this.f11221b = j2 - 1;
            } else {
                this.a.onNext(t);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.f11222c = cVar;
            this.a.onSubscribe(this);
        }
    }

    public a3(h.a.g0<T> g0Var, long j2) {
        super(g0Var);
        this.f11220b = j2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11220b));
    }
}
