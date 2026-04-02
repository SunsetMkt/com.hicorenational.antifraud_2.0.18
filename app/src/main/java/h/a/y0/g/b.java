package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ComputationScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final C0231b f11916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11917e = "RxComputationThreadPool";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final k f11918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String f11919g = "rx2.computation-threads";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f11920h = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger(f11919g, 0).intValue());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final c f11921i = new c(new k("RxComputationShutdown"));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f11922j = "rx2.computation-priority";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f11923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<C0231b> f11924c;

    /* JADX INFO: renamed from: h.a.y0.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class C0231b {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f11929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f11930c;

        C0231b(int i2, ThreadFactory threadFactory) {
            this.a = i2;
            this.f11929b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f11929b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.a;
            if (i2 == 0) {
                return b.f11921i;
            }
            c[] cVarArr = this.f11929b;
            long j2 = this.f11930c;
            this.f11930c = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (c cVar : this.f11929b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class c extends i {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f11921i.dispose();
        f11918f = new k(f11917e, Math.max(1, Math.min(10, Integer.getInteger(f11922j, 5).intValue())), true);
        f11916d = new C0231b(0, f11918f);
        f11916d.b();
    }

    public b() {
        this(f11918f);
    }

    static int a(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return new a(this.f11924c.get().a());
    }

    @Override // h.a.j0
    public void b() {
        C0231b c0231b;
        C0231b c0231b2;
        do {
            c0231b = this.f11924c.get();
            c0231b2 = f11916d;
            if (c0231b == c0231b2) {
                return;
            }
        } while (!this.f11924c.compareAndSet(c0231b, c0231b2));
        c0231b.b();
    }

    @Override // h.a.j0
    public void c() {
        C0231b c0231b = new C0231b(f11920h, this.f11923b);
        if (this.f11924c.compareAndSet(f11916d, c0231b)) {
            return;
        }
        c0231b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f11923b = threadFactory;
        this.f11924c = new AtomicReference<>(f11916d);
        c();
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f11924c.get().a().b(runnable, j2, timeUnit);
    }

    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class a extends j0.c {
        private final h.a.y0.a.i a = new h.a.y0.a.i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.u0.b f11925b = new h.a.u0.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h.a.y0.a.i f11926c = new h.a.y0.a.i();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c f11927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f11928e;

        a(c cVar) {
            this.f11927d = cVar;
            this.f11926c.b(this.a);
            this.f11926c.b(this.f11925b);
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
            return this.f11928e ? h.a.y0.a.e.INSTANCE : this.f11927d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f11928e) {
                return;
            }
            this.f11928e = true;
            this.f11926c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11928e;
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            if (this.f11928e) {
                return h.a.y0.a.e.INSTANCE;
            }
            return this.f11927d.a(runnable, j2, timeUnit, this.f11925b);
        }
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f11924c.get().a().b(runnable, j2, j3, timeUnit);
    }
}
