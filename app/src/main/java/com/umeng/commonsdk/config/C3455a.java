package com.umeng.commonsdk.config;

/* compiled from: BitUtils.java */
/* renamed from: com.umeng.commonsdk.config.a */
/* loaded from: classes2.dex */
public class C3455a {
    /* renamed from: a */
    public static boolean m11534a(int i2, int i3) {
        return i3 >= 0 && i3 <= 31 && (i2 & (1 << i3)) != 0;
    }

    /* renamed from: a */
    public static boolean m11535a(long j2, int i2) {
        return i2 >= 0 && i2 <= 63 && (j2 & (1 << i2)) != 0;
    }

    /* renamed from: b */
    public static int m11536b(int i2, int i3) {
        return i2 | (1 << i3);
    }

    /* renamed from: b */
    public static long m11537b(long j2, int i2) {
        return (i2 < 0 || i2 > 63) ? j2 : j2 | (1 << i2);
    }

    /* renamed from: c */
    public static int m11538c(int i2, int i3) {
        return i2 & (~(1 << i3));
    }

    /* renamed from: c */
    public static long m11539c(long j2, int i2) {
        return (i2 < 0 || i2 > 63) ? j2 : j2 & (~(1 << i2));
    }
}
