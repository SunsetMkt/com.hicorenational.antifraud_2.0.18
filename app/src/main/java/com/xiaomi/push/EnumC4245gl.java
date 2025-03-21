package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gl */
/* loaded from: classes2.dex */
public enum EnumC4245gl {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a */
    private final int f15684a;

    EnumC4245gl(int i2) {
        this.f15684a = i2;
    }

    /* renamed from: a */
    public int m15016a() {
        return this.f15684a;
    }

    /* renamed from: a */
    public static EnumC4245gl m15015a(int i2) {
        if (i2 == 1) {
            return MISC_CONFIG;
        }
        if (i2 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
