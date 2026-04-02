package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableAll.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends h.a.y0.e.b.a<T, Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.r<? super T> f10647c;

    /* JADX INFO: compiled from: FlowableAll.java */
    static final class a<T> extends h.a.y0.i.f<Boolean> implements h.a.q<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        boolean done;
        final h.a.x0.r<? super T> predicate;
        j.d.d s;

        a(j.d.c<? super Boolean> cVar, h.a.x0.r<? super T> rVar) {
            super(cVar);
            this.predicate = rVar;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(true);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                if (this.predicate.test(t)) {
                    return;
                }
                this.done = true;
                this.s.cancel();
                complete(false);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public f(h.a.l<T> lVar, h.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f10647c = rVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super Boolean> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10647c));
    }
}
