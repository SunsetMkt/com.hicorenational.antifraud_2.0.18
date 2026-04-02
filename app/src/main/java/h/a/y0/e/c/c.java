package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends h.a.s<T> implements h.a.v<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a[] f11106e = new a[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final a[] f11107f = new a[0];
    final AtomicReference<h.a.y<T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f11108b = new AtomicReference<>(f11106e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    T f11109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f11110d;

    /* JADX INFO: compiled from: MaybeCache.java */
    static final class a<T> extends AtomicReference<c<T>> implements h.a.u0.c {
        private static final long serialVersionUID = -5791853038359966195L;
        final h.a.v<? super T> actual;

        a(h.a.v<? super T> vVar, c<T> cVar) {
            super(cVar);
            this.actual = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            c<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b((a) this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public c(h.a.y<T> yVar) {
        this.a = new AtomicReference<>(yVar);
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f11108b.get();
            if (aVarArr == f11107f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f11108b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        a<T> aVar = new a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
                return;
            }
            h.a.y<T> andSet = this.a.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
                return;
            }
            return;
        }
        if (aVar.isDisposed()) {
            return;
        }
        Throwable th = this.f11110d;
        if (th != null) {
            vVar.onError(th);
            return;
        }
        T t = this.f11109c;
        if (t != null) {
            vVar.onSuccess(t);
        } else {
            vVar.onComplete();
        }
    }

    @Override // h.a.v
    public void onComplete() {
        for (a<T> aVar : this.f11108b.getAndSet(f11107f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // h.a.v
    public void onError(Throwable th) {
        this.f11110d = th;
        for (a<T> aVar : this.f11108b.getAndSet(f11107f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // h.a.v
    public void onSubscribe(h.a.u0.c cVar) {
    }

    @Override // h.a.v, h.a.n0
    public void onSuccess(T t) {
        this.f11109c = t;
        for (a<T> aVar : this.f11108b.getAndSet(f11107f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f11108b.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f11106e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f11108b.compareAndSet(aVarArr, aVarArr2));
    }
}
