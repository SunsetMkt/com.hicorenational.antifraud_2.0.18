package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class he implements hq<he, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a */
    public long f731a;

    /* JADX INFO: renamed from: a */
    public gu f732a;

    /* JADX INFO: renamed from: a */
    public String f733a;

    /* JADX INFO: renamed from: a */
    public ByteBuffer f734a;

    /* JADX INFO: renamed from: a */
    private BitSet f735a;

    /* JADX INFO: renamed from: a */
    public Map<String, String> f736a;

    /* JADX INFO: renamed from: a */
    public boolean f737a;

    /* JADX INFO: renamed from: b */
    public String f738b;

    /* JADX INFO: renamed from: b */
    public boolean f739b;

    /* JADX INFO: renamed from: c */
    public String f740c;

    /* JADX INFO: renamed from: d */
    public String f741d;

    /* JADX INFO: renamed from: e */
    public String f742e;

    /* JADX INFO: renamed from: f */
    public String f743f;

    /* JADX INFO: renamed from: g */
    public String f744g;

    /* JADX INFO: renamed from: h */
    public String f745h;

    /* JADX INFO: renamed from: i */
    public String f746i;

    /* JADX INFO: renamed from: a */
    private static final Cif f730a = new Cif("XmPushActionNotification");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b */
    private static final hx f9203b = new hx("", (byte) 12, 2);

    /* JADX INFO: renamed from: c */
    private static final hx f9204c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d */
    private static final hx f9205d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e */
    private static final hx f9206e = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: f */
    private static final hx f9207f = new hx("", (byte) 2, 6);

    /* JADX INFO: renamed from: g */
    private static final hx f9208g = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: h */
    private static final hx f9209h = new hx("", com.umeng.analytics.pro.cw.f7203k, 8);

    /* JADX INFO: renamed from: i */
    private static final hx f9210i = new hx("", (byte) 11, 9);

    /* JADX INFO: renamed from: j */
    private static final hx f9211j = new hx("", (byte) 11, 10);

    /* JADX INFO: renamed from: k */
    private static final hx f9212k = new hx("", (byte) 11, 12);

    /* JADX INFO: renamed from: l */
    private static final hx f9213l = new hx("", (byte) 11, 13);

    /* JADX INFO: renamed from: m */
    private static final hx f9214m = new hx("", (byte) 11, 14);

    /* JADX INFO: renamed from: n */
    private static final hx f9215n = new hx("", (byte) 10, 15);
    private static final hx o = new hx("", (byte) 2, 20);

    public he() {
        this.f735a = new BitSet(3);
        this.f737a = true;
        this.f739b = false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m546a() {
        return this.f733a != null;
    }

    /* JADX INFO: renamed from: b */
    public boolean m549b() {
        return this.f732a != null;
    }

    /* JADX INFO: renamed from: c */
    public boolean m550c() {
        return this.f738b != null;
    }

    /* JADX INFO: renamed from: d */
    public boolean m551d() {
        return this.f740c != null;
    }

    public boolean e() {
        return this.f741d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof he)) {
            return m547a((he) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f735a.get(0);
    }

    public boolean g() {
        return this.f742e != null;
    }

    public boolean h() {
        return this.f736a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f743f != null;
    }

    public boolean j() {
        return this.f744g != null;
    }

    public boolean k() {
        return this.f745h != null;
    }

    public boolean l() {
        return this.f746i != null;
    }

    public boolean m() {
        return this.f734a != null;
    }

    public boolean n() {
        return this.f735a.get(1);
    }

    public boolean o() {
        return this.f735a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        if (m546a()) {
            sb.append("debug:");
            String str = this.f733a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m549b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f732a;
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
        String str2 = this.f738b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        if (m551d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f740c;
            if (str3 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f741d;
            if (str4 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f737a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f742e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f736a;
            if (map == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f743f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f744g;
            if (str7 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f745h;
            if (str8 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f746i;
            if (str9 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f734a;
            if (byteBuffer == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                hr.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f731a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f739b);
        }
        sb.append(")");
        return sb.toString();
    }

    public gu a() {
        return this.f732a;
    }

    public String b() {
        return this.f740c;
    }

    public String c() {
        return this.f741d;
    }

    public String d() {
        return this.f743f;
    }

    /* JADX INFO: renamed from: a */
    public String m542a() {
        return this.f738b;
    }

    public he b(String str) {
        this.f740c = str;
        return this;
    }

    public he c(String str) {
        this.f741d = str;
        return this;
    }

    public he d(String str) {
        this.f743f = str;
        return this;
    }

    public he a(String str) {
        this.f738b = str;
        return this;
    }

    public void b(boolean z) {
        this.f735a.set(1, z);
    }

    public void c(boolean z) {
        this.f735a.set(2, z);
    }

    public he(String str, boolean z) {
        this();
        this.f738b = str;
        this.f737a = z;
        m545a(true);
    }

    public he a(boolean z) {
        this.f737a = z;
        m545a(true);
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m544a();
        iaVar.a(f730a);
        if (this.f733a != null && m546a()) {
            iaVar.a(a);
            iaVar.a(this.f733a);
            iaVar.b();
        }
        if (this.f732a != null && m549b()) {
            iaVar.a(f9203b);
            this.f732a.b(iaVar);
            iaVar.b();
        }
        if (this.f738b != null) {
            iaVar.a(f9204c);
            iaVar.a(this.f738b);
            iaVar.b();
        }
        if (this.f740c != null && m551d()) {
            iaVar.a(f9205d);
            iaVar.a(this.f740c);
            iaVar.b();
        }
        if (this.f741d != null && e()) {
            iaVar.a(f9206e);
            iaVar.a(this.f741d);
            iaVar.b();
        }
        iaVar.a(f9207f);
        iaVar.a(this.f737a);
        iaVar.b();
        if (this.f742e != null && g()) {
            iaVar.a(f9208g);
            iaVar.a(this.f742e);
            iaVar.b();
        }
        if (this.f736a != null && h()) {
            iaVar.a(f9209h);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f736a.size()));
            for (Map.Entry<String, String> entry : this.f736a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f743f != null && i()) {
            iaVar.a(f9210i);
            iaVar.a(this.f743f);
            iaVar.b();
        }
        if (this.f744g != null && j()) {
            iaVar.a(f9211j);
            iaVar.a(this.f744g);
            iaVar.b();
        }
        if (this.f745h != null && k()) {
            iaVar.a(f9212k);
            iaVar.a(this.f745h);
            iaVar.b();
        }
        if (this.f746i != null && l()) {
            iaVar.a(f9213l);
            iaVar.a(this.f746i);
            iaVar.b();
        }
        if (this.f734a != null && m()) {
            iaVar.a(f9214m);
            iaVar.a(this.f734a);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(f9215n);
            iaVar.a(this.f731a);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.a(this.f739b);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a */
    public void m545a(boolean z) {
        this.f735a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f736a == null) {
            this.f736a = new HashMap();
        }
        this.f736a.put(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m543a() {
        return this.f736a;
    }

    public he a(Map<String, String> map) {
        this.f736a = map;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public byte[] m548a() {
        a(hr.a(this.f734a));
        return this.f734a.array();
    }

    public he a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public he a(ByteBuffer byteBuffer) {
        this.f734a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m547a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean zM546a = m546a();
        boolean zM546a2 = heVar.m546a();
        if ((zM546a || zM546a2) && !(zM546a && zM546a2 && this.f733a.equals(heVar.f733a))) {
            return false;
        }
        boolean zM549b = m549b();
        boolean zM549b2 = heVar.m549b();
        if ((zM549b || zM549b2) && !(zM549b && zM549b2 && this.f732a.m505a(heVar.f732a))) {
            return false;
        }
        boolean zM550c = m550c();
        boolean zM550c2 = heVar.m550c();
        if ((zM550c || zM550c2) && !(zM550c && zM550c2 && this.f738b.equals(heVar.f738b))) {
            return false;
        }
        boolean zM551d = m551d();
        boolean zM551d2 = heVar.m551d();
        if ((zM551d || zM551d2) && !(zM551d && zM551d2 && this.f740c.equals(heVar.f740c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = heVar.e();
        if (((zE || zE2) && !(zE && zE2 && this.f741d.equals(heVar.f741d))) || this.f737a != heVar.f737a) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = heVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f742e.equals(heVar.f742e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = heVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f736a.equals(heVar.f736a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = heVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f743f.equals(heVar.f743f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = heVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f744g.equals(heVar.f744g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = heVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f745h.equals(heVar.f745h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = heVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f746i.equals(heVar.f746i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = heVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f734a.equals(heVar.f734a))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = heVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f731a == heVar.f731a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = heVar.o();
        if (zO || zO2) {
            return zO && zO2 && this.f739b == heVar.f739b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(he heVar) {
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
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        int iA15;
        if (!he.class.equals(heVar.getClass())) {
            return he.class.getName().compareTo(heVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m546a()).compareTo(Boolean.valueOf(heVar.m546a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m546a() && (iA15 = hr.a(this.f733a, heVar.f733a)) != 0) {
            return iA15;
        }
        int iCompareTo2 = Boolean.valueOf(m549b()).compareTo(Boolean.valueOf(heVar.m549b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m549b() && (iA14 = hr.a(this.f732a, heVar.f732a)) != 0) {
            return iA14;
        }
        int iCompareTo3 = Boolean.valueOf(m550c()).compareTo(Boolean.valueOf(heVar.m550c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m550c() && (iA13 = hr.a(this.f738b, heVar.f738b)) != 0) {
            return iA13;
        }
        int iCompareTo4 = Boolean.valueOf(m551d()).compareTo(Boolean.valueOf(heVar.m551d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m551d() && (iA12 = hr.a(this.f740c, heVar.f740c)) != 0) {
            return iA12;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(heVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA11 = hr.a(this.f741d, heVar.f741d)) != 0) {
            return iA11;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(heVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA10 = hr.a(this.f737a, heVar.f737a)) != 0) {
            return iA10;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(heVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA9 = hr.a(this.f742e, heVar.f742e)) != 0) {
            return iA9;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(heVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA8 = hr.a(this.f736a, heVar.f736a)) != 0) {
            return iA8;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(heVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA7 = hr.a(this.f743f, heVar.f743f)) != 0) {
            return iA7;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(heVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA6 = hr.a(this.f744g, heVar.f744g)) != 0) {
            return iA6;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(heVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA5 = hr.a(this.f745h, heVar.f745h)) != 0) {
            return iA5;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(heVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA4 = hr.a(this.f746i, heVar.f746i)) != 0) {
            return iA4;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(heVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA3 = hr.a(this.f734a, heVar.f734a)) != 0) {
            return iA3;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(heVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA2 = hr.a(this.f731a, heVar.f731a)) != 0) {
            return iA2;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(heVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (!o() || (iA = hr.a(this.f739b, heVar.f739b)) == 0) {
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
                if (f()) {
                    m544a();
                    return;
                }
                throw new ib("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f733a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        this.f732a = new gu();
                        this.f732a.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f738b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f740c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f741d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f737a = iaVar.mo611a();
                        m545a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f742e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        hz hzVarMo603a = iaVar.mo603a();
                        this.f736a = new HashMap(hzVarMo603a.f900a * 2);
                        for (int i2 = 0; i2 < hzVarMo603a.f900a; i2++) {
                            this.f736a.put(iaVar.mo606a(), iaVar.mo606a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f743f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f744g = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    id.a(iaVar, b2);
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f745h = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f746i = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f734a = iaVar.mo607a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f731a = iaVar.mo600a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f739b = iaVar.mo611a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m544a() throws ib {
        if (this.f738b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
