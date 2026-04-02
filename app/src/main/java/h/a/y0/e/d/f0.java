package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDelaySubscriptionOther.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0<T, U> extends h.a.b0<T> {
    final h.a.g0<? extends T> a;

    /* JADX INFO: renamed from: b */
    final h.a.g0<U> f11342b;

    /* JADX INFO: compiled from: ObservableDelaySubscriptionOther.java */
    final class a implements h.a.i0<U> {
        final h.a.y0.a.k a;

        /* JADX INFO: renamed from: b */
        final h.a.i0<? super T> f11343b;

        /* JADX INFO: renamed from: c */
        boolean f11344c;

        /* JADX INFO: renamed from: h.a.y0.e.d.f0$a$a */
        /* JADX INFO: compiled from: ObservableDelaySubscriptionOther.java */
        final class C0213a implements h.a.i0<T> {
            C0213a() {
            }

            @Override // h.a.i0
            public void onComplete() {
                a.this.f11343b.onComplete();
            }

            @Override // h.a.i0
            public void onError(Throwable th) {
                a.this.f11343b.onError(th);
            }

            @Override // h.a.i0
            public void onNext(T t) {
                a.this.f11343b.onNext(t);
            }

            @Override // h.a.i0
            public void onSubscribe(h.a.u0.c cVar) {
                a.this.a.update(cVar);
            }
        }

        a(h.a.y0.a.k kVar, h.a.i0<? super T> i0Var) {
            this.a = kVar;
            this.f11343b = i0Var;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11344c) {
                return;
            }
            this.f11344c = true;
            f0.this.a.subscribe(new C0213a());
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11344c) {
                h.a.c1.a.b(th);
            } else {
                this.f11344c = true;
                this.f11343b.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(U u) {
            onComplete();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.update(cVar);
        }
    }

    public f0(h.a.g0<? extends T> g0Var, h.a.g0<U> g0Var2) {
        this.a = g0Var;
        this.f11342b = g0Var2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        this.f11342b.subscribe(new a(kVar, i0Var));
    }
}
