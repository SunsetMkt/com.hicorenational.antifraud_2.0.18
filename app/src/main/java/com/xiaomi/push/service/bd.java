package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class bd implements XMPushService.n {

    /* renamed from: a, reason: collision with root package name */
    private static Context f13414a;

    /* renamed from: a, reason: collision with other field name */
    private static final boolean f1037a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a, reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f1036a = new HashMap();

    public bd(Context context) {
        f13414a = context;
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f1036a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(Constants.COLON_SEPARATOR);
                        List list = (List) map.get(str);
                        if (!com.xiaomi.push.s.a(list)) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                if (i2 != 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append((String) list.get(i2));
                            }
                        }
                        sb.append(";");
                    }
                    he a2 = a(null, aj.a(), gp.NotificationRemoved.f597a, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(f13414a, a2);
                }
                f1036a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo458a() {
        if (f1036a.size() > 0) {
            synchronized (f1036a) {
                b();
            }
        }
    }

    private static void a(Context context, final he heVar) {
        if (f1037a) {
            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:" + heVar);
        }
        com.xiaomi.push.ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] a2 = hp.a(w.a(he.this.d(), he.this.b(), he.this, gf.Notification));
                if (bd.f13414a instanceof XMPushService) {
                    ((XMPushService) bd.f13414a).a(he.this.d(), a2, true);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m50a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    private static he a(String str, String str2, String str3, String str4) {
        he heVar = new he();
        if (str3 != null) {
            heVar.c(str3);
        }
        if (str != null) {
            heVar.b(str);
        }
        if (str2 != null) {
            heVar.a(str2);
        }
        if (str4 != null) {
            heVar.d(str4);
        }
        heVar.a(false);
        return heVar;
    }
}
