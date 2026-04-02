package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r f11995b = new r();

    /* JADX INFO: compiled from: TrampolineScheduler.java */
    static final class a implements Runnable {
        private final Runnable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f11996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f11997c;

        a(Runnable runnable, c cVar, long j2) {
            this.a = runnable;
            this.f11996b = cVar;
            this.f11997c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11996b.f12003d) {
                return;
            }
            long jA = this.f11996b.a(TimeUnit.MILLISECONDS);
            long j2 = this.f11997c;
            if (j2 > jA) {
                long j3 = j2 - jA;
                if (j3 > 0) {
                    try {
                        Thread.sleep(j3);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        h.a.c1.a.b(e2);
                        return;
                    }
                }
            }
            if (this.f11996b.f12003d) {
                return;
            }
            this.a.run();
        }
    }

    /* JADX INFO: compiled from: TrampolineScheduler.java */
    static final class b implements Comparable<b> {
        final Runnable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f11999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f12000d;

        b(Runnable runnable, Long l2, int i2) {
            this.a = runnable;
            this.f11998b = l2.longValue();
            this.f11999c = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iA = h.a.y0.b.b.a(this.f11998b, bVar.f11998b);
            return iA == 0 ? h.a.y0.b.b.a(this.f11999c, bVar.f11999c) : iA;
        }
    }

    /* JADX INFO: compiled from: TrampolineScheduler.java */
    static final class c extends j0.c implements h.a.u0.c {
        final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f12001b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f12002c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f12003d;

        /* JADX INFO: compiled from: TrampolineScheduler.java */
        final class a implements Runnable {
            final b a;

            a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.a;
                bVar.f12000d = true;
                c.this.a.remove(bVar);
            }
        }

        c() {
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f12003d = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f12003d;
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return a(new a(runnable, this, jA), jA);
        }

        h.a.u0.c a(Runnable runnable, long j2) {
            if (this.f12003d) {
                return h.a.y0.a.e.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f12002c.incrementAndGet());
            this.a.add(bVar);
            if (this.f12001b.getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f12003d) {
                    b bVarPoll = this.a.poll();
                    if (bVarPoll == null) {
                        iAddAndGet = this.f12001b.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return h.a.y0.a.e.INSTANCE;
                        }
                    } else if (!bVarPoll.f12000d) {
                        bVarPoll.a.run();
                    }
                }
                this.a.clear();
                return h.a.y0.a.e.INSTANCE;
            }
            return h.a.u0.d.a(new a(bVar));
        }
    }

    r() {
    }

    public static r e() {
        return f11995b;
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return new c();
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
        runnable.run();
        return h.a.y0.a.e.INSTANCE;
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            runnable.run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            h.a.c1.a.b(e2);
        }
        return h.a.y0.a.e.INSTANCE;
    }
}
