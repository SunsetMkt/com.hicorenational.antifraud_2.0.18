package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hh */
/* loaded from: classes2.dex */
public class C4268hh implements InterfaceC4277hq<C4268hh, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f16155a;

    /* renamed from: a */
    public C4254gu f16156a;

    /* renamed from: a */
    public String f16157a;

    /* renamed from: a */
    private BitSet f16158a = new BitSet(1);

    /* renamed from: b */
    public String f16159b;

    /* renamed from: c */
    public String f16160c;

    /* renamed from: d */
    public String f16161d;

    /* renamed from: e */
    public String f16162e;

    /* renamed from: a */
    private static final C4293if f16148a = new C4293if("XmPushActionSendFeedbackResult");

    /* renamed from: a */
    private static final C4284hx f16147a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16149b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16150c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16151d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16152e = new C4284hx("", (byte) 10, 6);

    /* renamed from: f */
    private static final C4284hx f16153f = new C4284hx("", (byte) 11, 7);

    /* renamed from: g */
    private static final C4284hx f16154g = new C4284hx("", (byte) 11, 8);

    /* renamed from: a */
    public boolean m15429a() {
        return this.f16157a != null;
    }

    /* renamed from: b */
    public boolean m15431b() {
        return this.f16156a != null;
    }

    /* renamed from: c */
    public boolean m15432c() {
        return this.f16159b != null;
    }

    /* renamed from: d */
    public boolean m15433d() {
        return this.f16160c != null;
    }

    /* renamed from: e */
    public boolean m15434e() {
        return this.f16158a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4268hh)) {
            return m15430a((C4268hh) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15435f() {
        return this.f16161d != null;
    }

    /* renamed from: g */
    public boolean m15436g() {
        return this.f16162e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        if (m15429a()) {
            sb.append("debug:");
            String str = this.f16157a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15431b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16156a;
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
        String str2 = this.f16159b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16160c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f16155a);
        if (m15435f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f16161d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15436g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f16162e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m15428a(boolean z) {
        this.f16158a.set(0, z);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15427a();
        abstractC4288ia.mo15610a(f16148a);
        if (this.f16157a != null && m15429a()) {
            abstractC4288ia.mo15607a(f16147a);
            abstractC4288ia.mo15611a(this.f16157a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16156a != null && m15431b()) {
            abstractC4288ia.mo15607a(f16149b);
            this.f16156a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16159b != null) {
            abstractC4288ia.mo15607a(f16150c);
            abstractC4288ia.mo15611a(this.f16159b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16160c != null) {
            abstractC4288ia.mo15607a(f16151d);
            abstractC4288ia.mo15611a(this.f16160c);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f16152e);
        abstractC4288ia.mo15606a(this.f16155a);
        abstractC4288ia.mo15616b();
        if (this.f16161d != null && m15435f()) {
            abstractC4288ia.mo15607a(f16153f);
            abstractC4288ia.mo15611a(this.f16161d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16162e != null && m15436g()) {
            abstractC4288ia.mo15607a(f16154g);
            abstractC4288ia.mo15611a(this.f16162e);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15430a(C4268hh c4268hh) {
        if (c4268hh == null) {
            return false;
        }
        boolean m15429a = m15429a();
        boolean m15429a2 = c4268hh.m15429a();
        if ((m15429a || m15429a2) && !(m15429a && m15429a2 && this.f16157a.equals(c4268hh.f16157a))) {
            return false;
        }
        boolean m15431b = m15431b();
        boolean m15431b2 = c4268hh.m15431b();
        if ((m15431b || m15431b2) && !(m15431b && m15431b2 && this.f16156a.m15138a(c4268hh.f16156a))) {
            return false;
        }
        boolean m15432c = m15432c();
        boolean m15432c2 = c4268hh.m15432c();
        if ((m15432c || m15432c2) && !(m15432c && m15432c2 && this.f16159b.equals(c4268hh.f16159b))) {
            return false;
        }
        boolean m15433d = m15433d();
        boolean m15433d2 = c4268hh.m15433d();
        if (((m15433d || m15433d2) && !(m15433d && m15433d2 && this.f16160c.equals(c4268hh.f16160c))) || this.f16155a != c4268hh.f16155a) {
            return false;
        }
        boolean m15435f = m15435f();
        boolean m15435f2 = c4268hh.m15435f();
        if ((m15435f || m15435f2) && !(m15435f && m15435f2 && this.f16161d.equals(c4268hh.f16161d))) {
            return false;
        }
        boolean m15436g = m15436g();
        boolean m15436g2 = c4268hh.m15436g();
        if (m15436g || m15436g2) {
            return m15436g && m15436g2 && this.f16162e.equals(c4268hh.f16162e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4268hh c4268hh) {
        int m15572a;
        int m15572a2;
        int m15570a;
        int m15572a3;
        int m15572a4;
        int m15571a;
        int m15572a5;
        if (!C4268hh.class.equals(c4268hh.getClass())) {
            return C4268hh.class.getName().compareTo(c4268hh.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15429a()).compareTo(Boolean.valueOf(c4268hh.m15429a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15429a() && (m15572a5 = C4278hr.m15572a(this.f16157a, c4268hh.f16157a)) != 0) {
            return m15572a5;
        }
        int compareTo2 = Boolean.valueOf(m15431b()).compareTo(Boolean.valueOf(c4268hh.m15431b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15431b() && (m15571a = C4278hr.m15571a(this.f16156a, c4268hh.f16156a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15432c()).compareTo(Boolean.valueOf(c4268hh.m15432c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15432c() && (m15572a4 = C4278hr.m15572a(this.f16159b, c4268hh.f16159b)) != 0) {
            return m15572a4;
        }
        int compareTo4 = Boolean.valueOf(m15433d()).compareTo(Boolean.valueOf(c4268hh.m15433d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15433d() && (m15572a3 = C4278hr.m15572a(this.f16160c, c4268hh.f16160c)) != 0) {
            return m15572a3;
        }
        int compareTo5 = Boolean.valueOf(m15434e()).compareTo(Boolean.valueOf(c4268hh.m15434e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15434e() && (m15570a = C4278hr.m15570a(this.f16155a, c4268hh.f16155a)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15435f()).compareTo(Boolean.valueOf(c4268hh.m15435f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15435f() && (m15572a2 = C4278hr.m15572a(this.f16161d, c4268hh.f16161d)) != 0) {
            return m15572a2;
        }
        int compareTo7 = Boolean.valueOf(m15436g()).compareTo(Boolean.valueOf(c4268hh.m15436g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!m15436g() || (m15572a = C4278hr.m15572a(this.f16162e, c4268hh.f16162e)) == 0) {
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
                if (m15434e()) {
                    m15427a();
                    return;
                }
                throw new C4289ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16157a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16156a = new C4254gu();
                        this.f16156a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16159b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16160c = abstractC4288ia.mo15599a();
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
                        this.f16155a = abstractC4288ia.mo15593a();
                        m15428a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16161d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16162e = abstractC4288ia.mo15599a();
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
    public void m15427a() {
        if (this.f16159b != null) {
            if (this.f16160c != null) {
                return;
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
