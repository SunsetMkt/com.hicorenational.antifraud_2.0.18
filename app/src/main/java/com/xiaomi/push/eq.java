package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
class eq {
    public static void a(am.b bVar, String str, fa faVar) {
        String strA;
        dp.c cVar = new dp.c();
        if (!TextUtils.isEmpty(bVar.f9358c)) {
            cVar.a(bVar.f9358c);
        }
        if (!TextUtils.isEmpty(bVar.f9360e)) {
            cVar.d(bVar.f9360e);
        }
        if (!TextUtils.isEmpty(bVar.f9361f)) {
            cVar.e(bVar.f9361f);
        }
        cVar.b(bVar.f1000a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f9359d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.f9359d);
        }
        er erVar = new er();
        erVar.c(bVar.f1001b);
        erVar.a(Integer.parseInt(bVar.f9362g));
        erVar.b(bVar.f998a);
        erVar.a("BIND", (String) null);
        erVar.a(erVar.e());
        com.xiaomi.channel.commonutils.logger.b.m48a("[Slim]: bind id=" + erVar.e());
        HashMap map = new HashMap();
        map.put("challenge", str);
        map.put("token", bVar.f9358c);
        map.put("chid", bVar.f9362g);
        map.put("from", bVar.f1001b);
        map.put("id", erVar.e());
        map.put("to", "xiaomi.com");
        if (bVar.f1000a) {
            map.put("kick", "1");
        } else {
            map.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f9360e)) {
            map.put("client_attrs", "");
        } else {
            map.put("client_attrs", bVar.f9360e);
        }
        if (TextUtils.isEmpty(bVar.f9361f)) {
            map.put("cloud_attrs", "");
        } else {
            map.put("cloud_attrs", bVar.f9361f);
        }
        if (bVar.f9359d.equals("XIAOMI-PASS") || bVar.f9359d.equals("XMPUSH-PASS")) {
            strA = az.a(bVar.f9359d, null, map, bVar.f9363h);
        } else {
            bVar.f9359d.equals("XIAOMI-SASL");
            strA = null;
        }
        cVar.f(strA);
        erVar.a(cVar.m372a(), (String) null);
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
