package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gs implements hq<gs, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f628a;

    /* renamed from: a, reason: collision with other field name */
    public long f629a;

    /* renamed from: a, reason: collision with other field name */
    public String f630a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f631a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f632a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f633a;

    /* renamed from: b, reason: collision with other field name */
    public int f634b;

    /* renamed from: b, reason: collision with other field name */
    public String f635b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f636b;

    /* renamed from: c, reason: collision with other field name */
    public int f637c;

    /* renamed from: c, reason: collision with other field name */
    public String f638c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f639c;

    /* renamed from: d, reason: collision with other field name */
    public String f640d;

    /* renamed from: e, reason: collision with other field name */
    public String f641e;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f627a = new Cif("PushMetaInfo");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13019a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13020b = new hx("", (byte) 10, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13021c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13022d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13023e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13024f = new hx("", (byte) 8, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13025g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13026h = new hx("", (byte) 8, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13027i = new hx("", (byte) 8, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13028j = new hx("", com.umeng.analytics.pro.cw.f10301k, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13029k = new hx("", com.umeng.analytics.pro.cw.f10301k, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13030l = new hx("", (byte) 2, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13031m = new hx("", com.umeng.analytics.pro.cw.f10301k, 13);

    public gs() {
        this.f631a = new BitSet(5);
        this.f633a = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gs m494a() {
        return new gs(this);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m502b() {
        return this.f631a.get(0);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m504c() {
        return this.f635b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m505d() {
        return this.f638c != null;
    }

    public boolean e() {
        return this.f640d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gs)) {
            return m499a((gs) obj);
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
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f629a);
        if (m504c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f635b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        if (m505d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f638c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f640d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
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
                sb.append(c.c.a.b.a.a.f3101h);
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
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f636b;
            if (map2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
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
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m495a() {
        return this.f630a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m500b() {
        return this.f635b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m503c() {
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
        if (gsVar.m498a()) {
            this.f630a = gsVar.f630a;
        }
        this.f629a = gsVar.f629a;
        if (gsVar.m504c()) {
            this.f635b = gsVar.f635b;
        }
        if (gsVar.m505d()) {
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
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : gsVar.f632a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f632a = hashMap;
        }
        if (gsVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : gsVar.f636b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f636b = hashMap2;
        }
        this.f633a = gsVar.f633a;
        if (gsVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : gsVar.f639c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f639c = hashMap3;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m498a() {
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

    /* renamed from: a, reason: collision with other method in class */
    public long m493a() {
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

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m501b() {
        return this.f636b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m497a();
        iaVar.a(f627a);
        if (this.f630a != null) {
            iaVar.a(f13019a);
            iaVar.a(this.f630a);
            iaVar.b();
        }
        iaVar.a(f13020b);
        iaVar.a(this.f629a);
        iaVar.b();
        if (this.f635b != null && m504c()) {
            iaVar.a(f13021c);
            iaVar.a(this.f635b);
            iaVar.b();
        }
        if (this.f638c != null && m505d()) {
            iaVar.a(f13022d);
            iaVar.a(this.f638c);
            iaVar.b();
        }
        if (this.f640d != null && e()) {
            iaVar.a(f13023e);
            iaVar.a(this.f640d);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f13024f);
            iaVar.mo612a(this.f628a);
            iaVar.b();
        }
        if (this.f641e != null && g()) {
            iaVar.a(f13025g);
            iaVar.a(this.f641e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f13026h);
            iaVar.mo612a(this.f634b);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f13027i);
            iaVar.mo612a(this.f637c);
            iaVar.b();
        }
        if (this.f632a != null && j()) {
            iaVar.a(f13028j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f632a.size()));
            for (Map.Entry<String, String> entry : this.f632a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f636b != null && k()) {
            iaVar.a(f13029k);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f636b.size()));
            for (Map.Entry<String, String> entry2 : this.f636b.entrySet()) {
                iaVar.a(entry2.getKey());
                iaVar.a(entry2.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (m()) {
            iaVar.a(f13030l);
            iaVar.a(this.f633a);
            iaVar.b();
        }
        if (this.f639c != null && n()) {
            iaVar.a(f13031m);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f639c.size()));
            for (Map.Entry<String, String> entry3 : this.f639c.entrySet()) {
                iaVar.a(entry3.getKey());
                iaVar.a(entry3.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m496a() {
        return this.f632a;
    }

    public gs a(Map<String, String> map) {
        this.f632a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m499a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        boolean m498a = m498a();
        boolean m498a2 = gsVar.m498a();
        if (((m498a || m498a2) && !(m498a && m498a2 && this.f630a.equals(gsVar.f630a))) || this.f629a != gsVar.f629a) {
            return false;
        }
        boolean m504c = m504c();
        boolean m504c2 = gsVar.m504c();
        if ((m504c || m504c2) && !(m504c && m504c2 && this.f635b.equals(gsVar.f635b))) {
            return false;
        }
        boolean m505d = m505d();
        boolean m505d2 = gsVar.m505d();
        if ((m505d || m505d2) && !(m505d && m505d2 && this.f638c.equals(gsVar.f638c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f640d.equals(gsVar.f640d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f628a == gsVar.f628a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f641e.equals(gsVar.f641e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f634b == gsVar.f634b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f637c == gsVar.f637c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f632a.equals(gsVar.f632a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f636b.equals(gsVar.f636b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f633a == gsVar.f633a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = gsVar.n();
        if (n || n2) {
            return n && n2 && this.f639c.equals(gsVar.f639c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gs gsVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        if (!gs.class.equals(gsVar.getClass())) {
            return gs.class.getName().compareTo(gsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m498a()).compareTo(Boolean.valueOf(gsVar.m498a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m498a() && (a14 = hr.a(this.f630a, gsVar.f630a)) != 0) {
            return a14;
        }
        int compareTo2 = Boolean.valueOf(m502b()).compareTo(Boolean.valueOf(gsVar.m502b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m502b() && (a13 = hr.a(this.f629a, gsVar.f629a)) != 0) {
            return a13;
        }
        int compareTo3 = Boolean.valueOf(m504c()).compareTo(Boolean.valueOf(gsVar.m504c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m504c() && (a12 = hr.a(this.f635b, gsVar.f635b)) != 0) {
            return a12;
        }
        int compareTo4 = Boolean.valueOf(m505d()).compareTo(Boolean.valueOf(gsVar.m505d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m505d() && (a11 = hr.a(this.f638c, gsVar.f638c)) != 0) {
            return a11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gsVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a10 = hr.a(this.f640d, gsVar.f640d)) != 0) {
            return a10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gsVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a9 = hr.a(this.f628a, gsVar.f628a)) != 0) {
            return a9;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gsVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a8 = hr.a(this.f641e, gsVar.f641e)) != 0) {
            return a8;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gsVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a7 = hr.a(this.f634b, gsVar.f634b)) != 0) {
            return a7;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gsVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a6 = hr.a(this.f637c, gsVar.f637c)) != 0) {
            return a6;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gsVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a5 = hr.a(this.f632a, gsVar.f632a)) != 0) {
            return a5;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gsVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a4 = hr.a(this.f636b, gsVar.f636b)) != 0) {
            return a4;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gsVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a3 = hr.a(this.f633a, gsVar.f633a)) != 0) {
            return a3;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gsVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (a2 = hr.a(this.f639c, gsVar.f639c)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo607a();
        while (true) {
            hx mo603a = iaVar.mo603a();
            byte b2 = mo603a.f13224a;
            if (b2 == 0) {
                iaVar.f();
                if (m502b()) {
                    m497a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f630a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 10) {
                        this.f629a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f635b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f638c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f640d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 8) {
                        this.f628a = iaVar.mo601a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f641e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 8) {
                        this.f634b = iaVar.mo601a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f637c = iaVar.mo601a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        hz mo605a = iaVar.mo605a();
                        this.f632a = new HashMap(mo605a.f900a * 2);
                        while (i2 < mo605a.f900a) {
                            this.f632a.put(iaVar.mo608a(), iaVar.mo608a());
                            i2++;
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 13) {
                        hz mo605a2 = iaVar.mo605a();
                        this.f636b = new HashMap(mo605a2.f900a * 2);
                        while (i2 < mo605a2.f900a) {
                            this.f636b.put(iaVar.mo608a(), iaVar.mo608a());
                            i2++;
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 2) {
                        this.f633a = iaVar.mo613a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 13) {
                        hz mo605a3 = iaVar.mo605a();
                        this.f639c = new HashMap(mo605a3.f900a * 2);
                        while (i2 < mo605a3.f900a) {
                            this.f639c.put(iaVar.mo608a(), iaVar.mo608a());
                            i2++;
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                default:
                    id.a(iaVar, b2);
                    break;
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m497a() {
        if (this.f630a != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
