package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: classes.dex */
public class BaseException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f7150a;

    /* renamed from: b, reason: collision with root package name */
    private final ErrorEnum f7151b;

    public BaseException(int i2) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i2);
        this.f7151b = fromCode;
        this.f7150a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f7150a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f7151b.getMessage();
    }
}
