package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hk */
/* loaded from: classes2.dex */
public class C4271hk implements InterfaceC4277hq<C4271hk, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f16216a;

    /* renamed from: a */
    public C4254gu f16217a;

    /* renamed from: a */
    public String f16218a;

    /* renamed from: a */
    private BitSet f16219a = new BitSet(1);

    /* renamed from: b */
    public String f16220b;

    /* renamed from: c */
    public String f16221c;

    /* renamed from: d */
    public String f16222d;

    /* renamed from: e */
    public String f16223e;

    /* renamed from: f */
    public String f16224f;

    /* renamed from: g */
    public String f16225g;

    /* renamed from: a */
    private static final C4293if f16207a = new C4293if("XmPushActionSubscriptionResult");

    /* renamed from: a */
    private static final C4284hx f16206a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16208b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16209c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16210d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16211e = new C4284hx("", (byte) 10, 6);

    /* renamed from: f */
    private static final C4284hx f16212f = new C4284hx("", (byte) 11, 7);

    /* renamed from: g */
    private static final C4284hx f16213g = new C4284hx("", (byte) 11, 8);

    /* renamed from: h */
    private static final C4284hx f16214h = new C4284hx("", (byte) 11, 9);

    /* renamed from: i */
    private static final C4284hx f16215i = new C4284hx("", (byte) 11, 10);

    /* renamed from: a */
    public boolean m15480a() {
        return this.f16218a != null;
    }

    /* renamed from: b */
    public boolean m15483b() {
        return this.f16217a != null;
    }

    /* renamed from: c */
    public boolean m15485c() {
        return this.f16220b != null;
    }

    /* renamed from: d */
    public boolean m15486d() {
        return this.f16221c != null;
    }

    /* renamed from: e */
    public boolean m15487e() {
        return this.f16219a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4271hk)) {
            return m15481a((C4271hk) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15488f() {
        return this.f16222d != null;
    }

    /* renamed from: g */
    public boolean m15489g() {
        return this.f16223e != null;
    }

    /* renamed from: h */
    public boolean m15490h() {
        return this.f16224f != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15491i() {
        return this.f16225g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (m15480a()) {
            sb.append("debug:");
            String str = this.f16218a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15483b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16217a;
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
        String str2 = this.f16220b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        if (m15486d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f16221c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m15487e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f16216a);
        }
        if (m15488f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f16222d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15489g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f16223e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15490h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f16224f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15491i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f16225g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public String m15477a() {
        return this.f16220b;
    }

    /* renamed from: b */
    public String m15482b() {
        return this.f16223e;
    }

    /* renamed from: c */
    public String m15484c() {
        return this.f16225g;
    }

    /* renamed from: a */
    public void m15479a(boolean z) {
        this.f16219a.set(0, z);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15478a();
        abstractC4288ia.mo15610a(f16207a);
        if (this.f16218a != null && m15480a()) {
            abstractC4288ia.mo15607a(f16206a);
            abstractC4288ia.mo15611a(this.f16218a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16217a != null && m15483b()) {
            abstractC4288ia.mo15607a(f16208b);
            this.f16217a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16220b != null) {
            abstractC4288ia.mo15607a(f16209c);
            abstractC4288ia.mo15611a(this.f16220b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16221c != null && m15486d()) {
            abstractC4288ia.mo15607a(f16210d);
            abstractC4288ia.mo15611a(this.f16221c);
            abstractC4288ia.mo15616b();
        }
        if (m15487e()) {
            abstractC4288ia.mo15607a(f16211e);
            abstractC4288ia.mo15606a(this.f16216a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16222d != null && m15488f()) {
            abstractC4288ia.mo15607a(f16212f);
            abstractC4288ia.mo15611a(this.f16222d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16223e != null && m15489g()) {
            abstractC4288ia.mo15607a(f16213g);
            abstractC4288ia.mo15611a(this.f16223e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16224f != null && m15490h()) {
            abstractC4288ia.mo15607a(f16214h);
            abstractC4288ia.mo15611a(this.f16224f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16225g != null && m15491i()) {
            abstractC4288ia.mo15607a(f16215i);
            abstractC4288ia.mo15611a(this.f16225g);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15481a(C4271hk c4271hk) {
        if (c4271hk == null) {
            return false;
        }
        boolean m15480a = m15480a();
        boolean m15480a2 = c4271hk.m15480a();
        if ((m15480a || m15480a2) && !(m15480a && m15480a2 && this.f16218a.equals(c4271hk.f16218a))) {
            return false;
        }
        boolean m15483b = m15483b();
        boolean m15483b2 = c4271hk.m15483b();
        if ((m15483b || m15483b2) && !(m15483b && m15483b2 && this.f16217a.m15138a(c4271hk.f16217a))) {
            return false;
        }
        boolean m15485c = m15485c();
        boolean m15485c2 = c4271hk.m15485c();
        if ((m15485c || m15485c2) && !(m15485c && m15485c2 && this.f16220b.equals(c4271hk.f16220b))) {
            return false;
        }
        boolean m15486d = m15486d();
        boolean m15486d2 = c4271hk.m15486d();
        if ((m15486d || m15486d2) && !(m15486d && m15486d2 && this.f16221c.equals(c4271hk.f16221c))) {
            return false;
        }
        boolean m15487e = m15487e();
        boolean m15487e2 = c4271hk.m15487e();
        if ((m15487e || m15487e2) && !(m15487e && m15487e2 && this.f16216a == c4271hk.f16216a)) {
            return false;
        }
        boolean m15488f = m15488f();
        boolean m15488f2 = c4271hk.m15488f();
        if ((m15488f || m15488f2) && !(m15488f && m15488f2 && this.f16222d.equals(c4271hk.f16222d))) {
            return false;
        }
        boolean m15489g = m15489g();
        boolean m15489g2 = c4271hk.m15489g();
        if ((m15489g || m15489g2) && !(m15489g && m15489g2 && this.f16223e.equals(c4271hk.f16223e))) {
            return false;
        }
        boolean m15490h = m15490h();
        boolean m15490h2 = c4271hk.m15490h();
        if ((m15490h || m15490h2) && !(m15490h && m15490h2 && this.f16224f.equals(c4271hk.f16224f))) {
            return false;
        }
        boolean m15491i = m15491i();
        boolean m15491i2 = c4271hk.m15491i();
        if (m15491i || m15491i2) {
            return m15491i && m15491i2 && this.f16225g.equals(c4271hk.f16225g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4271hk c4271hk) {
        int m15572a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15570a;
        int m15572a5;
        int m15572a6;
        int m15571a;
        int m15572a7;
        if (!C4271hk.class.equals(c4271hk.getClass())) {
            return C4271hk.class.getName().compareTo(c4271hk.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15480a()).compareTo(Boolean.valueOf(c4271hk.m15480a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15480a() && (m15572a7 = C4278hr.m15572a(this.f16218a, c4271hk.f16218a)) != 0) {
            return m15572a7;
        }
        int compareTo2 = Boolean.valueOf(m15483b()).compareTo(Boolean.valueOf(c4271hk.m15483b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15483b() && (m15571a = C4278hr.m15571a(this.f16217a, c4271hk.f16217a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15485c()).compareTo(Boolean.valueOf(c4271hk.m15485c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15485c() && (m15572a6 = C4278hr.m15572a(this.f16220b, c4271hk.f16220b)) != 0) {
            return m15572a6;
        }
        int compareTo4 = Boolean.valueOf(m15486d()).compareTo(Boolean.valueOf(c4271hk.m15486d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15486d() && (m15572a5 = C4278hr.m15572a(this.f16221c, c4271hk.f16221c)) != 0) {
            return m15572a5;
        }
        int compareTo5 = Boolean.valueOf(m15487e()).compareTo(Boolean.valueOf(c4271hk.m15487e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15487e() && (m15570a = C4278hr.m15570a(this.f16216a, c4271hk.f16216a)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15488f()).compareTo(Boolean.valueOf(c4271hk.m15488f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15488f() && (m15572a4 = C4278hr.m15572a(this.f16222d, c4271hk.f16222d)) != 0) {
            return m15572a4;
        }
        int compareTo7 = Boolean.valueOf(m15489g()).compareTo(Boolean.valueOf(c4271hk.m15489g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15489g() && (m15572a3 = C4278hr.m15572a(this.f16223e, c4271hk.f16223e)) != 0) {
            return m15572a3;
        }
        int compareTo8 = Boolean.valueOf(m15490h()).compareTo(Boolean.valueOf(c4271hk.m15490h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15490h() && (m15572a2 = C4278hr.m15572a(this.f16224f, c4271hk.f16224f)) != 0) {
            return m15572a2;
        }
        int compareTo9 = Boolean.valueOf(m15491i()).compareTo(Boolean.valueOf(c4271hk.m15491i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!m15491i() || (m15572a = C4278hr.m15572a(this.f16225g, c4271hk.f16225g)) == 0) {
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
                m15478a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16218a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16217a = new C4254gu();
                        this.f16217a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16220b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16221c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f16216a = abstractC4288ia.mo15593a();
                        m15479a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16222d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16223e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f16224f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f16225g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15478a() {
        if (this.f16220b != null) {
            return;
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
