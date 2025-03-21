package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class ho implements hq<ho, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f878a;

    /* renamed from: a, reason: collision with other field name */
    public gu f879a;

    /* renamed from: a, reason: collision with other field name */
    public String f880a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f881a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f882b;

    /* renamed from: c, reason: collision with other field name */
    public String f883c;

    /* renamed from: d, reason: collision with other field name */
    public String f884d;

    /* renamed from: e, reason: collision with other field name */
    public String f885e;

    /* renamed from: f, reason: collision with other field name */
    public String f886f;

    /* renamed from: g, reason: collision with other field name */
    public String f887g;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f877a = new Cif("XmPushActionUnSubscriptionResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13202a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13203b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13204c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13205d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13206e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13207f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13208g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13209h = new hx("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13210i = new hx("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m592a() {
        return this.f880a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m594b() {
        return this.f879a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m595c() {
        return this.f882b != null;
    }

    public boolean d() {
        return this.f883c != null;
    }

    public boolean e() {
        return this.f881a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m593a((ho) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f884d != null;
    }

    public boolean g() {
        return this.f885e != null;
    }

    public boolean h() {
        return this.f886f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f887g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        if (m592a()) {
            sb.append("debug:");
            String str = this.f880a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m594b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f879a;
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
        String str2 = this.f882b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f883c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f878a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f884d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f885e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f886f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f887g;
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
        return this.f882b;
    }

    public String b() {
        return this.f885e;
    }

    public String c() {
        return this.f887g;
    }

    public void a(boolean z) {
        this.f881a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m591a();
        iaVar.a(f877a);
        if (this.f880a != null && m592a()) {
            iaVar.a(f13202a);
            iaVar.a(this.f880a);
            iaVar.b();
        }
        if (this.f879a != null && m594b()) {
            iaVar.a(f13203b);
            this.f879a.b(iaVar);
            iaVar.b();
        }
        if (this.f882b != null) {
            iaVar.a(f13204c);
            iaVar.a(this.f882b);
            iaVar.b();
        }
        if (this.f883c != null && d()) {
            iaVar.a(f13205d);
            iaVar.a(this.f883c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f13206e);
            iaVar.a(this.f878a);
            iaVar.b();
        }
        if (this.f884d != null && f()) {
            iaVar.a(f13207f);
            iaVar.a(this.f884d);
            iaVar.b();
        }
        if (this.f885e != null && g()) {
            iaVar.a(f13208g);
            iaVar.a(this.f885e);
            iaVar.b();
        }
        if (this.f886f != null && h()) {
            iaVar.a(f13209h);
            iaVar.a(this.f886f);
            iaVar.b();
        }
        if (this.f887g != null && i()) {
            iaVar.a(f13210i);
            iaVar.a(this.f887g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m593a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean m592a = m592a();
        boolean m592a2 = hoVar.m592a();
        if ((m592a || m592a2) && !(m592a && m592a2 && this.f880a.equals(hoVar.f880a))) {
            return false;
        }
        boolean m594b = m594b();
        boolean m594b2 = hoVar.m594b();
        if ((m594b || m594b2) && !(m594b && m594b2 && this.f879a.m507a(hoVar.f879a))) {
            return false;
        }
        boolean m595c = m595c();
        boolean m595c2 = hoVar.m595c();
        if ((m595c || m595c2) && !(m595c && m595c2 && this.f882b.equals(hoVar.f882b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hoVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f883c.equals(hoVar.f883c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hoVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f878a == hoVar.f878a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hoVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f884d.equals(hoVar.f884d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hoVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f885e.equals(hoVar.f885e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hoVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f886f.equals(hoVar.f886f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hoVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f887g.equals(hoVar.f887g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ho hoVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!ho.class.equals(hoVar.getClass())) {
            return ho.class.getName().compareTo(hoVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m592a()).compareTo(Boolean.valueOf(hoVar.m592a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m592a() && (a10 = hr.a(this.f880a, hoVar.f880a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m594b()).compareTo(Boolean.valueOf(hoVar.m594b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m594b() && (a9 = hr.a(this.f879a, hoVar.f879a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m595c()).compareTo(Boolean.valueOf(hoVar.m595c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m595c() && (a8 = hr.a(this.f882b, hoVar.f882b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hr.a(this.f883c, hoVar.f883c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hr.a(this.f878a, hoVar.f878a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hr.a(this.f884d, hoVar.f884d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = hr.a(this.f885e, hoVar.f885e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = hr.a(this.f886f, hoVar.f886f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hoVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = hr.a(this.f887g, hoVar.f887g)) == 0) {
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
                m591a();
                return;
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f880a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f879a = new gu();
                        this.f879a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f882b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f883c = iaVar.mo608a();
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
                        this.f878a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f884d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f885e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f886f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f887g = iaVar.mo608a();
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
    public void m591a() {
        if (this.f882b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
