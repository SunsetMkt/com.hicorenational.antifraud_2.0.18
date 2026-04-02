package h.a.y0.e.f;

import h.a.y0.e.f.h0;
import h.a.y0.e.f.u0;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SingleZipIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v0<T, R> extends h.a.k0<R> {
    final Iterable<? extends h.a.q0<? extends T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11897b;

    /* JADX INFO: compiled from: SingleZipIterable.java */
    final class a implements h.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return (R) h.a.y0.b.b.a(v0.this.f11897b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public v0(Iterable<? extends h.a.q0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        this.a = iterable;
        this.f11897b = oVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        h.a.q0[] q0VarArr = new h.a.q0[8];
        try {
            h.a.q0[] q0VarArr2 = q0VarArr;
            int i2 = 0;
            for (h.a.q0<? extends T> q0Var : this.a) {
                if (q0Var == null) {
                    h.a.y0.a.e.error(new NullPointerException("One of the sources is null"), n0Var);
                    return;
                }
                if (i2 == q0VarArr2.length) {
                    q0VarArr2 = (h.a.q0[]) Arrays.copyOf(q0VarArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                q0VarArr2[i2] = q0Var;
                i2 = i3;
            }
            if (i2 == 0) {
                h.a.y0.a.e.error(new NoSuchElementException(), n0Var);
                return;
            }
            if (i2 == 1) {
                q0VarArr2[0].a(new h0.a(n0Var, new a()));
                return;
            }
            u0.b bVar = new u0.b(n0Var, i2, this.f11897b);
            n0Var.onSubscribe(bVar);
            for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                q0VarArr2[i4].a(bVar.observers[i4]);
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }
}
