package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableScan.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<T, T, T> f10639c;

    /* JADX INFO: compiled from: FlowableScan.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<T, T, T> f10640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f10642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f10643e;

        a(j.d.c<? super T> cVar, h.a.x0.c<T, T, T> cVar2) {
            this.a = cVar;
            this.f10640b = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10641c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10643e) {
                return;
            }
            this.f10643e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10643e) {
                h.a.c1.a.b(th);
            } else {
                this.f10643e = true;
                this.a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10643e) {
                return;
            }
            j.d.c<? super T> cVar = this.a;
            T t2 = this.f10642d;
            if (t2 == null) {
                this.f10642d = t;
                cVar.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) h.a.y0.b.b.a((Object) this.f10640b.apply(t2, t), "The value returned by the accumulator is null");
                this.f10642d = r4;
                cVar.onNext(r4);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10641c.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10641c, dVar)) {
                this.f10641c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10641c.request(j2);
        }
    }

    public e3(h.a.l<T> lVar, h.a.x0.c<T, T, T> cVar) {
        super(lVar);
        this.f10639c = cVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10639c));
    }
}
