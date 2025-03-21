package com.huawei.hms.push.ups.entity;

/* loaded from: classes.dex */
public class CodeResult {

    /* renamed from: a */
    private int f7808a;

    /* renamed from: b */
    private String f7809b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f7809b;
    }

    public int getReturnCode() {
        return this.f7808a;
    }

    public void setReason(String str) {
        this.f7809b = str;
    }

    public void setReturnCode(int i2) {
        this.f7808a = i2;
    }

    public CodeResult(int i2) {
        this.f7808a = i2;
    }

    public CodeResult(int i2, String str) {
        this.f7808a = i2;
        this.f7809b = str;
    }
}
