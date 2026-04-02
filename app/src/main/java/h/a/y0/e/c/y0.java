package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeOnErrorComplete.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y0<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super Throwable> f11204b;

    /* JADX INFO: compiled from: MaybeOnErrorComplete.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super Throwable> f11205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11206c;

        a(h.a.v<? super T> vVar, h.a.x0.r<? super Throwable> rVar) {
            this.a = vVar;
            this.f11205b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11206c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11206c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            try {
                if (this.f11205b.test(th)) {
                    this.a.onComplete();
                } else {
                    this.a.onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11206c, cVar)) {
                this.f11206c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public y0(h.a.y<T> yVar, h.a.x0.r<? super Throwable> rVar) {
        super(yVar);
        this.f11204b = rVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11204b));
    }
}
