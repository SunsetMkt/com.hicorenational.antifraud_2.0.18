package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableOnErrorReturn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends T> f11217b;

    /* JADX INFO: compiled from: ObservableOnErrorReturn.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super Throwable, ? extends T> f11218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11219c;

        a(h.a.i0<? super T> i0Var, h.a.x0.o<? super Throwable, ? extends T> oVar) {
            this.a = i0Var;
            this.f11218b = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11219c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11219c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            try {
                T tApply = this.f11218b.apply(th);
                if (tApply != null) {
                    this.a.onNext(tApply);
                    this.a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.a.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11219c, cVar)) {
                this.f11219c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public a2(h.a.g0<T> g0Var, h.a.x0.o<? super Throwable, ? extends T> oVar) {
        super(g0Var);
        this.f11217b = oVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11217b));
    }
}
