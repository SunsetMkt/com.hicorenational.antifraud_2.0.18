package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.service.C4361am;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.eq */
/* loaded from: classes2.dex */
class C4196eq {
    /* renamed from: a */
    public static void m14678a(C4361am.b bVar, String str, AbstractC4207fa abstractC4207fa) {
        String m13847a;
        C4168dp.c cVar = new C4168dp.c();
        if (!TextUtils.isEmpty(bVar.f16559c)) {
            cVar.m14386a(bVar.f16559c);
        }
        if (!TextUtils.isEmpty(bVar.f16561e)) {
            cVar.m14395d(bVar.f16561e);
        }
        if (!TextUtils.isEmpty(bVar.f16562f)) {
            cVar.m14398e(bVar.f16562f);
        }
        cVar.m14389b(bVar.f16555a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f16560d)) {
            cVar.m14392c("XIAOMI-SASL");
        } else {
            cVar.m14392c(bVar.f16560d);
        }
        C4197er c4197er = new C4197er();
        c4197er.m14708c(bVar.f16557b);
        c4197er.m14688a(Integer.parseInt(bVar.f16563g));
        c4197er.m14702b(bVar.f16553a);
        c4197er.m14692a("BIND", (String) null);
        c4197er.m14691a(c4197er.m14709e());
        AbstractC4022b.m13347a("[Slim]: bind id=" + c4197er.m14709e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f16559c);
        hashMap.put("chid", bVar.f16563g);
        hashMap.put("from", bVar.f16557b);
        hashMap.put("id", c4197er.m14709e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f16555a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f16561e)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f16561e);
        }
        if (TextUtils.isEmpty(bVar.f16562f)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f16562f);
        }
        if (bVar.f16560d.equals("XIAOMI-PASS") || bVar.f16560d.equals("XMPUSH-PASS")) {
            m13847a = C4097az.m13847a(bVar.f16560d, null, hashMap, bVar.f16564h);
        } else {
            bVar.f16560d.equals("XIAOMI-SASL");
            m13847a = null;
        }
        cVar.m14401f(m13847a);
        c4197er.m14694a(cVar.m14590a(), (String) null);
        abstractC4207fa.mo14748b(c4197er);
    }

    /* renamed from: a */
    public static void m14679a(String str, String str2, AbstractC4207fa abstractC4207fa) {
        C4197er c4197er = new C4197er();
        c4197er.m14708c(str2);
        c4197er.m14688a(Integer.parseInt(str));
        c4197er.m14692a("UBND", (String) null);
        abstractC4207fa.mo14748b(c4197er);
    }
}
