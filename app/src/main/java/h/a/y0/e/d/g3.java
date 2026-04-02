package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableSwitchIfEmpty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<? extends T> f11380b;

    /* JADX INFO: compiled from: ObservableSwitchIfEmpty.java */
    static final class a<T> implements h.a.i0<T> {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.g0<? extends T> f11381b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11383d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.y0.a.k f11382c = new h.a.y0.a.k();

        a(h.a.i0<? super T> i0Var, h.a.g0<? extends T> g0Var) {
            this.a = i0Var;
            this.f11381b = g0Var;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (!this.f11383d) {
                this.a.onComplete();
            } else {
                this.f11383d = false;
                this.f11381b.subscribe(this);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11383d) {
                this.f11383d = false;
            }
            this.a.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.f11382c.update(cVar);
        }
    }

    public g3(h.a.g0<T> g0Var, h.a.g0<? extends T> g0Var2) {
        super(g0Var);
        this.f11380b = g0Var2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var, this.f11380b);
        i0Var.onSubscribe(aVar.f11382c);
        this.a.subscribe(aVar);
    }
}
