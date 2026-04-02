package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: NewThreadWorker.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends j0.c implements h.a.u0.c {
    private final ScheduledExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f11972b;

    public i(ThreadFactory threadFactory) {
        this.a = o.a(threadFactory);
    }

    @Override // h.a.j0.c
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public h.a.u0.c b(Runnable runnable, long j2, TimeUnit timeUnit) {
        m mVar = new m(h.a.c1.a.a(runnable));
        try {
            mVar.setFuture(j2 <= 0 ? this.a.submit(mVar) : this.a.schedule(mVar, j2, timeUnit));
            return mVar;
        } catch (RejectedExecutionException e2) {
            h.a.c1.a.b(e2);
            return h.a.y0.a.e.INSTANCE;
        }
    }

    @Override // h.a.u0.c
    public void dispose() {
        if (this.f11972b) {
            return;
        }
        this.f11972b = true;
        this.a.shutdownNow();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f11972b;
    }

    @Override // h.a.j0.c
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
        return this.f11972b ? h.a.y0.a.e.INSTANCE : a(runnable, j2, timeUnit, (h.a.y0.a.c) null);
    }

    @h.a.t0.f
    public n a(Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit, @h.a.t0.g h.a.y0.a.c cVar) {
        Future<?> futureSchedule;
        n nVar = new n(h.a.c1.a.a(runnable), cVar);
        if (cVar != null && !cVar.b(nVar)) {
            return nVar;
        }
        try {
            if (j2 <= 0) {
                futureSchedule = this.a.submit((Callable) nVar);
            } else {
                futureSchedule = this.a.schedule((Callable) nVar, j2, timeUnit);
            }
            nVar.setFuture(futureSchedule);
        } catch (RejectedExecutionException e2) {
            if (cVar != null) {
                cVar.a(nVar);
            }
            h.a.c1.a.b(e2);
        }
        return nVar;
    }

    public h.a.u0.c b(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableA = h.a.c1.a.a(runnable);
        if (j3 <= 0) {
            f fVar = new f(runnableA, this.a);
            try {
                if (j2 <= 0) {
                    futureSchedule = this.a.submit(fVar);
                } else {
                    futureSchedule = this.a.schedule(fVar, j2, timeUnit);
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
            lVar.setFuture(this.a.scheduleAtFixedRate(lVar, j2, j3, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e3) {
            h.a.c1.a.b(e3);
            return h.a.y0.a.e.INSTANCE;
        }
    }

    public void a() {
        if (this.f11972b) {
            return;
        }
        this.f11972b = true;
        this.a.shutdown();
    }
}
