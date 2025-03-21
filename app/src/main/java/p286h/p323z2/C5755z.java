package p286h.p323z2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: StringNumberConversionsJVM.kt */
/* renamed from: h.z2.z */
/* loaded from: classes2.dex */
class C5755z extends C5754y {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final String m24127a(byte b2, int i2) {
        int m23807a;
        int m23807a2;
        m23807a = C5727d.m23807a(i2);
        m23807a2 = C5727d.m23807a(m23807a);
        String num = Integer.toString(b2, m23807a2);
        C5544i0.m22521a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5817e
    /* renamed from: b */
    public static final BigInteger m24136b(@InterfaceC5816d String str, int i2) {
        int m23807a;
        C5544i0.m22546f(str, "$this$toBigIntegerOrNull");
        C5727d.m23807a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i3 = str.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                if (C5727d.m23806a(str.charAt(i3), i2) < 0) {
                    return null;
                }
            }
        } else if (C5727d.m23806a(str.charAt(0), i2) < 0) {
            return null;
        }
        m23807a = C5727d.m23807a(i2);
        return new BigInteger(str, m23807a);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final byte m24137c(@InterfaceC5816d String str, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        return Byte.parseByte(str, m23807a);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: d */
    private static final int m24138d(@InterfaceC5816d String str, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        return Integer.parseInt(str, m23807a);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: e */
    private static final long m24140e(@InterfaceC5816d String str, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        return Long.parseLong(str, m23807a);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final boolean m24143f(@InterfaceC5816d String str) {
        return Boolean.parseBoolean(str);
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final byte m24144g(@InterfaceC5816d String str) {
        return Byte.parseByte(str);
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final double m24145h(@InterfaceC5816d String str) {
        return Double.parseDouble(str);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: i */
    public static final Double m24146i(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toDoubleOrNull");
        try {
            if (C5747r.f20748a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final float m24147j(@InterfaceC5816d String str) {
        return Float.parseFloat(str);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: k */
    public static final Float m24148k(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toFloatOrNull");
        try {
            if (C5747r.f20748a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final int m24149l(@InterfaceC5816d String str) {
        return Integer.parseInt(str);
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final long m24150m(@InterfaceC5816d String str) {
        return Long.parseLong(str);
    }

    @InterfaceC5426f
    /* renamed from: n */
    private static final short m24151n(@InterfaceC5816d String str) {
        return Short.parseShort(str);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final String m24130a(short s, int i2) {
        int m23807a;
        int m23807a2;
        m23807a = C5727d.m23807a(i2);
        m23807a2 = C5727d.m23807a(m23807a);
        String num = Integer.toString(s, m23807a2);
        C5544i0.m22521a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    private static final BigInteger m24139d(@InterfaceC5816d String str) {
        return new BigInteger(str);
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5817e
    /* renamed from: e */
    public static final BigInteger m24141e(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toBigIntegerOrNull");
        return m24136b(str, 10);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: f */
    private static final short m24142f(@InterfaceC5816d String str, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        return Short.parseShort(str, m23807a);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final String m24128a(int i2, int i3) {
        int m23807a;
        m23807a = C5727d.m23807a(i3);
        String num = Integer.toString(i2, m23807a);
        C5544i0.m22521a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final String m24129a(long j2, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        String l2 = Long.toString(j2, m23807a);
        C5544i0.m22521a((Object) l2, "java.lang.Long.toString(this, checkRadix(radix))");
        return l2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigInteger m24133a(@InterfaceC5816d String str, int i2) {
        int m23807a;
        m23807a = C5727d.m23807a(i2);
        return new BigInteger(str, m23807a);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m24131a(@InterfaceC5816d String str) {
        return new BigDecimal(str);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m24132a(@InterfaceC5816d String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5817e
    /* renamed from: b */
    public static final BigDecimal m24134b(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$toBigDecimalOrNull");
        try {
            if (C5747r.f20748a.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static final <T> T m24126a(String str, InterfaceC5506l<? super String, ? extends T> interfaceC5506l) {
        try {
            if (C5747r.f20748a.matches(str)) {
                return interfaceC5506l.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5817e
    /* renamed from: b */
    public static final BigDecimal m24135b(@InterfaceC5816d String str, @InterfaceC5816d MathContext mathContext) {
        C5544i0.m22546f(str, "$this$toBigDecimalOrNull");
        C5544i0.m22546f(mathContext, "mathContext");
        try {
            if (C5747r.f20748a.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
