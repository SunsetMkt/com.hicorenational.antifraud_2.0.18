package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.InterfaceC4238ge;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.o */
/* loaded from: classes2.dex */
public class C4392o implements InterfaceC4238ge {

    /* renamed from: a */
    private final XMPushService f16748a;

    public C4392o(XMPushService xMPushService) {
        this.f16748a = xMPushService;
    }

    @Override // com.xiaomi.push.InterfaceC4238ge
    /* renamed from: a */
    public void mo14966a(final List<C4243gj> list, final String str, final String str2) {
        this.f16748a.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                String m16196a = C4392o.this.m16196a(str);
                ArrayList<C4265he> m16041a = C4374az.m16041a(list, str, m16196a, 32768);
                if (m16041a == null) {
                    AbstractC4022b.m13361d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                    return;
                }
                Iterator<C4265he> it = m16041a.iterator();
                while (it.hasNext()) {
                    C4265he next = it.next();
                    next.m15309a("uploadWay", "longXMPushService");
                    C4262hb m16276a = C4401w.m16276a(str, m16196a, next, EnumC4239gf.Notification);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                        if (m16276a.m15264a() == null) {
                            C4252gs c4252gs = new C4252gs();
                            c4252gs.m15094a("-1");
                            m16276a.m15266a(c4252gs);
                        }
                        m16276a.m15264a().m15108b("ext_traffic_source_pkg", str2);
                    }
                    C4392o.this.f16748a.m15802a(str, C4276hp.m15567a(m16276a), true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m16196a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f16748a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
