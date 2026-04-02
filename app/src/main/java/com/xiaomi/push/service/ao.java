package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
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

/* JADX INFO: loaded from: classes2.dex */
public class ao extends ax.a implements cg.a {
    private long a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private XMPushService f1007a;

    static class a implements cg.b {
        a() {
        }

        @Override // com.xiaomi.push.cg.b
        public String a(String str) throws IOException {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            builderBuildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            builderBuildUpon.appendQueryParameter("os", fx.a(Build.VERSION.INCREMENTAL));
            builderBuildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.r.a()));
            String string = builderBuildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + string);
            URL url = new URL(string);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = com.xiaomi.push.au.a(com.xiaomi.push.r.m634a(), url);
                ep.a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) (System.currentTimeMillis() - jCurrentTimeMillis), null);
                return strA;
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
        protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException {
            try {
                if (eo.m380a().m385a()) {
                    str2 = ax.m703a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                ep.a(0, ei.GSLB_ERR.a(), 1, null, com.xiaomi.push.au.b(cg.a) ? 1 : 0);
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
        cc ccVarB;
        if (bVar.m296b() && bVar.m295a() && System.currentTimeMillis() - this.a > com.heytap.mcssdk.constant.a.f3869e) {
            com.xiaomi.channel.commonutils.logger.b.m48a("fetch bucket :" + bVar.m295a());
            this.a = System.currentTimeMillis();
            cg cgVarA = cg.a();
            cgVarA.m229a();
            cgVarA.m232b();
            fa faVarM658a = this.f1007a.m658a();
            if (faVarM658a == null || (ccVarB = cgVarA.b(faVarM658a.m411a().c())) == null) {
                return;
            }
            ArrayList<String> arrayListM216a = ccVarB.m216a();
            boolean z = true;
            Iterator<String> it = arrayListM216a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(faVarM658a.mo412a())) {
                    z = false;
                    break;
                }
            }
            if (!z || arrayListM216a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("bucket changed, force reconnect");
            this.f1007a.a(0, (Exception) null);
            this.f1007a.a(false);
        }
    }

    @Override // com.xiaomi.push.cg.a
    public cg a(Context context, cf cfVar, cg.b bVar, String str) {
        return new b(context, cfVar, bVar, str);
    }
}
