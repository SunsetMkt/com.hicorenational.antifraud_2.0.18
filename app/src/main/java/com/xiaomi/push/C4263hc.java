package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hc */
/* loaded from: classes2.dex */
public class C4263hc implements InterfaceC4277hq<C4263hc, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C4250gq> f16009a;

    /* renamed from: a */
    private static final C4293if f16008a = new C4293if("XmPushActionCustomConfig");

    /* renamed from: a */
    private static final C4284hx f16007a = new C4284hx("", C3393cw.f11873m, 1);

    /* renamed from: a */
    public List<C4250gq> m15290a() {
        return this.f16009a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15291a();
        abstractC4288ia.mo15610a(f16008a);
        if (this.f16009a != null) {
            abstractC4288ia.mo15607a(f16007a);
            abstractC4288ia.mo15608a(new C4285hy((byte) 12, this.f16009a.size()));
            Iterator<C4250gq> it = this.f16009a.iterator();
            while (it.hasNext()) {
                it.next().mo14612b(abstractC4288ia);
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4263hc)) {
            return m15293a((C4263hc) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<C4250gq> list = this.f16009a;
        if (list == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m15292a() {
        return this.f16009a != null;
    }

    /* renamed from: a */
    public boolean m15293a(C4263hc c4263hc) {
        if (c4263hc == null) {
            return false;
        }
        boolean m15292a = m15292a();
        boolean m15292a2 = c4263hc.m15292a();
        if (m15292a || m15292a2) {
            return m15292a && m15292a2 && this.f16009a.equals(c4263hc.f16009a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4263hc c4263hc) {
        int m15574a;
        if (!C4263hc.class.equals(c4263hc.getClass())) {
            return C4263hc.class.getName().compareTo(c4263hc.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15292a()).compareTo(Boolean.valueOf(c4263hc.m15292a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m15292a() || (m15574a = C4278hr.m15574a(this.f16009a, c4263hc.f16009a)) == 0) {
            return 0;
        }
        return m15574a;
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
                m15291a();
                return;
            }
            if (mo15594a.f16333a != 1) {
                C4291id.m15660a(abstractC4288ia, b2);
            } else if (b2 == 15) {
                C4285hy mo15595a = abstractC4288ia.mo15595a();
                this.f16009a = new ArrayList(mo15595a.f16335a);
                for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                    C4250gq c4250gq = new C4250gq();
                    c4250gq.mo14606a(abstractC4288ia);
                    this.f16009a.add(c4250gq);
                }
                abstractC4288ia.mo15625i();
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15291a() {
        if (this.f16009a != null) {
            return;
        }
        throw new C4289ib("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
