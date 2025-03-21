package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.ho */
/* loaded from: classes2.dex */
public class C4275ho implements InterfaceC4277hq<C4275ho, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f16299a;

    /* renamed from: a */
    public C4254gu f16300a;

    /* renamed from: a */
    public String f16301a;

    /* renamed from: a */
    private BitSet f16302a = new BitSet(1);

    /* renamed from: b */
    public String f16303b;

    /* renamed from: c */
    public String f16304c;

    /* renamed from: d */
    public String f16305d;

    /* renamed from: e */
    public String f16306e;

    /* renamed from: f */
    public String f16307f;

    /* renamed from: g */
    public String f16308g;

    /* renamed from: a */
    private static final C4293if f16290a = new C4293if("XmPushActionUnSubscriptionResult");

    /* renamed from: a */
    private static final C4284hx f16289a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16291b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16292c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16293d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16294e = new C4284hx("", (byte) 10, 6);

    /* renamed from: f */
    private static final C4284hx f16295f = new C4284hx("", (byte) 11, 7);

    /* renamed from: g */
    private static final C4284hx f16296g = new C4284hx("", (byte) 11, 8);

    /* renamed from: h */
    private static final C4284hx f16297h = new C4284hx("", (byte) 11, 9);

    /* renamed from: i */
    private static final C4284hx f16298i = new C4284hx("", (byte) 11, 10);

    /* renamed from: a */
    public boolean m15550a() {
        return this.f16301a != null;
    }

    /* renamed from: b */
    public boolean m15553b() {
        return this.f16300a != null;
    }

    /* renamed from: c */
    public boolean m15555c() {
        return this.f16303b != null;
    }

    /* renamed from: d */
    public boolean m15556d() {
        return this.f16304c != null;
    }

    /* renamed from: e */
    public boolean m15557e() {
        return this.f16302a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4275ho)) {
            return m15551a((C4275ho) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15558f() {
        return this.f16305d != null;
    }

    /* renamed from: g */
    public boolean m15559g() {
        return this.f16306e != null;
    }

    /* renamed from: h */
    public boolean m15560h() {
        return this.f16307f != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15561i() {
        return this.f16308g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        if (m15550a()) {
            sb.append("debug:");
            String str = this.f16301a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15553b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16300a;
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
        String str2 = this.f16303b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        if (m15556d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f16304c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m15557e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f16299a);
        }
        if (m15558f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f16305d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15559g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f16306e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15560h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f16307f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15561i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f16308g;
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
    public String m15547a() {
        return this.f16303b;
    }

    /* renamed from: b */
    public String m15552b() {
        return this.f16306e;
    }

    /* renamed from: c */
    public String m15554c() {
        return this.f16308g;
    }

    /* renamed from: a */
    public void m15549a(boolean z) {
        this.f16302a.set(0, z);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15548a();
        abstractC4288ia.mo15610a(f16290a);
        if (this.f16301a != null && m15550a()) {
            abstractC4288ia.mo15607a(f16289a);
            abstractC4288ia.mo15611a(this.f16301a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16300a != null && m15553b()) {
            abstractC4288ia.mo15607a(f16291b);
            this.f16300a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16303b != null) {
            abstractC4288ia.mo15607a(f16292c);
            abstractC4288ia.mo15611a(this.f16303b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16304c != null && m15556d()) {
            abstractC4288ia.mo15607a(f16293d);
            abstractC4288ia.mo15611a(this.f16304c);
            abstractC4288ia.mo15616b();
        }
        if (m15557e()) {
            abstractC4288ia.mo15607a(f16294e);
            abstractC4288ia.mo15606a(this.f16299a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16305d != null && m15558f()) {
            abstractC4288ia.mo15607a(f16295f);
            abstractC4288ia.mo15611a(this.f16305d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16306e != null && m15559g()) {
            abstractC4288ia.mo15607a(f16296g);
            abstractC4288ia.mo15611a(this.f16306e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16307f != null && m15560h()) {
            abstractC4288ia.mo15607a(f16297h);
            abstractC4288ia.mo15611a(this.f16307f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16308g != null && m15561i()) {
            abstractC4288ia.mo15607a(f16298i);
            abstractC4288ia.mo15611a(this.f16308g);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15551a(C4275ho c4275ho) {
        if (c4275ho == null) {
            return false;
        }
        boolean m15550a = m15550a();
        boolean m15550a2 = c4275ho.m15550a();
        if ((m15550a || m15550a2) && !(m15550a && m15550a2 && this.f16301a.equals(c4275ho.f16301a))) {
            return false;
        }
        boolean m15553b = m15553b();
        boolean m15553b2 = c4275ho.m15553b();
        if ((m15553b || m15553b2) && !(m15553b && m15553b2 && this.f16300a.m15138a(c4275ho.f16300a))) {
            return false;
        }
        boolean m15555c = m15555c();
        boolean m15555c2 = c4275ho.m15555c();
        if ((m15555c || m15555c2) && !(m15555c && m15555c2 && this.f16303b.equals(c4275ho.f16303b))) {
            return false;
        }
        boolean m15556d = m15556d();
        boolean m15556d2 = c4275ho.m15556d();
        if ((m15556d || m15556d2) && !(m15556d && m15556d2 && this.f16304c.equals(c4275ho.f16304c))) {
            return false;
        }
        boolean m15557e = m15557e();
        boolean m15557e2 = c4275ho.m15557e();
        if ((m15557e || m15557e2) && !(m15557e && m15557e2 && this.f16299a == c4275ho.f16299a)) {
            return false;
        }
        boolean m15558f = m15558f();
        boolean m15558f2 = c4275ho.m15558f();
        if ((m15558f || m15558f2) && !(m15558f && m15558f2 && this.f16305d.equals(c4275ho.f16305d))) {
            return false;
        }
        boolean m15559g = m15559g();
        boolean m15559g2 = c4275ho.m15559g();
        if ((m15559g || m15559g2) && !(m15559g && m15559g2 && this.f16306e.equals(c4275ho.f16306e))) {
            return false;
        }
        boolean m15560h = m15560h();
        boolean m15560h2 = c4275ho.m15560h();
        if ((m15560h || m15560h2) && !(m15560h && m15560h2 && this.f16307f.equals(c4275ho.f16307f))) {
            return false;
        }
        boolean m15561i = m15561i();
        boolean m15561i2 = c4275ho.m15561i();
        if (m15561i || m15561i2) {
            return m15561i && m15561i2 && this.f16308g.equals(c4275ho.f16308g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4275ho c4275ho) {
        int m15572a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15570a;
        int m15572a5;
        int m15572a6;
        int m15571a;
        int m15572a7;
        if (!C4275ho.class.equals(c4275ho.getClass())) {
            return C4275ho.class.getName().compareTo(c4275ho.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15550a()).compareTo(Boolean.valueOf(c4275ho.m15550a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15550a() && (m15572a7 = C4278hr.m15572a(this.f16301a, c4275ho.f16301a)) != 0) {
            return m15572a7;
        }
        int compareTo2 = Boolean.valueOf(m15553b()).compareTo(Boolean.valueOf(c4275ho.m15553b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15553b() && (m15571a = C4278hr.m15571a(this.f16300a, c4275ho.f16300a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15555c()).compareTo(Boolean.valueOf(c4275ho.m15555c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15555c() && (m15572a6 = C4278hr.m15572a(this.f16303b, c4275ho.f16303b)) != 0) {
            return m15572a6;
        }
        int compareTo4 = Boolean.valueOf(m15556d()).compareTo(Boolean.valueOf(c4275ho.m15556d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15556d() && (m15572a5 = C4278hr.m15572a(this.f16304c, c4275ho.f16304c)) != 0) {
            return m15572a5;
        }
        int compareTo5 = Boolean.valueOf(m15557e()).compareTo(Boolean.valueOf(c4275ho.m15557e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15557e() && (m15570a = C4278hr.m15570a(this.f16299a, c4275ho.f16299a)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15558f()).compareTo(Boolean.valueOf(c4275ho.m15558f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15558f() && (m15572a4 = C4278hr.m15572a(this.f16305d, c4275ho.f16305d)) != 0) {
            return m15572a4;
        }
        int compareTo7 = Boolean.valueOf(m15559g()).compareTo(Boolean.valueOf(c4275ho.m15559g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15559g() && (m15572a3 = C4278hr.m15572a(this.f16306e, c4275ho.f16306e)) != 0) {
            return m15572a3;
        }
        int compareTo8 = Boolean.valueOf(m15560h()).compareTo(Boolean.valueOf(c4275ho.m15560h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15560h() && (m15572a2 = C4278hr.m15572a(this.f16307f, c4275ho.f16307f)) != 0) {
            return m15572a2;
        }
        int compareTo9 = Boolean.valueOf(m15561i()).compareTo(Boolean.valueOf(c4275ho.m15561i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!m15561i() || (m15572a = C4278hr.m15572a(this.f16308g, c4275ho.f16308g)) == 0) {
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
                m15548a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16301a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16300a = new C4254gu();
                        this.f16300a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16303b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16304c = abstractC4288ia.mo15599a();
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
                        this.f16299a = abstractC4288ia.mo15593a();
                        m15549a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16305d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16306e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f16307f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f16308g = abstractC4288ia.mo15599a();
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
    public void m15548a() {
        if (this.f16303b != null) {
            return;
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
