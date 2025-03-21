package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.InterfaceC3364bu;

/* loaded from: classes2.dex */
public enum Gender implements InterfaceC3364bu {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);

    private final int value;

    Gender(int i2) {
        this.value = i2;
    }

    public static Gender findByValue(int i2) {
        if (i2 == 0) {
            return MALE;
        }
        if (i2 == 1) {
            return FEMALE;
        }
        if (i2 != 2) {
            return null;
        }
        return UNKNOWN;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3364bu
    public int getValue() {
        return this.value;
    }
}
