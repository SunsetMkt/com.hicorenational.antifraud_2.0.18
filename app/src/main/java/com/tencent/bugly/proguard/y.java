package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class y extends m implements Cloneable {
    static v q;
    static u r;
    static u s;
    static Map<String, String> t;
    static final /* synthetic */ boolean u = !y.class.desiredAssertionStatus();
    public String a;

    /* JADX INFO: renamed from: b */
    public String f6595b;

    /* JADX INFO: renamed from: c */
    public long f6596c;

    /* JADX INFO: renamed from: d */
    public int f6597d;

    /* JADX INFO: renamed from: e */
    public v f6598e;

    /* JADX INFO: renamed from: f */
    public u f6599f;

    /* JADX INFO: renamed from: g */
    public byte f6600g;

    /* JADX INFO: renamed from: h */
    public int f6601h;

    /* JADX INFO: renamed from: i */
    public long f6602i;

    /* JADX INFO: renamed from: j */
    public u f6603j;

    /* JADX INFO: renamed from: k */
    public String f6604k;

    /* JADX INFO: renamed from: l */
    public Map<String, String> f6605l;

    /* JADX INFO: renamed from: m */
    public String f6606m;

    /* JADX INFO: renamed from: n */
    public int f6607n;
    public long o;
    public int p;

    public y() {
        this.a = "";
        this.f6595b = "";
        this.f6596c = 0L;
        this.f6597d = 0;
        this.f6598e = null;
        this.f6599f = null;
        this.f6600g = (byte) 0;
        this.f6601h = 0;
        this.f6602i = 0L;
        this.f6603j = null;
        this.f6604k = "";
        this.f6605l = null;
        this.f6606m = "";
        this.f6607n = 0;
        this.o = 0L;
        this.p = 0;
    }

    public long a() {
        return this.f6596c;
    }

    public u b() {
        return this.f6599f;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (u) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        y yVar = (y) obj;
        return n.a(this.a, yVar.a) && n.a(this.f6595b, yVar.f6595b) && n.a(this.f6596c, yVar.f6596c) && n.a(this.f6597d, yVar.f6597d) && n.a(this.f6598e, yVar.f6598e) && n.a(this.f6599f, yVar.f6599f) && n.a(this.f6600g, yVar.f6600g) && n.a(this.f6601h, yVar.f6601h) && n.a(this.f6602i, yVar.f6602i) && n.a(this.f6603j, yVar.f6603j) && n.a(this.f6604k, yVar.f6604k) && n.a(this.f6605l, yVar.f6605l) && n.a(this.f6606m, yVar.f6606m) && n.a(this.f6607n, yVar.f6607n) && n.a(this.o, yVar.o) && n.a(this.p, yVar.p);
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
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.f6595b, 1);
        lVar.a(this.f6596c, 2);
        lVar.a(this.f6597d, 3);
        lVar.a((m) this.f6598e, 4);
        lVar.a((m) this.f6599f, 5);
        lVar.b(this.f6600g, 6);
        lVar.a(this.f6601h, 7);
        lVar.a(this.f6602i, 8);
        u uVar = this.f6603j;
        if (uVar != null) {
            lVar.a((m) uVar, 9);
        }
        String str = this.f6604k;
        if (str != null) {
            lVar.a(str, 10);
        }
        Map<String, String> map = this.f6605l;
        if (map != null) {
            lVar.a((Map) map, 11);
        }
        String str2 = this.f6606m;
        if (str2 != null) {
            lVar.a(str2, 12);
        }
        lVar.a(this.f6607n, 13);
        lVar.a(this.o, 14);
        lVar.a(this.p, 15);
    }

    public y(String str, String str2, long j2, int i2, v vVar, u uVar, byte b2, int i3, long j3, u uVar2, String str3, Map<String, String> map, String str4, int i4, long j4, int i5) {
        this.a = "";
        this.f6595b = "";
        this.f6596c = 0L;
        this.f6597d = 0;
        this.f6598e = null;
        this.f6599f = null;
        this.f6600g = (byte) 0;
        this.f6601h = 0;
        this.f6602i = 0L;
        this.f6603j = null;
        this.f6604k = "";
        this.f6605l = null;
        this.f6606m = "";
        this.f6607n = 0;
        this.o = 0L;
        this.p = 0;
        this.a = str;
        this.f6595b = str2;
        this.f6596c = j2;
        this.f6597d = i2;
        this.f6598e = vVar;
        this.f6599f = uVar;
        this.f6600g = b2;
        this.f6601h = i3;
        this.f6602i = j3;
        this.f6603j = uVar2;
        this.f6604k = str3;
        this.f6605l = map;
        this.f6606m = str4;
        this.f6607n = i4;
        this.o = j4;
        this.p = i5;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        this.f6595b = kVar.a(1, true);
        this.f6596c = kVar.a(this.f6596c, 2, true);
        this.f6597d = kVar.a(this.f6597d, 3, true);
        if (q == null) {
            q = new v();
        }
        this.f6598e = (v) kVar.a((m) q, 4, true);
        if (r == null) {
            r = new u();
        }
        this.f6599f = (u) kVar.a((m) r, 5, true);
        this.f6600g = kVar.a(this.f6600g, 6, true);
        this.f6601h = kVar.a(this.f6601h, 7, false);
        this.f6602i = kVar.a(this.f6602i, 8, false);
        if (s == null) {
            s = new u();
        }
        this.f6603j = (u) kVar.a((m) s, 9, false);
        this.f6604k = kVar.a(10, false);
        if (t == null) {
            t = new HashMap();
            t.put("", "");
        }
        this.f6605l = (Map) kVar.a(t, 11, false);
        this.f6606m = kVar.a(12, false);
        this.f6607n = kVar.a(this.f6607n, 13, false);
        this.o = kVar.a(this.o, 14, false);
        this.p = kVar.a(this.p, 15, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "title");
        iVar.a(this.f6595b, "newFeature");
        iVar.a(this.f6596c, "publishTime");
        iVar.a(this.f6597d, "publishType");
        iVar.a((m) this.f6598e, "appBasicInfo");
        iVar.a((m) this.f6599f, "apkBaseInfo");
        iVar.a(this.f6600g, "updateStrategy");
        iVar.a(this.f6601h, "popTimes");
        iVar.a(this.f6602i, "popInterval");
        iVar.a((m) this.f6603j, "diffApkInfo");
        iVar.a(this.f6604k, "netType");
        iVar.a((Map) this.f6605l, "reserved");
        iVar.a(this.f6606m, "strategyId");
        iVar.a(this.f6607n, NotificationCompat.CATEGORY_STATUS);
        iVar.a(this.o, "updateTime");
        iVar.a(this.p, "updateType");
    }
}
