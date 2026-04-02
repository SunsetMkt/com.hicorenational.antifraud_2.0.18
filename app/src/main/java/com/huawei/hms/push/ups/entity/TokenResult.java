package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: classes.dex */
public class TokenResult extends CodeResult {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4910c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f4910c;
    }

    public void setToken(String str) {
        this.f4910c = str;
    }

    public TokenResult(int i2) {
        super(i2);
    }

    public TokenResult(int i2, String str) {
        super(i2, str);
    }

    public TokenResult(String str) {
        this.f4910c = str;
    }
}
