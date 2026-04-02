package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class ho implements hq<ho, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f881a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f882b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f883c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f884d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f885e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f886f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f887g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f877a = new Cif("XmPushActionUnSubscriptionResult");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9300b = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9301c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9302d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9303e = new hx("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9304f = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9305g = new hx("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9306h = new hx("", (byte) 11, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hx f9307i = new hx("", (byte) 11, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m590a() {
        return this.f880a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m592b() {
        return this.f879a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m593c() {
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
            return m591a((ho) obj);
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
        if (m590a()) {
            sb.append("debug:");
            String str = this.f880a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m592b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f879a;
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
        String str2 = this.f882b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f883c;
            if (str3 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
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
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f885e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f886f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f887g;
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
    public void b(ia iaVar) throws ib {
        m589a();
        iaVar.a(f877a);
        if (this.f880a != null && m590a()) {
            iaVar.a(a);
            iaVar.a(this.f880a);
            iaVar.b();
        }
        if (this.f879a != null && m592b()) {
            iaVar.a(f9300b);
            this.f879a.b(iaVar);
            iaVar.b();
        }
        if (this.f882b != null) {
            iaVar.a(f9301c);
            iaVar.a(this.f882b);
            iaVar.b();
        }
        if (this.f883c != null && d()) {
            iaVar.a(f9302d);
            iaVar.a(this.f883c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f9303e);
            iaVar.a(this.f878a);
            iaVar.b();
        }
        if (this.f884d != null && f()) {
            iaVar.a(f9304f);
            iaVar.a(this.f884d);
            iaVar.b();
        }
        if (this.f885e != null && g()) {
            iaVar.a(f9305g);
            iaVar.a(this.f885e);
            iaVar.b();
        }
        if (this.f886f != null && h()) {
            iaVar.a(f9306h);
            iaVar.a(this.f886f);
            iaVar.b();
        }
        if (this.f887g != null && i()) {
            iaVar.a(f9307i);
            iaVar.a(this.f887g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m591a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean zM590a = m590a();
        boolean zM590a2 = hoVar.m590a();
        if ((zM590a || zM590a2) && !(zM590a && zM590a2 && this.f880a.equals(hoVar.f880a))) {
            return false;
        }
        boolean zM592b = m592b();
        boolean zM592b2 = hoVar.m592b();
        if ((zM592b || zM592b2) && !(zM592b && zM592b2 && this.f879a.m505a(hoVar.f879a))) {
            return false;
        }
        boolean zM593c = m593c();
        boolean zM593c2 = hoVar.m593c();
        if ((zM593c || zM593c2) && !(zM593c && zM593c2 && this.f882b.equals(hoVar.f882b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hoVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f883c.equals(hoVar.f883c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hoVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f878a == hoVar.f878a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hoVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f884d.equals(hoVar.f884d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hoVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f885e.equals(hoVar.f885e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hoVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f886f.equals(hoVar.f886f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hoVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f887g.equals(hoVar.f887g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ho hoVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!ho.class.equals(hoVar.getClass())) {
            return ho.class.getName().compareTo(hoVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m590a()).compareTo(Boolean.valueOf(hoVar.m590a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m590a() && (iA9 = hr.a(this.f880a, hoVar.f880a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m592b()).compareTo(Boolean.valueOf(hoVar.m592b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m592b() && (iA8 = hr.a(this.f879a, hoVar.f879a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m593c()).compareTo(Boolean.valueOf(hoVar.m593c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m593c() && (iA7 = hr.a(this.f882b, hoVar.f882b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hr.a(this.f883c, hoVar.f883c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hr.a(this.f878a, hoVar.f878a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hr.a(this.f884d, hoVar.f884d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hr.a(this.f885e, hoVar.f885e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hr.a(this.f886f, hoVar.f886f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hoVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hr.a(this.f887g, hoVar.f887g)) == 0) {
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
                m589a();
                return;
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f880a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        this.f879a = new gu();
                        this.f879a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f882b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f883c = iaVar.mo606a();
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
                        this.f878a = iaVar.mo600a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f884d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f885e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f886f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f887g = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m589a() throws ib {
        if (this.f882b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
