package p251g.p252a;

import java.util.concurrent.TimeUnit;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p281g.C5120i;
import p251g.p252a.p268y0.p281g.C5127p;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: Scheduler.java */
/* renamed from: g.a.j0 */
/* loaded from: classes2.dex */
public abstract class AbstractC4516j0 {

    /* renamed from: a */
    static final long f17426a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    /* renamed from: g.a.j0$a */
    static final class a implements Runnable, InterfaceC4552c {

        /* renamed from: a */
        final Runnable f17427a;

        /* renamed from: b */
        final c f17428b;

        /* renamed from: c */
        Thread f17429c;

        a(Runnable runnable, c cVar) {
            this.f17427a = runnable;
            this.f17428b = cVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17429c == Thread.currentThread()) {
                c cVar = this.f17428b;
                if (cVar instanceof C5120i) {
                    ((C5120i) cVar).m18570a();
                    return;
                }
            }
            this.f17428b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17428b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17429c = Thread.currentThread();
            try {
                this.f17427a.run();
            } finally {
                dispose();
                this.f17429c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: g.a.j0$b */
    static class b implements Runnable, InterfaceC4552c {

        /* renamed from: a */
        final Runnable f17430a;

        /* renamed from: b */
        @InterfaceC4546f
        final c f17431b;

        /* renamed from: c */
        @InterfaceC4546f
        volatile boolean f17432c;

        b(@InterfaceC4546f Runnable runnable, @InterfaceC4546f c cVar) {
            this.f17430a = runnable;
            this.f17431b = cVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17432c = true;
            this.f17431b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17432c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17432c) {
                return;
            }
            try {
                this.f17430a.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17431b.dispose();
                throw C5171k.m18626c(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: g.a.j0$c */
    public static abstract class c implements InterfaceC4552c {

        /* compiled from: Scheduler.java */
        /* renamed from: g.a.j0$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            @InterfaceC4546f
            final Runnable f17433a;

            /* renamed from: b */
            @InterfaceC4546f
            final C4599k f17434b;

            /* renamed from: c */
            final long f17435c;

            /* renamed from: d */
            long f17436d;

            /* renamed from: e */
            long f17437e;

            /* renamed from: f */
            long f17438f;

            a(long j2, @InterfaceC4546f Runnable runnable, long j3, @InterfaceC4546f C4599k c4599k, long j4) {
                this.f17433a = runnable;
                this.f17434b = c4599k;
                this.f17435c = j4;
                this.f17437e = j3;
                this.f17438f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                this.f17433a.run();
                if (this.f17434b.isDisposed()) {
                    return;
                }
                long mo17281a = c.this.mo17281a(TimeUnit.NANOSECONDS);
                long j3 = AbstractC4516j0.f17426a;
                long j4 = mo17281a + j3;
                long j5 = this.f17437e;
                if (j4 >= j5) {
                    long j6 = this.f17435c;
                    if (mo17281a < j5 + j6 + j3) {
                        long j7 = this.f17438f;
                        long j8 = this.f17436d + 1;
                        this.f17436d = j8;
                        j2 = j7 + (j8 * j6);
                        this.f17437e = mo17281a;
                        this.f17434b.replace(c.this.mo17283a(this, j2 - mo17281a, TimeUnit.NANOSECONDS));
                    }
                }
                long j9 = this.f17435c;
                long j10 = mo17281a + j9;
                long j11 = this.f17436d + 1;
                this.f17436d = j11;
                this.f17438f = j10 - (j9 * j11);
                j2 = j10;
                this.f17437e = mo17281a;
                this.f17434b.replace(c.this.mo17283a(this, j2 - mo17281a, TimeUnit.NANOSECONDS));
            }
        }

        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            return mo17283a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @InterfaceC4546f
        /* renamed from: a */
        public abstract InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit);

        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17412a(@InterfaceC4546f Runnable runnable, long j2, long j3, @InterfaceC4546f TimeUnit timeUnit) {
            C4599k c4599k = new C4599k();
            C4599k c4599k2 = new C4599k(c4599k);
            Runnable m17139a = C4476a.m17139a(runnable);
            long nanos = timeUnit.toNanos(j3);
            long mo17281a = mo17281a(TimeUnit.NANOSECONDS);
            InterfaceC4552c mo17283a = mo17283a(new a(mo17281a + timeUnit.toNanos(j2), m17139a, mo17281a, c4599k2, nanos), j2, timeUnit);
            if (mo17283a == EnumC4593e.INSTANCE) {
                return mo17283a;
            }
            c4599k.replace(mo17283a);
            return c4599k2;
        }

        /* renamed from: a */
        public long mo17281a(@InterfaceC4546f TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: d */
    public static long m17405d() {
        return f17426a;
    }

    /* renamed from: a */
    public long mo17276a(@InterfaceC4546f TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public abstract c mo17277a();

    /* renamed from: b */
    public void mo17410b() {
    }

    /* renamed from: c */
    public void mo17411c() {
    }

    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17407a(@InterfaceC4546f Runnable runnable) {
        return mo17409a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17409a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
        c mo17277a = mo17277a();
        a aVar = new a(C4476a.m17139a(runnable), mo17277a);
        mo17277a.mo17283a(aVar, j2, timeUnit);
        return aVar;
    }

    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17408a(@InterfaceC4546f Runnable runnable, long j2, long j3, @InterfaceC4546f TimeUnit timeUnit) {
        c mo17277a = mo17277a();
        b bVar = new b(C4476a.m17139a(runnable), mo17277a);
        InterfaceC4552c mo17412a = mo17277a.mo17412a(bVar, j2, j3, timeUnit);
        return mo17412a == EnumC4593e.INSTANCE ? mo17412a : bVar;
    }

    @InterfaceC4546f
    /* renamed from: a */
    public <S extends AbstractC4516j0 & InterfaceC4552c> S m17406a(@InterfaceC4546f InterfaceC4584o<AbstractC4519l<AbstractC4519l<AbstractC4474c>>, AbstractC4474c> interfaceC4584o) {
        return new C5127p(interfaceC4584o, this);
    }
}
