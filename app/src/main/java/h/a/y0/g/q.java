package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11987d = "rx2.single-priority";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11988e = "RxSingleScheduler";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final k f11989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final ScheduledExecutorService f11990g = Executors.newScheduledThreadPool(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f11991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f11992c;

    /* JADX INFO: compiled from: SingleScheduler.java */
    static final class a extends j0.c {
        final ScheduledExecutorService a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.u0.b f11993b = new h.a.u0.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f11994c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            if (this.f11994c) {
                return h.a.y0.a.e.INSTANCE;
            }
            n nVar = new n(h.a.c1.a.a(runnable), this.f11993b);
            this.f11993b.b(nVar);
            try {
                nVar.setFuture(j2 <= 0 ? this.a.submit((Callable) nVar) : this.a.schedule((Callable) nVar, j2, timeUnit));
                return nVar;
            } catch (RejectedExecutionException e2) {
                dispose();
                h.a.c1.a.b(e2);
                return h.a.y0.a.e.INSTANCE;
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f11994c) {
                return;
            }
            this.f11994c = true;
            this.f11993b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11994c;
        }
    }

    static {
        f11990g.shutdown();
        f11989f = new k(f11988e, Math.max(1, Math.min(10, Integer.getInteger(f11987d, 5).intValue())), true);
    }

    public q() {
        this(f11989f);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return o.a(threadFactory);
    }

    @Override // h.a.j0
    public void b() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f11992c.get();
        ScheduledExecutorService scheduledExecutorService2 = f11990g;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.f11992c.getAndSet(scheduledExecutorService2)) == f11990g) {
            return;
        }
        andSet.shutdownNow();
    }

    @Override // h.a.j0
    public void c() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorServiceA = null;
        do {
            scheduledExecutorService = this.f11992c.get();
            if (scheduledExecutorService != f11990g) {
                if (scheduledExecutorServiceA != null) {
                    scheduledExecutorServiceA.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorServiceA == null) {
                scheduledExecutorServiceA = a(this.f11991b);
            }
        } while (!this.f11992c.compareAndSet(scheduledExecutorService, scheduledExecutorServiceA));
    }

    public q(ThreadFactory threadFactory) {
        this.f11992c = new AtomicReference<>();
        this.f11991b = threadFactory;
        this.f11992c.lazySet(a(threadFactory));
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return new a(this.f11992c.get());
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        m mVar = new m(h.a.c1.a.a(runnable));
        try {
            if (j2 <= 0) {
                futureSchedule = this.f11992c.get().submit(mVar);
            } else {
                futureSchedule = this.f11992c.get().schedule(mVar, j2, timeUnit);
            }
            mVar.setFuture(futureSchedule);
            return mVar;
        } catch (RejectedExecutionException e2) {
            h.a.c1.a.b(e2);
            return h.a.y0.a.e.INSTANCE;
        }
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableA = h.a.c1.a.a(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f11992c.get();
            f fVar = new f(runnableA, scheduledExecutorService);
            try {
                if (j2 <= 0) {
                    futureSchedule = scheduledExecutorService.submit(fVar);
                } else {
                    futureSchedule = scheduledExecutorService.schedule(fVar, j2, timeUnit);
                }
                fVar.a(futureSchedule);
                return fVar;
            } catch (RejectedExecutionException e2) {
                h.a.c1.a.b(e2);
                return h.a.y0.a.e.INSTANCE;
            }
        }
        l lVar = new l(runnableA);
        try {
            lVar.setFuture(this.f11992c.get().scheduleAtFixedRate(lVar, j2, j3, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e3) {
            h.a.c1.a.b(e3);
            return h.a.y0.a.e.INSTANCE;
        }
    }
}
