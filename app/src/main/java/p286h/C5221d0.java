package p286h;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: BigIntegers.kt */
/* renamed from: h.d0 */
/* loaded from: classes2.dex */
class C5221d0 extends C5217c0 {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigInteger m18845a(@InterfaceC5816d BigInteger bigInteger) {
        C5544i0.m22546f(bigInteger, "$this$dec");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        C5544i0.m22521a((Object) subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final BigInteger m18850b(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        C5544i0.m22546f(bigInteger, "$this$div");
        BigInteger divide = bigInteger.divide(bigInteger2);
        C5544i0.m22521a((Object) divide, "this.divide(other)");
        return divide;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final BigInteger m18852c(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        C5544i0.m22546f(bigInteger, "$this$minus");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        C5544i0.m22521a((Object) subtract, "this.subtract(other)");
        return subtract;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    private static final BigInteger m18854d(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger or = bigInteger.or(bigInteger2);
        C5544i0.m22521a((Object) or, "this.or(other)");
        return or;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final BigInteger m18856e(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        C5544i0.m22546f(bigInteger, "$this$plus");
        BigInteger add = bigInteger.add(bigInteger2);
        C5544i0.m22521a((Object) add, "this.add(other)");
        return add;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: f */
    private static final BigInteger m18857f(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        C5544i0.m22546f(bigInteger, "$this$rem");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        C5544i0.m22521a((Object) remainder, "this.remainder(other)");
        return remainder;
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final BigInteger m18858g(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        C5544i0.m22546f(bigInteger, "$this$times");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        C5544i0.m22521a((Object) multiply, "this.multiply(other)");
        return multiply;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: h */
    private static final BigInteger m18859h(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger xor = bigInteger.xor(bigInteger2);
        C5544i0.m22521a((Object) xor, "this.xor(other)");
        return xor;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigInteger m18847a(@InterfaceC5816d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger and = bigInteger.and(bigInteger2);
        C5544i0.m22521a((Object) and, "this.and(other)");
        return and;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final BigInteger m18848b(@InterfaceC5816d BigInteger bigInteger) {
        C5544i0.m22546f(bigInteger, "$this$inc");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        C5544i0.m22521a((Object) add, "this.add(BigInteger.ONE)");
        return add;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: c */
    private static final BigInteger m18851c(@InterfaceC5816d BigInteger bigInteger) {
        BigInteger not = bigInteger.not();
        C5544i0.m22521a((Object) not, "this.not()");
        return not;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    private static final BigDecimal m18853d(@InterfaceC5816d BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final BigInteger m18855e(@InterfaceC5816d BigInteger bigInteger) {
        C5544i0.m22546f(bigInteger, "$this$unaryMinus");
        BigInteger negate = bigInteger.negate();
        C5544i0.m22521a((Object) negate, "this.negate()");
        return negate;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigInteger m18846a(@InterfaceC5816d BigInteger bigInteger, int i2) {
        BigInteger shiftLeft = bigInteger.shiftLeft(i2);
        C5544i0.m22521a((Object) shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final BigInteger m18849b(@InterfaceC5816d BigInteger bigInteger, int i2) {
        BigInteger shiftRight = bigInteger.shiftRight(i2);
        C5544i0.m22521a((Object) shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigInteger m18843a(int i2) {
        BigInteger valueOf = BigInteger.valueOf(i2);
        C5544i0.m22521a((Object) valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigInteger m18844a(long j2) {
        BigInteger valueOf = BigInteger.valueOf(j2);
        C5544i0.m22521a((Object) valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ BigDecimal m18842a(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            C5544i0.m22521a((Object) mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18841a(@InterfaceC5816d BigInteger bigInteger, int i2, MathContext mathContext) {
        return new BigDecimal(bigInteger, i2, mathContext);
    }
}
