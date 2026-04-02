package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f10725c;

    /* JADX INFO: compiled from: FlowableSingle.java */
    static final class a<T> extends h.a.y0.i.f<T> implements h.a.q<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        j.d.d s;

        a(j.d.c<? super T> cVar, T t) {
            super(cVar);
            this.defaultValue = t;
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
            T t = this.value;
            this.value = null;
            if (t == null) {
                t = this.defaultValue;
            }
            if (t == null) {
                this.actual.onComplete();
            } else {
                complete(t);
            }
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
            if (this.value == null) {
                this.value = t;
                return;
            }
            this.done = true;
            this.s.cancel();
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
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

    public j3(h.a.l<T> lVar, T t) {
        super(lVar);
        this.f10725c = t;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10725c));
    }
}
