package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableDoOnEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.g<? super Throwable> f10546b;

    /* JADX INFO: compiled from: CompletableDoOnEvent.java */
    final class a implements h.a.f {
        private final h.a.f a;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.f
        public void onComplete() {
            try {
                l.this.f10546b.accept(null);
                this.a.onComplete();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            try {
                l.this.f10546b.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.a.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    public l(h.a.i iVar, h.a.x0.g<? super Throwable> gVar) {
        this.a = iVar;
        this.f10546b = gVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }
}
