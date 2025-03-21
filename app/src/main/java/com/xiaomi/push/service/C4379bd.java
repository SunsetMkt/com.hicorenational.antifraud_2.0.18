package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4310s;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.bd */
/* loaded from: classes2.dex */
public class C4379bd implements XMPushService.InterfaceC4341n {

    /* renamed from: a */
    private static Context f16691a;

    /* renamed from: a */
    private static final boolean f16693a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a */
    private static final Map<Integer, Map<String, List<String>>> f16692a = new HashMap();

    public C4379bd(Context context) {
        f16691a = context;
    }

    /* renamed from: b */
    private static void m16073b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f16692a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(Constants.COLON_SEPARATOR);
                        List list = (List) map.get(str);
                        if (!C4310s.m15728a(list)) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                if (i2 != 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append((String) list.get(i2));
                            }
                        }
                        sb.append(";");
                    }
                    C4265he m16071a = m16071a(null, C4358aj.m15941a(), EnumC4249gp.NotificationRemoved.f15769a, null);
                    m16071a.m15309a("removed_reason", String.valueOf(num));
                    m16071a.m15309a("all_delete_msgId_appId", sb.toString());
                    AbstractC4022b.m13356b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    m16072a(f16691a, m16071a);
                }
                f16692a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.InterfaceC4341n
    /* renamed from: a */
    public void mo14950a() {
        if (f16692a.size() > 0) {
            synchronized (f16692a) {
                m16073b();
            }
        }
    }

    /* renamed from: a */
    private static void m16072a(Context context, final C4265he c4265he) {
        if (f16693a) {
            AbstractC4022b.m13356b("UNDatas upload message notification:" + c4265he);
        }
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] m15567a = C4276hp.m15567a(C4401w.m16276a(C4265he.this.m15323d(), C4265he.this.m15315b(), C4265he.this, EnumC4239gf.Notification));
                if (C4379bd.f16691a instanceof XMPushService) {
                    ((XMPushService) C4379bd.f16691a).m15802a(C4265he.this.m15323d(), m15567a, true);
                } else {
                    AbstractC4022b.m13347a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    /* renamed from: a */
    private static C4265he m16071a(String str, String str2, String str3, String str4) {
        C4265he c4265he = new C4265he();
        if (str3 != null) {
            c4265he.m15318c(str3);
        }
        if (str != null) {
            c4265he.m15314b(str);
        }
        if (str2 != null) {
            c4265he.m15301a(str2);
        }
        if (str4 != null) {
            c4265he.m15322d(str4);
        }
        c4265he.m15304a(false);
        return c4265he;
    }
}
