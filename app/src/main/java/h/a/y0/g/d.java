package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends j0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final j0 f11931c = h.a.e1.a.e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h.a.t0.f
    final Executor f11932b;

    /* JADX INFO: compiled from: ExecutorScheduler.java */
    final class a implements Runnable {
        private final b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.a;
            bVar.direct.replace(d.this.a(bVar));
        }
    }

    /* JADX INFO: compiled from: ExecutorScheduler.java */
    static final class b extends AtomicReference<Runnable> implements Runnable, h.a.u0.c {
        private static final long serialVersionUID = -4101336210206799084L;
        final h.a.y0.a.k direct;
        final h.a.y0.a.k timed;

        b(Runnable runnable) {
            super(runnable);
            this.timed = new h.a.y0.a.k();
            this.direct = new h.a.y0.a.k();
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // h.a.u0.c
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
                    this.timed.lazySet(h.a.y0.a.d.DISPOSED);
                    this.direct.lazySet(h.a.y0.a.d.DISPOSED);
                }
            }
        }
    }

    public d(@h.a.t0.f Executor executor) {
        this.f11932b = executor;
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return new c(this.f11932b);
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
        Runnable runnableA = h.a.c1.a.a(runnable);
        try {
            if (this.f11932b instanceof ExecutorService) {
                m mVar = new m(runnableA);
                mVar.setFuture(((ExecutorService) this.f11932b).submit(mVar));
                return mVar;
            }
            c.a aVar = new c.a(runnableA);
            this.f11932b.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e2) {
            h.a.c1.a.b(e2);
            return h.a.y0.a.e.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ExecutorScheduler.java */
    public static final class c extends j0.c implements Runnable {
        final Executor a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f11935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f11936d = new AtomicInteger();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final h.a.u0.b f11937e = new h.a.u0.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.y0.f.a<Runnable> f11934b = new h.a.y0.f.a<>();

        /* JADX INFO: compiled from: ExecutorScheduler.java */
        static final class a extends AtomicBoolean implements Runnable, h.a.u0.c {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            a(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // h.a.u0.c
            public void dispose() {
                lazySet(true);
            }

            @Override // h.a.u0.c
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

        /* JADX INFO: compiled from: ExecutorScheduler.java */
        final class b implements Runnable {
            private final h.a.y0.a.k a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Runnable f11938b;

            b(h.a.y0.a.k kVar, Runnable runnable) {
                this.a = kVar;
                this.f11938b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.replace(c.this.a(this.f11938b));
            }
        }

        public c(Executor executor) {
            this.a = executor;
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
            if (this.f11935c) {
                return h.a.y0.a.e.INSTANCE;
            }
            a aVar = new a(h.a.c1.a.a(runnable));
            this.f11934b.offer(aVar);
            if (this.f11936d.getAndIncrement() == 0) {
                try {
                    this.a.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f11935c = true;
                    this.f11934b.clear();
                    h.a.c1.a.b(e2);
                    return h.a.y0.a.e.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f11935c) {
                return;
            }
            this.f11935c = true;
            this.f11937e.dispose();
            if (this.f11936d.getAndIncrement() == 0) {
                this.f11934b.clear();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11935c;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.y0.f.a<Runnable> aVar = this.f11934b;
            int iAddAndGet = 1;
            while (!this.f11935c) {
                do {
                    Runnable runnablePoll = aVar.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    } else if (this.f11935c) {
                        aVar.clear();
                        return;
                    } else {
                        iAddAndGet = this.f11936d.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f11935c);
                aVar.clear();
                return;
            }
            aVar.clear();
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            if (j2 <= 0) {
                return a(runnable);
            }
            if (this.f11935c) {
                return h.a.y0.a.e.INSTANCE;
            }
            h.a.y0.a.k kVar = new h.a.y0.a.k();
            h.a.y0.a.k kVar2 = new h.a.y0.a.k(kVar);
            n nVar = new n(new b(kVar2, h.a.c1.a.a(runnable)), this.f11937e);
            this.f11937e.b(nVar);
            Executor executor = this.a;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    nVar.setFuture(((ScheduledExecutorService) executor).schedule((Callable) nVar, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f11935c = true;
                    h.a.c1.a.b(e2);
                    return h.a.y0.a.e.INSTANCE;
                }
            } else {
                nVar.setFuture(new h.a.y0.g.c(d.f11931c.a(nVar, j2, timeUnit)));
            }
            kVar.replace(nVar);
            return kVar2;
        }
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable runnableA = h.a.c1.a.a(runnable);
        if (this.f11932b instanceof ScheduledExecutorService) {
            try {
                m mVar = new m(runnableA);
                mVar.setFuture(((ScheduledExecutorService) this.f11932b).schedule(mVar, j2, timeUnit));
                return mVar;
            } catch (RejectedExecutionException e2) {
                h.a.c1.a.b(e2);
                return h.a.y0.a.e.INSTANCE;
            }
        }
        b bVar = new b(runnableA);
        bVar.timed.replace(f11931c.a(new a(bVar), j2, timeUnit));
        return bVar;
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        if (this.f11932b instanceof ScheduledExecutorService) {
            try {
                l lVar = new l(h.a.c1.a.a(runnable));
                lVar.setFuture(((ScheduledExecutorService) this.f11932b).scheduleAtFixedRate(lVar, j2, j3, timeUnit));
                return lVar;
            } catch (RejectedExecutionException e2) {
                h.a.c1.a.b(e2);
                return h.a.y0.a.e.INSTANCE;
            }
        }
        return super.a(runnable, j2, j3, timeUnit);
    }
}
