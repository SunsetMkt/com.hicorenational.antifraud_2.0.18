package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class z extends m implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Map<String, String> f6608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f6609f = !z.class.desiredAssertionStatus();
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f6612d;

    public z() {
        this.a = 0;
        this.f6610b = "";
        this.f6611c = 0L;
        this.f6612d = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        String str = this.f6610b;
        if (str != null) {
            lVar.a(str, 1);
        }
        lVar.a(this.f6611c, 2);
        Map<String, String> map = this.f6612d;
        if (map != null) {
            lVar.a((Map) map, 3);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6609f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        z zVar = (z) obj;
        return n.a(this.a, zVar.a) && n.a(this.f6610b, zVar.f6610b) && n.a(this.f6611c, zVar.f6611c) && n.a(this.f6612d, zVar.f6612d);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public z(int i2, String str, long j2, Map<String, String> map) {
        this.a = 0;
        this.f6610b = "";
        this.f6611c = 0L;
        this.f6612d = null;
        this.a = i2;
        this.f6610b = str;
        this.f6611c = j2;
        this.f6612d = map;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, false);
        this.f6610b = kVar.a(1, false);
        this.f6611c = kVar.a(this.f6611c, 2, false);
        if (f6608e == null) {
            f6608e = new HashMap();
            f6608e.put("", "");
        }
        this.f6612d = (Map) kVar.a(f6608e, 3, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, AgooConstants.MESSAGE_FLAG);
        iVar.a(this.f6610b, "localStrategyId");
        iVar.a(this.f6611c, "localStrategyTime");
        iVar.a((Map) this.f6612d, "reserved");
    }
}
