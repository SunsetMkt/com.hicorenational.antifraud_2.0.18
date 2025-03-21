package com.alibaba.sdk.android.httpdns.p114d;

import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.C1521h;
import java.net.SocketTimeoutException;

/* renamed from: com.alibaba.sdk.android.httpdns.d.c */
/* loaded from: classes.dex */
public class C1516c {
    /* renamed from: a */
    public static int m3506a() {
        return 0;
    }

    /* renamed from: a */
    public static int m3507a(Throwable th) {
        return th instanceof C1521h ? ((C1521h) th).getErrorCode() : th instanceof SocketTimeoutException ? 10001 : 10000;
    }

    /* renamed from: a */
    public static String m3508a(Throwable th) {
        return (th == null || TextUtils.isEmpty(th.getMessage())) ? th instanceof SocketTimeoutException ? "time out exception" : "default error" : th.getMessage();
    }
}
