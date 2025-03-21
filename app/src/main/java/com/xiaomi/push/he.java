package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class he implements hq<he, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f731a;

    /* renamed from: a, reason: collision with other field name */
    public gu f732a;

    /* renamed from: a, reason: collision with other field name */
    public String f733a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f734a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f735a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f736a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f737a;

    /* renamed from: b, reason: collision with other field name */
    public String f738b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f739b;

    /* renamed from: c, reason: collision with other field name */
    public String f740c;

    /* renamed from: d, reason: collision with other field name */
    public String f741d;

    /* renamed from: e, reason: collision with other field name */
    public String f742e;

    /* renamed from: f, reason: collision with other field name */
    public String f743f;

    /* renamed from: g, reason: collision with other field name */
    public String f744g;

    /* renamed from: h, reason: collision with other field name */
    public String f745h;

    /* renamed from: i, reason: collision with other field name */
    public String f746i;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f730a = new Cif("XmPushActionNotification");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13098a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13099b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13100c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13101d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13102e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13103f = new hx("", (byte) 2, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13104g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13105h = new hx("", com.umeng.analytics.pro.cw.f10301k, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13106i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13107j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13108k = new hx("", (byte) 11, 12);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13109l = new hx("", (byte) 11, 13);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13110m = new hx("", (byte) 11, 14);
    private static final hx n = new hx("", (byte) 10, 15);
    private static final hx o = new hx("", (byte) 2, 20);

    public he() {
        this.f735a = new BitSet(3);
        this.f737a = true;
        this.f739b = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m548a() {
        return this.f733a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m551b() {
        return this.f732a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m552c() {
        return this.f738b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m553d() {
        return this.f740c != null;
    }

    public boolean e() {
        return this.f741d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof he)) {
            return m549a((he) obj);
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
        if (m548a()) {
            sb.append("debug:");
            String str = this.f733a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m551b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f732a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
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
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        if (m553d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f740c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f741d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
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
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f736a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f743f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f744g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f745h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f746i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f734a;
            if (byteBuffer == null) {
                sb.append(c.c.a.b.a.a.f3101h);
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

    /* renamed from: a, reason: collision with other method in class */
    public String m544a() {
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
        m547a(true);
    }

    public he a(boolean z) {
        this.f737a = z;
        m547a(true);
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m546a();
        iaVar.a(f730a);
        if (this.f733a != null && m548a()) {
            iaVar.a(f13098a);
            iaVar.a(this.f733a);
            iaVar.b();
        }
        if (this.f732a != null && m551b()) {
            iaVar.a(f13099b);
            this.f732a.b(iaVar);
            iaVar.b();
        }
        if (this.f738b != null) {
            iaVar.a(f13100c);
            iaVar.a(this.f738b);
            iaVar.b();
        }
        if (this.f740c != null && m553d()) {
            iaVar.a(f13101d);
            iaVar.a(this.f740c);
            iaVar.b();
        }
        if (this.f741d != null && e()) {
            iaVar.a(f13102e);
            iaVar.a(this.f741d);
            iaVar.b();
        }
        iaVar.a(f13103f);
        iaVar.a(this.f737a);
        iaVar.b();
        if (this.f742e != null && g()) {
            iaVar.a(f13104g);
            iaVar.a(this.f742e);
            iaVar.b();
        }
        if (this.f736a != null && h()) {
            iaVar.a(f13105h);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f736a.size()));
            for (Map.Entry<String, String> entry : this.f736a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f743f != null && i()) {
            iaVar.a(f13106i);
            iaVar.a(this.f743f);
            iaVar.b();
        }
        if (this.f744g != null && j()) {
            iaVar.a(f13107j);
            iaVar.a(this.f744g);
            iaVar.b();
        }
        if (this.f745h != null && k()) {
            iaVar.a(f13108k);
            iaVar.a(this.f745h);
            iaVar.b();
        }
        if (this.f746i != null && l()) {
            iaVar.a(f13109l);
            iaVar.a(this.f746i);
            iaVar.b();
        }
        if (this.f734a != null && m()) {
            iaVar.a(f13110m);
            iaVar.a(this.f734a);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.a(this.f731a);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.a(this.f739b);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m547a(boolean z) {
        this.f735a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f736a == null) {
            this.f736a = new HashMap();
        }
        this.f736a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m545a() {
        return this.f736a;
    }

    public he a(Map<String, String> map) {
        this.f736a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m550a() {
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

    /* renamed from: a, reason: collision with other method in class */
    public boolean m549a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean m548a = m548a();
        boolean m548a2 = heVar.m548a();
        if ((m548a || m548a2) && !(m548a && m548a2 && this.f733a.equals(heVar.f733a))) {
            return false;
        }
        boolean m551b = m551b();
        boolean m551b2 = heVar.m551b();
        if ((m551b || m551b2) && !(m551b && m551b2 && this.f732a.m507a(heVar.f732a))) {
            return false;
        }
        boolean m552c = m552c();
        boolean m552c2 = heVar.m552c();
        if ((m552c || m552c2) && !(m552c && m552c2 && this.f738b.equals(heVar.f738b))) {
            return false;
        }
        boolean m553d = m553d();
        boolean m553d2 = heVar.m553d();
        if ((m553d || m553d2) && !(m553d && m553d2 && this.f740c.equals(heVar.f740c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = heVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f741d.equals(heVar.f741d))) || this.f737a != heVar.f737a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = heVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f742e.equals(heVar.f742e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = heVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f736a.equals(heVar.f736a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = heVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f743f.equals(heVar.f743f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = heVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f744g.equals(heVar.f744g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = heVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f745h.equals(heVar.f745h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = heVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f746i.equals(heVar.f746i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = heVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f734a.equals(heVar.f734a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = heVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f731a == heVar.f731a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = heVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f739b == heVar.f739b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(he heVar) {
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
        int a15;
        int a16;
        if (!he.class.equals(heVar.getClass())) {
            return he.class.getName().compareTo(heVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m548a()).compareTo(Boolean.valueOf(heVar.m548a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m548a() && (a16 = hr.a(this.f733a, heVar.f733a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(m551b()).compareTo(Boolean.valueOf(heVar.m551b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m551b() && (a15 = hr.a(this.f732a, heVar.f732a)) != 0) {
            return a15;
        }
        int compareTo3 = Boolean.valueOf(m552c()).compareTo(Boolean.valueOf(heVar.m552c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m552c() && (a14 = hr.a(this.f738b, heVar.f738b)) != 0) {
            return a14;
        }
        int compareTo4 = Boolean.valueOf(m553d()).compareTo(Boolean.valueOf(heVar.m553d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m553d() && (a13 = hr.a(this.f740c, heVar.f740c)) != 0) {
            return a13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(heVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a12 = hr.a(this.f741d, heVar.f741d)) != 0) {
            return a12;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(heVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a11 = hr.a(this.f737a, heVar.f737a)) != 0) {
            return a11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(heVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a10 = hr.a(this.f742e, heVar.f742e)) != 0) {
            return a10;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(heVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a9 = hr.a(this.f736a, heVar.f736a)) != 0) {
            return a9;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(heVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a8 = hr.a(this.f743f, heVar.f743f)) != 0) {
            return a8;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(heVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a7 = hr.a(this.f744g, heVar.f744g)) != 0) {
            return a7;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(heVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a6 = hr.a(this.f745h, heVar.f745h)) != 0) {
            return a6;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(heVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a5 = hr.a(this.f746i, heVar.f746i)) != 0) {
            return a5;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(heVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a4 = hr.a(this.f734a, heVar.f734a)) != 0) {
            return a4;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(heVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a3 = hr.a(this.f731a, heVar.f731a)) != 0) {
            return a3;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(heVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!o() || (a2 = hr.a(this.f739b, heVar.f739b)) == 0) {
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
                if (f()) {
                    m546a();
                    return;
                }
                throw new ib("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f733a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f732a = new gu();
                        this.f732a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f738b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f740c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f741d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 2) {
                        this.f737a = iaVar.mo613a();
                        m547a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f742e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 13) {
                        hz mo605a = iaVar.mo605a();
                        this.f736a = new HashMap(mo605a.f900a * 2);
                        for (int i2 = 0; i2 < mo605a.f900a; i2++) {
                            this.f736a.put(iaVar.mo608a(), iaVar.mo608a());
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f743f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f744g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
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
                        this.f745h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f746i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f734a = iaVar.mo609a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 10) {
                        this.f731a = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f739b = iaVar.mo613a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m546a() {
        if (this.f738b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
