package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletablePeek.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.g<? super h.a.u0.c> f10509b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.g<? super Throwable> f10510c;

    /* JADX INFO: renamed from: d */
    final h.a.x0.a f10511d;

    /* JADX INFO: renamed from: e */
    final h.a.x0.a f10512e;

    /* JADX INFO: renamed from: f */
    final h.a.x0.a f10513f;

    /* JADX INFO: renamed from: g */
    final h.a.x0.a f10514g;

    /* JADX INFO: compiled from: CompletablePeek.java */
    final class a implements h.a.f, h.a.u0.c {
        final h.a.f a;

        /* JADX INFO: renamed from: b */
        h.a.u0.c f10515b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        void a() {
            try {
                g0.this.f10513f.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            try {
                g0.this.f10514g.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
            this.f10515b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10515b.isDisposed();
        }

        @Override // h.a.f
        public void onComplete() {
            if (this.f10515b == h.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                g0.this.f10511d.run();
                g0.this.f10512e.run();
                this.a.onComplete();
                a();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            if (this.f10515b == h.a.y0.a.d.DISPOSED) {
                h.a.c1.a.b(th);
                return;
            }
            try {
                g0.this.f10510c.accept(th);
                g0.this.f10512e.run();
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.a.onError(th);
            a();
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            try {
                g0.this.f10509b.accept(cVar);
                if (h.a.y0.a.d.validate(this.f10515b, cVar)) {
                    this.f10515b = cVar;
                    this.a.onSubscribe(this);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cVar.dispose();
                this.f10515b = h.a.y0.a.d.DISPOSED;
                h.a.y0.a.e.error(th, this.a);
            }
        }
    }

    public g0(h.a.i iVar, h.a.x0.g<? super h.a.u0.c> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2, h.a.x0.a aVar3, h.a.x0.a aVar4) {
        this.a = iVar;
        this.f10509b = gVar;
        this.f10510c = gVar2;
        this.f10511d = aVar;
        this.f10512e = aVar2;
        this.f10513f = aVar3;
        this.f10514g = aVar4;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }
}
