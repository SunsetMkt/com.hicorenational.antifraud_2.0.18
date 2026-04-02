package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: classes.dex */
public class CodeResult {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4909b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f4909b;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReason(String str) {
        this.f4909b = str;
    }

    public void setReturnCode(int i2) {
        this.a = i2;
    }

    public CodeResult(int i2) {
        this.a = i2;
    }

    public CodeResult(int i2, String str) {
        this.a = i2;
        this.f4909b = str;
    }
}
