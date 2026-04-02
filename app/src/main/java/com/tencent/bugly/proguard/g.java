package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f6535g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f6537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f6538j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f6529m = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static byte[] f6527k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static Map<String, String> f6528l = null;
    public short a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f6530b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6531c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6532d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6533e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6534f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6536h = 0;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 1);
        lVar.b(this.f6530b, 2);
        lVar.a(this.f6531c, 3);
        lVar.a(this.f6532d, 4);
        lVar.a(this.f6533e, 5);
        lVar.a(this.f6534f, 6);
        lVar.a(this.f6535g, 7);
        lVar.a(this.f6536h, 8);
        lVar.a((Map) this.f6537i, 9);
        lVar.a((Map) this.f6538j, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6529m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        g gVar = (g) obj;
        return n.a(1, (int) gVar.a) && n.a(1, (int) gVar.f6530b) && n.a(1, gVar.f6531c) && n.a(1, gVar.f6532d) && n.a((Object) 1, (Object) gVar.f6533e) && n.a((Object) 1, (Object) gVar.f6534f) && n.a((Object) 1, (Object) gVar.f6535g) && n.a(1, gVar.f6536h) && n.a((Object) 1, (Object) gVar.f6537i) && n.a((Object) 1, (Object) gVar.f6538j);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        try {
            this.a = kVar.a(this.a, 1, true);
            this.f6530b = kVar.a(this.f6530b, 2, true);
            this.f6531c = kVar.a(this.f6531c, 3, true);
            this.f6532d = kVar.a(this.f6532d, 4, true);
            this.f6533e = kVar.a(5, true);
            this.f6534f = kVar.a(6, true);
            if (f6527k == null) {
                f6527k = new byte[]{0};
            }
            this.f6535g = kVar.a(f6527k, 7, true);
            this.f6536h = kVar.a(this.f6536h, 8, true);
            if (f6528l == null) {
                f6528l = new HashMap();
                f6528l.put("", "");
            }
            this.f6537i = (Map) kVar.a(f6528l, 9, true);
            if (f6528l == null) {
                f6528l = new HashMap();
                f6528l.put("", "");
            }
            this.f6538j = (Map) kVar.a(f6528l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + f.a(this.f6535g));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "iVersion");
        iVar.a(this.f6530b, "cPacketType");
        iVar.a(this.f6531c, "iMessageType");
        iVar.a(this.f6532d, "iRequestId");
        iVar.a(this.f6533e, "sServantName");
        iVar.a(this.f6534f, "sFuncName");
        iVar.a(this.f6535g, "sBuffer");
        iVar.a(this.f6536h, "iTimeout");
        iVar.a((Map) this.f6537i, com.umeng.analytics.pro.d.R);
        iVar.a((Map) this.f6538j, NotificationCompat.CATEGORY_STATUS);
    }
}
