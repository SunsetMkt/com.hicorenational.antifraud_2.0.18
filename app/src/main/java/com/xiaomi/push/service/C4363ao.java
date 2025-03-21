package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.AbstractC4207fa;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4128cc;
import com.xiaomi.push.C4132cg;
import com.xiaomi.push.C4167do;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.C4194eo;
import com.xiaomi.push.C4195ep;
import com.xiaomi.push.C4230fx;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.EnumC4188ei;
import com.xiaomi.push.InterfaceC4131cf;
import com.xiaomi.push.service.C4372ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.ao */
/* loaded from: classes2.dex */
public class C4363ao extends C4372ax.a implements C4132cg.a {

    /* renamed from: a */
    private long f16625a;

    /* renamed from: a */
    private XMPushService f16626a;

    /* renamed from: com.xiaomi.push.service.ao$a */
    static class a implements C4132cg.b {
        a() {
        }

        @Override // com.xiaomi.push.C4132cg.b
        /* renamed from: a */
        public String mo14098a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", C4230fx.m14901a(Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C4309r.m15714a()));
            String builder = buildUpon.toString();
            AbstractC4022b.m13359c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String m13790a = C4092au.m13790a(C4309r.m15715a(), url);
                C4195ep.m14673a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return m13790a;
            } catch (IOException e2) {
                C4195ep.m14673a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e2);
                throw e2;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.ao$b */
    static class b extends C4132cg {
        protected b(Context context, InterfaceC4131cf interfaceC4131cf, C4132cg.b bVar, String str) {
            super(context, interfaceC4131cf, bVar, str);
        }

        @Override // com.xiaomi.push.C4132cg
        /* renamed from: a */
        protected String mo14078a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (C4194eo.m14657a().m14664a()) {
                    str2 = C4372ax.m16018a();
                }
                return super.mo14078a(arrayList, str, str2, z);
            } catch (IOException e2) {
                C4195ep.m14670a(0, EnumC4188ei.GSLB_ERR.m14600a(), 1, null, C4092au.m13801b(C4132cg.f14719a) ? 1 : 0);
                throw e2;
            }
        }
    }

    C4363ao(XMPushService xMPushService) {
        this.f16626a = xMPushService;
    }

    /* renamed from: a */
    public static void m15983a(XMPushService xMPushService) {
        C4363ao c4363ao = new C4363ao(xMPushService);
        C4372ax.m16017a().m16029a(c4363ao);
        synchronized (C4132cg.class) {
            C4132cg.m14071a(c4363ao);
            C4132cg.m14070a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.service.C4372ax.a
    /* renamed from: a */
    public void mo15984a(C4167do.a aVar) {
    }

    @Override // com.xiaomi.push.service.C4372ax.a
    /* renamed from: a */
    public void mo14666a(C4168dp.b bVar) {
        C4128cc m14084b;
        if (bVar.m14378b() && bVar.m14376a() && System.currentTimeMillis() - this.f16625a > C2084a.f6123e) {
            AbstractC4022b.m13347a("fetch bucket :" + bVar.m14376a());
            this.f16625a = System.currentTimeMillis();
            C4132cg m14066a = C4132cg.m14066a();
            m14066a.m14080a();
            m14066a.m14086b();
            AbstractC4207fa m15791a = this.f16626a.m15791a();
            if (m15791a == null || (m14084b = m14066a.m14084b(m15791a.m14761a().m14793c())) == null) {
                return;
            }
            ArrayList<String> m14034a = m14084b.m14034a();
            boolean z = true;
            Iterator<String> it = m14034a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m15791a.mo14762a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m14034a.isEmpty()) {
                return;
            }
            AbstractC4022b.m13347a("bucket changed, force reconnect");
            this.f16626a.m15795a(0, (Exception) null);
            this.f16626a.m15803a(false);
        }
    }

    @Override // com.xiaomi.push.C4132cg.a
    /* renamed from: a */
    public C4132cg mo14097a(Context context, InterfaceC4131cf interfaceC4131cf, C4132cg.b bVar, String str) {
        return new b(context, interfaceC4131cf, bVar, str);
    }
}
