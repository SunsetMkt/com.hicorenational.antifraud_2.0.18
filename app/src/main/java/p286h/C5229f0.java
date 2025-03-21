package p286h;

import p286h.p304m2.InterfaceC5426f;

/* compiled from: Numbers.kt */
/* renamed from: h.f0 */
/* loaded from: classes2.dex */
class C5229f0 extends C5225e0 {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    public static final byte m18903a(byte b2, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b2 & 255) >>> (8 - i3)) | (b2 << i3));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final int m18904a(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & C5230f1.f20085c) - 24;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    public static final short m18906a(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> (16 - i3)) | (s << i3));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    public static final byte m18907b(byte b2, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b2 & 255) >>> i3) | (b2 << (8 - i3)));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final int m18908b(byte b2) {
        return Integer.bitCount(b2 & C5230f1.f20085c);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    public static final short m18910b(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> i3) | (s << (16 - i3)));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: c */
    private static final int m18911c(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: d */
    private static final byte m18913d(byte b2) {
        return (byte) Integer.highestOneBit(b2 & C5230f1.f20085c);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: e */
    private static final byte m18915e(byte b2) {
        return (byte) Integer.lowestOneBit(b2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final int m18905a(short s) {
        return Integer.numberOfLeadingZeros(s & C5611t1.f20467c) - 16;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final int m18909b(short s) {
        return Integer.bitCount(s & C5611t1.f20467c);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: c */
    private static final int m18912c(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: d */
    private static final short m18914d(short s) {
        return (short) Integer.highestOneBit(s & C5611t1.f20467c);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: e */
    private static final short m18916e(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
