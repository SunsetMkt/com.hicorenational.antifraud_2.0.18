package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gm */
/* loaded from: classes2.dex */
public enum EnumC4246gm {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a */
    private final int f15690a;

    EnumC4246gm(int i2) {
        this.f15690a = i2;
    }

    /* renamed from: a */
    public static EnumC4246gm m15017a(int i2) {
        if (i2 == 1) {
            return INT;
        }
        if (i2 == 2) {
            return LONG;
        }
        if (i2 == 3) {
            return STRING;
        }
        if (i2 != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
