package h.a.y0.e.e;

/* JADX INFO: compiled from: ParallelFromArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends h.a.b1.b<T> {
    final j.d.b<T>[] a;

    public g(j.d.b<T>[] bVarArr) {
        this.a = bVarArr;
    }

    @Override // h.a.b1.b
    public int a() {
        return this.a.length;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.a[i2].subscribe(cVarArr[i2]);
            }
        }
    }
}
