package h.a.y0.e.d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: ObservableWithLatestFromMany.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e4<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h.a.t0.g
    final h.a.g0<?>[] f11334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h.a.t0.g
    final Iterable<? extends h.a.g0<?>> f11335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h.a.t0.f
    final h.a.x0.o<? super Object[], R> f11336d;

    /* JADX INFO: compiled from: ObservableWithLatestFromMany.java */
    final class a implements h.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return (R) h.a.y0.b.b.a(e4.this.f11336d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* JADX INFO: compiled from: ObservableWithLatestFromMany.java */
    static final class b<T, R> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 1577321883966341961L;
        final h.a.i0<? super R> actual;
        final h.a.x0.o<? super Object[], R> combiner;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11337d;
        volatile boolean done;
        final h.a.y0.j.c error;
        final c[] observers;
        final AtomicReferenceArray<Object> values;

        b(h.a.i0<? super R> i0Var, h.a.x0.o<? super Object[], R> oVar, int i2) {
            this.actual = i0Var;
            this.combiner = oVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.observers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.f11337d = new AtomicReference<>();
            this.error = new h.a.y0.j.c();
        }

        void cancelAllBut(int i2) {
            c[] cVarArr = this.observers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.f11337d);
            for (c cVar : this.observers) {
                cVar.dispose();
            }
        }

        void innerComplete(int i2, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            cancelAllBut(i2);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        void innerError(int i2, Throwable th) {
            this.done = true;
            h.a.y0.a.d.dispose(this.f11337d);
            cancelAllBut(i2);
            h.a.y0.j.l.a((h.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.f11337d.get());
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            h.a.y0.j.l.a((h.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i2 = 0;
            objArr[0] = t;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                h.a.y0.j.l.a(this.actual, h.a.y0.b.b.a(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.f11337d, cVar);
        }

        void subscribe(h.a.g0<?>[] g0VarArr, int i2) {
            c[] cVarArr = this.observers;
            AtomicReference<h.a.u0.c> atomicReference = this.f11337d;
            for (int i3 = 0; i3 < i2 && !h.a.y0.a.d.isDisposed(atomicReference.get()) && !this.done; i3++) {
                g0VarArr[i3].subscribe(cVarArr[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableWithLatestFromMany.java */
    static final class c extends AtomicReference<h.a.u0.c> implements h.a.i0<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.i0
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public e4(@h.a.t0.f h.a.g0<T> g0Var, @h.a.t0.f h.a.g0<?>[] g0VarArr, @h.a.t0.f h.a.x0.o<? super Object[], R> oVar) {
        super(g0Var);
        this.f11334b = g0VarArr;
        this.f11335c = null;
        this.f11336d = oVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        int length;
        h.a.g0<?>[] g0VarArr = this.f11334b;
        if (g0VarArr == null) {
            g0VarArr = new h.a.g0[8];
            try {
                length = 0;
                for (h.a.g0<?> g0Var : this.f11335c) {
                    if (length == g0VarArr.length) {
                        g0VarArr = (h.a.g0[]) Arrays.copyOf(g0VarArr, (length >> 1) + length);
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
            new u1(this.a, new a()).d((h.a.i0) i0Var);
            return;
        }
        b bVar = new b(i0Var, this.f11336d, length);
        i0Var.onSubscribe(bVar);
        bVar.subscribe(g0VarArr, length);
        this.a.subscribe(bVar);
    }

    public e4(@h.a.t0.f h.a.g0<T> g0Var, @h.a.t0.f Iterable<? extends h.a.g0<?>> iterable, @h.a.t0.f h.a.x0.o<? super Object[], R> oVar) {
        super(g0Var);
        this.f11334b = null;
        this.f11335c = iterable;
        this.f11336d = oVar;
    }
}
