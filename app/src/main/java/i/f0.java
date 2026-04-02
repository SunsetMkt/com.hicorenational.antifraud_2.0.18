package i;

/* JADX INFO: compiled from: Numbers.kt */
/* JADX INFO: loaded from: classes2.dex */
class f0 extends e0 {
    @j
    @t0(version = "1.3")
    public static final byte a(byte b2, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b2 & 255) >>> (8 - i3)) | (b2 << i3));
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final int a(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & f1.f12066c) - 24;
    }

    @j
    @t0(version = "1.3")
    public static final short a(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> (16 - i3)) | (s << i3));
    }

    @j
    @t0(version = "1.3")
    public static final byte b(byte b2, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b2 & 255) >>> i3) | (b2 << (8 - i3)));
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final int b(byte b2) {
        return Integer.bitCount(b2 & f1.f12066c);
    }

    @j
    @t0(version = "1.3")
    public static final short b(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> i3) | (s << (16 - i3)));
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final int c(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final byte d(byte b2) {
        return (byte) Integer.highestOneBit(b2 & f1.f12066c);
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final byte e(byte b2) {
        return (byte) Integer.lowestOneBit(b2);
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final int a(short s) {
        return Integer.numberOfLeadingZeros(s & t1.f12275c) - 16;
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final int b(short s) {
        return Integer.bitCount(s & t1.f12275c);
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final int c(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final short d(short s) {
        return (short) Integer.highestOneBit(s & t1.f12275c);
    }

    @j
    @t0(version = "1.3")
    @i.m2.f
    private static final short e(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
