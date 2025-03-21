package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gq implements hq<gq, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f599a;

    /* renamed from: a, reason: collision with other field name */
    public long f600a;

    /* renamed from: a, reason: collision with other field name */
    public String f601a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f602a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f603a;

    /* renamed from: b, reason: collision with other field name */
    public int f604b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f605b;

    /* renamed from: c, reason: collision with other field name */
    public int f606c;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f598a = new Cif("OnlineConfigItem");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12999a = new hx("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13000b = new hx("", (byte) 8, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13001c = new hx("", (byte) 2, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13002d = new hx("", (byte) 8, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13003e = new hx("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13004f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13005g = new hx("", (byte) 2, 7);

    public int a() {
        return this.f599a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m482a() {
    }

    public int b() {
        return this.f604b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m486c() {
        return this.f602a.get(2);
    }

    public boolean d() {
        return this.f602a.get(3);
    }

    public boolean e() {
        return this.f602a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gq)) {
            return m484a((gq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f601a != null;
    }

    public boolean g() {
        return this.f605b;
    }

    public boolean h() {
        return this.f602a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (m483a()) {
            sb.append("key:");
            sb.append(this.f599a);
            z = false;
        } else {
            z = true;
        }
        if (m485b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f604b);
            z = false;
        }
        if (m486c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f603a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f606c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f600a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f601a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f605b);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m483a() {
        return this.f602a.get(0);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m485b() {
        return this.f602a.get(1);
    }

    public void c(boolean z) {
        this.f602a.set(2, z);
    }

    public void d(boolean z) {
        this.f602a.set(3, z);
    }

    public void e(boolean z) {
        this.f602a.set(4, z);
    }

    public void f(boolean z) {
        this.f602a.set(5, z);
    }

    public void a(boolean z) {
        this.f602a.set(0, z);
    }

    public void b(boolean z) {
        this.f602a.set(1, z);
    }

    public int c() {
        return this.f606c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m480a() {
        return this.f600a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m482a();
        iaVar.a(f598a);
        if (m483a()) {
            iaVar.a(f12999a);
            iaVar.mo612a(this.f599a);
            iaVar.b();
        }
        if (m485b()) {
            iaVar.a(f13000b);
            iaVar.mo612a(this.f604b);
            iaVar.b();
        }
        if (m486c()) {
            iaVar.a(f13001c);
            iaVar.a(this.f603a);
            iaVar.b();
        }
        if (d()) {
            iaVar.a(f13002d);
            iaVar.mo612a(this.f606c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f13003e);
            iaVar.a(this.f600a);
            iaVar.b();
        }
        if (this.f601a != null && f()) {
            iaVar.a(f13004f);
            iaVar.a(this.f601a);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f13005g);
            iaVar.a(this.f605b);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m481a() {
        return this.f601a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m484a(gq gqVar) {
        if (gqVar == null) {
            return false;
        }
        boolean m483a = m483a();
        boolean m483a2 = gqVar.m483a();
        if ((m483a || m483a2) && !(m483a && m483a2 && this.f599a == gqVar.f599a)) {
            return false;
        }
        boolean m485b = m485b();
        boolean m485b2 = gqVar.m485b();
        if ((m485b || m485b2) && !(m485b && m485b2 && this.f604b == gqVar.f604b)) {
            return false;
        }
        boolean m486c = m486c();
        boolean m486c2 = gqVar.m486c();
        if ((m486c || m486c2) && !(m486c && m486c2 && this.f603a == gqVar.f603a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f606c == gqVar.f606c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f600a == gqVar.f600a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f601a.equals(gqVar.f601a))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gqVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f605b == gqVar.f605b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gq gqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!gq.class.equals(gqVar.getClass())) {
            return gq.class.getName().compareTo(gqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m483a()).compareTo(Boolean.valueOf(gqVar.m483a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m483a() && (a8 = hr.a(this.f599a, gqVar.f599a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(m485b()).compareTo(Boolean.valueOf(gqVar.m485b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m485b() && (a7 = hr.a(this.f604b, gqVar.f604b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(m486c()).compareTo(Boolean.valueOf(gqVar.m486c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m486c() && (a6 = hr.a(this.f603a, gqVar.f603a)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gqVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = hr.a(this.f606c, gqVar.f606c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gqVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = hr.a(this.f600a, gqVar.f600a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gqVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = hr.a(this.f601a, gqVar.f601a)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gqVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!h() || (a2 = hr.a(this.f605b, gqVar.f605b)) == 0) {
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
                m482a();
                return;
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 8) {
                        this.f599a = iaVar.mo601a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f604b = iaVar.mo601a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f603a = iaVar.mo613a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 8) {
                        this.f606c = iaVar.mo601a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f600a = iaVar.mo602a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f601a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 2) {
                        this.f605b = iaVar.mo613a();
                        f(true);
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
