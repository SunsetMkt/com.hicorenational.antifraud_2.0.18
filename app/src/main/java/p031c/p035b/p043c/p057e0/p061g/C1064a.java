package p031c.p035b.p043c.p057e0.p061g;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix.java */
/* renamed from: c.b.c.e0.g.a */
/* loaded from: classes.dex */
public final class C1064a {

    /* renamed from: a */
    private final C1065b[] f2062a;

    /* renamed from: b */
    private int f2063b;

    /* renamed from: c */
    private final int f2064c;

    /* renamed from: d */
    private final int f2065d;

    C1064a(int i2, int i3) {
        this.f2062a = new C1065b[i2];
        int length = this.f2062a.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f2062a[i4] = new C1065b(((i3 + 4) * 17) + 1);
        }
        this.f2065d = i3 * 17;
        this.f2064c = i2;
        this.f2063b = -1;
    }

    /* renamed from: a */
    void m1688a(int i2, int i3, byte b2) {
        this.f2062a[i3].m1692a(i2, b2);
    }

    /* renamed from: b */
    public byte[][] m1690b() {
        return m1689a(1, 1);
    }

    /* renamed from: c */
    void m1691c() {
        this.f2063b++;
    }

    /* renamed from: a */
    C1065b m1687a() {
        return this.f2062a[this.f2063b];
    }

    /* renamed from: a */
    public byte[][] m1689a(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f2064c * i3, this.f2065d * i2);
        int i4 = this.f2064c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.f2062a[i5 / i3].m1695a(i2);
        }
        return bArr;
    }
}
