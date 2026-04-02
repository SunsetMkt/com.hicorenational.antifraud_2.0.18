package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableSequenceEqualSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w2<T> extends h.a.k0<Boolean> implements h.a.y0.c.d<Boolean> {
    final h.a.g0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<? extends T> f11690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.d<? super T, ? super T> f11691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11692d;

    /* JADX INFO: compiled from: ObservableSequenceEqualSingle.java */
    static final class a<T> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = -6178010334400373240L;
        final h.a.n0<? super Boolean> actual;
        volatile boolean cancelled;
        final h.a.x0.d<? super T, ? super T> comparer;
        final h.a.g0<? extends T> first;
        final b<T>[] observers;
        final h.a.y0.a.a resources = new h.a.y0.a.a(2);
        final h.a.g0<? extends T> second;
        T v1;
        T v2;

        a(h.a.n0<? super Boolean> n0Var, int i2, h.a.g0<? extends T> g0Var, h.a.g0<? extends T> g0Var2, h.a.x0.d<? super T, ? super T> dVar) {
            this.actual = n0Var;
            this.first = g0Var;
            this.second = g0Var2;
            this.comparer = dVar;
            this.observers = new b[]{new b<>(this, 0, i2), new b<>(this, 1, i2)};
        }

        void cancel(h.a.y0.f.c<T> cVar, h.a.y0.f.c<T> cVar2) {
            this.cancelled = true;
            cVar.clear();
            cVar2.clear();
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.observers;
                bVarArr[0].f11693b.clear();
                bVarArr[1].f11693b.clear();
            }
        }

        void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T>[] bVarArr = this.observers;
            b<T> bVar = bVarArr[0];
            h.a.y0.f.c<T> cVar = bVar.f11693b;
            b<T> bVar2 = bVarArr[1];
            h.a.y0.f.c<T> cVar2 = bVar2.f11693b;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = bVar.f11695d;
                if (z && (th2 = bVar.f11696e) != null) {
                    cancel(cVar, cVar2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f11695d;
                if (z2 && (th = bVar2.f11696e) != null) {
                    cancel(cVar, cVar2);
                    this.actual.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = cVar.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = cVar2.poll();
                }
                boolean z4 = this.v2 == null;
                if (z && z2 && z3 && z4) {
                    this.actual.onSuccess(true);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(cVar, cVar2);
                    this.actual.onSuccess(false);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.a(this.v1, this.v2)) {
                            cancel(cVar, cVar2);
                            this.actual.onSuccess(false);
                            return;
                        } else {
                            this.v1 = null;
                            this.v2 = null;
                        }
                    } catch (Throwable th3) {
                        h.a.v0.b.b(th3);
                        cancel(cVar, cVar2);
                        this.actual.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar.clear();
            cVar2.clear();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        boolean setDisposable(h.a.u0.c cVar, int i2) {
            return this.resources.setResource(i2, cVar);
        }

        void subscribe() {
            b<T>[] bVarArr = this.observers;
            this.first.subscribe(bVarArr[0]);
            this.second.subscribe(bVarArr[1]);
        }
    }

    /* JADX INFO: compiled from: ObservableSequenceEqualSingle.java */
    static final class b<T> implements h.a.i0<T> {
        final a<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.y0.f.c<T> f11693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f11694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f11695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Throwable f11696e;

        b(a<T> aVar, int i2, int i3) {
            this.a = aVar;
            this.f11694c = i2;
            this.f11693b = new h.a.y0.f.c<>(i3);
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11695d = true;
            this.a.drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11696e = th;
            this.f11695d = true;
            this.a.drain();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11693b.offer(t);
            this.a.drain();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.setDisposable(cVar, this.f11694c);
        }
    }

    public w2(h.a.g0<? extends T> g0Var, h.a.g0<? extends T> g0Var2, h.a.x0.d<? super T, ? super T> dVar, int i2) {
        this.a = g0Var;
        this.f11690b = g0Var2;
        this.f11691c = dVar;
        this.f11692d = i2;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<Boolean> a() {
        return h.a.c1.a.a(new v2(this.a, this.f11690b, this.f11691c, this.f11692d));
    }

    @Override // h.a.k0
    public void b(h.a.n0<? super Boolean> n0Var) {
        a aVar = new a(n0Var, this.f11692d, this.a, this.f11690b, this.f11691c);
        n0Var.onSubscribe(aVar);
        aVar.subscribe();
    }
}
