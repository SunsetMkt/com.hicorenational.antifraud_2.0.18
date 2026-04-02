package h.a.y0.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CompletableTimeout.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final long f10533b;

    /* JADX INFO: renamed from: c */
    final TimeUnit f10534c;

    /* JADX INFO: renamed from: d */
    final h.a.j0 f10535d;

    /* JADX INFO: renamed from: e */
    final h.a.i f10536e;

    /* JADX INFO: compiled from: CompletableTimeout.java */
    final class a implements Runnable {
        private final AtomicBoolean a;

        /* JADX INFO: renamed from: b */
        final h.a.u0.b f10537b;

        /* JADX INFO: renamed from: c */
        final h.a.f f10538c;

        /* JADX INFO: renamed from: h.a.y0.e.a.j0$a$a */
        /* JADX INFO: compiled from: CompletableTimeout.java */
        final class C0186a implements h.a.f {
            C0186a() {
            }

            @Override // h.a.f
            public void onComplete() {
                a.this.f10537b.dispose();
                a.this.f10538c.onComplete();
            }

            @Override // h.a.f
            public void onError(Throwable th) {
                a.this.f10537b.dispose();
                a.this.f10538c.onError(th);
            }

            @Override // h.a.f
            public void onSubscribe(h.a.u0.c cVar) {
                a.this.f10537b.b(cVar);
            }
        }

        a(AtomicBoolean atomicBoolean, h.a.u0.b bVar, h.a.f fVar) {
            this.a = atomicBoolean;
            this.f10537b = bVar;
            this.f10538c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.compareAndSet(false, true)) {
                this.f10537b.a();
                h.a.i iVar = j0.this.f10536e;
                if (iVar == null) {
                    this.f10538c.onError(new TimeoutException());
                } else {
                    iVar.a(new C0186a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: CompletableTimeout.java */
    static final class b implements h.a.f {
        private final h.a.u0.b a;

        /* JADX INFO: renamed from: b */
        private final AtomicBoolean f10540b;

        /* JADX INFO: renamed from: c */
        private final h.a.f f10541c;

        b(h.a.u0.b bVar, AtomicBoolean atomicBoolean, h.a.f fVar) {
            this.a = bVar;
            this.f10540b = atomicBoolean;
            this.f10541c = fVar;
        }

        @Override // h.a.f
        public void onComplete() {
            if (this.f10540b.compareAndSet(false, true)) {
                this.a.dispose();
                this.f10541c.onComplete();
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            if (!this.f10540b.compareAndSet(false, true)) {
                h.a.c1.a.b(th);
            } else {
                this.a.dispose();
                this.f10541c.onError(th);
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.b(cVar);
        }
    }

    public j0(h.a.i iVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, h.a.i iVar2) {
        this.a = iVar;
        this.f10533b = j2;
        this.f10534c = timeUnit;
        this.f10535d = j0Var;
        this.f10536e = iVar2;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        h.a.u0.b bVar = new h.a.u0.b();
        fVar.onSubscribe(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        bVar.b(this.f10535d.a(new a(atomicBoolean, bVar, fVar), this.f10533b, this.f10534c));
        this.a.a(new b(bVar, atomicBoolean, fVar));
    }
}
