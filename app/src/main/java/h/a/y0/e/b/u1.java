package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableLastMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u1<T> extends h.a.s<T> {
    final j.d.b<T> a;

    /* JADX INFO: compiled from: FlowableLastMaybe.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f11009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f11010c;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11009b.cancel();
            this.f11009b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11009b == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f11009b = h.a.y0.i.j.CANCELLED;
            T t = this.f11010c;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.f11010c = null;
                this.a.onSuccess(t);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f11009b = h.a.y0.i.j.CANCELLED;
            this.f11010c = null;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.f11010c = t;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11009b, dVar)) {
                this.f11009b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public u1(j.d.b<T> bVar) {
        this.a = bVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.subscribe(new a(vVar));
    }
}
