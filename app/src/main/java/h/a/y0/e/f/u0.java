package h.a.y0.e.f;

import h.a.y0.e.f.h0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleZipArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0<T, R> extends h.a.k0<R> {
    final h.a.q0<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11894b;

    /* JADX INFO: compiled from: SingleZipArray.java */
    final class a implements h.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return (R) h.a.y0.b.b.a(u0.this.f11894b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* JADX INFO: compiled from: SingleZipArray.java */
    static final class b<T, R> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = -5556924161382950569L;
        final h.a.n0<? super R> actual;
        final c<T>[] observers;
        final Object[] values;
        final h.a.x0.o<? super Object[], ? extends R> zipper;

        b(h.a.n0<? super R> n0Var, int i2, h.a.x0.o<? super Object[], ? extends R> oVar) {
            super(i2);
            this.actual = n0Var;
            this.zipper = oVar;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.observers = cVarArr;
            this.values = new Object[i2];
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.observers) {
                    cVar.dispose();
                }
            }
        }

        void disposeExcept(int i2) {
            c<T>[] cVarArr = this.observers;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].dispose();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                } else {
                    cVarArr[i2].dispose();
                }
            }
        }

        void innerError(Throwable th, int i2) {
            if (getAndSet(0) <= 0) {
                h.a.c1.a.b(th);
            } else {
                disposeExcept(i2);
                this.actual.onError(th);
            }
        }

        void innerSuccess(T t, int i2) {
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(h.a.y0.b.b.a(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    /* JADX INFO: compiled from: SingleZipArray.java */
    static final class c<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final b<T, ?> parent;

        c(b<T, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public u0(h.a.q0<? extends T>[] q0VarArr, h.a.x0.o<? super Object[], ? extends R> oVar) {
        this.a = q0VarArr;
        this.f11894b = oVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        h.a.q0<? extends T>[] q0VarArr = this.a;
        int length = q0VarArr.length;
        if (length == 1) {
            q0VarArr[0].a(new h0.a(n0Var, new a()));
            return;
        }
        b bVar = new b(n0Var, length, this.f11894b);
        n0Var.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            h.a.q0<? extends T> q0Var = q0VarArr[i2];
            if (q0Var == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            q0Var.a(bVar.observers[i2]);
        }
    }
}
