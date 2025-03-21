package p286h.p314r2;

import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5588w;
import p286h.p309q2.p311t.C5594z;

/* compiled from: MathJVM.kt */
/* renamed from: h.r2.d */
/* loaded from: classes2.dex */
class C5602d extends C5601c {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: A */
    private static final double m22726A(double d2) {
        return Math.signum(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: B */
    public static /* synthetic */ void m22728B(double d2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: B */
    public static /* synthetic */ void m22729B(float f2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: C */
    private static final double m22730C(double d2) {
        return Math.sin(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: D */
    private static final double m22732D(double d2) {
        return Math.sinh(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: E */
    private static final double m22734E(double d2) {
        return Math.sqrt(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: F */
    private static final double m22736F(double d2) {
        return Math.tan(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: G */
    private static final double m22738G(double d2) {
        return Math.tanh(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: H */
    public static final double m22740H(double d2) {
        return (Double.isNaN(d2) || Double.isInfinite(d2)) ? d2 : d2 > ((double) 0) ? Math.floor(d2) : Math.ceil(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: I */
    public static /* synthetic */ void m22742I(double d2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: I */
    public static /* synthetic */ void m22743I(float f2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final double m22744a(double d2) {
        return Math.abs(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final double m22754b(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    public static /* synthetic */ void m22760b(double d2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    public static /* synthetic */ void m22761b(float f2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    public static /* synthetic */ void m22762b(int i2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    public static /* synthetic */ void m22763b(long j2) {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: c */
    private static final double m22764c(double d2) {
        return Math.acos(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    public static final double m22770d(double d2) {
        double d3 = 1;
        if (d2 < d3) {
            return C5588w.f20440f.m22692d();
        }
        if (d2 > C5599a.f20459e) {
            return Math.log(d2) + C5599a.f20455a;
        }
        double d4 = d2 - d3;
        if (d4 >= C5599a.f20458d) {
            return Math.log(d2 + Math.sqrt((d2 * d2) - d3));
        }
        double sqrt = Math.sqrt(d4);
        if (sqrt >= C5599a.f20457c) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    /* renamed from: d */
    public static final int m22774d(int i2) {
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    /* renamed from: d */
    public static final int m22775d(long j2) {
        if (j2 < 0) {
            return -1;
        }
        return j2 > 0 ? 1 : 0;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    private static final double m22776e(double d2) {
        return Math.asin(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    public static /* synthetic */ void m22780e(int i2) {
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    public static /* synthetic */ void m22781e(long j2) {
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: f */
    public static final double m22782f(double d2) {
        double d3 = C5599a.f20458d;
        if (d2 < d3) {
            return d2 <= (-d3) ? -m22782f(-d2) : Math.abs(d2) >= C5599a.f20457c ? d2 - (((d2 * d2) * d2) / 6) : d2;
        }
        if (d2 <= C5599a.f20460f) {
            return Math.log(d2 + Math.sqrt((d2 * d2) + 1));
        }
        if (d2 > C5599a.f20459e) {
            return Math.log(d2) + C5599a.f20455a;
        }
        double d4 = d2 * 2;
        return Math.log(d4 + (1 / d4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: g */
    private static final double m22786g(double d2) {
        return Math.atan(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: h */
    public static final double m22790h(double d2) {
        if (Math.abs(d2) < C5599a.f20458d) {
            return Math.abs(d2) > C5599a.f20457c ? d2 + (((d2 * d2) * d2) / 3) : d2;
        }
        double d3 = 1;
        return Math.log((d3 + d2) / (d3 - d2)) / 2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: i */
    private static final double m22794i(double d2) {
        return Math.ceil(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: j */
    private static final double m22798j(double d2) {
        return Math.cos(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: k */
    private static final double m22800k(double d2) {
        return Math.cosh(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: l */
    private static final double m22802l(double d2) {
        return Math.exp(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: m */
    private static final double m22804m(double d2) {
        return Math.expm1(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: n */
    private static final double m22806n(double d2) {
        return Math.floor(d2);
    }

    /* renamed from: o */
    private static final double m22808o(double d2) {
        return Math.abs(d2);
    }

    /* renamed from: p */
    private static final double m22810p(double d2) {
        return Math.signum(d2);
    }

    /* renamed from: q */
    private static final double m22812q(double d2) {
        return Math.ulp(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: r */
    private static final double m22814r(double d2) {
        return Math.log(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: s */
    private static final double m22816s(double d2) {
        return Math.log1p(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: t */
    private static final double m22818t(double d2) {
        return Math.log10(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: u */
    public static final double m22820u(double d2) {
        return Math.log(d2) / C5599a.f20455a;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: v */
    private static final double m22822v(double d2) {
        return Math.nextAfter(d2, C5588w.f20440f.m22691c());
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: w */
    private static final double m22824w(double d2) {
        return Math.nextUp(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: x */
    private static final double m22826x(double d2) {
        return Math.rint(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: y */
    public static final int m22828y(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (d2 < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: z */
    public static final long m22830z(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: A */
    private static final float m22727A(float f2) {
        return Math.signum(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: C */
    private static final float m22731C(float f2) {
        return (float) Math.sin(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: D */
    private static final float m22733D(float f2) {
        return (float) Math.sinh(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: E */
    private static final float m22735E(float f2) {
        return (float) Math.sqrt(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: F */
    private static final float m22737F(float f2) {
        return (float) Math.tan(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: G */
    private static final float m22739G(float f2) {
        return (float) Math.tanh(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final double m22746a(double d2, int i2) {
        return Math.pow(d2, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final double m22755b(double d2, int i2) {
        return Math.copySign(d2, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: c */
    private static final double m22765c(double d2, double d3) {
        return Math.hypot(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    private static final double m22777e(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: g */
    private static final double m22787g(double d2, double d3) {
        return Math.nextAfter(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: i */
    private static final double m22795i(double d2, double d3) {
        return Math.copySign(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: j */
    private static final float m22799j(float f2) {
        return (float) Math.cos(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: k */
    private static final float m22801k(float f2) {
        return (float) Math.cosh(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: l */
    private static final float m22803l(float f2) {
        return (float) Math.exp(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: m */
    private static final float m22805m(float f2) {
        return (float) Math.expm1(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: n */
    private static final float m22807n(float f2) {
        return (float) Math.floor(f2);
    }

    /* renamed from: o */
    private static final float m22809o(float f2) {
        return Math.abs(f2);
    }

    /* renamed from: p */
    private static final float m22811p(float f2) {
        return Math.signum(f2);
    }

    /* renamed from: q */
    private static final float m22813q(float f2) {
        return Math.ulp(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: r */
    private static final float m22815r(float f2) {
        return (float) Math.log(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: s */
    private static final float m22817s(float f2) {
        return (float) Math.log1p(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: t */
    private static final float m22819t(float f2) {
        return (float) Math.log10(f2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: u */
    public static final float m22821u(float f2) {
        return (float) (Math.log(f2) / C5599a.f20455a);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: v */
    private static final float m22823v(float f2) {
        return Math.nextAfter(f2, C5588w.f20440f.m22691c());
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: w */
    private static final float m22825w(float f2) {
        return Math.nextUp(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: x */
    private static final float m22827x(float f2) {
        return (float) Math.rint(f2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: z */
    public static final long m22831z(float f2) {
        return m22830z(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final double m22745a(double d2, double d3) {
        return Math.IEEEremainder(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final float m22756b(float f2, float f3) {
        return (float) Math.atan2(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: c */
    private static final float m22766c(float f2) {
        return (float) Math.acos(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    private static final float m22778e(float f2) {
        return (float) Math.asin(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: g */
    private static final float m22788g(float f2) {
        return (float) Math.atan(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: i */
    private static final float m22796i(float f2) {
        return (float) Math.ceil(f2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: H */
    public static final float m22741H(float f2) {
        double ceil;
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        if (f2 > 0) {
            ceil = Math.floor(f2);
        } else {
            ceil = Math.ceil(f2);
        }
        return (float) ceil;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final float m22747a(float f2) {
        return Math.abs(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final float m22757b(float f2, int i2) {
        return Math.copySign(f2, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: c */
    private static final float m22767c(float f2, float f3) {
        return (float) Math.hypot(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    private static final float m22779e(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: g */
    private static final float m22789g(float f2, float f3) {
        return Math.nextAfter(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: h */
    private static final double m22791h(double d2, double d3) {
        return Math.pow(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: i */
    private static final float m22797i(float f2, float f3) {
        return Math.copySign(f2, f3);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: y */
    public static final int m22829y(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final float m22749a(float f2, int i2) {
        return (float) Math.pow(f2, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final int m22758b(int i2, int i3) {
        return Math.min(i2, i3);
    }

    /* renamed from: c */
    private static final int m22768c(int i2) {
        return Math.abs(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: h */
    private static final float m22792h(float f2) {
        return (float) m22790h(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final float m22748a(float f2, float f3) {
        return (float) Math.IEEEremainder(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final long m22759b(long j2, long j3) {
        return Math.min(j2, j3);
    }

    /* renamed from: c */
    private static final long m22769c(long j2) {
        return Math.abs(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: h */
    private static final float m22793h(float f2, float f3) {
        return (float) Math.pow(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final int m22750a(int i2) {
        return Math.abs(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final int m22751a(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final long m22752a(long j2) {
        return Math.abs(j2);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    public static final double m22771d(double d2, double d3) {
        if (d3 > 0.0d && d3 != 1.0d) {
            return Math.log(d2) / Math.log(d3);
        }
        return C5588w.f20440f.m22692d();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: f */
    private static final double m22783f(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final long m22753a(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: f */
    private static final float m22784f(float f2) {
        return (float) m22782f(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    private static final float m22772d(float f2) {
        return (float) m22770d(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: f */
    private static final float m22785f(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    public static final float m22773d(float f2, float f3) {
        if (f3 > 0.0f && f3 != 1.0f) {
            return (float) (Math.log(f2) / Math.log(f3));
        }
        return C5594z.f20453f.m22706d();
    }
}
