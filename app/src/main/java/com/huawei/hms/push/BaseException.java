package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* JADX INFO: loaded from: classes.dex */
public class BaseException extends Exception {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ErrorEnum f4845b;

    public BaseException(int i2) {
        ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(i2);
        this.f4845b = errorEnumFromCode;
        this.a = errorEnumFromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f4845b.getMessage();
    }
}
