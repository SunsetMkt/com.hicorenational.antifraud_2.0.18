package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends h.a.k0<T> implements h.a.n0<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final a[] f11819f = new a[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final a[] f11820g = new a[0];
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicInteger f11821b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<a<T>[]> f11822c = new AtomicReference<>(f11819f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    T f11823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Throwable f11824e;

    /* JADX INFO: compiled from: SingleCache.java */
    static final class a<T> extends AtomicBoolean implements h.a.u0.c {
        private static final long serialVersionUID = 7514387411091976596L;
        final h.a.n0<? super T> actual;
        final b<T> parent;

        a(h.a.n0<? super T> n0Var, b<T> bVar) {
            this.actual = n0Var;
            this.parent = bVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b((a) this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get();
        }
    }

    public b(h.a.q0<? extends T> q0Var) {
        this.a = q0Var;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f11822c.get();
            if (aVarArr == f11820g) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f11822c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        a<T> aVar = new a<>(n0Var, this);
        n0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
            }
            if (this.f11821b.getAndIncrement() == 0) {
                this.a.a(this);
                return;
            }
            return;
        }
        Throwable th = this.f11824e;
        if (th != null) {
            n0Var.onError(th);
        } else {
            n0Var.onSuccess(this.f11823d);
        }
    }

    @Override // h.a.n0
    public void onError(Throwable th) {
        this.f11824e = th;
        for (a<T> aVar : this.f11822c.getAndSet(f11820g)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // h.a.n0
    public void onSubscribe(h.a.u0.c cVar) {
    }

    @Override // h.a.n0
    public void onSuccess(T t) {
        this.f11823d = t;
        for (a<T> aVar : this.f11822c.getAndSet(f11820g)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f11822c.get();
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
                aVarArr2 = f11819f;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f11822c.compareAndSet(aVarArr, aVarArr2));
    }
}
