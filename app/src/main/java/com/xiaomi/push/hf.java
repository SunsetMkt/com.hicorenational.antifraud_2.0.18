package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class hf implements hq<hf, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f748a;

    /* renamed from: a, reason: collision with other field name */
    public long f749a;

    /* renamed from: a, reason: collision with other field name */
    public gt f750a;

    /* renamed from: a, reason: collision with other field name */
    public gu f751a;

    /* renamed from: a, reason: collision with other field name */
    public String f752a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f754a;

    /* renamed from: b, reason: collision with other field name */
    public int f756b;

    /* renamed from: b, reason: collision with other field name */
    public long f757b;

    /* renamed from: b, reason: collision with other field name */
    public String f758b;

    /* renamed from: c, reason: collision with other field name */
    public int f760c;

    /* renamed from: c, reason: collision with other field name */
    public String f761c;

    /* renamed from: d, reason: collision with other field name */
    public String f763d;

    /* renamed from: e, reason: collision with other field name */
    public String f764e;

    /* renamed from: f, reason: collision with other field name */
    public String f765f;

    /* renamed from: g, reason: collision with other field name */
    public String f766g;

    /* renamed from: h, reason: collision with other field name */
    public String f767h;

    /* renamed from: i, reason: collision with other field name */
    public String f768i;

    /* renamed from: j, reason: collision with other field name */
    public String f769j;

    /* renamed from: k, reason: collision with other field name */
    public String f770k;

    /* renamed from: l, reason: collision with other field name */
    public String f771l;

    /* renamed from: m, reason: collision with other field name */
    public String f772m;

    /* renamed from: n, reason: collision with other field name */
    public String f773n;

    /* renamed from: o, reason: collision with other field name */
    public String f774o;

    /* renamed from: p, reason: collision with other field name */
    public String f775p;

    /* renamed from: q, reason: collision with other field name */
    public String f776q;

    /* renamed from: r, reason: collision with other field name */
    public String f777r;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f747a = new Cif("XmPushActionRegistration");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13111a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13112b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13113c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13114d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13115e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13116f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13117g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13118h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13119i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13120j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13121k = new hx("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13122l = new hx("", (byte) 11, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13123m = new hx("", (byte) 8, 13);
    private static final hx n = new hx("", (byte) 8, 14);
    private static final hx o = new hx("", (byte) 11, 15);
    private static final hx p = new hx("", (byte) 11, 16);
    private static final hx q = new hx("", (byte) 11, 17);
    private static final hx r = new hx("", (byte) 11, 18);
    private static final hx s = new hx("", (byte) 8, 19);
    private static final hx t = new hx("", (byte) 8, 20);
    private static final hx u = new hx("", (byte) 2, 21);
    private static final hx v = new hx("", (byte) 10, 22);
    private static final hx w = new hx("", (byte) 10, 23);
    private static final hx x = new hx("", (byte) 11, 24);
    private static final hx y = new hx("", (byte) 11, 25);
    private static final hx z = new hx("", (byte) 2, 26);
    private static final hx A = new hx("", com.umeng.analytics.pro.cw.f10301k, 100);
    private static final hx B = new hx("", (byte) 2, 101);
    private static final hx C = new hx("", (byte) 11, 102);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f753a = new BitSet(8);

    /* renamed from: a, reason: collision with other field name */
    public boolean f755a = true;

    /* renamed from: c, reason: collision with other field name */
    public boolean f762c = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f759b = false;

    public boolean A() {
        return this.f754a != null;
    }

    public boolean B() {
        return this.f753a.get(7);
    }

    public boolean C() {
        return this.f777r != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m555a() {
        return this.f752a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m557b() {
        return this.f751a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m558c() {
        return this.f758b != null;
    }

    public boolean d() {
        return this.f761c != null;
    }

    public boolean e() {
        return this.f763d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return m556a((hf) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f764e != null;
    }

    public boolean g() {
        return this.f765f != null;
    }

    public boolean h() {
        return this.f766g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f767h != null;
    }

    public boolean j() {
        return this.f768i != null;
    }

    public boolean k() {
        return this.f769j != null;
    }

    public boolean l() {
        return this.f770k != null;
    }

    public boolean m() {
        return this.f753a.get(0);
    }

    public boolean n() {
        return this.f753a.get(1);
    }

    public boolean o() {
        return this.f771l != null;
    }

    public boolean p() {
        return this.f772m != null;
    }

    public boolean q() {
        return this.f773n != null;
    }

    public boolean r() {
        return this.f774o != null;
    }

    public boolean s() {
        return this.f753a.get(2);
    }

    public boolean t() {
        return this.f750a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        if (m555a()) {
            sb.append("debug:");
            String str = this.f752a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m557b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f751a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(guVar);
            }
            z2 = false;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f758b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f761c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f763d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f764e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f765f;
        if (str6 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f766g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f767h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f768i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f769j;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f770k;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f748a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f756b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f771l;
            if (str12 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f772m;
            if (str13 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f773n;
            if (str14 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f774o;
            if (str15 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f760c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            gt gtVar = this.f750a;
            if (gtVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(gtVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f755a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f749a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f757b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f775p;
            if (str16 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f776q;
            if (str17 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f759b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f754a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f762c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f777r;
            if (str18 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f753a.get(3);
    }

    public boolean v() {
        return this.f753a.get(4);
    }

    public boolean w() {
        return this.f753a.get(5);
    }

    public boolean x() {
        return this.f775p != null;
    }

    public boolean y() {
        return this.f776q != null;
    }

    public boolean z() {
        return this.f753a.get(6);
    }

    public String a() {
        return this.f758b;
    }

    public String b() {
        return this.f761c;
    }

    public hf c(String str) {
        this.f763d = str;
        return this;
    }

    public hf d(String str) {
        this.f764e = str;
        return this;
    }

    public hf e(String str) {
        this.f765f = str;
        return this;
    }

    public hf f(String str) {
        this.f766g = str;
        return this;
    }

    public hf g(String str) {
        this.f767h = str;
        return this;
    }

    public hf h(String str) {
        this.f770k = str;
        return this;
    }

    public hf i(String str) {
        this.f774o = str;
        return this;
    }

    public hf a(String str) {
        this.f758b = str;
        return this;
    }

    public hf b(String str) {
        this.f761c = str;
        return this;
    }

    public String c() {
        return this.f765f;
    }

    public void d(boolean z2) {
        this.f753a.set(3, z2);
    }

    public void e(boolean z2) {
        this.f753a.set(4, z2);
    }

    public void f(boolean z2) {
        this.f753a.set(5, z2);
    }

    public void g(boolean z2) {
        this.f753a.set(6, z2);
    }

    public void h(boolean z2) {
        this.f753a.set(7, z2);
    }

    public hf a(int i2) {
        this.f748a = i2;
        a(true);
        return this;
    }

    public hf b(int i2) {
        this.f756b = i2;
        b(true);
        return this;
    }

    public hf c(int i2) {
        this.f760c = i2;
        c(true);
        return this;
    }

    public void a(boolean z2) {
        this.f753a.set(0, z2);
    }

    public void b(boolean z2) {
        this.f753a.set(1, z2);
    }

    public void c(boolean z2) {
        this.f753a.set(2, z2);
    }

    public hf a(gt gtVar) {
        this.f750a = gtVar;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m554a();
        iaVar.a(f747a);
        if (this.f752a != null && m555a()) {
            iaVar.a(f13111a);
            iaVar.a(this.f752a);
            iaVar.b();
        }
        if (this.f751a != null && m557b()) {
            iaVar.a(f13112b);
            this.f751a.b(iaVar);
            iaVar.b();
        }
        if (this.f758b != null) {
            iaVar.a(f13113c);
            iaVar.a(this.f758b);
            iaVar.b();
        }
        if (this.f761c != null) {
            iaVar.a(f13114d);
            iaVar.a(this.f761c);
            iaVar.b();
        }
        if (this.f763d != null && e()) {
            iaVar.a(f13115e);
            iaVar.a(this.f763d);
            iaVar.b();
        }
        if (this.f764e != null && f()) {
            iaVar.a(f13116f);
            iaVar.a(this.f764e);
            iaVar.b();
        }
        if (this.f765f != null) {
            iaVar.a(f13117g);
            iaVar.a(this.f765f);
            iaVar.b();
        }
        if (this.f766g != null && h()) {
            iaVar.a(f13118h);
            iaVar.a(this.f766g);
            iaVar.b();
        }
        if (this.f767h != null && i()) {
            iaVar.a(f13119i);
            iaVar.a(this.f767h);
            iaVar.b();
        }
        if (this.f768i != null && j()) {
            iaVar.a(f13120j);
            iaVar.a(this.f768i);
            iaVar.b();
        }
        if (this.f769j != null && k()) {
            iaVar.a(f13121k);
            iaVar.a(this.f769j);
            iaVar.b();
        }
        if (this.f770k != null && l()) {
            iaVar.a(f13122l);
            iaVar.a(this.f770k);
            iaVar.b();
        }
        if (m()) {
            iaVar.a(f13123m);
            iaVar.mo612a(this.f748a);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.mo612a(this.f756b);
            iaVar.b();
        }
        if (this.f771l != null && o()) {
            iaVar.a(o);
            iaVar.a(this.f771l);
            iaVar.b();
        }
        if (this.f772m != null && p()) {
            iaVar.a(p);
            iaVar.a(this.f772m);
            iaVar.b();
        }
        if (this.f773n != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f773n);
            iaVar.b();
        }
        if (this.f774o != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f774o);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.mo612a(this.f760c);
            iaVar.b();
        }
        if (this.f750a != null && t()) {
            iaVar.a(t);
            iaVar.mo612a(this.f750a.a());
            iaVar.b();
        }
        if (u()) {
            iaVar.a(u);
            iaVar.a(this.f755a);
            iaVar.b();
        }
        if (v()) {
            iaVar.a(v);
            iaVar.a(this.f749a);
            iaVar.b();
        }
        if (w()) {
            iaVar.a(w);
            iaVar.a(this.f757b);
            iaVar.b();
        }
        if (this.f775p != null && x()) {
            iaVar.a(x);
            iaVar.a(this.f775p);
            iaVar.b();
        }
        if (this.f776q != null && y()) {
            iaVar.a(y);
            iaVar.a(this.f776q);
            iaVar.b();
        }
        if (z()) {
            iaVar.a(z);
            iaVar.a(this.f759b);
            iaVar.b();
        }
        if (this.f754a != null && A()) {
            iaVar.a(A);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f754a.size()));
            for (Map.Entry<String, String> entry : this.f754a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (B()) {
            iaVar.a(B);
            iaVar.a(this.f762c);
            iaVar.b();
        }
        if (this.f777r != null && C()) {
            iaVar.a(C);
            iaVar.a(this.f777r);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m556a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean m555a = m555a();
        boolean m555a2 = hfVar.m555a();
        if ((m555a || m555a2) && !(m555a && m555a2 && this.f752a.equals(hfVar.f752a))) {
            return false;
        }
        boolean m557b = m557b();
        boolean m557b2 = hfVar.m557b();
        if ((m557b || m557b2) && !(m557b && m557b2 && this.f751a.m507a(hfVar.f751a))) {
            return false;
        }
        boolean m558c = m558c();
        boolean m558c2 = hfVar.m558c();
        if ((m558c || m558c2) && !(m558c && m558c2 && this.f758b.equals(hfVar.f758b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hfVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f761c.equals(hfVar.f761c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hfVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f763d.equals(hfVar.f763d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hfVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f764e.equals(hfVar.f764e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hfVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f765f.equals(hfVar.f765f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hfVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f766g.equals(hfVar.f766g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hfVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f767h.equals(hfVar.f767h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hfVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f768i.equals(hfVar.f768i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hfVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f769j.equals(hfVar.f769j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hfVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f770k.equals(hfVar.f770k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hfVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f748a == hfVar.f748a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hfVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f756b == hfVar.f756b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hfVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f771l.equals(hfVar.f771l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hfVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f772m.equals(hfVar.f772m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hfVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f773n.equals(hfVar.f773n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hfVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f774o.equals(hfVar.f774o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hfVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f760c == hfVar.f760c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hfVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f750a.equals(hfVar.f750a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = hfVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f755a == hfVar.f755a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = hfVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f749a == hfVar.f749a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = hfVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f757b == hfVar.f757b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = hfVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f775p.equals(hfVar.f775p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = hfVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f776q.equals(hfVar.f776q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = hfVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f759b == hfVar.f759b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = hfVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f754a.equals(hfVar.f754a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = hfVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f762c == hfVar.f762c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = hfVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f777r.equals(hfVar.f777r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hf hfVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        int a30;
        if (!hf.class.equals(hfVar.getClass())) {
            return hf.class.getName().compareTo(hfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m555a()).compareTo(Boolean.valueOf(hfVar.m555a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m555a() && (a30 = hr.a(this.f752a, hfVar.f752a)) != 0) {
            return a30;
        }
        int compareTo2 = Boolean.valueOf(m557b()).compareTo(Boolean.valueOf(hfVar.m557b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m557b() && (a29 = hr.a(this.f751a, hfVar.f751a)) != 0) {
            return a29;
        }
        int compareTo3 = Boolean.valueOf(m558c()).compareTo(Boolean.valueOf(hfVar.m558c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m558c() && (a28 = hr.a(this.f758b, hfVar.f758b)) != 0) {
            return a28;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a27 = hr.a(this.f761c, hfVar.f761c)) != 0) {
            return a27;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a26 = hr.a(this.f763d, hfVar.f763d)) != 0) {
            return a26;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a25 = hr.a(this.f764e, hfVar.f764e)) != 0) {
            return a25;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a24 = hr.a(this.f765f, hfVar.f765f)) != 0) {
            return a24;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a23 = hr.a(this.f766g, hfVar.f766g)) != 0) {
            return a23;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a22 = hr.a(this.f767h, hfVar.f767h)) != 0) {
            return a22;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a21 = hr.a(this.f768i, hfVar.f768i)) != 0) {
            return a21;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a20 = hr.a(this.f769j, hfVar.f769j)) != 0) {
            return a20;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a19 = hr.a(this.f770k, hfVar.f770k)) != 0) {
            return a19;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a18 = hr.a(this.f748a, hfVar.f748a)) != 0) {
            return a18;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a17 = hr.a(this.f756b, hfVar.f756b)) != 0) {
            return a17;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a16 = hr.a(this.f771l, hfVar.f771l)) != 0) {
            return a16;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hfVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a15 = hr.a(this.f772m, hfVar.f772m)) != 0) {
            return a15;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hfVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a14 = hr.a(this.f773n, hfVar.f773n)) != 0) {
            return a14;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hfVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a13 = hr.a(this.f774o, hfVar.f774o)) != 0) {
            return a13;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hfVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a12 = hr.a(this.f760c, hfVar.f760c)) != 0) {
            return a12;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hfVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (a11 = hr.a(this.f750a, hfVar.f750a)) != 0) {
            return a11;
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hfVar.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u() && (a10 = hr.a(this.f755a, hfVar.f755a)) != 0) {
            return a10;
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hfVar.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v() && (a9 = hr.a(this.f749a, hfVar.f749a)) != 0) {
            return a9;
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hfVar.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w() && (a8 = hr.a(this.f757b, hfVar.f757b)) != 0) {
            return a8;
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hfVar.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x() && (a7 = hr.a(this.f775p, hfVar.f775p)) != 0) {
            return a7;
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hfVar.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y() && (a6 = hr.a(this.f776q, hfVar.f776q)) != 0) {
            return a6;
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hfVar.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z() && (a5 = hr.a(this.f759b, hfVar.f759b)) != 0) {
            return a5;
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hfVar.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A() && (a4 = hr.a(this.f754a, hfVar.f754a)) != 0) {
            return a4;
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hfVar.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (B() && (a3 = hr.a(this.f762c, hfVar.f762c)) != 0) {
            return a3;
        }
        int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hfVar.C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!C() || (a2 = hr.a(this.f777r, hfVar.f777r)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo607a();
        while (true) {
            hx mo603a = iaVar.mo603a();
            byte b2 = mo603a.f13224a;
            if (b2 == 0) {
                iaVar.f();
                m554a();
                return;
            }
            short s2 = mo603a.f898a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f752a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f751a = new gu();
                        this.f751a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f758b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f761c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f763d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f764e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f765f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f766g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f767h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f768i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f769j = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f770k = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 8) {
                        this.f748a = iaVar.mo601a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 8) {
                        this.f756b = iaVar.mo601a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f771l = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 11) {
                        this.f772m = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f773n = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 11) {
                        this.f774o = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 8) {
                        this.f760c = iaVar.mo601a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 8) {
                        this.f750a = gt.a(iaVar.mo601a());
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 2) {
                        this.f755a = iaVar.mo613a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 10) {
                        this.f749a = iaVar.mo602a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 10) {
                        this.f757b = iaVar.mo602a();
                        f(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 24:
                    if (b2 == 11) {
                        this.f775p = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 25:
                    if (b2 == 11) {
                        this.f776q = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 26:
                    if (b2 == 2) {
                        this.f759b = iaVar.mo613a();
                        g(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                hz mo605a = iaVar.mo605a();
                                this.f754a = new HashMap(mo605a.f900a * 2);
                                for (int i2 = 0; i2 < mo605a.f900a; i2++) {
                                    this.f754a.put(iaVar.mo608a(), iaVar.mo608a());
                                }
                                iaVar.h();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 101:
                            if (b2 == 2) {
                                this.f762c = iaVar.mo613a();
                                h(true);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 102:
                            if (b2 == 11) {
                                this.f777r = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        default:
                            id.a(iaVar, b2);
                            break;
                    }
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m554a() {
        if (this.f758b != null) {
            if (this.f761c != null) {
                if (this.f765f != null) {
                    return;
                }
                throw new ib("Required field 'token' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
