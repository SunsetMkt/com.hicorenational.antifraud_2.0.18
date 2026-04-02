package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements hq<gz, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f697a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f699b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f701c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f702d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f703e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f692a = new Cif("XmPushActionCommand");
    private static final hx a = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9178b = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9179c = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9180d = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9181e = new hx("", com.umeng.analytics.pro.cw.f7205m, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9182f = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9183g = new hx("", (byte) 11, 9);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9184h = new hx("", (byte) 2, 10);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hx f9185i = new hx("", (byte) 2, 11);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hx f9186j = new hx("", (byte) 10, 12);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f696a = new BitSet(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f698a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f700b = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m519a() {
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
            return m520a((gz) obj);
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
        if (m519a()) {
            sb.append("target:");
            gu guVar = this.f694a;
            if (guVar == null) {
                sb.append(d.c.a.b.a.a.f10075h);
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
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f699b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f701c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f697a;
            if (list == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f702d;
            if (str4 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f703e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m518a(String str) {
        if (this.f697a == null) {
            this.f697a = new ArrayList();
        }
        this.f697a.add(str);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m517a();
        iaVar.a(f692a);
        if (this.f694a != null && m519a()) {
            iaVar.a(a);
            this.f694a.b(iaVar);
            iaVar.b();
        }
        if (this.f695a != null) {
            iaVar.a(f9178b);
            iaVar.a(this.f695a);
            iaVar.b();
        }
        if (this.f699b != null) {
            iaVar.a(f9179c);
            iaVar.a(this.f699b);
            iaVar.b();
        }
        if (this.f701c != null) {
            iaVar.a(f9180d);
            iaVar.a(this.f701c);
            iaVar.b();
        }
        if (this.f697a != null && e()) {
            iaVar.a(f9181e);
            iaVar.a(new hy((byte) 11, this.f697a.size()));
            Iterator<String> it = this.f697a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f702d != null && f()) {
            iaVar.a(f9182f);
            iaVar.a(this.f702d);
            iaVar.b();
        }
        if (this.f703e != null && g()) {
            iaVar.a(f9183g);
            iaVar.a(this.f703e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f9184h);
            iaVar.a(this.f698a);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f9185i);
            iaVar.a(this.f700b);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f9186j);
            iaVar.a(this.f693a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    public void a(boolean z) {
        this.f696a.set(0, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m520a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean zM519a = m519a();
        boolean zM519a2 = gzVar.m519a();
        if ((zM519a || zM519a2) && !(zM519a && zM519a2 && this.f694a.m505a(gzVar.f694a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gzVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f695a.equals(gzVar.f695a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gzVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f699b.equals(gzVar.f699b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gzVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f701c.equals(gzVar.f701c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gzVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f697a.equals(gzVar.f697a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gzVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f702d.equals(gzVar.f702d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gzVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f703e.equals(gzVar.f703e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gzVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f698a == gzVar.f698a)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gzVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f700b == gzVar.f700b)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gzVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f693a == gzVar.f693a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        if (!gz.class.equals(gzVar.getClass())) {
            return gz.class.getName().compareTo(gzVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m519a()).compareTo(Boolean.valueOf(gzVar.m519a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m519a() && (iA10 = hr.a(this.f694a, gzVar.f694a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gzVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = hr.a(this.f695a, gzVar.f695a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gzVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hr.a(this.f699b, gzVar.f699b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gzVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f701c, gzVar.f701c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f697a, gzVar.f697a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gzVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f702d, gzVar.f702d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gzVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f703e, gzVar.f703e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gzVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f698a, gzVar.f698a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gzVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f700b, gzVar.f700b)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gzVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f693a, gzVar.f693a)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) throws ib {
        iaVar.mo605a();
        while (true) {
            hx hxVarMo601a = iaVar.mo601a();
            byte b2 = hxVarMo601a.a;
            if (b2 == 0) {
                iaVar.f();
                m517a();
                return;
            }
            switch (hxVarMo601a.f898a) {
                case 2:
                    if (b2 == 12) {
                        this.f694a = new gu();
                        this.f694a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f695a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f699b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f701c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        hy hyVarMo602a = iaVar.mo602a();
                        this.f697a = new ArrayList(hyVarMo602a.f899a);
                        for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                            this.f697a.add(iaVar.mo606a());
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f702d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                default:
                    id.a(iaVar, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f703e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f698a = iaVar.mo611a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f700b = iaVar.mo611a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f693a = iaVar.mo600a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m517a() throws ib {
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
