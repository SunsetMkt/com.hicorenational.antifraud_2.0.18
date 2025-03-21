package h;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* compiled from: BigIntegers.kt */
/* loaded from: classes2.dex */
class d0 extends c0 {
    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d BigInteger bigInteger) {
        h.q2.t.i0.f(bigInteger, "$this$dec");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        h.q2.t.i0.a((Object) subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @h.m2.f
    private static final BigInteger b(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$div");
        BigInteger divide = bigInteger.divide(bigInteger2);
        h.q2.t.i0.a((Object) divide, "this.divide(other)");
        return divide;
    }

    @h.m2.f
    private static final BigInteger c(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$minus");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        h.q2.t.i0.a((Object) subtract, "this.subtract(other)");
        return subtract;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger d(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger or = bigInteger.or(bigInteger2);
        h.q2.t.i0.a((Object) or, "this.or(other)");
        return or;
    }

    @h.m2.f
    private static final BigInteger e(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$plus");
        BigInteger add = bigInteger.add(bigInteger2);
        h.q2.t.i0.a((Object) add, "this.add(other)");
        return add;
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final BigInteger f(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$rem");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        h.q2.t.i0.a((Object) remainder, "this.remainder(other)");
        return remainder;
    }

    @h.m2.f
    private static final BigInteger g(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        h.q2.t.i0.f(bigInteger, "$this$times");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        h.q2.t.i0.a((Object) multiply, "this.multiply(other)");
        return multiply;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger h(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger xor = bigInteger.xor(bigInteger2);
        h.q2.t.i0.a((Object) xor, "this.xor(other)");
        return xor;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger and = bigInteger.and(bigInteger2);
        h.q2.t.i0.a((Object) and, "this.and(other)");
        return and;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger b(@i.c.a.d BigInteger bigInteger) {
        h.q2.t.i0.f(bigInteger, "$this$inc");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        h.q2.t.i0.a((Object) add, "this.add(BigInteger.ONE)");
        return add;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger c(@i.c.a.d BigInteger bigInteger) {
        BigInteger not = bigInteger.not();
        h.q2.t.i0.a((Object) not, "this.not()");
        return not;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal d(@i.c.a.d BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    @h.m2.f
    private static final BigInteger e(@i.c.a.d BigInteger bigInteger) {
        h.q2.t.i0.f(bigInteger, "$this$unaryMinus");
        BigInteger negate = bigInteger.negate();
        h.q2.t.i0.a((Object) negate, "this.negate()");
        return negate;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(@i.c.a.d BigInteger bigInteger, int i2) {
        BigInteger shiftLeft = bigInteger.shiftLeft(i2);
        h.q2.t.i0.a((Object) shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger b(@i.c.a.d BigInteger bigInteger, int i2) {
        BigInteger shiftRight = bigInteger.shiftRight(i2);
        h.q2.t.i0.a((Object) shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(int i2) {
        BigInteger valueOf = BigInteger.valueOf(i2);
        h.q2.t.i0.a((Object) valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigInteger a(long j2) {
        BigInteger valueOf = BigInteger.valueOf(j2);
        h.q2.t.i0.a((Object) valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }

    static /* synthetic */ BigDecimal a(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            h.q2.t.i0.a((Object) mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(@i.c.a.d BigInteger bigInteger, int i2, MathContext mathContext) {
        return new BigDecimal(bigInteger, i2, mathContext);
    }
}
