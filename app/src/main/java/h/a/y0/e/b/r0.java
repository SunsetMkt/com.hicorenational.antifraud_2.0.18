package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableElementAtMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r0<T> extends h.a.s<T> implements h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f10933b;

    /* JADX INFO: compiled from: FlowableElementAtMaybe.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f10934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f10936d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f10937e;

        a(h.a.v<? super T> vVar, long j2) {
            this.a = vVar;
            this.f10934b = j2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10935c.cancel();
            this.f10935c = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10935c == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10935c = h.a.y0.i.j.CANCELLED;
            if (this.f10937e) {
                return;
            }
            this.f10937e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10937e) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10937e = true;
            this.f10935c = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10937e) {
                return;
            }
            long j2 = this.f10936d;
            if (j2 != this.f10934b) {
                this.f10936d = j2 + 1;
                return;
            }
            this.f10937e = true;
            this.f10935c.cancel();
            this.f10935c = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10935c, dVar)) {
                this.f10935c = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public r0(h.a.l<T> lVar, long j2) {
        this.a = lVar;
        this.f10933b = j2;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a((h.a.q) new a(vVar, this.f10933b));
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new q0(this.a, this.f10933b, null, false));
    }
}
