package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gj */
/* loaded from: classes2.dex */
public class C4243gj implements InterfaceC4277hq<C4243gj, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f15537a;

    /* renamed from: a */
    public String f15538a;

    /* renamed from: a */
    private BitSet f15539a = new BitSet(3);

    /* renamed from: a */
    public Map<String, String> f15540a;

    /* renamed from: a */
    public boolean f15541a;

    /* renamed from: b */
    public long f15542b;

    /* renamed from: b */
    public String f15543b;

    /* renamed from: c */
    public String f15544c;

    /* renamed from: d */
    public String f15545d;

    /* renamed from: e */
    public String f15546e;

    /* renamed from: f */
    public String f15547f;

    /* renamed from: g */
    public String f15548g;

    /* renamed from: a */
    private static final C4293if f15526a = new C4293if("ClientUploadDataItem");

    /* renamed from: a */
    private static final C4284hx f15525a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f15527b = new C4284hx("", (byte) 11, 2);

    /* renamed from: c */
    private static final C4284hx f15528c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f15529d = new C4284hx("", (byte) 10, 4);

    /* renamed from: e */
    private static final C4284hx f15530e = new C4284hx("", (byte) 10, 5);

    /* renamed from: f */
    private static final C4284hx f15531f = new C4284hx("", (byte) 2, 6);

    /* renamed from: g */
    private static final C4284hx f15532g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f15533h = new C4284hx("", (byte) 11, 8);

    /* renamed from: i */
    private static final C4284hx f15534i = new C4284hx("", (byte) 11, 9);

    /* renamed from: j */
    private static final C4284hx f15535j = new C4284hx("", C3393cw.f11871k, 10);

    /* renamed from: k */
    private static final C4284hx f15536k = new C4284hx("", (byte) 11, 11);

    /* renamed from: a */
    public String m14984a() {
        return this.f15538a;
    }

    /* renamed from: a */
    public void m14986a() {
    }

    /* renamed from: b */
    public C4243gj m14992b(String str) {
        this.f15543b = str;
        return this;
    }

    /* renamed from: c */
    public C4243gj m14996c(String str) {
        this.f15544c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m15002d() {
        return this.f15539a.get(0);
    }

    /* renamed from: e */
    public boolean m15005e() {
        return this.f15539a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4243gj)) {
            return m14990a((C4243gj) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15007f() {
        return this.f15539a.get(2);
    }

    /* renamed from: g */
    public boolean m15009g() {
        return this.f15545d != null;
    }

    /* renamed from: h */
    public boolean m15010h() {
        return this.f15546e != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15011i() {
        return this.f15547f != null;
    }

    /* renamed from: j */
    public boolean m15012j() {
        return this.f15540a != null;
    }

    /* renamed from: k */
    public boolean m15013k() {
        return this.f15548g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (m14989a()) {
            sb.append("channel:");
            String str = this.f15538a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m14995b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f15543b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m14999c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f15544c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m15002d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f15537a);
            z = false;
        }
        if (m15005e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f15542b);
            z = false;
        }
        if (m15007f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f15541a);
            z = false;
        }
        if (m15009g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f15545d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (m15010h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f15546e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (m15011i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f15547f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (m15012j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f15540a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
            z = false;
        }
        if (m15013k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f15548g;
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
    public C4243gj m14981a(String str) {
        this.f15538a = str;
        return this;
    }

    /* renamed from: b */
    public boolean m14995b() {
        return this.f15543b != null;
    }

    /* renamed from: c */
    public boolean m14999c() {
        return this.f15544c != null;
    }

    /* renamed from: d */
    public C4243gj m15000d(String str) {
        this.f15545d = str;
        return this;
    }

    /* renamed from: e */
    public C4243gj m15003e(String str) {
        this.f15546e = str;
        return this;
    }

    /* renamed from: f */
    public C4243gj m15006f(String str) {
        this.f15547f = str;
        return this;
    }

    /* renamed from: g */
    public C4243gj m15008g(String str) {
        this.f15548g = str;
        return this;
    }

    /* renamed from: a */
    public boolean m14989a() {
        return this.f15538a != null;
    }

    /* renamed from: b */
    public String m14993b() {
        return this.f15544c;
    }

    /* renamed from: c */
    public void m14998c(boolean z) {
        this.f15539a.set(2, z);
    }

    /* renamed from: d */
    public String m15001d() {
        return this.f15547f;
    }

    /* renamed from: e */
    public String m15004e() {
        return this.f15548g;
    }

    /* renamed from: a */
    public C4243gj m14980a(long j2) {
        this.f15537a = j2;
        m14988a(true);
        return this;
    }

    /* renamed from: b */
    public C4243gj m14991b(long j2) {
        this.f15542b = j2;
        m14994b(true);
        return this;
    }

    /* renamed from: c */
    public String m14997c() {
        return this.f15546e;
    }

    /* renamed from: a */
    public void m14988a(boolean z) {
        this.f15539a.set(0, z);
    }

    /* renamed from: b */
    public void m14994b(boolean z) {
        this.f15539a.set(1, z);
    }

    /* renamed from: a */
    public long m14979a() {
        return this.f15542b;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m14986a();
        abstractC4288ia.mo15610a(f15526a);
        if (this.f15538a != null && m14989a()) {
            abstractC4288ia.mo15607a(f15525a);
            abstractC4288ia.mo15611a(this.f15538a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15543b != null && m14995b()) {
            abstractC4288ia.mo15607a(f15527b);
            abstractC4288ia.mo15611a(this.f15543b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15544c != null && m14999c()) {
            abstractC4288ia.mo15607a(f15528c);
            abstractC4288ia.mo15611a(this.f15544c);
            abstractC4288ia.mo15616b();
        }
        if (m15002d()) {
            abstractC4288ia.mo15607a(f15529d);
            abstractC4288ia.mo15606a(this.f15537a);
            abstractC4288ia.mo15616b();
        }
        if (m15005e()) {
            abstractC4288ia.mo15607a(f15530e);
            abstractC4288ia.mo15606a(this.f15542b);
            abstractC4288ia.mo15616b();
        }
        if (m15007f()) {
            abstractC4288ia.mo15607a(f15531f);
            abstractC4288ia.mo15614a(this.f15541a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15545d != null && m15009g()) {
            abstractC4288ia.mo15607a(f15532g);
            abstractC4288ia.mo15611a(this.f15545d);
            abstractC4288ia.mo15616b();
        }
        if (this.f15546e != null && m15010h()) {
            abstractC4288ia.mo15607a(f15533h);
            abstractC4288ia.mo15611a(this.f15546e);
            abstractC4288ia.mo15616b();
        }
        if (this.f15547f != null && m15011i()) {
            abstractC4288ia.mo15607a(f15534i);
            abstractC4288ia.mo15611a(this.f15547f);
            abstractC4288ia.mo15616b();
        }
        if (this.f15540a != null && m15012j()) {
            abstractC4288ia.mo15607a(f15535j);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f15540a.size()));
            for (Map.Entry<String, String> entry : this.f15540a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (this.f15548g != null && m15013k()) {
            abstractC4288ia.mo15607a(f15536k);
            abstractC4288ia.mo15611a(this.f15548g);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public C4243gj m14983a(boolean z) {
        this.f15541a = z;
        m14998c(true);
        return this;
    }

    /* renamed from: a */
    public void m14987a(String str, String str2) {
        if (this.f15540a == null) {
            this.f15540a = new HashMap();
        }
        this.f15540a.put(str, str2);
    }

    /* renamed from: a */
    public Map<String, String> m14985a() {
        return this.f15540a;
    }

    /* renamed from: a */
    public C4243gj m14982a(Map<String, String> map) {
        this.f15540a = map;
        return this;
    }

    /* renamed from: a */
    public boolean m14990a(C4243gj c4243gj) {
        if (c4243gj == null) {
            return false;
        }
        boolean m14989a = m14989a();
        boolean m14989a2 = c4243gj.m14989a();
        if ((m14989a || m14989a2) && !(m14989a && m14989a2 && this.f15538a.equals(c4243gj.f15538a))) {
            return false;
        }
        boolean m14995b = m14995b();
        boolean m14995b2 = c4243gj.m14995b();
        if ((m14995b || m14995b2) && !(m14995b && m14995b2 && this.f15543b.equals(c4243gj.f15543b))) {
            return false;
        }
        boolean m14999c = m14999c();
        boolean m14999c2 = c4243gj.m14999c();
        if ((m14999c || m14999c2) && !(m14999c && m14999c2 && this.f15544c.equals(c4243gj.f15544c))) {
            return false;
        }
        boolean m15002d = m15002d();
        boolean m15002d2 = c4243gj.m15002d();
        if ((m15002d || m15002d2) && !(m15002d && m15002d2 && this.f15537a == c4243gj.f15537a)) {
            return false;
        }
        boolean m15005e = m15005e();
        boolean m15005e2 = c4243gj.m15005e();
        if ((m15005e || m15005e2) && !(m15005e && m15005e2 && this.f15542b == c4243gj.f15542b)) {
            return false;
        }
        boolean m15007f = m15007f();
        boolean m15007f2 = c4243gj.m15007f();
        if ((m15007f || m15007f2) && !(m15007f && m15007f2 && this.f15541a == c4243gj.f15541a)) {
            return false;
        }
        boolean m15009g = m15009g();
        boolean m15009g2 = c4243gj.m15009g();
        if ((m15009g || m15009g2) && !(m15009g && m15009g2 && this.f15545d.equals(c4243gj.f15545d))) {
            return false;
        }
        boolean m15010h = m15010h();
        boolean m15010h2 = c4243gj.m15010h();
        if ((m15010h || m15010h2) && !(m15010h && m15010h2 && this.f15546e.equals(c4243gj.f15546e))) {
            return false;
        }
        boolean m15011i = m15011i();
        boolean m15011i2 = c4243gj.m15011i();
        if ((m15011i || m15011i2) && !(m15011i && m15011i2 && this.f15547f.equals(c4243gj.f15547f))) {
            return false;
        }
        boolean m15012j = m15012j();
        boolean m15012j2 = c4243gj.m15012j();
        if ((m15012j || m15012j2) && !(m15012j && m15012j2 && this.f15540a.equals(c4243gj.f15540a))) {
            return false;
        }
        boolean m15013k = m15013k();
        boolean m15013k2 = c4243gj.m15013k();
        if (m15013k || m15013k2) {
            return m15013k && m15013k2 && this.f15548g.equals(c4243gj.f15548g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4243gj c4243gj) {
        int m15572a;
        int m15575a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15578a;
        int m15570a;
        int m15570a2;
        int m15572a5;
        int m15572a6;
        int m15572a7;
        if (!C4243gj.class.equals(c4243gj.getClass())) {
            return C4243gj.class.getName().compareTo(c4243gj.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m14989a()).compareTo(Boolean.valueOf(c4243gj.m14989a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m14989a() && (m15572a7 = C4278hr.m15572a(this.f15538a, c4243gj.f15538a)) != 0) {
            return m15572a7;
        }
        int compareTo2 = Boolean.valueOf(m14995b()).compareTo(Boolean.valueOf(c4243gj.m14995b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m14995b() && (m15572a6 = C4278hr.m15572a(this.f15543b, c4243gj.f15543b)) != 0) {
            return m15572a6;
        }
        int compareTo3 = Boolean.valueOf(m14999c()).compareTo(Boolean.valueOf(c4243gj.m14999c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m14999c() && (m15572a5 = C4278hr.m15572a(this.f15544c, c4243gj.f15544c)) != 0) {
            return m15572a5;
        }
        int compareTo4 = Boolean.valueOf(m15002d()).compareTo(Boolean.valueOf(c4243gj.m15002d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15002d() && (m15570a2 = C4278hr.m15570a(this.f15537a, c4243gj.f15537a)) != 0) {
            return m15570a2;
        }
        int compareTo5 = Boolean.valueOf(m15005e()).compareTo(Boolean.valueOf(c4243gj.m15005e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15005e() && (m15570a = C4278hr.m15570a(this.f15542b, c4243gj.f15542b)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15007f()).compareTo(Boolean.valueOf(c4243gj.m15007f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15007f() && (m15578a = C4278hr.m15578a(this.f15541a, c4243gj.f15541a)) != 0) {
            return m15578a;
        }
        int compareTo7 = Boolean.valueOf(m15009g()).compareTo(Boolean.valueOf(c4243gj.m15009g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15009g() && (m15572a4 = C4278hr.m15572a(this.f15545d, c4243gj.f15545d)) != 0) {
            return m15572a4;
        }
        int compareTo8 = Boolean.valueOf(m15010h()).compareTo(Boolean.valueOf(c4243gj.m15010h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15010h() && (m15572a3 = C4278hr.m15572a(this.f15546e, c4243gj.f15546e)) != 0) {
            return m15572a3;
        }
        int compareTo9 = Boolean.valueOf(m15011i()).compareTo(Boolean.valueOf(c4243gj.m15011i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15011i() && (m15572a2 = C4278hr.m15572a(this.f15547f, c4243gj.f15547f)) != 0) {
            return m15572a2;
        }
        int compareTo10 = Boolean.valueOf(m15012j()).compareTo(Boolean.valueOf(c4243gj.m15012j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15012j() && (m15575a = C4278hr.m15575a(this.f15540a, c4243gj.f15540a)) != 0) {
            return m15575a;
        }
        int compareTo11 = Boolean.valueOf(m15013k()).compareTo(Boolean.valueOf(c4243gj.m15013k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!m15013k() || (m15572a = C4278hr.m15572a(this.f15548g, c4243gj.f15548g)) == 0) {
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
                m14986a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f15538a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 11) {
                        this.f15543b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f15544c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 10) {
                        this.f15537a = abstractC4288ia.mo15593a();
                        m14988a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f15542b = abstractC4288ia.mo15593a();
                        m14994b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 2) {
                        this.f15541a = abstractC4288ia.mo15615a();
                        m14998c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f15545d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f15546e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f15547f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        C4286hz mo15596a = abstractC4288ia.mo15596a();
                        this.f15540a = new HashMap(mo15596a.f16337a * 2);
                        for (int i2 = 0; i2 < mo15596a.f16337a; i2++) {
                            this.f15540a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f15548g = abstractC4288ia.mo15599a();
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
