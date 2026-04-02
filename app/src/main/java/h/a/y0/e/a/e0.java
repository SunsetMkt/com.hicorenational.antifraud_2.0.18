package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableObserveOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.j0 f10506b;

    /* JADX INFO: compiled from: CompletableObserveOn.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final h.a.f actual;
        Throwable error;
        final h.a.j0 scheduler;

        a(h.a.f fVar, h.a.j0 j0Var) {
            this.actual = fVar;
            this.scheduler = j0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.f
        public void onComplete() {
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.error = th;
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th == null) {
                this.actual.onComplete();
            } else {
                this.error = null;
                this.actual.onError(th);
            }
        }
    }

    public e0(h.a.i iVar, h.a.j0 j0Var) {
        this.a = iVar;
        this.f10506b = j0Var;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar, this.f10506b));
    }
}
