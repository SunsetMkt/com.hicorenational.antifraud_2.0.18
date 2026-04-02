package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class bh implements Runnable {
    private bh() {
    }

    public static void a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m180a()) {
            new Thread(new bh()).start();
            aVar.m179a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0191  */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.xiaomi.push.bg] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [com.xiaomi.push.bg] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v9, types: [com.xiaomi.push.bg] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v3, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [com.xiaomi.push.bf, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.xiaomi.push.bh] */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.xiaomi.push.bg, java.lang.Object] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        bd bdVar;
        Exception exc;
        Map<String, ?> all;
        int size;
        String str;
        String str2;
        bd bdVar2;
        Iterator<Map.Entry<String, ?>> it;
        ?? bfVar;
        ?? r11;
        ?? r19;
        ?? r12;
        List<NotificationChannel> listM683a;
        String str3;
        ?? r20;
        String str4 = "mipush_";
        String str5 = "com.xiaomi.xmsf";
        final Context contextM634a = r.m634a();
        if (contextM634a != null) {
            bd bdVar3 = new bd();
            bc bcVar = new bc(50L, 1000L);
            try {
                all = r.m634a().getSharedPreferences("pref_registered_pkg_names", 0).getAll();
            } catch (Exception e2) {
                e = e2;
                bdVar = bdVar3;
            }
            if (all == null || all.isEmpty()) {
                bdVar = bdVar3;
            } else {
                Set<String> setKeySet = all.keySet();
                if (setKeySet.contains("com.xiaomi.xmsf")) {
                    try {
                        size = setKeySet.size() - 1;
                    } catch (Exception e3) {
                        exc = e3;
                        bdVar = bdVar3;
                    }
                } else {
                    size = setKeySet.size();
                }
                bdVar3.a(size);
                bg bgVar = new bg();
                bgVar.put(com.umeng.analytics.pro.bh.aI, bdVar3.m177a());
                Set<Map.Entry<String, ?>> setEntrySet = all.entrySet();
                bf bfVar2 = new bf();
                Iterator<Map.Entry<String, ?>> it2 = setEntrySet.iterator();
                ?? r112 = bgVar;
                ?? r122 = bfVar2;
                while (it2.hasNext()) {
                    Map.Entry<String, ?> next = it2.next();
                    final String key = next.getKey();
                    String str6 = (String) next.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        if (str5.equals(key) || TextUtils.isEmpty(str6)) {
                            str = str4;
                            str2 = str5;
                            bdVar2 = bdVar3;
                            it = it2;
                            r11 = r112;
                            bfVar = r122;
                        } else {
                            ?? bgVar2 = new bg();
                            bgVar2.put(com.umeng.analytics.pro.bh.ay, str6);
                            bgVar2.put(com.umeng.analytics.pro.bh.aE, (String) bcVar.a(new Callable<String>() { // from class: com.xiaomi.push.bh.1
                                @Override // java.util.concurrent.Callable
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public String call() {
                                    return String.valueOf(com.xiaomi.push.service.a.a(contextM634a, key));
                                }
                            }));
                            if (Build.VERSION.SDK_INT < 26 || (listM683a = com.xiaomi.push.service.af.a(contextM634a, key).m683a()) == null || listM683a.isEmpty()) {
                                str = str4;
                                str2 = str5;
                                bdVar2 = bdVar3;
                                it = it2;
                                r19 = r112;
                                r12 = r122;
                            } else {
                                bf bfVar3 = new bf();
                                str2 = str5;
                                it = it2;
                                r19 = r112;
                                bdVar3.b(listM683a.size());
                                Iterator<NotificationChannel> it3 = listM683a.iterator();
                                while (it3.hasNext()) {
                                    final NotificationChannel next2 = it3.next();
                                    String id = next2.getId();
                                    bg bgVar3 = new bg();
                                    Iterator<NotificationChannel> it4 = it3;
                                    bd bdVar4 = bdVar3;
                                    if (id.startsWith(str4)) {
                                        r20 = r122;
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(str4);
                                            sb.append(key);
                                            str3 = str4;
                                            sb.append(d.c.a.b.a.a.s1);
                                            String strReplace = id.replace(sb.toString(), "");
                                            bgVar3.put("t", 1);
                                            bgVar3.put(com.umeng.analytics.pro.bh.aI, strReplace);
                                        } catch (Exception e4) {
                                            exc = e4;
                                            bdVar = bdVar4;
                                        }
                                    } else {
                                        str3 = str4;
                                        r20 = r122;
                                        if (id.startsWith("mipush|")) {
                                            String strReplace2 = id.replace("mipush|" + key + HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "");
                                            bgVar3.put("t", 2);
                                            bgVar3.put(com.umeng.analytics.pro.bh.aI, strReplace2);
                                        }
                                    }
                                    bgVar3.put(com.umeng.analytics.pro.bh.aE, (String) bcVar.a(new Callable() { // from class: com.xiaomi.push.bh.2
                                        @Override // java.util.concurrent.Callable
                                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                        public String call() {
                                            return String.valueOf(com.xiaomi.push.service.f.a(contextM634a, key, next2));
                                        }
                                    }));
                                    bfVar3.put(bgVar3);
                                    r122 = r20;
                                    it3 = it4;
                                    bdVar3 = bdVar4;
                                    str4 = str3;
                                }
                                str = str4;
                                bdVar2 = bdVar3;
                                bgVar2.put(com.umeng.analytics.pro.bh.aI, bfVar3);
                                r12 = r122;
                            }
                            r12.put(bgVar2);
                            ?? r113 = r19;
                            r113.put("d", r12);
                            r11 = r113;
                            bfVar = r12;
                        }
                        try {
                            if (r11.a() > 30720) {
                                bdVar2.m178a();
                                bdVar = bdVar2;
                                try {
                                    bdVar.c(r11.a());
                                    a(contextM634a, r11, bdVar);
                                    bg bgVar4 = new bg();
                                    bgVar4.put(com.umeng.analytics.pro.bh.aI, bdVar.m177a());
                                    r11 = bgVar4;
                                    bfVar = new bf();
                                } catch (Exception e5) {
                                    e = e5;
                                    exc = e;
                                    a(bdVar, bcVar, exc);
                                }
                            } else {
                                bdVar = bdVar2;
                            }
                            bdVar3 = bdVar;
                            str5 = str2;
                            it2 = it;
                            str4 = str;
                            r112 = r11;
                            r122 = bfVar;
                        } catch (Exception e6) {
                            e = e6;
                            bdVar = bdVar2;
                            exc = e;
                            a(bdVar, bcVar, exc);
                        }
                    }
                    a(bdVar, bcVar, exc);
                }
                bdVar = bdVar3;
                if (r122.length() > 0) {
                    bdVar.m178a();
                    bdVar.c(r112.a());
                    a(contextM634a, r112, bdVar);
                }
            }
            exc = null;
            a(bdVar, bcVar, exc);
        }
    }

    private static class a {
        public SharedPreferences a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final String f214a = "dc_job_result_time_26";

        public a(Context context) {
            this.a = context.getSharedPreferences("mipush_extra", 0);
            long j2 = this.a.getLong("dc_job_result_time_26", 0L);
            if (j2 <= 0 || j2 - System.currentTimeMillis() > 259200000) {
                this.a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Random random = new Random(jCurrentTimeMillis);
            return (((jCurrentTimeMillis / 86400000) + 1) * 86400000) + ((long) (random.nextInt(3) * 86400000)) + ((long) random.nextInt(46800000));
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m180a() {
            return System.currentTimeMillis() - this.a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        private a() {
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m179a() {
            long j2 = this.a.getLong("dc_job_result_time_26", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j2;
            if (jCurrentTimeMillis >= 0) {
                this.a.edit().putLong("dc_job_result_time_26", j2 + (((jCurrentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    private void a(bd bdVar, bc bcVar, Exception exc) {
        HashMap map = new HashMap();
        String strM740a = com.xiaomi.push.service.q.m740a(r.m634a());
        if (!TextUtils.isEmpty(strM740a)) {
            map.put("uuid", strM740a);
        }
        map.put("appCount", Long.valueOf(bdVar.m177a()));
        map.put("channels", Long.valueOf(bdVar.b()));
        map.put("packCount", Long.valueOf(bdVar.c()));
        map.put("totalSize", Long.valueOf(bdVar.d()));
        map.put("isBatch", Integer.valueOf(bdVar.a()));
        map.put("maxCallTime", Long.valueOf(bcVar.a()));
        map.put("minCallTime", Long.valueOf(bcVar.b()));
        map.put("callAvg", Long.valueOf(bcVar.c()));
        map.put("duration", Long.valueOf(bcVar.d()));
        if (exc != null) {
            map.put("exception", exc.toString());
        }
        eh.a().a("app_switch_upload", map);
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
