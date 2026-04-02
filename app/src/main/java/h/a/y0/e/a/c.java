package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableConcat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends h.a.c {
    final j.d.b<? extends h.a.i> a;

    /* JADX INFO: renamed from: b */
    final int f10505b;

    /* JADX INFO: compiled from: CompletableConcat.java */
    static final class a extends AtomicInteger implements h.a.q<h.a.i>, h.a.u0.c {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        final h.a.f actual;
        int consumed;
        volatile boolean done;
        final int limit;
        final int prefetch;
        h.a.y0.c.o<h.a.i> queue;
        j.d.d s;
        int sourceFused;
        final C0183a inner = new C0183a(this);
        final AtomicBoolean once = new AtomicBoolean();

        /* JADX INFO: renamed from: h.a.y0.e.a.c$a$a */
        /* JADX INFO: compiled from: CompletableConcat.java */
        static final class C0183a extends AtomicReference<h.a.u0.c> implements h.a.f {
            private static final long serialVersionUID = -5454794857847146511L;
            final a parent;

            C0183a(a aVar) {
                this.parent = aVar;
            }

            @Override // h.a.f
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // h.a.f
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // h.a.f
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.replace(this, cVar);
            }
        }

        a(h.a.f fVar, int i2) {
            this.actual = fVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.s.cancel();
            h.a.y0.a.d.dispose(this.inner);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        h.a.i iVarPoll = this.queue.poll();
                        boolean z2 = iVarPoll == null;
                        if (z && z2) {
                            if (this.once.compareAndSet(false, true)) {
                                this.actual.onComplete();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.active = true;
                            iVarPoll.a(this.inner);
                            request();
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        innerError(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                h.a.c1.a.b(th);
            } else {
                this.s.cancel();
                this.actual.onError(th);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.inner.get());
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                h.a.c1.a.b(th);
            } else {
                h.a.y0.a.d.dispose(this.inner);
                this.actual.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                int i2 = this.prefetch;
                long j2 = i2 == Integer.MAX_VALUE ? i.q2.t.m0.f12222b : i2;
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceFused = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceFused = iRequestFusion;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(j2);
                        return;
                    }
                }
                int i3 = this.prefetch;
                if (i3 == Integer.MAX_VALUE) {
                    this.queue = new h.a.y0.f.c(h.a.l.Q());
                } else {
                    this.queue = new h.a.y0.f.b(i3);
                }
                this.actual.onSubscribe(this);
                dVar.request(j2);
            }
        }

        void request() {
            if (this.sourceFused != 1) {
                int i2 = this.consumed + 1;
                if (i2 != this.limit) {
                    this.consumed = i2;
                } else {
                    this.consumed = 0;
                    this.s.request(i2);
                }
            }
        }

        @Override // j.d.c
        public void onNext(h.a.i iVar) {
            if (this.sourceFused != 0 || this.queue.offer(iVar)) {
                drain();
            } else {
                onError(new h.a.v0.c());
            }
        }
    }

    public c(j.d.b<? extends h.a.i> bVar, int i2) {
        this.a = bVar;
        this.f10505b = i2;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar, this.f10505b));
    }
}
