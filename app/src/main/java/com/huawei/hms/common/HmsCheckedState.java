package com.huawei.hms.common;

/* JADX INFO: loaded from: classes.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);

    private final int a;

    HmsCheckedState(int i2) {
        this.a = i2;
    }

    public int getState() {
        return this.a;
    }
}
