package i;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: compiled from: BigIntegers.kt */
/* JADX INFO: loaded from: classes2.dex */
class d0 extends c0 {
    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger a(@j.c.a.d BigInteger bigInteger) {
        i.q2.t.i0.f(bigInteger, "$this$dec");
        BigInteger bigIntegerSubtract = bigInteger.subtract(BigInteger.ONE);
        i.q2.t.i0.a((Object) bigIntegerSubtract, "this.subtract(BigInteger.ONE)");
        return bigIntegerSubtract;
    }

    @i.m2.f
    private static final BigInteger b(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        i.q2.t.i0.f(bigInteger, "$this$div");
        BigInteger bigIntegerDivide = bigInteger.divide(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerDivide, "this.divide(other)");
        return bigIntegerDivide;
    }

    @i.m2.f
    private static final BigInteger c(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        i.q2.t.i0.f(bigInteger, "$this$minus");
        BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerSubtract, "this.subtract(other)");
        return bigIntegerSubtract;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger d(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerOr = bigInteger.or(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerOr, "this.or(other)");
        return bigIntegerOr;
    }

    @i.m2.f
    private static final BigInteger e(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        i.q2.t.i0.f(bigInteger, "$this$plus");
        BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerAdd, "this.add(other)");
        return bigIntegerAdd;
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final BigInteger f(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        i.q2.t.i0.f(bigInteger, "$this$rem");
        BigInteger bigIntegerRemainder = bigInteger.remainder(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerRemainder, "this.remainder(other)");
        return bigIntegerRemainder;
    }

    @i.m2.f
    private static final BigInteger g(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        i.q2.t.i0.f(bigInteger, "$this$times");
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerMultiply, "this.multiply(other)");
        return bigIntegerMultiply;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger h(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerXor = bigInteger.xor(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerXor, "this.xor(other)");
        return bigIntegerXor;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger a(@j.c.a.d BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerAnd = bigInteger.and(bigInteger2);
        i.q2.t.i0.a((Object) bigIntegerAnd, "this.and(other)");
        return bigIntegerAnd;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger b(@j.c.a.d BigInteger bigInteger) {
        i.q2.t.i0.f(bigInteger, "$this$inc");
        BigInteger bigIntegerAdd = bigInteger.add(BigInteger.ONE);
        i.q2.t.i0.a((Object) bigIntegerAdd, "this.add(BigInteger.ONE)");
        return bigIntegerAdd;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger c(@j.c.a.d BigInteger bigInteger) {
        BigInteger bigIntegerNot = bigInteger.not();
        i.q2.t.i0.a((Object) bigIntegerNot, "this.not()");
        return bigIntegerNot;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal d(@j.c.a.d BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    @i.m2.f
    private static final BigInteger e(@j.c.a.d BigInteger bigInteger) {
        i.q2.t.i0.f(bigInteger, "$this$unaryMinus");
        BigInteger bigIntegerNegate = bigInteger.negate();
        i.q2.t.i0.a((Object) bigIntegerNegate, "this.negate()");
        return bigIntegerNegate;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger a(@j.c.a.d BigInteger bigInteger, int i2) {
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i2);
        i.q2.t.i0.a((Object) bigIntegerShiftLeft, "this.shiftLeft(n)");
        return bigIntegerShiftLeft;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger b(@j.c.a.d BigInteger bigInteger, int i2) {
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i2);
        i.q2.t.i0.a((Object) bigIntegerShiftRight, "this.shiftRight(n)");
        return bigIntegerShiftRight;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger a(int i2) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i2);
        i.q2.t.i0.a((Object) bigIntegerValueOf, "BigInteger.valueOf(this.toLong())");
        return bigIntegerValueOf;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigInteger a(long j2) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j2);
        i.q2.t.i0.a((Object) bigIntegerValueOf, "BigInteger.valueOf(this)");
        return bigIntegerValueOf;
    }

    static /* synthetic */ BigDecimal a(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            i.q2.t.i0.a((Object) mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(@j.c.a.d BigInteger bigInteger, int i2, MathContext mathContext) {
        return new BigDecimal(bigInteger, i2, mathContext);
    }
}
