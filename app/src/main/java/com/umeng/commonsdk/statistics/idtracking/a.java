package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: AbstractIdTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private final int a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7705b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f7707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f7708e;

    public a(String str) {
        this.f7706c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f7708e;
        String strB = bVar == null ? null : bVar.b();
        int iH = bVar == null ? 0 : bVar.h();
        String strA = a(f());
        if (strA == null || strA.equals(strB)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(strA);
        bVar.a(System.currentTimeMillis());
        bVar.a(iH + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f7706c);
        aVar.c(strA);
        aVar.b(strB);
        aVar.a(bVar.e());
        if (this.f7707d == null) {
            this.f7707d = new ArrayList(2);
        }
        this.f7707d.add(aVar);
        if (this.f7707d.size() > 10) {
            this.f7707d.remove(0);
        }
        this.f7708e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f7706c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f7708e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f7708e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f7707d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f7708e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f7707d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0 || "0".equals(strTrim) || "unknown".equals(strTrim.toLowerCase(Locale.US))) {
            return null;
        }
        return strTrim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f7708e = cVar.c().get(this.f7706c);
        List<com.umeng.commonsdk.statistics.proto.a> listH = cVar.h();
        if (listH == null || listH.size() <= 0) {
            return;
        }
        if (this.f7707d == null) {
            this.f7707d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : listH) {
            if (this.f7706c.equals(aVar.a)) {
                this.f7707d.add(aVar);
            }
        }
    }
}
