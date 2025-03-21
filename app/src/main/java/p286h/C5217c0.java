package p286h;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: BigDecimals.kt */
/* renamed from: h.c0 */
/* loaded from: classes2.dex */
class C5217c0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final BigDecimal m18830a(@InterfaceC5816d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        C5544i0.m22546f(bigDecimal, "$this$div");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        C5544i0.m22521a((Object) divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final BigDecimal m18832b(@InterfaceC5816d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        C5544i0.m22546f(bigDecimal, "$this$minus");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        C5544i0.m22521a((Object) subtract, "this.subtract(other)");
        return subtract;
    }

    @InterfaceC5426f
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use rem(other) instead", replaceWith = @InterfaceC5467o0(expression = "rem(other)", imports = {}))
    /* renamed from: c */
    private static final BigDecimal m18834c(@InterfaceC5816d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        C5544i0.m22546f(bigDecimal, "$this$mod");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        C5544i0.m22521a((Object) remainder, "this.remainder(other)");
        return remainder;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final BigDecimal m18835d(@InterfaceC5816d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        C5544i0.m22546f(bigDecimal, "$this$plus");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        C5544i0.m22521a((Object) add, "this.add(other)");
        return add;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final BigDecimal m18836e(@InterfaceC5816d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        C5544i0.m22546f(bigDecimal, "$this$rem");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        C5544i0.m22521a((Object) remainder, "this.remainder(other)");
        return remainder;
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final BigDecimal m18837f(@InterfaceC5816d BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        C5544i0.m22546f(bigDecimal, "$this$times");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        C5544i0.m22521a((Object) multiply, "this.multiply(other)");
        return multiply;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18829a(@InterfaceC5816d BigDecimal bigDecimal) {
        C5544i0.m22546f(bigDecimal, "$this$dec");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        C5544i0.m22521a((Object) subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: b */
    private static final BigDecimal m18831b(@InterfaceC5816d BigDecimal bigDecimal) {
        C5544i0.m22546f(bigDecimal, "$this$inc");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        C5544i0.m22521a((Object) add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final BigDecimal m18833c(@InterfaceC5816d BigDecimal bigDecimal) {
        C5544i0.m22546f(bigDecimal, "$this$unaryMinus");
        BigDecimal negate = bigDecimal.negate();
        C5544i0.m22521a((Object) negate, "this.negate()");
        return negate;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18825a(int i2) {
        BigDecimal valueOf = BigDecimal.valueOf(i2);
        C5544i0.m22521a((Object) valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18826a(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18827a(long j2) {
        BigDecimal valueOf = BigDecimal.valueOf(j2);
        C5544i0.m22521a((Object) valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18828a(long j2, MathContext mathContext) {
        return new BigDecimal(j2, mathContext);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18823a(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18824a(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18821a(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final BigDecimal m18822a(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }
}
