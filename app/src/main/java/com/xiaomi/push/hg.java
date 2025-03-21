package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hg implements hq<hg, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f779a;

    /* renamed from: a, reason: collision with other field name */
    public long f780a;

    /* renamed from: a, reason: collision with other field name */
    public gu f781a;

    /* renamed from: a, reason: collision with other field name */
    public String f782a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f784a;

    /* renamed from: b, reason: collision with other field name */
    public int f786b;

    /* renamed from: b, reason: collision with other field name */
    public long f787b;

    /* renamed from: b, reason: collision with other field name */
    public String f788b;

    /* renamed from: c, reason: collision with other field name */
    public long f789c;

    /* renamed from: c, reason: collision with other field name */
    public String f790c;

    /* renamed from: d, reason: collision with other field name */
    public String f791d;

    /* renamed from: e, reason: collision with other field name */
    public String f792e;

    /* renamed from: f, reason: collision with other field name */
    public String f793f;

    /* renamed from: g, reason: collision with other field name */
    public String f794g;

    /* renamed from: h, reason: collision with other field name */
    public String f795h;

    /* renamed from: i, reason: collision with other field name */
    public String f796i;

    /* renamed from: j, reason: collision with other field name */
    public String f797j;

    /* renamed from: k, reason: collision with other field name */
    public String f798k;

    /* renamed from: l, reason: collision with other field name */
    public String f799l;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f778a = new Cif("XmPushActionRegistrationResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13124a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13125b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13126c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13127d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13128e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13129f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13130g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13131h = new hx("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13132i = new hx("", (byte) 11, 10);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13133j = new hx("", (byte) 10, 11);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13134k = new hx("", (byte) 11, 12);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13135l = new hx("", (byte) 11, 13);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13136m = new hx("", (byte) 10, 14);
    private static final hx n = new hx("", (byte) 11, 15);
    private static final hx o = new hx("", (byte) 8, 16);
    private static final hx p = new hx("", (byte) 11, 17);
    private static final hx q = new hx("", (byte) 8, 18);
    private static final hx r = new hx("", (byte) 11, 19);
    private static final hx s = new hx("", (byte) 2, 20);
    private static final hx t = new hx("", com.umeng.analytics.pro.cw.f10303m, 21);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f783a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f785a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m562a() {
        return this.f782a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m564b() {
        return this.f781a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m565c() {
        return this.f788b != null;
    }

    public boolean d() {
        return this.f790c != null;
    }

    public boolean e() {
        return this.f783a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return m563a((hg) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f791d != null;
    }

    public boolean g() {
        return this.f792e != null;
    }

    public boolean h() {
        return this.f793f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f794g != null;
    }

    public boolean j() {
        return this.f783a.get(1);
    }

    public boolean k() {
        return this.f795h != null;
    }

    public boolean l() {
        return this.f796i != null;
    }

    public boolean m() {
        return this.f783a.get(2);
    }

    public boolean n() {
        return this.f797j != null;
    }

    public boolean o() {
        return this.f783a.get(3);
    }

    public boolean p() {
        return this.f798k != null;
    }

    public boolean q() {
        return this.f783a.get(4);
    }

    public boolean r() {
        return this.f799l != null;
    }

    public boolean s() {
        return this.f783a.get(5);
    }

    public boolean t() {
        return this.f784a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        if (m562a()) {
            sb.append("debug:");
            String str = this.f782a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m564b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f781a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(guVar);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f788b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f790c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f780a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f791d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f792e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f794g;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f787b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f795h;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f796i;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f789c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f797j;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f779a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f798k;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f786b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f799l;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f785a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f784a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m559a() {
        return this.f788b;
    }

    public String b() {
        return this.f793f;
    }

    public String c() {
        return this.f794g;
    }

    public void d(boolean z) {
        this.f783a.set(3, z);
    }

    public void e(boolean z) {
        this.f783a.set(4, z);
    }

    public void f(boolean z) {
        this.f783a.set(5, z);
    }

    public long a() {
        return this.f780a;
    }

    public void b(boolean z) {
        this.f783a.set(1, z);
    }

    public void c(boolean z) {
        this.f783a.set(2, z);
    }

    public void a(boolean z) {
        this.f783a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m561a();
        iaVar.a(f778a);
        if (this.f782a != null && m562a()) {
            iaVar.a(f13124a);
            iaVar.a(this.f782a);
            iaVar.b();
        }
        if (this.f781a != null && m564b()) {
            iaVar.a(f13125b);
            this.f781a.b(iaVar);
            iaVar.b();
        }
        if (this.f788b != null) {
            iaVar.a(f13126c);
            iaVar.a(this.f788b);
            iaVar.b();
        }
        if (this.f790c != null) {
            iaVar.a(f13127d);
            iaVar.a(this.f790c);
            iaVar.b();
        }
        iaVar.a(f13128e);
        iaVar.a(this.f780a);
        iaVar.b();
        if (this.f791d != null && f()) {
            iaVar.a(f13129f);
            iaVar.a(this.f791d);
            iaVar.b();
        }
        if (this.f792e != null && g()) {
            iaVar.a(f13130g);
            iaVar.a(this.f792e);
            iaVar.b();
        }
        if (this.f793f != null && h()) {
            iaVar.a(f13131h);
            iaVar.a(this.f793f);
            iaVar.b();
        }
        if (this.f794g != null && i()) {
            iaVar.a(f13132i);
            iaVar.a(this.f794g);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f13133j);
            iaVar.a(this.f787b);
            iaVar.b();
        }
        if (this.f795h != null && k()) {
            iaVar.a(f13134k);
            iaVar.a(this.f795h);
            iaVar.b();
        }
        if (this.f796i != null && l()) {
            iaVar.a(f13135l);
            iaVar.a(this.f796i);
            iaVar.b();
        }
        if (m()) {
            iaVar.a(f13136m);
            iaVar.a(this.f789c);
            iaVar.b();
        }
        if (this.f797j != null && n()) {
            iaVar.a(n);
            iaVar.a(this.f797j);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.mo612a(this.f779a);
            iaVar.b();
        }
        if (this.f798k != null && p()) {
            iaVar.a(p);
            iaVar.a(this.f798k);
            iaVar.b();
        }
        if (q()) {
            iaVar.a(q);
            iaVar.mo612a(this.f786b);
            iaVar.b();
        }
        if (this.f799l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f799l);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.a(this.f785a);
            iaVar.b();
        }
        if (this.f784a != null && t()) {
            iaVar.a(t);
            iaVar.a(new hy((byte) 11, this.f784a.size()));
            Iterator<String> it = this.f784a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m560a() {
        return this.f784a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m563a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean m562a = m562a();
        boolean m562a2 = hgVar.m562a();
        if ((m562a || m562a2) && !(m562a && m562a2 && this.f782a.equals(hgVar.f782a))) {
            return false;
        }
        boolean m564b = m564b();
        boolean m564b2 = hgVar.m564b();
        if ((m564b || m564b2) && !(m564b && m564b2 && this.f781a.m507a(hgVar.f781a))) {
            return false;
        }
        boolean m565c = m565c();
        boolean m565c2 = hgVar.m565c();
        if ((m565c || m565c2) && !(m565c && m565c2 && this.f788b.equals(hgVar.f788b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hgVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f790c.equals(hgVar.f790c))) || this.f780a != hgVar.f780a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hgVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f791d.equals(hgVar.f791d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hgVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f792e.equals(hgVar.f792e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hgVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f793f.equals(hgVar.f793f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hgVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f794g.equals(hgVar.f794g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hgVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f787b == hgVar.f787b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hgVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f795h.equals(hgVar.f795h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hgVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f796i.equals(hgVar.f796i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hgVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f789c == hgVar.f789c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hgVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f797j.equals(hgVar.f797j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hgVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f779a == hgVar.f779a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hgVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f798k.equals(hgVar.f798k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hgVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f786b == hgVar.f786b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hgVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f799l.equals(hgVar.f799l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hgVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f785a == hgVar.f785a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hgVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f784a.equals(hgVar.f784a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hg hgVar) {
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
        if (!hg.class.equals(hgVar.getClass())) {
            return hg.class.getName().compareTo(hgVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m562a()).compareTo(Boolean.valueOf(hgVar.m562a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m562a() && (a21 = hr.a(this.f782a, hgVar.f782a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(m564b()).compareTo(Boolean.valueOf(hgVar.m564b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m564b() && (a20 = hr.a(this.f781a, hgVar.f781a)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(m565c()).compareTo(Boolean.valueOf(hgVar.m565c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m565c() && (a19 = hr.a(this.f788b, hgVar.f788b)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = hr.a(this.f790c, hgVar.f790c)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = hr.a(this.f780a, hgVar.f780a)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = hr.a(this.f791d, hgVar.f791d)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = hr.a(this.f792e, hgVar.f792e)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = hr.a(this.f793f, hgVar.f793f)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = hr.a(this.f794g, hgVar.f794g)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = hr.a(this.f787b, hgVar.f787b)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = hr.a(this.f795h, hgVar.f795h)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hgVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = hr.a(this.f796i, hgVar.f796i)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hgVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = hr.a(this.f789c, hgVar.f789c)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hgVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = hr.a(this.f797j, hgVar.f797j)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hgVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = hr.a(this.f779a, hgVar.f779a)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hgVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = hr.a(this.f798k, hgVar.f798k)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hgVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = hr.a(this.f786b, hgVar.f786b)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hgVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = hr.a(this.f799l, hgVar.f799l)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hgVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = hr.a(this.f785a, hgVar.f785a)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hgVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a2 = hr.a(this.f784a, hgVar.f784a)) == 0) {
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
                if (e()) {
                    m561a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f782a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f781a = new gu();
                        this.f781a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f788b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f790c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                default:
                    id.a(iaVar, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f780a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f791d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f792e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f793f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f794g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 10) {
                        this.f787b = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f795h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f796i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 10) {
                        this.f789c = iaVar.mo602a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f797j = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 8) {
                        this.f779a = iaVar.mo601a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f798k = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 8) {
                        this.f786b = iaVar.mo601a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 11) {
                        this.f799l = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f785a = iaVar.mo613a();
                        f(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 15) {
                        hy mo604a = iaVar.mo604a();
                        this.f784a = new ArrayList(mo604a.f899a);
                        for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                            this.f784a.add(iaVar.mo608a());
                        }
                        iaVar.i();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m561a() {
        if (this.f788b != null) {
            if (this.f790c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
