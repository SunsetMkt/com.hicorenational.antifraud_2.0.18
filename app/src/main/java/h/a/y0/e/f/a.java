package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SingleAmb.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends h.a.k0<T> {
    private final h.a.q0<? extends T>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterable<? extends h.a.q0<? extends T>> f11818b;

    /* JADX INFO: renamed from: h.a.y0.e.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SingleAmb.java */
    static final class C0226a<T> extends AtomicBoolean implements h.a.n0<T> {
        private static final long serialVersionUID = -1944085461036028108L;
        final h.a.n0<? super T> s;
        final h.a.u0.b set;

        C0226a(h.a.n0<? super T> n0Var, h.a.u0.b bVar) {
            this.s = n0Var;
            this.set = bVar;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                h.a.c1.a.b(th);
            } else {
                this.set.dispose();
                this.s.onError(th);
            }
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.set.b(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(t);
            }
        }
    }

    public a(h.a.q0<? extends T>[] q0VarArr, Iterable<? extends h.a.q0<? extends T>> iterable) {
        this.a = q0VarArr;
        this.f11818b = iterable;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        int length;
        h.a.q0<? extends T>[] q0VarArr = this.a;
        if (q0VarArr == null) {
            q0VarArr = new h.a.q0[8];
            try {
                length = 0;
                for (h.a.q0<? extends T> q0Var : this.f11818b) {
                    if (q0Var == null) {
                        h.a.y0.a.e.error(new NullPointerException("One of the sources is null"), n0Var);
                        return;
                    }
                    if (length == q0VarArr.length) {
                        h.a.q0<? extends T>[] q0VarArr2 = new h.a.q0[(length >> 2) + length];
                        System.arraycopy(q0VarArr, 0, q0VarArr2, 0, length);
                        q0VarArr = q0VarArr2;
                    }
                    int i2 = length + 1;
                    q0VarArr[length] = q0Var;
                    length = i2;
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, n0Var);
                return;
            }
        } else {
            length = q0VarArr.length;
        }
        h.a.u0.b bVar = new h.a.u0.b();
        C0226a c0226a = new C0226a(n0Var, bVar);
        n0Var.onSubscribe(bVar);
        for (int i3 = 0; i3 < length; i3++) {
            h.a.q0<? extends T> q0Var2 = q0VarArr[i3];
            if (c0226a.get()) {
                return;
            }
            if (q0Var2 == null) {
                bVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (c0226a.compareAndSet(false, true)) {
                    n0Var.onError(nullPointerException);
                    return;
                } else {
                    h.a.c1.a.b(nullPointerException);
                    return;
                }
            }
            q0Var2.a(c0226a);
        }
    }
}
