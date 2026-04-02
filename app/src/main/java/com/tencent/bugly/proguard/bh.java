package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bh extends m {
    static byte[] y = new byte[1];
    static Map<String, String> z;
    public int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6465b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6466c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6467d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6468e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6469f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6470g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f6471h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6472i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6473j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f6474k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6475l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6476m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f6477n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";

    static {
        y[0] = 0;
        z = new HashMap();
        z.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.f6465b, 1);
        lVar.a(this.f6466c, 2);
        lVar.a(this.f6467d, 3);
        String str = this.f6468e;
        if (str != null) {
            lVar.a(str, 4);
        }
        lVar.a(this.f6469f, 5);
        lVar.a(this.f6470g, 6);
        lVar.a(this.f6471h, 7);
        String str2 = this.f6472i;
        if (str2 != null) {
            lVar.a(str2, 8);
        }
        String str3 = this.f6473j;
        if (str3 != null) {
            lVar.a(str3, 9);
        }
        Map<String, String> map = this.f6474k;
        if (map != null) {
            lVar.a((Map) map, 10);
        }
        String str4 = this.f6475l;
        if (str4 != null) {
            lVar.a(str4, 11);
        }
        lVar.a(this.f6476m, 12);
        String str5 = this.f6477n;
        if (str5 != null) {
            lVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            lVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            lVar.a(str7, 15);
        }
        lVar.a(this.q, 16);
        String str8 = this.r;
        if (str8 != null) {
            lVar.a(str8, 17);
        }
        String str9 = this.s;
        if (str9 != null) {
            lVar.a(str9, 18);
        }
        String str10 = this.t;
        if (str10 != null) {
            lVar.a(str10, 19);
        }
        String str11 = this.u;
        if (str11 != null) {
            lVar.a(str11, 20);
        }
        String str12 = this.v;
        if (str12 != null) {
            lVar.a(str12, 21);
        }
        String str13 = this.w;
        if (str13 != null) {
            lVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            lVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.f6465b = kVar.a(1, true);
        this.f6466c = kVar.a(2, true);
        this.f6467d = kVar.a(3, true);
        this.f6468e = kVar.a(4, false);
        this.f6469f = kVar.a(5, true);
        this.f6470g = kVar.a(this.f6470g, 6, true);
        this.f6471h = kVar.a(y, 7, true);
        this.f6472i = kVar.a(8, false);
        this.f6473j = kVar.a(9, false);
        this.f6474k = (Map) kVar.a(z, 10, false);
        this.f6475l = kVar.a(11, false);
        this.f6476m = kVar.a(this.f6476m, 12, false);
        this.f6477n = kVar.a(13, false);
        this.o = kVar.a(14, false);
        this.p = kVar.a(15, false);
        this.q = kVar.a(this.q, 16, false);
        this.r = kVar.a(17, false);
        this.s = kVar.a(18, false);
        this.t = kVar.a(19, false);
        this.u = kVar.a(20, false);
        this.v = kVar.a(21, false);
        this.w = kVar.a(22, false);
        this.x = kVar.a(23, false);
    }
}
