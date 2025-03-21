package com.alibaba.sdk.android.httpdns;

/* renamed from: com.alibaba.sdk.android.httpdns.h */
/* loaded from: classes.dex */
public class C1521h extends Exception {

    /* renamed from: b */
    private int f3929b;

    public C1521h(int i2, String str) {
        super(str);
        this.f3929b = i2;
    }

    public int getErrorCode() {
        return this.f3929b;
    }
}
