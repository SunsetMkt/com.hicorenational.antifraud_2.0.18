package h.z2;

import h.b2;
import h.f1;
import h.j1;
import h.n1;
import h.t0;
import h.t1;

/* compiled from: UStrings.kt */
@h.q2.e(name = "UStringsKt")
/* loaded from: classes2.dex */
public final class i0 {
    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(byte b2, int i2) {
        int a2;
        int i3 = b2 & f1.f16099c;
        a2 = d.a(i2);
        String num = Integer.toString(i3, a2);
        h.q2.t.i0.a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final f1 b(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUByteOrNull");
        return b(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    public static final int c(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUInt");
        j1 d2 = d(str);
        if (d2 != null) {
            return d2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final j1 d(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUIntOrNull");
        return d(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    public static final long e(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toULong");
        n1 f2 = f(str);
        if (f2 != null) {
            return f2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final n1 f(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toULongOrNull");
        return f(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    public static final short g(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUShort");
        t1 h2 = h(str);
        if (h2 != null) {
            return h2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final t1 h(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUShortOrNull");
        return h(str, 10);
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(short s, int i2) {
        int a2;
        int i3 = s & t1.f16480c;
        a2 = d.a(i2);
        String num = Integer.toString(i3, a2);
        h.q2.t.i0.a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final f1 b(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUByteOrNull");
        j1 d2 = d(str, i2);
        if (d2 == null) {
            return null;
        }
        int a2 = d2.a();
        if (b2.a(a2, j1.c(255)) > 0) {
            return null;
        }
        return f1.a(f1.c((byte) a2));
    }

    @t0(version = "1.3")
    @h.k
    public static final int c(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUInt");
        j1 d2 = d(str, i2);
        if (d2 != null) {
            return d2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final j1 d(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUIntOrNull");
        d.a(i2);
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
        int c2 = j1.c(i2);
        int i5 = 119304647;
        while (i4 < length) {
            int a2 = d.a(str.charAt(i4), i2);
            if (a2 < 0) {
                return null;
            }
            if (b2.a(i3, i5) > 0) {
                if (i5 == 119304647) {
                    i5 = b2.b(-1, c2);
                    if (b2.a(i3, i5) > 0) {
                    }
                }
                return null;
            }
            int c3 = j1.c(i3 * c2);
            int c4 = j1.c(j1.c(a2) + c3);
            if (b2.a(c4, c3) < 0) {
                return null;
            }
            i4++;
            i3 = c4;
        }
        return j1.a(i3);
    }

    @t0(version = "1.3")
    @h.k
    public static final long e(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toULong");
        n1 f2 = f(str, i2);
        if (f2 != null) {
            return f2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final n1 f(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toULongOrNull");
        d.a(i2);
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
        long c2 = n1.c(i2);
        long j3 = 0;
        long j4 = 512409557603043100L;
        while (i3 < length) {
            if (d.a(str.charAt(i3), i2) < 0) {
                return null;
            }
            if (b2.a(j3, j4) > 0) {
                if (j4 == 512409557603043100L) {
                    j4 = b2.b(j2, c2);
                    if (b2.a(j3, j4) > 0) {
                    }
                }
                return null;
            }
            long c3 = n1.c(j3 * c2);
            long c4 = n1.c(n1.c(j1.c(r15) & 4294967295L) + c3);
            if (b2.a(c4, c3) < 0) {
                return null;
            }
            i3++;
            j3 = c4;
            j2 = -1;
        }
        return n1.a(j3);
    }

    @t0(version = "1.3")
    @h.k
    public static final short g(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUShort");
        t1 h2 = h(str, i2);
        if (h2 != null) {
            return h2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.e
    public static final t1 h(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUShortOrNull");
        j1 d2 = d(str, i2);
        if (d2 == null) {
            return null;
        }
        int a2 = d2.a();
        if (b2.a(a2, j1.c(65535)) > 0) {
            return null;
        }
        return t1.a(t1.c((short) a2));
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(int i2, int i3) {
        int a2;
        long j2 = i2 & 4294967295L;
        a2 = d.a(i3);
        String l2 = Long.toString(j2, a2);
        h.q2.t.i0.a((Object) l2, "java.lang.Long.toString(this, checkRadix(radix))");
        return l2;
    }

    @t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final String a(long j2, int i2) {
        int a2;
        a2 = d.a(i2);
        return b2.a(j2, a2);
    }

    @t0(version = "1.3")
    @h.k
    public static final byte a(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toUByte");
        f1 b2 = b(str);
        if (b2 != null) {
            return b2.a();
        }
        a0.a(str);
        throw null;
    }

    @t0(version = "1.3")
    @h.k
    public static final byte a(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toUByte");
        f1 b2 = b(str, i2);
        if (b2 != null) {
            return b2.a();
        }
        a0.a(str);
        throw null;
    }
}
