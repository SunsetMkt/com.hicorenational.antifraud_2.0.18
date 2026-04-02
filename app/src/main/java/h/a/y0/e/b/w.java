package h.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableConcatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f11024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.y0.j.j f11026e;

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[h.a.y0.j.j.values().length];

        static {
            try {
                a[h.a.y0.j.j.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.y0.j.j.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    static abstract class b<T, R> extends AtomicInteger implements h.a.q<T>, f<R>, j.d.d {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final int limit;
        final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> mapper;
        final int prefetch;
        h.a.y0.c.o<T> queue;
        j.d.d s;
        int sourceMode;
        final e<R> inner = new e<>(this);
        final h.a.y0.j.c errors = new h.a.y0.j.c();

        b(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
            this.mapper = oVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        abstract void drain();

        @Override // h.a.y0.e.b.w.f
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // j.d.c
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public final void onNext(T t) {
            if (this.sourceMode == 2 || this.queue.offer(t)) {
                drain();
            } else {
                this.s.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // h.a.q
        public final void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        subscribeActual();
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        subscribeActual();
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.b(this.prefetch);
                subscribeActual();
                dVar.request(this.prefetch);
            }
        }

        abstract void subscribeActual();
    }

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    static final class c<T, R> extends b<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final j.d.c<? super R> actual;
        final boolean veryEnd;

        c(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
            super(oVar, i2);
            this.actual = cVar;
            this.veryEnd = z;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.s.cancel();
        }

        @Override // h.a.y0.e.b.w.b
        void drain() {
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        if (z && !this.veryEnd && this.errors.get() != null) {
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                        try {
                            T tPoll = this.queue.poll();
                            boolean z2 = tPoll == null;
                            if (z && z2) {
                                Throwable thTerminate = this.errors.terminate();
                                if (thTerminate != null) {
                                    this.actual.onError(thTerminate);
                                    return;
                                } else {
                                    this.actual.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                try {
                                    j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.s.request(i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) bVar).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                this.actual.onNext(objCall);
                                            } else {
                                                this.active = true;
                                                e<R> eVar = this.inner;
                                                eVar.setSubscription(new g(objCall, eVar));
                                            }
                                        } catch (Throwable th) {
                                            h.a.v0.b.b(th);
                                            this.s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        bVar.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    h.a.v0.b.b(th2);
                                    this.s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            h.a.v0.b.b(th3);
                            this.s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.a.y0.e.b.w.f
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.veryEnd) {
                this.s.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
        }

        @Override // h.a.y0.e.b.w.f
        public void innerNext(R r) {
            this.actual.onNext(r);
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

        @Override // j.d.d
        public void request(long j2) {
            this.inner.request(j2);
        }

        @Override // h.a.y0.e.b.w.b
        void subscribeActual() {
            this.actual.onSubscribe(this);
        }
    }

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    static final class d<T, R> extends b<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final j.d.c<? super R> actual;
        final AtomicInteger wip;

        d(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
            super(oVar, i2);
            this.actual = cVar;
            this.wip = new AtomicInteger();
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.s.cancel();
        }

        @Override // h.a.y0.e.b.w.b
        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T tPoll = this.queue.poll();
                            boolean z2 = tPoll == null;
                            if (z && z2) {
                                this.actual.onComplete();
                                return;
                            }
                            if (!z2) {
                                try {
                                    j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.s.request(i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) bVar).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (!this.inner.isUnbounded()) {
                                                this.active = true;
                                                e<R> eVar = this.inner;
                                                eVar.setSubscription(new g(objCall, eVar));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.actual.onNext(objCall);
                                                if (!compareAndSet(1, 0)) {
                                                    this.actual.onError(this.errors.terminate());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            h.a.v0.b.b(th);
                                            this.s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        bVar.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    h.a.v0.b.b(th2);
                                    this.s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            h.a.v0.b.b(th3);
                            this.s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.a.y0.e.b.w.f
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // h.a.y0.e.b.w.f
        public void innerNext(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.inner.request(j2);
        }

        @Override // h.a.y0.e.b.w.b
        void subscribeActual() {
            this.actual.onSubscribe(this);
        }
    }

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    static final class e<R> extends h.a.y0.i.i implements h.a.q<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final f<R> parent;
        long produced;

        e(f<R> fVar) {
            this.parent = fVar;
        }

        @Override // j.d.c
        public void onComplete() {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.parent.innerComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.parent.innerError(th);
        }

        @Override // j.d.c
        public void onNext(R r) {
            this.produced++;
            this.parent.innerNext(r);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            setSubscription(dVar);
        }
    }

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    interface f<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t);
    }

    /* JADX INFO: compiled from: FlowableConcatMap.java */
    static final class g<T> implements j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f11027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11028c;

        g(T t, j.d.c<? super T> cVar) {
            this.f11027b = t;
            this.a = cVar;
        }

        @Override // j.d.d
        public void cancel() {
        }

        @Override // j.d.d
        public void request(long j2) {
            if (j2 <= 0 || this.f11028c) {
                return;
            }
            this.f11028c = true;
            j.d.c<? super T> cVar = this.a;
            cVar.onNext(this.f11027b);
            cVar.onComplete();
        }
    }

    public w(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, h.a.y0.j.j jVar) {
        super(lVar);
        this.f11024c = oVar;
        this.f11025d = i2;
        this.f11026e = jVar;
    }

    public static <T, R> j.d.c<T> a(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, h.a.y0.j.j jVar) {
        int i3 = a.a[jVar.ordinal()];
        return i3 != 1 ? i3 != 2 ? new d(cVar, oVar, i2) : new c(cVar, oVar, i2, true) : new c(cVar, oVar, i2, false);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        if (d3.a(this.f10561b, cVar, this.f11024c)) {
            return;
        }
        this.f10561b.subscribe(a(cVar, this.f11024c, this.f11025d, this.f11026e));
    }
}
