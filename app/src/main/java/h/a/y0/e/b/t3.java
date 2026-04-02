package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableSwitchMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t3<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f10994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f10996e;

    /* JADX INFO: compiled from: FlowableSwitchMap.java */
    static final class a<T, R> extends AtomicReference<j.d.d> implements h.a.q<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final b<T, R> parent;
        volatile h.a.y0.c.o<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.bufferSize = i2;
        }

        public void cancel() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // j.d.c
        public void onComplete() {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                this.done = true;
                bVar.drain();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            b<T, R> bVar = this.parent;
            if (this.index != bVar.unique || !bVar.error.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!bVar.delayErrors) {
                bVar.s.cancel();
            }
            this.done = true;
            bVar.drain();
        }

        @Override // j.d.c
        public void onNext(R r) {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                if (this.fusionMode != 0 || this.queue.offer(r)) {
                    bVar.drain();
                } else {
                    onError(new h.a.v0.c("Queue full?!"));
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        dVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.b(this.bufferSize);
                dVar.request(this.bufferSize);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableSwitchMap.java */
    static final class b<T, R> extends AtomicInteger implements h.a.q<T>, j.d.d {
        static final a<Object, Object> CANCELLED = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final j.d.c<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> mapper;
        j.d.d s;
        volatile long unique;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final h.a.y0.j.c error = new h.a.y0.j.c();

        static {
            CANCELLED.cancel();
        }

        b(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
            this.actual = cVar;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            disposeInner();
        }

        void disposeInner() {
            a<T, R> andSet;
            a<T, R> aVar = this.active.get();
            a<Object, Object> aVar2 = CANCELLED;
            if (aVar == aVar2 || (andSet = this.active.getAndSet((a<T, R>) aVar2)) == CANCELLED || andSet == null) {
                return;
            }
            andSet.cancel();
        }

        void drain() {
            boolean z;
            defpackage.a aVarPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super R> cVar = this.actual;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.done) {
                    if (this.delayErrors) {
                        if (this.active.get() == null) {
                            if (this.error.get() != null) {
                                cVar.onError(this.error.terminate());
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        }
                    } else if (this.error.get() != null) {
                        disposeInner();
                        cVar.onError(this.error.terminate());
                        return;
                    } else if (this.active.get() == null) {
                        cVar.onComplete();
                        return;
                    }
                }
                a<T, R> aVar = this.active.get();
                h.a.y0.c.o<R> oVar = aVar != null ? aVar.queue : null;
                if (oVar != null) {
                    if (aVar.done) {
                        if (this.delayErrors) {
                            if (oVar.isEmpty()) {
                                this.active.compareAndSet(aVar, null);
                            }
                        } else if (this.error.get() != null) {
                            disposeInner();
                            cVar.onError(this.error.terminate());
                            return;
                        } else if (oVar.isEmpty()) {
                            this.active.compareAndSet(aVar, null);
                        }
                    }
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        z = false;
                        if (j3 != j2) {
                            if (!this.cancelled) {
                                boolean z2 = aVar.done;
                                try {
                                    aVarPoll = oVar.poll();
                                } catch (Throwable th) {
                                    h.a.v0.b.b(th);
                                    aVar.cancel();
                                    this.error.addThrowable(th);
                                    aVarPoll = null;
                                    z2 = true;
                                }
                                boolean z3 = aVarPoll == null;
                                if (aVar != this.active.get()) {
                                    break;
                                }
                                if (z2) {
                                    if (!this.delayErrors) {
                                        if (this.error.get() == null) {
                                            if (z3) {
                                                this.active.compareAndSet(aVar, null);
                                                break;
                                            }
                                        } else {
                                            cVar.onError(this.error.terminate());
                                            return;
                                        }
                                    } else if (z3) {
                                        this.active.compareAndSet(aVar, null);
                                        break;
                                    }
                                }
                                if (z3) {
                                    break;
                                }
                                cVar.onNext(aVarPoll);
                                j3++;
                            } else {
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    z = true;
                    if (j3 != 0 && !this.cancelled) {
                        if (j2 != i.q2.t.m0.f12222b) {
                            this.requested.addAndGet(-j3);
                        }
                        aVar.get().request(j3);
                    }
                    if (z) {
                        continue;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            this.active.lazySet(null);
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done || !this.error.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            a<T, R> aVar;
            if (this.done) {
                return;
            }
            long j2 = this.unique + 1;
            this.unique = j2;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.mapper.apply(t), "The publisher returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                bVar.subscribe(aVar3);
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
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                if (this.unique == 0) {
                    this.s.request(i.q2.t.m0.f12222b);
                } else {
                    drain();
                }
            }
        }
    }

    public t3(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
        super(lVar);
        this.f10994c = oVar;
        this.f10995d = i2;
        this.f10996e = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        if (d3.a(this.f10561b, cVar, this.f10994c)) {
            return;
        }
        this.f10561b.a((h.a.q) new b(cVar, this.f10994c, this.f10995d, this.f10996e));
    }
}
