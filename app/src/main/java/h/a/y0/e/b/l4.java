package h.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableWindow.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l4<T> extends h.a.y0.e.b.a<T, h.a.l<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f10774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f10775e;

    /* JADX INFO: compiled from: FlowableWindow.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final j.d.c<? super h.a.l<T>> actual;
        final int bufferSize;
        long index;
        final AtomicBoolean once;
        j.d.d s;
        final long size;
        h.a.d1.g<T> window;

        a(j.d.c<? super h.a.l<T>> cVar, long j2, int i2) {
            super(1);
            this.actual = cVar;
            this.size = j2;
            this.once = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // j.d.c
        public void onComplete() {
            h.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = this.index;
            h.a.d1.g<T> gVarA = this.window;
            if (j2 == 0) {
                getAndIncrement();
                gVarA = h.a.d1.g.a(this.bufferSize, (Runnable) this);
                this.window = gVarA;
                this.actual.onNext(gVarA);
            }
            long j3 = j2 + 1;
            gVarA.onNext(t);
            if (j3 != this.size) {
                this.index = j3;
                return;
            }
            this.index = 0L;
            this.window = null;
            gVarA.onComplete();
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                this.s.request(h.a.y0.j.d.b(this.size, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: FlowableWindow.java */
    static final class b<T> extends AtomicInteger implements h.a.q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final j.d.c<? super h.a.l<T>> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final h.a.y0.f.c<h.a.d1.g<T>> queue;
        final AtomicLong requested;
        j.d.d s;
        final long size;
        final long skip;
        final ArrayDeque<h.a.d1.g<T>> windows;
        final AtomicInteger wip;

        b(j.d.c<? super h.a.l<T>> cVar, long j2, long j3, int i2) {
            super(1);
            this.actual = cVar;
            this.size = j2;
            this.skip = j3;
            this.queue = new h.a.y0.f.c<>(i2);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i2;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, j.d.c<?> cVar, h.a.y0.f.c<?> cVar2) {
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
            j.d.c<? super h.a.l<T>> cVar = this.actual;
            h.a.y0.f.c<h.a.d1.g<T>> cVar2 = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    h.a.d1.g<T> gVarPoll = cVar2.poll();
                    boolean z2 = gVarPoll == null;
                    if (checkTerminated(z, z2, cVar, cVar2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(gVarPoll);
                    j3++;
                }
                if (j3 == j2 && checkTerminated(this.done, cVar2.isEmpty(), cVar, cVar2)) {
                    return;
                }
                if (j3 != 0 && j2 != i.q2.t.m0.f12222b) {
                    this.requested.addAndGet(-j3);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<h.a.d1.g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            Iterator<h.a.d1.g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index;
            if (j2 == 0 && !this.cancelled) {
                getAndIncrement();
                h.a.d1.g<T> gVarA = h.a.d1.g.a(this.bufferSize, (Runnable) this);
                this.windows.offer(gVarA);
                this.queue.offer(gVarA);
                drain();
            }
            long j3 = j2 + 1;
            Iterator<h.a.d1.g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j4 = this.produced + 1;
            if (j4 == this.size) {
                this.produced = j4 - this.skip;
                h.a.d1.g<T> gVarPoll = this.windows.poll();
                if (gVarPoll != null) {
                    gVarPoll.onComplete();
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

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(h.a.y0.j.d.b(this.skip, j2));
                } else {
                    this.s.request(h.a.y0.j.d.a(this.size, h.a.y0.j.d.b(this.skip, j2 - 1)));
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

    /* JADX INFO: compiled from: FlowableWindow.java */
    static final class c<T> extends AtomicInteger implements h.a.q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final j.d.c<? super h.a.l<T>> actual;
        final int bufferSize;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        j.d.d s;
        final long size;
        final long skip;
        h.a.d1.g<T> window;

        c(j.d.c<? super h.a.l<T>> cVar, long j2, long j3, int i2) {
            super(1);
            this.actual = cVar;
            this.size = j2;
            this.skip = j3;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // j.d.c
        public void onComplete() {
            h.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.d1.g<T> gVar = this.window;
            if (gVar != null) {
                this.window = null;
                gVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = this.index;
            h.a.d1.g<T> gVarA = this.window;
            if (j2 == 0) {
                getAndIncrement();
                gVarA = h.a.d1.g.a(this.bufferSize, (Runnable) this);
                this.window = gVarA;
                this.actual.onNext(gVarA);
            }
            long j3 = j2 + 1;
            if (gVarA != null) {
                gVarA.onNext(t);
            }
            if (j3 == this.size) {
                this.window = null;
                gVarA.onComplete();
            }
            if (j3 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j3;
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(h.a.y0.j.d.b(this.skip, j2));
                } else {
                    this.s.request(h.a.y0.j.d.a(h.a.y0.j.d.b(this.size, j2), h.a.y0.j.d.b(this.skip - this.size, j2 - 1)));
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

    public l4(h.a.l<T> lVar, long j2, long j3, int i2) {
        super(lVar);
        this.f10773c = j2;
        this.f10774d = j3;
        this.f10775e = i2;
    }

    @Override // h.a.l
    public void d(j.d.c<? super h.a.l<T>> cVar) {
        long j2 = this.f10774d;
        long j3 = this.f10773c;
        if (j2 == j3) {
            this.f10561b.a((h.a.q) new a(cVar, j3, this.f10775e));
        } else if (j2 > j3) {
            this.f10561b.a((h.a.q) new c(cVar, j3, j2, this.f10775e));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, j3, j2, this.f10775e));
        }
    }
}
