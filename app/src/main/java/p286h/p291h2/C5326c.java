package p286h.p291h2;

import com.umeng.analytics.pro.C3351bh;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _ComparisonsJvm.kt */
/* renamed from: h.h2.c */
/* loaded from: classes2.dex */
class C5326c extends C5325b {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final byte m21836a(byte b2, byte b3) {
        return (byte) Math.max((int) b2, (int) b3);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: b */
    public static final <T extends Comparable<? super T>> T m21859b(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "a");
        C5544i0.m22546f(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: c */
    public static final <T extends Comparable<? super T>> T m21863c(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "a");
        C5544i0.m22546f(t2, "b");
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final short m21847a(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final byte m21849b(byte b2, byte b3) {
        return (byte) Math.min((int) b2, (int) b3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final int m21842a(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final short m21861b(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final long m21844a(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m21855b(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final float m21840a(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final long m21857b(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final double m21838a(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final float m21853b(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m21846a(@InterfaceC5816d T t, @InterfaceC5816d T t2, @InterfaceC5816d T t3) {
        C5544i0.m22546f(t, "a");
        C5544i0.m22546f(t2, "b");
        C5544i0.m22546f(t3, C3351bh.f11584aI);
        return (T) m21859b(t, m21859b(t2, t3));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final double m21851b(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final byte m21837a(byte b2, byte b3, byte b4) {
        return (byte) Math.max((int) b2, Math.max((int) b3, (int) b4));
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: b */
    public static final <T extends Comparable<? super T>> T m21860b(@InterfaceC5816d T t, @InterfaceC5816d T t2, @InterfaceC5816d T t3) {
        C5544i0.m22546f(t, "a");
        C5544i0.m22546f(t2, "b");
        C5544i0.m22546f(t3, C3351bh.f11584aI);
        return (T) m21863c(t, m21863c(t2, t3));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final short m21848a(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final byte m21850b(byte b2, byte b3, byte b4) {
        return (byte) Math.min((int) b2, Math.min((int) b3, (int) b4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final int m21843a(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final short m21862b(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final long m21845a(long j2, long j3, long j4) {
        return Math.max(j2, Math.max(j3, j4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m21856b(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final float m21841a(float f2, float f3, float f4) {
        return Math.max(f2, Math.max(f3, f4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final long m21858b(long j2, long j3, long j4) {
        return Math.min(j2, Math.min(j3, j4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final double m21839a(double d2, double d3, double d4) {
        return Math.max(d2, Math.max(d3, d4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final float m21854b(float f2, float f3, float f4) {
        return Math.min(f2, Math.min(f3, f4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final double m21852b(double d2, double d3, double d4) {
        return Math.min(d2, Math.min(d3, d4));
    }
}
