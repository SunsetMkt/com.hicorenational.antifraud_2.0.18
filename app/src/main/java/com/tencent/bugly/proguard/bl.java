package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bl extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static Map<String, String> f6501i = new HashMap();
    public long a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f6502b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6503c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6504d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6505e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f6506f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6507g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6508h = true;

    static {
        f6501i.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.b(this.f6502b, 1);
        String str = this.f6503c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f6504d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f6505e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f6506f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f6507g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f6508h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.f6502b = kVar.a(this.f6502b, 1, true);
        this.f6503c = kVar.a(2, false);
        this.f6504d = kVar.a(3, false);
        this.f6505e = kVar.a(4, false);
        this.f6506f = (Map) kVar.a(f6501i, 5, false);
        this.f6507g = kVar.a(6, false);
        this.f6508h = kVar.a(this.f6508h, 7, false);
    }
}
