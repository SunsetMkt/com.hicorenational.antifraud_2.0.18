package d.b.c;

/* JADX INFO: compiled from: RGBLuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f9845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9849g;

    public o(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f9846d = i2;
        this.f9847e = i3;
        this.f9848f = 0;
        this.f9849g = 0;
        this.f9845c = new byte[i2 * i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * i2;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i5 + i6;
                int i8 = iArr[i7];
                int i9 = (i8 >> 16) & 255;
                int i10 = (i8 >> 8) & 255;
                int i11 = i8 & 255;
                if (i9 == i10 && i10 == i11) {
                    this.f9845c[i7] = (byte) i9;
                } else {
                    this.f9845c[i7] = (byte) (((i9 + (i10 * 2)) + i11) / 4);
                }
            }
        }
    }

    @Override // d.b.c.j
    public byte[] a(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        int iC = c();
        if (bArr == null || bArr.length < iC) {
            bArr = new byte[iC];
        }
        System.arraycopy(this.f9845c, ((i2 + this.f9849g) * this.f9846d) + this.f9848f, bArr, 0, iC);
        return bArr;
    }

    @Override // d.b.c.j
    public byte[] b() {
        int iC = c();
        int iA = a();
        if (iC == this.f9846d && iA == this.f9847e) {
            return this.f9845c;
        }
        int i2 = iC * iA;
        byte[] bArr = new byte[i2];
        int i3 = this.f9849g;
        int i4 = this.f9846d;
        int i5 = (i3 * i4) + this.f9848f;
        if (iC == i4) {
            System.arraycopy(this.f9845c, i5, bArr, 0, i2);
            return bArr;
        }
        byte[] bArr2 = this.f9845c;
        for (int i6 = 0; i6 < iA; i6++) {
            System.arraycopy(bArr2, i5, bArr, i6 * iC, iC);
            i5 += this.f9846d;
        }
        return bArr;
    }

    @Override // d.b.c.j
    public boolean e() {
        return true;
    }

    @Override // d.b.c.j
    public j a(int i2, int i3, int i4, int i5) {
        return new o(this.f9845c, this.f9846d, this.f9847e, this.f9848f + i2, this.f9849g + i3, i4, i5);
    }

    private o(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.f9845c = bArr;
            this.f9846d = i2;
            this.f9847e = i3;
            this.f9848f = i4;
            this.f9849g = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
