package com.umeng.socialize.tracker.utils;

/* compiled from: Errors.java */
/* renamed from: com.umeng.socialize.tracker.utils.a */
/* loaded from: classes2.dex */
public enum EnumC3775a {
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


    /* renamed from: k */
    private final int f13804k;

    EnumC3775a(int i2) {
        this.f13804k = i2;
    }

    /* renamed from: b */
    private String m12711b() {
        return "错误码：" + this.f13804k + " 错误信息：";
    }

    /* renamed from: a */
    public String m12712a() {
        if (this == UnKnownCode) {
            return m12711b() + "--未知错误--";
        }
        if (this == Timeout) {
            return m12711b() + "--连接超时--";
        }
        if (this == NetworkUnavailable) {
            return m12711b() + "--网络不可用--";
        }
        if (this == SSLException) {
            return m12711b() + "--SSL证书认证失败--";
        }
        if (this == IOException) {
            return m12711b() + "--IO异常--";
        }
        if (this == HttpError) {
            return m12711b() + "--服务端返回HTTP错误--";
        }
        if (this == EmptyResponse) {
            return m12711b() + "--服务端返回数据为空--";
        }
        if (this == ErrorResponse) {
            return m12711b() + "--服务端返回错误数据--";
        }
        if (this != ErrorMakeRequestBody) {
            return "unknown";
        }
        return m12711b() + "--请求报文构建错误--";
    }
}
