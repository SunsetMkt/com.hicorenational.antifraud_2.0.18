package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class hh implements hq<hh, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f804a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f805b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f806c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f807d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f808e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f800a = new Cif("XmPushActionSendFeedbackResult");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9242b = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9243c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9244d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9245e = new hx("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9246f = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9247g = new hx("", (byte) 11, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m564a() {
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
            return m565a((hh) obj);
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
        if (m564a()) {
            sb.append("debug:");
            String str = this.f803a;
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
            gu guVar = this.f802a;
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
        String str2 = this.f805b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f806c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
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
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f808e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
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
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f800a);
        if (this.f803a != null && m564a()) {
            iaVar.a(a);
            iaVar.a(this.f803a);
            iaVar.b();
        }
        if (this.f802a != null && b()) {
            iaVar.a(f9242b);
            this.f802a.b(iaVar);
            iaVar.b();
        }
        if (this.f805b != null) {
            iaVar.a(f9243c);
            iaVar.a(this.f805b);
            iaVar.b();
        }
        if (this.f806c != null) {
            iaVar.a(f9244d);
            iaVar.a(this.f806c);
            iaVar.b();
        }
        iaVar.a(f9245e);
        iaVar.a(this.f801a);
        iaVar.b();
        if (this.f807d != null && f()) {
            iaVar.a(f9246f);
            iaVar.a(this.f807d);
            iaVar.b();
        }
        if (this.f808e != null && g()) {
            iaVar.a(f9247g);
            iaVar.a(this.f808e);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m565a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean zM564a = m564a();
        boolean zM564a2 = hhVar.m564a();
        if ((zM564a || zM564a2) && !(zM564a && zM564a2 && this.f803a.equals(hhVar.f803a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hhVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f802a.m505a(hhVar.f802a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hhVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f805b.equals(hhVar.f805b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hhVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f806c.equals(hhVar.f806c))) || this.f801a != hhVar.f801a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hhVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f807d.equals(hhVar.f807d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hhVar.g();
        if (zG || zG2) {
            return zG && zG2 && this.f808e.equals(hhVar.f808e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hh hhVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!hh.class.equals(hhVar.getClass())) {
            return hh.class.getName().compareTo(hhVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m564a()).compareTo(Boolean.valueOf(hhVar.m564a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m564a() && (iA7 = hr.a(this.f803a, hhVar.f803a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hhVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA6 = hr.a(this.f802a, hhVar.f802a)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hhVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA5 = hr.a(this.f805b, hhVar.f805b)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hhVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = hr.a(this.f806c, hhVar.f806c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hhVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = hr.a(this.f801a, hhVar.f801a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hhVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = hr.a(this.f807d, hhVar.f807d)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hhVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!g() || (iA = hr.a(this.f808e, hhVar.f808e)) == 0) {
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
                    a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f803a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        this.f802a = new gu();
                        this.f802a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f805b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f806c = iaVar.mo606a();
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
                        this.f801a = iaVar.mo600a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f807d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f808e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f805b != null) {
            if (this.f806c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
