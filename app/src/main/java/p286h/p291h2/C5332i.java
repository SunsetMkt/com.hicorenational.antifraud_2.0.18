package p286h.p291h2;

import p286h.C5215b2;
import p286h.C5230f1;
import p286h.C5611t1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UComparisons.kt */
/* renamed from: h.h2.i */
/* loaded from: classes2.dex */
public class C5332i {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static int m21877a(int i2, int i3) {
        return C5215b2.m18812a(i2, i3) >= 0 ? i2 : i3;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static int m21885b(int i2, int i3) {
        return C5215b2.m18812a(i2, i3) <= 0 ? i2 : i3;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static long m21879a(long j2, long j3) {
        return C5215b2.m18813a(j2, j3) >= 0 ? j2 : j3;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static long m21887b(long j2, long j3) {
        return C5215b2.m18813a(j2, j3) <= 0 ? j2 : j3;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final byte m21875a(byte b2, byte b3) {
        return C5544i0.m22512a(b2 & C5230f1.f20085c, b3 & C5230f1.f20085c) >= 0 ? b2 : b3;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final byte m21883b(byte b2, byte b3) {
        return C5544i0.m22512a(b2 & C5230f1.f20085c, b3 & C5230f1.f20085c) <= 0 ? b2 : b3;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final short m21881a(short s, short s2) {
        return C5544i0.m22512a(s & C5611t1.f20467c, 65535 & s2) >= 0 ? s : s2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final short m21889b(short s, short s2) {
        return C5544i0.m22512a(s & C5611t1.f20467c, 65535 & s2) <= 0 ? s : s2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m21878a(int i2, int i3, int i4) {
        int m21877a;
        int m21877a2;
        m21877a = m21877a(i3, i4);
        m21877a2 = m21877a(i2, m21877a);
        return m21877a2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final int m21886b(int i2, int i3, int i4) {
        int m21885b;
        int m21885b2;
        m21885b = m21885b(i3, i4);
        m21885b2 = m21885b(i2, m21885b);
        return m21885b2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final long m21880a(long j2, long j3, long j4) {
        long m21879a;
        long m21879a2;
        m21879a = m21879a(j3, j4);
        m21879a2 = m21879a(j2, m21879a);
        return m21879a2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final long m21888b(long j2, long j3, long j4) {
        long m21887b;
        long m21887b2;
        m21887b = m21887b(j3, j4);
        m21887b2 = m21887b(j2, m21887b);
        return m21887b2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final byte m21876a(byte b2, byte b3, byte b4) {
        return m21875a(b2, m21875a(b3, b4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final byte m21884b(byte b2, byte b3, byte b4) {
        return m21883b(b2, m21883b(b3, b4));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final short m21882a(short s, short s2, short s3) {
        return m21881a(s, m21881a(s2, s3));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final short m21890b(short s, short s2, short s3) {
        return m21889b(s, m21889b(s2, s3));
    }
}
