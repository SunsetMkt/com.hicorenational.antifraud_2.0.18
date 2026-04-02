package com.alibaba.sdk.android.httpdns.d;

import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.h;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a() {
        return 0;
    }

    public static int a(Throwable th) {
        return th instanceof h ? ((h) th).getErrorCode() : th instanceof SocketTimeoutException ? 10001 : 10000;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m18a(Throwable th) {
        return (th == null || TextUtils.isEmpty(th.getMessage())) ? th instanceof SocketTimeoutException ? "time out exception" : "default error" : th.getMessage();
    }
}
