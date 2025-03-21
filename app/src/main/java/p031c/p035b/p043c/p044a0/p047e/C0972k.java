package p031c.p035b.p043c.p044a0.p047e;

import com.hicorenational.antifraud.C2114a;
import com.umeng.socialize.bean.HandlerRequestCode;
import p031c.p035b.p043c.C1071f;

/* compiled from: SymbolInfo.java */
/* renamed from: c.b.c.a0.e.k */
/* loaded from: classes.dex */
public class C0972k {

    /* renamed from: i */
    static final C0972k[] f1718i = {new C0972k(false, 3, 5, 8, 8, 1), new C0972k(false, 5, 7, 10, 10, 1), new C0972k(true, 5, 7, 16, 6, 1), new C0972k(false, 8, 10, 12, 12, 1), new C0972k(true, 10, 11, 14, 6, 2), new C0972k(false, 12, 12, 14, 14, 1), new C0972k(true, 16, 14, 24, 10, 1), new C0972k(false, 18, 14, 16, 16, 1), new C0972k(false, 22, 18, 18, 18, 1), new C0972k(true, 22, 18, 16, 10, 2), new C0972k(false, 30, 20, 20, 20, 1), new C0972k(true, 32, 24, 16, 14, 2), new C0972k(false, 36, 24, 22, 22, 1), new C0972k(false, 44, 28, 24, 24, 1), new C0972k(true, 49, 28, 22, 14, 2), new C0972k(false, 62, 36, 14, 14, 4), new C0972k(false, 86, 42, 16, 16, 4), new C0972k(false, 114, 48, 18, 18, 4), new C0972k(false, 144, 56, 20, 20, 4), new C0972k(false, C2114a.f6308e, 68, 22, 22, 4), new C0972k(false, 204, 84, 24, 24, 4, 102, 42), new C0972k(false, 280, 112, 14, 14, 16, HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE, 56), new C0972k(false, 368, 144, 16, 16, 16, 92, 36), new C0972k(false, 456, 192, 18, 18, 16, 114, 48), new C0972k(false, 576, 224, 20, 20, 16, 144, 56), new C0972k(false, 696, 272, 22, 22, 16, C2114a.f6308e, 68), new C0972k(false, 816, 336, 24, 24, 16, 136, 56), new C0972k(false, 1050, 408, 18, 18, 36, 175, 68), new C0972k(false, 1304, 496, 20, 20, 36, 163, 62), new C0965d()};

    /* renamed from: j */
    private static C0972k[] f1719j = f1718i;

    /* renamed from: a */
    private final boolean f1720a;

    /* renamed from: b */
    private final int f1721b;

    /* renamed from: c */
    private final int f1722c;

    /* renamed from: d */
    public final int f1723d;

    /* renamed from: e */
    public final int f1724e;

    /* renamed from: f */
    private final int f1725f;

    /* renamed from: g */
    private final int f1726g;

    /* renamed from: h */
    private final int f1727h;

    public C0972k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    /* renamed from: a */
    public static void m1310a(C0972k[] c0972kArr) {
        f1719j = c0972kArr;
    }

    /* renamed from: c */
    public static C0972k m1311c(int i2) {
        return m1308a(i2, EnumC0973l.FORCE_NONE, true);
    }

    /* renamed from: b */
    public final int m1313b() {
        return this.f1721b;
    }

    /* renamed from: d */
    final int m1316d() {
        int i2 = this.f1725f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    /* renamed from: e */
    public int mo1250e() {
        return this.f1721b / this.f1726g;
    }

    /* renamed from: f */
    public final int m1317f() {
        return m1321j() * this.f1724e;
    }

    /* renamed from: g */
    public final int m1318g() {
        return m1316d() * this.f1723d;
    }

    /* renamed from: h */
    public final int m1319h() {
        return m1317f() + (m1321j() * 2);
    }

    /* renamed from: i */
    public final int m1320i() {
        return m1318g() + (m1316d() * 2);
    }

    /* renamed from: j */
    final int m1321j() {
        int i2 = this.f1725f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1720a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f1723d);
        sb.append('x');
        sb.append(this.f1724e);
        sb.append(", symbol size ");
        sb.append(m1320i());
        sb.append('x');
        sb.append(m1319h());
        sb.append(", symbol data size ");
        sb.append(m1318g());
        sb.append('x');
        sb.append(m1317f());
        sb.append(", codewords ");
        sb.append(this.f1721b);
        sb.append('+');
        sb.append(this.f1722c);
        return sb.toString();
    }

    C0972k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1720a = z;
        this.f1721b = i2;
        this.f1722c = i3;
        this.f1723d = i4;
        this.f1724e = i5;
        this.f1725f = i6;
        this.f1726g = i7;
        this.f1727h = i8;
    }

    /* renamed from: a */
    public static C0972k m1306a(int i2, EnumC0973l enumC0973l) {
        return m1308a(i2, enumC0973l, true);
    }

    /* renamed from: b */
    public final int m1314b(int i2) {
        return this.f1727h;
    }

    /* renamed from: c */
    public final int m1315c() {
        return this.f1722c;
    }

    /* renamed from: a */
    public static C0972k m1309a(int i2, boolean z, boolean z2) {
        return m1308a(i2, z ? EnumC0973l.FORCE_NONE : EnumC0973l.FORCE_SQUARE, z2);
    }

    /* renamed from: a */
    private static C0972k m1308a(int i2, EnumC0973l enumC0973l, boolean z) {
        return m1307a(i2, enumC0973l, null, null, z);
    }

    /* renamed from: a */
    public static C0972k m1307a(int i2, EnumC0973l enumC0973l, C1071f c1071f, C1071f c1071f2, boolean z) {
        for (C0972k c0972k : f1719j) {
            if (!(enumC0973l == EnumC0973l.FORCE_SQUARE && c0972k.f1720a) && ((enumC0973l != EnumC0973l.FORCE_RECTANGLE || c0972k.f1720a) && ((c1071f == null || (c0972k.m1320i() >= c1071f.m1729b() && c0972k.m1319h() >= c1071f.m1728a())) && ((c1071f2 == null || (c0972k.m1320i() <= c1071f2.m1729b() && c0972k.m1319h() <= c1071f2.m1728a())) && i2 <= c0972k.f1721b)))) {
                return c0972k;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i2);
    }

    /* renamed from: a */
    public int m1312a() {
        return this.f1721b + this.f1722c;
    }

    /* renamed from: a */
    public int mo1249a(int i2) {
        return this.f1726g;
    }
}
