package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.ej */
/* loaded from: classes2.dex */
public class C4189ej implements InterfaceC4277hq<C4189ej, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public byte f15157a;

    /* renamed from: a */
    public int f15158a;

    /* renamed from: a */
    public String f15159a;

    /* renamed from: a */
    private BitSet f15160a = new BitSet(6);

    /* renamed from: b */
    public int f15161b;

    /* renamed from: b */
    public String f15162b;

    /* renamed from: c */
    public int f15163c;

    /* renamed from: c */
    public String f15164c;

    /* renamed from: d */
    public int f15165d;

    /* renamed from: d */
    public String f15166d;

    /* renamed from: e */
    public int f15167e;

    /* renamed from: a */
    private static final C4293if f15147a = new C4293if("StatsEvent");

    /* renamed from: a */
    private static final C4284hx f15146a = new C4284hx("", (byte) 3, 1);

    /* renamed from: b */
    private static final C4284hx f15148b = new C4284hx("", (byte) 8, 2);

    /* renamed from: c */
    private static final C4284hx f15149c = new C4284hx("", (byte) 8, 3);

    /* renamed from: d */
    private static final C4284hx f15150d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15151e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f15152f = new C4284hx("", (byte) 8, 6);

    /* renamed from: g */
    private static final C4284hx f15153g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f15154h = new C4284hx("", (byte) 11, 8);

    /* renamed from: i */
    private static final C4284hx f15155i = new C4284hx("", (byte) 8, 9);

    /* renamed from: j */
    private static final C4284hx f15156j = new C4284hx("", (byte) 8, 10);

    /* renamed from: a */
    public C4189ej m14602a(byte b2) {
        this.f15157a = b2;
        m14607a(true);
        return this;
    }

    /* renamed from: b */
    public boolean m14614b() {
        return this.f15160a.get(1);
    }

    /* renamed from: c */
    public boolean m14618c() {
        return this.f15160a.get(2);
    }

    /* renamed from: d */
    public boolean m14622d() {
        return this.f15159a != null;
    }

    /* renamed from: e */
    public boolean m14624e() {
        return this.f15162b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4189ej)) {
            return m14609a((C4189ej) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m14626f() {
        return this.f15160a.get(3);
    }

    /* renamed from: g */
    public boolean m14627g() {
        return this.f15164c != null;
    }

    /* renamed from: h */
    public boolean m14628h() {
        return this.f15166d != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m14629i() {
        return this.f15160a.get(4);
    }

    /* renamed from: j */
    public boolean m14630j() {
        return this.f15160a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f15157a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f15158a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f15161b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f15159a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        if (m14624e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f15162b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
        }
        if (m14626f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f15163c);
        }
        if (m14627g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f15164c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m14628h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f15166d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m14629i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f15165d);
        }
        if (m14630j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f15167e);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: b */
    public void m14613b(boolean z) {
        this.f15160a.set(1, z);
    }

    /* renamed from: c */
    public void m14617c(boolean z) {
        this.f15160a.set(2, z);
    }

    /* renamed from: d */
    public void m14621d(boolean z) {
        this.f15160a.set(3, z);
    }

    /* renamed from: e */
    public void m14623e(boolean z) {
        this.f15160a.set(4, z);
    }

    /* renamed from: f */
    public void m14625f(boolean z) {
        this.f15160a.set(5, z);
    }

    /* renamed from: a */
    public boolean m14608a() {
        return this.f15160a.get(0);
    }

    /* renamed from: b */
    public C4189ej m14610b(int i2) {
        this.f15161b = i2;
        m14617c(true);
        return this;
    }

    /* renamed from: c */
    public C4189ej m14615c(int i2) {
        this.f15163c = i2;
        m14621d(true);
        return this;
    }

    /* renamed from: d */
    public C4189ej m14620d(String str) {
        this.f15166d = str;
        return this;
    }

    /* renamed from: a */
    public void m14607a(boolean z) {
        this.f15160a.set(0, z);
    }

    /* renamed from: d */
    public C4189ej m14619d(int i2) {
        this.f15165d = i2;
        m14623e(true);
        return this;
    }

    /* renamed from: a */
    public C4189ej m14603a(int i2) {
        this.f15158a = i2;
        m14613b(true);
        return this;
    }

    /* renamed from: b */
    public C4189ej m14611b(String str) {
        this.f15162b = str;
        return this;
    }

    /* renamed from: c */
    public C4189ej m14616c(String str) {
        this.f15164c = str;
        return this;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m14605a();
        abstractC4288ia.mo15610a(f15147a);
        abstractC4288ia.mo15607a(f15146a);
        abstractC4288ia.mo15604a(this.f15157a);
        abstractC4288ia.mo15616b();
        abstractC4288ia.mo15607a(f15148b);
        abstractC4288ia.mo15605a(this.f15158a);
        abstractC4288ia.mo15616b();
        abstractC4288ia.mo15607a(f15149c);
        abstractC4288ia.mo15605a(this.f15161b);
        abstractC4288ia.mo15616b();
        if (this.f15159a != null) {
            abstractC4288ia.mo15607a(f15150d);
            abstractC4288ia.mo15611a(this.f15159a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15162b != null && m14624e()) {
            abstractC4288ia.mo15607a(f15151e);
            abstractC4288ia.mo15611a(this.f15162b);
            abstractC4288ia.mo15616b();
        }
        if (m14626f()) {
            abstractC4288ia.mo15607a(f15152f);
            abstractC4288ia.mo15605a(this.f15163c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15164c != null && m14627g()) {
            abstractC4288ia.mo15607a(f15153g);
            abstractC4288ia.mo15611a(this.f15164c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15166d != null && m14628h()) {
            abstractC4288ia.mo15607a(f15154h);
            abstractC4288ia.mo15611a(this.f15166d);
            abstractC4288ia.mo15616b();
        }
        if (m14629i()) {
            abstractC4288ia.mo15607a(f15155i);
            abstractC4288ia.mo15605a(this.f15165d);
            abstractC4288ia.mo15616b();
        }
        if (m14630j()) {
            abstractC4288ia.mo15607a(f15156j);
            abstractC4288ia.mo15605a(this.f15167e);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public C4189ej m14604a(String str) {
        this.f15159a = str;
        return this;
    }

    /* renamed from: a */
    public boolean m14609a(C4189ej c4189ej) {
        if (c4189ej == null || this.f15157a != c4189ej.f15157a || this.f15158a != c4189ej.f15158a || this.f15161b != c4189ej.f15161b) {
            return false;
        }
        boolean m14622d = m14622d();
        boolean m14622d2 = c4189ej.m14622d();
        if ((m14622d || m14622d2) && !(m14622d && m14622d2 && this.f15159a.equals(c4189ej.f15159a))) {
            return false;
        }
        boolean m14624e = m14624e();
        boolean m14624e2 = c4189ej.m14624e();
        if ((m14624e || m14624e2) && !(m14624e && m14624e2 && this.f15162b.equals(c4189ej.f15162b))) {
            return false;
        }
        boolean m14626f = m14626f();
        boolean m14626f2 = c4189ej.m14626f();
        if ((m14626f || m14626f2) && !(m14626f && m14626f2 && this.f15163c == c4189ej.f15163c)) {
            return false;
        }
        boolean m14627g = m14627g();
        boolean m14627g2 = c4189ej.m14627g();
        if ((m14627g || m14627g2) && !(m14627g && m14627g2 && this.f15164c.equals(c4189ej.f15164c))) {
            return false;
        }
        boolean m14628h = m14628h();
        boolean m14628h2 = c4189ej.m14628h();
        if ((m14628h || m14628h2) && !(m14628h && m14628h2 && this.f15166d.equals(c4189ej.f15166d))) {
            return false;
        }
        boolean m14629i = m14629i();
        boolean m14629i2 = c4189ej.m14629i();
        if ((m14629i || m14629i2) && !(m14629i && m14629i2 && this.f15165d == c4189ej.f15165d)) {
            return false;
        }
        boolean m14630j = m14630j();
        boolean m14630j2 = c4189ej.m14630j();
        if (m14630j || m14630j2) {
            return m14630j && m14630j2 && this.f15167e == c4189ej.f15167e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4189ej c4189ej) {
        int m15569a;
        int m15569a2;
        int m15572a;
        int m15572a2;
        int m15569a3;
        int m15572a3;
        int m15572a4;
        int m15569a4;
        int m15569a5;
        int m15568a;
        if (!C4189ej.class.equals(c4189ej.getClass())) {
            return C4189ej.class.getName().compareTo(c4189ej.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m14608a()).compareTo(Boolean.valueOf(c4189ej.m14608a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m14608a() && (m15568a = C4278hr.m15568a(this.f15157a, c4189ej.f15157a)) != 0) {
            return m15568a;
        }
        int compareTo2 = Boolean.valueOf(m14614b()).compareTo(Boolean.valueOf(c4189ej.m14614b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m14614b() && (m15569a5 = C4278hr.m15569a(this.f15158a, c4189ej.f15158a)) != 0) {
            return m15569a5;
        }
        int compareTo3 = Boolean.valueOf(m14618c()).compareTo(Boolean.valueOf(c4189ej.m14618c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m14618c() && (m15569a4 = C4278hr.m15569a(this.f15161b, c4189ej.f15161b)) != 0) {
            return m15569a4;
        }
        int compareTo4 = Boolean.valueOf(m14622d()).compareTo(Boolean.valueOf(c4189ej.m14622d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m14622d() && (m15572a4 = C4278hr.m15572a(this.f15159a, c4189ej.f15159a)) != 0) {
            return m15572a4;
        }
        int compareTo5 = Boolean.valueOf(m14624e()).compareTo(Boolean.valueOf(c4189ej.m14624e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m14624e() && (m15572a3 = C4278hr.m15572a(this.f15162b, c4189ej.f15162b)) != 0) {
            return m15572a3;
        }
        int compareTo6 = Boolean.valueOf(m14626f()).compareTo(Boolean.valueOf(c4189ej.m14626f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m14626f() && (m15569a3 = C4278hr.m15569a(this.f15163c, c4189ej.f15163c)) != 0) {
            return m15569a3;
        }
        int compareTo7 = Boolean.valueOf(m14627g()).compareTo(Boolean.valueOf(c4189ej.m14627g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m14627g() && (m15572a2 = C4278hr.m15572a(this.f15164c, c4189ej.f15164c)) != 0) {
            return m15572a2;
        }
        int compareTo8 = Boolean.valueOf(m14628h()).compareTo(Boolean.valueOf(c4189ej.m14628h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m14628h() && (m15572a = C4278hr.m15572a(this.f15166d, c4189ej.f15166d)) != 0) {
            return m15572a;
        }
        int compareTo9 = Boolean.valueOf(m14629i()).compareTo(Boolean.valueOf(c4189ej.m14629i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m14629i() && (m15569a2 = C4278hr.m15569a(this.f15165d, c4189ej.f15165d)) != 0) {
            return m15569a2;
        }
        int compareTo10 = Boolean.valueOf(m14630j()).compareTo(Boolean.valueOf(c4189ej.m14630j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m14630j() || (m15569a = C4278hr.m15569a(this.f15167e, c4189ej.f15167e)) == 0) {
            return 0;
        }
        return m15569a;
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
                if (m14608a()) {
                    if (m14614b()) {
                        if (m14618c()) {
                            m14605a();
                            return;
                        }
                        throw new C4289ib("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new C4289ib("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new C4289ib("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 3) {
                        this.f15157a = abstractC4288ia.mo15590a();
                        m14607a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f15158a = abstractC4288ia.mo15592a();
                        m14613b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 8) {
                        this.f15161b = abstractC4288ia.mo15592a();
                        m14617c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f15159a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f15162b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 8) {
                        this.f15163c = abstractC4288ia.mo15592a();
                        m14621d(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f15164c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f15166d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f15165d = abstractC4288ia.mo15592a();
                        m14623e(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 8) {
                        this.f15167e = abstractC4288ia.mo15592a();
                        m14625f(true);
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
    public void m14605a() {
        if (this.f15159a != null) {
            return;
        }
        throw new C4289ib("Required field 'connpt' was not present! Struct: " + toString());
    }
}
