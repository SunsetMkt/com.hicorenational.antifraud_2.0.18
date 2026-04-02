package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hn implements hq<hn, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f871a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f872b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f873c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f874d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f875e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f876f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f868a = new Cif("XmPushActionUnSubscription");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9293b = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9294c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9295d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9296e = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9297f = new hx("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9298g = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9299h = new hx("", com.umeng.analytics.pro.cw.f7205m, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m587a() {
        return this.f870a != null;
    }

    public boolean b() {
        return this.f869a != null;
    }

    public boolean c() {
        return this.f872b != null;
    }

    public boolean d() {
        return this.f873c != null;
    }

    public boolean e() {
        return this.f874d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m588a((hn) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f875e != null;
    }

    public boolean g() {
        return this.f876f != null;
    }

    public boolean h() {
        return this.f871a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (m587a()) {
            sb.append("debug:");
            String str = this.f870a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
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
            gu guVar = this.f869a;
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
        String str2 = this.f872b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f873c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f874d;
        if (str4 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f875e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f876f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f871a;
            if (list == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hn a(String str) {
        this.f872b = str;
        return this;
    }

    public hn b(String str) {
        this.f873c = str;
        return this;
    }

    public hn c(String str) {
        this.f874d = str;
        return this;
    }

    public hn d(String str) {
        this.f875e = str;
        return this;
    }

    public hn e(String str) {
        this.f876f = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m588a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean zM587a = m587a();
        boolean zM587a2 = hnVar.m587a();
        if ((zM587a || zM587a2) && !(zM587a && zM587a2 && this.f870a.equals(hnVar.f870a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hnVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f869a.m505a(hnVar.f869a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hnVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f872b.equals(hnVar.f872b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hnVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f873c.equals(hnVar.f873c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hnVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f874d.equals(hnVar.f874d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hnVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f875e.equals(hnVar.f875e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hnVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f876f.equals(hnVar.f876f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hnVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f871a.equals(hnVar.f871a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f868a);
        if (this.f870a != null && m587a()) {
            iaVar.a(a);
            iaVar.a(this.f870a);
            iaVar.b();
        }
        if (this.f869a != null && b()) {
            iaVar.a(f9293b);
            this.f869a.b(iaVar);
            iaVar.b();
        }
        if (this.f872b != null) {
            iaVar.a(f9294c);
            iaVar.a(this.f872b);
            iaVar.b();
        }
        if (this.f873c != null) {
            iaVar.a(f9295d);
            iaVar.a(this.f873c);
            iaVar.b();
        }
        if (this.f874d != null) {
            iaVar.a(f9296e);
            iaVar.a(this.f874d);
            iaVar.b();
        }
        if (this.f875e != null && f()) {
            iaVar.a(f9297f);
            iaVar.a(this.f875e);
            iaVar.b();
        }
        if (this.f876f != null && g()) {
            iaVar.a(f9298g);
            iaVar.a(this.f876f);
            iaVar.b();
        }
        if (this.f871a != null && h()) {
            iaVar.a(f9299h);
            iaVar.a(new hy((byte) 11, this.f871a.size()));
            Iterator<String> it = this.f871a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hn hnVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!hn.class.equals(hnVar.getClass())) {
            return hn.class.getName().compareTo(hnVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m587a()).compareTo(Boolean.valueOf(hnVar.m587a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m587a() && (iA8 = hr.a(this.f870a, hnVar.f870a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hr.a(this.f869a, hnVar.f869a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hr.a(this.f872b, hnVar.f872b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hr.a(this.f873c, hnVar.f873c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hr.a(this.f874d, hnVar.f874d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hr.a(this.f875e, hnVar.f875e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hr.a(this.f876f, hnVar.f876f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hr.a(this.f871a, hnVar.f871a)) == 0) {
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
                a();
                return;
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f870a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        this.f869a = new gu();
                        this.f869a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f872b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f873c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f874d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f875e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f876f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        hy hyVarMo602a = iaVar.mo602a();
                        this.f871a = new ArrayList(hyVarMo602a.f899a);
                        for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                            this.f871a.add(iaVar.mo606a());
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                default:
                    id.a(iaVar, b2);
                    break;
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f872b != null) {
            if (this.f873c != null) {
                if (this.f874d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
