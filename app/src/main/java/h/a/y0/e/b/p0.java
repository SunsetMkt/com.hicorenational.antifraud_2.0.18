package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDoOnLifecycle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.a.x0.g<? super j.d.d> f10867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h.a.x0.q f10868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h.a.x0.a f10869e;

    /* JADX INFO: compiled from: FlowableDoOnLifecycle.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.g<? super j.d.d> f10870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.x0.q f10871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final h.a.x0.a f10872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        j.d.d f10873e;

        a(j.d.c<? super T> cVar, h.a.x0.g<? super j.d.d> gVar, h.a.x0.q qVar, h.a.x0.a aVar) {
            this.a = cVar;
            this.f10870b = gVar;
            this.f10872d = aVar;
            this.f10871c = qVar;
        }

        @Override // j.d.d
        public void cancel() {
            try {
                this.f10872d.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
            this.f10873e.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10873e != h.a.y0.i.j.CANCELLED) {
                this.a.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10873e != h.a.y0.i.j.CANCELLED) {
                this.a.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            try {
                this.f10870b.accept(dVar);
                if (h.a.y0.i.j.validate(this.f10873e, dVar)) {
                    this.f10873e = dVar;
                    this.a.onSubscribe(this);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dVar.cancel();
                this.f10873e = h.a.y0.i.j.CANCELLED;
                h.a.y0.i.g.error(th, this.a);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            try {
                this.f10871c.a(j2);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
            this.f10873e.request(j2);
        }
    }

    public p0(h.a.l<T> lVar, h.a.x0.g<? super j.d.d> gVar, h.a.x0.q qVar, h.a.x0.a aVar) {
        super(lVar);
        this.f10867c = gVar;
        this.f10868d = qVar;
        this.f10869e = aVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10867c, this.f10868d, this.f10869e));
    }
}
