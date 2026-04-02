package h.a.y0.e.e;

import i.q2.t.m0;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ParallelCollect.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T, C> extends h.a.b1.b<C> {
    final h.a.b1.b<? extends T> a;

    /* JADX INFO: renamed from: b */
    final Callable<? extends C> f11744b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.b<? super C, ? super T> f11745c;

    /* JADX INFO: renamed from: h.a.y0.e.e.a$a */
    /* JADX INFO: compiled from: ParallelCollect.java */
    static final class C0223a<T, C> extends h.a.y0.h.g<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final h.a.x0.b<? super C, ? super T> collector;
        boolean done;

        C0223a(j.d.c<? super C> cVar, C c2, h.a.x0.b<? super C, ? super T> bVar) {
            super(cVar);
            this.collection = c2;
            this.collector = bVar;
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
            C c2 = this.collection;
            this.collection = null;
            complete(c2);
        }

        @Override // h.a.y0.h.g, j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.collection = null;
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.a(this.collection, t);
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

    public a(h.a.b1.b<? extends T> bVar, Callable<? extends C> callable, h.a.x0.b<? super C, ? super T> bVar2) {
        this.a = bVar;
        this.f11744b = callable;
        this.f11745c = bVar2;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super C>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super Object>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    cVarArr2[i2] = new C0223a(cVarArr[i2], h.a.y0.b.b.a(this.f11744b.call(), "The initialSupplier returned a null value"), this.f11745c);
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
