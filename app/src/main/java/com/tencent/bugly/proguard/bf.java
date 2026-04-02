package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bf extends m {
    static ArrayList<be> A;
    static Map<String, String> B;
    static Map<String, String> C;
    static Map<String, String> v = new HashMap();
    static bd w;
    static bc x;
    static ArrayList<bc> y;
    static ArrayList<bc> z;
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6451b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6452c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6453d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6454e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6455f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6456g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f6457h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6458i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public bd f6459j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6460k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6461l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f6462m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public bc f6463n = null;
    public ArrayList<bc> o = null;
    public ArrayList<bc> p = null;
    public ArrayList<be> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    public String t = "";
    public boolean u = true;

    static {
        v.put("", "");
        w = new bd();
        x = new bc();
        y = new ArrayList<>();
        y.add(new bc());
        z = new ArrayList<>();
        z.add(new bc());
        A = new ArrayList<>();
        A.add(new be());
        B = new HashMap();
        B.put("", "");
        C = new HashMap();
        C.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.f6451b, 1);
        lVar.a(this.f6452c, 2);
        String str = this.f6453d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f6454e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f6455f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f6456g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f6457h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f6458i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bd bdVar = this.f6459j;
        if (bdVar != null) {
            lVar.a((m) bdVar, 9);
        }
        lVar.a(this.f6460k, 10);
        String str6 = this.f6461l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f6462m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bc bcVar = this.f6463n;
        if (bcVar != null) {
            lVar.a((m) bcVar, 13);
        }
        ArrayList<bc> arrayList = this.o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bc> arrayList2 = this.p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<be> arrayList3 = this.q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        this.f6451b = kVar.a(this.f6451b, 1, true);
        this.f6452c = kVar.a(2, true);
        this.f6453d = kVar.a(3, false);
        this.f6454e = kVar.a(4, false);
        this.f6455f = kVar.a(5, false);
        this.f6456g = kVar.a(6, false);
        this.f6457h = (Map) kVar.a(v, 7, false);
        this.f6458i = kVar.a(8, false);
        this.f6459j = (bd) kVar.a((m) w, 9, false);
        this.f6460k = kVar.a(this.f6460k, 10, false);
        this.f6461l = kVar.a(11, false);
        this.f6462m = kVar.a(12, false);
        this.f6463n = (bc) kVar.a((m) x, 13, false);
        this.o = (ArrayList) kVar.a(y, 14, false);
        this.p = (ArrayList) kVar.a(z, 15, false);
        this.q = (ArrayList) kVar.a(A, 16, false);
        this.r = (Map) kVar.a(B, 17, false);
        this.s = (Map) kVar.a(C, 18, false);
        this.t = kVar.a(19, false);
        this.u = kVar.a(this.u, 20, false);
    }
}
