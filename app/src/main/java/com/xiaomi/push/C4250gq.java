package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gq */
/* loaded from: classes2.dex */
public class C4250gq implements InterfaceC4277hq<C4250gq, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f15778a;

    /* renamed from: a */
    public long f15779a;

    /* renamed from: a */
    public String f15780a;

    /* renamed from: a */
    private BitSet f15781a = new BitSet(6);

    /* renamed from: a */
    public boolean f15782a;

    /* renamed from: b */
    public int f15783b;

    /* renamed from: b */
    public boolean f15784b;

    /* renamed from: c */
    public int f15785c;

    /* renamed from: a */
    private static final C4293if f15771a = new C4293if("OnlineConfigItem");

    /* renamed from: a */
    private static final C4284hx f15770a = new C4284hx("", (byte) 8, 1);

    /* renamed from: b */
    private static final C4284hx f15772b = new C4284hx("", (byte) 8, 2);

    /* renamed from: c */
    private static final C4284hx f15773c = new C4284hx("", (byte) 2, 3);

    /* renamed from: d */
    private static final C4284hx f15774d = new C4284hx("", (byte) 8, 4);

    /* renamed from: e */
    private static final C4284hx f15775e = new C4284hx("", (byte) 10, 5);

    /* renamed from: f */
    private static final C4284hx f15776f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f15777g = new C4284hx("", (byte) 2, 7);

    /* renamed from: a */
    public int m15038a() {
        return this.f15778a;
    }

    /* renamed from: a */
    public void m15042a() {
    }

    /* renamed from: b */
    public int m15046b() {
        return this.f15783b;
    }

    /* renamed from: c */
    public boolean m15051c() {
        return this.f15781a.get(2);
    }

    /* renamed from: d */
    public boolean m15053d() {
        return this.f15781a.get(3);
    }

    /* renamed from: e */
    public boolean m15055e() {
        return this.f15781a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4250gq)) {
            return m15045a((C4250gq) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15057f() {
        return this.f15780a != null;
    }

    /* renamed from: g */
    public boolean m15058g() {
        return this.f15784b;
    }

    /* renamed from: h */
    public boolean m15059h() {
        return this.f15781a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (m15044a()) {
            sb.append("key:");
            sb.append(this.f15778a);
            z = false;
        } else {
            z = true;
        }
        if (m15048b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f15783b);
            z = false;
        }
        if (m15051c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f15782a);
            z = false;
        }
        if (m15053d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f15785c);
            z = false;
        }
        if (m15055e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f15779a);
            z = false;
        }
        if (m15057f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f15780a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        }
        if (m15059h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f15784b);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m15044a() {
        return this.f15781a.get(0);
    }

    /* renamed from: b */
    public boolean m15048b() {
        return this.f15781a.get(1);
    }

    /* renamed from: c */
    public void m15050c(boolean z) {
        this.f15781a.set(2, z);
    }

    /* renamed from: d */
    public void m15052d(boolean z) {
        this.f15781a.set(3, z);
    }

    /* renamed from: e */
    public void m15054e(boolean z) {
        this.f15781a.set(4, z);
    }

    /* renamed from: f */
    public void m15056f(boolean z) {
        this.f15781a.set(5, z);
    }

    /* renamed from: a */
    public void m15043a(boolean z) {
        this.f15781a.set(0, z);
    }

    /* renamed from: b */
    public void m15047b(boolean z) {
        this.f15781a.set(1, z);
    }

    /* renamed from: c */
    public int m15049c() {
        return this.f15785c;
    }

    /* renamed from: a */
    public long m15040a() {
        return this.f15779a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15042a();
        abstractC4288ia.mo15610a(f15771a);
        if (m15044a()) {
            abstractC4288ia.mo15607a(f15770a);
            abstractC4288ia.mo15605a(this.f15778a);
            abstractC4288ia.mo15616b();
        }
        if (m15048b()) {
            abstractC4288ia.mo15607a(f15772b);
            abstractC4288ia.mo15605a(this.f15783b);
            abstractC4288ia.mo15616b();
        }
        if (m15051c()) {
            abstractC4288ia.mo15607a(f15773c);
            abstractC4288ia.mo15614a(this.f15782a);
            abstractC4288ia.mo15616b();
        }
        if (m15053d()) {
            abstractC4288ia.mo15607a(f15774d);
            abstractC4288ia.mo15605a(this.f15785c);
            abstractC4288ia.mo15616b();
        }
        if (m15055e()) {
            abstractC4288ia.mo15607a(f15775e);
            abstractC4288ia.mo15606a(this.f15779a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15780a != null && m15057f()) {
            abstractC4288ia.mo15607a(f15776f);
            abstractC4288ia.mo15611a(this.f15780a);
            abstractC4288ia.mo15616b();
        }
        if (m15059h()) {
            abstractC4288ia.mo15607a(f15777g);
            abstractC4288ia.mo15614a(this.f15784b);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public String m15041a() {
        return this.f15780a;
    }

    /* renamed from: a */
    public boolean m15045a(C4250gq c4250gq) {
        if (c4250gq == null) {
            return false;
        }
        boolean m15044a = m15044a();
        boolean m15044a2 = c4250gq.m15044a();
        if ((m15044a || m15044a2) && !(m15044a && m15044a2 && this.f15778a == c4250gq.f15778a)) {
            return false;
        }
        boolean m15048b = m15048b();
        boolean m15048b2 = c4250gq.m15048b();
        if ((m15048b || m15048b2) && !(m15048b && m15048b2 && this.f15783b == c4250gq.f15783b)) {
            return false;
        }
        boolean m15051c = m15051c();
        boolean m15051c2 = c4250gq.m15051c();
        if ((m15051c || m15051c2) && !(m15051c && m15051c2 && this.f15782a == c4250gq.f15782a)) {
            return false;
        }
        boolean m15053d = m15053d();
        boolean m15053d2 = c4250gq.m15053d();
        if ((m15053d || m15053d2) && !(m15053d && m15053d2 && this.f15785c == c4250gq.f15785c)) {
            return false;
        }
        boolean m15055e = m15055e();
        boolean m15055e2 = c4250gq.m15055e();
        if ((m15055e || m15055e2) && !(m15055e && m15055e2 && this.f15779a == c4250gq.f15779a)) {
            return false;
        }
        boolean m15057f = m15057f();
        boolean m15057f2 = c4250gq.m15057f();
        if ((m15057f || m15057f2) && !(m15057f && m15057f2 && this.f15780a.equals(c4250gq.f15780a))) {
            return false;
        }
        boolean m15059h = m15059h();
        boolean m15059h2 = c4250gq.m15059h();
        if (m15059h || m15059h2) {
            return m15059h && m15059h2 && this.f15784b == c4250gq.f15784b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4250gq c4250gq) {
        int m15578a;
        int m15572a;
        int m15570a;
        int m15569a;
        int m15578a2;
        int m15569a2;
        int m15569a3;
        if (!C4250gq.class.equals(c4250gq.getClass())) {
            return C4250gq.class.getName().compareTo(c4250gq.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15044a()).compareTo(Boolean.valueOf(c4250gq.m15044a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15044a() && (m15569a3 = C4278hr.m15569a(this.f15778a, c4250gq.f15778a)) != 0) {
            return m15569a3;
        }
        int compareTo2 = Boolean.valueOf(m15048b()).compareTo(Boolean.valueOf(c4250gq.m15048b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15048b() && (m15569a2 = C4278hr.m15569a(this.f15783b, c4250gq.f15783b)) != 0) {
            return m15569a2;
        }
        int compareTo3 = Boolean.valueOf(m15051c()).compareTo(Boolean.valueOf(c4250gq.m15051c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15051c() && (m15578a2 = C4278hr.m15578a(this.f15782a, c4250gq.f15782a)) != 0) {
            return m15578a2;
        }
        int compareTo4 = Boolean.valueOf(m15053d()).compareTo(Boolean.valueOf(c4250gq.m15053d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15053d() && (m15569a = C4278hr.m15569a(this.f15785c, c4250gq.f15785c)) != 0) {
            return m15569a;
        }
        int compareTo5 = Boolean.valueOf(m15055e()).compareTo(Boolean.valueOf(c4250gq.m15055e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15055e() && (m15570a = C4278hr.m15570a(this.f15779a, c4250gq.f15779a)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15057f()).compareTo(Boolean.valueOf(c4250gq.m15057f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15057f() && (m15572a = C4278hr.m15572a(this.f15780a, c4250gq.f15780a)) != 0) {
            return m15572a;
        }
        int compareTo7 = Boolean.valueOf(m15059h()).compareTo(Boolean.valueOf(c4250gq.m15059h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!m15059h() || (m15578a = C4278hr.m15578a(this.f15784b, c4250gq.f15784b)) == 0) {
            return 0;
        }
        return m15578a;
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
                m15042a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 8) {
                        this.f15778a = abstractC4288ia.mo15592a();
                        m15043a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f15783b = abstractC4288ia.mo15592a();
                        m15047b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f15782a = abstractC4288ia.mo15615a();
                        m15050c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 8) {
                        this.f15785c = abstractC4288ia.mo15592a();
                        m15052d(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f15779a = abstractC4288ia.mo15593a();
                        m15054e(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f15780a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 2) {
                        this.f15784b = abstractC4288ia.mo15615a();
                        m15056f(true);
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
}
