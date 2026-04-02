package com.umeng.socialize.tracker.utils;

/* JADX INFO: compiled from: Errors.java */
/* JADX INFO: loaded from: classes2.dex */
public enum a {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(5004),
    UnKnownHostException(5005),
    HttpError(5006),
    EmptyResponse(5007),
    ErrorResponse(5008),
    ErrorMakeRequestBody(5009);


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8395k;

    a(int i2) {
        this.f8395k = i2;
    }

    private String b() {
        return "\u9519\u8bef\u7801\uff1a" + this.f8395k + " \u9519\u8bef\u4fe1\u606f\uff1a";
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--\u672a\u77e5\u9519\u8bef--";
        }
        if (this == Timeout) {
            return b() + "--\u8fde\u63a5\u8d85\u65f6--";
        }
        if (this == NetworkUnavailable) {
            return b() + "--\u7f51\u7edc\u4e0d\u53ef\u7528--";
        }
        if (this == SSLException) {
            return b() + "--SSL\u8bc1\u4e66\u8ba4\u8bc1\u5931\u8d25--";
        }
        if (this == IOException) {
            return b() + "--IO\u5f02\u5e38--";
        }
        if (this == HttpError) {
            return b() + "--\u670d\u52a1\u7aef\u8fd4\u56deHTTP\u9519\u8bef--";
        }
        if (this == EmptyResponse) {
            return b() + "--\u670d\u52a1\u7aef\u8fd4\u56de\u6570\u636e\u4e3a\u7a7a--";
        }
        if (this == ErrorResponse) {
            return b() + "--\u670d\u52a1\u7aef\u8fd4\u56de\u9519\u8bef\u6570\u636e--";
        }
        if (this != ErrorMakeRequestBody) {
            return "unknown";
        }
        return b() + "--\u8bf7\u6c42\u62a5\u6587\u6784\u5efa\u9519\u8bef--";
    }
}
