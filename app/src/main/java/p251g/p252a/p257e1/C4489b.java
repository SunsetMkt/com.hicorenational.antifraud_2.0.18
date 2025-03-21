package p251g.p252a.p257e1;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: TestScheduler.java */
/* renamed from: g.a.e1.b */
/* loaded from: classes2.dex */
public final class C4489b extends AbstractC4516j0 {

    /* renamed from: b */
    final Queue<b> f17327b = new PriorityBlockingQueue(11);

    /* renamed from: c */
    long f17328c;

    /* renamed from: d */
    volatile long f17329d;

    /* compiled from: TestScheduler.java */
    /* renamed from: g.a.e1.b$b */
    static final class b implements Comparable<b> {

        /* renamed from: a */
        final long f17334a;

        /* renamed from: b */
        final Runnable f17335b;

        /* renamed from: c */
        final a f17336c;

        /* renamed from: d */
        final long f17337d;

        b(a aVar, long j2, Runnable runnable, long j3) {
            this.f17334a = j2;
            this.f17335b = runnable;
            this.f17336c = aVar;
            this.f17337d = j3;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j2 = this.f17334a;
            long j3 = bVar.f17334a;
            return j2 == j3 ? C4601b.m18280a(this.f17337d, bVar.f17337d) : C4601b.m18280a(j2, j3);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.f17334a), this.f17335b.toString());
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: a */
    public long mo17276a(@InterfaceC4546f TimeUnit timeUnit) {
        return timeUnit.convert(this.f17329d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: b */
    public void m17279b(long j2, TimeUnit timeUnit) {
        m17275a(timeUnit.toNanos(j2));
    }

    /* renamed from: e */
    public void m17280e() {
        m17275a(this.f17329d);
    }

    /* renamed from: a */
    public void m17278a(long j2, TimeUnit timeUnit) {
        m17279b(this.f17329d + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    private void m17275a(long j2) {
        while (true) {
            b peek = this.f17327b.peek();
            if (peek == null) {
                break;
            }
            long j3 = peek.f17334a;
            if (j3 > j2) {
                break;
            }
            if (j3 == 0) {
                j3 = this.f17329d;
            }
            this.f17329d = j3;
            this.f17327b.remove(peek);
            if (!peek.f17336c.f17330a) {
                peek.f17335b.run();
            }
        }
        this.f17329d = j2;
    }

    /* compiled from: TestScheduler.java */
    /* renamed from: g.a.e1.b$a */
    final class a extends AbstractC4516j0.c {

        /* renamed from: a */
        volatile boolean f17330a;

        /* compiled from: TestScheduler.java */
        /* renamed from: g.a.e1.b$a$a, reason: collision with other inner class name */
        final class RunnableC7382a implements Runnable {

            /* renamed from: a */
            final b f17332a;

            RunnableC7382a(b bVar) {
                this.f17332a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4489b.this.f17327b.remove(this.f17332a);
            }
        }

        a() {
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            if (this.f17330a) {
                return EnumC4593e.INSTANCE;
            }
            long nanos = C4489b.this.f17329d + timeUnit.toNanos(j2);
            C4489b c4489b = C4489b.this;
            long j3 = c4489b.f17328c;
            c4489b.f17328c = 1 + j3;
            b bVar = new b(this, nanos, runnable, j3);
            C4489b.this.f17327b.add(bVar);
            return C4553d.m18186a(new RunnableC7382a(bVar));
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17330a = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17330a;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            if (this.f17330a) {
                return EnumC4593e.INSTANCE;
            }
            C4489b c4489b = C4489b.this;
            long j2 = c4489b.f17328c;
            c4489b.f17328c = 1 + j2;
            b bVar = new b(this, 0L, runnable, j2);
            C4489b.this.f17327b.add(bVar);
            return C4553d.m18186a(new RunnableC7382a(bVar));
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        /* renamed from: a */
        public long mo17281a(@InterfaceC4546f TimeUnit timeUnit) {
            return C4489b.this.mo17276a(timeUnit);
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new a();
    }
}
