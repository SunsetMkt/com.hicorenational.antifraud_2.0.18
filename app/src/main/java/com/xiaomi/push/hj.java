package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hj implements hq<hj, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gu f824a;

    /* renamed from: a, reason: collision with other field name */
    public String f825a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f826a;

    /* renamed from: b, reason: collision with other field name */
    public String f827b;

    /* renamed from: c, reason: collision with other field name */
    public String f828c;

    /* renamed from: d, reason: collision with other field name */
    public String f829d;

    /* renamed from: e, reason: collision with other field name */
    public String f830e;

    /* renamed from: f, reason: collision with other field name */
    public String f831f;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f823a = new Cif("XmPushActionSubscription");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13156a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13157b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13158c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13159d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13160e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13161f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13162g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13163h = new hx("", com.umeng.analytics.pro.cw.f10303m, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m577a() {
        return this.f825a != null;
    }

    public boolean b() {
        return this.f824a != null;
    }

    public boolean c() {
        return this.f827b != null;
    }

    public boolean d() {
        return this.f828c != null;
    }

    public boolean e() {
        return this.f829d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m578a((hj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f830e != null;
    }

    public boolean g() {
        return this.f831f != null;
    }

    public boolean h() {
        return this.f826a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (m577a()) {
            sb.append("debug:");
            String str = this.f825a;
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
            gu guVar = this.f824a;
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
        String str2 = this.f827b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f828c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f829d;
        if (str4 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f830e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f831f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f826a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hj a(String str) {
        this.f827b = str;
        return this;
    }

    public hj b(String str) {
        this.f828c = str;
        return this;
    }

    public hj c(String str) {
        this.f829d = str;
        return this;
    }

    public hj d(String str) {
        this.f830e = str;
        return this;
    }

    public hj e(String str) {
        this.f831f = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m578a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m577a = m577a();
        boolean m577a2 = hjVar.m577a();
        if ((m577a || m577a2) && !(m577a && m577a2 && this.f825a.equals(hjVar.f825a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f824a.m507a(hjVar.f824a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hjVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f827b.equals(hjVar.f827b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hjVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f828c.equals(hjVar.f828c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hjVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f829d.equals(hjVar.f829d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hjVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f830e.equals(hjVar.f830e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hjVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f831f.equals(hjVar.f831f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hjVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f826a.equals(hjVar.f826a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f823a);
        if (this.f825a != null && m577a()) {
            iaVar.a(f13156a);
            iaVar.a(this.f825a);
            iaVar.b();
        }
        if (this.f824a != null && b()) {
            iaVar.a(f13157b);
            this.f824a.b(iaVar);
            iaVar.b();
        }
        if (this.f827b != null) {
            iaVar.a(f13158c);
            iaVar.a(this.f827b);
            iaVar.b();
        }
        if (this.f828c != null) {
            iaVar.a(f13159d);
            iaVar.a(this.f828c);
            iaVar.b();
        }
        if (this.f829d != null) {
            iaVar.a(f13160e);
            iaVar.a(this.f829d);
            iaVar.b();
        }
        if (this.f830e != null && f()) {
            iaVar.a(f13161f);
            iaVar.a(this.f830e);
            iaVar.b();
        }
        if (this.f831f != null && g()) {
            iaVar.a(f13162g);
            iaVar.a(this.f831f);
            iaVar.b();
        }
        if (this.f826a != null && h()) {
            iaVar.a(f13163h);
            iaVar.a(new hy((byte) 11, this.f826a.size()));
            Iterator<String> it = this.f826a.iterator();
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
    public int compareTo(hj hjVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!hj.class.equals(hjVar.getClass())) {
            return hj.class.getName().compareTo(hjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m577a()).compareTo(Boolean.valueOf(hjVar.m577a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m577a() && (a9 = hr.a(this.f825a, hjVar.f825a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = hr.a(this.f824a, hjVar.f824a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hjVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = hr.a(this.f827b, hjVar.f827b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = hr.a(this.f828c, hjVar.f828c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hjVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = hr.a(this.f829d, hjVar.f829d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = hr.a(this.f830e, hjVar.f830e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = hr.a(this.f831f, hjVar.f831f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = hr.a(this.f826a, hjVar.f826a)) == 0) {
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
                        this.f825a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f824a = new gu();
                        this.f824a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f827b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f828c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f829d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f830e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f831f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        hy mo604a = iaVar.mo604a();
                        this.f826a = new ArrayList(mo604a.f899a);
                        for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                            this.f826a.add(iaVar.mo608a());
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
        if (this.f827b != null) {
            if (this.f828c != null) {
                if (this.f829d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
