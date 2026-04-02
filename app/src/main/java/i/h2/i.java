package i.h2;

import i.b2;
import i.f1;
import i.k;
import i.q2.t.i0;
import i.t0;
import i.t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _UComparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    @k
    @t0(version = "1.3")
    public static int a(int i2, int i3) {
        return b2.a(i2, i3) >= 0 ? i2 : i3;
    }

    @k
    @t0(version = "1.3")
    public static int b(int i2, int i3) {
        return b2.a(i2, i3) <= 0 ? i2 : i3;
    }

    @k
    @t0(version = "1.3")
    public static long a(long j2, long j3) {
        return b2.a(j2, j3) >= 0 ? j2 : j3;
    }

    @k
    @t0(version = "1.3")
    public static long b(long j2, long j3) {
        return b2.a(j2, j3) <= 0 ? j2 : j3;
    }

    @k
    @t0(version = "1.3")
    public static final byte a(byte b2, byte b3) {
        return i0.a(b2 & f1.f12066c, b3 & f1.f12066c) >= 0 ? b2 : b3;
    }

    @k
    @t0(version = "1.3")
    public static final byte b(byte b2, byte b3) {
        return i0.a(b2 & f1.f12066c, b3 & f1.f12066c) <= 0 ? b2 : b3;
    }

    @k
    @t0(version = "1.3")
    public static final short a(short s, short s2) {
        return i0.a(s & t1.f12275c, 65535 & s2) >= 0 ? s : s2;
    }

    @k
    @t0(version = "1.3")
    public static final short b(short s, short s2) {
        return i0.a(s & t1.f12275c, 65535 & s2) <= 0 ? s : s2;
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final int a(int i2, int i3, int i4) {
        return a(i2, a(i3, i4));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final int b(int i2, int i3, int i4) {
        return b(i2, b(i3, i4));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final long a(long j2, long j3, long j4) {
        return a(j2, a(j3, j4));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final long b(long j2, long j3, long j4) {
        return b(j2, b(j3, j4));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final byte a(byte b2, byte b3, byte b4) {
        return a(b2, a(b3, b4));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final byte b(byte b2, byte b3, byte b4) {
        return b(b2, b(b3, b4));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final short a(short s, short s2, short s3) {
        return a(s, a(s2, s3));
    }

    @k
    @t0(version = "1.3")
    @i.m2.f
    private static final short b(short s, short s2, short s3) {
        return b(s, b(s2, s3));
    }
}
