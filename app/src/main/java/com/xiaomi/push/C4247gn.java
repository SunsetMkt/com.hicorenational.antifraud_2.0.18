package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gn */
/* loaded from: classes2.dex */
public class C4247gn implements InterfaceC4277hq<C4247gn, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f15695a;

    /* renamed from: a */
    public EnumC4241gh f15696a;

    /* renamed from: a */
    public String f15697a;

    /* renamed from: a */
    private BitSet f15698a = new BitSet(1);

    /* renamed from: a */
    private static final C4293if f15692a = new C4293if("DataCollectionItem");

    /* renamed from: a */
    private static final C4284hx f15691a = new C4284hx("", (byte) 10, 1);

    /* renamed from: b */
    private static final C4284hx f15693b = new C4284hx("", (byte) 8, 2);

    /* renamed from: c */
    private static final C4284hx f15694c = new C4284hx("", (byte) 11, 3);

    /* renamed from: a */
    public C4247gn m15019a(long j2) {
        this.f15695a = j2;
        m15024a(true);
        return this;
    }

    /* renamed from: b */
    public boolean m15027b() {
        return this.f15696a != null;
    }

    /* renamed from: c */
    public boolean m15028c() {
        return this.f15697a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4247gn)) {
            return m15026a((C4247gn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f15695a);
        sb.append(", ");
        sb.append("collectionType:");
        EnumC4241gh enumC4241gh = this.f15696a;
        if (enumC4241gh == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(enumC4241gh);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f15697a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15023a();
        abstractC4288ia.mo15610a(f15692a);
        abstractC4288ia.mo15607a(f15691a);
        abstractC4288ia.mo15606a(this.f15695a);
        abstractC4288ia.mo15616b();
        if (this.f15696a != null) {
            abstractC4288ia.mo15607a(f15693b);
            abstractC4288ia.mo15605a(this.f15696a.m14971a());
            abstractC4288ia.mo15616b();
        }
        if (this.f15697a != null) {
            abstractC4288ia.mo15607a(f15694c);
            abstractC4288ia.mo15611a(this.f15697a);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15025a() {
        return this.f15698a.get(0);
    }

    /* renamed from: a */
    public void m15024a(boolean z) {
        this.f15698a.set(0, z);
    }

    /* renamed from: a */
    public C4247gn m15020a(EnumC4241gh enumC4241gh) {
        this.f15696a = enumC4241gh;
        return this;
    }

    /* renamed from: a */
    public String m15022a() {
        return this.f15697a;
    }

    /* renamed from: a */
    public C4247gn m15021a(String str) {
        this.f15697a = str;
        return this;
    }

    /* renamed from: a */
    public boolean m15026a(C4247gn c4247gn) {
        if (c4247gn == null || this.f15695a != c4247gn.f15695a) {
            return false;
        }
        boolean m15027b = m15027b();
        boolean m15027b2 = c4247gn.m15027b();
        if ((m15027b || m15027b2) && !(m15027b && m15027b2 && this.f15696a.equals(c4247gn.f15696a))) {
            return false;
        }
        boolean m15028c = m15028c();
        boolean m15028c2 = c4247gn.m15028c();
        if (m15028c || m15028c2) {
            return m15028c && m15028c2 && this.f15697a.equals(c4247gn.f15697a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4247gn c4247gn) {
        int m15572a;
        int m15571a;
        int m15570a;
        if (!C4247gn.class.equals(c4247gn.getClass())) {
            return C4247gn.class.getName().compareTo(c4247gn.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15025a()).compareTo(Boolean.valueOf(c4247gn.m15025a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15025a() && (m15570a = C4278hr.m15570a(this.f15695a, c4247gn.f15695a)) != 0) {
            return m15570a;
        }
        int compareTo2 = Boolean.valueOf(m15027b()).compareTo(Boolean.valueOf(c4247gn.m15027b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15027b() && (m15571a = C4278hr.m15571a(this.f15696a, c4247gn.f15696a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15028c()).compareTo(Boolean.valueOf(c4247gn.m15028c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!m15028c() || (m15572a = C4278hr.m15572a(this.f15697a, c4247gn.f15697a)) == 0) {
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
                        C4291id.m15660a(abstractC4288ia, b2);
                    } else if (b2 == 11) {
                        this.f15697a = abstractC4288ia.mo15599a();
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                    }
                } else if (b2 == 8) {
                    this.f15696a = EnumC4241gh.m14970a(abstractC4288ia.mo15592a());
                } else {
                    C4291id.m15660a(abstractC4288ia, b2);
                }
            } else if (b2 == 10) {
                this.f15695a = abstractC4288ia.mo15593a();
                m15024a(true);
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
        abstractC4288ia.mo15622f();
        if (m15025a()) {
            m15023a();
            return;
        }
        throw new C4289ib("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a */
    public void m15023a() {
        if (this.f15696a != null) {
            if (this.f15697a != null) {
                return;
            }
            throw new C4289ib("Required field 'content' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'collectionType' was not present! Struct: " + toString());
    }
}
