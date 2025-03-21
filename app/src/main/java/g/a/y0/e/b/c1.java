package g.a.y0.e.b;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlattenIterable.java */
/* loaded from: classes2.dex */
public final class c1<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f14149c;

    /* renamed from: d, reason: collision with root package name */
    final int f14150d;

    /* compiled from: FlowableFlattenIterable.java */
    static final class a<T, R> extends g.a.y0.i.c<R> implements g.a.q<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        int fusionMode;
        final int limit;
        final g.a.x0.o<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        g.a.y0.c.o<T> queue;
        i.d.d s;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        a(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // i.d.d
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

        boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar, g.a.y0.c.o<?> oVar) {
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
            Throwable a2 = g.a.y0.j.k.a(this.error);
            this.current = null;
            oVar.clear();
            cVar.onError(a2);
            return true;
        }

        @Override // g.a.y0.c.o
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

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0121, code lost:
        
            if (r6 == null) goto L72;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.c1.a.drain():void");
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.current == null ? this.queue.isEmpty() : !r0.hasNext();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done || !g.a.y0.j.k.a(this.error, th)) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new g.a.v0.c("Queue is full?!"));
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int requestFusion = lVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = this.mapper.apply(poll).iterator();
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
            R r = (R) g.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return r;
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return ((i2 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }

    public c1(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar, int i2) {
        super(lVar);
        this.f14149c = oVar;
        this.f14150d = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.l
    public void d(i.d.c<? super R> cVar) {
        g.a.l<T> lVar = this.f14110b;
        if (!(lVar instanceof Callable)) {
            lVar.a((g.a.q) new a(cVar, this.f14149c, this.f14150d));
            return;
        }
        try {
            Object call = ((Callable) lVar).call();
            if (call == null) {
                g.a.y0.i.g.complete(cVar);
                return;
            }
            try {
                g1.a((i.d.c) cVar, (Iterator) this.f14149c.apply(call).iterator());
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.i.g.error(th, cVar);
            }
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.y0.i.g.error(th2, cVar);
        }
    }
}
