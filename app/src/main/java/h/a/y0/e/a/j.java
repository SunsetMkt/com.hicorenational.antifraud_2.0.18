package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableDisposeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.j0 f10529b;

    /* JADX INFO: compiled from: CompletableDisposeOn.java */
    static final class a implements h.a.f, h.a.u0.c, Runnable {
        final h.a.f a;

        /* JADX INFO: renamed from: b */
        final h.a.j0 f10530b;

        /* JADX INFO: renamed from: c */
        h.a.u0.c f10531c;

        /* JADX INFO: renamed from: d */
        volatile boolean f10532d;

        a(h.a.f fVar, h.a.j0 j0Var) {
            this.a = fVar;
            this.f10530b = j0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10532d = true;
            this.f10530b.a(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10532d;
        }

        @Override // h.a.f
        public void onComplete() {
            if (this.f10532d) {
                return;
            }
            this.a.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            if (this.f10532d) {
                h.a.c1.a.b(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f10531c, cVar)) {
                this.f10531c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10531c.dispose();
            this.f10531c = h.a.y0.a.d.DISPOSED;
        }
    }

    public j(h.a.i iVar, h.a.j0 j0Var) {
        this.a = iVar;
        this.f10529b = j0Var;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar, this.f10529b));
    }
}
