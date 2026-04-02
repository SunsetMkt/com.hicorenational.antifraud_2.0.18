package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTracker {
    private a a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f40a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, String> f41a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2623b;

    AlicloudTracker(a aVar, String str, String str2) {
        this.a = aVar;
        this.f40a = str;
        this.f2623b = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f41a.containsKey(str)) {
            return;
        }
        this.f41a.remove(str);
    }

    public void sendCustomHit(String str, long j2, Map<String, String> map) {
        try {
            if (this.a == null) {
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f41a);
            map.put("sdkId", this.f40a);
            map.put("sdkVersion", this.f2623b);
            this.a.sendCustomHit(this.f40a + d.c.a.b.a.a.s1 + str, j2, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.f41a.containsKey(str)) {
            this.f41a.remove(str);
        }
        this.f41a.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
