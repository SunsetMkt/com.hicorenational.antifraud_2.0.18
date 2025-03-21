package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.u */
/* loaded from: classes.dex */
public class C2450u {

    /* renamed from: a */
    private List<C2399b1> f7634a;

    /* renamed from: b */
    private String f7635b;

    /* renamed from: c */
    private String f7636c;

    /* renamed from: d */
    private String f7637d;

    public C2450u(List<C2399b1> list, String str, String str2, String str3) {
        this.f7634a = list;
        this.f7635b = str;
        this.f7636c = str2;
        this.f7637d = str3;
    }

    /* renamed from: a */
    private void m7371a(List<C2399b1> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 * 500;
            List<C2399b1> subList = list.subList(i3, Math.min(list.size(), i3 + 500));
            String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            long currentTimeMillis = System.currentTimeMillis();
            long m7020b = AbstractC2396a1.m7020b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (C2399b1 c2399b1 : subList) {
                if (!C2401c0.m7060a(c2399b1.m7047b(), currentTimeMillis, m7020b)) {
                    arrayList.add(c2399b1);
                }
            }
            if (arrayList.size() > 0) {
                new C2428l0(str2, str, this.f7637d, arrayList, replace).m7218a();
            } else {
                C2452v.m7389e("hmsSdk", "No data to report handler");
            }
        }
    }

    /* renamed from: a */
    public void m7372a() {
        if (!"_default_config_tag".equals(this.f7636c)) {
            m7371a(this.f7634a, this.f7636c, this.f7635b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C2399b1 c2399b1 : this.f7634a) {
            String m7049c = c2399b1.m7049c();
            if (TextUtils.isEmpty(m7049c) || "oper".equals(m7049c)) {
                arrayList4.add(c2399b1);
            } else if ("maint".equals(m7049c)) {
                arrayList.add(c2399b1);
            } else if ("preins".equals(m7049c)) {
                arrayList2.add(c2399b1);
            } else if ("diffprivacy".equals(m7049c)) {
                arrayList3.add(c2399b1);
            }
        }
        m7371a(arrayList4, "oper", "_default_config_tag");
        m7371a(arrayList, "maint", "_default_config_tag");
        m7371a(arrayList2, "preins", "_default_config_tag");
        m7371a(arrayList3, "diffprivacy", "_default_config_tag");
    }
}
