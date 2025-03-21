package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class o implements ge {

    /* renamed from: a, reason: collision with root package name */
    private final XMPushService f13442a;

    public o(XMPushService xMPushService) {
        this.f13442a = xMPushService;
    }

    @Override // com.xiaomi.push.ge
    public void a(final List<gj> list, final String str, final String str2) {
        this.f13442a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                String a2 = o.this.a(str);
                ArrayList<he> a3 = az.a(list, str, a2, 32768);
                if (a3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                    return;
                }
                Iterator<he> it = a3.iterator();
                while (it.hasNext()) {
                    he next = it.next();
                    next.a("uploadWay", "longXMPushService");
                    hb a4 = w.a(str, a2, next, gf.Notification);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                        if (a4.m529a() == null) {
                            gs gsVar = new gs();
                            gsVar.a("-1");
                            a4.a(gsVar);
                        }
                        a4.m529a().b("ext_traffic_source_pkg", str2);
                    }
                    o.this.f13442a.a(str, hp.a(a4), true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f13442a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
