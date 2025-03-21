package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.go */
/* loaded from: classes2.dex */
public class C4248go implements InterfaceC4277hq<C4248go, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f15703a;

    /* renamed from: a */
    public EnumC4245gl f15704a;

    /* renamed from: a */
    private BitSet f15705a = new BitSet(1);

    /* renamed from: a */
    public List<C4250gq> f15706a;

    /* renamed from: a */
    private static final C4293if f15700a = new C4293if("NormalConfig");

    /* renamed from: a */
    private static final C4284hx f15699a = new C4284hx("", (byte) 8, 1);

    /* renamed from: b */
    private static final C4284hx f15701b = new C4284hx("", C3393cw.f11873m, 2);

    /* renamed from: c */
    private static final C4284hx f15702c = new C4284hx("", (byte) 8, 3);

    /* renamed from: a */
    public int m15029a() {
        return this.f15703a;
    }

    /* renamed from: b */
    public boolean m15036b() {
        return this.f15706a != null;
    }

    /* renamed from: c */
    public boolean m15037c() {
        return this.f15704a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4248go)) {
            return m15035a((C4248go) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f15703a);
        sb.append(", ");
        sb.append("configItems:");
        List<C4250gq> list = this.f15706a;
        if (list == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(list);
        }
        if (m15037c()) {
            sb.append(", ");
            sb.append("type:");
            EnumC4245gl enumC4245gl = this.f15704a;
            if (enumC4245gl == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(enumC4245gl);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m15034a() {
        return this.f15705a.get(0);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15032a();
        abstractC4288ia.mo15610a(f15700a);
        abstractC4288ia.mo15607a(f15699a);
        abstractC4288ia.mo15605a(this.f15703a);
        abstractC4288ia.mo15616b();
        if (this.f15706a != null) {
            abstractC4288ia.mo15607a(f15701b);
            abstractC4288ia.mo15608a(new C4285hy((byte) 12, this.f15706a.size()));
            Iterator<C4250gq> it = this.f15706a.iterator();
            while (it.hasNext()) {
                it.next().mo14612b(abstractC4288ia);
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        if (this.f15704a != null && m15037c()) {
            abstractC4288ia.mo15607a(f15702c);
            abstractC4288ia.mo15605a(this.f15704a.m15016a());
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public void m15033a(boolean z) {
        this.f15705a.set(0, z);
    }

    /* renamed from: a */
    public EnumC4245gl m15031a() {
        return this.f15704a;
    }

    /* renamed from: a */
    public boolean m15035a(C4248go c4248go) {
        if (c4248go == null || this.f15703a != c4248go.f15703a) {
            return false;
        }
        boolean m15036b = m15036b();
        boolean m15036b2 = c4248go.m15036b();
        if ((m15036b || m15036b2) && !(m15036b && m15036b2 && this.f15706a.equals(c4248go.f15706a))) {
            return false;
        }
        boolean m15037c = m15037c();
        boolean m15037c2 = c4248go.m15037c();
        if (m15037c || m15037c2) {
            return m15037c && m15037c2 && this.f15704a.equals(c4248go.f15704a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4248go c4248go) {
        int m15571a;
        int m15574a;
        int m15569a;
        if (!C4248go.class.equals(c4248go.getClass())) {
            return C4248go.class.getName().compareTo(c4248go.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15034a()).compareTo(Boolean.valueOf(c4248go.m15034a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15034a() && (m15569a = C4278hr.m15569a(this.f15703a, c4248go.f15703a)) != 0) {
            return m15569a;
        }
        int compareTo2 = Boolean.valueOf(m15036b()).compareTo(Boolean.valueOf(c4248go.m15036b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15036b() && (m15574a = C4278hr.m15574a(this.f15706a, c4248go.f15706a)) != 0) {
            return m15574a;
        }
        int compareTo3 = Boolean.valueOf(m15037c()).compareTo(Boolean.valueOf(c4248go.m15037c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!m15037c() || (m15571a = C4278hr.m15571a(this.f15704a, c4248go.f15704a)) == 0) {
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
                break;
            }
            short s = mo15594a.f16333a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        C4291id.m15660a(abstractC4288ia, b2);
                    } else if (b2 == 8) {
                        this.f15704a = EnumC4245gl.m15015a(abstractC4288ia.mo15592a());
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                    }
                } else if (b2 == 15) {
                    C4285hy mo15595a = abstractC4288ia.mo15595a();
                    this.f15706a = new ArrayList(mo15595a.f16335a);
                    for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                        C4250gq c4250gq = new C4250gq();
                        c4250gq.mo14606a(abstractC4288ia);
                        this.f15706a.add(c4250gq);
                    }
                    abstractC4288ia.mo15625i();
                } else {
                    C4291id.m15660a(abstractC4288ia, b2);
                }
            } else if (b2 == 8) {
                this.f15703a = abstractC4288ia.mo15592a();
                m15033a(true);
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
        abstractC4288ia.mo15622f();
        if (m15034a()) {
            m15032a();
            return;
        }
        throw new C4289ib("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a */
    public void m15032a() {
        if (this.f15706a != null) {
            return;
        }
        throw new C4289ib("Required field 'configItems' was not present! Struct: " + toString());
    }
}
