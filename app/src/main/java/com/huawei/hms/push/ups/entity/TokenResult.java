package com.huawei.hms.push.ups.entity;

/* loaded from: classes.dex */
public class TokenResult extends CodeResult {

    /* renamed from: c */
    private String f7810c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f7810c;
    }

    public void setToken(String str) {
        this.f7810c = str;
    }

    public TokenResult(int i2) {
        super(i2);
    }

    public TokenResult(int i2, String str) {
        super(i2, str);
    }

    public TokenResult(String str) {
        this.f7810c = str;
    }
}
