package com.huawei.secure.android.common.util;

/* loaded from: classes.dex */
public class SecurityCommonException extends Exception {

    /* renamed from: c */
    private static final long f8285c = 1;

    /* renamed from: a */
    private String f8286a;

    /* renamed from: b */
    private String f8287b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f8287b;
    }

    public String getRetCd() {
        return this.f8286a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f8287b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f8286a = str;
        this.f8287b = str2;
    }
}
