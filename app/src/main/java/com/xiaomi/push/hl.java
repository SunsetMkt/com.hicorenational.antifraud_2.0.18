package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hl implements hq<hl, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f844a;

    /* renamed from: a, reason: collision with other field name */
    public gu f845a;

    /* renamed from: a, reason: collision with other field name */
    public String f846a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f847a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f848a = true;

    /* renamed from: b, reason: collision with other field name */
    public String f849b;

    /* renamed from: c, reason: collision with other field name */
    public String f850c;

    /* renamed from: d, reason: collision with other field name */
    public String f851d;

    /* renamed from: e, reason: collision with other field name */
    public String f852e;

    /* renamed from: f, reason: collision with other field name */
    public String f853f;

    /* renamed from: g, reason: collision with other field name */
    public String f854g;

    /* renamed from: h, reason: collision with other field name */
    public String f855h;

    /* renamed from: i, reason: collision with other field name */
    public String f856i;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f843a = new Cif("XmPushActionUnRegistration");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13173a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13174b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13175c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13176d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13177e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13178f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13179g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13180h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13181i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13182j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13183k = new hx("", (byte) 2, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13184l = new hx("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m584a() {
        return this.f846a != null;
    }

    public boolean b() {
        return this.f845a != null;
    }

    public boolean c() {
        return this.f849b != null;
    }

    public boolean d() {
        return this.f850c != null;
    }

    public boolean e() {
        return this.f851d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m585a((hl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f852e != null;
    }

    public boolean g() {
        return this.f853f != null;
    }

    public boolean h() {
        return this.f854g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f855h != null;
    }

    public boolean j() {
        return this.f856i != null;
    }

    public boolean k() {
        return this.f847a.get(0);
    }

    public boolean l() {
        return this.f847a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        if (m584a()) {
            sb.append("debug:");
            String str = this.f846a;
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
            gu guVar = this.f845a;
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
        String str2 = this.f849b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f850c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f851d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f852e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f853f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f854g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f855h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f856i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f848a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f844a);
        }
        sb.append(")");
        return sb.toString();
    }

    public hl a(String str) {
        this.f849b = str;
        return this;
    }

    public hl b(String str) {
        this.f850c = str;
        return this;
    }

    public hl c(String str) {
        this.f851d = str;
        return this;
    }

    public hl d(String str) {
        this.f853f = str;
        return this;
    }

    public hl e(String str) {
        this.f854g = str;
        return this;
    }

    public void a(boolean z) {
        this.f847a.set(0, z);
    }

    public void b(boolean z) {
        this.f847a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m585a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean m584a = m584a();
        boolean m584a2 = hlVar.m584a();
        if ((m584a || m584a2) && !(m584a && m584a2 && this.f846a.equals(hlVar.f846a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hlVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f845a.m507a(hlVar.f845a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hlVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f849b.equals(hlVar.f849b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hlVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f850c.equals(hlVar.f850c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hlVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f851d.equals(hlVar.f851d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hlVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f852e.equals(hlVar.f852e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hlVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f853f.equals(hlVar.f853f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hlVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f854g.equals(hlVar.f854g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hlVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f855h.equals(hlVar.f855h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hlVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f856i.equals(hlVar.f856i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hlVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f848a == hlVar.f848a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hlVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f844a == hlVar.f844a;
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f843a);
        if (this.f846a != null && m584a()) {
            iaVar.a(f13173a);
            iaVar.a(this.f846a);
            iaVar.b();
        }
        if (this.f845a != null && b()) {
            iaVar.a(f13174b);
            this.f845a.b(iaVar);
            iaVar.b();
        }
        if (this.f849b != null) {
            iaVar.a(f13175c);
            iaVar.a(this.f849b);
            iaVar.b();
        }
        if (this.f850c != null) {
            iaVar.a(f13176d);
            iaVar.a(this.f850c);
            iaVar.b();
        }
        if (this.f851d != null && e()) {
            iaVar.a(f13177e);
            iaVar.a(this.f851d);
            iaVar.b();
        }
        if (this.f852e != null && f()) {
            iaVar.a(f13178f);
            iaVar.a(this.f852e);
            iaVar.b();
        }
        if (this.f853f != null && g()) {
            iaVar.a(f13179g);
            iaVar.a(this.f853f);
            iaVar.b();
        }
        if (this.f854g != null && h()) {
            iaVar.a(f13180h);
            iaVar.a(this.f854g);
            iaVar.b();
        }
        if (this.f855h != null && i()) {
            iaVar.a(f13181i);
            iaVar.a(this.f855h);
            iaVar.b();
        }
        if (this.f856i != null && j()) {
            iaVar.a(f13182j);
            iaVar.a(this.f856i);
            iaVar.b();
        }
        if (k()) {
            iaVar.a(f13183k);
            iaVar.a(this.f848a);
            iaVar.b();
        }
        if (l()) {
            iaVar.a(f13184l);
            iaVar.a(this.f844a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hl hlVar) {
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
        if (!hl.class.equals(hlVar.getClass())) {
            return hl.class.getName().compareTo(hlVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m584a()).compareTo(Boolean.valueOf(hlVar.m584a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m584a() && (a13 = hr.a(this.f846a, hlVar.f846a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hr.a(this.f845a, hlVar.f845a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a11 = hr.a(this.f849b, hlVar.f849b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a10 = hr.a(this.f850c, hlVar.f850c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a9 = hr.a(this.f851d, hlVar.f851d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a8 = hr.a(this.f852e, hlVar.f852e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = hr.a(this.f853f, hlVar.f853f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = hr.a(this.f854g, hlVar.f854g)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = hr.a(this.f855h, hlVar.f855h)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = hr.a(this.f856i, hlVar.f856i)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = hr.a(this.f848a, hlVar.f848a)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hlVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = hr.a(this.f844a, hlVar.f844a)) == 0) {
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
                        this.f846a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f845a = new gu();
                        this.f845a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f849b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f850c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f851d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f852e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f853f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f854g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f855h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f856i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f848a = iaVar.mo613a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f844a = iaVar.mo602a();
                        b(true);
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
        if (this.f849b != null) {
            if (this.f850c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
