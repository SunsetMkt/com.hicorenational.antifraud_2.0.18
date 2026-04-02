package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableFilter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11631b;

    /* JADX INFO: compiled from: ObservableFilter.java */
    static final class a<T> extends h.a.y0.d.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.r<? super T> f11632f;

        a(h.a.i0<? super T> i0Var, h.a.x0.r<? super T> rVar) {
            super(i0Var);
            this.f11632f = rVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f10464e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                if (this.f11632f.test(t)) {
                    this.a.onNext((Object) t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f10462c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f11632f.test(tPoll));
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public t0(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f11631b = rVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11631b));
    }
}
