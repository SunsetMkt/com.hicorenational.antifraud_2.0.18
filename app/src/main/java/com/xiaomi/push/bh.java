package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes2.dex */
public class bh implements Runnable {
    private bh() {
    }

    public static void a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m182a()) {
            new Thread(new bh()).start();
            aVar.m181a();
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bh.run():void");
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public SharedPreferences f12501a;

        /* renamed from: a, reason: collision with other field name */
        private final String f214a = "dc_job_result_time_26";

        public a(Context context) {
            this.f12501a = context.getSharedPreferences("mipush_extra", 0);
            long j2 = this.f12501a.getLong("dc_job_result_time_26", 0L);
            if (j2 <= 0 || j2 - System.currentTimeMillis() > 259200000) {
                this.f12501a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long currentTimeMillis = System.currentTimeMillis();
            Random random = new Random(currentTimeMillis);
            return (((currentTimeMillis / 86400000) + 1) * 86400000) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m182a() {
            return System.currentTimeMillis() - this.f12501a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        private a() {
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m181a() {
            long j2 = this.f12501a.getLong("dc_job_result_time_26", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j2;
            if (currentTimeMillis >= 0) {
                this.f12501a.edit().putLong("dc_job_result_time_26", j2 + (((currentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    private void a(bd bdVar, bc bcVar, Exception exc) {
        HashMap hashMap = new HashMap();
        String m742a = com.xiaomi.push.service.q.m742a(C0334r.m636a());
        if (!TextUtils.isEmpty(m742a)) {
            hashMap.put("uuid", m742a);
        }
        hashMap.put("appCount", Long.valueOf(bdVar.m179a()));
        hashMap.put("channels", Long.valueOf(bdVar.b()));
        hashMap.put("packCount", Long.valueOf(bdVar.c()));
        hashMap.put("totalSize", Long.valueOf(bdVar.d()));
        hashMap.put("isBatch", Integer.valueOf(bdVar.a()));
        hashMap.put("maxCallTime", Long.valueOf(bcVar.a()));
        hashMap.put("minCallTime", Long.valueOf(bcVar.b()));
        hashMap.put("callAvg", Long.valueOf(bcVar.c()));
        hashMap.put("duration", Long.valueOf(bcVar.d()));
        if (exc != null) {
            hashMap.put("exception", exc.toString());
        }
        eh.a().a("app_switch_upload", hashMap);
    }

    private void a(Context context, bg bgVar, bd bdVar) {
        gj gjVar = new gj();
        gjVar.d("category_app_channel_info");
        gjVar.c("app_channel_info");
        gjVar.b(bgVar.toString());
        gjVar.a(false);
        gjVar.a(1L);
        gjVar.a("xmsf_channel");
        gjVar.b(System.currentTimeMillis());
        gjVar.g("com.xiaomi.xmsf");
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.az.a());
        com.xiaomi.push.service.ba.a(context, gjVar);
    }
}
