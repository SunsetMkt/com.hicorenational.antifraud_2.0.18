package h.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Scheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: compiled from: Scheduler.java */
    static final class a implements Runnable, h.a.u0.c {
        final Runnable a;

        /* JADX INFO: renamed from: b */
        final c f10403b;

        /* JADX INFO: renamed from: c */
        Thread f10404c;

        a(Runnable runnable, c cVar) {
            this.a = runnable;
            this.f10403b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f10404c == Thread.currentThread()) {
                c cVar = this.f10403b;
                if (cVar instanceof h.a.y0.g.i) {
                    ((h.a.y0.g.i) cVar).a();
                    return;
                }
            }
            this.f10403b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10403b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10404c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.f10404c = null;
            }
        }
    }

    /* JADX INFO: compiled from: Scheduler.java */
    static class b implements Runnable, h.a.u0.c {
        final Runnable a;

        /* JADX INFO: renamed from: b */
        @h.a.t0.f
        final c f10405b;

        /* JADX INFO: renamed from: c */
        @h.a.t0.f
        volatile boolean f10406c;

        b(@h.a.t0.f Runnable runnable, @h.a.t0.f c cVar) {
            this.a = runnable;
            this.f10405b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10406c = true;
            this.f10405b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10406c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10406c) {
                return;
            }
            try {
                this.a.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10405b.dispose();
                throw h.a.y0.j.k.c(th);
            }
        }
    }

    /* JADX INFO: compiled from: Scheduler.java */
    public static abstract class c implements h.a.u0.c {

        /* JADX INFO: compiled from: Scheduler.java */
        final class a implements Runnable {

            @h.a.t0.f
            final Runnable a;

            /* JADX INFO: renamed from: b */
            @h.a.t0.f
            final h.a.y0.a.k f10407b;

            /* JADX INFO: renamed from: c */
            final long f10408c;

            /* JADX INFO: renamed from: d */
            long f10409d;

            /* JADX INFO: renamed from: e */
            long f10410e;

            /* JADX INFO: renamed from: f */
            long f10411f;

            a(long j2, @h.a.t0.f Runnable runnable, long j3, @h.a.t0.f h.a.y0.a.k kVar, long j4) {
                this.a = runnable;
                this.f10407b = kVar;
                this.f10408c = j4;
                this.f10410e = j3;
                this.f10411f = j2;
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                long j2;
                this.a.run();
                if (this.f10407b.isDisposed()) {
                    return;
                }
                long jA = c.this.a(TimeUnit.NANOSECONDS);
                long j3 = j0.a;
                long j4 = jA + j3;
                long j5 = this.f10410e;
                if (j4 >= j5) {
                    long j6 = this.f10408c;
                    if (jA >= j5 + j6 + j3) {
                        long j7 = this.f10408c;
                        long j8 = jA + j7;
                        long j9 = this.f10409d + 1;
                        this.f10409d = j9;
                        this.f10411f = j8 - (j7 * j9);
                        j2 = j8;
                    } else {
                        long j10 = this.f10411f;
                        long j11 = this.f10409d + 1;
                        this.f10409d = j11;
                        j2 = j10 + (j11 * j6);
                    }
                }
                this.f10410e = jA;
                this.f10407b.replace(c.this.a(this, j2 - jA, TimeUnit.NANOSECONDS));
            }
        }

        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @h.a.t0.f
        public abstract h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit);

        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, @h.a.t0.f TimeUnit timeUnit) {
            h.a.y0.a.k kVar = new h.a.y0.a.k();
            h.a.y0.a.k kVar2 = new h.a.y0.a.k(kVar);
            Runnable runnableA = h.a.c1.a.a(runnable);
            long nanos = timeUnit.toNanos(j3);
            long jA = a(TimeUnit.NANOSECONDS);
            h.a.u0.c cVarA = a(new a(jA + timeUnit.toNanos(j2), runnableA, jA, kVar2, nanos), j2, timeUnit);
            if (cVarA == h.a.y0.a.e.INSTANCE) {
                return cVarA;
            }
            kVar.replace(cVarA);
            return kVar2;
        }

        public long a(@h.a.t0.f TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public static long d() {
        return a;
    }

    public long a(@h.a.t0.f TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @h.a.t0.f
    public abstract c a();

    public void b() {
    }

    public void c() {
    }

    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
        c cVarA = a();
        a aVar = new a(h.a.c1.a.a(runnable), cVarA);
        cVarA.a(aVar, j2, timeUnit);
        return aVar;
    }

    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, @h.a.t0.f TimeUnit timeUnit) {
        c cVarA = a();
        b bVar = new b(h.a.c1.a.a(runnable), cVarA);
        h.a.u0.c cVarA2 = cVarA.a(bVar, j2, j3, timeUnit);
        return cVarA2 == h.a.y0.a.e.INSTANCE ? cVarA2 : bVar;
    }

    @h.a.t0.f
    public <S extends j0 & h.a.u0.c> S a(@h.a.t0.f h.a.x0.o<l<l<h.a.c>>, h.a.c> oVar) {
        return new h.a.y0.g.p(oVar, this);
    }
}
