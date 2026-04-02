package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static String a(String str, String str2) {
        try {
            return (String) r.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("SystemProperties.get: " + e2);
            return str2;
        }
    }
}
