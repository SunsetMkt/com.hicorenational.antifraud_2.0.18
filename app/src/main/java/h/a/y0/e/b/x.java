package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableConcatMapEager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f11036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.y0.j.j f11039f;

    /* JADX INFO: compiled from: FlowableConcatMapEager.java */
    static final class a<T, R> extends AtomicInteger implements h.a.q<T>, j.d.d, h.a.y0.h.k<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        volatile h.a.y0.h.j<R> current;
        volatile boolean done;
        final h.a.y0.j.j errorMode;
        final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        j.d.d s;
        final h.a.y0.f.c<h.a.y0.h.j<R>> subscribers;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final AtomicLong requested = new AtomicLong();

        a(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, int i3, h.a.y0.j.j jVar) {
            this.actual = cVar;
            this.mapper = oVar;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = jVar;
            this.subscribers = new h.a.y0.f.c<>(Math.min(i3, i2));
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            drainAndCancel();
        }

        void cancelAll() {
            while (true) {
                h.a.y0.h.j<R> jVarPoll = this.subscribers.poll();
                if (jVarPoll == null) {
                    return;
                } else {
                    jVarPoll.cancel();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x0110  */
        @Override // h.a.y0.h.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            h.a.y0.h.j<R> jVarPoll;
            int i2;
            long j2;
            boolean z;
            h.a.y0.c.o<R> oVarQueue;
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.y0.h.j<R> jVar = this.current;
            j.d.c<? super R> cVar = this.actual;
            h.a.y0.j.j jVar2 = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.requested.get();
                if (jVar != null) {
                    jVarPoll = jVar;
                } else {
                    if (jVar2 != h.a.y0.j.j.END && this.errors.get() != null) {
                        cancelAll();
                        cVar.onError(this.errors.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    jVarPoll = this.subscribers.poll();
                    if (z2 && jVarPoll == null) {
                        Throwable thTerminate = this.errors.terminate();
                        if (thTerminate != null) {
                            cVar.onError(thTerminate);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                    if (jVarPoll != null) {
                        this.current = jVarPoll;
                    }
                }
                if (jVarPoll == null || (oVarQueue = jVarPoll.queue()) == null) {
                    i2 = iAddAndGet;
                    jVar = jVarPoll;
                    j2 = 0;
                    z = false;
                } else {
                    i2 = iAddAndGet;
                    j2 = 0;
                    while (j2 != j3) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (jVar2 == h.a.y0.j.j.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            jVarPoll.cancel();
                            cancelAll();
                            cVar.onError(this.errors.terminate());
                            return;
                        }
                        boolean zIsDone = jVarPoll.isDone();
                        try {
                            R rPoll = oVarQueue.poll();
                            boolean z3 = rPoll == null;
                            if (zIsDone && z3) {
                                this.current = null;
                                this.s.request(1L);
                                jVarPoll = null;
                                z = true;
                                break;
                            }
                            if (z3) {
                                break;
                            }
                            cVar.onNext(rPoll);
                            j2++;
                            jVarPoll.requestOne();
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            this.current = null;
                            jVarPoll.cancel();
                            cancelAll();
                            cVar.onError(th);
                            return;
                        }
                    }
                    z = false;
                    if (j2 != j3) {
                        jVar = jVarPoll;
                    } else {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (jVar2 == h.a.y0.j.j.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            jVarPoll.cancel();
                            cancelAll();
                            cVar.onError(this.errors.terminate());
                            return;
                        }
                        boolean zIsDone2 = jVarPoll.isDone();
                        boolean zIsEmpty = oVarQueue.isEmpty();
                        if (zIsDone2 && zIsEmpty) {
                            this.current = null;
                            this.s.request(1L);
                            jVar = null;
                            z = true;
                        }
                    }
                }
                if (j2 != 0 && j3 != i.q2.t.m0.f12222b) {
                    this.requested.addAndGet(-j2);
                }
                if (z) {
                    iAddAndGet = i2;
                } else {
                    iAddAndGet = addAndGet(-i2);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // h.a.y0.h.k
        public void innerComplete(h.a.y0.h.j<R> jVar) {
            jVar.setDone();
            drain();
        }

        @Override // h.a.y0.h.k
        public void innerError(h.a.y0.h.j<R> jVar, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            jVar.setDone();
            if (this.errorMode != h.a.y0.j.j.END) {
                this.s.cancel();
            }
            drain();
        }

        @Override // h.a.y0.h.k
        public void innerNext(h.a.y0.h.j<R> jVar, R r) {
            if (jVar.queue().offer(r)) {
                drain();
            } else {
                jVar.cancel();
                innerError(jVar, new h.a.v0.c());
            }
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            try {
                j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null Publisher");
                h.a.y0.h.j<R> jVar = new h.a.y0.h.j<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(jVar);
                if (this.cancelled) {
                    return;
                }
                bVar.subscribe(jVar);
                if (this.cancelled) {
                    jVar.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                dVar.request(i2 == Integer.MAX_VALUE ? i.q2.t.m0.f12222b : i2);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public x(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, int i3, h.a.y0.j.j jVar) {
        super(lVar);
        this.f11036c = oVar;
        this.f11037d = i2;
        this.f11038e = i3;
        this.f11039f = jVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11036c, this.f11037d, this.f11038e, this.f11039f));
    }
}
