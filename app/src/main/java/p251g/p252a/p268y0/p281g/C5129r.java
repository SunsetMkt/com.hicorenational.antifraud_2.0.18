package p251g.p252a.p268y0.p281g;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: TrampolineScheduler.java */
/* renamed from: g.a.y0.g.r */
/* loaded from: classes2.dex */
public final class C5129r extends AbstractC4516j0 {

    /* renamed from: b */
    private static final C5129r f19934b = new C5129r();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: g.a.y0.g.r$a */
    static final class a implements Runnable {

        /* renamed from: a */
        private final Runnable f19935a;

        /* renamed from: b */
        private final c f19936b;

        /* renamed from: c */
        private final long f19937c;

        a(Runnable runnable, c cVar, long j2) {
            this.f19935a = runnable;
            this.f19936b = cVar;
            this.f19937c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19936b.f19945d) {
                return;
            }
            long mo17281a = this.f19936b.mo17281a(TimeUnit.MILLISECONDS);
            long j2 = this.f19937c;
            if (j2 > mo17281a) {
                long j3 = j2 - mo17281a;
                if (j3 > 0) {
                    try {
                        Thread.sleep(j3);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        C4476a.m17152b(e2);
                        return;
                    }
                }
            }
            if (this.f19936b.f19945d) {
                return;
            }
            this.f19935a.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: g.a.y0.g.r$b */
    static final class b implements Comparable<b> {

        /* renamed from: a */
        final Runnable f19938a;

        /* renamed from: b */
        final long f19939b;

        /* renamed from: c */
        final int f19940c;

        /* renamed from: d */
        volatile boolean f19941d;

        b(Runnable runnable, Long l2, int i2) {
            this.f19938a = runnable;
            this.f19939b = l2.longValue();
            this.f19940c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int m18280a = C4601b.m18280a(this.f19939b, bVar.f19939b);
            return m18280a == 0 ? C4601b.m18278a(this.f19940c, bVar.f19940c) : m18280a;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: g.a.y0.g.r$c */
    static final class c extends AbstractC4516j0.c implements InterfaceC4552c {

        /* renamed from: a */
        final PriorityBlockingQueue<b> f19942a = new PriorityBlockingQueue<>();

        /* renamed from: b */
        private final AtomicInteger f19943b = new AtomicInteger();

        /* renamed from: c */
        final AtomicInteger f19944c = new AtomicInteger();

        /* renamed from: d */
        volatile boolean f19945d;

        /* compiled from: TrampolineScheduler.java */
        /* renamed from: g.a.y0.g.r$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            final b f19946a;

            a(b bVar) {
                this.f19946a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.f19946a;
                bVar.f19941d = true;
                c.this.f19942a.remove(bVar);
            }
        }

        c() {
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            return m18580a(runnable, mo17281a(TimeUnit.MILLISECONDS));
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19945d = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19945d;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            long mo17281a = mo17281a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return m18580a(new a(runnable, this, mo17281a), mo17281a);
        }

        /* renamed from: a */
        InterfaceC4552c m18580a(Runnable runnable, long j2) {
            if (this.f19945d) {
                return EnumC4593e.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f19944c.incrementAndGet());
            this.f19942a.add(bVar);
            if (this.f19943b.getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f19945d) {
                    b poll = this.f19942a.poll();
                    if (poll == null) {
                        i2 = this.f19943b.addAndGet(-i2);
                        if (i2 == 0) {
                            return EnumC4593e.INSTANCE;
                        }
                    } else if (!poll.f19941d) {
                        poll.f19938a.run();
                    }
                }
                this.f19942a.clear();
                return EnumC4593e.INSTANCE;
            }
            return C4553d.m18186a(new a(bVar));
        }
    }

    C5129r() {
    }

    /* renamed from: e */
    public static C5129r m18578e() {
        return f19934b;
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new c();
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17407a(@InterfaceC4546f Runnable runnable) {
        runnable.run();
        return EnumC4593e.INSTANCE;
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17409a(@InterfaceC4546f Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            runnable.run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            C4476a.m17152b(e2);
        }
        return EnumC4593e.INSTANCE;
    }
}
