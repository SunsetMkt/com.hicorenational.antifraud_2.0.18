package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AbstractIdTracker.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f10919a = 10;

    /* renamed from: b, reason: collision with root package name */
    private final int f10920b = 100;

    /* renamed from: c, reason: collision with root package name */
    private final String f10921c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f10922d;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f10923e;

    public a(String str) {
        this.f10921c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f10923e;
        String b2 = bVar == null ? null : bVar.b();
        int h2 = bVar == null ? 0 : bVar.h();
        String a2 = a(f());
        if (a2 == null || a2.equals(b2)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a2);
        bVar.a(System.currentTimeMillis());
        bVar.a(h2 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f10921c);
        aVar.c(a2);
        aVar.b(b2);
        aVar.a(bVar.e());
        if (this.f10922d == null) {
            this.f10922d = new ArrayList(2);
        }
        this.f10922d.add(aVar);
        if (this.f10922d.size() > 10) {
            this.f10922d.remove(0);
        }
        this.f10923e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f10921c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f10923e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f10923e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f10922d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f10923e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f10922d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f10923e = cVar.c().get(this.f10921c);
        List<com.umeng.commonsdk.statistics.proto.a> h2 = cVar.h();
        if (h2 == null || h2.size() <= 0) {
            return;
        }
        if (this.f10922d == null) {
            this.f10922d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h2) {
            if (this.f10921c.equals(aVar.f10985a)) {
                this.f10922d.add(aVar);
            }
        }
    }
}
