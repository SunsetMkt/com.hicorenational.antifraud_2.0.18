package com.umeng.analytics.pro;

import p286h.C5230f1;

/* compiled from: EncodingUtils.java */
/* renamed from: com.umeng.analytics.pro.bn */
/* loaded from: classes2.dex */
public class C3357bn {
    /* renamed from: a */
    public static final void m11015a(int i2, byte[] bArr) {
        m11016a(i2, bArr, 0);
    }

    /* renamed from: a */
    public static final boolean m11018a(int i2, int i3) {
        return (i2 & (1 << i3)) != 0;
    }

    /* renamed from: a */
    public static final boolean m11019a(long j2, int i2) {
        return (j2 & (1 << i2)) != 0;
    }

    /* renamed from: b */
    public static final byte m11021b(byte b2, int i2) {
        return (byte) m11022b((int) b2, i2);
    }

    /* renamed from: b */
    public static final int m11022b(int i2, int i3) {
        return i2 & (~(1 << i3));
    }

    /* renamed from: b */
    public static final long m11023b(long j2, int i2) {
        return j2 & (~(1 << i2));
    }

    /* renamed from: a */
    public static final void m11016a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
    }

    /* renamed from: b */
    public static final short m11024b(short s, int i2) {
        return (short) m11022b((int) s, i2);
    }

    /* renamed from: a */
    public static final int m11011a(byte[] bArr) {
        return m11012a(bArr, 0);
    }

    /* renamed from: a */
    public static final int m11012a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 24) | ((bArr[i2 + 1] & C5230f1.f20085c) << 16) | ((bArr[i2 + 2] & C5230f1.f20085c) << 8);
    }

    /* renamed from: a */
    public static final boolean m11017a(byte b2, int i2) {
        return m11018a((int) b2, i2);
    }

    /* renamed from: a */
    public static final boolean m11020a(short s, int i2) {
        return m11018a((int) s, i2);
    }

    /* renamed from: a */
    public static final byte m11009a(byte b2, int i2, boolean z) {
        return (byte) m11010a((int) b2, i2, z);
    }

    /* renamed from: a */
    public static final short m11014a(short s, int i2, boolean z) {
        return (short) m11010a((int) s, i2, z);
    }

    /* renamed from: a */
    public static final int m11010a(int i2, int i3, boolean z) {
        return z ? i2 | (1 << i3) : m11022b(i2, i3);
    }

    /* renamed from: a */
    public static final long m11013a(long j2, int i2, boolean z) {
        return z ? j2 | (1 << i2) : m11023b(j2, i2);
    }
}
