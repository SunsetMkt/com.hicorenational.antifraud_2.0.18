package com.alibaba.sdk.android.httpdns.p112b;

import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* renamed from: com.alibaba.sdk.android.httpdns.b.c */
/* loaded from: classes.dex */
public class C1506c {

    /* renamed from: a */
    private static final SimpleDateFormat f3854a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a */
    public static long m3443a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: c */
    static String m3444c(String str) {
        try {
            return f3854a.format(Long.valueOf(m3443a(str) * 1000));
        } catch (Exception unused) {
            return f3854a.format(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: d */
    static String m3445d(String str) {
        try {
            return String.valueOf(f3854a.parse(str).getTime() / 1000);
        } catch (Exception unused) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
    }
}
