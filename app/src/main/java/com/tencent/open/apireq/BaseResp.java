package com.tencent.open.apireq;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;
    private int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6812b = "";

    protected String a(int i2) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.f6812b;
    }

    public boolean isSuccess() {
        return this.a == 0;
    }

    public void setCode(int i2) {
        String strA;
        this.a = i2;
        if (i2 == -2001) {
            strA = "Not login.";
        } else if (i2 == -2000) {
            strA = "The given params check failed.";
        } else if (i2 != 0) {
            switch (i2) {
                case CODE_UNSUPPORTED_BRANCH /* -1002 */:
                    strA = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case CODE_QQ_LOW_VERSION /* -1001 */:
                    strA = "QQ version is too low.";
                    break;
                case -1000:
                    strA = "QQ is not installed.";
                    break;
                default:
                    strA = a(i2);
                    break;
            }
        } else {
            strA = "";
        }
        setErrorMsg(strA);
    }

    public void setErrorMsg(String str) {
        this.f6812b = str;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.a + ", mErrorMsg='" + this.f6812b + "'}";
    }
}
