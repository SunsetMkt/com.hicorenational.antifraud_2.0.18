package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.service.C4374az;
import com.xiaomi.push.service.C4376ba;
import com.xiaomi.push.service.C4394q;
import java.util.HashMap;
import java.util.Random;

/* renamed from: com.xiaomi.push.bh */
/* loaded from: classes2.dex */
public class RunnableC4106bh implements Runnable {
    private RunnableC4106bh() {
    }

    /* renamed from: a */
    public static void m13905a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m13912a()) {
            new Thread(new RunnableC4106bh()).start();
            aVar.m13911a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1 A[Catch: Exception -> 0x01d1, TRY_LEAVE, TryCatch #4 {Exception -> 0x01d1, blocks: (B:56:0x0199, B:58:0x01a1), top: B:55:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c5  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.RunnableC4106bh.run():void");
    }

    /* renamed from: com.xiaomi.push.bh$a */
    private static class a {

        /* renamed from: a */
        public SharedPreferences f14629a;

        /* renamed from: a */
        private final String f14630a = "dc_job_result_time_26";

        public a(Context context) {
            this.f14629a = context.getSharedPreferences("mipush_extra", 0);
            long j2 = this.f14629a.getLong("dc_job_result_time_26", 0L);
            if (j2 <= 0 || j2 - System.currentTimeMillis() > 259200000) {
                this.f14629a.edit().putLong("dc_job_result_time_26", m13910a()).apply();
            }
        }

        /* renamed from: a */
        private long m13910a() {
            long currentTimeMillis = System.currentTimeMillis();
            Random random = new Random(currentTimeMillis);
            return (((currentTimeMillis / 86400000) + 1) * 86400000) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        /* renamed from: a */
        public boolean m13912a() {
            return System.currentTimeMillis() - this.f14629a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        private a() {
        }

        /* renamed from: a */
        public void m13911a() {
            long j2 = this.f14629a.getLong("dc_job_result_time_26", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j2;
            if (currentTimeMillis >= 0) {
                this.f14629a.edit().putLong("dc_job_result_time_26", j2 + (((currentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    /* renamed from: a */
    private void m13907a(C4102bd c4102bd, C4101bc c4101bc, Exception exc) {
        HashMap hashMap = new HashMap();
        String m16206a = C4394q.m16206a(C4309r.m15715a());
        if (!TextUtils.isEmpty(m16206a)) {
            hashMap.put("uuid", m16206a);
        }
        hashMap.put("appCount", Long.valueOf(c4102bd.m13896a()));
        hashMap.put("channels", Long.valueOf(c4102bd.m13899b()));
        hashMap.put("packCount", Long.valueOf(c4102bd.m13901c()));
        hashMap.put("totalSize", Long.valueOf(c4102bd.m13903d()));
        hashMap.put("isBatch", Integer.valueOf(c4102bd.m13895a()));
        hashMap.put("maxCallTime", Long.valueOf(c4101bc.m13890a()));
        hashMap.put("minCallTime", Long.valueOf(c4101bc.m13892b()));
        hashMap.put("callAvg", Long.valueOf(c4101bc.m13893c()));
        hashMap.put("duration", Long.valueOf(c4101bc.m13894d()));
        if (exc != null) {
            hashMap.put("exception", exc.toString());
        }
        C4187eh.m14597a().mo14596a("app_switch_upload", hashMap);
    }

    /* renamed from: a */
    private void m13906a(Context context, C4105bg c4105bg, C4102bd c4102bd) {
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d("category_app_channel_info");
        c4243gj.m14996c("app_channel_info");
        c4243gj.m14992b(c4105bg.toString());
        c4243gj.m14983a(false);
        c4243gj.m14980a(1L);
        c4243gj.m14981a("xmsf_channel");
        c4243gj.m14991b(System.currentTimeMillis());
        c4243gj.m15008g("com.xiaomi.xmsf");
        c4243gj.m15003e("com.xiaomi.xmsf");
        c4243gj.m15006f(C4374az.m16040a());
        C4376ba.m16052a(context, c4243gj);
    }
}
