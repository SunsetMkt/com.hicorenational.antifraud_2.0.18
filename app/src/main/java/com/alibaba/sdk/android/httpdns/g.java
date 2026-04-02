package com.alibaba.sdk.android.httpdns;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2575b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2576e;

    g(int i2, String str) {
        this.f2575b = i2;
        this.f2576e = new JSONObject(str).getString("code");
    }

    public String b() {
        return this.f2576e;
    }

    public int getErrorCode() {
        return this.f2575b;
    }
}
