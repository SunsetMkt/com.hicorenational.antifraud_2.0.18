package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDematerialize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0<T> extends h.a.y0.e.b.a<h.a.a0<T>, T> {

    /* JADX INFO: compiled from: FlowableDematerialize.java */
    static final class a<T> implements h.a.q<h.a.a0<T>>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f10704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10705c;

        a(j.d.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // j.d.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(h.a.a0<T> a0Var) {
            if (this.f10704b) {
                if (a0Var.d()) {
                    h.a.c1.a.b(a0Var.a());
                }
            } else if (a0Var.d()) {
                this.f10705c.cancel();
                onError(a0Var.a());
            } else if (!a0Var.c()) {
                this.a.onNext(a0Var.b());
            } else {
                this.f10705c.cancel();
                onComplete();
            }
        }

        @Override // j.d.d
        public void cancel() {
            this.f10705c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10704b) {
                return;
            }
            this.f10704b = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10704b) {
                h.a.c1.a.b(th);
            } else {
                this.f10704b = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10705c, dVar)) {
                this.f10705c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10705c.request(j2);
        }
    }

    public i0(h.a.l<h.a.a0<T>> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
