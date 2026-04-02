package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gj implements hq<gj, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f570a = new BitSet(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f572a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f573b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f574b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f575c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f576d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f577e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f578f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f579g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f567a = new Cif("ClientUploadDataItem");
    private static final hx a = new hx("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9073b = new hx("", (byte) 11, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9074c = new hx("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hx f9075d = new hx("", (byte) 10, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hx f9076e = new hx("", (byte) 10, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hx f9077f = new hx("", (byte) 2, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hx f9078g = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hx f9079h = new hx("", (byte) 11, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hx f9080i = new hx("", (byte) 11, 9);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hx f9081j = new hx("", com.umeng.analytics.pro.cw.f7203k, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hx f9082k = new hx("", (byte) 11, 11);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m461a() {
        return this.f569a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m463a() {
    }

    public gj b(String str) {
        this.f574b = str;
        return this;
    }

    public gj c(String str) {
        this.f575c = str;
        return this;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m469d() {
        return this.f570a.get(0);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m470e() {
        return this.f570a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gj)) {
            return m466a((gj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f570a.get(2);
    }

    public boolean g() {
        return this.f576d != null;
    }

    public boolean h() {
        return this.f577e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f578f != null;
    }

    public boolean j() {
        return this.f571a != null;
    }

    public boolean k() {
        return this.f579g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (m465a()) {
            sb.append("channel:");
            String str = this.f569a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m467b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f574b;
            if (str2 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m468c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f575c;
            if (str3 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m469d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f568a);
            z = false;
        }
        if (m470e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f573b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f572a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f576d;
            if (str4 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f577e;
            if (str5 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f578f;
            if (str6 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f571a;
            if (map == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(map);
            }
            z = false;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f579g;
            if (str7 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gj a(String str) {
        this.f569a = str;
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m467b() {
        return this.f574b != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m468c() {
        return this.f575c != null;
    }

    public gj d(String str) {
        this.f576d = str;
        return this;
    }

    public gj e(String str) {
        this.f577e = str;
        return this;
    }

    public gj f(String str) {
        this.f578f = str;
        return this;
    }

    public gj g(String str) {
        this.f579g = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m465a() {
        return this.f569a != null;
    }

    public String b() {
        return this.f575c;
    }

    public void c(boolean z) {
        this.f570a.set(2, z);
    }

    public String d() {
        return this.f578f;
    }

    public String e() {
        return this.f579g;
    }

    public gj a(long j2) {
        this.f568a = j2;
        m464a(true);
        return this;
    }

    public gj b(long j2) {
        this.f573b = j2;
        b(true);
        return this;
    }

    public String c() {
        return this.f577e;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m464a(boolean z) {
        this.f570a.set(0, z);
    }

    public void b(boolean z) {
        this.f570a.set(1, z);
    }

    public long a() {
        return this.f573b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m463a();
        iaVar.a(f567a);
        if (this.f569a != null && m465a()) {
            iaVar.a(a);
            iaVar.a(this.f569a);
            iaVar.b();
        }
        if (this.f574b != null && m467b()) {
            iaVar.a(f9073b);
            iaVar.a(this.f574b);
            iaVar.b();
        }
        if (this.f575c != null && m468c()) {
            iaVar.a(f9074c);
            iaVar.a(this.f575c);
            iaVar.b();
        }
        if (m469d()) {
            iaVar.a(f9075d);
            iaVar.a(this.f568a);
            iaVar.b();
        }
        if (m470e()) {
            iaVar.a(f9076e);
            iaVar.a(this.f573b);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f9077f);
            iaVar.a(this.f572a);
            iaVar.b();
        }
        if (this.f576d != null && g()) {
            iaVar.a(f9078g);
            iaVar.a(this.f576d);
            iaVar.b();
        }
        if (this.f577e != null && h()) {
            iaVar.a(f9079h);
            iaVar.a(this.f577e);
            iaVar.b();
        }
        if (this.f578f != null && i()) {
            iaVar.a(f9080i);
            iaVar.a(this.f578f);
            iaVar.b();
        }
        if (this.f571a != null && j()) {
            iaVar.a(f9081j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f571a.size()));
            for (Map.Entry<String, String> entry : this.f571a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f579g != null && k()) {
            iaVar.a(f9082k);
            iaVar.a(this.f579g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    public gj a(boolean z) {
        this.f572a = z;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f571a == null) {
            this.f571a = new HashMap();
        }
        this.f571a.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m462a() {
        return this.f571a;
    }

    public gj a(Map<String, String> map) {
        this.f571a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m466a(gj gjVar) {
        if (gjVar == null) {
            return false;
        }
        boolean zM465a = m465a();
        boolean zM465a2 = gjVar.m465a();
        if ((zM465a || zM465a2) && !(zM465a && zM465a2 && this.f569a.equals(gjVar.f569a))) {
            return false;
        }
        boolean zM467b = m467b();
        boolean zM467b2 = gjVar.m467b();
        if ((zM467b || zM467b2) && !(zM467b && zM467b2 && this.f574b.equals(gjVar.f574b))) {
            return false;
        }
        boolean zM468c = m468c();
        boolean zM468c2 = gjVar.m468c();
        if ((zM468c || zM468c2) && !(zM468c && zM468c2 && this.f575c.equals(gjVar.f575c))) {
            return false;
        }
        boolean zM469d = m469d();
        boolean zM469d2 = gjVar.m469d();
        if ((zM469d || zM469d2) && !(zM469d && zM469d2 && this.f568a == gjVar.f568a)) {
            return false;
        }
        boolean zM470e = m470e();
        boolean zM470e2 = gjVar.m470e();
        if ((zM470e || zM470e2) && !(zM470e && zM470e2 && this.f573b == gjVar.f573b)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gjVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f572a == gjVar.f572a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gjVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f576d.equals(gjVar.f576d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gjVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f577e.equals(gjVar.f577e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gjVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f578f.equals(gjVar.f578f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gjVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f571a.equals(gjVar.f571a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gjVar.k();
        if (zK || zK2) {
            return zK && zK2 && this.f579g.equals(gjVar.f579g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gj gjVar) {
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
        if (!gj.class.equals(gjVar.getClass())) {
            return gj.class.getName().compareTo(gjVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m465a()).compareTo(Boolean.valueOf(gjVar.m465a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m465a() && (iA11 = hr.a(this.f569a, gjVar.f569a)) != 0) {
            return iA11;
        }
        int iCompareTo2 = Boolean.valueOf(m467b()).compareTo(Boolean.valueOf(gjVar.m467b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m467b() && (iA10 = hr.a(this.f574b, gjVar.f574b)) != 0) {
            return iA10;
        }
        int iCompareTo3 = Boolean.valueOf(m468c()).compareTo(Boolean.valueOf(gjVar.m468c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m468c() && (iA9 = hr.a(this.f575c, gjVar.f575c)) != 0) {
            return iA9;
        }
        int iCompareTo4 = Boolean.valueOf(m469d()).compareTo(Boolean.valueOf(gjVar.m469d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m469d() && (iA8 = hr.a(this.f568a, gjVar.f568a)) != 0) {
            return iA8;
        }
        int iCompareTo5 = Boolean.valueOf(m470e()).compareTo(Boolean.valueOf(gjVar.m470e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m470e() && (iA7 = hr.a(this.f573b, gjVar.f573b)) != 0) {
            return iA7;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gjVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA6 = hr.a(this.f572a, gjVar.f572a)) != 0) {
            return iA6;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gjVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA5 = hr.a(this.f576d, gjVar.f576d)) != 0) {
            return iA5;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gjVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA4 = hr.a(this.f577e, gjVar.f577e)) != 0) {
            return iA4;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gjVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA3 = hr.a(this.f578f, gjVar.f578f)) != 0) {
            return iA3;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gjVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA2 = hr.a(this.f571a, gjVar.f571a)) != 0) {
            return iA2;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gjVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (!k() || (iA = hr.a(this.f579g, gjVar.f579g)) == 0) {
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
                m463a();
                return;
            }
            switch (hxVarMo601a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f569a = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f574b = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f575c = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f568a = iaVar.mo600a();
                        m464a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f573b = iaVar.mo600a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f572a = iaVar.mo611a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f576d = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f577e = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f578f = iaVar.mo606a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        hz hzVarMo603a = iaVar.mo603a();
                        this.f571a = new HashMap(hzVarMo603a.f900a * 2);
                        for (int i2 = 0; i2 < hzVarMo603a.f900a; i2++) {
                            this.f571a.put(iaVar.mo606a(), iaVar.mo606a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f579g = iaVar.mo606a();
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
