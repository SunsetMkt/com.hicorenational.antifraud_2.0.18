package h.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableConcatMapEager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> f11698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.y0.j.j f11699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11701e;

    /* JADX INFO: compiled from: ObservableConcatMapEager.java */
    static final class a<T, R> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c, h.a.y0.d.u<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        final h.a.i0<? super R> actual;
        volatile boolean cancelled;
        h.a.y0.d.t<R> current;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11702d;
        volatile boolean done;
        final h.a.y0.j.j errorMode;
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        h.a.y0.c.o<T> queue;
        int sourceMode;
        final h.a.y0.j.c error = new h.a.y0.j.c();
        final ArrayDeque<h.a.y0.d.t<R>> observers = new ArrayDeque<>();

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, int i2, int i3, h.a.y0.j.j jVar) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = jVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                this.queue.clear();
                disposeAll();
            }
        }

        void disposeAll() {
            h.a.y0.d.t<R> tVar = this.current;
            if (tVar != null) {
                tVar.dispose();
            }
            while (true) {
                h.a.y0.d.t<R> tVarPoll = this.observers.poll();
                if (tVarPoll == null) {
                    return;
                } else {
                    tVarPoll.dispose();
                }
            }
        }

        @Override // h.a.y0.d.u
        public void drain() {
            R rPoll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.y0.c.o<T> oVar = this.queue;
            ArrayDeque<h.a.y0.d.t<R>> arrayDeque = this.observers;
            h.a.i0<? super R> i0Var = this.actual;
            h.a.y0.j.j jVar = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                int i2 = this.activeCount;
                while (i2 != this.maxConcurrency) {
                    if (this.cancelled) {
                        oVar.clear();
                        disposeAll();
                        return;
                    }
                    if (jVar == h.a.y0.j.j.IMMEDIATE && this.error.get() != null) {
                        oVar.clear();
                        disposeAll();
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                    try {
                        T tPoll = oVar.poll();
                        if (tPoll == null) {
                            break;
                        }
                        h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                        h.a.y0.d.t<R> tVar = new h.a.y0.d.t<>(this, this.prefetch);
                        arrayDeque.offer(tVar);
                        g0Var.subscribe(tVar);
                        i2++;
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.f11702d.dispose();
                        oVar.clear();
                        disposeAll();
                        this.error.addThrowable(th);
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                }
                this.activeCount = i2;
                if (this.cancelled) {
                    oVar.clear();
                    disposeAll();
                    return;
                }
                if (jVar == h.a.y0.j.j.IMMEDIATE && this.error.get() != null) {
                    oVar.clear();
                    disposeAll();
                    i0Var.onError(this.error.terminate());
                    return;
                }
                h.a.y0.d.t<R> tVar2 = this.current;
                if (tVar2 == null) {
                    if (jVar == h.a.y0.j.j.BOUNDARY && this.error.get() != null) {
                        oVar.clear();
                        disposeAll();
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    h.a.y0.d.t<R> tVarPoll = arrayDeque.poll();
                    boolean z3 = tVarPoll == null;
                    if (z2 && z3) {
                        if (this.error.get() == null) {
                            i0Var.onComplete();
                            return;
                        }
                        oVar.clear();
                        disposeAll();
                        i0Var.onError(this.error.terminate());
                        return;
                    }
                    if (!z3) {
                        this.current = tVarPoll;
                    }
                    tVar2 = tVarPoll;
                }
                if (tVar2 != null) {
                    h.a.y0.c.o<R> oVarQueue = tVar2.queue();
                    while (!this.cancelled) {
                        boolean zIsDone = tVar2.isDone();
                        if (jVar == h.a.y0.j.j.IMMEDIATE && this.error.get() != null) {
                            oVar.clear();
                            disposeAll();
                            i0Var.onError(this.error.terminate());
                            return;
                        }
                        try {
                            rPoll = oVarQueue.poll();
                            z = rPoll == null;
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            this.error.addThrowable(th2);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (zIsDone && z) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z) {
                            i0Var.onNext(rPoll);
                        }
                    }
                    oVar.clear();
                    disposeAll();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // h.a.y0.d.u
        public void innerComplete(h.a.y0.d.t<R> tVar) {
            tVar.setDone();
            drain();
        }

        @Override // h.a.y0.d.u
        public void innerError(h.a.y0.d.t<R> tVar, Throwable th) {
            if (!this.error.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (this.errorMode == h.a.y0.j.j.IMMEDIATE) {
                this.f11702d.dispose();
            }
            tVar.setDone();
            drain();
        }

        @Override // h.a.y0.d.u
        public void innerNext(h.a.y0.d.t<R> tVar, R r) {
            tVar.queue().offer(r);
            drain();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11702d, cVar)) {
                this.f11702d = cVar;
                if (cVar instanceof h.a.y0.c.j) {
                    h.a.y0.c.j jVar = (h.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.c(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }
    }

    public x(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, h.a.y0.j.j jVar, int i2, int i3) {
        super(g0Var);
        this.f11698b = oVar;
        this.f11699c = jVar;
        this.f11700d = i2;
        this.f11701e = i3;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11698b, this.f11700d, this.f11701e, this.f11699c));
    }
}
