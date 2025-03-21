package com.huawei.hms.hatool;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.d1 */
/* loaded from: classes.dex */
public class C2405d1 implements InterfaceRunnableC2412g {

    /* renamed from: a */
    private String f7489a;

    /* renamed from: b */
    private String f7490b;

    /* renamed from: c */
    private String f7491c;

    /* renamed from: d */
    private List<C2399b1> f7492d;

    public C2405d1(List<C2399b1> list, String str, String str2, String str3) {
        this.f7489a = str;
        this.f7490b = str2;
        this.f7491c = str3;
        this.f7492d = list;
    }

    /* renamed from: a */
    private void m7076a() {
        C2403d.m7071a(AbstractC2443q0.m7311i(), "backup_event", AbstractC2435n1.m7254a(this.f7489a, this.f7491c, this.f7490b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<C2399b1> list = this.f7492d;
        if (list == null || list.size() == 0) {
            C2452v.m7387d("hmsSdk", "failed events is empty");
            return;
        }
        if (C2401c0.m7059a(AbstractC2443q0.m7311i(), "cached_v2_1", AbstractC2443q0.m7313k() * 1048576)) {
            C2452v.m7389e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f7490b);
            return;
        }
        String m7253a = AbstractC2435n1.m7253a(this.f7489a, this.f7491c);
        List<C2399b1> list2 = C2402c1.m7066b(AbstractC2443q0.m7311i(), "cached_v2_1", m7253a).get(m7253a);
        if (list2 != null && list2.size() != 0) {
            this.f7492d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<C2399b1> it = this.f7492d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().m7051d());
            } catch (JSONException unused) {
                C2452v.m7389e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > AbstractC2443q0.m7309h() * 1048576) {
            C2452v.m7389e("hmsSdk", "this failed data is too long,can not writing it");
            this.f7492d = null;
            return;
        }
        C2452v.m7387d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f7490b);
        C2403d.m7074b(AbstractC2443q0.m7311i(), "cached_v2_1", m7253a, jSONArray2);
        m7076a();
    }
}
