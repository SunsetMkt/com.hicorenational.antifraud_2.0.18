package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybePeek.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b1<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super h.a.u0.c> f11098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super T> f11099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.g<? super Throwable> f11100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.a f11101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.x0.a f11102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.x0.a f11103g;

    public b1(h.a.y<T> yVar, h.a.x0.g<? super h.a.u0.c> gVar, h.a.x0.g<? super T> gVar2, h.a.x0.g<? super Throwable> gVar3, h.a.x0.a aVar, h.a.x0.a aVar2, h.a.x0.a aVar3) {
        super(yVar);
        this.f11098b = gVar;
        this.f11099c = gVar2;
        this.f11100d = gVar3;
        this.f11101e = aVar;
        this.f11102f = aVar2;
        this.f11103g = aVar3;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this));
    }

    /* JADX INFO: compiled from: MaybePeek.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b1<T> f11104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11105c;

        a(h.a.v<? super T> vVar, b1<T> b1Var) {
            this.a = vVar;
            this.f11104b = b1Var;
        }

        void a(Throwable th) {
            try {
                this.f11104b.f11100d.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.f11105c = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
            a();
        }

        @Override // h.a.u0.c
        public void dispose() {
            try {
                this.f11104b.f11103g.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
            this.f11105c.dispose();
            this.f11105c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11105c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            if (this.f11105c == h.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                this.f11104b.f11101e.run();
                this.f11105c = h.a.y0.a.d.DISPOSED;
                this.a.onComplete();
                a();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                a(th);
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            if (this.f11105c == h.a.y0.a.d.DISPOSED) {
                h.a.c1.a.b(th);
            } else {
                a(th);
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11105c, cVar)) {
                try {
                    this.f11104b.f11098b.accept(cVar);
                    this.f11105c = cVar;
                    this.a.onSubscribe(this);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cVar.dispose();
                    this.f11105c = h.a.y0.a.d.DISPOSED;
                    h.a.y0.a.e.error(th, this.a);
                }
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            if (this.f11105c == h.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                this.f11104b.f11099c.accept(t);
                this.f11105c = h.a.y0.a.d.DISPOSED;
                this.a.onSuccess(t);
                a();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                a(th);
            }
        }

        void a() {
            try {
                this.f11104b.f11102f.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }
    }
}
