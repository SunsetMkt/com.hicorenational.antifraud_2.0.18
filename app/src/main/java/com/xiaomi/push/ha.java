package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ha implements hq<ha, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f709a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f711b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f712c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f713d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f714e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f715f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f704a = new Cif("XmPushActionCommandResult");
    private static final hx a = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9187b = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9188c = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9189d = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9190e = new hx("", (byte) 10, 7);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9191f = new hx("", (byte) 11, 8);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9192g = new hx("", (byte) 11, 9);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9193h = new hx("", com.umeng.analytics.pro.cw.f7205m, 10);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hx f9194i = new hx("", (byte) 11, 12);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hx f9195j = new hx("", (byte) 2, 13);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f708a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f710a = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m523a() {
        return this.f706a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m525b() {
        return this.f707a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m526c() {
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
            return m524a((ha) obj);
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
        if (m523a()) {
            sb.append("target:");
            gu guVar = this.f706a;
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
        String str = this.f707a;
        if (str == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f711b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f712c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
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
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f714e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f709a;
            if (list == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f715f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m521a() {
        return this.f709a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m522a();
        iaVar.a(f704a);
        if (this.f706a != null && m523a()) {
            iaVar.a(a);
            this.f706a.b(iaVar);
            iaVar.b();
        }
        if (this.f707a != null) {
            iaVar.a(f9187b);
            iaVar.a(this.f707a);
            iaVar.b();
        }
        if (this.f711b != null) {
            iaVar.a(f9188c);
            iaVar.a(this.f711b);
            iaVar.b();
        }
        if (this.f712c != null) {
            iaVar.a(f9189d);
            iaVar.a(this.f712c);
            iaVar.b();
        }
        iaVar.a(f9190e);
        iaVar.a(this.f705a);
        iaVar.b();
        if (this.f713d != null && f()) {
            iaVar.a(f9191f);
            iaVar.a(this.f713d);
            iaVar.b();
        }
        if (this.f714e != null && g()) {
            iaVar.a(f9192g);
            iaVar.a(this.f714e);
            iaVar.b();
        }
        if (this.f709a != null && h()) {
            iaVar.a(f9193h);
            iaVar.a(new hy((byte) 11, this.f709a.size()));
            Iterator<String> it = this.f709a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f715f != null && i()) {
            iaVar.a(f9194i);
            iaVar.a(this.f715f);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f9195j);
            iaVar.a(this.f710a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m524a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean zM523a = m523a();
        boolean zM523a2 = haVar.m523a();
        if ((zM523a || zM523a2) && !(zM523a && zM523a2 && this.f706a.m505a(haVar.f706a))) {
            return false;
        }
        boolean zM525b = m525b();
        boolean zM525b2 = haVar.m525b();
        if ((zM525b || zM525b2) && !(zM525b && zM525b2 && this.f707a.equals(haVar.f707a))) {
            return false;
        }
        boolean zM526c = m526c();
        boolean zM526c2 = haVar.m526c();
        if ((zM526c || zM526c2) && !(zM526c && zM526c2 && this.f711b.equals(haVar.f711b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = haVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f712c.equals(haVar.f712c))) || this.f705a != haVar.f705a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = haVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f713d.equals(haVar.f713d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = haVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f714e.equals(haVar.f714e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = haVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f709a.equals(haVar.f709a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = haVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f715f.equals(haVar.f715f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = haVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f710a == haVar.f710a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
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
        if (!ha.class.equals(haVar.getClass())) {
            return ha.class.getName().compareTo(haVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m523a()).compareTo(Boolean.valueOf(haVar.m523a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m523a() && (iA10 = hr.a(this.f706a, haVar.f706a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m525b()).compareTo(Boolean.valueOf(haVar.m525b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m525b() && (iA9 = hr.a(this.f707a, haVar.f707a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(m526c()).compareTo(Boolean.valueOf(haVar.m526c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m526c() && (iA8 = hr.a(this.f711b, haVar.f711b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f712c, haVar.f712c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f705a, haVar.f705a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f713d, haVar.f713d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f714e, haVar.f714e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f709a, haVar.f709a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f715f, haVar.f715f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f710a, haVar.f710a)) == 0) {
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
                if (e()) {
                    m522a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo601a.f898a) {
                case 2:
                    if (b2 == 12) {
                        this.f706a = new gu();
                        this.f706a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f707a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f711b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f712c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                case 11:
                default:
                    id.a(iaVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f705a = iaVar.mo600a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f713d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f714e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        hy hyVarMo602a = iaVar.mo602a();
                        this.f709a = new ArrayList(hyVarMo602a.f899a);
                        for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                            this.f709a.add(iaVar.mo606a());
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f715f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f710a = iaVar.mo611a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m522a() throws ib {
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
