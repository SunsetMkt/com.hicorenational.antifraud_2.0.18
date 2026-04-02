package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservablePublish.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b2<T> extends h.a.z0.a<T> implements h.a.y0.c.g<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<b<T>> f11243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.g0<T> f11244c;

    /* JADX INFO: compiled from: ObservablePublish.java */
    static final class a<T> extends AtomicReference<Object> implements h.a.u0.c {
        private static final long serialVersionUID = -1100270633763673112L;
        final h.a.i0<? super T> child;

        a(h.a.i0<? super T> i0Var) {
            this.child = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == this;
        }

        void setParent(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.b(this);
        }
    }

    /* JADX INFO: compiled from: ObservablePublish.java */
    static final class b<T> implements h.a.i0<T>, h.a.u0.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final a[] f11245e = new a[0];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final a[] f11246f = new a[0];
        final AtomicReference<b<T>> a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11249d = new AtomicReference<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference<a<T>[]> f11247b = new AtomicReference<>(f11245e);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicBoolean f11248c = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f11247b.get();
                if (aVarArr == f11246f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f11247b.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f11247b.get();
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
                    if (aVarArr[i3].equals(aVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f11245e;
                } else {
                    a<T>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f11247b.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // h.a.u0.c
        public void dispose() {
            a<T>[] aVarArr = this.f11247b.get();
            a<T>[] aVarArr2 = f11246f;
            if (aVarArr == aVarArr2 || this.f11247b.getAndSet(aVarArr2) == f11246f) {
                return;
            }
            this.a.compareAndSet(this, null);
            h.a.y0.a.d.dispose(this.f11249d);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11247b.get() == f11246f;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.compareAndSet(this, null);
            for (a<T> aVar : this.f11247b.getAndSet(f11246f)) {
                aVar.child.onComplete();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.compareAndSet(this, null);
            a<T>[] andSet = this.f11247b.getAndSet(f11246f);
            if (andSet.length == 0) {
                h.a.c1.a.b(th);
                return;
            }
            for (a<T> aVar : andSet) {
                aVar.child.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            for (a<T> aVar : this.f11247b.get()) {
                aVar.child.onNext(t);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.f11249d, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservablePublish.java */
    static final class c<T> implements h.a.g0<T> {
        private final AtomicReference<b<T>> a;

        c(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        @Override // h.a.g0
        public void subscribe(h.a.i0<? super T> i0Var) {
            a aVar = new a(i0Var);
            i0Var.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.a);
                    if (this.a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.setParent(bVar);
                    return;
                }
            }
        }
    }

    private b2(h.a.g0<T> g0Var, h.a.g0<T> g0Var2, AtomicReference<b<T>> atomicReference) {
        this.f11244c = g0Var;
        this.a = g0Var2;
        this.f11243b = atomicReference;
    }

    public static <T> h.a.z0.a<T> w(h.a.g0<T> g0Var) {
        AtomicReference atomicReference = new AtomicReference();
        return h.a.c1.a.a((h.a.z0.a) new b2(new c(atomicReference), g0Var, atomicReference));
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.f11244c.subscribe(i0Var);
    }

    @Override // h.a.z0.a
    public void k(h.a.x0.g<? super h.a.u0.c> gVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f11243b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f11243b);
            if (this.f11243b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = !bVar.f11248c.get() && bVar.f11248c.compareAndSet(false, true);
        try {
            gVar.accept(bVar);
            if (z) {
                this.a.subscribe(bVar);
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @Override // h.a.y0.c.g
    public h.a.g0<T> source() {
        return this.a;
    }
}
