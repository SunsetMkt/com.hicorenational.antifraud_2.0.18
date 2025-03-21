package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p257e1.C4488a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p280f.C5109a;

/* compiled from: ExecutorScheduler.java */
/* renamed from: g.a.y0.g.d */
/* loaded from: classes2.dex */
public final class C5115d extends AbstractC4516j0 {

    /* renamed from: c */
    static final AbstractC4516j0 f19857c = C4488a.m17272e();

    /* renamed from: b */
    @InterfaceC4546f
    final Executor f19858b;

    /* compiled from: ExecutorScheduler.java */
    /* renamed from: g.a.y0.g.d$a */
    final class a implements Runnable {

        /* renamed from: a */
        private final b f19859a;

        a(b bVar) {
            this.f19859a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f19859a;
            bVar.direct.replace(C5115d.this.mo17407a(bVar));
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* renamed from: g.a.y0.g.d$b */
    static final class b extends AtomicReference<Runnable> implements Runnable, InterfaceC4552c {
        private static final long serialVersionUID = -4101336210206799084L;
        final C4599k direct;
        final C4599k timed;

        b(Runnable runnable) {
            super(runnable);
            this.timed = new C4599k();
            this.direct = new C4599k();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(EnumC4592d.DISPOSED);
                    this.direct.lazySet(EnumC4592d.DISPOSED);
                }
            }
        }
    }

    public C5115d(@InterfaceC4546f Executor executor) {
        this.f19858b = executor;
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new c(this.f19858b);
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17407a(@InterfaceC4546f Runnable runnable) {
        Runnable m17139a = C4476a.m17139a(runnable);
        try {
            if (this.f19858b instanceof ExecutorService) {
                CallableC5124m callableC5124m = new CallableC5124m(m17139a);
                callableC5124m.setFuture(((ExecutorService) this.f19858b).submit(callableC5124m));
                return callableC5124m;
            }
            c.a aVar = new c.a(m17139a);
            this.f19858b.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e2) {
            C4476a.m17152b(e2);
            return EnumC4593e.INSTANCE;
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* renamed from: g.a.y0.g.d$c */
    public static final class c extends AbstractC4516j0.c implements Runnable {

        /* renamed from: a */
        final Executor f19861a;

        /* renamed from: c */
        volatile boolean f19863c;

        /* renamed from: d */
        final AtomicInteger f19864d = new AtomicInteger();

        /* renamed from: e */
        final C4551b f19865e = new C4551b();

        /* renamed from: b */
        final C5109a<Runnable> f19862b = new C5109a<>();

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: g.a.y0.g.d$c$a */
        static final class a extends AtomicBoolean implements Runnable, InterfaceC4552c {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            a(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public void dispose() {
                lazySet(true);
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: g.a.y0.g.d$c$b */
        final class b implements Runnable {

            /* renamed from: a */
            private final C4599k f19866a;

            /* renamed from: b */
            private final Runnable f19867b;

            b(C4599k c4599k, Runnable runnable) {
                this.f19866a = c4599k;
                this.f19867b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19866a.replace(c.this.mo17282a(this.f19867b));
            }
        }

        public c(Executor executor) {
            this.f19861a = executor;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            if (this.f19863c) {
                return EnumC4593e.INSTANCE;
            }
            a aVar = new a(C4476a.m17139a(runnable));
            this.f19862b.offer(aVar);
            if (this.f19864d.getAndIncrement() == 0) {
                try {
                    this.f19861a.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f19863c = true;
                    this.f19862b.clear();
                    C4476a.m17152b(e2);
                    return EnumC4593e.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f19863c) {
                return;
            }
            this.f19863c = true;
            this.f19865e.dispose();
            if (this.f19864d.getAndIncrement() == 0) {
                this.f19862b.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19863c;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5109a<Runnable> c5109a = this.f19862b;
            int i2 = 1;
            while (!this.f19863c) {
                do {
                    Runnable poll = c5109a.poll();
                    if (poll != null) {
                        poll.run();
                    } else if (this.f19863c) {
                        c5109a.clear();
                        return;
                    } else {
                        i2 = this.f19864d.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                } while (!this.f19863c);
                c5109a.clear();
                return;
            }
            c5109a.clear();
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            if (j2 <= 0) {
                return mo17282a(runnable);
            }
            if (this.f19863c) {
                return EnumC4593e.INSTANCE;
            }
            C4599k c4599k = new C4599k();
            C4599k c4599k2 = new C4599k(c4599k);
            RunnableC5125n runnableC5125n = new RunnableC5125n(new b(c4599k2, C4476a.m17139a(runnable)), this.f19865e);
            this.f19865e.mo18181b(runnableC5125n);
            Executor executor = this.f19861a;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    runnableC5125n.setFuture(((ScheduledExecutorService) executor).schedule((Callable) runnableC5125n, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f19863c = true;
                    C4476a.m17152b(e2);
                    return EnumC4593e.INSTANCE;
                }
            } else {
                runnableC5125n.setFuture(new FutureC5114c(C5115d.f19857c.mo17409a(runnableC5125n, j2, timeUnit)));
            }
            c4599k.replace(runnableC5125n);
            return c4599k2;
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17409a(@InterfaceC4546f Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable m17139a = C4476a.m17139a(runnable);
        if (this.f19858b instanceof ScheduledExecutorService) {
            try {
                CallableC5124m callableC5124m = new CallableC5124m(m17139a);
                callableC5124m.setFuture(((ScheduledExecutorService) this.f19858b).schedule(callableC5124m, j2, timeUnit));
                return callableC5124m;
            } catch (RejectedExecutionException e2) {
                C4476a.m17152b(e2);
                return EnumC4593e.INSTANCE;
            }
        }
        b bVar = new b(m17139a);
        bVar.timed.replace(f19857c.mo17409a(new a(bVar), j2, timeUnit));
        return bVar;
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17408a(@InterfaceC4546f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        if (this.f19858b instanceof ScheduledExecutorService) {
            try {
                RunnableC5123l runnableC5123l = new RunnableC5123l(C4476a.m17139a(runnable));
                runnableC5123l.setFuture(((ScheduledExecutorService) this.f19858b).scheduleAtFixedRate(runnableC5123l, j2, j3, timeUnit));
                return runnableC5123l;
            } catch (RejectedExecutionException e2) {
                C4476a.m17152b(e2);
                return EnumC4593e.INSTANCE;
            }
        }
        return super.mo17408a(runnable, j2, j3, timeUnit);
    }
}
