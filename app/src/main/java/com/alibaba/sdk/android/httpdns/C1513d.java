package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.p112b.C1505b;
import com.alibaba.sdk.android.httpdns.p112b.C1506c;
import com.alibaba.sdk.android.httpdns.p112b.C1508e;
import com.alibaba.sdk.android.httpdns.p112b.C1510g;
import com.alibaba.sdk.android.httpdns.probe.C1536d;
import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.httpdns.probe.IPProbeService;
import com.alibaba.sdk.android.httpdns.probe.InterfaceC1534b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* renamed from: com.alibaba.sdk.android.httpdns.d */
/* loaded from: classes.dex */
class C1513d {

    /* renamed from: a */
    private static C1513d f3873a = new C1513d();

    /* renamed from: a */
    private static IPProbeService f3874a = C1536d.m3568a(new InterfaceC1534b() { // from class: com.alibaba.sdk.android.httpdns.d.1
        @Override // com.alibaba.sdk.android.httpdns.probe.InterfaceC1534b
        /* renamed from: a */
        public void mo3484a(String str, String[] strArr) {
            C1517e c1517e;
            if (str == null || strArr == null || strArr.length == 0 || (c1517e = (C1517e) C1513d.f3875a.get(str)) == null) {
                return;
            }
            C1517e c1517e2 = new C1517e(str, strArr, c1517e.m3509a(), c1517e.m3513b(), c1517e.m3511a(), c1517e.getCacheKey());
            C1513d.f3875a.put(str, c1517e2);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < c1517e2.getIps().length; i2++) {
                sb.append(c1517e2.getIps()[i2] + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            C1522i.m3527f("optimized host:" + str + ", ip:" + sb.toString());
        }
    });

    /* renamed from: a */
    private static ConcurrentMap<String, C1517e> f3875a;

    /* renamed from: a */
    private static ConcurrentSkipListSet<String> f3876a;

    private C1513d() {
        f3875a = new ConcurrentHashMap();
        f3876a = new ConcurrentSkipListSet<>();
    }

    /* renamed from: a */
    static C1513d m3470a() {
        return f3873a;
    }

    /* renamed from: a */
    private IPProbeItem m3471a(String str) {
        List<IPProbeItem> list = C1519f.f3921a;
        if (list == null) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equals(list.get(i2).getHostName())) {
                return list.get(i2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m3474a(C1508e c1508e) {
        return (System.currentTimeMillis() / 1000) - C1506c.m3443a(c1508e.f3862n) > 604800;
    }

    /* renamed from: a */
    private boolean m3475a(String str, C1517e c1517e) {
        IPProbeItem m3471a;
        if (c1517e == null || c1517e.getIps() == null || c1517e.getIps().length <= 1 || f3874a == null || (m3471a = m3471a(str)) == null) {
            return false;
        }
        if (f3874a.getProbeStatus(str) == IPProbeService.EnumC1532a.PROBING) {
            f3874a.stopIPProbeTask(str);
        }
        C1522i.m3527f("START PROBE");
        f3874a.launchIPProbeTask(str, m3471a.getPort(), c1517e.getIps());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3476b() {
        List<C1508e> m3433a = C1505b.m3433a();
        String m3442i = C1505b.m3442i();
        for (C1508e c1508e : m3433a) {
            if (m3474a(c1508e)) {
                C1505b.m3440b(c1508e);
            } else if (m3442i.equals(c1508e.f3861m)) {
                c1508e.f3862n = String.valueOf(System.currentTimeMillis() / 1000);
                C1517e c1517e = new C1517e(c1508e);
                f3875a.put(c1508e.host, c1517e);
                if (C1505b.m3441g()) {
                    C1505b.m3440b(c1508e);
                }
                m3475a(c1508e.host, c1517e);
            }
        }
    }

    /* renamed from: a */
    C1517e m3477a(String str) {
        return f3875a.get(str);
    }

    /* renamed from: a */
    ArrayList<String> m3478a() {
        return new ArrayList<>(f3875a.keySet());
    }

    /* renamed from: a */
    void m3479a() {
        if (C1505b.m3438a()) {
            C1511c.m3462a().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1513d.this.m3476b();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    void m3480a(String str) {
        f3876a.add(str);
    }

    /* renamed from: a */
    void m3481a(String str, C1517e c1517e) {
        ArrayList<C1510g> arrayList;
        f3875a.put(str, c1517e);
        if (C1505b.m3438a()) {
            C1508e m3510a = c1517e.m3510a();
            ArrayList<C1510g> arrayList2 = m3510a.f3857a;
            if ((arrayList2 == null || arrayList2.size() <= 0) && ((arrayList = m3510a.f3859b) == null || arrayList.size() <= 0)) {
                C1505b.m3440b(m3510a);
            } else {
                C1505b.m3436a(m3510a);
            }
        }
        m3475a(str, c1517e);
    }

    /* renamed from: a */
    boolean m3482a(String str) {
        return f3876a.contains(str);
    }

    /* renamed from: b */
    void m3483b(String str) {
        f3876a.remove(str);
    }

    void clear() {
        f3875a.clear();
        f3876a.clear();
    }

    int count() {
        return f3875a.size();
    }
}
