package p031c.p035b.p043c.p057e0.p061g;

/* compiled from: BarcodeRow.java */
/* renamed from: c.b.c.e0.g.b */
/* loaded from: classes.dex */
final class C1065b {

    /* renamed from: a */
    private final byte[] f2066a;

    /* renamed from: b */
    private int f2067b = 0;

    C1065b(int i2) {
        this.f2066a = new byte[i2];
    }

    /* renamed from: a */
    void m1692a(int i2, byte b2) {
        this.f2066a[i2] = b2;
    }

    /* renamed from: a */
    void m1693a(int i2, boolean z) {
        this.f2066a[i2] = z ? (byte) 1 : (byte) 0;
    }

    /* renamed from: a */
    void m1694a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f2067b;
            this.f2067b = i4 + 1;
            m1693a(i4, z);
        }
    }

    /* renamed from: a */
    byte[] m1695a(int i2) {
        byte[] bArr = new byte[this.f2066a.length * i2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = this.f2066a[i3 / i2];
        }
        return bArr;
    }
}
