package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gu */
/* loaded from: classes2.dex */
public class C4254gu implements InterfaceC4277hq<C4254gu, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public String f15865a;

    /* renamed from: d */
    public String f15870d;

    /* renamed from: a */
    private static final C4293if f15858a = new C4293if("Target");

    /* renamed from: a */
    private static final C4284hx f15857a = new C4284hx("", (byte) 10, 1);

    /* renamed from: b */
    private static final C4284hx f15859b = new C4284hx("", (byte) 11, 2);

    /* renamed from: c */
    private static final C4284hx f15860c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f15861d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15862e = new C4284hx("", (byte) 2, 5);

    /* renamed from: f */
    private static final C4284hx f15863f = new C4284hx("", (byte) 11, 7);

    /* renamed from: a */
    private BitSet f15866a = new BitSet(2);

    /* renamed from: a */
    public long f15864a = 5;

    /* renamed from: b */
    public String f15868b = "xiaomi.com";

    /* renamed from: c */
    public String f15869c = "";

    /* renamed from: a */
    public boolean f15867a = false;

    /* renamed from: a */
    public boolean m15137a() {
        return this.f15866a.get(0);
    }

    /* renamed from: b */
    public boolean m15140b() {
        return this.f15865a != null;
    }

    /* renamed from: c */
    public boolean m15141c() {
        return this.f15868b != null;
    }

    /* renamed from: d */
    public boolean m15142d() {
        return this.f15869c != null;
    }

    /* renamed from: e */
    public boolean m15143e() {
        return this.f15866a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4254gu)) {
            return m15138a((C4254gu) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15144f() {
        return this.f15870d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f15864a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f15865a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        if (m15141c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f15868b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
        }
        if (m15142d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f15869c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m15143e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f15867a);
        }
        if (m15144f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f15870d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m15136a(boolean z) {
        this.f15866a.set(0, z);
    }

    /* renamed from: b */
    public void m15139b(boolean z) {
        this.f15866a.set(1, z);
    }

    /* renamed from: a */
    public boolean m15138a(C4254gu c4254gu) {
        if (c4254gu == null || this.f15864a != c4254gu.f15864a) {
            return false;
        }
        boolean m15140b = m15140b();
        boolean m15140b2 = c4254gu.m15140b();
        if ((m15140b || m15140b2) && !(m15140b && m15140b2 && this.f15865a.equals(c4254gu.f15865a))) {
            return false;
        }
        boolean m15141c = m15141c();
        boolean m15141c2 = c4254gu.m15141c();
        if ((m15141c || m15141c2) && !(m15141c && m15141c2 && this.f15868b.equals(c4254gu.f15868b))) {
            return false;
        }
        boolean m15142d = m15142d();
        boolean m15142d2 = c4254gu.m15142d();
        if ((m15142d || m15142d2) && !(m15142d && m15142d2 && this.f15869c.equals(c4254gu.f15869c))) {
            return false;
        }
        boolean m15143e = m15143e();
        boolean m15143e2 = c4254gu.m15143e();
        if ((m15143e || m15143e2) && !(m15143e && m15143e2 && this.f15867a == c4254gu.f15867a)) {
            return false;
        }
        boolean m15144f = m15144f();
        boolean m15144f2 = c4254gu.m15144f();
        if (m15144f || m15144f2) {
            return m15144f && m15144f2 && this.f15870d.equals(c4254gu.f15870d);
        }
        return true;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15135a();
        abstractC4288ia.mo15610a(f15858a);
        abstractC4288ia.mo15607a(f15857a);
        abstractC4288ia.mo15606a(this.f15864a);
        abstractC4288ia.mo15616b();
        if (this.f15865a != null) {
            abstractC4288ia.mo15607a(f15859b);
            abstractC4288ia.mo15611a(this.f15865a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15868b != null && m15141c()) {
            abstractC4288ia.mo15607a(f15860c);
            abstractC4288ia.mo15611a(this.f15868b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15869c != null && m15142d()) {
            abstractC4288ia.mo15607a(f15861d);
            abstractC4288ia.mo15611a(this.f15869c);
            abstractC4288ia.mo15616b();
        }
        if (m15143e()) {
            abstractC4288ia.mo15607a(f15862e);
            abstractC4288ia.mo15614a(this.f15867a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15870d != null && m15144f()) {
            abstractC4288ia.mo15607a(f15863f);
            abstractC4288ia.mo15611a(this.f15870d);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4254gu c4254gu) {
        int m15572a;
        int m15578a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15570a;
        if (!C4254gu.class.equals(c4254gu.getClass())) {
            return C4254gu.class.getName().compareTo(c4254gu.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15137a()).compareTo(Boolean.valueOf(c4254gu.m15137a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15137a() && (m15570a = C4278hr.m15570a(this.f15864a, c4254gu.f15864a)) != 0) {
            return m15570a;
        }
        int compareTo2 = Boolean.valueOf(m15140b()).compareTo(Boolean.valueOf(c4254gu.m15140b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15140b() && (m15572a4 = C4278hr.m15572a(this.f15865a, c4254gu.f15865a)) != 0) {
            return m15572a4;
        }
        int compareTo3 = Boolean.valueOf(m15141c()).compareTo(Boolean.valueOf(c4254gu.m15141c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15141c() && (m15572a3 = C4278hr.m15572a(this.f15868b, c4254gu.f15868b)) != 0) {
            return m15572a3;
        }
        int compareTo4 = Boolean.valueOf(m15142d()).compareTo(Boolean.valueOf(c4254gu.m15142d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15142d() && (m15572a2 = C4278hr.m15572a(this.f15869c, c4254gu.f15869c)) != 0) {
            return m15572a2;
        }
        int compareTo5 = Boolean.valueOf(m15143e()).compareTo(Boolean.valueOf(c4254gu.m15143e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15143e() && (m15578a = C4278hr.m15578a(this.f15867a, c4254gu.f15867a)) != 0) {
            return m15578a;
        }
        int compareTo6 = Boolean.valueOf(m15144f()).compareTo(Boolean.valueOf(c4254gu.m15144f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!m15144f() || (m15572a = C4278hr.m15572a(this.f15870d, c4254gu.f15870d)) == 0) {
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
                break;
            }
            short s = mo15594a.f16333a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s != 7) {
                                    C4291id.m15660a(abstractC4288ia, b2);
                                } else if (b2 == 11) {
                                    this.f15870d = abstractC4288ia.mo15599a();
                                } else {
                                    C4291id.m15660a(abstractC4288ia, b2);
                                }
                            } else if (b2 == 2) {
                                this.f15867a = abstractC4288ia.mo15615a();
                                m15139b(true);
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                            }
                        } else if (b2 == 11) {
                            this.f15869c = abstractC4288ia.mo15599a();
                        } else {
                            C4291id.m15660a(abstractC4288ia, b2);
                        }
                    } else if (b2 == 11) {
                        this.f15868b = abstractC4288ia.mo15599a();
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                    }
                } else if (b2 == 11) {
                    this.f15865a = abstractC4288ia.mo15599a();
                } else {
                    C4291id.m15660a(abstractC4288ia, b2);
                }
            } else if (b2 == 10) {
                this.f15864a = abstractC4288ia.mo15593a();
                m15136a(true);
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
        abstractC4288ia.mo15622f();
        if (m15137a()) {
            m15135a();
            return;
        }
        throw new C4289ib("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a */
    public void m15135a() {
        if (this.f15865a != null) {
            return;
        }
        throw new C4289ib("Required field 'userId' was not present! Struct: " + toString());
    }
}
