package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gj implements hq<gj, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f568a;

    /* renamed from: a, reason: collision with other field name */
    public String f569a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f570a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f571a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f572a;

    /* renamed from: b, reason: collision with other field name */
    public long f573b;

    /* renamed from: b, reason: collision with other field name */
    public String f574b;

    /* renamed from: c, reason: collision with other field name */
    public String f575c;

    /* renamed from: d, reason: collision with other field name */
    public String f576d;

    /* renamed from: e, reason: collision with other field name */
    public String f577e;

    /* renamed from: f, reason: collision with other field name */
    public String f578f;

    /* renamed from: g, reason: collision with other field name */
    public String f579g;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f567a = new Cif("ClientUploadDataItem");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12950a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f12951b = new hx("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f12952c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f12953d = new hx("", (byte) 10, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f12954e = new hx("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f12955f = new hx("", (byte) 2, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f12956g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f12957h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f12958i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f12959j = new hx("", com.umeng.analytics.pro.cw.f10301k, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f12960k = new hx("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other method in class */
    public String m463a() {
        return this.f569a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m465a() {
    }

    public gj b(String str) {
        this.f574b = str;
        return this;
    }

    public gj c(String str) {
        this.f575c = str;
        return this;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m471d() {
        return this.f570a.get(0);
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m472e() {
        return this.f570a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gj)) {
            return m468a((gj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f570a.get(2);
    }

    public boolean g() {
        return this.f576d != null;
    }

    public boolean h() {
        return this.f577e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f578f != null;
    }

    public boolean j() {
        return this.f571a != null;
    }

    public boolean k() {
        return this.f579g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (m467a()) {
            sb.append("channel:");
            String str = this.f569a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m469b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f574b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m470c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f575c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m471d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f568a);
            z = false;
        }
        if (m472e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f573b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f572a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f576d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f577e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f578f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f571a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
            z = false;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f579g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gj a(String str) {
        this.f569a = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m469b() {
        return this.f574b != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m470c() {
        return this.f575c != null;
    }

    public gj d(String str) {
        this.f576d = str;
        return this;
    }

    public gj e(String str) {
        this.f577e = str;
        return this;
    }

    public gj f(String str) {
        this.f578f = str;
        return this;
    }

    public gj g(String str) {
        this.f579g = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m467a() {
        return this.f569a != null;
    }

    public String b() {
        return this.f575c;
    }

    public void c(boolean z) {
        this.f570a.set(2, z);
    }

    public String d() {
        return this.f578f;
    }

    public String e() {
        return this.f579g;
    }

    public gj a(long j2) {
        this.f568a = j2;
        m466a(true);
        return this;
    }

    public gj b(long j2) {
        this.f573b = j2;
        b(true);
        return this;
    }

    public String c() {
        return this.f577e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m466a(boolean z) {
        this.f570a.set(0, z);
    }

    public void b(boolean z) {
        this.f570a.set(1, z);
    }

    public long a() {
        return this.f573b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m465a();
        iaVar.a(f567a);
        if (this.f569a != null && m467a()) {
            iaVar.a(f12950a);
            iaVar.a(this.f569a);
            iaVar.b();
        }
        if (this.f574b != null && m469b()) {
            iaVar.a(f12951b);
            iaVar.a(this.f574b);
            iaVar.b();
        }
        if (this.f575c != null && m470c()) {
            iaVar.a(f12952c);
            iaVar.a(this.f575c);
            iaVar.b();
        }
        if (m471d()) {
            iaVar.a(f12953d);
            iaVar.a(this.f568a);
            iaVar.b();
        }
        if (m472e()) {
            iaVar.a(f12954e);
            iaVar.a(this.f573b);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f12955f);
            iaVar.a(this.f572a);
            iaVar.b();
        }
        if (this.f576d != null && g()) {
            iaVar.a(f12956g);
            iaVar.a(this.f576d);
            iaVar.b();
        }
        if (this.f577e != null && h()) {
            iaVar.a(f12957h);
            iaVar.a(this.f577e);
            iaVar.b();
        }
        if (this.f578f != null && i()) {
            iaVar.a(f12958i);
            iaVar.a(this.f578f);
            iaVar.b();
        }
        if (this.f571a != null && j()) {
            iaVar.a(f12959j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f571a.size()));
            for (Map.Entry<String, String> entry : this.f571a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f579g != null && k()) {
            iaVar.a(f12960k);
            iaVar.a(this.f579g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public gj a(boolean z) {
        this.f572a = z;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f571a == null) {
            this.f571a = new HashMap();
        }
        this.f571a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m464a() {
        return this.f571a;
    }

    public gj a(Map<String, String> map) {
        this.f571a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m468a(gj gjVar) {
        if (gjVar == null) {
            return false;
        }
        boolean m467a = m467a();
        boolean m467a2 = gjVar.m467a();
        if ((m467a || m467a2) && !(m467a && m467a2 && this.f569a.equals(gjVar.f569a))) {
            return false;
        }
        boolean m469b = m469b();
        boolean m469b2 = gjVar.m469b();
        if ((m469b || m469b2) && !(m469b && m469b2 && this.f574b.equals(gjVar.f574b))) {
            return false;
        }
        boolean m470c = m470c();
        boolean m470c2 = gjVar.m470c();
        if ((m470c || m470c2) && !(m470c && m470c2 && this.f575c.equals(gjVar.f575c))) {
            return false;
        }
        boolean m471d = m471d();
        boolean m471d2 = gjVar.m471d();
        if ((m471d || m471d2) && !(m471d && m471d2 && this.f568a == gjVar.f568a)) {
            return false;
        }
        boolean m472e = m472e();
        boolean m472e2 = gjVar.m472e();
        if ((m472e || m472e2) && !(m472e && m472e2 && this.f573b == gjVar.f573b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gjVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f572a == gjVar.f572a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gjVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f576d.equals(gjVar.f576d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gjVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f577e.equals(gjVar.f577e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gjVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f578f.equals(gjVar.f578f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gjVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f571a.equals(gjVar.f571a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gjVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f579g.equals(gjVar.f579g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gj gjVar) {
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
        if (!gj.class.equals(gjVar.getClass())) {
            return gj.class.getName().compareTo(gjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m467a()).compareTo(Boolean.valueOf(gjVar.m467a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m467a() && (a12 = hr.a(this.f569a, gjVar.f569a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(m469b()).compareTo(Boolean.valueOf(gjVar.m469b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m469b() && (a11 = hr.a(this.f574b, gjVar.f574b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(m470c()).compareTo(Boolean.valueOf(gjVar.m470c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m470c() && (a10 = hr.a(this.f575c, gjVar.f575c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(m471d()).compareTo(Boolean.valueOf(gjVar.m471d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m471d() && (a9 = hr.a(this.f568a, gjVar.f568a)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(m472e()).compareTo(Boolean.valueOf(gjVar.m472e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m472e() && (a8 = hr.a(this.f573b, gjVar.f573b)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gjVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = hr.a(this.f572a, gjVar.f572a)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gjVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = hr.a(this.f576d, gjVar.f576d)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gjVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = hr.a(this.f577e, gjVar.f577e)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gjVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = hr.a(this.f578f, gjVar.f578f)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gjVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a3 = hr.a(this.f571a, gjVar.f571a)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gjVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (a2 = hr.a(this.f579g, gjVar.f579g)) == 0) {
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
                m465a();
                return;
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f569a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 11) {
                        this.f574b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f575c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 10) {
                        this.f568a = iaVar.mo602a();
                        m466a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f573b = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 2) {
                        this.f572a = iaVar.mo613a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f576d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f577e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f578f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        hz mo605a = iaVar.mo605a();
                        this.f571a = new HashMap(mo605a.f900a * 2);
                        for (int i2 = 0; i2 < mo605a.f900a; i2++) {
                            this.f571a.put(iaVar.mo608a(), iaVar.mo608a());
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f579g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                default:
                    id.a(iaVar, b2);
                    break;
            }
            iaVar.g();
        }
    }
}
