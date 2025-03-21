package com.tencent.open.p212b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p211a.C3255f;
import com.tencent.open.utils.C3288f;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3294l;
import com.tencent.open.utils.C3295m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.b */
/* loaded from: classes2.dex */
public class C3260b {

    /* renamed from: a */
    private static C3260b f11166a;

    /* renamed from: b */
    private String f11167b = "";

    /* renamed from: c */
    private String f11168c = "";

    /* renamed from: d */
    private String f11169d = "";

    /* renamed from: e */
    private String f11170e = "";

    /* renamed from: f */
    private String f11171f = "";

    /* renamed from: g */
    private String f11172g = "";

    /* renamed from: h */
    private String f11173h = "";

    /* renamed from: i */
    private List<Serializable> f11174i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j */
    private List<Serializable> f11175j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k */
    private Executor f11176k = C3294l.m10655b();

    /* renamed from: l */
    private boolean f11177l;

    private C3260b() {
    }

    /* renamed from: c */
    private void m10447c() {
        while (!this.f11175j.isEmpty()) {
            C3261c c3261c = (C3261c) this.f11175j.remove(0);
            c3261c.f11180a.put("appid", this.f11167b);
            c3261c.f11180a.put("app_name", this.f11168c);
            c3261c.f11180a.put(Constants.PARAM_APP_VER, this.f11170e);
            c3261c.f11180a.put(Constants.PARAM_PKG_NAME, this.f11171f);
            c3261c.f11180a.put("qq_install", this.f11172g);
            c3261c.f11180a.put(Constants.PARAM_QQ_VER, this.f11173h);
            c3261c.f11180a.put("openid", this.f11169d);
            c3261c.f11180a.put("time_appid_openid", c3261c.f11180a.get("time") + AbstractC1191a.f2606s1 + this.f11167b + AbstractC1191a.f2606s1 + this.f11169d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(c3261c);
            SLog.m10502i("AttaReporter", sb.toString());
            this.f11174i.add(c3261c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10448d() {
        SLog.m10502i("AttaReporter", "attaReportAtSubThread");
        if (!this.f11177l) {
            List<Serializable> m10467b = C3265g.m10467b("report_atta");
            this.f11177l = m10467b.isEmpty();
            this.f11174i.addAll(m10467b);
            Iterator<Serializable> it = m10467b.iterator();
            while (it.hasNext()) {
                SLog.m10502i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f11174i.isEmpty()) {
            C3261c c3261c = (C3261c) this.f11174i.remove(0);
            if (!m10446b(c3261c)) {
                arrayList.add(c3261c);
            }
        }
        if (arrayList.isEmpty()) {
            if (this.f11177l) {
                return;
            }
            SLog.m10502i("AttaReporter", "attaReportAtSubThread clear db");
            C3265g.m10465a("report_atta");
            this.f11177l = true;
            return;
        }
        SLog.m10502i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SLog.m10502i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((C3261c) it2.next()));
        }
        C3265g.m10466a("report_atta", arrayList);
        this.f11177l = false;
    }

    /* renamed from: a */
    public static synchronized C3260b m10440a() {
        C3260b c3260b;
        synchronized (C3260b.class) {
            if (f11166a == null) {
                f11166a = new C3260b();
            }
            c3260b = f11166a;
        }
        return c3260b;
    }

    /* renamed from: b */
    private C3261c m10443b(String str, String str2, Object obj, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put("token", "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + AbstractC1191a.f2606s1 + this.f11167b + AbstractC1191a.f2606s1 + this.f11169d);
        hashMap.put("time", String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.f11169d);
        hashMap.put("appid", this.f11167b);
        hashMap.put("app_name", this.f11168c);
        hashMap.put(Constants.PARAM_APP_VER, this.f11170e);
        hashMap.put(Constants.PARAM_PKG_NAME, this.f11171f);
        hashMap.put("os", "AND");
        hashMap.put("os_ver", Build.VERSION.RELEASE);
        hashMap.put("sdk_ver", Constants.SDK_VERSION);
        hashMap.put(Constants.PARAM_MODEL_NAME, C3288f.m10596a().m10601c(C3289g.m10603a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        hashMap.put("interface_result", obj == null ? "" : obj.toString());
        hashMap.put("qq_install", this.f11172g);
        hashMap.put(Constants.PARAM_QQ_VER, this.f11173h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            hashMap.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            hashMap.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            hashMap.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            hashMap.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new C3261c((HashMap<String, String>) hashMap);
    }

    /* renamed from: a */
    public void m10450a(String str, Context context) {
        SLog.m10502i("AttaReporter", "init");
        this.f11167b = str;
        this.f11168c = C3293k.m10633a(context);
        this.f11170e = C3295m.m10695d(context, C3289g.m10606b());
        this.f11171f = C3289g.m10606b();
        this.f11172g = C3293k.m10643b(context) ? "1" : "0";
        this.f11173h = C3295m.m10691c(context, "com.tencent.mobileqq");
        m10447c();
        C3265g.m10464a();
    }

    /* renamed from: a */
    public void m10449a(String str) {
        SLog.m10502i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f11169d = str;
    }

    /* renamed from: a */
    public void m10452a(String str, String str2) {
        m10454a(str, str2, null);
    }

    /* renamed from: a */
    public void m10454a(String str, String str2, Map<String, Object> map) {
        m10453a(str, str2, "", map);
    }

    /* renamed from: a */
    public void m10451a(String str, Object obj) {
        m10453a(str, "", obj, null);
    }

    /* renamed from: a */
    public void m10453a(String str, String str2, Object obj, Map<String, Object> map) {
        C3261c m10443b = m10443b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f11167b) && !TextUtils.isEmpty(this.f11168c) && C3289g.m10603a() != null) {
            m10442a(m10443b);
            return;
        }
        SLog.m10502i("AttaReporter", "attaReport cancel appid=" + this.f11167b + ", mAppName=" + this.f11168c + ", context=" + C3289g.m10603a() + ", " + m10443b);
        this.f11175j.add(m10443b);
    }

    /* renamed from: a */
    private void m10442a(final C3261c c3261c) {
        this.f11176k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                C3260b.this.f11174i.add(c3261c);
                if (C3295m.m10688b(C3289g.m10603a())) {
                    try {
                        C3260b.this.m10448d();
                        return;
                    } catch (Exception e2) {
                        SLog.m10501e("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
                        return;
                    }
                }
                SLog.m10502i("AttaReporter", "attaReport net disconnect, " + c3261c);
            }
        });
    }

    /* renamed from: b */
    private boolean m10446b(C3261c c3261c) {
        int i2 = 0;
        do {
            i2++;
            try {
                SLog.m10502i("AttaReporter", "doAttaReportItem post " + c3261c);
                return C3255f.m10416a().m10424b("https://h.trace.qq.com/kv", c3261c.f11180a).mo10413d() == 200;
            } catch (Exception e2) {
                SLog.m10503i("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
            }
        } while (i2 < 2);
        return false;
    }

    /* renamed from: b */
    public static String m10444b() {
        return m10440a().f11167b;
    }
}
