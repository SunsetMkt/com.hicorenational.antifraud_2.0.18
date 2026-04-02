package h.a.y0.e.e;

import h.a.y0.e.b.w;

/* JADX INFO: compiled from: ParallelConcatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T, R> extends h.a.b1.b<R> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f11746b;

    /* JADX INFO: renamed from: c */
    final int f11747c;

    /* JADX INFO: renamed from: d */
    final h.a.y0.j.j f11748d;

    public b(h.a.b1.b<T> bVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, h.a.y0.j.j jVar) {
        this.a = bVar;
        this.f11746b = (h.a.x0.o) h.a.y0.b.b.a(oVar, "mapper");
        this.f11747c = i2;
        this.f11748d = (h.a.y0.j.j) h.a.y0.b.b.a(jVar, "errorMode");
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
                cVarArr2[i2] = w.a(cVarArr[i2], this.f11746b, this.f11747c, this.f11748d);
            }
            this.a.a(cVarArr2);
        }
    }
}
