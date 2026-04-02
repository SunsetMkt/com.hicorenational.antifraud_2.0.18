package com.umeng.socialize;

/* JADX INFO: loaded from: classes2.dex */
public class SocializeException extends RuntimeException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f8147b = 1;
    protected int a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8148c;

    public SocializeException(int i2, String str) {
        super(str);
        this.a = 5000;
        this.f8148c = "";
        this.a = i2;
        this.f8148c = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f8148c;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.a = 5000;
        this.f8148c = "";
        this.f8148c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.a = 5000;
        this.f8148c = "";
        this.f8148c = str;
    }
}
