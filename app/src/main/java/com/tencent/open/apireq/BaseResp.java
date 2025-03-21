package com.tencent.open.apireq;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* renamed from: a */
    private int f11159a = 0;

    /* renamed from: b */
    private String f11160b = "";

    /* renamed from: a */
    protected String m10428a(int i2) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.f11159a;
    }

    public String getErrorMsg() {
        return this.f11160b;
    }

    public boolean isSuccess() {
        return this.f11159a == 0;
    }

    public void setCode(int i2) {
        String str;
        this.f11159a = i2;
        if (i2 == -2001) {
            str = "Not login.";
        } else if (i2 == -2000) {
            str = "The given params check failed.";
        } else if (i2 != 0) {
            switch (i2) {
                case CODE_UNSUPPORTED_BRANCH /* -1002 */:
                    str = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case CODE_QQ_LOW_VERSION /* -1001 */:
                    str = "QQ version is too low.";
                    break;
                case -1000:
                    str = "QQ is not installed.";
                    break;
                default:
                    str = m10428a(i2);
                    break;
            }
        } else {
            str = "";
        }
        setErrorMsg(str);
    }

    public void setErrorMsg(String str) {
        this.f11160b = str;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.f11159a + ", mErrorMsg='" + this.f11160b + "'}";
    }
}
