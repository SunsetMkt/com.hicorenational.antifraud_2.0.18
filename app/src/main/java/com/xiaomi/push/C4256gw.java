package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gw */
/* loaded from: classes2.dex */
public class C4256gw implements InterfaceC4277hq<C4256gw, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C4254gu f15925a;

    /* renamed from: a */
    public String f15926a;

    /* renamed from: a */
    public Map<String, String> f15928a;

    /* renamed from: b */
    public String f15929b;

    /* renamed from: c */
    public String f15930c;

    /* renamed from: d */
    public String f15931d;

    /* renamed from: e */
    public String f15932e;

    /* renamed from: f */
    public String f15933f;

    /* renamed from: g */
    public String f15934g;

    /* renamed from: a */
    private static final C4293if f15914a = new C4293if("XmPushActionAckNotification");

    /* renamed from: a */
    private static final C4284hx f15913a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f15915b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f15916c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f15917d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15918e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f15919f = new C4284hx("", (byte) 10, 7);

    /* renamed from: g */
    private static final C4284hx f15920g = new C4284hx("", (byte) 11, 8);

    /* renamed from: h */
    private static final C4284hx f15921h = new C4284hx("", C3393cw.f11871k, 9);

    /* renamed from: i */
    private static final C4284hx f15922i = new C4284hx("", (byte) 11, 10);

    /* renamed from: j */
    private static final C4284hx f15923j = new C4284hx("", (byte) 11, 11);

    /* renamed from: a */
    private BitSet f15927a = new BitSet(1);

    /* renamed from: a */
    public long f15924a = 0;

    /* renamed from: a */
    public boolean m15187a() {
        return this.f15926a != null;
    }

    /* renamed from: b */
    public boolean m15191b() {
        return this.f15925a != null;
    }

    /* renamed from: c */
    public boolean m15193c() {
        return this.f15929b != null;
    }

    /* renamed from: d */
    public boolean m15195d() {
        return this.f15930c != null;
    }

    /* renamed from: e */
    public boolean m15197e() {
        return this.f15931d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4256gw)) {
            return m15188a((C4256gw) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15198f() {
        return this.f15927a.get(0);
    }

    /* renamed from: g */
    public boolean m15199g() {
        return this.f15932e != null;
    }

    /* renamed from: h */
    public boolean m15200h() {
        return this.f15928a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15201i() {
        return this.f15933f != null;
    }

    /* renamed from: j */
    public boolean m15202j() {
        return this.f15934g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        if (m15187a()) {
            sb.append("debug:");
            String str = this.f15926a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15191b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f15925a;
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
        String str2 = this.f15929b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        if (m15195d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f15930c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m15197e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f15931d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15198f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f15924a);
        }
        if (m15199g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f15932e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15200h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f15928a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
        }
        if (m15201i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f15933f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15202j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f15934g;
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
    public C4256gw m15181a(C4254gu c4254gu) {
        this.f15925a = c4254gu;
        return this;
    }

    /* renamed from: b */
    public C4256gw m15189b(String str) {
        this.f15930c = str;
        return this;
    }

    /* renamed from: c */
    public C4256gw m15192c(String str) {
        this.f15931d = str;
        return this;
    }

    /* renamed from: d */
    public C4256gw m15194d(String str) {
        this.f15932e = str;
        return this;
    }

    /* renamed from: e */
    public C4256gw m15196e(String str) {
        this.f15933f = str;
        return this;
    }

    /* renamed from: a */
    public String m15183a() {
        return this.f15929b;
    }

    /* renamed from: b */
    public String m15190b() {
        return this.f15931d;
    }

    /* renamed from: a */
    public C4256gw m15182a(String str) {
        this.f15929b = str;
        return this;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15185a();
        abstractC4288ia.mo15610a(f15914a);
        if (this.f15926a != null && m15187a()) {
            abstractC4288ia.mo15607a(f15913a);
            abstractC4288ia.mo15611a(this.f15926a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15925a != null && m15191b()) {
            abstractC4288ia.mo15607a(f15915b);
            this.f15925a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15929b != null) {
            abstractC4288ia.mo15607a(f15916c);
            abstractC4288ia.mo15611a(this.f15929b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15930c != null && m15195d()) {
            abstractC4288ia.mo15607a(f15917d);
            abstractC4288ia.mo15611a(this.f15930c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15931d != null && m15197e()) {
            abstractC4288ia.mo15607a(f15918e);
            abstractC4288ia.mo15611a(this.f15931d);
            abstractC4288ia.mo15616b();
        }
        if (m15198f()) {
            abstractC4288ia.mo15607a(f15919f);
            abstractC4288ia.mo15606a(this.f15924a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15932e != null && m15199g()) {
            abstractC4288ia.mo15607a(f15920g);
            abstractC4288ia.mo15611a(this.f15932e);
            abstractC4288ia.mo15616b();
        }
        if (this.f15928a != null && m15200h()) {
            abstractC4288ia.mo15607a(f15921h);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f15928a.size()));
            for (Map.Entry<String, String> entry : this.f15928a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (this.f15933f != null && m15201i()) {
            abstractC4288ia.mo15607a(f15922i);
            abstractC4288ia.mo15611a(this.f15933f);
            abstractC4288ia.mo15616b();
        }
        if (this.f15934g != null && m15202j()) {
            abstractC4288ia.mo15607a(f15923j);
            abstractC4288ia.mo15611a(this.f15934g);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public C4256gw m15180a(long j2) {
        this.f15924a = j2;
        m15186a(true);
        return this;
    }

    /* renamed from: a */
    public void m15186a(boolean z) {
        this.f15927a.set(0, z);
    }

    /* renamed from: a */
    public Map<String, String> m15184a() {
        return this.f15928a;
    }

    /* renamed from: a */
    public boolean m15188a(C4256gw c4256gw) {
        if (c4256gw == null) {
            return false;
        }
        boolean m15187a = m15187a();
        boolean m15187a2 = c4256gw.m15187a();
        if ((m15187a || m15187a2) && !(m15187a && m15187a2 && this.f15926a.equals(c4256gw.f15926a))) {
            return false;
        }
        boolean m15191b = m15191b();
        boolean m15191b2 = c4256gw.m15191b();
        if ((m15191b || m15191b2) && !(m15191b && m15191b2 && this.f15925a.m15138a(c4256gw.f15925a))) {
            return false;
        }
        boolean m15193c = m15193c();
        boolean m15193c2 = c4256gw.m15193c();
        if ((m15193c || m15193c2) && !(m15193c && m15193c2 && this.f15929b.equals(c4256gw.f15929b))) {
            return false;
        }
        boolean m15195d = m15195d();
        boolean m15195d2 = c4256gw.m15195d();
        if ((m15195d || m15195d2) && !(m15195d && m15195d2 && this.f15930c.equals(c4256gw.f15930c))) {
            return false;
        }
        boolean m15197e = m15197e();
        boolean m15197e2 = c4256gw.m15197e();
        if ((m15197e || m15197e2) && !(m15197e && m15197e2 && this.f15931d.equals(c4256gw.f15931d))) {
            return false;
        }
        boolean m15198f = m15198f();
        boolean m15198f2 = c4256gw.m15198f();
        if ((m15198f || m15198f2) && !(m15198f && m15198f2 && this.f15924a == c4256gw.f15924a)) {
            return false;
        }
        boolean m15199g = m15199g();
        boolean m15199g2 = c4256gw.m15199g();
        if ((m15199g || m15199g2) && !(m15199g && m15199g2 && this.f15932e.equals(c4256gw.f15932e))) {
            return false;
        }
        boolean m15200h = m15200h();
        boolean m15200h2 = c4256gw.m15200h();
        if ((m15200h || m15200h2) && !(m15200h && m15200h2 && this.f15928a.equals(c4256gw.f15928a))) {
            return false;
        }
        boolean m15201i = m15201i();
        boolean m15201i2 = c4256gw.m15201i();
        if ((m15201i || m15201i2) && !(m15201i && m15201i2 && this.f15933f.equals(c4256gw.f15933f))) {
            return false;
        }
        boolean m15202j = m15202j();
        boolean m15202j2 = c4256gw.m15202j();
        if (m15202j || m15202j2) {
            return m15202j && m15202j2 && this.f15934g.equals(c4256gw.f15934g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4256gw c4256gw) {
        int m15572a;
        int m15572a2;
        int m15575a;
        int m15572a3;
        int m15570a;
        int m15572a4;
        int m15572a5;
        int m15572a6;
        int m15571a;
        int m15572a7;
        if (!C4256gw.class.equals(c4256gw.getClass())) {
            return C4256gw.class.getName().compareTo(c4256gw.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15187a()).compareTo(Boolean.valueOf(c4256gw.m15187a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15187a() && (m15572a7 = C4278hr.m15572a(this.f15926a, c4256gw.f15926a)) != 0) {
            return m15572a7;
        }
        int compareTo2 = Boolean.valueOf(m15191b()).compareTo(Boolean.valueOf(c4256gw.m15191b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15191b() && (m15571a = C4278hr.m15571a(this.f15925a, c4256gw.f15925a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15193c()).compareTo(Boolean.valueOf(c4256gw.m15193c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15193c() && (m15572a6 = C4278hr.m15572a(this.f15929b, c4256gw.f15929b)) != 0) {
            return m15572a6;
        }
        int compareTo4 = Boolean.valueOf(m15195d()).compareTo(Boolean.valueOf(c4256gw.m15195d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15195d() && (m15572a5 = C4278hr.m15572a(this.f15930c, c4256gw.f15930c)) != 0) {
            return m15572a5;
        }
        int compareTo5 = Boolean.valueOf(m15197e()).compareTo(Boolean.valueOf(c4256gw.m15197e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15197e() && (m15572a4 = C4278hr.m15572a(this.f15931d, c4256gw.f15931d)) != 0) {
            return m15572a4;
        }
        int compareTo6 = Boolean.valueOf(m15198f()).compareTo(Boolean.valueOf(c4256gw.m15198f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15198f() && (m15570a = C4278hr.m15570a(this.f15924a, c4256gw.f15924a)) != 0) {
            return m15570a;
        }
        int compareTo7 = Boolean.valueOf(m15199g()).compareTo(Boolean.valueOf(c4256gw.m15199g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15199g() && (m15572a3 = C4278hr.m15572a(this.f15932e, c4256gw.f15932e)) != 0) {
            return m15572a3;
        }
        int compareTo8 = Boolean.valueOf(m15200h()).compareTo(Boolean.valueOf(c4256gw.m15200h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15200h() && (m15575a = C4278hr.m15575a(this.f15928a, c4256gw.f15928a)) != 0) {
            return m15575a;
        }
        int compareTo9 = Boolean.valueOf(m15201i()).compareTo(Boolean.valueOf(c4256gw.m15201i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15201i() && (m15572a2 = C4278hr.m15572a(this.f15933f, c4256gw.f15933f)) != 0) {
            return m15572a2;
        }
        int compareTo10 = Boolean.valueOf(m15202j()).compareTo(Boolean.valueOf(c4256gw.m15202j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m15202j() || (m15572a = C4278hr.m15572a(this.f15934g, c4256gw.f15934g)) == 0) {
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
                m15185a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f15926a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f15925a = new C4254gu();
                        this.f15925a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f15929b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f15930c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f15931d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f15924a = abstractC4288ia.mo15593a();
                        m15186a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f15932e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 13) {
                        C4286hz mo15596a = abstractC4288ia.mo15596a();
                        this.f15928a = new HashMap(mo15596a.f16337a * 2);
                        for (int i2 = 0; i2 < mo15596a.f16337a; i2++) {
                            this.f15928a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f15933f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f15934g = abstractC4288ia.mo15599a();
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
    public void m15185a() {
        if (this.f15929b != null) {
            return;
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
