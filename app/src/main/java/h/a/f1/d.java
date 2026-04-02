package h.a.f1;

import h.a.s;
import h.a.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends s<T> implements v<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a[] f10359e = new a[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final a[] f10360f = new a[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    T f10362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f10363d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f10361b = new AtomicBoolean();
    final AtomicReference<a<T>[]> a = new AtomicReference<>(f10359e);

    /* JADX INFO: compiled from: MaybeSubject.java */
    static final class a<T> extends AtomicReference<d<T>> implements h.a.u0.c {
        private static final long serialVersionUID = -7650903191002190468L;
        final v<? super T> actual;

        a(v<? super T> vVar, d<T> dVar) {
            this.actual = vVar;
            lazySet(dVar);
        }

        @Override // h.a.u0.c
        public void dispose() {
            d<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b((a) this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    d() {
    }

    @h.a.t0.d
    public static <T> d<T> A() {
        return new d<>();
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == f10360f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // h.a.s
    protected void b(v<? super T> vVar) {
        a<T> aVar = new a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
                return;
            }
            return;
        }
        Throwable th = this.f10363d;
        if (th != null) {
            vVar.onError(th);
            return;
        }
        T t = this.f10362c;
        if (t == null) {
            vVar.onComplete();
        } else {
            vVar.onSuccess(t);
        }
    }

    @Override // h.a.v
    public void onComplete() {
        if (this.f10361b.compareAndSet(false, true)) {
            for (a<T> aVar : this.a.getAndSet(f10360f)) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // h.a.v
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f10361b.compareAndSet(false, true)) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10363d = th;
        for (a<T> aVar : this.a.getAndSet(f10360f)) {
            aVar.actual.onError(th);
        }
    }

    @Override // h.a.v
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.a.get() == f10360f) {
            cVar.dispose();
        }
    }

    @Override // h.a.v, h.a.n0
    public void onSuccess(T t) {
        if (t == null) {
            onError(new NullPointerException("Null values are not allowed in 2.x"));
            return;
        }
        if (this.f10361b.compareAndSet(false, true)) {
            this.f10362c = t;
            for (a<T> aVar : this.a.getAndSet(f10360f)) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    public Throwable t() {
        if (this.a.get() == f10360f) {
            return this.f10363d;
        }
        return null;
    }

    public T u() {
        if (this.a.get() == f10360f) {
            return this.f10362c;
        }
        return null;
    }

    public boolean v() {
        return this.a.get() == f10360f && this.f10362c == null && this.f10363d == null;
    }

    public boolean w() {
        return this.a.get().length != 0;
    }

    public boolean x() {
        return this.a.get() == f10360f && this.f10363d != null;
    }

    public boolean y() {
        return this.a.get() == f10360f && this.f10362c != null;
    }

    int z() {
        return this.a.get().length;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
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
                aVarArr2 = f10359e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
    }
}
