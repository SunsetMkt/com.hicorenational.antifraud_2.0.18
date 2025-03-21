package p251g.p252a.p268y0.p281g;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: IoScheduler.java */
/* renamed from: g.a.y0.g.g */
/* loaded from: classes2.dex */
public final class C5118g extends AbstractC4516j0 {

    /* renamed from: d */
    private static final String f19878d = "RxCachedThreadScheduler";

    /* renamed from: e */
    static final ThreadFactoryC5122k f19879e;

    /* renamed from: f */
    private static final String f19880f = "RxCachedWorkerPoolEvictor";

    /* renamed from: g */
    static final ThreadFactoryC5122k f19881g;

    /* renamed from: h */
    private static final long f19882h = 60;

    /* renamed from: i */
    private static final TimeUnit f19883i = TimeUnit.SECONDS;

    /* renamed from: j */
    static final c f19884j = new c(new ThreadFactoryC5122k("RxCachedThreadSchedulerShutdown"));

    /* renamed from: k */
    private static final String f19885k = "rx2.io-priority";

    /* renamed from: l */
    static final a f19886l;

    /* renamed from: b */
    final ThreadFactory f19887b;

    /* renamed from: c */
    final AtomicReference<a> f19888c;

    /* compiled from: IoScheduler.java */
    /* renamed from: g.a.y0.g.g$b */
    static final class b extends AbstractC4516j0.c {

        /* renamed from: b */
        private final a f19896b;

        /* renamed from: c */
        private final c f19897c;

        /* renamed from: d */
        final AtomicBoolean f19898d = new AtomicBoolean();

        /* renamed from: a */
        private final C4551b f19895a = new C4551b();

        b(a aVar) {
            this.f19896b = aVar;
            this.f19897c = aVar.m18564b();
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            return this.f19895a.isDisposed() ? EnumC4593e.INSTANCE : this.f19897c.m18569a(runnable, j2, timeUnit, this.f19895a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f19898d.compareAndSet(false, true)) {
                this.f19895a.dispose();
                this.f19896b.m18563a(this.f19897c);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19898d.get();
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: g.a.y0.g.g$c */
    static final class c extends C5120i {

        /* renamed from: c */
        private long f19899c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f19899c = 0L;
        }

        /* renamed from: a */
        public void m18567a(long j2) {
            this.f19899c = j2;
        }

        /* renamed from: b */
        public long m18568b() {
            return this.f19899c;
        }
    }

    static {
        f19884j.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger(f19885k, 5).intValue()));
        f19879e = new ThreadFactoryC5122k(f19878d, max);
        f19881g = new ThreadFactoryC5122k(f19880f, max);
        f19886l = new a(0L, null, f19879e);
        f19886l.m18566d();
    }

    public C5118g() {
        this(f19879e);
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new b(this.f19888c.get());
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: b */
    public void mo17410b() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f19888c.get();
            aVar2 = f19886l;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f19888c.compareAndSet(aVar, aVar2));
        aVar.m18566d();
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: c */
    public void mo17411c() {
        a aVar = new a(f19882h, f19883i, this.f19887b);
        if (this.f19888c.compareAndSet(f19886l, aVar)) {
            return;
        }
        aVar.m18566d();
    }

    /* renamed from: e */
    public int m18561e() {
        return this.f19888c.get().f19891c.m18180b();
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: g.a.y0.g.g$a */
    static final class a implements Runnable {

        /* renamed from: a */
        private final long f19889a;

        /* renamed from: b */
        private final ConcurrentLinkedQueue<c> f19890b;

        /* renamed from: c */
        final C4551b f19891c;

        /* renamed from: d */
        private final ScheduledExecutorService f19892d;

        /* renamed from: e */
        private final Future<?> f19893e;

        /* renamed from: f */
        private final ThreadFactory f19894f;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f19889a = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f19890b = new ConcurrentLinkedQueue<>();
            this.f19891c = new C4551b();
            this.f19894f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, C5118g.f19881g);
                long j3 = this.f19889a;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f19892d = scheduledExecutorService;
            this.f19893e = scheduledFuture;
        }

        /* renamed from: a */
        void m18563a(c cVar) {
            cVar.m18567a(m18565c() + this.f19889a);
            this.f19890b.offer(cVar);
        }

        /* renamed from: b */
        c m18564b() {
            if (this.f19891c.isDisposed()) {
                return C5118g.f19884j;
            }
            while (!this.f19890b.isEmpty()) {
                c poll = this.f19890b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f19894f);
            this.f19891c.mo18181b(cVar);
            return cVar;
        }

        /* renamed from: c */
        long m18565c() {
            return System.nanoTime();
        }

        /* renamed from: d */
        void m18566d() {
            this.f19891c.dispose();
            Future<?> future = this.f19893e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f19892d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            m18562a();
        }

        /* renamed from: a */
        void m18562a() {
            if (this.f19890b.isEmpty()) {
                return;
            }
            long m18565c = m18565c();
            Iterator<c> it = this.f19890b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.m18568b() > m18565c) {
                    return;
                }
                if (this.f19890b.remove(next)) {
                    this.f19891c.mo18178a(next);
                }
            }
        }
    }

    public C5118g(ThreadFactory threadFactory) {
        this.f19887b = threadFactory;
        this.f19888c = new AtomicReference<>(f19886l);
        mo17411c();
    }
}
