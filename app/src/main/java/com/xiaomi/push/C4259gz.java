package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gz */
/* loaded from: classes2.dex */
public class C4259gz implements InterfaceC4277hq<C4259gz, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f15955a;

    /* renamed from: a */
    public C4254gu f15956a;

    /* renamed from: a */
    public String f15957a;

    /* renamed from: a */
    public List<String> f15959a;

    /* renamed from: b */
    public String f15961b;

    /* renamed from: c */
    public String f15963c;

    /* renamed from: d */
    public String f15964d;

    /* renamed from: e */
    public String f15965e;

    /* renamed from: a */
    private static final C4293if f15945a = new C4293if("XmPushActionCommand");

    /* renamed from: a */
    private static final C4284hx f15944a = new C4284hx("", (byte) 12, 2);

    /* renamed from: b */
    private static final C4284hx f15946b = new C4284hx("", (byte) 11, 3);

    /* renamed from: c */
    private static final C4284hx f15947c = new C4284hx("", (byte) 11, 4);

    /* renamed from: d */
    private static final C4284hx f15948d = new C4284hx("", (byte) 11, 5);

    /* renamed from: e */
    private static final C4284hx f15949e = new C4284hx("", C3393cw.f11873m, 6);

    /* renamed from: f */
    private static final C4284hx f15950f = new C4284hx("", (byte) 11, 7);

    /* renamed from: g */
    private static final C4284hx f15951g = new C4284hx("", (byte) 11, 9);

    /* renamed from: h */
    private static final C4284hx f15952h = new C4284hx("", (byte) 2, 10);

    /* renamed from: i */
    private static final C4284hx f15953i = new C4284hx("", (byte) 2, 11);

    /* renamed from: j */
    private static final C4284hx f15954j = new C4284hx("", (byte) 10, 12);

    /* renamed from: a */
    private BitSet f15958a = new BitSet(3);

    /* renamed from: a */
    public boolean f15960a = false;

    /* renamed from: b */
    public boolean f15962b = true;

    /* renamed from: a */
    public boolean m15223a() {
        return this.f15956a != null;
    }

    /* renamed from: b */
    public boolean m15227b() {
        return this.f15957a != null;
    }

    /* renamed from: c */
    public boolean m15230c() {
        return this.f15961b != null;
    }

    /* renamed from: d */
    public boolean m15232d() {
        return this.f15963c != null;
    }

    /* renamed from: e */
    public boolean m15234e() {
        return this.f15959a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4259gz)) {
            return m15224a((C4259gz) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15235f() {
        return this.f15964d != null;
    }

    /* renamed from: g */
    public boolean m15236g() {
        return this.f15965e != null;
    }

    /* renamed from: h */
    public boolean m15237h() {
        return this.f15958a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15238i() {
        return this.f15958a.get(1);
    }

    /* renamed from: j */
    public boolean m15239j() {
        return this.f15958a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m15223a()) {
            sb.append("target:");
            C4254gu c4254gu = this.f15956a;
            if (c4254gu == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4254gu);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f15957a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f15961b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f15963c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        if (m15234e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f15959a;
            if (list == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(list);
            }
        }
        if (m15235f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f15964d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15236g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f15965e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15237h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f15960a);
        }
        if (m15238i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f15962b);
        }
        if (m15239j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f15955a);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public C4259gz m15218a(String str) {
        this.f15957a = str;
        return this;
    }

    /* renamed from: b */
    public C4259gz m15225b(String str) {
        this.f15961b = str;
        return this;
    }

    /* renamed from: c */
    public C4259gz m15228c(String str) {
        this.f15963c = str;
        return this;
    }

    /* renamed from: d */
    public C4259gz m15231d(String str) {
        this.f15964d = str;
        return this;
    }

    /* renamed from: e */
    public C4259gz m15233e(String str) {
        this.f15965e = str;
        return this;
    }

    /* renamed from: a */
    public String m15219a() {
        return this.f15963c;
    }

    /* renamed from: b */
    public void m15226b(boolean z) {
        this.f15958a.set(1, z);
    }

    /* renamed from: c */
    public void m15229c(boolean z) {
        this.f15958a.set(2, z);
    }

    /* renamed from: a */
    public void m15221a(String str) {
        if (this.f15959a == null) {
            this.f15959a = new ArrayList();
        }
        this.f15959a.add(str);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15220a();
        abstractC4288ia.mo15610a(f15945a);
        if (this.f15956a != null && m15223a()) {
            abstractC4288ia.mo15607a(f15944a);
            this.f15956a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15957a != null) {
            abstractC4288ia.mo15607a(f15946b);
            abstractC4288ia.mo15611a(this.f15957a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15961b != null) {
            abstractC4288ia.mo15607a(f15947c);
            abstractC4288ia.mo15611a(this.f15961b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15963c != null) {
            abstractC4288ia.mo15607a(f15948d);
            abstractC4288ia.mo15611a(this.f15963c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15959a != null && m15234e()) {
            abstractC4288ia.mo15607a(f15949e);
            abstractC4288ia.mo15608a(new C4285hy((byte) 11, this.f15959a.size()));
            Iterator<String> it = this.f15959a.iterator();
            while (it.hasNext()) {
                abstractC4288ia.mo15611a(it.next());
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        if (this.f15964d != null && m15235f()) {
            abstractC4288ia.mo15607a(f15950f);
            abstractC4288ia.mo15611a(this.f15964d);
            abstractC4288ia.mo15616b();
        }
        if (this.f15965e != null && m15236g()) {
            abstractC4288ia.mo15607a(f15951g);
            abstractC4288ia.mo15611a(this.f15965e);
            abstractC4288ia.mo15616b();
        }
        if (m15237h()) {
            abstractC4288ia.mo15607a(f15952h);
            abstractC4288ia.mo15614a(this.f15960a);
            abstractC4288ia.mo15616b();
        }
        if (m15238i()) {
            abstractC4288ia.mo15607a(f15953i);
            abstractC4288ia.mo15614a(this.f15962b);
            abstractC4288ia.mo15616b();
        }
        if (m15239j()) {
            abstractC4288ia.mo15607a(f15954j);
            abstractC4288ia.mo15606a(this.f15955a);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public void m15222a(boolean z) {
        this.f15958a.set(0, z);
    }

    /* renamed from: a */
    public boolean m15224a(C4259gz c4259gz) {
        if (c4259gz == null) {
            return false;
        }
        boolean m15223a = m15223a();
        boolean m15223a2 = c4259gz.m15223a();
        if ((m15223a || m15223a2) && !(m15223a && m15223a2 && this.f15956a.m15138a(c4259gz.f15956a))) {
            return false;
        }
        boolean m15227b = m15227b();
        boolean m15227b2 = c4259gz.m15227b();
        if ((m15227b || m15227b2) && !(m15227b && m15227b2 && this.f15957a.equals(c4259gz.f15957a))) {
            return false;
        }
        boolean m15230c = m15230c();
        boolean m15230c2 = c4259gz.m15230c();
        if ((m15230c || m15230c2) && !(m15230c && m15230c2 && this.f15961b.equals(c4259gz.f15961b))) {
            return false;
        }
        boolean m15232d = m15232d();
        boolean m15232d2 = c4259gz.m15232d();
        if ((m15232d || m15232d2) && !(m15232d && m15232d2 && this.f15963c.equals(c4259gz.f15963c))) {
            return false;
        }
        boolean m15234e = m15234e();
        boolean m15234e2 = c4259gz.m15234e();
        if ((m15234e || m15234e2) && !(m15234e && m15234e2 && this.f15959a.equals(c4259gz.f15959a))) {
            return false;
        }
        boolean m15235f = m15235f();
        boolean m15235f2 = c4259gz.m15235f();
        if ((m15235f || m15235f2) && !(m15235f && m15235f2 && this.f15964d.equals(c4259gz.f15964d))) {
            return false;
        }
        boolean m15236g = m15236g();
        boolean m15236g2 = c4259gz.m15236g();
        if ((m15236g || m15236g2) && !(m15236g && m15236g2 && this.f15965e.equals(c4259gz.f15965e))) {
            return false;
        }
        boolean m15237h = m15237h();
        boolean m15237h2 = c4259gz.m15237h();
        if ((m15237h || m15237h2) && !(m15237h && m15237h2 && this.f15960a == c4259gz.f15960a)) {
            return false;
        }
        boolean m15238i = m15238i();
        boolean m15238i2 = c4259gz.m15238i();
        if ((m15238i || m15238i2) && !(m15238i && m15238i2 && this.f15962b == c4259gz.f15962b)) {
            return false;
        }
        boolean m15239j = m15239j();
        boolean m15239j2 = c4259gz.m15239j();
        if (m15239j || m15239j2) {
            return m15239j && m15239j2 && this.f15955a == c4259gz.f15955a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4259gz c4259gz) {
        int m15570a;
        int m15578a;
        int m15578a2;
        int m15572a;
        int m15572a2;
        int m15574a;
        int m15572a3;
        int m15572a4;
        int m15572a5;
        int m15571a;
        if (!C4259gz.class.equals(c4259gz.getClass())) {
            return C4259gz.class.getName().compareTo(c4259gz.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15223a()).compareTo(Boolean.valueOf(c4259gz.m15223a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15223a() && (m15571a = C4278hr.m15571a(this.f15956a, c4259gz.f15956a)) != 0) {
            return m15571a;
        }
        int compareTo2 = Boolean.valueOf(m15227b()).compareTo(Boolean.valueOf(c4259gz.m15227b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15227b() && (m15572a5 = C4278hr.m15572a(this.f15957a, c4259gz.f15957a)) != 0) {
            return m15572a5;
        }
        int compareTo3 = Boolean.valueOf(m15230c()).compareTo(Boolean.valueOf(c4259gz.m15230c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15230c() && (m15572a4 = C4278hr.m15572a(this.f15961b, c4259gz.f15961b)) != 0) {
            return m15572a4;
        }
        int compareTo4 = Boolean.valueOf(m15232d()).compareTo(Boolean.valueOf(c4259gz.m15232d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15232d() && (m15572a3 = C4278hr.m15572a(this.f15963c, c4259gz.f15963c)) != 0) {
            return m15572a3;
        }
        int compareTo5 = Boolean.valueOf(m15234e()).compareTo(Boolean.valueOf(c4259gz.m15234e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15234e() && (m15574a = C4278hr.m15574a(this.f15959a, c4259gz.f15959a)) != 0) {
            return m15574a;
        }
        int compareTo6 = Boolean.valueOf(m15235f()).compareTo(Boolean.valueOf(c4259gz.m15235f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15235f() && (m15572a2 = C4278hr.m15572a(this.f15964d, c4259gz.f15964d)) != 0) {
            return m15572a2;
        }
        int compareTo7 = Boolean.valueOf(m15236g()).compareTo(Boolean.valueOf(c4259gz.m15236g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15236g() && (m15572a = C4278hr.m15572a(this.f15965e, c4259gz.f15965e)) != 0) {
            return m15572a;
        }
        int compareTo8 = Boolean.valueOf(m15237h()).compareTo(Boolean.valueOf(c4259gz.m15237h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15237h() && (m15578a2 = C4278hr.m15578a(this.f15960a, c4259gz.f15960a)) != 0) {
            return m15578a2;
        }
        int compareTo9 = Boolean.valueOf(m15238i()).compareTo(Boolean.valueOf(c4259gz.m15238i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15238i() && (m15578a = C4278hr.m15578a(this.f15962b, c4259gz.f15962b)) != 0) {
            return m15578a;
        }
        int compareTo10 = Boolean.valueOf(m15239j()).compareTo(Boolean.valueOf(c4259gz.m15239j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m15239j() || (m15570a = C4278hr.m15570a(this.f15955a, c4259gz.f15955a)) == 0) {
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
                m15220a();
                return;
            }
            switch (mo15594a.f16333a) {
                case 2:
                    if (b2 == 12) {
                        this.f15956a = new C4254gu();
                        this.f15956a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f15957a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f15961b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f15963c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 15) {
                        C4285hy mo15595a = abstractC4288ia.mo15595a();
                        this.f15959a = new ArrayList(mo15595a.f16335a);
                        for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                            this.f15959a.add(abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15625i();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f15964d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f15965e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 2) {
                        this.f15960a = abstractC4288ia.mo15615a();
                        m15222a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f15962b = abstractC4288ia.mo15615a();
                        m15226b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f15955a = abstractC4288ia.mo15593a();
                        m15229c(true);
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
    public void m15220a() {
        if (this.f15957a != null) {
            if (this.f15961b != null) {
                if (this.f15963c != null) {
                    return;
                }
                throw new C4289ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
