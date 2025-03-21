package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gr */
/* loaded from: classes2.dex */
public class C4251gr implements InterfaceC4277hq<C4251gr, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f15805a;

    /* renamed from: a */
    public C4252gs f15806a;

    /* renamed from: a */
    public C4254gu f15807a;

    /* renamed from: a */
    public String f15808a;

    /* renamed from: a */
    private BitSet f15809a = new BitSet(4);

    /* renamed from: a */
    public boolean f15810a = false;

    /* renamed from: b */
    public long f15811b;

    /* renamed from: b */
    public String f15812b;

    /* renamed from: c */
    public long f15813c;

    /* renamed from: c */
    public String f15814c;

    /* renamed from: d */
    public String f15815d;

    /* renamed from: e */
    public String f15816e;

    /* renamed from: f */
    public String f15817f;

    /* renamed from: g */
    public String f15818g;

    /* renamed from: h */
    public String f15819h;

    /* renamed from: i */
    public String f15820i;

    /* renamed from: j */
    public String f15821j;

    /* renamed from: k */
    public String f15822k;

    /* renamed from: l */
    public String f15823l;

    /* renamed from: a */
    private static final C4293if f15787a = new C4293if("PushMessage");

    /* renamed from: a */
    private static final C4284hx f15786a = new C4284hx("", (byte) 12, 1);

    /* renamed from: b */
    private static final C4284hx f15788b = new C4284hx("", (byte) 11, 2);

    /* renamed from: c */
    private static final C4284hx f15789c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f15790d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15791e = new C4284hx("", (byte) 10, 5);

    /* renamed from: f */
    private static final C4284hx f15792f = new C4284hx("", (byte) 10, 6);

    /* renamed from: g */
    private static final C4284hx f15793g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f15794h = new C4284hx("", (byte) 11, 8);

    /* renamed from: i */
    private static final C4284hx f15795i = new C4284hx("", (byte) 11, 9);

    /* renamed from: j */
    private static final C4284hx f15796j = new C4284hx("", (byte) 11, 10);

    /* renamed from: k */
    private static final C4284hx f15797k = new C4284hx("", (byte) 11, 11);

    /* renamed from: l */
    private static final C4284hx f15798l = new C4284hx("", (byte) 12, 12);

    /* renamed from: m */
    private static final C4284hx f15799m = new C4284hx("", (byte) 11, 13);

    /* renamed from: n */
    private static final C4284hx f15800n = new C4284hx("", (byte) 2, 14);

    /* renamed from: o */
    private static final C4284hx f15801o = new C4284hx("", (byte) 11, 15);

    /* renamed from: p */
    private static final C4284hx f15802p = new C4284hx("", (byte) 10, 16);

    /* renamed from: q */
    private static final C4284hx f15803q = new C4284hx("", (byte) 11, 20);

    /* renamed from: r */
    private static final C4284hx f15804r = new C4284hx("", (byte) 11, 21);

    /* renamed from: a */
    public boolean m15065a() {
        return this.f15807a != null;
    }

    /* renamed from: b */
    public boolean m15069b() {
        return this.f15808a != null;
    }

    /* renamed from: c */
    public boolean m15072c() {
        return this.f15812b != null;
    }

    /* renamed from: d */
    public boolean m15074d() {
        return this.f15814c != null;
    }

    /* renamed from: e */
    public boolean m15075e() {
        return this.f15809a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4251gr)) {
            return m15066a((C4251gr) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15076f() {
        return this.f15809a.get(1);
    }

    /* renamed from: g */
    public boolean m15077g() {
        return this.f15815d != null;
    }

    /* renamed from: h */
    public boolean m15078h() {
        return this.f15816e != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15079i() {
        return this.f15817f != null;
    }

    /* renamed from: j */
    public boolean m15080j() {
        return this.f15818g != null;
    }

    /* renamed from: k */
    public boolean m15081k() {
        return this.f15819h != null;
    }

    /* renamed from: l */
    public boolean m15082l() {
        return this.f15806a != null;
    }

    /* renamed from: m */
    public boolean m15083m() {
        return this.f15820i != null;
    }

    /* renamed from: n */
    public boolean m15084n() {
        return this.f15809a.get(2);
    }

    /* renamed from: o */
    public boolean m15085o() {
        return this.f15821j != null;
    }

    /* renamed from: p */
    public boolean m15086p() {
        return this.f15809a.get(3);
    }

    /* renamed from: q */
    public boolean m15087q() {
        return this.f15822k != null;
    }

    /* renamed from: r */
    public boolean m15088r() {
        return this.f15823l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m15065a()) {
            sb.append("to:");
            C4254gu c4254gu = this.f15807a;
            if (c4254gu == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4254gu);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f15808a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f15812b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f15814c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        if (m15075e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f15805a);
        }
        if (m15076f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f15811b);
        }
        if (m15077g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f15815d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15078h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f15816e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15079i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f15817f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15080j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f15818g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15081k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f15819h;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        if (m15082l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            C4252gs c4252gs = this.f15806a;
            if (c4252gs == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4252gs);
            }
        }
        if (m15083m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f15820i;
            if (str9 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str9);
            }
        }
        if (m15084n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f15810a);
        }
        if (m15085o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f15821j;
            if (str10 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str10);
            }
        }
        if (m15086p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f15813c);
        }
        if (m15087q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f15822k;
            if (str11 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str11);
            }
        }
        if (m15088r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f15823l;
            if (str12 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public String m15062a() {
        return this.f15808a;
    }

    /* renamed from: b */
    public String m15067b() {
        return this.f15812b;
    }

    /* renamed from: c */
    public String m15070c() {
        return this.f15814c;
    }

    /* renamed from: d */
    public void m15073d(boolean z) {
        this.f15809a.set(3, z);
    }

    /* renamed from: a */
    public long m15061a() {
        return this.f15805a;
    }

    /* renamed from: b */
    public void m15068b(boolean z) {
        this.f15809a.set(1, z);
    }

    /* renamed from: c */
    public void m15071c(boolean z) {
        this.f15809a.set(2, z);
    }

    /* renamed from: a */
    public void m15064a(boolean z) {
        this.f15809a.set(0, z);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15063a();
        abstractC4288ia.mo15610a(f15787a);
        if (this.f15807a != null && m15065a()) {
            abstractC4288ia.mo15607a(f15786a);
            this.f15807a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15808a != null) {
            abstractC4288ia.mo15607a(f15788b);
            abstractC4288ia.mo15611a(this.f15808a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15812b != null) {
            abstractC4288ia.mo15607a(f15789c);
            abstractC4288ia.mo15611a(this.f15812b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15814c != null) {
            abstractC4288ia.mo15607a(f15790d);
            abstractC4288ia.mo15611a(this.f15814c);
            abstractC4288ia.mo15616b();
        }
        if (m15075e()) {
            abstractC4288ia.mo15607a(f15791e);
            abstractC4288ia.mo15606a(this.f15805a);
            abstractC4288ia.mo15616b();
        }
        if (m15076f()) {
            abstractC4288ia.mo15607a(f15792f);
            abstractC4288ia.mo15606a(this.f15811b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15815d != null && m15077g()) {
            abstractC4288ia.mo15607a(f15793g);
            abstractC4288ia.mo15611a(this.f15815d);
            abstractC4288ia.mo15616b();
        }
        if (this.f15816e != null && m15078h()) {
            abstractC4288ia.mo15607a(f15794h);
            abstractC4288ia.mo15611a(this.f15816e);
            abstractC4288ia.mo15616b();
        }
        if (this.f15817f != null && m15079i()) {
            abstractC4288ia.mo15607a(f15795i);
            abstractC4288ia.mo15611a(this.f15817f);
            abstractC4288ia.mo15616b();
        }
        if (this.f15818g != null && m15080j()) {
            abstractC4288ia.mo15607a(f15796j);
            abstractC4288ia.mo15611a(this.f15818g);
            abstractC4288ia.mo15616b();
        }
        if (this.f15819h != null && m15081k()) {
            abstractC4288ia.mo15607a(f15797k);
            abstractC4288ia.mo15611a(this.f15819h);
            abstractC4288ia.mo15616b();
        }
        if (this.f15806a != null && m15082l()) {
            abstractC4288ia.mo15607a(f15798l);
            this.f15806a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15820i != null && m15083m()) {
            abstractC4288ia.mo15607a(f15799m);
            abstractC4288ia.mo15611a(this.f15820i);
            abstractC4288ia.mo15616b();
        }
        if (m15084n()) {
            abstractC4288ia.mo15607a(f15800n);
            abstractC4288ia.mo15614a(this.f15810a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15821j != null && m15085o()) {
            abstractC4288ia.mo15607a(f15801o);
            abstractC4288ia.mo15611a(this.f15821j);
            abstractC4288ia.mo15616b();
        }
        if (m15086p()) {
            abstractC4288ia.mo15607a(f15802p);
            abstractC4288ia.mo15606a(this.f15813c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15822k != null && m15087q()) {
            abstractC4288ia.mo15607a(f15803q);
            abstractC4288ia.mo15611a(this.f15822k);
            abstractC4288ia.mo15616b();
        }
        if (this.f15823l != null && m15088r()) {
            abstractC4288ia.mo15607a(f15804r);
            abstractC4288ia.mo15611a(this.f15823l);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15066a(C4251gr c4251gr) {
        if (c4251gr == null) {
            return false;
        }
        boolean m15065a = m15065a();
        boolean m15065a2 = c4251gr.m15065a();
        if ((m15065a || m15065a2) && !(m15065a && m15065a2 && this.f15807a.m15138a(c4251gr.f15807a))) {
            return false;
        }
        boolean m15069b = m15069b();
        boolean m15069b2 = c4251gr.m15069b();
        if ((m15069b || m15069b2) && !(m15069b && m15069b2 && this.f15808a.equals(c4251gr.f15808a))) {
            return false;
        }
        boolean m15072c = m15072c();
        boolean m15072c2 = c4251gr.m15072c();
        if ((m15072c || m15072c2) && !(m15072c && m15072c2 && this.f15812b.equals(c4251gr.f15812b))) {
            return false;
        }
        boolean m15074d = m15074d();
        boolean m15074d2 = c4251gr.m15074d();
        if ((m15074d || m15074d2) && !(m15074d && m15074d2 && this.f15814c.equals(c4251gr.f15814c))) {
            return false;
        }
        boolean m15075e = m15075e();
        boolean m15075e2 = c4251gr.m15075e();
        if ((m15075e || m15075e2) && !(m15075e && m15075e2 && this.f15805a == c4251gr.f15805a)) {
            return false;
        }
        boolean m15076f = m15076f();
        boolean m15076f2 = c4251gr.m15076f();
        if ((m15076f || m15076f2) && !(m15076f && m15076f2 && this.f15811b == c4251gr.f15811b)) {
            return false;
        }
        boolean m15077g = m15077g();
        boolean m15077g2 = c4251gr.m15077g();
        if ((m15077g || m15077g2) && !(m15077g && m15077g2 && this.f15815d.equals(c4251gr.f15815d))) {
            return false;
        }
        boolean m15078h = m15078h();
        boolean m15078h2 = c4251gr.m15078h();
        if ((m15078h || m15078h2) && !(m15078h && m15078h2 && this.f15816e.equals(c4251gr.f15816e))) {
            return false;
        }
        boolean m15079i = m15079i();
        boolean m15079i2 = c4251gr.m15079i();
        if ((m15079i || m15079i2) && !(m15079i && m15079i2 && this.f15817f.equals(c4251gr.f15817f))) {
            return false;
        }
        boolean m15080j = m15080j();
        boolean m15080j2 = c4251gr.m15080j();
        if ((m15080j || m15080j2) && !(m15080j && m15080j2 && this.f15818g.equals(c4251gr.f15818g))) {
            return false;
        }
        boolean m15081k = m15081k();
        boolean m15081k2 = c4251gr.m15081k();
        if ((m15081k || m15081k2) && !(m15081k && m15081k2 && this.f15819h.equals(c4251gr.f15819h))) {
            return false;
        }
        boolean m15082l = m15082l();
        boolean m15082l2 = c4251gr.m15082l();
        if ((m15082l || m15082l2) && !(m15082l && m15082l2 && this.f15806a.m15102a(c4251gr.f15806a))) {
            return false;
        }
        boolean m15083m = m15083m();
        boolean m15083m2 = c4251gr.m15083m();
        if ((m15083m || m15083m2) && !(m15083m && m15083m2 && this.f15820i.equals(c4251gr.f15820i))) {
            return false;
        }
        boolean m15084n = m15084n();
        boolean m15084n2 = c4251gr.m15084n();
        if ((m15084n || m15084n2) && !(m15084n && m15084n2 && this.f15810a == c4251gr.f15810a)) {
            return false;
        }
        boolean m15085o = m15085o();
        boolean m15085o2 = c4251gr.m15085o();
        if ((m15085o || m15085o2) && !(m15085o && m15085o2 && this.f15821j.equals(c4251gr.f15821j))) {
            return false;
        }
        boolean m15086p = m15086p();
        boolean m15086p2 = c4251gr.m15086p();
        if ((m15086p || m15086p2) && !(m15086p && m15086p2 && this.f15813c == c4251gr.f15813c)) {
            return false;
        }
        boolean m15087q = m15087q();
        boolean m15087q2 = c4251gr.m15087q();
        if ((m15087q || m15087q2) && !(m15087q && m15087q2 && this.f15822k.equals(c4251gr.f15822k))) {
            return false;
        }
        boolean m15088r = m15088r();
        boolean m15088r2 = c4251gr.m15088r();
        if (m15088r || m15088r2) {
            return m15088r && m15088r2 && this.f15823l.equals(c4251gr.f15823l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4251gr c4251gr) {
        int m15572a;
        int m15572a2;
        int m15570a;
        int m15572a3;
        int m15578a;
        int m15572a4;
        int m15571a;
        int m15572a5;
        int m15572a6;
        int m15572a7;
        int m15572a8;
        int m15572a9;
        int m15570a2;
        int m15570a3;
        int m15572a10;
        int m15572a11;
        int m15572a12;
        int m15571a2;
        if (!C4251gr.class.equals(c4251gr.getClass())) {
            return C4251gr.class.getName().compareTo(c4251gr.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15065a()).compareTo(Boolean.valueOf(c4251gr.m15065a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15065a() && (m15571a2 = C4278hr.m15571a(this.f15807a, c4251gr.f15807a)) != 0) {
            return m15571a2;
        }
        int compareTo2 = Boolean.valueOf(m15069b()).compareTo(Boolean.valueOf(c4251gr.m15069b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15069b() && (m15572a12 = C4278hr.m15572a(this.f15808a, c4251gr.f15808a)) != 0) {
            return m15572a12;
        }
        int compareTo3 = Boolean.valueOf(m15072c()).compareTo(Boolean.valueOf(c4251gr.m15072c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15072c() && (m15572a11 = C4278hr.m15572a(this.f15812b, c4251gr.f15812b)) != 0) {
            return m15572a11;
        }
        int compareTo4 = Boolean.valueOf(m15074d()).compareTo(Boolean.valueOf(c4251gr.m15074d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15074d() && (m15572a10 = C4278hr.m15572a(this.f15814c, c4251gr.f15814c)) != 0) {
            return m15572a10;
        }
        int compareTo5 = Boolean.valueOf(m15075e()).compareTo(Boolean.valueOf(c4251gr.m15075e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15075e() && (m15570a3 = C4278hr.m15570a(this.f15805a, c4251gr.f15805a)) != 0) {
            return m15570a3;
        }
        int compareTo6 = Boolean.valueOf(m15076f()).compareTo(Boolean.valueOf(c4251gr.m15076f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15076f() && (m15570a2 = C4278hr.m15570a(this.f15811b, c4251gr.f15811b)) != 0) {
            return m15570a2;
        }
        int compareTo7 = Boolean.valueOf(m15077g()).compareTo(Boolean.valueOf(c4251gr.m15077g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15077g() && (m15572a9 = C4278hr.m15572a(this.f15815d, c4251gr.f15815d)) != 0) {
            return m15572a9;
        }
        int compareTo8 = Boolean.valueOf(m15078h()).compareTo(Boolean.valueOf(c4251gr.m15078h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15078h() && (m15572a8 = C4278hr.m15572a(this.f15816e, c4251gr.f15816e)) != 0) {
            return m15572a8;
        }
        int compareTo9 = Boolean.valueOf(m15079i()).compareTo(Boolean.valueOf(c4251gr.m15079i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15079i() && (m15572a7 = C4278hr.m15572a(this.f15817f, c4251gr.f15817f)) != 0) {
            return m15572a7;
        }
        int compareTo10 = Boolean.valueOf(m15080j()).compareTo(Boolean.valueOf(c4251gr.m15080j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15080j() && (m15572a6 = C4278hr.m15572a(this.f15818g, c4251gr.f15818g)) != 0) {
            return m15572a6;
        }
        int compareTo11 = Boolean.valueOf(m15081k()).compareTo(Boolean.valueOf(c4251gr.m15081k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15081k() && (m15572a5 = C4278hr.m15572a(this.f15819h, c4251gr.f15819h)) != 0) {
            return m15572a5;
        }
        int compareTo12 = Boolean.valueOf(m15082l()).compareTo(Boolean.valueOf(c4251gr.m15082l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m15082l() && (m15571a = C4278hr.m15571a(this.f15806a, c4251gr.f15806a)) != 0) {
            return m15571a;
        }
        int compareTo13 = Boolean.valueOf(m15083m()).compareTo(Boolean.valueOf(c4251gr.m15083m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m15083m() && (m15572a4 = C4278hr.m15572a(this.f15820i, c4251gr.f15820i)) != 0) {
            return m15572a4;
        }
        int compareTo14 = Boolean.valueOf(m15084n()).compareTo(Boolean.valueOf(c4251gr.m15084n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m15084n() && (m15578a = C4278hr.m15578a(this.f15810a, c4251gr.f15810a)) != 0) {
            return m15578a;
        }
        int compareTo15 = Boolean.valueOf(m15085o()).compareTo(Boolean.valueOf(c4251gr.m15085o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m15085o() && (m15572a3 = C4278hr.m15572a(this.f15821j, c4251gr.f15821j)) != 0) {
            return m15572a3;
        }
        int compareTo16 = Boolean.valueOf(m15086p()).compareTo(Boolean.valueOf(c4251gr.m15086p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m15086p() && (m15570a = C4278hr.m15570a(this.f15813c, c4251gr.f15813c)) != 0) {
            return m15570a;
        }
        int compareTo17 = Boolean.valueOf(m15087q()).compareTo(Boolean.valueOf(c4251gr.m15087q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m15087q() && (m15572a2 = C4278hr.m15572a(this.f15822k, c4251gr.f15822k)) != 0) {
            return m15572a2;
        }
        int compareTo18 = Boolean.valueOf(m15088r()).compareTo(Boolean.valueOf(c4251gr.m15088r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!m15088r() || (m15572a = C4278hr.m15572a(this.f15823l, c4251gr.f15823l)) == 0) {
            return 0;
        }
        return m15572a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: a */
    public void mo14606a(AbstractC4288ia abstractC4288ia) {
        abstractC4288ia.mo15598a();
        while (true) {
            C4284hx mo15594a = abstractC4288ia.mo15594a();
            byte b2 = mo15594a.f16331a;
            if (b2 == 0) {
                abstractC4288ia.mo15622f();
                m15063a();
                return;
            }
            short s = mo15594a.f16333a;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (b2 == 12) {
                                this.f15807a = new C4254gu();
                                this.f15807a.mo14606a(abstractC4288ia);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 2:
                            if (b2 == 11) {
                                this.f15808a = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 3:
                            if (b2 == 11) {
                                this.f15812b = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 4:
                            if (b2 == 11) {
                                this.f15814c = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 5:
                            if (b2 == 10) {
                                this.f15805a = abstractC4288ia.mo15593a();
                                m15064a(true);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 6:
                            if (b2 == 10) {
                                this.f15811b = abstractC4288ia.mo15593a();
                                m15068b(true);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 7:
                            if (b2 == 11) {
                                this.f15815d = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 8:
                            if (b2 == 11) {
                                this.f15816e = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 9:
                            if (b2 == 11) {
                                this.f15817f = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 10:
                            if (b2 == 11) {
                                this.f15818g = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 11:
                            if (b2 == 11) {
                                this.f15819h = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 12:
                            if (b2 == 12) {
                                this.f15806a = new C4252gs();
                                this.f15806a.mo14606a(abstractC4288ia);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 13:
                            if (b2 == 11) {
                                this.f15820i = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 14:
                            if (b2 == 2) {
                                this.f15810a = abstractC4288ia.mo15615a();
                                m15071c(true);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 15:
                            if (b2 == 11) {
                                this.f15821j = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 16:
                            if (b2 == 10) {
                                this.f15813c = abstractC4288ia.mo15593a();
                                m15073d(true);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        default:
                            C4291id.m15660a(abstractC4288ia, b2);
                            break;
                    }
                } else if (b2 == 11) {
                    this.f15823l = abstractC4288ia.mo15599a();
                } else {
                    C4291id.m15660a(abstractC4288ia, b2);
                }
            } else if (b2 == 11) {
                this.f15822k = abstractC4288ia.mo15599a();
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15063a() {
        if (this.f15808a != null) {
            if (this.f15812b != null) {
                if (this.f15814c != null) {
                    return;
                }
                throw new C4289ib("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
