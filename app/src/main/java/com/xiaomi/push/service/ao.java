package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C0334r;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.cc;
import com.xiaomi.push.cf;
import com.xiaomi.push.cg;
import com.xiaomi.push.dp;
import com.xiaomi.push.ei;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.fa;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ao extends ax.a implements cg.a {

    /* renamed from: a, reason: collision with root package name */
    private long f13377a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f1007a;

    static class a implements cg.b {
        a() {
        }

        @Override // com.xiaomi.push.cg.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", fx.a(Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C0334r.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = com.xiaomi.push.au.a(C0334r.m636a(), url);
                ep.a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a2;
            } catch (IOException e2) {
                ep.a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e2);
                throw e2;
            }
        }
    }

    static class b extends cg {
        protected b(Context context, cf cfVar, cg.b bVar, String str) {
            super(context, cfVar, bVar, str);
        }

        @Override // com.xiaomi.push.cg
        protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (eo.m382a().m387a()) {
                    str2 = ax.m705a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                ep.a(0, ei.GSLB_ERR.a(), 1, null, com.xiaomi.push.au.b(cg.f12551a) ? 1 : 0);
                throw e2;
            }
        }
    }

    ao(XMPushService xMPushService) {
        this.f1007a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ax.a().a(aoVar);
        synchronized (cg.class) {
            cg.a(aoVar);
            cg.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(Cdo.a aVar) {
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(dp.b bVar) {
        cc b2;
        if (bVar.m298b() && bVar.m297a() && System.currentTimeMillis() - this.f13377a > com.heytap.mcssdk.constant.a.f5801e) {
            com.xiaomi.channel.commonutils.logger.b.m50a("fetch bucket :" + bVar.m297a());
            this.f13377a = System.currentTimeMillis();
            cg a2 = cg.a();
            a2.m231a();
            a2.m234b();
            fa m660a = this.f1007a.m660a();
            if (m660a == null || (b2 = a2.b(m660a.m413a().c())) == null) {
                return;
            }
            ArrayList<String> m218a = b2.m218a();
            boolean z = true;
            Iterator<String> it = m218a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m660a.mo414a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m218a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("bucket changed, force reconnect");
            this.f1007a.a(0, (Exception) null);
            this.f1007a.a(false);
        }
    }

    @Override // com.xiaomi.push.cg.a
    public cg a(Context context, cf cfVar, cg.b bVar, String str) {
        return new b(context, cfVar, bVar, str);
    }
}
