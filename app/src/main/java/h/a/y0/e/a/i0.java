package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.j0 f10528b;

    /* JADX INFO: compiled from: CompletableSubscribeOn.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final h.a.f actual;
        final h.a.i source;
        final h.a.y0.a.k task = new h.a.y0.a.k();

        a(h.a.f fVar, h.a.i iVar) {
            this.actual = fVar;
            this.source = iVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            this.task.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.f
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public i0(h.a.i iVar, h.a.j0 j0Var) {
        this.a = iVar;
        this.f10528b = j0Var;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        a aVar = new a(fVar, this.a);
        fVar.onSubscribe(aVar);
        aVar.task.replace(this.f10528b.a(aVar));
    }
}
