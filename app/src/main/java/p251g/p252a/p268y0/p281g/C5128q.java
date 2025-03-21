package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: SingleScheduler.java */
/* renamed from: g.a.y0.g.q */
/* loaded from: classes2.dex */
public final class C5128q extends AbstractC4516j0 {

    /* renamed from: d */
    private static final String f19925d = "rx2.single-priority";

    /* renamed from: e */
    private static final String f19926e = "RxSingleScheduler";

    /* renamed from: f */
    static final ThreadFactoryC5122k f19927f;

    /* renamed from: g */
    static final ScheduledExecutorService f19928g = Executors.newScheduledThreadPool(0);

    /* renamed from: b */
    final ThreadFactory f19929b;

    /* renamed from: c */
    final AtomicReference<ScheduledExecutorService> f19930c;

    /* compiled from: SingleScheduler.java */
    /* renamed from: g.a.y0.g.q$a */
    static final class a extends AbstractC4516j0.c {

        /* renamed from: a */
        final ScheduledExecutorService f19931a;

        /* renamed from: b */
        final C4551b f19932b = new C4551b();

        /* renamed from: c */
        volatile boolean f19933c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f19931a = scheduledExecutorService;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            if (this.f19933c) {
                return EnumC4593e.INSTANCE;
            }
            RunnableC5125n runnableC5125n = new RunnableC5125n(C4476a.m17139a(runnable), this.f19932b);
            this.f19932b.mo18181b(runnableC5125n);
            try {
                runnableC5125n.setFuture(j2 <= 0 ? this.f19931a.submit((Callable) runnableC5125n) : this.f19931a.schedule((Callable) runnableC5125n, j2, timeUnit));
                return runnableC5125n;
            } catch (RejectedExecutionException e2) {
                dispose();
                C4476a.m17152b(e2);
                return EnumC4593e.INSTANCE;
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f19933c) {
                return;
            }
            this.f19933c = true;
            this.f19932b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19933c;
        }
    }

    static {
        f19928g.shutdown();
        f19927f = new ThreadFactoryC5122k(f19926e, Math.max(1, Math.min(10, Integer.getInteger(f19925d, 5).intValue())), true);
    }

    public C5128q() {
        this(f19927f);
    }

    /* renamed from: a */
    static ScheduledExecutorService m18577a(ThreadFactory threadFactory) {
        return C5126o.m18573a(threadFactory);
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: b */
    public void mo17410b() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f19930c.get();
        ScheduledExecutorService scheduledExecutorService2 = f19928g;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.f19930c.getAndSet(scheduledExecutorService2)) == f19928g) {
            return;
        }
        andSet.shutdownNow();
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: c */
    public void mo17411c() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f19930c.get();
            if (scheduledExecutorService != f19928g) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = m18577a(this.f19929b);
            }
        } while (!this.f19930c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    public C5128q(ThreadFactory threadFactory) {
        this.f19930c = new AtomicReference<>();
        this.f19929b = threadFactory;
        this.f19930c.lazySet(m18577a(threadFactory));
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new a(this.f19930c.get());
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17409a(@InterfaceC4546f Runnable runnable, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        CallableC5124m callableC5124m = new CallableC5124m(C4476a.m17139a(runnable));
        try {
            if (j2 <= 0) {
                schedule = this.f19930c.get().submit(callableC5124m);
            } else {
                schedule = this.f19930c.get().schedule(callableC5124m, j2, timeUnit);
            }
            callableC5124m.setFuture(schedule);
            return callableC5124m;
        } catch (RejectedExecutionException e2) {
            C4476a.m17152b(e2);
            return EnumC4593e.INSTANCE;
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17408a(@InterfaceC4546f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable m17139a = C4476a.m17139a(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f19930c.get();
            CallableC5117f callableC5117f = new CallableC5117f(m17139a, scheduledExecutorService);
            try {
                if (j2 <= 0) {
                    schedule = scheduledExecutorService.submit(callableC5117f);
                } else {
                    schedule = scheduledExecutorService.schedule(callableC5117f, j2, timeUnit);
                }
                callableC5117f.m18559a(schedule);
                return callableC5117f;
            } catch (RejectedExecutionException e2) {
                C4476a.m17152b(e2);
                return EnumC4593e.INSTANCE;
            }
        }
        RunnableC5123l runnableC5123l = new RunnableC5123l(m17139a);
        try {
            runnableC5123l.setFuture(this.f19930c.get().scheduleAtFixedRate(runnableC5123l, j2, j3, timeUnit));
            return runnableC5123l;
        } catch (RejectedExecutionException e3) {
            C4476a.m17152b(e3);
            return EnumC4593e.INSTANCE;
        }
    }
}
