package p286h;

import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5588w;
import p286h.p309q2.p311t.C5594z;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: NumbersJVM.kt */
/* renamed from: h.e0 */
/* loaded from: classes2.dex */
class C5225e0 extends C5221d0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final boolean m18881a(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final boolean m18887b(double d2) {
        return Double.isInfinite(d2);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final boolean m18891c(double d2) {
        return Double.isNaN(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    private static final long m18895d(double d2) {
        return Double.doubleToLongBits(d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    private static final long m18899e(double d2) {
        return Double.doubleToRawLongBits(d2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final boolean m18882a(float f2) {
        return (Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final boolean m18888b(float f2) {
        return Float.isInfinite(f2);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final boolean m18892c(float f2) {
        return Float.isNaN(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: d */
    private static final int m18893d(float f2) {
        return Float.floatToIntBits(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: e */
    private static final int m18897e(float f2) {
        return Float.floatToRawIntBits(f2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final double m18875a(@InterfaceC5816d C5588w c5588w, long j2) {
        return Double.longBitsToDouble(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final int m18883b(int i2) {
        return Integer.bitCount(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: c */
    private static final int m18889c(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: d */
    private static final int m18894d(int i2) {
        return Integer.highestOneBit(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: e */
    private static final int m18898e(int i2) {
        return Integer.lowestOneBit(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final float m18876a(@InterfaceC5816d C5594z c5594z, int i2) {
        return Float.intBitsToFloat(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final int m18884b(int i2, int i3) {
        return Integer.rotateRight(i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: c */
    private static final int m18890c(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: d */
    private static final long m18896d(long j2) {
        return Long.highestOneBit(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: e */
    private static final long m18900e(long j2) {
        return Long.lowestOneBit(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final int m18877a(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final int m18885b(long j2) {
        return Long.bitCount(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final int m18878a(int i2, int i3) {
        return Integer.rotateLeft(i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final long m18886b(long j2, int i2) {
        return Long.rotateRight(j2, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final int m18879a(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final long m18880a(long j2, int i2) {
        return Long.rotateLeft(j2, i2);
    }
}
