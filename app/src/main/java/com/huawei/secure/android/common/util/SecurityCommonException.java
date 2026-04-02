package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes.dex */
public class SecurityCommonException extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f5243c = 1;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5244b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f5244b;
    }

    public String getRetCd() {
        return this.a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f5244b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.a = str;
        this.f5244b = str2;
    }
}
