package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hb */
/* loaded from: classes2.dex */
public class C4262hb implements InterfaceC4277hq<C4262hb, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public EnumC4239gf f15998a;

    /* renamed from: a */
    public C4252gs f15999a;

    /* renamed from: a */
    public C4254gu f16000a;

    /* renamed from: a */
    public String f16001a;

    /* renamed from: a */
    public ByteBuffer f16002a;

    /* renamed from: b */
    public String f16005b;

    /* renamed from: a */
    private static final C4293if f15990a = new C4293if("XmPushActionContainer");

    /* renamed from: a */
    private static final C4284hx f15989a = new C4284hx("", (byte) 8, 1);

    /* renamed from: b */
    private static final C4284hx f15991b = new C4284hx("", (byte) 2, 2);

    /* renamed from: c */
    private static final C4284hx f15992c = new C4284hx("", (byte) 2, 3);

    /* renamed from: d */
    private static final C4284hx f15993d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15994e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f15995f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f15996g = new C4284hx("", (byte) 12, 7);

    /* renamed from: h */
    private static final C4284hx f15997h = new C4284hx("", (byte) 12, 8);

    /* renamed from: a */
    private BitSet f16003a = new BitSet(2);

    /* renamed from: a */
    public boolean f16004a = true;

    /* renamed from: b */
    public boolean f16006b = true;

    /* renamed from: a */
    public EnumC4239gf m15263a() {
        return this.f15998a;
    }

    /* renamed from: b */
    public boolean m15281b() {
        return this.f16004a;
    }

    /* renamed from: c */
    public boolean m15282c() {
        return this.f16003a.get(0);
    }

    /* renamed from: d */
    public boolean m15283d() {
        return this.f16003a.get(1);
    }

    /* renamed from: e */
    public boolean m15284e() {
        return this.f16002a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4262hb)) {
            return m15275a((C4262hb) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15285f() {
        return this.f16001a != null;
    }

    /* renamed from: g */
    public boolean m15286g() {
        return this.f16005b != null;
    }

    /* renamed from: h */
    public boolean m15287h() {
        return this.f16000a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15288i() {
        return this.f15999a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        EnumC4239gf enumC4239gf = this.f15998a;
        if (enumC4239gf == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(enumC4239gf);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f16004a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f16006b);
        if (m15285f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f16001a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
        }
        if (m15286g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f16005b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        C4254gu c4254gu = this.f16000a;
        if (c4254gu == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(c4254gu);
        }
        if (m15288i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            C4252gs c4252gs = this.f15999a;
            if (c4252gs == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4252gs);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public C4262hb m15265a(EnumC4239gf enumC4239gf) {
        this.f15998a = enumC4239gf;
        return this;
    }

    /* renamed from: b */
    public C4262hb m15278b(boolean z) {
        this.f16006b = z;
        m15280b(true);
        return this;
    }

    /* renamed from: a */
    public boolean m15274a() {
        return this.f15998a != null;
    }

    /* renamed from: a */
    public C4262hb m15270a(boolean z) {
        this.f16004a = z;
        m15273a(true);
        return this;
    }

    /* renamed from: b */
    public void m15280b(boolean z) {
        this.f16003a.set(1, z);
    }

    /* renamed from: b */
    public String m15279b() {
        return this.f16005b;
    }

    /* renamed from: a */
    public void m15273a(boolean z) {
        this.f16003a.set(0, z);
    }

    /* renamed from: b */
    public C4262hb m15277b(String str) {
        this.f16005b = str;
        return this;
    }

    /* renamed from: a */
    public byte[] m15276a() {
        m15269a(C4278hr.m15581a(this.f16002a));
        return this.f16002a.array();
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15272a();
        abstractC4288ia.mo15610a(f15990a);
        if (this.f15998a != null) {
            abstractC4288ia.mo15607a(f15989a);
            abstractC4288ia.mo15605a(this.f15998a.m14968a());
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f15991b);
        abstractC4288ia.mo15614a(this.f16004a);
        abstractC4288ia.mo15616b();
        abstractC4288ia.mo15607a(f15992c);
        abstractC4288ia.mo15614a(this.f16006b);
        abstractC4288ia.mo15616b();
        if (this.f16002a != null) {
            abstractC4288ia.mo15607a(f15993d);
            abstractC4288ia.mo15612a(this.f16002a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16001a != null && m15285f()) {
            abstractC4288ia.mo15607a(f15994e);
            abstractC4288ia.mo15611a(this.f16001a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16005b != null && m15286g()) {
            abstractC4288ia.mo15607a(f15995f);
            abstractC4288ia.mo15611a(this.f16005b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16000a != null) {
            abstractC4288ia.mo15607a(f15996g);
            this.f16000a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15999a != null && m15288i()) {
            abstractC4288ia.mo15607a(f15997h);
            this.f15999a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public C4262hb m15269a(ByteBuffer byteBuffer) {
        this.f16002a = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public String m15271a() {
        return this.f16001a;
    }

    /* renamed from: a */
    public C4262hb m15268a(String str) {
        this.f16001a = str;
        return this;
    }

    /* renamed from: a */
    public C4262hb m15267a(C4254gu c4254gu) {
        this.f16000a = c4254gu;
        return this;
    }

    /* renamed from: a */
    public C4252gs m15264a() {
        return this.f15999a;
    }

    /* renamed from: a */
    public C4262hb m15266a(C4252gs c4252gs) {
        this.f15999a = c4252gs;
        return this;
    }

    /* renamed from: a */
    public boolean m15275a(C4262hb c4262hb) {
        if (c4262hb == null) {
            return false;
        }
        boolean m15274a = m15274a();
        boolean m15274a2 = c4262hb.m15274a();
        if (((m15274a || m15274a2) && (!m15274a || !m15274a2 || !this.f15998a.equals(c4262hb.f15998a))) || this.f16004a != c4262hb.f16004a || this.f16006b != c4262hb.f16006b) {
            return false;
        }
        boolean m15284e = m15284e();
        boolean m15284e2 = c4262hb.m15284e();
        if ((m15284e || m15284e2) && !(m15284e && m15284e2 && this.f16002a.equals(c4262hb.f16002a))) {
            return false;
        }
        boolean m15285f = m15285f();
        boolean m15285f2 = c4262hb.m15285f();
        if ((m15285f || m15285f2) && !(m15285f && m15285f2 && this.f16001a.equals(c4262hb.f16001a))) {
            return false;
        }
        boolean m15286g = m15286g();
        boolean m15286g2 = c4262hb.m15286g();
        if ((m15286g || m15286g2) && !(m15286g && m15286g2 && this.f16005b.equals(c4262hb.f16005b))) {
            return false;
        }
        boolean m15287h = m15287h();
        boolean m15287h2 = c4262hb.m15287h();
        if ((m15287h || m15287h2) && !(m15287h && m15287h2 && this.f16000a.m15138a(c4262hb.f16000a))) {
            return false;
        }
        boolean m15288i = m15288i();
        boolean m15288i2 = c4262hb.m15288i();
        if (m15288i || m15288i2) {
            return m15288i && m15288i2 && this.f15999a.m15102a(c4262hb.f15999a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4262hb c4262hb) {
        int m15571a;
        int m15571a2;
        int m15572a;
        int m15572a2;
        int m15571a3;
        int m15578a;
        int m15578a2;
        int m15571a4;
        if (!C4262hb.class.equals(c4262hb.getClass())) {
            return C4262hb.class.getName().compareTo(c4262hb.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15274a()).compareTo(Boolean.valueOf(c4262hb.m15274a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15274a() && (m15571a4 = C4278hr.m15571a(this.f15998a, c4262hb.f15998a)) != 0) {
            return m15571a4;
        }
        int compareTo2 = Boolean.valueOf(m15282c()).compareTo(Boolean.valueOf(c4262hb.m15282c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15282c() && (m15578a2 = C4278hr.m15578a(this.f16004a, c4262hb.f16004a)) != 0) {
            return m15578a2;
        }
        int compareTo3 = Boolean.valueOf(m15283d()).compareTo(Boolean.valueOf(c4262hb.m15283d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15283d() && (m15578a = C4278hr.m15578a(this.f16006b, c4262hb.f16006b)) != 0) {
            return m15578a;
        }
        int compareTo4 = Boolean.valueOf(m15284e()).compareTo(Boolean.valueOf(c4262hb.m15284e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15284e() && (m15571a3 = C4278hr.m15571a(this.f16002a, c4262hb.f16002a)) != 0) {
            return m15571a3;
        }
        int compareTo5 = Boolean.valueOf(m15285f()).compareTo(Boolean.valueOf(c4262hb.m15285f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15285f() && (m15572a2 = C4278hr.m15572a(this.f16001a, c4262hb.f16001a)) != 0) {
            return m15572a2;
        }
        int compareTo6 = Boolean.valueOf(m15286g()).compareTo(Boolean.valueOf(c4262hb.m15286g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15286g() && (m15572a = C4278hr.m15572a(this.f16005b, c4262hb.f16005b)) != 0) {
            return m15572a;
        }
        int compareTo7 = Boolean.valueOf(m15287h()).compareTo(Boolean.valueOf(c4262hb.m15287h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15287h() && (m15571a2 = C4278hr.m15571a(this.f16000a, c4262hb.f16000a)) != 0) {
            return m15571a2;
        }
        int compareTo8 = Boolean.valueOf(m15288i()).compareTo(Boolean.valueOf(c4262hb.m15288i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!m15288i() || (m15571a = C4278hr.m15571a(this.f15999a, c4262hb.f15999a)) == 0) {
            return 0;
        }
        return m15571a;
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
                if (m15282c()) {
                    if (m15283d()) {
                        m15272a();
                        return;
                    }
                    throw new C4289ib("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new C4289ib("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 8) {
                        this.f15998a = EnumC4239gf.m14967a(abstractC4288ia.mo15592a());
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 2) {
                        this.f16004a = abstractC4288ia.mo15615a();
                        m15273a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f16006b = abstractC4288ia.mo15615a();
                        m15280b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16002a = abstractC4288ia.mo15601a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16001a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f16005b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 12) {
                        this.f16000a = new C4254gu();
                        this.f16000a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f15999a = new C4252gs();
                        this.f15999a.mo14606a(abstractC4288ia);
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
    public void m15272a() {
        if (this.f15998a != null) {
            if (this.f16002a != null) {
                if (this.f16000a != null) {
                    return;
                }
                throw new C4289ib("Required field 'target' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'action' was not present! Struct: " + toString());
    }
}
