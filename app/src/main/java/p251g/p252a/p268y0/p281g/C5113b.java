package p251g.p252a.p268y0.p281g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4597i;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: ComputationScheduler.java */
/* renamed from: g.a.y0.g.b */
/* loaded from: classes2.dex */
public final class C5113b extends AbstractC4516j0 {

    /* renamed from: d */
    static final b f19839d;

    /* renamed from: e */
    private static final String f19840e = "RxComputationThreadPool";

    /* renamed from: f */
    static final ThreadFactoryC5122k f19841f;

    /* renamed from: g */
    static final String f19842g = "rx2.computation-threads";

    /* renamed from: h */
    static final int f19843h = m18556a(Runtime.getRuntime().availableProcessors(), Integer.getInteger(f19842g, 0).intValue());

    /* renamed from: i */
    static final c f19844i = new c(new ThreadFactoryC5122k("RxComputationShutdown"));

    /* renamed from: j */
    private static final String f19845j = "rx2.computation-priority";

    /* renamed from: b */
    final ThreadFactory f19846b;

    /* renamed from: c */
    final AtomicReference<b> f19847c;

    /* compiled from: ComputationScheduler.java */
    /* renamed from: g.a.y0.g.b$b */
    static final class b {

        /* renamed from: a */
        final int f19853a;

        /* renamed from: b */
        final c[] f19854b;

        /* renamed from: c */
        long f19855c;

        b(int i2, ThreadFactory threadFactory) {
            this.f19853a = i2;
            this.f19854b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f19854b[i3] = new c(threadFactory);
            }
        }

        /* renamed from: a */
        public c m18557a() {
            int i2 = this.f19853a;
            if (i2 == 0) {
                return C5113b.f19844i;
            }
            c[] cVarArr = this.f19854b;
            long j2 = this.f19855c;
            this.f19855c = 1 + j2;
            return cVarArr[(int) (j2 % i2)];
        }

        /* renamed from: b */
        public void m18558b() {
            for (c cVar : this.f19854b) {
                cVar.dispose();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: g.a.y0.g.b$c */
    static final class c extends C5120i {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f19844i.dispose();
        f19841f = new ThreadFactoryC5122k(f19840e, Math.max(1, Math.min(10, Integer.getInteger(f19845j, 5).intValue())), true);
        f19839d = new b(0, f19841f);
        f19839d.m18558b();
    }

    public C5113b() {
        this(f19841f);
    }

    /* renamed from: a */
    static int m18556a(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new a(this.f19847c.get().m18557a());
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: b */
    public void mo17410b() {
        b bVar;
        b bVar2;
        do {
            bVar = this.f19847c.get();
            bVar2 = f19839d;
            if (bVar == bVar2) {
                return;
            }
        } while (!this.f19847c.compareAndSet(bVar, bVar2));
        bVar.m18558b();
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: c */
    public void mo17411c() {
        b bVar = new b(f19843h, this.f19846b);
        if (this.f19847c.compareAndSet(f19839d, bVar)) {
            return;
        }
        bVar.m18558b();
    }

    public C5113b(ThreadFactory threadFactory) {
        this.f19846b = threadFactory;
        this.f19847c = new AtomicReference<>(f19839d);
        mo17411c();
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17409a(@InterfaceC4546f Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f19847c.get().m18557a().m18572b(runnable, j2, timeUnit);
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: g.a.y0.g.b$a */
    static final class a extends AbstractC4516j0.c {

        /* renamed from: a */
        private final C4597i f19848a = new C4597i();

        /* renamed from: b */
        private final C4551b f19849b = new C4551b();

        /* renamed from: c */
        private final C4597i f19850c = new C4597i();

        /* renamed from: d */
        private final c f19851d;

        /* renamed from: e */
        volatile boolean f19852e;

        a(c cVar) {
            this.f19851d = cVar;
            this.f19850c.mo18181b(this.f19848a);
            this.f19850c.mo18181b(this.f19849b);
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            return this.f19852e ? EnumC4593e.INSTANCE : this.f19851d.m18569a(runnable, 0L, TimeUnit.MILLISECONDS, this.f19848a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f19852e) {
                return;
            }
            this.f19852e = true;
            this.f19850c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19852e;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            if (this.f19852e) {
                return EnumC4593e.INSTANCE;
            }
            return this.f19851d.m18569a(runnable, j2, timeUnit, this.f19849b);
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17408a(@InterfaceC4546f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f19847c.get().m18557a().m18571b(runnable, j2, j3, timeUnit);
    }
}
