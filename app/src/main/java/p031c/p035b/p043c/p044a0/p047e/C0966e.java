package p031c.p035b.p043c.p044a0.p047e;

import java.util.Arrays;

/* compiled from: DefaultPlacement.java */
/* renamed from: c.b.c.a0.e.e */
/* loaded from: classes.dex */
public class C0966e {

    /* renamed from: a */
    private final CharSequence f1680a;

    /* renamed from: b */
    private final int f1681b;

    /* renamed from: c */
    private final int f1682c;

    /* renamed from: d */
    private final byte[] f1683d;

    public C0966e(CharSequence charSequence, int i2, int i3) {
        this.f1680a = charSequence;
        this.f1682c = i2;
        this.f1681b = i3;
        this.f1683d = new byte[i2 * i3];
        Arrays.fill(this.f1683d, (byte) -1);
    }

    /* renamed from: a */
    final byte[] m1259a() {
        return this.f1683d;
    }

    /* renamed from: b */
    final int m1260b() {
        return this.f1682c;
    }

    /* renamed from: c */
    final int m1262c() {
        return this.f1681b;
    }

    /* renamed from: d */
    public final void m1263d() {
        int i2;
        int i3;
        int i4 = 4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 == this.f1681b && i5 == 0) {
                m1251a(i6);
                i6++;
            }
            if (i4 == this.f1681b - 2 && i5 == 0 && this.f1682c % 4 != 0) {
                m1254b(i6);
                i6++;
            }
            if (i4 == this.f1681b - 2 && i5 == 0 && this.f1682c % 8 == 4) {
                m1255c(i6);
                i6++;
            }
            if (i4 == this.f1681b + 4 && i5 == 2 && this.f1682c % 8 == 0) {
                m1256d(i6);
                i6++;
            }
            do {
                if (i4 < this.f1681b && i5 >= 0 && !m1261b(i5, i4)) {
                    m1252a(i4, i5, i6);
                    i6++;
                }
                i4 -= 2;
                i5 += 2;
                if (i4 < 0) {
                    break;
                }
            } while (i5 < this.f1682c);
            int i7 = i4 + 1;
            int i8 = i5 + 3;
            do {
                if (i7 >= 0 && i8 < this.f1682c && !m1261b(i8, i7)) {
                    m1252a(i7, i8, i6);
                    i6++;
                }
                i7 += 2;
                i8 -= 2;
                if (i7 >= this.f1681b) {
                    break;
                }
            } while (i8 >= 0);
            i4 = i7 + 3;
            i5 = i8 + 1;
            i2 = this.f1681b;
            if (i4 >= i2 && i5 >= (i3 = this.f1682c)) {
                break;
            }
        }
        if (m1261b(i3 - 1, i2 - 1)) {
            return;
        }
        m1257a(this.f1682c - 1, this.f1681b - 1, true);
        m1257a(this.f1682c - 2, this.f1681b - 2, true);
    }

    /* renamed from: c */
    private void m1255c(int i2) {
        m1253a(this.f1681b - 3, 0, i2, 1);
        m1253a(this.f1681b - 2, 0, i2, 2);
        m1253a(this.f1681b - 1, 0, i2, 3);
        m1253a(0, this.f1682c - 2, i2, 4);
        m1253a(0, this.f1682c - 1, i2, 5);
        m1253a(1, this.f1682c - 1, i2, 6);
        m1253a(2, this.f1682c - 1, i2, 7);
        m1253a(3, this.f1682c - 1, i2, 8);
    }

    /* renamed from: a */
    public final boolean m1258a(int i2, int i3) {
        return this.f1683d[(i3 * this.f1682c) + i2] == 1;
    }

    /* renamed from: b */
    final boolean m1261b(int i2, int i3) {
        return this.f1683d[(i3 * this.f1682c) + i2] >= 0;
    }

    /* renamed from: b */
    private void m1254b(int i2) {
        m1253a(this.f1681b - 3, 0, i2, 1);
        m1253a(this.f1681b - 2, 0, i2, 2);
        m1253a(this.f1681b - 1, 0, i2, 3);
        m1253a(0, this.f1682c - 4, i2, 4);
        m1253a(0, this.f1682c - 3, i2, 5);
        m1253a(0, this.f1682c - 2, i2, 6);
        m1253a(0, this.f1682c - 1, i2, 7);
        m1253a(1, this.f1682c - 1, i2, 8);
    }

    /* renamed from: a */
    final void m1257a(int i2, int i3, boolean z) {
        this.f1683d[(i3 * this.f1682c) + i2] = z ? (byte) 1 : (byte) 0;
    }

    /* renamed from: a */
    private void m1253a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            int i6 = this.f1681b;
            i2 += i6;
            i3 += 4 - ((i6 + 4) % 8);
        }
        if (i3 < 0) {
            int i7 = this.f1682c;
            i3 += i7;
            i2 += 4 - ((i7 + 4) % 8);
        }
        m1257a(i3, i2, (this.f1680a.charAt(i4) & (1 << (8 - i5))) != 0);
    }

    /* renamed from: a */
    private void m1252a(int i2, int i3, int i4) {
        int i5 = i2 - 2;
        int i6 = i3 - 2;
        m1253a(i5, i6, i4, 1);
        int i7 = i3 - 1;
        m1253a(i5, i7, i4, 2);
        int i8 = i2 - 1;
        m1253a(i8, i6, i4, 3);
        m1253a(i8, i7, i4, 4);
        m1253a(i8, i3, i4, 5);
        m1253a(i2, i6, i4, 6);
        m1253a(i2, i7, i4, 7);
        m1253a(i2, i3, i4, 8);
    }

    /* renamed from: a */
    private void m1251a(int i2) {
        m1253a(this.f1681b - 1, 0, i2, 1);
        m1253a(this.f1681b - 1, 1, i2, 2);
        m1253a(this.f1681b - 1, 2, i2, 3);
        m1253a(0, this.f1682c - 2, i2, 4);
        m1253a(0, this.f1682c - 1, i2, 5);
        m1253a(1, this.f1682c - 1, i2, 6);
        m1253a(2, this.f1682c - 1, i2, 7);
        m1253a(3, this.f1682c - 1, i2, 8);
    }

    /* renamed from: d */
    private void m1256d(int i2) {
        m1253a(this.f1681b - 1, 0, i2, 1);
        m1253a(this.f1681b - 1, this.f1682c - 1, i2, 2);
        m1253a(0, this.f1682c - 3, i2, 3);
        m1253a(0, this.f1682c - 2, i2, 4);
        m1253a(0, this.f1682c - 1, i2, 5);
        m1253a(1, this.f1682c - 3, i2, 6);
        m1253a(1, this.f1682c - 2, i2, 7);
        m1253a(1, this.f1682c - 1, i2, 8);
    }
}
