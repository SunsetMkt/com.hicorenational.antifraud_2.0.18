package i;

/* JADX INFO: compiled from: UByteArray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h1 {
    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final byte[] a(int i2, i.q2.s.l<? super Integer, f1> lVar) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = lVar.invoke(Integer.valueOf(i3)).a();
        }
        return g1.b(bArr);
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final byte[] a(byte... bArr) {
        return bArr;
    }
}
