package com.huawei.hms.common;

/* loaded from: classes.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);


    /* renamed from: a */
    private final int f7196a;

    HmsCheckedState(int i2) {
        this.f7196a = i2;
    }

    public int getState() {
        return this.f7196a;
    }
}
