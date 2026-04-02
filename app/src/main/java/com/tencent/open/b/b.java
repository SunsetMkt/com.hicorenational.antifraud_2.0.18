package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static b a;

    /* JADX INFO: renamed from: b */
    private String f6815b = "";

    /* JADX INFO: renamed from: c */
    private String f6816c = "";

    /* JADX INFO: renamed from: d */
    private String f6817d = "";

    /* JADX INFO: renamed from: e */
    private String f6818e = "";

    /* JADX INFO: renamed from: f */
    private String f6819f = "";

    /* JADX INFO: renamed from: g */
    private String f6820g = "";

    /* JADX INFO: renamed from: h */
    private String f6821h = "";

    /* JADX INFO: renamed from: i */
    private List<Serializable> f6822i = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: j */
    private List<Serializable> f6823j = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: k */
    private Executor f6824k = l.b();

    /* JADX INFO: renamed from: l */
    private boolean f6825l;

    /* JADX INFO: renamed from: com.tencent.open.b.b$1 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ c a;

        AnonymousClass1(c cVar) {
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f6822i.add(cVar);
            if (m.b(com.tencent.open.utils.g.a())) {
                try {
                    b.this.d();
                    return;
                } catch (Exception e2) {
                    SLog.e("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
                    return;
                }
            }
            SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
        }
    }

    private b() {
    }

    private void c() {
        while (!this.f6823j.isEmpty()) {
            c cVar = (c) this.f6823j.remove(0);
            cVar.a.put("appid", this.f6815b);
            cVar.a.put("app_name", this.f6816c);
            cVar.a.put(Constants.PARAM_APP_VER, this.f6818e);
            cVar.a.put(Constants.PARAM_PKG_NAME, this.f6819f);
            cVar.a.put("qq_install", this.f6820g);
            cVar.a.put(Constants.PARAM_QQ_VER, this.f6821h);
            cVar.a.put("openid", this.f6817d);
            cVar.a.put("time_appid_openid", cVar.a.get("time") + d.c.a.b.a.a.s1 + this.f6815b + d.c.a.b.a.a.s1 + this.f6817d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(cVar);
            SLog.i("AttaReporter", sb.toString());
            this.f6822i.add(cVar);
        }
    }

    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.f6825l) {
            List<Serializable> listB = g.b("report_atta");
            this.f6825l = listB.isEmpty();
            this.f6822i.addAll(listB);
            Iterator<Serializable> it = listB.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f6822i.isEmpty()) {
            c cVar = (c) this.f6822i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (this.f6825l) {
                return;
            }
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.f6825l = true;
            return;
        }
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) it2.next()));
        }
        g.a("report_atta", arrayList);
        this.f6825l = false;
    }

    public static synchronized b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map2 = new HashMap();
        map2.put("attaid", "09400051119");
        map2.put("token", "9389887874");
        map2.put("time_appid_openid", jCurrentTimeMillis + d.c.a.b.a.a.s1 + this.f6815b + d.c.a.b.a.a.s1 + this.f6817d);
        map2.put("time", String.valueOf(jCurrentTimeMillis));
        map2.put("openid", this.f6817d);
        map2.put("appid", this.f6815b);
        map2.put("app_name", this.f6816c);
        map2.put(Constants.PARAM_APP_VER, this.f6818e);
        map2.put(Constants.PARAM_PKG_NAME, this.f6819f);
        map2.put("os", "AND");
        map2.put("os_ver", Build.VERSION.RELEASE);
        map2.put("sdk_ver", Constants.SDK_VERSION);
        map2.put(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        map2.put("interface_name", str);
        map2.put("interface_data", str2);
        map2.put("interface_result", obj == null ? "" : obj.toString());
        map2.put("qq_install", this.f6820g);
        map2.put(Constants.PARAM_QQ_VER, this.f6821h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            map2.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            map2.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            map2.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            map2.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new c((HashMap<String, String>) map2);
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", "init");
        this.f6815b = str;
        this.f6816c = k.a(context);
        this.f6818e = m.d(context, com.tencent.open.utils.g.b());
        this.f6819f = com.tencent.open.utils.g.b();
        this.f6820g = k.b(context) ? "1" : "0";
        this.f6821h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f6817d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c cVarB = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f6815b) && !TextUtils.isEmpty(this.f6816c) && com.tencent.open.utils.g.a() != null) {
            a(cVarB);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f6815b + ", mAppName=" + this.f6816c + ", context=" + com.tencent.open.utils.g.a() + ", " + cVarB);
        this.f6823j.add(cVarB);
    }

    private void a(c cVar) {
        this.f6824k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            final /* synthetic */ c a;

            AnonymousClass1(c cVar2) {
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f6822i.add(cVar);
                if (m.b(com.tencent.open.utils.g.a())) {
                    try {
                        b.this.d();
                        return;
                    } catch (Exception e2) {
                        SLog.e("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
                        return;
                    }
                }
                SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
            }
        });
    }

    private boolean b(c cVar) {
        int i2 = 0;
        do {
            i2++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                return com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.a).d() == 200;
            } catch (Exception e2) {
                SLog.i("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
            }
        } while (i2 < 2);
        return false;
    }

    public static String b() {
        return a().f6815b;
    }
}
