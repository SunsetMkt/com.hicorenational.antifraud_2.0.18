package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hn */
/* loaded from: classes2.dex */
public class C4274hn implements InterfaceC4277hq<C4274hn, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C4254gu f16281a;

    /* renamed from: a */
    public String f16282a;

    /* renamed from: a */
    public List<String> f16283a;

    /* renamed from: b */
    public String f16284b;

    /* renamed from: c */
    public String f16285c;

    /* renamed from: d */
    public String f16286d;

    /* renamed from: e */
    public String f16287e;

    /* renamed from: f */
    public String f16288f;

    /* renamed from: a */
    private static final C4293if f16273a = new C4293if("XmPushActionUnSubscription");

    /* renamed from: a */
    private static final C4284hx f16272a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16274b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16275c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16276d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16277e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f16278f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f16279g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f16280h = new C4284hx("", C3393cw.f11873m, 8);

    /* renamed from: a */
    public boolean m15533a() {
        return this.f16282a != null;
    }

    /* renamed from: b */
    public boolean m15536b() {
        return this.f16281a != null;
    }

    /* renamed from: c */
    public boolean m15538c() {
        return this.f16284b != null;
    }

    /* renamed from: d */
    public boolean m15540d() {
        return this.f16285c != null;
    }

    /* renamed from: e */
    public boolean m15542e() {
        return this.f16286d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4274hn)) {
            return m15534a((C4274hn) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15543f() {
        return this.f16287e != null;
    }

    /* renamed from: g */
    public boolean m15544g() {
        return this.f16288f != null;
    }

    /* renamed from: h */
    public boolean m15545h() {
        return this.f16283a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (m15533a()) {
            sb.append("debug:");
            String str = this.f16282a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15536b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16281a;
            if (c4254gu == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4254gu);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f16284b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16285c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f16286d;
        if (str4 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str4);
        }
        if (m15543f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f16287e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15544g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f16288f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15545h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f16283a;
            if (list == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public C4274hn m15531a(String str) {
        this.f16284b = str;
        return this;
    }

    /* renamed from: b */
    public C4274hn m15535b(String str) {
        this.f16285c = str;
        return this;
    }

    /* renamed from: c */
    public C4274hn m15537c(String str) {
        this.f16286d = str;
        return this;
    }

    /* renamed from: d */
    public C4274hn m15539d(String str) {
        this.f16287e = str;
        return this;
    }

    /* renamed from: e */
    public C4274hn m15541e(String str) {
        this.f16288f = str;
        return this;
    }

    /* renamed from: a */
    public boolean m15534a(C4274hn c4274hn) {
        if (c4274hn == null) {
            return false;
        }
        boolean m15533a = m15533a();
        boolean m15533a2 = c4274hn.m15533a();
        if ((m15533a || m15533a2) && !(m15533a && m15533a2 && this.f16282a.equals(c4274hn.f16282a))) {
            return false;
        }
        boolean m15536b = m15536b();
        boolean m15536b2 = c4274hn.m15536b();
        if ((m15536b || m15536b2) && !(m15536b && m15536b2 && this.f16281a.m15138a(c4274hn.f16281a))) {
            return false;
        }
        boolean m15538c = m15538c();
        boolean m15538c2 = c4274hn.m15538c();
        if ((m15538c || m15538c2) && !(m15538c && m15538c2 && this.f16284b.equals(c4274hn.f16284b))) {
            return false;
        }
        boolean m15540d = m15540d();
        boolean m15540d2 = c4274hn.m15540d();
        if ((m15540d || m15540d2) && !(m15540d && m15540d2 && this.f16285c.equals(c4274hn.f16285c))) {
            return false;
        }
        boolean m15542e = m15542e();
        boolean m15542e2 = c4274hn.m15542e();
        if ((m15542e || m15542e2) && !(m15542e && m15542e2 && this.f16286d.equals(c4274hn.f16286d))) {
            return false;
        }
        boolean m15543f = m15543f();
        boolean m15543f2 = c4274hn.m15543f();
        if ((m15543f || m15543f2) && !(m15543f && m15543f2 && this.f16287e.equals(c4274hn.f16287e))) {
            return false;
        }
        boolean m15544g = m15544g();
        boolean m15544g2 = c4274hn.m15544g();
        if ((m15544g || m15544g2) && !(m15544g && m15544g2 && this.f16288f.equals(c4274hn.f16288f))) {
            return false;
        }
        boolean m15545h = m15545h();
        boolean m15545h2 = c4274hn.m15545h();
        if (m15545h || m15545h2) {
            return m15545h && m15545h2 && this.f16283a.equals(c4274hn.f16283a);
        }
        return true;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15532a();
        abstractC4288ia.mo15610a(f16273a);
        if (this.f16282a != null && m15533a()) {
            abstractC4288ia.mo15607a(f16272a);
            abstractC4288ia.mo15611a(this.f16282a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16281a != null && m15536b()) {
            abstractC4288ia.mo15607a(f16274b);
            this.f16281a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16284b != null) {
            abstractC4288ia.mo15607a(f16275c);
            abstractC4288ia.mo15611a(this.f16284b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16285c != null) {
            abstractC4288ia.mo15607a(f16276d);
            abstractC4288ia.mo15611a(this.f16285c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16286d != null) {
            abstractC4288ia.mo15607a(f16277e);
            abstractC4288ia.mo15611a(this.f16286d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16287e != null && m15543f()) {
            abstractC4288ia.mo15607a(f16278f);
            abstractC4288ia.mo15611a(this.f16287e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16288f != null && m15544g()) {
            abstractC4288ia.mo15607a(f16279g);
            abstractC4288ia.mo15611a(this.f16288f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16283a != null && m15545h()) {
            abstractC4288ia.mo15607a(f16280h);
            abstractC4288ia.mo15608a(new C4285hy((byte) 11, this.f16283a.size()));
            Iterator<String> it = this.f16283a.iterator();
            while (it.hasNext()) {
                abstractC4288ia.mo15611a(it.next());
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4274hn c4274hn) {
        int m15574a;
        int m15572a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15572a5;
        int m15571a;
        int m15572a6;
        if (!C4274hn.class.equals(c4274hn.getClass())) {
            return C4274hn.class.getName().compareTo(c4274hn.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15533a()).compareTo(Boolean.valueOf(c4274hn.m15533a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15533a() && (m15572a6 = C4278hr.m15572a(this.f16282a, c4274hn.f16282a)) != 0) {
            return m15572a6;
        }
        int compareTo2 = Boolean.valueOf(m15536b()).compareTo(Boolean.valueOf(c4274hn.m15536b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15536b() && (m15571a = C4278hr.m15571a(this.f16281a, c4274hn.f16281a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15538c()).compareTo(Boolean.valueOf(c4274hn.m15538c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15538c() && (m15572a5 = C4278hr.m15572a(this.f16284b, c4274hn.f16284b)) != 0) {
            return m15572a5;
        }
        int compareTo4 = Boolean.valueOf(m15540d()).compareTo(Boolean.valueOf(c4274hn.m15540d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15540d() && (m15572a4 = C4278hr.m15572a(this.f16285c, c4274hn.f16285c)) != 0) {
            return m15572a4;
        }
        int compareTo5 = Boolean.valueOf(m15542e()).compareTo(Boolean.valueOf(c4274hn.m15542e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15542e() && (m15572a3 = C4278hr.m15572a(this.f16286d, c4274hn.f16286d)) != 0) {
            return m15572a3;
        }
        int compareTo6 = Boolean.valueOf(m15543f()).compareTo(Boolean.valueOf(c4274hn.m15543f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15543f() && (m15572a2 = C4278hr.m15572a(this.f16287e, c4274hn.f16287e)) != 0) {
            return m15572a2;
        }
        int compareTo7 = Boolean.valueOf(m15544g()).compareTo(Boolean.valueOf(c4274hn.m15544g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15544g() && (m15572a = C4278hr.m15572a(this.f16288f, c4274hn.f16288f)) != 0) {
            return m15572a;
        }
        int compareTo8 = Boolean.valueOf(m15545h()).compareTo(Boolean.valueOf(c4274hn.m15545h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!m15545h() || (m15574a = C4278hr.m15574a(this.f16283a, c4274hn.f16283a)) == 0) {
            return 0;
        }
        return m15574a;
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
                m15532a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16282a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16281a = new C4254gu();
                        this.f16281a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16284b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16285c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16286d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f16287e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16288f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        C4285hy mo15595a = abstractC4288ia.mo15595a();
                        this.f16283a = new ArrayList(mo15595a.f16335a);
                        for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                            this.f16283a.add(abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15625i();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15532a() {
        if (this.f16284b != null) {
            if (this.f16285c != null) {
                if (this.f16286d != null) {
                    return;
                }
                throw new C4289ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
