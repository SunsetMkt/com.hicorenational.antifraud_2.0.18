package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class hk implements hq<hk, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f836a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f837b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f838c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f839d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f840e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f841f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f842g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f832a = new Cif("XmPushActionSubscriptionResult");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9266b = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9267c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9268d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9269e = new hx("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9270f = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9271g = new hx("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9272h = new hx("", (byte) 11, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hx f9273i = new hx("", (byte) 11, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m578a() {
        return this.f835a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m580b() {
        return this.f834a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m581c() {
        return this.f837b != null;
    }

    public boolean d() {
        return this.f838c != null;
    }

    public boolean e() {
        return this.f836a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m579a((hk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f839d != null;
    }

    public boolean g() {
        return this.f840e != null;
    }

    public boolean h() {
        return this.f841f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f842g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (m578a()) {
            sb.append("debug:");
            String str = this.f835a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m580b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f834a;
            if (guVar == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(guVar);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f837b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f838c;
            if (str3 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f833a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f839d;
            if (str4 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f840e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f841f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f842g;
            if (str7 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f837b;
    }

    public String b() {
        return this.f840e;
    }

    public String c() {
        return this.f842g;
    }

    public void a(boolean z) {
        this.f836a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m577a();
        iaVar.a(f832a);
        if (this.f835a != null && m578a()) {
            iaVar.a(a);
            iaVar.a(this.f835a);
            iaVar.b();
        }
        if (this.f834a != null && m580b()) {
            iaVar.a(f9266b);
            this.f834a.b(iaVar);
            iaVar.b();
        }
        if (this.f837b != null) {
            iaVar.a(f9267c);
            iaVar.a(this.f837b);
            iaVar.b();
        }
        if (this.f838c != null && d()) {
            iaVar.a(f9268d);
            iaVar.a(this.f838c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f9269e);
            iaVar.a(this.f833a);
            iaVar.b();
        }
        if (this.f839d != null && f()) {
            iaVar.a(f9270f);
            iaVar.a(this.f839d);
            iaVar.b();
        }
        if (this.f840e != null && g()) {
            iaVar.a(f9271g);
            iaVar.a(this.f840e);
            iaVar.b();
        }
        if (this.f841f != null && h()) {
            iaVar.a(f9272h);
            iaVar.a(this.f841f);
            iaVar.b();
        }
        if (this.f842g != null && i()) {
            iaVar.a(f9273i);
            iaVar.a(this.f842g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m579a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean zM578a = m578a();
        boolean zM578a2 = hkVar.m578a();
        if ((zM578a || zM578a2) && !(zM578a && zM578a2 && this.f835a.equals(hkVar.f835a))) {
            return false;
        }
        boolean zM580b = m580b();
        boolean zM580b2 = hkVar.m580b();
        if ((zM580b || zM580b2) && !(zM580b && zM580b2 && this.f834a.m505a(hkVar.f834a))) {
            return false;
        }
        boolean zM581c = m581c();
        boolean zM581c2 = hkVar.m581c();
        if ((zM581c || zM581c2) && !(zM581c && zM581c2 && this.f837b.equals(hkVar.f837b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hkVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f838c.equals(hkVar.f838c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hkVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f833a == hkVar.f833a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hkVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f839d.equals(hkVar.f839d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hkVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f840e.equals(hkVar.f840e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hkVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f841f.equals(hkVar.f841f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hkVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f842g.equals(hkVar.f842g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hk hkVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!hk.class.equals(hkVar.getClass())) {
            return hk.class.getName().compareTo(hkVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m578a()).compareTo(Boolean.valueOf(hkVar.m578a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m578a() && (iA9 = hr.a(this.f835a, hkVar.f835a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m580b()).compareTo(Boolean.valueOf(hkVar.m580b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m580b() && (iA8 = hr.a(this.f834a, hkVar.f834a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m581c()).compareTo(Boolean.valueOf(hkVar.m581c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m581c() && (iA7 = hr.a(this.f837b, hkVar.f837b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hr.a(this.f838c, hkVar.f838c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hr.a(this.f833a, hkVar.f833a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hr.a(this.f839d, hkVar.f839d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hr.a(this.f840e, hkVar.f840e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hr.a(this.f841f, hkVar.f841f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hr.a(this.f842g, hkVar.f842g)) == 0) {
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
                m577a();
                return;
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f835a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        this.f834a = new gu();
                        this.f834a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f837b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f838c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                default:
                    id.a(iaVar, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f833a = iaVar.mo600a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f839d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f840e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f841f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f842g = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m577a() throws ib {
        if (this.f837b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
