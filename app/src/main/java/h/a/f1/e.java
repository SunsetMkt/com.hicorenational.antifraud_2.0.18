package h.a.f1;

import h.a.i0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PublishSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends i<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final a[] f10364c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final a[] f10365d = new a[0];
    final AtomicReference<a<T>[]> a = new AtomicReference<>(f10365d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f10366b;

    /* JADX INFO: compiled from: PublishSubject.java */
    static final class a<T> extends AtomicBoolean implements h.a.u0.c {
        private static final long serialVersionUID = 3562861878281475070L;
        final i0<? super T> actual;
        final e<T> parent;

        a(i0<? super T> i0Var, e<T> eVar) {
            this.actual = i0Var;
            this.parent = eVar;
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

        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                h.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }
    }

    e() {
    }

    @h.a.t0.d
    public static <T> e<T> T() {
        return new e<>();
    }

    @Override // h.a.f1.i
    public Throwable O() {
        if (this.a.get() == f10364c) {
            return this.f10366b;
        }
        return null;
    }

    @Override // h.a.f1.i
    public boolean P() {
        return this.a.get() == f10364c && this.f10366b == null;
    }

    @Override // h.a.f1.i
    public boolean Q() {
        return this.a.get().length != 0;
    }

    @Override // h.a.f1.i
    public boolean R() {
        return this.a.get() == f10364c && this.f10366b != null;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == f10364c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == f10364c || aVarArr == f10365d) {
                return;
            }
            int length = aVarArr.length;
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
                aVarArr2 = f10365d;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // h.a.b0
    public void d(i0<? super T> i0Var) {
        a<T> aVar = new a<>(i0Var, this);
        i0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b((a) aVar);
            }
        } else {
            Throwable th = this.f10366b;
            if (th != null) {
                i0Var.onError(th);
            } else {
                i0Var.onComplete();
            }
        }
    }

    @Override // h.a.i0
    public void onComplete() {
        a<T>[] aVarArr = this.a.get();
        a<T>[] aVarArr2 = f10364c;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.a.getAndSet(aVarArr2)) {
            aVar.onComplete();
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (this.a.get() == f10364c) {
            h.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f10366b = th;
        for (a<T> aVar : this.a.getAndSet(f10364c)) {
            aVar.onError(th);
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.a.get() == f10364c) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (a<T> aVar : this.a.get()) {
            aVar.onNext(t);
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.a.get() == f10364c) {
            cVar.dispose();
        }
    }
}
