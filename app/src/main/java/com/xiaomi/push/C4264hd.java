package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hd */
/* loaded from: classes2.dex */
public class C4264hd implements InterfaceC4277hq<C4264hd, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C4248go> f16012a;

    /* renamed from: a */
    private static final C4293if f16011a = new C4293if("XmPushActionNormalConfig");

    /* renamed from: a */
    private static final C4284hx f16010a = new C4284hx("", C3393cw.f11873m, 1);

    /* renamed from: a */
    public List<C4248go> m15295a() {
        return this.f16012a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15296a();
        abstractC4288ia.mo15610a(f16011a);
        if (this.f16012a != null) {
            abstractC4288ia.mo15607a(f16010a);
            abstractC4288ia.mo15608a(new C4285hy((byte) 12, this.f16012a.size()));
            Iterator<C4248go> it = this.f16012a.iterator();
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
        if (obj != null && (obj instanceof C4264hd)) {
            return m15298a((C4264hd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<C4248go> list = this.f16012a;
        if (list == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m15297a() {
        return this.f16012a != null;
    }

    /* renamed from: a */
    public boolean m15298a(C4264hd c4264hd) {
        if (c4264hd == null) {
            return false;
        }
        boolean m15297a = m15297a();
        boolean m15297a2 = c4264hd.m15297a();
        if (m15297a || m15297a2) {
            return m15297a && m15297a2 && this.f16012a.equals(c4264hd.f16012a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4264hd c4264hd) {
        int m15574a;
        if (!C4264hd.class.equals(c4264hd.getClass())) {
            return C4264hd.class.getName().compareTo(c4264hd.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15297a()).compareTo(Boolean.valueOf(c4264hd.m15297a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m15297a() || (m15574a = C4278hr.m15574a(this.f16012a, c4264hd.f16012a)) == 0) {
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
                m15296a();
                return;
            }
            if (mo15594a.f16333a != 1) {
                C4291id.m15660a(abstractC4288ia, b2);
            } else if (b2 == 15) {
                C4285hy mo15595a = abstractC4288ia.mo15595a();
                this.f16012a = new ArrayList(mo15595a.f16335a);
                for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                    C4248go c4248go = new C4248go();
                    c4248go.mo14606a(abstractC4288ia);
                    this.f16012a.add(c4248go);
                }
                abstractC4288ia.mo15625i();
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15296a() {
        if (this.f16012a != null) {
            return;
        }
        throw new C4289ib("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
