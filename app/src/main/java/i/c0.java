package i;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* JADX INFO: compiled from: BigDecimals.kt */
/* JADX INFO: loaded from: classes2.dex */
class c0 {
    @i.m2.f
    private static final BigDecimal a(@j.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        i.q2.t.i0.f(bigDecimal, "$this$div");
        BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        i.q2.t.i0.a((Object) bigDecimalDivide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return bigDecimalDivide;
    }

    @i.m2.f
    private static final BigDecimal b(@j.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        i.q2.t.i0.f(bigDecimal, "$this$minus");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal2);
        i.q2.t.i0.a((Object) bigDecimalSubtract, "this.subtract(other)");
        return bigDecimalSubtract;
    }

    @c(level = d.ERROR, message = "Use rem(other) instead", replaceWith = @o0(expression = "rem(other)", imports = {}))
    @i.m2.f
    private static final BigDecimal c(@j.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        i.q2.t.i0.f(bigDecimal, "$this$mod");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(bigDecimal2);
        i.q2.t.i0.a((Object) bigDecimalRemainder, "this.remainder(other)");
        return bigDecimalRemainder;
    }

    @i.m2.f
    private static final BigDecimal d(@j.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        i.q2.t.i0.f(bigDecimal, "$this$plus");
        BigDecimal bigDecimalAdd = bigDecimal.add(bigDecimal2);
        i.q2.t.i0.a((Object) bigDecimalAdd, "this.add(other)");
        return bigDecimalAdd;
    }

    @i.m2.f
    private static final BigDecimal e(@j.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        i.q2.t.i0.f(bigDecimal, "$this$rem");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(bigDecimal2);
        i.q2.t.i0.a((Object) bigDecimalRemainder, "this.remainder(other)");
        return bigDecimalRemainder;
    }

    @i.m2.f
    private static final BigDecimal f(@j.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        i.q2.t.i0.f(bigDecimal, "$this$times");
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
        i.q2.t.i0.a((Object) bigDecimalMultiply, "this.multiply(other)");
        return bigDecimalMultiply;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(@j.c.a.d BigDecimal bigDecimal) {
        i.q2.t.i0.f(bigDecimal, "$this$dec");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        i.q2.t.i0.a((Object) bigDecimalSubtract, "this.subtract(BigDecimal.ONE)");
        return bigDecimalSubtract;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal b(@j.c.a.d BigDecimal bigDecimal) {
        i.q2.t.i0.f(bigDecimal, "$this$inc");
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        i.q2.t.i0.a((Object) bigDecimalAdd, "this.add(BigDecimal.ONE)");
        return bigDecimalAdd;
    }

    @i.m2.f
    private static final BigDecimal c(@j.c.a.d BigDecimal bigDecimal) {
        i.q2.t.i0.f(bigDecimal, "$this$unaryMinus");
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        i.q2.t.i0.a((Object) bigDecimalNegate, "this.negate()");
        return bigDecimalNegate;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(int i2) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i2);
        i.q2.t.i0.a((Object) bigDecimalValueOf, "BigDecimal.valueOf(this.toLong())");
        return bigDecimalValueOf;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(long j2) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j2);
        i.q2.t.i0.a((Object) bigDecimalValueOf, "BigDecimal.valueOf(this)");
        return bigDecimalValueOf;
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(long j2, MathContext mathContext) {
        return new BigDecimal(j2, mathContext);
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @t0(version = "1.2")
    @i.m2.f
    private static final BigDecimal a(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }
}
