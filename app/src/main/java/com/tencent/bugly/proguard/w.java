package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends m implements Cloneable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static v f6583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static Map<String, String> f6584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ boolean f6585k = !w.class.desiredAssertionStatus();
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f6587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f6589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f6592h;

    public w() {
        this.a = "";
        this.f6586b = 0L;
        this.f6587c = (byte) 0;
        this.f6588d = 0L;
        this.f6589e = null;
        this.f6590f = "";
        this.f6591g = 0;
        this.f6592h = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.f6586b, 1);
        lVar.b(this.f6587c, 2);
        lVar.a(this.f6588d, 3);
        v vVar = this.f6589e;
        if (vVar != null) {
            lVar.a((m) vVar, 4);
        }
        String str = this.f6590f;
        if (str != null) {
            lVar.a(str, 5);
        }
        lVar.a(this.f6591g, 6);
        Map<String, String> map = this.f6592h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6585k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        w wVar = (w) obj;
        return n.a(this.a, wVar.a) && n.a(this.f6586b, wVar.f6586b) && n.a(this.f6587c, wVar.f6587c) && n.a(this.f6588d, wVar.f6588d) && n.a(this.f6589e, wVar.f6589e) && n.a(this.f6590f, wVar.f6590f) && n.a(this.f6591g, wVar.f6591g) && n.a(this.f6592h, wVar.f6592h);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public w(String str, long j2, byte b2, long j3, v vVar, String str2, int i2, Map<String, String> map) {
        this.a = "";
        this.f6586b = 0L;
        this.f6587c = (byte) 0;
        this.f6588d = 0L;
        this.f6589e = null;
        this.f6590f = "";
        this.f6591g = 0;
        this.f6592h = null;
        this.a = str;
        this.f6586b = j2;
        this.f6587c = b2;
        this.f6588d = j3;
        this.f6589e = vVar;
        this.f6590f = str2;
        this.f6591g = i2;
        this.f6592h = map;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        this.f6586b = kVar.a(this.f6586b, 1, true);
        this.f6587c = kVar.a(this.f6587c, 2, true);
        this.f6588d = kVar.a(this.f6588d, 3, false);
        if (f6583i == null) {
            f6583i = new v();
        }
        this.f6589e = (v) kVar.a((m) f6583i, 4, false);
        this.f6590f = kVar.a(5, false);
        this.f6591g = kVar.a(this.f6591g, 6, false);
        if (f6584j == null) {
            f6584j = new HashMap();
            f6584j.put("", "");
        }
        this.f6592h = (Map) kVar.a(f6584j, 7, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "eventType");
        iVar.a(this.f6586b, "eventTime");
        iVar.a(this.f6587c, "eventResult");
        iVar.a(this.f6588d, "eventElapse");
        iVar.a((m) this.f6589e, "destAppInfo");
        iVar.a(this.f6590f, "strategyId");
        iVar.a(this.f6591g, "updateType");
        iVar.a((Map) this.f6592h, "reserved");
    }
}
