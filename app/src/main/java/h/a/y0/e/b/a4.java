package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a4<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.r<? super T> f10570c;

    /* JADX INFO: compiled from: FlowableTakeUntilPredicate.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f10571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10573d;

        a(j.d.c<? super T> cVar, h.a.x0.r<? super T> rVar) {
            this.a = cVar;
            this.f10571b = rVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10572c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10573d) {
                return;
            }
            this.f10573d = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10573d) {
                h.a.c1.a.b(th);
            } else {
                this.f10573d = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10573d) {
                return;
            }
            this.a.onNext(t);
            try {
                if (this.f10571b.test(t)) {
                    this.f10573d = true;
                    this.f10572c.cancel();
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10572c.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10572c, dVar)) {
                this.f10572c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10572c.request(j2);
        }
    }

    public a4(h.a.l<T> lVar, h.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f10570c = rVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10570c));
    }
}
