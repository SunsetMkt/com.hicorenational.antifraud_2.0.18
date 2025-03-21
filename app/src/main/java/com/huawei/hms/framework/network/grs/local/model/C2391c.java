package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.c */
/* loaded from: classes.dex */
public class C2391c {

    /* renamed from: a */
    private String f7451a;

    /* renamed from: b */
    private final Map<String, C2392d> f7452b = new ConcurrentHashMap(16);

    /* renamed from: c */
    private List<C2390b> f7453c = new ArrayList(16);

    /* renamed from: a */
    public C2392d m7001a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f7452b.get(str);
        }
        Logger.m6803w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    /* renamed from: a */
    public List<C2390b> m7002a() {
        return this.f7453c;
    }

    /* renamed from: a */
    public void m7003a(String str, C2392d c2392d) {
        if (TextUtils.isEmpty(str) || c2392d == null) {
            return;
        }
        this.f7452b.put(str, c2392d);
    }

    /* renamed from: a */
    public void m7004a(List<C2390b> list) {
        this.f7453c = list;
    }

    /* renamed from: b */
    public String m7005b() {
        return this.f7451a;
    }

    /* renamed from: b */
    public void m7006b(String str) {
    }

    /* renamed from: c */
    public void m7007c(String str) {
        this.f7451a = str;
    }
}
