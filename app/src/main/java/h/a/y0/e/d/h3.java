package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableSwitchMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h3<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> f11401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11403d;

    /* JADX INFO: compiled from: ObservableSwitchMap.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.i0<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        volatile boolean done;
        final long index;
        final b<T, R> parent;
        final h.a.y0.f.c<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.queue = new h.a.y0.f.c<>(i2);
        }

        public void cancel() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // h.a.i0
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                this.queue.offer(r);
                this.parent.drain();
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableSwitchMap.java */
    static final class b<T, R> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        static final a<Object, Object> CANCELLED = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final h.a.i0<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> mapper;
        h.a.u0.c s;
        volatile long unique;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final h.a.y0.j.c errors = new h.a.y0.j.c();

        static {
            CANCELLED.cancel();
        }

        b(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, int i2, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
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

        /* JADX WARN: Removed duplicated region for block: B:78:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x000b A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.i0<? super R> i0Var = this.actual;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = false;
                if (this.done) {
                    boolean z2 = this.active.get() == null;
                    if (this.delayErrors) {
                        if (z2) {
                            Throwable th = this.errors.get();
                            if (th != null) {
                                i0Var.onError(th);
                                return;
                            } else {
                                i0Var.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        i0Var.onError(this.errors.terminate());
                        return;
                    } else if (z2) {
                        i0Var.onComplete();
                        return;
                    }
                }
                a<T, R> aVar = this.active.get();
                if (aVar != null) {
                    h.a.y0.f.c<R> cVar = aVar.queue;
                    if (aVar.done) {
                        boolean zIsEmpty = cVar.isEmpty();
                        if (this.delayErrors) {
                            if (zIsEmpty) {
                                this.active.compareAndSet(aVar, null);
                            }
                        } else if (this.errors.get() != null) {
                            i0Var.onError(this.errors.terminate());
                            return;
                        } else if (zIsEmpty) {
                            this.active.compareAndSet(aVar, null);
                        }
                    }
                    while (!this.cancelled) {
                        if (aVar == this.active.get()) {
                            if (!this.delayErrors && this.errors.get() != null) {
                                i0Var.onError(this.errors.terminate());
                                return;
                            }
                            boolean z3 = aVar.done;
                            R rPoll = cVar.poll();
                            boolean z4 = rPoll == null;
                            if (z3 && z4) {
                                this.active.compareAndSet(aVar, null);
                            } else if (!z4) {
                                i0Var.onNext(rPoll);
                            } else if (!z) {
                                continue;
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void innerError(a<T, R> aVar, Throwable th) {
            if (aVar.index != this.unique || !this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.s.dispose();
            }
            aVar.done = true;
            drain();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.done && this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                if (!this.delayErrors) {
                    disposeInner();
                }
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            a<T, R> aVar;
            long j2 = this.unique + 1;
            this.unique = j2;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.mapper.apply(t), "The ObservableSource returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                g0Var.subscribe(aVar3);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public h3(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, int i2, boolean z) {
        super(g0Var);
        this.f11401b = oVar;
        this.f11402c = i2;
        this.f11403d = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super R> i0Var) {
        if (s2.a(this.a, i0Var, this.f11401b)) {
            return;
        }
        this.a.subscribe(new b(i0Var, this.f11401b, this.f11402c, this.f11403d));
    }
}
