package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDoAfterNext.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class k0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super T> f11443b;

    /* JADX INFO: compiled from: ObservableDoAfterNext.java */
    static final class a<T> extends h.a.y0.d.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.g<? super T> f11444f;

        a(h.a.i0<? super T> i0Var, h.a.x0.g<? super T> gVar) {
            super(i0Var);
            this.f11444f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            this.a.onNext((Object) t);
            if (this.f10464e == 0) {
                try {
                    this.f11444f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.f10462c.poll();
            if (tPoll != null) {
                this.f11444f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public k0(h.a.g0<T> g0Var, h.a.x0.g<? super T> gVar) {
        super(g0Var);
        this.f11443b = gVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11443b));
    }
}
