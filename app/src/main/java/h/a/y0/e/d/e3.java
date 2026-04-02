package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableSkipWhile.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11330b;

    /* JADX INFO: compiled from: ObservableSkipWhile.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11333d;

        a(h.a.i0<? super T> i0Var, h.a.x0.r<? super T> rVar) {
            this.a = i0Var;
            this.f11331b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11332c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11332c.isDisposed();
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
            if (this.f11333d) {
                this.a.onNext(t);
                return;
            }
            try {
                if (this.f11331b.test(t)) {
                    return;
                }
                this.f11333d = true;
                this.a.onNext(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11332c.dispose();
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11332c, cVar)) {
                this.f11332c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public e3(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f11330b = rVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11330b));
    }
}
