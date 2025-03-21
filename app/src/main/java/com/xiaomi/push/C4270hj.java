package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hj */
/* loaded from: classes2.dex */
public class C4270hj implements InterfaceC4277hq<C4270hj, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C4254gu f16198a;

    /* renamed from: a */
    public String f16199a;

    /* renamed from: a */
    public List<String> f16200a;

    /* renamed from: b */
    public String f16201b;

    /* renamed from: c */
    public String f16202c;

    /* renamed from: d */
    public String f16203d;

    /* renamed from: e */
    public String f16204e;

    /* renamed from: f */
    public String f16205f;

    /* renamed from: a */
    private static final C4293if f16190a = new C4293if("XmPushActionSubscription");

    /* renamed from: a */
    private static final C4284hx f16189a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16191b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16192c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16193d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16194e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f16195f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f16196g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f16197h = new C4284hx("", C3393cw.f11873m, 8);

    /* renamed from: a */
    public boolean m15463a() {
        return this.f16199a != null;
    }

    /* renamed from: b */
    public boolean m15466b() {
        return this.f16198a != null;
    }

    /* renamed from: c */
    public boolean m15468c() {
        return this.f16201b != null;
    }

    /* renamed from: d */
    public boolean m15470d() {
        return this.f16202c != null;
    }

    /* renamed from: e */
    public boolean m15472e() {
        return this.f16203d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4270hj)) {
            return m15464a((C4270hj) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15473f() {
        return this.f16204e != null;
    }

    /* renamed from: g */
    public boolean m15474g() {
        return this.f16205f != null;
    }

    /* renamed from: h */
    public boolean m15475h() {
        return this.f16200a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (m15463a()) {
            sb.append("debug:");
            String str = this.f16199a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15466b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16198a;
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
        String str2 = this.f16201b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16202c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f16203d;
        if (str4 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str4);
        }
        if (m15473f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f16204e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15474g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f16205f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15475h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f16200a;
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
    public C4270hj m15461a(String str) {
        this.f16201b = str;
        return this;
    }

    /* renamed from: b */
    public C4270hj m15465b(String str) {
        this.f16202c = str;
        return this;
    }

    /* renamed from: c */
    public C4270hj m15467c(String str) {
        this.f16203d = str;
        return this;
    }

    /* renamed from: d */
    public C4270hj m15469d(String str) {
        this.f16204e = str;
        return this;
    }

    /* renamed from: e */
    public C4270hj m15471e(String str) {
        this.f16205f = str;
        return this;
    }

    /* renamed from: a */
    public boolean m15464a(C4270hj c4270hj) {
        if (c4270hj == null) {
            return false;
        }
        boolean m15463a = m15463a();
        boolean m15463a2 = c4270hj.m15463a();
        if ((m15463a || m15463a2) && !(m15463a && m15463a2 && this.f16199a.equals(c4270hj.f16199a))) {
            return false;
        }
        boolean m15466b = m15466b();
        boolean m15466b2 = c4270hj.m15466b();
        if ((m15466b || m15466b2) && !(m15466b && m15466b2 && this.f16198a.m15138a(c4270hj.f16198a))) {
            return false;
        }
        boolean m15468c = m15468c();
        boolean m15468c2 = c4270hj.m15468c();
        if ((m15468c || m15468c2) && !(m15468c && m15468c2 && this.f16201b.equals(c4270hj.f16201b))) {
            return false;
        }
        boolean m15470d = m15470d();
        boolean m15470d2 = c4270hj.m15470d();
        if ((m15470d || m15470d2) && !(m15470d && m15470d2 && this.f16202c.equals(c4270hj.f16202c))) {
            return false;
        }
        boolean m15472e = m15472e();
        boolean m15472e2 = c4270hj.m15472e();
        if ((m15472e || m15472e2) && !(m15472e && m15472e2 && this.f16203d.equals(c4270hj.f16203d))) {
            return false;
        }
        boolean m15473f = m15473f();
        boolean m15473f2 = c4270hj.m15473f();
        if ((m15473f || m15473f2) && !(m15473f && m15473f2 && this.f16204e.equals(c4270hj.f16204e))) {
            return false;
        }
        boolean m15474g = m15474g();
        boolean m15474g2 = c4270hj.m15474g();
        if ((m15474g || m15474g2) && !(m15474g && m15474g2 && this.f16205f.equals(c4270hj.f16205f))) {
            return false;
        }
        boolean m15475h = m15475h();
        boolean m15475h2 = c4270hj.m15475h();
        if (m15475h || m15475h2) {
            return m15475h && m15475h2 && this.f16200a.equals(c4270hj.f16200a);
        }
        return true;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15462a();
        abstractC4288ia.mo15610a(f16190a);
        if (this.f16199a != null && m15463a()) {
            abstractC4288ia.mo15607a(f16189a);
            abstractC4288ia.mo15611a(this.f16199a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16198a != null && m15466b()) {
            abstractC4288ia.mo15607a(f16191b);
            this.f16198a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16201b != null) {
            abstractC4288ia.mo15607a(f16192c);
            abstractC4288ia.mo15611a(this.f16201b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16202c != null) {
            abstractC4288ia.mo15607a(f16193d);
            abstractC4288ia.mo15611a(this.f16202c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16203d != null) {
            abstractC4288ia.mo15607a(f16194e);
            abstractC4288ia.mo15611a(this.f16203d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16204e != null && m15473f()) {
            abstractC4288ia.mo15607a(f16195f);
            abstractC4288ia.mo15611a(this.f16204e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16205f != null && m15474g()) {
            abstractC4288ia.mo15607a(f16196g);
            abstractC4288ia.mo15611a(this.f16205f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16200a != null && m15475h()) {
            abstractC4288ia.mo15607a(f16197h);
            abstractC4288ia.mo15608a(new C4285hy((byte) 11, this.f16200a.size()));
            Iterator<String> it = this.f16200a.iterator();
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
    public int compareTo(C4270hj c4270hj) {
        int m15574a;
        int m15572a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15572a5;
        int m15571a;
        int m15572a6;
        if (!C4270hj.class.equals(c4270hj.getClass())) {
            return C4270hj.class.getName().compareTo(c4270hj.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15463a()).compareTo(Boolean.valueOf(c4270hj.m15463a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15463a() && (m15572a6 = C4278hr.m15572a(this.f16199a, c4270hj.f16199a)) != 0) {
            return m15572a6;
        }
        int compareTo2 = Boolean.valueOf(m15466b()).compareTo(Boolean.valueOf(c4270hj.m15466b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15466b() && (m15571a = C4278hr.m15571a(this.f16198a, c4270hj.f16198a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15468c()).compareTo(Boolean.valueOf(c4270hj.m15468c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15468c() && (m15572a5 = C4278hr.m15572a(this.f16201b, c4270hj.f16201b)) != 0) {
            return m15572a5;
        }
        int compareTo4 = Boolean.valueOf(m15470d()).compareTo(Boolean.valueOf(c4270hj.m15470d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15470d() && (m15572a4 = C4278hr.m15572a(this.f16202c, c4270hj.f16202c)) != 0) {
            return m15572a4;
        }
        int compareTo5 = Boolean.valueOf(m15472e()).compareTo(Boolean.valueOf(c4270hj.m15472e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15472e() && (m15572a3 = C4278hr.m15572a(this.f16203d, c4270hj.f16203d)) != 0) {
            return m15572a3;
        }
        int compareTo6 = Boolean.valueOf(m15473f()).compareTo(Boolean.valueOf(c4270hj.m15473f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15473f() && (m15572a2 = C4278hr.m15572a(this.f16204e, c4270hj.f16204e)) != 0) {
            return m15572a2;
        }
        int compareTo7 = Boolean.valueOf(m15474g()).compareTo(Boolean.valueOf(c4270hj.m15474g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15474g() && (m15572a = C4278hr.m15572a(this.f16205f, c4270hj.f16205f)) != 0) {
            return m15572a;
        }
        int compareTo8 = Boolean.valueOf(m15475h()).compareTo(Boolean.valueOf(c4270hj.m15475h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!m15475h() || (m15574a = C4278hr.m15574a(this.f16200a, c4270hj.f16200a)) == 0) {
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
                m15462a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16199a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16198a = new C4254gu();
                        this.f16198a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16201b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16202c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16203d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f16204e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16205f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        C4285hy mo15595a = abstractC4288ia.mo15595a();
                        this.f16200a = new ArrayList(mo15595a.f16335a);
                        for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                            this.f16200a.add(abstractC4288ia.mo15599a());
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
    public void m15462a() {
        if (this.f16201b != null) {
            if (this.f16202c != null) {
                if (this.f16203d != null) {
                    return;
                }
                throw new C4289ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
