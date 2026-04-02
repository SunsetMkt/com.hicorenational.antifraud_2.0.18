package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeFilter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11197b;

    /* JADX INFO: compiled from: MaybeFilter.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11199c;

        a(h.a.v<? super T> vVar, h.a.x0.r<? super T> rVar) {
            this.a = vVar;
            this.f11198b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.u0.c cVar = this.f11199c;
            this.f11199c = h.a.y0.a.d.DISPOSED;
            cVar.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11199c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11199c, cVar)) {
                this.f11199c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                if (this.f11198b.test(t)) {
                    this.a.onSuccess(t);
                } else {
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public x(h.a.y<T> yVar, h.a.x0.r<? super T> rVar) {
        super(yVar);
        this.f11197b = rVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11197b));
    }
}
