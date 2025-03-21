package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hl */
/* loaded from: classes2.dex */
public class C4272hl implements InterfaceC4277hq<C4272hl, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f16239a;

    /* renamed from: a */
    public C4254gu f16240a;

    /* renamed from: a */
    public String f16241a;

    /* renamed from: a */
    private BitSet f16242a = new BitSet(2);

    /* renamed from: a */
    public boolean f16243a = true;

    /* renamed from: b */
    public String f16244b;

    /* renamed from: c */
    public String f16245c;

    /* renamed from: d */
    public String f16246d;

    /* renamed from: e */
    public String f16247e;

    /* renamed from: f */
    public String f16248f;

    /* renamed from: g */
    public String f16249g;

    /* renamed from: h */
    public String f16250h;

    /* renamed from: i */
    public String f16251i;

    /* renamed from: a */
    private static final C4293if f16227a = new C4293if("XmPushActionUnRegistration");

    /* renamed from: a */
    private static final C4284hx f16226a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16228b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16229c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16230d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16231e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f16232f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f16233g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f16234h = new C4284hx("", (byte) 11, 8);

    /* renamed from: i */
    private static final C4284hx f16235i = new C4284hx("", (byte) 11, 9);

    /* renamed from: j */
    private static final C4284hx f16236j = new C4284hx("", (byte) 11, 10);

    /* renamed from: k */
    private static final C4284hx f16237k = new C4284hx("", (byte) 2, 11);

    /* renamed from: l */
    private static final C4284hx f16238l = new C4284hx("", (byte) 10, 12);

    /* renamed from: a */
    public boolean m15496a() {
        return this.f16241a != null;
    }

    /* renamed from: b */
    public boolean m15500b() {
        return this.f16240a != null;
    }

    /* renamed from: c */
    public boolean m15502c() {
        return this.f16244b != null;
    }

    /* renamed from: d */
    public boolean m15504d() {
        return this.f16245c != null;
    }

    /* renamed from: e */
    public boolean m15506e() {
        return this.f16246d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4272hl)) {
            return m15497a((C4272hl) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15507f() {
        return this.f16247e != null;
    }

    /* renamed from: g */
    public boolean m15508g() {
        return this.f16248f != null;
    }

    /* renamed from: h */
    public boolean m15509h() {
        return this.f16249g != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15510i() {
        return this.f16250h != null;
    }

    /* renamed from: j */
    public boolean m15511j() {
        return this.f16251i != null;
    }

    /* renamed from: k */
    public boolean m15512k() {
        return this.f16242a.get(0);
    }

    /* renamed from: l */
    public boolean m15513l() {
        return this.f16242a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        if (m15496a()) {
            sb.append("debug:");
            String str = this.f16241a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15500b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16240a;
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
        String str2 = this.f16244b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16245c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        if (m15506e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f16246d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15507f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f16247e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15508g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f16248f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15509h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f16249g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15510i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f16250h;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        if (m15511j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f16251i;
            if (str9 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str9);
            }
        }
        if (m15512k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f16243a);
        }
        if (m15513l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f16239a);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public C4272hl m15493a(String str) {
        this.f16244b = str;
        return this;
    }

    /* renamed from: b */
    public C4272hl m15498b(String str) {
        this.f16245c = str;
        return this;
    }

    /* renamed from: c */
    public C4272hl m15501c(String str) {
        this.f16246d = str;
        return this;
    }

    /* renamed from: d */
    public C4272hl m15503d(String str) {
        this.f16248f = str;
        return this;
    }

    /* renamed from: e */
    public C4272hl m15505e(String str) {
        this.f16249g = str;
        return this;
    }

    /* renamed from: a */
    public void m15495a(boolean z) {
        this.f16242a.set(0, z);
    }

    /* renamed from: b */
    public void m15499b(boolean z) {
        this.f16242a.set(1, z);
    }

    /* renamed from: a */
    public boolean m15497a(C4272hl c4272hl) {
        if (c4272hl == null) {
            return false;
        }
        boolean m15496a = m15496a();
        boolean m15496a2 = c4272hl.m15496a();
        if ((m15496a || m15496a2) && !(m15496a && m15496a2 && this.f16241a.equals(c4272hl.f16241a))) {
            return false;
        }
        boolean m15500b = m15500b();
        boolean m15500b2 = c4272hl.m15500b();
        if ((m15500b || m15500b2) && !(m15500b && m15500b2 && this.f16240a.m15138a(c4272hl.f16240a))) {
            return false;
        }
        boolean m15502c = m15502c();
        boolean m15502c2 = c4272hl.m15502c();
        if ((m15502c || m15502c2) && !(m15502c && m15502c2 && this.f16244b.equals(c4272hl.f16244b))) {
            return false;
        }
        boolean m15504d = m15504d();
        boolean m15504d2 = c4272hl.m15504d();
        if ((m15504d || m15504d2) && !(m15504d && m15504d2 && this.f16245c.equals(c4272hl.f16245c))) {
            return false;
        }
        boolean m15506e = m15506e();
        boolean m15506e2 = c4272hl.m15506e();
        if ((m15506e || m15506e2) && !(m15506e && m15506e2 && this.f16246d.equals(c4272hl.f16246d))) {
            return false;
        }
        boolean m15507f = m15507f();
        boolean m15507f2 = c4272hl.m15507f();
        if ((m15507f || m15507f2) && !(m15507f && m15507f2 && this.f16247e.equals(c4272hl.f16247e))) {
            return false;
        }
        boolean m15508g = m15508g();
        boolean m15508g2 = c4272hl.m15508g();
        if ((m15508g || m15508g2) && !(m15508g && m15508g2 && this.f16248f.equals(c4272hl.f16248f))) {
            return false;
        }
        boolean m15509h = m15509h();
        boolean m15509h2 = c4272hl.m15509h();
        if ((m15509h || m15509h2) && !(m15509h && m15509h2 && this.f16249g.equals(c4272hl.f16249g))) {
            return false;
        }
        boolean m15510i = m15510i();
        boolean m15510i2 = c4272hl.m15510i();
        if ((m15510i || m15510i2) && !(m15510i && m15510i2 && this.f16250h.equals(c4272hl.f16250h))) {
            return false;
        }
        boolean m15511j = m15511j();
        boolean m15511j2 = c4272hl.m15511j();
        if ((m15511j || m15511j2) && !(m15511j && m15511j2 && this.f16251i.equals(c4272hl.f16251i))) {
            return false;
        }
        boolean m15512k = m15512k();
        boolean m15512k2 = c4272hl.m15512k();
        if ((m15512k || m15512k2) && !(m15512k && m15512k2 && this.f16243a == c4272hl.f16243a)) {
            return false;
        }
        boolean m15513l = m15513l();
        boolean m15513l2 = c4272hl.m15513l();
        if (m15513l || m15513l2) {
            return m15513l && m15513l2 && this.f16239a == c4272hl.f16239a;
        }
        return true;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15494a();
        abstractC4288ia.mo15610a(f16227a);
        if (this.f16241a != null && m15496a()) {
            abstractC4288ia.mo15607a(f16226a);
            abstractC4288ia.mo15611a(this.f16241a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16240a != null && m15500b()) {
            abstractC4288ia.mo15607a(f16228b);
            this.f16240a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16244b != null) {
            abstractC4288ia.mo15607a(f16229c);
            abstractC4288ia.mo15611a(this.f16244b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16245c != null) {
            abstractC4288ia.mo15607a(f16230d);
            abstractC4288ia.mo15611a(this.f16245c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16246d != null && m15506e()) {
            abstractC4288ia.mo15607a(f16231e);
            abstractC4288ia.mo15611a(this.f16246d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16247e != null && m15507f()) {
            abstractC4288ia.mo15607a(f16232f);
            abstractC4288ia.mo15611a(this.f16247e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16248f != null && m15508g()) {
            abstractC4288ia.mo15607a(f16233g);
            abstractC4288ia.mo15611a(this.f16248f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16249g != null && m15509h()) {
            abstractC4288ia.mo15607a(f16234h);
            abstractC4288ia.mo15611a(this.f16249g);
            abstractC4288ia.mo15616b();
        }
        if (this.f16250h != null && m15510i()) {
            abstractC4288ia.mo15607a(f16235i);
            abstractC4288ia.mo15611a(this.f16250h);
            abstractC4288ia.mo15616b();
        }
        if (this.f16251i != null && m15511j()) {
            abstractC4288ia.mo15607a(f16236j);
            abstractC4288ia.mo15611a(this.f16251i);
            abstractC4288ia.mo15616b();
        }
        if (m15512k()) {
            abstractC4288ia.mo15607a(f16237k);
            abstractC4288ia.mo15614a(this.f16243a);
            abstractC4288ia.mo15616b();
        }
        if (m15513l()) {
            abstractC4288ia.mo15607a(f16238l);
            abstractC4288ia.mo15606a(this.f16239a);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4272hl c4272hl) {
        int m15570a;
        int m15578a;
        int m15572a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15572a5;
        int m15572a6;
        int m15572a7;
        int m15572a8;
        int m15571a;
        int m15572a9;
        if (!C4272hl.class.equals(c4272hl.getClass())) {
            return C4272hl.class.getName().compareTo(c4272hl.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15496a()).compareTo(Boolean.valueOf(c4272hl.m15496a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15496a() && (m15572a9 = C4278hr.m15572a(this.f16241a, c4272hl.f16241a)) != 0) {
            return m15572a9;
        }
        int compareTo2 = Boolean.valueOf(m15500b()).compareTo(Boolean.valueOf(c4272hl.m15500b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15500b() && (m15571a = C4278hr.m15571a(this.f16240a, c4272hl.f16240a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15502c()).compareTo(Boolean.valueOf(c4272hl.m15502c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15502c() && (m15572a8 = C4278hr.m15572a(this.f16244b, c4272hl.f16244b)) != 0) {
            return m15572a8;
        }
        int compareTo4 = Boolean.valueOf(m15504d()).compareTo(Boolean.valueOf(c4272hl.m15504d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15504d() && (m15572a7 = C4278hr.m15572a(this.f16245c, c4272hl.f16245c)) != 0) {
            return m15572a7;
        }
        int compareTo5 = Boolean.valueOf(m15506e()).compareTo(Boolean.valueOf(c4272hl.m15506e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15506e() && (m15572a6 = C4278hr.m15572a(this.f16246d, c4272hl.f16246d)) != 0) {
            return m15572a6;
        }
        int compareTo6 = Boolean.valueOf(m15507f()).compareTo(Boolean.valueOf(c4272hl.m15507f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15507f() && (m15572a5 = C4278hr.m15572a(this.f16247e, c4272hl.f16247e)) != 0) {
            return m15572a5;
        }
        int compareTo7 = Boolean.valueOf(m15508g()).compareTo(Boolean.valueOf(c4272hl.m15508g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15508g() && (m15572a4 = C4278hr.m15572a(this.f16248f, c4272hl.f16248f)) != 0) {
            return m15572a4;
        }
        int compareTo8 = Boolean.valueOf(m15509h()).compareTo(Boolean.valueOf(c4272hl.m15509h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15509h() && (m15572a3 = C4278hr.m15572a(this.f16249g, c4272hl.f16249g)) != 0) {
            return m15572a3;
        }
        int compareTo9 = Boolean.valueOf(m15510i()).compareTo(Boolean.valueOf(c4272hl.m15510i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15510i() && (m15572a2 = C4278hr.m15572a(this.f16250h, c4272hl.f16250h)) != 0) {
            return m15572a2;
        }
        int compareTo10 = Boolean.valueOf(m15511j()).compareTo(Boolean.valueOf(c4272hl.m15511j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15511j() && (m15572a = C4278hr.m15572a(this.f16251i, c4272hl.f16251i)) != 0) {
            return m15572a;
        }
        int compareTo11 = Boolean.valueOf(m15512k()).compareTo(Boolean.valueOf(c4272hl.m15512k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15512k() && (m15578a = C4278hr.m15578a(this.f16243a, c4272hl.f16243a)) != 0) {
            return m15578a;
        }
        int compareTo12 = Boolean.valueOf(m15513l()).compareTo(Boolean.valueOf(c4272hl.m15513l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!m15513l() || (m15570a = C4278hr.m15570a(this.f16239a, c4272hl.f16239a)) == 0) {
            return 0;
        }
        return m15570a;
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
                m15494a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16241a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16240a = new C4254gu();
                        this.f16240a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16244b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16245c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16246d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f16247e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16248f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16249g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f16250h = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f16251i = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f16243a = abstractC4288ia.mo15615a();
                        m15495a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f16239a = abstractC4288ia.mo15593a();
                        m15499b(true);
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
    public void m15494a() {
        if (this.f16244b != null) {
            if (this.f16245c != null) {
                return;
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
