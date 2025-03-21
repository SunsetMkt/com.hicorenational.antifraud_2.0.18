package p031c.p035b.p043c.p062f0.p064d;

import java.util.Map;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p062f0.p063c.C1083j;
import p031c.p035b.p043c.p072z.AbstractC1170i;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1168g;
import p031c.p035b.p043c.p072z.C1172k;
import p031c.p035b.p043c.p072z.p073m.C1174a;

/* compiled from: Detector.java */
/* renamed from: c.b.c.f0.d.c */
/* loaded from: classes.dex */
public class C1086c {

    /* renamed from: a */
    private final C1163b f2156a;

    /* renamed from: b */
    private InterfaceC1110u f2157b;

    public C1086c(C1163b c1163b) {
        this.f2156a = c1163b;
    }

    /* renamed from: a */
    public C1168g m1799a() throws C1102m, C1097h {
        return m1801a((Map<EnumC1044e, ?>) null);
    }

    /* renamed from: b */
    protected final C1163b m1802b() {
        return this.f2156a;
    }

    /* renamed from: c */
    protected final InterfaceC1110u m1803c() {
        return this.f2157b;
    }

    /* renamed from: b */
    private float m1796b(int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        float f3;
        float m1791a = m1791a(i2, i3, i4, i5);
        int i7 = i2 - (i4 - i2);
        int i8 = 0;
        if (i7 < 0) {
            f2 = i2 / (i2 - i7);
            i6 = 0;
        } else if (i7 >= this.f2156a.m2181g()) {
            f2 = ((this.f2156a.m2181g() - 1) - i2) / (i7 - i2);
            i6 = this.f2156a.m2181g() - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        float f4 = i3;
        int i9 = (int) (f4 - ((i5 - i3) * f2));
        if (i9 < 0) {
            f3 = f4 / (i3 - i9);
        } else if (i9 >= this.f2156a.m2177d()) {
            f3 = ((this.f2156a.m2177d() - 1) - i3) / (i9 - i3);
            i8 = this.f2156a.m2177d() - 1;
        } else {
            i8 = i9;
            f3 = 1.0f;
        }
        return (m1791a + m1791a(i2, i3, (int) (i2 + ((i6 - i2) * f3)), i8)) - 1.0f;
    }

    /* renamed from: a */
    public final C1168g m1801a(Map<EnumC1044e, ?> map) throws C1102m, C1097h {
        this.f2157b = map == null ? null : (InterfaceC1110u) map.get(EnumC1044e.NEED_RESULT_POINT_CALLBACK);
        return m1800a(new C1088e(this.f2156a, this.f2157b).m1817a(map));
    }

    /* renamed from: a */
    protected final C1168g m1800a(C1089f c1089f) throws C1102m, C1097h {
        C1087d m1822b = c1089f.m1822b();
        C1087d m1823c = c1089f.m1823c();
        C1087d m1821a = c1089f.m1821a();
        float m1797a = m1797a(m1822b, m1823c, m1821a);
        if (m1797a >= 1.0f) {
            int m1793a = m1793a(m1822b, m1823c, m1821a, m1797a);
            C1083j m1769b = C1083j.m1769b(m1793a);
            int m1775c = m1769b.m1775c() - 7;
            C1084a c1084a = null;
            if (m1769b.m1774b().length > 0) {
                float m1922a = (m1823c.m1922a() - m1822b.m1922a()) + m1821a.m1922a();
                float m1923b = (m1823c.m1923b() - m1822b.m1923b()) + m1821a.m1923b();
                float f2 = 1.0f - (3.0f / m1775c);
                int m1922a2 = (int) (m1822b.m1922a() + ((m1922a - m1822b.m1922a()) * f2));
                int m1923b2 = (int) (m1822b.m1923b() + (f2 * (m1923b - m1822b.m1923b())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        c1084a = m1798a(m1797a, m1922a2, m1923b2, i2);
                        break;
                    } catch (C1102m unused) {
                    }
                }
            }
            return new C1168g(m1794a(this.f2156a, m1795a(m1822b, m1823c, m1821a, c1084a, m1793a), m1793a), c1084a == null ? new C1109t[]{m1821a, m1822b, m1823c} : new C1109t[]{m1821a, m1822b, m1823c, c1084a});
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static C1172k m1795a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4, int i2) {
        float m1922a;
        float m1923b;
        float f2;
        float f3 = i2 - 3.5f;
        if (c1109t4 != null) {
            m1922a = c1109t4.m1922a();
            m1923b = c1109t4.m1923b();
            f2 = f3 - 3.0f;
        } else {
            m1922a = (c1109t2.m1922a() - c1109t.m1922a()) + c1109t3.m1922a();
            m1923b = (c1109t2.m1923b() - c1109t.m1923b()) + c1109t3.m1923b();
            f2 = f3;
        }
        return C1172k.m2214a(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, c1109t.m1922a(), c1109t.m1923b(), c1109t2.m1922a(), c1109t2.m1923b(), m1922a, m1923b, c1109t3.m1922a(), c1109t3.m1923b());
    }

    /* renamed from: a */
    private static C1163b m1794a(C1163b c1163b, C1172k c1172k, int i2) throws C1102m {
        return AbstractC1170i.m2206a().mo2201a(c1163b, i2, i2, c1172k);
    }

    /* renamed from: a */
    private static int m1793a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3, float f2) throws C1102m {
        int m2223a = ((C1174a.m2223a(C1109t.m1919a(c1109t, c1109t2) / f2) + C1174a.m2223a(C1109t.m1919a(c1109t, c1109t3) / f2)) / 2) + 7;
        int i2 = m2223a & 3;
        if (i2 == 0) {
            return m2223a + 1;
        }
        if (i2 == 2) {
            return m2223a - 1;
        }
        if (i2 != 3) {
            return m2223a;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    protected final float m1797a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3) {
        return (m1792a(c1109t, c1109t2) + m1792a(c1109t, c1109t3)) / 2.0f;
    }

    /* renamed from: a */
    private float m1792a(C1109t c1109t, C1109t c1109t2) {
        float m1796b = m1796b((int) c1109t.m1922a(), (int) c1109t.m1923b(), (int) c1109t2.m1922a(), (int) c1109t2.m1923b());
        float m1796b2 = m1796b((int) c1109t2.m1922a(), (int) c1109t2.m1923b(), (int) c1109t.m1922a(), (int) c1109t.m1923b());
        return Float.isNaN(m1796b) ? m1796b2 / 7.0f : Float.isNaN(m1796b2) ? m1796b / 7.0f : (m1796b + m1796b2) / 14.0f;
    }

    /* renamed from: a */
    private float m1791a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        C1086c c1086c;
        boolean z;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i12 = (-abs) / 2;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 < i9 ? 1 : -1;
        int i15 = i8 + i13;
        int i16 = i7;
        int i17 = i12;
        int i18 = 0;
        int i19 = i6;
        while (true) {
            if (i19 == i15) {
                i10 = i15;
                break;
            }
            int i20 = z3 ? i16 : i19;
            int i21 = z3 ? i19 : i16;
            if (i18 == i11) {
                c1086c = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                c1086c = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == c1086c.f2156a.m2173b(i20, i21)) {
                if (i18 == 2) {
                    return C1174a.m2222a(i19, i16, i6, i7);
                }
                i18++;
            }
            i17 += abs2;
            if (i17 > 0) {
                if (i16 == i9) {
                    break;
                }
                i16 += i14;
                i17 -= abs;
            }
            i19 += i13;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return C1174a.m2222a(i10, i9, i6, i7);
        }
        return Float.NaN;
    }

    /* renamed from: a */
    protected final C1084a m1798a(float f2, int i2, int i3, float f3) throws C1102m {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.f2156a.m2181g() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min >= f4) {
            int max2 = Math.max(0, i3 - i4);
            int min2 = Math.min(this.f2156a.m2177d() - 1, i3 + i4) - max2;
            if (min2 >= f4) {
                return new C1085b(this.f2156a, max, max2, min, min2, f2, this.f2157b).m1790a();
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }
}
