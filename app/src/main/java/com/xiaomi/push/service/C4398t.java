package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.C4310s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.t */
/* loaded from: classes2.dex */
public class C4398t {

    /* renamed from: a */
    private static final Map<String, byte[]> f16777a = new HashMap();

    /* renamed from: a */
    private static ArrayList<Pair<String, byte[]>> f16776a = new ArrayList<>();

    /* renamed from: a */
    public static void m16231a(String str, byte[] bArr) {
        synchronized (f16777a) {
            AbstractC4022b.m13347a("pending registration request. " + str);
            f16777a.put(str, bArr);
        }
    }

    /* renamed from: b */
    public static void m16232b(String str, byte[] bArr) {
        synchronized (f16776a) {
            f16776a.add(new Pair<>(str, bArr));
            if (f16776a.size() > 50) {
                f16776a.remove(0);
            }
        }
    }

    /* renamed from: a */
    public static void m16230a(XMPushService xMPushService, boolean z) {
        try {
            synchronized (f16777a) {
                for (String str : f16777a.keySet()) {
                    AbstractC4022b.m13347a("processing pending registration request. " + str);
                    C4401w.m16284a(xMPushService, str, f16777a.get(str));
                    if (z && !C4310s.m15727a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f16777a.clear();
            }
        } catch (C4215fi e2) {
            AbstractC4022b.m13361d("fail to deal with pending register request. " + e2);
            xMPushService.m15795a(10, e2);
        }
    }

    /* renamed from: a */
    public static void m16227a(Context context, int i2, String str) {
        synchronized (f16777a) {
            for (String str2 : f16777a.keySet()) {
                AbstractC4022b.m13347a("notify registration error. " + str2);
                m16228a(context, str2, f16777a.get(str2), i2, str);
            }
            f16777a.clear();
        }
    }

    /* renamed from: a */
    public static void m16229a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f16776a) {
                arrayList = f16776a;
                f16776a = new ArrayList<>();
            }
            boolean m15727a = C4310s.m15727a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                C4401w.m16284a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!m15727a) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (C4215fi e2) {
            AbstractC4022b.m13361d("meet error when process pending message. " + e2);
            xMPushService.m15795a(10, e2);
        }
    }

    /* renamed from: a */
    public static void m16228a(Context context, String str, byte[] bArr, int i2, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i2);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C4401w.m16279a(str));
    }
}
