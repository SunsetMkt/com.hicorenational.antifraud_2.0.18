package h.a.f1;

import h.a.k0;
import h.a.n0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends k0<T> implements n0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a[] f10375e = new a[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final a[] f10376f = new a[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    T f10378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f10379d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f10377b = new AtomicBoolean();
    final AtomicReference<a<T>[]> a = new AtomicReference<>(f10375e);

    /* JADX INFO: compiled from: SingleSubject.java */
    static final class a<T> extends AtomicReference<h<T>> implements h.a.u0.c {
        private static final long serialVersionUID = -7650903191002190468L;
        final n0<? super T> actual;

        a(n0<? super T> n0Var, h<T> hVar) {
            this.actual = n0Var;
            lazySet(hVar);
        }

        @Override // h.a.u0.c
        public void dispose() {
            h<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b((a) this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    h() {
    }

    @h.a.t0.f
    @h.a.t0.d
    public static <T> h<T> x() {
        return new h<>();
    }

    boolean a(@h.a.t0.f a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == f10376f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // h.a.k0
    protected void b(@h.a.t0.f n0<? super T> n0Var) {
        a<T> aVar = new a<>(n0Var, this);
        n0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
            }
        } else {
            Throwable th = this.f10379d;
            if (th != null) {
                n0Var.onError(th);
            } else {
                n0Var.onSuccess(this.f10378c);
            }
        }
    }

    @Override // h.a.n0
    public void onError(@h.a.t0.f Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f10377b.compareAndSet(false, true)) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10379d = th;
        for (a<T> aVar : this.a.getAndSet(f10376f)) {
            aVar.actual.onError(th);
        }
    }

    @Override // h.a.n0
    public void onSubscribe(@h.a.t0.f h.a.u0.c cVar) {
        if (this.a.get() == f10376f) {
            cVar.dispose();
        }
    }

    @Override // h.a.n0
    public void onSuccess(@h.a.t0.f T t) {
        if (t == null) {
            onError(new NullPointerException("Null values are not allowed in 2.x"));
            return;
        }
        if (this.f10377b.compareAndSet(false, true)) {
            this.f10378c = t;
            for (a<T> aVar : this.a.getAndSet(f10376f)) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    @h.a.t0.g
    public Throwable r() {
        if (this.a.get() == f10376f) {
            return this.f10379d;
        }
        return null;
    }

    @h.a.t0.g
    public T s() {
        if (this.a.get() == f10376f) {
            return this.f10378c;
        }
        return null;
    }

    public boolean t() {
        return this.a.get().length != 0;
    }

    public boolean u() {
        return this.a.get() == f10376f && this.f10379d != null;
    }

    public boolean v() {
        return this.a.get() == f10376f && this.f10378c != null;
    }

    int w() {
        return this.a.get().length;
    }

    void b(@h.a.t0.f a<T> aVar) {
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
                aVarArr2 = f10375e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
    }
}
