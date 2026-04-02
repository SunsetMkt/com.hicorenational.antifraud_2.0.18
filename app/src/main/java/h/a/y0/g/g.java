package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: IoScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11948d = "RxCachedThreadScheduler";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final k f11949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f11950f = "RxCachedWorkerPoolEvictor";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final k f11951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f11952h = 60;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final TimeUnit f11953i = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final c f11954j = new c(new k("RxCachedThreadSchedulerShutdown"));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f11955k = "rx2.io-priority";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final a f11956l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f11957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<a> f11958c;

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class b extends j0.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f11964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c f11965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f11966d = new AtomicBoolean();
        private final h.a.u0.b a = new h.a.u0.b();

        b(a aVar) {
            this.f11964b = aVar;
            this.f11965c = aVar.b();
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            return this.a.isDisposed() ? h.a.y0.a.e.INSTANCE : this.f11965c.a(runnable, j2, timeUnit, this.a);
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f11966d.compareAndSet(false, true)) {
                this.a.dispose();
                this.f11964b.a(this.f11965c);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11966d.get();
        }
    }

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class c extends i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f11967c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f11967c = 0L;
        }

        public void a(long j2) {
            this.f11967c = j2;
        }

        public long b() {
            return this.f11967c;
        }
    }

    static {
        f11954j.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger(f11955k, 5).intValue()));
        f11949e = new k(f11948d, iMax);
        f11951g = new k(f11950f, iMax);
        f11956l = new a(0L, null, f11949e);
        f11956l.d();
    }

    public g() {
        this(f11949e);
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return new b(this.f11958c.get());
    }

    @Override // h.a.j0
    public void b() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f11958c.get();
            aVar2 = f11956l;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f11958c.compareAndSet(aVar, aVar2));
        aVar.d();
    }

    @Override // h.a.j0
    public void c() {
        a aVar = new a(f11952h, f11953i, this.f11957b);
        if (this.f11958c.compareAndSet(f11956l, aVar)) {
            return;
        }
        aVar.d();
    }

    public int e() {
        return this.f11958c.get().f11960c.b();
    }

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class a implements Runnable {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f11959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.u0.b f11960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f11961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Future<?> f11962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ThreadFactory f11963f;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.a = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f11959b = new ConcurrentLinkedQueue<>();
            this.f11960c = new h.a.u0.b();
            this.f11963f = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, g.f11951g);
                long j3 = this.a;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f11961d = scheduledExecutorServiceNewScheduledThreadPool;
            this.f11962e = scheduledFutureScheduleWithFixedDelay;
        }

        void a(c cVar) {
            cVar.a(c() + this.a);
            this.f11959b.offer(cVar);
        }

        c b() {
            if (this.f11960c.isDisposed()) {
                return g.f11954j;
            }
            while (!this.f11959b.isEmpty()) {
                c cVarPoll = this.f11959b.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f11963f);
            this.f11960c.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.f11960c.dispose();
            Future<?> future = this.f11962e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f11961d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        void a() {
            if (this.f11959b.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.f11959b) {
                if (cVar.b() > jC) {
                    return;
                }
                if (this.f11959b.remove(cVar)) {
                    this.f11960c.a(cVar);
                }
            }
        }
    }

    public g(ThreadFactory threadFactory) {
        this.f11957b = threadFactory;
        this.f11958c = new AtomicReference<>(f11956l);
        c();
    }
}
