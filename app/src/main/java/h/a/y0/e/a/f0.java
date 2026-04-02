package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableOnErrorComplete.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.r<? super Throwable> f10507b;

    /* JADX INFO: compiled from: CompletableOnErrorComplete.java */
    final class a implements h.a.f {
        private final h.a.f a;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.f
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            try {
                if (f0.this.f10507b.test(th)) {
                    this.a.onComplete();
                } else {
                    this.a.onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    public f0(h.a.i iVar, h.a.x0.r<? super Throwable> rVar) {
        this.a = iVar;
        this.f10507b = rVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }
}
