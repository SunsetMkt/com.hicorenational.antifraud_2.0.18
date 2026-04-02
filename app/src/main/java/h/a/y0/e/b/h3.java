package h.a.y0.e.b;

import h.a.y0.e.b.g3;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableSequenceEqualSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h3<T> extends h.a.k0<Boolean> implements h.a.y0.c.b<Boolean> {
    final j.d.b<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<? extends T> f10699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.d<? super T, ? super T> f10700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10701d;

    /* JADX INFO: compiled from: FlowableSequenceEqualSingle.java */
    static final class a<T> extends AtomicInteger implements h.a.u0.c, g3.b {
        private static final long serialVersionUID = -6178010334400373240L;
        final h.a.n0<? super Boolean> actual;
        final h.a.x0.d<? super T, ? super T> comparer;
        final h.a.y0.j.c error = new h.a.y0.j.c();
        final g3.c<T> first;
        final g3.c<T> second;
        T v1;
        T v2;

        a(h.a.n0<? super Boolean> n0Var, int i2, h.a.x0.d<? super T, ? super T> dVar) {
            this.actual = n0Var;
            this.comparer = dVar;
            this.first = new g3.c<>(this, i2);
            this.second = new g3.c<>(this, i2);
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // h.a.y0.e.b.g3.b
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                h.a.y0.c.o<T> oVar = this.first.queue;
                h.a.y0.c.o<T> oVar2 = this.second.queue;
                if (oVar != null && oVar2 != null) {
                    while (!isDisposed()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T tPoll = this.v1;
                        if (tPoll == null) {
                            try {
                                tPoll = oVar.poll();
                                this.v1 = tPoll;
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = tPoll == null;
                        boolean z3 = this.second.done;
                        T tPoll2 = this.v2;
                        if (tPoll2 == null) {
                            try {
                                tPoll2 = oVar2.poll();
                                this.v2 = tPoll2;
                            } catch (Throwable th2) {
                                h.a.v0.b.b(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z4 = tPoll2 == null;
                        if (z && z3 && z2 && z4) {
                            this.actual.onSuccess(true);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            this.actual.onSuccess(false);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.a(tPoll, tPoll2)) {
                                    cancelAndClear();
                                    this.actual.onSuccess(false);
                                    return;
                                } else {
                                    this.v1 = null;
                                    this.v2 = null;
                                    this.first.request();
                                    this.second.request();
                                }
                            } catch (Throwable th3) {
                                h.a.v0.b.b(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.actual.onError(this.error.terminate());
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // h.a.y0.e.b.g3.b
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.i.j.isCancelled(this.first.get());
        }

        void subscribe(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2) {
            bVar.subscribe(this.first);
            bVar2.subscribe(this.second);
        }
    }

    public h3(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, h.a.x0.d<? super T, ? super T> dVar, int i2) {
        this.a = bVar;
        this.f10699b = bVar2;
        this.f10700c = dVar;
        this.f10701d = i2;
    }

    @Override // h.a.k0
    public void b(h.a.n0<? super Boolean> n0Var) {
        a aVar = new a(n0Var, this.f10701d, this.f10700c);
        n0Var.onSubscribe(aVar);
        aVar.subscribe(this.a, this.f10699b);
    }

    @Override // h.a.y0.c.b
    public h.a.l<Boolean> b() {
        return h.a.c1.a.a(new g3(this.a, this.f10699b, this.f10700c, this.f10701d));
    }
}
