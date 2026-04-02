package i.l2;

import i.m2.f;
import i.t0;

/* JADX INFO: compiled from: bitwiseOperations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @t0(version = "1.1")
    @f
    private static final byte a(byte b2) {
        return (byte) (~b2);
    }

    @t0(version = "1.1")
    @f
    private static final byte a(byte b2, byte b3) {
        return (byte) (b2 & b3);
    }

    @t0(version = "1.1")
    @f
    private static final short a(short s) {
        return (short) (~s);
    }

    @t0(version = "1.1")
    @f
    private static final short a(short s, short s2) {
        return (short) (s & s2);
    }

    @t0(version = "1.1")
    @f
    private static final byte b(byte b2, byte b3) {
        return (byte) (b2 | b3);
    }

    @t0(version = "1.1")
    @f
    private static final short b(short s, short s2) {
        return (short) (s | s2);
    }

    @t0(version = "1.1")
    @f
    private static final byte c(byte b2, byte b3) {
        return (byte) (b2 ^ b3);
    }

    @t0(version = "1.1")
    @f
    private static final short c(short s, short s2) {
        return (short) (s ^ s2);
    }
}
