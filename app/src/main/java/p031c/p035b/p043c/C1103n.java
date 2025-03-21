package p031c.p035b.p043c;

import androidx.core.view.ViewCompat;
import p286h.C5230f1;

/* compiled from: PlanarYUVLuminanceSource.java */
/* renamed from: c.b.c.n */
/* loaded from: classes.dex */
public final class C1103n extends AbstractC1099j {

    /* renamed from: h */
    private static final int f2205h = 2;

    /* renamed from: c */
    private final byte[] f2206c;

    /* renamed from: d */
    private final int f2207d;

    /* renamed from: e */
    private final int f2208e;

    /* renamed from: f */
    private final int f2209f;

    /* renamed from: g */
    private final int f2210g;

    public C1103n(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f2206c = bArr;
        this.f2207d = i2;
        this.f2208e = i3;
        this.f2209f = i4;
        this.f2210g = i5;
        if (z) {
            m1906a(i6, i7);
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
        System.arraycopy(this.f2206c, ((i2 + this.f2210g) * this.f2207d) + this.f2209f, bArr, 0, m1902c);
        return bArr;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: b */
    public byte[] mo1895b() {
        int m1902c = m1902c();
        int m1901a = m1901a();
        if (m1902c == this.f2207d && m1901a == this.f2208e) {
            return this.f2206c;
        }
        int i2 = m1902c * m1901a;
        byte[] bArr = new byte[i2];
        int i3 = this.f2210g;
        int i4 = this.f2207d;
        int i5 = (i3 * i4) + this.f2209f;
        if (m1902c == i4) {
            System.arraycopy(this.f2206c, i5, bArr, 0, i2);
            return bArr;
        }
        byte[] bArr2 = this.f2206c;
        for (int i6 = 0; i6 < m1901a; i6++) {
            System.arraycopy(bArr2, i5, bArr, i6 * m1902c, m1902c);
            i5 += this.f2207d;
        }
        return bArr;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: e */
    public boolean mo1897e() {
        return true;
    }

    /* renamed from: i */
    public int m1907i() {
        return m1901a() / 2;
    }

    /* renamed from: j */
    public int m1908j() {
        return m1902c() / 2;
    }

    /* renamed from: k */
    public int[] m1909k() {
        int m1902c = m1902c() / 2;
        int m1901a = m1901a() / 2;
        int[] iArr = new int[m1902c * m1901a];
        byte[] bArr = this.f2206c;
        int i2 = (this.f2210g * this.f2207d) + this.f2209f;
        for (int i3 = 0; i3 < m1901a; i3++) {
            int i4 = i3 * m1902c;
            for (int i5 = 0; i5 < m1902c; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 * 2) + i2] & C5230f1.f20085c) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i2 += this.f2207d * 2;
        }
        return iArr;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: a */
    public AbstractC1099j mo1893a(int i2, int i3, int i4, int i5) {
        return new C1103n(this.f2206c, this.f2207d, this.f2208e, this.f2209f + i2, this.f2210g + i3, i4, i5, false);
    }

    /* renamed from: a */
    private void m1906a(int i2, int i3) {
        byte[] bArr = this.f2206c;
        int i4 = (this.f2210g * this.f2207d) + this.f2209f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b2 = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b2;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f2207d;
        }
    }
}
