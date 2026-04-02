package h.a.y0.e.e;

import h.a.j0;
import h.a.q;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ParallelRunOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T> extends h.a.b1.b<T> {
    final h.a.b1.b<? extends T> a;

    /* JADX INFO: renamed from: b */
    final j0 f11814b;

    /* JADX INFO: renamed from: c */
    final int f11815c;

    /* JADX INFO: compiled from: ParallelRunOn.java */
    static abstract class a<T> extends AtomicInteger implements q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final h.a.y0.f.b<T> queue;
        final AtomicLong requested = new AtomicLong();
        j.d.d s;
        final j0.c worker;

        a(int i2, h.a.y0.f.b<T> bVar, j0.c cVar) {
            this.prefetch = i2;
            this.queue = bVar;
            this.limit = i2 - (i2 >> 2);
            this.worker = cVar;
        }

        @Override // j.d.d
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // j.d.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // j.d.c
        public final void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // j.d.c
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.queue.offer(t)) {
                schedule();
            } else {
                this.s.cancel();
                onError(new h.a.v0.c("Queue is full?!"));
            }
        }

        @Override // j.d.d
        public final void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                schedule();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a(this);
            }
        }
    }

    /* JADX INFO: compiled from: ParallelRunOn.java */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final h.a.y0.c.a<? super T> actual;

        b(h.a.y0.c.a<? super T> aVar, int i2, h.a.y0.f.b<T> bVar, j0.c cVar) {
            super(i2, bVar, cVar);
            this.actual = aVar;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            h.a.y0.f.b<T> bVar = this.queue;
            h.a.y0.c.a<? super T> aVar = this.actual;
            int i3 = this.limit;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        bVar.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T tPoll = bVar.poll();
                    boolean z2 = tPoll == null;
                    if (z && z2) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        if (aVar.tryOnNext(tPoll)) {
                            j3++;
                        }
                        i2++;
                        if (i2 == i3) {
                            this.s.request(i2);
                            i2 = 0;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            bVar.clear();
                            aVar.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (bVar.isEmpty()) {
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != m0.f12222b) {
                    this.requested.addAndGet(-j3);
                }
                int i4 = get();
                if (i4 == iAddAndGet) {
                    this.consumed = i2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i4;
                }
            }
        }
    }

    /* JADX INFO: compiled from: ParallelRunOn.java */
    static final class c<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final j.d.c<? super T> actual;

        c(j.d.c<? super T> cVar, int i2, h.a.y0.f.b<T> bVar, j0.c cVar2) {
            super(i2, bVar, cVar2);
            this.actual = cVar;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            h.a.y0.f.b<T> bVar = this.queue;
            j.d.c<? super T> cVar = this.actual;
            int i3 = this.limit;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        bVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T tPoll = bVar.poll();
                    boolean z2 = tPoll == null;
                    if (z && z2) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j3++;
                        i2++;
                        if (i2 == i3) {
                            this.s.request(i2);
                            i2 = 0;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            bVar.clear();
                            cVar.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (bVar.isEmpty()) {
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != m0.f12222b) {
                    this.requested.addAndGet(-j3);
                }
                int i4 = get();
                if (i4 == iAddAndGet) {
                    this.consumed = i2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i4;
                }
            }
        }
    }

    public o(h.a.b1.b<? extends T> bVar, j0 j0Var, int i2) {
        this.a = bVar;
        this.f11814b = j0Var;
        this.f11815c = i2;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super Object>[] cVarArr2 = new j.d.c[length];
            int i2 = this.f11815c;
            for (int i3 = 0; i3 < length; i3++) {
                j.d.c<? super T> cVar = cVarArr[i3];
                j0.c cVarA = this.f11814b.a();
                h.a.y0.f.b bVar = new h.a.y0.f.b(i2);
                if (cVar instanceof h.a.y0.c.a) {
                    cVarArr2[i3] = new b((h.a.y0.c.a) cVar, i2, bVar, cVarA);
                } else {
                    cVarArr2[i3] = new c(cVar, i2, bVar, cVarA);
                }
            }
            this.a.a(cVarArr2);
        }
    }

    @Override // h.a.b1.b
    public int a() {
        return this.a.a();
    }
}
