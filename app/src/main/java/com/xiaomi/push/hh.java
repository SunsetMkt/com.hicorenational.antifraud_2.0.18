package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hh implements hq<hh, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f801a;

    /* renamed from: a, reason: collision with other field name */
    public gu f802a;

    /* renamed from: a, reason: collision with other field name */
    public String f803a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f804a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f805b;

    /* renamed from: c, reason: collision with other field name */
    public String f806c;

    /* renamed from: d, reason: collision with other field name */
    public String f807d;

    /* renamed from: e, reason: collision with other field name */
    public String f808e;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f800a = new Cif("XmPushActionSendFeedbackResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13137a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13138b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13139c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13140d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13141e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13142f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13143g = new hx("", (byte) 11, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m566a() {
        return this.f803a != null;
    }

    public boolean b() {
        return this.f802a != null;
    }

    public boolean c() {
        return this.f805b != null;
    }

    public boolean d() {
        return this.f806c != null;
    }

    public boolean e() {
        return this.f804a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hh)) {
            return m567a((hh) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f807d != null;
    }

    public boolean g() {
        return this.f808e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        if (m566a()) {
            sb.append("debug:");
            String str = this.f803a;
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
            gu guVar = this.f802a;
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
        String str2 = this.f805b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f806c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f801a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f807d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f808e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f804a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f800a);
        if (this.f803a != null && m566a()) {
            iaVar.a(f13137a);
            iaVar.a(this.f803a);
            iaVar.b();
        }
        if (this.f802a != null && b()) {
            iaVar.a(f13138b);
            this.f802a.b(iaVar);
            iaVar.b();
        }
        if (this.f805b != null) {
            iaVar.a(f13139c);
            iaVar.a(this.f805b);
            iaVar.b();
        }
        if (this.f806c != null) {
            iaVar.a(f13140d);
            iaVar.a(this.f806c);
            iaVar.b();
        }
        iaVar.a(f13141e);
        iaVar.a(this.f801a);
        iaVar.b();
        if (this.f807d != null && f()) {
            iaVar.a(f13142f);
            iaVar.a(this.f807d);
            iaVar.b();
        }
        if (this.f808e != null && g()) {
            iaVar.a(f13143g);
            iaVar.a(this.f808e);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m567a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean m566a = m566a();
        boolean m566a2 = hhVar.m566a();
        if ((m566a || m566a2) && !(m566a && m566a2 && this.f803a.equals(hhVar.f803a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hhVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f802a.m507a(hhVar.f802a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hhVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f805b.equals(hhVar.f805b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hhVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f806c.equals(hhVar.f806c))) || this.f801a != hhVar.f801a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hhVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f807d.equals(hhVar.f807d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hhVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f808e.equals(hhVar.f808e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hh hhVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!hh.class.equals(hhVar.getClass())) {
            return hh.class.getName().compareTo(hhVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m566a()).compareTo(Boolean.valueOf(hhVar.m566a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m566a() && (a8 = hr.a(this.f803a, hhVar.f803a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hhVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = hr.a(this.f802a, hhVar.f802a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hhVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = hr.a(this.f805b, hhVar.f805b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hhVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = hr.a(this.f806c, hhVar.f806c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hhVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = hr.a(this.f801a, hhVar.f801a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hhVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = hr.a(this.f807d, hhVar.f807d)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hhVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a2 = hr.a(this.f808e, hhVar.f808e)) == 0) {
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
                    a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f803a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f802a = new gu();
                        this.f802a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f805b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f806c = iaVar.mo608a();
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
                        this.f801a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f807d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f808e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
            }
            iaVar.g();
        }
    }

    public void a() {
        if (this.f805b != null) {
            if (this.f806c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
