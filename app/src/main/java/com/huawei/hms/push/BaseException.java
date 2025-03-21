package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: classes.dex */
public class BaseException extends Exception {

    /* renamed from: a */
    private final int f7680a;

    /* renamed from: b */
    private final ErrorEnum f7681b;

    public BaseException(int i2) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i2);
        this.f7681b = fromCode;
        this.f7680a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f7680a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f7681b.getMessage();
    }
}
