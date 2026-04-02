package i.z2;

import i.t0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class z extends y {
    @t0(version = "1.1")
    @i.m2.f
    private static final String a(byte b2, int i2) {
        String string = Integer.toString(b2, d.a(d.a(i2)));
        i.q2.t.i0.a((Object) string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    @j.c.a.e
    @t0(version = "1.2")
    public static final BigInteger b(@j.c.a.d String str, int i2) {
        i.q2.t.i0.f(str, "$this$toBigIntegerOrNull");
        d.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i3 = str.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                if (d.a(str.charAt(i3), i2) < 0) {
                    return null;
                }
            }
        } else if (d.a(str.charAt(0), i2) < 0) {
            return null;
        }
        return new BigInteger(str, d.a(i2));
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final byte c(@j.c.a.d String str, int i2) {
        return Byte.parseByte(str, d.a(i2));
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final int d(@j.c.a.d String str, int i2) {
        return Integer.parseInt(str, d.a(i2));
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final long e(@j.c.a.d String str, int i2) {
        return Long.parseLong(str, d.a(i2));
    }

    @i.m2.f
    private static final boolean f(@j.c.a.d String str) {
        return Boolean.parseBoolean(str);
    }

    @i.m2.f
    private static final byte g(@j.c.a.d String str) {
        return Byte.parseByte(str);
    }

    @i.m2.f
    private static final double h(@j.c.a.d String str) {
        return Double.parseDouble(str);
    }

    @j.c.a.e
    @t0(version = "1.1")
    public static final Double i(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "$this$toDoubleOrNull");
        try {
            if (r.a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @i.m2.f
    private static final float j(@j.c.a.d String str) {
        return Float.parseFloat(str);
    }

    @j.c.a.e
    @t0(version = "1.1")
    public static final Float k(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "$this$toFloatOrNull");
        try {
            if (r.a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @i.m2.f
    private static final int l(@j.c.a.d String str) {
        return Integer.parseInt(str);
    }

    @i.m2.f
    private static final long m(@j.c.a.d String str) {
        return Long.parseLong(str);
    }

    @i.m2.f
    private static final short n(@j.c.a.d String str) {
        return Short.parseShort(str);
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final String a(short s, int i2) {
        String string = Integer.toString(s, d.a(d.a(i2)));
        i.q2.t.i0.a((Object) string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger d(@j.c.a.d String str) {
        return new BigInteger(str);
    }

    @j.c.a.e
    @t0(version = "1.2")
    public static final BigInteger e(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "$this$toBigIntegerOrNull");
        return b(str, 10);
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final short f(@j.c.a.d String str, int i2) {
        return Short.parseShort(str, d.a(i2));
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final String a(int i2, int i3) {
        String string = Integer.toString(i2, d.a(i3));
        i.q2.t.i0.a((Object) string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final String a(long j2, int i2) {
        String string = Long.toString(j2, d.a(i2));
        i.q2.t.i0.a((Object) string, "java.lang.Long.toString(this, checkRadix(radix))");
        return string;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger a(@j.c.a.d String str, int i2) {
        return new BigInteger(str, d.a(i2));
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(@j.c.a.d String str) {
        return new BigDecimal(str);
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(@j.c.a.d String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @j.c.a.e
    @t0(version = "1.2")
    public static final BigDecimal b(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "$this$toBigDecimalOrNull");
        try {
            if (r.a.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static final <T> T a(String str, i.q2.s.l<? super String, ? extends T> lVar) {
        try {
            if (r.a.matches(str)) {
                return lVar.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @j.c.a.e
    @t0(version = "1.2")
    public static final BigDecimal b(@j.c.a.d String str, @j.c.a.d MathContext mathContext) {
        i.q2.t.i0.f(str, "$this$toBigDecimalOrNull");
        i.q2.t.i0.f(mathContext, "mathContext");
        try {
            if (r.a.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
