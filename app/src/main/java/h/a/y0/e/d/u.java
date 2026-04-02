package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableCombineLatest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u<T, R> extends h.a.b0<R> {
    final h.a.g0<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends h.a.g0<? extends T>> f11641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f11644e;

    /* JADX INFO: compiled from: ObservableCombineLatest.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.i0<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final b<T, R> parent;

        a(b<T, R> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.i0
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableCombineLatest.java */
    static final class b<T, R> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final h.a.i0<? super R> actual;
        volatile boolean cancelled;
        final h.a.x0.o<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        Object[] latest;
        final a<T, R>[] observers;
        final h.a.y0.f.c<Object[]> queue;

        b(h.a.i0<? super R> i0Var, h.a.x0.o<? super Object[], ? extends R> oVar, int i2, int i3, boolean z) {
            this.actual = i0Var;
            this.combiner = oVar;
            this.delayError = z;
            this.latest = new Object[i2];
            a<T, R>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            this.observers = aVarArr;
            this.queue = new h.a.y0.f.c<>(i3);
        }

        void cancelSources() {
            for (a<T, R> aVar : this.observers) {
                aVar.dispose();
            }
        }

        void clear(h.a.y0.f.c<?> cVar) {
            synchronized (this) {
                this.latest = null;
            }
            cVar.clear();
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear(this.queue);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.y0.f.c<Object[]> cVar = this.queue;
            h.a.i0<? super R> i0Var = this.actual;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!z && this.errors.get() != null) {
                    cancelSources();
                    clear(cVar);
                    i0Var.onError(this.errors.terminate());
                    return;
                }
                boolean z2 = this.done;
                Object[] objArrPoll = cVar.poll();
                boolean z3 = objArrPoll == null;
                if (z2 && z3) {
                    clear(cVar);
                    Throwable thTerminate = this.errors.terminate();
                    if (thTerminate == null) {
                        i0Var.onComplete();
                        return;
                    } else {
                        i0Var.onError(thTerminate);
                        return;
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        i0Var.onNext((Object) h.a.y0.b.b.a(this.combiner.apply(objArrPoll), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.errors.addThrowable(th);
                        cancelSources();
                        clear(cVar);
                        i0Var.onError(this.errors.terminate());
                        return;
                    }
                }
            }
            clear(cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0007, B:12:0x0011, B:15:0x001b, B:14:0x0019), top: B:23:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerComplete(int i2) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                boolean z = objArr[i2] == null;
                if (!z) {
                    int i3 = this.complete + 1;
                    this.complete = i3;
                    if (i3 == objArr.length) {
                        this.done = true;
                    }
                }
                if (z) {
                    cancelSources();
                }
                drain();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0025 A[Catch: all -> 0x0029, TryCatch #0 {, blocks: (B:7:0x000e, B:9:0x0012, B:11:0x0014, B:16:0x001d, B:19:0x0027, B:18:0x0025), top: B:30:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerError(int i2, Throwable th) {
            boolean z;
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (this.delayError) {
                synchronized (this) {
                    Object[] objArr = this.latest;
                    if (objArr == null) {
                        return;
                    }
                    z = objArr[i2] == null;
                    if (!z) {
                        int i3 = this.complete + 1;
                        this.complete = i3;
                        if (i3 == objArr.length) {
                            this.done = true;
                        }
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                cancelSources();
            }
            drain();
        }

        void innerNext(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i2];
                int i3 = this.active;
                if (obj == null) {
                    i3++;
                    this.active = i3;
                }
                objArr[i2] = t;
                if (i3 == objArr.length) {
                    this.queue.offer((Object[]) objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    drain();
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(h.a.g0<? extends T>[] g0VarArr) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.done && !this.cancelled; i2++) {
                g0VarArr[i2].subscribe(aVarArr[i2]);
            }
        }
    }

    public u(h.a.g0<? extends T>[] g0VarArr, Iterable<? extends h.a.g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.a = g0VarArr;
        this.f11641b = iterable;
        this.f11642c = oVar;
        this.f11643d = i2;
        this.f11644e = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super R> i0Var) {
        int length;
        h.a.g0<? extends T>[] g0VarArr = this.a;
        if (g0VarArr == null) {
            g0VarArr = new h.a.b0[8];
            length = 0;
            for (h.a.g0<? extends T> g0Var : this.f11641b) {
                if (length == g0VarArr.length) {
                    h.a.g0<? extends T>[] g0VarArr2 = new h.a.g0[(length >> 2) + length];
                    System.arraycopy(g0VarArr, 0, g0VarArr2, 0, length);
                    g0VarArr = g0VarArr2;
                }
                g0VarArr[length] = g0Var;
                length++;
            }
        } else {
            length = g0VarArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            h.a.y0.a.e.complete(i0Var);
        } else {
            new b(i0Var, this.f11642c, i2, this.f11643d, this.f11644e).subscribe(g0VarArr);
        }
    }
}
