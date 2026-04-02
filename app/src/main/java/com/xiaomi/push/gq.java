package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class gq implements hq<gq, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f602a = new BitSet(6);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f603a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f604b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f605b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f606c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f598a = new Cif("OnlineConfigItem");
    private static final hx a = new hx("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9117b = new hx("", (byte) 8, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9118c = new hx("", (byte) 2, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9119d = new hx("", (byte) 8, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9120e = new hx("", (byte) 10, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9121f = new hx("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9122g = new hx("", (byte) 2, 7);

    public int a() {
        return this.f599a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m480a() {
    }

    public int b() {
        return this.f604b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m484c() {
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
            return m482a((gq) obj);
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
        if (m481a()) {
            sb.append("key:");
            sb.append(this.f599a);
            z = false;
        } else {
            z = true;
        }
        if (m483b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f604b);
            z = false;
        }
        if (m484c()) {
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
                sb.append(d.c.a.b.a.a.f10075h);
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m481a() {
        return this.f602a.get(0);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m483b() {
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m478a() {
        return this.f600a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m480a();
        iaVar.a(f598a);
        if (m481a()) {
            iaVar.a(a);
            iaVar.mo610a(this.f599a);
            iaVar.b();
        }
        if (m483b()) {
            iaVar.a(f9117b);
            iaVar.mo610a(this.f604b);
            iaVar.b();
        }
        if (m484c()) {
            iaVar.a(f9118c);
            iaVar.a(this.f603a);
            iaVar.b();
        }
        if (d()) {
            iaVar.a(f9119d);
            iaVar.mo610a(this.f606c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f9120e);
            iaVar.a(this.f600a);
            iaVar.b();
        }
        if (this.f601a != null && f()) {
            iaVar.a(f9121f);
            iaVar.a(this.f601a);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f9122g);
            iaVar.a(this.f605b);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m479a() {
        return this.f601a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m482a(gq gqVar) {
        if (gqVar == null) {
            return false;
        }
        boolean zM481a = m481a();
        boolean zM481a2 = gqVar.m481a();
        if ((zM481a || zM481a2) && !(zM481a && zM481a2 && this.f599a == gqVar.f599a)) {
            return false;
        }
        boolean zM483b = m483b();
        boolean zM483b2 = gqVar.m483b();
        if ((zM483b || zM483b2) && !(zM483b && zM483b2 && this.f604b == gqVar.f604b)) {
            return false;
        }
        boolean zM484c = m484c();
        boolean zM484c2 = gqVar.m484c();
        if ((zM484c || zM484c2) && !(zM484c && zM484c2 && this.f603a == gqVar.f603a)) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gqVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f606c == gqVar.f606c)) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gqVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f600a == gqVar.f600a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gqVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f601a.equals(gqVar.f601a))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gqVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f605b == gqVar.f605b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gq gqVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!gq.class.equals(gqVar.getClass())) {
            return gq.class.getName().compareTo(gqVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m481a()).compareTo(Boolean.valueOf(gqVar.m481a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m481a() && (iA7 = hr.a(this.f599a, gqVar.f599a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(m483b()).compareTo(Boolean.valueOf(gqVar.m483b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m483b() && (iA6 = hr.a(this.f604b, gqVar.f604b)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(m484c()).compareTo(Boolean.valueOf(gqVar.m484c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m484c() && (iA5 = hr.a(this.f603a, gqVar.f603a)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gqVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = hr.a(this.f606c, gqVar.f606c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gqVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = hr.a(this.f600a, gqVar.f600a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gqVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = hr.a(this.f601a, gqVar.f601a)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gqVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!h() || (iA = hr.a(this.f605b, gqVar.f605b)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo605a();
        while (true) {
            hx hxVarMo601a = iaVar.mo601a();
            byte b2 = hxVarMo601a.a;
            if (b2 == 0) {
                iaVar.f();
                m480a();
                return;
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 8) {
                        this.f599a = iaVar.mo599a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f604b = iaVar.mo599a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f603a = iaVar.mo611a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f606c = iaVar.mo599a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f600a = iaVar.mo600a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f601a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f605b = iaVar.mo611a();
                        f(true);
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
}
