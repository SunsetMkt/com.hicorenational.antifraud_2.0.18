package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.fi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a */
    private static final Map<String, byte[]> f1074a = new HashMap();
    private static ArrayList<Pair<String, byte[]>> a = new ArrayList<>();

    public static void a(String str, byte[] bArr) {
        synchronized (f1074a) {
            com.xiaomi.channel.commonutils.logger.b.m48a("pending registration request. " + str);
            f1074a.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (a) {
            a.add(new Pair<>(str, bArr));
            if (a.size() > 50) {
                a.remove(0);
            }
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            synchronized (f1074a) {
                for (String str : f1074a.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("processing pending registration request. " + str);
                    w.a(xMPushService, str, f1074a.get(str));
                    if (z && !com.xiaomi.push.s.a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f1074a.clear();
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(Context context, int i2, String str) {
        synchronized (f1074a) {
            for (String str2 : f1074a.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.m48a("notify registration error. " + str2);
                a(context, str2, f1074a.get(str2), i2, str);
            }
            f1074a.clear();
        }
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            boolean zA = com.xiaomi.push.s.a();
            for (Pair<String, byte[]> pair : arrayList) {
                w.a(xMPushService, (String) pair.first, (byte[]) pair.second);
                if (!zA) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i2, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i2);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.a(str));
    }
}
