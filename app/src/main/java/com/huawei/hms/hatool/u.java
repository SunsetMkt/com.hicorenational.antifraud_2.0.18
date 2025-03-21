package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private List<b1> f7104a;

    /* renamed from: b, reason: collision with root package name */
    private String f7105b;

    /* renamed from: c, reason: collision with root package name */
    private String f7106c;

    /* renamed from: d, reason: collision with root package name */
    private String f7107d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.f7104a = list;
        this.f7105b = str;
        this.f7106c = str2;
        this.f7107d = str3;
    }

    private void a(List<b1> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 * 500;
            List<b1> subList = list.subList(i3, Math.min(list.size(), i3 + 500));
            String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = a1.b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (b1 b1Var : subList) {
                if (!c0.a(b1Var.b(), currentTimeMillis, b2)) {
                    arrayList.add(b1Var);
                }
            }
            if (arrayList.size() > 0) {
                new l0(str2, str, this.f7107d, arrayList, replace).a();
            } else {
                v.e("hmsSdk", "No data to report handler");
            }
        }
    }

    public void a() {
        if (!"_default_config_tag".equals(this.f7106c)) {
            a(this.f7104a, this.f7106c, this.f7105b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (b1 b1Var : this.f7104a) {
            String c2 = b1Var.c();
            if (TextUtils.isEmpty(c2) || "oper".equals(c2)) {
                arrayList4.add(b1Var);
            } else if ("maint".equals(c2)) {
                arrayList.add(b1Var);
            } else if ("preins".equals(c2)) {
                arrayList2.add(b1Var);
            } else if ("diffprivacy".equals(c2)) {
                arrayList3.add(b1Var);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }
}
