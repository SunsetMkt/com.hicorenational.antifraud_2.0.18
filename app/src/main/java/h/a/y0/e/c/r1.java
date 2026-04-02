package h.a.y0.e.c;

import h.a.y0.e.c.u0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeZipArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r1<T, R> extends h.a.s<R> {
    final h.a.y<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11185b;

    /* JADX INFO: compiled from: MaybeZipArray.java */
    final class a implements h.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return (R) h.a.y0.b.b.a(r1.this.f11185b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* JADX INFO: compiled from: MaybeZipArray.java */
    static final class b<T, R> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = -5556924161382950569L;
        final h.a.v<? super R> actual;
        final c<T>[] observers;
        final Object[] values;
        final h.a.x0.o<? super Object[], ? extends R> zipper;

        b(h.a.v<? super R> vVar, int i2, h.a.x0.o<? super Object[], ? extends R> oVar) {
            super(i2);
            this.actual = vVar;
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

        void innerComplete(int i2) {
            if (getAndSet(0) > 0) {
                disposeExcept(i2);
                this.actual.onComplete();
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

    /* JADX INFO: compiled from: MaybeZipArray.java */
    static final class c<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T> {
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

        @Override // h.a.v
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public r1(h.a.y<? extends T>[] yVarArr, h.a.x0.o<? super Object[], ? extends R> oVar) {
        this.a = yVarArr;
        this.f11185b = oVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        h.a.y<? extends T>[] yVarArr = this.a;
        int length = yVarArr.length;
        if (length == 1) {
            yVarArr[0].a(new u0.a(vVar, new a()));
            return;
        }
        b bVar = new b(vVar, length, this.f11185b);
        vVar.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            h.a.y<? extends T> yVar = yVarArr[i2];
            if (yVar == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            yVar.a(bVar.observers[i2]);
        }
    }
}
