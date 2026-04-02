package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableReduceMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f2<T> extends h.a.s<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.c<T, T, T> f11346b;

    /* JADX INFO: compiled from: ObservableReduceMaybe.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<T, T, T> f11347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f11349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h.a.u0.c f11350e;

        a(h.a.v<? super T> vVar, h.a.x0.c<T, T, T> cVar) {
            this.a = vVar;
            this.f11347b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11350e.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11350e.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11348c) {
                return;
            }
            this.f11348c = true;
            T t = this.f11349d;
            this.f11349d = null;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onComplete();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11348c) {
                h.a.c1.a.b(th);
                return;
            }
            this.f11348c = true;
            this.f11349d = null;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11348c) {
                return;
            }
            T t2 = this.f11349d;
            if (t2 == null) {
                this.f11349d = t;
                return;
            }
            try {
                this.f11349d = (T) h.a.y0.b.b.a((Object) this.f11347b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11350e.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11350e, cVar)) {
                this.f11350e = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public f2(h.a.g0<T> g0Var, h.a.x0.c<T, T, T> cVar) {
        this.a = g0Var;
        this.f11346b = cVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.subscribe(new a(vVar, this.f11346b));
    }
}
