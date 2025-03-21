package g.a;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    static final long f13834a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    static final class a implements Runnable, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f13835a;

        /* renamed from: b, reason: collision with root package name */
        final c f13836b;

        /* renamed from: c, reason: collision with root package name */
        Thread f13837c;

        a(Runnable runnable, c cVar) {
            this.f13835a = runnable;
            this.f13836b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f13837c == Thread.currentThread()) {
                c cVar = this.f13836b;
                if (cVar instanceof g.a.y0.g.i) {
                    ((g.a.y0.g.i) cVar).a();
                    return;
                }
            }
            this.f13836b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13836b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13837c = Thread.currentThread();
            try {
                this.f13835a.run();
            } finally {
                dispose();
                this.f13837c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    static class b implements Runnable, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f13838a;

        /* renamed from: b, reason: collision with root package name */
        @g.a.t0.f
        final c f13839b;

        /* renamed from: c, reason: collision with root package name */
        @g.a.t0.f
        volatile boolean f13840c;

        b(@g.a.t0.f Runnable runnable, @g.a.t0.f c cVar) {
            this.f13838a = runnable;
            this.f13839b = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f13840c = true;
            this.f13839b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13840c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13840c) {
                return;
            }
            try {
                this.f13838a.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f13839b.dispose();
                throw g.a.y0.j.k.c(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    public static abstract class c implements g.a.u0.c {

        /* compiled from: Scheduler.java */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            @g.a.t0.f
            final Runnable f13841a;

            /* renamed from: b, reason: collision with root package name */
            @g.a.t0.f
            final g.a.y0.a.k f13842b;

            /* renamed from: c, reason: collision with root package name */
            final long f13843c;

            /* renamed from: d, reason: collision with root package name */
            long f13844d;

            /* renamed from: e, reason: collision with root package name */
            long f13845e;

            /* renamed from: f, reason: collision with root package name */
            long f13846f;

            a(long j2, @g.a.t0.f Runnable runnable, long j3, @g.a.t0.f g.a.y0.a.k kVar, long j4) {
                this.f13841a = runnable;
                this.f13842b = kVar;
                this.f13843c = j4;
                this.f13845e = j3;
                this.f13846f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                this.f13841a.run();
                if (this.f13842b.isDisposed()) {
                    return;
                }
                long a2 = c.this.a(TimeUnit.NANOSECONDS);
                long j3 = j0.f13834a;
                long j4 = a2 + j3;
                long j5 = this.f13845e;
                if (j4 >= j5) {
                    long j6 = this.f13843c;
                    if (a2 < j5 + j6 + j3) {
                        long j7 = this.f13846f;
                        long j8 = this.f13844d + 1;
                        this.f13844d = j8;
                        j2 = j7 + (j8 * j6);
                        this.f13845e = a2;
                        this.f13842b.replace(c.this.a(this, j2 - a2, TimeUnit.NANOSECONDS));
                    }
                }
                long j9 = this.f13843c;
                long j10 = a2 + j9;
                long j11 = this.f13844d + 1;
                this.f13844d = j11;
                this.f13846f = j10 - (j9 * j11);
                j2 = j10;
                this.f13845e = a2;
                this.f13842b.replace(c.this.a(this, j2 - a2, TimeUnit.NANOSECONDS));
            }
        }

        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @g.a.t0.f
        public abstract g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit);

        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, @g.a.t0.f TimeUnit timeUnit) {
            g.a.y0.a.k kVar = new g.a.y0.a.k();
            g.a.y0.a.k kVar2 = new g.a.y0.a.k(kVar);
            Runnable a2 = g.a.c1.a.a(runnable);
            long nanos = timeUnit.toNanos(j3);
            long a3 = a(TimeUnit.NANOSECONDS);
            g.a.u0.c a4 = a(new a(a3 + timeUnit.toNanos(j2), a2, a3, kVar2, nanos), j2, timeUnit);
            if (a4 == g.a.y0.a.e.INSTANCE) {
                return a4;
            }
            kVar.replace(a4);
            return kVar2;
        }

        public long a(@g.a.t0.f TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public static long d() {
        return f13834a;
    }

    public long a(@g.a.t0.f TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @g.a.t0.f
    public abstract c a();

    public void b() {
    }

    public void c() {
    }

    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(g.a.c1.a.a(runnable), a2);
        a2.a(aVar, j2, timeUnit);
        return aVar;
    }

    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, @g.a.t0.f TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(g.a.c1.a.a(runnable), a2);
        g.a.u0.c a3 = a2.a(bVar, j2, j3, timeUnit);
        return a3 == g.a.y0.a.e.INSTANCE ? a3 : bVar;
    }

    @g.a.t0.f
    public <S extends j0 & g.a.u0.c> S a(@g.a.t0.f g.a.x0.o<l<l<g.a.c>>, g.a.c> oVar) {
        return new g.a.y0.g.p(oVar, this);
    }
}
