package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p269a.InterfaceC4591c;

/* compiled from: NewThreadWorker.java */
/* renamed from: g.a.y0.g.i */
/* loaded from: classes2.dex */
public class C5120i extends AbstractC4516j0.c implements InterfaceC4552c {

    /* renamed from: a */
    private final ScheduledExecutorService f19904a;

    /* renamed from: b */
    volatile boolean f19905b;

    public C5120i(ThreadFactory threadFactory) {
        this.f19904a = C5126o.m18573a(threadFactory);
    }

    @Override // p251g.p252a.AbstractC4516j0.c
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
        return mo17283a(runnable, 0L, null);
    }

    /* renamed from: b */
    public InterfaceC4552c m18572b(Runnable runnable, long j2, TimeUnit timeUnit) {
        CallableC5124m callableC5124m = new CallableC5124m(C4476a.m17139a(runnable));
        try {
            callableC5124m.setFuture(j2 <= 0 ? this.f19904a.submit(callableC5124m) : this.f19904a.schedule(callableC5124m, j2, timeUnit));
            return callableC5124m;
        } catch (RejectedExecutionException e2) {
            C4476a.m17152b(e2);
            return EnumC4593e.INSTANCE;
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        if (this.f19905b) {
            return;
        }
        this.f19905b = true;
        this.f19904a.shutdownNow();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f19905b;
    }

    @Override // p251g.p252a.AbstractC4516j0.c
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
        return this.f19905b ? EnumC4593e.INSTANCE : m18569a(runnable, j2, timeUnit, (InterfaceC4591c) null);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public RunnableC5125n m18569a(Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit, @InterfaceC4547g InterfaceC4591c interfaceC4591c) {
        Future<?> schedule;
        RunnableC5125n runnableC5125n = new RunnableC5125n(C4476a.m17139a(runnable), interfaceC4591c);
        if (interfaceC4591c != null && !interfaceC4591c.mo18181b(runnableC5125n)) {
            return runnableC5125n;
        }
        try {
            if (j2 <= 0) {
                schedule = this.f19904a.submit((Callable) runnableC5125n);
            } else {
                schedule = this.f19904a.schedule((Callable) runnableC5125n, j2, timeUnit);
            }
            runnableC5125n.setFuture(schedule);
        } catch (RejectedExecutionException e2) {
            if (interfaceC4591c != null) {
                interfaceC4591c.mo18178a(runnableC5125n);
            }
            C4476a.m17152b(e2);
        }
        return runnableC5125n;
    }

    /* renamed from: b */
    public InterfaceC4552c m18571b(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable m17139a = C4476a.m17139a(runnable);
        if (j3 <= 0) {
            CallableC5117f callableC5117f = new CallableC5117f(m17139a, this.f19904a);
            try {
                if (j2 <= 0) {
                    schedule = this.f19904a.submit(callableC5117f);
                } else {
                    schedule = this.f19904a.schedule(callableC5117f, j2, timeUnit);
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
            runnableC5123l.setFuture(this.f19904a.scheduleAtFixedRate(runnableC5123l, j2, j3, timeUnit));
            return runnableC5123l;
        } catch (RejectedExecutionException e3) {
            C4476a.m17152b(e3);
            return EnumC4593e.INSTANCE;
        }
    }

    /* renamed from: a */
    public void m18570a() {
        if (this.f19905b) {
            return;
        }
        this.f19905b = true;
        this.f19904a.shutdown();
    }
}
