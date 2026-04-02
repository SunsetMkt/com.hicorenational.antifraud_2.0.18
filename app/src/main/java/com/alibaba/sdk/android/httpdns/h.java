package com.alibaba.sdk.android.httpdns;

/* JADX INFO: loaded from: classes.dex */
public class h extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2577b;

    public h(int i2, String str) {
        super(str);
        this.f2577b = i2;
    }

    public int getErrorCode() {
        return this.f2577b;
    }
}
