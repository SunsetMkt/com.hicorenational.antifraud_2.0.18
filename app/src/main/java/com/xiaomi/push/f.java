package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    static final int a = a(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f8960b = a(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f8961c = a(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f8962d = a(3, 2);

    static int a(int i2) {
        return i2 & 7;
    }

    static int a(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public static int b(int i2) {
        return i2 >>> 3;
    }
}
