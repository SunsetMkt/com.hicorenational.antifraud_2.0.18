package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gv implements hq<gv, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f653a;

    /* renamed from: a, reason: collision with other field name */
    public long f654a;

    /* renamed from: a, reason: collision with other field name */
    public gu f655a;

    /* renamed from: a, reason: collision with other field name */
    public hi f656a;

    /* renamed from: a, reason: collision with other field name */
    public String f657a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f659a;

    /* renamed from: a, reason: collision with other field name */
    public short f660a;

    /* renamed from: b, reason: collision with other field name */
    public String f662b;

    /* renamed from: b, reason: collision with other field name */
    public short f663b;

    /* renamed from: c, reason: collision with other field name */
    public String f664c;

    /* renamed from: d, reason: collision with other field name */
    public String f665d;

    /* renamed from: e, reason: collision with other field name */
    public String f666e;

    /* renamed from: f, reason: collision with other field name */
    public String f667f;

    /* renamed from: g, reason: collision with other field name */
    public String f668g;

    /* renamed from: h, reason: collision with other field name */
    public String f669h;

    /* renamed from: i, reason: collision with other field name */
    public String f670i;

    /* renamed from: j, reason: collision with other field name */
    public String f671j;

    /* renamed from: k, reason: collision with other field name */
    public String f672k;

    /* renamed from: l, reason: collision with other field name */
    public String f673l;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f652a = new Cif("XmPushActionAckMessage");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13041a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13042b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13043c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13044d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13045e = new hx("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13046f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13047g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13048h = new hx("", (byte) 12, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13049i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13050j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13051k = new hx("", (byte) 2, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13052l = new hx("", (byte) 11, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13053m = new hx("", (byte) 11, 13);
    private static final hx n = new hx("", (byte) 11, 14);
    private static final hx o = new hx("", (byte) 6, 15);
    private static final hx p = new hx("", (byte) 6, 16);
    private static final hx q = new hx("", (byte) 11, 20);
    private static final hx r = new hx("", (byte) 11, 21);
    private static final hx s = new hx("", (byte) 8, 22);
    private static final hx t = new hx("", com.umeng.analytics.pro.cw.f10301k, 23);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f658a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f661a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m508a() {
        return this.f657a != null;
    }

    public boolean b() {
        return this.f655a != null;
    }

    public boolean c() {
        return this.f662b != null;
    }

    public boolean d() {
        return this.f664c != null;
    }

    public boolean e() {
        return this.f658a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gv)) {
            return m509a((gv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f665d != null;
    }

    public boolean g() {
        return this.f666e != null;
    }

    public boolean h() {
        return this.f656a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f667f != null;
    }

    public boolean j() {
        return this.f668g != null;
    }

    public boolean k() {
        return this.f658a.get(1);
    }

    public boolean l() {
        return this.f669h != null;
    }

    public boolean m() {
        return this.f670i != null;
    }

    public boolean n() {
        return this.f671j != null;
    }

    public boolean o() {
        return this.f658a.get(2);
    }

    public boolean p() {
        return this.f658a.get(3);
    }

    public boolean q() {
        return this.f672k != null;
    }

    public boolean r() {
        return this.f673l != null;
    }

    public boolean s() {
        return this.f658a.get(4);
    }

    public boolean t() {
        return this.f659a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (m508a()) {
            sb.append("debug:");
            String str = this.f657a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
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
            gu guVar = this.f655a;
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
        String str2 = this.f662b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f664c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f654a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f665d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f666e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hi hiVar = this.f656a;
            if (hiVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(hiVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f667f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f668g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f661a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f669h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f670i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f671j;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f660a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f663b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f672k;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f673l;
            if (str12 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f653a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f659a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gv a(String str) {
        this.f662b = str;
        return this;
    }

    public gv b(String str) {
        this.f664c = str;
        return this;
    }

    public gv c(String str) {
        this.f665d = str;
        return this;
    }

    public gv d(String str) {
        this.f666e = str;
        return this;
    }

    public void e(boolean z) {
        this.f658a.set(4, z);
    }

    public gv a(long j2) {
        this.f654a = j2;
        a(true);
        return this;
    }

    public void b(boolean z) {
        this.f658a.set(1, z);
    }

    public void c(boolean z) {
        this.f658a.set(2, z);
    }

    public void d(boolean z) {
        this.f658a.set(3, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f652a);
        if (this.f657a != null && m508a()) {
            iaVar.a(f13041a);
            iaVar.a(this.f657a);
            iaVar.b();
        }
        if (this.f655a != null && b()) {
            iaVar.a(f13042b);
            this.f655a.b(iaVar);
            iaVar.b();
        }
        if (this.f662b != null) {
            iaVar.a(f13043c);
            iaVar.a(this.f662b);
            iaVar.b();
        }
        if (this.f664c != null) {
            iaVar.a(f13044d);
            iaVar.a(this.f664c);
            iaVar.b();
        }
        iaVar.a(f13045e);
        iaVar.a(this.f654a);
        iaVar.b();
        if (this.f665d != null && f()) {
            iaVar.a(f13046f);
            iaVar.a(this.f665d);
            iaVar.b();
        }
        if (this.f666e != null && g()) {
            iaVar.a(f13047g);
            iaVar.a(this.f666e);
            iaVar.b();
        }
        if (this.f656a != null && h()) {
            iaVar.a(f13048h);
            this.f656a.b(iaVar);
            iaVar.b();
        }
        if (this.f667f != null && i()) {
            iaVar.a(f13049i);
            iaVar.a(this.f667f);
            iaVar.b();
        }
        if (this.f668g != null && j()) {
            iaVar.a(f13050j);
            iaVar.a(this.f668g);
            iaVar.b();
        }
        if (k()) {
            iaVar.a(f13051k);
            iaVar.a(this.f661a);
            iaVar.b();
        }
        if (this.f669h != null && l()) {
            iaVar.a(f13052l);
            iaVar.a(this.f669h);
            iaVar.b();
        }
        if (this.f670i != null && m()) {
            iaVar.a(f13053m);
            iaVar.a(this.f670i);
            iaVar.b();
        }
        if (this.f671j != null && n()) {
            iaVar.a(n);
            iaVar.a(this.f671j);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.a(this.f660a);
            iaVar.b();
        }
        if (p()) {
            iaVar.a(p);
            iaVar.a(this.f663b);
            iaVar.b();
        }
        if (this.f672k != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f672k);
            iaVar.b();
        }
        if (this.f673l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f673l);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.mo612a(this.f653a);
            iaVar.b();
        }
        if (this.f659a != null && t()) {
            iaVar.a(t);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f659a.size()));
            for (Map.Entry<String, String> entry : this.f659a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public void a(boolean z) {
        this.f658a.set(0, z);
    }

    public gv a(short s2) {
        this.f660a = s2;
        c(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m509a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        boolean m508a = m508a();
        boolean m508a2 = gvVar.m508a();
        if ((m508a || m508a2) && !(m508a && m508a2 && this.f657a.equals(gvVar.f657a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gvVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f655a.m507a(gvVar.f655a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gvVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f662b.equals(gvVar.f662b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gvVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f664c.equals(gvVar.f664c))) || this.f654a != gvVar.f654a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gvVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f665d.equals(gvVar.f665d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gvVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f666e.equals(gvVar.f666e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gvVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f656a.m571a(gvVar.f656a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gvVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f667f.equals(gvVar.f667f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gvVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f668g.equals(gvVar.f668g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gvVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f661a == gvVar.f661a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = gvVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f669h.equals(gvVar.f669h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gvVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f670i.equals(gvVar.f670i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = gvVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f671j.equals(gvVar.f671j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = gvVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f660a == gvVar.f660a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = gvVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f663b == gvVar.f663b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = gvVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f672k.equals(gvVar.f672k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = gvVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f673l.equals(gvVar.f673l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = gvVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f653a == gvVar.f653a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = gvVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f659a.equals(gvVar.f659a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gv gvVar) {
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
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        if (!gv.class.equals(gvVar.getClass())) {
            return gv.class.getName().compareTo(gvVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m508a()).compareTo(Boolean.valueOf(gvVar.m508a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m508a() && (a21 = hr.a(this.f657a, gvVar.f657a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gvVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a20 = hr.a(this.f655a, gvVar.f655a)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a19 = hr.a(this.f662b, gvVar.f662b)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = hr.a(this.f664c, gvVar.f664c)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = hr.a(this.f654a, gvVar.f654a)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = hr.a(this.f665d, gvVar.f665d)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gvVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = hr.a(this.f666e, gvVar.f666e)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gvVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = hr.a(this.f656a, gvVar.f656a)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gvVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = hr.a(this.f667f, gvVar.f667f)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gvVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = hr.a(this.f668g, gvVar.f668g)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gvVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = hr.a(this.f661a, gvVar.f661a)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gvVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = hr.a(this.f669h, gvVar.f669h)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gvVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = hr.a(this.f670i, gvVar.f670i)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gvVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = hr.a(this.f671j, gvVar.f671j)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gvVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = hr.a(this.f660a, gvVar.f660a)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gvVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = hr.a(this.f663b, gvVar.f663b)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gvVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = hr.a(this.f672k, gvVar.f672k)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gvVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = hr.a(this.f673l, gvVar.f673l)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gvVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = hr.a(this.f653a, gvVar.f653a)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gvVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a2 = hr.a(this.f659a, gvVar.f659a)) == 0) {
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
                if (e()) {
                    a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f657a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f655a = new gu();
                        this.f655a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f662b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f664c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f654a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f665d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f666e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f656a = new hi();
                        this.f656a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f667f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f668g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f661a = iaVar.mo613a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f669h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f670i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f671j = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 6) {
                        this.f660a = iaVar.mo610a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 6) {
                        this.f663b = iaVar.mo610a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    id.a(iaVar, b2);
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f672k = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 11) {
                        this.f673l = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 8) {
                        this.f653a = iaVar.mo601a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 13) {
                        hz mo605a = iaVar.mo605a();
                        this.f659a = new HashMap(mo605a.f900a * 2);
                        for (int i2 = 0; i2 < mo605a.f900a; i2++) {
                            this.f659a.put(iaVar.mo608a(), iaVar.mo608a());
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
            }
            iaVar.g();
        }
    }

    public void a() {
        if (this.f662b != null) {
            if (this.f664c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
