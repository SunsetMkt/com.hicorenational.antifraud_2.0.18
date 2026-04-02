package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableReduce.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<T, T, T> f10885c;

    /* JADX INFO: compiled from: FlowableReduce.java */
    static final class a<T> extends h.a.y0.i.f<T> implements h.a.q<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final h.a.x0.c<T, T, T> reducer;
        j.d.d s;

        a(j.d.c<? super T> cVar, h.a.x0.c<T, T, T> cVar2) {
            super(cVar);
            this.reducer = cVar2;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
            this.s = h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            j.d.d dVar = this.s;
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (dVar == jVar) {
                return;
            }
            this.s = jVar;
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            j.d.d dVar = this.s;
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (dVar == jVar) {
                h.a.c1.a.b(th);
            } else {
                this.s = jVar;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.s == h.a.y0.i.j.CANCELLED) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) h.a.y0.b.b.a((Object) this.reducer.apply(t2, t), "The reducer returned a null value");
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

    public p2(h.a.l<T> lVar, h.a.x0.c<T, T, T> cVar) {
        super(lVar);
        this.f10885c = cVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10885c));
    }
}
