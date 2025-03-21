package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hm implements hq<hm, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f858a;

    /* renamed from: a, reason: collision with other field name */
    public gu f859a;

    /* renamed from: a, reason: collision with other field name */
    public String f860a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f861a = new BitSet(3);

    /* renamed from: b, reason: collision with other field name */
    public long f862b;

    /* renamed from: b, reason: collision with other field name */
    public String f863b;

    /* renamed from: c, reason: collision with other field name */
    public long f864c;

    /* renamed from: c, reason: collision with other field name */
    public String f865c;

    /* renamed from: d, reason: collision with other field name */
    public String f866d;

    /* renamed from: e, reason: collision with other field name */
    public String f867e;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f857a = new Cif("XmPushActionUnRegistrationResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13185a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13186b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13187c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13188d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13189e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13190f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13191g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13192h = new hx("", (byte) 10, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13193i = new hx("", (byte) 10, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m587a() {
        return this.f860a != null;
    }

    public boolean b() {
        return this.f859a != null;
    }

    public boolean c() {
        return this.f863b != null;
    }

    public boolean d() {
        return this.f865c != null;
    }

    public boolean e() {
        return this.f861a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return m588a((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f866d != null;
    }

    public boolean g() {
        return this.f867e != null;
    }

    public boolean h() {
        return this.f861a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f861a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        if (m587a()) {
            sb.append("debug:");
            String str = this.f860a;
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
            gu guVar = this.f859a;
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
        String str2 = this.f863b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f865c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f858a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f866d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f867e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f862b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f864c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f861a.set(0, z);
    }

    public void b(boolean z) {
        this.f861a.set(1, z);
    }

    public void c(boolean z) {
        this.f861a.set(2, z);
    }

    public String a() {
        return this.f867e;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m586a();
        iaVar.a(f857a);
        if (this.f860a != null && m587a()) {
            iaVar.a(f13185a);
            iaVar.a(this.f860a);
            iaVar.b();
        }
        if (this.f859a != null && b()) {
            iaVar.a(f13186b);
            this.f859a.b(iaVar);
            iaVar.b();
        }
        if (this.f863b != null) {
            iaVar.a(f13187c);
            iaVar.a(this.f863b);
            iaVar.b();
        }
        if (this.f865c != null) {
            iaVar.a(f13188d);
            iaVar.a(this.f865c);
            iaVar.b();
        }
        iaVar.a(f13189e);
        iaVar.a(this.f858a);
        iaVar.b();
        if (this.f866d != null && f()) {
            iaVar.a(f13190f);
            iaVar.a(this.f866d);
            iaVar.b();
        }
        if (this.f867e != null && g()) {
            iaVar.a(f13191g);
            iaVar.a(this.f867e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f13192h);
            iaVar.a(this.f862b);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f13193i);
            iaVar.a(this.f864c);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m588a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean m587a = m587a();
        boolean m587a2 = hmVar.m587a();
        if ((m587a || m587a2) && !(m587a && m587a2 && this.f860a.equals(hmVar.f860a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hmVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f859a.m507a(hmVar.f859a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hmVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f863b.equals(hmVar.f863b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hmVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f865c.equals(hmVar.f865c))) || this.f858a != hmVar.f858a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hmVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f866d.equals(hmVar.f866d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hmVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f867e.equals(hmVar.f867e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hmVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f862b == hmVar.f862b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hmVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f864c == hmVar.f864c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hm hmVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!hm.class.equals(hmVar.getClass())) {
            return hm.class.getName().compareTo(hmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m587a()).compareTo(Boolean.valueOf(hmVar.m587a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m587a() && (a10 = hr.a(this.f860a, hmVar.f860a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = hr.a(this.f859a, hmVar.f859a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = hr.a(this.f863b, hmVar.f863b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hr.a(this.f865c, hmVar.f865c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hr.a(this.f858a, hmVar.f858a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hr.a(this.f866d, hmVar.f866d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = hr.a(this.f867e, hmVar.f867e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = hr.a(this.f862b, hmVar.f862b)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = hr.a(this.f864c, hmVar.f864c)) == 0) {
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
                    m586a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f860a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f859a = new gu();
                        this.f859a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f863b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f865c = iaVar.mo608a();
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
                        this.f858a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f866d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f867e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 10) {
                        this.f862b = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 10) {
                        this.f864c = iaVar.mo602a();
                        c(true);
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
    public void m586a() {
        if (this.f863b != null) {
            if (this.f865c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
