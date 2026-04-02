package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0<T, K> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, K> f11431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.d<? super K, ? super K> f11432c;

    /* JADX INFO: compiled from: ObservableDistinctUntilChanged.java */
    static final class a<T, K> extends h.a.y0.d.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.o<? super T, K> f11433f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.d<? super K, ? super K> f11434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        K f11435h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f11436i;

        a(h.a.i0<? super T> i0Var, h.a.x0.o<? super T, K> oVar, h.a.x0.d<? super K, ? super K> dVar) {
            super(i0Var);
            this.f11433f = oVar;
            this.f11434g = dVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f10463d) {
                return;
            }
            if (this.f10464e != 0) {
                this.a.onNext((Object) t);
                return;
            }
            try {
                K kApply = this.f11433f.apply(t);
                if (this.f11436i) {
                    boolean zA = this.f11434g.a(this.f11435h, kApply);
                    this.f11435h = kApply;
                    if (zA) {
                        return;
                    }
                } else {
                    this.f11436i = true;
                    this.f11435h = kApply;
                }
                this.a.onNext((Object) t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f10462c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f11433f.apply(tPoll);
                if (!this.f11436i) {
                    this.f11436i = true;
                    this.f11435h = kApply;
                    return tPoll;
                }
                if (!this.f11434g.a(this.f11435h, kApply)) {
                    this.f11435h = kApply;
                    return tPoll;
                }
                this.f11435h = kApply;
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public j0(h.a.g0<T> g0Var, h.a.x0.o<? super T, K> oVar, h.a.x0.d<? super K, ? super K> dVar) {
        super(g0Var);
        this.f11431b = oVar;
        this.f11432c = dVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11431b, this.f11432c));
    }
}
