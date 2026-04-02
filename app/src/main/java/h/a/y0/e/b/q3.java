package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableSkipWhile.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.r<? super T> f10917c;

    /* JADX INFO: compiled from: FlowableSkipWhile.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f10918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10920d;

        a(j.d.c<? super T> cVar, h.a.x0.r<? super T> rVar) {
            this.a = cVar;
            this.f10918b = rVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10919c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10920d) {
                this.a.onNext(t);
                return;
            }
            try {
                if (this.f10918b.test(t)) {
                    this.f10919c.request(1L);
                } else {
                    this.f10920d = true;
                    this.a.onNext(t);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10919c.cancel();
                this.a.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10919c, dVar)) {
                this.f10919c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10919c.request(j2);
        }
    }

    public q3(h.a.l<T> lVar, h.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f10917c = rVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10917c));
    }
}
