package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hm */
/* loaded from: classes2.dex */
public class C4273hm implements InterfaceC4277hq<C4273hm, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f16262a;

    /* renamed from: a */
    public C4254gu f16263a;

    /* renamed from: a */
    public String f16264a;

    /* renamed from: a */
    private BitSet f16265a = new BitSet(3);

    /* renamed from: b */
    public long f16266b;

    /* renamed from: b */
    public String f16267b;

    /* renamed from: c */
    public long f16268c;

    /* renamed from: c */
    public String f16269c;

    /* renamed from: d */
    public String f16270d;

    /* renamed from: e */
    public String f16271e;

    /* renamed from: a */
    private static final C4293if f16253a = new C4293if("XmPushActionUnRegistrationResult");

    /* renamed from: a */
    private static final C4284hx f16252a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16254b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16255c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16256d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16257e = new C4284hx("", (byte) 10, 6);

    /* renamed from: f */
    private static final C4284hx f16258f = new C4284hx("", (byte) 11, 7);

    /* renamed from: g */
    private static final C4284hx f16259g = new C4284hx("", (byte) 11, 8);

    /* renamed from: h */
    private static final C4284hx f16260h = new C4284hx("", (byte) 10, 9);

    /* renamed from: i */
    private static final C4284hx f16261i = new C4284hx("", (byte) 10, 10);

    /* renamed from: a */
    public boolean m15518a() {
        return this.f16264a != null;
    }

    /* renamed from: b */
    public boolean m15521b() {
        return this.f16263a != null;
    }

    /* renamed from: c */
    public boolean m15523c() {
        return this.f16267b != null;
    }

    /* renamed from: d */
    public boolean m15524d() {
        return this.f16269c != null;
    }

    /* renamed from: e */
    public boolean m15525e() {
        return this.f16265a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4273hm)) {
            return m15519a((C4273hm) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15526f() {
        return this.f16270d != null;
    }

    /* renamed from: g */
    public boolean m15527g() {
        return this.f16271e != null;
    }

    /* renamed from: h */
    public boolean m15528h() {
        return this.f16265a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15529i() {
        return this.f16265a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        if (m15518a()) {
            sb.append("debug:");
            String str = this.f16264a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15521b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16263a;
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
        String str2 = this.f16267b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16269c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f16262a);
        if (m15526f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f16270d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15527g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f16271e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15528h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f16266b);
        }
        if (m15529i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f16268c);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m15517a(boolean z) {
        this.f16265a.set(0, z);
    }

    /* renamed from: b */
    public void m15520b(boolean z) {
        this.f16265a.set(1, z);
    }

    /* renamed from: c */
    public void m15522c(boolean z) {
        this.f16265a.set(2, z);
    }

    /* renamed from: a */
    public String m15515a() {
        return this.f16271e;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15516a();
        abstractC4288ia.mo15610a(f16253a);
        if (this.f16264a != null && m15518a()) {
            abstractC4288ia.mo15607a(f16252a);
            abstractC4288ia.mo15611a(this.f16264a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16263a != null && m15521b()) {
            abstractC4288ia.mo15607a(f16254b);
            this.f16263a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16267b != null) {
            abstractC4288ia.mo15607a(f16255c);
            abstractC4288ia.mo15611a(this.f16267b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16269c != null) {
            abstractC4288ia.mo15607a(f16256d);
            abstractC4288ia.mo15611a(this.f16269c);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f16257e);
        abstractC4288ia.mo15606a(this.f16262a);
        abstractC4288ia.mo15616b();
        if (this.f16270d != null && m15526f()) {
            abstractC4288ia.mo15607a(f16258f);
            abstractC4288ia.mo15611a(this.f16270d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16271e != null && m15527g()) {
            abstractC4288ia.mo15607a(f16259g);
            abstractC4288ia.mo15611a(this.f16271e);
            abstractC4288ia.mo15616b();
        }
        if (m15528h()) {
            abstractC4288ia.mo15607a(f16260h);
            abstractC4288ia.mo15606a(this.f16266b);
            abstractC4288ia.mo15616b();
        }
        if (m15529i()) {
            abstractC4288ia.mo15607a(f16261i);
            abstractC4288ia.mo15606a(this.f16268c);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15519a(C4273hm c4273hm) {
        if (c4273hm == null) {
            return false;
        }
        boolean m15518a = m15518a();
        boolean m15518a2 = c4273hm.m15518a();
        if ((m15518a || m15518a2) && !(m15518a && m15518a2 && this.f16264a.equals(c4273hm.f16264a))) {
            return false;
        }
        boolean m15521b = m15521b();
        boolean m15521b2 = c4273hm.m15521b();
        if ((m15521b || m15521b2) && !(m15521b && m15521b2 && this.f16263a.m15138a(c4273hm.f16263a))) {
            return false;
        }
        boolean m15523c = m15523c();
        boolean m15523c2 = c4273hm.m15523c();
        if ((m15523c || m15523c2) && !(m15523c && m15523c2 && this.f16267b.equals(c4273hm.f16267b))) {
            return false;
        }
        boolean m15524d = m15524d();
        boolean m15524d2 = c4273hm.m15524d();
        if (((m15524d || m15524d2) && !(m15524d && m15524d2 && this.f16269c.equals(c4273hm.f16269c))) || this.f16262a != c4273hm.f16262a) {
            return false;
        }
        boolean m15526f = m15526f();
        boolean m15526f2 = c4273hm.m15526f();
        if ((m15526f || m15526f2) && !(m15526f && m15526f2 && this.f16270d.equals(c4273hm.f16270d))) {
            return false;
        }
        boolean m15527g = m15527g();
        boolean m15527g2 = c4273hm.m15527g();
        if ((m15527g || m15527g2) && !(m15527g && m15527g2 && this.f16271e.equals(c4273hm.f16271e))) {
            return false;
        }
        boolean m15528h = m15528h();
        boolean m15528h2 = c4273hm.m15528h();
        if ((m15528h || m15528h2) && !(m15528h && m15528h2 && this.f16266b == c4273hm.f16266b)) {
            return false;
        }
        boolean m15529i = m15529i();
        boolean m15529i2 = c4273hm.m15529i();
        if (m15529i || m15529i2) {
            return m15529i && m15529i2 && this.f16268c == c4273hm.f16268c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4273hm c4273hm) {
        int m15570a;
        int m15570a2;
        int m15572a;
        int m15572a2;
        int m15570a3;
        int m15572a3;
        int m15572a4;
        int m15571a;
        int m15572a5;
        if (!C4273hm.class.equals(c4273hm.getClass())) {
            return C4273hm.class.getName().compareTo(c4273hm.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15518a()).compareTo(Boolean.valueOf(c4273hm.m15518a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15518a() && (m15572a5 = C4278hr.m15572a(this.f16264a, c4273hm.f16264a)) != 0) {
            return m15572a5;
        }
        int compareTo2 = Boolean.valueOf(m15521b()).compareTo(Boolean.valueOf(c4273hm.m15521b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15521b() && (m15571a = C4278hr.m15571a(this.f16263a, c4273hm.f16263a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15523c()).compareTo(Boolean.valueOf(c4273hm.m15523c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15523c() && (m15572a4 = C4278hr.m15572a(this.f16267b, c4273hm.f16267b)) != 0) {
            return m15572a4;
        }
        int compareTo4 = Boolean.valueOf(m15524d()).compareTo(Boolean.valueOf(c4273hm.m15524d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15524d() && (m15572a3 = C4278hr.m15572a(this.f16269c, c4273hm.f16269c)) != 0) {
            return m15572a3;
        }
        int compareTo5 = Boolean.valueOf(m15525e()).compareTo(Boolean.valueOf(c4273hm.m15525e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15525e() && (m15570a3 = C4278hr.m15570a(this.f16262a, c4273hm.f16262a)) != 0) {
            return m15570a3;
        }
        int compareTo6 = Boolean.valueOf(m15526f()).compareTo(Boolean.valueOf(c4273hm.m15526f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15526f() && (m15572a2 = C4278hr.m15572a(this.f16270d, c4273hm.f16270d)) != 0) {
            return m15572a2;
        }
        int compareTo7 = Boolean.valueOf(m15527g()).compareTo(Boolean.valueOf(c4273hm.m15527g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15527g() && (m15572a = C4278hr.m15572a(this.f16271e, c4273hm.f16271e)) != 0) {
            return m15572a;
        }
        int compareTo8 = Boolean.valueOf(m15528h()).compareTo(Boolean.valueOf(c4273hm.m15528h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15528h() && (m15570a2 = C4278hr.m15570a(this.f16266b, c4273hm.f16266b)) != 0) {
            return m15570a2;
        }
        int compareTo9 = Boolean.valueOf(m15529i()).compareTo(Boolean.valueOf(c4273hm.m15529i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!m15529i() || (m15570a = C4278hr.m15570a(this.f16268c, c4273hm.f16268c)) == 0) {
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
                if (m15525e()) {
                    m15516a();
                    return;
                }
                throw new C4289ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16264a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16263a = new C4254gu();
                        this.f16263a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16267b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16269c = abstractC4288ia.mo15599a();
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
                        this.f16262a = abstractC4288ia.mo15593a();
                        m15517a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16270d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16271e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 10) {
                        this.f16266b = abstractC4288ia.mo15593a();
                        m15520b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 10) {
                        this.f16268c = abstractC4288ia.mo15593a();
                        m15522c(true);
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
    public void m15516a() {
        if (this.f16267b != null) {
            if (this.f16269c != null) {
                return;
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
