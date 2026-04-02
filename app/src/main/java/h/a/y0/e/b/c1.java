package h.a.y0.e.b;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableFlattenIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c1<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f10592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10593d;

    /* JADX INFO: compiled from: FlowableFlattenIterable.java */
    static final class a<T, R> extends h.a.y0.i.c<R> implements h.a.q<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        int fusionMode;
        final int limit;
        final h.a.x0.o<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        h.a.y0.c.o<T> queue;
        j.d.d s;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        a(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, j.d.c<?> cVar, h.a.y0.c.o<?> oVar) {
            if (this.cancelled) {
                this.current = null;
                oVar.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                cVar.onComplete();
                return true;
            }
            Throwable thA = h.a.y0.j.k.a(this.error);
            this.current = null;
            oVar.clear();
            cVar.onError(thA);
            return true;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        void consumedOne(boolean z) {
            if (z) {
                int i2 = this.consumed + 1;
                if (i2 != this.limit) {
                    this.consumed = i2;
                } else {
                    this.consumed = 0;
                    this.s.request(i2);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x0124 A[PHI: r6
  0x0124: PHI (r6v4 java.util.Iterator<? extends R>) = (r6v3 java.util.Iterator<? extends R>), (r6v6 java.util.Iterator<? extends R>) binds: [B:30:0x0080, B:67:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<?> cVar = this.actual;
            h.a.y0.c.o<T> oVar = this.queue;
            boolean z = this.fusionMode != 1;
            Iterator<? extends R> it = this.current;
            int iAddAndGet = 1;
            while (true) {
                if (it == null) {
                    boolean z2 = this.done;
                    try {
                        T tPoll = oVar.poll();
                        if (checkTerminated(z2, tPoll == null, cVar, oVar)) {
                            return;
                        }
                        if (tPoll != null) {
                            try {
                                it = this.mapper.apply(tPoll).iterator();
                                if (it.hasNext()) {
                                    this.current = it;
                                } else {
                                    consumedOne(z);
                                    it = null;
                                }
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                this.s.cancel();
                                h.a.y0.j.k.a(this.error, th);
                                cVar.onError(h.a.y0.j.k.a(this.error));
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        this.s.cancel();
                        h.a.y0.j.k.a(this.error, th2);
                        Throwable thA = h.a.y0.j.k.a(this.error);
                        this.current = null;
                        oVar.clear();
                        cVar.onError(thA);
                        return;
                    }
                }
                if (it != null) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2) {
                            break;
                        }
                        if (checkTerminated(this.done, false, cVar, oVar)) {
                            return;
                        }
                        try {
                            cVar.onNext((Object) h.a.y0.b.b.a(it.next(), "The iterator returned a null value"));
                            if (checkTerminated(this.done, false, cVar, oVar)) {
                                return;
                            }
                            j3++;
                            try {
                                if (!it.hasNext()) {
                                    consumedOne(z);
                                    this.current = null;
                                    it = null;
                                    break;
                                }
                            } catch (Throwable th3) {
                                h.a.v0.b.b(th3);
                                this.current = null;
                                this.s.cancel();
                                h.a.y0.j.k.a(this.error, th3);
                                cVar.onError(h.a.y0.j.k.a(this.error));
                                return;
                            }
                        } catch (Throwable th4) {
                            h.a.v0.b.b(th4);
                            this.current = null;
                            this.s.cancel();
                            h.a.y0.j.k.a(this.error, th4);
                            cVar.onError(h.a.y0.j.k.a(this.error));
                            return;
                        }
                    }
                    if (j3 == j2) {
                        if (checkTerminated(this.done, oVar.isEmpty() && it == null, cVar, oVar)) {
                            return;
                        }
                    }
                    if (j3 != 0 && j2 != i.q2.t.m0.f12222b) {
                        this.requested.addAndGet(-j3);
                    }
                    if (it != null) {
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.current == null ? this.queue.isEmpty() : !r0.hasNext();
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
            if (this.done || !h.a.y0.j.k.a(this.error, th)) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new h.a.v0.c("Queue is full?!"));
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.b(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T tPoll = this.queue.poll();
                    if (tPoll != null) {
                        it = this.mapper.apply(tPoll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) h.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return r;
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return ((i2 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }

    public c1(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar, int i2) {
        super(lVar);
        this.f10592c = oVar;
        this.f10593d = i2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // h.a.l
    public void d(j.d.c<? super R> cVar) {
        h.a.l<T> lVar = this.f10561b;
        if (!(lVar instanceof Callable)) {
            lVar.a((h.a.q) new a(cVar, this.f10592c, this.f10593d));
            return;
        }
        try {
            Object objCall = ((Callable) lVar).call();
            if (objCall == null) {
                h.a.y0.i.g.complete(cVar);
                return;
            }
            try {
                g1.a((j.d.c) cVar, (Iterator) this.f10592c.apply(objCall).iterator());
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.i.g.error(th, cVar);
            }
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.y0.i.g.error(th2, cVar);
        }
    }
}
