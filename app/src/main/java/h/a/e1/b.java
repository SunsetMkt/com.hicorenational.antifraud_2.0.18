package h.a.e1;

import h.a.j0;
import h.a.t0.f;
import h.a.u0.d;
import h.a.y0.a.e;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TestScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Queue<C0175b> f10325b = new PriorityBlockingQueue(11);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f10326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile long f10327d;

    /* JADX INFO: renamed from: h.a.e1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TestScheduler.java */
    static final class C0175b implements Comparable<C0175b> {
        final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f10330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final a f10331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f10332d;

        C0175b(a aVar, long j2, Runnable runnable, long j3) {
            this.a = j2;
            this.f10330b = runnable;
            this.f10331c = aVar;
            this.f10332d = j3;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0175b c0175b) {
            long j2 = this.a;
            long j3 = c0175b.a;
            return j2 == j3 ? h.a.y0.b.b.a(this.f10332d, c0175b.f10332d) : h.a.y0.b.b.a(j2, j3);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.a), this.f10330b.toString());
        }
    }

    @Override // h.a.j0
    public long a(@f TimeUnit timeUnit) {
        return timeUnit.convert(this.f10327d, TimeUnit.NANOSECONDS);
    }

    public void b(long j2, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j2));
    }

    public void e() {
        a(this.f10327d);
    }

    public void a(long j2, TimeUnit timeUnit) {
        b(this.f10327d + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    private void a(long j2) {
        while (true) {
            C0175b c0175bPeek = this.f10325b.peek();
            if (c0175bPeek == null) {
                break;
            }
            long j3 = c0175bPeek.a;
            if (j3 > j2) {
                break;
            }
            if (j3 == 0) {
                j3 = this.f10327d;
            }
            this.f10327d = j3;
            this.f10325b.remove(c0175bPeek);
            if (!c0175bPeek.f10331c.a) {
                c0175bPeek.f10330b.run();
            }
        }
        this.f10327d = j2;
    }

    /* JADX INFO: compiled from: TestScheduler.java */
    final class a extends j0.c {
        volatile boolean a;

        /* JADX INFO: renamed from: h.a.e1.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TestScheduler.java */
        final class RunnableC0174a implements Runnable {
            final C0175b a;

            RunnableC0174a(C0175b c0175b) {
                this.a = c0175b;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10325b.remove(this.a);
            }
        }

        a() {
        }

        @Override // h.a.j0.c
        @f
        public h.a.u0.c a(@f Runnable runnable, long j2, @f TimeUnit timeUnit) {
            if (this.a) {
                return e.INSTANCE;
            }
            long nanos = b.this.f10327d + timeUnit.toNanos(j2);
            b bVar = b.this;
            long j3 = bVar.f10326c;
            bVar.f10326c = 1 + j3;
            C0175b c0175b = new C0175b(this, nanos, runnable, j3);
            b.this.f10325b.add(c0175b);
            return d.a(new RunnableC0174a(c0175b));
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.a = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.a;
        }

        @Override // h.a.j0.c
        @f
        public h.a.u0.c a(@f Runnable runnable) {
            if (this.a) {
                return e.INSTANCE;
            }
            b bVar = b.this;
            long j2 = bVar.f10326c;
            bVar.f10326c = 1 + j2;
            C0175b c0175b = new C0175b(this, 0L, runnable, j2);
            b.this.f10325b.add(c0175b);
            return d.a(new RunnableC0174a(c0175b));
        }

        @Override // h.a.j0.c
        public long a(@f TimeUnit timeUnit) {
            return b.this.a(timeUnit);
        }
    }

    @Override // h.a.j0
    @f
    public j0.c a() {
        return new a();
    }
}
