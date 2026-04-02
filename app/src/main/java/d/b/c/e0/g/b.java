package d.b.c.e0.g;

/* JADX INFO: compiled from: BarcodeRow.java */
/* JADX INFO: loaded from: classes.dex */
final class b {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9748b = 0;

    b(int i2) {
        this.a = new byte[i2];
    }

    void a(int i2, byte b2) {
        this.a[i2] = b2;
    }

    void a(int i2, boolean z) {
        this.a[i2] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f9748b;
            this.f9748b = i4 + 1;
            a(i4, z);
        }
    }

    byte[] a(int i2) {
        byte[] bArr = new byte[this.a.length * i2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = this.a[i3 / i2];
        }
        return bArr;
    }
}
