package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bi */
/* loaded from: classes2.dex */
public final class C3173bi extends AbstractC3188m {

    /* renamed from: i */
    static byte[] f10685i = new byte[1];

    /* renamed from: j */
    static Map<String, String> f10686j;

    /* renamed from: a */
    public byte f10687a = 0;

    /* renamed from: b */
    public int f10688b = 0;

    /* renamed from: c */
    public byte[] f10689c = null;

    /* renamed from: d */
    public String f10690d = "";

    /* renamed from: e */
    public long f10691e = 0;

    /* renamed from: f */
    public String f10692f = "";

    /* renamed from: g */
    public String f10693g = "";

    /* renamed from: h */
    public Map<String, String> f10694h = null;

    static {
        f10685i[0] = 0;
        f10686j = new HashMap();
        f10686j.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10118b(this.f10687a, 0);
        c3187l.m10102a(this.f10688b, 1);
        byte[] bArr = this.f10689c;
        if (bArr != null) {
            c3187l.m10111a(bArr, 2);
        }
        String str = this.f10690d;
        if (str != null) {
            c3187l.m10106a(str, 3);
        }
        c3187l.m10103a(this.f10691e, 4);
        String str2 = this.f10692f;
        if (str2 != null) {
            c3187l.m10106a(str2, 5);
        }
        String str3 = this.f10693g;
        if (str3 != null) {
            c3187l.m10106a(str3, 6);
        }
        Map<String, String> map = this.f10694h;
        if (map != null) {
            c3187l.m10108a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10687a = c3186k.m10070a(this.f10687a, 0, true);
        this.f10688b = c3186k.m10073a(this.f10688b, 1, true);
        this.f10689c = c3186k.m10087a(f10685i, 2, false);
        this.f10690d = c3186k.m10078a(3, false);
        this.f10691e = c3186k.m10075a(this.f10691e, 4, false);
        this.f10692f = c3186k.m10078a(5, false);
        this.f10693g = c3186k.m10078a(6, false);
        this.f10694h = (Map) c3186k.m10077a((C3186k) f10686j, 7, false);
    }
}
