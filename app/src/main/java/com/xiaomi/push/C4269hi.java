package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hi */
/* loaded from: classes2.dex */
public class C4269hi implements InterfaceC4277hq<C4269hi, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C4251gr f16176a;

    /* renamed from: a */
    public C4254gu f16177a;

    /* renamed from: a */
    public String f16178a;

    /* renamed from: a */
    public Map<String, String> f16180a;

    /* renamed from: b */
    public String f16182b;

    /* renamed from: c */
    public String f16183c;

    /* renamed from: d */
    public String f16184d;

    /* renamed from: e */
    public String f16185e;

    /* renamed from: f */
    public String f16186f;

    /* renamed from: g */
    public String f16187g;

    /* renamed from: h */
    public String f16188h;

    /* renamed from: a */
    private static final C4293if f16164a = new C4293if("XmPushActionSendMessage");

    /* renamed from: a */
    private static final C4284hx f16163a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16165b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16166c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16167d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16168e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f16169f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f16170g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f16171h = new C4284hx("", (byte) 12, 8);

    /* renamed from: i */
    private static final C4284hx f16172i = new C4284hx("", (byte) 2, 9);

    /* renamed from: j */
    private static final C4284hx f16173j = new C4284hx("", C3393cw.f11871k, 10);

    /* renamed from: k */
    private static final C4284hx f16174k = new C4284hx("", (byte) 11, 11);

    /* renamed from: l */
    private static final C4284hx f16175l = new C4284hx("", (byte) 11, 12);

    /* renamed from: a */
    private BitSet f16179a = new BitSet(1);

    /* renamed from: a */
    public boolean f16181a = true;

    /* renamed from: a */
    public boolean m15442a() {
        return this.f16178a != null;
    }

    /* renamed from: b */
    public boolean m15445b() {
        return this.f16177a != null;
    }

    /* renamed from: c */
    public boolean m15447c() {
        return this.f16182b != null;
    }

    /* renamed from: d */
    public boolean m15449d() {
        return this.f16183c != null;
    }

    /* renamed from: e */
    public boolean m15451e() {
        return this.f16184d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4269hi)) {
            return m15443a((C4269hi) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15453f() {
        return this.f16185e != null;
    }

    /* renamed from: g */
    public boolean m15454g() {
        return this.f16186f != null;
    }

    /* renamed from: h */
    public boolean m15455h() {
        return this.f16176a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15456i() {
        return this.f16179a.get(0);
    }

    /* renamed from: j */
    public boolean m15457j() {
        return this.f16180a != null;
    }

    /* renamed from: k */
    public boolean m15458k() {
        return this.f16187g != null;
    }

    /* renamed from: l */
    public boolean m15459l() {
        return this.f16188h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        if (m15442a()) {
            sb.append("debug:");
            String str = this.f16178a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15445b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16177a;
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
        String str2 = this.f16182b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16183c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        if (m15451e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f16184d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15453f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f16185e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15454g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f16186f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15455h()) {
            sb.append(", ");
            sb.append("message:");
            C4251gr c4251gr = this.f16176a;
            if (c4251gr == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4251gr);
            }
        }
        if (m15456i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f16181a);
        }
        if (m15457j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f16180a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
        }
        if (m15458k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f16187g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15459l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f16188h;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public String m15439a() {
        return this.f16182b;
    }

    /* renamed from: b */
    public String m15444b() {
        return this.f16183c;
    }

    /* renamed from: c */
    public String m15446c() {
        return this.f16185e;
    }

    /* renamed from: d */
    public String m15448d() {
        return this.f16186f;
    }

    /* renamed from: e */
    public String m15450e() {
        return this.f16187g;
    }

    /* renamed from: f */
    public String m15452f() {
        return this.f16188h;
    }

    /* renamed from: a */
    public C4251gr m15438a() {
        return this.f16176a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15440a();
        abstractC4288ia.mo15610a(f16164a);
        if (this.f16178a != null && m15442a()) {
            abstractC4288ia.mo15607a(f16163a);
            abstractC4288ia.mo15611a(this.f16178a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16177a != null && m15445b()) {
            abstractC4288ia.mo15607a(f16165b);
            this.f16177a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16182b != null) {
            abstractC4288ia.mo15607a(f16166c);
            abstractC4288ia.mo15611a(this.f16182b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16183c != null) {
            abstractC4288ia.mo15607a(f16167d);
            abstractC4288ia.mo15611a(this.f16183c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16184d != null && m15451e()) {
            abstractC4288ia.mo15607a(f16168e);
            abstractC4288ia.mo15611a(this.f16184d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16185e != null && m15453f()) {
            abstractC4288ia.mo15607a(f16169f);
            abstractC4288ia.mo15611a(this.f16185e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16186f != null && m15454g()) {
            abstractC4288ia.mo15607a(f16170g);
            abstractC4288ia.mo15611a(this.f16186f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16176a != null && m15455h()) {
            abstractC4288ia.mo15607a(f16171h);
            this.f16176a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (m15456i()) {
            abstractC4288ia.mo15607a(f16172i);
            abstractC4288ia.mo15614a(this.f16181a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16180a != null && m15457j()) {
            abstractC4288ia.mo15607a(f16173j);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f16180a.size()));
            for (Map.Entry<String, String> entry : this.f16180a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (this.f16187g != null && m15458k()) {
            abstractC4288ia.mo15607a(f16174k);
            abstractC4288ia.mo15611a(this.f16187g);
            abstractC4288ia.mo15616b();
        }
        if (this.f16188h != null && m15459l()) {
            abstractC4288ia.mo15607a(f16175l);
            abstractC4288ia.mo15611a(this.f16188h);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public void m15441a(boolean z) {
        this.f16179a.set(0, z);
    }

    /* renamed from: a */
    public boolean m15443a(C4269hi c4269hi) {
        if (c4269hi == null) {
            return false;
        }
        boolean m15442a = m15442a();
        boolean m15442a2 = c4269hi.m15442a();
        if ((m15442a || m15442a2) && !(m15442a && m15442a2 && this.f16178a.equals(c4269hi.f16178a))) {
            return false;
        }
        boolean m15445b = m15445b();
        boolean m15445b2 = c4269hi.m15445b();
        if ((m15445b || m15445b2) && !(m15445b && m15445b2 && this.f16177a.m15138a(c4269hi.f16177a))) {
            return false;
        }
        boolean m15447c = m15447c();
        boolean m15447c2 = c4269hi.m15447c();
        if ((m15447c || m15447c2) && !(m15447c && m15447c2 && this.f16182b.equals(c4269hi.f16182b))) {
            return false;
        }
        boolean m15449d = m15449d();
        boolean m15449d2 = c4269hi.m15449d();
        if ((m15449d || m15449d2) && !(m15449d && m15449d2 && this.f16183c.equals(c4269hi.f16183c))) {
            return false;
        }
        boolean m15451e = m15451e();
        boolean m15451e2 = c4269hi.m15451e();
        if ((m15451e || m15451e2) && !(m15451e && m15451e2 && this.f16184d.equals(c4269hi.f16184d))) {
            return false;
        }
        boolean m15453f = m15453f();
        boolean m15453f2 = c4269hi.m15453f();
        if ((m15453f || m15453f2) && !(m15453f && m15453f2 && this.f16185e.equals(c4269hi.f16185e))) {
            return false;
        }
        boolean m15454g = m15454g();
        boolean m15454g2 = c4269hi.m15454g();
        if ((m15454g || m15454g2) && !(m15454g && m15454g2 && this.f16186f.equals(c4269hi.f16186f))) {
            return false;
        }
        boolean m15455h = m15455h();
        boolean m15455h2 = c4269hi.m15455h();
        if ((m15455h || m15455h2) && !(m15455h && m15455h2 && this.f16176a.m15066a(c4269hi.f16176a))) {
            return false;
        }
        boolean m15456i = m15456i();
        boolean m15456i2 = c4269hi.m15456i();
        if ((m15456i || m15456i2) && !(m15456i && m15456i2 && this.f16181a == c4269hi.f16181a)) {
            return false;
        }
        boolean m15457j = m15457j();
        boolean m15457j2 = c4269hi.m15457j();
        if ((m15457j || m15457j2) && !(m15457j && m15457j2 && this.f16180a.equals(c4269hi.f16180a))) {
            return false;
        }
        boolean m15458k = m15458k();
        boolean m15458k2 = c4269hi.m15458k();
        if ((m15458k || m15458k2) && !(m15458k && m15458k2 && this.f16187g.equals(c4269hi.f16187g))) {
            return false;
        }
        boolean m15459l = m15459l();
        boolean m15459l2 = c4269hi.m15459l();
        if (m15459l || m15459l2) {
            return m15459l && m15459l2 && this.f16188h.equals(c4269hi.f16188h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4269hi c4269hi) {
        int m15572a;
        int m15572a2;
        int m15575a;
        int m15578a;
        int m15571a;
        int m15572a3;
        int m15572a4;
        int m15572a5;
        int m15572a6;
        int m15572a7;
        int m15571a2;
        int m15572a8;
        if (!C4269hi.class.equals(c4269hi.getClass())) {
            return C4269hi.class.getName().compareTo(c4269hi.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15442a()).compareTo(Boolean.valueOf(c4269hi.m15442a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15442a() && (m15572a8 = C4278hr.m15572a(this.f16178a, c4269hi.f16178a)) != 0) {
            return m15572a8;
        }
        int compareTo2 = Boolean.valueOf(m15445b()).compareTo(Boolean.valueOf(c4269hi.m15445b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15445b() && (m15571a2 = C4278hr.m15571a(this.f16177a, c4269hi.f16177a)) != 0) {
            return m15571a2;
        }
        int compareTo3 = Boolean.valueOf(m15447c()).compareTo(Boolean.valueOf(c4269hi.m15447c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15447c() && (m15572a7 = C4278hr.m15572a(this.f16182b, c4269hi.f16182b)) != 0) {
            return m15572a7;
        }
        int compareTo4 = Boolean.valueOf(m15449d()).compareTo(Boolean.valueOf(c4269hi.m15449d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15449d() && (m15572a6 = C4278hr.m15572a(this.f16183c, c4269hi.f16183c)) != 0) {
            return m15572a6;
        }
        int compareTo5 = Boolean.valueOf(m15451e()).compareTo(Boolean.valueOf(c4269hi.m15451e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15451e() && (m15572a5 = C4278hr.m15572a(this.f16184d, c4269hi.f16184d)) != 0) {
            return m15572a5;
        }
        int compareTo6 = Boolean.valueOf(m15453f()).compareTo(Boolean.valueOf(c4269hi.m15453f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15453f() && (m15572a4 = C4278hr.m15572a(this.f16185e, c4269hi.f16185e)) != 0) {
            return m15572a4;
        }
        int compareTo7 = Boolean.valueOf(m15454g()).compareTo(Boolean.valueOf(c4269hi.m15454g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15454g() && (m15572a3 = C4278hr.m15572a(this.f16186f, c4269hi.f16186f)) != 0) {
            return m15572a3;
        }
        int compareTo8 = Boolean.valueOf(m15455h()).compareTo(Boolean.valueOf(c4269hi.m15455h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15455h() && (m15571a = C4278hr.m15571a(this.f16176a, c4269hi.f16176a)) != 0) {
            return m15571a;
        }
        int compareTo9 = Boolean.valueOf(m15456i()).compareTo(Boolean.valueOf(c4269hi.m15456i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15456i() && (m15578a = C4278hr.m15578a(this.f16181a, c4269hi.f16181a)) != 0) {
            return m15578a;
        }
        int compareTo10 = Boolean.valueOf(m15457j()).compareTo(Boolean.valueOf(c4269hi.m15457j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15457j() && (m15575a = C4278hr.m15575a(this.f16180a, c4269hi.f16180a)) != 0) {
            return m15575a;
        }
        int compareTo11 = Boolean.valueOf(m15458k()).compareTo(Boolean.valueOf(c4269hi.m15458k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15458k() && (m15572a2 = C4278hr.m15572a(this.f16187g, c4269hi.f16187g)) != 0) {
            return m15572a2;
        }
        int compareTo12 = Boolean.valueOf(m15459l()).compareTo(Boolean.valueOf(c4269hi.m15459l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!m15459l() || (m15572a = C4278hr.m15572a(this.f16188h, c4269hi.f16188h)) == 0) {
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
                m15440a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16178a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16177a = new C4254gu();
                        this.f16177a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16182b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16183c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16184d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f16185e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16186f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f16176a = new C4251gr();
                        this.f16176a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 2) {
                        this.f16181a = abstractC4288ia.mo15615a();
                        m15441a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        C4286hz mo15596a = abstractC4288ia.mo15596a();
                        this.f16180a = new HashMap(mo15596a.f16337a * 2);
                        for (int i2 = 0; i2 < mo15596a.f16337a; i2++) {
                            this.f16180a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f16187g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f16188h = abstractC4288ia.mo15599a();
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
    public void m15440a() {
        if (this.f16182b != null) {
            if (this.f16183c != null) {
                return;
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
