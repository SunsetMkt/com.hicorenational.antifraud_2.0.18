package h.a.y0.e.e;

import i.q2.t.m0;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ParallelReduce.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T, R> extends h.a.b1.b<R> {
    final h.a.b1.b<? extends T> a;

    /* JADX INFO: renamed from: b */
    final Callable<R> f11810b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.c<R, ? super T, R> f11811c;

    /* JADX INFO: compiled from: ParallelReduce.java */
    static final class a<T, R> extends h.a.y0.h.g<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final h.a.x0.c<R, ? super T, R> reducer;

        a(j.d.c<? super R> cVar, R r, h.a.x0.c<R, ? super T, R> cVar2) {
            super(cVar);
            this.accumulator = r;
            this.reducer = cVar2;
        }

        @Override // h.a.y0.h.g, h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // h.a.y0.h.g, j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            R r = this.accumulator;
            this.accumulator = null;
            complete(r);
        }

        @Override // h.a.y0.h.g, j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.accumulator = null;
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator = (R) h.a.y0.b.b.a(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // h.a.y0.h.g, h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(m0.f12222b);
            }
        }
    }

    public m(h.a.b1.b<? extends T> bVar, Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        this.a = bVar;
        this.f11810b = callable;
        this.f11811c = cVar;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super Object>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    cVarArr2[i2] = new a(cVarArr[i2], h.a.y0.b.b.a(this.f11810b.call(), "The initialSupplier returned a null value"), this.f11811c);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    a(cVarArr, th);
                    return;
                }
            }
            this.a.a(cVarArr2);
        }
    }

    void a(j.d.c<?>[] cVarArr, Throwable th) {
        for (j.d.c<?> cVar : cVarArr) {
            h.a.y0.i.g.error(th, cVar);
        }
    }

    @Override // h.a.b1.b
    public int a() {
        return this.a.a();
    }
}
