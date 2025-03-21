package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.proto.C3523a;
import com.umeng.commonsdk.statistics.proto.C3524b;
import com.umeng.commonsdk.statistics.proto.C3525c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AbstractIdTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.a */
/* loaded from: classes2.dex */
public abstract class AbstractC3501a {

    /* renamed from: a */
    private final int f12773a = 10;

    /* renamed from: b */
    private final int f12774b = 100;

    /* renamed from: c */
    private final String f12775c;

    /* renamed from: d */
    private List<C3523a> f12776d;

    /* renamed from: e */
    private C3524b f12777e;

    public AbstractC3501a(String str) {
        this.f12775c = str;
    }

    /* renamed from: g */
    private boolean m11845g() {
        C3524b c3524b = this.f12777e;
        String m11956b = c3524b == null ? null : c3524b.m11956b();
        int m11964h = c3524b == null ? 0 : c3524b.m11964h();
        String m11846a = m11846a(mo11855f());
        if (m11846a == null || m11846a.equals(m11956b)) {
            return false;
        }
        if (c3524b == null) {
            c3524b = new C3524b();
        }
        c3524b.m11953a(m11846a);
        c3524b.m11952a(System.currentTimeMillis());
        c3524b.m11951a(m11964h + 1);
        C3523a c3523a = new C3523a();
        c3523a.m11915a(this.f12775c);
        c3523a.m11920c(m11846a);
        c3523a.m11917b(m11956b);
        c3523a.m11914a(c3524b.m11961e());
        if (this.f12776d == null) {
            this.f12776d = new ArrayList(2);
        }
        this.f12776d.add(c3523a);
        if (this.f12776d.size() > 10) {
            this.f12776d.remove(0);
        }
        this.f12777e = c3524b;
        return true;
    }

    /* renamed from: a */
    public boolean m11850a() {
        return m11845g();
    }

    /* renamed from: b */
    public String m11851b() {
        return this.f12775c;
    }

    /* renamed from: c */
    public boolean m11852c() {
        C3524b c3524b = this.f12777e;
        return c3524b == null || c3524b.m11964h() <= 100;
    }

    /* renamed from: d */
    public C3524b m11853d() {
        return this.f12777e;
    }

    /* renamed from: e */
    public List<C3523a> m11854e() {
        return this.f12776d;
    }

    /* renamed from: f */
    public abstract String mo11855f();

    /* renamed from: a */
    public void m11847a(C3524b c3524b) {
        this.f12777e = c3524b;
    }

    /* renamed from: a */
    public void m11849a(List<C3523a> list) {
        this.f12776d = list;
    }

    /* renamed from: a */
    public String m11846a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public void m11848a(C3525c c3525c) {
        this.f12777e = c3525c.m11993c().get(this.f12775c);
        List<C3523a> m11999h = c3525c.m11999h();
        if (m11999h == null || m11999h.size() <= 0) {
            return;
        }
        if (this.f12776d == null) {
            this.f12776d = new ArrayList();
        }
        for (C3523a c3523a : m11999h) {
            if (this.f12775c.equals(c3523a.f12839a)) {
                this.f12776d.add(c3523a);
            }
        }
    }
}
