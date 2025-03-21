package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gt */
/* loaded from: classes2.dex */
public enum EnumC4253gt {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a */
    private final int f15856a;

    EnumC4253gt(int i2) {
        this.f15856a = i2;
    }

    /* renamed from: a */
    public int m15133a() {
        return this.f15856a;
    }

    /* renamed from: a */
    public static EnumC4253gt m15132a(int i2) {
        if (i2 == 0) {
            return RegIdExpired;
        }
        if (i2 == 1) {
            return PackageUnregistered;
        }
        if (i2 != 2) {
            return null;
        }
        return Init;
    }
}
