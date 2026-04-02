package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableOnErrorNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z1<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends T>> f11728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11729c;

    /* JADX INFO: compiled from: ObservableOnErrorNext.java */
    static final class a<T> implements h.a.i0<T> {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends T>> f11730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f11731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final h.a.y0.a.k f11732d = new h.a.y0.a.k();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11734f;

        a(h.a.i0<? super T> i0Var, h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends T>> oVar, boolean z) {
            this.a = i0Var;
            this.f11730b = oVar;
            this.f11731c = z;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11734f) {
                return;
            }
            this.f11734f = true;
            this.f11733e = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11733e) {
                if (this.f11734f) {
                    h.a.c1.a.b(th);
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.f11733e = true;
            if (this.f11731c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                h.a.g0<? extends T> g0VarApply = this.f11730b.apply(th);
                if (g0VarApply != null) {
                    g0VarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11734f) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.f11732d.replace(cVar);
        }
    }

    public z1(h.a.g0<T> g0Var, h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends T>> oVar, boolean z) {
        super(g0Var);
        this.f11728b = oVar;
        this.f11729c = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var, this.f11728b, this.f11729c);
        i0Var.onSubscribe(aVar.f11732d);
        this.a.subscribe(aVar);
    }
}
