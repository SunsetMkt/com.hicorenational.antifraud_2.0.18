package p286h;

import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;

/* compiled from: UNumbers.kt */
@InterfaceC5481e(name = "UNumbersKt")
/* renamed from: h.s1 */
/* loaded from: classes2.dex */
public final class C5606s1 {
    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m22838a(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final int m22846b(int i2) {
        return Integer.bitCount(i2);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    private static final int m22853c(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: d */
    private static final int m22857d(int i2) {
        return C5341j1.m21929c(Integer.highestOneBit(i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: e */
    private static final int m22861e(int i2) {
        return C5341j1.m21929c(Integer.lowestOneBit(i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m22839a(int i2, int i3) {
        return C5341j1.m21929c(Integer.rotateLeft(i2, i3));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final int m22847b(int i2, int i3) {
        return C5341j1.m21929c(Integer.rotateRight(i2, i3));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    private static final int m22854c(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: d */
    private static final long m22858d(long j2) {
        return C5441n1.m22205c(Long.highestOneBit(j2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: e */
    private static final long m22862e(long j2) {
        return C5441n1.m22205c(Long.lowestOneBit(j2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m22840a(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final int m22848b(long j2) {
        return Long.bitCount(j2);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    private static final int m22852c(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: d */
    private static final byte m22856d(byte b2) {
        return C5230f1.m18929c((byte) Integer.highestOneBit(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: e */
    private static final byte m22860e(byte b2) {
        return C5230f1.m18929c((byte) Integer.lowestOneBit(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final long m22842a(long j2, int i2) {
        return C5441n1.m22205c(Long.rotateLeft(j2, i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final long m22850b(long j2, int i2) {
        return C5441n1.m22205c(Long.rotateRight(j2, i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    private static final int m22855c(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: d */
    private static final short m22859d(short s) {
        return C5611t1.m22880c((short) Integer.highestOneBit(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: e */
    private static final short m22863e(short s) {
        return C5611t1.m22880c((short) Integer.lowestOneBit(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m22837a(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & C5230f1.f20085c) - 24;
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final int m22845b(byte b2) {
        return Integer.bitCount(C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final byte m22836a(byte b2, int i2) {
        return C5230f1.m18929c(C5229f0.m18903a(b2, i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final byte m22844b(byte b2, int i2) {
        return C5230f1.m18929c(C5229f0.m18907b(b2, i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m22841a(short s) {
        return Integer.numberOfLeadingZeros(s & C5611t1.f20467c) - 16;
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final int m22849b(short s) {
        return Integer.bitCount(C5341j1.m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final short m22843a(short s, int i2) {
        return C5611t1.m22880c(C5229f0.m18906a(s, i2));
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final short m22851b(short s, int i2) {
        return C5611t1.m22880c(C5229f0.m18910b(s, i2));
    }
}
