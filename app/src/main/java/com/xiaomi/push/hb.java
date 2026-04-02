package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class hb implements hq<hb, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gf f717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gs f718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f721a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f724b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f716a = new Cif("XmPushActionContainer");
    private static final hx a = new hx("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9196b = new hx("", (byte) 2, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9197c = new hx("", (byte) 2, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9198d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9199e = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9200f = new hx("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9201g = new hx("", (byte) 12, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9202h = new hx("", (byte) 12, 8);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f722a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f723a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f725b = true;

    public gf a() {
        return this.f717a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m535b() {
        return this.f723a;
    }

    public boolean c() {
        return this.f722a.get(0);
    }

    public boolean d() {
        return this.f722a.get(1);
    }

    public boolean e() {
        return this.f721a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return m532a((hb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f720a != null;
    }

    public boolean g() {
        return this.f724b != null;
    }

    public boolean h() {
        return this.f719a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f718a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        gf gfVar = this.f717a;
        if (gfVar == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(gfVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f723a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f725b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f720a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f724b;
            if (str2 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        gu guVar = this.f719a;
        if (guVar == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(guVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gs gsVar = this.f718a;
            if (gsVar == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(gsVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hb a(gf gfVar) {
        this.f717a = gfVar;
        return this;
    }

    public hb b(boolean z) {
        this.f725b = z;
        m534b(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m531a() {
        return this.f717a != null;
    }

    public hb a(boolean z) {
        this.f723a = z;
        m530a(true);
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m534b(boolean z) {
        this.f722a.set(1, z);
    }

    public String b() {
        return this.f724b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m530a(boolean z) {
        this.f722a.set(0, z);
    }

    public hb b(String str) {
        this.f724b = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m533a() {
        a(hr.a(this.f721a));
        return this.f721a.array();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m529a();
        iaVar.a(f716a);
        if (this.f717a != null) {
            iaVar.a(a);
            iaVar.mo610a(this.f717a.a());
            iaVar.b();
        }
        iaVar.a(f9196b);
        iaVar.a(this.f723a);
        iaVar.b();
        iaVar.a(f9197c);
        iaVar.a(this.f725b);
        iaVar.b();
        if (this.f721a != null) {
            iaVar.a(f9198d);
            iaVar.a(this.f721a);
            iaVar.b();
        }
        if (this.f720a != null && f()) {
            iaVar.a(f9199e);
            iaVar.a(this.f720a);
            iaVar.b();
        }
        if (this.f724b != null && g()) {
            iaVar.a(f9200f);
            iaVar.a(this.f724b);
            iaVar.b();
        }
        if (this.f719a != null) {
            iaVar.a(f9201g);
            this.f719a.b(iaVar);
            iaVar.b();
        }
        if (this.f718a != null && i()) {
            iaVar.a(f9202h);
            this.f718a.b(iaVar);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    public hb a(ByteBuffer byteBuffer) {
        this.f721a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m528a() {
        return this.f720a;
    }

    public hb a(String str) {
        this.f720a = str;
        return this;
    }

    public hb a(gu guVar) {
        this.f719a = guVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gs m527a() {
        return this.f718a;
    }

    public hb a(gs gsVar) {
        this.f718a = gsVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m532a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean zM531a = m531a();
        boolean zM531a2 = hbVar.m531a();
        if (((zM531a || zM531a2) && (!zM531a || !zM531a2 || !this.f717a.equals(hbVar.f717a))) || this.f723a != hbVar.f723a || this.f725b != hbVar.f725b) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hbVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f721a.equals(hbVar.f721a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hbVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f720a.equals(hbVar.f720a))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hbVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f724b.equals(hbVar.f724b))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hbVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f719a.m505a(hbVar.f719a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hbVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f718a.m497a(hbVar.f718a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hb hbVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!hb.class.equals(hbVar.getClass())) {
            return hb.class.getName().compareTo(hbVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m531a()).compareTo(Boolean.valueOf(hbVar.m531a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m531a() && (iA8 = hr.a(this.f717a, hbVar.f717a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hbVar.c()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (c() && (iA7 = hr.a(this.f723a, hbVar.f723a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (d() && (iA6 = hr.a(this.f725b, hbVar.f725b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (e() && (iA5 = hr.a(this.f721a, hbVar.f721a)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hbVar.f()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (f() && (iA4 = hr.a(this.f720a, hbVar.f720a)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (g() && (iA3 = hr.a(this.f724b, hbVar.f724b)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hbVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (h() && (iA2 = hr.a(this.f719a, hbVar.f719a)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!i() || (iA = hr.a(this.f718a, hbVar.f718a)) == 0) {
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
                if (c()) {
                    if (d()) {
                        m529a();
                        return;
                    }
                    throw new ib("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 8) {
                        this.f717a = gf.a(iaVar.mo599a());
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f723a = iaVar.mo611a();
                        m530a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f725b = iaVar.mo611a();
                        m534b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f721a = iaVar.mo607a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f720a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f724b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        this.f719a = new gu();
                        this.f719a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        this.f718a = new gs();
                        this.f718a.a(iaVar);
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m529a() throws ib {
        if (this.f717a != null) {
            if (this.f721a != null) {
                if (this.f719a != null) {
                    return;
                }
                throw new ib("Required field 'target' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'action' was not present! Struct: " + toString());
    }
}
