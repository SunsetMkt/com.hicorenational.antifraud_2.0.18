package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gs implements hq<gs, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a */
    public int f628a;

    /* JADX INFO: renamed from: a */
    public long f629a;

    /* JADX INFO: renamed from: a */
    public String f630a;

    /* JADX INFO: renamed from: a */
    private BitSet f631a;

    /* JADX INFO: renamed from: a */
    public Map<String, String> f632a;

    /* JADX INFO: renamed from: a */
    public boolean f633a;

    /* JADX INFO: renamed from: b */
    public int f634b;

    /* JADX INFO: renamed from: b */
    public String f635b;

    /* JADX INFO: renamed from: b */
    public Map<String, String> f636b;

    /* JADX INFO: renamed from: c */
    public int f637c;

    /* JADX INFO: renamed from: c */
    public String f638c;

    /* JADX INFO: renamed from: c */
    public Map<String, String> f639c;

    /* JADX INFO: renamed from: d */
    public String f640d;

    /* JADX INFO: renamed from: e */
    public String f641e;

    /* JADX INFO: renamed from: a */
    private static final Cif f627a = new Cif("PushMetaInfo");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b */
    private static final hx f9136b = new hx("", (byte) 10, 2);

    /* JADX INFO: renamed from: c */
    private static final hx f9137c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d */
    private static final hx f9138d = new hx("", (byte) 11, 4);

    /* JADX INFO: renamed from: e */
    private static final hx f9139e = new hx("", (byte) 11, 5);

    /* JADX INFO: renamed from: f */
    private static final hx f9140f = new hx("", (byte) 8, 6);

    /* JADX INFO: renamed from: g */
    private static final hx f9141g = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: h */
    private static final hx f9142h = new hx("", (byte) 8, 8);

    /* JADX INFO: renamed from: i */
    private static final hx f9143i = new hx("", (byte) 8, 9);

    /* JADX INFO: renamed from: j */
    private static final hx f9144j = new hx("", com.umeng.analytics.pro.cw.f7203k, 10);

    /* JADX INFO: renamed from: k */
    private static final hx f9145k = new hx("", com.umeng.analytics.pro.cw.f7203k, 11);

    /* JADX INFO: renamed from: l */
    private static final hx f9146l = new hx("", (byte) 2, 12);

    /* JADX INFO: renamed from: m */
    private static final hx f9147m = new hx("", com.umeng.analytics.pro.cw.f7203k, 13);

    public gs() {
        this.f631a = new BitSet(5);
        this.f633a = false;
    }

    /* JADX INFO: renamed from: a */
    public gs m492a() {
        return new gs(this);
    }

    /* JADX INFO: renamed from: b */
    public boolean m500b() {
        return this.f631a.get(0);
    }

    /* JADX INFO: renamed from: c */
    public boolean m502c() {
        return this.f635b != null;
    }

    /* JADX INFO: renamed from: d */
    public boolean m503d() {
        return this.f638c != null;
    }

    public boolean e() {
        return this.f640d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gs)) {
            return m497a((gs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f631a.get(1);
    }

    public boolean g() {
        return this.f641e != null;
    }

    public boolean h() {
        return this.f631a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f631a.get(3);
    }

    public boolean j() {
        return this.f632a != null;
    }

    public boolean k() {
        return this.f636b != null;
    }

    public boolean l() {
        return this.f633a;
    }

    public boolean m() {
        return this.f631a.get(4);
    }

    public boolean n() {
        return this.f639c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f630a;
        if (str == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f629a);
        if (m502c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f635b;
            if (str2 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str2);
            }
        }
        if (m503d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f638c;
            if (str3 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f640d;
            if (str4 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f628a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f641e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f634b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f637c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f632a;
            if (map == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f636b;
            if (map2 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f633a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f639c;
            if (map3 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public String m493a() {
        return this.f630a;
    }

    /* JADX INFO: renamed from: b */
    public String m498b() {
        return this.f635b;
    }

    /* JADX INFO: renamed from: c */
    public String m501c() {
        return this.f638c;
    }

    public String d() {
        return this.f640d;
    }

    public void e(boolean z) {
        this.f631a.set(4, z);
    }

    public gs a(String str) {
        this.f630a = str;
        return this;
    }

    public gs b(String str) {
        this.f635b = str;
        return this;
    }

    public gs c(String str) {
        this.f638c = str;
        return this;
    }

    public gs d(String str) {
        this.f640d = str;
        return this;
    }

    public gs(gs gsVar) {
        this.f631a = new BitSet(5);
        this.f631a.clear();
        this.f631a.or(gsVar.f631a);
        if (gsVar.m496a()) {
            this.f630a = gsVar.f630a;
        }
        this.f629a = gsVar.f629a;
        if (gsVar.m502c()) {
            this.f635b = gsVar.f635b;
        }
        if (gsVar.m503d()) {
            this.f638c = gsVar.f638c;
        }
        if (gsVar.e()) {
            this.f640d = gsVar.f640d;
        }
        this.f628a = gsVar.f628a;
        if (gsVar.g()) {
            this.f641e = gsVar.f641e;
        }
        this.f634b = gsVar.f634b;
        this.f637c = gsVar.f637c;
        if (gsVar.j()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, String> entry : gsVar.f632a.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            this.f632a = map;
        }
        if (gsVar.k()) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, String> entry2 : gsVar.f636b.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue());
            }
            this.f636b = map2;
        }
        this.f633a = gsVar.f633a;
        if (gsVar.n()) {
            HashMap map3 = new HashMap();
            for (Map.Entry<String, String> entry3 : gsVar.f639c.entrySet()) {
                map3.put(entry3.getKey(), entry3.getValue());
            }
            this.f639c = map3;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m496a() {
        return this.f630a != null;
    }

    public void b(boolean z) {
        this.f631a.set(1, z);
    }

    public void c(boolean z) {
        this.f631a.set(2, z);
    }

    public void d(boolean z) {
        this.f631a.set(3, z);
    }

    /* JADX INFO: renamed from: a */
    public long m491a() {
        return this.f629a;
    }

    public int b() {
        return this.f634b;
    }

    public int c() {
        return this.f637c;
    }

    public void a(boolean z) {
        this.f631a.set(0, z);
    }

    public gs b(int i2) {
        this.f634b = i2;
        c(true);
        return this;
    }

    public gs c(int i2) {
        this.f637c = i2;
        d(true);
        return this;
    }

    public int a() {
        return this.f628a;
    }

    public gs a(int i2) {
        this.f628a = i2;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f636b == null) {
            this.f636b = new HashMap();
        }
        this.f636b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f632a == null) {
            this.f632a = new HashMap();
        }
        this.f632a.put(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public Map<String, String> m499b() {
        return this.f636b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m495a();
        iaVar.a(f627a);
        if (this.f630a != null) {
            iaVar.a(a);
            iaVar.a(this.f630a);
            iaVar.b();
        }
        iaVar.a(f9136b);
        iaVar.a(this.f629a);
        iaVar.b();
        if (this.f635b != null && m502c()) {
            iaVar.a(f9137c);
            iaVar.a(this.f635b);
            iaVar.b();
        }
        if (this.f638c != null && m503d()) {
            iaVar.a(f9138d);
            iaVar.a(this.f638c);
            iaVar.b();
        }
        if (this.f640d != null && e()) {
            iaVar.a(f9139e);
            iaVar.a(this.f640d);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f9140f);
            iaVar.mo610a(this.f628a);
            iaVar.b();
        }
        if (this.f641e != null && g()) {
            iaVar.a(f9141g);
            iaVar.a(this.f641e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f9142h);
            iaVar.mo610a(this.f634b);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f9143i);
            iaVar.mo610a(this.f637c);
            iaVar.b();
        }
        if (this.f632a != null && j()) {
            iaVar.a(f9144j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f632a.size()));
            for (Map.Entry<String, String> entry : this.f632a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f636b != null && k()) {
            iaVar.a(f9145k);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f636b.size()));
            for (Map.Entry<String, String> entry2 : this.f636b.entrySet()) {
                iaVar.a(entry2.getKey());
                iaVar.a(entry2.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (m()) {
            iaVar.a(f9146l);
            iaVar.a(this.f633a);
            iaVar.b();
        }
        if (this.f639c != null && n()) {
            iaVar.a(f9147m);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f639c.size()));
            for (Map.Entry<String, String> entry3 : this.f639c.entrySet()) {
                iaVar.a(entry3.getKey());
                iaVar.a(entry3.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m494a() {
        return this.f632a;
    }

    public gs a(Map<String, String> map) {
        this.f632a = map;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m497a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        boolean zM496a = m496a();
        boolean zM496a2 = gsVar.m496a();
        if (((zM496a || zM496a2) && !(zM496a && zM496a2 && this.f630a.equals(gsVar.f630a))) || this.f629a != gsVar.f629a) {
            return false;
        }
        boolean zM502c = m502c();
        boolean zM502c2 = gsVar.m502c();
        if ((zM502c || zM502c2) && !(zM502c && zM502c2 && this.f635b.equals(gsVar.f635b))) {
            return false;
        }
        boolean zM503d = m503d();
        boolean zM503d2 = gsVar.m503d();
        if ((zM503d || zM503d2) && !(zM503d && zM503d2 && this.f638c.equals(gsVar.f638c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gsVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f640d.equals(gsVar.f640d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gsVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f628a == gsVar.f628a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gsVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f641e.equals(gsVar.f641e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gsVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f634b == gsVar.f634b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gsVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f637c == gsVar.f637c)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gsVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f632a.equals(gsVar.f632a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gsVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f636b.equals(gsVar.f636b))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gsVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f633a == gsVar.f633a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gsVar.n();
        if (zN || zN2) {
            return zN && zN2 && this.f639c.equals(gsVar.f639c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(gs gsVar) {
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
        if (!gs.class.equals(gsVar.getClass())) {
            return gs.class.getName().compareTo(gsVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m496a()).compareTo(Boolean.valueOf(gsVar.m496a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m496a() && (iA13 = hr.a(this.f630a, gsVar.f630a)) != 0) {
            return iA13;
        }
        int iCompareTo2 = Boolean.valueOf(m500b()).compareTo(Boolean.valueOf(gsVar.m500b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m500b() && (iA12 = hr.a(this.f629a, gsVar.f629a)) != 0) {
            return iA12;
        }
        int iCompareTo3 = Boolean.valueOf(m502c()).compareTo(Boolean.valueOf(gsVar.m502c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m502c() && (iA11 = hr.a(this.f635b, gsVar.f635b)) != 0) {
            return iA11;
        }
        int iCompareTo4 = Boolean.valueOf(m503d()).compareTo(Boolean.valueOf(gsVar.m503d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m503d() && (iA10 = hr.a(this.f638c, gsVar.f638c)) != 0) {
            return iA10;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gsVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA9 = hr.a(this.f640d, gsVar.f640d)) != 0) {
            return iA9;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gsVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA8 = hr.a(this.f628a, gsVar.f628a)) != 0) {
            return iA8;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gsVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA7 = hr.a(this.f641e, gsVar.f641e)) != 0) {
            return iA7;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gsVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA6 = hr.a(this.f634b, gsVar.f634b)) != 0) {
            return iA6;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gsVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA5 = hr.a(this.f637c, gsVar.f637c)) != 0) {
            return iA5;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gsVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA4 = hr.a(this.f632a, gsVar.f632a)) != 0) {
            return iA4;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gsVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA3 = hr.a(this.f636b, gsVar.f636b)) != 0) {
            return iA3;
        }
        int iCompareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gsVar.m()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (m() && (iA2 = hr.a(this.f633a, gsVar.f633a)) != 0) {
            return iA2;
        }
        int iCompareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gsVar.n()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (!n() || (iA = hr.a(this.f639c, gsVar.f639c)) == 0) {
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
                if (m500b()) {
                    m495a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f630a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f629a = iaVar.mo600a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f635b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f638c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f640d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f628a = iaVar.mo599a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f641e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f634b = iaVar.mo599a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f637c = iaVar.mo599a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        hz hzVarMo603a = iaVar.mo603a();
                        this.f632a = new HashMap(hzVarMo603a.f900a * 2);
                        while (i2 < hzVarMo603a.f900a) {
                            this.f632a.put(iaVar.mo606a(), iaVar.mo606a());
                            i2++;
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 13) {
                        hz hzVarMo603a2 = iaVar.mo603a();
                        this.f636b = new HashMap(hzVarMo603a2.f900a * 2);
                        while (i2 < hzVarMo603a2.f900a) {
                            this.f636b.put(iaVar.mo606a(), iaVar.mo606a());
                            i2++;
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f633a = iaVar.mo611a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 13) {
                        hz hzVarMo603a3 = iaVar.mo603a();
                        this.f639c = new HashMap(hzVarMo603a3.f900a * 2);
                        while (i2 < hzVarMo603a3.f900a) {
                            this.f639c.put(iaVar.mo606a(), iaVar.mo606a());
                            i2++;
                        }
                        iaVar.h();
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

    /* JADX INFO: renamed from: a */
    public void m495a() throws ib {
        if (this.f630a != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
