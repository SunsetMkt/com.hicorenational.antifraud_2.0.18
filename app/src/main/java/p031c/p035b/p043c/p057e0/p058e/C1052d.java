package p031c.p035b.p043c.p057e0.p058e;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* compiled from: Codeword.java */
/* renamed from: c.b.c.e0.e.d */
/* loaded from: classes.dex */
final class C1052d {

    /* renamed from: f */
    private static final int f1994f = -1;

    /* renamed from: a */
    private final int f1995a;

    /* renamed from: b */
    private final int f1996b;

    /* renamed from: c */
    private final int f1997c;

    /* renamed from: d */
    private final int f1998d;

    /* renamed from: e */
    private int f1999e = -1;

    C1052d(int i2, int i3, int i4, int i5) {
        this.f1995a = i2;
        this.f1996b = i3;
        this.f1997c = i4;
        this.f1998d = i5;
    }

    /* renamed from: a */
    boolean m1577a(int i2) {
        return i2 != -1 && this.f1997c == (i2 % 3) * 3;
    }

    /* renamed from: b */
    int m1578b() {
        return this.f1996b;
    }

    /* renamed from: c */
    int m1580c() {
        return this.f1999e;
    }

    /* renamed from: d */
    int m1581d() {
        return this.f1995a;
    }

    /* renamed from: e */
    int m1582e() {
        return this.f1998d;
    }

    /* renamed from: f */
    int m1583f() {
        return this.f1996b - this.f1995a;
    }

    /* renamed from: g */
    boolean m1584g() {
        return m1577a(this.f1999e);
    }

    /* renamed from: h */
    void m1585h() {
        this.f1999e = ((this.f1998d / 30) * 3) + (this.f1997c / 3);
    }

    public String toString() {
        return this.f1999e + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f1998d;
    }

    /* renamed from: a */
    int m1576a() {
        return this.f1997c;
    }

    /* renamed from: b */
    void m1579b(int i2) {
        this.f1999e = i2;
    }
}
