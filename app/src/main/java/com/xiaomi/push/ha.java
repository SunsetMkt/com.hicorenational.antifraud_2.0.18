package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ha implements hq<ha, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f705a;

    /* renamed from: a, reason: collision with other field name */
    public gu f706a;

    /* renamed from: a, reason: collision with other field name */
    public String f707a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f709a;

    /* renamed from: b, reason: collision with other field name */
    public String f711b;

    /* renamed from: c, reason: collision with other field name */
    public String f712c;

    /* renamed from: d, reason: collision with other field name */
    public String f713d;

    /* renamed from: e, reason: collision with other field name */
    public String f714e;

    /* renamed from: f, reason: collision with other field name */
    public String f715f;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f704a = new Cif("XmPushActionCommandResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13078a = new hx("", (byte) 12, 2);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13079b = new hx("", (byte) 11, 3);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13080c = new hx("", (byte) 11, 4);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13081d = new hx("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13082e = new hx("", (byte) 10, 7);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13083f = new hx("", (byte) 11, 8);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13084g = new hx("", (byte) 11, 9);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13085h = new hx("", com.umeng.analytics.pro.cw.f10303m, 10);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13086i = new hx("", (byte) 11, 12);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13087j = new hx("", (byte) 2, 13);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f708a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f710a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m525a() {
        return this.f706a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m527b() {
        return this.f707a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m528c() {
        return this.f711b != null;
    }

    public boolean d() {
        return this.f712c != null;
    }

    public boolean e() {
        return this.f708a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ha)) {
            return m526a((ha) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f713d != null;
    }

    public boolean g() {
        return this.f714e != null;
    }

    public boolean h() {
        return this.f709a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f715f != null;
    }

    public boolean j() {
        return this.f708a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m525a()) {
            sb.append("target:");
            gu guVar = this.f706a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(guVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f707a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f711b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f712c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f705a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f713d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f714e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f709a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f715f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f710a);
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f707a;
    }

    public String b() {
        return this.f712c;
    }

    public String c() {
        return this.f715f;
    }

    public void a(boolean z) {
        this.f708a.set(0, z);
    }

    public void b(boolean z) {
        this.f708a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m523a() {
        return this.f709a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m524a();
        iaVar.a(f704a);
        if (this.f706a != null && m525a()) {
            iaVar.a(f13078a);
            this.f706a.b(iaVar);
            iaVar.b();
        }
        if (this.f707a != null) {
            iaVar.a(f13079b);
            iaVar.a(this.f707a);
            iaVar.b();
        }
        if (this.f711b != null) {
            iaVar.a(f13080c);
            iaVar.a(this.f711b);
            iaVar.b();
        }
        if (this.f712c != null) {
            iaVar.a(f13081d);
            iaVar.a(this.f712c);
            iaVar.b();
        }
        iaVar.a(f13082e);
        iaVar.a(this.f705a);
        iaVar.b();
        if (this.f713d != null && f()) {
            iaVar.a(f13083f);
            iaVar.a(this.f713d);
            iaVar.b();
        }
        if (this.f714e != null && g()) {
            iaVar.a(f13084g);
            iaVar.a(this.f714e);
            iaVar.b();
        }
        if (this.f709a != null && h()) {
            iaVar.a(f13085h);
            iaVar.a(new hy((byte) 11, this.f709a.size()));
            Iterator<String> it = this.f709a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f715f != null && i()) {
            iaVar.a(f13086i);
            iaVar.a(this.f715f);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f13087j);
            iaVar.a(this.f710a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m526a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean m525a = m525a();
        boolean m525a2 = haVar.m525a();
        if ((m525a || m525a2) && !(m525a && m525a2 && this.f706a.m507a(haVar.f706a))) {
            return false;
        }
        boolean m527b = m527b();
        boolean m527b2 = haVar.m527b();
        if ((m527b || m527b2) && !(m527b && m527b2 && this.f707a.equals(haVar.f707a))) {
            return false;
        }
        boolean m528c = m528c();
        boolean m528c2 = haVar.m528c();
        if ((m528c || m528c2) && !(m528c && m528c2 && this.f711b.equals(haVar.f711b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = haVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f712c.equals(haVar.f712c))) || this.f705a != haVar.f705a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = haVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f713d.equals(haVar.f713d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = haVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f714e.equals(haVar.f714e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = haVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f709a.equals(haVar.f709a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = haVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f715f.equals(haVar.f715f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = haVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f710a == haVar.f710a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
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
        if (!ha.class.equals(haVar.getClass())) {
            return ha.class.getName().compareTo(haVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m525a()).compareTo(Boolean.valueOf(haVar.m525a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m525a() && (a11 = hr.a(this.f706a, haVar.f706a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m527b()).compareTo(Boolean.valueOf(haVar.m527b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m527b() && (a10 = hr.a(this.f707a, haVar.f707a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(m528c()).compareTo(Boolean.valueOf(haVar.m528c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m528c() && (a9 = hr.a(this.f711b, haVar.f711b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hr.a(this.f712c, haVar.f712c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hr.a(this.f705a, haVar.f705a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hr.a(this.f713d, haVar.f713d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hr.a(this.f714e, haVar.f714e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hr.a(this.f709a, haVar.f709a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hr.a(this.f715f, haVar.f715f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = hr.a(this.f710a, haVar.f710a)) == 0) {
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
                    m524a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo603a.f898a) {
                case 2:
                    if (b2 == 12) {
                        this.f706a = new gu();
                        this.f706a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f707a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f711b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f712c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                case 11:
                default:
                    id.a(iaVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f705a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f713d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f714e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 15) {
                        hy mo604a = iaVar.mo604a();
                        this.f709a = new ArrayList(mo604a.f899a);
                        for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                            this.f709a.add(iaVar.mo608a());
                        }
                        iaVar.i();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f715f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 2) {
                        this.f710a = iaVar.mo613a();
                        b(true);
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
    public void m524a() {
        if (this.f707a != null) {
            if (this.f711b != null) {
                if (this.f712c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
