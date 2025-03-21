package com.alibaba.sdk.android.httpdns;

import org.json.JSONObject;

/* renamed from: com.alibaba.sdk.android.httpdns.g */
/* loaded from: classes.dex */
class C1520g {

    /* renamed from: b */
    private int f3927b;

    /* renamed from: e */
    private String f3928e;

    C1520g(int i2, String str) {
        this.f3927b = i2;
        this.f3928e = new JSONObject(str).getString("code");
    }

    /* renamed from: b */
    public String m3522b() {
        return this.f3928e;
    }

    public int getErrorCode() {
        return this.f3927b;
    }
}
