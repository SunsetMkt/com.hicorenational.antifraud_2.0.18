package com.umeng.message.proguard;

import android.os.SystemClock;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.umeng.message.common.UPLog;

/* renamed from: com.umeng.message.proguard.au */
/* loaded from: classes2.dex */
public final class C3572au {
    /* renamed from: a */
    public static String m12306a(String str, String str2) {
        String str3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            HttpDnsService service2 = HttpDns.getService(C3604x.m12460a(), str);
            service2.setExpiredIPEnabled(true);
            int i2 = 0;
            str3 = null;
            do {
                try {
                    str3 = service2.getIpByHostAsync(str2);
                    if (str3 != null) {
                        break;
                    }
                    Thread.sleep(500L);
                    i2++;
                } catch (Throwable th) {
                    th = th;
                    try {
                        UPLog.m12145i("HttpDns", "host parse error:", th.getMessage());
                        UPLog.m12145i("HttpDns", "host:", str2, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        return str3;
                    } catch (Throwable th2) {
                        UPLog.m12145i("HttpDns", "host:", str2, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        throw th2;
                    }
                }
            } while (i2 < 5);
            UPLog.m12145i("HttpDns", "host:", str2, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        } catch (Throwable th3) {
            th = th3;
            str3 = null;
        }
        return str3;
    }
}
