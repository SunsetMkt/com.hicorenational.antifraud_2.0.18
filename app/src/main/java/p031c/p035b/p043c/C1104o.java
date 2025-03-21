package p031c.p035b.p043c;

/* compiled from: RGBLuminanceSource.java */
/* renamed from: c.b.c.o */
/* loaded from: classes.dex */
public final class C1104o extends AbstractC1099j {

    /* renamed from: c */
    private final byte[] f2211c;

    /* renamed from: d */
    private final int f2212d;

    /* renamed from: e */
    private final int f2213e;

    /* renamed from: f */
    private final int f2214f;

    /* renamed from: g */
    private final int f2215g;

    public C1104o(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f2212d = i2;
        this.f2213e = i3;
        this.f2214f = 0;
        this.f2215g = 0;
        this.f2211c = new byte[i2 * i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * i2;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i5 + i6;
                int i8 = iArr[i7];
                int i9 = (i8 >> 16) & 255;
                int i10 = (i8 >> 8) & 255;
                int i11 = i8 & 255;
                if (i9 == i10 && i10 == i11) {
                    this.f2211c[i7] = (byte) i9;
                } else {
                    this.f2211c[i7] = (byte) (((i9 + (i10 * 2)) + i11) / 4);
                }
            }
        }
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: a */
    public byte[] mo1894a(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= m1901a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        int m1902c = m1902c();
        if (bArr == null || bArr.length < m1902c) {
            bArr = new byte[m1902c];
        }
        System.arraycopy(this.f2211c, ((i2 + this.f2215g) * this.f2212d) + this.f2214f, bArr, 0, m1902c);
        return bArr;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: b */
    public byte[] mo1895b() {
        int m1902c = m1902c();
        int m1901a = m1901a();
        if (m1902c == this.f2212d && m1901a == this.f2213e) {
            return this.f2211c;
        }
        int i2 = m1902c * m1901a;
        byte[] bArr = new byte[i2];
        int i3 = this.f2215g;
        int i4 = this.f2212d;
        int i5 = (i3 * i4) + this.f2214f;
        if (m1902c == i4) {
            System.arraycopy(this.f2211c, i5, bArr, 0, i2);
            return bArr;
        }
        byte[] bArr2 = this.f2211c;
        for (int i6 = 0; i6 < m1901a; i6++) {
            System.arraycopy(bArr2, i5, bArr, i6 * m1902c, m1902c);
            i5 += this.f2212d;
        }
        return bArr;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: e */
    public boolean mo1897e() {
        return true;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: a */
    public AbstractC1099j mo1893a(int i2, int i3, int i4, int i5) {
        return new C1104o(this.f2211c, this.f2212d, this.f2213e, this.f2214f + i2, this.f2215g + i3, i4, i5);
    }

    private C1104o(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.f2211c = bArr;
            this.f2212d = i2;
            this.f2213e = i3;
            this.f2214f = i4;
            this.f2215g = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
