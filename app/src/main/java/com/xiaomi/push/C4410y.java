package com.xiaomi.push;

import p286h.C5230f1;

/* renamed from: com.xiaomi.push.y */
/* loaded from: classes2.dex */
public class C4410y {
    /* renamed from: a */
    public static int m16368a(byte[] bArr) {
        if (bArr.length != 4) {
            throw new IllegalArgumentException("the length of bytes must be 4");
        }
        return (bArr[3] & C5230f1.f20085c) | 0 | ((bArr[0] & C5230f1.f20085c) << 24) | ((bArr[1] & C5230f1.f20085c) << 16) | ((bArr[2] & C5230f1.f20085c) << 8);
    }

    /* renamed from: a */
    public static byte[] m16369a(int i2) {
        return new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
    }
}
