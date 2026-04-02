package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDematerialize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0<T> extends h.a.y0.e.d.a<h.a.a0<T>, T> {

    /* JADX INFO: compiled from: ObservableDematerialize.java */
    static final class a<T> implements h.a.i0<h.a.a0<T>>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f11365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11366c;

        a(h.a.i0<? super T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.i0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(h.a.a0<T> a0Var) {
            if (this.f11365b) {
                if (a0Var.d()) {
                    h.a.c1.a.b(a0Var.a());
                }
            } else if (a0Var.d()) {
                this.f11366c.dispose();
                onError(a0Var.a());
            } else if (!a0Var.c()) {
                this.a.onNext(a0Var.b());
            } else {
                this.f11366c.dispose();
                onComplete();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11366c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11366c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11365b) {
                return;
            }
            this.f11365b = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11365b) {
                h.a.c1.a.b(th);
            } else {
                this.f11365b = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11366c, cVar)) {
                this.f11366c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g0(h.a.g0<h.a.a0<T>> g0Var) {
        super(g0Var);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
