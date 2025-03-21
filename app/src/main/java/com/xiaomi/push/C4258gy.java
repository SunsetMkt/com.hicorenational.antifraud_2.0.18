package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gy */
/* loaded from: classes2.dex */
public class C4258gy implements InterfaceC4277hq<C4258gy, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C4247gn> f15943a;

    /* renamed from: a */
    private static final C4293if f15942a = new C4293if("XmPushActionCollectData");

    /* renamed from: a */
    private static final C4284hx f15941a = new C4284hx("", C3393cw.f11873m, 1);

    /* renamed from: a */
    public C4258gy m15213a(List<C4247gn> list) {
        this.f15943a = list;
        return this;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15214a();
        abstractC4288ia.mo15610a(f15942a);
        if (this.f15943a != null) {
            abstractC4288ia.mo15607a(f15941a);
            abstractC4288ia.mo15608a(new C4285hy((byte) 12, this.f15943a.size()));
            Iterator<C4247gn> it = this.f15943a.iterator();
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
        if (obj != null && (obj instanceof C4258gy)) {
            return m15216a((C4258gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<C4247gn> list = this.f15943a;
        if (list == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m15215a() {
        return this.f15943a != null;
    }

    /* renamed from: a */
    public boolean m15216a(C4258gy c4258gy) {
        if (c4258gy == null) {
            return false;
        }
        boolean m15215a = m15215a();
        boolean m15215a2 = c4258gy.m15215a();
        if (m15215a || m15215a2) {
            return m15215a && m15215a2 && this.f15943a.equals(c4258gy.f15943a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4258gy c4258gy) {
        int m15574a;
        if (!C4258gy.class.equals(c4258gy.getClass())) {
            return C4258gy.class.getName().compareTo(c4258gy.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15215a()).compareTo(Boolean.valueOf(c4258gy.m15215a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m15215a() || (m15574a = C4278hr.m15574a(this.f15943a, c4258gy.f15943a)) == 0) {
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
                m15214a();
                return;
            }
            if (mo15594a.f16333a != 1) {
                C4291id.m15660a(abstractC4288ia, b2);
            } else if (b2 == 15) {
                C4285hy mo15595a = abstractC4288ia.mo15595a();
                this.f15943a = new ArrayList(mo15595a.f16335a);
                for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                    C4247gn c4247gn = new C4247gn();
                    c4247gn.mo14606a(abstractC4288ia);
                    this.f15943a.add(c4247gn);
                }
                abstractC4288ia.mo15625i();
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15214a() {
        if (this.f15943a != null) {
            return;
        }
        throw new C4289ib("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
