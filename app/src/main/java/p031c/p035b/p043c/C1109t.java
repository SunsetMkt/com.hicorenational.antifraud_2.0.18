package p031c.p035b.p043c;

import p031c.p035b.p043c.p072z.p073m.C1174a;

/* compiled from: ResultPoint.java */
/* renamed from: c.b.c.t */
/* loaded from: classes.dex */
public class C1109t {

    /* renamed from: a */
    private final float f2223a;

    /* renamed from: b */
    private final float f2224b;

    public C1109t(float f2, float f3) {
        this.f2223a = f2;
        this.f2224b = f3;
    }

    /* renamed from: a */
    public final float m1922a() {
        return this.f2223a;
    }

    /* renamed from: b */
    public final float m1923b() {
        return this.f2224b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1109t)) {
            return false;
        }
        C1109t c1109t = (C1109t) obj;
        return this.f2223a == c1109t.f2223a && this.f2224b == c1109t.f2224b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2223a) * 31) + Float.floatToIntBits(this.f2224b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f2223a);
        sb.append(',');
        sb.append(this.f2224b);
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: a */
    public static void m1921a(C1109t[] c1109tArr) {
        C1109t c1109t;
        C1109t c1109t2;
        C1109t c1109t3;
        float m1919a = m1919a(c1109tArr[0], c1109tArr[1]);
        float m1919a2 = m1919a(c1109tArr[1], c1109tArr[2]);
        float m1919a3 = m1919a(c1109tArr[0], c1109tArr[2]);
        if (m1919a2 >= m1919a && m1919a2 >= m1919a3) {
            c1109t = c1109tArr[0];
            c1109t2 = c1109tArr[1];
            c1109t3 = c1109tArr[2];
        } else if (m1919a3 < m1919a2 || m1919a3 < m1919a) {
            c1109t = c1109tArr[2];
            c1109t2 = c1109tArr[0];
            c1109t3 = c1109tArr[1];
        } else {
            c1109t = c1109tArr[1];
            c1109t2 = c1109tArr[0];
            c1109t3 = c1109tArr[2];
        }
        if (m1920a(c1109t2, c1109t, c1109t3) < 0.0f) {
            C1109t c1109t4 = c1109t3;
            c1109t3 = c1109t2;
            c1109t2 = c1109t4;
        }
        c1109tArr[0] = c1109t2;
        c1109tArr[1] = c1109t;
        c1109tArr[2] = c1109t3;
    }

    /* renamed from: a */
    public static float m1919a(C1109t c1109t, C1109t c1109t2) {
        return C1174a.m2221a(c1109t.f2223a, c1109t.f2224b, c1109t2.f2223a, c1109t2.f2224b);
    }

    /* renamed from: a */
    private static float m1920a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3) {
        float f2 = c1109t2.f2223a;
        float f3 = c1109t2.f2224b;
        return ((c1109t3.f2223a - f2) * (c1109t.f2224b - f3)) - ((c1109t3.f2224b - f3) * (c1109t.f2223a - f2));
    }
}
