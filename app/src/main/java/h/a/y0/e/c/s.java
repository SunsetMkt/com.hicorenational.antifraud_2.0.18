package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeDoOnEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.b<? super T, ? super Throwable> f11186b;

    /* JADX INFO: compiled from: MaybeDoOnEvent.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.b<? super T, ? super Throwable> f11187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11188c;

        a(h.a.v<? super T> vVar, h.a.x0.b<? super T, ? super Throwable> bVar) {
            this.a = vVar;
            this.f11187b = bVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11188c.dispose();
            this.f11188c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11188c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11188c = h.a.y0.a.d.DISPOSED;
            try {
                this.f11187b.a(null, null);
                this.a.onComplete();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11188c = h.a.y0.a.d.DISPOSED;
            try {
                this.f11187b.a(null, th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11188c, cVar)) {
                this.f11188c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11188c = h.a.y0.a.d.DISPOSED;
            try {
                this.f11187b.a(t, null);
                this.a.onSuccess(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public s(h.a.y<T> yVar, h.a.x0.b<? super T, ? super Throwable> bVar) {
        super(yVar);
        this.f11186b = bVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11186b));
    }
}
