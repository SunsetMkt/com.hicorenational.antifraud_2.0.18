package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hn implements hq<hn, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gu f869a;

    /* renamed from: a, reason: collision with other field name */
    public String f870a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f871a;

    /* renamed from: b, reason: collision with other field name */
    public String f872b;

    /* renamed from: c, reason: collision with other field name */
    public String f873c;

    /* renamed from: d, reason: collision with other field name */
    public String f874d;

    /* renamed from: e, reason: collision with other field name */
    public String f875e;

    /* renamed from: f, reason: collision with other field name */
    public String f876f;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f868a = new Cif("XmPushActionUnSubscription");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13194a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13195b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13196c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13197d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13198e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13199f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13200g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13201h = new hx("", com.umeng.analytics.pro.cw.f10303m, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m589a() {
        return this.f870a != null;
    }

    public boolean b() {
        return this.f869a != null;
    }

    public boolean c() {
        return this.f872b != null;
    }

    public boolean d() {
        return this.f873c != null;
    }

    public boolean e() {
        return this.f874d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m590a((hn) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f875e != null;
    }

    public boolean g() {
        return this.f876f != null;
    }

    public boolean h() {
        return this.f871a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (m589a()) {
            sb.append("debug:");
            String str = this.f870a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f869a;
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
        String str2 = this.f872b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f873c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f874d;
        if (str4 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f875e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f876f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f871a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hn a(String str) {
        this.f872b = str;
        return this;
    }

    public hn b(String str) {
        this.f873c = str;
        return this;
    }

    public hn c(String str) {
        this.f874d = str;
        return this;
    }

    public hn d(String str) {
        this.f875e = str;
        return this;
    }

    public hn e(String str) {
        this.f876f = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m590a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean m589a = m589a();
        boolean m589a2 = hnVar.m589a();
        if ((m589a || m589a2) && !(m589a && m589a2 && this.f870a.equals(hnVar.f870a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hnVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f869a.m507a(hnVar.f869a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hnVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f872b.equals(hnVar.f872b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hnVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f873c.equals(hnVar.f873c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hnVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f874d.equals(hnVar.f874d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hnVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f875e.equals(hnVar.f875e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hnVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f876f.equals(hnVar.f876f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hnVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f871a.equals(hnVar.f871a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f868a);
        if (this.f870a != null && m589a()) {
            iaVar.a(f13194a);
            iaVar.a(this.f870a);
            iaVar.b();
        }
        if (this.f869a != null && b()) {
            iaVar.a(f13195b);
            this.f869a.b(iaVar);
            iaVar.b();
        }
        if (this.f872b != null) {
            iaVar.a(f13196c);
            iaVar.a(this.f872b);
            iaVar.b();
        }
        if (this.f873c != null) {
            iaVar.a(f13197d);
            iaVar.a(this.f873c);
            iaVar.b();
        }
        if (this.f874d != null) {
            iaVar.a(f13198e);
            iaVar.a(this.f874d);
            iaVar.b();
        }
        if (this.f875e != null && f()) {
            iaVar.a(f13199f);
            iaVar.a(this.f875e);
            iaVar.b();
        }
        if (this.f876f != null && g()) {
            iaVar.a(f13200g);
            iaVar.a(this.f876f);
            iaVar.b();
        }
        if (this.f871a != null && h()) {
            iaVar.a(f13201h);
            iaVar.a(new hy((byte) 11, this.f871a.size()));
            Iterator<String> it = this.f871a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hn hnVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!hn.class.equals(hnVar.getClass())) {
            return hn.class.getName().compareTo(hnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m589a()).compareTo(Boolean.valueOf(hnVar.m589a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m589a() && (a9 = hr.a(this.f870a, hnVar.f870a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = hr.a(this.f869a, hnVar.f869a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = hr.a(this.f872b, hnVar.f872b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = hr.a(this.f873c, hnVar.f873c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = hr.a(this.f874d, hnVar.f874d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = hr.a(this.f875e, hnVar.f875e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = hr.a(this.f876f, hnVar.f876f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = hr.a(this.f871a, hnVar.f871a)) == 0) {
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
                a();
                return;
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f870a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f869a = new gu();
                        this.f869a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f872b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f873c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f874d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f875e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f876f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        hy mo604a = iaVar.mo604a();
                        this.f871a = new ArrayList(mo604a.f899a);
                        for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                            this.f871a.add(iaVar.mo608a());
                        }
                        iaVar.i();
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

    public void a() {
        if (this.f872b != null) {
            if (this.f873c != null) {
                if (this.f874d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
