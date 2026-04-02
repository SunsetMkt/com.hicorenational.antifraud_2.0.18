package com.tencent.bugly.crashreport.crash.h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6305b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6306c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6307d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6308e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6309f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6310g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6311h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6312i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6313j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f6314k = 0;

    public Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f6305b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f6306c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f6307d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f6312i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j2 = this.f6313j;
        if (j2 != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j2));
        }
        return linkedHashMap;
    }
}
