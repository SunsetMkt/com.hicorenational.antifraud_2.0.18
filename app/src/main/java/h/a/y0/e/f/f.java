package h.a.y0.e.f;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SingleDelay.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends h.a.k0<T> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f11836e;

    /* JADX INFO: compiled from: SingleDelay.java */
    final class a implements h.a.n0<T> {
        private final h.a.y0.a.k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.n0<? super T> f11837b;

        /* JADX INFO: renamed from: h.a.y0.e.f.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleDelay.java */
        final class RunnableC0227a implements Runnable {
            private final Throwable a;

            RunnableC0227a(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f11837b.onError(this.a);
            }
        }

        /* JADX INFO: compiled from: SingleDelay.java */
        final class b implements Runnable {
            private final T a;

            b(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f11837b.onSuccess(this.a);
            }
        }

        a(h.a.y0.a.k kVar, h.a.n0<? super T> n0Var) {
            this.a = kVar;
            this.f11837b = n0Var;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            h.a.y0.a.k kVar = this.a;
            h.a.j0 j0Var = f.this.f11835d;
            RunnableC0227a runnableC0227a = new RunnableC0227a(th);
            f fVar = f.this;
            kVar.replace(j0Var.a(runnableC0227a, fVar.f11836e ? fVar.f11833b : 0L, f.this.f11834c));
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.replace(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            h.a.y0.a.k kVar = this.a;
            h.a.j0 j0Var = f.this.f11835d;
            b bVar = new b(t);
            f fVar = f.this;
            kVar.replace(j0Var.a(bVar, fVar.f11833b, fVar.f11834c));
        }
    }

    public f(h.a.q0<? extends T> q0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, boolean z) {
        this.a = q0Var;
        this.f11833b = j2;
        this.f11834c = timeUnit;
        this.f11835d = j0Var;
        this.f11836e = z;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        n0Var.onSubscribe(kVar);
        this.a.a(new a(kVar, n0Var));
    }
}
