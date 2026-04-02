package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableAmb.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends h.a.b0<T> {
    final h.a.g0<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends h.a.g0<? extends T>> f11390b;

    /* JADX INFO: compiled from: ObservableAmb.java */
    static final class b<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final h.a.i0<? super T> actual;
        final int index;
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, h.a.i0<? super T> i0Var) {
            this.parent = aVar;
            this.index = i2;
            this.actual = i0Var;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (!this.parent.a(this.index)) {
                h.a.c1.a.b(th);
            } else {
                this.won = true;
                this.actual.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (!this.parent.a(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.actual.onNext(t);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public h(h.a.g0<? extends T>[] g0VarArr, Iterable<? extends h.a.g0<? extends T>> iterable) {
        this.a = g0VarArr;
        this.f11390b = iterable;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        int length;
        h.a.g0<? extends T>[] g0VarArr = this.a;
        if (g0VarArr == null) {
            g0VarArr = new h.a.b0[8];
            try {
                length = 0;
                for (h.a.g0<? extends T> g0Var : this.f11390b) {
                    if (g0Var == null) {
                        h.a.y0.a.e.error(new NullPointerException("One of the sources is null"), i0Var);
                        return;
                    }
                    if (length == g0VarArr.length) {
                        h.a.g0<? extends T>[] g0VarArr2 = new h.a.g0[(length >> 2) + length];
                        System.arraycopy(g0VarArr, 0, g0VarArr2, 0, length);
                        g0VarArr = g0VarArr2;
                    }
                    int i2 = length + 1;
                    g0VarArr[length] = g0Var;
                    length = i2;
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, i0Var);
                return;
            }
        } else {
            length = g0VarArr.length;
        }
        if (length == 0) {
            h.a.y0.a.e.complete(i0Var);
        } else if (length == 1) {
            g0VarArr[0].subscribe(i0Var);
        } else {
            new a(i0Var, length).a(g0VarArr);
        }
    }

    /* JADX INFO: compiled from: ObservableAmb.java */
    static final class a<T> implements h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T>[] f11391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f11392c = new AtomicInteger();

        a(h.a.i0<? super T> i0Var, int i2) {
            this.a = i0Var;
            this.f11391b = new b[i2];
        }

        public void a(h.a.g0<? extends T>[] g0VarArr) {
            b<T>[] bVarArr = this.f11391b;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr[i2] = new b<>(this, i3, this.a);
                i2 = i3;
            }
            this.f11392c.lazySet(0);
            this.a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f11392c.get() == 0; i4++) {
                g0VarArr[i4].subscribe(bVarArr[i4]);
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f11392c.get() != -1) {
                this.f11392c.lazySet(-1);
                for (b<T> bVar : this.f11391b) {
                    bVar.dispose();
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11392c.get() == -1;
        }

        public boolean a(int i2) {
            int i3 = this.f11392c.get();
            int i4 = 0;
            if (i3 != 0) {
                return i3 == i2;
            }
            if (!this.f11392c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f11391b;
            int length = bVarArr.length;
            while (i4 < length) {
                int i5 = i4 + 1;
                if (i5 != i2) {
                    bVarArr[i4].dispose();
                }
                i4 = i5;
            }
            return true;
        }
    }
}
