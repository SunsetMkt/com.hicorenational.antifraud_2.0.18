package g.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableWindow.java */
/* loaded from: classes2.dex */
public final class l4<T> extends g.a.y0.e.b.a<T, g.a.l<T>> {

    /* renamed from: c, reason: collision with root package name */
    final long f14364c;

    /* renamed from: d, reason: collision with root package name */
    final long f14365d;

    /* renamed from: e, reason: collision with root package name */
    final int f14366e;

    /* compiled from: FlowableWindow.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final i.d.c<? super g.a.l<T>> actual;
        final int bufferSize;
        long index;
        final AtomicBoolean once;
        i.d.d s;
        final long size;
        g.a.d1.g<T> window;

        a(i.d.c<? super g.a.l<T>> cVar, long j2, int i2) {
            super(1);
            this.actual = cVar;
            this.size = j2;
            this.once = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // i.d.c
        public void onComplete() {
            g.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = this.index;
            g.a.d1.g<T> gVar = this.window;
            if (j2 == 0) {
                getAndIncrement();
                gVar = g.a.d1.g.a(this.bufferSize, (Runnable) this);
                this.window = gVar;
                this.actual.onNext(gVar);
            }
            long j3 = j2 + 1;
            gVar.onNext(t);
            if (j3 != this.size) {
                this.index = j3;
                return;
            }
            this.index = 0L;
            this.window = null;
            gVar.onComplete();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                this.s.request(g.a.y0.j.d.b(this.size, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* compiled from: FlowableWindow.java */
    static final class b<T> extends AtomicInteger implements g.a.q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final i.d.c<? super g.a.l<T>> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final g.a.y0.f.c<g.a.d1.g<T>> queue;
        final AtomicLong requested;
        i.d.d s;
        final long size;
        final long skip;
        final ArrayDeque<g.a.d1.g<T>> windows;
        final AtomicInteger wip;

        b(i.d.c<? super g.a.l<T>> cVar, long j2, long j3, int i2) {
            super(1);
            this.actual = cVar;
            this.size = j2;
            this.skip = j3;
            this.queue = new g.a.y0.f.c<>(i2);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i2;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar, g.a.y0.f.c<?> cVar2) {
            if (this.cancelled) {
                cVar2.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                cVar2.clear();
                cVar.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super g.a.l<T>> cVar = this.actual;
            g.a.y0.f.c<g.a.d1.g<T>> cVar2 = this.queue;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    g.a.d1.g<T> poll = cVar2.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2, cVar, cVar2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(poll);
                    j3++;
                }
                if (j3 == j2 && checkTerminated(this.done, cVar2.isEmpty(), cVar, cVar2)) {
                    return;
                }
                if (j3 != 0 && j2 != h.q2.t.m0.f16408b) {
                    this.requested.addAndGet(-j3);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<g.a.d1.g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            Iterator<g.a.d1.g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index;
            if (j2 == 0 && !this.cancelled) {
                getAndIncrement();
                g.a.d1.g<T> a2 = g.a.d1.g.a(this.bufferSize, (Runnable) this);
                this.windows.offer(a2);
                this.queue.offer(a2);
                drain();
            }
            long j3 = j2 + 1;
            Iterator<g.a.d1.g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j4 = this.produced + 1;
            if (j4 == this.size) {
                this.produced = j4 - this.skip;
                g.a.d1.g<T> poll = this.windows.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.produced = j4;
            }
            if (j3 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j3;
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(g.a.y0.j.d.b(this.skip, j2));
                } else {
                    this.s.request(g.a.y0.j.d.a(this.size, g.a.y0.j.d.b(this.skip, j2 - 1)));
                }
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* compiled from: FlowableWindow.java */
    static final class c<T> extends AtomicInteger implements g.a.q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final i.d.c<? super g.a.l<T>> actual;
        final int bufferSize;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        i.d.d s;
        final long size;
        final long skip;
        g.a.d1.g<T> window;

        c(i.d.c<? super g.a.l<T>> cVar, long j2, long j3, int i2) {
            super(1);
            this.actual = cVar;
            this.size = j2;
            this.skip = j3;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // i.d.c
        public void onComplete() {
            g.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = this.index;
            g.a.d1.g<T> gVar = this.window;
            if (j2 == 0) {
                getAndIncrement();
                gVar = g.a.d1.g.a(this.bufferSize, (Runnable) this);
                this.window = gVar;
                this.actual.onNext(gVar);
            }
            long j3 = j2 + 1;
            if (gVar != null) {
                gVar.onNext(t);
            }
            if (j3 == this.size) {
                this.window = null;
                gVar.onComplete();
            }
            if (j3 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j3;
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(g.a.y0.j.d.b(this.skip, j2));
                } else {
                    this.s.request(g.a.y0.j.d.a(g.a.y0.j.d.b(this.size, j2), g.a.y0.j.d.b(this.skip - this.size, j2 - 1)));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    public l4(g.a.l<T> lVar, long j2, long j3, int i2) {
        super(lVar);
        this.f14364c = j2;
        this.f14365d = j3;
        this.f14366e = i2;
    }

    @Override // g.a.l
    public void d(i.d.c<? super g.a.l<T>> cVar) {
        long j2 = this.f14365d;
        long j3 = this.f14364c;
        if (j2 == j3) {
            this.f14110b.a((g.a.q) new a(cVar, j3, this.f14366e));
        } else if (j2 > j3) {
            this.f14110b.a((g.a.q) new c(cVar, j3, j2, this.f14366e));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, j3, j2, this.f14366e));
        }
    }
}
