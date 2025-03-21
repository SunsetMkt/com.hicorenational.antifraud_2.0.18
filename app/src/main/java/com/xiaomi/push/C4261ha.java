package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.ha */
/* loaded from: classes2.dex */
public class C4261ha implements InterfaceC4277hq<C4261ha, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f15978a;

    /* renamed from: a */
    public C4254gu f15979a;

    /* renamed from: a */
    public String f15980a;

    /* renamed from: a */
    public List<String> f15982a;

    /* renamed from: b */
    public String f15984b;

    /* renamed from: c */
    public String f15985c;

    /* renamed from: d */
    public String f15986d;

    /* renamed from: e */
    public String f15987e;

    /* renamed from: f */
    public String f15988f;

    /* renamed from: a */
    private static final C4293if f15968a = new C4293if("XmPushActionCommandResult");

    /* renamed from: a */
    private static final C4284hx f15967a = new C4284hx("", (byte) 12, 2);

    /* renamed from: b */
    private static final C4284hx f15969b = new C4284hx("", (byte) 11, 3);

    /* renamed from: c */
    private static final C4284hx f15970c = new C4284hx("", (byte) 11, 4);

    /* renamed from: d */
    private static final C4284hx f15971d = new C4284hx("", (byte) 11, 5);

    /* renamed from: e */
    private static final C4284hx f15972e = new C4284hx("", (byte) 10, 7);

    /* renamed from: f */
    private static final C4284hx f15973f = new C4284hx("", (byte) 11, 8);

    /* renamed from: g */
    private static final C4284hx f15974g = new C4284hx("", (byte) 11, 9);

    /* renamed from: h */
    private static final C4284hx f15975h = new C4284hx("", C3393cw.f11873m, 10);

    /* renamed from: i */
    private static final C4284hx f15976i = new C4284hx("", (byte) 11, 12);

    /* renamed from: j */
    private static final C4284hx f15977j = new C4284hx("", (byte) 2, 13);

    /* renamed from: a */
    private BitSet f15981a = new BitSet(2);

    /* renamed from: a */
    public boolean f15983a = true;

    /* renamed from: a */
    public boolean m15248a() {
        return this.f15979a != null;
    }

    /* renamed from: b */
    public boolean m15252b() {
        return this.f15980a != null;
    }

    /* renamed from: c */
    public boolean m15254c() {
        return this.f15984b != null;
    }

    /* renamed from: d */
    public boolean m15255d() {
        return this.f15985c != null;
    }

    /* renamed from: e */
    public boolean m15256e() {
        return this.f15981a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4261ha)) {
            return m15249a((C4261ha) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15257f() {
        return this.f15986d != null;
    }

    /* renamed from: g */
    public boolean m15258g() {
        return this.f15987e != null;
    }

    /* renamed from: h */
    public boolean m15259h() {
        return this.f15982a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15260i() {
        return this.f15988f != null;
    }

    /* renamed from: j */
    public boolean m15261j() {
        return this.f15981a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m15248a()) {
            sb.append("target:");
            C4254gu c4254gu = this.f15979a;
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
        String str = this.f15980a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f15984b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f15985c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f15978a);
        if (m15257f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f15986d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15258g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f15987e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15259h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f15982a;
            if (list == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(list);
            }
        }
        if (m15260i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f15988f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15261j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f15983a);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public String m15244a() {
        return this.f15980a;
    }

    /* renamed from: b */
    public String m15250b() {
        return this.f15985c;
    }

    /* renamed from: c */
    public String m15253c() {
        return this.f15988f;
    }

    /* renamed from: a */
    public void m15247a(boolean z) {
        this.f15981a.set(0, z);
    }

    /* renamed from: b */
    public void m15251b(boolean z) {
        this.f15981a.set(1, z);
    }

    /* renamed from: a */
    public List<String> m15245a() {
        return this.f15982a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15246a();
        abstractC4288ia.mo15610a(f15968a);
        if (this.f15979a != null && m15248a()) {
            abstractC4288ia.mo15607a(f15967a);
            this.f15979a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15980a != null) {
            abstractC4288ia.mo15607a(f15969b);
            abstractC4288ia.mo15611a(this.f15980a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15984b != null) {
            abstractC4288ia.mo15607a(f15970c);
            abstractC4288ia.mo15611a(this.f15984b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15985c != null) {
            abstractC4288ia.mo15607a(f15971d);
            abstractC4288ia.mo15611a(this.f15985c);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f15972e);
        abstractC4288ia.mo15606a(this.f15978a);
        abstractC4288ia.mo15616b();
        if (this.f15986d != null && m15257f()) {
            abstractC4288ia.mo15607a(f15973f);
            abstractC4288ia.mo15611a(this.f15986d);
            abstractC4288ia.mo15616b();
        }
        if (this.f15987e != null && m15258g()) {
            abstractC4288ia.mo15607a(f15974g);
            abstractC4288ia.mo15611a(this.f15987e);
            abstractC4288ia.mo15616b();
        }
        if (this.f15982a != null && m15259h()) {
            abstractC4288ia.mo15607a(f15975h);
            abstractC4288ia.mo15608a(new C4285hy((byte) 11, this.f15982a.size()));
            Iterator<String> it = this.f15982a.iterator();
            while (it.hasNext()) {
                abstractC4288ia.mo15611a(it.next());
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        if (this.f15988f != null && m15260i()) {
            abstractC4288ia.mo15607a(f15976i);
            abstractC4288ia.mo15611a(this.f15988f);
            abstractC4288ia.mo15616b();
        }
        if (m15261j()) {
            abstractC4288ia.mo15607a(f15977j);
            abstractC4288ia.mo15614a(this.f15983a);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15249a(C4261ha c4261ha) {
        if (c4261ha == null) {
            return false;
        }
        boolean m15248a = m15248a();
        boolean m15248a2 = c4261ha.m15248a();
        if ((m15248a || m15248a2) && !(m15248a && m15248a2 && this.f15979a.m15138a(c4261ha.f15979a))) {
            return false;
        }
        boolean m15252b = m15252b();
        boolean m15252b2 = c4261ha.m15252b();
        if ((m15252b || m15252b2) && !(m15252b && m15252b2 && this.f15980a.equals(c4261ha.f15980a))) {
            return false;
        }
        boolean m15254c = m15254c();
        boolean m15254c2 = c4261ha.m15254c();
        if ((m15254c || m15254c2) && !(m15254c && m15254c2 && this.f15984b.equals(c4261ha.f15984b))) {
            return false;
        }
        boolean m15255d = m15255d();
        boolean m15255d2 = c4261ha.m15255d();
        if (((m15255d || m15255d2) && !(m15255d && m15255d2 && this.f15985c.equals(c4261ha.f15985c))) || this.f15978a != c4261ha.f15978a) {
            return false;
        }
        boolean m15257f = m15257f();
        boolean m15257f2 = c4261ha.m15257f();
        if ((m15257f || m15257f2) && !(m15257f && m15257f2 && this.f15986d.equals(c4261ha.f15986d))) {
            return false;
        }
        boolean m15258g = m15258g();
        boolean m15258g2 = c4261ha.m15258g();
        if ((m15258g || m15258g2) && !(m15258g && m15258g2 && this.f15987e.equals(c4261ha.f15987e))) {
            return false;
        }
        boolean m15259h = m15259h();
        boolean m15259h2 = c4261ha.m15259h();
        if ((m15259h || m15259h2) && !(m15259h && m15259h2 && this.f15982a.equals(c4261ha.f15982a))) {
            return false;
        }
        boolean m15260i = m15260i();
        boolean m15260i2 = c4261ha.m15260i();
        if ((m15260i || m15260i2) && !(m15260i && m15260i2 && this.f15988f.equals(c4261ha.f15988f))) {
            return false;
        }
        boolean m15261j = m15261j();
        boolean m15261j2 = c4261ha.m15261j();
        if (m15261j || m15261j2) {
            return m15261j && m15261j2 && this.f15983a == c4261ha.f15983a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4261ha c4261ha) {
        int m15578a;
        int m15572a;
        int m15574a;
        int m15572a2;
        int m15572a3;
        int m15570a;
        int m15572a4;
        int m15572a5;
        int m15572a6;
        int m15571a;
        if (!C4261ha.class.equals(c4261ha.getClass())) {
            return C4261ha.class.getName().compareTo(c4261ha.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15248a()).compareTo(Boolean.valueOf(c4261ha.m15248a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15248a() && (m15571a = C4278hr.m15571a(this.f15979a, c4261ha.f15979a)) != 0) {
            return m15571a;
        }
        int compareTo2 = Boolean.valueOf(m15252b()).compareTo(Boolean.valueOf(c4261ha.m15252b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15252b() && (m15572a6 = C4278hr.m15572a(this.f15980a, c4261ha.f15980a)) != 0) {
            return m15572a6;
        }
        int compareTo3 = Boolean.valueOf(m15254c()).compareTo(Boolean.valueOf(c4261ha.m15254c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15254c() && (m15572a5 = C4278hr.m15572a(this.f15984b, c4261ha.f15984b)) != 0) {
            return m15572a5;
        }
        int compareTo4 = Boolean.valueOf(m15255d()).compareTo(Boolean.valueOf(c4261ha.m15255d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15255d() && (m15572a4 = C4278hr.m15572a(this.f15985c, c4261ha.f15985c)) != 0) {
            return m15572a4;
        }
        int compareTo5 = Boolean.valueOf(m15256e()).compareTo(Boolean.valueOf(c4261ha.m15256e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15256e() && (m15570a = C4278hr.m15570a(this.f15978a, c4261ha.f15978a)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15257f()).compareTo(Boolean.valueOf(c4261ha.m15257f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15257f() && (m15572a3 = C4278hr.m15572a(this.f15986d, c4261ha.f15986d)) != 0) {
            return m15572a3;
        }
        int compareTo7 = Boolean.valueOf(m15258g()).compareTo(Boolean.valueOf(c4261ha.m15258g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15258g() && (m15572a2 = C4278hr.m15572a(this.f15987e, c4261ha.f15987e)) != 0) {
            return m15572a2;
        }
        int compareTo8 = Boolean.valueOf(m15259h()).compareTo(Boolean.valueOf(c4261ha.m15259h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15259h() && (m15574a = C4278hr.m15574a(this.f15982a, c4261ha.f15982a)) != 0) {
            return m15574a;
        }
        int compareTo9 = Boolean.valueOf(m15260i()).compareTo(Boolean.valueOf(c4261ha.m15260i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15260i() && (m15572a = C4278hr.m15572a(this.f15988f, c4261ha.f15988f)) != 0) {
            return m15572a;
        }
        int compareTo10 = Boolean.valueOf(m15261j()).compareTo(Boolean.valueOf(c4261ha.m15261j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m15261j() || (m15578a = C4278hr.m15578a(this.f15983a, c4261ha.f15983a)) == 0) {
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
                if (m15256e()) {
                    m15246a();
                    return;
                }
                throw new C4289ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 2:
                    if (b2 == 12) {
                        this.f15979a = new C4254gu();
                        this.f15979a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f15980a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f15984b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f15985c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                case 11:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f15978a = abstractC4288ia.mo15593a();
                        m15247a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f15986d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f15987e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 15) {
                        C4285hy mo15595a = abstractC4288ia.mo15595a();
                        this.f15982a = new ArrayList(mo15595a.f16335a);
                        for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                            this.f15982a.add(abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15625i();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f15988f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 13:
                    if (b2 == 2) {
                        this.f15983a = abstractC4288ia.mo15615a();
                        m15251b(true);
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
    public void m15246a() {
        if (this.f15980a != null) {
            if (this.f15984b != null) {
                if (this.f15985c != null) {
                    return;
                }
                throw new C4289ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
