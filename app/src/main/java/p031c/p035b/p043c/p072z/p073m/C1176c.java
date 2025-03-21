package p031c.p035b.p043c.p072z.p073m;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: WhiteRectangleDetector.java */
/* renamed from: c.b.c.z.m.c */
/* loaded from: classes.dex */
public final class C1176c {

    /* renamed from: h */
    private static final int f2440h = 10;

    /* renamed from: i */
    private static final int f2441i = 1;

    /* renamed from: a */
    private final C1163b f2442a;

    /* renamed from: b */
    private final int f2443b;

    /* renamed from: c */
    private final int f2444c;

    /* renamed from: d */
    private final int f2445d;

    /* renamed from: e */
    private final int f2446e;

    /* renamed from: f */
    private final int f2447f;

    /* renamed from: g */
    private final int f2448g;

    public C1176c(C1163b c1163b) throws C1102m {
        this(c1163b, 10, c1163b.m2181g() / 2, c1163b.m2177d() / 2);
    }

    /* renamed from: a */
    public C1109t[] m2230a() throws C1102m {
        boolean z;
        int i2 = this.f2445d;
        int i3 = this.f2446e;
        int i4 = this.f2448g;
        int i5 = this.f2447f;
        boolean z2 = false;
        int i6 = i2;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (boolean z8 = true; z8; z8 = z) {
            boolean z9 = true;
            z = false;
            while (true) {
                if ((z9 || !z3) && i3 < this.f2444c) {
                    z9 = m2228a(i4, i5, i3, false);
                    if (z9) {
                        i3++;
                        z3 = true;
                        z = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 < this.f2444c) {
                boolean z10 = true;
                while (true) {
                    if ((z10 || !z4) && i5 < this.f2443b) {
                        z10 = m2228a(i6, i3, i5, true);
                        if (z10) {
                            i5++;
                            z4 = true;
                            z = true;
                        } else if (!z4) {
                            i5++;
                        }
                    }
                }
                if (i5 < this.f2443b) {
                    boolean z11 = true;
                    while (true) {
                        if ((z11 || !z5) && i6 >= 0) {
                            z11 = m2228a(i4, i5, i6, false);
                            if (z11) {
                                i6--;
                                z5 = true;
                                z = true;
                            } else if (!z5) {
                                i6--;
                            }
                        }
                    }
                    if (i6 >= 0) {
                        boolean z12 = true;
                        while (true) {
                            if ((z12 || !z7) && i4 >= 0) {
                                z12 = m2228a(i6, i3, i4, true);
                                if (z12) {
                                    i4--;
                                    z7 = true;
                                    z = true;
                                } else if (!z7) {
                                    i4--;
                                }
                            }
                        }
                        if (i4 >= 0) {
                            if (z) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2 || !z6) {
            throw C1102m.getNotFoundInstance();
        }
        int i7 = i3 - i6;
        C1109t c1109t = null;
        C1109t c1109t2 = null;
        for (int i8 = 1; i8 < i7; i8++) {
            c1109t2 = m2227a(i6, i5 - i8, i6 + i8, i5);
            if (c1109t2 != null) {
                break;
            }
        }
        if (c1109t2 == null) {
            throw C1102m.getNotFoundInstance();
        }
        C1109t c1109t3 = null;
        for (int i9 = 1; i9 < i7; i9++) {
            c1109t3 = m2227a(i6, i4 + i9, i6 + i9, i4);
            if (c1109t3 != null) {
                break;
            }
        }
        if (c1109t3 == null) {
            throw C1102m.getNotFoundInstance();
        }
        C1109t c1109t4 = null;
        for (int i10 = 1; i10 < i7; i10++) {
            c1109t4 = m2227a(i3, i4 + i10, i3 - i10, i4);
            if (c1109t4 != null) {
                break;
            }
        }
        if (c1109t4 == null) {
            throw C1102m.getNotFoundInstance();
        }
        for (int i11 = 1; i11 < i7; i11++) {
            c1109t = m2227a(i3, i5 - i11, i3 - i11, i5);
            if (c1109t != null) {
                break;
            }
        }
        if (c1109t != null) {
            return m2229a(c1109t, c1109t2, c1109t4, c1109t3);
        }
        throw C1102m.getNotFoundInstance();
    }

    public C1176c(C1163b c1163b, int i2, int i3, int i4) throws C1102m {
        this.f2442a = c1163b;
        this.f2443b = c1163b.m2177d();
        this.f2444c = c1163b.m2181g();
        int i5 = i2 / 2;
        this.f2445d = i3 - i5;
        this.f2446e = i3 + i5;
        this.f2448g = i4 - i5;
        this.f2447f = i4 + i5;
        if (this.f2448g < 0 || this.f2445d < 0 || this.f2447f >= this.f2443b || this.f2446e >= this.f2444c) {
            throw C1102m.getNotFoundInstance();
        }
    }

    /* renamed from: a */
    private C1109t m2227a(float f2, float f3, float f4, float f5) {
        int m2223a = C1174a.m2223a(C1174a.m2221a(f2, f3, f4, f5));
        float f6 = m2223a;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < m2223a; i2++) {
            float f9 = i2;
            int m2223a2 = C1174a.m2223a((f9 * f7) + f2);
            int m2223a3 = C1174a.m2223a((f9 * f8) + f3);
            if (this.f2442a.m2173b(m2223a2, m2223a3)) {
                return new C1109t(m2223a2, m2223a3);
            }
        }
        return null;
    }

    /* renamed from: a */
    private C1109t[] m2229a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4) {
        float m1922a = c1109t.m1922a();
        float m1923b = c1109t.m1923b();
        float m1922a2 = c1109t2.m1922a();
        float m1923b2 = c1109t2.m1923b();
        float m1922a3 = c1109t3.m1922a();
        float m1923b3 = c1109t3.m1923b();
        float m1922a4 = c1109t4.m1922a();
        float m1923b4 = c1109t4.m1923b();
        return m1922a < ((float) this.f2444c) / 2.0f ? new C1109t[]{new C1109t(m1922a4 - 1.0f, m1923b4 + 1.0f), new C1109t(m1922a2 + 1.0f, m1923b2 + 1.0f), new C1109t(m1922a3 - 1.0f, m1923b3 - 1.0f), new C1109t(m1922a + 1.0f, m1923b - 1.0f)} : new C1109t[]{new C1109t(m1922a4 + 1.0f, m1923b4 + 1.0f), new C1109t(m1922a2 + 1.0f, m1923b2 - 1.0f), new C1109t(m1922a3 - 1.0f, m1923b3 + 1.0f), new C1109t(m1922a - 1.0f, m1923b - 1.0f)};
    }

    /* renamed from: a */
    private boolean m2228a(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.f2442a.m2173b(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.f2442a.m2173b(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }
}
