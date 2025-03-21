package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gz implements hq<gz, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f693a;

    /* renamed from: a, reason: collision with other field name */
    public gu f694a;

    /* renamed from: a, reason: collision with other field name */
    public String f695a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f697a;

    /* renamed from: b, reason: collision with other field name */
    public String f699b;

    /* renamed from: c, reason: collision with other field name */
    public String f701c;

    /* renamed from: d, reason: collision with other field name */
    public String f702d;

    /* renamed from: e, reason: collision with other field name */
    public String f703e;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f692a = new Cif("XmPushActionCommand");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13067a = new hx("", (byte) 12, 2);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13068b = new hx("", (byte) 11, 3);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13069c = new hx("", (byte) 11, 4);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13070d = new hx("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13071e = new hx("", com.umeng.analytics.pro.cw.f10303m, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13072f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13073g = new hx("", (byte) 11, 9);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13074h = new hx("", (byte) 2, 10);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13075i = new hx("", (byte) 2, 11);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13076j = new hx("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f696a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public boolean f698a = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f700b = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m521a() {
        return this.f694a != null;
    }

    public boolean b() {
        return this.f695a != null;
    }

    public boolean c() {
        return this.f699b != null;
    }

    public boolean d() {
        return this.f701c != null;
    }

    public boolean e() {
        return this.f697a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gz)) {
            return m522a((gz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f702d != null;
    }

    public boolean g() {
        return this.f703e != null;
    }

    public boolean h() {
        return this.f696a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f696a.get(1);
    }

    public boolean j() {
        return this.f696a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m521a()) {
            sb.append("target:");
            gu guVar = this.f694a;
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
        String str = this.f695a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f699b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f701c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f697a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f702d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f703e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f698a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f700b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f693a);
        }
        sb.append(")");
        return sb.toString();
    }

    public gz a(String str) {
        this.f695a = str;
        return this;
    }

    public gz b(String str) {
        this.f699b = str;
        return this;
    }

    public gz c(String str) {
        this.f701c = str;
        return this;
    }

    public gz d(String str) {
        this.f702d = str;
        return this;
    }

    public gz e(String str) {
        this.f703e = str;
        return this;
    }

    public String a() {
        return this.f701c;
    }

    public void b(boolean z) {
        this.f696a.set(1, z);
    }

    public void c(boolean z) {
        this.f696a.set(2, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m520a(String str) {
        if (this.f697a == null) {
            this.f697a = new ArrayList();
        }
        this.f697a.add(str);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m519a();
        iaVar.a(f692a);
        if (this.f694a != null && m521a()) {
            iaVar.a(f13067a);
            this.f694a.b(iaVar);
            iaVar.b();
        }
        if (this.f695a != null) {
            iaVar.a(f13068b);
            iaVar.a(this.f695a);
            iaVar.b();
        }
        if (this.f699b != null) {
            iaVar.a(f13069c);
            iaVar.a(this.f699b);
            iaVar.b();
        }
        if (this.f701c != null) {
            iaVar.a(f13070d);
            iaVar.a(this.f701c);
            iaVar.b();
        }
        if (this.f697a != null && e()) {
            iaVar.a(f13071e);
            iaVar.a(new hy((byte) 11, this.f697a.size()));
            Iterator<String> it = this.f697a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f702d != null && f()) {
            iaVar.a(f13072f);
            iaVar.a(this.f702d);
            iaVar.b();
        }
        if (this.f703e != null && g()) {
            iaVar.a(f13073g);
            iaVar.a(this.f703e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f13074h);
            iaVar.a(this.f698a);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f13075i);
            iaVar.a(this.f700b);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f13076j);
            iaVar.a(this.f693a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public void a(boolean z) {
        this.f696a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m522a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean m521a = m521a();
        boolean m521a2 = gzVar.m521a();
        if ((m521a || m521a2) && !(m521a && m521a2 && this.f694a.m507a(gzVar.f694a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gzVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f695a.equals(gzVar.f695a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gzVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f699b.equals(gzVar.f699b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gzVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f701c.equals(gzVar.f701c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f697a.equals(gzVar.f697a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f702d.equals(gzVar.f702d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f703e.equals(gzVar.f703e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f698a == gzVar.f698a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f700b == gzVar.f700b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gzVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f693a == gzVar.f693a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
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
        if (!gz.class.equals(gzVar.getClass())) {
            return gz.class.getName().compareTo(gzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m521a()).compareTo(Boolean.valueOf(gzVar.m521a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m521a() && (a11 = hr.a(this.f694a, gzVar.f694a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gzVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hr.a(this.f695a, gzVar.f695a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gzVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hr.a(this.f699b, gzVar.f699b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gzVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hr.a(this.f701c, gzVar.f701c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hr.a(this.f697a, gzVar.f697a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gzVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hr.a(this.f702d, gzVar.f702d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gzVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hr.a(this.f703e, gzVar.f703e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gzVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hr.a(this.f698a, gzVar.f698a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gzVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hr.a(this.f700b, gzVar.f700b)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gzVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = hr.a(this.f693a, gzVar.f693a)) == 0) {
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
                m519a();
                return;
            }
            switch (mo603a.f898a) {
                case 2:
                    if (b2 == 12) {
                        this.f694a = new gu();
                        this.f694a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f695a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f699b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f701c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 15) {
                        hy mo604a = iaVar.mo604a();
                        this.f697a = new ArrayList(mo604a.f899a);
                        for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                            this.f697a.add(iaVar.mo608a());
                        }
                        iaVar.i();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f702d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                default:
                    id.a(iaVar, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f703e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 2) {
                        this.f698a = iaVar.mo613a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f700b = iaVar.mo613a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f693a = iaVar.mo602a();
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
    public void m519a() {
        if (this.f695a != null) {
            if (this.f699b != null) {
                if (this.f701c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
