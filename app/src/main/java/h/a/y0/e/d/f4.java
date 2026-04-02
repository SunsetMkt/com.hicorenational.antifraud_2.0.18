package h.a.y0.e.d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableZip.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f4<T, R> extends h.a.b0<R> {
    final h.a.g0<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends h.a.g0<? extends T>> f11353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f11356e;

    /* JADX INFO: compiled from: ObservableZip.java */
    static final class a<T, R> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = 2983708048395377667L;
        final h.a.i0<? super R> actual;
        volatile boolean cancelled;
        final boolean delayError;
        final b<T, R>[] observers;
        final T[] row;
        final h.a.x0.o<? super Object[], ? extends R> zipper;

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
            this.actual = i0Var;
            this.zipper = oVar;
            this.observers = new b[i2];
            this.row = (T[]) new Object[i2];
            this.delayError = z;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            for (b<T, R> bVar : this.observers) {
                bVar.a();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, h.a.i0<? super R> i0Var, boolean z3, b<?, ?> bVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = bVar.f11359d;
                cancel();
                if (th != null) {
                    i0Var.onError(th);
                } else {
                    i0Var.onComplete();
                }
                return true;
            }
            Throwable th2 = bVar.f11359d;
            if (th2 != null) {
                cancel();
                i0Var.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancel();
            i0Var.onComplete();
            return true;
        }

        void clear() {
            for (b<T, R> bVar : this.observers) {
                bVar.f11357b.clear();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T, R>[] bVarArr = this.observers;
            h.a.i0<? super R> i0Var = this.actual;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (b<T, R> bVar : bVarArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = bVar.f11358c;
                        T tPoll = bVar.f11357b.poll();
                        boolean z3 = tPoll == null;
                        if (checkTerminated(z2, z3, i0Var, z, bVar)) {
                            return;
                        }
                        if (z3) {
                            i2++;
                        } else {
                            tArr[i3] = tPoll;
                        }
                    } else if (bVar.f11358c && !z && (th = bVar.f11359d) != null) {
                        cancel();
                        i0Var.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        i0Var.onNext((Object) h.a.y0.b.b.a(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        cancel();
                        i0Var.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(h.a.g0<? extends T>[] g0VarArr, int i2) {
            b<T, R>[] bVarArr = this.observers;
            int length = bVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                bVarArr[i3] = new b<>(this, i2);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.cancelled; i4++) {
                g0VarArr[i4].subscribe(bVarArr[i4]);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableZip.java */
    static final class b<T, R> implements h.a.i0<T> {
        final a<T, R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.y0.f.c<T> f11357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f11358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f11359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11360e = new AtomicReference<>();

        b(a<T, R> aVar, int i2) {
            this.a = aVar;
            this.f11357b = new h.a.y0.f.c<>(i2);
        }

        public void a() {
            h.a.y0.a.d.dispose(this.f11360e);
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11358c = true;
            this.a.drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11359d = th;
            this.f11358c = true;
            this.a.drain();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11357b.offer(t);
            this.a.drain();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.f11360e, cVar);
        }
    }

    public f4(h.a.g0<? extends T>[] g0VarArr, Iterable<? extends h.a.g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.a = g0VarArr;
        this.f11353b = iterable;
        this.f11354c = oVar;
        this.f11355d = i2;
        this.f11356e = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super R> i0Var) {
        int length;
        h.a.g0<? extends T>[] g0VarArr = this.a;
        if (g0VarArr == null) {
            g0VarArr = new h.a.b0[8];
            length = 0;
            for (h.a.g0<? extends T> g0Var : this.f11353b) {
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
        if (length == 0) {
            h.a.y0.a.e.complete(i0Var);
        } else {
            new a(i0Var, this.f11354c, length, this.f11356e).subscribe(g0VarArr, this.f11355d);
        }
    }
}
