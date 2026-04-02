package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u1<T, U> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends U> f11649b;

    /* JADX INFO: compiled from: ObservableMap.java */
    static final class a<T, U> extends h.a.y0.d.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends U> f11650f;

        a(h.a.i0<? super U> i0Var, h.a.x0.o<? super T, ? extends U> oVar) {
            super(i0Var);
            this.f11650f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f10463d) {
                return;
            }
            if (this.f10464e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext((Object) h.a.y0.b.b.a(this.f11650f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public U poll() throws Exception {
            T tPoll = this.f10462c.poll();
            if (tPoll != null) {
                return (U) h.a.y0.b.b.a(this.f11650f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public u1(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends U> oVar) {
        super(g0Var);
        this.f11649b = oVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super U> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11649b));
    }
}
