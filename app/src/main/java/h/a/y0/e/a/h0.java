package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableResumeNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.o<? super Throwable, ? extends h.a.i> f10524b;

    /* JADX INFO: compiled from: CompletableResumeNext.java */
    final class a implements h.a.f {
        final h.a.f a;

        /* JADX INFO: renamed from: b */
        final h.a.y0.a.k f10525b;

        /* JADX INFO: renamed from: h.a.y0.e.a.h0$a$a */
        /* JADX INFO: compiled from: CompletableResumeNext.java */
        final class C0185a implements h.a.f {
            C0185a() {
            }

            @Override // h.a.f
            public void onComplete() {
                a.this.a.onComplete();
            }

            @Override // h.a.f
            public void onError(Throwable th) {
                a.this.a.onError(th);
            }

            @Override // h.a.f
            public void onSubscribe(h.a.u0.c cVar) {
                a.this.f10525b.update(cVar);
            }
        }

        a(h.a.f fVar, h.a.y0.a.k kVar) {
            this.a = fVar;
            this.f10525b = kVar;
        }

        @Override // h.a.f
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            try {
                h.a.i iVarApply = h0.this.f10524b.apply(th);
                if (iVarApply != null) {
                    iVarApply.a(new C0185a());
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th2, th));
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.f10525b.update(cVar);
        }
    }

    public h0(h.a.i iVar, h.a.x0.o<? super Throwable, ? extends h.a.i> oVar) {
        this.a = iVar;
        this.f10524b = oVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        fVar.onSubscribe(kVar);
        this.a.a(new a(fVar, kVar));
    }
}
