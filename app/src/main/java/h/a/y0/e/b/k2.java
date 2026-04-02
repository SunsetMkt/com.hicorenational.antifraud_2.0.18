package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableOnErrorReturn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends T> f10740c;

    /* JADX INFO: compiled from: FlowableOnErrorReturn.java */
    static final class a<T> extends h.a.y0.h.s<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final h.a.x0.o<? super Throwable, ? extends T> valueSupplier;

        a(j.d.c<? super T> cVar, h.a.x0.o<? super Throwable, ? extends T> oVar) {
            super(cVar);
            this.valueSupplier = oVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            try {
                complete(h.a.y0.b.b.a((Object) this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.actual.onError(new h.a.v0.a(th, th2));
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext((Object) t);
        }
    }

    public k2(h.a.l<T> lVar, h.a.x0.o<? super Throwable, ? extends T> oVar) {
        super(lVar);
        this.f10740c = oVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10740c));
    }
}
