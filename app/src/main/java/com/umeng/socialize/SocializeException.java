package com.umeng.socialize;

/* loaded from: classes2.dex */
public class SocializeException extends RuntimeException {

    /* renamed from: b */
    private static final long f13445b = 1;

    /* renamed from: a */
    protected int f13446a;

    /* renamed from: c */
    private String f13447c;

    public SocializeException(int i2, String str) {
        super(str);
        this.f13446a = 5000;
        this.f13447c = "";
        this.f13446a = i2;
        this.f13447c = str;
    }

    public int getErrorCode() {
        return this.f13446a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f13447c;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.f13446a = 5000;
        this.f13447c = "";
        this.f13447c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.f13446a = 5000;
        this.f13447c = "";
        this.f13447c = str;
    }
}
