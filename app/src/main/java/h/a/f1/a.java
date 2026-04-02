package h.a.f1;

import h.a.i0;
import h.a.y0.d.l;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AsyncSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends i<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final C0176a[] f10335d = new C0176a[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final C0176a[] f10336e = new C0176a[0];
    final AtomicReference<C0176a<T>[]> a = new AtomicReference<>(f10335d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f10337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    T f10338c;

    /* JADX INFO: renamed from: h.a.f1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncSubject.java */
    static final class C0176a<T> extends l<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final a<T> parent;

        C0176a(i0<? super T> i0Var, a<T> aVar) {
            super(i0Var);
            this.parent = aVar;
        }

        @Override // h.a.y0.d.l, h.a.u0.c
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.b((C0176a) this);
            }
        }

        void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                h.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    a() {
    }

    @h.a.t0.d
    public static <T> a<T> X() {
        return new a<>();
    }

    @Override // h.a.f1.i
    public Throwable O() {
        if (this.a.get() == f10336e) {
            return this.f10337b;
        }
        return null;
    }

    @Override // h.a.f1.i
    public boolean P() {
        return this.a.get() == f10336e && this.f10337b == null;
    }

    @Override // h.a.f1.i
    public boolean Q() {
        return this.a.get().length != 0;
    }

    @Override // h.a.f1.i
    public boolean R() {
        return this.a.get() == f10336e && this.f10337b != null;
    }

    public T T() {
        if (this.a.get() == f10336e) {
            return this.f10338c;
        }
        return null;
    }

    public Object[] U() {
        T T = T();
        return T != null ? new Object[]{T} : new Object[0];
    }

    public boolean V() {
        return this.a.get() == f10336e && this.f10338c != null;
    }

    void W() {
        this.f10338c = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f10337b = nullPointerException;
        for (C0176a<T> c0176a : this.a.getAndSet(f10336e)) {
            c0176a.onError(nullPointerException);
        }
    }

    boolean a(C0176a<T> c0176a) {
        C0176a<T>[] c0176aArr;
        C0176a<T>[] c0176aArr2;
        do {
            c0176aArr = this.a.get();
            if (c0176aArr == f10336e) {
                return false;
            }
            int length = c0176aArr.length;
            c0176aArr2 = new C0176a[length + 1];
            System.arraycopy(c0176aArr, 0, c0176aArr2, 0, length);
            c0176aArr2[length] = c0176a;
        } while (!this.a.compareAndSet(c0176aArr, c0176aArr2));
        return true;
    }

    void b(C0176a<T> c0176a) {
        C0176a<T>[] c0176aArr;
        C0176a<T>[] c0176aArr2;
        do {
            c0176aArr = this.a.get();
            int length = c0176aArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (c0176aArr[i3] == c0176a) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                c0176aArr2 = f10335d;
            } else {
                C0176a<T>[] c0176aArr3 = new C0176a[length - 1];
                System.arraycopy(c0176aArr, 0, c0176aArr3, 0, i2);
                System.arraycopy(c0176aArr, i2 + 1, c0176aArr3, i2, (length - i2) - 1);
                c0176aArr2 = c0176aArr3;
            }
        } while (!this.a.compareAndSet(c0176aArr, c0176aArr2));
    }

    public T[] c(T[] tArr) {
        T T = T();
        if (T == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = T;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // h.a.b0
    protected void d(i0<? super T> i0Var) {
        C0176a<T> c0176a = new C0176a<>(i0Var, this);
        i0Var.onSubscribe(c0176a);
        if (a((C0176a) c0176a)) {
            if (c0176a.isDisposed()) {
                b((C0176a) c0176a);
                return;
            }
            return;
        }
        Throwable th = this.f10337b;
        if (th != null) {
            i0Var.onError(th);
            return;
        }
        T t = this.f10338c;
        if (t != null) {
            c0176a.complete(t);
        } else {
            c0176a.onComplete();
        }
    }

    @Override // h.a.i0
    public void onComplete() {
        C0176a<T>[] c0176aArr = this.a.get();
        C0176a<T>[] c0176aArr2 = f10336e;
        if (c0176aArr == c0176aArr2) {
            return;
        }
        T t = this.f10338c;
        C0176a<T>[] andSet = this.a.getAndSet(c0176aArr2);
        int i2 = 0;
        if (t == null) {
            int length = andSet.length;
            while (i2 < length) {
                andSet[i2].onComplete();
                i2++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i2 < length2) {
            andSet[i2].complete(t);
            i2++;
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        C0176a<T>[] c0176aArr = this.a.get();
        C0176a<T>[] c0176aArr2 = f10336e;
        if (c0176aArr == c0176aArr2) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10338c = null;
        this.f10337b = th;
        for (C0176a<T> c0176a : this.a.getAndSet(c0176aArr2)) {
            c0176a.onError(th);
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.a.get() == f10336e) {
            return;
        }
        if (t == null) {
            W();
        } else {
            this.f10338c = t;
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.a.get() == f10336e) {
            cVar.dispose();
        }
    }
}
