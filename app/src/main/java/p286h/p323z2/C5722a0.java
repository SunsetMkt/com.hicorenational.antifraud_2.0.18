package p286h.p323z2;

import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: StringNumberConversions.kt */
/* renamed from: h.z2.a0 */
/* loaded from: classes2.dex */
class C5722a0 extends C5755z {
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: a */
    public static final Byte m23558a(@InterfaceC5816d String str, int i2) {
        int intValue;
        C5544i0.m22546f(str, "$this$toByteOrNull");
        Integer m23560c = m23560c(str, i2);
        if (m23560c == null || (intValue = m23560c.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: c */
    public static final Integer m23560c(@InterfaceC5816d String str, int i2) {
        boolean z;
        int i3;
        C5544i0.m22546f(str, "$this$toIntOrNull");
        C5727d.m23807a(i2);
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
            int m23806a = C5727d.m23806a(str.charAt(i6), i2);
            if (m23806a < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + m23806a) {
                return null;
            }
            i4 = i3 - m23806a;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: d */
    public static final Byte m23561d(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toByteOrNull");
        return m23558a(str, 10);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: e */
    public static final Short m23563e(@InterfaceC5816d String str, int i2) {
        int intValue;
        C5544i0.m22546f(str, "$this$toShortOrNull");
        Integer m23560c = m23560c(str, i2);
        if (m23560c == null || (intValue = m23560c.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: f */
    public static final Integer m23564f(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toIntOrNull");
        return m23560c(str, 10);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: g */
    public static final Long m23565g(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toLongOrNull");
        return m23562d(str, 10);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: h */
    public static final Short m23566h(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toShortOrNull");
        return m23563e(str, 10);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: d */
    public static final Long m23562d(@InterfaceC5816d String str, int i2) {
        C5544i0.m22546f(str, "$this$toLongOrNull");
        C5727d.m23807a(i2);
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
            int m23806a = C5727d.m23806a(str.charAt(i3), i2);
            if (m23806a < 0) {
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
            long j7 = m23806a;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i3++;
            j3 = -256204778801521550L;
        }
        return z ? Long.valueOf(j4) : Long.valueOf(-j4);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final Void m23559a(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }
}
