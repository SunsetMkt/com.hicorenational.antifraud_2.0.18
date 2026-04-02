package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends y0<byte[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f12231d;

    public o(int i2) {
        super(i2);
        this.f12231d = new byte[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d byte[] bArr) {
        i0.f(bArr, "$this$getSize");
        return bArr.length;
    }

    @j.c.a.d
    public final byte[] c() {
        return a(this.f12231d, new byte[b()]);
    }

    public final void a(byte b2) {
        byte[] bArr = this.f12231d;
        int iA = a();
        a(iA + 1);
        bArr[iA] = b2;
    }
}
