package i;

/* JADX INFO: compiled from: ULongArray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p1 {
    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final long[] a(int i2, i.q2.s.l<? super Integer, n1> lVar) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = lVar.invoke(Integer.valueOf(i3)).a();
        }
        return o1.b(jArr);
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final long[] a(long... jArr) {
        return jArr;
    }
}
