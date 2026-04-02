package h.a.y0.e.e;

import h.a.y0.e.b.w0;

/* JADX INFO: compiled from: ParallelFlatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T, R> extends h.a.b1.b<R> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f11771b;

    /* JADX INFO: renamed from: c */
    final boolean f11772c;

    /* JADX INFO: renamed from: d */
    final int f11773d;

    /* JADX INFO: renamed from: e */
    final int f11774e;

    public f(h.a.b1.b<T> bVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z, int i2, int i3) {
        this.a = bVar;
        this.f11771b = oVar;
        this.f11772c = z;
        this.f11773d = i2;
        this.f11774e = i3;
    }

    @Override // h.a.b1.b
    public int a() {
        return this.a.a();
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                cVarArr2[i2] = w0.a(cVarArr[i2], this.f11771b, this.f11772c, this.f11773d, this.f11774e);
            }
            this.a.a(cVarArr2);
        }
    }
}
