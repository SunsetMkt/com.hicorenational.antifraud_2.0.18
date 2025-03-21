package com.tencent.bugly.crashreport.crash.p206h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.h5.a */
/* loaded from: classes2.dex */
public class C3131a {

    /* renamed from: a */
    public String f10423a = null;

    /* renamed from: b */
    public String f10424b = null;

    /* renamed from: c */
    public String f10425c = null;

    /* renamed from: d */
    public String f10426d = null;

    /* renamed from: e */
    public String f10427e = null;

    /* renamed from: f */
    public String f10428f = null;

    /* renamed from: g */
    public String f10429g = null;

    /* renamed from: h */
    public String f10430h = null;

    /* renamed from: i */
    public String f10431i = null;

    /* renamed from: j */
    public long f10432j = 0;

    /* renamed from: k */
    public long f10433k = 0;

    /* renamed from: a */
    public Map<String, String> m9762a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f10423a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f10424b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f10425c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f10426d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f10431i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j2 = this.f10432j;
        if (j2 != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j2));
        }
        return linkedHashMap;
    }
}
