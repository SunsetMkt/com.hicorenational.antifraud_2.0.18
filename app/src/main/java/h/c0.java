package h;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* compiled from: BigDecimals.kt */
/* loaded from: classes2.dex */
class c0 {
    @h.m2.f
    private static final BigDecimal a(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$div");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        h.q2.t.i0.a((Object) divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @h.m2.f
    private static final BigDecimal b(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$minus");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        h.q2.t.i0.a((Object) subtract, "this.subtract(other)");
        return subtract;
    }

    @h.m2.f
    @c(level = d.ERROR, message = "Use rem(other) instead", replaceWith = @o0(expression = "rem(other)", imports = {}))
    private static final BigDecimal c(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$mod");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        h.q2.t.i0.a((Object) remainder, "this.remainder(other)");
        return remainder;
    }

    @h.m2.f
    private static final BigDecimal d(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$plus");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        h.q2.t.i0.a((Object) add, "this.add(other)");
        return add;
    }

    @h.m2.f
    private static final BigDecimal e(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$rem");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        h.q2.t.i0.a((Object) remainder, "this.remainder(other)");
        return remainder;
    }

    @h.m2.f
    private static final BigDecimal f(@i.c.a.d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        h.q2.t.i0.f(bigDecimal, "$this$times");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        h.q2.t.i0.a((Object) multiply, "this.multiply(other)");
        return multiply;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(@i.c.a.d BigDecimal bigDecimal) {
        h.q2.t.i0.f(bigDecimal, "$this$dec");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        h.q2.t.i0.a((Object) subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal b(@i.c.a.d BigDecimal bigDecimal) {
        h.q2.t.i0.f(bigDecimal, "$this$inc");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        h.q2.t.i0.a((Object) add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @h.m2.f
    private static final BigDecimal c(@i.c.a.d BigDecimal bigDecimal) {
        h.q2.t.i0.f(bigDecimal, "$this$unaryMinus");
        BigDecimal negate = bigDecimal.negate();
        h.q2.t.i0.a((Object) negate, "this.negate()");
        return negate;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(int i2) {
        BigDecimal valueOf = BigDecimal.valueOf(i2);
        h.q2.t.i0.a((Object) valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(long j2) {
        BigDecimal valueOf = BigDecimal.valueOf(j2);
        h.q2.t.i0.a((Object) valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(long j2, MathContext mathContext) {
        return new BigDecimal(j2, mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @h.m2.f
    @t0(version = "1.2")
    private static final BigDecimal a(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }
}
