package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bk extends m implements Cloneable {
    public boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6490b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6491c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6492d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6493e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public bj f6494f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f6495g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6496h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6497i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6498j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6499k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6500l = 0;
    static final /* synthetic */ boolean o = !bk.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static bj f6488m = new bj();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static Map<String, String> f6489n = new HashMap();

    static {
        f6489n.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.f6490b, 1);
        lVar.a(this.f6491c, 2);
        String str = this.f6492d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f6493e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bj bjVar = this.f6494f;
        if (bjVar != null) {
            lVar.a((m) bjVar, 5);
        }
        Map<String, String> map = this.f6495g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f6496h, 7);
        String str3 = this.f6497i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f6498j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f6499k, 10);
        lVar.a(this.f6500l, 11);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bk bkVar = (bk) obj;
        return n.a(this.a, bkVar.a) && n.a(this.f6490b, bkVar.f6490b) && n.a(this.f6491c, bkVar.f6491c) && n.a(this.f6492d, bkVar.f6492d) && n.a(this.f6493e, bkVar.f6493e) && n.a(this.f6494f, bkVar.f6494f) && n.a(this.f6495g, bkVar.f6495g) && n.a(this.f6496h, bkVar.f6496h) && n.a(this.f6497i, bkVar.f6497i) && n.a(this.f6498j, bkVar.f6498j) && n.a(this.f6499k, bkVar.f6499k) && n.a(this.f6500l, bkVar.f6500l);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.f6490b = kVar.a(this.f6490b, 1, true);
        this.f6491c = kVar.a(this.f6491c, 2, true);
        this.f6492d = kVar.a(3, false);
        this.f6493e = kVar.a(4, false);
        this.f6494f = (bj) kVar.a((m) f6488m, 5, false);
        this.f6495g = (Map) kVar.a(f6489n, 6, false);
        this.f6496h = kVar.a(this.f6496h, 7, false);
        this.f6497i = kVar.a(8, false);
        this.f6498j = kVar.a(9, false);
        this.f6499k = kVar.a(this.f6499k, 10, false);
        this.f6500l = kVar.a(this.f6500l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "enable");
        iVar.a(this.f6490b, "enableUserInfo");
        iVar.a(this.f6491c, "enableQuery");
        iVar.a(this.f6492d, "url");
        iVar.a(this.f6493e, "expUrl");
        iVar.a((m) this.f6494f, "security");
        iVar.a((Map) this.f6495g, "valueMap");
        iVar.a(this.f6496h, "strategylastUpdateTime");
        iVar.a(this.f6497i, "httpsUrl");
        iVar.a(this.f6498j, "httpsExpUrl");
        iVar.a(this.f6499k, "eventRecordCount");
        iVar.a(this.f6500l, "eventTimeInterval");
    }
}
