package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class AlicloudTracker {

    /* renamed from: a */
    private C1565a f4023a;

    /* renamed from: a */
    private String f4024a;

    /* renamed from: a */
    private Map<String, String> f4025a = new HashMap();

    /* renamed from: b */
    private String f4026b;

    AlicloudTracker(C1565a c1565a, String str, String str2) {
        this.f4023a = c1565a;
        this.f4024a = str;
        this.f4026b = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f4025a.containsKey(str)) {
            return;
        }
        this.f4025a.remove(str);
    }

    public void sendCustomHit(String str, long j2, Map<String, String> map) {
        try {
            if (this.f4023a == null) {
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f4025a);
            map.put("sdkId", this.f4024a);
            map.put("sdkVersion", this.f4026b);
            this.f4023a.sendCustomHit(this.f4024a + AbstractC1191a.f2606s1 + str, j2, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.f4025a.containsKey(str)) {
            this.f4025a.remove(str);
        }
        this.f4025a.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
