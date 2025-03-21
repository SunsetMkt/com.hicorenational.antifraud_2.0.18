package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* loaded from: classes2.dex */
class eq {
    public static void a(am.b bVar, String str, fa faVar) {
        String a2;
        dp.c cVar = new dp.c();
        if (!TextUtils.isEmpty(bVar.f13346c)) {
            cVar.a(bVar.f13346c);
        }
        if (!TextUtils.isEmpty(bVar.f13348e)) {
            cVar.d(bVar.f13348e);
        }
        if (!TextUtils.isEmpty(bVar.f13349f)) {
            cVar.e(bVar.f13349f);
        }
        cVar.b(bVar.f1000a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f13347d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.f13347d);
        }
        er erVar = new er();
        erVar.c(bVar.f1001b);
        erVar.a(Integer.parseInt(bVar.f13350g));
        erVar.b(bVar.f998a);
        erVar.a("BIND", (String) null);
        erVar.a(erVar.e());
        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim]: bind id=" + erVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f13346c);
        hashMap.put("chid", bVar.f13350g);
        hashMap.put("from", bVar.f1001b);
        hashMap.put("id", erVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f1000a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f13348e)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f13348e);
        }
        if (TextUtils.isEmpty(bVar.f13349f)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f13349f);
        }
        if (bVar.f13347d.equals("XIAOMI-PASS") || bVar.f13347d.equals("XMPUSH-PASS")) {
            a2 = az.a(bVar.f13347d, null, hashMap, bVar.f13351h);
        } else {
            bVar.f13347d.equals("XIAOMI-SASL");
            a2 = null;
        }
        cVar.f(a2);
        erVar.a(cVar.m374a(), (String) null);
        faVar.b(erVar);
    }

    public static void a(String str, String str2, fa faVar) {
        er erVar = new er();
        erVar.c(str2);
        erVar.a(Integer.parseInt(str));
        erVar.a("UBND", (String) null);
        faVar.b(erVar);
    }
}
