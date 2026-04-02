package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDelaySubscriptionOther.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0<T, U> extends h.a.l<T> {

    /* JADX INFO: renamed from: b */
    final j.d.b<? extends T> f10691b;

    /* JADX INFO: renamed from: c */
    final j.d.b<U> f10692c;

    /* JADX INFO: compiled from: FlowableDelaySubscriptionOther.java */
    final class a implements h.a.q<U> {
        final h.a.y0.i.i a;

        /* JADX INFO: renamed from: b */
        final j.d.c<? super T> f10693b;

        /* JADX INFO: renamed from: c */
        boolean f10694c;

        /* JADX INFO: renamed from: h.a.y0.e.b.h0$a$a */
        /* JADX INFO: compiled from: FlowableDelaySubscriptionOther.java */
        final class C0192a implements j.d.d {
            private final j.d.d a;

            C0192a(j.d.d dVar) {
                this.a = dVar;
            }

            @Override // j.d.d
            public void cancel() {
                this.a.cancel();
            }

            @Override // j.d.d
            public void request(long j2) {
            }
        }

        /* JADX INFO: compiled from: FlowableDelaySubscriptionOther.java */
        final class b implements h.a.q<T> {
            b() {
            }

            @Override // j.d.c
            public void onComplete() {
                a.this.f10693b.onComplete();
            }

            @Override // j.d.c
            public void onError(Throwable th) {
                a.this.f10693b.onError(th);
            }

            @Override // j.d.c
            public void onNext(T t) {
                a.this.f10693b.onNext(t);
            }

            @Override // h.a.q
            public void onSubscribe(j.d.d dVar) {
                a.this.a.setSubscription(dVar);
            }
        }

        a(h.a.y0.i.i iVar, j.d.c<? super T> cVar) {
            this.a = iVar;
            this.f10693b = cVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10694c) {
                return;
            }
            this.f10694c = true;
            h0.this.f10691b.subscribe(new b());
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10694c) {
                h.a.c1.a.b(th);
            } else {
                this.f10694c = true;
                this.f10693b.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(U u) {
            onComplete();
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            this.a.setSubscription(new C0192a(dVar));
            dVar.request(i.q2.t.m0.f12222b);
        }
    }

    public h0(j.d.b<? extends T> bVar, j.d.b<U> bVar2) {
        this.f10691b = bVar;
        this.f10692c = bVar2;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.i iVar = new h.a.y0.i.i();
        cVar.onSubscribe(iVar);
        this.f10692c.subscribe(new a(iVar, cVar));
    }
}
