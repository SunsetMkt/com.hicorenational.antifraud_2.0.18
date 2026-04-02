package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableSingleMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k3<T> extends h.a.s<T> implements h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: compiled from: FlowableSingleMaybe.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f10743d;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10741b.cancel();
            this.f10741b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10741b == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10742c) {
                return;
            }
            this.f10742c = true;
            this.f10741b = h.a.y0.i.j.CANCELLED;
            T t = this.f10743d;
            this.f10743d = null;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10742c) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10742c = true;
            this.f10741b = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10742c) {
                return;
            }
            if (this.f10743d == null) {
                this.f10743d = t;
                return;
            }
            this.f10742c = true;
            this.f10741b.cancel();
            this.f10741b = h.a.y0.i.j.CANCELLED;
            this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10741b, dVar)) {
                this.f10741b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public k3(h.a.l<T> lVar) {
        this.a = lVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a((h.a.q) new a(vVar));
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new j3(this.a, null));
    }
}
