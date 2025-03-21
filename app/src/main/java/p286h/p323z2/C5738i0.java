package p286h.p323z2;

import p286h.C5215b2;
import p286h.C5230f1;
import p286h.C5341j1;
import p286h.C5441n1;
import p286h.C5611t1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UStrings.kt */
@InterfaceC5481e(name = "UStringsKt")
/* renamed from: h.z2.i0 */
/* loaded from: classes2.dex */
public final class C5738i0 {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23994a(byte b2, int i2) {
        int m23807a;
        int i3 = b2 & C5230f1.f20085c;
        m23807a = C5727d.m23807a(i2);
        String num = Integer.toString(i3, m23807a);
        C5544i0.m22521a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: b */
    public static final C5230f1 m23998b(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toUByteOrNull");
        return m23999b(str, 10);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    public static final int m24000c(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toUInt");
        C5341j1 m24002d = m24002d(str);
        if (m24002d != null) {
            return m24002d.m21968a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: d */
    public static final C5341j1 m24002d(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toUIntOrNull");
        return m24003d(str, 10);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: e */
    public static final long m24004e(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toULong");
        C5441n1 m24006f = m24006f(str);
        if (m24006f != null) {
            return m24006f.m22244a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: f */
    public static final C5441n1 m24006f(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toULongOrNull");
        return m24007f(str, 10);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: g */
    public static final short m24008g(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toUShort");
        C5611t1 m24010h = m24010h(str);
        if (m24010h != null) {
            return m24010h.m22913a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: h */
    public static final C5611t1 m24010h(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toUShortOrNull");
        return m24011h(str, 10);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23997a(short s, int i2) {
        int m23807a;
        int i3 = s & C5611t1.f20467c;
        m23807a = C5727d.m23807a(i2);
        String num = Integer.toString(i3, m23807a);
        C5544i0.m22521a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: b */
    public static final C5230f1 m23999b(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toUByteOrNull");
        C5341j1 m24003d = m24003d(str, i2);
        if (m24003d == null) {
            return null;
        }
        int m21968a = m24003d.m21968a();
        if (C5215b2.m18812a(m21968a, C5341j1.m21929c(255)) > 0) {
            return null;
        }
        return C5230f1.m18921a(C5230f1.m18929c((byte) m21968a));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    public static final int m24001c(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toUInt");
        C5341j1 m24003d = m24003d(str, i2);
        if (m24003d != null) {
            return m24003d.m21968a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: d */
    public static final C5341j1 m24003d(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toUIntOrNull");
        C5727d.m23807a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int i4 = 1;
        if (charAt >= '0') {
            i4 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int m21929c = C5341j1.m21929c(i2);
        int i5 = 119304647;
        while (i4 < length) {
            int m23806a = C5727d.m23806a(str.charAt(i4), i2);
            if (m23806a < 0) {
                return null;
            }
            if (C5215b2.m18812a(i3, i5) > 0) {
                if (i5 == 119304647) {
                    i5 = C5215b2.m18815b(-1, m21929c);
                    if (C5215b2.m18812a(i3, i5) > 0) {
                    }
                }
                return null;
            }
            int m21929c2 = C5341j1.m21929c(i3 * m21929c);
            int m21929c3 = C5341j1.m21929c(C5341j1.m21929c(m23806a) + m21929c2);
            if (C5215b2.m18812a(m21929c3, m21929c2) < 0) {
                return null;
            }
            i4++;
            i3 = m21929c3;
        }
        return C5341j1.m21921a(i3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: e */
    public static final long m24005e(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toULong");
        C5441n1 m24007f = m24007f(str, i2);
        if (m24007f != null) {
            return m24007f.m22244a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: f */
    public static final C5441n1 m24007f(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toULongOrNull");
        C5727d.m23807a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j2 = -1;
        int i3 = 0;
        char charAt = str.charAt(0);
        if (charAt < '0') {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i3 = 1;
        }
        long m22205c = C5441n1.m22205c(i2);
        long j3 = 0;
        long j4 = 512409557603043100L;
        while (i3 < length) {
            if (C5727d.m23806a(str.charAt(i3), i2) < 0) {
                return null;
            }
            if (C5215b2.m18813a(j3, j4) > 0) {
                if (j4 == 512409557603043100L) {
                    j4 = C5215b2.m18817b(j2, m22205c);
                    if (C5215b2.m18813a(j3, j4) > 0) {
                    }
                }
                return null;
            }
            long m22205c2 = C5441n1.m22205c(j3 * m22205c);
            long m22205c3 = C5441n1.m22205c(C5441n1.m22205c(C5341j1.m21929c(r15) & 4294967295L) + m22205c2);
            if (C5215b2.m18813a(m22205c3, m22205c2) < 0) {
                return null;
            }
            i3++;
            j3 = m22205c3;
            j2 = -1;
        }
        return C5441n1.m22197a(j3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: g */
    public static final short m24009g(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toUShort");
        C5611t1 m24011h = m24011h(str, i2);
        if (m24011h != null) {
            return m24011h.m22913a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: h */
    public static final C5611t1 m24011h(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toUShortOrNull");
        C5341j1 m24003d = m24003d(str, i2);
        if (m24003d == null) {
            return null;
        }
        int m21968a = m24003d.m21968a();
        if (C5215b2.m18812a(m21968a, C5341j1.m21929c(65535)) > 0) {
            return null;
        }
        return C5611t1.m22867a(C5611t1.m22880c((short) m21968a));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23995a(int i2, int i3) {
        int m23807a;
        long j2 = i2 & 4294967295L;
        m23807a = C5727d.m23807a(i3);
        String l2 = Long.toString(j2, m23807a);
        C5544i0.m22521a((Object) l2, "java.lang.Long.toString(this, checkRadix(radix))");
        return l2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23996a(long j2, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        return C5215b2.m18814a(j2, m23807a);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final byte m23992a(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toUByte");
        C5230f1 m23998b = m23998b(str);
        if (m23998b != null) {
            return m23998b.m18966a();
        }
        C5722a0.m23559a(str);
        throw null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final byte m23993a(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toUByte");
        C5230f1 m23999b = m23999b(str, i2);
        if (m23999b != null) {
            return m23999b.m18966a();
        }
        C5722a0.m23559a(str);
        throw null;
    }
}
