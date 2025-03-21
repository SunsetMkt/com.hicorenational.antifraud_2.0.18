package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hk implements hq<hk, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f833a;

    /* renamed from: a, reason: collision with other field name */
    public gu f834a;

    /* renamed from: a, reason: collision with other field name */
    public String f835a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f836a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f837b;

    /* renamed from: c, reason: collision with other field name */
    public String f838c;

    /* renamed from: d, reason: collision with other field name */
    public String f839d;

    /* renamed from: e, reason: collision with other field name */
    public String f840e;

    /* renamed from: f, reason: collision with other field name */
    public String f841f;

    /* renamed from: g, reason: collision with other field name */
    public String f842g;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f832a = new Cif("XmPushActionSubscriptionResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13164a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13165b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13166c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13167d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13168e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13169f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13170g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13171h = new hx("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13172i = new hx("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m580a() {
        return this.f835a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m582b() {
        return this.f834a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m583c() {
        return this.f837b != null;
    }

    public boolean d() {
        return this.f838c != null;
    }

    public boolean e() {
        return this.f836a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m581a((hk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f839d != null;
    }

    public boolean g() {
        return this.f840e != null;
    }

    public boolean h() {
        return this.f841f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f842g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (m580a()) {
            sb.append("debug:");
            String str = this.f835a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m582b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f834a;
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
        String str2 = this.f837b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f838c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f833a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f839d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f840e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f841f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f842g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f837b;
    }

    public String b() {
        return this.f840e;
    }

    public String c() {
        return this.f842g;
    }

    public void a(boolean z) {
        this.f836a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m579a();
        iaVar.a(f832a);
        if (this.f835a != null && m580a()) {
            iaVar.a(f13164a);
            iaVar.a(this.f835a);
            iaVar.b();
        }
        if (this.f834a != null && m582b()) {
            iaVar.a(f13165b);
            this.f834a.b(iaVar);
            iaVar.b();
        }
        if (this.f837b != null) {
            iaVar.a(f13166c);
            iaVar.a(this.f837b);
            iaVar.b();
        }
        if (this.f838c != null && d()) {
            iaVar.a(f13167d);
            iaVar.a(this.f838c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f13168e);
            iaVar.a(this.f833a);
            iaVar.b();
        }
        if (this.f839d != null && f()) {
            iaVar.a(f13169f);
            iaVar.a(this.f839d);
            iaVar.b();
        }
        if (this.f840e != null && g()) {
            iaVar.a(f13170g);
            iaVar.a(this.f840e);
            iaVar.b();
        }
        if (this.f841f != null && h()) {
            iaVar.a(f13171h);
            iaVar.a(this.f841f);
            iaVar.b();
        }
        if (this.f842g != null && i()) {
            iaVar.a(f13172i);
            iaVar.a(this.f842g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m581a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m580a = m580a();
        boolean m580a2 = hkVar.m580a();
        if ((m580a || m580a2) && !(m580a && m580a2 && this.f835a.equals(hkVar.f835a))) {
            return false;
        }
        boolean m582b = m582b();
        boolean m582b2 = hkVar.m582b();
        if ((m582b || m582b2) && !(m582b && m582b2 && this.f834a.m507a(hkVar.f834a))) {
            return false;
        }
        boolean m583c = m583c();
        boolean m583c2 = hkVar.m583c();
        if ((m583c || m583c2) && !(m583c && m583c2 && this.f837b.equals(hkVar.f837b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hkVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f838c.equals(hkVar.f838c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hkVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f833a == hkVar.f833a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f839d.equals(hkVar.f839d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f840e.equals(hkVar.f840e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f841f.equals(hkVar.f841f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f842g.equals(hkVar.f842g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hk hkVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!hk.class.equals(hkVar.getClass())) {
            return hk.class.getName().compareTo(hkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m580a()).compareTo(Boolean.valueOf(hkVar.m580a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m580a() && (a10 = hr.a(this.f835a, hkVar.f835a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m582b()).compareTo(Boolean.valueOf(hkVar.m582b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m582b() && (a9 = hr.a(this.f834a, hkVar.f834a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m583c()).compareTo(Boolean.valueOf(hkVar.m583c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m583c() && (a8 = hr.a(this.f837b, hkVar.f837b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hr.a(this.f838c, hkVar.f838c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hr.a(this.f833a, hkVar.f833a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hr.a(this.f839d, hkVar.f839d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = hr.a(this.f840e, hkVar.f840e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = hr.a(this.f841f, hkVar.f841f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = hr.a(this.f842g, hkVar.f842g)) == 0) {
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
                m579a();
                return;
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f835a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f834a = new gu();
                        this.f834a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f837b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f838c = iaVar.mo608a();
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
                        this.f833a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f839d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f840e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f841f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f842g = iaVar.mo608a();
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
    public void m579a() {
        if (this.f837b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
