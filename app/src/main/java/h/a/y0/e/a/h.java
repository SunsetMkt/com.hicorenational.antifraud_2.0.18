package h.a.y0.e.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CompletableDelay.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final long f10517b;

    /* JADX INFO: renamed from: c */
    final TimeUnit f10518c;

    /* JADX INFO: renamed from: d */
    final h.a.j0 f10519d;

    /* JADX INFO: renamed from: e */
    final boolean f10520e;

    /* JADX INFO: compiled from: CompletableDelay.java */
    final class a implements h.a.f {
        private final h.a.u0.b a;

        /* JADX INFO: renamed from: b */
        final h.a.f f10521b;

        /* JADX INFO: renamed from: h.a.y0.e.a.h$a$a */
        /* JADX INFO: compiled from: CompletableDelay.java */
        final class RunnableC0184a implements Runnable {
            RunnableC0184a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f10521b.onComplete();
            }
        }

        /* JADX INFO: compiled from: CompletableDelay.java */
        final class b implements Runnable {
            private final Throwable a;

            b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f10521b.onError(this.a);
            }
        }

        a(h.a.u0.b bVar, h.a.f fVar) {
            this.a = bVar;
            this.f10521b = fVar;
        }

        @Override // h.a.f
        public void onComplete() {
            h.a.u0.b bVar = this.a;
            h.a.j0 j0Var = h.this.f10519d;
            RunnableC0184a runnableC0184a = new RunnableC0184a();
            h hVar = h.this;
            bVar.b(j0Var.a(runnableC0184a, hVar.f10517b, hVar.f10518c));
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            h.a.u0.b bVar = this.a;
            h.a.j0 j0Var = h.this.f10519d;
            b bVar2 = new b(th);
            h hVar = h.this;
            bVar.b(j0Var.a(bVar2, hVar.f10520e ? hVar.f10517b : 0L, h.this.f10518c));
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.b(cVar);
            this.f10521b.onSubscribe(this.a);
        }
    }

    public h(h.a.i iVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, boolean z) {
        this.a = iVar;
        this.f10517b = j2;
        this.f10518c = timeUnit;
        this.f10519d = j0Var;
        this.f10520e = z;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(new h.a.u0.b(), fVar));
    }
}
