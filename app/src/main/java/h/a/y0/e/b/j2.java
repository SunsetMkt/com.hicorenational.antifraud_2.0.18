package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableOnErrorNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends j.d.b<? extends T>> f10718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10719d;

    /* JADX INFO: compiled from: FlowableOnErrorNext.java */
    static final class a<T> implements h.a.q<T> {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super Throwable, ? extends j.d.b<? extends T>> f10720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f10721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final h.a.y0.i.i f10722d = new h.a.y0.i.i();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f10723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f10724f;

        a(j.d.c<? super T> cVar, h.a.x0.o<? super Throwable, ? extends j.d.b<? extends T>> oVar, boolean z) {
            this.a = cVar;
            this.f10720b = oVar;
            this.f10721c = z;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10724f) {
                return;
            }
            this.f10724f = true;
            this.f10723e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10723e) {
                if (this.f10724f) {
                    h.a.c1.a.b(th);
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.f10723e = true;
            if (this.f10721c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                j.d.b<? extends T> bVarApply = this.f10720b.apply(th);
                if (bVarApply != null) {
                    bVarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Publisher is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10724f) {
                return;
            }
            this.a.onNext(t);
            if (this.f10723e) {
                return;
            }
            this.f10722d.produced(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            this.f10722d.setSubscription(dVar);
        }
    }

    public j2(h.a.l<T> lVar, h.a.x0.o<? super Throwable, ? extends j.d.b<? extends T>> oVar, boolean z) {
        super(lVar);
        this.f10718c = oVar;
        this.f10719d = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a aVar = new a(cVar, this.f10718c, this.f10719d);
        cVar.onSubscribe(aVar.f10722d);
        this.f10561b.a((h.a.q) aVar);
    }
}
