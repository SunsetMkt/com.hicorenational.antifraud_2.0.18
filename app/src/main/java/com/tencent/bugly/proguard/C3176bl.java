package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bl */
/* loaded from: classes2.dex */
public final class C3176bl extends AbstractC3188m {

    /* renamed from: i */
    static Map<String, String> f10712i = new HashMap();

    /* renamed from: a */
    public long f10713a = 0;

    /* renamed from: b */
    public byte f10714b = 0;

    /* renamed from: c */
    public String f10715c = "";

    /* renamed from: d */
    public String f10716d = "";

    /* renamed from: e */
    public String f10717e = "";

    /* renamed from: f */
    public Map<String, String> f10718f = null;

    /* renamed from: g */
    public String f10719g = "";

    /* renamed from: h */
    public boolean f10720h = true;

    static {
        f10712i.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10103a(this.f10713a, 0);
        c3187l.m10118b(this.f10714b, 1);
        String str = this.f10715c;
        if (str != null) {
            c3187l.m10106a(str, 2);
        }
        String str2 = this.f10716d;
        if (str2 != null) {
            c3187l.m10106a(str2, 3);
        }
        String str3 = this.f10717e;
        if (str3 != null) {
            c3187l.m10106a(str3, 4);
        }
        Map<String, String> map = this.f10718f;
        if (map != null) {
            c3187l.m10108a((Map) map, 5);
        }
        String str4 = this.f10719g;
        if (str4 != null) {
            c3187l.m10106a(str4, 6);
        }
        c3187l.m10110a(this.f10720h, 7);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10713a = c3186k.m10075a(this.f10713a, 0, true);
        this.f10714b = c3186k.m10070a(this.f10714b, 1, true);
        this.f10715c = c3186k.m10078a(2, false);
        this.f10716d = c3186k.m10078a(3, false);
        this.f10717e = c3186k.m10078a(4, false);
        this.f10718f = (Map) c3186k.m10077a((C3186k) f10712i, 5, false);
        this.f10719g = c3186k.m10078a(6, false);
        this.f10720h = c3186k.m10086a(this.f10720h, 7, false);
    }
}
