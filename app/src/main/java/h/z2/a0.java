package h.z2;

import h.t0;

/* compiled from: StringNumberConversions.kt */
/* loaded from: classes2.dex */
class a0 extends z {
    @t0(version = "1.1")
    @i.c.a.e
    public static final Byte a(@i.c.a.d String str, int i2) {
        int intValue;
        h.q2.t.i0.f(str, "$this$toByteOrNull");
        Integer c2 = c(str, i2);
        if (c2 == null || (intValue = c2.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Integer c(@i.c.a.d String str, int i2) {
        boolean z;
        int i3;
        h.q2.t.i0.f(str, "$this$toIntOrNull");
        d.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (charAt >= '0') {
            z = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int a2 = d.a(str.charAt(i6), i2);
            if (a2 < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + a2) {
                return null;
            }
            i4 = i3 - a2;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Byte d(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toByteOrNull");
        return a(str, 10);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Short e(@i.c.a.d String str, int i2) {
        int intValue;
        h.q2.t.i0.f(str, "$this$toShortOrNull");
        Integer c2 = c(str, i2);
        if (c2 == null || (intValue = c2.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Integer f(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toIntOrNull");
        return c(str, 10);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Long g(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toLongOrNull");
        return d(str, 10);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Short h(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$toShortOrNull");
        return e(str, 10);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final Long d(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$toLongOrNull");
        d.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        boolean z = false;
        char charAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        int i3 = 1;
        if (charAt >= '0') {
            i3 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j2 = Long.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            }
        }
        long j3 = -256204778801521550L;
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i3 < length) {
            int a2 = d.a(str.charAt(i3), i2);
            if (a2 < 0) {
                return null;
            }
            if (j4 < j5) {
                if (j5 == j3) {
                    j5 = j2 / i2;
                    if (j4 < j5) {
                    }
                }
                return null;
            }
            long j6 = j4 * i2;
            long j7 = a2;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i3++;
            j3 = -256204778801521550L;
        }
        return z ? Long.valueOf(j4) : Long.valueOf(-j4);
    }

    @i.c.a.d
    public static final Void a(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }
}
