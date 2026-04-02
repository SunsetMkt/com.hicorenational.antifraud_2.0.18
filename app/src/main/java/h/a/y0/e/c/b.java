package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MaybeAmb.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends h.a.s<T> {
    private final h.a.y<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterable<? extends h.a.y<? extends T>> f11094b;

    /* JADX INFO: compiled from: MaybeAmb.java */
    static final class a<T> extends AtomicBoolean implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = -7044685185359438206L;
        final h.a.v<? super T> actual;
        final h.a.u0.b set = new h.a.u0.b();

        a(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // h.a.v
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onComplete();
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                h.a.c1.a.b(th);
            } else {
                this.set.dispose();
                this.actual.onError(th);
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            this.set.b(cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onSuccess(t);
            }
        }
    }

    public b(h.a.y<? extends T>[] yVarArr, Iterable<? extends h.a.y<? extends T>> iterable) {
        this.a = yVarArr;
        this.f11094b = iterable;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        int length;
        h.a.y<? extends T>[] yVarArr = this.a;
        if (yVarArr == null) {
            yVarArr = new h.a.y[8];
            try {
                length = 0;
                for (h.a.y<? extends T> yVar : this.f11094b) {
                    if (yVar == null) {
                        h.a.y0.a.e.error(new NullPointerException("One of the sources is null"), vVar);
                        return;
                    }
                    if (length == yVarArr.length) {
                        h.a.y<? extends T>[] yVarArr2 = new h.a.y[(length >> 2) + length];
                        System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                        yVarArr = yVarArr2;
                    }
                    int i2 = length + 1;
                    yVarArr[length] = yVar;
                    length = i2;
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, vVar);
                return;
            }
        } else {
            length = yVarArr.length;
        }
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        for (int i3 = 0; i3 < length; i3++) {
            h.a.y<? extends T> yVar2 = yVarArr[i3];
            if (aVar.isDisposed()) {
                return;
            }
            if (yVar2 == null) {
                aVar.onError(new NullPointerException("One of the MaybeSources is null"));
                return;
            }
            yVar2.a(aVar);
        }
        if (length == 0) {
            vVar.onComplete();
        }
    }
}
