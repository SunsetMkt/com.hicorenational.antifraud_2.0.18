package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDoOnEach.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super T> f11469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super Throwable> f11470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.a f11471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.a f11472e;

    /* JADX INFO: compiled from: ObservableDoOnEach.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.g<? super T> f11473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.x0.g<? super Throwable> f11474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final h.a.x0.a f11475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final h.a.x0.a f11476e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        h.a.u0.c f11477f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f11478g;

        a(h.a.i0<? super T> i0Var, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2) {
            this.a = i0Var;
            this.f11473b = gVar;
            this.f11474c = gVar2;
            this.f11475d = aVar;
            this.f11476e = aVar2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11477f.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11477f.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11478g) {
                return;
            }
            try {
                this.f11475d.run();
                this.f11478g = true;
                this.a.onComplete();
                try {
                    this.f11476e.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                onError(th2);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11478g) {
                h.a.c1.a.b(th);
                return;
            }
            this.f11478g = true;
            try {
                this.f11474c.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.a.onError(th);
            try {
                this.f11476e.run();
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                h.a.c1.a.b(th3);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11478g) {
                return;
            }
            try {
                this.f11473b.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11477f.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11477f, cVar)) {
                this.f11477f = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public m0(h.a.g0<T> g0Var, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2) {
        super(g0Var);
        this.f11469b = gVar;
        this.f11470c = gVar2;
        this.f11471d = aVar;
        this.f11472e = aVar2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11469b, this.f11470c, this.f11471d, this.f11472e));
    }
}
