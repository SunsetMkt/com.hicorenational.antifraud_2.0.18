package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hj implements hq<hj, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f826a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f827b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f828c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f829d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f830e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f831f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f823a = new Cif("XmPushActionSubscription");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9259b = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9260c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9261d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9262e = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9263f = new hx("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9264g = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9265h = new hx("", com.umeng.analytics.pro.cw.f7205m, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m575a() {
        return this.f825a != null;
    }

    public boolean b() {
        return this.f824a != null;
    }

    public boolean c() {
        return this.f827b != null;
    }

    public boolean d() {
        return this.f828c != null;
    }

    public boolean e() {
        return this.f829d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m576a((hj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f830e != null;
    }

    public boolean g() {
        return this.f831f != null;
    }

    public boolean h() {
        return this.f826a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (m575a()) {
            sb.append("debug:");
            String str = this.f825a;
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
            gu guVar = this.f824a;
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
        String str2 = this.f827b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f828c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f829d;
        if (str4 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f830e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f831f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f826a;
            if (list == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hj a(String str) {
        this.f827b = str;
        return this;
    }

    public hj b(String str) {
        this.f828c = str;
        return this;
    }

    public hj c(String str) {
        this.f829d = str;
        return this;
    }

    public hj d(String str) {
        this.f830e = str;
        return this;
    }

    public hj e(String str) {
        this.f831f = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m576a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean zM575a = m575a();
        boolean zM575a2 = hjVar.m575a();
        if ((zM575a || zM575a2) && !(zM575a && zM575a2 && this.f825a.equals(hjVar.f825a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hjVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f824a.m505a(hjVar.f824a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hjVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f827b.equals(hjVar.f827b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hjVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f828c.equals(hjVar.f828c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hjVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f829d.equals(hjVar.f829d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hjVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f830e.equals(hjVar.f830e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hjVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f831f.equals(hjVar.f831f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hjVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f826a.equals(hjVar.f826a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f823a);
        if (this.f825a != null && m575a()) {
            iaVar.a(a);
            iaVar.a(this.f825a);
            iaVar.b();
        }
        if (this.f824a != null && b()) {
            iaVar.a(f9259b);
            this.f824a.b(iaVar);
            iaVar.b();
        }
        if (this.f827b != null) {
            iaVar.a(f9260c);
            iaVar.a(this.f827b);
            iaVar.b();
        }
        if (this.f828c != null) {
            iaVar.a(f9261d);
            iaVar.a(this.f828c);
            iaVar.b();
        }
        if (this.f829d != null) {
            iaVar.a(f9262e);
            iaVar.a(this.f829d);
            iaVar.b();
        }
        if (this.f830e != null && f()) {
            iaVar.a(f9263f);
            iaVar.a(this.f830e);
            iaVar.b();
        }
        if (this.f831f != null && g()) {
            iaVar.a(f9264g);
            iaVar.a(this.f831f);
            iaVar.b();
        }
        if (this.f826a != null && h()) {
            iaVar.a(f9265h);
            iaVar.a(new hy((byte) 11, this.f826a.size()));
            Iterator<String> it = this.f826a.iterator();
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
    public int compareTo(hj hjVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!hj.class.equals(hjVar.getClass())) {
            return hj.class.getName().compareTo(hjVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m575a()).compareTo(Boolean.valueOf(hjVar.m575a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m575a() && (iA8 = hr.a(this.f825a, hjVar.f825a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hr.a(this.f824a, hjVar.f824a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hjVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hr.a(this.f827b, hjVar.f827b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hr.a(this.f828c, hjVar.f828c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hjVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hr.a(this.f829d, hjVar.f829d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hr.a(this.f830e, hjVar.f830e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hr.a(this.f831f, hjVar.f831f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hr.a(this.f826a, hjVar.f826a)) == 0) {
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
                        this.f825a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        this.f824a = new gu();
                        this.f824a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f827b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f828c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f829d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f830e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f831f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        hy hyVarMo602a = iaVar.mo602a();
                        this.f826a = new ArrayList(hyVarMo602a.f899a);
                        for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                            this.f826a.add(iaVar.mo606a());
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
        if (this.f827b != null) {
            if (this.f828c != null) {
                if (this.f829d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
