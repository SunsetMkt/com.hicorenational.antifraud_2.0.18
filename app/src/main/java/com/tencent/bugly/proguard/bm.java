package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bm extends m implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static ArrayList<bl> f6509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Map<String, String> f6510g;
    public byte a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6511b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6512c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<bl> f6513d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f6514e = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.b(this.a, 0);
        String str = this.f6511b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f6512c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bl> arrayList = this.f6513d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f6514e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.f6511b = kVar.a(1, false);
        this.f6512c = kVar.a(2, false);
        if (f6509f == null) {
            f6509f = new ArrayList<>();
            f6509f.add(new bl());
        }
        this.f6513d = (ArrayList) kVar.a(f6509f, 3, false);
        if (f6510g == null) {
            f6510g = new HashMap();
            f6510g.put("", "");
        }
        this.f6514e = (Map) kVar.a(f6510g, 4, false);
    }
}
